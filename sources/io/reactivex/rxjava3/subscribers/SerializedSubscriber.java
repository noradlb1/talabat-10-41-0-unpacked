package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super T> f23479b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f23480c;

    /* renamed from: d  reason: collision with root package name */
    public Subscription f23481d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23482e;

    /* renamed from: f  reason: collision with root package name */
    public AppendOnlyLinkedArrayList<Object> f23483f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f23484g;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    public void a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f23483f;
                if (appendOnlyLinkedArrayList == null) {
                    this.f23482e = false;
                    return;
                }
                this.f23483f = null;
            }
        } while (!appendOnlyLinkedArrayList.accept((Subscriber<? super U>) this.f23479b));
    }

    public void cancel() {
        this.f23481d.cancel();
    }

    public void onComplete() {
        if (!this.f23484g) {
            synchronized (this) {
                if (!this.f23484g) {
                    if (this.f23482e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23483f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23483f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f23484g = true;
                    this.f23482e = true;
                    this.f23479b.onComplete();
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
        r2.f23479b.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f23484g
            if (r0 == 0) goto L_0x0008
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f23484g     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f23482e     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f23484g = r1     // Catch:{ all -> 0x0044 }
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f23483f     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f23483f = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.rxjava3.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f23480c     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.add(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.setFirst(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f23484g = r1     // Catch:{ all -> 0x0044 }
            r2.f23482e = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x003e:
            org.reactivestreams.Subscriber<? super T> r0 = r2.f23479b
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.subscribers.SerializedSubscriber.onError(java.lang.Throwable):void");
    }

    public void onNext(@NonNull T t11) {
        if (!this.f23484g) {
            if (t11 == null) {
                this.f23481d.cancel();
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                return;
            }
            synchronized (this) {
                if (!this.f23484g) {
                    if (this.f23482e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f23483f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f23483f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t11));
                        return;
                    }
                    this.f23482e = true;
                    this.f23479b.onNext(t11);
                    a();
                }
            }
        }
    }

    public void onSubscribe(@NonNull Subscription subscription) {
        if (SubscriptionHelper.validate(this.f23481d, subscription)) {
            this.f23481d = subscription;
            this.f23479b.onSubscribe(this);
        }
    }

    public void request(long j11) {
        this.f23481d.request(j11);
    }

    public SerializedSubscriber(@NonNull Subscriber<? super T> subscriber, boolean z11) {
        this.f23479b = subscriber;
        this.f23480c = z11;
    }
}
