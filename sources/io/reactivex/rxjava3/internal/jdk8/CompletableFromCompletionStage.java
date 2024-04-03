package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromCompletionStage;
import j$.util.function.BiConsumer;
import java.util.concurrent.CompletionStage;

public final class CompletableFromCompletionStage<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletionStage<T> f18818b;

    public static final class CompletionStageHandler<T> implements Disposable, BiConsumer<T, Throwable> {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f18819b;

        /* renamed from: c  reason: collision with root package name */
        public final FlowableFromCompletionStage.BiConsumerAtomicReference<T> f18820c;

        public CompletionStageHandler(CompletableObserver completableObserver, FlowableFromCompletionStage.BiConsumerAtomicReference<T> biConsumerAtomicReference) {
            this.f18819b = completableObserver;
            this.f18820c = biConsumerAtomicReference;
        }

        public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return BiConsumer.CC.$default$andThen(this, biConsumer);
        }

        public void dispose() {
            this.f18820c.set((Object) null);
        }

        public boolean isDisposed() {
            return this.f18820c.get() == null;
        }

        public void accept(T t11, Throwable th2) {
            if (th2 != null) {
                this.f18819b.onError(th2);
            } else {
                this.f18819b.onComplete();
            }
        }
    }

    public CompletableFromCompletionStage(CompletionStage<T> completionStage) {
        this.f18818b = completionStage;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        FlowableFromCompletionStage.BiConsumerAtomicReference biConsumerAtomicReference = new FlowableFromCompletionStage.BiConsumerAtomicReference();
        CompletionStageHandler completionStageHandler = new CompletionStageHandler(completableObserver, biConsumerAtomicReference);
        biConsumerAtomicReference.lazySet(completionStageHandler);
        completableObserver.onSubscribe(completionStageHandler);
        CompletionStage unused = this.f18818b.whenComplete(BiConsumer.Wrapper.convert(biConsumerAtomicReference));
    }
}
