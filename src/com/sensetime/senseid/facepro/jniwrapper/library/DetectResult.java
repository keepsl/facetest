package com.sensetime.senseid.facepro.jniwrapper.library;

import java.util.List;

public class DetectResult {
	private Rect rect;
	
	  private float score;
	  private int pointsCount;
	  private float yaw;
	  private float pitch;
	  private float roll;
	  private float eyeDist;
	  private int id;
	  private List<PointF> pointsArray;
	  
	  public Rect getRect()
	  {
	    return this.rect;
	  }
	  
	  public float getScore()
	  {
	    return this.score;
	  }
	  
	  public int getPointsCount()
	  {
	    return this.pointsCount;
	  }
	  
	  public float getYaw()
	  {
	    return this.yaw;
	  }
	  
	  public float getPitch()
	  {
	    return this.pitch;
	  }
	  
	  public float getRoll()
	  {
	    return this.roll;
	  }
	  
	  public float getEyeDist()
	  {
	    return this.eyeDist;
	  }
	  
	  public int getId()
	  {
	    return this.id;
	  }
	  
	  public List<PointF> getPointsArray()
	  {
	    return this.pointsArray;
	  }
	  
	  public String toString()
	  {
	    StringBuilder builder = new StringBuilder(getClass().getName());
	    builder.append("[");
	    
	    builder.append("rect: ");
	    builder.append(this.rect);
	    
	    builder.append("score: ");
	    builder.append(this.score);
	    
	    builder.append("pointsCount: ");
	    builder.append(this.pointsCount);
	    
	    builder.append("yaw: ");
	    builder.append(this.yaw);
	    
	    builder.append("pitch: ");
	    builder.append(this.pitch);
	    
	    builder.append("roll: ");
	    builder.append(this.roll);
	    
	    builder.append("eyeDist: ");
	    builder.append(this.eyeDist);
	    
	    builder.append("id: ");
	    builder.append(this.id);
	    
	    if ((this.pointsArray != null) && (!this.pointsArray.isEmpty()))
	    {
	      builder.append("pointsArray: [");
	      for (PointF pointF : this.pointsArray)
	      {
	        builder.append(pointF);
	        builder.append(";");
	      }
	      builder.append("]");
	    }
	    builder.append("]");
	    return builder.toString();
	  }
}
