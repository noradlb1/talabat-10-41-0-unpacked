package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableTakeLastTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f22301c;

    /* renamed from: d  reason: collision with root package name */
    public final long f22302d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f22303e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f22304f;

    /* renamed from: g  reason: collision with root package name */
    public final int f22305g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f22306h;

    public static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22307b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22308c;

        /* renamed from: d  reason: collision with root package name */
        public final long f22309d;

        /* renamed from: e  reason: collision with root package name */
        public final TimeUnit f22310e;

        /* renamed from: f  reason: collision with root package name */
        public final Scheduler f22311f;

        /* renamed from: g  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f22312g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f22313h;

        /* renamed from: i  reason: collision with root package name */
        public Disposable f22314i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f22315j;

        /* renamed from: k  reason: collision with root package name */
        public Throwable f22316k;

        public TakeLastTimedObserver(Observer<? super T> observer, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
            this.f22307b = observer;
            this.f22308c = j11;
            this.f22309d = j12;
            this.f22310e = timeUnit;
            this.f22311f = scheduler;
            this.f22312g = new SpscLinkedArrayQueue<>(i11);
            this.f22313h = z11;
        }

        public void a() {
            boolean z11;
            Throwable th2;
            if (compareAndSet(false, true)) {
                Observer<? super T> observer = this.f22307b;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f22312g;
                boolean z12 = this.f22313h;
                long now = this.f22311f.now(this.f22310e) - this.f22309d;
                while (!this.f22315j) {
                    if (z12 || (th2 = this.f22316k) == null) {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11) {
                            Throwable th3 = this.f22316k;
                            if (th3 != null) {
                                observer.onError(th3);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        } else {
                            Object poll2 = spscLinkedArrayQueue.poll();
                            if (((Long) poll).longValue() >= now) {
                                observer.onNext(poll2);
                            }
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        observer.onError(th2);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void dispose() {
            if (!this.f22315j) {
                this.f22315j = true;
                this.f22314i.dispose();
                if (compareAndSet(false, true)) {
                    this.f22312g.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f22315j;
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th2) {
            this.f22316k = th2;
            a();
        }

        public void onNext(T t11) {
            boolean z11;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f22312g;
            long now = this.f22311f.now(this.f22310e);
            long j11 = this.f22309d;
            long j12 = this.f22308c;
            if (j12 == Long.MAX_VALUE) {
                z11 = true;
            } else {
                z11 = false;
            }
            spscLinkedArrayQueue.offer(Long.valueOf(now), t11);
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() <= now - j11 || (!z11 && ((long) (spscLinkedArrayQueue.size() >> 1)) > j12)) {
                    spscLinkedArrayQueue.poll();
                    spscLinkedArrayQueue.poll();
                } else {
                    return;
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22314i, disposable)) {
                this.f22314i = disposable;
                this.f22307b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
        super(observableSource);
        this.f22301c = j11;
        this.f22302d = j12;
        this.f22303e = timeUnit;
        this.f22304f = scheduler;
        this.f22305g = i11;
        this.f22306h = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new TakeLastTimedObserver(observer, this.f22301c, this.f22302d, this.f22303e, this.f22304f, this.f22305g, this.f22306h));
    }
}
