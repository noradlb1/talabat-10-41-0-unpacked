package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f17435c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f17436d;

    /* renamed from: e  reason: collision with root package name */
    public final int f17437e;

    public static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17438b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler.Worker f17439c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f17440d;

        /* renamed from: e  reason: collision with root package name */
        public final int f17441e;

        /* renamed from: f  reason: collision with root package name */
        public SimpleQueue<T> f17442f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f17443g;

        /* renamed from: h  reason: collision with root package name */
        public Throwable f17444h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f17445i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f17446j;

        /* renamed from: k  reason: collision with root package name */
        public int f17447k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f17448l;

        public ObserveOnObserver(Observer<? super T> observer, Scheduler.Worker worker, boolean z11, int i11) {
            this.f17438b = observer;
            this.f17439c = worker;
            this.f17440d = z11;
            this.f17441e = i11;
        }

        public boolean a(boolean z11, boolean z12, Observer<? super T> observer) {
            if (this.f17446j) {
                this.f17442f.clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                Throwable th2 = this.f17444h;
                if (this.f17440d) {
                    if (!z12) {
                        return false;
                    }
                    this.f17446j = true;
                    if (th2 != null) {
                        observer.onError(th2);
                    } else {
                        observer.onComplete();
                    }
                    this.f17439c.dispose();
                    return true;
                } else if (th2 != null) {
                    this.f17446j = true;
                    this.f17442f.clear();
                    observer.onError(th2);
                    this.f17439c.dispose();
                    return true;
                } else if (!z12) {
                    return false;
                } else {
                    this.f17446j = true;
                    observer.onComplete();
                    this.f17439c.dispose();
                    return true;
                }
            }
        }

        public void b() {
            int i11 = 1;
            while (!this.f17446j) {
                boolean z11 = this.f17445i;
                Throwable th2 = this.f17444h;
                if (this.f17440d || !z11 || th2 == null) {
                    this.f17438b.onNext(null);
                    if (z11) {
                        this.f17446j = true;
                        Throwable th3 = this.f17444h;
                        if (th3 != null) {
                            this.f17438b.onError(th3);
                        } else {
                            this.f17438b.onComplete();
                        }
                        this.f17439c.dispose();
                        return;
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else {
                    this.f17446j = true;
                    this.f17438b.onError(this.f17444h);
                    this.f17439c.dispose();
                    return;
                }
            }
        }

        public void c() {
            boolean z11;
            SimpleQueue<T> simpleQueue = this.f17442f;
            Observer<? super T> observer = this.f17438b;
            int i11 = 1;
            while (!a(this.f17445i, simpleQueue.isEmpty(), observer)) {
                while (true) {
                    boolean z12 = this.f17445i;
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
                        this.f17446j = true;
                        this.f17443g.dispose();
                        simpleQueue.clear();
                        observer.onError(th2);
                        this.f17439c.dispose();
                        return;
                    }
                }
            }
        }

        public void clear() {
            this.f17442f.clear();
        }

        public void d() {
            if (getAndIncrement() == 0) {
                this.f17439c.schedule(this);
            }
        }

        public void dispose() {
            if (!this.f17446j) {
                this.f17446j = true;
                this.f17443g.dispose();
                this.f17439c.dispose();
                if (!this.f17448l && getAndIncrement() == 0) {
                    this.f17442f.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f17446j;
        }

        public boolean isEmpty() {
            return this.f17442f.isEmpty();
        }

        public void onComplete() {
            if (!this.f17445i) {
                this.f17445i = true;
                d();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17445i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17444h = th2;
            this.f17445i = true;
            d();
        }

        public void onNext(T t11) {
            if (!this.f17445i) {
                if (this.f17447k != 2) {
                    this.f17442f.offer(t11);
                }
                d();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17443g, disposable)) {
                this.f17443g = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f17447k = requestFusion;
                        this.f17442f = queueDisposable;
                        this.f17445i = true;
                        this.f17438b.onSubscribe(this);
                        d();
                        return;
                    } else if (requestFusion == 2) {
                        this.f17447k = requestFusion;
                        this.f17442f = queueDisposable;
                        this.f17438b.onSubscribe(this);
                        return;
                    }
                }
                this.f17442f = new SpscLinkedArrayQueue(this.f17441e);
                this.f17438b.onSubscribe(this);
            }
        }

        @Nullable
        public T poll() throws Exception {
            return this.f17442f.poll();
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f17448l = true;
            return 2;
        }

        public void run() {
            if (this.f17448l) {
                b();
            } else {
                c();
            }
        }
    }

    public ObservableObserveOn(ObservableSource<T> observableSource, Scheduler scheduler, boolean z11, int i11) {
        super(observableSource);
        this.f17435c = scheduler;
        this.f17436d = z11;
        this.f17437e = i11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        Scheduler scheduler = this.f17435c;
        if (scheduler instanceof TrampolineScheduler) {
            this.f16799b.subscribe(observer);
            return;
        }
        this.f16799b.subscribe(new ObserveOnObserver(observer, scheduler.createWorker(), this.f17436d, this.f17437e));
    }
}
