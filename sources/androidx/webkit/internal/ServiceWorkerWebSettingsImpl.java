package androidx.webkit.internal;

import android.webkit.ServiceWorkerWebSettings;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.webkit.ServiceWorkerWebSettingsCompat;
import androidx.webkit.internal.ApiFeature;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Set;
import org.chromium.support_lib_boundary.ServiceWorkerWebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class ServiceWorkerWebSettingsImpl extends ServiceWorkerWebSettingsCompat {
    private ServiceWorkerWebSettingsBoundaryInterface mBoundaryInterface;
    private ServiceWorkerWebSettings mFrameworksImpl;

    public ServiceWorkerWebSettingsImpl(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings) {
        this.mFrameworksImpl = serviceWorkerWebSettings;
    }

    private ServiceWorkerWebSettingsBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = (ServiceWorkerWebSettingsBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ServiceWorkerWebSettingsBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertServiceWorkerSettings(this.mFrameworksImpl));
        }
        return this.mBoundaryInterface;
    }

    @RequiresApi(24)
    private ServiceWorkerWebSettings getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertServiceWorkerSettings(Proxy.getInvocationHandler(this.mBoundaryInterface));
        }
        return this.mFrameworksImpl;
    }

    public boolean getAllowContentAccess() {
        ApiFeature.N n11 = WebViewFeatureInternal.SERVICE_WORKER_CONTENT_ACCESS;
        if (n11.isSupportedByFramework()) {
            return ApiHelperForN.getAllowContentAccess(getFrameworksImpl());
        }
        if (n11.isSupportedByWebView()) {
            return getBoundaryInterface().getAllowContentAccess();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public boolean getAllowFileAccess() {
        ApiFeature.N n11 = WebViewFeatureInternal.SERVICE_WORKER_FILE_ACCESS;
        if (n11.isSupportedByFramework()) {
            return ApiHelperForN.getAllowFileAccess(getFrameworksImpl());
        }
        if (n11.isSupportedByWebView()) {
            return getBoundaryInterface().getAllowFileAccess();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public boolean getBlockNetworkLoads() {
        ApiFeature.N n11 = WebViewFeatureInternal.SERVICE_WORKER_BLOCK_NETWORK_LOADS;
        if (n11.isSupportedByFramework()) {
            return ApiHelperForN.getBlockNetworkLoads(getFrameworksImpl());
        }
        if (n11.isSupportedByWebView()) {
            return getBoundaryInterface().getBlockNetworkLoads();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public int getCacheMode() {
        ApiFeature.N n11 = WebViewFeatureInternal.SERVICE_WORKER_CACHE_MODE;
        if (n11.isSupportedByFramework()) {
            return ApiHelperForN.getCacheMode(getFrameworksImpl());
        }
        if (n11.isSupportedByWebView()) {
            return getBoundaryInterface().getCacheMode();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @NonNull
    public Set<String> getRequestedWithHeaderOriginAllowList() {
        if (WebViewFeatureInternal.REQUESTED_WITH_HEADER_ALLOW_LIST.isSupportedByWebView()) {
            return getBoundaryInterface().getRequestedWithHeaderOriginAllowList();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public void setAllowContentAccess(boolean z11) {
        ApiFeature.N n11 = WebViewFeatureInternal.SERVICE_WORKER_CONTENT_ACCESS;
        if (n11.isSupportedByFramework()) {
            ApiHelperForN.setAllowContentAccess(getFrameworksImpl(), z11);
        } else if (n11.isSupportedByWebView()) {
            getBoundaryInterface().setAllowContentAccess(z11);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void setAllowFileAccess(boolean z11) {
        ApiFeature.N n11 = WebViewFeatureInternal.SERVICE_WORKER_FILE_ACCESS;
        if (n11.isSupportedByFramework()) {
            ApiHelperForN.setAllowFileAccess(getFrameworksImpl(), z11);
        } else if (n11.isSupportedByWebView()) {
            getBoundaryInterface().setAllowFileAccess(z11);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void setBlockNetworkLoads(boolean z11) {
        ApiFeature.N n11 = WebViewFeatureInternal.SERVICE_WORKER_BLOCK_NETWORK_LOADS;
        if (n11.isSupportedByFramework()) {
            ApiHelperForN.setBlockNetworkLoads(getFrameworksImpl(), z11);
        } else if (n11.isSupportedByWebView()) {
            getBoundaryInterface().setBlockNetworkLoads(z11);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void setCacheMode(int i11) {
        ApiFeature.N n11 = WebViewFeatureInternal.SERVICE_WORKER_CACHE_MODE;
        if (n11.isSupportedByFramework()) {
            ApiHelperForN.setCacheMode(getFrameworksImpl(), i11);
        } else if (n11.isSupportedByWebView()) {
            getBoundaryInterface().setCacheMode(i11);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void setRequestedWithHeaderOriginAllowList(@NonNull Set<String> set) {
        if (WebViewFeatureInternal.REQUESTED_WITH_HEADER_ALLOW_LIST.isSupportedByWebView()) {
            getBoundaryInterface().setRequestedWithHeaderOriginAllowList(set);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public ServiceWorkerWebSettingsImpl(@NonNull InvocationHandler invocationHandler) {
        this.mBoundaryInterface = (ServiceWorkerWebSettingsBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ServiceWorkerWebSettingsBoundaryInterface.class, invocationHandler);
    }
}
