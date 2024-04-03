package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObservableLatest<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21312b;

    public static final class BlockingObservableLatestIterator<T> extends DisposableObserver<Notification<T>> implements Iterator<T>, j$.util.Iterator {

        /* renamed from: c  reason: collision with root package name */
        public Notification<T> f21313c;

        /* renamed from: d  reason: collision with root package name */
        public final Semaphore f21314d = new Semaphore(0);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Notification<T>> f21315e = new AtomicReference<>();

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            Notification<T> notification = this.f21313c;
            if (notification == null || !notification.isOnError()) {
                if (this.f21313c == null) {
                    try {
                        BlockingHelper.verifyNonBlocking();
                        this.f21314d.acquire();
                        Notification<T> andSet = this.f21315e.getAndSet((Object) null);
                        this.f21313c = andSet;
                        if (andSet.isOnError()) {
                            throw ExceptionHelper.wrapOrThrow(andSet.getError());
                        }
                    } catch (InterruptedException e11) {
                        dispose();
                        this.f21313c = Notification.createOnError(e11);
                        throw ExceptionHelper.wrapOrThrow(e11);
                    }
                }
                return this.f21313c.isOnNext();
            }
            throw ExceptionHelper.wrapOrThrow(this.f21313c.getError());
        }

        public T next() {
            if (hasNext()) {
                T value = this.f21313c.getValue();
                this.f21313c = null;
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
            if (this.f21315e.getAndSet(notification) == null) {
                this.f21314d.release();
            }
        }
    }

    public BlockingObservableLatest(ObservableSource<T> observableSource) {
        this.f21312b = observableSource;
    }

    public java.util.Iterator<T> iterator() {
        BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        Observable.wrap(this.f21312b).materialize().subscribe(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }
}
