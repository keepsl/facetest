package com;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.util.EntityUtils;
import javax.activation.MimetypesFileTypeMap;

public class Http_Requests {

	private static CloseableHttpClient httpclient = HttpClients.createDefault();
	// 设定请求超时的时间
	private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(300000)
			.setConnectionRequestTimeout(300000).build();

	public static void main(String[] args) {
		int threadNum = 10;
		/*
		 * String groupCount = groupQuery("test002");
		 * System.out.print(groupCount);
		 */

		// 1查询系统中所有的分组名称
		// String groupList = groupList();
		// System.out.print(groupList);

		// 2查询分组 test01 中的所有人员face信息
		// String queryString = groupQuery("test01");
		// System.out.print(queryString);

		// 3创建分组 test04
		// String createString = groupCreate("test04");
		// System.out.print(createString);

		// 4删除分组 test04
		// String deleteString = groupDelete("test04");
		// System.out.print(deleteString);

		// 5添加目录下的所有照片到底库，并绑定这些人脸到分组 test01
		faceAddFolderAndBind("E:\\电子班牌多媒体资源\\001\\", "test02");

		/*
		 * for (int i = 0; i < threadNum; i++) { new Thread() { public void
		 * run() { try { long time = System.currentTimeMillis(); String data =
		 * serviceRec("d:\\face1\\001.jpg");
		 * System.out.println(System.currentTimeMillis() - time);
		 * System.out.println(data); } catch (FileNotFoundException e) {
		 * e.printStackTrace(); } } }.start(); }
		 */

	}

