package com.pichillilorenzo.flutter_inappwebview;

import android.os.Build;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import net.bytebuddy.utility.JavaConstant;

public class PlatformUtil implements MethodChannel.MethodCallHandler {
    protected static final String LOG_TAG = "PlatformUtil";
    public MethodChannel channel;
    public InAppWebViewFlutterPlugin plugin;

    public PlatformUtil(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappwebview_platformutil");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static String formatDate(long j11, String str, Locale locale, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(new Date(j11));
    }

    public static Locale getLocaleFromString(String str) {
        if (str == null) {
            return Locale.US;
        }
        String[] split = str.split(JavaConstant.Dynamic.DEFAULT_NAME);
        String str2 = split[0];
        String str3 = "";
        String str4 = split.length > 1 ? split[1] : str3;
        if (split.length > 2) {
            str3 = split[2];
        }
        return new Locale(str2, str4, str3);
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.plugin = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        String str2 = methodCall.method;
        str2.hashCode();
        if (str2.equals("formatDate")) {
            long longValue = ((Long) methodCall.argument("date")).longValue();
            String str3 = (String) methodCall.argument("format");
            Locale localeFromString = getLocaleFromString((String) methodCall.argument("locale"));
            String str4 = (String) methodCall.argument("timezone");
            if (str4 == null) {
                str4 = "UTC";
            }
            str = formatDate(longValue, str3, localeFromString, DesugarTimeZone.getTimeZone(str4));
        } else if (!str2.equals("getSystemVersion")) {
            result.notImplemented();
            return;
        } else {
            str = String.valueOf(Build.VERSION.SDK_INT);
        }
        result.success(str);
    }
}
