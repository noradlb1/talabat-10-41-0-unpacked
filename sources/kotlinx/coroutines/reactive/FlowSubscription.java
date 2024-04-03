package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u001d2\b\u0012\u0004\u0012\u00020\n0\u001eB-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u001c\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/reactive/FlowSubscription;", "T", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lorg/reactivestreams/Subscriber;", "subscriber", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lorg/reactivestreams/Subscriber;Lkotlin/coroutines/CoroutineContext;)V", "", "cancel", "()V", "consumeFlow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "createInitialContinuation", "()Lkotlin/coroutines/Continuation;", "flowProcessing", "", "n", "request", "(J)V", "", "cancellationRequested", "Z", "Lkotlinx/coroutines/flow/Flow;", "Lorg/reactivestreams/Subscriber;", "kotlinx-coroutines-reactive", "Lorg/reactivestreams/Subscription;", "Lkotlinx/coroutines/AbstractCoroutine;"}, k = 1, mv = {1, 6, 0}, xi = 48)
@InternalCoroutinesApi
public final class FlowSubscription<T> extends AbstractCoroutine<Unit> implements Subscription {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f26228b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26229c;
    private volatile boolean cancellationRequested;
    @NotNull
    @JvmField
    public final Flow<T> flow;
    @NotNull
    volatile /* synthetic */ Object producer = createInitialContinuation();
    @NotNull
    volatile /* synthetic */ long requested = 0;
    @NotNull
    @JvmField
    public final Subscriber<? super T> subscriber;

    static {
        Class<FlowSubscription> cls = FlowSubscription.class;
        f26228b = AtomicLongFieldUpdater.newUpdater(cls, "requested");
        f26229c = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "producer");
    }

    public FlowSubscription(@NotNull Flow<? extends T> flow2, @NotNull Subscriber<? super T> subscriber2, @NotNull CoroutineContext coroutineContext) {
        super(coroutineContext, false, true);
        this.flow = flow2;
        this.subscriber = subscriber2;
    }

    /* access modifiers changed from: private */
    public final Object consumeFlow(Continuation<? super Unit> continuation) {
        Object collect = this.flow.collect(new FlowSubscription$consumeFlow$2(this), continuation);
        return collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    private final Continuation<Unit> createInitialContinuation() {
        return new FlowSubscription$createInitialContinuation$$inlined$Continuation$1(getCoroutineContext(), this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object flowProcessing(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1 r0 = (kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1) r0
            int r1 = r0.f26236k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26236k = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1 r0 = new kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f26234i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f26236k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f26233h
            kotlinx.coroutines.reactive.FlowSubscription r0 = (kotlinx.coroutines.reactive.FlowSubscription) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0046
        L_0x002d:
            r5 = move-exception
            goto L_0x0059
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.f26233h = r4     // Catch:{ all -> 0x0057 }
            r0.f26236k = r3     // Catch:{ all -> 0x0057 }
            java.lang.Object r5 = r4.consumeFlow(r0)     // Catch:{ all -> 0x0057 }
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r0 = r4
        L_0x0046:
            org.reactivestreams.Subscriber<? super T> r5 = r0.subscriber     // Catch:{ all -> 0x004c }
            r5.onComplete()     // Catch:{ all -> 0x004c }
            goto L_0x0054
        L_0x004c:
            r5 = move-exception
            kotlin.coroutines.CoroutineContext r0 = r0.getCoroutineContext()
            kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(r0, r5)
        L_0x0054:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0057:
            r5 = move-exception
            r0 = r4
        L_0x0059:
            boolean r1 = r0.cancellationRequested
            if (r1 == 0) goto L_0x0069
            boolean r1 = r0.isActive()
            if (r1 != 0) goto L_0x0069
            java.util.concurrent.CancellationException r1 = r0.getCancellationException()
            if (r5 == r1) goto L_0x007a
        L_0x0069:
            org.reactivestreams.Subscriber<? super T> r1 = r0.subscriber     // Catch:{ all -> 0x006f }
            r1.onError(r5)     // Catch:{ all -> 0x006f }
            goto L_0x007a
        L_0x006f:
            r1 = move-exception
            kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(r5, r1)
            kotlin.coroutines.CoroutineContext r0 = r0.getCoroutineContext()
            kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(r0, r5)
        L_0x007a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.FlowSubscription.flowProcessing(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void cancel() {
        this.cancellationRequested = true;
        cancel((CancellationException) null);
    }

    public void request(long j11) {
        long j12;
        long j13;
        Continuation continuation;
        if (j11 > 0) {
            do {
                j12 = this.requested;
                j13 = j12 + j11;
                if (j13 <= 0) {
                    j13 = Long.MAX_VALUE;
                }
            } while (!f26228b.compareAndSet(this, j12, j13));
            if (j12 <= 0) {
                do {
                    continuation = (Continuation) f26229c.getAndSet(this, (Object) null);
                } while (continuation == null);
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
            }
        }
    }
}
