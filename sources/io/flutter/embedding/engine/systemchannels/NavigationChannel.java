package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class NavigationChannel {
    private static final String TAG = "NavigationChannel";
    @NonNull
    public final MethodChannel channel;
    private final MethodChannel.MethodCallHandler defaultHandler;

    public NavigationChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 r02 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                result.success((Object) null);
            }
        };
        this.defaultHandler = r02;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/navigation", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r02);
    }

    public void popRoute() {
        Log.v(TAG, "Sending message to pop route.");
        this.channel.invokeMethod("popRoute", (Object) null);
    }

    public void pushRoute(@NonNull String str) {
        Log.v(TAG, "Sending message to push route '" + str + "'");
        this.channel.invokeMethod("pushRoute", str);
    }

    public void setInitialRoute(@NonNull String str) {
        Log.v(TAG, "Sending message to set initial route to '" + str + "'");
        this.channel.invokeMethod("setInitialRoute", str);
    }

    public void setMethodCallHandler(@Nullable MethodChannel.MethodCallHandler methodCallHandler) {
        this.channel.setMethodCallHandler(methodCallHandler);
    }
}
