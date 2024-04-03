package kotlinx.coroutines.rx2;

import io.reactivex.ObservableEmitter;
import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00028\u00000\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006B\u001d\u0012\u0006\u0010=\u001a\u00020<\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.¢\u0006\u0004\b>\u0010?J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0019\u001a\u00020\u00182\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b \u0010!JX\u0010(\u001a\u00020\u0004\"\u0004\b\u0001\u0010\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010#2\u0006\u0010\u001b\u001a\u00028\u00002(\u0010'\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010&\u0012\u0006\u0012\u0004\u0018\u00010\u00010%H\u0016ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0014¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b-\u0010\u0012R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00107\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R&\u0010;\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006@"}, d2 = {"Lkotlinx/coroutines/rx2/RxObservableCoroutine;", "", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "elem", "", "doLockedNext", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "unlockAndCheckCompleted", "()V", "cause", "", "handled", "doLockedSignalCompleted", "(Ljava/lang/Throwable;Z)V", "signalCompleted", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "handler", "", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "element", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "value", "n", "(Lkotlin/Unit;)V", "m", "Lio/reactivex/ObservableEmitter;", "subscriber", "Lio/reactivex/ObservableEmitter;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "isClosedForSend", "()Z", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/ObservableEmitter;)V", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0})
final class RxObservableCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T>, SelectClause2<T, SendChannel<? super T>> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _signal$FU = AtomicIntegerFieldUpdater.newUpdater(RxObservableCoroutine.class, "_signal");
    @NotNull
    private volatile /* synthetic */ int _signal = 0;
    /* access modifiers changed from: private */
    @NotNull
    public final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);
    @NotNull
    private final ObservableEmitter<T> subscriber;

    public RxObservableCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull ObservableEmitter<T> observableEmitter) {
        super(coroutineContext, false, true);
        this.subscriber = observableEmitter;
    }

    /* access modifiers changed from: private */
    public final Throwable doLockedNext(T t11) {
        if (!isActive()) {
            doLockedSignalCompleted(c(), d());
            return getCancellationException();
        }
        try {
            this.subscriber.onNext(t11);
            unlockAndCheckCompleted();
            return null;
        } catch (Throwable th2) {
            UndeliverableException undeliverableException = new UndeliverableException(th2);
            boolean close = close(undeliverableException);
            unlockAndCheckCompleted();
            if (close) {
                return undeliverableException;
            }
            RxCancellableKt.handleUndeliverableException(undeliverableException, getContext());
            return getCancellationException();
        }
    }

    private final void doLockedSignalCompleted(Throwable th2, boolean z11) {
        CancellationException cancellationException;
        try {
            if (this._signal == -2) {
                Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
                return;
            }
            this._signal = -2;
            if (th2 != null) {
                cancellationException = th2;
            } else {
                cancellationException = null;
            }
            if (cancellationException == null) {
                this.subscriber.onComplete();
            } else if ((cancellationException instanceof UndeliverableException) && !z11) {
                RxCancellableKt.handleUndeliverableException(th2, getContext());
            } else if (cancellationException != getCancellationException() || !this.subscriber.isDisposed()) {
                try {
                    this.subscriber.onError(th2);
                } catch (Exception e11) {
                    ExceptionsKt__ExceptionsKt.addSuppressed(th2, e11);
                    RxCancellableKt.handleUndeliverableException(th2, getContext());
                }
            }
            Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
        } catch (Exception e12) {
            RxCancellableKt.handleUndeliverableException(e12, getContext());
        } catch (Throwable th3) {
            Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
            throw th3;
        }
    }

    private final void signalCompleted(Throwable th2, boolean z11) {
        if (_signal$FU.compareAndSet(this, 0, -1) && Mutex.DefaultImpls.tryLock$default(this.mutex, (Object) null, 1, (Object) null)) {
            doLockedSignalCompleted(th2, z11);
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
        if (!isActive() && Mutex.DefaultImpls.tryLock$default(this.mutex, (Object) null, 1, (Object) null)) {
            doLockedSignalCompleted(c(), d());
        }
    }

    public boolean close(@Nullable Throwable th2) {
        return cancelCoroutine(th2);
    }

    @NotNull
    public SendChannel<T> getChannel() {
        return this;
    }

    @NotNull
    public SelectClause2<T, SendChannel<T>> getOnSend() {
        return this;
    }

    public boolean isClosedForSend() {
        return !isActive();
    }

    public void m(@NotNull Throwable th2, boolean z11) {
        signalCompleted(th2, z11);
    }

    /* renamed from: n */
    public void onCompleted(@NotNull Unit unit) {
        signalCompleted((Throwable) null, false);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(@NotNull T t11) {
        return ProducerScope.DefaultImpls.offer(this, t11);
    }

    public <R> void registerSelectClause2(@NotNull SelectInstance<? super R> selectInstance, @NotNull T t11, @NotNull Function2<? super SendChannel<? super T>, ? super Continuation<? super R>, ? extends Object> function2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new RxObservableCoroutine$registerSelectClause2$1(this, selectInstance, new RxObservableCoroutine$registerSelectClause2$clause$1(this, t11, function2, (Continuation<? super RxObservableCoroutine$registerSelectClause2$clause$1>) null), (Continuation<? super RxObservableCoroutine$registerSelectClause2$1>) null), 1, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object send(@org.jetbrains.annotations.NotNull T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.rx2.RxObservableCoroutine$send$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.rx2.RxObservableCoroutine$send$1 r0 = (kotlinx.coroutines.rx2.RxObservableCoroutine$send$1) r0
            int r1 = r0.f26333l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26333l = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx2.RxObservableCoroutine$send$1 r0 = new kotlinx.coroutines.rx2.RxObservableCoroutine$send$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f26331j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f26333l
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.f26330i
            java.lang.Object r0 = r0.f26329h
            kotlinx.coroutines.rx2.RxObservableCoroutine r0 = (kotlinx.coroutines.rx2.RxObservableCoroutine) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004b
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r4.mutex
            r0.f26329h = r4
            r0.f26330i = r5
            r0.f26333l = r3
            r2 = 0
            java.lang.Object r6 = kotlinx.coroutines.sync.Mutex.DefaultImpls.lock$default(r6, r2, r0, r3, r2)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r0 = r4
        L_0x004b:
            java.lang.Throwable r5 = r0.doLockedNext(r5)
            if (r5 != 0) goto L_0x0054
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0054:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxObservableCoroutine.send(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    public Object m7858trySendJP2dKIU(@NotNull T t11) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, (Object) null, 1, (Object) null)) {
            return ChannelResult.Companion.m7813failurePtdJZtk();
        }
        Throwable doLockedNext = doLockedNext(t11);
        if (doLockedNext == null) {
            return ChannelResult.Companion.m7814successJP2dKIU(Unit.INSTANCE);
        }
        return ChannelResult.Companion.m7812closedJP2dKIU(doLockedNext);
    }

    @NotNull
    public Void invokeOnClose(@NotNull Function1<? super Throwable, Unit> function1) {
        throw new UnsupportedOperationException("RxObservableCoroutine doesn't support invokeOnClose");
    }
}
