package androidx.browser.trusted;

import androidx.annotation.NonNull;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;

class FutureUtils {
    private FutureUtils() {
    }

    @NonNull
    public static <T> ListenableFuture<T> a(@NonNull Throwable th2) {
        ResolvableFuture create = ResolvableFuture.create();
        create.setException(th2);
        return create;
    }
}
