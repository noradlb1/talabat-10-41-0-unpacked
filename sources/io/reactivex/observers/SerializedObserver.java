package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;

public final class SerializedObserver<T> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final Observer<? super T> f18658b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f18659c;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f18660d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18661e;

    /* renamed from: f  reason: collision with root package name */
    public AppendOnlyLinkedArrayList<Object> f18662f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f18663g;

    public SerializedObserver(@NonNull Observer<? super T> observer) {
        this(observer, false);
    }

    public void a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f18662f;
                if (appendOnlyLinkedArrayList == null) {
                    this.f18661e = false;
                    return;
                }
                this.f18662f = null;
            }
        } while (!appendOnlyLinkedArrayList.accept((Observer<? super U>) this.f18658b));
    }

    public void dispose() {
        this.f18660d.dispose();
    }

    public boolean isDisposed() {
        return this.f18660d.isDisposed();
    }

    public void onComplete() {
        if (!this.f18663g) {
            synchronized (this) {
                if (!this.f18663g) {
                    if (this.f18661e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f18662f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f18662f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f18663g = true;
                    this.f18661e = true;
                    this.f18658b.onComplete();
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
        io.reactivex.plugins.RxJavaPlugins.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.f18658b.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(@io.reactivex.annotations.NonNull java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f18663g
            if (r0 == 0) goto L_0x0008
            io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f18663g     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f18661e     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f18663g = r1     // Catch:{ all -> 0x0044 }
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f18662f     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f18662f = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f18659c     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.add(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.setFirst(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f18663g = r1     // Catch:{ all -> 0x0044 }
            r2.f18661e = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x003e:
            io.reactivex.Observer<? super T> r0 = r2.f18658b
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.SerializedObserver.onError(java.lang.Throwable):void");
    }

    public void onNext(@NonNull T t11) {
        if (!this.f18663g) {
            if (t11 == null) {
                this.f18660d.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f18663g) {
                    if (this.f18661e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f18662f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f18662f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t11));
                        return;
                    }
                    this.f18661e = true;
                    this.f18658b.onNext(t11);
                    a();
                }
            }
        }
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.f18660d, disposable)) {
            this.f18660d = disposable;
            this.f18658b.onSubscribe(this);
        }
    }

    public SerializedObserver(@NonNull Observer<? super T> observer, boolean z11) {
        this.f18658b = observer;
        this.f18659c = z11;
    }
}
