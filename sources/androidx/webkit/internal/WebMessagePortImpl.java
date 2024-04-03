package androidx.webkit.internal;

import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.internal.ApiFeature;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebMessagePortImpl extends WebMessagePortCompat {
    private WebMessagePortBoundaryInterface mBoundaryInterface;
    private WebMessagePort mFrameworksImpl;

    public WebMessagePortImpl(@NonNull WebMessagePort webMessagePort) {
        this.mFrameworksImpl = webMessagePort;
    }

    @RequiresApi(23)
    @NonNull
    public static WebMessage compatToFrameworkMessage(@NonNull WebMessageCompat webMessageCompat) {
        return ApiHelperForM.createWebMessage(webMessageCompat);
    }

    @RequiresApi(23)
    @Nullable
    public static WebMessagePort[] compatToPorts(@Nullable WebMessagePortCompat[] webMessagePortCompatArr) {
        if (webMessagePortCompatArr == null) {
            return null;
        }
        int length = webMessagePortCompatArr.length;
        WebMessagePort[] webMessagePortArr = new WebMessagePort[length];
        for (int i11 = 0; i11 < length; i11++) {
            webMessagePortArr[i11] = webMessagePortCompatArr[i11].getFrameworkPort();
        }
        return webMessagePortArr;
    }

    @RequiresApi(23)
    @NonNull
    public static WebMessageCompat frameworkMessageToCompat(@NonNull WebMessage webMessage) {
        return ApiHelperForM.createWebMessageCompat(webMessage);
    }

    private WebMessagePortBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePortBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(this.mFrameworksImpl));
        }
        return this.mBoundaryInterface;
    }

    @RequiresApi(23)
    private WebMessagePort getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(Proxy.getInvocationHandler(this.mBoundaryInterface));
        }
        return this.mFrameworksImpl;
    }

    @Nullable
    public static WebMessagePortCompat[] portsToCompat(@Nullable WebMessagePort[] webMessagePortArr) {
        if (webMessagePortArr == null) {
            return null;
        }
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[webMessagePortArr.length];
        for (int i11 = 0; i11 < webMessagePortArr.length; i11++) {
            webMessagePortCompatArr[i11] = new WebMessagePortImpl(webMessagePortArr[i11]);
        }
        return webMessagePortCompatArr;
    }

    public void close() {
        ApiFeature.M m11 = WebViewFeatureInternal.WEB_MESSAGE_PORT_CLOSE;
        if (m11.isSupportedByFramework()) {
            ApiHelperForM.close(getFrameworksImpl());
        } else if (m11.isSupportedByWebView()) {
            getBoundaryInterface().close();
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @RequiresApi(23)
    @NonNull
    public WebMessagePort getFrameworkPort() {
        return getFrameworksImpl();
    }

    @NonNull
    public InvocationHandler getInvocationHandler() {
        return Proxy.getInvocationHandler(getBoundaryInterface());
    }

    public void postMessage(@NonNull WebMessageCompat webMessageCompat) {
        ApiFeature.M m11 = WebViewFeatureInternal.WEB_MESSAGE_PORT_POST_MESSAGE;
        if (m11.isSupportedByFramework() && webMessageCompat.getType() == 0) {
            ApiHelperForM.postMessage(getFrameworksImpl(), compatToFrameworkMessage(webMessageCompat));
        } else if (!m11.isSupportedByWebView() || !WebMessageAdapter.isMessagePayloadTypeSupportedByWebView(webMessageCompat.getType())) {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        } else {
            getBoundaryInterface().postMessage(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageAdapter(webMessageCompat)));
        }
    }

    public void setWebMessageCallback(@NonNull WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        ApiFeature.M m11 = WebViewFeatureInternal.WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK;
        if (m11.isSupportedByWebView()) {
            getBoundaryInterface().setWebMessageCallback(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageCallbackAdapter(webMessageCallbackCompat)));
        } else if (m11.isSupportedByFramework()) {
            ApiHelperForM.setWebMessageCallback(getFrameworksImpl(), webMessageCallbackCompat);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public WebMessagePortImpl(@NonNull InvocationHandler invocationHandler) {
        this.mBoundaryInterface = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePortBoundaryInterface.class, invocationHandler);
    }

    public void setWebMessageCallback(@Nullable Handler handler, @NonNull WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        ApiFeature.M m11 = WebViewFeatureInternal.CREATE_WEB_MESSAGE_CHANNEL;
        if (m11.isSupportedByWebView()) {
            getBoundaryInterface().setWebMessageCallback(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageCallbackAdapter(webMessageCallbackCompat)), handler);
        } else if (m11.isSupportedByFramework()) {
            ApiHelperForM.setWebMessageCallback(getFrameworksImpl(), webMessageCallbackCompat, handler);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }
}
