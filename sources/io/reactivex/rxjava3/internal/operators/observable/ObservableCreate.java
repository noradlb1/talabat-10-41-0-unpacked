package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCreate<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableOnSubscribe<T> f21584b;

    public static final class CreateEmitter<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {
        private static final long serialVersionUID = -3434801548987643227L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21585b;

        public CreateEmitter(Observer<? super T> observer) {
            this.f21585b = observer;
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
                    this.f21585b.onComplete();
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
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            } else if (!isDisposed()) {
                this.f21585b.onNext(t11);
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
                th2 = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.f21585b.onError(th2);
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
        public final ObservableEmitter<T> f21586b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicThrowable f21587c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f21588d = new SpscLinkedArrayQueue<>(16);

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f21589e;

        public SerializedEmitter(ObservableEmitter<T> observableEmitter) {
            this.f21586b = observableEmitter;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            boolean z11;
            ObservableEmitter<T> observableEmitter = this.f21586b;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f21588d;
            AtomicThrowable atomicThrowable = this.f21587c;
            int i11 = 1;
            while (!observableEmitter.isDisposed()) {
                if (atomicThrowable.get() != null) {
                    spscLinkedArrayQueue.clear();
                    atomicThrowable.tryTerminateConsumer((Emitter<?>) observableEmitter);
                    return;
                }
                boolean z12 = this.f21589e;
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
            return this.f21586b.isDisposed();
        }

        public void onComplete() {
            if (!this.f21589e && !this.f21586b.isDisposed()) {
                this.f21589e = true;
                a();
            }
        }

        public void onError(Throwable th2) {
            if (!tryOnError(th2)) {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!this.f21589e && !this.f21586b.isDisposed()) {
                if (t11 == null) {
                    onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                    return;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f21588d;
                    synchronized (spscLinkedArrayQueue) {
                        spscLinkedArrayQueue.offer(t11);
                    }
                    if (getAndIncrement() != 0) {
                        return;
                    }
                } else {
                    this.f21586b.onNext(t11);
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
            this.f21586b.setCancellable(cancellable);
        }

        public void setDisposable(Disposable disposable) {
            this.f21586b.setDisposable(disposable);
        }

        public String toString() {
            return this.f21586b.toString();
        }

        public boolean tryOnError(Throwable th2) {
            if (!this.f21589e && !this.f21586b.isDisposed()) {
                if (th2 == null) {
                    th2 = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
                }
                if (this.f21587c.tryAddThrowable(th2)) {
                    this.f21589e = true;
                    a();
                    return true;
                }
            }
            return false;
        }
    }

    public ObservableCreate(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.f21584b = observableOnSubscribe;
    }

    public void subscribeActual(Observer<? super T> observer) {
        CreateEmitter createEmitter = new CreateEmitter(observer);
        observer.onSubscribe(createEmitter);
        try {
            this.f21584b.subscribe(createEmitter);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            createEmitter.onError(th2);
        }
    }
}
