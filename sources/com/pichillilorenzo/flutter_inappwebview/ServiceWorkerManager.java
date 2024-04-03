package com.pichillilorenzo.flutter_inappwebview;

import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.webkit.ServiceWorkerClientCompat;
import androidx.webkit.ServiceWorkerControllerCompat;
import androidx.webkit.WebViewFeature;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.pichillilorenzo.flutter_inappwebview.Util;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

public class ServiceWorkerManager implements MethodChannel.MethodCallHandler {
    static final String LOG_TAG = "ServiceWorkerManager";
    public static ServiceWorkerControllerCompat serviceWorkerController;
    public MethodChannel channel;
    public InAppWebViewFlutterPlugin plugin;

    public static final class DummyServiceWorkerClientCompat extends ServiceWorkerClientCompat {
        static final ServiceWorkerClientCompat INSTANCE = new DummyServiceWorkerClientCompat();

        private DummyServiceWorkerClientCompat() {
        }

        public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
            return null;
        }
    }

    public ServiceWorkerManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappwebview_android_serviceworkercontroller");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    private ServiceWorkerClientCompat dummyServiceWorkerClientCompat() {
        return DummyServiceWorkerClientCompat.INSTANCE;
    }

    public static void init() {
        if (serviceWorkerController == null && WebViewFeature.isFeatureSupported("SERVICE_WORKER_BASIC_USAGE")) {
            serviceWorkerController = ServiceWorkerControllerCompat.getInstance();
        }
    }

    private void setServiceWorkerClient(Boolean bool) {
        ServiceWorkerControllerCompat serviceWorkerControllerCompat = serviceWorkerController;
        if (serviceWorkerControllerCompat != null) {
            serviceWorkerControllerCompat.setServiceWorkerClient(bool.booleanValue() ? dummyServiceWorkerClientCompat() : new ServiceWorkerClientCompat() {
                public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", webResourceRequest.getUrl().toString());
                    hashMap.put("method", webResourceRequest.getMethod());
                    hashMap.put(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS, webResourceRequest.getRequestHeaders());
                    hashMap.put("isForMainFrame", Boolean.valueOf(webResourceRequest.isForMainFrame()));
                    hashMap.put("hasGesture", Boolean.valueOf(webResourceRequest.hasGesture()));
                    hashMap.put("isRedirect", Boolean.valueOf(webResourceRequest.isRedirect()));
                    ByteArrayInputStream byteArrayInputStream = null;
                    try {
                        Util.WaitFlutterResult invokeMethodAndWait = Util.invokeMethodAndWait(ServiceWorkerManager.this.channel, "shouldInterceptRequest", hashMap);
                        String str = invokeMethodAndWait.error;
                        if (str != null) {
                            Log.e(ServiceWorkerManager.LOG_TAG, str);
                            return null;
                        }
                        Object obj = invokeMethodAndWait.result;
                        if (obj == null) {
                            return null;
                        }
                        Map map = (Map) obj;
                        String str2 = (String) map.get(AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
                        String str3 = (String) map.get("contentEncoding");
                        byte[] bArr = (byte[]) map.get("data");
                        Map map2 = (Map) map.get(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS);
                        Integer num = (Integer) map.get("statusCode");
                        String str4 = (String) map.get("reasonPhrase");
                        if (bArr != null) {
                            byteArrayInputStream = new ByteArrayInputStream(bArr);
                        }
                        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                        return (map2 == null && num == null && str4 == null) ? new WebResourceResponse(str2, str3, byteArrayInputStream2) : new WebResourceResponse(str2, str3, num.intValue(), str4, map2, byteArrayInputStream2);
                    } catch (InterruptedException e11) {
                        e11.printStackTrace();
                        return null;
                    }
                }
            });
        }
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        ServiceWorkerControllerCompat serviceWorkerControllerCompat = serviceWorkerController;
        if (serviceWorkerControllerCompat != null) {
            serviceWorkerControllerCompat.setServiceWorkerClient(dummyServiceWorkerClientCompat());
            serviceWorkerController = null;
        }
        this.plugin = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012c, code lost:
        r9 = java.lang.Boolean.TRUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012e, code lost:
        r10.success(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x013e, code lost:
        r9 = java.lang.Boolean.valueOf(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0143, code lost:
        r9 = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r9, io.flutter.plugin.common.MethodChannel.Result r10) {
        /*
            r8 = this;
            init()
            androidx.webkit.ServiceWorkerControllerCompat r0 = serviceWorkerController
            r1 = 0
            if (r0 == 0) goto L_0x000d
            androidx.webkit.ServiceWorkerWebSettingsCompat r0 = r0.getServiceWorkerWebSettings()
            goto L_0x000e
        L_0x000d:
            r0 = r1
        L_0x000e:
            java.lang.String r2 = r9.method
            r2.hashCode()
            int r3 = r2.hashCode()
            r4 = -1
            switch(r3) {
                case -1332730774: goto L_0x0078;
                case -1165005700: goto L_0x006d;
                case -563397233: goto L_0x0062;
                case 674894835: goto L_0x0057;
                case 985595395: goto L_0x004c;
                case 1083898794: goto L_0x0041;
                case 1203480182: goto L_0x0036;
                case 1594928487: goto L_0x002b;
                case 1694822198: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x0082
        L_0x001d:
            java.lang.String r3 = "getBlockNetworkLoads"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0027
            goto L_0x0082
        L_0x0027:
            r4 = 8
            goto L_0x0082
        L_0x002b:
            java.lang.String r3 = "setAllowFileAccess"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0034
            goto L_0x0082
        L_0x0034:
            r4 = 7
            goto L_0x0082
        L_0x0036:
            java.lang.String r3 = "setAllowContentAccess"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x003f
            goto L_0x0082
        L_0x003f:
            r4 = 6
            goto L_0x0082
        L_0x0041:
            java.lang.String r3 = "setBlockNetworkLoads"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x004a
            goto L_0x0082
        L_0x004a:
            r4 = 5
            goto L_0x0082
        L_0x004c:
            java.lang.String r3 = "setCacheMode"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0055
            goto L_0x0082
        L_0x0055:
            r4 = 4
            goto L_0x0082
        L_0x0057:
            java.lang.String r3 = "getAllowFileAccess"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0060
            goto L_0x0082
        L_0x0060:
            r4 = 3
            goto L_0x0082
        L_0x0062:
            java.lang.String r3 = "getCacheMode"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x006b
            goto L_0x0082
        L_0x006b:
            r4 = 2
            goto L_0x0082
        L_0x006d:
            java.lang.String r3 = "setServiceWorkerClient"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0076
            goto L_0x0082
        L_0x0076:
            r4 = 1
            goto L_0x0082
        L_0x0078:
            java.lang.String r3 = "getAllowContentAccess"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r4 = 0
        L_0x0082:
            java.lang.String r2 = "allow"
            java.lang.String r3 = "SERVICE_WORKER_BLOCK_NETWORK_LOADS"
            java.lang.String r5 = "SERVICE_WORKER_FILE_ACCESS"
            java.lang.String r6 = "SERVICE_WORKER_CACHE_MODE"
            java.lang.String r7 = "SERVICE_WORKER_CONTENT_ACCESS"
            switch(r4) {
                case 0: goto L_0x0132;
                case 1: goto L_0x0121;
                case 2: goto L_0x010c;
                case 3: goto L_0x00ff;
                case 4: goto L_0x00e7;
                case 5: goto L_0x00cf;
                case 6: goto L_0x00b9;
                case 7: goto L_0x00a2;
                case 8: goto L_0x0094;
                default: goto L_0x008f;
            }
        L_0x008f:
            r10.notImplemented()
            goto L_0x0146
        L_0x0094:
            if (r0 == 0) goto L_0x0143
            boolean r9 = androidx.webkit.WebViewFeature.isFeatureSupported(r3)
            if (r9 == 0) goto L_0x0143
            boolean r9 = r0.getBlockNetworkLoads()
            goto L_0x013e
        L_0x00a2:
            if (r0 == 0) goto L_0x012c
            boolean r1 = androidx.webkit.WebViewFeature.isFeatureSupported(r5)
            if (r1 == 0) goto L_0x012c
            java.lang.Object r9 = r9.argument(r2)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r0.setAllowFileAccess(r9)
            goto L_0x012c
        L_0x00b9:
            if (r0 == 0) goto L_0x012c
            boolean r1 = androidx.webkit.WebViewFeature.isFeatureSupported(r7)
            if (r1 == 0) goto L_0x012c
            java.lang.Object r9 = r9.argument(r2)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r0.setAllowContentAccess(r9)
            goto L_0x012c
        L_0x00cf:
            if (r0 == 0) goto L_0x012c
            boolean r1 = androidx.webkit.WebViewFeature.isFeatureSupported(r3)
            if (r1 == 0) goto L_0x012c
            java.lang.String r1 = "flag"
            java.lang.Object r9 = r9.argument(r1)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r0.setBlockNetworkLoads(r9)
            goto L_0x012c
        L_0x00e7:
            if (r0 == 0) goto L_0x012c
            boolean r1 = androidx.webkit.WebViewFeature.isFeatureSupported(r6)
            if (r1 == 0) goto L_0x012c
            java.lang.String r1 = "mode"
            java.lang.Object r9 = r9.argument(r1)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r0.setCacheMode(r9)
            goto L_0x012c
        L_0x00ff:
            if (r0 == 0) goto L_0x0143
            boolean r9 = androidx.webkit.WebViewFeature.isFeatureSupported(r5)
            if (r9 == 0) goto L_0x0143
            boolean r9 = r0.getAllowFileAccess()
            goto L_0x013e
        L_0x010c:
            if (r0 == 0) goto L_0x011d
            boolean r9 = androidx.webkit.WebViewFeature.isFeatureSupported(r6)
            if (r9 == 0) goto L_0x011d
            int r9 = r0.getCacheMode()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x012e
        L_0x011d:
            r10.success(r1)
            goto L_0x0146
        L_0x0121:
            java.lang.String r0 = "isNull"
            java.lang.Object r9 = r9.argument(r0)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            r8.setServiceWorkerClient(r9)
        L_0x012c:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
        L_0x012e:
            r10.success(r9)
            goto L_0x0146
        L_0x0132:
            if (r0 == 0) goto L_0x0143
            boolean r9 = androidx.webkit.WebViewFeature.isFeatureSupported(r7)
            if (r9 == 0) goto L_0x0143
            boolean r9 = r0.getAllowContentAccess()
        L_0x013e:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            goto L_0x012e
        L_0x0143:
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            goto L_0x012e
        L_0x0146:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.ServiceWorkerManager.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
