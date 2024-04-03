package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Optional;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMapTryOptional<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f18977a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<? super T, Optional<? extends R>> f18978b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f18979c;

    /* renamed from: io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18980a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.reactivex.rxjava3.parallel.ParallelFailureHandling[] r0 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18980a = r0
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.RETRY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f18980a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.SKIP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f18980a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.STOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class ParallelMapTryConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final ConditionalSubscriber<? super R> f18981b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, Optional<? extends R>> f18982c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f18983d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f18984e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f18985f;

        public ParallelMapTryConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, Optional<? extends R>> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.f18981b = conditionalSubscriber;
            this.f18982c = function;
            this.f18983d = biFunction;
        }

        public void cancel() {
            this.f18984e.cancel();
        }

        public void onComplete() {
            if (!this.f18985f) {
                this.f18985f = true;
                this.f18981b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18985f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18985f = true;
            this.f18981b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11) && !this.f18985f) {
                this.f18984e.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18984e, subscription)) {
                this.f18984e = subscription;
                this.f18981b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f18984e.request(j11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.f18985f
                r1 = 0
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r2 = 0
            L_0x0008:
                r0 = 1
                io.reactivex.rxjava3.functions.Function<? super T, j$.util.Optional<? extends R>> r4 = r9.f18982c     // Catch:{ all -> 0x002a }
                java.lang.Object r4 = r4.apply(r10)     // Catch:{ all -> 0x002a }
                java.lang.String r5 = "The mapper returned a null Optional"
                java.util.Objects.requireNonNull(r4, r5)     // Catch:{ all -> 0x002a }
                j$.util.Optional r4 = (j$.util.Optional) r4     // Catch:{ all -> 0x002a }
                boolean r10 = r4.isPresent()
                if (r10 == 0) goto L_0x0029
                io.reactivex.rxjava3.operators.ConditionalSubscriber<? super R> r10 = r9.f18981b
                java.lang.Object r2 = r4.get()
                boolean r10 = r10.tryOnNext(r2)
                if (r10 == 0) goto L_0x0029
                r1 = r0
            L_0x0029:
                return r1
            L_0x002a:
                r4 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
                r5 = 2
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.f18983d     // Catch:{ all -> 0x0060 }
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0060 }
                java.lang.Object r6 = r6.apply(r7, r4)     // Catch:{ all -> 0x0060 }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x0060 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x0060 }
                int[] r7 = io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.AnonymousClass1.f18980a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r0) goto L_0x0008
                if (r6 == r5) goto L_0x005f
                r10 = 3
                if (r6 == r10) goto L_0x0059
                r9.cancel()
                r9.onError(r4)
                return r1
            L_0x0059:
                r9.cancel()
                r9.onComplete()
            L_0x005f:
                return r1
            L_0x0060:
                r10 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r10)
                r9.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r2 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r3 = new java.lang.Throwable[r5]
                r3[r1] = r4
                r3[r0] = r10
                r2.<init>((java.lang.Throwable[]) r3)
                r9.onError(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.ParallelMapTryConditionalSubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public static final class ParallelMapTrySubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f18986b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, Optional<? extends R>> f18987c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f18988d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f18989e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f18990f;

        public ParallelMapTrySubscriber(Subscriber<? super R> subscriber, Function<? super T, Optional<? extends R>> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.f18986b = subscriber;
            this.f18987c = function;
            this.f18988d = biFunction;
        }

        public void cancel() {
            this.f18989e.cancel();
        }

        public void onComplete() {
            if (!this.f18990f) {
                this.f18990f = true;
                this.f18986b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18990f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18990f = true;
            this.f18986b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11) && !this.f18990f) {
                this.f18989e.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18989e, subscription)) {
                this.f18989e = subscription;
                this.f18986b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f18989e.request(j11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.f18990f
                r1 = 0
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r2 = 0
            L_0x0008:
                r0 = 1
                io.reactivex.rxjava3.functions.Function<? super T, j$.util.Optional<? extends R>> r4 = r9.f18987c     // Catch:{ all -> 0x0027 }
                java.lang.Object r4 = r4.apply(r10)     // Catch:{ all -> 0x0027 }
                java.lang.String r5 = "The mapper returned a null Optional"
                java.util.Objects.requireNonNull(r4, r5)     // Catch:{ all -> 0x0027 }
                j$.util.Optional r4 = (j$.util.Optional) r4     // Catch:{ all -> 0x0027 }
                boolean r10 = r4.isPresent()
                if (r10 == 0) goto L_0x0026
                org.reactivestreams.Subscriber<? super R> r10 = r9.f18986b
                java.lang.Object r1 = r4.get()
                r10.onNext(r1)
                return r0
            L_0x0026:
                return r1
            L_0x0027:
                r4 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
                r5 = 2
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.f18988d     // Catch:{ all -> 0x005d }
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x005d }
                java.lang.Object r6 = r6.apply(r7, r4)     // Catch:{ all -> 0x005d }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x005d }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x005d }
                int[] r7 = io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.AnonymousClass1.f18980a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r0) goto L_0x0008
                if (r6 == r5) goto L_0x005c
                r10 = 3
                if (r6 == r10) goto L_0x0056
                r9.cancel()
                r9.onError(r4)
                return r1
            L_0x0056:
                r9.cancel()
                r9.onComplete()
            L_0x005c:
                return r1
            L_0x005d:
                r10 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r10)
                r9.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r2 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r3 = new java.lang.Throwable[r5]
                r3[r1] = r4
                r3[r0] = r10
                r2.<init>((java.lang.Throwable[]) r3)
                r9.onError(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.ParallelMapTrySubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public ParallelMapTryOptional(ParallelFlowable<T> parallelFlowable, Function<? super T, Optional<? extends R>> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.f18977a = parallelFlowable;
        this.f18978b = function;
        this.f18979c = biFunction;
    }

    public int parallelism() {
        return this.f18977a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                ConditionalSubscriber conditionalSubscriber = subscriberArr[i11];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i11] = new ParallelMapTryConditionalSubscriber(conditionalSubscriber, this.f18978b, this.f18979c);
                } else {
                    subscriberArr2[i11] = new ParallelMapTrySubscriber(conditionalSubscriber, this.f18978b, this.f18979c);
                }
            }
            this.f18977a.subscribe(subscriberArr2);
        }
    }
}
