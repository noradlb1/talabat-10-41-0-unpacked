package io.reactivex.observers;

import i.b;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {
    private final Observer<? super T> downstream;

    /* renamed from: qd  reason: collision with root package name */
    private QueueDisposable<T> f18664qd;
    private final AtomicReference<Disposable> upstream;

    public enum EmptyObserver implements Observer<Object> {
        INSTANCE;

        public void onComplete() {
        }

        public void onError(Throwable th2) {
        }

        public void onNext(Object obj) {
        }

        public void onSubscribe(Disposable disposable) {
        }
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    public static <T> TestObserver<T> create() {
        return new TestObserver<>();
    }

    public final TestObserver<T> assertOf(Consumer<? super TestObserver<T>> consumer) {
        try {
            consumer.accept(this);
            return this;
        } catch (Throwable th2) {
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    public final void cancel() {
        dispose();
    }

    public final void dispose() {
        DisposableHelper.dispose(this.upstream);
    }

    public final boolean hasSubscription() {
        return this.upstream.get() != null;
    }

    public final boolean isCancelled() {
        return isDisposed();
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    public void onComplete() {
        if (!this.f18647g) {
            this.f18647g = true;
            if (this.upstream.get() == null) {
                this.f18644d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f18646f = Thread.currentThread();
            this.f18645e++;
            this.downstream.onComplete();
        } finally {
            this.f18642b.countDown();
        }
    }

    public void onError(Throwable th2) {
        if (!this.f18647g) {
            this.f18647g = true;
            if (this.upstream.get() == null) {
                this.f18644d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f18646f = Thread.currentThread();
            if (th2 == null) {
                this.f18644d.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f18644d.add(th2);
            }
            this.downstream.onError(th2);
        } finally {
            this.f18642b.countDown();
        }
    }

    public void onNext(T t11) {
        if (!this.f18647g) {
            this.f18647g = true;
            if (this.upstream.get() == null) {
                this.f18644d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f18646f = Thread.currentThread();
        if (this.f18649i == 2) {
            while (true) {
                try {
                    T poll = this.f18664qd.poll();
                    if (poll != null) {
                        this.f18643c.add(poll);
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    this.f18644d.add(th2);
                    this.f18664qd.dispose();
                    return;
                }
            }
        } else {
            this.f18643c.add(t11);
            if (t11 == null) {
                this.f18644d.add(new NullPointerException("onNext received a null value"));
            }
            this.downstream.onNext(t11);
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.f18646f = Thread.currentThread();
        if (disposable == null) {
            this.f18644d.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!b.a(this.upstream, (Object) null, disposable)) {
            disposable.dispose();
            if (this.upstream.get() != DisposableHelper.DISPOSED) {
                this.f18644d.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
            }
        } else {
            int i11 = this.f18648h;
            if (i11 != 0 && (disposable instanceof QueueDisposable)) {
                QueueDisposable<T> queueDisposable = (QueueDisposable) disposable;
                this.f18664qd = queueDisposable;
                int requestFusion = queueDisposable.requestFusion(i11);
                this.f18649i = requestFusion;
                if (requestFusion == 1) {
                    this.f18647g = true;
                    this.f18646f = Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.f18664qd.poll();
                            if (poll != null) {
                                this.f18643c.add(poll);
                            } else {
                                this.f18645e++;
                                this.upstream.lazySet(DisposableHelper.DISPOSED);
                                return;
                            }
                        } catch (Throwable th2) {
                            this.f18644d.add(th2);
                            return;
                        }
                    }
                }
            }
            this.downstream.onSubscribe(disposable);
        }
    }

    public void onSuccess(T t11) {
        onNext(t11);
        onComplete();
    }

    public TestObserver(Observer<? super T> observer) {
        this.upstream = new AtomicReference<>();
        this.downstream = observer;
    }

    public static <T> TestObserver<T> create(Observer<? super T> observer) {
        return new TestObserver<>(observer);
    }

    public final TestObserver<T> assertNotSubscribed() {
        if (this.upstream.get() != null) {
            throw a("Subscribed!");
        } else if (this.f18644d.isEmpty()) {
            return this;
        } else {
            throw a("Not subscribed but errors found");
        }
    }

    public final TestObserver<T> assertSubscribed() {
        if (this.upstream.get() != null) {
            return this;
        }
        throw a("Not subscribed!");
    }
}
