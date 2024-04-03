package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromCompletionStage;
import j$.util.function.BiConsumer;
import java.util.concurrent.CompletionStage;

public final class SingleFromCompletionStage<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final CompletionStage<T> f18995b;

    public static final class CompletionStageHandler<T> implements Disposable, BiConsumer<T, Throwable> {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18996b;

        /* renamed from: c  reason: collision with root package name */
        public final FlowableFromCompletionStage.BiConsumerAtomicReference<T> f18997c;

        public CompletionStageHandler(SingleObserver<? super T> singleObserver, FlowableFromCompletionStage.BiConsumerAtomicReference<T> biConsumerAtomicReference) {
            this.f18996b = singleObserver;
            this.f18997c = biConsumerAtomicReference;
        }

        public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return BiConsumer.CC.$default$andThen(this, biConsumer);
        }

        public void dispose() {
            this.f18997c.set((Object) null);
        }

        public boolean isDisposed() {
            return this.f18997c.get() == null;
        }

        public void accept(T t11, Throwable th2) {
            if (th2 != null) {
                this.f18996b.onError(th2);
            } else if (t11 != null) {
                this.f18996b.onSuccess(t11);
            } else {
                this.f18996b.onError(new NullPointerException("The CompletionStage terminated with null."));
            }
        }
    }

    public SingleFromCompletionStage(CompletionStage<T> completionStage) {
        this.f18995b = completionStage;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        FlowableFromCompletionStage.BiConsumerAtomicReference biConsumerAtomicReference = new FlowableFromCompletionStage.BiConsumerAtomicReference();
        CompletionStageHandler completionStageHandler = new CompletionStageHandler(singleObserver, biConsumerAtomicReference);
        biConsumerAtomicReference.lazySet(completionStageHandler);
        singleObserver.onSubscribe(completionStageHandler);
        CompletionStage unused = this.f18995b.whenComplete(BiConsumer.Wrapper.convert(biConsumerAtomicReference));
    }
}
