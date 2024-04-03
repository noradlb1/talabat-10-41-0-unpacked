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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

public final class BlockingFlowableNext<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<? extends T> f14782b;

    public static final class NextIterator<T> implements Iterator<T>, j$.util.Iterator {
        private Throwable error;
        private boolean hasNext = true;
        private boolean isNextConsumed = true;
        private final Publisher<? extends T> items;
        private T next;
        private boolean started;
        private final NextSubscriber<T> subscriber;

        public NextIterator(Publisher<? extends T> publisher, NextSubscriber<T> nextSubscriber) {
            this.items = publisher;
            this.subscriber = nextSubscriber;
        }

        private boolean moveToNext() {
            try {
                if (!this.started) {
                    this.started = true;
                    this.subscriber.c();
                    Flowable.fromPublisher(this.items).materialize().subscribe(this.subscriber);
                }
                Notification<T> takeNext = this.subscriber.takeNext();
                if (takeNext.isOnNext()) {
                    this.isNextConsumed = false;
                    this.next = takeNext.getValue();
                    return true;
                }
                this.hasNext = false;
                if (takeNext.isOnComplete()) {
                    return false;
                }
                if (takeNext.isOnError()) {
                    Throwable error2 = takeNext.getError();
                    this.error = error2;
                    throw ExceptionHelper.wrapOrThrow(error2);
                }
                throw new IllegalStateException("Should not reach here");
            } catch (InterruptedException e11) {
                this.subscriber.dispose();
                this.error = e11;
                throw ExceptionHelper.wrapOrThrow(e11);
            }
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            Throwable th2 = this.error;
            if (th2 != null) {
                throw ExceptionHelper.wrapOrThrow(th2);
            } else if (!this.hasNext) {
                return false;
            } else {
                if (!this.isNextConsumed || moveToNext()) {
                    return true;
                }
                return false;
            }
        }

        public T next() {
            Throwable th2 = this.error;
            if (th2 != null) {
                throw ExceptionHelper.wrapOrThrow(th2);
            } else if (hasNext()) {
                this.isNextConsumed = true;
                return this.next;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    public static final class NextSubscriber<T> extends DisposableSubscriber<Notification<T>> {
        private final BlockingQueue<Notification<T>> buf = new ArrayBlockingQueue(1);

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f14783c = new AtomicInteger();

        public void c() {
            this.f14783c.set(1);
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            RxJavaPlugins.onError(th2);
        }

        public Notification<T> takeNext() throws InterruptedException {
            c();
            BlockingHelper.verifyNonBlocking();
            return this.buf.take();
        }

        public void onNext(Notification<T> notification) {
            if (this.f14783c.getAndSet(0) == 1 || !notification.isOnNext()) {
                while (!this.buf.offer(notification)) {
                    Notification<T> poll = this.buf.poll();
                    if (poll != null && !poll.isOnNext()) {
                        notification = poll;
                    }
                }
            }
        }
    }

    public BlockingFlowableNext(Publisher<? extends T> publisher) {
        this.f14782b = publisher;
    }

    public java.util.Iterator<T> iterator() {
        return new NextIterator(this.f14782b, new NextSubscriber());
    }
}
