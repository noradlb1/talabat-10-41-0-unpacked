package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.Task;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\b\u0014J\u001f\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001b\u001a\u00020\fJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\b\u001dR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", "", "takenState", "", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", "state", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DispatchedTask<T> extends Task {
    @JvmField
    public int resumeMode;

    public DispatchedTask(int i11) {
        this.resumeMode = i11;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object obj, @NotNull Throwable th2) {
    }

    @NotNull
    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object obj) {
        return obj;
    }

    public final void handleFatalException(@Nullable Throwable th2, @Nullable Throwable th3) {
        if (th2 != null || th3 != null) {
            if (!(th2 == null || th3 == null)) {
                ExceptionsKt__ExceptionsKt.addSuppressed(th2, th3);
            }
            if (th2 == null) {
                th2 = th3;
            }
            Intrinsics.checkNotNull(th2);
            CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
        if (r4.clearThreadContext() != false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00aa, code lost:
        if (r4.clearThreadContext() != false) goto L_0x00ac;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            kotlinx.coroutines.scheduling.TaskContext r0 = r10.taskContext
            kotlin.coroutines.Continuation r1 = r10.getDelegate$kotlinx_coroutines_core()     // Catch:{ all -> 0x00b0 }
            kotlinx.coroutines.internal.DispatchedContinuation r1 = (kotlinx.coroutines.internal.DispatchedContinuation) r1     // Catch:{ all -> 0x00b0 }
            kotlin.coroutines.Continuation<T> r2 = r1.continuation     // Catch:{ all -> 0x00b0 }
            java.lang.Object r1 = r1.countOrElement     // Catch:{ all -> 0x00b0 }
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()     // Catch:{ all -> 0x00b0 }
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(r3, r1)     // Catch:{ all -> 0x00b0 }
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS     // Catch:{ all -> 0x00b0 }
            r5 = 0
            if (r1 == r4) goto L_0x001e
            kotlinx.coroutines.UndispatchedCoroutine r4 = kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(r2, r3, r1)     // Catch:{ all -> 0x00b0 }
            goto L_0x001f
        L_0x001e:
            r4 = r5
        L_0x001f:
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()     // Catch:{ all -> 0x00a3 }
            java.lang.Object r7 = r10.takeState$kotlinx_coroutines_core()     // Catch:{ all -> 0x00a3 }
            java.lang.Throwable r8 = r10.getExceptionalResult$kotlinx_coroutines_core(r7)     // Catch:{ all -> 0x00a3 }
            if (r8 != 0) goto L_0x003e
            int r9 = r10.resumeMode     // Catch:{ all -> 0x00a3 }
            boolean r9 = kotlinx.coroutines.DispatchedTaskKt.isCancellableMode(r9)     // Catch:{ all -> 0x00a3 }
            if (r9 == 0) goto L_0x003e
            kotlinx.coroutines.Job$Key r9 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x00a3 }
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r9)     // Catch:{ all -> 0x00a3 }
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6     // Catch:{ all -> 0x00a3 }
            goto L_0x003f
        L_0x003e:
            r6 = r5
        L_0x003f:
            if (r6 == 0) goto L_0x005c
            boolean r9 = r6.isActive()     // Catch:{ all -> 0x00a3 }
            if (r9 != 0) goto L_0x005c
            java.util.concurrent.CancellationException r6 = r6.getCancellationException()     // Catch:{ all -> 0x00a3 }
            r10.cancelCompletedResult$kotlinx_coroutines_core(r7, r6)     // Catch:{ all -> 0x00a3 }
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x00a3 }
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)     // Catch:{ all -> 0x00a3 }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x00a3 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00a3 }
            goto L_0x0079
        L_0x005c:
            if (r8 == 0) goto L_0x006c
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x00a3 }
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r8)     // Catch:{ all -> 0x00a3 }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x00a3 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00a3 }
            goto L_0x0079
        L_0x006c:
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x00a3 }
            java.lang.Object r6 = r10.getSuccessfulResult$kotlinx_coroutines_core(r7)     // Catch:{ all -> 0x00a3 }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x00a3 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00a3 }
        L_0x0079:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a3 }
            if (r4 == 0) goto L_0x0083
            boolean r2 = r4.clearThreadContext()     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x0086
        L_0x0083:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r3, r1)     // Catch:{ all -> 0x00b0 }
        L_0x0086:
            r0.afterTask()     // Catch:{ all -> 0x0090 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0090 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x009b
        L_0x0090:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x009b:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            r10.handleFatalException(r5, r0)
            goto L_0x00cf
        L_0x00a3:
            r2 = move-exception
            if (r4 == 0) goto L_0x00ac
            boolean r4 = r4.clearThreadContext()     // Catch:{ all -> 0x00b0 }
            if (r4 == 0) goto L_0x00af
        L_0x00ac:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r3, r1)     // Catch:{ all -> 0x00b0 }
        L_0x00af:
            throw r2     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x00bd }
            r0.afterTask()     // Catch:{ all -> 0x00bd }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00bd }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x00bd }
            goto L_0x00c8
        L_0x00bd:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x00c8:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            r10.handleFatalException(r1, r0)
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DispatchedTask.run():void");
    }

    @Nullable
    public abstract Object takeState$kotlinx_coroutines_core();
}
