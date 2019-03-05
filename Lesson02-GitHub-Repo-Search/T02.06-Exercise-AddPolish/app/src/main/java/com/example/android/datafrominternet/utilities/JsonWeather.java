package com.example.android.datafrominternet.utilities;

import android.util.Log;

import org.json.JSONObject;

public class JsonWeather {
    private static String json = "{   \"temp\": {      \"min\":\"11.34\",      \"max\":\"19.01\"   },   \"weather\": {      \"id\":\"801\",      \"condition\":\"Clouds\",      \"description\":\"few clouds\"   },   \"pressure\":\"1023.51\",   \"humidity\":\"87\"}     }";
    public static void setSting(){
//        String json = "{   \"temp\": {      \"min\":\"11.34\",      \"max\":\"19.01\"   },   \"weather\": {      \"id\":\"801\",      \"condition\":\"Clouds\",      \"description\":\"few clouds\"   },   \"pressure\":\"1023.51\",   \"humidity\":\"87\"}     }";
       System.out.println(json);
    }
    public static String getCondition(String jsonString)
    {
        String condition = new String();
        try {
            JSONObject obj = new JSONObject(jsonString);
            JSONObject weather = obj.getJSONObject("weather");
            condition = weather.getString("condition");
        }catch (Exception e)
        {
            Log.e("Exception", e.getMessage());
        }
        return  condition;
    }

}
