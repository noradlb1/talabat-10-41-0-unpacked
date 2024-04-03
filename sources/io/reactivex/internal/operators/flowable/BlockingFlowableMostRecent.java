package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subscribers.DefaultSubscriber;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.NoSuchElementException;

public final class BlockingFlowableMostRecent<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f14778b;

    /* renamed from: c  reason: collision with root package name */
    public final T f14779c;

    public static final class MostRecentSubscriber<T> extends DefaultSubscriber<T> {

        /* renamed from: c  reason: collision with root package name */
        public volatile Object f14780c;

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
                Object obj = MostRecentSubscriber.this.f14780c;
                this.buf = obj;
                return !NotificationLite.isComplete(obj);
            }

            public T next() {
                Object obj = null;
                try {
                    if (this.buf == null) {
                        obj = MostRecentSubscriber.this.f14780c;
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
            this.f14780c = NotificationLite.next(t11);
        }

        public MostRecentSubscriber<T>.Iterator getIterable() {
            return new Iterator();
        }

        public void onComplete() {
            this.f14780c = NotificationLite.complete();
        }

        public void onError(Throwable th2) {
            this.f14780c = NotificationLite.error(th2);
        }

        public void onNext(T t11) {
            this.f14780c = NotificationLite.next(t11);
        }
    }

    public BlockingFlowableMostRecent(Flowable<T> flowable, T t11) {
        this.f14778b = flowable;
        this.f14779c = t11;
    }

    public java.util.Iterator<T> iterator() {
        MostRecentSubscriber mostRecentSubscriber = new MostRecentSubscriber(this.f14779c);
        this.f14778b.subscribe(mostRecentSubscriber);
        return mostRecentSubscriber.getIterable();
    }
}
