package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DefaultObserver;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.NoSuchElementException;

public final class BlockingObservableMostRecent<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f16811b;

    /* renamed from: c  reason: collision with root package name */
    public final T f16812c;

    public static final class MostRecentObserver<T> extends DefaultObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public volatile Object f16813b;

        public final class Iterator implements java.util.Iterator<T>, j$.util.Iterator {
            private Object buf;

            public Iterator() {
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                Object obj = MostRecentObserver.this.f16813b;
                this.buf = obj;
                return !NotificationLite.isComplete(obj);
            }

            public T next() {
                Object obj = null;
                try {
                    if (this.buf == null) {
                        obj = MostRecentObserver.this.f16813b;
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
            this.f16813b = NotificationLite.next(t11);
        }

        public MostRecentObserver<T>.Iterator getIterable() {
            return new Iterator();
        }

        public void onComplete() {
            this.f16813b = NotificationLite.complete();
        }

        public void onError(Throwable th2) {
            this.f16813b = NotificationLite.error(th2);
        }

        public void onNext(T t11) {
            this.f16813b = NotificationLite.next(t11);
        }
    }

    public BlockingObservableMostRecent(ObservableSource<T> observableSource, T t11) {
        this.f16811b = observableSource;
        this.f16812c = t11;
    }

    public java.util.Iterator<T> iterator() {
        MostRecentObserver mostRecentObserver = new MostRecentObserver(this.f16812c);
        this.f16811b.subscribe(mostRecentObserver);
        return mostRecentObserver.getIterable();
    }
}
