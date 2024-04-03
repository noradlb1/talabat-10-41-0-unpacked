package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeUnsubscribeOn<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f16560c;

    public static final class UnsubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16561b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f16562c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16563d;

        public UnsubscribeOnMaybeObserver(MaybeObserver<? super T> maybeObserver, Scheduler scheduler) {
            this.f16561b = maybeObserver;
            this.f16562c = scheduler;
        }

        public void dispose() {
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            Disposable disposable = (Disposable) getAndSet(disposableHelper);
            if (disposable != disposableHelper) {
                this.f16563d = disposable;
                this.f16562c.scheduleDirect(this);
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f16561b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16561b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f16561b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16561b.onSuccess(t11);
        }

        public void run() {
            this.f16563d.dispose();
        }
    }

    public MaybeUnsubscribeOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.f16560c = scheduler;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new UnsubscribeOnMaybeObserver(maybeObserver, this.f16560c));
    }
}
