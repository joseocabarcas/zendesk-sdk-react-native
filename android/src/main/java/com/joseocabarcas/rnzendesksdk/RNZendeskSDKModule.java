package com.joseocabarcas.rnzendesksdk;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import zendesk.messaging.android.FailureCallback;
import zendesk.messaging.android.Messaging;
import zendesk.messaging.android.MessagingError;
import zendesk.messaging.android.SuccessCallback;

public class RNZendeskSDKModule extends ReactContextBaseJavaModule {
    private ReactContext appContext;
    private static final String TAG = "[RNZendeskSDKModule]";

    public RNZendeskSDKModule(ReactApplicationContext reactContext) {
        super(reactContext);
        appContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNZendeskSDKModule";
    }

    @ReactMethod
    public void init(ReadableMap options, Promise promise) {
        try {
            String key = options.getString("key");
            Context context = appContext;
            Messaging.initialize(
                    context,
                    key,
                    new SuccessCallback<Messaging>() {
                        @Override
                        public void onSuccess(Messaging value) {
                            Log.i("IntegrationApplication", "Initialization successful");
                            promise.resolve(null);
                        }
                    },
                    new FailureCallback<MessagingError>() {
                        @Override
                        public void onFailure(@Nullable MessagingError cause) {
                            Log.e("IntegrationApplication", "Messaging failed to initialize", cause);
                            promise.reject("Messaging failed to initialize", cause.getMessage());
                        }
                    });
            Log.d(TAG, key);
        } catch (Exception e) {
            promise.reject("Exception Error", e.getMessage());
        }
    }

    @ReactMethod
    public void showMessaging() {
        Context context = appContext;
        Messaging.instance().showMessaging(context);
    }
}