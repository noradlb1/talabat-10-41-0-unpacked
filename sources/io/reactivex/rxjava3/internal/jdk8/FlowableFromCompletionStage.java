package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import j$.util.function.BiConsumer;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableFromCompletionStage<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final CompletionStage<T> f18858c;

    public static final class BiConsumerAtomicReference<T> extends AtomicReference<BiConsumer<T, Throwable>> implements BiConsumer<T, Throwable> {
        private static final long serialVersionUID = 45838553147237545L;

        public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return BiConsumer.CC.$default$andThen(this, biConsumer);
        }

        public void accept(T t11, Throwable th2) {
            BiConsumer biConsumer = (BiConsumer) get();
            if (biConsumer != null) {
                biConsumer.accept(t11, th2);
            }
        }
    }

    public static final class CompletionStageHandler<T> extends DeferredScalarSubscription<T> implements BiConsumer<T, Throwable> {
        private static final long serialVersionUID = 4665335664328839859L;

        /* renamed from: d  reason: collision with root package name */
        public final BiConsumerAtomicReference<T> f18859d;

        public CompletionStageHandler(Subscriber<? super T> subscriber, BiConsumerAtomicReference<T> biConsumerAtomicReference) {
            super(subscriber);
            this.f18859d = biConsumerAtomicReference;
        }

        public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return BiConsumer.CC.$default$andThen(this, biConsumer);
        }

        public void cancel() {
            super.cancel();
            this.f18859d.set((Object) null);
        }

        public void accept(T t11, Throwable th2) {
            if (th2 != null) {
                this.f23170b.onError(th2);
            } else if (t11 != null) {
                complete(t11);
            } else {
                this.f23170b.onError(new NullPointerException("The CompletionStage terminated with null."));
            }
        }
    }

    public FlowableFromCompletionStage(CompletionStage<T> completionStage) {
        this.f18858c = completionStage;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        BiConsumerAtomicReference biConsumerAtomicReference = new BiConsumerAtomicReference();
        CompletionStageHandler completionStageHandler = new CompletionStageHandler(subscriber, biConsumerAtomicReference);
        biConsumerAtomicReference.lazySet(completionStageHandler);
        subscriber.onSubscribe(completionStageHandler);
        CompletionStage unused = this.f18858c.whenComplete(BiConsumer.Wrapper.convert(biConsumerAtomicReference));
    }
}
