package dev.fluttercommunity.plus.share;

import android.app.Activity;
import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;

public class SharePlusPlugin implements FlutterPlugin, ActivityAware {
    private static final String CHANNEL = "dev.fluttercommunity.plus/share";
    private MethodCallHandler handler;
    private MethodChannel methodChannel;
    private Share share;

    private void setUpChannel(Context context, Activity activity, BinaryMessenger binaryMessenger) {
        this.methodChannel = new MethodChannel(binaryMessenger, CHANNEL);
        Share share2 = new Share(context, activity);
        this.share = share2;
        MethodCallHandler methodCallHandler = new MethodCallHandler(share2);
        this.handler = methodCallHandler;
        this.methodChannel.setMethodCallHandler(methodCallHandler);
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.share.a(activityPluginBinding.getActivity());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        setUpChannel(flutterPluginBinding.getApplicationContext(), (Activity) null, flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromActivity() {
        this.share.a((Activity) null);
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.methodChannel = null;
        this.share = null;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
