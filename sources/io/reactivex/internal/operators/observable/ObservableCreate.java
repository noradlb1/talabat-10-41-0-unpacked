package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCreate<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableOnSubscribe<T> f17056b;

    public static final class CreateEmitter<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {
        private static final long serialVersionUID = -3434801548987643227L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17057b;

        public CreateEmitter(Observer<? super T> observer) {
            this.f17057b = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (!isDisposed()) {
                try {
                    this.f17057b.onComplete();
                } finally {
                    dispose();
                }
            }
        }

        public void onError(Throwable th2) {
            if (!tryOnError(th2)) {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (t11 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (!isDisposed()) {
                this.f17057b.onNext(t11);
            }
        }

        public ObservableEmitter<T> serialize() {
            return new SerializedEmitter(this);
        }

        public void setCancellable(Cancellable cancellable) {
            setDisposable(new CancellableDisposable(cancellable));
        }

        public void setDisposable(Disposable disposable) {
            DisposableHelper.set(this, disposable);
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{CreateEmitter.class.getSimpleName(), super.toString()});
        }

        /* JADX INFO: finally extract failed */
        public boolean tryOnError(Throwable th2) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.f17057b.onError(th2);
                dispose();
                return true;
            } catch (Throwable th3) {
                dispose();
                throw th3;
            }
        }
    }

    public static final class SerializedEmitter<T> extends AtomicInteger implements ObservableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;

        /* renamed from: b  reason: collision with root package name */
        public final ObservableEmitter<T> f17058b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicThrowable f17059c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f17060d = new SpscLinkedArrayQueue<>(16);

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f17061e;

        public SerializedEmitter(ObservableEmitter<T> observableEmitter) {
            this.f17058b = observableEmitter;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            boolean z11;
            ObservableEmitter<T> observableEmitter = this.f17058b;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f17060d;
            AtomicThrowable atomicThrowable = this.f17059c;
            int i11 = 1;
            while (!observableEmitter.isDisposed()) {
                if (atomicThrowable.get() != null) {
                    spscLinkedArrayQueue.clear();
                    observableEmitter.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z12 = this.f17061e;
                T poll = spscLinkedArrayQueue.poll();
                if (poll == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z12 && z11) {
                    observableEmitter.onComplete();
                    return;
                } else if (z11) {
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    observableEmitter.onNext(poll);
                }
            }
            spscLinkedArrayQueue.clear();
        }

        public boolean isDisposed() {
            return this.f17058b.isDisposed();
        }

        public void onComplete() {
            if (!this.f17058b.isDisposed() && !this.f17061e) {
                this.f17061e = true;
                a();
            }
        }

        public void onError(Throwable th2) {
            if (!tryOnError(th2)) {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!this.f17058b.isDisposed() && !this.f17061e) {
                if (t11 == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f17060d;
                    synchronized (spscLinkedArrayQueue) {
                        spscLinkedArrayQueue.offer(t11);
                    }
                    if (getAndIncrement() != 0) {
                        return;
                    }
                } else {
                    this.f17058b.onNext(t11);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                b();
            }
        }

        public ObservableEmitter<T> serialize() {
            return this;
        }

        public void setCancellable(Cancellable cancellable) {
            this.f17058b.setCancellable(cancellable);
        }

        public void setDisposable(Disposable disposable) {
            this.f17058b.setDisposable(disposable);
        }

        public String toString() {
            return this.f17058b.toString();
        }

        public boolean tryOnError(Throwable th2) {
            if (!this.f17058b.isDisposed() && !this.f17061e) {
                if (th2 == null) {
                    th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.f17059c.addThrowable(th2)) {
                    this.f17061e = true;
                    a();
                    return true;
                }
            }
            return false;
        }
    }

    public ObservableCreate(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.f17056b = observableOnSubscribe;
    }

    public void subscribeActual(Observer<? super T> observer) {
        CreateEmitter createEmitter = new CreateEmitter(observer);
        observer.onSubscribe(createEmitter);
        try {
            this.f17056b.subscribe(createEmitter);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            createEmitter.onError(th2);
        }
    }
}
