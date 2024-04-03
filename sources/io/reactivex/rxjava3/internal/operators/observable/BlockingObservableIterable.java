package io.reactivex.rxjava3.internal.operators.observable;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class BlockingObservableIterable<T> implements Iterable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T> f21305b;

    /* renamed from: c  reason: collision with root package name */
    public final int f21306c;

    public static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable, j$.util.Iterator {
        private static final long serialVersionUID = 6695226475494099826L;

        /* renamed from: b  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f21307b;

        /* renamed from: c  reason: collision with root package name */
        public final Lock f21308c;

        /* renamed from: d  reason: collision with root package name */
        public final Condition f21309d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f21310e;

        /* renamed from: f  reason: collision with root package name */
        public volatile Throwable f21311f;

        public BlockingObservableIterator(int i11) {
            this.f21307b = new SpscLinkedArrayQueue<>(i11);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f21308c = reentrantLock;
            this.f21309d = reentrantLock.newCondition();
        }

        public void a() {
            this.f21308c.lock();
            try {
                this.f21309d.signalAll();
            } finally {
                this.f21308c.unlock();
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            a();
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            while (!isDisposed()) {
                boolean z11 = this.f21310e;
                boolean isEmpty = this.f21307b.isEmpty();
                if (z11) {
                    Throwable th2 = this.f21311f;
                    if (th2 != null) {
                        throw ExceptionHelper.wrapOrThrow(th2);
                    } else if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                BlockingHelper.verifyNonBlocking();
                this.f21308c.lock();
                while (!this.f21310e && this.f21307b.isEmpty() && !isDisposed()) {
                    try {
                        this.f21309d.await();
                    } catch (InterruptedException e11) {
                        DisposableHelper.dispose(this);
                        a();
                        throw ExceptionHelper.wrapOrThrow(e11);
                    } catch (Throwable th3) {
                        this.f21308c.unlock();
                        throw th3;
                    }
                }
                this.f21308c.unlock();
            }
            Throwable th4 = this.f21311f;
            if (th4 == null) {
                return false;
            }
            throw ExceptionHelper.wrapOrThrow(th4);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public T next() {
            if (hasNext()) {
                return this.f21307b.poll();
            }
            throw new NoSuchElementException();
        }

        public void onComplete() {
            this.f21310e = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f21311f = th2;
            this.f21310e = true;
            a();
        }

        public void onNext(T t11) {
            this.f21307b.offer(t11);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void remove() {
            throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
        }
    }

    public BlockingObservableIterable(ObservableSource<? extends T> observableSource, int i11) {
        this.f21305b = observableSource;
        this.f21306c = i11;
    }

    public java.util.Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.f21306c);
        this.f21305b.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
