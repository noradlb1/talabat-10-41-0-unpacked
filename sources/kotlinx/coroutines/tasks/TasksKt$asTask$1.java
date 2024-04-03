package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TasksKt$asTask$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CancellationTokenSource f26389g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Deferred<T> f26390h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource<T> f26391i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TasksKt$asTask$1(CancellationTokenSource cancellationTokenSource, Deferred<? extends T> deferred, TaskCompletionSource<T> taskCompletionSource) {
        super(1);
        this.f26389g = cancellationTokenSource;
        this.f26390h = deferred;
        this.f26391i = taskCompletionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2) {
        if (th2 instanceof CancellationException) {
            this.f26389g.cancel();
            return;
        }
        Throwable completionExceptionOrNull = this.f26390h.getCompletionExceptionOrNull();
        if (completionExceptionOrNull == null) {
            this.f26391i.setResult(this.f26390h.getCompleted());
            return;
        }
        TaskCompletionSource<T> taskCompletionSource = this.f26391i;
        Exception exc = completionExceptionOrNull instanceof Exception ? (Exception) completionExceptionOrNull : null;
        if (exc == null) {
            exc = new RuntimeExecutionException(completionExceptionOrNull);
        }
        taskCompletionSource.setException(exc);
    }
}
