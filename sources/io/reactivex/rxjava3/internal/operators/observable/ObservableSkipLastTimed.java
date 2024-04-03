package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSkipLastTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f22229c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f22230d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f22231e;

    /* renamed from: f  reason: collision with root package name */
    public final int f22232f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f22233g;

    public static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22234b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22235c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f22236d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f22237e;

        /* renamed from: f  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f22238f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f22239g;

        /* renamed from: h  reason: collision with root package name */
        public Disposable f22240h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f22241i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f22242j;

        /* renamed from: k  reason: collision with root package name */
        public Throwable f22243k;

        public SkipLastTimedObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
            this.f22234b = observer;
            this.f22235c = j11;
            this.f22236d = timeUnit;
            this.f22237e = scheduler;
            this.f22238f = new SpscLinkedArrayQueue<>(i11);
            this.f22239g = z11;
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super T> observer = this.f22234b;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f22238f;
                boolean z12 = this.f22239g;
                TimeUnit timeUnit = this.f22236d;
                Scheduler scheduler = this.f22237e;
                long j11 = this.f22235c;
                int i11 = 1;
                while (!this.f22241i) {
                    boolean z13 = this.f22242j;
                    Long l11 = (Long) spscLinkedArrayQueue.peek();
                    if (l11 == null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    long now = scheduler.now(timeUnit);
                    if (!z11 && l11.longValue() > now - j11) {
                        z11 = true;
                    }
                    if (z13) {
                        if (!z12) {
                            Throwable th2 = this.f22243k;
                            if (th2 != null) {
                                this.f22238f.clear();
                                observer.onError(th2);
                                return;
                            } else if (z11) {
                                observer.onComplete();
                                return;
                            }
                        } else if (z11) {
                            Throwable th3 = this.f22243k;
                            if (th3 != null) {
                                observer.onError(th3);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                    }
                    if (z11) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        spscLinkedArrayQueue.poll();
                        observer.onNext(spscLinkedArrayQueue.poll());
                    }
                }
                this.f22238f.clear();
            }
        }

        public void dispose() {
            if (!this.f22241i) {
                this.f22241i = true;
                this.f22240h.dispose();
                if (getAndIncrement() == 0) {
                    this.f22238f.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f22241i;
        }

        public void onComplete() {
            this.f22242j = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f22243k = th2;
            this.f22242j = true;
            a();
        }

        public void onNext(T t11) {
            this.f22238f.offer(Long.valueOf(this.f22237e.now(this.f22236d)), t11);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22240h, disposable)) {
                this.f22240h = disposable;
                this.f22234b.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLastTimed(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
        super(observableSource);
        this.f22229c = j11;
        this.f22230d = timeUnit;
        this.f22231e = scheduler;
        this.f22232f = i11;
        this.f22233g = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new SkipLastTimedObserver(observer, this.f22229c, this.f22230d, this.f22231e, this.f22232f, this.f22233g));
    }
}