	// 使用JSON对服务端进行POST请求
	private static String postRequestJson(String uri, String requestData) throws IOException {

		// 这两个变量是必须定义在try catch之前的，否则作用域是不对的
		HttpEntity entity = null;
		String responseData = null;

		// 使用http post方法请求
		try {
			HttpPost httppost = new HttpPost(uri);
			httppost.setConfig(requestConfig);

			// 封装请求内容,经测试不添加header也是可以的，那么内容就会被看做Text
			httppost.addHeader("Content-type", "application/json; charset = UTF-8");
			StringEntity strEntity = new StringEntity(requestData, "UTF-8");
			httppost.setEntity(strEntity);

			// 设置请求内容
			HttpResponse response = null;
			entity = null;
			responseData = null;

			// 发送请求
			response = httpclient.execute(httppost);

			// 获取应答数据
			entity = response.getEntity();
			InputStream is = entity.getContent();
			Header encodingHeader = entity.getContentEncoding();
			Charset contentEncoding = encodingHeader == null ? Consts.UTF_8
					: Charset.forName(encodingHeader.getValue());
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, contentEncoding));
			responseData = IOUtils.toString(reader);

		} finally {
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseData;
	}

	public static String getRequestJson(String uri) throws IOException {
		HttpEntity entity = null;
		String responseData = null;

		HttpGet httpget = new HttpGet(uri);
		httpget.setConfig(requestConfig);

		HttpResponse response = null;
		try {
			response = httpclient.execute(httpget);
			entity = response.getEntity();
			InputStream is = entity.getContent();
			Header encodingHeader = entity.getContentEncoding();
			Charset contentEncoding = encodingHeader == null ? Consts.UTF_8
					: Charset.forName(encodingHeader.getValue());
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, contentEncoding));
			responseData = IOUtils.toString(reader);
		} finally {
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseData;
	}

	// 使用form表单进行POST请求，添加filePath指向的人脸
	public static String faceAdd(String filePath) throws FileNotFoundException {

		String uri = "http://192.168.60.71:8080/api/face/v1/add";
		File image = new File(filePath);
		if (image == null || !image.exists()) {
			throw new FileNotFoundException();
		}
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
		// multipartEntityBuilder.setCharset(Consts.UTF_8);
		multipartEntityBuilder.addBinaryBody("image", image);

		HttpPost httpPost = new HttpPost(uri);
		httpPost.setEntity(multipartEntityBuilder.build());
		// httpPost.setHeader("Content-type",
		// ContentType.MULTIPART_FORM_DATA.toString());
		try {
			HttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity);
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 使用form表单进行POST请求，添加File指向的人脸
	public static String faceAdd(File image) throws FileNotFoundException {

		String uri = "http://192.168.60.71:8080/api/face/v1/add";
		if (image == null || !image.exists()) {
			throw new FileNotFoundException();
		}
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
		// multipartEntityBuilder.setCharset(Consts.UTF_8);
		multipartEntityBuilder.addBinaryBody("image", image);

		HttpPost httpPost = new HttpPost(uri);
		httpPost.setEntity(multipartEntityBuilder.build());
		// httpPost.setHeader("Content-type",
		// ContentType.MULTIPART_FORM_DATA.toString());
		try {
			HttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity);
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 使用form表单添加文件夹下所有的人脸
	public static void faceAddFolder(String folderDir) {
		File file = new File(folderDir);
		File[] files = file.listFiles();
		if (files == null) {
			return;
		}
		for (File f : files) {
			if (f.isFile() && isImage(f)) {
				try {
					System.out.println(f.getAbsolutePath());
					System.out.println(faceAdd(f));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else if (f.isDirectory()) {
				faceAddFolder(f.getAbsolutePath());
			}
		}
	}

	// 使用form表单添加folderDir下所有的人脸，并和指定group_name的group绑定
	public static void faceAddFolderAndBind(String folderDir, String group_name) {

		String bindUri = "http://192.168.60.71:8080/api/group/v1/bind";
		File file = new File(folderDir);
		File[] files = file.listFiles();
		if (files == null) {
			return;
		}
		String errImage="";
		int totle =files.length;
		int current =0;
		int succ=0;
		for (File f : files) {
			if (1==1) {
				try {
					current++;
					System.out.println(f.getAbsolutePath());
					String response = faceAdd(f);
					String resultcode = findResultCode(response);
					System.out.println("照片总数"+totle+"张，当前第"+current+"张，成功加入"+succ+"张；");
					if (resultcode.equals("0")) {
						String face_token = findFace_token(response);
						System.out.println(response);
						String bindRequest = "{" + "\"group_name\": " + "\"" + group_name + "\"" + ", "
								+ "\"face_token\": " + face_token + "}";
						try {
							succ++;
							System.out.println(postRequestJson(bindUri, bindRequest));
							
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else{
						errImage += "'"+f.getName()+"',";
						System.out.println("retultcode = "+resultcode+";message = "+findResultMessage(response));
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			} else if (f.isDirectory()) {
				faceAddFolder(f.getAbsolutePath());
			}
		}
		
		System.out.println("errImage = "+errImage);
	}

	// 使用form表单进行POST请求，识别给定的人脸（仅用于测试，使用的参数无法直接获得，是客户端处理过后的值）
	public static String serviceRec(String filePath) throws FileNotFoundException {

		String uri = "http://192.168.60.71:8080/api/service/recognize/v1";
		File image = new File(filePath);
		if (image == null || !image.exists()) {
			throw new FileNotFoundException();
		}
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
		// multipartEntityBuilder.setCharset(Consts.UTF_8);
		multipartEntityBuilder.addBinaryBody("image_0", image);
		multipartEntityBuilder.addTextBody("group_name", "test002");
		multipartEntityBuilder.addTextBody("face_data",
				"AAECAwQFBgcICQoLDA0OD5XQySG-BdhDMrR3_27mzrjbxHahSOT0R5QEkcw870LGUhWo5CUUjlnk2ID0CxvGocxnUKM6JFSIz81n2BMcvSGwEmw3tGBnBGDdhg4XfXVWehzNCixJw0LSkP2F-ttppkiqdPSxm_5szrfSj4vyt6NZOzr_NCi27oFB6aj7ZEhimymapwjNGUehwrz9HJn3dnf8H5FIoGMADLEsm-odRkgeSm2uDPEqJ_rVRu16mQuTOL-n_14i00sK3ltd8J3vkOrq5XWQW9V3Z_sOdrHNuO2zoqDYfxMNCIRONPC_HY2ZIJiMR848TCHbn69x9-DHQjkZcJ4h1sd5lerr6v-462R_Xy_ElS44BM4gQgCxXjLSoxdaOjmOB4Hd3dsvLheOkcZO0V-KNyauVl-WP_4HFusqav_CiCv7cp7RD5yEWlwzB0mLygOTc-R61AN79V_FtrvzM279BOpOkFO5FBfspQP7RZ-9mukUXWQUp1oKBiRd3Ff5B1smLmwS3Ch2sctazMGJHwdTLpL86bHx4zRST9FC2w9csEvJuDVKnNLixobjV0x9ZYFOKT_khQ2a2x664_v8MLLcCGL-45KGlNlkvbhO4Kbw92g6O6yetwwilm-eUcfdRH37DvQEti1CPgT9VeYE-BIKx71KF5Oo8u0uVcAm1Mq7DrtJMsPignqfrLSDIYnAhCrrPPaFgSzFairYuhywvgrW8CNiwZ7VSMnvFc_H5wctSrwU-VBuNP4sTQpeI5_U_qxqrR8IADV24SzPqwhEFBjLkr-toUNg0HVSNUkOqhiiJBqKA6qKpiPJIctg3iXpGXuq8phjC3a_e7Nke65Teu97-cFGzSMo0RHxTqr_ALfGx8EPHx0fT4KPrtGK_YJ2Bt-njobXGcU2Y6p06O5Mhv-CJ1ylEDoYY6DCPWeEolG8zmXQRIGNi-yiTfAFxwBfq7PqnFypJHSdjTBqe2Z6ZjgUKoU65fICtMLVaQbXiD-v3wApdBsfQBUg5ZOaPj5KJwm7V1MIb6LbJfOxdYydUaNSi1R9yWVRFGMar-6EZNS9PUo2_HeO5FslWetjdirnpjDm4uay9BKfBmNL9M3ZT5PlfFPhf8gmZtRKTMuob6-l9B6-S9HsmUoXh1SdDXociGBdahIwcqPW_oiQU5RYawFumBCGyJNZ3I7VUcmd6x-Tib9-Kwg2mVCSUTCGDSJd7FJoT9uQMJ16uGI4_hAQbichHpAGwx1Pqn4oSiL1cMKlHlE0JwGPW-8XQmtfLoh_6MwrwMNcfFJj2EP2lkFBs7i8slpF5d3qOrpPtDRjIvavhU88Bna2zqgO7MNf7P2HOmXGtL-abF5b42e60wTBIi0RLG_OTuiE_eXS_ILpwWp92yBdCc9h5i_AWwQ4IE-he0vnDTR5aWzgEAL8j7MfGNe37KsVN3r96fW5DdNayPt5crHeDjYN2zjlqZLXprG1t-Cl2NbLPRbjI-IyI7zgTnc2xsJJfqEC9JGzjBVIsWjtESEsz6CI_f79ZMP4RyqqRIs6UPTBeYoN5VfSXeC1rDQFL3si-L7h6xkrA4cJrmidfwuMZqN4i75BSvaOHyC5x72Cnp-7Xcfgti9k1JjE7VejqpmQtLjgNq82v2XFZi6DicrUufuLgzQCN2Ct9tA_yO6zYlUDVmnnmn2O5_5cMesvSS8fYuSA7H8EIxQaUXlS2MhBGqyBD0qDijei635xmIQo24cNkS01jYQsuynbp688rDAq3Ol3v5llsOyf730Pfpnz_mbrXeeYbuwbZQfxlrv5DA1aQJRvoOrk1xAI_GW9zHFP2Ap0MZ2T9jtavgttAeYrOcUcfBJn6A3nYL3AV1e7JgUHnom0LE519oDoM-UOgBLeyDa3Gzb9FYxGq5YiWKW4pvPPlnuF1Hjkyi9iaw8Pw395NVmlkdLeAQFH4kJlhovEOQSNJqeSSAiuF1nQhq26XiCUEwQLiQYg8YvXzgxZlsOz_ELrLI7SdNTqSMRZWru9N9esl3anbM0tyAIFMMF720SFJjd02I3yyIE8zo7adywwIrh6I1S-ec3P1r-nwblltcx0g66kJTx2XOi0LUNg2fvWRhyaUfLvgTnxJW03d8qqyU-cQ-pd7n5qLkh3TrEXFWJ2IJAqOZhPhV6jNO5Hn6ePg9IzNpa8gLaEc-y1sBOLvpzZGWW5Z4edzSW4w7V-tlph7DAXVXH9vkydZE4ECyFt-iSUatPInGuzouXXDF2kEUzX7-C-P-ZHPF2WlpUCtgr5ZGqPIHjwD7VxJmaWDciRIu9JhUxxDzds6aXxflVYRkyDa1PSxw-Mdra3hRQVvrplHmKKm6iPBdQjgN01NMYXJyi8bfQ02fFGTMRuY-SzbX3SuBfoQIGlJwTFbyZ58MgJ2n_bAk7W8IILkR0l_QnR54WaUSEAglr3zsZP0m5mr_u6fn0A0mxYHB5MRL5tHkBztZk3jPVvX_hJSZjmewK8VNI4MlSESKPNSYDPkOY8S_h0_i2EbkzwCvRf_6y6CTp0Z_B8K24Vlnsvjpsve69Ugr4FgrEjyFZWkXS3ZNbSQ_JHNOs2YKXvjOe0mb-z4S8TzUYVvWkD6iExm8mEyOegV8wCQT5WRf6MArEpzQf2QTAvQ7ItQa0syy31G-Wrt0TXohPFakBZFoAcof8DScjwEitGsdnqmdPAuniue7juuzoYY_dghEyYCpLA1p4qQLqbFMlrviCK2gd3hB4Mz3oDqzKjDu9xninmdV6a1za3C1ktHeP46TrztA5677LGV3PADLpl7OWJYSEXdMH-R-KbM2ODrrVR8xo9vQ5StBp7DcpERApvd5IJppmVGCrCnL3SxlNrTX5zKCv3cvwAeemNA3sRH2Ac3X44-nwN5ExSaUj5y0xocuQ0XnCxl2nZ1CyQqy5-kXCh6pVp3dtQVuW2n5Aq6mN_VmA2kbktncmyrDlvfThbvPXcjcGucMRrSt0RPqBSRT9d9IWD-NLoM3gFTU8RLz3nTTWH8paFmZk2C2Z6L_9g6pbTHsqaj3liEsknpvHMo7L4j2ZRjOm8Lb513r-XAEqdH_1RpGq8sd56lplSs7ymFVrXxEtb6M0ptevJBO6qaQ37HK7afGbYeLFpbzpf1Ol7uwqkfWr-8HqZe0m-Xpegy7cguVij12WczNEQ9lweurAUZ0HlI5j8LGh621fQquiCL1n7T38xB4sMBRz-pUc3sjEelQz2F50nDg95sj2d0wUPeQPVGsg72vGLGjjdJ_rnuQgxzdHVMECSorSR1YhTBx07ARw60pBcxCXe9G3R_Zw0SqQI26uBz6HqzAvtJhB3ZpgzY8kqoDGLk3FcaF1_sDUPxp94VRHzz-KzvaPjqcEnzrrui9-IdHw_bBet9Te9vqL7hQQ68WUOiB3t-Taqeu27E5otpr7GDf2B56jX3FvVeo6xrgwVIkw741YVH5a0b7iKGtOsvNJx72aQ4SUN8Se8lvxjgYb-njxOnDvNu516Gd6K6Eoo-Nxzh95UXXe9IlB3VPrzXFUg0vpc2mIGnVzveZF5t6wjOuqx_g9g2z1RraVkxJLMt7HRsCF0xqwtLrDvvHAJQNF_jpdVLgPyWmjEamnkVkBhkiUs3WpnVnL3PopjOd22To6yPqsHelMR6dI8OYYEBYFq8J7pWSwNtbsiwIpMEughG9CjKZ8GTirHUSrclSy9tv29h6JJ7O475h2uHe_e7peAyq3ovdz-xw0iKlqVryYi82FQTIOqw4yMQE1wlYtZ5kZVILbdR-ZjTVPcfd0Cg7DgsvFOD4nKwexYn4eDSHIrGNsRVyGNMuwSGX9GdbJovnTt6_JG9nJoGNYycxozPtkxqSBw4vkePEb3rohIuPb4B1caSKEPDJe5YJ3f94OU4p5pX77Nmg_jzNI0VXmC8tLWrCVfQoWYqdvGGMRdaAvPd9G12bxLJ-45OVG3flVah6CyqMJGo1ptuy2AHH9qBC4HAKEQp45Zm8eXEC4ZFtRFkcetIHLpKV2_Fq3vCMtcT18JqQgR49nD0sLWjf9VBBzKxPiZ1PDWNuIV6nCWmAuTNvhO5uy8jLn-oIORQrH0LybLDYtZic3e2X2XRx0WX0u1bOdOi-QX7GZl6jlHpKPjyZe_PNCALWMHC7UU1pYxswsu0IpI2A9dW0mdxm7_BUcuZ0hQJAOW1XZXP34ND11cj_EnZyd5WQEd_2i9sPrK-ylclshZlMDEGr3NB8GCflH9A4Hnz7JQxVnZSf5Ab7oD8lqbPVG4DRyr1mfVUvl4_FnlUfMqEhXyjM3kN8Edoe3_lQUfQ-xhfmO_1gQ803JdTIO7VyhbWsAkx4LlK6wTLFWmUafIGUGlO6Viq7XwXM2x1dR2Y7I79GrvfozyvkEmXOtuMH-zYOFDhh6WCKXuxI7nnUAJoiRJuFP6WxL5fezVL3wwsUtNU3ZQFVD_7d6ohD_OfsUyW_6s-bn69XSq8UoweNo8riwYpYqAy_KMFJ0-xDfK6zg-ftOjyEO_7nyUzvfjXixQIXS2_cV0SuYgCqV25uXcvNmCyVNvES5kfB2xTk-y6VDAw2irhunvqZyzPN5O4yLYCPZEDEryjcUJSetC1VstmfyTwqoNHOYNWMEGamMeaDkCWK891H76nvFSFFZ6FqiNjbwKyvz828maB9M91R7N7ij_-yoTr_neM_apt6izvjvf8iOtn5j_w_JSYwSQSJEbemYLuH5QiCGF0LXVw0Sf8QnH2kslAB6thVWCtlDSWXnsWXm4O8rS1ASGN71KdwtGQrmQ8TKtrRa48WhEOxojVebl7Ta8MLaSIwB-Sa-AbAcoi0qSC_sgzHv7eLYOl_ikA8I_UeExCGMhINVZz-GzLc8fgVs2_F5wjdfcy62_BXwQUDDSXUeMw4bRENORdUX66mjSBAWlfFUjBbliJ7empc97e9gQSRa6hvaVzOp4XU6rbUSwKnijT7tOJ3Uw52c0mEV5HWuFjXfxd9l9hFafRwwikBYmzh4fFBkn6ZN0q3fDaW1lsqhlCAS_G1G9tOR-0UXwdVKeEoaCbCXEaeEtxd9vVPCNgjhzLgG24NzsJpLarBY-FpvQbmUGTn5_ch2CxNGr0oHwOOTcaWMNBJEbHYgb4iiAibrBlenMyuUSJvI8Gtm5mapm3x__q6XoV2oIOQuQToDRQnqWuRny--dCEMkX45FrYcMNdWTsh1tcO8FP0wnrVrg0G8O2ZaMU7iIjS6z0wGNJNm7RfZRt4L5Hlf1cRy--z49p9xHc9j4ylXOWzaQMCJ_g_kRxrU_LuqMiTCT3P_7CaHEu6lUIm4Cqkfxlwtf8jlaBGL37qYNAiivjO709VjuvAtTXGjuGi20OZrmnJZYXJn_Ei_FTEnqsso6ZXWPu_gcZwpV_EjglUktuwVhnXErVPwm2pXxOTliyju0vc40edP9kBO5ZPyIE5SKDsOOErgkAAAv2GhzmjKTryqH5oQzI0H4l_mz5V-SQc5H2JhpoxS_Pr5Xd-ZmKO_NqKZ211ayJ1RCfPOQymLSjh71Pyyd1GhJbhLYu6c16QWOVbmyEDm4QhOfzNmHQ_JofjEr9iwGqQCbj-avZSnZQ-F49VfejyFqVoDmCAMuFbetAzzUyV_lVRUUU_yvbjs8GjMqhKO1dP6Bo4Vr7JzdnM0zE_RjR02QB2FjbbATnWa6qjptZPnKXP-rSyTDpR_8m");

		HttpPost httpPost = new HttpPost(uri);
		httpPost.setEntity(multipartEntityBuilder.build());
		// httpPost.setHeader("Content-type",
		// ContentType.MULTIPART_FORM_DATA.toString());
		try {
			HttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity);
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 删除face_token，也会自动从group中删除绑定的face_token关系
	// 注意，给定face_token时不需要加引号
	// 正确参数：dzOYYMpcoEMaXViQooTaEg== 错误参数："dzOYYMpcoEMaXViQooTaEg=="
	public static String faceDelete(String face_token) {
		String uri = "http://192.168.60.71:8080/api/face/v1/delete";
		try {
			String request = "{" + "\"face_token\":" + "\"" + face_token + "\"}";
			return postRequestJson(uri, request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 使用groupQuery的返回值来删除该group下所有的face_token
	public static void faceDeleteGroup(String group_name) {
		String response = groupQuery(group_name);
		int beginIndex = response.indexOf("==") - 22;
		int endIndex = beginIndex + 24;
		int gap = 34;
		int terminatIndex = response.indexOf("group_name");
		while (endIndex < terminatIndex) {
			String face_token = response.substring(beginIndex, endIndex);
			faceDelete(face_token);
			beginIndex += gap;
			endIndex += gap;
		}
	}

	// 查询face_token对应的人脸信息
	public static String faceQuery(String face_token) {
		String uri = "http://192.168.60.71:8080/api/face/v1/query";
		try {
			String request = "{" + "\"face_token\":" + "\"" + face_token + "\"}";
			return postRequestJson(uri, request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 创建group
	public static String groupCreate(String group_name) {
		String uri = "http://192.168.60.71:8080/api/group/v1/create";
		try {
			String request = "{" + "\"group_name\":" + "\"" + group_name + "\"}";
			return postRequestJson(uri, request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 删除group，同时也删除了group和face_token的绑定信息
	public static String groupDelete(String group_name) {
		String uri = "http://192.168.60.71:8080/api/group/v1/delete";
		try {
			String request = "{" + "\"group_name\":" + "\"" + group_name + "\"}";
			return postRequestJson(uri, request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 查询group_name对应的face信息
	public static String groupQuery(String group_name) {
		String uri = "http://192.168.60.71:8080/api/group/v1/query";
		try {
			String request = "{" + "\"group_name\":" + "\"" + group_name + "\"}";
			return postRequestJson(uri, request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 查询全部Group
	public static String groupList() {
		String uri = "http://192.168.60.71:8080/api/group/v1/list";
		try {
			return getRequestJson(uri);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 绑定一张人脸到group
	public static String faceBindGroup(String face_token, String group_name) {
		String uri = "http://192.168.60.71:8080/api/group/v1/bind";
		try {
			String request = "{" + "\"group_name\":" + "\"" + group_name + "\"" + "," + "\"face_token\":" + "\""
					+ face_token + "\"}";
			return postRequestJson(uri, request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 从group解绑一张人脸
	public static String faceUnbindGroup(String face_token, String group_name) {
		String uri = "http://192.168.60.71:8080/api/group/v1/unbind";
		try {
			String request = "{" + "\"group_name\":" + "\"" + group_name + "\"" + "," + "\"face_token\":" + "\""
					+ face_token + "\"}";
			return postRequestJson(uri, request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 从服务器的response字符串中定位face_token
	// 用于faceAddFolderBind方法，从faceAdd方法返回的reponse中定位face_token，不保证对所有response有效
	private static String findFace_token(String response) {
		int beginIndex = response.indexOf("face_token") + 13;
		int endIndex = beginIndex + 26;
		return response.substring(beginIndex, endIndex);
	}

	// 从服务器的response字符串中定位timecost
	private static String findTimecost(String response) {
		int beginIndex = response.indexOf("timecost") + 11;
		int endIndex = beginIndex + 3;
		return response.substring(beginIndex, endIndex);
	}

	// 从服务器的response字符串中定位code
	private static String findResultCode(String response) {
		int beginIndex = response.indexOf("code")+7;
		int endIndex = response.indexOf("message") - 5;
		return response.substring(beginIndex, endIndex);
	}
	
	// 从服务器的response字符串中定位code
		private static String findResultMessage(String response) {
			int beginIndex = response.indexOf("message") + 10;
			int endIndex = response.indexOf("timecost") - 5;
			return response.substring(beginIndex, endIndex);
		}

	// 判断文件是否是图片
	private static boolean isImage(File file) {
		String mimetype = new MimetypesFileTypeMap().getContentType(file);
		String type = mimetype.split("/")[0];
		if (type.equals("image")) {
			return true;
		} else {
			return false;
		}
	}

	// 将图片转化为二进制数组
	private static byte[] imageToByteArray(String imgpath) {
		BufferedInputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream(imgpath));
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int size = 0;
			byte[] temp = new byte[1024];
			while ((size = in.read(temp)) != -1) {
				out.write(temp, 0, size);
			}
			in.close();
			return out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
