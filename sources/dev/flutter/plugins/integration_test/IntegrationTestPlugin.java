package dev.flutter.plugins.integration_test;

import android.app.Activity;
import android.content.Context;
import com.google.common.util.concurrent.SettableFuture;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Future;

public class IntegrationTestPlugin implements MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {
    private static final String CHANNEL = "plugins.flutter.io/integration_test";
    public static final Future<Map<String, String>> testResults;
    private static final SettableFuture<Map<String, String>> testResultsSettable;
    private Activity flutterActivity;
    private MethodChannel methodChannel;

    static {
        SettableFuture<Map<String, String>> create = SettableFuture.create();
        testResultsSettable = create;
        testResults = create;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new IntegrationTestPlugin().onAttachedToEngine(registrar.context(), registrar.messenger());
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.flutterActivity = activityPluginBinding.getActivity();
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        onAttachedToEngine(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromActivity() {
        this.flutterActivity = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        this.flutterActivity = null;
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.methodChannel = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -575977140:
                if (str.equals("captureScreenshot")) {
                    c11 = 0;
                    break;
                }
                break;
            case -426872452:
                if (str.equals("convertFlutterSurfaceToImage")) {
                    c11 = 1;
                    break;
                }
                break;
            case -399852893:
                if (str.equals("revertFlutterImage")) {
                    c11 = 2;
                    break;
                }
                break;
            case 15721874:
                if (str.equals("allTestsFinished")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                if (FlutterDeviceScreenshot.j()) {
                    try {
                        result.success(FlutterDeviceScreenshot.h());
                        return;
                    } catch (IOException e11) {
                        result.error("Could not capture screenshot", "UiAutomation failed", e11);
                        return;
                    }
                } else {
                    Activity activity = this.flutterActivity;
                    if (activity == null) {
                        result.error("Could not capture screenshot", "Activity not initialized", (Object) null);
                        return;
                    } else {
                        FlutterDeviceScreenshot.g(activity, this.methodChannel, result);
                        return;
                    }
                }
            case 1:
                Activity activity2 = this.flutterActivity;
                if (activity2 == null) {
                    result.error("Could not convert to image", "Activity not initialized", (Object) null);
                    return;
                }
                FlutterDeviceScreenshot.i(activity2);
                result.success((Object) null);
                return;
            case 2:
                Activity activity3 = this.flutterActivity;
                if (activity3 == null) {
                    result.error("Could not revert Flutter image", "Activity not initialized", (Object) null);
                    return;
                }
                FlutterDeviceScreenshot.k(activity3);
                result.success((Object) null);
                return;
            case 3:
                testResultsSettable.set((Map) methodCall.argument("results"));
                result.success((Object) null);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        this.flutterActivity = activityPluginBinding.getActivity();
    }

    private void onAttachedToEngine(Context context, BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel2 = new MethodChannel(binaryMessenger, CHANNEL);
        this.methodChannel = methodChannel2;
        methodChannel2.setMethodCallHandler(this);
    }
}
