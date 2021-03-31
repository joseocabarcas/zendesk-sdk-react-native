package com.joseocabarcas.rnzendesksdk;

import android.content.Context;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

public class RNZendeskSDK extends ReactContextBaseJavaModule {
    private ReactContext appContext;
    private static final String TAG = "ZendeskSDK";

    public RNZendeskSDK(ReactApplicationContext reactContext) {
        super(reactContext);
        appContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNZendeskSDK";
    }

    @ReactMethod
    public void init(ReadableMap options) {
        String appId = options.getString("appId");
        String clientId = options.getString("clientId");
        String url = options.getString("url");
        String key = options.getString("key");
        Context context = appContext;
        Log.d(TAG, appId);
        Log.d(TAG, url);
    }
}