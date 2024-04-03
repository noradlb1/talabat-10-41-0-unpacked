package io.reactivex.internal.operators.observable;

import i.b;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, ObservablePublishClassic<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17461b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<PublishObserver<T>> f17462c;

    /* renamed from: d  reason: collision with root package name */
    public final ObservableSource<T> f17463d;

    public static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        private static final long serialVersionUID = -1100270633763673112L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17464b;

        public InnerDisposable(Observer<? super T> observer) {
            this.f17464b = observer;
        }

        public void a(PublishObserver<T> publishObserver) {
            if (!compareAndSet((Object) null, publishObserver)) {
                publishObserver.b(this);
            }
        }

        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((PublishObserver) andSet).b(this);
            }
        }

        public boolean isDisposed() {
            return get() == this;
        }
    }

    public static final class PublishObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        public static final InnerDisposable[] f17465f = new InnerDisposable[0];

        /* renamed from: g  reason: collision with root package name */
        public static final InnerDisposable[] f17466g = new InnerDisposable[0];

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<PublishObserver<T>> f17467b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<InnerDisposable<T>[]> f17468c = new AtomicReference<>(f17465f);

        /* renamed from: d  reason: collision with root package name */
        public final AtomicBoolean f17469d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Disposable> f17470e = new AtomicReference<>();

        public PublishObserver(AtomicReference<PublishObserver<T>> atomicReference) {
            this.f17467b = atomicReference;
            this.f17469d = new AtomicBoolean();
        }

        public boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) this.f17468c.get();
                if (innerDisposableArr == f17466g) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!b.a(this.f17468c, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public void b(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) this.f17468c.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            i11 = -1;
                            break;
                        } else if (innerDisposableArr[i11].equals(innerDisposable)) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i11 >= 0) {
                        if (length == 1) {
                            innerDisposableArr2 = f17465f;
                        } else {
                            InnerDisposable[] innerDisposableArr3 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i11);
                            System.arraycopy(innerDisposableArr, i11 + 1, innerDisposableArr3, i11, (length - i11) - 1);
                            innerDisposableArr2 = innerDisposableArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!b.a(this.f17468c, innerDisposableArr, innerDisposableArr2));
        }

        public void dispose() {
            AtomicReference<InnerDisposable<T>[]> atomicReference = this.f17468c;
            InnerDisposable[] innerDisposableArr = f17466g;
            if (((InnerDisposable[]) atomicReference.getAndSet(innerDisposableArr)) != innerDisposableArr) {
                b.a(this.f17467b, this, (Object) null);
                DisposableHelper.dispose(this.f17470e);
            }
        }

        public boolean isDisposed() {
            return this.f17468c.get() == f17466g;
        }

        public void onComplete() {
            b.a(this.f17467b, this, (Object) null);
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.f17468c.getAndSet(f17466g)) {
                innerDisposable.f17464b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            b.a(this.f17467b, this, (Object) null);
            InnerDisposable[] innerDisposableArr = (InnerDisposable[]) this.f17468c.getAndSet(f17466g);
            if (innerDisposableArr.length != 0) {
                for (InnerDisposable innerDisposable : innerDisposableArr) {
                    innerDisposable.f17464b.onError(th2);
                }
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.f17468c.get()) {
                innerDisposable.f17464b.onNext(t11);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f17470e, disposable);
        }
    }

    public static final class PublishSource<T> implements ObservableSource<T> {
        private final AtomicReference<PublishObserver<T>> curr;

        public PublishSource(AtomicReference<PublishObserver<T>> atomicReference) {
            this.curr = atomicReference;
        }

        public void subscribe(Observer<? super T> observer) {
            InnerDisposable innerDisposable = new InnerDisposable(observer);
            observer.onSubscribe(innerDisposable);
            while (true) {
                PublishObserver publishObserver = this.curr.get();
                if (publishObserver == null || publishObserver.isDisposed()) {
                    PublishObserver publishObserver2 = new PublishObserver(this.curr);
                    if (!b.a(this.curr, publishObserver, publishObserver2)) {
                        continue;
                    } else {
                        publishObserver = publishObserver2;
                    }
                }
                if (publishObserver.a(innerDisposable)) {
                    innerDisposable.a(publishObserver);
                    return;
                }
            }
        }
    }

    private ObservablePublish(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<PublishObserver<T>> atomicReference) {
        this.f17463d = observableSource;
        this.f17461b = observableSource2;
        this.f17462c = atomicReference;
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly(new ObservablePublish(new PublishSource(atomicReference), observableSource, atomicReference));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T>> r0 = r4.f17462c
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver r0 = (io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0021
        L_0x0010:
            io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver r1 = new io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T>> r2 = r4.f17462c
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T>> r2 = r4.f17462c
            boolean r0 = i.b.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0020
            goto L_0x0000
        L_0x0020:
            r0 = r1
        L_0x0021:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f17469d
            boolean r1 = r1.get()
            r2 = 0
            if (r1 != 0) goto L_0x0034
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f17469d
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0034
            r2 = r3
        L_0x0034:
            r5.accept(r0)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003e
            io.reactivex.ObservableSource<T> r5 = r4.f17461b
            r5.subscribe(r0)
        L_0x003e:
            return
        L_0x003f:
            r5 = move-exception
            io.reactivex.exceptions.Exceptions.throwIfFatal(r5)
            java.lang.RuntimeException r5 = io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservablePublish.connect(io.reactivex.functions.Consumer):void");
    }

    public ObservableSource<T> publishSource() {
        return this.f17461b;
    }

    public ObservableSource<T> source() {
        return this.f17461b;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f17463d.subscribe(observer);
    }
}
