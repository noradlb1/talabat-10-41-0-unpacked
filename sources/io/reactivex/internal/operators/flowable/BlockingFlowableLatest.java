package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

public final class BlockingFlowableLatest<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<? extends T> f14774b;

    public static final class LatestSubscriberIterator<T> extends DisposableSubscriber<Notification<T>> implements Iterator<T>, j$.util.Iterator {

        /* renamed from: c  reason: collision with root package name */
        public final Semaphore f14775c = new Semaphore(0);

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Notification<T>> f14776d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public Notification<T> f14777e;

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            Notification<T> notification = this.f14777e;
            if (notification == null || !notification.isOnError()) {
                Notification<T> notification2 = this.f14777e;
                if ((notification2 == null || notification2.isOnNext()) && this.f14777e == null) {
                    try {
                        BlockingHelper.verifyNonBlocking();
                        this.f14775c.acquire();
                        Notification<T> andSet = this.f14776d.getAndSet((Object) null);
                        this.f14777e = andSet;
                        if (andSet.isOnError()) {
                            throw ExceptionHelper.wrapOrThrow(andSet.getError());
                        }
                    } catch (InterruptedException e11) {
                        dispose();
                        this.f14777e = Notification.createOnError(e11);
                        throw ExceptionHelper.wrapOrThrow(e11);
                    }
                }
                return this.f14777e.isOnNext();
            }
            throw ExceptionHelper.wrapOrThrow(this.f14777e.getError());
        }

        public T next() {
            if (!hasNext() || !this.f14777e.isOnNext()) {
                throw new NoSuchElementException();
            }
            T value = this.f14777e.getValue();
            this.f14777e = null;
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
            if (this.f14776d.getAndSet(notification) == null) {
                this.f14775c.release();
            }
        }
    }

    public BlockingFlowableLatest(Publisher<? extends T> publisher) {
        this.f14774b = publisher;
    }

    public java.util.Iterator<T> iterator() {
        LatestSubscriberIterator latestSubscriberIterator = new LatestSubscriberIterator();
        Flowable.fromPublisher(this.f14774b).materialize().subscribe(latestSubscriberIterator);
        return latestSubscriberIterator;
    }
}
