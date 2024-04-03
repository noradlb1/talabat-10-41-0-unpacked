package androidx.webkit.internal;

import android.os.Build;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebViewGlueCommunicator {
    private static final String GLUE_FACTORY_PROVIDER_FETCHER_CLASS = "org.chromium.support_lib_glue.SupportLibReflectionUtil";
    private static final String GLUE_FACTORY_PROVIDER_FETCHER_METHOD = "createWebViewProviderFactory";

    public static class LAZY_COMPAT_CONVERTER_HOLDER {

        /* renamed from: a  reason: collision with root package name */
        public static final WebkitToCompatConverter f37942a = new WebkitToCompatConverter(WebViewGlueCommunicator.getFactory().getWebkitToCompatConverter());

        private LAZY_COMPAT_CONVERTER_HOLDER() {
        }
    }

    public static class LAZY_FACTORY_HOLDER {

        /* renamed from: a  reason: collision with root package name */
        public static final WebViewProviderFactory f37943a = WebViewGlueCommunicator.a();

        private LAZY_FACTORY_HOLDER() {
        }
    }

    private WebViewGlueCommunicator() {
    }

    @NonNull
    public static WebViewProviderFactory a() {
        try {
            return new WebViewProviderFactoryAdapter((WebViewProviderFactoryBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderFactoryBoundaryInterface.class, fetchGlueProviderFactoryImpl()));
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        } catch (ClassNotFoundException unused) {
            return new IncompatibleApkWebViewProviderFactory();
        } catch (NoSuchMethodException e13) {
            throw new RuntimeException(e13);
        }
    }

    private static InvocationHandler fetchGlueProviderFactoryImpl() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        return (InvocationHandler) Class.forName(GLUE_FACTORY_PROVIDER_FETCHER_CLASS, false, getWebViewClassLoader()).getDeclaredMethod(GLUE_FACTORY_PROVIDER_FETCHER_METHOD, new Class[0]).invoke((Object) null, new Object[0]);
    }

    @NonNull
    public static WebkitToCompatConverter getCompatConverter() {
        return LAZY_COMPAT_CONVERTER_HOLDER.f37942a;
    }

    @NonNull
    public static WebViewProviderFactory getFactory() {
        return LAZY_FACTORY_HOLDER.f37943a;
    }

    @NonNull
    public static ClassLoader getWebViewClassLoader() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ApiHelperForP.getWebViewClassLoader();
        }
        return getWebViewProviderFactory().getClass().getClassLoader();
    }

    private static Object getWebViewProviderFactory() {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke((Object) null, new Object[0]);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        } catch (IllegalAccessException e13) {
            throw new RuntimeException(e13);
        }
    }
}
