package com.huawei.hms.flutter.analytics;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;

public class AnalyticsPlugin implements FlutterPlugin {
    private HMSAnalyticsMethodCallHandler analyticsMethodCallHandler;
    private MethodChannel channel;

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        onAttachedToEngine(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
            this.channel = null;
        }
        this.analyticsMethodCallHandler = null;
    }

    private void onAttachedToEngine(Context context, BinaryMessenger binaryMessenger) {
        WeakReference weakReference = new WeakReference(context);
        this.channel = new MethodChannel(binaryMessenger, BuildConfig.LIBRARY_PACKAGE_NAME);
        HMSAnalyticsMethodCallHandler hMSAnalyticsMethodCallHandler = new HMSAnalyticsMethodCallHandler(weakReference);
        this.analyticsMethodCallHandler = hMSAnalyticsMethodCallHandler;
        this.channel.setMethodCallHandler(hMSAnalyticsMethodCallHandler);
    }
}
