package kotlinx.coroutines.rx2;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"handleUndeliverableException", "", "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-rx2"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RxCancellableKt {
    public static final void handleUndeliverableException(@NotNull Throwable th2, @NotNull CoroutineContext coroutineContext) {
        if (!(th2 instanceof CancellationException)) {
            try {
                RxJavaPlugins.onError(th2);
            } catch (Throwable th3) {
                ExceptionsKt__ExceptionsKt.addSuppressed(th2, th3);
                CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, th2);
            }
        }
    }
}
