package com.pichillilorenzo.flutter_inappwebview;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import datamodels.TypesAliasesKt;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MyCookieManager implements MethodChannel.MethodCallHandler {
    static final String LOG_TAG = "MyCookieManager";
    public static CookieManager cookieManager;
    public MethodChannel channel;
    public InAppWebViewFlutterPlugin plugin;

    public MyCookieManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappwebview_cookiemanager");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static String getCookieExpirationDate(Long l11) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(new Date(l11.longValue()));
    }

    private static CookieManager getCookieManager() {
        if (cookieManager == null) {
            try {
                cookieManager = CookieManager.getInstance();
            } catch (IllegalArgumentException unused) {
                return null;
            } catch (Exception e11) {
                if (e11.getMessage() != null && e11.getClass().getCanonicalName().equals("android.webkit.WebViewFactory.MissingWebViewPackageException")) {
                    return null;
                }
                throw e11;
            }
        }
        return cookieManager;
    }

    public static void init() {
        if (cookieManager == null) {
            cookieManager = getCookieManager();
        }
    }

    public void deleteAllCookies(final MethodChannel.Result result) {
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 != null) {
            cookieManager.removeAllCookies(new ValueCallback<Boolean>() {
                public void onReceiveValue(Boolean bool) {
                    result.success(Boolean.TRUE);
                }
            });
            cookieManager.flush();
        }
    }

    public void deleteCookie(String str, String str2, String str3, String str4, final MethodChannel.Result result) {
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 != null) {
            String str5 = str2 + "=; Path=" + str4 + "; Max-Age=-1";
            if (str3 != null) {
                str5 = str5 + "; Domain=" + str3;
            }
            cookieManager.setCookie(str, str5 + TypesAliasesKt.separator, new ValueCallback<Boolean>() {
                public void onReceiveValue(Boolean bool) {
                    result.success(Boolean.TRUE);
                }
            });
            cookieManager.flush();
        }
    }

    public void deleteCookies(String str, String str2, String str3, MethodChannel.Result result) {
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 != null) {
            String cookie = cookieManager2.getCookie(str);
            if (cookie != null) {
                for (String split : cookie.split(TypesAliasesKt.separator)) {
                    String str4 = split.split("=", 2)[0].trim() + "=; Path=" + str3 + "; Max-Age=-1";
                    if (str2 != null) {
                        str4 = str4 + "; Domain=" + str2;
                    }
                    cookieManager.setCookie(str, str4 + TypesAliasesKt.separator, (ValueCallback) null);
                }
                cookieManager.flush();
            }
            result.success(Boolean.TRUE);
        }
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.plugin = null;
    }

    public List<Map<String, Object>> getCookies(String str) {
        String cookie;
        ArrayList arrayList = new ArrayList();
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (!(cookieManager2 == null || (cookie = cookieManager2.getCookie(str)) == null)) {
            for (String split : cookie.split(TypesAliasesKt.separator)) {
                String[] split2 = split.split("=", 2);
                String trim = split2[0].trim();
                String trim2 = split2.length > 1 ? split2[1].trim() : "";
                HashMap hashMap = new HashMap();
                hashMap.put("name", trim);
                hashMap.put("value", trim2);
                hashMap.put("expiresDate", (Object) null);
                hashMap.put("isSessionOnly", (Object) null);
                hashMap.put("domain", (Object) null);
                hashMap.put("sameSite", (Object) null);
                hashMap.put("isSecure", (Object) null);
                hashMap.put("isHttpOnly", (Object) null);
                hashMap.put("path", (Object) null);
                arrayList.add(hashMap);
            }
        }
        return arrayList;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        MethodCall methodCall2 = methodCall;
        MethodChannel.Result result2 = result;
        init();
        String str = methodCall2.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1222815761:
                if (str.equals("deleteCookie")) {
                    c11 = 0;
                    break;
                }
                break;
            case 126640486:
                if (str.equals("setCookie")) {
                    c11 = 1;
                    break;
                }
                break;
            case 747417188:
                if (str.equals("deleteCookies")) {
                    c11 = 2;
                    break;
                }
                break;
            case 822411705:
                if (str.equals("deleteAllCookies")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1989049945:
                if (str.equals("getCookies")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                deleteCookie((String) methodCall2.argument("url"), (String) methodCall2.argument("name"), (String) methodCall2.argument("domain"), (String) methodCall2.argument("path"), result);
                return;
            case 1:
                String str2 = (String) methodCall2.argument("url");
                String str3 = (String) methodCall2.argument("name");
                String str4 = (String) methodCall2.argument("value");
                String str5 = (String) methodCall2.argument("domain");
                String str6 = (String) methodCall2.argument("path");
                String str7 = (String) methodCall2.argument("expiresDate");
                setCookie(str2, str3, str4, str5, str6, str7 != null ? new Long(str7) : null, (Integer) methodCall2.argument("maxAge"), (Boolean) methodCall2.argument("isSecure"), (Boolean) methodCall2.argument("isHttpOnly"), (String) methodCall2.argument("sameSite"), result);
                return;
            case 2:
                deleteCookies((String) methodCall2.argument("url"), (String) methodCall2.argument("domain"), (String) methodCall2.argument("path"), result2);
                return;
            case 3:
                deleteAllCookies(result2);
                return;
            case 4:
                result2.success(getCookies((String) methodCall2.argument("url")));
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public void setCookie(String str, String str2, String str3, String str4, String str5, Long l11, Integer num, Boolean bool, Boolean bool2, String str6, final MethodChannel.Result result) {
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 != null) {
            String str7 = str2 + "=" + str3 + "; Path=" + str5;
            if (str4 != null) {
                str7 = str7 + "; Domain=" + str4;
            }
            if (l11 != null) {
                str7 = str7 + "; Expires=" + getCookieExpirationDate(l11);
            }
            if (num != null) {
                str7 = str7 + "; Max-Age=" + num.toString();
            }
            if (bool != null && bool.booleanValue()) {
                str7 = str7 + "; Secure";
            }
            if (bool2 != null && bool2.booleanValue()) {
                str7 = str7 + "; HttpOnly";
            }
            if (str6 != null) {
                str7 = str7 + "; SameSite=" + str6;
            }
            cookieManager.setCookie(str, str7 + TypesAliasesKt.separator, new ValueCallback<Boolean>() {
                public void onReceiveValue(Boolean bool) {
                    result.success(Boolean.TRUE);
                }
            });
            cookieManager.flush();
        }
    }
}
