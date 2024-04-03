package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeObserveOn<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f20984c;

    public static final class ObserveOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20985b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f20986c;

        /* renamed from: d  reason: collision with root package name */
        public T f20987d;

        /* renamed from: e  reason: collision with root package name */
        public Throwable f20988e;

        public ObserveOnMaybeObserver(MaybeObserver<? super T> maybeObserver, Scheduler scheduler) {
            this.f20985b = maybeObserver;
            this.f20986c = scheduler;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            DisposableHelper.replace(this, this.f20986c.scheduleDirect(this));
        }

        public void onError(Throwable th2) {
            this.f20988e = th2;
            DisposableHelper.replace(this, this.f20986c.scheduleDirect(this));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f20985b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20987d = t11;
            DisposableHelper.replace(this, this.f20986c.scheduleDirect(this));
        }

        public void run() {
            Throwable th2 = this.f20988e;
            if (th2 != null) {
                this.f20988e = null;
                this.f20985b.onError(th2);
                return;
            }
            T t11 = this.f20987d;
            if (t11 != null) {
                this.f20987d = null;
                this.f20985b.onSuccess(t11);
                return;
            }
            this.f20985b.onComplete();
        }
    }

    public MaybeObserveOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.f20984c = scheduler;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new ObserveOnMaybeObserver(maybeObserver, this.f20984c));
    }
}
