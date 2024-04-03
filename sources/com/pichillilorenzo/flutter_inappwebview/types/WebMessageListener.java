package com.pichillilorenzo.flutter_inappwebview.types;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.ProxyConfig;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.pichillilorenzo.flutter_inappwebview.Util;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView;
import com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.JavaScriptBridgeJS;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.utility.JavaConstant;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class WebMessageListener implements MethodChannel.MethodCallHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final String LOG_TAG = "WebMessageListener";
    public Set<String> allowedOriginRules;
    public MethodChannel channel;

    /* renamed from: id  reason: collision with root package name */
    public String f52882id;
    public String jsObjectName;
    public WebViewCompat.WebMessageListener listener;
    public JavaScriptReplyProxy replyProxy;
    public InAppWebViewInterface webView;

    public WebMessageListener(String str, InAppWebViewInterface inAppWebViewInterface, BinaryMessenger binaryMessenger, String str2, Set<String> set) {
        this.f52882id = str;
        this.webView = inAppWebViewInterface;
        this.jsObjectName = str2;
        this.allowedOriginRules = set;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.pichillilorenzo/flutter_inappwebview_web_message_listener_" + this.f52882id + JavaConstant.Dynamic.DEFAULT_NAME + this.jsObjectName);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        if (this.webView instanceof InAppWebView) {
            this.listener = new WebViewCompat.WebMessageListener() {
                public void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z11, JavaScriptReplyProxy javaScriptReplyProxy) {
                    WebMessageListener.this.replyProxy = javaScriptReplyProxy;
                    this.onPostMessage(webMessageCompat.getData(), uri, z11);
                }
            };
        }
    }

    public static WebMessageListener fromMap(InAppWebViewInterface inAppWebViewInterface, BinaryMessenger binaryMessenger, Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new WebMessageListener((String) map.get("id"), inAppWebViewInterface, binaryMessenger, (String) map.get("jsObjectName"), new HashSet((List) map.get("allowedOriginRules")));
    }

    private void postMessageForInAppWebView(String str, MethodChannel.Result result) {
        if (this.replyProxy != null && WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
            this.replyProxy.postMessage(str);
        }
        result.success(Boolean.TRUE);
    }

    public void assertOriginRulesValid() {
        int i11 = 0;
        for (String next : this.allowedOriginRules) {
            if (next == null) {
                throw new Exception("allowedOriginRules[" + i11 + "] is null");
            } else if (next.isEmpty()) {
                throw new Exception("allowedOriginRules[" + i11 + "] is empty");
            } else if (!"*".equals(next)) {
                Uri parse = Uri.parse(next);
                String scheme = parse.getScheme();
                String host = parse.getHost();
                String path = parse.getPath();
                int port = parse.getPort();
                if (scheme == null) {
                    throw new Exception("allowedOriginRules " + next + " is invalid");
                } else if ((ProxyConfig.MATCH_HTTP.equals(scheme) || "https".equals(scheme)) && (host == null || host.isEmpty())) {
                    throw new Exception("allowedOriginRules " + next + " is invalid");
                } else if (!ProxyConfig.MATCH_HTTP.equals(scheme) && !"https".equals(scheme) && (host != null || port != -1)) {
                    throw new Exception("allowedOriginRules " + next + " is invalid");
                } else if ((host == null || host.isEmpty()) && port != -1) {
                    throw new Exception("allowedOriginRules " + next + " is invalid");
                } else if (path.isEmpty()) {
                    if (host != null) {
                        int indexOf = host.indexOf("*");
                        if (indexOf != 0 || (indexOf == 0 && !host.startsWith("*."))) {
                            throw new Exception("allowedOriginRules " + next + " is invalid");
                        } else if (host.startsWith("[")) {
                            if (!host.endsWith("]")) {
                                throw new Exception("allowedOriginRules " + next + " is invalid");
                            } else if (!Util.isIPv6(host.substring(1, host.length() - 1))) {
                                throw new Exception("allowedOriginRules " + next + " is invalid");
                            }
                        }
                    }
                    i11++;
                } else {
                    throw new Exception("allowedOriginRules " + next + " is invalid");
                }
            }
        }
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.listener = null;
        this.replyProxy = null;
        this.webView = null;
    }

    public void initJsInstance() {
        String str;
        String sb2;
        if (this.webView != null) {
            String replaceAll = Util.replaceAll(this.jsObjectName, "'", "\\'");
            ArrayList arrayList = new ArrayList();
            for (String next : this.allowedOriginRules) {
                if ("*".equals(next)) {
                    sb2 = "'*'";
                } else {
                    Uri parse = Uri.parse(next);
                    Object obj = "null";
                    if (parse.getHost() != null) {
                        str = "'" + Util.replaceAll(parse.getHost(), "'", "\\'") + "'";
                    } else {
                        str = obj;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("{scheme: '");
                    sb3.append(parse.getScheme());
                    sb3.append("', host: ");
                    sb3.append(str);
                    sb3.append(", port: ");
                    Object obj2 = obj;
                    if (parse.getPort() != -1) {
                        obj2 = Integer.valueOf(parse.getPort());
                    }
                    sb3.append(obj2);
                    sb3.append("}");
                    sb2 = sb3.toString();
                }
                arrayList.add(sb2);
            }
            String str2 = "(function() {  var allowedOriginRules = [" + TextUtils.join(IndicativeSentencesGeneration.DEFAULT_SEPARATOR, arrayList) + "];  var isPageBlank = window.location.href === 'about:blank';  var scheme = !isPageBlank ? window.location.protocol.replace(':', '') : null;  var host = !isPageBlank ? window.location.hostname : null;  var port = !isPageBlank ? window.location.port : null;  if (window." + JavaScriptBridgeJS.JAVASCRIPT_BRIDGE_NAME + "._isOriginAllowed(allowedOriginRules, scheme, host, port)) {      window['" + replaceAll + "'] = new FlutterInAppWebViewWebMessageListener('" + replaceAll + "');  }})();";
            this.webView.getUserContentController().addPluginScript(new PluginScript("WebMessageListener-" + this.jsObjectName, str2, UserScriptInjectionTime.AT_DOCUMENT_START, (ContentWorld) null, false));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isOriginAllowed(java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r11 = this;
            java.util.Set<java.lang.String> r0 = r11.allowedOriginRules
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x00f8
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r3 = "*"
            boolean r4 = r3.equals(r1)
            r5 = 1
            if (r4 == 0) goto L_0x001d
            return r5
        L_0x001d:
            if (r12 == 0) goto L_0x0006
            boolean r4 = r12.isEmpty()
            if (r4 == 0) goto L_0x0026
            goto L_0x0006
        L_0x0026:
            boolean r4 = r12.isEmpty()
            r6 = -1
            if (r4 == 0) goto L_0x003a
            if (r13 == 0) goto L_0x0035
            boolean r4 = r13.isEmpty()
            if (r4 == 0) goto L_0x003a
        L_0x0035:
            if (r14 == 0) goto L_0x0006
            if (r14 != r6) goto L_0x003a
            goto L_0x0006
        L_0x003a:
            android.net.Uri r1 = android.net.Uri.parse(r1)
            int r4 = r1.getPort()
            r7 = 443(0x1bb, float:6.21E-43)
            r8 = 80
            java.lang.String r9 = "https"
            if (r4 == r6) goto L_0x0056
            int r4 = r1.getPort()
            if (r4 != 0) goto L_0x0051
            goto L_0x0056
        L_0x0051:
            int r4 = r1.getPort()
            goto L_0x0063
        L_0x0056:
            java.lang.String r4 = r1.getScheme()
            boolean r4 = r9.equals(r4)
            if (r4 == 0) goto L_0x0062
            r4 = r7
            goto L_0x0063
        L_0x0062:
            r4 = r8
        L_0x0063:
            if (r14 == 0) goto L_0x006a
            if (r14 != r6) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r7 = r14
            goto L_0x0072
        L_0x006a:
            boolean r6 = r9.equals(r12)
            if (r6 == 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r7 = r8
        L_0x0072:
            java.lang.String r6 = r1.getHost()
            r8 = 0
            if (r6 == 0) goto L_0x009b
            java.lang.String r6 = r1.getHost()
            java.lang.String r9 = "["
            boolean r6 = r6.startsWith(r9)
            if (r6 == 0) goto L_0x009b
            java.lang.String r6 = r1.getHost()     // Catch:{ Exception -> 0x009b }
            java.lang.String r9 = r1.getHost()     // Catch:{ Exception -> 0x009b }
            int r9 = r9.length()     // Catch:{ Exception -> 0x009b }
            int r9 = r9 - r5
            java.lang.String r6 = r6.substring(r5, r9)     // Catch:{ Exception -> 0x009b }
            java.lang.String r6 = com.pichillilorenzo.flutter_inappwebview.Util.normalizeIPv6(r6)     // Catch:{ Exception -> 0x009b }
            goto L_0x009c
        L_0x009b:
            r6 = r8
        L_0x009c:
            java.lang.String r8 = com.pichillilorenzo.flutter_inappwebview.Util.normalizeIPv6(r13)     // Catch:{ Exception -> 0x00a0 }
        L_0x00a0:
            java.lang.String r9 = r1.getScheme()
            boolean r9 = r9.equals(r12)
            java.lang.String r10 = r1.getHost()
            if (r10 == 0) goto L_0x00ed
            java.lang.String r10 = r1.getHost()
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x00ed
            java.lang.String r10 = r1.getHost()
            boolean r10 = r10.equals(r13)
            if (r10 != 0) goto L_0x00ed
            java.lang.String r10 = r1.getHost()
            boolean r3 = r10.startsWith(r3)
            if (r3 == 0) goto L_0x00e0
            if (r13 == 0) goto L_0x00e0
            java.lang.String r1 = r1.getHost()
            java.lang.String r3 = "\\*"
            java.lang.String[] r1 = r1.split(r3)
            r1 = r1[r5]
            boolean r1 = r13.contains(r1)
            if (r1 != 0) goto L_0x00ed
        L_0x00e0:
            if (r8 == 0) goto L_0x00eb
            if (r6 == 0) goto L_0x00eb
            boolean r1 = r8.equals(r6)
            if (r1 == 0) goto L_0x00eb
            goto L_0x00ed
        L_0x00eb:
            r1 = r2
            goto L_0x00ee
        L_0x00ed:
            r1 = r5
        L_0x00ee:
            if (r4 != r7) goto L_0x00f1
            r2 = r5
        L_0x00f1:
            if (r9 == 0) goto L_0x0006
            if (r1 == 0) goto L_0x0006
            if (r2 == 0) goto L_0x0006
            return r5
        L_0x00f8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.types.WebMessageListener.isOriginAllowed(java.lang.String, java.lang.String, int):boolean");
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        if (!str.equals("postMessage")) {
            result.notImplemented();
        } else if (this.webView instanceof InAppWebView) {
            postMessageForInAppWebView((String) methodCall.argument("message"), result);
        } else {
            result.success(Boolean.TRUE);
        }
    }

    public void onPostMessage(String str, Uri uri, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", str);
        hashMap.put("sourceOrigin", uri.toString().equals("null") ? null : uri.toString());
        hashMap.put("isMainFrame", Boolean.valueOf(z11));
        this.channel.invokeMethod("onPostMessage", hashMap);
    }
}
