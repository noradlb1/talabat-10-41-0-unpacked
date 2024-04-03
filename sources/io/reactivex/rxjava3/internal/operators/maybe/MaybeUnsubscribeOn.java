package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeUnsubscribeOn<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f21073c;

    public static final class UnsubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f21074b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f21075c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21076d;

        public UnsubscribeOnMaybeObserver(MaybeObserver<? super T> maybeObserver, Scheduler scheduler) {
            this.f21074b = maybeObserver;
            this.f21075c = scheduler;
        }

        public void dispose() {
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            Disposable disposable = (Disposable) getAndSet(disposableHelper);
            if (disposable != disposableHelper) {
                this.f21076d = disposable;
                this.f21075c.scheduleDirect(this);
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f21074b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21074b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f21074b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f21074b.onSuccess(t11);
        }

        public void run() {
            this.f21076d.dispose();
        }
    }

    public MaybeUnsubscribeOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.f21073c = scheduler;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new UnsubscribeOnMaybeObserver(maybeObserver, this.f21073c));
    }
}
