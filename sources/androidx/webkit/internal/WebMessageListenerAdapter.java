package androidx.webkit.internal;

import android.net.Uri;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebMessageListenerAdapter implements WebMessageListenerBoundaryInterface {
    private WebViewCompat.WebMessageListener mWebMessageListener;

    public WebMessageListenerAdapter(@NonNull WebViewCompat.WebMessageListener webMessageListener) {
        this.mWebMessageListener = webMessageListener;
    }

    @NonNull
    public String[] getSupportedFeatures() {
        return new String[]{"WEB_MESSAGE_LISTENER"};
    }

    public void onPostMessage(@NonNull WebView webView, @NonNull InvocationHandler invocationHandler, @NonNull Uri uri, boolean z11, @NonNull InvocationHandler invocationHandler2) {
        WebMessageCompat webMessageCompatFromBoundaryInterface = WebMessageAdapter.webMessageCompatFromBoundaryInterface((WebMessageBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessageBoundaryInterface.class, invocationHandler));
        if (webMessageCompatFromBoundaryInterface != null) {
            this.mWebMessageListener.onPostMessage(webView, webMessageCompatFromBoundaryInterface, uri, z11, JavaScriptReplyProxyImpl.forInvocationHandler(invocationHandler2));
        }
    }
}
