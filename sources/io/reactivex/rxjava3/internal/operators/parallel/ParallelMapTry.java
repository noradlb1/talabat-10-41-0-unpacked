package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMapTry<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f22672a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<? super T, ? extends R> f22673b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f22674c;

    /* renamed from: io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22675a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.reactivex.rxjava3.parallel.ParallelFailureHandling[] r0 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22675a = r0
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.RETRY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22675a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.SKIP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22675a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.STOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class ParallelMapTryConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final ConditionalSubscriber<? super R> f22676b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends R> f22677c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f22678d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f22679e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22680f;

        public ParallelMapTryConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.f22676b = conditionalSubscriber;
            this.f22677c = function;
            this.f22678d = biFunction;
        }

        public void cancel() {
            this.f22679e.cancel();
        }

        public void onComplete() {
            if (!this.f22680f) {
                this.f22680f = true;
                this.f22676b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22680f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22680f = true;
            this.f22676b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11) && !this.f22680f) {
                this.f22679e.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22679e, subscription)) {
                this.f22679e = subscription;
                this.f22676b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f22679e.request(j11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.f22680f
                r1 = 0
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r2 = 0
            L_0x0008:
                io.reactivex.rxjava3.functions.Function<? super T, ? extends R> r0 = r9.f22677c     // Catch:{ all -> 0x001a }
                java.lang.Object r0 = r0.apply(r10)     // Catch:{ all -> 0x001a }
                java.lang.String r4 = "The mapper returned a null value"
                java.util.Objects.requireNonNull(r0, r4)     // Catch:{ all -> 0x001a }
                io.reactivex.rxjava3.operators.ConditionalSubscriber<? super R> r10 = r9.f22676b
                boolean r10 = r10.tryOnNext(r0)
                return r10
            L_0x001a:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r4 = 1
                r5 = 2
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.f22678d     // Catch:{ all -> 0x0051 }
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0051 }
                java.lang.Object r6 = r6.apply(r7, r0)     // Catch:{ all -> 0x0051 }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x0051 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x0051 }
                int[] r7 = io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.AnonymousClass1.f22675a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r4) goto L_0x0008
                if (r6 == r5) goto L_0x0050
                r10 = 3
                if (r6 == r10) goto L_0x004a
                r9.cancel()
                r9.onError(r0)
                return r1
            L_0x004a:
                r9.cancel()
                r9.onComplete()
            L_0x0050:
                return r1
            L_0x0051:
                r10 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r10)
                r9.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r2 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r3 = new java.lang.Throwable[r5]
                r3[r1] = r0
                r3[r4] = r10
                r2.<init>((java.lang.Throwable[]) r3)
                r9.onError(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.ParallelMapTryConditionalSubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public static final class ParallelMapTrySubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f22681b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends R> f22682c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f22683d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f22684e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22685f;

        public ParallelMapTrySubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.f22681b = subscriber;
            this.f22682c = function;
            this.f22683d = biFunction;
        }

        public void cancel() {
            this.f22684e.cancel();
        }

        public void onComplete() {
            if (!this.f22685f) {
                this.f22685f = true;
                this.f22681b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22685f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22685f = true;
            this.f22681b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11) && !this.f22685f) {
                this.f22684e.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22684e, subscription)) {
                this.f22684e = subscription;
                this.f22681b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f22684e.request(j11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.f22685f
                r1 = 0
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r2 = 0
            L_0x0008:
                r0 = 1
                io.reactivex.rxjava3.functions.Function<? super T, ? extends R> r4 = r9.f22682c     // Catch:{ all -> 0x001a }
                java.lang.Object r4 = r4.apply(r10)     // Catch:{ all -> 0x001a }
                java.lang.String r5 = "The mapper returned a null value"
                java.util.Objects.requireNonNull(r4, r5)     // Catch:{ all -> 0x001a }
                org.reactivestreams.Subscriber<? super R> r10 = r9.f22681b
                r10.onNext(r4)
                return r0
            L_0x001a:
                r4 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
                r5 = 2
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.f22683d     // Catch:{ all -> 0x0050 }
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0050 }
                java.lang.Object r6 = r6.apply(r7, r4)     // Catch:{ all -> 0x0050 }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x0050 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x0050 }
                int[] r7 = io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.AnonymousClass1.f22675a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r0) goto L_0x0008
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
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.ParallelMapTrySubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public ParallelMapTry(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.f22672a = parallelFlowable;
        this.f22673b = function;
        this.f22674c = biFunction;
    }

    public int parallelism() {
        return this.f22672a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, (Subscriber<? super T>[]) subscriberArr);
        if (a(onSubscribe)) {
            int length = onSubscribe.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                Subscriber subscriber = onSubscribe[i11];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i11] = new ParallelMapTryConditionalSubscriber((ConditionalSubscriber) subscriber, this.f22673b, this.f22674c);
                } else {
                    subscriberArr2[i11] = new ParallelMapTrySubscriber(subscriber, this.f22673b, this.f22674c);
                }
            }
            this.f22672a.subscribe(subscriberArr2);
        }
    }
}
