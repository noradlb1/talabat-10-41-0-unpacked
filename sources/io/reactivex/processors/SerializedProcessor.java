package io.reactivex.processors;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

final class SerializedProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: c  reason: collision with root package name */
    public final FlowableProcessor<T> f18745c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18746d;

    /* renamed from: e  reason: collision with root package name */
    public AppendOnlyLinkedArrayList<Object> f18747e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f18748f;

    public SerializedProcessor(FlowableProcessor<T> flowableProcessor) {
        this.f18745c = flowableProcessor;
    }

    public void b() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f18747e;
                if (appendOnlyLinkedArrayList == null) {
                    this.f18746d = false;
                    return;
                }
                this.f18747e = null;
            }
            appendOnlyLinkedArrayList.accept((Subscriber<? super U>) this.f18745c);
        }
        while (true) {
        }
    }

    @Nullable
    public Throwable getThrowable() {
        return this.f18745c.getThrowable();
    }

    public boolean hasComplete() {
        return this.f18745c.hasComplete();
    }

    public boolean hasSubscribers() {
        return this.f18745c.hasSubscribers();
    }

    public boolean hasThrowable() {
        return this.f18745c.hasThrowable();
    }

    public void onComplete() {
        if (!this.f18748f) {
            synchronized (this) {
                if (!this.f18748f) {
                    this.f18748f = true;
                    if (this.f18746d) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f18747e;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f18747e = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f18746d = true;
                    this.f18745c.onComplete();
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
        r2.f18745c.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f18748f
            if (r0 == 0) goto L_0x0008
            io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f18748f     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x002d
        L_0x000f:
            r2.f18748f = r1     // Catch:{ all -> 0x003a }
            boolean r0 = r2.f18746d     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x002a
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f18747e     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x003a }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003a }
            r2.f18747e = r0     // Catch:{ all -> 0x003a }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x003a }
            r0.setFirst(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            return
        L_0x002a:
            r2.f18746d = r1     // Catch:{ all -> 0x003a }
            r1 = 0
        L_0x002d:
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0034
            io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0034:
            io.reactivex.processors.FlowableProcessor<T> r0 = r2.f18745c
            r0.onError(r3)
            return
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.SerializedProcessor.onError(java.lang.Throwable):void");
    }

    public void onNext(T t11) {
        if (!this.f18748f) {
            synchronized (this) {
                if (!this.f18748f) {
                    if (this.f18746d) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f18747e;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f18747e = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t11));
                        return;
                    }
                    this.f18746d = true;
                    this.f18745c.onNext(t11);
                    b();
                }
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        boolean z11 = true;
        if (!this.f18748f) {
            synchronized (this) {
                if (!this.f18748f) {
                    if (this.f18746d) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f18747e;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f18747e = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.subscription(subscription));
                        return;
                    }
                    this.f18746d = true;
                    z11 = false;
                }
            }
        }
        if (z11) {
            subscription.cancel();
            return;
        }
        this.f18745c.onSubscribe(subscription);
        b();
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f18745c.subscribe(subscriber);
    }
}
