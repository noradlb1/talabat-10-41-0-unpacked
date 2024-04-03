package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSkipLastTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17686c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f17687d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f17688e;

    /* renamed from: f  reason: collision with root package name */
    public final int f17689f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f17690g;

    public static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17691b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17692c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f17693d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f17694e;

        /* renamed from: f  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f17695f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f17696g;

        /* renamed from: h  reason: collision with root package name */
        public Disposable f17697h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f17698i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f17699j;

        /* renamed from: k  reason: collision with root package name */
        public Throwable f17700k;

        public SkipLastTimedObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
            this.f17691b = observer;
            this.f17692c = j11;
            this.f17693d = timeUnit;
            this.f17694e = scheduler;
            this.f17695f = new SpscLinkedArrayQueue<>(i11);
            this.f17696g = z11;
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super T> observer = this.f17691b;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f17695f;
                boolean z12 = this.f17696g;
                TimeUnit timeUnit = this.f17693d;
                Scheduler scheduler = this.f17694e;
                long j11 = this.f17692c;
                int i11 = 1;
                while (!this.f17698i) {
                    boolean z13 = this.f17699j;
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
                            Throwable th2 = this.f17700k;
                            if (th2 != null) {
                                this.f17695f.clear();
                                observer.onError(th2);
                                return;
                            } else if (z11) {
                                observer.onComplete();
                                return;
                            }
                        } else if (z11) {
                            Throwable th3 = this.f17700k;
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
                this.f17695f.clear();
            }
        }

        public void dispose() {
            if (!this.f17698i) {
                this.f17698i = true;
                this.f17697h.dispose();
                if (getAndIncrement() == 0) {
                    this.f17695f.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f17698i;
        }

        public void onComplete() {
            this.f17699j = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f17700k = th2;
            this.f17699j = true;
            a();
        }

        public void onNext(T t11) {
            this.f17695f.offer(Long.valueOf(this.f17694e.now(this.f17693d)), t11);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17697h, disposable)) {
                this.f17697h = disposable;
                this.f17691b.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLastTimed(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
        super(observableSource);
        this.f17686c = j11;
        this.f17687d = timeUnit;
        this.f17688e = scheduler;
        this.f17689f = i11;
        this.f17690g = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new SkipLastTimedObserver(observer, this.f17686c, this.f17687d, this.f17688e, this.f17689f, this.f17690g));
    }
}
