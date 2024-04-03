package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelDoOnNextTry<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f18057a;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f18058b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f18059c;

    /* renamed from: io.reactivex.internal.operators.parallel.ParallelDoOnNextTry$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18060a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.reactivex.parallel.ParallelFailureHandling[] r0 = io.reactivex.parallel.ParallelFailureHandling.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18060a = r0
                io.reactivex.parallel.ParallelFailureHandling r1 = io.reactivex.parallel.ParallelFailureHandling.RETRY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f18060a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.parallel.ParallelFailureHandling r1 = io.reactivex.parallel.ParallelFailureHandling.SKIP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f18060a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.parallel.ParallelFailureHandling r1 = io.reactivex.parallel.ParallelFailureHandling.STOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelDoOnNextTry.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class ParallelDoOnNextConditionalSubscriber<T> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f18061b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super T> f18062c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f18063d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f18064e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f18065f;

        public ParallelDoOnNextConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.f18061b = conditionalSubscriber;
            this.f18062c = consumer;
            this.f18063d = biFunction;
        }

        public void cancel() {
            this.f18064e.cancel();
        }

        public void onComplete() {
            if (!this.f18065f) {
                this.f18065f = true;
                this.f18061b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18065f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18065f = true;
            this.f18061b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11) && !this.f18065f) {
                this.f18064e.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18064e, subscription)) {
                this.f18064e = subscription;
                this.f18061b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f18064e.request(j11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.f18065f
                r1 = 0
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r2 = 0
            L_0x0008:
                io.reactivex.functions.Consumer<? super T> r0 = r9.f18062c     // Catch:{ all -> 0x0014 }
                r0.accept(r10)     // Catch:{ all -> 0x0014 }
                io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> r0 = r9.f18061b
                boolean r10 = r0.tryOnNext(r10)
                return r10
            L_0x0014:
                r0 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r0)
                r4 = 1
                r5 = 2
                io.reactivex.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.parallel.ParallelFailureHandling> r6 = r9.f18063d     // Catch:{ all -> 0x004c }
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x004c }
                java.lang.Object r6 = r6.apply(r7, r0)     // Catch:{ all -> 0x004c }
                java.lang.String r7 = "The errorHandler returned a null item"
                java.lang.Object r6 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r6, (java.lang.String) r7)     // Catch:{ all -> 0x004c }
                io.reactivex.parallel.ParallelFailureHandling r6 = (io.reactivex.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x004c }
                int[] r7 = io.reactivex.internal.operators.parallel.ParallelDoOnNextTry.AnonymousClass1.f18060a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r4) goto L_0x0008
                if (r6 == r5) goto L_0x004b
                r10 = 3
                if (r6 == r10) goto L_0x0045
                r9.cancel()
                r9.onError(r0)
                return r1
            L_0x0045:
                r9.cancel()
                r9.onComplete()
            L_0x004b:
                return r1
            L_0x004c:
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelDoOnNextTry.ParallelDoOnNextConditionalSubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public static final class ParallelDoOnNextSubscriber<T> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f18066b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super T> f18067c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f18068d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f18069e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f18070f;

        public ParallelDoOnNextSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.f18066b = subscriber;
            this.f18067c = consumer;
            this.f18068d = biFunction;
        }

        public void cancel() {
            this.f18069e.cancel();
        }

        public void onComplete() {
            if (!this.f18070f) {
                this.f18070f = true;
                this.f18066b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18070f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18070f = true;
            this.f18066b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f18069e.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18069e, subscription)) {
                this.f18069e = subscription;
                this.f18066b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f18069e.request(j11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.f18070f
                r1 = 0
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r2 = 0
            L_0x0008:
                r0 = 1
                io.reactivex.functions.Consumer<? super T> r4 = r9.f18067c     // Catch:{ all -> 0x0014 }
                r4.accept(r10)     // Catch:{ all -> 0x0014 }
                org.reactivestreams.Subscriber<? super T> r1 = r9.f18066b
                r1.onNext(r10)
                return r0
            L_0x0014:
                r4 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r4)
                r5 = 2
                io.reactivex.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.parallel.ParallelFailureHandling> r6 = r9.f18068d     // Catch:{ all -> 0x004b }
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x004b }
                java.lang.Object r6 = r6.apply(r7, r4)     // Catch:{ all -> 0x004b }
                java.lang.String r7 = "The errorHandler returned a null item"
                java.lang.Object r6 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r6, (java.lang.String) r7)     // Catch:{ all -> 0x004b }
                io.reactivex.parallel.ParallelFailureHandling r6 = (io.reactivex.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x004b }
                int[] r7 = io.reactivex.internal.operators.parallel.ParallelDoOnNextTry.AnonymousClass1.f18060a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r0) goto L_0x0008
                if (r6 == r5) goto L_0x004a
                r10 = 3
                if (r6 == r10) goto L_0x0044
                r9.cancel()
                r9.onError(r4)
                return r1
            L_0x0044:
                r9.cancel()
                r9.onComplete()
            L_0x004a:
                return r1
            L_0x004b:
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelDoOnNextTry.ParallelDoOnNextSubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public ParallelDoOnNextTry(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.f18057a = parallelFlowable;
        this.f18058b = consumer;
        this.f18059c = biFunction;
    }

    public int parallelism() {
        return this.f18057a.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                ConditionalSubscriber conditionalSubscriber = subscriberArr[i11];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i11] = new ParallelDoOnNextConditionalSubscriber(conditionalSubscriber, this.f18058b, this.f18059c);
                } else {
                    subscriberArr2[i11] = new ParallelDoOnNextSubscriber(conditionalSubscriber, this.f18058b, this.f18059c);
                }
            }
            this.f18057a.subscribe(subscriberArr2);
        }
    }
}
