package com.airbnb.lottie.compose;

import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2", f = "LottieAnimatable.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
public final class LottieAnimatableImpl$animate$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f40487h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LottieAnimatableImpl f40488i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f40489j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f40490k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f40491l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ LottieClipSpec f40492m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ LottieComposition f40493n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f40494o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f40495p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ LottieCancellationBehavior f40496q;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2$1", f = "LottieAnimatable.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f40497h;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* renamed from: com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LottieCancellationBehavior.values().length];
                iArr[LottieCancellationBehavior.OnIterationFinish.ordinal()] = 1;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(lottieCancellationBehavior, job, i13, i14, lottieAnimatableImpl2, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.f40497h
                r2 = 1
                if (r1 == 0) goto L_0x0019
                if (r1 != r2) goto L_0x0011
                kotlin.ResultKt.throwOnFailure(r6)
                r1 = r0
                r0 = r5
                goto L_0x0048
            L_0x0011:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x0019:
                kotlin.ResultKt.throwOnFailure(r6)
                r6 = r5
            L_0x001d:
                com.airbnb.lottie.compose.LottieCancellationBehavior r1 = r5
                int[] r3 = com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2.AnonymousClass1.WhenMappings.$EnumSwitchMapping$0
                int r1 = r1.ordinal()
                r1 = r3[r1]
                if (r1 != r2) goto L_0x0037
                kotlinx.coroutines.Job r1 = r6
                boolean r1 = r1.isActive()
                if (r1 == 0) goto L_0x0034
                int r1 = r7
                goto L_0x0039
            L_0x0034:
                int r1 = r8
                goto L_0x0039
            L_0x0037:
                int r1 = r7
            L_0x0039:
                com.airbnb.lottie.compose.LottieAnimatableImpl r3 = r9
                r6.f40497h = r2
                java.lang.Object r1 = r3.doFrame(r1, r6)
                if (r1 != r0) goto L_0x0044
                return r0
            L_0x0044:
                r4 = r0
                r0 = r6
                r6 = r1
                r1 = r4
            L_0x0048:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 != 0) goto L_0x0053
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            L_0x0053:
                r6 = r0
                r0 = r1
                goto L_0x001d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LottieCancellationBehavior.values().length];
            iArr[LottieCancellationBehavior.OnIterationFinish.ordinal()] = 1;
            iArr[LottieCancellationBehavior.Immediately.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieAnimatableImpl$animate$2(LottieAnimatableImpl lottieAnimatableImpl, int i11, int i12, float f11, LottieClipSpec lottieClipSpec, LottieComposition lottieComposition, float f12, boolean z11, LottieCancellationBehavior lottieCancellationBehavior, Continuation<? super LottieAnimatableImpl$animate$2> continuation) {
        super(1, continuation);
        this.f40488i = lottieAnimatableImpl;
        this.f40489j = i11;
        this.f40490k = i12;
        this.f40491l = f11;
        this.f40492m = lottieClipSpec;
        this.f40493n = lottieComposition;
        this.f40494o = f12;
        this.f40495p = z11;
        this.f40496q = lottieCancellationBehavior;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new LottieAnimatableImpl$animate$2(this.f40488i, this.f40489j, this.f40490k, this.f40491l, this.f40492m, this.f40493n, this.f40494o, this.f40495p, this.f40496q, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((LottieAnimatableImpl$animate$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineContext coroutineContext;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f40487h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f40488i.setIteration(this.f40489j);
            this.f40488i.setIterations(this.f40490k);
            this.f40488i.setSpeed(this.f40491l);
            this.f40488i.setClipSpec(this.f40492m);
            this.f40488i.setComposition(this.f40493n);
            this.f40488i.setProgress(this.f40494o);
            if (!this.f40495p) {
                this.f40488i.setLastFrameNanos(Long.MIN_VALUE);
            }
            if (this.f40493n == null) {
                this.f40488i.setPlaying(false);
                return Unit.INSTANCE;
            } else if (Float.isInfinite(this.f40491l)) {
                LottieAnimatableImpl lottieAnimatableImpl = this.f40488i;
                lottieAnimatableImpl.setProgress(lottieAnimatableImpl.getEndProgress());
                this.f40488i.setPlaying(false);
                this.f40488i.setIteration(this.f40490k);
                return Unit.INSTANCE;
            } else {
                this.f40488i.setPlaying(true);
                int i12 = WhenMappings.$EnumSwitchMapping$0[this.f40496q.ordinal()];
                if (i12 == 1) {
                    coroutineContext = NonCancellable.INSTANCE;
                } else if (i12 == 2) {
                    coroutineContext = EmptyCoroutineContext.INSTANCE;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                final Job job = JobKt.getJob(getContext());
                final LottieCancellationBehavior lottieCancellationBehavior = this.f40496q;
                final int i13 = this.f40490k;
                final int i14 = this.f40489j;
                final LottieAnimatableImpl lottieAnimatableImpl2 = this.f40488i;
                AnonymousClass1 r42 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
                this.f40487h = 1;
                if (BuildersKt.withContext(coroutineContext, r42, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                this.f40488i.setPlaying(false);
                throw th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        JobKt.ensureActive(getContext());
        this.f40488i.setPlaying(false);
        return Unit.INSTANCE;
    }
}
