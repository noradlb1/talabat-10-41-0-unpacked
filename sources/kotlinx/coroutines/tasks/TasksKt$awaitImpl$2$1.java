package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u0001H\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "it", "Lcom/google/android/gms/tasks/Task;", "kotlin.jvm.PlatformType", "onComplete"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TasksKt$awaitImpl$2$1<TResult> implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<T> f26392b;

    public TasksKt$awaitImpl$2$1(CancellableContinuation<? super T> cancellableContinuation) {
        this.f26392b = cancellableContinuation;
    }

    public final void onComplete(@NotNull Task<T> task) {
        Exception exception = task.getException();
        if (exception != null) {
            CancellableContinuation<T> cancellableContinuation = this.f26392b;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(exception)));
        } else if (task.isCanceled()) {
            CancellableContinuation.DefaultImpls.cancel$default(this.f26392b, (Throwable) null, 1, (Object) null);
        } else {
            CancellableContinuation<T> cancellableContinuation2 = this.f26392b;
            Result.Companion companion2 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m6329constructorimpl(task.getResult()));
        }
    }
}
