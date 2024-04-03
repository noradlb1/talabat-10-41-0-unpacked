package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubscribeOn<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f16507c;

    public static final class SubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 8571289934935992137L;

        /* renamed from: b  reason: collision with root package name */
        public final SequentialDisposable f16508b = new SequentialDisposable();

        /* renamed from: c  reason: collision with root package name */
        public final MaybeObserver<? super T> f16509c;

        public SubscribeOnMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f16509c = maybeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.f16508b.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f16509c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16509c.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f16509c.onSuccess(t11);
        }
    }

    public static final class SubscribeTask<T> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16510b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybeSource<T> f16511c;

        public SubscribeTask(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.f16510b = maybeObserver;
            this.f16511c = maybeSource;
        }

        public void run() {
            this.f16511c.subscribe(this.f16510b);
        }
    }

    public MaybeSubscribeOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.f16507c = scheduler;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        SubscribeOnMaybeObserver subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe(subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.f16508b.replace(this.f16507c.scheduleDirect(new SubscribeTask(subscribeOnMaybeObserver, this.f16264b)));
    }
}
