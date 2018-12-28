package com.sensetime.senseid.facepro.jniwrapper.library;

import java.util.Locale;

public class SearchResult {

	  private int[] topIdxs;
	  private float[] topScores;
	  private int resultLength;
	  private int mResult;
	  
	  public int[] getTopIdxs()
	  {
	    return this.topIdxs;
	  }
	  
	  public float[] getTopScores()
	  {
	    return this.topScores;
	  }
	  
	  public int getResultLength()
	  {
	    return this.resultLength;
	  }
	  
	  public int getResult()
	  {
	    return this.mResult;
	  }
	  
	  public String toString()
	  {
	    StringBuilder builder = new StringBuilder(getClass().getName());
	    builder.append("[");
	    
	    builder.append("topIdxs: [");
	    if ((this.topIdxs != null) && (this.topIdxs.length > 0)) {
	      for (int idx : this.topIdxs)
	      {
	        builder.append(idx);
	        builder.append(";");
	      }
	    }
	    builder.append("]");
	    
	    builder.append("topScores: [");
	    if ((this.topScores != null) && (this.topScores.length > 0)) {
	      for (float score : this.topScores)
	      {
	        builder.append(String.format(Locale.getDefault(), "%.6f", new Object[] { Float.valueOf(score) }));
	        builder.append(";");
	      }
	    }
	    builder.append("]");
	    
	    builder.append(", resultLength: ");
	    builder.append(this.resultLength);
	    
	    builder.append(", result: ");
	    builder.append(this.mResult);
	    
	    builder.append("]");
	    
	    return builder.toString();
	  }
}
