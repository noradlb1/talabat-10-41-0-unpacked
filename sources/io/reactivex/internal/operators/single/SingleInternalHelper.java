package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

public final class SingleInternalHelper {

    public enum NoSuchElementCallable implements Callable<NoSuchElementException> {
        INSTANCE;

        public NoSuchElementException call() throws Exception {
            return new NoSuchElementException();
        }
    }

    public enum ToFlowable implements Function<SingleSource, Publisher> {
        INSTANCE;

        public Publisher apply(SingleSource singleSource) {
            return new SingleToFlowable(singleSource);
        }
    }

    public static final class ToFlowableIterable<T> implements Iterable<Flowable<T>> {
        private final Iterable<? extends SingleSource<? extends T>> sources;

        public ToFlowableIterable(Iterable<? extends SingleSource<? extends T>> iterable) {
            this.sources = iterable;
        }

        public Iterator<Flowable<T>> iterator() {
            return new ToFlowableIterator(this.sources.iterator());
        }
    }

    public static final class ToFlowableIterator<T> implements Iterator<Flowable<T>>, j$.util.Iterator {
        private final Iterator<? extends SingleSource<? extends T>> sit;

        public ToFlowableIterator(Iterator<? extends SingleSource<? extends T>> it) {
            this.sit = it;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.sit.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Flowable<T> next() {
            return new SingleToFlowable((SingleSource) this.sit.next());
        }
    }

    public enum ToObservable implements Function<SingleSource, Observable> {
        INSTANCE;

        public Observable apply(SingleSource singleSource) {
            return new SingleToObservable(singleSource);
        }
    }

    private SingleInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Callable<NoSuchElementException> emptyThrower() {
        return NoSuchElementCallable.INSTANCE;
    }

    public static <T> Iterable<? extends Flowable<T>> iterableToFlowable(Iterable<? extends SingleSource<? extends T>> iterable) {
        return new ToFlowableIterable(iterable);
    }

    public static <T> Function<SingleSource<? extends T>, Publisher<? extends T>> toFlowable() {
        return ToFlowable.INSTANCE;
    }

    public static <T> Function<SingleSource<? extends T>, Observable<? extends T>> toObservable() {
        return ToObservable.INSTANCE;
    }
}
