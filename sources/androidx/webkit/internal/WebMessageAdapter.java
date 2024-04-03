package androidx.webkit.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebMessageAdapter implements WebMessageBoundaryInterface {
    private static final String[] sFeatures = {"WEB_MESSAGE_GET_MESSAGE_PAYLOAD"};
    private WebMessageCompat mWebMessageCompat;

    public WebMessageAdapter(@NonNull WebMessageCompat webMessageCompat) {
        this.mWebMessageCompat = webMessageCompat;
    }

    public static boolean isMessagePayloadTypeSupportedByWebView(int i11) {
        if (i11 == 0) {
            return true;
        }
        if (i11 != 1 || !WebViewFeatureInternal.WEB_MESSAGE_GET_MESSAGE_PAYLOAD.isSupportedByWebView()) {
            return false;
        }
        return true;
    }

    @NonNull
    private static WebMessagePortCompat[] toWebMessagePortCompats(InvocationHandler[] invocationHandlerArr) {
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[invocationHandlerArr.length];
        for (int i11 = 0; i11 < invocationHandlerArr.length; i11++) {
            webMessagePortCompatArr[i11] = new WebMessagePortImpl(invocationHandlerArr[i11]);
        }
        return webMessagePortCompatArr;
    }

    @Nullable
    public static WebMessageCompat webMessageCompatFromBoundaryInterface(@NonNull WebMessageBoundaryInterface webMessageBoundaryInterface) {
        WebMessagePortCompat[] webMessagePortCompats = toWebMessagePortCompats(webMessageBoundaryInterface.getPorts());
        if (!WebViewFeatureInternal.WEB_MESSAGE_GET_MESSAGE_PAYLOAD.isSupportedByWebView()) {
            return new WebMessageCompat(webMessageBoundaryInterface.getData(), webMessagePortCompats);
        }
        WebMessagePayloadBoundaryInterface webMessagePayloadBoundaryInterface = (WebMessagePayloadBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePayloadBoundaryInterface.class, webMessageBoundaryInterface.getMessagePayload());
        int type = webMessagePayloadBoundaryInterface.getType();
        if (type == 0) {
            return new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsString(), webMessagePortCompats);
        }
        if (type != 1) {
            return null;
        }
        return new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsArrayBuffer(), webMessagePortCompats);
    }

    @Deprecated
    @Nullable
    public String getData() {
        return this.mWebMessageCompat.getData();
    }

    @RequiresApi(api = 19)
    @Nullable
    public InvocationHandler getMessagePayload() {
        return BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessagePayloadAdapter(this.mWebMessageCompat));
    }

    @Nullable
    public InvocationHandler[] getPorts() {
        WebMessagePortCompat[] ports = this.mWebMessageCompat.getPorts();
        if (ports == null) {
            return null;
        }
        InvocationHandler[] invocationHandlerArr = new InvocationHandler[ports.length];
        for (int i11 = 0; i11 < ports.length; i11++) {
            invocationHandlerArr[i11] = ports[i11].getInvocationHandler();
        }
        return invocationHandlerArr;
    }

    @NonNull
    public String[] getSupportedFeatures() {
        return sFeatures;
    }
}
