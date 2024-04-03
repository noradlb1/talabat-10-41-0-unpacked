package io.flutter.plugins.urllauncher;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.urllauncher.UrlLauncher;
import java.util.Map;

final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private static final String TAG = "MethodCallHandlerImpl";
    @Nullable
    private MethodChannel channel;
    private final UrlLauncher urlLauncher;

    public MethodCallHandlerImpl(UrlLauncher urlLauncher2) {
        this.urlLauncher = urlLauncher2;
    }

    private static Bundle extractBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String next : map.keySet()) {
            bundle.putString(next, map.get(next));
        }
        return bundle;
    }

    private void onCanLaunch(MethodChannel.Result result, String str) {
        result.success(Boolean.valueOf(this.urlLauncher.a(str)));
    }

    private void onCloseWebView(MethodChannel.Result result) {
        this.urlLauncher.b();
        result.success((Object) null);
    }

    private void onLaunch(MethodCall methodCall, MethodChannel.Result result, String str) {
        boolean booleanValue = ((Boolean) methodCall.argument("useWebView")).booleanValue();
        boolean booleanValue2 = ((Boolean) methodCall.argument("enableJavaScript")).booleanValue();
        boolean booleanValue3 = ((Boolean) methodCall.argument("enableDomStorage")).booleanValue();
        UrlLauncher.LaunchStatus c11 = this.urlLauncher.c(str, extractBundle((Map) methodCall.argument(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS)), booleanValue, booleanValue2, booleanValue3);
        if (c11 == UrlLauncher.LaunchStatus.NO_ACTIVITY) {
            result.error("NO_ACTIVITY", "Launching a URL requires a foreground activity.", (Object) null);
        } else if (c11 == UrlLauncher.LaunchStatus.ACTIVITY_NOT_FOUND) {
            result.error("ACTIVITY_NOT_FOUND", String.format("No Activity found to handle intent { %s }", new Object[]{str}), (Object) null);
        } else {
            result.success(Boolean.TRUE);
        }
    }

    public void a(BinaryMessenger binaryMessenger) {
        if (this.channel != null) {
            Log.wtf(TAG, "Setting a method call handler before the last was disposed.");
            b();
        }
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/url_launcher");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void b() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
            this.channel = null;
        }
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("url");
        String str2 = methodCall.method;
        str2.hashCode();
        char c11 = 65535;
        switch (str2.hashCode()) {
            case -1109843021:
                if (str2.equals("launch")) {
                    c11 = 0;
                    break;
                }
                break;
            case -185306205:
                if (str2.equals("canLaunch")) {
                    c11 = 1;
                    break;
                }
                break;
            case -121617663:
                if (str2.equals("closeWebView")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                onLaunch(methodCall, result, str);
                return;
            case 1:
                onCanLaunch(result, str);
                return;
            case 2:
                onCloseWebView(result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
