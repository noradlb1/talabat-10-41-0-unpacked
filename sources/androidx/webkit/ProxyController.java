package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.webkit.internal.ProxyControllerImpl;
import java.util.concurrent.Executor;

public abstract class ProxyController {

    public static class LAZY_HOLDER {

        /* renamed from: a  reason: collision with root package name */
        public static final ProxyController f37930a = new ProxyControllerImpl();

        private LAZY_HOLDER() {
        }
    }

    @NonNull
    public static ProxyController getInstance() {
        if (WebViewFeature.isFeatureSupported(WebViewFeature.PROXY_OVERRIDE)) {
            return LAZY_HOLDER.f37930a;
        }
        throw new UnsupportedOperationException("Proxy override not supported");
    }

    public abstract void clearProxyOverride(@NonNull Executor executor, @NonNull Runnable runnable);

    public abstract void setProxyOverride(@NonNull ProxyConfig proxyConfig, @NonNull Executor executor, @NonNull Runnable runnable);
}
