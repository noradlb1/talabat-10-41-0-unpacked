package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
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
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.InternalCoroutinesApi;
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
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006B7\u0012\u0006\u0010F\u001a\u000206\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000003\u0012\u0018\u00107\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00030%¢\u0006\u0004\bG\u0010HJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0019\u001a\u00020\u00182\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00030\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010 \u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b \u0010!JX\u0010)\u001a\u00020\u0003\"\u0004\b\u0001\u0010\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010#2\u0006\u0010\u001b\u001a\u00028\u00002(\u0010(\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010&\u0012\u0006\u0012\u0004\u0018\u00010'0%H\u0016ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010,\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003H\u0014¢\u0006\u0004\b,\u00100J\u001f\u00101\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b1\u0010\u0012J\u000f\u00102\u001a\u00020\u0003H\u0016¢\u0006\u0004\b2\u0010\rR\u001a\u00104\u001a\b\u0012\u0004\u0012\u00028\u0000038\bX\u0004¢\u0006\u0006\n\u0004\b4\u00105R&\u00107\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00030%8\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR&\u0010E\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00068VX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lorg/reactivestreams/Subscription;", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "elem", "", "doLockedNext", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "unlockAndCheckCompleted", "()V", "cause", "", "handled", "doLockedSignalCompleted", "(Ljava/lang/Throwable;Z)V", "signalCompleted", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "handler", "", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "element", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "n", "request", "(J)V", "value", "(Lkotlin/Unit;)V", "m", "cancel", "Lorg/reactivestreams/Subscriber;", "subscriber", "Lorg/reactivestreams/Subscriber;", "Lkotlin/coroutines/CoroutineContext;", "exceptionOnCancelHandler", "Lkotlin/jvm/functions/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "cancelled", "Z", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "isClosedForSend", "()Z", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lorg/reactivestreams/Subscriber;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 6, 0})
@InternalCoroutinesApi
public final class PublisherCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T>, Subscription, SelectClause2<T, SendChannel<? super T>> {
    private static final /* synthetic */ AtomicLongFieldUpdater _nRequested$FU = AtomicLongFieldUpdater.newUpdater(PublisherCoroutine.class, "_nRequested");
    @NotNull
    private volatile /* synthetic */ long _nRequested = 0;
    private volatile boolean cancelled;
    @NotNull
    private final Function2<Throwable, CoroutineContext, Unit> exceptionOnCancelHandler;
    /* access modifiers changed from: private */
    @NotNull
    public final Mutex mutex = MutexKt.Mutex(true);
    @NotNull
    private final Subscriber<T> subscriber;

