package com.airbnb.lottie.compose;

import android.graphics.Matrix;
import androidx.annotation.FloatRange;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.utils.Utils;
import kotlin.Metadata;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a±\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u001c\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u001e\u001a\"\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"LottieAnimation", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "modifier", "Landroidx/compose/ui/Modifier;", "isPlaying", "", "restartOnPlay", "clipSpec", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "speed", "", "iterations", "", "outlineMasksAndMattes", "applyOpacityToLayers", "enableMergePaths", "renderMode", "Lcom/airbnb/lottie/RenderMode;", "maintainOriginalImageBounds", "dynamicProperties", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "clipToCompositionBounds", "(Lcom/airbnb/lottie/LottieComposition;Landroidx/compose/ui/Modifier;ZZLcom/airbnb/lottie/compose/LottieClipSpec;FIZZZLcom/airbnb/lottie/RenderMode;ZLcom/airbnb/lottie/compose/LottieDynamicProperties;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;ZLandroidx/compose/runtime/Composer;III)V", "progress", "(Lcom/airbnb/lottie/LottieComposition;FLandroidx/compose/ui/Modifier;ZZZLcom/airbnb/lottie/RenderMode;ZLcom/airbnb/lottie/compose/LottieDynamicProperties;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;ZLandroidx/compose/runtime/Composer;III)V", "times", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/geometry/Size;", "scale", "Landroidx/compose/ui/layout/ScaleFactor;", "times-UQTWf7w", "(JJ)J", "lottie-compose_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class LottieAnimationKt {
    @Composable
    public static final void LottieAnimation(@Nullable LottieComposition lottieComposition, @FloatRange(from = 0.0d, to = 1.0d) float f11, @Nullable Modifier modifier, boolean z11, boolean z12, boolean z13, @Nullable RenderMode renderMode, boolean z14, @Nullable LottieDynamicProperties lottieDynamicProperties, @Nullable Alignment alignment, @Nullable ContentScale contentScale, boolean z15, @Nullable Composer composer, int i11, int i12, int i13) {
        int i14;
        Alignment alignment2;
        Composer composer2;
        Modifier modifier2;
        int i15 = i13;
        Composer startRestartGroup = composer.startRestartGroup(185150462);
        Modifier.Companion companion = (i15 & 4) != 0 ? Modifier.Companion : modifier;
        boolean z16 = (i15 & 8) != 0 ? false : z11;
        boolean z17 = (i15 & 16) != 0 ? false : z12;
        boolean z18 = (i15 & 32) != 0 ? false : z13;
        RenderMode renderMode2 = (i15 & 64) != 0 ? RenderMode.AUTOMATIC : renderMode;
        boolean z19 = (i15 & 128) != 0 ? false : z14;
        LottieDynamicProperties lottieDynamicProperties2 = (i15 & 256) != 0 ? null : lottieDynamicProperties;
        if ((i15 & 512) != 0) {
            alignment2 = Alignment.Companion.getCenter();
            i14 = i11 & -1879048193;
        } else {
            alignment2 = alignment;
            i14 = i11;
        }
        ContentScale fit = (i15 & 1024) != 0 ? ContentScale.Companion.getFit() : contentScale;
        boolean z21 = (i15 & 2048) != 0 ? true : z15;
        startRestartGroup.startReplaceableGroup(-3687241);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion2 = Composer.Companion;
        if (rememberedValue == companion2.getEmpty()) {
            rememberedValue = new LottieDrawable();
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        LottieDrawable lottieDrawable = (LottieDrawable) rememberedValue;
        startRestartGroup.startReplaceableGroup(-3687241);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion2.getEmpty()) {
            rememberedValue2 = new Matrix();
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        Matrix matrix = (Matrix) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-3687241);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion2.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue3;
        if (lottieComposition != null) {
            if (!(lottieComposition.getDuration() == 0.0f)) {
                startRestartGroup.startReplaceableGroup(185151298);
                startRestartGroup.endReplaceableGroup();
                float dpScale = Utils.dpScale();
                CanvasKt.Canvas(SizeKt.m560sizeVpY3zN4(companion, Dp.m5478constructorimpl(((float) lottieComposition.getBounds().width()) / dpScale), Dp.m5478constructorimpl(((float) lottieComposition.getBounds().height()) / dpScale)), new LottieAnimationKt$LottieAnimation$2(lottieComposition, fit, alignment2, matrix, lottieDrawable, z18, renderMode2, lottieDynamicProperties2, z16, z17, z19, z21, f11, mutableState), startRestartGroup, 0);
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    LottieAnimationKt$LottieAnimation$3 lottieAnimationKt$LottieAnimation$3 = r0;
                    LottieAnimationKt$LottieAnimation$3 lottieAnimationKt$LottieAnimation$32 = new LottieAnimationKt$LottieAnimation$3(lottieComposition, f11, companion, z16, z17, z18, renderMode2, z19, lottieDynamicProperties2, alignment2, fit, z21, i11, i12, i13);
                    endRestartGroup.updateScope(lottieAnimationKt$LottieAnimation$3);
                    return;
                }
                return;
            }
        }
        startRestartGroup.startReplaceableGroup(185151278);
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            modifier2 = companion;
            composer2 = startRestartGroup;
        } else {
            LottieAnimationKt$LottieAnimation$1 lottieAnimationKt$LottieAnimation$1 = r0;
            modifier2 = companion;
            composer2 = startRestartGroup;
            LottieAnimationKt$LottieAnimation$1 lottieAnimationKt$LottieAnimation$12 = new LottieAnimationKt$LottieAnimation$1(lottieComposition, f11, companion, z16, z17, z18, renderMode2, z19, lottieDynamicProperties2, alignment2, fit, z21, i11, i12, i13);
            endRestartGroup2.updateScope(lottieAnimationKt$LottieAnimation$1);
        }
        BoxKt.Box(modifier2, composer2, (i14 >> 6) & 14);
    }

    /* access modifiers changed from: private */
    /* renamed from: LottieAnimation$lambda-3  reason: not valid java name */
    public static final LottieDynamicProperties m9140LottieAnimation$lambda3(MutableState<LottieDynamicProperties> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: LottieAnimation$lambda-4  reason: not valid java name */
    public static final void m9141LottieAnimation$lambda4(MutableState<LottieDynamicProperties> mutableState, LottieDynamicProperties lottieDynamicProperties) {
        mutableState.setValue(lottieDynamicProperties);
    }

    /* renamed from: LottieAnimation$lambda-5  reason: not valid java name */
    private static final float m9142LottieAnimation$lambda5(LottieAnimationState lottieAnimationState) {
        return ((Number) lottieAnimationState.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: times-UQTWf7w  reason: not valid java name */
    public static final long m9146timesUQTWf7w(long j11, long j12) {
        return IntSizeKt.IntSize((int) (Size.m2745getWidthimpl(j11) * ScaleFactor.m4549getScaleXimpl(j12)), (int) (Size.m2742getHeightimpl(j11) * ScaleFactor.m4550getScaleYimpl(j12)));
    }

    @Composable
    public static final void LottieAnimation(@Nullable LottieComposition lottieComposition, @Nullable Modifier modifier, boolean z11, boolean z12, @Nullable LottieClipSpec lottieClipSpec, float f11, int i11, boolean z13, boolean z14, boolean z15, @Nullable RenderMode renderMode, boolean z16, @Nullable LottieDynamicProperties lottieDynamicProperties, @Nullable Alignment alignment, @Nullable ContentScale contentScale, boolean z17, @Nullable Composer composer, int i12, int i13, int i14) {
        Alignment alignment2;
        int i15;
        ContentScale contentScale2;
        int i16 = i14;
        Composer startRestartGroup = composer.startRestartGroup(185153230);
        Modifier.Companion companion = (i16 & 2) != 0 ? Modifier.Companion : modifier;
        boolean z18 = (i16 & 4) != 0 ? true : z11;
        boolean z19 = (i16 & 8) != 0 ? true : z12;
        LottieClipSpec lottieClipSpec2 = (i16 & 16) != 0 ? null : lottieClipSpec;
        float f12 = (i16 & 32) != 0 ? 1.0f : f11;
        int i17 = (i16 & 64) != 0 ? 1 : i11;
        boolean z21 = (i16 & 128) != 0 ? false : z13;
        boolean z22 = (i16 & 256) != 0 ? false : z14;
        boolean z23 = (i16 & 512) != 0 ? false : z15;
        RenderMode renderMode2 = (i16 & 1024) != 0 ? RenderMode.AUTOMATIC : renderMode;
        boolean z24 = (i16 & 2048) != 0 ? false : z16;
        LottieDynamicProperties lottieDynamicProperties2 = (i16 & 4096) != 0 ? null : lottieDynamicProperties;
        if ((i16 & 8192) != 0) {
            i15 = i13 & -7169;
            alignment2 = Alignment.Companion.getCenter();
        } else {
            alignment2 = alignment;
            i15 = i13;
        }
        if ((i16 & 16384) != 0) {
            i15 &= -57345;
            contentScale2 = ContentScale.Companion.getFit();
        } else {
            contentScale2 = contentScale;
        }
        boolean z25 = (32768 & i16) != 0 ? true : z17;
        int i18 = i12 >> 3;
        LottieComposition lottieComposition2 = lottieComposition;
        float r12 = m9142LottieAnimation$lambda5(AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(lottieComposition2, z18, z19, lottieClipSpec2, f12, i17, (LottieCancellationBehavior) null, false, startRestartGroup, (i18 & 112) | 8 | (i18 & 896) | (i18 & 7168) | (i18 & 57344) | (i18 & Opcodes.ASM7), 192));
        int i19 = i12 >> 12;
        int i21 = ((i12 << 3) & 896) | 134217736 | (i19 & 7168) | (57344 & i19) | (i19 & Opcodes.ASM7);
        int i22 = i15 << 18;
        int i23 = i15 >> 12;
        LottieAnimation(lottieComposition2, r12, companion, z21, z22, z23, renderMode2, z24, lottieDynamicProperties2, alignment2, contentScale2, z25, startRestartGroup, i21 | (3670016 & i22) | (29360128 & i22) | (i22 & 1879048192), (i23 & 112) | (i23 & 14), 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LottieAnimationKt$LottieAnimation$4(lottieComposition, companion, z18, z19, lottieClipSpec2, f12, i17, z21, z22, z23, renderMode2, z24, lottieDynamicProperties2, alignment2, contentScale2, z25, i12, i13, i14));
        }
    }
}
