package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;

public final class SerializedObserver<T> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final Observer<? super T> f23218b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f23219c;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f23220d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23221e;

    /* renamed from: f  reason: collision with root package name */
    public AppendOnlyLinkedArrayList<Object> f23222f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f23223g;

    public SerializedObserver(@NonNull Observer<? super T> observer) {
        this(observer, false);
    }

    public void a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f23222f;
                if (appendOnlyLinkedArrayList == null) {
                    this.f23221e = false;
                    return;
                }
                this.f23222f = null;
            }
        } while (!appendOnlyLinkedArrayList.accept((Observer<? super U>) this.f23218b));
    }

    public void dispose() {
        this.f23223g = true;
        this.f23220d.dispose();
    }

    public boolean isDisposed() {
        return this.f23220d.isDisposed();
    }

    public void onComplete() {
        if (!this.f23223g) {
            synchronized (this) {
                if (!this.f23223g) {
                    if (this.f23221e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23222f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23222f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f23223g = true;
                    this.f23221e = true;
                    this.f23218b.onComplete();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.f23218b.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(@io.reactivex.rxjava3.annotations.NonNull java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f23223g
            if (r0 == 0) goto L_0x0008
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f23223g     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f23221e     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f23223g = r1     // Catch:{ all -> 0x0044 }
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f23222f     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f23222f = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.rxjava3.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f23219c     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.add(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.setFirst(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f23223g = r1     // Catch:{ all -> 0x0044 }
            r2.f23221e = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x003e:
            io.reactivex.rxjava3.core.Observer<? super T> r0 = r2.f23218b
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.observers.SerializedObserver.onError(java.lang.Throwable):void");
    }

    public void onNext(@NonNull T t11) {
        if (!this.f23223g) {
            if (t11 == null) {
                this.f23220d.dispose();
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                return;
            }
            synchronized (this) {
                if (!this.f23223g) {
                    if (this.f23221e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23222f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23222f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t11));
                        return;
                    }
                    this.f23221e = true;
                    this.f23218b.onNext(t11);
                    a();
                }
            }
        }
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.f23220d, disposable)) {
            this.f23220d = disposable;
            this.f23218b.onSubscribe(this);
        }
    }

    public SerializedObserver(@NonNull Observer<? super T> observer, boolean z11) {
        this.f23218b = observer;
        this.f23219c = z11;
    }
}
