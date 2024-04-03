package androidx.webkit.internal;

import android.os.Looper;
import android.webkit.TracingConfig;
import android.webkit.TracingController;
import android.webkit.WebView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.TracingConfig;
import java.io.OutputStream;
import java.util.concurrent.Executor;

@RequiresApi(28)
public class ApiHelperForP {
    private ApiHelperForP() {
    }

    @DoNotInline
    @NonNull
    public static TracingController getTracingControllerInstance() {
        return TracingController.getInstance();
    }

    @DoNotInline
    @NonNull
    public static ClassLoader getWebViewClassLoader() {
        return WebView.getWebViewClassLoader();
    }

    @DoNotInline
    @NonNull
    public static Looper getWebViewLooper(@NonNull WebView webView) {
        return webView.getWebViewLooper();
    }

    @DoNotInline
    public static boolean isTracing(@NonNull TracingController tracingController) {
        return tracingController.isTracing();
    }

    @DoNotInline
    public static void setDataDirectorySuffix(@NonNull String str) {
        WebView.setDataDirectorySuffix(str);
    }

    @DoNotInline
    public static void start(@NonNull TracingController tracingController, @NonNull TracingConfig tracingConfig) {
        tracingController.start(new TracingConfig.Builder().addCategories(new int[]{tracingConfig.getPredefinedCategories()}).addCategories(tracingConfig.getCustomIncludedCategories()).setTracingMode(tracingConfig.getTracingMode()).build());
    }

    @DoNotInline
    public static boolean stop(@NonNull TracingController tracingController, @Nullable OutputStream outputStream, @NonNull Executor executor) {
        return tracingController.stop(outputStream, executor);
    }
}
