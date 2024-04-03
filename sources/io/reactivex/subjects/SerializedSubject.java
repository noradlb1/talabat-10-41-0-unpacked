package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;

final class SerializedSubject<T> extends Subject<T> implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {

    /* renamed from: b  reason: collision with root package name */
    public final Subject<T> f23647b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23648c;

    /* renamed from: d  reason: collision with root package name */
    public AppendOnlyLinkedArrayList<Object> f23649d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f23650e;

    public SerializedSubject(Subject<T> subject) {
        this.f23647b = subject;
    }

    public void a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f23649d;
                if (appendOnlyLinkedArrayList == null) {
                    this.f23648c = false;
                    return;
                }
                this.f23649d = null;
            }
            appendOnlyLinkedArrayList.forEachWhile(this);
        }
        while (true) {
        }
    }

    @Nullable
    public Throwable getThrowable() {
        return this.f23647b.getThrowable();
    }

    public boolean hasComplete() {
        return this.f23647b.hasComplete();
    }

    public boolean hasObservers() {
        return this.f23647b.hasObservers();
    }

    public boolean hasThrowable() {
        return this.f23647b.hasThrowable();
    }

    public void onComplete() {
        if (!this.f23650e) {
            synchronized (this) {
                if (!this.f23650e) {
                    this.f23650e = true;
                    if (this.f23648c) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23649d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23649d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f23648c = true;
                    this.f23647b.onComplete();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        if (r1 == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        io.reactivex.plugins.RxJavaPlugins.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r2.f23647b.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f23650e
            if (r0 == 0) goto L_0x0008
            io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f23650e     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x002d
        L_0x000f:
            r2.f23650e = r1     // Catch:{ all -> 0x003a }
            boolean r0 = r2.f23648c     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x002a
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f23649d     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x003a }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003a }
            r2.f23649d = r0     // Catch:{ all -> 0x003a }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x003a }
            r0.setFirst(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            return
        L_0x002a:
            r2.f23648c = r1     // Catch:{ all -> 0x003a }
            r1 = 0
        L_0x002d:
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0034
            io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0034:
            io.reactivex.subjects.Subject<T> r0 = r2.f23647b
            r0.onError(r3)
            return
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.SerializedSubject.onError(java.lang.Throwable):void");
    }

    public void onNext(T t11) {
        if (!this.f23650e) {
            synchronized (this) {
                if (!this.f23650e) {
                    if (this.f23648c) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23649d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23649d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t11));
                        return;
                    }
                    this.f23648c = true;
                    this.f23647b.onNext(t11);
                    a();
                }
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        boolean z11 = true;
        if (!this.f23650e) {
            synchronized (this) {
                if (!this.f23650e) {
                    if (this.f23648c) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23649d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23649d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.disposable(disposable));
                        return;
                    }
                    this.f23648c = true;
                    z11 = false;
                }
            }
        }
        if (z11) {
            disposable.dispose();
            return;
        }
        this.f23647b.onSubscribe(disposable);
        a();
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f23647b.subscribe(observer);
    }

    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.f23647b);
    }
}
