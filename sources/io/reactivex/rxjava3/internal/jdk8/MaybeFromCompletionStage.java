package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromCompletionStage;
import j$.util.function.BiConsumer;
import java.util.concurrent.CompletionStage;

public final class MaybeFromCompletionStage<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final CompletionStage<T> f18899b;

    public static final class CompletionStageHandler<T> implements Disposable, BiConsumer<T, Throwable> {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f18900b;

        /* renamed from: c  reason: collision with root package name */
        public final FlowableFromCompletionStage.BiConsumerAtomicReference<T> f18901c;

        public CompletionStageHandler(MaybeObserver<? super T> maybeObserver, FlowableFromCompletionStage.BiConsumerAtomicReference<T> biConsumerAtomicReference) {
            this.f18900b = maybeObserver;
            this.f18901c = biConsumerAtomicReference;
        }

        public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return BiConsumer.CC.$default$andThen(this, biConsumer);
        }

        public void dispose() {
            this.f18901c.set((Object) null);
        }

        public boolean isDisposed() {
            return this.f18901c.get() == null;
        }

        public void accept(T t11, Throwable th2) {
            if (th2 != null) {
                this.f18900b.onError(th2);
            } else if (t11 != null) {
                this.f18900b.onSuccess(t11);
            } else {
                this.f18900b.onComplete();
            }
        }
    }

    public MaybeFromCompletionStage(CompletionStage<T> completionStage) {
        this.f18899b = completionStage;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        FlowableFromCompletionStage.BiConsumerAtomicReference biConsumerAtomicReference = new FlowableFromCompletionStage.BiConsumerAtomicReference();
        CompletionStageHandler completionStageHandler = new CompletionStageHandler(maybeObserver, biConsumerAtomicReference);
        biConsumerAtomicReference.lazySet(completionStageHandler);
        maybeObserver.onSubscribe(completionStageHandler);
        CompletionStage unused = this.f18899b.whenComplete(BiConsumer.Wrapper.convert(biConsumerAtomicReference));
    }
}
