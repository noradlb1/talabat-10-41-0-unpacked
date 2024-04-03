package com.pichillilorenzo.flutter_inappwebview.content_blocker;

import android.util.Log;
import android.webkit.WebResourceResponse;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.instabug.library.model.NetworkLog;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.pichillilorenzo.flutter_inappwebview.Util;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView;
import datamodels.TypesAliasesKt;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Instrumented
public class ContentBlockerHandler {
    protected static final String LOG_TAG = "ContentBlockerHandler";
    protected List<ContentBlocker> ruleList;

    /* renamed from: com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerHandler$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$pichillilorenzo$flutter_inappwebview$content_blocker$ContentBlockerActionType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerActionType[] r0 = com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerActionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview$content_blocker$ContentBlockerActionType = r0
                com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerActionType r1 = com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerActionType.BLOCK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$pichillilorenzo$flutter_inappwebview$content_blocker$ContentBlockerActionType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerActionType r1 = com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerActionType.CSS_DISPLAY_NONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$pichillilorenzo$flutter_inappwebview$content_blocker$ContentBlockerActionType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerActionType r1 = com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerActionType.MAKE_HTTPS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerHandler.AnonymousClass3.<clinit>():void");
        }
    }

    public ContentBlockerHandler() {
        this.ruleList = new ArrayList();
    }

    public ContentBlockerHandler(List<ContentBlocker> list) {
        new ArrayList();
        this.ruleList = list;
    }

    public WebResourceResponse checkUrl(InAppWebView inAppWebView, String str) {
        return checkUrl(inAppWebView, str, getResourceTypeFromUrl(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.webkit.WebResourceResponse checkUrl(com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView r19, java.lang.String r20, com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerTriggerResourceType r21) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.String r4 = "charset="
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r2.options
            java.util.List<java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>>> r0 = r0.contentBlockers
            r5 = 0
            if (r0 != 0) goto L_0x0010
            return r5
        L_0x0010:
            r6 = 0
            java.net.URI r0 = new java.net.URI     // Catch:{ URISyntaxException -> 0x0017 }
            r0.<init>(r3)     // Catch:{ URISyntaxException -> 0x0017 }
            goto L_0x0049
        L_0x0017:
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r3.split(r0)
            r8 = r0[r6]
            java.net.URL r0 = new java.net.URL
            java.lang.String r7 = "https"
            java.lang.String r7 = r3.replace(r8, r7)
            r0.<init>(r7)
            java.net.URI r15 = new java.net.URI
            java.lang.String r9 = r0.getUserInfo()
            java.lang.String r10 = r0.getHost()
            int r11 = r0.getPort()
            java.lang.String r12 = r0.getPath()
            java.lang.String r13 = r0.getQuery()
            java.lang.String r14 = r0.getRef()
            r7 = r15
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            r0 = r15
        L_0x0049:
            java.lang.String r7 = r0.getHost()
            int r8 = r0.getPort()
            java.lang.String r9 = r0.getScheme()
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            java.util.List<com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlocker> r10 = r1.ruleList
            r0.<init>(r10)
            java.util.Iterator r10 = r0.iterator()
        L_0x0060:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0328
            java.lang.Object r0 = r10.next()
            com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlocker r0 = (com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlocker) r0
            com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerTrigger r11 = r0.getTrigger()
            java.util.List r12 = r11.getResourceType()
            com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerTriggerResourceType r13 = com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerTriggerResourceType.IMAGE
            boolean r13 = r12.contains(r13)
            if (r13 == 0) goto L_0x0087
            com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerTriggerResourceType r13 = com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerTriggerResourceType.SVG_DOCUMENT
            boolean r14 = r12.contains(r13)
            if (r14 != 0) goto L_0x0087
            r12.add(r13)
        L_0x0087:
            com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerAction r0 = r0.getAction()
            java.util.regex.Pattern r13 = r11.getUrlFilterPatternCompiled()
            java.util.regex.Matcher r13 = r13.matcher(r3)
            boolean r13 = r13.matches()
            if (r13 == 0) goto L_0x0060
            boolean r13 = r12.isEmpty()
            if (r13 != 0) goto L_0x00a8
            r13 = r21
            boolean r12 = r12.contains(r13)
            if (r12 != 0) goto L_0x00aa
            return r5
        L_0x00a8:
            r13 = r21
        L_0x00aa:
            java.util.List r12 = r11.getIfDomain()
            boolean r12 = r12.isEmpty()
            java.lang.String r14 = "*"
            java.lang.String r15 = ""
            if (r12 != 0) goto L_0x00ed
            java.util.List r12 = r11.getIfDomain()
            java.util.Iterator r12 = r12.iterator()
        L_0x00c0:
            boolean r16 = r12.hasNext()
            if (r16 == 0) goto L_0x00e8
            java.lang.Object r16 = r12.next()
            r6 = r16
            java.lang.String r6 = (java.lang.String) r6
            boolean r16 = r6.startsWith(r14)
            if (r16 == 0) goto L_0x00de
            java.lang.String r5 = r6.replace(r14, r15)
            boolean r5 = r7.endsWith(r5)
            if (r5 != 0) goto L_0x00e4
        L_0x00de:
            boolean r5 = r6.equals(r7)
            if (r5 == 0) goto L_0x00e6
        L_0x00e4:
            r5 = 1
            goto L_0x00e9
        L_0x00e6:
            r5 = 0
            goto L_0x00c0
        L_0x00e8:
            r5 = 0
        L_0x00e9:
            if (r5 != 0) goto L_0x00ed
            r5 = 0
            return r5
        L_0x00ed:
            java.util.List r5 = r11.getUnlessDomain()
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0123
            java.util.List r5 = r11.getUnlessDomain()
            java.util.Iterator r5 = r5.iterator()
        L_0x00ff:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0123
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r12 = r6.startsWith(r14)
            if (r12 == 0) goto L_0x011b
            java.lang.String r12 = r6.replace(r14, r15)
            boolean r12 = r7.endsWith(r12)
            if (r12 != 0) goto L_0x0121
        L_0x011b:
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00ff
        L_0x0121:
            r2 = 0
            return r2
        L_0x0123:
            r5 = 1
            java.lang.String[] r6 = new java.lang.String[r5]
            java.util.List r5 = r11.getLoadType()
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0144
            java.util.List r5 = r11.getIfTopUrl()
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0144
            java.util.List r5 = r11.getUnlessTopUrl()
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x015e
        L_0x0144:
            java.util.concurrent.CountDownLatch r5 = new java.util.concurrent.CountDownLatch
            r12 = 1
            r5.<init>(r12)
            android.os.Handler r12 = new android.os.Handler
            android.os.Looper r14 = r19.getWebViewLooper()
            r12.<init>(r14)
            com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerHandler$1 r14 = new com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerHandler$1
            r14.<init>(r6, r2, r5)
            r12.post(r14)
            r5.await()
        L_0x015e:
            r5 = 0
            r12 = r6[r5]
            if (r12 == 0) goto L_0x0211
            java.util.List r12 = r11.getLoadType()
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x01b8
            java.net.URI r12 = new java.net.URI
            r14 = r6[r5]
            r12.<init>(r14)
            java.lang.String r5 = r12.getHost()
            int r14 = r12.getPort()
            java.lang.String r12 = r12.getScheme()
            r17 = r10
            java.util.List r10 = r11.getLoadType()
            java.lang.String r13 = "first-party"
            boolean r10 = r10.contains(r13)
            if (r10 == 0) goto L_0x01a1
            if (r5 == 0) goto L_0x01a1
            boolean r10 = r12.equals(r9)
            if (r10 == 0) goto L_0x019f
            boolean r10 = r5.equals(r7)
            if (r10 == 0) goto L_0x019f
            if (r14 != r8) goto L_0x019f
            goto L_0x01a1
        L_0x019f:
            r2 = 0
            goto L_0x01b7
        L_0x01a1:
            java.util.List r10 = r11.getLoadType()
            java.lang.String r12 = "third-party"
            boolean r10 = r10.contains(r12)
            if (r10 == 0) goto L_0x01ba
            if (r5 == 0) goto L_0x01ba
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x01ba
            goto L_0x019f
        L_0x01b7:
            return r2
        L_0x01b8:
            r17 = r10
        L_0x01ba:
            java.util.List r5 = r11.getIfTopUrl()
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x01e8
            java.util.List r5 = r11.getIfTopUrl()
            java.util.Iterator r5 = r5.iterator()
        L_0x01cc:
            boolean r10 = r5.hasNext()
            if (r10 == 0) goto L_0x01e3
            java.lang.Object r10 = r5.next()
            java.lang.String r10 = (java.lang.String) r10
            r12 = 0
            r13 = r6[r12]
            boolean r10 = r13.startsWith(r10)
            if (r10 == 0) goto L_0x01cc
            r5 = 1
            goto L_0x01e4
        L_0x01e3:
            r5 = 0
        L_0x01e4:
            if (r5 != 0) goto L_0x01e8
            r5 = 0
            return r5
        L_0x01e8:
            java.util.List r5 = r11.getUnlessTopUrl()
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0213
            java.util.List r5 = r11.getUnlessTopUrl()
            java.util.Iterator r5 = r5.iterator()
        L_0x01fa:
            boolean r10 = r5.hasNext()
            if (r10 == 0) goto L_0x0213
            java.lang.Object r10 = r5.next()
            java.lang.String r10 = (java.lang.String) r10
            r11 = 0
            r12 = r6[r11]
            boolean r10 = r12.startsWith(r10)
            if (r10 == 0) goto L_0x01fa
            r10 = 0
            return r10
        L_0x0211:
            r17 = r10
        L_0x0213:
            int[] r5 = com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerHandler.AnonymousClass3.$SwitchMap$com$pichillilorenzo$flutter_inappwebview$content_blocker$ContentBlockerActionType
            com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerActionType r6 = r0.getType()
            int r6 = r6.ordinal()
            r5 = r5[r6]
            r6 = 1
            if (r5 == r6) goto L_0x0321
            r6 = 2
            if (r5 == r6) goto L_0x02e7
            r0 = 3
            if (r5 == r0) goto L_0x022a
            goto L_0x02e1
        L_0x022a:
            java.lang.String r0 = "http"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x02e1
            r0 = -1
            if (r8 == r0) goto L_0x0239
            r0 = 80
            if (r8 != r0) goto L_0x02e1
        L_0x0239:
            java.lang.String r0 = "http://"
            java.lang.String r5 = "https://"
            java.lang.String r0 = r3.replace(r0, r5)
            okhttp3.Request$Builder r5 = new okhttp3.Request$Builder
            r5.<init>()
            okhttp3.Request$Builder r0 = r5.url((java.lang.String) r0)
            boolean r5 = r0 instanceof okhttp3.Request.Builder
            if (r5 != 0) goto L_0x0253
            okhttp3.Request r0 = r0.build()
            goto L_0x0257
        L_0x0253:
            okhttp3.Request r0 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.build(r0)
        L_0x0257:
            okhttp3.OkHttpClient r5 = com.pichillilorenzo.flutter_inappwebview.Util.getBasicOkHttpClient()     // Catch:{ Exception -> 0x02c1 }
            boolean r6 = r5 instanceof okhttp3.OkHttpClient     // Catch:{ Exception -> 0x02c1 }
            if (r6 != 0) goto L_0x0268
            okhttp3.Call r0 = r5.newCall(r0)     // Catch:{ Exception -> 0x0264 }
            goto L_0x026c
        L_0x0264:
            r0 = move-exception
            r5 = 0
        L_0x0266:
            r10 = 0
            goto L_0x02c4
        L_0x0268:
            okhttp3.Call r0 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.newCall(r5, r0)     // Catch:{ Exception -> 0x02c1 }
        L_0x026c:
            okhttp3.Response r5 = com.google.firebase.perf.network.FirebasePerfOkHttpClient.execute(r0)     // Catch:{ Exception -> 0x02c1 }
            okhttp3.ResponseBody r0 = r5.body()     // Catch:{ Exception -> 0x02bf }
            byte[] r0 = r0.bytes()     // Catch:{ Exception -> 0x02bf }
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x02bf }
            r6.<init>(r0)     // Catch:{ Exception -> 0x02bf }
            java.lang.String r0 = "content-type"
            java.lang.String r10 = "text/plain"
            java.lang.String r0 = r5.header(r0, r10)     // Catch:{ Exception -> 0x02bf }
            java.lang.String r10 = ";"
            java.lang.String[] r0 = r0.split(r10)     // Catch:{ Exception -> 0x02bf }
            r10 = 0
            r11 = r0[r10]     // Catch:{ Exception -> 0x02bd }
            java.lang.String r11 = r11.trim()     // Catch:{ Exception -> 0x02bd }
            int r12 = r0.length     // Catch:{ Exception -> 0x02bd }
            r13 = 1
            if (r12 <= r13) goto L_0x02aa
            r12 = r0[r13]     // Catch:{ Exception -> 0x02bd }
            boolean r12 = r12.contains(r4)     // Catch:{ Exception -> 0x02bd }
            if (r12 == 0) goto L_0x02aa
            r0 = r0[r13]     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = r0.replace(r4, r15)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x02bd }
            goto L_0x02ad
        L_0x02aa:
            java.lang.String r0 = "utf-8"
        L_0x02ad:
            okhttp3.ResponseBody r12 = r5.body()     // Catch:{ Exception -> 0x02bd }
            r12.close()     // Catch:{ Exception -> 0x02bd }
            r5.close()     // Catch:{ Exception -> 0x02bd }
            android.webkit.WebResourceResponse r12 = new android.webkit.WebResourceResponse     // Catch:{ Exception -> 0x02bd }
            r12.<init>(r11, r0, r6)     // Catch:{ Exception -> 0x02bd }
            return r12
        L_0x02bd:
            r0 = move-exception
            goto L_0x02c4
        L_0x02bf:
            r0 = move-exception
            goto L_0x0266
        L_0x02c1:
            r0 = move-exception
            r10 = 0
            r5 = 0
        L_0x02c4:
            if (r5 == 0) goto L_0x02d0
            okhttp3.ResponseBody r6 = r5.body()
            r6.close()
            r5.close()
        L_0x02d0:
            boolean r5 = r0 instanceof javax.net.ssl.SSLHandshakeException
            if (r5 != 0) goto L_0x031b
            r0.printStackTrace()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r5 = "ContentBlockerHandler"
            android.util.Log.e(r5, r0)
            goto L_0x031b
        L_0x02e1:
            r10 = r17
            r5 = 0
            r6 = 0
            goto L_0x0060
        L_0x02e7:
            r10 = 0
            java.lang.String r0 = r0.getSelector()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "(function(d) {    function hide () {        if (!d.getElementById('css-display-none-style')) {            var c = d.createElement('style');            c.id = 'css-display-none-style';            c.innerHTML = '"
            r5.append(r6)
            r5.append(r0)
            java.lang.String r6 = " { display: none !important; }';            d.body.appendChild(c);        }       d.querySelectorAll('"
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = "').forEach(function (item, index) {            item.setAttribute('style', 'display: none !important;');        });    };    hide();    d.addEventListener('DOMContentLoaded', function(event) { hide(); }); })(document);"
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            android.os.Handler r5 = new android.os.Handler
            android.os.Looper r6 = r19.getWebViewLooper()
            r5.<init>(r6)
            com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerHandler$2 r6 = new com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerHandler$2
            r6.<init>(r2, r0)
            r5.post(r6)
        L_0x031b:
            r6 = r10
            r10 = r17
            r5 = 0
            goto L_0x0060
        L_0x0321:
            android.webkit.WebResourceResponse r0 = new android.webkit.WebResourceResponse
            r5 = 0
            r0.<init>(r15, r15, r5)
            return r0
        L_0x0328:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerHandler.checkUrl(com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView, java.lang.String, com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerTriggerResourceType):android.webkit.WebResourceResponse");
    }

    public WebResourceResponse checkUrl(InAppWebView inAppWebView, String str, String str2) {
        return checkUrl(inAppWebView, str, getResourceTypeFromContentType(str2));
    }

    public ContentBlockerTriggerResourceType getResourceTypeFromContentType(String str) {
        return str.equals("text/css") ? ContentBlockerTriggerResourceType.STYLE_SHEET : str.equals("image/svg+xml") ? ContentBlockerTriggerResourceType.SVG_DOCUMENT : str.startsWith("image/") ? ContentBlockerTriggerResourceType.IMAGE : str.startsWith("font/") ? ContentBlockerTriggerResourceType.FONT : (str.startsWith("audio/") || str.startsWith("video/") || str.equals("application/ogg")) ? ContentBlockerTriggerResourceType.MEDIA : str.endsWith("javascript") ? ContentBlockerTriggerResourceType.SCRIPT : str.startsWith("text/") ? ContentBlockerTriggerResourceType.DOCUMENT : ContentBlockerTriggerResourceType.RAW;
    }

    public ContentBlockerTriggerResourceType getResourceTypeFromUrl(String str) {
        ContentBlockerTriggerResourceType contentBlockerTriggerResourceType = ContentBlockerTriggerResourceType.RAW;
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return contentBlockerTriggerResourceType;
        }
        Request.Builder head = new Request.Builder().url(str).head();
        Request build = !(head instanceof Request.Builder) ? head.build() : OkHttp3Instrumentation.build(head);
        Response response = null;
        try {
            OkHttpClient basicOkHttpClient = Util.getBasicOkHttpClient();
            Response execute = FirebasePerfOkHttpClient.execute(!(basicOkHttpClient instanceof OkHttpClient) ? basicOkHttpClient.newCall(build) : OkHttp3Instrumentation.newCall(basicOkHttpClient, build));
            if (execute.header(NetworkLog.CONTENT_TYPE) == null) {
                return contentBlockerTriggerResourceType;
            }
            String[] split = execute.header(NetworkLog.CONTENT_TYPE).split(TypesAliasesKt.separator);
            String trim = split[0].trim();
            if (split.length > 1 && split[1].contains("charset=")) {
                split[1].replace("charset=", "").trim();
            }
            execute.body().close();
            execute.close();
            return getResourceTypeFromContentType(trim);
        } catch (Exception e11) {
            if (response != null) {
                response.body().close();
                response.close();
            }
            if (e11 instanceof SSLHandshakeException) {
                return contentBlockerTriggerResourceType;
            }
            e11.printStackTrace();
            Log.e(LOG_TAG, e11.getMessage());
            return contentBlockerTriggerResourceType;
        }
    }

    public List<ContentBlocker> getRuleList() {
        return this.ruleList;
    }

    public void setRuleList(List<ContentBlocker> list) {
        this.ruleList = list;
    }
}
