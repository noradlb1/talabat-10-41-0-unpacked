package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.InnerQueuedObserver;
import io.reactivex.rxjava3.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableConcatMapEager<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f21515c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f21516d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21517e;

    /* renamed from: f  reason: collision with root package name */
    public final int f21518f;

    public static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {
        private static final long serialVersionUID = 8080567949447303262L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21519b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f21520c;

        /* renamed from: d  reason: collision with root package name */
        public final int f21521d;

        /* renamed from: e  reason: collision with root package name */
        public final int f21522e;

        /* renamed from: f  reason: collision with root package name */
        public final ErrorMode f21523f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f21524g = new AtomicThrowable();

        /* renamed from: h  reason: collision with root package name */
        public final ArrayDeque<InnerQueuedObserver<R>> f21525h = new ArrayDeque<>();

        /* renamed from: i  reason: collision with root package name */
        public SimpleQueue<T> f21526i;

        /* renamed from: j  reason: collision with root package name */
        public Disposable f21527j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f21528k;

        /* renamed from: l  reason: collision with root package name */
        public int f21529l;

        /* renamed from: m  reason: collision with root package name */
        public volatile boolean f21530m;

        /* renamed from: n  reason: collision with root package name */
        public InnerQueuedObserver<R> f21531n;

        /* renamed from: o  reason: collision with root package name */
        public int f21532o;

        public ConcatMapEagerMainObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i11, int i12, ErrorMode errorMode) {
            this.f21519b = observer;
            this.f21520c = function;
            this.f21521d = i11;
            this.f21522e = i12;
            this.f21523f = errorMode;
        }

        public void a() {
            InnerQueuedObserver<R> innerQueuedObserver = this.f21531n;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver poll = this.f21525h.poll();
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
                    this.f21526i.clear();
                    a();
                } while (decrementAndGet() != 0);
            }
        }

        public void dispose() {
            if (!this.f21530m) {
                this.f21530m = true;
                this.f21527j.dispose();
                this.f21524g.tryTerminateAndReport();
                b();
            }
        }

        public void drain() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.f21526i;
                ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.f21525h;
                Observer<? super R> observer = this.f21519b;
                ErrorMode errorMode = this.f21523f;
                int i11 = 1;
                while (true) {
                    int i12 = this.f21532o;
                    while (true) {
                        if (i12 == this.f21521d) {
                            break;
                        } else if (this.f21530m) {
                            simpleQueue.clear();
                            a();
                            return;
                        } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f21524g.get()) == null) {
                            try {
                                T poll = simpleQueue.poll();
                                if (poll == null) {
                                    break;
                                }
                                Object apply = this.f21520c.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                InnerQueuedObserver innerQueuedObserver = new InnerQueuedObserver(this, this.f21522e);
                                arrayDeque.offer(innerQueuedObserver);
                                observableSource.subscribe(innerQueuedObserver);
                                i12++;
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f21527j.dispose();
                                simpleQueue.clear();
                                a();
                                this.f21524g.tryAddThrowableOrReport(th2);
                                this.f21524g.tryTerminateConsumer((Observer<?>) this.f21519b);
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            a();
                            this.f21524g.tryTerminateConsumer((Observer<?>) this.f21519b);
                            return;
                        }
                    }
                    this.f21532o = i12;
                    if (this.f21530m) {
                        simpleQueue.clear();
                        a();
                        return;
                    } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f21524g.get()) == null) {
                        InnerQueuedObserver<R> innerQueuedObserver2 = this.f21531n;
                        if (innerQueuedObserver2 == null) {
                            if (errorMode != ErrorMode.BOUNDARY || ((Throwable) this.f21524g.get()) == null) {
                                boolean z13 = this.f21528k;
                                InnerQueuedObserver<R> poll2 = arrayDeque.poll();
                                if (poll2 == null) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                if (!z13 || !z12) {
                                    if (!z12) {
                                        this.f21531n = poll2;
                                    }
                                    innerQueuedObserver2 = poll2;
                                } else if (((Throwable) this.f21524g.get()) != null) {
                                    simpleQueue.clear();
                                    a();
                                    this.f21524g.tryTerminateConsumer((Observer<?>) observer);
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            } else {
                                simpleQueue.clear();
                                a();
                                this.f21524g.tryTerminateConsumer((Observer<?>) observer);
                                return;
                            }
                        }
                        if (innerQueuedObserver2 != null) {
                            SimpleQueue<R> queue = innerQueuedObserver2.queue();
                            while (!this.f21530m) {
                                boolean isDone = innerQueuedObserver2.isDone();
                                if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f21524g.get()) == null) {
                                    try {
                                        R poll3 = queue.poll();
                                        if (poll3 == null) {
                                            z11 = true;
                                        } else {
                                            z11 = false;
                                        }
                                        if (isDone && z11) {
                                            this.f21531n = null;
                                            this.f21532o--;
                                        } else if (!z11) {
                                            observer.onNext(poll3);
                                        }
                                    } catch (Throwable th3) {
                                        Exceptions.throwIfFatal(th3);
                                        this.f21524g.tryAddThrowableOrReport(th3);
                                        this.f21531n = null;
                                        this.f21532o--;
                                    }
                                } else {
                                    simpleQueue.clear();
                                    a();
                                    this.f21524g.tryTerminateConsumer((Observer<?>) observer);
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
                        this.f21524g.tryTerminateConsumer((Observer<?>) this.f21519b);
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
            if (this.f21524g.tryAddThrowableOrReport(th2)) {
                if (this.f21523f == ErrorMode.IMMEDIATE) {
                    this.f21527j.dispose();
                }
                innerQueuedObserver.setDone();
                drain();
            }
        }

        public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r11) {
            innerQueuedObserver.queue().offer(r11);
            drain();
        }

        public boolean isDisposed() {
            return this.f21530m;
        }

        public void onComplete() {
            this.f21528k = true;
            drain();
        }

        public void onError(Throwable th2) {
            if (this.f21524g.tryAddThrowableOrReport(th2)) {
                this.f21528k = true;
                drain();
            }
        }

        public void onNext(T t11) {
            if (this.f21529l == 0) {
                this.f21526i.offer(t11);
            }
            drain();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21527j, disposable)) {
                this.f21527j = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f21529l = requestFusion;
                        this.f21526i = queueDisposable;
                        this.f21528k = true;
                        this.f21519b.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.f21529l = requestFusion;
                        this.f21526i = queueDisposable;
                        this.f21519b.onSubscribe(this);
                        return;
                    }
                }
                this.f21526i = new SpscLinkedArrayQueue(this.f21522e);
                this.f21519b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapEager(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, ErrorMode errorMode, int i11, int i12) {
        super(observableSource);
        this.f21515c = function;
        this.f21516d = errorMode;
        this.f21517e = i11;
        this.f21518f = i12;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f21304b.subscribe(new ConcatMapEagerMainObserver(observer, this.f21515c, this.f21517e, this.f21518f, this.f21516d));
    }
}
