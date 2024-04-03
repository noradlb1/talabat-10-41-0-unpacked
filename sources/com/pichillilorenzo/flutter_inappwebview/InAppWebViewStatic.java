package com.pichillilorenzo.flutter_inappwebview;

import android.content.pm.PackageInfo;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

public class InAppWebViewStatic implements MethodChannel.MethodCallHandler {
    protected static final String LOG_TAG = "InAppWebViewStatic";
    public MethodChannel channel;
    public InAppWebViewFlutterPlugin plugin;

    public InAppWebViewStatic(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappwebview_static");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public Map<String, Object> convertWebViewPackageToMap(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("versionName", packageInfo.versionName);
        hashMap.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, packageInfo.packageName);
        return hashMap;
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.plugin = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a0, code lost:
        r6.success(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r5, final io.flutter.plugin.common.MethodChannel.Result r6) {
        /*
            r4 = this;
            java.lang.String r0 = r5.method
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = 0
            r3 = -1
            switch(r1) {
                case -1600358415: goto L_0x0047;
                case -910403233: goto L_0x003b;
                case -436220260: goto L_0x0030;
                case 258673215: goto L_0x0025;
                case 643643439: goto L_0x001a;
                case 1586319888: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0051
        L_0x000f:
            java.lang.String r1 = "getCurrentWebViewPackage"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0018
            goto L_0x0051
        L_0x0018:
            r3 = 5
            goto L_0x0051
        L_0x001a:
            java.lang.String r1 = "getDefaultUserAgent"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0023
            goto L_0x0051
        L_0x0023:
            r3 = 4
            goto L_0x0051
        L_0x0025:
            java.lang.String r1 = "getSafeBrowsingPrivacyPolicyUrl"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002e
            goto L_0x0051
        L_0x002e:
            r3 = 3
            goto L_0x0051
        L_0x0030:
            java.lang.String r1 = "clearClientCertPreferences"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0039
            goto L_0x0051
        L_0x0039:
            r3 = 2
            goto L_0x0051
        L_0x003b:
            java.lang.String r1 = "setWebContentsDebuggingEnabled"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0045
            goto L_0x0051
        L_0x0045:
            r3 = 1
            goto L_0x0051
        L_0x0047:
            java.lang.String r1 = "setSafeBrowsingWhitelist"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r3 = r2
        L_0x0051:
            r0 = 0
            switch(r3) {
                case 0: goto L_0x00d4;
                case 1: goto L_0x00c2;
                case 2: goto L_0x00b9;
                case 3: goto L_0x00a4;
                case 4: goto L_0x0098;
                case 5: goto L_0x005a;
                default: goto L_0x0055;
            }
        L_0x0055:
            r6.notImplemented()
            goto L_0x010c
        L_0x005a:
            int r5 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r5 < r1) goto L_0x0079
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r5 = r4.plugin
            if (r5 == 0) goto L_0x0079
            android.app.Activity r1 = r5.activity
            if (r1 != 0) goto L_0x006c
            android.content.Context r3 = r5.applicationContext
            if (r3 == 0) goto L_0x0079
        L_0x006c:
            if (r1 != 0) goto L_0x0070
            android.content.Context r1 = r5.applicationContext
        L_0x0070:
            android.content.pm.PackageInfo r5 = androidx.webkit.WebViewCompat.getCurrentWebViewPackage(r1)
            java.util.Map r5 = r4.convertWebViewPackageToMap(r5)
            goto L_0x00a0
        L_0x0079:
            java.lang.String r5 = "android.webkit.WebViewFactory"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r1 = "getLoadedPackageInfo"
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x00b5 }
            java.lang.reflect.Method r5 = r5.getMethod(r1, r3)     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r5 = r5.invoke(r0, r1)     // Catch:{ Exception -> 0x00b5 }
            android.content.pm.PackageInfo r5 = (android.content.pm.PackageInfo) r5     // Catch:{ Exception -> 0x00b5 }
            java.util.Map r5 = r4.convertWebViewPackageToMap(r5)     // Catch:{ Exception -> 0x00b5 }
            r6.success(r5)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x010c
        L_0x0098:
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r5 = r4.plugin
            android.content.Context r5 = r5.applicationContext
            java.lang.String r5 = android.webkit.WebSettings.getDefaultUserAgent(r5)
        L_0x00a0:
            r6.success(r5)
            goto L_0x010c
        L_0x00a4:
            java.lang.String r5 = "SAFE_BROWSING_PRIVACY_POLICY_URL"
            boolean r5 = androidx.webkit.WebViewFeature.isFeatureSupported(r5)
            if (r5 == 0) goto L_0x00b5
            android.net.Uri r5 = androidx.webkit.WebViewCompat.getSafeBrowsingPrivacyPolicyUrl()
            java.lang.String r5 = r5.toString()
            goto L_0x00a0
        L_0x00b5:
            r6.success(r0)
            goto L_0x010c
        L_0x00b9:
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic$1 r5 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic$1
            r5.<init>(r6)
            android.webkit.WebView.clearClientCertPreferences(r5)
            goto L_0x010c
        L_0x00c2:
            java.lang.String r0 = "debuggingEnabled"
            java.lang.Object r5 = r5.argument(r0)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            android.webkit.WebView.setWebContentsDebuggingEnabled(r5)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            goto L_0x00a0
        L_0x00d4:
            java.lang.String r0 = "SAFE_BROWSING_ALLOWLIST"
            boolean r0 = androidx.webkit.WebViewFeature.isFeatureSupported(r0)
            java.lang.String r1 = "hosts"
            if (r0 == 0) goto L_0x00f2
            java.util.HashSet r0 = new java.util.HashSet
            java.lang.Object r5 = r5.argument(r1)
            java.util.List r5 = (java.util.List) r5
            r0.<init>(r5)
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic$2 r5 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic$2
            r5.<init>(r6)
            androidx.webkit.WebViewCompat.setSafeBrowsingAllowlist(r0, r5)
            goto L_0x010c
        L_0x00f2:
            java.lang.String r0 = "SAFE_BROWSING_WHITELIST"
            boolean r0 = androidx.webkit.WebViewFeature.isFeatureSupported(r0)
            if (r0 == 0) goto L_0x0109
            java.lang.Object r5 = r5.argument(r1)
            java.util.List r5 = (java.util.List) r5
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic$3 r0 = new com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic$3
            r0.<init>(r6)
            androidx.webkit.WebViewCompat.setSafeBrowsingWhitelist(r5, r0)
            goto L_0x010c
        L_0x0109:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L_0x00a0
        L_0x010c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.InAppWebViewStatic.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
