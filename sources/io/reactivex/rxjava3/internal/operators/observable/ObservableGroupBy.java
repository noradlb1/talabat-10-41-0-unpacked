package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.observables.GroupedObservable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends K> f21816c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends V> f21817d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21818e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f21819f;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: j  reason: collision with root package name */
        public static final Object f21820j = new Object();
        private static final long serialVersionUID = -3688291656102519502L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super GroupedObservable<K, V>> f21821b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends K> f21822c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends V> f21823d;

        /* renamed from: e  reason: collision with root package name */
        public final int f21824e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f21825f;

        /* renamed from: g  reason: collision with root package name */
        public final Map<Object, GroupedUnicast<K, V>> f21826g;

        /* renamed from: h  reason: collision with root package name */
        public Disposable f21827h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicBoolean f21828i = new AtomicBoolean();

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i11, boolean z11) {
            this.f21821b = observer;
            this.f21822c = function;
            this.f21823d = function2;
            this.f21824e = i11;
            this.f21825f = z11;
            this.f21826g = new ConcurrentHashMap();
            lazySet(1);
        }

        public void cancel(K k11) {
            if (k11 == null) {
                k11 = f21820j;
            }
            this.f21826g.remove(k11);
            if (decrementAndGet() == 0) {
                this.f21827h.dispose();
            }
        }

        public void dispose() {
            if (this.f21828i.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f21827h.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f21828i.get();
        }

        public void onComplete() {
            ArrayList<GroupedUnicast> arrayList = new ArrayList<>(this.f21826g.values());
            this.f21826g.clear();
            for (GroupedUnicast onComplete : arrayList) {
                onComplete.onComplete();
            }
            this.f21821b.onComplete();
        }

        public void onError(Throwable th2) {
            ArrayList<GroupedUnicast> arrayList = new ArrayList<>(this.f21826g.values());
            this.f21826g.clear();
            for (GroupedUnicast onError : arrayList) {
                onError.onError(th2);
            }
            this.f21821b.onError(th2);
        }

        public void onNext(T t11) {
            Object obj;
            boolean z11;
            try {
                Object apply = this.f21822c.apply(t11);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = f21820j;
                }
                GroupedUnicast groupedUnicast = this.f21826g.get(obj);
                if (groupedUnicast != null) {
                    z11 = false;
                } else if (!this.f21828i.get()) {
                    groupedUnicast = GroupedUnicast.createWith(apply, this.f21824e, this, this.f21825f);
                    this.f21826g.put(obj, groupedUnicast);
                    getAndIncrement();
                    z11 = true;
                } else {
                    return;
                }
                try {
                    Object apply2 = this.f21823d.apply(t11);
                    Objects.requireNonNull(apply2, "The value supplied is null");
                    groupedUnicast.onNext(apply2);
                    if (z11) {
                        this.f21821b.onNext(groupedUnicast);
                        if (groupedUnicast.f21829c.d()) {
                            cancel(apply);
                            groupedUnicast.onComplete();
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f21827h.dispose();
                    if (z11) {
                        this.f21821b.onNext(groupedUnicast);
                    }
                    onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f21827h.dispose();
                onError(th3);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21827h, disposable)) {
                this.f21827h = disposable;
                this.f21821b.onSubscribe(this);
            }
        }
    }

    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {

        /* renamed from: c  reason: collision with root package name */
        public final State<T, K> f21829c;

        public GroupedUnicast(K k11, State<T, K> state) {
            super(k11);
            this.f21829c = state;
        }

        public static <T, K> GroupedUnicast<K, T> createWith(K k11, int i11, GroupByObserver<?, K, T> groupByObserver, boolean z11) {
            return new GroupedUnicast<>(k11, new State(i11, groupByObserver, k11, z11));
        }

        public void onComplete() {
            this.f21829c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21829c.onError(th2);
        }

        public void onNext(T t11) {
            this.f21829c.onNext(t11);
        }

        public void subscribeActual(Observer<? super T> observer) {
            this.f21829c.subscribe(observer);
        }
    }

    public static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long serialVersionUID = -3852313036005250360L;

        /* renamed from: b  reason: collision with root package name */
        public final K f21830b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f21831c;

        /* renamed from: d  reason: collision with root package name */
        public final GroupByObserver<?, K, T> f21832d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f21833e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f21834f;

        /* renamed from: g  reason: collision with root package name */
        public Throwable f21835g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f21836h = new AtomicBoolean();

        /* renamed from: i  reason: collision with root package name */
        public final AtomicReference<Observer<? super T>> f21837i = new AtomicReference<>();

        /* renamed from: j  reason: collision with root package name */
        public final AtomicInteger f21838j = new AtomicInteger();

        public State(int i11, GroupByObserver<?, K, T> groupByObserver, K k11, boolean z11) {
            this.f21831c = new SpscLinkedArrayQueue<>(i11);
            this.f21832d = groupByObserver;
            this.f21830b = k11;
            this.f21833e = z11;
        }

        public void a() {
            if ((this.f21838j.get() & 2) == 0) {
                this.f21832d.cancel(this.f21830b);
            }
        }

        public boolean b(boolean z11, boolean z12, Observer<? super T> observer, boolean z13) {
            if (this.f21836h.get()) {
                this.f21831c.clear();
                this.f21837i.lazySet((Object) null);
                a();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!z13) {
                    Throwable th2 = this.f21835g;
                    if (th2 != null) {
                        this.f21831c.clear();
                        this.f21837i.lazySet((Object) null);
                        observer.onError(th2);
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        this.f21837i.lazySet((Object) null);
                        observer.onComplete();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    Throwable th3 = this.f21835g;
                    this.f21837i.lazySet((Object) null);
                    if (th3 != null) {
                        observer.onError(th3);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
            }
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f21831c;
                boolean z12 = this.f21833e;
                Observer observer = this.f21837i.get();
                int i11 = 1;
                while (true) {
                    if (observer != null) {
                        while (true) {
                            boolean z13 = this.f21834f;
                            T poll = spscLinkedArrayQueue.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (!b(z13, z11, observer, z12)) {
                                if (z11) {
                                    break;
                                }
                                observer.onNext(poll);
                            } else {
                                return;
                            }
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 != 0) {
                        if (observer == null) {
                            observer = this.f21837i.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public boolean d() {
            return this.f21838j.get() == 0 && this.f21838j.compareAndSet(0, 2);
        }

        public void dispose() {
            if (this.f21836h.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f21837i.lazySet((Object) null);
                a();
            }
        }

        public boolean isDisposed() {
            return this.f21836h.get();
        }

        public void onComplete() {
            this.f21834f = true;
            c();
        }

        public void onError(Throwable th2) {
            this.f21835g = th2;
            this.f21834f = true;
            c();
        }

        public void onNext(T t11) {
            this.f21831c.offer(t11);
            c();
        }

        public void subscribe(Observer<? super T> observer) {
            int i11;
            do {
                i11 = this.f21838j.get();
                if ((i11 & 1) != 0) {
                    EmptyDisposable.error((Throwable) new IllegalStateException("Only one Observer allowed!"), (Observer<?>) observer);
                    return;
                }
            } while (!this.f21838j.compareAndSet(i11, i11 | 1));
            observer.onSubscribe(this);
            this.f21837i.lazySet(observer);
            if (this.f21836h.get()) {
                this.f21837i.lazySet((Object) null);
            } else {
                c();
            }
        }
    }

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i11, boolean z11) {
        super(observableSource);
        this.f21816c = function;
        this.f21817d = function2;
        this.f21818e = i11;
        this.f21819f = z11;
    }

    public void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.f21304b.subscribe(new GroupByObserver(observer, this.f21816c, this.f21817d, this.f21818e, this.f21819f));
    }
}
