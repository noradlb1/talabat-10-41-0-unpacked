package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelDoOnNextTry<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f22588a;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f22589b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f22590c;

    /* renamed from: io.reactivex.rxjava3.internal.operators.parallel.ParallelDoOnNextTry$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22591a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.reactivex.rxjava3.parallel.ParallelFailureHandling[] r0 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22591a = r0
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.RETRY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22591a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.SKIP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22591a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.STOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelDoOnNextTry.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class ParallelDoOnNextConditionalSubscriber<T> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f22592b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super T> f22593c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f22594d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f22595e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22596f;

        public ParallelDoOnNextConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.f22592b = conditionalSubscriber;
            this.f22593c = consumer;
            this.f22594d = biFunction;
        }

        public void cancel() {
            this.f22595e.cancel();
        }

        public void onComplete() {
            if (!this.f22596f) {
                this.f22596f = true;
                this.f22592b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22596f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22596f = true;
            this.f22592b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11) && !this.f22596f) {
                this.f22595e.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22595e, subscription)) {
                this.f22595e = subscription;
                this.f22592b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f22595e.request(j11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.f22596f
                r1 = 0
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r2 = 0
            L_0x0008:
                io.reactivex.rxjava3.functions.Consumer<? super T> r0 = r9.f22593c     // Catch:{ all -> 0x0014 }
                r0.accept(r10)     // Catch:{ all -> 0x0014 }
                io.reactivex.rxjava3.operators.ConditionalSubscriber<? super T> r0 = r9.f22592b
                boolean r10 = r0.tryOnNext(r10)
                return r10
            L_0x0014:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r4 = 1
                r5 = 2
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.f22594d     // Catch:{ all -> 0x004b }
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x004b }
                java.lang.Object r6 = r6.apply(r7, r0)     // Catch:{ all -> 0x004b }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x004b }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x004b }
                int[] r7 = io.reactivex.rxjava3.internal.operators.parallel.ParallelDoOnNextTry.AnonymousClass1.f22591a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r4) goto L_0x0008
                if (r6 == r5) goto L_0x004a
                r10 = 3
                if (r6 == r10) goto L_0x0044
                r9.cancel()
                r9.onError(r0)
                return r1
            L_0x0044:
                r9.cancel()
                r9.onComplete()
            L_0x004a:
                return r1
            L_0x004b:
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelDoOnNextTry.ParallelDoOnNextConditionalSubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public static final class ParallelDoOnNextSubscriber<T> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f22597b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super T> f22598c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f22599d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f22600e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22601f;

        public ParallelDoOnNextSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.f22597b = subscriber;
            this.f22598c = consumer;
            this.f22599d = biFunction;
        }

        public void cancel() {
            this.f22600e.cancel();
        }

        public void onComplete() {
            if (!this.f22601f) {
                this.f22601f = true;
                this.f22597b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22601f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22601f = true;
            this.f22597b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f22600e.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22600e, subscription)) {
                this.f22600e = subscription;
                this.f22597b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f22600e.request(j11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r10) {
            /*
                r9 = this;
                boolean r0 = r9.f22601f
                r1 = 0
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r2 = 0
            L_0x0008:
                r0 = 1
                io.reactivex.rxjava3.functions.Consumer<? super T> r4 = r9.f22598c     // Catch:{ all -> 0x0014 }
                r4.accept(r10)     // Catch:{ all -> 0x0014 }
                org.reactivestreams.Subscriber<? super T> r1 = r9.f22597b
                r1.onNext(r10)
                return r0
            L_0x0014:
                r4 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
                r5 = 2
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.f22599d     // Catch:{ all -> 0x004a }
                r7 = 1
                long r2 = r2 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x004a }
                java.lang.Object r6 = r6.apply(r7, r4)     // Catch:{ all -> 0x004a }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x004a }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x004a }
                int[] r7 = io.reactivex.rxjava3.internal.operators.parallel.ParallelDoOnNextTry.AnonymousClass1.f22591a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r0) goto L_0x0008
                if (r6 == r5) goto L_0x0049
                r10 = 3
                if (r6 == r10) goto L_0x0043
                r9.cancel()
                r9.onError(r4)
                return r1
            L_0x0043:
                r9.cancel()
                r9.onComplete()
            L_0x0049:
                return r1
            L_0x004a:
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelDoOnNextTry.ParallelDoOnNextSubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public ParallelDoOnNextTry(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.f22588a = parallelFlowable;
        this.f22589b = consumer;
        this.f22590c = biFunction;
    }

    public int parallelism() {
        return this.f22588a.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, subscriberArr);
        if (a(onSubscribe)) {
            int length = onSubscribe.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                Subscriber subscriber = onSubscribe[i11];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i11] = new ParallelDoOnNextConditionalSubscriber((ConditionalSubscriber) subscriber, this.f22589b, this.f22590c);
                } else {
                    subscriberArr2[i11] = new ParallelDoOnNextSubscriber(subscriber, this.f22589b, this.f22590c);
                }
            }
            this.f22588a.subscribe(subscriberArr2);
        }
    }
}
