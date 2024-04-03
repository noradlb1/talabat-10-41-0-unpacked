package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H'¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/Job;", "getChildJobCancellationCause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@InternalCoroutinesApi
public interface ParentJob extends Job {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(@NotNull ParentJob parentJob, R r11, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return Job.DefaultImpls.fold(parentJob, r11, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull ParentJob parentJob, @NotNull CoroutineContext.Key<E> key) {
            return Job.DefaultImpls.get(parentJob, key);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull ParentJob parentJob, @NotNull CoroutineContext.Key<?> key) {
            return Job.DefaultImpls.minusKey(parentJob, key);
        }

        @NotNull
        public static CoroutineContext plus(@NotNull ParentJob parentJob, @NotNull CoroutineContext coroutineContext) {
            return Job.DefaultImpls.plus((Job) parentJob, coroutineContext);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job plus(@NotNull ParentJob parentJob, @NotNull Job job) {
            return Job.DefaultImpls.plus((Job) parentJob, job);
        }
    }

    @NotNull
    @InternalCoroutinesApi
    CancellationException getChildJobCancellationCause();
}
