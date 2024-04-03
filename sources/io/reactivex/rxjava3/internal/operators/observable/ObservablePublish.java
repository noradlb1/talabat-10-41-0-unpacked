package io.reactivex.rxjava3.internal.operators.observable;

import i.b;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f22010b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<PublishConnection<T>> f22011c = new AtomicReference<>();

    public static final class InnerDisposable<T> extends AtomicReference<PublishConnection<T>> implements Disposable {
        private static final long serialVersionUID = 7463222674719692880L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22012b;

        public InnerDisposable(Observer<? super T> observer, PublishConnection<T> publishConnection) {
            this.f22012b = observer;
            lazySet(publishConnection);
        }

        public void dispose() {
            PublishConnection publishConnection = (PublishConnection) getAndSet((Object) null);
            if (publishConnection != null) {
                publishConnection.remove(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    public static final class PublishConnection<T> extends AtomicReference<InnerDisposable<T>[]> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        public static final InnerDisposable[] f22013f = new InnerDisposable[0];

        /* renamed from: g  reason: collision with root package name */
        public static final InnerDisposable[] f22014g = new InnerDisposable[0];
        private static final long serialVersionUID = -3251430252873581268L;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f22015b = new AtomicBoolean();

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<PublishConnection<T>> f22016c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Disposable> f22017d;

        /* renamed from: e  reason: collision with root package name */
        public Throwable f22018e;

        public PublishConnection(AtomicReference<PublishConnection<T>> atomicReference) {
            this.f22016c = atomicReference;
            this.f22017d = new AtomicReference<>();
            lazySet(f22013f);
        }

        public boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) get();
                if (innerDisposableArr == f22014g) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public void dispose() {
            getAndSet(f22014g);
            b.a(this.f22016c, this, (Object) null);
            DisposableHelper.dispose(this.f22017d);
        }

        public boolean isDisposed() {
            return get() == f22014g;
        }

        public void onComplete() {
            this.f22017d.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable innerDisposable : (InnerDisposable[]) getAndSet(f22014g)) {
                innerDisposable.f22012b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            Disposable disposable = this.f22017d.get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.f22018e = th2;
                this.f22017d.lazySet(disposableHelper);
                for (InnerDisposable innerDisposable : (InnerDisposable[]) getAndSet(f22014g)) {
                    innerDisposable.f22012b.onError(th2);
                }
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            for (InnerDisposable innerDisposable : (InnerDisposable[]) get()) {
                innerDisposable.f22012b.onNext(t11);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f22017d, disposable);
        }

        public void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            i11 = -1;
                            break;
                        } else if (innerDisposableArr[i11] == innerDisposable) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i11 >= 0) {
                        innerDisposableArr2 = f22013f;
                        if (length != 1) {
                            innerDisposableArr2 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, i11);
                            System.arraycopy(innerDisposableArr, i11 + 1, innerDisposableArr2, i11, (length - i11) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
        }
    }

    public ObservablePublish(ObservableSource<T> observableSource) {
        this.f22010b = observableSource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.rxjava3.functions.Consumer<? super io.reactivex.rxjava3.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r0 = r4.f22011c
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection r0 = (io.reactivex.rxjava3.internal.operators.observable.ObservablePublish.PublishConnection) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0021
        L_0x0010:
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection r1 = new io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r2 = r4.f22011c
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r2 = r4.f22011c
            boolean r0 = i.b.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0020
            goto L_0x0000
        L_0x0020:
            r0 = r1
        L_0x0021:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f22015b
            boolean r1 = r1.get()
            r2 = 0
            if (r1 != 0) goto L_0x0034
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f22015b
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0034
            r2 = r3
        L_0x0034:
            r5.accept(r0)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003e
            io.reactivex.rxjava3.core.ObservableSource<T> r5 = r4.f22010b
            r5.subscribe(r0)
        L_0x003e:
            return
        L_0x003f:
            r5 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r5)
            java.lang.RuntimeException r5 = io.reactivex.rxjava3.internal.util.ExceptionHelper.wrapOrThrow(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservablePublish.connect(io.reactivex.rxjava3.functions.Consumer):void");
    }

    public void reset() {
        PublishConnection publishConnection = this.f22011c.get();
        if (publishConnection != null && publishConnection.isDisposed()) {
            b.a(this.f22011c, publishConnection, (Object) null);
        }
    }

    public ObservableSource<T> source() {
        return this.f22010b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void subscribeActual(io.reactivex.rxjava3.core.Observer<? super T> r4) {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r0 = r3.f22011c
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection r0 = (io.reactivex.rxjava3.internal.operators.observable.ObservablePublish.PublishConnection) r0
            if (r0 != 0) goto L_0x001b
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection r1 = new io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r2 = r3.f22011c
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r2 = r3.f22011c
            boolean r0 = i.b.a(r2, r0, r1)
            if (r0 != 0) goto L_0x001a
            goto L_0x0000
        L_0x001a:
            r0 = r1
        L_0x001b:
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$InnerDisposable r1 = new io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$InnerDisposable
            r1.<init>(r4, r0)
            r4.onSubscribe(r1)
            boolean r2 = r0.add(r1)
            if (r2 == 0) goto L_0x0033
            boolean r4 = r1.isDisposed()
            if (r4 == 0) goto L_0x0032
            r0.remove(r1)
        L_0x0032:
            return
        L_0x0033:
            java.lang.Throwable r0 = r0.f22018e
            if (r0 == 0) goto L_0x003b
            r4.onError(r0)
            goto L_0x003e
        L_0x003b:
            r4.onComplete()
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservablePublish.subscribeActual(io.reactivex.rxjava3.core.Observer):void");
    }
}
