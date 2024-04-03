package io.flutter.plugins.webviewflutter;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebView;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import e00.a;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.Objects;

public class CookieManagerHostApiImpl implements GeneratedAndroidWebView.CookieManagerHostApi {
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;
    private final CookieManagerProxy proxy;
    @NonNull
    private final AndroidSdkChecker sdkChecker;

    @VisibleForTesting
    public interface AndroidSdkChecker {
        @ChecksSdkIntAtLeast(parameter = 0)
        boolean sdkIsAtLeast(int i11);
    }

    @VisibleForTesting
    public static class CookieManagerProxy {
        @NonNull
        public CookieManager getInstance() {
            return CookieManager.getInstance();
        }
    }

    public CookieManagerHostApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        this(binaryMessenger2, instanceManager2, new CookieManagerProxy());
    }

    @NonNull
    private CookieManager getCookieManagerInstance(@NonNull Long l11) {
        CookieManager cookieManager = (CookieManager) this.instanceManager.getInstance(l11.longValue());
        Objects.requireNonNull(cookieManager);
        return cookieManager;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(int i11) {
        return Build.VERSION.SDK_INT >= i11;
    }

    private boolean removeCookiesPreL(CookieManager cookieManager) {
        boolean hasCookies = cookieManager.hasCookies();
        if (hasCookies) {
            cookieManager.removeAllCookie();
        }
        return hasCookies;
    }

    public void attachInstance(@NonNull Long l11) {
        this.instanceManager.addDartCreatedInstance(this.proxy.getInstance(), l11.longValue());
    }

    public void removeAllCookies(@NonNull Long l11, @NonNull GeneratedAndroidWebView.Result<Boolean> result) {
        if (this.sdkChecker.sdkIsAtLeast(21)) {
            CookieManager cookieManagerInstance = getCookieManagerInstance(l11);
            Objects.requireNonNull(result);
            cookieManagerInstance.removeAllCookies(new a(result));
            return;
        }
        result.success(Boolean.valueOf(removeCookiesPreL(getCookieManagerInstance(l11))));
    }

    public void setAcceptThirdPartyCookies(@NonNull Long l11, @NonNull Long l12, @NonNull Boolean bool) {
        if (this.sdkChecker.sdkIsAtLeast(21)) {
            CookieManager cookieManagerInstance = getCookieManagerInstance(l11);
            WebView webView = (WebView) this.instanceManager.getInstance(l12.longValue());
            Objects.requireNonNull(webView);
            cookieManagerInstance.setAcceptThirdPartyCookies(webView, bool.booleanValue());
            return;
        }
        throw new UnsupportedOperationException("`setAcceptThirdPartyCookies` is unsupported on versions below `Build.VERSION_CODES.LOLLIPOP`.");
    }

    public void setCookie(@NonNull Long l11, @NonNull String str, @NonNull String str2) {
        getCookieManagerInstance(l11).setCookie(str, str2);
    }

    @VisibleForTesting
    public CookieManagerHostApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2, @NonNull CookieManagerProxy cookieManagerProxy) {
        this(binaryMessenger2, instanceManager2, cookieManagerProxy, new a());
    }

    @VisibleForTesting
    public CookieManagerHostApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2, @NonNull CookieManagerProxy cookieManagerProxy, @NonNull AndroidSdkChecker androidSdkChecker) {
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
        this.proxy = cookieManagerProxy;
        this.sdkChecker = androidSdkChecker;
    }
}
