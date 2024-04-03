package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.observers.DefaultObserver;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BlockingObservableMostRecent<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21316b;

    /* renamed from: c  reason: collision with root package name */
    public final T f21317c;

    public static final class MostRecentObserver<T> extends DefaultObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public volatile Object f21318b;

        public final class MostRecentIterator implements Iterator<T>, j$.util.Iterator {
            private Object buf;

            public MostRecentIterator() {
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                Object obj = MostRecentObserver.this.f21318b;
                this.buf = obj;
                return !NotificationLite.isComplete(obj);
            }

            public T next() {
                Object obj = null;
                try {
                    if (this.buf == null) {
                        obj = MostRecentObserver.this.f21318b;
                    }
                    if (NotificationLite.isComplete(this.buf)) {
                        throw new NoSuchElementException();
                    } else if (!NotificationLite.isError(this.buf)) {
                        T value = NotificationLite.getValue(this.buf);
                        this.buf = obj;
                        return value;
                    } else {
                        throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.buf));
                    }
                } finally {
                    this.buf = obj;
                }
            }

            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        public MostRecentObserver(T t11) {
            this.f21318b = NotificationLite.next(t11);
        }

        public MostRecentObserver<T>.MostRecentIterator getIterable() {
            return new MostRecentIterator();
        }

        public void onComplete() {
            this.f21318b = NotificationLite.complete();
        }

        public void onError(Throwable th2) {
            this.f21318b = NotificationLite.error(th2);
        }

        public void onNext(T t11) {
            this.f21318b = NotificationLite.next(t11);
        }
    }

    public BlockingObservableMostRecent(ObservableSource<T> observableSource, T t11) {
        this.f21316b = observableSource;
        this.f21317c = t11;
    }

    public java.util.Iterator<T> iterator() {
        MostRecentObserver mostRecentObserver = new MostRecentObserver(this.f21317c);
        this.f21316b.subscribe(mostRecentObserver);
        return mostRecentObserver.getIterable();
    }
}
