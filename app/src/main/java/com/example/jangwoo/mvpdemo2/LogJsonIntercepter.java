package com.example.jangwoo.mvpdemo2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LogJsonIntercepter implements Interceptor {
    private static final String TAG = "LogJsonIntercepter";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        String rawJson = response.body().string();

        try {
            Object object = new JSONTokener(rawJson).nextValue();
            String jsonLog = object instanceof JSONObject
                    ?((JSONObject) object).toString(4)
                    :((JSONArray) object).toString(4);
            Log.d(TAG, "intercept: " + jsonLog);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return response.newBuilder()
                .body(ResponseBody.create(response.body().contentType(),rawJson)).build();
    }
}
