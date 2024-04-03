package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableConcatMapEager<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f17019c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f17020d;

    /* renamed from: e  reason: collision with root package name */
    public final int f17021e;

    /* renamed from: f  reason: collision with root package name */
    public final int f17022f;

    public static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {
        private static final long serialVersionUID = 8080567949447303262L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f17023b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f17024c;

        /* renamed from: d  reason: collision with root package name */
        public final int f17025d;

        /* renamed from: e  reason: collision with root package name */
        public final int f17026e;

        /* renamed from: f  reason: collision with root package name */
        public final ErrorMode f17027f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f17028g = new AtomicThrowable();

        /* renamed from: h  reason: collision with root package name */
        public final ArrayDeque<InnerQueuedObserver<R>> f17029h = new ArrayDeque<>();

        /* renamed from: i  reason: collision with root package name */
        public SimpleQueue<T> f17030i;

        /* renamed from: j  reason: collision with root package name */
        public Disposable f17031j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f17032k;

        /* renamed from: l  reason: collision with root package name */
        public int f17033l;

        /* renamed from: m  reason: collision with root package name */
        public volatile boolean f17034m;

        /* renamed from: n  reason: collision with root package name */
        public InnerQueuedObserver<R> f17035n;

        /* renamed from: o  reason: collision with root package name */
        public int f17036o;

        public ConcatMapEagerMainObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i11, int i12, ErrorMode errorMode) {
            this.f17023b = observer;
            this.f17024c = function;
            this.f17025d = i11;
            this.f17026e = i12;
            this.f17027f = errorMode;
        }

        public void a() {
            InnerQueuedObserver<R> innerQueuedObserver = this.f17035n;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver poll = this.f17029h.poll();
                if (poll != null) {
                    poll.dispose();
                } else {
                    return;
                }
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                do {
                    this.f17030i.clear();
                    a();
                } while (decrementAndGet() != 0);
            }
        }

        public void dispose() {
            if (!this.f17034m) {
                this.f17034m = true;
                this.f17031j.dispose();
                b();
            }
        }

        public void drain() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.f17030i;
                ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.f17029h;
                Observer<? super R> observer = this.f17023b;
                ErrorMode errorMode = this.f17027f;
                int i11 = 1;
                while (true) {
                    int i12 = this.f17036o;
                    while (true) {
                        if (i12 == this.f17025d) {
                            break;
                        } else if (this.f17034m) {
                            simpleQueue.clear();
                            a();
                            return;
                        } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f17028g.get()) == null) {
                            try {
                                T poll = simpleQueue.poll();
                                if (poll == null) {
                                    break;
                                }
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17024c.apply(poll), "The mapper returned a null ObservableSource");
                                InnerQueuedObserver innerQueuedObserver = new InnerQueuedObserver(this, this.f17026e);
                                arrayDeque.offer(innerQueuedObserver);
                                observableSource.subscribe(innerQueuedObserver);
                                i12++;
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f17031j.dispose();
                                simpleQueue.clear();
                                a();
                                this.f17028g.addThrowable(th2);
                                observer.onError(this.f17028g.terminate());
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            a();
                            observer.onError(this.f17028g.terminate());
                            return;
                        }
                    }
                    this.f17036o = i12;
                    if (this.f17034m) {
                        simpleQueue.clear();
                        a();
                        return;
                    } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f17028g.get()) == null) {
                        InnerQueuedObserver<R> innerQueuedObserver2 = this.f17035n;
                        if (innerQueuedObserver2 == null) {
                            if (errorMode != ErrorMode.BOUNDARY || ((Throwable) this.f17028g.get()) == null) {
                                boolean z13 = this.f17032k;
                                InnerQueuedObserver<R> poll2 = arrayDeque.poll();
                                if (poll2 == null) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                if (!z13 || !z12) {
                                    if (!z12) {
                                        this.f17035n = poll2;
                                    }
                                    innerQueuedObserver2 = poll2;
                                } else if (((Throwable) this.f17028g.get()) != null) {
                                    simpleQueue.clear();
                                    a();
                                    observer.onError(this.f17028g.terminate());
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            } else {
                                simpleQueue.clear();
                                a();
                                observer.onError(this.f17028g.terminate());
                                return;
                            }
                        }
                        if (innerQueuedObserver2 != null) {
                            SimpleQueue<R> queue = innerQueuedObserver2.queue();
                            while (!this.f17034m) {
                                boolean isDone = innerQueuedObserver2.isDone();
                                if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f17028g.get()) == null) {
                                    try {
                                        R poll3 = queue.poll();
                                        if (poll3 == null) {
                                            z11 = true;
                                        } else {
                                            z11 = false;
                                        }
                                        if (isDone && z11) {
                                            this.f17035n = null;
                                            this.f17036o--;
                                        } else if (!z11) {
                                            observer.onNext(poll3);
                                        }
                                    } catch (Throwable th3) {
                                        Exceptions.throwIfFatal(th3);
                                        this.f17028g.addThrowable(th3);
                                        this.f17035n = null;
                                        this.f17036o--;
                                    }
                                } else {
                                    simpleQueue.clear();
                                    a();
                                    observer.onError(this.f17028g.terminate());
                                    return;
                                }
                            }
                            simpleQueue.clear();
                            a();
                            return;
                        }
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        simpleQueue.clear();
                        a();
                        observer.onError(this.f17028g.terminate());
                        return;
                    }
                }
            }
        }

        public void innerComplete(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.setDone();
            drain();
        }

        public void innerError(InnerQueuedObserver<R> innerQueuedObserver, Throwable th2) {
            if (this.f17028g.addThrowable(th2)) {
                if (this.f17027f == ErrorMode.IMMEDIATE) {
                    this.f17031j.dispose();
                }
                innerQueuedObserver.setDone();
                drain();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r11) {
            innerQueuedObserver.queue().offer(r11);
            drain();
        }

        public boolean isDisposed() {
            return this.f17034m;
        }

        public void onComplete() {
            this.f17032k = true;
            drain();
        }

        public void onError(Throwable th2) {
            if (this.f17028g.addThrowable(th2)) {
                this.f17032k = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f17033l == 0) {
                this.f17030i.offer(t11);
            }
            drain();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17031j, disposable)) {
                this.f17031j = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f17033l = requestFusion;
                        this.f17030i = queueDisposable;
                        this.f17032k = true;
                        this.f17023b.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.f17033l = requestFusion;
                        this.f17030i = queueDisposable;
                        this.f17023b.onSubscribe(this);
                        return;
                    }
                }
                this.f17030i = new SpscLinkedArrayQueue(this.f17026e);
                this.f17023b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapEager(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, ErrorMode errorMode, int i11, int i12) {
        super(observableSource);
        this.f17019c = function;
        this.f17020d = errorMode;
        this.f17021e = i11;
        this.f17022f = i12;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f16799b.subscribe(new ConcatMapEagerMainObserver(observer, this.f17019c, this.f17021e, this.f17022f, this.f17020d));
    }
}
