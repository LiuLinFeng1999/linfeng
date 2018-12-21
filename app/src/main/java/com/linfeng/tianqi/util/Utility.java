package com.linfeng.tianqi.util;
import android.text.*;
import org.json.*;
import com.linfeng.tianqi.db.*;
import com.google.gson.*;
import com.linfeng.tianqi.gson.*;

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
	/**
     * 将返回的JSON数据解析成Weather实体类
     * @param response
     * @return
     */
    /**
     * 传入json数据,返回实例化后的Weather对象
     *
     * @param response 传入的json数据
     * @return 实例化后的Weather对象
     */
	public static Weather handleWeatherResponse(String response) {
        try {

            // 将整个json实例化保存在jsonObject中
            JSONObject jsonObject = new JSONObject(response);
			/* // 从jsonObject中取出键为"HeWeather6"的数据,并保存在数组中
			 JSONArray jsonArray = jsonObject.getJSONArray("HeWeather6");
			 // 取出数组中的第一项,并以字符串形式保存
			 String weatherContent = jsonArray.getJSONObject(0).toString();
			 // 返回通过Gson解析后的Weather对象*/
            Gson g=new Gson();
            Weather weather=  g.fromJson(jsonObject.toString(),Weather.class);

			return weather;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
	public static AQI handleAQIResponse(String response) {

        try {
            // 将整个json实例化保存在jsonObject中

            JSONObject jsonObject = new JSONObject(response);
			/* // 从jsonObject中取出键为"HeWeather6"的数据,并保存在数组中
			 JSONArray jsonArray = jsonObject.getJSONArray("HeWeather6");
			 // 取出数组中的第一项,并以字符串形式保存
			 String weatherContent = jsonArray.getJSONObject(0).toString();
			 // 返回通过Gson解析后的Weather对象*/
            Gson g=new Gson();
            AQI aqi=  g.fromJson(jsonObject.toString(),AQI.class);

            return aqi;

        } catch (Exception e) {
            e.printStackTrace();


        }
        return null;

    }
}
