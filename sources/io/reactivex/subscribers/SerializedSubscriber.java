package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super T> f23674b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f23675c;

    /* renamed from: d  reason: collision with root package name */
    public Subscription f23676d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23677e;

    /* renamed from: f  reason: collision with root package name */
    public AppendOnlyLinkedArrayList<Object> f23678f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f23679g;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    public void a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f23678f;
                if (appendOnlyLinkedArrayList == null) {
                    this.f23677e = false;
                    return;
                }
                this.f23678f = null;
            }
        } while (!appendOnlyLinkedArrayList.accept((Subscriber<? super U>) this.f23674b));
    }

    public void cancel() {
        this.f23676d.cancel();
    }

    public void onComplete() {
        if (!this.f23679g) {
            synchronized (this) {
                if (!this.f23679g) {
                    if (this.f23677e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23678f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23678f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f23679g = true;
                    this.f23677e = true;
                    this.f23674b.onComplete();
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
        r2.f23674b.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f23679g
            if (r0 == 0) goto L_0x0008
            io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f23679g     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f23677e     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f23679g = r1     // Catch:{ all -> 0x0044 }
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f23678f     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f23678f = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f23675c     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.add(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.setFirst(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f23679g = r1     // Catch:{ all -> 0x0044 }
            r2.f23677e = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x003e:
            org.reactivestreams.Subscriber<? super T> r0 = r2.f23674b
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subscribers.SerializedSubscriber.onError(java.lang.Throwable):void");
    }

    public void onNext(T t11) {
        if (!this.f23679g) {
            if (t11 == null) {
                this.f23676d.cancel();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f23679g) {
                    if (this.f23677e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23678f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23678f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t11));
                        return;
                    }
                    this.f23677e = true;
                    this.f23674b.onNext(t11);
                    a();
                }
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f23676d, subscription)) {
            this.f23676d = subscription;
            this.f23674b.onSubscribe(this);
        }
    }

    public void request(long j11) {
        this.f23676d.request(j11);
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z11) {
        this.f23674b = subscriber;
        this.f23675c = z11;
    }
}
