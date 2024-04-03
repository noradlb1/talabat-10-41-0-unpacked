package kotlinx.coroutines.rx2;

import i.b;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0015\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"kotlinx/coroutines/rx2/RxConvertKt$asFlow$1$observer$1", "Lio/reactivex/Observer;", "onComplete", "", "onError", "e", "", "onNext", "t", "(Ljava/lang/Object;)V", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RxConvertKt$asFlow$1$observer$1 implements Observer<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProducerScope<T> f26308b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AtomicReference<Disposable> f26309c;

    public RxConvertKt$asFlow$1$observer$1(ProducerScope<? super T> producerScope, AtomicReference<Disposable> atomicReference) {
        this.f26308b = producerScope;
        this.f26309c = atomicReference;
    }

    public void onComplete() {
        SendChannel.DefaultImpls.close$default(this.f26308b, (Throwable) null, 1, (Object) null);
    }

    public void onError(@NotNull Throwable th2) {
        this.f26308b.close(th2);
    }

    public void onNext(@NotNull T t11) {
        try {
            ChannelsKt.trySendBlocking(this.f26308b, t11);
        } catch (InterruptedException unused) {
        }
    }

    public void onSubscribe(@NotNull Disposable disposable) {
        if (!b.a(this.f26309c, (Object) null, disposable)) {
            disposable.dispose();
        }
    }
}
