package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubscribeOn<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f21011c;

    public static final class SubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 8571289934935992137L;

        /* renamed from: b  reason: collision with root package name */
        public final SequentialDisposable f21012b = new SequentialDisposable();

        /* renamed from: c  reason: collision with root package name */
        public final MaybeObserver<? super T> f21013c;

        public SubscribeOnMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f21013c = maybeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.f21012b.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f21013c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21013c.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f21013c.onSuccess(t11);
        }
    }

    public static final class SubscribeTask<T> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f21014b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybeSource<T> f21015c;

        public SubscribeTask(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.f21014b = maybeObserver;
            this.f21015c = maybeSource;
        }

        public void run() {
            this.f21015c.subscribe(this.f21014b);
        }
    }

    public MaybeSubscribeOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.f21011c = scheduler;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        SubscribeOnMaybeObserver subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe(subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.f21012b.replace(this.f21011c.scheduleDirect(new SubscribeTask(subscribeOnMaybeObserver, this.f20763b)));
    }
}
