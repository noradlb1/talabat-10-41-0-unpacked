package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebViewProviderAdapter {

    /* renamed from: a  reason: collision with root package name */
    public WebViewProviderBoundaryInterface f37944a;

    public WebViewProviderAdapter(@NonNull WebViewProviderBoundaryInterface webViewProviderBoundaryInterface) {
        this.f37944a = webViewProviderBoundaryInterface;
    }

    @NonNull
    public ScriptHandlerImpl addDocumentStartJavaScript(@NonNull String str, @NonNull String[] strArr) {
        return ScriptHandlerImpl.toScriptHandler(this.f37944a.addDocumentStartJavaScript(str, strArr));
    }

    @RequiresApi(19)
    public void addWebMessageListener(@NonNull String str, @NonNull String[] strArr, @NonNull WebViewCompat.WebMessageListener webMessageListener) {
        this.f37944a.addWebMessageListener(str, strArr, BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageListenerAdapter(webMessageListener)));
    }

    @NonNull
    public WebMessagePortCompat[] createWebMessageChannel() {
        InvocationHandler[] createWebMessageChannel = this.f37944a.createWebMessageChannel();
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[createWebMessageChannel.length];
        for (int i11 = 0; i11 < createWebMessageChannel.length; i11++) {
            webMessagePortCompatArr[i11] = new WebMessagePortImpl(createWebMessageChannel[i11]);
        }
        return webMessagePortCompatArr;
    }

    @Nullable
    public WebChromeClient getWebChromeClient() {
        return this.f37944a.getWebChromeClient();
    }

    @NonNull
    public WebViewClient getWebViewClient() {
        return this.f37944a.getWebViewClient();
    }

    @Nullable
    public WebViewRenderProcess getWebViewRenderProcess() {
        return WebViewRenderProcessImpl.forInvocationHandler(this.f37944a.getWebViewRenderer());
    }

    @RequiresApi(19)
    @Nullable
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        InvocationHandler webViewRendererClient = this.f37944a.getWebViewRendererClient();
        if (webViewRendererClient == null) {
            return null;
        }
        return ((WebViewRenderProcessClientAdapter) BoundaryInterfaceReflectionUtil.getDelegateFromInvocationHandler(webViewRendererClient)).getWebViewRenderProcessClient();
    }

    @RequiresApi(19)
    public void insertVisualStateCallback(long j11, @NonNull WebViewCompat.VisualStateCallback visualStateCallback) {
        this.f37944a.insertVisualStateCallback(j11, BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new VisualStateCallbackAdapter(visualStateCallback)));
    }

    @RequiresApi(19)
    public void postWebMessage(@NonNull WebMessageCompat webMessageCompat, @NonNull Uri uri) {
        this.f37944a.postMessageToMainFrame(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageAdapter(webMessageCompat)), uri);
    }

    public void removeWebMessageListener(@NonNull String str) {
        this.f37944a.removeWebMessageListener(str);
    }

    @RequiresApi(19)
    @SuppressLint({"LambdaLast"})
    public void setWebViewRenderProcessClient(@Nullable Executor executor, @Nullable WebViewRenderProcessClient webViewRenderProcessClient) {
        InvocationHandler invocationHandler;
        if (webViewRenderProcessClient != null) {
            invocationHandler = BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebViewRenderProcessClientAdapter(executor, webViewRenderProcessClient));
        } else {
            invocationHandler = null;
        }
        this.f37944a.setWebViewRendererClient(invocationHandler);
    }
}
