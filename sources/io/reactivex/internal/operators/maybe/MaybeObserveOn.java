package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeObserveOn<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f16478c;

    public static final class ObserveOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16479b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f16480c;

        /* renamed from: d  reason: collision with root package name */
        public T f16481d;

        /* renamed from: e  reason: collision with root package name */
        public Throwable f16482e;

        public ObserveOnMaybeObserver(MaybeObserver<? super T> maybeObserver, Scheduler scheduler) {
            this.f16479b = maybeObserver;
            this.f16480c = scheduler;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            DisposableHelper.replace(this, this.f16480c.scheduleDirect(this));
        }

        public void onError(Throwable th2) {
            this.f16482e = th2;
            DisposableHelper.replace(this, this.f16480c.scheduleDirect(this));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f16479b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16481d = t11;
            DisposableHelper.replace(this, this.f16480c.scheduleDirect(this));
        }

        public void run() {
            Throwable th2 = this.f16482e;
            if (th2 != null) {
                this.f16482e = null;
                this.f16479b.onError(th2);
                return;
            }
            T t11 = this.f16481d;
            if (t11 != null) {
                this.f16481d = null;
                this.f16479b.onSuccess(t11);
                return;
            }
            this.f16479b.onComplete();
        }
    }

    public MaybeObserveOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.f16478c = scheduler;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new ObserveOnMaybeObserver(maybeObserver, this.f16478c));
    }
}
