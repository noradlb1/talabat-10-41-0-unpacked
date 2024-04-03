package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends K> f17283c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends V> f17284d;

    /* renamed from: e  reason: collision with root package name */
    public final int f17285e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f17286f;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: j  reason: collision with root package name */
        public static final Object f17287j = new Object();
        private static final long serialVersionUID = -3688291656102519502L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super GroupedObservable<K, V>> f17288b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends K> f17289c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends V> f17290d;

        /* renamed from: e  reason: collision with root package name */
        public final int f17291e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f17292f;

        /* renamed from: g  reason: collision with root package name */
        public final Map<Object, GroupedUnicast<K, V>> f17293g;

        /* renamed from: h  reason: collision with root package name */
        public Disposable f17294h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicBoolean f17295i = new AtomicBoolean();

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i11, boolean z11) {
            this.f17288b = observer;
            this.f17289c = function;
            this.f17290d = function2;
            this.f17291e = i11;
            this.f17292f = z11;
            this.f17293g = new ConcurrentHashMap();
            lazySet(1);
        }

        public void cancel(K k11) {
            if (k11 == null) {
                k11 = f17287j;
            }
            this.f17293g.remove(k11);
            if (decrementAndGet() == 0) {
                this.f17294h.dispose();
            }
        }

        public void dispose() {
            if (this.f17295i.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f17294h.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f17295i.get();
        }

        public void onComplete() {
            ArrayList<GroupedUnicast> arrayList = new ArrayList<>(this.f17293g.values());
            this.f17293g.clear();
            for (GroupedUnicast onComplete : arrayList) {
                onComplete.onComplete();
            }
            this.f17288b.onComplete();
        }

        public void onError(Throwable th2) {
            ArrayList<GroupedUnicast> arrayList = new ArrayList<>(this.f17293g.values());
            this.f17293g.clear();
            for (GroupedUnicast onError : arrayList) {
                onError.onError(th2);
            }
            this.f17288b.onError(th2);
        }

        public void onNext(T t11) {
            Object obj;
            try {
                Object apply = this.f17289c.apply(t11);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = f17287j;
                }
                GroupedUnicast groupedUnicast = this.f17293g.get(obj);
                if (groupedUnicast == null) {
                    if (!this.f17295i.get()) {
                        groupedUnicast = GroupedUnicast.createWith(apply, this.f17291e, this, this.f17292f);
                        this.f17293g.put(obj, groupedUnicast);
                        getAndIncrement();
                        this.f17288b.onNext(groupedUnicast);
                    } else {
                        return;
                    }
                }
                try {
                    groupedUnicast.onNext(ObjectHelper.requireNonNull(this.f17290d.apply(t11), "The value supplied is null"));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f17294h.dispose();
                    onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f17294h.dispose();
                onError(th3);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17294h, disposable)) {
                this.f17294h = disposable;
                this.f17288b.onSubscribe(this);
            }
        }
    }

    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {

        /* renamed from: c  reason: collision with root package name */
        public final State<T, K> f17296c;

        public GroupedUnicast(K k11, State<T, K> state) {
            super(k11);
            this.f17296c = state;
        }

        public static <T, K> GroupedUnicast<K, T> createWith(K k11, int i11, GroupByObserver<?, K, T> groupByObserver, boolean z11) {
            return new GroupedUnicast<>(k11, new State(i11, groupByObserver, k11, z11));
        }

        public void onComplete() {
            this.f17296c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17296c.onError(th2);
        }

        public void onNext(T t11) {
            this.f17296c.onNext(t11);
        }

        public void subscribeActual(Observer<? super T> observer) {
            this.f17296c.subscribe(observer);
        }
    }

    public static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long serialVersionUID = -3852313036005250360L;

        /* renamed from: b  reason: collision with root package name */
        public final K f17297b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f17298c;

        /* renamed from: d  reason: collision with root package name */
        public final GroupByObserver<?, K, T> f17299d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f17300e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f17301f;

        /* renamed from: g  reason: collision with root package name */
        public Throwable f17302g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f17303h = new AtomicBoolean();

        /* renamed from: i  reason: collision with root package name */
        public final AtomicBoolean f17304i = new AtomicBoolean();

        /* renamed from: j  reason: collision with root package name */
        public final AtomicReference<Observer<? super T>> f17305j = new AtomicReference<>();

        public State(int i11, GroupByObserver<?, K, T> groupByObserver, K k11, boolean z11) {
            this.f17298c = new SpscLinkedArrayQueue<>(i11);
            this.f17299d = groupByObserver;
            this.f17297b = k11;
            this.f17300e = z11;
        }

        public boolean a(boolean z11, boolean z12, Observer<? super T> observer, boolean z13) {
            if (this.f17303h.get()) {
                this.f17298c.clear();
                this.f17299d.cancel(this.f17297b);
                this.f17305j.lazySet((Object) null);
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!z13) {
                    Throwable th2 = this.f17302g;
                    if (th2 != null) {
                        this.f17298c.clear();
                        this.f17305j.lazySet((Object) null);
                        observer.onError(th2);
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        this.f17305j.lazySet((Object) null);
                        observer.onComplete();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    Throwable th3 = this.f17302g;
                    this.f17305j.lazySet((Object) null);
                    if (th3 != null) {
                        observer.onError(th3);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
            }
        }

        public void b() {
            boolean z11;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f17298c;
                boolean z12 = this.f17300e;
                Observer observer = this.f17305j.get();
                int i11 = 1;
                while (true) {
                    if (observer != null) {
                        while (true) {
                            boolean z13 = this.f17301f;
                            T poll = spscLinkedArrayQueue.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (!a(z13, z11, observer, z12)) {
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
                            observer = this.f17305j.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public void dispose() {
            if (this.f17303h.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f17305j.lazySet((Object) null);
                this.f17299d.cancel(this.f17297b);
            }
        }

        public boolean isDisposed() {
            return this.f17303h.get();
        }

        public void onComplete() {
            this.f17301f = true;
            b();
        }

        public void onError(Throwable th2) {
            this.f17302g = th2;
            this.f17301f = true;
            b();
        }

        public void onNext(T t11) {
            this.f17298c.offer(t11);
            b();
        }

        public void subscribe(Observer<? super T> observer) {
            if (this.f17304i.compareAndSet(false, true)) {
                observer.onSubscribe(this);
                this.f17305j.lazySet(observer);
                if (this.f17303h.get()) {
                    this.f17305j.lazySet((Object) null);
                } else {
                    b();
                }
            } else {
                EmptyDisposable.error((Throwable) new IllegalStateException("Only one Observer allowed!"), (Observer<?>) observer);
            }
        }
    }

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i11, boolean z11) {
        super(observableSource);
        this.f17283c = function;
        this.f17284d = function2;
        this.f17285e = i11;
        this.f17286f = z11;
    }

    public void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.f16799b.subscribe(new GroupByObserver(observer, this.f17283c, this.f17284d, this.f17285e, this.f17286f));
    }
}
