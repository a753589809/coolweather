package com.example.lianyin.weather.util;

import android.text.TextUtils;

import com.example.lianyin.weather.db.City;
import com.example.lianyin.weather.db.County;
import com.example.lianyin.weather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lianyin on 2017/10/12.
 */

public class Utility {

    public static boolean handleProvinceResponse(String response) {

        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvince = new JSONArray(response);
                for (int i=0; i<allProvince.length(); i++) {
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.setProvinceName(provinceObject.getString("name"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityResponse(String response, int provinceId) {

        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i=0; i<allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountyResponse(String response, int cityId) {

        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray countyProvince = new JSONArray(response);
                for (int i=0; i<countyProvince.length(); i++) {
                    JSONObject countyObject = countyProvince.getJSONObject(i);
                    County county = new County();
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCountyName(countyObject.getString("name"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
