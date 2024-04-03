package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.internal.TracingControllerImpl;
import java.io.OutputStream;
import java.util.concurrent.Executor;

public abstract class TracingController {

    public static class LAZY_HOLDER {

        /* renamed from: a  reason: collision with root package name */
        public static final TracingController f37932a = new TracingControllerImpl();

        private LAZY_HOLDER() {
        }
    }

    @NonNull
    public static TracingController getInstance() {
        return LAZY_HOLDER.f37932a;
    }

    public abstract boolean isTracing();

    public abstract void start(@NonNull TracingConfig tracingConfig);

    public abstract boolean stop(@Nullable OutputStream outputStream, @NonNull Executor executor);
}
