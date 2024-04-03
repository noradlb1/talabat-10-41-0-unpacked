package com.designsystem.ds_loading_indicator;

import androidx.compose.runtime.Composer;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCompositionResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSLoadingIndicatorKt$DSLoadingIndicator$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LottieCompositionResult f32375g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationState f32376h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSLoadingIndicatorKt$DSLoadingIndicator$1$1$1(LottieCompositionResult lottieCompositionResult, LottieAnimationState lottieAnimationState) {
        super(2);
        this.f32375g = lottieCompositionResult;
        this.f32376h = lottieAnimationState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        r1 = r1.getLottieCompositionResult();
     */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            r13 = r19
            r1 = r20 & 11
            r1 = r1 ^ 2
            if (r1 != 0) goto L_0x0016
            boolean r1 = r19.getSkipping()
            if (r1 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            r19.skipToGroupEnd()
            goto L_0x0095
        L_0x0016:
            androidx.compose.runtime.ProvidableCompositionLocal r1 = com.designsystem.composition.LocalCompositionResultKt.getLocalLottieCompositionState()
            java.lang.Object r1 = r13.consume(r1)
            com.designsystem.composition.LottieCompositionState r1 = (com.designsystem.composition.LottieCompositionState) r1
            r2 = 0
            if (r1 != 0) goto L_0x0025
        L_0x0023:
            r1 = r2
            goto L_0x0030
        L_0x0025:
            com.airbnb.lottie.compose.LottieCompositionResult r1 = r1.getLottieCompositionResult()
            if (r1 != 0) goto L_0x002c
            goto L_0x0023
        L_0x002c:
            com.airbnb.lottie.LottieComposition r1 = r1.getValue()
        L_0x0030:
            if (r1 != 0) goto L_0x0038
            com.airbnb.lottie.compose.LottieCompositionResult r1 = r0.f32375g
            com.airbnb.lottie.LottieComposition r1 = com.designsystem.ds_loading_indicator.DSLoadingIndicatorKt$DSLoadingIndicator$1.m8495invoke$lambda0(r1)
        L_0x0038:
            androidx.compose.runtime.ProvidableCompositionLocal r3 = com.designsystem.composition.LocalCompositionResultKt.getLocalLottieCompositionState()
            java.lang.Object r3 = r13.consume(r3)
            com.designsystem.composition.LottieCompositionState r3 = (com.designsystem.composition.LottieCompositionState) r3
            if (r3 != 0) goto L_0x0046
            r3 = r2
            goto L_0x004e
        L_0x0046:
            float r3 = r3.getProgress()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
        L_0x004e:
            if (r3 != 0) goto L_0x0057
            com.airbnb.lottie.compose.LottieAnimationState r3 = r0.f32376h
            float r3 = com.designsystem.ds_loading_indicator.DSLoadingIndicatorKt$DSLoadingIndicator$1.m8496invoke$lambda1(r3)
            goto L_0x005b
        L_0x0057:
            float r3 = r3.floatValue()
        L_0x005b:
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            float r5 = com.designsystem.ds_loading_indicator.DSLoadingIndicatorKt.LoadingIndicatorAnimationHeight
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r4, r5)
            r5 = 3
            r6 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.wrapContentWidth$default(r4, r2, r6, r5, r2)
            com.designsystem.ds_loading_indicator.DSLoadingIndicatorKt$DSLoadingIndicator$1$1$1$1 r5 = com.designsystem.ds_loading_indicator.DSLoadingIndicatorKt$DSLoadingIndicator$1$1$1.AnonymousClass1.INSTANCE
            r7 = 1
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r4, r6, r5, r7, r2)
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 8
            r16 = 0
            r17 = 4088(0xff8, float:5.729E-42)
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r14
            r13 = r19
            r14 = r15
            r15 = r16
            r16 = r17
            com.airbnb.lottie.compose.LottieAnimationKt.LottieAnimation(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_loading_indicator.DSLoadingIndicatorKt$DSLoadingIndicator$1$1$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
