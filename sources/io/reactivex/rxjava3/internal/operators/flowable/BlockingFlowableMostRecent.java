package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.subscribers.DefaultSubscriber;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.NoSuchElementException;

public final class BlockingFlowableMostRecent<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f19275b;

    /* renamed from: c  reason: collision with root package name */
    public final T f19276c;

    public static final class MostRecentSubscriber<T> extends DefaultSubscriber<T> {

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f19277c;

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
                Object obj = MostRecentSubscriber.this.f19277c;
                this.buf = obj;
                return !NotificationLite.isComplete(obj);
            }

            public T next() {
                Object obj = null;
                try {
                    if (this.buf == null) {
                        obj = MostRecentSubscriber.this.f19277c;
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

        public MostRecentSubscriber(T t11) {
            this.f19277c = NotificationLite.next(t11);
        }

        public MostRecentSubscriber<T>.Iterator getIterable() {
            return new Iterator();
        }

        public void onComplete() {
            this.f19277c = NotificationLite.complete();
        }

        public void onError(Throwable th2) {
            this.f19277c = NotificationLite.error(th2);
        }

        public void onNext(T t11) {
            this.f19277c = NotificationLite.next(t11);
        }
    }

    public BlockingFlowableMostRecent(Flowable<T> flowable, T t11) {
        this.f19275b = flowable;
        this.f19276c = t11;
    }

    public java.util.Iterator<T> iterator() {
        MostRecentSubscriber mostRecentSubscriber = new MostRecentSubscriber(this.f19276c);
        this.f19275b.subscribe(mostRecentSubscriber);
        return mostRecentSubscriber.getIterable();
    }
}
