package io.reactivex.internal.operators.mixed;

import i.b;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f16651b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f16652c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f16653d;

    public static final class SwitchMapCompletableObserver<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public static final SwitchMapInnerObserver f16654i = new SwitchMapInnerObserver((SwitchMapCompletableObserver<?>) null);

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f16655b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f16656c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f16657d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f16658e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<SwitchMapInnerObserver> f16659f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f16660g;

        /* renamed from: h  reason: collision with root package name */
        public Subscription f16661h;

        public static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;

            /* renamed from: b  reason: collision with root package name */
            public final SwitchMapCompletableObserver<?> f16662b;

            public SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.f16662b = switchMapCompletableObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f16662b.b(this);
            }

            public void onError(Throwable th2) {
                this.f16662b.c(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public SwitchMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z11) {
            this.f16655b = completableObserver;
            this.f16656c = function;
            this.f16657d = z11;
        }

        public void a() {
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.f16659f;
            SwitchMapInnerObserver switchMapInnerObserver = f16654i;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet != null && andSet != switchMapInnerObserver) {
                andSet.a();
            }
        }

        public void b(SwitchMapInnerObserver switchMapInnerObserver) {
            if (b.a(this.f16659f, switchMapInnerObserver, (Object) null) && this.f16660g) {
                Throwable terminate = this.f16658e.terminate();
                if (terminate == null) {
                    this.f16655b.onComplete();
                } else {
                    this.f16655b.onError(terminate);
                }
            }
        }

        public void c(SwitchMapInnerObserver switchMapInnerObserver, Throwable th2) {
            if (!b.a(this.f16659f, switchMapInnerObserver, (Object) null) || !this.f16658e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (!this.f16657d) {
                dispose();
                Throwable terminate = this.f16658e.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.f16655b.onError(terminate);
                }
            } else if (this.f16660g) {
                this.f16655b.onError(this.f16658e.terminate());
            }
        }

        public void dispose() {
            this.f16661h.cancel();
            a();
        }

        public boolean isDisposed() {
            return this.f16659f.get() == f16654i;
        }

        public void onComplete() {
            this.f16660g = true;
            if (this.f16659f.get() == null) {
                Throwable terminate = this.f16658e.terminate();
                if (terminate == null) {
                    this.f16655b.onComplete();
                } else {
                    this.f16655b.onError(terminate);
                }
            }
        }

        public void onError(Throwable th2) {
            if (!this.f16658e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (this.f16657d) {
                onComplete();
            } else {
                a();
                Throwable terminate = this.f16658e.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.f16655b.onError(terminate);
                }
            }
        }

        public void onNext(T t11) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.f16656c.apply(t11), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.f16659f.get();
                    if (switchMapInnerObserver == f16654i) {
                        return;
                    }
                } while (!b.a(this.f16659f, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.a();
                }
                completableSource.subscribe(switchMapInnerObserver2);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16661h.cancel();
                onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16661h, subscription)) {
                this.f16661h = subscription;
                this.f16655b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSwitchMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z11) {
        this.f16651b = flowable;
        this.f16652c = function;
        this.f16653d = z11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f16651b.subscribe(new SwitchMapCompletableObserver(completableObserver, this.f16652c, this.f16653d));
    }
}
