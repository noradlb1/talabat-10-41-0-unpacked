package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

final class SerializedProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: c  reason: collision with root package name */
    public final FlowableProcessor<T> f23343c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23344d;

    /* renamed from: e  reason: collision with root package name */
    public AppendOnlyLinkedArrayList<Object> f23345e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f23346f;

    public SerializedProcessor(FlowableProcessor<T> flowableProcessor) {
        this.f23343c = flowableProcessor;
    }

    public void b() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f23345e;
                if (appendOnlyLinkedArrayList == null) {
                    this.f23344d = false;
                    return;
                }
                this.f23345e = null;
            }
            appendOnlyLinkedArrayList.accept((Subscriber<? super U>) this.f23343c);
        }
        while (true) {
        }
    }

    @Nullable
    public Throwable getThrowable() {
        return this.f23343c.getThrowable();
    }

    public boolean hasComplete() {
        return this.f23343c.hasComplete();
    }

    public boolean hasSubscribers() {
        return this.f23343c.hasSubscribers();
    }

    public boolean hasThrowable() {
        return this.f23343c.hasThrowable();
    }

    public void onComplete() {
        if (!this.f23346f) {
            synchronized (this) {
                if (!this.f23346f) {
                    this.f23346f = true;
                    if (this.f23344d) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23345e;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23345e = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f23344d = true;
                    this.f23343c.onComplete();
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
        r2.f23343c.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f23346f
            if (r0 == 0) goto L_0x0008
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f23346f     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x002d
        L_0x000f:
            r2.f23346f = r1     // Catch:{ all -> 0x003a }
            boolean r0 = r2.f23344d     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x002a
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f23345e     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0021
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x003a }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003a }
            r2.f23345e = r0     // Catch:{ all -> 0x003a }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.rxjava3.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x003a }
            r0.setFirst(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            return
        L_0x002a:
            r2.f23344d = r1     // Catch:{ all -> 0x003a }
            r1 = 0
        L_0x002d:
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0034
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0034:
            io.reactivex.rxjava3.processors.FlowableProcessor<T> r0 = r2.f23343c
            r0.onError(r3)
            return
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.SerializedProcessor.onError(java.lang.Throwable):void");
    }

    public void onNext(T t11) {
        if (!this.f23346f) {
            synchronized (this) {
                if (!this.f23346f) {
                    if (this.f23344d) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23345e;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23345e = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t11));
                        return;
                    }
                    this.f23344d = true;
                    this.f23343c.onNext(t11);
                    b();
                }
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        boolean z11 = true;
        if (!this.f23346f) {
            synchronized (this) {
                if (!this.f23346f) {
                    if (this.f23344d) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23345e;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23345e = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.subscription(subscription));
                        return;
                    }
                    this.f23344d = true;
                    z11 = false;
                }
            }
        }
        if (z11) {
            subscription.cancel();
            return;
        }
        this.f23343c.onSubscribe(subscription);
        b();
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f23343c.subscribe(subscriber);
    }
}
