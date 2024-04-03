package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/CompletableDeferred;", "T", "Lkotlinx/coroutines/Deferred;", "complete", "", "value", "(Ljava/lang/Object;)Z", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CompletableDeferred<T> extends Deferred<T> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T, R> R fold(@NotNull CompletableDeferred<T> completableDeferred, R r11, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return Deferred.DefaultImpls.fold(completableDeferred, r11, function2);
        }

        @Nullable
        public static <T, E extends CoroutineContext.Element> E get(@NotNull CompletableDeferred<T> completableDeferred, @NotNull CoroutineContext.Key<E> key) {
            return Deferred.DefaultImpls.get(completableDeferred, key);
        }

        @NotNull
        public static <T> CoroutineContext minusKey(@NotNull CompletableDeferred<T> completableDeferred, @NotNull CoroutineContext.Key<?> key) {
            return Deferred.DefaultImpls.minusKey(completableDeferred, key);
        }

        @NotNull
        public static <T> CoroutineContext plus(@NotNull CompletableDeferred<T> completableDeferred, @NotNull CoroutineContext coroutineContext) {
            return Deferred.DefaultImpls.plus(completableDeferred, coroutineContext);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static <T> Job plus(@NotNull CompletableDeferred<T> completableDeferred, @NotNull Job job) {
            return Deferred.DefaultImpls.plus(completableDeferred, job);
        }
    }

    boolean complete(T t11);

    boolean completeExceptionally(@NotNull Throwable th2);
}
