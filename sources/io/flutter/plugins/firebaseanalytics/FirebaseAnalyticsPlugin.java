package io.flutter.plugins.firebaseanalytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.Map;

public class FirebaseAnalyticsPlugin implements MethodChannel.MethodCallHandler, FlutterPlugin {
    private Activity activity;
    private FirebaseAnalytics firebaseAnalytics;
    private MethodChannel methodChannel;
    private PluginRegistry.Registrar registrar;

    private static Bundle createBundleFromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            String str = (String) next.getKey();
            if (value instanceof String) {
                bundle.putString(str, (String) value);
            } else if (value instanceof Integer) {
                bundle.putInt(str, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                bundle.putLong(str, ((Long) value).longValue());
            } else if (value instanceof Double) {
                bundle.putDouble(str, ((Double) value).doubleValue());
            } else if (value instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) value).booleanValue());
            } else if (value == null) {
                bundle.putString(str, (String) null);
            } else if (value instanceof Iterable) {
                ArrayList arrayList = new ArrayList();
                for (Object next2 : (Iterable) value) {
                    if (next2 instanceof Map) {
                        arrayList.add(createBundleFromMap((Map) next2));
                    } else {
                        throw new IllegalArgumentException("Unsupported value type: " + value.getClass().getCanonicalName() + " in list at key " + str);
                    }
                }
                bundle.putParcelableArrayList(str, arrayList);
            } else if (value instanceof Map) {
                bundle.putParcelable(str, createBundleFromMap((Map) value));
            } else {
                throw new IllegalArgumentException("Unsupported value type: " + value.getClass().getCanonicalName());
            }
        }
        return bundle;
    }

    private void handleLogEvent(MethodCall methodCall, MethodChannel.Result result) {
        Bundle createBundleFromMap = createBundleFromMap((Map) methodCall.argument("parameters"));
        this.firebaseAnalytics.logEvent((String) methodCall.argument("name"), createBundleFromMap);
        result.success((Object) null);
    }

    private void handleResetAnalyticsData(MethodChannel.Result result) {
        this.firebaseAnalytics.resetAnalyticsData();
        result.success((Object) null);
    }

    private void handleSetAnalyticsCollectionEnabled(MethodCall methodCall, MethodChannel.Result result) {
        this.firebaseAnalytics.setAnalyticsCollectionEnabled(((Boolean) methodCall.arguments()).booleanValue());
        result.success((Object) null);
    }

    private void handleSetCurrentScreen(MethodCall methodCall, MethodChannel.Result result) {
        Bundle bundle = new Bundle();
        bundle.putString("screen_name", (String) methodCall.argument("screenName"));
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, (String) methodCall.argument("screenClassOverride"));
        this.firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
        result.success((Object) null);
    }

    private void handleSetSessionTimeoutDuration(MethodCall methodCall, MethodChannel.Result result) {
        this.firebaseAnalytics.setSessionTimeoutDuration((long) ((Integer) methodCall.arguments()).intValue());
        result.success((Object) null);
    }

    private void handleSetUserId(MethodCall methodCall, MethodChannel.Result result) {
        this.firebaseAnalytics.setUserId((String) methodCall.arguments);
        result.success((Object) null);
    }

    private void handleSetUserProperty(MethodCall methodCall, MethodChannel.Result result) {
        this.firebaseAnalytics.setUserProperty((String) methodCall.argument("name"), (String) methodCall.argument("value"));
        result.success((Object) null);
    }

    public static void registerWith(PluginRegistry.Registrar registrar2) {
        FirebaseAnalyticsPlugin firebaseAnalyticsPlugin = new FirebaseAnalyticsPlugin();
        firebaseAnalyticsPlugin.registrar = registrar2;
        firebaseAnalyticsPlugin.onAttachedToEngine(registrar2.context(), registrar2.messenger());
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        onAttachedToEngine(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.firebaseAnalytics = null;
        this.methodChannel = null;
    }

    public void onMethodCall(MethodCall methodCall, @NonNull MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2071164449:
                if (str.equals("setAnalyticsCollectionEnabled")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1583933535:
                if (str.equals("setSessionTimeoutDuration")) {
                    c11 = 1;
                    break;
                }
                break;
            case -721629693:
                if (str.equals("setCurrentScreen")) {
                    c11 = 2;
                    break;
                }
                break;
            case 645367112:
                if (str.equals("setUserId")) {
                    c11 = 3;
                    break;
                }
                break;
            case 776192066:
                if (str.equals("setUserProperty")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1543714625:
                if (str.equals("resetAnalyticsData")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1989757366:
                if (str.equals("logEvent")) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                handleSetAnalyticsCollectionEnabled(methodCall, result);
                return;
            case 1:
                handleSetSessionTimeoutDuration(methodCall, result);
                return;
            case 2:
                handleSetCurrentScreen(methodCall, result);
                return;
            case 3:
                handleSetUserId(methodCall, result);
                return;
            case 4:
                handleSetUserProperty(methodCall, result);
                return;
            case 5:
                handleResetAnalyticsData(result);
                return;
            case 6:
                handleLogEvent(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    private void onAttachedToEngine(Context context, BinaryMessenger binaryMessenger) {
        FirebaseApp.initializeApp(context);
        this.firebaseAnalytics = FirebaseAnalytics.getInstance(context);
        MethodChannel methodChannel2 = new MethodChannel(binaryMessenger, "plugins.flutter.io/firebase_analytics");
        this.methodChannel = methodChannel2;
        methodChannel2.setMethodCallHandler(this);
    }
}
