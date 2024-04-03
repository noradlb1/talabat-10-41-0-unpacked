package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMapTry<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f18138a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<? super T, ? extends R> f18139b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f18140c;

    /* renamed from: io.reactivex.internal.operators.parallel.ParallelMapTry$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18141a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.reactivex.parallel.ParallelFailureHandling[] r0 = io.reactivex.parallel.ParallelFailureHandling.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18141a = r0
                io.reactivex.parallel.ParallelFailureHandling r1 = io.reactivex.parallel.ParallelFailureHandling.RETRY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f18141a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.parallel.ParallelFailureHandling r1 = io.reactivex.parallel.ParallelFailureHandling.SKIP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f18141a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.parallel.ParallelFailureHandling r1 = io.reactivex.parallel.ParallelFailureHandling.STOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelMapTry.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class ParallelMapTryConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final ConditionalSubscriber<? super R> f18142b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends R> f18143c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f18144d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f18145e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f18146f;

        public ParallelMapTryConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.f18142b = conditionalSubscriber;
            this.f18143c = function;
            this.f18144d = biFunction;
        }

        public void cancel() {
            this.f18145e.cancel();
        }

        public void onComplete() {
            if (!this.f18146f) {
                this.f18146f = true;
                this.f18142b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18146f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18146f = true;
            this.f18142b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11) && !this.f18146f) {
                this.f18145e.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18145e, subscription)) {
                this.f18145e = subscription;
                this.f18142b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f18145e.request(j11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.f18146f
                r1 = 0
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r2 = 0
            L_0x0008:
                io.reactivex.functions.Function<? super T, ? extends R> r0 = r9.f18143c     // Catch:{ all -> 0x001b }
                java.lang.Object r0 = r0.apply(r10)     // Catch:{ all -> 0x001b }
                java.lang.String r4 = "The mapper returned a null value"
                java.lang.Object r10 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r0, (java.lang.String) r4)     // Catch:{ all -> 0x001b }
                io.reactivex.internal.fuseable.ConditionalSubscriber<? super R> r0 = r9.f18142b
                boolean r10 = r0.tryOnNext(r10)
                return r10
            L_0x001b:
                r0 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r0)
                r4 = 1
                r5 = 2
                io.reactivex.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.parallel.ParallelFailureHandling> r6 = r9.f18144d     // Catch:{ all -> 0x0053 }
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0053 }
                java.lang.Object r6 = r6.apply(r7, r0)     // Catch:{ all -> 0x0053 }
                java.lang.String r7 = "The errorHandler returned a null item"
                java.lang.Object r6 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r6, (java.lang.String) r7)     // Catch:{ all -> 0x0053 }
                io.reactivex.parallel.ParallelFailureHandling r6 = (io.reactivex.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x0053 }
                int[] r7 = io.reactivex.internal.operators.parallel.ParallelMapTry.AnonymousClass1.f18141a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r4) goto L_0x0008
                if (r6 == r5) goto L_0x0052
                r10 = 3
                if (r6 == r10) goto L_0x004c
                r9.cancel()
                r9.onError(r0)
                return r1
            L_0x004c:
                r9.cancel()
                r9.onComplete()
            L_0x0052:
                return r1
            L_0x0053:
                r10 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r10)
                r9.cancel()
                io.reactivex.exceptions.CompositeException r2 = new io.reactivex.exceptions.CompositeException
                java.lang.Throwable[] r3 = new java.lang.Throwable[r5]
                r3[r1] = r0
                r3[r4] = r10
                r2.<init>((java.lang.Throwable[]) r3)
                r9.onError(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelMapTry.ParallelMapTryConditionalSubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public static final class ParallelMapTrySubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f18147b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends R> f18148c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f18149d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f18150e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f18151f;

        public ParallelMapTrySubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.f18147b = subscriber;
            this.f18148c = function;
            this.f18149d = biFunction;
        }

        public void cancel() {
            this.f18150e.cancel();
        }

        public void onComplete() {
            if (!this.f18151f) {
                this.f18151f = true;
                this.f18147b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18151f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18151f = true;
            this.f18147b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11) && !this.f18151f) {
                this.f18150e.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18150e, subscription)) {
                this.f18150e = subscription;
                this.f18147b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f18150e.request(j11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.f18151f
                r1 = 0
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r2 = 0
            L_0x0008:
                r0 = 1
                io.reactivex.functions.Function<? super T, ? extends R> r4 = r9.f18148c     // Catch:{ all -> 0x001b }
                java.lang.Object r4 = r4.apply(r10)     // Catch:{ all -> 0x001b }
                java.lang.String r5 = "The mapper returned a null value"
                java.lang.Object r10 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r4, (java.lang.String) r5)     // Catch:{ all -> 0x001b }
                org.reactivestreams.Subscriber<? super R> r1 = r9.f18147b
                r1.onNext(r10)
                return r0
            L_0x001b:
                r4 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r4)
                r5 = 2
                io.reactivex.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.parallel.ParallelFailureHandling> r6 = r9.f18149d     // Catch:{ all -> 0x0052 }
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0052 }
                java.lang.Object r6 = r6.apply(r7, r4)     // Catch:{ all -> 0x0052 }
                java.lang.String r7 = "The errorHandler returned a null item"
                java.lang.Object r6 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r6, (java.lang.String) r7)     // Catch:{ all -> 0x0052 }
                io.reactivex.parallel.ParallelFailureHandling r6 = (io.reactivex.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x0052 }
                int[] r7 = io.reactivex.internal.operators.parallel.ParallelMapTry.AnonymousClass1.f18141a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r0) goto L_0x0008
                if (r6 == r5) goto L_0x0051
                r10 = 3
                if (r6 == r10) goto L_0x004b
                r9.cancel()
                r9.onError(r4)
                return r1
            L_0x004b:
                r9.cancel()
                r9.onComplete()
            L_0x0051:
                return r1
            L_0x0052:
                r10 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r10)
                r9.cancel()
                io.reactivex.exceptions.CompositeException r2 = new io.reactivex.exceptions.CompositeException
                java.lang.Throwable[] r3 = new java.lang.Throwable[r5]
                r3[r1] = r4
                r3[r0] = r10
                r2.<init>((java.lang.Throwable[]) r3)
                r9.onError(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelMapTry.ParallelMapTrySubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public ParallelMapTry(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.f18138a = parallelFlowable;
        this.f18139b = function;
        this.f18140c = biFunction;
    }

    public int parallelism() {
        return this.f18138a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                ConditionalSubscriber conditionalSubscriber = subscriberArr[i11];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i11] = new ParallelMapTryConditionalSubscriber(conditionalSubscriber, this.f18139b, this.f18140c);
                } else {
                    subscriberArr2[i11] = new ParallelMapTrySubscriber(conditionalSubscriber, this.f18139b, this.f18140c);
                }
            }
            this.f18138a.subscribe(subscriberArr2);
        }
    }
}
