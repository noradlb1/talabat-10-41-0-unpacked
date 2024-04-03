package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

public final class BlockingFlowableLatest<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<? extends T> f19271b;

    public static final class LatestSubscriberIterator<T> extends DisposableSubscriber<Notification<T>> implements Iterator<T>, j$.util.Iterator {

        /* renamed from: c  reason: collision with root package name */
        public final Semaphore f19272c = new Semaphore(0);

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Notification<T>> f19273d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public Notification<T> f19274e;

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            Notification<T> notification = this.f19274e;
            if (notification == null || !notification.isOnError()) {
                Notification<T> notification2 = this.f19274e;
                if ((notification2 == null || notification2.isOnNext()) && this.f19274e == null) {
                    try {
                        BlockingHelper.verifyNonBlocking();
                        this.f19272c.acquire();
                        Notification<T> andSet = this.f19273d.getAndSet((Object) null);
                        this.f19274e = andSet;
                        if (andSet.isOnError()) {
                            throw ExceptionHelper.wrapOrThrow(andSet.getError());
                        }
                    } catch (InterruptedException e11) {
                        dispose();
                        this.f19274e = Notification.createOnError(e11);
                        throw ExceptionHelper.wrapOrThrow(e11);
                    }
                }
                return this.f19274e.isOnNext();
            }
            throw ExceptionHelper.wrapOrThrow(this.f19274e.getError());
        }

        public T next() {
            if (!hasNext() || !this.f19274e.isOnNext()) {
                throw new NoSuchElementException();
            }
            T value = this.f19274e.getValue();
            this.f19274e = null;
            return value;
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            RxJavaPlugins.onError(th2);
        }

        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }

        public void onNext(Notification<T> notification) {
            if (this.f19273d.getAndSet(notification) == null) {
                this.f19272c.release();
            }
        }
    }

    public BlockingFlowableLatest(Publisher<? extends T> publisher) {
        this.f19271b = publisher;
    }

    public java.util.Iterator<T> iterator() {
        LatestSubscriberIterator latestSubscriberIterator = new LatestSubscriberIterator();
        Flowable.fromPublisher(this.f19271b).materialize().subscribe(latestSubscriberIterator);
        return latestSubscriberIterator;
    }
}