    public PublisherCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Subscriber<T> subscriber2, @NotNull Function2<? super Throwable, ? super CoroutineContext, Unit> function2) {
        super(coroutineContext, false, true);
        this.subscriber = subscriber2;
        this.exceptionOnCancelHandler = function2;
    }

    /* access modifiers changed from: private */
    public final Throwable doLockedNext(T t11) {
        if (t11 == null) {
            unlockAndCheckCompleted();
            throw new NullPointerException("Attempted to emit `null` inside a reactive publisher");
        } else if (!isActive()) {
            unlockAndCheckCompleted();
            return getCancellationException();
        } else {
            try {
                this.subscriber.onNext(t11);
                while (true) {
                    long j11 = this._nRequested;
                    if (j11 < 0 || j11 == Long.MAX_VALUE) {
                        break;
                    }
                    long j12 = j11 - 1;
                    if (_nRequested$FU.compareAndSet(this, j11, j12)) {
                        if (j12 == 0) {
                            return null;
                        }
                    }
                }
                unlockAndCheckCompleted();
                return null;
            } catch (Throwable th2) {
                this.cancelled = true;
                boolean close = close(th2);
                unlockAndCheckCompleted();
                if (close) {
                    return th2;
                }
                this.exceptionOnCancelHandler.invoke(th2, getContext());
                return getCancellationException();
            }
        }
    }

    private final void doLockedSignalCompleted(Throwable th2, boolean z11) {
        try {
            if (this._nRequested != -2) {
                this._nRequested = -2;
                if (!this.cancelled) {
                    if (th2 == null) {
                        this.subscriber.onComplete();
                    } else {
                        try {
                            this.subscriber.onError(th2);
                        } catch (Throwable th3) {
                            if (th3 != th2) {
                                ExceptionsKt__ExceptionsKt.addSuppressed(th2, th3);
                            }
                            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th2);
                        }
                    }
                    Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
                    return;
                } else if (th2 != null && !z11) {
                    this.exceptionOnCancelHandler.invoke(th2, getContext());
                }
            }
            Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
        } catch (Throwable th4) {
            Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
            throw th4;
        }
    }

    private final void signalCompleted(Throwable th2, boolean z11) {
        long j11;
        int i11;
        boolean z12;
        do {
            j11 = this._nRequested;
            if (j11 != -2) {
                i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
                if (i11 >= 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                return;
            }
        } while (!_nRequested$FU.compareAndSet(this, j11, -1));
        if (i11 == 0) {
            doLockedSignalCompleted(th2, z11);
        } else if (Mutex.DefaultImpls.tryLock$default(this.mutex, (Object) null, 1, (Object) null)) {
            doLockedSignalCompleted(th2, z11);
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, (Object) null, 1, (Object) null);
        if (isCompleted() && Mutex.DefaultImpls.tryLock$default(this.mutex, (Object) null, 1, (Object) null)) {
            doLockedSignalCompleted(c(), d());
        }
    }

    public void cancel() {
        this.cancelled = true;
        super.cancel((CancellationException) null);
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
    public boolean offer(T t11) {
        return ProducerScope.DefaultImpls.offer(this, t11);
    }

    public <R> void registerSelectClause2(@NotNull SelectInstance<? super R> selectInstance, T t11, @NotNull Function2<? super SendChannel<? super T>, ? super Continuation<? super R>, ? extends Object> function2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new PublisherCoroutine$registerSelectClause2$1(this, selectInstance, new PublisherCoroutine$registerSelectClause2$clause$1(this, t11, function2, (Continuation<? super PublisherCoroutine$registerSelectClause2$clause$1>) null), (Continuation<? super PublisherCoroutine$registerSelectClause2$1>) null), 1, (Object) null);
    }

    public void request(long j11) {
        long j12;
        int i11;
        long j13;
        if (j11 <= 0) {
            cancelCoroutine(new IllegalArgumentException("non-positive subscription request " + j11));
            return;
        }
        do {
            j12 = this._nRequested;
            i11 = (j12 > 0 ? 1 : (j12 == 0 ? 0 : -1));
            if (i11 >= 0) {
                long j14 = j12 + j11;
                if (j14 < 0 || j11 == Long.MAX_VALUE) {
                    j13 = Long.MAX_VALUE;
                } else {
                    j13 = j14;
                }
                if (j12 == j13) {
                    return;
                }
            } else {
                return;
            }
        } while (!_nRequested$FU.compareAndSet(this, j12, j13));
        if (i11 == 0) {
            unlockAndCheckCompleted();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object send(T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.reactive.PublisherCoroutine$send$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.reactive.PublisherCoroutine$send$1 r0 = (kotlinx.coroutines.reactive.PublisherCoroutine$send$1) r0
            int r1 = r0.f26260l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26260l = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.PublisherCoroutine$send$1 r0 = new kotlinx.coroutines.reactive.PublisherCoroutine$send$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f26258j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f26260l
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.f26257i
            java.lang.Object r0 = r0.f26256h
            kotlinx.coroutines.reactive.PublisherCoroutine r0 = (kotlinx.coroutines.reactive.PublisherCoroutine) r0
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
            r0.f26256h = r4
            r0.f26257i = r5
            r0.f26260l = r3
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.PublisherCoroutine.send(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    public Object m7854trySendJP2dKIU(T t11) {
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
        throw new UnsupportedOperationException("PublisherCoroutine doesn't support invokeOnClose");
    }
}
