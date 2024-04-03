package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFilterTry<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f22609a;

    /* renamed from: b  reason: collision with root package name */
    public final Predicate<? super T> f22610b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f22611c;

    /* renamed from: io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22612a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.reactivex.rxjava3.parallel.ParallelFailureHandling[] r0 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22612a = r0
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.RETRY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22612a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.SKIP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22612a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.STOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Predicate<? super T> f22613b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f22614c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f22615d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22616e;

        public BaseFilterSubscriber(Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.f22613b = predicate;
            this.f22614c = biFunction;
        }

        public final void cancel() {
            this.f22615d.cancel();
        }

        public final void onNext(T t11) {
            if (!tryOnNext(t11) && !this.f22616e) {
                this.f22615d.request(1);
            }
        }

        public final void request(long j11) {
            this.f22615d.request(j11);
        }
    }

    public static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {

        /* renamed from: f  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f22617f;

        public ParallelFilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            super(predicate, biFunction);
            this.f22617f = conditionalSubscriber;
        }

        public void onComplete() {
            if (!this.f22616e) {
                this.f22616e = true;
                this.f22617f.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22616e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22616e = true;
            this.f22617f.onError(th2);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22615d, subscription)) {
                this.f22615d = subscription;
                this.f22617f.onSubscribe(this);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.f22616e
                r1 = 0
                if (r0 != 0) goto L_0x0065
                r2 = 0
            L_0x0007:
                r0 = 1
                io.reactivex.rxjava3.functions.Predicate<? super T> r4 = r9.f22613b     // Catch:{ all -> 0x001a }
                boolean r2 = r4.test(r10)     // Catch:{ all -> 0x001a }
                if (r2 == 0) goto L_0x0019
                io.reactivex.rxjava3.operators.ConditionalSubscriber<? super T> r2 = r9.f22617f
                boolean r10 = r2.tryOnNext(r10)
                if (r10 == 0) goto L_0x0019
                r1 = r0
            L_0x0019:
                return r1
            L_0x001a:
                r4 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
                r5 = 2
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.f22614c     // Catch:{ all -> 0x0050 }
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0050 }
                java.lang.Object r6 = r6.apply(r7, r4)     // Catch:{ all -> 0x0050 }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x0050 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x0050 }
                int[] r7 = io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.AnonymousClass1.f22612a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r0) goto L_0x0007
                if (r6 == r5) goto L_0x004f
                r10 = 3
                if (r6 == r10) goto L_0x0049
                r9.cancel()
                r9.onError(r4)
                return r1
            L_0x0049:
                r9.cancel()
                r9.onComplete()
            L_0x004f:
                return r1
            L_0x0050:
                r10 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r10)
                r9.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r2 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r3 = new java.lang.Throwable[r5]
                r3[r1] = r4
                r3[r0] = r10
                r2.<init>((java.lang.Throwable[]) r3)
                r9.onError(r2)
            L_0x0065:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.ParallelFilterConditionalSubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {

        /* renamed from: f  reason: collision with root package name */
        public final Subscriber<? super T> f22618f;

        public ParallelFilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            super(predicate, biFunction);
            this.f22618f = subscriber;
        }

        public void onComplete() {
            if (!this.f22616e) {
                this.f22616e = true;
                this.f22618f.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22616e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22616e = true;
            this.f22618f.onError(th2);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22615d, subscription)) {
                this.f22615d = subscription;
                this.f22618f.onSubscribe(this);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.f22616e
                r1 = 0
                if (r0 != 0) goto L_0x0062
                r2 = 0
            L_0x0007:
                r0 = 1
                io.reactivex.rxjava3.functions.Predicate<? super T> r4 = r9.f22613b     // Catch:{ all -> 0x0017 }
                boolean r2 = r4.test(r10)     // Catch:{ all -> 0x0017 }
                if (r2 == 0) goto L_0x0016
                org.reactivestreams.Subscriber<? super T> r1 = r9.f22618f
                r1.onNext(r10)
                return r0
            L_0x0016:
                return r1
            L_0x0017:
                r4 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
                r5 = 2
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.f22614c     // Catch:{ all -> 0x004d }
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x004d }
                java.lang.Object r6 = r6.apply(r7, r4)     // Catch:{ all -> 0x004d }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x004d }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x004d }
                int[] r7 = io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.AnonymousClass1.f22612a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r0) goto L_0x0007
                if (r6 == r5) goto L_0x004c
                r10 = 3
                if (r6 == r10) goto L_0x0046
                r9.cancel()
                r9.onError(r4)
                return r1
            L_0x0046:
                r9.cancel()
                r9.onComplete()
            L_0x004c:
                return r1
            L_0x004d:
                r10 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r10)
                r9.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r2 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r3 = new java.lang.Throwable[r5]
                r3[r1] = r4
                r3[r0] = r10
                r2.<init>((java.lang.Throwable[]) r3)
                r9.onError(r2)
            L_0x0062:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.ParallelFilterSubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public ParallelFilterTry(ParallelFlowable<T> parallelFlowable, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.f22609a = parallelFlowable;
        this.f22610b = predicate;
        this.f22611c = biFunction;
    }

    public int parallelism() {
        return this.f22609a.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, subscriberArr);
        if (a(onSubscribe)) {
            int length = onSubscribe.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                Subscriber subscriber = onSubscribe[i11];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i11] = new ParallelFilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f22610b, this.f22611c);
                } else {
                    subscriberArr2[i11] = new ParallelFilterSubscriber(subscriber, this.f22610b, this.f22611c);
                }
            }
            this.f22609a.subscribe(subscriberArr2);
        }
    }
}
