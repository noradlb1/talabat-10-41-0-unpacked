package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class BlockingObservableNext<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f16815b;

    public static final class NextIterator<T> implements Iterator<T>, j$.util.Iterator {
        private Throwable error;
        private boolean hasNext = true;
        private boolean isNextConsumed = true;
        private final ObservableSource<T> items;
        private T next;
        private final NextObserver<T> observer;
        private boolean started;

        public NextIterator(ObservableSource<T> observableSource, NextObserver<T> nextObserver) {
            this.items = observableSource;
            this.observer = nextObserver;
        }

        private boolean moveToNext() {
            if (!this.started) {
                this.started = true;
                this.observer.a();
                new ObservableMaterialize(this.items).subscribe(this.observer);
            }
            try {
                Notification<T> takeNext = this.observer.takeNext();
                if (takeNext.isOnNext()) {
                    this.isNextConsumed = false;
                    this.next = takeNext.getValue();
                    return true;
                }
                this.hasNext = false;
                if (takeNext.isOnComplete()) {
                    return false;
                }
                Throwable error2 = takeNext.getError();
                this.error = error2;
                throw ExceptionHelper.wrapOrThrow(error2);
            } catch (InterruptedException e11) {
                this.observer.dispose();
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

    public static final class NextObserver<T> extends DisposableObserver<Notification<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f16816b = new AtomicInteger();
        private final BlockingQueue<Notification<T>> buf = new ArrayBlockingQueue(1);

        public void a() {
            this.f16816b.set(1);
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            RxJavaPlugins.onError(th2);
        }

        public Notification<T> takeNext() throws InterruptedException {
            a();
            BlockingHelper.verifyNonBlocking();
            return this.buf.take();
        }

        public void onNext(Notification<T> notification) {
            if (this.f16816b.getAndSet(0) == 1 || !notification.isOnNext()) {
                while (!this.buf.offer(notification)) {
                    Notification<T> poll = this.buf.poll();
                    if (poll != null && !poll.isOnNext()) {
                        notification = poll;
                    }
                }
            }
        }
    }

    public BlockingObservableNext(ObservableSource<T> observableSource) {
        this.f16815b = observableSource;
    }

    public java.util.Iterator<T> iterator() {
        return new NextIterator(this.f16815b, new NextObserver());
    }
}
