package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableTakeLastTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17758c;

    /* renamed from: d  reason: collision with root package name */
    public final long f17759d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f17760e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f17761f;

    /* renamed from: g  reason: collision with root package name */
    public final int f17762g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f17763h;

    public static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17764b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17765c;

        /* renamed from: d  reason: collision with root package name */
        public final long f17766d;

        /* renamed from: e  reason: collision with root package name */
        public final TimeUnit f17767e;

        /* renamed from: f  reason: collision with root package name */
        public final Scheduler f17768f;

        /* renamed from: g  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f17769g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f17770h;

        /* renamed from: i  reason: collision with root package name */
        public Disposable f17771i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f17772j;

        /* renamed from: k  reason: collision with root package name */
        public Throwable f17773k;

        public TakeLastTimedObserver(Observer<? super T> observer, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
            this.f17764b = observer;
            this.f17765c = j11;
            this.f17766d = j12;
            this.f17767e = timeUnit;
            this.f17768f = scheduler;
            this.f17769g = new SpscLinkedArrayQueue<>(i11);
            this.f17770h = z11;
        }

        public void a() {
            boolean z11;
            Throwable th2;
            if (compareAndSet(false, true)) {
                Observer<? super T> observer = this.f17764b;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f17769g;
                boolean z12 = this.f17770h;
                long now = this.f17768f.now(this.f17767e) - this.f17766d;
                while (!this.f17772j) {
                    if (z12 || (th2 = this.f17773k) == null) {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11) {
                            Throwable th3 = this.f17773k;
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
            if (!this.f17772j) {
                this.f17772j = true;
                this.f17771i.dispose();
                if (compareAndSet(false, true)) {
                    this.f17769g.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f17772j;
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th2) {
            this.f17773k = th2;
            a();
        }

        public void onNext(T t11) {
            boolean z11;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f17769g;
            long now = this.f17768f.now(this.f17767e);
            long j11 = this.f17766d;
            long j12 = this.f17765c;
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
            if (DisposableHelper.validate(this.f17771i, disposable)) {
                this.f17771i = disposable;
                this.f17764b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
        super(observableSource);
        this.f17758c = j11;
        this.f17759d = j12;
        this.f17760e = timeUnit;
        this.f17761f = scheduler;
        this.f17762g = i11;
        this.f17763h = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new TakeLastTimedObserver(observer, this.f17758c, this.f17759d, this.f17760e, this.f17761f, this.f17762g, this.f17763h));
    }
}
