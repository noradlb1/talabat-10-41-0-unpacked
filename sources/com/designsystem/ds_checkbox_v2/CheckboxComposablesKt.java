package com.designsystem.ds_checkbox_v2;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
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
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.designsystem.marshmallow.R;
import com.google.android.exoplayer2.RendererCapabilities;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001a\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0016\u001a7\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00192\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"CheckboxAnimationSpeed", "", "CheckboxDisabledAlpha", "CheckboxEnabledAlpha", "CheckboxSize", "Landroidx/compose/ui/unit/Dp;", "F", "DSCheckboxCompositionSpec", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$RawRes;", "getDSCheckboxCompositionSpec", "()I", "I", "Checkbox", "", "state", "Landroidx/compose/ui/state/ToggleableState;", "isEnabled", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/state/ToggleableState;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "CheckboxAnimatedCheckmark", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)V", "ToggleableCheckbox", "onTap", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class CheckboxComposablesKt {
    private static final float CheckboxAnimationSpeed = 1.0f;
    private static final float CheckboxDisabledAlpha = 0.35f;
    private static final float CheckboxEnabledAlpha = 1.0f;
    private static final float CheckboxSize = Dp.m5478constructorimpl((float) 24);
    private static final int DSCheckboxCompositionSpec = LottieCompositionSpec.RawRes.m9176constructorimpl(R.raw.checkbox);

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Off.ordinal()] = 2;
            iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void Checkbox(ToggleableState toggleableState, boolean z11, Modifier modifier, Composer composer, int i11) {
        int i12;
        float f11;
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(204312555);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) toggleableState)) {
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
            if (startRestartGroup.changed((Object) modifier)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        if (((i12 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            Alignment center = Alignment.Companion.getCenter();
            Modifier r22 = SizeKt.m558size3ABfNKs(modifier, CheckboxSize);
            if (z11) {
                f11 = 1.0f;
            } else {
                f11 = CheckboxDisabledAlpha;
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
            CheckboxAnimatedCheckmark(toggleableState, startRestartGroup, i12 & 14);
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
            endRestartGroup.updateScope(new CheckboxComposablesKt$Checkbox$2(toggleableState, z11, modifier, i11));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CheckboxAnimatedCheckmark(androidx.compose.ui.state.ToggleableState r19, androidx.compose.runtime.Composer r20, int r21) {
        /*
            r0 = r19
            r1 = r21
            r2 = -1921938796(0xffffffff8d718a94, float:-7.4430666E-31)
            r3 = r20
            androidx.compose.runtime.Composer r2 = r3.startRestartGroup(r2)
            r3 = r1 & 14
            r12 = 2
            if (r3 != 0) goto L_0x001d
            boolean r3 = r2.changed((java.lang.Object) r0)
            if (r3 == 0) goto L_0x001a
            r3 = 4
            goto L_0x001b
        L_0x001a:
            r3 = r12
        L_0x001b:
            r3 = r3 | r1
            goto L_0x001e
        L_0x001d:
            r3 = r1
        L_0x001e:
            r3 = r3 & 11
            r3 = r3 ^ r12
            if (r3 != 0) goto L_0x002f
            boolean r3 = r2.getSkipping()
            if (r3 != 0) goto L_0x002a
            goto L_0x002f
        L_0x002a:
            r2.skipToGroupEnd()
            goto L_0x00d3
        L_0x002f:
            int r3 = DSCheckboxCompositionSpec
            com.airbnb.lottie.compose.LottieCompositionSpec$RawRes r3 = com.airbnb.lottie.compose.LottieCompositionSpec.RawRes.m9175boximpl(r3)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 8
            r11 = 62
            r9 = r2
            com.airbnb.lottie.compose.LottieCompositionResult r14 = com.airbnb.lottie.compose.RememberLottieCompositionKt.rememberLottieComposition(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            com.airbnb.lottie.LottieComposition r3 = m8308CheckboxAnimatedCheckmark$lambda1(r14)
            r4 = 0
            r5 = 0
            int[] r7 = com.designsystem.ds_checkbox_v2.CheckboxComposablesKt.WhenMappings.$EnumSwitchMapping$0
            int r8 = r19.ordinal()
            r7 = r7[r8]
            r8 = 1
            r9 = 1065353216(0x3f800000, float:1.0)
            if (r7 == r8) goto L_0x0065
            if (r7 == r12) goto L_0x0062
            r8 = 3
            if (r7 != r8) goto L_0x005c
            goto L_0x0065
        L_0x005c:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0062:
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x0066
        L_0x0065:
            r7 = r9
        L_0x0066:
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 8
            r13 = 238(0xee, float:3.34E-43)
            r11 = r2
            com.airbnb.lottie.compose.LottieAnimationState r3 = com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = com.designsystem.composition.LocalCompositionResultKt.getLocalLottieCompositionState()
            java.lang.Object r4 = r2.consume(r4)
            com.designsystem.composition.LottieCompositionState r4 = (com.designsystem.composition.LottieCompositionState) r4
            r5 = 0
            if (r4 != 0) goto L_0x0081
        L_0x007f:
            r4 = r5
            goto L_0x008c
        L_0x0081:
            com.airbnb.lottie.compose.LottieCompositionResult r4 = r4.getLottieCompositionResult()
            if (r4 != 0) goto L_0x0088
            goto L_0x007f
        L_0x0088:
            com.airbnb.lottie.LottieComposition r4 = r4.getValue()
        L_0x008c:
            if (r4 != 0) goto L_0x0092
            com.airbnb.lottie.LottieComposition r4 = m8308CheckboxAnimatedCheckmark$lambda1(r14)
        L_0x0092:
            androidx.compose.runtime.ProvidableCompositionLocal r6 = com.designsystem.composition.LocalCompositionResultKt.getLocalLottieCompositionState()
            java.lang.Object r6 = r2.consume(r6)
            com.designsystem.composition.LottieCompositionState r6 = (com.designsystem.composition.LottieCompositionState) r6
            if (r6 != 0) goto L_0x009f
            goto L_0x00a7
        L_0x009f:
            float r5 = r6.getProgress()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
        L_0x00a7:
            if (r5 != 0) goto L_0x00ae
            float r3 = m8309CheckboxAnimatedCheckmark$lambda2(r3)
            goto L_0x00b2
        L_0x00ae:
            float r3 = r5.floatValue()
        L_0x00b2:
            r5 = r3
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 8
            r17 = 0
            r18 = 4092(0xffc, float:5.734E-42)
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r2
            com.airbnb.lottie.compose.LottieAnimationKt.LottieAnimation(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
        L_0x00d3:
            androidx.compose.runtime.ScopeUpdateScope r2 = r2.endRestartGroup()
            if (r2 != 0) goto L_0x00da
            goto L_0x00e2
        L_0x00da:
            com.designsystem.ds_checkbox_v2.CheckboxComposablesKt$CheckboxAnimatedCheckmark$1 r3 = new com.designsystem.ds_checkbox_v2.CheckboxComposablesKt$CheckboxAnimatedCheckmark$1
            r3.<init>(r0, r1)
            r2.updateScope(r3)
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_checkbox_v2.CheckboxComposablesKt.CheckboxAnimatedCheckmark(androidx.compose.ui.state.ToggleableState, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: CheckboxAnimatedCheckmark$lambda-1  reason: not valid java name */
    private static final LottieComposition m8308CheckboxAnimatedCheckmark$lambda1(LottieCompositionResult lottieCompositionResult) {
        return (LottieComposition) lottieCompositionResult.getValue();
    }

    /* renamed from: CheckboxAnimatedCheckmark$lambda-2  reason: not valid java name */
    private static final float m8309CheckboxAnimatedCheckmark$lambda2(LottieAnimationState lottieAnimationState) {
        return ((Number) lottieAnimationState.getValue()).floatValue();
    }

    @Composable
    public static final void ToggleableCheckbox(@NotNull ToggleableState toggleableState, boolean z11, @Nullable Function0<Unit> function0, @Nullable Modifier modifier, @Nullable Composer composer, int i11, int i12) {
        int i13;
        Modifier modifier2;
        int i14;
        int i15;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(toggleableState, "state");
        Composer startRestartGroup = composer.startRestartGroup(-278792020);
        if ((i12 & 1) != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) toggleableState)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i13 = i17 | i11;
        } else {
            i13 = i11;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(z11)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i13 |= i16;
        }
        if ((i12 & 4) != 0) {
            i13 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i11 & 896) == 0) {
            if (startRestartGroup.changed((Object) function0)) {
                i15 = 256;
            } else {
                i15 = 128;
            }
            i13 |= i15;
        }
        int i18 = i12 & 8;
        if (i18 != 0) {
            i13 |= KfsConstant.KFS_RSA_KEY_LEN_3072;
        } else if ((i11 & 7168) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i14 = 2048;
            } else {
                i14 = 1024;
            }
            i13 |= i14;
        }
        if (((i13 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            if (i18 != 0) {
                modifier = Modifier.Companion;
            }
            if (function0 != null) {
                Modifier.Companion companion = Modifier.Companion;
                int r22 = Role.Companion.m4912getCheckboxo7Vup1c();
                modifier2 = ToggleableKt.m790triStateToggleableO2vRcR0(companion, toggleableState, InteractionSourceKt.MutableInteractionSource(), (Indication) null, z11, Role.m4904boximpl(r22), function0);
            } else {
                modifier2 = Modifier.Companion;
            }
            Checkbox(toggleableState, z11, modifier.then(modifier2), startRestartGroup, (i13 & 112) | (i13 & 14));
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier3 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CheckboxComposablesKt$ToggleableCheckbox$1(toggleableState, z11, function0, modifier3, i11, i12));
        }
    }

    public static final int getDSCheckboxCompositionSpec() {
        return DSCheckboxCompositionSpec;
    }
}
