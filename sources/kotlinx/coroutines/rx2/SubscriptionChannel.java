package kotlinx.coroutines.rx2;

import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.LinkedListChannel;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00172\b\u0012\u0004\u0012\u00028\u00000\u00182\b\u0012\u0004\u0012\u00028\u00000\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0010¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/rx2/SubscriptionChannel;", "T", "<init>", "()V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "closed", "", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "onComplete", "", "e", "onError", "(Ljava/lang/Throwable;)V", "t", "onNext", "(Ljava/lang/Object;)V", "Lio/reactivex/disposables/Disposable;", "sub", "onSubscribe", "(Lio/reactivex/disposables/Disposable;)V", "onSuccess", "kotlinx-coroutines-rx2", "Lkotlinx/coroutines/channels/LinkedListChannel;", "Lio/reactivex/Observer;", "Lio/reactivex/MaybeObserver;"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class SubscriptionChannel<T> extends LinkedListChannel<T> implements Observer<T>, MaybeObserver<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _subscription$FU = AtomicReferenceFieldUpdater.newUpdater(SubscriptionChannel.class, Object.class, "_subscription");
    @NotNull
    private volatile /* synthetic */ Object _subscription = null;

    public SubscriptionChannel() {
        super((Function1) null);
    }

    public void onClosedIdempotent(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        Disposable disposable = (Disposable) _subscription$FU.getAndSet(this, (Object) null);
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void onComplete() {
        close((Throwable) null);
    }

    public void onError(@NotNull Throwable th2) {
        close(th2);
    }

    public void onNext(T t11) {
        m7790trySendJP2dKIU(t11);
    }

    public void onSubscribe(@NotNull Disposable disposable) {
        this._subscription = disposable;
    }

    public void onSuccess(T t11) {
        m7790trySendJP2dKIU(t11);
        close((Throwable) null);
    }
}
