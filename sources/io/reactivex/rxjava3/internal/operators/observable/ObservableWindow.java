package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindow<T> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    public final long f22429c;

    /* renamed from: d  reason: collision with root package name */
    public final long f22430d;

    /* renamed from: e  reason: collision with root package name */
    public final int f22431e;

    public static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Observable<T>> f22432b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22433c;

        /* renamed from: d  reason: collision with root package name */
        public final int f22434d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f22435e = new AtomicBoolean();

        /* renamed from: f  reason: collision with root package name */
        public long f22436f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f22437g;

        /* renamed from: h  reason: collision with root package name */
        public UnicastSubject<T> f22438h;

        public WindowExactObserver(Observer<? super Observable<T>> observer, long j11, int i11) {
            this.f22432b = observer;
            this.f22433c = j11;
            this.f22434d = i11;
            lazySet(1);
        }

        public void dispose() {
            if (this.f22435e.compareAndSet(false, true)) {
                run();
            }
        }

        public boolean isDisposed() {
            return this.f22435e.get();
        }

        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.f22438h;
            if (unicastSubject != null) {
                this.f22438h = null;
                unicastSubject.onComplete();
            }
            this.f22432b.onComplete();
        }

        public void onError(Throwable th2) {
            UnicastSubject<T> unicastSubject = this.f22438h;
            if (unicastSubject != null) {
                this.f22438h = null;
                unicastSubject.onError(th2);
            }
            this.f22432b.onError(th2);
        }

        public void onNext(T t11) {
            ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept;
            UnicastSubject<T> unicastSubject = this.f22438h;
            if (unicastSubject != null || this.f22435e.get()) {
                observableWindowSubscribeIntercept = null;
            } else {
                getAndIncrement();
                unicastSubject = UnicastSubject.create(this.f22434d, this);
                this.f22438h = unicastSubject;
                observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(unicastSubject);
                this.f22432b.onNext(observableWindowSubscribeIntercept);
            }
            if (unicastSubject != null) {
                unicastSubject.onNext(t11);
                long j11 = this.f22436f + 1;
                this.f22436f = j11;
                if (j11 >= this.f22433c) {
                    this.f22436f = 0;
                    this.f22438h = null;
                    unicastSubject.onComplete();
                }
                if (observableWindowSubscribeIntercept != null && observableWindowSubscribeIntercept.a()) {
                    this.f22438h = null;
                    unicastSubject.onComplete();
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22437g, disposable)) {
                this.f22437g = disposable;
                this.f22432b.onSubscribe(this);
            }
        }

        public void run() {
            if (decrementAndGet() == 0) {
                this.f22437g.dispose();
            }
        }
    }

    public static final class WindowSkipObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Observable<T>> f22439b;

        /* renamed from: c  reason: collision with root package name */
        public final long f22440c;

        /* renamed from: d  reason: collision with root package name */
        public final long f22441d;

        /* renamed from: e  reason: collision with root package name */
        public final int f22442e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayDeque<UnicastSubject<T>> f22443f = new ArrayDeque<>();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicBoolean f22444g = new AtomicBoolean();

        /* renamed from: h  reason: collision with root package name */
        public long f22445h;

        /* renamed from: i  reason: collision with root package name */
        public long f22446i;

        /* renamed from: j  reason: collision with root package name */
        public Disposable f22447j;

        public WindowSkipObserver(Observer<? super Observable<T>> observer, long j11, long j12, int i11) {
            this.f22439b = observer;
            this.f22440c = j11;
            this.f22441d = j12;
            this.f22442e = i11;
            lazySet(1);
        }

        public void dispose() {
            if (this.f22444g.compareAndSet(false, true)) {
                run();
            }
        }

        public boolean isDisposed() {
            return this.f22444g.get();
        }

        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f22443f;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.f22439b.onComplete();
        }

        public void onError(Throwable th2) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f22443f;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th2);
            }
            this.f22439b.onError(th2);
        }

        public void onNext(T t11) {
            ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept;
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f22443f;
            long j11 = this.f22445h;
            long j12 = this.f22441d;
            if (j11 % j12 != 0 || this.f22444g.get()) {
                observableWindowSubscribeIntercept = null;
            } else {
                getAndIncrement();
                UnicastSubject create = UnicastSubject.create(this.f22442e, this);
                observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(create);
                arrayDeque.offer(create);
                this.f22439b.onNext(observableWindowSubscribeIntercept);
            }
            long j13 = this.f22446i + 1;
            Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t11);
            }
            if (j13 >= this.f22440c) {
                arrayDeque.poll().onComplete();
                if (!arrayDeque.isEmpty() || !this.f22444g.get()) {
                    this.f22446i = j13 - j12;
                } else {
                    return;
                }
            } else {
                this.f22446i = j13;
            }
            this.f22445h = j11 + 1;
            if (observableWindowSubscribeIntercept != null && observableWindowSubscribeIntercept.a()) {
                observableWindowSubscribeIntercept.f22488b.onComplete();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22447j, disposable)) {
                this.f22447j = disposable;
                this.f22439b.onSubscribe(this);
            }
        }

        public void run() {
            if (decrementAndGet() == 0) {
                this.f22447j.dispose();
            }
        }
    }

    public ObservableWindow(ObservableSource<T> observableSource, long j11, long j12, int i11) {
        super(observableSource);
        this.f22429c = j11;
        this.f22430d = j12;
        this.f22431e = i11;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        if (this.f22429c == this.f22430d) {
            this.f21304b.subscribe(new WindowExactObserver(observer, this.f22429c, this.f22431e));
            return;
        }
        this.f21304b.subscribe(new WindowSkipObserver(observer, this.f22429c, this.f22430d, this.f22431e));
    }
}
