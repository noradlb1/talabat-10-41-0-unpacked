package com.designsystem.ds_progressive_offer;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$CelebrationAnimation$1", f = "ProgressiveOfferComposables.kt", i = {}, l = {303, 311, 319, 321, 329, 337, 345}, m = "invokeSuspend", n = {}, s = {})
public final class ProgressiveOfferComposablesKt$CelebrationAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f32483h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32484i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Animatable<Float, AnimationVector1D> f32485j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Animatable<Float, AnimationVector1D> f32486k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$CelebrationAnimation$1(boolean z11, Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2, Continuation<? super ProgressiveOfferComposablesKt$CelebrationAnimation$1> continuation) {
        super(2, continuation);
        this.f32484i = z11;
        this.f32485j = animatable;
        this.f32486k = animatable2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ProgressiveOfferComposablesKt$CelebrationAnimation$1(this.f32484i, this.f32485j, this.f32486k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ProgressiveOfferComposablesKt$CelebrationAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0067, code lost:
        r0 = r8.f32486k;
        r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(1.0f);
        r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(150, 0, androidx.compose.animation.core.EasingKt.getLinearEasing(), r12, (java.lang.Object) null);
        r8.f32483h = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0082, code lost:
        if (androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, (java.lang.Object) null, (kotlin.jvm.functions.Function1) null, r17, 12, (java.lang.Object) null) != r9) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0084, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0085, code lost:
        r8.f32483h = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008e, code lost:
        if (kotlinx.coroutines.DelayKt.delay(1000, r8) != r9) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0090, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0091, code lost:
        r0 = r8.f32486k;
        r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(0.0f);
        r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(150, 0, androidx.compose.animation.core.EasingKt.getLinearEasing(), r12, (java.lang.Object) null);
        r8.f32483h = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ad, code lost:
        if (androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, (java.lang.Object) null, (kotlin.jvm.functions.Function1) null, r17, 12, (java.lang.Object) null) != r9) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00af, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b0, code lost:
        r0 = r8.f32485j;
        r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(1.0f);
        r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(100, 0, androidx.compose.animation.core.EasingKt.getLinearEasing(), r12, (java.lang.Object) null);
        r8.f32483h = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ce, code lost:
        if (androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, (java.lang.Object) null, (kotlin.jvm.functions.Function1) null, r17, 12, (java.lang.Object) null) != r9) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d0, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f3, code lost:
        r0 = r8.f32486k;
        r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(0.0f);
        r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(150, 0, androidx.compose.animation.core.EasingKt.getLinearEasing(), r12, (java.lang.Object) null);
        r8.f32483h = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x010f, code lost:
        if (androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, (java.lang.Object) null, (kotlin.jvm.functions.Function1) null, r17, 12, (java.lang.Object) null) != r9) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0111, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0114, code lost:
        return kotlin.Unit.INSTANCE;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r8 = r17
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r8.f32483h
            r10 = 150(0x96, float:2.1E-43)
            r11 = 0
            r12 = 100
            r13 = 1065353216(0x3f800000, float:1.0)
            r14 = 0
            r15 = 0
            r7 = 2
            switch(r0) {
                case 0: goto L_0x003d;
                case 1: goto L_0x0038;
                case 2: goto L_0x0033;
                case 3: goto L_0x002e;
                case 4: goto L_0x0028;
                case 5: goto L_0x0023;
                case 6: goto L_0x001d;
                case 7: goto L_0x0023;
                default: goto L_0x0015;
            }
        L_0x0015:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r18)
            r12 = r7
            goto L_0x00f3
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x0112
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r18)
            r12 = r7
            goto L_0x00b0
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r18)
            r12 = r7
            goto L_0x0091
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r18)
            r12 = r7
            goto L_0x0085
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r18)
            r12 = r7
            goto L_0x0067
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r18)
            boolean r0 = r8.f32484i
            if (r0 == 0) goto L_0x00d1
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r8.f32485j
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r11)
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r12, r15, r2, r7, r14)
            r3 = 0
            r4 = 0
            r6 = 12
            r16 = 0
            r5 = 1
            r8.f32483h = r5
            r5 = r17
            r12 = r7
            r7 = r16
            java.lang.Object r0 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r0 != r9) goto L_0x0067
            return r9
        L_0x0067:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r8.f32486k
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r10, r15, r2, r12, r14)
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            r8.f32483h = r12
            r5 = r17
            java.lang.Object r0 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r0 != r9) goto L_0x0085
            return r9
        L_0x0085:
            r0 = 3
            r8.f32483h = r0
            r0 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r0, r8)
            if (r0 != r9) goto L_0x0091
            return r9
        L_0x0091:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r8.f32486k
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r11)
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r10, r15, r2, r12, r14)
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            r5 = 4
            r8.f32483h = r5
            r5 = r17
            java.lang.Object r0 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r0 != r9) goto L_0x00b0
            return r9
        L_0x00b0:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r8.f32485j
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r3 = 100
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r3, r15, r2, r12, r14)
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            r5 = 5
            r8.f32483h = r5
            r5 = r17
            java.lang.Object r0 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r0 != r9) goto L_0x0112
            return r9
        L_0x00d1:
            r12 = r7
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r8.f32485j
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r3 = 100
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r3, r15, r2, r12, r14)
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            r5 = 6
            r8.f32483h = r5
            r5 = r17
            java.lang.Object r0 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r0 != r9) goto L_0x00f3
            return r9
        L_0x00f3:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r0 = r8.f32486k
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r11)
            androidx.compose.animation.core.Easing r2 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r10, r15, r2, r12, r14)
            r3 = 0
            r4 = 0
            r6 = 12
            r7 = 0
            r5 = 7
            r8.f32483h = r5
            r5 = r17
            java.lang.Object r0 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r0 != r9) goto L_0x0112
            return r9
        L_0x0112:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$CelebrationAnimation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
