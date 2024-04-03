package com.pichillilorenzo.flutter_inappwebview.in_app_webview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.CookieManager;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.pichillilorenzo.flutter_inappwebview.Util;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate;
import com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.JavaScriptBridgeJS;
import com.pichillilorenzo.flutter_inappwebview.types.ClientCertChallenge;
import com.pichillilorenzo.flutter_inappwebview.types.NavigationAction;
import com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy;
import com.pichillilorenzo.flutter_inappwebview.types.ServerTrustChallenge;
import com.pichillilorenzo.flutter_inappwebview.types.URLCredential;
import com.pichillilorenzo.flutter_inappwebview.types.URLProtectionSpace;
import com.pichillilorenzo.flutter_inappwebview.types.URLRequest;
import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class InAppWebViewClient extends WebViewClient {
    protected static final String LOG_TAG = "IAWebViewClient";
    /* access modifiers changed from: private */
    public static List<URLCredential> credentialsProposed;
    /* access modifiers changed from: private */
    public static int previousAuthRequestFailureCount;
    private final MethodChannel channel;
    private InAppBrowserDelegate inAppBrowserDelegate;

    /* renamed from: com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewClient$7  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$NavigationActionPolicy;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy[] r0 = com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$NavigationActionPolicy = r0
                com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy r1 = com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy.ALLOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$NavigationActionPolicy     // Catch:{ NoSuchFieldError -> 0x001d }
                com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy r1 = com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy.CANCEL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewClient.AnonymousClass7.<clinit>():void");
        }
    }

    public InAppWebViewClient(MethodChannel methodChannel, InAppBrowserDelegate inAppBrowserDelegate2) {
        this.channel = methodChannel;
        this.inAppBrowserDelegate = inAppBrowserDelegate2;
    }

    /* access modifiers changed from: private */
    public void allowShouldOverrideUrlLoading(WebView webView, String str, Map<String, String> map, boolean z11) {
        if (z11) {
            webView.loadUrl(str, map);
        }
    }

    public void dispose() {
        if (this.inAppBrowserDelegate != null) {
            this.inAppBrowserDelegate = null;
        }
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z11) {
        super.doUpdateVisitedHistory(webView, str, z11);
        String url = webView.getUrl();
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.didUpdateVisitedHistory(url);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", url);
        hashMap.put("androidIsReload", Boolean.valueOf(z11));
        this.channel.invokeMethod("onUpdateVisitedHistory", hashMap);
    }

    public void loadCustomJavaScriptOnPageFinished(WebView webView) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        inAppWebView.evaluateJavascript(inAppWebView.userContentController.generateWrappedCodeForDocumentEnd(), (ValueCallback) null);
    }

    public void loadCustomJavaScriptOnPageStarted(WebView webView) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        inAppWebView.evaluateJavascript(inAppWebView.userContentController.generateWrappedCodeForDocumentStart(), (ValueCallback) null);
    }

    public void onFormResubmission(final WebView webView, final Message message, final Message message2) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", webView.getUrl());
        this.channel.invokeMethod("onFormResubmission", hashMap, new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                Log.e(InAppWebViewClient.LOG_TAG, "ERROR: " + str + " " + str2);
            }

            public void notImplemented() {
                InAppWebViewClient.super.onFormResubmission(webView, message, message2);
            }

            public void success(Object obj) {
                Integer num;
                if (obj == null || (num = (Integer) ((Map) obj).get(NativeProtocol.WEB_DIALOG_ACTION)) == null) {
                    InAppWebViewClient.super.onFormResubmission(webView, message, message2);
                } else if (num.intValue() != 0) {
                    message.sendToTarget();
                } else {
                    message2.sendToTarget();
                }
            }
        });
    }

    public void onPageCommitVisible(WebView webView, String str) {
        super.onPageCommitVisible(webView, str);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        this.channel.invokeMethod("onPageCommitVisible", hashMap);
    }

    public void onPageFinished(WebView webView, String str) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        inAppWebView.isLoading = false;
        loadCustomJavaScriptOnPageFinished(inAppWebView);
        previousAuthRequestFailureCount = 0;
        credentialsProposed = null;
        super.onPageFinished(webView, str);
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.didFinishNavigation(str);
        }
        CookieManager.getInstance().flush();
        inAppWebView.evaluateJavascript(JavaScriptBridgeJS.PLATFORM_READY_JS_SOURCE, (ValueCallback) null);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        this.channel.invokeMethod("onLoadStop", hashMap);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        inAppWebView.isLoading = true;
        inAppWebView.disposeWebMessageChannels();
        inAppWebView.userContentController.resetContentWorlds();
        loadCustomJavaScriptOnPageStarted(inAppWebView);
        super.onPageStarted(webView, str, bitmap);
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.didStartNavigation(str);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        this.channel.invokeMethod("onLoadStart", hashMap);
    }

    public void onReceivedClientCertRequest(final WebView webView, final ClientCertRequest clientCertRequest) {
        String str;
        String url = webView.getUrl();
        String host = clientCertRequest.getHost();
        int port = clientCertRequest.getPort();
        if (url != null) {
            try {
                str = new URI(url).getScheme();
            } catch (URISyntaxException e11) {
                e11.printStackTrace();
            }
            this.channel.invokeMethod("onReceivedClientCertRequest", new ClientCertChallenge(new URLProtectionSpace(host, str, (String) null, port, webView.getCertificate(), (SslError) null), clientCertRequest.getPrincipals(), clientCertRequest.getKeyTypes()).toMap(), new MethodChannel.Result() {
                public void error(String str, String str2, Object obj) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    if (str2 == null) {
                        str2 = "";
                    }
                    sb2.append(str2);
                    Log.e(InAppWebViewClient.LOG_TAG, sb2.toString());
                }

                public void notImplemented() {
                    InAppWebViewClient.super.onReceivedClientCertRequest(webView, clientCertRequest);
                }

                public void success(Object obj) {
                    if (obj != null) {
                        Map map = (Map) obj;
                        Integer num = (Integer) map.get(NativeProtocol.WEB_DIALOG_ACTION);
                        if (num != null) {
                            int intValue = num.intValue();
                            if (intValue == 1) {
                                Util.PrivateKeyAndCertificates loadPrivateKeyAndCertificate = Util.loadPrivateKeyAndCertificate(((InAppWebView) webView).plugin, (String) map.get("certificatePath"), (String) map.get("certificatePassword"), (String) map.get("androidKeyStoreType"));
                                clientCertRequest.proceed(loadPrivateKeyAndCertificate.privateKey, loadPrivateKeyAndCertificate.certificates);
                                return;
                            } else if (intValue != 2) {
                                clientCertRequest.cancel();
                                return;
                            } else {
                                clientCertRequest.ignore();
                                return;
                            }
                        }
                    }
                    InAppWebViewClient.super.onReceivedClientCertRequest(webView, clientCertRequest);
                }
            });
        }
        str = "https";
        this.channel.invokeMethod("onReceivedClientCertRequest", new ClientCertChallenge(new URLProtectionSpace(host, str, (String) null, port, webView.getCertificate(), (SslError) null), clientCertRequest.getPrincipals(), clientCertRequest.getKeyTypes()).toMap(), new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                Log.e(InAppWebViewClient.LOG_TAG, sb2.toString());
            }

            public void notImplemented() {
                InAppWebViewClient.super.onReceivedClientCertRequest(webView, clientCertRequest);
            }

            public void success(Object obj) {
                if (obj != null) {
                    Map map = (Map) obj;
                    Integer num = (Integer) map.get(NativeProtocol.WEB_DIALOG_ACTION);
                    if (num != null) {
                        int intValue = num.intValue();
                        if (intValue == 1) {
                            Util.PrivateKeyAndCertificates loadPrivateKeyAndCertificate = Util.loadPrivateKeyAndCertificate(((InAppWebView) webView).plugin, (String) map.get("certificatePath"), (String) map.get("certificatePassword"), (String) map.get("androidKeyStoreType"));
                            clientCertRequest.proceed(loadPrivateKeyAndCertificate.privateKey, loadPrivateKeyAndCertificate.certificates);
                            return;
                        } else if (intValue != 2) {
                            clientCertRequest.cancel();
                            return;
                        } else {
                            clientCertRequest.ignore();
                            return;
                        }
                    }
                }
                InAppWebViewClient.super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        });
    }

    public void onReceivedError(WebView webView, int i11, String str, String str2) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (inAppWebView.options.disableDefaultErrorPage.booleanValue()) {
            inAppWebView.stopLoading();
            inAppWebView.loadUrl("about:blank");
        }
        inAppWebView.isLoading = false;
        previousAuthRequestFailureCount = 0;
        credentialsProposed = null;
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.didFailNavigation(str2, i11, str);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str2);
        hashMap.put(Constant.PARAM_ERROR_CODE, Integer.valueOf(i11));
        hashMap.put("message", str);
        this.channel.invokeMethod("onLoadError", hashMap);
        super.onReceivedError(webView, i11, str, str2);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceivedHttpAuthRequest(android.webkit.WebView r16, android.webkit.HttpAuthHandler r17, java.lang.String r18, java.lang.String r19) {
        /*
            r15 = this;
            java.lang.String r0 = r16.getUrl()
            java.lang.String r1 = "https"
            r2 = 0
            if (r0 == 0) goto L_0x001b
            java.net.URI r3 = new java.net.URI     // Catch:{ URISyntaxException -> 0x0017 }
            r3.<init>(r0)     // Catch:{ URISyntaxException -> 0x0017 }
            java.lang.String r1 = r3.getScheme()     // Catch:{ URISyntaxException -> 0x0017 }
            int r0 = r3.getPort()     // Catch:{ URISyntaxException -> 0x0017 }
            goto L_0x001c
        L_0x0017:
            r0 = move-exception
            r0.printStackTrace()
        L_0x001b:
            r0 = r2
        L_0x001c:
            int r3 = previousAuthRequestFailureCount
            int r3 = r3 + 1
            previousAuthRequestFailureCount = r3
            java.util.List<com.pichillilorenzo.flutter_inappwebview.types.URLCredential> r3 = credentialsProposed
            if (r3 != 0) goto L_0x003d
            android.content.Context r3 = r16.getContext()
            com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase r3 = com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase.getInstance(r3)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r10 = r18
            r11 = r19
            java.util.List r3 = r3.getHttpAuthCredentials(r10, r1, r11, r4)
            credentialsProposed = r3
            goto L_0x0041
        L_0x003d:
            r10 = r18
            r11 = r19
        L_0x0041:
            java.util.List<com.pichillilorenzo.flutter_inappwebview.types.URLCredential> r3 = credentialsProposed
            if (r3 == 0) goto L_0x0054
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0054
            java.util.List<com.pichillilorenzo.flutter_inappwebview.types.URLCredential> r3 = credentialsProposed
            java.lang.Object r2 = r3.get(r2)
            com.pichillilorenzo.flutter_inappwebview.types.URLCredential r2 = (com.pichillilorenzo.flutter_inappwebview.types.URLCredential) r2
            goto L_0x0055
        L_0x0054:
            r2 = 0
        L_0x0055:
            com.pichillilorenzo.flutter_inappwebview.types.URLProtectionSpace r12 = new com.pichillilorenzo.flutter_inappwebview.types.URLProtectionSpace
            android.net.http.SslCertificate r8 = r16.getCertificate()
            r9 = 0
            r3 = r12
            r4 = r18
            r5 = r1
            r6 = r19
            r7 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            com.pichillilorenzo.flutter_inappwebview.types.HttpAuthenticationChallenge r3 = new com.pichillilorenzo.flutter_inappwebview.types.HttpAuthenticationChallenge
            int r4 = previousAuthRequestFailureCount
            r3.<init>(r12, r4, r2)
            r2 = r15
            io.flutter.plugin.common.MethodChannel r12 = r2.channel
            java.util.Map r13 = r3.toMap()
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewClient$2 r14 = new com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewClient$2
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r18
            r7 = r1
            r8 = r19
            r9 = r0
            r10 = r17
            r3.<init>(r5, r6, r7, r8, r9, r10)
            java.lang.String r0 = "onReceivedHttpAuthRequest"
            r12.invokeMethod(r0, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewClient.onReceivedHttpAuthRequest(android.webkit.WebView, android.webkit.HttpAuthHandler, java.lang.String, java.lang.String):void");
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webResourceRequest.isForMainFrame()) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", webResourceRequest.getUrl().toString());
            hashMap.put("statusCode", Integer.valueOf(webResourceResponse.getStatusCode()));
            hashMap.put("description", webResourceResponse.getReasonPhrase());
            this.channel.invokeMethod("onLoadHttpError", hashMap);
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM, str);
        hashMap.put("account", str2);
        hashMap.put(StepData.ARGS, str3);
        this.channel.invokeMethod("onReceivedLoginRequest", hashMap);
    }

    public void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
        int i11;
        String str = "";
        String str2 = "https";
        try {
            URI uri = new URI(sslError.getUrl());
            str = uri.getHost();
            str2 = uri.getScheme();
            i11 = uri.getPort();
        } catch (URISyntaxException e11) {
            e11.printStackTrace();
            i11 = 0;
        }
        this.channel.invokeMethod("onReceivedServerTrustAuthRequest", new ServerTrustChallenge(new URLProtectionSpace(str, str2, (String) null, i11, sslError.getCertificate(), sslError)).toMap(), new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                Log.e(InAppWebViewClient.LOG_TAG, sb2.toString());
            }

            public void notImplemented() {
                InAppWebViewClient.super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            public void success(Object obj) {
                Integer num;
                if (obj == null || (num = (Integer) ((Map) obj).get(NativeProtocol.WEB_DIALOG_ACTION)) == null) {
                    InAppWebViewClient.super.onReceivedSslError(webView, sslErrorHandler, sslError);
                } else if (num.intValue() != 1) {
                    sslErrorHandler.cancel();
                } else {
                    sslErrorHandler.proceed();
                }
            }
        });
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (!((InAppWebView) webView).options.useOnRenderProcessGone.booleanValue()) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        Boolean valueOf = Boolean.valueOf(renderProcessGoneDetail.didCrash());
        Integer valueOf2 = Integer.valueOf(renderProcessGoneDetail.rendererPriorityAtExit());
        HashMap hashMap = new HashMap();
        hashMap.put("didCrash", valueOf);
        hashMap.put("rendererPriorityAtExit", valueOf2);
        this.channel.invokeMethod("onRenderProcessGone", hashMap);
        return true;
    }

    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i11, SafeBrowsingResponse safeBrowsingResponse) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", webResourceRequest.getUrl().toString());
        hashMap.put("threatType", Integer.valueOf(i11));
        final SafeBrowsingResponse safeBrowsingResponse2 = safeBrowsingResponse;
        final WebView webView2 = webView;
        final WebResourceRequest webResourceRequest2 = webResourceRequest;
        final int i12 = i11;
        this.channel.invokeMethod("onSafeBrowsingHit", hashMap, new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                Log.e(InAppWebViewClient.LOG_TAG, sb2.toString());
            }

            public void notImplemented() {
                InAppWebViewClient.super.onSafeBrowsingHit(webView2, webResourceRequest2, i12, safeBrowsingResponse2);
            }

            public void success(Object obj) {
                if (obj != null) {
                    Map map = (Map) obj;
                    Boolean bool = (Boolean) map.get("report");
                    Integer num = (Integer) map.get(NativeProtocol.WEB_DIALOG_ACTION);
                    Boolean valueOf = Boolean.valueOf(bool != null ? bool.booleanValue() : true);
                    if (num != null) {
                        int intValue = num.intValue();
                        if (intValue == 0) {
                            safeBrowsingResponse2.backToSafety(valueOf.booleanValue());
                            return;
                        } else if (intValue != 1) {
                            safeBrowsingResponse2.showInterstitial(valueOf.booleanValue());
                            return;
                        } else {
                            safeBrowsingResponse2.proceed(valueOf.booleanValue());
                            return;
                        }
                    }
                }
                InAppWebViewClient.super.onSafeBrowsingHit(webView2, webResourceRequest2, i12, safeBrowsingResponse2);
            }
        });
    }

    public void onScaleChanged(WebView webView, float f11, float f12) {
        super.onScaleChanged(webView, f11, f12);
        InAppWebView inAppWebView = (InAppWebView) webView;
        inAppWebView.zoomScale = f12 / Util.getPixelDensity(inAppWebView.getContext());
        HashMap hashMap = new HashMap();
        hashMap.put("oldScale", Float.valueOf(f11));
        hashMap.put("newScale", Float.valueOf(f12));
        this.channel.invokeMethod("onZoomScaleChanged", hashMap);
    }

    public WebResourceResponse onShouldInterceptRequest(Object obj) {
        boolean z11;
        boolean z12;
        Map<String, String> map;
        ByteArrayInputStream byteArrayInputStream = null;
        String str = obj instanceof String ? (String) obj : null;
        int i11 = Build.VERSION.SDK_INT;
        boolean z13 = false;
        if (obj instanceof WebResourceRequest) {
            WebResourceRequest webResourceRequest = (WebResourceRequest) obj;
            str = webResourceRequest.getUrl().toString();
            map = webResourceRequest.getRequestHeaders();
            z12 = webResourceRequest.hasGesture();
            z11 = webResourceRequest.isForMainFrame();
            if (i11 >= 24) {
                z13 = webResourceRequest.isRedirect();
            }
        } else {
            z11 = true;
            map = null;
            z12 = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("method", "GET");
        hashMap.put(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS, map);
        hashMap.put("isForMainFrame", Boolean.valueOf(z11));
        hashMap.put("hasGesture", Boolean.valueOf(z12));
        hashMap.put("isRedirect", Boolean.valueOf(z13));
        try {
            Util.WaitFlutterResult invokeMethodAndWait = Util.invokeMethodAndWait(this.channel, "shouldInterceptRequest", hashMap);
            String str2 = invokeMethodAndWait.error;
            if (str2 != null) {
                Log.e(LOG_TAG, str2);
            } else {
                Object obj2 = invokeMethodAndWait.result;
                if (obj2 != null) {
                    Map map2 = (Map) obj2;
                    String str3 = (String) map2.get(AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
                    String str4 = (String) map2.get("contentEncoding");
                    byte[] bArr = (byte[]) map2.get("data");
                    Map map3 = (Map) map2.get(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS);
                    Integer num = (Integer) map2.get("statusCode");
                    String str5 = (String) map2.get("reasonPhrase");
                    if (bArr != null) {
                        byteArrayInputStream = new ByteArrayInputStream(bArr);
                    }
                    ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                    return (map3 == null && num == null && str5 == null) ? new WebResourceResponse(str3, str4, byteArrayInputStream2) : new WebResourceResponse(str3, str4, num.intValue(), str5, map3, byteArrayInputStream2);
                }
            }
            return null;
        } catch (InterruptedException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public void onShouldOverrideUrlLoading(InAppWebView inAppWebView, String str, String str2, Map<String, String> map, boolean z11, boolean z12, boolean z13) {
        final InAppWebView inAppWebView2 = inAppWebView;
        final String str3 = str;
        final Map<String, String> map2 = map;
        final boolean z14 = z11;
        this.channel.invokeMethod("shouldOverrideUrlLoading", new NavigationAction(new URLRequest(str, str2, (byte[]) null, map), z11, z12, z13).toMap(), new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                Log.e(InAppWebViewClient.LOG_TAG, sb2.toString());
                InAppWebViewClient.this.allowShouldOverrideUrlLoading(inAppWebView2, str3, map2, z14);
            }

            public void notImplemented() {
                InAppWebViewClient.this.allowShouldOverrideUrlLoading(inAppWebView2, str3, map2, z14);
            }

            public void success(Object obj) {
                if (obj != null) {
                    Integer num = (Integer) ((Map) obj).get(NativeProtocol.WEB_DIALOG_ACTION);
                    NavigationActionPolicy fromValue = NavigationActionPolicy.fromValue(Integer.valueOf(num != null ? num.intValue() : NavigationActionPolicy.CANCEL.rawValue()).intValue());
                    if (fromValue == null || AnonymousClass7.$SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$NavigationActionPolicy[fromValue.ordinal()] != 1) {
                        return;
                    }
                }
                InAppWebViewClient.this.allowShouldOverrideUrlLoading(inAppWebView2, str3, map2, z14);
            }
        });
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return ((InAppWebView) webView).options.useShouldInterceptRequest.booleanValue() ? onShouldInterceptRequest(webResourceRequest) : shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        URI uri;
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (inAppWebView.options.useShouldInterceptRequest.booleanValue()) {
            return onShouldInterceptRequest(str);
        }
        WebResourceResponse webResourceResponse = null;
        try {
            uri = new URI(str);
        } catch (URISyntaxException unused) {
            String str2 = str.split(CertificateUtil.DELIMITER)[0];
            try {
                URL url = new URL(str.replace(str2, "https"));
                uri = new URI(str2, url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        }
        String scheme = uri.getScheme();
        List<String> list = inAppWebView.options.resourceCustomSchemes;
        if (list != null && list.contains(scheme)) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            try {
                Util.WaitFlutterResult invokeMethodAndWait = Util.invokeMethodAndWait(this.channel, "onLoadResourceCustomScheme", hashMap);
                String str3 = invokeMethodAndWait.error;
                if (str3 != null) {
                    Log.e(LOG_TAG, str3);
                } else {
                    Object obj = invokeMethodAndWait.result;
                    if (obj != null) {
                        Map map = (Map) obj;
                        try {
                            webResourceResponse = inAppWebView.contentBlockerHandler.checkUrl(inAppWebView, str, map.get(AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE).toString());
                        } catch (Exception e12) {
                            e12.printStackTrace();
                        }
                        return webResourceResponse != null ? webResourceResponse : new WebResourceResponse(map.get(AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE).toString(), map.get("contentEncoding").toString(), new ByteArrayInputStream((byte[]) map.get("data")));
                    }
                }
            } catch (InterruptedException e13) {
                e13.printStackTrace();
                return null;
            }
        }
        if (inAppWebView.contentBlockerHandler.getRuleList().size() <= 0) {
            return null;
        }
        try {
            return inAppWebView.contentBlockerHandler.checkUrl(inAppWebView, str);
        } catch (Exception e14) {
            e14.printStackTrace();
            return null;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (!inAppWebView.options.useShouldOverrideUrlLoading.booleanValue()) {
            return false;
        }
        onShouldOverrideUrlLoading(inAppWebView, webResourceRequest.getUrl().toString(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders(), webResourceRequest.isForMainFrame(), webResourceRequest.hasGesture(), Build.VERSION.SDK_INT >= 24 ? webResourceRequest.isRedirect() : false);
        if (inAppWebView.regexToCancelSubFramesLoadingCompiled == null) {
            return webResourceRequest.isForMainFrame();
        }
        if (webResourceRequest.isForMainFrame()) {
            return true;
        }
        return inAppWebView.regexToCancelSubFramesLoadingCompiled.matcher(webResourceRequest.getUrl().toString()).matches();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (!inAppWebView.options.useShouldOverrideUrlLoading.booleanValue()) {
            return false;
        }
        onShouldOverrideUrlLoading(inAppWebView, str, "GET", (Map<String, String>) null, true, false, false);
        return true;
    }
}
