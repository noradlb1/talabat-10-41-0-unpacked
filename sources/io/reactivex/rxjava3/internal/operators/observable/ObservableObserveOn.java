package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f21982c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21983d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21984e;

    public static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21985b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler.Worker f21986c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f21987d;

        /* renamed from: e  reason: collision with root package name */
        public final int f21988e;

        /* renamed from: f  reason: collision with root package name */
        public SimpleQueue<T> f21989f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f21990g;

        /* renamed from: h  reason: collision with root package name */
        public Throwable f21991h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f21992i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f21993j;

        /* renamed from: k  reason: collision with root package name */
        public int f21994k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f21995l;

        public ObserveOnObserver(Observer<? super T> observer, Scheduler.Worker worker, boolean z11, int i11) {
            this.f21985b = observer;
            this.f21986c = worker;
            this.f21987d = z11;
            this.f21988e = i11;
        }

        public boolean a(boolean z11, boolean z12, Observer<? super T> observer) {
            if (this.f21993j) {
                this.f21989f.clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                Throwable th2 = this.f21991h;
                if (this.f21987d) {
                    if (!z12) {
                        return false;
                    }
                    this.f21993j = true;
                    if (th2 != null) {
                        observer.onError(th2);
                    } else {
                        observer.onComplete();
                    }
                    this.f21986c.dispose();
                    return true;
                } else if (th2 != null) {
                    this.f21993j = true;
                    this.f21989f.clear();
                    observer.onError(th2);
                    this.f21986c.dispose();
                    return true;
                } else if (!z12) {
                    return false;
                } else {
                    this.f21993j = true;
                    observer.onComplete();
                    this.f21986c.dispose();
                    return true;
                }
            }
        }

        public void b() {
            int i11 = 1;
            while (!this.f21993j) {
                boolean z11 = this.f21992i;
                Throwable th2 = this.f21991h;
                if (this.f21987d || !z11 || th2 == null) {
                    this.f21985b.onNext(null);
                    if (z11) {
                        this.f21993j = true;
                        Throwable th3 = this.f21991h;
                        if (th3 != null) {
                            this.f21985b.onError(th3);
                        } else {
                            this.f21985b.onComplete();
                        }
                        this.f21986c.dispose();
                        return;
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    this.f21993j = true;
                    this.f21985b.onError(this.f21991h);
                    this.f21986c.dispose();
                    return;
                }
            }
        }

        public void c() {
            boolean z11;
            SimpleQueue<T> simpleQueue = this.f21989f;
            Observer<? super T> observer = this.f21985b;
            int i11 = 1;
            while (!a(this.f21992i, simpleQueue.isEmpty(), observer)) {
                while (true) {
                    boolean z12 = this.f21992i;
                    try {
                        T poll = simpleQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!a(z12, z11, observer)) {
                            if (z11) {
                                i11 = addAndGet(-i11);
                                if (i11 == 0) {
                                    return;
                                }
                            } else {
                                observer.onNext(poll);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f21993j = true;
                        this.f21990g.dispose();
                        simpleQueue.clear();
                        observer.onError(th2);
                        this.f21986c.dispose();
                        return;
                    }
                }
            }
        }

        public void clear() {
            this.f21989f.clear();
        }

        public void d() {
            if (getAndIncrement() == 0) {
                this.f21986c.schedule(this);
            }
        }

        public void dispose() {
            if (!this.f21993j) {
                this.f21993j = true;
                this.f21990g.dispose();
                this.f21986c.dispose();
                if (!this.f21995l && getAndIncrement() == 0) {
                    this.f21989f.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f21993j;
        }

        public boolean isEmpty() {
            return this.f21989f.isEmpty();
        }

        public void onComplete() {
            if (!this.f21992i) {
                this.f21992i = true;
                d();
            }
        }

        public void onError(Throwable th2) {
            if (this.f21992i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21991h = th2;
            this.f21992i = true;
            d();
        }

        public void onNext(T t11) {
            if (!this.f21992i) {
                if (this.f21994k != 2) {
                    this.f21989f.offer(t11);
                }
                d();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21990g, disposable)) {
                this.f21990g = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f21994k = requestFusion;
                        this.f21989f = queueDisposable;
                        this.f21992i = true;
                        this.f21985b.onSubscribe(this);
                        d();
                        return;
                    } else if (requestFusion == 2) {
                        this.f21994k = requestFusion;
                        this.f21989f = queueDisposable;
                        this.f21985b.onSubscribe(this);
                        return;
                    }
                }
                this.f21989f = new SpscLinkedArrayQueue(this.f21988e);
                this.f21985b.onSubscribe(this);
            }
        }

        @Nullable
        public T poll() throws Throwable {
            return this.f21989f.poll();
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f21995l = true;
            return 2;
        }

        public void run() {
            if (this.f21995l) {
                b();
            } else {
                c();
            }
        }
    }

    public ObservableObserveOn(ObservableSource<T> observableSource, Scheduler scheduler, boolean z11, int i11) {
        super(observableSource);
        this.f21982c = scheduler;
        this.f21983d = z11;
        this.f21984e = i11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        Scheduler scheduler = this.f21982c;
        if (scheduler instanceof TrampolineScheduler) {
            this.f21304b.subscribe(observer);
            return;
        }
        this.f21304b.subscribe(new ObserveOnObserver(observer, scheduler.createWorker(), this.f21983d, this.f21984e));
    }
}
