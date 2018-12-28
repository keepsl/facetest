package com.sensetime.senseid.facepro.jniwrapper.library;

import java.util.ArrayList;
import java.util.List;

public class BinocularResult {
	private int mResult;
	  private List<DetectResult> rgbResults;
	  private List<DetectResult> infraredResults;
	  
	  public List<DetectResult> getRgbResults()
	  {
	    return this.rgbResults;
	  }
	  
	  public List<DetectResult> getInfraredResults()
	  {
	    return this.infraredResults;
	  }
	  
	  public BinocularResult copy()
	  {
	    BinocularResult result = new BinocularResult();
	    result.rgbResults = new ArrayList(this.rgbResults);
	    result.infraredResults = new ArrayList(this.infraredResults);
	    return result;
	  }
	  
	  public void clear()
	  {
	    if (this.rgbResults != null)
	    {
	      this.rgbResults.clear();
	      this.rgbResults = null;
	    }
	    if (this.infraredResults != null)
	    {
	      this.infraredResults.clear();
	      this.infraredResults = null;
	    }
	  }
	  
	  public int getResult()
	  {
	    return this.mResult;
	  }
	  
	  public String toString()
	  {
	    StringBuilder builder = new StringBuilder(getClass().getName());
	    builder.append("[");
	    
	    builder.append("result: ");
	    builder.append(this.mResult);
	    builder.append(", ");
	    if ((this.rgbResults != null) && (!this.rgbResults.isEmpty()))
	    {
	      builder.append("rgbResults:[");
	      for (DetectResult result : this.rgbResults)
	      {
	        builder.append(result);
	        builder.append(";");
	      }
	      builder.append("]");
	    }
	    if ((this.infraredResults != null) && (!this.infraredResults.isEmpty()))
	    {
	      builder.append("infraredResults:[");
	      for (DetectResult result : this.infraredResults)
	      {
	        builder.append(result);
	        builder.append(";");
	      }
	      builder.append("]");
	    }
	    builder.append("]");
	    return builder.toString();
	  }
}
