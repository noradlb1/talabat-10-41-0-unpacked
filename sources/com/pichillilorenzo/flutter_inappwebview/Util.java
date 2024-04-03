package com.pichillilorenzo.flutter_inappwebview;

import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.pichillilorenzo.flutter_inappwebview.types.Size2D;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public class Util {
    public static final String ANDROID_ASSET_URL = "file:///android_asset/";
    static final String LOG_TAG = "Util";

    public static class PrivateKeyAndCertificates {
        public X509Certificate[] certificates;
        public PrivateKey privateKey;

        public PrivateKeyAndCertificates(PrivateKey privateKey2, X509Certificate[] x509CertificateArr) {
            this.privateKey = privateKey2;
            this.certificates = x509CertificateArr;
        }
    }

    public static class WaitFlutterResult {
        public String error;
        public Object result;

        public WaitFlutterResult(Object obj, String str) {
            this.result = obj;
            this.error = str;
        }
    }

    private Util() {
    }

    public static String JSONStringify(Object obj) {
        return obj == null ? "null" : obj instanceof Map ? JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) (Map) obj)) : obj instanceof List ? JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) (List) obj)) : obj instanceof String ? JSONObject.quote((String) obj) : JSONObject.wrap(obj).toString();
    }

    public static OkHttpClient getBasicOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(15, timeUnit).writeTimeout(15, timeUnit).readTimeout(15, timeUnit).build();
    }

    public static InputStream getFileAsset(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, String str) {
        PluginRegistry.Registrar registrar = inAppWebViewFlutterPlugin.registrar;
        return inAppWebViewFlutterPlugin.applicationContext.getResources().getAssets().open(registrar != null ? registrar.lookupKeyForAsset(str) : inAppWebViewFlutterPlugin.flutterAssets.getAssetFilePathByName(str));
    }

    public static Size2D getFullscreenSize(Context context) {
        int i11;
        Size2D size2D = new Size2D(-1.0d, -1.0d);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                WindowMetrics a11 = windowManager.getCurrentWindowMetrics();
                Insets a12 = a11.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout());
                int a13 = a12.right + a12.left;
                int a14 = a12.top + a12.bottom;
                Rect a15 = a11.getBounds();
                size2D.setWidth((double) (a15.width() - a13));
                i11 = a15.height() - a14;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                size2D.setWidth((double) displayMetrics.widthPixels);
                i11 = displayMetrics.heightPixels;
            }
            size2D.setHeight((double) i11);
        }
        return size2D;
    }

    public static Object getOrDefault(Map map, String str, Object obj) {
        return map.containsKey(str) ? map.get(str) : obj;
    }

    public static float getPixelDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static String getUrlAsset(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, String str) {
        IOException e11;
        PluginRegistry.Registrar registrar = inAppWebViewFlutterPlugin.registrar;
        String lookupKeyForAsset = registrar != null ? registrar.lookupKeyForAsset(str) : inAppWebViewFlutterPlugin.flutterAssets.getAssetFilePathByName(str);
        InputStream fileAsset = getFileAsset(inAppWebViewFlutterPlugin, str);
        if (fileAsset != null) {
            try {
                fileAsset.close();
            } catch (IOException e12) {
                e11 = e12;
            }
        }
        e11 = null;
        if (e11 == null) {
            return ANDROID_ASSET_URL + lookupKeyForAsset;
        }
        throw e11;
    }

    public static X509Certificate getX509CertFromSslCertHack(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            try {
                return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException unused) {
            }
        }
        return null;
    }

    public static WaitFlutterResult invokeMethodAndWait(MethodChannel methodChannel, String str, Object obj) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        HashMap hashMap = new HashMap();
        hashMap.put("result", (Object) null);
        hashMap.put("error", (Object) null);
        final MethodChannel methodChannel2 = methodChannel;
        final String str2 = str;
        final Object obj2 = obj;
        final HashMap hashMap2 = hashMap;
        final CountDownLatch countDownLatch2 = countDownLatch;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                MethodChannel.this.invokeMethod(str2, obj2, new MethodChannel.Result() {
                    public void error(String str, String str2, Object obj) {
                        Map map = hashMap2;
                        map.put("error", "ERROR: " + str + " " + str2);
                        hashMap2.put("result", obj);
                        countDownLatch2.countDown();
                    }

                    public void notImplemented() {
                        countDownLatch2.countDown();
                    }

                    public void success(Object obj) {
                        hashMap2.put("result", obj);
                        countDownLatch2.countDown();
                    }
                });
            }
        });
        countDownLatch.await();
        return new WaitFlutterResult(hashMap.get("result"), (String) hashMap.get("error"));
    }

    public static <O> Object invokeMethodIfExists(O o11, String str, Object... objArr) {
        Method[] methods = o11.getClass().getMethods();
        int length = methods.length;
        int i11 = 0;
        while (i11 < length) {
            Method method = methods[i11];
            if (method.getName().equals(str)) {
                try {
                    return method.invoke(o11, objArr);
                } catch (IllegalAccessException | InvocationTargetException unused) {
                    return null;
                }
            } else {
                i11++;
            }
        }
        return null;
    }

    public static boolean isClass(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isIPv6(String str) {
        try {
            InetAddress.getByName(str);
            return true;
        } catch (UnknownHostException unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
        if (r3 == null) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.pichillilorenzo.flutter_inappwebview.Util.PrivateKeyAndCertificates loadPrivateKeyAndCertificate(com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 0
            java.io.InputStream r3 = getFileAsset(r3, r4)     // Catch:{ IOException -> 0x0006 }
            goto L_0x0007
        L_0x0006:
            r3 = r0
        L_0x0007:
            java.lang.String r1 = "Util"
            if (r3 != 0) goto L_0x0011
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0057 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0057 }
            r3 = r2
        L_0x0011:
            java.security.KeyStore r4 = java.security.KeyStore.getInstance(r6)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x001b
            r2 = r5
            goto L_0x001c
        L_0x001b:
            r2 = r6
        L_0x001c:
            char[] r2 = r2.toCharArray()     // Catch:{ Exception -> 0x0057 }
            r4.load(r3, r2)     // Catch:{ Exception -> 0x0057 }
            java.util.Enumeration r2 = r4.aliases()     // Catch:{ Exception -> 0x0057 }
            java.lang.Object r2 = r2.nextElement()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0057 }
            if (r5 == 0) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r5 = r6
        L_0x0031:
            char[] r5 = r5.toCharArray()     // Catch:{ Exception -> 0x0057 }
            java.security.Key r5 = r4.getKey(r2, r5)     // Catch:{ Exception -> 0x0057 }
            boolean r6 = r5 instanceof java.security.PrivateKey     // Catch:{ Exception -> 0x0057 }
            if (r6 == 0) goto L_0x0051
            java.security.PrivateKey r5 = (java.security.PrivateKey) r5     // Catch:{ Exception -> 0x0057 }
            java.security.cert.Certificate r4 = r4.getCertificate(r2)     // Catch:{ Exception -> 0x0057 }
            r6 = 1
            java.security.cert.X509Certificate[] r6 = new java.security.cert.X509Certificate[r6]     // Catch:{ Exception -> 0x0057 }
            java.security.cert.X509Certificate r4 = (java.security.cert.X509Certificate) r4     // Catch:{ Exception -> 0x0057 }
            r2 = 0
            r6[r2] = r4     // Catch:{ Exception -> 0x0057 }
            com.pichillilorenzo.flutter_inappwebview.Util$PrivateKeyAndCertificates r4 = new com.pichillilorenzo.flutter_inappwebview.Util$PrivateKeyAndCertificates     // Catch:{ Exception -> 0x0057 }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0057 }
            r0 = r4
        L_0x0051:
            r3.close()     // Catch:{ Exception -> 0x0057 }
            goto L_0x0064
        L_0x0055:
            r4 = move-exception
            goto L_0x0074
        L_0x0057:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x0055 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0055 }
            android.util.Log.e(r1, r4)     // Catch:{ all -> 0x0055 }
            if (r3 == 0) goto L_0x0073
        L_0x0064:
            r3.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x0073
        L_0x0068:
            r3 = move-exception
            r3.printStackTrace()
            java.lang.String r3 = r3.getMessage()
            android.util.Log.e(r1, r3)
        L_0x0073:
            return r0
        L_0x0074:
            if (r3 == 0) goto L_0x0085
            r3.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x0085
        L_0x007a:
            r3 = move-exception
            r3.printStackTrace()
            java.lang.String r3 = r3.getMessage()
            android.util.Log.e(r1, r3)
        L_0x0085:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.Util.loadPrivateKeyAndCertificate(com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin, java.lang.String, java.lang.String, java.lang.String):com.pichillilorenzo.flutter_inappwebview.Util$PrivateKeyAndCertificates");
    }

    public static void log(String str, String str2) {
        int min;
        int length = str2.length();
        int i11 = 0;
        while (i11 < length) {
            int indexOf = str2.indexOf(10, i11);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i11 + 4000);
                str2.substring(i11, min);
                if (min >= indexOf) {
                    break;
                }
                i11 = min;
            }
            i11 = min + 1;
        }
    }

    public static String normalizeIPv6(String str) {
        if (isIPv6(str)) {
            return InetAddress.getByName(str).getCanonicalHostName();
        }
        throw new Exception("Invalid address: " + str);
    }

    public static boolean objEquals(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static String replaceAll(String str, String str2, String str3) {
        return TextUtils.join(str3, str.split(Pattern.quote(str2)));
    }
}
