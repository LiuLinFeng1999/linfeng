package com.linfeng.tianqi.db;
import org.litepal.crud.*;

public class County extends DataSupport
{
	private int id;
	private String countyName;
	private String weatherId;
	private int cityId;

	public void setCityId(int cityId)
	{
		this.cityId = cityId;
	}

	public int getCityId()
	{
		return cityId;
	}

	public void setWeatherId(String weatherId)
	{
		this.weatherId = weatherId;
	}

	public String getWeatherId()
	{
		return weatherId;
	}

	public void setCountyName(String countyName)
	{
	this.countyName = countyName;
	}

	public String getCountyName()
	{
	return countyName;
	}
	


	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}
