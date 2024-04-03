package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import e00.g3;
import e00.h3;
import e00.i3;
import e00.j3;
import e00.k3;
import e00.l3;
import e00.m3;
import e00.n3;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.List;
import java.util.Objects;
import v8.f;

public class WebChromeClientHostApiImpl implements GeneratedAndroidWebView.WebChromeClientHostApi {
    private Context context;
    private final WebChromeClientFlutterApiImpl flutterApi;
    private final InstanceManager instanceManager;
    private final WebChromeClientCreator webChromeClientCreator;

    public static class SecureWebChromeClient extends WebChromeClient {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public WebViewClient f14426a;

        @VisibleForTesting
        public boolean a(@NonNull final WebView webView, @NonNull Message message, @Nullable WebView webView2) {
            if (this.f14426a == null) {
                return false;
            }
            AnonymousClass1 r02 = new WebViewClient() {
                @RequiresApi(api = 24)
                public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
                    if (f.a(SecureWebChromeClient.this.f14426a, webView, webResourceRequest)) {
                        return true;
                    }
                    webView.loadUrl(webResourceRequest.getUrl().toString());
                    return true;
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    if (SecureWebChromeClient.this.f14426a.shouldOverrideUrlLoading(webView, str)) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                }
            };
            if (webView2 == null) {
                webView2 = new WebView(webView.getContext());
            }
            webView2.setWebViewClient(r02);
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }

        public boolean onCreateWindow(@NonNull WebView webView, boolean z11, boolean z12, @NonNull Message message) {
            return a(webView, message, new WebView(webView.getContext()));
        }

        public void setWebViewClient(@NonNull WebViewClient webViewClient) {
            this.f14426a = webViewClient;
        }
    }

    public static class WebChromeClientCreator {
        @NonNull
        public WebChromeClientImpl createWebChromeClient(@NonNull WebChromeClientFlutterApiImpl webChromeClientFlutterApiImpl) {
            return new WebChromeClientImpl(webChromeClientFlutterApiImpl);
        }
    }

    public static class WebChromeClientImpl extends SecureWebChromeClient {
        private final WebChromeClientFlutterApiImpl flutterApi;
        private boolean returnValueForOnConsoleMessage = false;
        private boolean returnValueForOnShowFileChooser = false;

        public WebChromeClientImpl(@NonNull WebChromeClientFlutterApiImpl webChromeClientFlutterApiImpl) {
            this.flutterApi = webChromeClientFlutterApiImpl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onConsoleMessage$7(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onGeolocationPermissionsHidePrompt$4(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onGeolocationPermissionsShowPrompt$3(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onHideCustomView$2(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPermissionRequest$6(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onProgressChanged$0(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onShowCustomView$1(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onShowFileChooser$5(boolean z11, ValueCallback valueCallback, List list) {
            if (z11) {
                Uri[] uriArr = new Uri[list.size()];
                for (int i11 = 0; i11 < list.size(); i11++) {
                    uriArr[i11] = Uri.parse((String) list.get(i11));
                }
                valueCallback.onReceiveValue(uriArr);
            }
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            this.flutterApi.onConsoleMessage(this, consoleMessage, new n3());
            return this.returnValueForOnConsoleMessage;
        }

        public void onGeolocationPermissionsHidePrompt() {
            this.flutterApi.onGeolocationPermissionsHidePrompt(this, new h3());
        }

        public void onGeolocationPermissionsShowPrompt(@NonNull String str, @NonNull GeolocationPermissions.Callback callback) {
            this.flutterApi.onGeolocationPermissionsShowPrompt(this, str, callback, new i3());
        }

        public void onHideCustomView() {
            this.flutterApi.onHideCustomView(this, new j3());
        }

        @RequiresApi(api = 21)
        public void onPermissionRequest(@NonNull PermissionRequest permissionRequest) {
            this.flutterApi.onPermissionRequest(this, permissionRequest, new m3());
        }

        public void onProgressChanged(@NonNull WebView webView, int i11) {
            this.flutterApi.onProgressChanged(this, webView, Long.valueOf((long) i11), new k3());
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            this.flutterApi.onShowCustomView(this, view, customViewCallback, new l3());
        }

        @RequiresApi(api = 21)
        public boolean onShowFileChooser(@NonNull WebView webView, @NonNull ValueCallback<Uri[]> valueCallback, @NonNull WebChromeClient.FileChooserParams fileChooserParams) {
            boolean z11 = this.returnValueForOnShowFileChooser;
            this.flutterApi.onShowFileChooser(this, webView, fileChooserParams, new g3(z11, valueCallback));
            return z11;
        }

        public void setReturnValueForOnConsoleMessage(boolean z11) {
            this.returnValueForOnConsoleMessage = z11;
        }

        public void setReturnValueForOnShowFileChooser(boolean z11) {
            this.returnValueForOnShowFileChooser = z11;
        }
    }

    public WebChromeClientHostApiImpl(@NonNull InstanceManager instanceManager2, @NonNull WebChromeClientCreator webChromeClientCreator2, @NonNull WebChromeClientFlutterApiImpl webChromeClientFlutterApiImpl) {
        this.instanceManager = instanceManager2;
        this.webChromeClientCreator = webChromeClientCreator2;
        this.flutterApi = webChromeClientFlutterApiImpl;
    }

    public void create(@NonNull Long l11) {
        this.instanceManager.addDartCreatedInstance(this.webChromeClientCreator.createWebChromeClient(this.flutterApi), l11.longValue());
    }

    public void setSynchronousReturnValueForOnConsoleMessage(@NonNull Long l11, @NonNull Boolean bool) {
        WebChromeClientImpl webChromeClientImpl = (WebChromeClientImpl) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webChromeClientImpl);
        webChromeClientImpl.setReturnValueForOnConsoleMessage(bool.booleanValue());
    }

    public void setSynchronousReturnValueForOnShowFileChooser(@NonNull Long l11, @NonNull Boolean bool) {
        WebChromeClientImpl webChromeClientImpl = (WebChromeClientImpl) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(webChromeClientImpl);
        webChromeClientImpl.setReturnValueForOnShowFileChooser(bool.booleanValue());
    }
}
