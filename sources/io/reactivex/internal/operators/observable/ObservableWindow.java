package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindow<T> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17887c;

    /* renamed from: d  reason: collision with root package name */
    public final long f17888d;

    /* renamed from: e  reason: collision with root package name */
    public final int f17889e;

    public static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Observable<T>> f17890b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17891c;

        /* renamed from: d  reason: collision with root package name */
        public final int f17892d;

        /* renamed from: e  reason: collision with root package name */
        public long f17893e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f17894f;

        /* renamed from: g  reason: collision with root package name */
        public UnicastSubject<T> f17895g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f17896h;

        public WindowExactObserver(Observer<? super Observable<T>> observer, long j11, int i11) {
            this.f17890b = observer;
            this.f17891c = j11;
            this.f17892d = i11;
        }

        public void dispose() {
            this.f17896h = true;
        }

        public boolean isDisposed() {
            return this.f17896h;
        }

        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.f17895g;
            if (unicastSubject != null) {
                this.f17895g = null;
                unicastSubject.onComplete();
            }
            this.f17890b.onComplete();
        }

        public void onError(Throwable th2) {
            UnicastSubject<T> unicastSubject = this.f17895g;
            if (unicastSubject != null) {
                this.f17895g = null;
                unicastSubject.onError(th2);
            }
            this.f17890b.onError(th2);
        }

        public void onNext(T t11) {
            UnicastSubject<T> unicastSubject = this.f17895g;
            if (unicastSubject == null && !this.f17896h) {
                unicastSubject = UnicastSubject.create(this.f17892d, this);
                this.f17895g = unicastSubject;
                this.f17890b.onNext(unicastSubject);
            }
            if (unicastSubject != null) {
                unicastSubject.onNext(t11);
                long j11 = this.f17893e + 1;
                this.f17893e = j11;
                if (j11 >= this.f17891c) {
                    this.f17893e = 0;
                    this.f17895g = null;
                    unicastSubject.onComplete();
                    if (this.f17896h) {
                        this.f17894f.dispose();
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17894f, disposable)) {
                this.f17894f = disposable;
                this.f17890b.onSubscribe(this);
            }
        }

        public void run() {
            if (this.f17896h) {
                this.f17894f.dispose();
            }
        }
    }

    public static final class WindowSkipObserver<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Observable<T>> f17897b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17898c;

        /* renamed from: d  reason: collision with root package name */
        public final long f17899d;

        /* renamed from: e  reason: collision with root package name */
        public final int f17900e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayDeque<UnicastSubject<T>> f17901f;

        /* renamed from: g  reason: collision with root package name */
        public long f17902g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f17903h;

        /* renamed from: i  reason: collision with root package name */
        public long f17904i;

        /* renamed from: j  reason: collision with root package name */
        public Disposable f17905j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicInteger f17906k = new AtomicInteger();

        public WindowSkipObserver(Observer<? super Observable<T>> observer, long j11, long j12, int i11) {
            this.f17897b = observer;
            this.f17898c = j11;
            this.f17899d = j12;
            this.f17900e = i11;
            this.f17901f = new ArrayDeque<>();
        }

        public void dispose() {
            this.f17903h = true;
        }

        public boolean isDisposed() {
            return this.f17903h;
        }

        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f17901f;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.f17897b.onComplete();
        }

        public void onError(Throwable th2) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f17901f;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th2);
            }
            this.f17897b.onError(th2);
        }

        public void onNext(T t11) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f17901f;
            long j11 = this.f17902g;
            long j12 = this.f17899d;
            if (j11 % j12 == 0 && !this.f17903h) {
                this.f17906k.getAndIncrement();
                UnicastSubject create = UnicastSubject.create(this.f17900e, this);
                arrayDeque.offer(create);
                this.f17897b.onNext(create);
            }
            long j13 = this.f17904i + 1;
            Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t11);
            }
            if (j13 >= this.f17898c) {
                arrayDeque.poll().onComplete();
                if (!arrayDeque.isEmpty() || !this.f17903h) {
                    this.f17904i = j13 - j12;
                } else {
                    this.f17905j.dispose();
                    return;
                }
            } else {
                this.f17904i = j13;
            }
            this.f17902g = j11 + 1;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17905j, disposable)) {
                this.f17905j = disposable;
                this.f17897b.onSubscribe(this);
            }
        }

        public void run() {
            if (this.f17906k.decrementAndGet() == 0 && this.f17903h) {
                this.f17905j.dispose();
            }
        }
    }

    public ObservableWindow(ObservableSource<T> observableSource, long j11, long j12, int i11) {
        super(observableSource);
        this.f17887c = j11;
        this.f17888d = j12;
        this.f17889e = i11;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        if (this.f17887c == this.f17888d) {
            this.f16799b.subscribe(new WindowExactObserver(observer, this.f17887c, this.f17889e));
            return;
        }
        this.f16799b.subscribe(new WindowSkipObserver(observer, this.f17887c, this.f17888d, this.f17889e));
    }
}
