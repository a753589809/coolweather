package com.example.lianyin.weather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lianyin on 2017/10/12.
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }

}
