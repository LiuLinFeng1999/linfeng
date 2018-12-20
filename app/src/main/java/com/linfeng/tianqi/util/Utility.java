package com.linfeng.tianqi.util;
import android.text.*;
import org.json.*;
import com.linfeng.tianqi.db.*;

public class Utility
{
	/*解析和处理服务器返回的省级数据*/
	public static boolean handleProvinceResponse(String response){
		if(!TextUtils.isEmpty(response)){
			try{
				JSONArray allProvinces= new JSONArray(response);
				for(int i=0;i<allProvinces.length();i++){
					JSONObject provinceObject= allProvinces.getJSONObject(i);
					Province province = new Province();
					province.setProvinceName(provinceObject.getString("name"));
					province.setProvinceCode(provinceObject.getInt("id"));
					province.save();
				}
				return true;
			}catch(JSONException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	/*解析和处理服务器返回的市级数据*/
	public static boolean handleCityResponse(String response,int provinceId){
		if(!TextUtils.isEmpty(response)){
			try{
				JSONArray allProvinces= new JSONArray(response);
				for(int i=0;i<allProvinces.length();i++){
					JSONObject provinceObject= allProvinces.getJSONObject(i);
					City province = new City();
					province.setCityName(provinceObject.getString("name"));
					province.setCityCode(provinceObject.getInt("id"));
					province.setProvinceId(provinceId);
					province.save();
				}
				return true;
			}catch(JSONException e){
				e.printStackTrace();
				}
		}
		return false;
	}
	/*解析和处理服务器返回的县级数据*/
	public static boolean handleCountyResponse(String response,int cityId){
		if(!TextUtils.isEmpty(response)){
			try{
				JSONArray allContents= new JSONArray(response);
				for(int i=0;i<allContents.length();i++){
					JSONObject countObject= allContents.getJSONObject(i);
					County Count= new County();
					Count.setCountyName(countObject.getString("name"));
					Count.setWeatherId(countObject.getString("weather_id"));
					Count.setCityId(cityId);
					Count.save();
				}
				return true;
			}catch(JSONException e){
				e.printStackTrace();
			}
		}
		return false;
	}
}
