package kotlinx.coroutines.reactive;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.LinkedListChannel;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u001c2\b\u0012\u0004\u0012\u00028\u00000\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\fJ\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001a¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/reactive/SubscriptionChannel;", "T", "", "request", "<init>", "(I)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "closed", "", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "onComplete", "()V", "", "e", "onError", "(Ljava/lang/Throwable;)V", "t", "onNext", "(Ljava/lang/Object;)V", "onReceiveDequeued", "onReceiveEnqueued", "Lorg/reactivestreams/Subscription;", "s", "onSubscribe", "(Lorg/reactivestreams/Subscription;)V", "I", "kotlinx-coroutines-reactive", "Lkotlinx/coroutines/channels/LinkedListChannel;", "Lorg/reactivestreams/Subscriber;"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class SubscriptionChannel<T> extends LinkedListChannel<T> implements Subscriber<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _requested$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _subscription$FU;
    @NotNull
    private volatile /* synthetic */ int _requested;
    @NotNull
    private volatile /* synthetic */ Object _subscription;
    private final int request;

    static {
        Class<SubscriptionChannel> cls = SubscriptionChannel.class;
        _subscription$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_subscription");
        _requested$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "_requested");
    }

    public SubscriptionChannel(int i11) {
        super((Function1) null);
        boolean z11;
        this.request = i11;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this._subscription = null;
            this._requested = 0;
            return;
        }
        throw new IllegalArgumentException(("Invalid request size: " + i11).toString());
    }

    public void onClosedIdempotent(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        Subscription subscription = (Subscription) _subscription$FU.getAndSet(this, (Object) null);
        if (subscription != null) {
            subscription.cancel();
        }
    }

    public void onComplete() {
        close((Throwable) null);
    }

    public void onError(@NotNull Throwable th2) {
        close(th2);
    }

    public void onNext(T t11) {
        _requested$FU.decrementAndGet(this);
        m7790trySendJP2dKIU(t11);
    }

    public void onReceiveDequeued() {
        _requested$FU.incrementAndGet(this);
    }

    public void onReceiveEnqueued() {
        Subscription subscription;
        int i11;
        while (true) {
            int i12 = this._requested;
            subscription = (Subscription) this._subscription;
            i11 = i12 - 1;
            if (subscription != null && i11 < 0) {
                int i13 = this.request;
                if (i12 == i13 || _requested$FU.compareAndSet(this, i12, i13)) {
                    subscription.request((long) (this.request - i11));
                }
            } else if (_requested$FU.compareAndSet(this, i12, i11)) {
                return;
            }
        }
        subscription.request((long) (this.request - i11));
    }

    public void onSubscribe(@NotNull Subscription subscription) {
        this._subscription = subscription;
        while (!isClosedForSend()) {
            int i11 = this._requested;
            int i12 = this.request;
            if (i11 < i12) {
                if (_requested$FU.compareAndSet(this, i11, i12)) {
                    subscription.request((long) (this.request - i11));
                    return;
                }
            } else {
                return;
            }
        }
        subscription.cancel();
    }
}
