package kotlinx.coroutines.rx2;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import t00.e;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0007¢\u0006\u0002\b\u0000\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0001\u001aQ\u0010\u0006\u001a\u00020\u0007*\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\f\u001a\u00020\r2,\u0010\u000e\u001a(\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f\u0012\b\u0012\u00060\nj\u0002`\u000b0\u000fH\u0002ø\u0001\u0000*8\b\u0002\u0010\u0013\"\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f2\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lio/reactivex/Scheduler;", "asCoroutineDispatcher0", "Lkotlinx/coroutines/rx2/SchedulerCoroutineDispatcher;", "asScheduler", "scheduleTask", "Lio/reactivex/disposables/Disposable;", "Lkotlinx/coroutines/CoroutineScope;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "delayMillis", "", "adaptForScheduling", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "Task", "kotlinx-coroutines-rx2"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RxSchedulerKt {
    @NotNull
    public static final CoroutineDispatcher asCoroutineDispatcher(@NotNull Scheduler scheduler) {
        if (scheduler instanceof DispatcherScheduler) {
            return ((DispatcherScheduler) scheduler).dispatcher;
        }
        return new SchedulerCoroutineDispatcher(scheduler);
    }

    @NotNull
    public static final Scheduler asScheduler(@NotNull CoroutineDispatcher coroutineDispatcher) {
        if (coroutineDispatcher instanceof SchedulerCoroutineDispatcher) {
            return ((SchedulerCoroutineDispatcher) coroutineDispatcher).getScheduler();
        }
        return new DispatcherScheduler(coroutineDispatcher);
    }

    /* access modifiers changed from: private */
    public static final Disposable scheduleTask(CoroutineScope coroutineScope, Runnable runnable, long j11, Function1<? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? extends Runnable> function1) {
        CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Disposable fromRunnable = Disposables.fromRunnable(new e(objectRef));
        Runnable runnable2 = (Runnable) function1.invoke(new RxSchedulerKt$scheduleTask$toSchedule$1(fromRunnable, coroutineContext, RxJavaPlugins.onSchedule(runnable)));
        if (!CoroutineScopeKt.isActive(coroutineScope)) {
            return Disposables.disposed();
        }
        if (j11 <= 0) {
            runnable2.run();
        } else {
            objectRef.element = DelayKt.getDelay(coroutineContext).invokeOnTimeout(j11, runnable2, coroutineContext);
        }
        return fromRunnable;
    }

    /* access modifiers changed from: private */
    /* renamed from: scheduleTask$lambda-0  reason: not valid java name */
    public static final void m7860scheduleTask$lambda0(Ref.ObjectRef objectRef) {
        DisposableHandle disposableHandle = (DisposableHandle) objectRef.element;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: kotlin.coroutines.CoroutineContext} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object scheduleTask$task(io.reactivex.disposables.Disposable r4, kotlin.coroutines.CoroutineContext r5, java.lang.Runnable r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1 r0 = (kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1) r0
            int r1 = r0.f26336j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26336j = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1 r0 = new kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f26335i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f26336j
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.f26334h
            r5 = r4
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0053 }
            goto L_0x0057
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r4 = r4.isDisposed()
            if (r4 == 0) goto L_0x0042
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0042:
            kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$2 r4 = new kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$2     // Catch:{ all -> 0x0053 }
            r4.<init>(r6)     // Catch:{ all -> 0x0053 }
            r0.f26334h = r5     // Catch:{ all -> 0x0053 }
            r0.f26336j = r3     // Catch:{ all -> 0x0053 }
            r6 = 0
            java.lang.Object r4 = kotlinx.coroutines.InterruptibleKt.runInterruptible$default(r6, r4, r0, r3, r6)     // Catch:{ all -> 0x0053 }
            if (r4 != r1) goto L_0x0057
            return r1
        L_0x0053:
            r4 = move-exception
            kotlinx.coroutines.rx2.RxCancellableKt.handleUndeliverableException(r4, r5)
        L_0x0057:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxSchedulerKt.scheduleTask$task(io.reactivex.disposables.Disposable, kotlin.coroutines.CoroutineContext, java.lang.Runnable, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
