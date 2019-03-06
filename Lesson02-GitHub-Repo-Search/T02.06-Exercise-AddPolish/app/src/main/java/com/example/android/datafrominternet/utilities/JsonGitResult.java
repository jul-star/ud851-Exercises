package com.example.android.datafrominternet.utilities;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;

public class JsonGitResult {

    public static int getNumber(String json){
        int res = -1;
        int index = json.indexOf("incomplete_results");
        String sub = json.substring(0, index-2);
        sub += "}";
        try {
            JSONObject obj = new JSONObject(sub);
            res = obj.getInt("total_count");
        }
        catch (JSONException e)
        {
//            Log.e("JsonGitResultGetNumber:", e.getMessage());
            e.printStackTrace();
        }
        return  res;
    }

}
