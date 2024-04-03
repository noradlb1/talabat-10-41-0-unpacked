package io.reactivex.rxjava3.observers;

import i.b;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, Disposable, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {
    private final Observer<? super T> downstream;
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

    @NonNull
    public static <T> TestObserver<T> create() {
        return new TestObserver<>();
    }

    @NonNull
    /* renamed from: c */
    public final TestObserver<T> a() {
        if (this.upstream.get() != null) {
            return this;
        }
        throw b("Not subscribed!");
    }

    public final void dispose() {
        DisposableHelper.dispose(this.upstream);
    }

    public final boolean hasSubscription() {
        return this.upstream.get() != null;
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    public void onComplete() {
        if (!this.f23208g) {
            this.f23208g = true;
            if (this.upstream.get() == null) {
                this.f23205d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f23207f = Thread.currentThread();
            this.f23206e++;
            this.downstream.onComplete();
        } finally {
            this.f23203b.countDown();
        }
    }

    public void onError(@NonNull Throwable th2) {
        if (!this.f23208g) {
            this.f23208g = true;
            if (this.upstream.get() == null) {
                this.f23205d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f23207f = Thread.currentThread();
            if (th2 == null) {
                this.f23205d.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f23205d.add(th2);
            }
            this.downstream.onError(th2);
        } finally {
            this.f23203b.countDown();
        }
    }

    public void onNext(@NonNull T t11) {
        if (!this.f23208g) {
            this.f23208g = true;
            if (this.upstream.get() == null) {
                this.f23205d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f23207f = Thread.currentThread();
        this.f23204c.add(t11);
        if (t11 == null) {
            this.f23205d.add(new NullPointerException("onNext received a null value"));
        }
        this.downstream.onNext(t11);
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        this.f23207f = Thread.currentThread();
        if (disposable == null) {
            this.f23205d.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!b.a(this.upstream, (Object) null, disposable)) {
            disposable.dispose();
            if (this.upstream.get() != DisposableHelper.DISPOSED) {
                List<Throwable> list = this.f23205d;
                list.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
            }
        } else {
            this.downstream.onSubscribe(disposable);
        }
    }

    public void onSuccess(@NonNull T t11) {
        onNext(t11);
        onComplete();
    }

    public TestObserver(@NonNull Observer<? super T> observer) {
        this.upstream = new AtomicReference<>();
        this.downstream = observer;
    }

    @NonNull
    public static <T> TestObserver<T> create(@NonNull Observer<? super T> observer) {
        return new TestObserver<>(observer);
    }
}
