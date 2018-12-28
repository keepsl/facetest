package com.sensetime.senseid.facepro.jniwrapper.library;

import java.util.List;

public class DetectResults {
	private int mResultCode;
	  private List<DetectResult> mDetectResults;
	  
	  public int getResultCode()
	  {
	    return this.mResultCode;
	  }
	  
	  public List<DetectResult> getDetectResults()
	  {
	    return this.mDetectResults;
	  }
}
