package androidx.webkit.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;

@RequiresApi(23)
public class ApiHelperForM {
    private ApiHelperForM() {
    }

    @DoNotInline
    public static void close(@NonNull WebMessagePort webMessagePort) {
        webMessagePort.close();
    }

    @DoNotInline
    @NonNull
    public static WebMessage createWebMessage(@NonNull WebMessageCompat webMessageCompat) {
        return new WebMessage(webMessageCompat.getData(), WebMessagePortImpl.compatToPorts(webMessageCompat.getPorts()));
    }

    @DoNotInline
    @NonNull
    public static WebMessagePort[] createWebMessageChannel(@NonNull WebView webView) {
        return webView.createWebMessageChannel();
    }

    @DoNotInline
    @NonNull
    public static WebMessageCompat createWebMessageCompat(@NonNull WebMessage webMessage) {
        return new WebMessageCompat(webMessage.getData(), WebMessagePortImpl.portsToCompat(webMessage.getPorts()));
    }

    @DoNotInline
    @NonNull
    public static CharSequence getDescription(@NonNull WebResourceError webResourceError) {
        return webResourceError.getDescription();
    }

    @DoNotInline
    public static int getErrorCode(@NonNull WebResourceError webResourceError) {
        return webResourceError.getErrorCode();
    }

    @DoNotInline
    public static boolean getOffscreenPreRaster(@NonNull WebSettings webSettings) {
        return webSettings.getOffscreenPreRaster();
    }

    @DoNotInline
    public static void postMessage(@NonNull WebMessagePort webMessagePort, @NonNull WebMessage webMessage) {
        webMessagePort.postMessage(webMessage);
    }

    @DoNotInline
    public static void postVisualStateCallback(@NonNull WebView webView, long j11, @NonNull final WebViewCompat.VisualStateCallback visualStateCallback) {
        webView.postVisualStateCallback(j11, new WebView.VisualStateCallback() {
            public void onComplete(long j11) {
                WebViewCompat.VisualStateCallback.this.onComplete(j11);
            }
        });
    }

    @DoNotInline
    public static void postWebMessage(@NonNull WebView webView, @NonNull WebMessage webMessage, @NonNull Uri uri) {
        webView.postWebMessage(webMessage, uri);
    }

    @DoNotInline
    public static void setOffscreenPreRaster(@NonNull WebSettings webSettings, boolean z11) {
        webSettings.setOffscreenPreRaster(z11);
    }

    @DoNotInline
    public static void setWebMessageCallback(@NonNull WebMessagePort webMessagePort, @NonNull final WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        webMessagePort.setWebMessageCallback(new WebMessagePort.WebMessageCallback() {
            public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
                WebMessagePortCompat.WebMessageCallbackCompat.this.onMessage(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.frameworkMessageToCompat(webMessage));
            }
        });
    }

    @DoNotInline
    public static void setWebMessageCallback(@NonNull WebMessagePort webMessagePort, @NonNull final WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat, @Nullable Handler handler) {
        webMessagePort.setWebMessageCallback(new WebMessagePort.WebMessageCallback() {
            public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
                WebMessagePortCompat.WebMessageCallbackCompat.this.onMessage(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.frameworkMessageToCompat(webMessage));
            }
        }, handler);
    }
}
