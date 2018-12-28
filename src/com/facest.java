package com;

import com.sensetime.senseid.facepro.jniwrapper.library.*;

public class facest {
	public static void main(String[] args) {
				
		prepareLicense();
	
	}
	
	public static void prepareLicense(){
		
		FaceLibrary library = new FaceLibrary();
		String licenseStr = "############################################################"+
			    "# SenseTime License"+
			    "# License Product: senseid_facepro" +
			    "# Expiration: 20180922~20190108" +
			    "# License SN: 2419a93f-277f-4d4d-a5f6-2411a26fd852" +
			    "############################################################" +
			    "sGfdd2LUQuRLWz2cLLWuXC7A/gy/dEjX/YNbkp8+nMtPwOyzpM+P3wP4cWJ/" +
			    "kaPl1nJTShjiB1vLxTg2hTEuj/vCNeRRqYzW2fchtsn7olVrjQpQgEWjOh0L" +
			    "e2/FfuusGHlm9Pjis42khH7fJHhqGu8K/qvCVUg01PhZaIO9i6bdXtr4AQAA" +
			    "AAEAAAAQcEgl69AtwPQjP7Fhbn0cvwt/wgQ5Atdsu95WqMIpvS1DkwlbguM7" +
			    "upr0cyCMXwsmPTBUs8YmPTJblLUE9Sh7ABkygsUAFZ6rYowXqAneqGbqeD+a" +
			    "DI+iRO2+Xthxak9TkbfH1zpZ0hs0b6wPib8UUYEdeIdst6N6JD+qKkYaOuMf" +
			    "/HlCtD4Zstx62EL+2yBh9ZX6VnvskX6tZvYfH+mYpTrnDpE1++xQAnhjvD0F" +
			    "oSO8JV8Hktuk370WkgMeqWbvRSBTWfIqFvL1Kl3hAKgIOxKCkodtgVB8xotv" +
			    "9lEG8lxoo/VAZ4jcGvrX6ju6ahRpiWGAkhfVcT/OwNBK7dsZAQABAAAAAAAD" +
			    "AAAAAAAAAAAAAABQHp1idCKjccGx1Beh1rZ3E6g6gdMz6ASyNHmwZvc7HjIQ" +
			    "eTD0gxlCj4OBER73ahyoSLJ1coTXwl9o7jCPcBu5VxT9qPwqhcYMAX5rsZ0I" +
			    "WRYH7Ol3cUDoWuPWLn7m30GyH+4wrgag8vcpM+6zrstwInxO5C3lr0FPC71P" +
			    "LmgT5Nsef4tKtUu16vtqw4KQ4SRMF3x//0czuSGNY9WrLQ5WokUNhmMyTDxc" +
			    "miy7zv2ZbEydsiK20PI3XJRzd+3clOPDu9C1FrxIp4xGBlrjo0BKdvGqv8Nj" +
			    "uiS8liRFBNI3OSnATVAyO6P1x40ShE4TUITMpwHphOQG8JZIjYmyFo3uxHIQ" +
			    "6zNuLS0E+noMu/8UP8/O/D1kDmX6vRGYmdkpw/p6y/UhYS201TUWLh+YJ4qH" +
			    "jrgLlmBBm2aNutc5l/4rWqGtNQrr2ZubpsbrrKlhGUnkWTHZ75NQo/6Vpv/V" +
			    "F5RaD/TeEE0I7oc0k8ky3Le3XNsr2hwtx6/XLXYFB7XG"                 +
			    "------------------------------------------------------------" +
			    "sGfddzaGm/M/xt9QWgP3Ed+eIfz92xU0AqaW2Y35OFaorJazP7wfbRL3DChs" +
			    "0Ojlz0U5VuwZfW28+Z2V1WvYwf9hSXL27LgKBw/hRkZJRowEeiDoLzP4FTd/" +
			    "Du+imS75TgBYoYPaU/BHTWweR1W2fdld3YASx7b0jqG7XOuKsN8N+AeOAQAA" +
			    "AAIAAABpsFOBp9aW2fhJrpdQkczG8hoasZQ7xfRmjZ6mQm0d4+ZXZrXD2pav" +
			    "GfpyQgmQNN25LufUE2kbRogIsnmS69IUcLZJp19rpwKOk3q2Ah5eK3N0u8iE" +
			    "7HvAAOxpfS8vwk1QJR6OvlhwluziCouI96yLSeRrTDEUEA6FW5jw6FH3TpT7" +
			    "/FxxwgXdjN82cunruAtnNxearL0IZ3CzV3433cPPFkPRIhRqr2xee56I0yoj" +
			    "NyrE/BSHphykqxTf63cplv0+Z1Hs91JKzJud2ux2LJYrpPJsYUww2JQr2dTE" +
			    "LPYw2IbZrZtkAks00JEkNIRDWCX/2t41ityly7ZkA0Kie0BtAQABAAAAAAAD" +
			    "AAAAAAAAAAAAAACiEWPQM7hh+/v4QEoR3ItUjtFNnBdOjCFZNwxCUqTZih4A" +
			    "LVO8f3/U7JAR31vadODuJL0/3YQ1KYvg/+Qw2ajqUWt9ILVwJb6ecgIdg/ys" +
			    "Jc0zn3k5BcVPf74k86f6l1L1sdJl9DCJ782V9FP+6w/93Zqyuyn+a6twQlHz" +
			    "ZnYQQo5bLM1Jb9qrDTk9Hz27ztFS+6RyaJ2YDI35inYZRsEUZiE/xjg1sx1I" +
			    "cX4xRZOCSMA2nUqNHJyzQNsXQpo25RPlkFAfIaywZzGunMAwoem9JlssWG+e" +
			    "P6OZ9RJ+clcZuP0ZVjQbB+2paV2X+zJBa7Gio7l3xiFdqVdaUirUMPt2GYpa" +
			    "2AZkZEDFUT56/MN9WVaOWCUsaWIvCwJWGOecVFa2f9LrOdchosnzxxjqTwLa" +
			    "q0uXr0JbPP2CAJ5b66fEL/X6vIjY68n06Sun/zwC6CSyTjrIcx3juQJy+9Q0" +
			    "bmAAl7tLBnj0REfr4JTbfO55Mdkxn86rQ/qBy9LcyW+sYyATCHsTDrN1LRke" +
			    "eCcyg4oAr3CEHJL+XC4K/Sces2lN0UGx7s0ePrKRc0cc5/ToBMINLwgNQQNv" +
			    "foh+samAxaypsa3kwLVHuhy2mzuTjHzmiy9RWGGhBTq7vt2YYRtibFf3Bn5r" +
			    "3gCfz8xFjhK5IcQAVA=="                                         +
			    "############################################################" ;
		StringResult activationCode = library.getActivationCode(licenseStr);
		
		if(activationCode!=null){
			int result = library.activite(activationCode.getString());
			System.out.println("系统授权验证成功01");
		}
	}
}
