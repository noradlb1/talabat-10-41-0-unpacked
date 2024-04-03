package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import j$.util.function.BiConsumer;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFromCompletionStage<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final CompletionStage<T> f18931b;

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

    public static final class CompletionStageHandler<T> extends DeferredScalarDisposable<T> implements BiConsumer<T, Throwable> {
        private static final long serialVersionUID = 4665335664328839859L;

        /* renamed from: d  reason: collision with root package name */
        public final BiConsumerAtomicReference<T> f18932d;

        public CompletionStageHandler(Observer<? super T> observer, BiConsumerAtomicReference<T> biConsumerAtomicReference) {
            super(observer);
            this.f18932d = biConsumerAtomicReference;
        }

        public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return BiConsumer.CC.$default$andThen(this, biConsumer);
        }

        public void dispose() {
            super.dispose();
            this.f18932d.set((Object) null);
        }

        public void accept(T t11, Throwable th2) {
            if (th2 != null) {
                this.f19028b.onError(th2);
            } else if (t11 != null) {
                complete(t11);
            } else {
                this.f19028b.onError(new NullPointerException("The CompletionStage terminated with null."));
            }
        }
    }

    public ObservableFromCompletionStage(CompletionStage<T> completionStage) {
        this.f18931b = completionStage;
    }

    public void subscribeActual(Observer<? super T> observer) {
        BiConsumerAtomicReference biConsumerAtomicReference = new BiConsumerAtomicReference();
        CompletionStageHandler completionStageHandler = new CompletionStageHandler(observer, biConsumerAtomicReference);
        biConsumerAtomicReference.lazySet(completionStageHandler);
        observer.onSubscribe(completionStageHandler);
        CompletionStage unused = this.f18931b.whenComplete(BiConsumer.Wrapper.convert(biConsumerAtomicReference));
    }
}
