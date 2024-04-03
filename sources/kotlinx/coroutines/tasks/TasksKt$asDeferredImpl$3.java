package kotlinx.coroutines.tasks;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001J\u0011\u0010\u001c\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u001fH\u0001J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0018\u00010\"j\u0004\u0018\u0001`#H\u0001J6\u0010$\u001a\u0002H%\"\u0004\b\u0001\u0010%2\u0006\u0010&\u001a\u0002H%2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u0002H%0(H\u0001¢\u0006\u0002\u0010*J(\u0010+\u001a\u0004\u0018\u0001H,\"\b\b\u0001\u0010,*\u00020)2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H,0\rH\u0003¢\u0006\u0002\u0010-J\r\u0010.\u001a\u00060\"j\u0002`#H\u0001J\u000e\u0010/\u001a\u00028\u0000H\u0001¢\u0006\u0002\u00100J\u000b\u00101\u001a\u0004\u0018\u00010!H\u0001JB\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2'\u00106\u001a#\u0012\u0015\u0012\u0013\u0018\u00010!¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u001f07j\u0002`:H\u0001J2\u00102\u001a\u0002032'\u00106\u001a#\u0012\u0015\u0012\u0013\u0018\u00010!¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u001f07j\u0002`:H\u0001J\u0011\u0010;\u001a\u00020\u001fHAø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0015\u0010<\u001a\u00020=2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0001J\u0011\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020=H\u0003J\u0011\u0010>\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0003J\t\u0010A\u001a\u00020\bH\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0012\u0010\n\u001a\u00020\bX\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0012\u0010\u000b\u001a\u00020\bX\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011X\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"kotlinx/coroutines/tasks/TasksKt$asDeferredImpl$3", "Lkotlinx/coroutines/Deferred;", "children", "Lkotlin/sequences/Sequence;", "Lkotlinx/coroutines/Job;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onAwait", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "getCancellationException", "getCompleted", "()Ljava/lang/Object;", "getCompletionExceptionOrNull", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "plus", "context", "other", "start", "kotlinx-coroutines-play-services"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TasksKt$asDeferredImpl$3 implements Deferred<T> {
    private final /* synthetic */ CompletableDeferred<T> $$delegate_0;

    public TasksKt$asDeferredImpl$3(CompletableDeferred<T> completableDeferred) {
        this.$$delegate_0 = completableDeferred;
    }

    @NotNull
    @InternalCoroutinesApi
    public ChildHandle attachChild(@NotNull ChildJob childJob) {
        return this.$$delegate_0.attachChild(childJob);
    }

    @Nullable
    public Object await(@NotNull Continuation<? super T> continuation) {
        return this.$$delegate_0.await(continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        this.$$delegate_0.cancel();
    }

    public void cancel(@Nullable CancellationException cancellationException) {
        this.$$delegate_0.cancel(cancellationException);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable th2) {
        return this.$$delegate_0.cancel(th2);
    }

    public <R> R fold(R r11, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return this.$$delegate_0.fold(r11, function2);
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return this.$$delegate_0.get(key);
    }

    @NotNull
    @InternalCoroutinesApi
    public CancellationException getCancellationException() {
        return this.$$delegate_0.getCancellationException();
    }

    @NotNull
    public Sequence<Job> getChildren() {
        return this.$$delegate_0.getChildren();
    }

    @ExperimentalCoroutinesApi
    public T getCompleted() {
        return this.$$delegate_0.getCompleted();
    }

    @Nullable
    @ExperimentalCoroutinesApi
    public Throwable getCompletionExceptionOrNull() {
        return this.$$delegate_0.getCompletionExceptionOrNull();
    }

    @NotNull
    public CoroutineContext.Key<?> getKey() {
        return this.$$delegate_0.getKey();
    }

    @NotNull
    public SelectClause1<T> getOnAwait() {
        return this.$$delegate_0.getOnAwait();
    }

    @NotNull
    public SelectClause0 getOnJoin() {
        return this.$$delegate_0.getOnJoin();
    }

    @NotNull
    public DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> function1) {
        return this.$$delegate_0.invokeOnCompletion(function1);
    }

    @NotNull
    @InternalCoroutinesApi
    public DisposableHandle invokeOnCompletion(boolean z11, boolean z12, @NotNull Function1<? super Throwable, Unit> function1) {
        return this.$$delegate_0.invokeOnCompletion(z11, z12, function1);
    }

    public boolean isActive() {
        return this.$$delegate_0.isActive();
    }

    public boolean isCancelled() {
        return this.$$delegate_0.isCancelled();
    }

    public boolean isCompleted() {
        return this.$$delegate_0.isCompleted();
    }

    @Nullable
    public Object join(@NotNull Continuation<? super Unit> continuation) {
        return this.$$delegate_0.join(continuation);
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return this.$$delegate_0.minusKey(key);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return this.$$delegate_0.plus(coroutineContext);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job plus(@NotNull Job job) {
        return this.$$delegate_0.plus(job);
    }

    public boolean start() {
        return this.$$delegate_0.start();
    }
}
