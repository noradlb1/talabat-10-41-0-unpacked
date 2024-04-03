package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.NotificationLite;

final class SerializedSubject<T> extends Subject<T> implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {

    /* renamed from: b  reason: collision with root package name */
    public final Subject<T> f23452b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23453c;

    /* renamed from: d  reason: collision with root package name */
    public AppendOnlyLinkedArrayList<Object> f23454d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f23455e;

    public SerializedSubject(Subject<T> subject) {
        this.f23452b = subject;
    }

    public void a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f23454d;
                if (appendOnlyLinkedArrayList == null) {
                    this.f23453c = false;
                    return;
                }
                this.f23454d = null;
            }
            appendOnlyLinkedArrayList.forEachWhile(this);
        }
        while (true) {
        }
    }

    @Nullable
    public Throwable getThrowable() {
        return this.f23452b.getThrowable();
    }

    public boolean hasComplete() {
        return this.f23452b.hasComplete();
    }

    public boolean hasObservers() {
        return this.f23452b.hasObservers();
    }

    public boolean hasThrowable() {
        return this.f23452b.hasThrowable();
    }

    public void onComplete() {
        if (!this.f23455e) {
            synchronized (this) {
                if (!this.f23455e) {
                    this.f23455e = true;
                    if (this.f23453c) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23454d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23454d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f23453c = true;
                    this.f23452b.onComplete();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        if (r1 == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r2.f23452b.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f23455e
            if (r0 == 0) goto L_0x0008
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f23455e     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x002d
        L_0x000f:
            r2.f23455e = r1     // Catch:{ all -> 0x003a }
            boolean r0 = r2.f23453c     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x002a
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f23454d     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0021
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x003a }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003a }
            r2.f23454d = r0     // Catch:{ all -> 0x003a }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.rxjava3.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x003a }
            r0.setFirst(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            return
        L_0x002a:
            r2.f23453c = r1     // Catch:{ all -> 0x003a }
            r1 = 0
        L_0x002d:
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0034
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0034:
            io.reactivex.rxjava3.subjects.Subject<T> r0 = r2.f23452b
            r0.onError(r3)
            return
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.subjects.SerializedSubject.onError(java.lang.Throwable):void");
    }

    public void onNext(T t11) {
        if (!this.f23455e) {
            synchronized (this) {
                if (!this.f23455e) {
                    if (this.f23453c) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23454d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23454d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t11));
                        return;
                    }
                    this.f23453c = true;
                    this.f23452b.onNext(t11);
                    a();
                }
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        boolean z11 = true;
        if (!this.f23455e) {
            synchronized (this) {
                if (!this.f23455e) {
                    if (this.f23453c) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23454d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23454d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.disposable(disposable));
                        return;
                    }
                    this.f23453c = true;
                    z11 = false;
                }
            }
        }
        if (z11) {
            disposable.dispose();
            return;
        }
        this.f23452b.onSubscribe(disposable);
        a();
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f23452b.subscribe(observer);
    }

    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.f23452b);
    }
}
