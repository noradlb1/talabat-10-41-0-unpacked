package io.reactivex.internal.operators.observable;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
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
    public final ObservableSource<? extends T> f16800b;

    /* renamed from: c  reason: collision with root package name */
    public final int f16801c;

    public static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable, j$.util.Iterator {
        private static final long serialVersionUID = 6695226475494099826L;

        /* renamed from: b  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f16802b;

        /* renamed from: c  reason: collision with root package name */
        public final Lock f16803c;

        /* renamed from: d  reason: collision with root package name */
        public final Condition f16804d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f16805e;

        /* renamed from: f  reason: collision with root package name */
        public volatile Throwable f16806f;

        public BlockingObservableIterator(int i11) {
            this.f16802b = new SpscLinkedArrayQueue<>(i11);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f16803c = reentrantLock;
            this.f16804d = reentrantLock.newCondition();
        }

        public void a() {
            this.f16803c.lock();
            try {
                this.f16804d.signalAll();
            } finally {
                this.f16803c.unlock();
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
                boolean z11 = this.f16805e;
                boolean isEmpty = this.f16802b.isEmpty();
                if (z11) {
                    Throwable th2 = this.f16806f;
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
                this.f16803c.lock();
                while (!this.f16805e && this.f16802b.isEmpty() && !isDisposed()) {
                    try {
                        this.f16804d.await();
                    } catch (InterruptedException e11) {
                        DisposableHelper.dispose(this);
                        a();
                        throw ExceptionHelper.wrapOrThrow(e11);
                    } catch (Throwable th3) {
                        this.f16803c.unlock();
                        throw th3;
                    }
                }
                this.f16803c.unlock();
            }
            Throwable th4 = this.f16806f;
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
                return this.f16802b.poll();
            }
            throw new NoSuchElementException();
        }

        public void onComplete() {
            this.f16805e = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f16806f = th2;
            this.f16805e = true;
            a();
        }

        public void onNext(T t11) {
            this.f16802b.offer(t11);
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
        this.f16800b = observableSource;
        this.f16801c = i11;
    }

    public java.util.Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.f16801c);
        this.f16800b.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
