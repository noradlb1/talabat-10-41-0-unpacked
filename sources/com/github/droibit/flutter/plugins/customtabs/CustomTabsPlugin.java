package com.github.droibit.flutter.plugins.customtabs;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.droibit.android.customtabs.launcher.CustomTabsLauncher;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;

public class CustomTabsPlugin implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler {
    private static final String CODE_LAUNCH_ERROR = "LAUNCH_ERROR";
    private static final String KEY_OPTION = "customTabsOption";
    private static final String KEY_URL = "url";
    @Nullable
    private Activity activity;
    @Nullable
    private MethodChannel channel;

    private void launch(@NonNull Map<String, Object> map, @NonNull MethodChannel.Result result) {
        Activity activity2 = this.activity;
        if (activity2 == null) {
            result.error(CODE_LAUNCH_ERROR, "Launching a CustomTabs requires a foreground activity.", (Object) null);
            return;
        }
        CustomTabsFactory customTabsFactory = new CustomTabsFactory(activity2);
        try {
            Map map2 = (Map) map.get(KEY_OPTION);
            CustomTabsLauncher.launch(activity2, customTabsFactory.b(map2), Uri.parse(map.get("url").toString()), customTabsFactory.a(map2));
            result.success((Object) null);
        } catch (ActivityNotFoundException e11) {
            result.error(CODE_LAUNCH_ERROR, e11.getMessage(), (Object) null);
        }
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        this.activity = activityPluginBinding.getActivity();
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "plugins.flutter.droibit.github.io/custom_tabs");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromActivity() {
        this.activity = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
    }

    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if ("launch".equals(methodCall.method)) {
            launch((Map) methodCall.arguments, result);
        } else {
            result.notImplemented();
        }
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
