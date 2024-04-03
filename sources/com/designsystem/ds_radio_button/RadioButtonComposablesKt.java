package com.designsystem.ds_radio_button;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCancellationBehavior;
import com.airbnb.lottie.compose.LottieClipSpec;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.LottieDynamicProperties;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.designsystem.composition.LocalCompositionResultKt;
import com.designsystem.composition.LottieCompositionState;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0015\u001a5\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0018H\u0001¢\u0006\u0002\u0010\u0019\"\u0016\u0010\u0000\u001a\u00020\u0001ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\nX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"DSRadioButtonCompositionSpec", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$RawRes;", "getDSRadioButtonCompositionSpec", "()I", "I", "RadioButtonAnimationSpeed", "", "RadioButtonDisabledAlpha", "RadioButtonEnabledAlpha", "RadioButtonSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButton", "", "modifier", "Landroidx/compose/ui/Modifier;", "isChecked", "", "isEnabled", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/runtime/Composer;I)V", "RadioButtonAnimatedCheckmark", "(ZLandroidx/compose/runtime/Composer;I)V", "SelectableRadioButton", "onTap", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class RadioButtonComposablesKt {
    private static final int DSRadioButtonCompositionSpec = LottieCompositionSpec.RawRes.m9176constructorimpl(R.raw.radio_button);
    private static final float RadioButtonAnimationSpeed = 1.0f;
    private static final float RadioButtonDisabledAlpha = 0.35f;
    private static final float RadioButtonEnabledAlpha = 1.0f;
    private static final float RadioButtonSize = Dp.m5478constructorimpl((float) 24);

    /* access modifiers changed from: private */
    @Composable
    public static final void RadioButton(Modifier modifier, boolean z11, boolean z12, Composer composer, int i11) {
        int i12;
        float f11;
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(686131415);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(z11)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        if ((i11 & 896) == 0) {
            if (startRestartGroup.changed(z12)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        if (((i12 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            Alignment center = Alignment.Companion.getCenter();
            Modifier r22 = SizeKt.m558size3ABfNKs(modifier, RadioButtonSize);
            if (z12) {
                f11 = 1.0f;
            } else {
                f11 = RadioButtonDisabledAlpha;
            }
            Modifier alpha = AlphaKt.alpha(r22, f11);
            startRestartGroup.startReplaceableGroup(-1990474327);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(alpha);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r72 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r72, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density, companion.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection, companion.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            RadioButtonAnimatedCheckmark(z11, startRestartGroup, (i12 >> 3) & 14);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RadioButtonComposablesKt$RadioButton$2(modifier, z11, z12, i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void RadioButtonAnimatedCheckmark(boolean z11, Composer composer, int i11) {
        int i12;
        float f11;
        LottieComposition lottieComposition;
        float f12;
        LottieCompositionResult lottieCompositionResult;
        int i13;
        boolean z12 = z11;
        int i14 = i11;
        Composer startRestartGroup = composer.startRestartGroup(521043398);
        if ((i14 & 14) == 0) {
            if (startRestartGroup.changed(z12)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i14;
        } else {
            i12 = i14;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            LottieCompositionResult rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m9175boximpl(DSRadioButtonCompositionSpec), (String) null, (String) null, (String) null, (String) null, (Function3<? super Integer, ? super Throwable, ? super Continuation<? super Boolean>, ? extends Object>) null, startRestartGroup, 8, 62);
            LottieComposition r32 = m8551RadioButtonAnimatedCheckmark$lambda1(rememberLottieComposition);
            if (z12) {
                f11 = 1.0f;
            } else {
                f11 = -1.0f;
            }
            LottieAnimationState animateLottieCompositionAsState = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(r32, false, false, (LottieClipSpec) null, f11, 0, (LottieCancellationBehavior) null, false, startRestartGroup, 8, 238);
            LottieCompositionState lottieCompositionState = (LottieCompositionState) startRestartGroup.consume(LocalCompositionResultKt.getLocalLottieCompositionState());
            Float f13 = null;
            if (lottieCompositionState == null || (lottieCompositionResult = lottieCompositionState.getLottieCompositionResult()) == null) {
                lottieComposition = null;
            } else {
                lottieComposition = lottieCompositionResult.getValue();
            }
            if (lottieComposition == null) {
                lottieComposition = m8551RadioButtonAnimatedCheckmark$lambda1(rememberLottieComposition);
            }
            LottieCompositionState lottieCompositionState2 = (LottieCompositionState) startRestartGroup.consume(LocalCompositionResultKt.getLocalLottieCompositionState());
            if (lottieCompositionState2 != null) {
                f13 = Float.valueOf(lottieCompositionState2.getProgress());
            }
            if (f13 == null) {
                f12 = m8552RadioButtonAnimatedCheckmark$lambda2(animateLottieCompositionAsState);
            } else {
                f12 = f13.floatValue();
            }
            LottieAnimationKt.LottieAnimation(lottieComposition, f12, (Modifier) null, false, false, false, (RenderMode) null, false, (LottieDynamicProperties) null, (Alignment) null, (ContentScale) null, false, startRestartGroup, 8, 0, 4092);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RadioButtonComposablesKt$RadioButtonAnimatedCheckmark$1(z12, i14));
        }
    }

    /* renamed from: RadioButtonAnimatedCheckmark$lambda-1  reason: not valid java name */
    private static final LottieComposition m8551RadioButtonAnimatedCheckmark$lambda1(LottieCompositionResult lottieCompositionResult) {
        return (LottieComposition) lottieCompositionResult.getValue();
    }

    /* renamed from: RadioButtonAnimatedCheckmark$lambda-2  reason: not valid java name */
    private static final float m8552RadioButtonAnimatedCheckmark$lambda2(LottieAnimationState lottieAnimationState) {
        return ((Number) lottieAnimationState.getValue()).floatValue();
    }

    @Composable
    public static final void SelectableRadioButton(@NotNull Modifier modifier, boolean z11, boolean z12, @Nullable Function0<Unit> function0, @Nullable Composer composer, int i11) {
        int i12;
        Modifier modifier2;
        int i13;
        int i14;
        int i15;
        int i16;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(1052803740);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i12 = i16 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(z11)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i12 |= i15;
        }
        if ((i11 & 896) == 0) {
            if (startRestartGroup.changed(z12)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i12 |= i14;
        }
        if ((i11 & 7168) == 0) {
            if (startRestartGroup.changed((Object) function0)) {
                i13 = 2048;
            } else {
                i13 = 1024;
            }
            i12 |= i13;
        }
        if (((i12 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            if (function0 != null) {
                boolean z13 = z11;
                boolean z14 = z12;
                modifier2 = SelectableKt.m782selectableO2vRcR0(Modifier.Companion, z13, InteractionSourceKt.MutableInteractionSource(), (Indication) null, z14, Role.m4904boximpl(Role.Companion.m4914getRadioButtono7Vup1c()), function0);
            } else {
                modifier2 = Modifier.Companion;
            }
            RadioButton(modifier.then(modifier2), z11, z12, startRestartGroup, (i12 & 896) | (i12 & 112));
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RadioButtonComposablesKt$SelectableRadioButton$1(modifier, z11, z12, function0, i11));
        }
    }

    public static final int getDSRadioButtonCompositionSpec() {
        return DSRadioButtonCompositionSpec;
    }
}
