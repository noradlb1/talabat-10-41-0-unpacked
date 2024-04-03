package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.stream.Stream;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableFlatMapStream<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f18924b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends Stream<? extends R>> f18925c;

    public static final class FlatMapStreamObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5127032662980523968L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f18926b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Stream<? extends R>> f18927c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f18928d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f18929e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f18930f;

        public FlatMapStreamObserver(Observer<? super R> observer, Function<? super T, ? extends Stream<? extends R>> function) {
            this.f18926b = observer;
            this.f18927c = function;
        }

        public void dispose() {
            this.f18929e = true;
            this.f18928d.dispose();
        }

        public boolean isDisposed() {
            return this.f18929e;
        }

        public void onComplete() {
            if (!this.f18930f) {
                this.f18930f = true;
                this.f18926b.onComplete();
            }
        }

        public void onError(@NonNull Throwable th2) {
            if (this.f18930f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18930f = true;
            this.f18926b.onError(th2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r5.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x004e, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(@io.reactivex.rxjava3.annotations.NonNull T r5) {
            /*
                r4 = this;
                boolean r0 = r4.f18930f
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                io.reactivex.rxjava3.functions.Function<? super T, ? extends j$.util.stream.Stream<? extends R>> r0 = r4.f18927c     // Catch:{ all -> 0x004f }
                java.lang.Object r5 = r0.apply(r5)     // Catch:{ all -> 0x004f }
                java.lang.String r0 = "The mapper returned a null Stream"
                java.util.Objects.requireNonNull(r5, r0)     // Catch:{ all -> 0x004f }
                j$.util.stream.Stream r5 = (j$.util.stream.Stream) r5     // Catch:{ all -> 0x004f }
                java.util.Iterator r0 = r5.iterator()     // Catch:{ all -> 0x0043 }
            L_0x0016:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0043 }
                if (r1 == 0) goto L_0x003f
                boolean r1 = r4.f18929e     // Catch:{ all -> 0x0043 }
                r2 = 1
                if (r1 == 0) goto L_0x0024
                r4.f18930f = r2     // Catch:{ all -> 0x0043 }
                goto L_0x003f
            L_0x0024:
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0043 }
                java.lang.String r3 = "The Stream's Iterator.next returned a null value"
                java.util.Objects.requireNonNull(r1, r3)     // Catch:{ all -> 0x0043 }
                boolean r3 = r4.f18929e     // Catch:{ all -> 0x0043 }
                if (r3 == 0) goto L_0x0034
                r4.f18930f = r2     // Catch:{ all -> 0x0043 }
                goto L_0x003f
            L_0x0034:
                io.reactivex.rxjava3.core.Observer<? super R> r3 = r4.f18926b     // Catch:{ all -> 0x0043 }
                r3.onNext(r1)     // Catch:{ all -> 0x0043 }
                boolean r1 = r4.f18929e     // Catch:{ all -> 0x0043 }
                if (r1 == 0) goto L_0x0016
                r4.f18930f = r2     // Catch:{ all -> 0x0043 }
            L_0x003f:
                r5.close()     // Catch:{ all -> 0x004f }
                goto L_0x005b
            L_0x0043:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0045 }
            L_0x0045:
                r1 = move-exception
                r5.close()     // Catch:{ all -> 0x004a }
                goto L_0x004e
            L_0x004a:
                r5 = move-exception
                r0.addSuppressed(r5)     // Catch:{ all -> 0x004f }
            L_0x004e:
                throw r1     // Catch:{ all -> 0x004f }
            L_0x004f:
                r5 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r5)
                io.reactivex.rxjava3.disposables.Disposable r0 = r4.f18928d
                r0.dispose()
                r4.onError(r5)
            L_0x005b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ObservableFlatMapStream.FlatMapStreamObserver.onNext(java.lang.Object):void");
        }

        public void onSubscribe(@NonNull Disposable disposable) {
            if (DisposableHelper.validate(this.f18928d, disposable)) {
                this.f18928d = disposable;
                this.f18926b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapStream(Observable<T> observable, Function<? super T, ? extends Stream<? extends R>> function) {
        this.f18924b = observable;
        this.f18925c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        Stream stream;
        Observable<T> observable = this.f18924b;
        if (observable instanceof Supplier) {
            try {
                Object obj = ((Supplier) observable).get();
                if (obj != null) {
                    Object apply = this.f18925c.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                    stream = (Stream) apply;
                } else {
                    stream = null;
                }
                if (stream != null) {
                    ObservableFromStream.subscribeStream(observer, stream);
                } else {
                    EmptyDisposable.complete((Observer<?>) observer);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptyDisposable.error(th2, (Observer<?>) observer);
            }
        } else {
            observable.subscribe((Observer<? super T>) new FlatMapStreamObserver(observer, this.f18925c));
        }
    }
}
