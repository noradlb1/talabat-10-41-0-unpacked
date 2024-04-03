package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObservableLatest<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f16807b;

    public static final class BlockingObservableLatestIterator<T> extends DisposableObserver<Notification<T>> implements Iterator<T>, j$.util.Iterator {

        /* renamed from: b  reason: collision with root package name */
        public Notification<T> f16808b;

        /* renamed from: c  reason: collision with root package name */
        public final Semaphore f16809c = new Semaphore(0);

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Notification<T>> f16810d = new AtomicReference<>();

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            Notification<T> notification = this.f16808b;
            if (notification == null || !notification.isOnError()) {
                if (this.f16808b == null) {
                    try {
                        BlockingHelper.verifyNonBlocking();
                        this.f16809c.acquire();
                        Notification<T> andSet = this.f16810d.getAndSet((Object) null);
                        this.f16808b = andSet;
                        if (andSet.isOnError()) {
                            throw ExceptionHelper.wrapOrThrow(andSet.getError());
                        }
                    } catch (InterruptedException e11) {
                        dispose();
                        this.f16808b = Notification.createOnError(e11);
                        throw ExceptionHelper.wrapOrThrow(e11);
                    }
                }
                return this.f16808b.isOnNext();
            }
            throw ExceptionHelper.wrapOrThrow(this.f16808b.getError());
        }

        public T next() {
            if (hasNext()) {
                T value = this.f16808b.getValue();
                this.f16808b = null;
                return value;
            }
            throw new NoSuchElementException();
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
            if (this.f16810d.getAndSet(notification) == null) {
                this.f16809c.release();
            }
        }
    }

    public BlockingObservableLatest(ObservableSource<T> observableSource) {
        this.f16807b = observableSource;
    }

    public java.util.Iterator<T> iterator() {
        BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        Observable.wrap(this.f16807b).materialize().subscribe(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }
}
