package androidx.compose.material3;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aj\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a|\u0010\u001f\u001a\u00020\u000f*\u00020 2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"2\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010\u001c\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\b\u0010\t\"\u0013\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\r\u0010\t\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "SwitchHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchWidth", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPadding", "ThumbPathLength", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Landroidx/compose/material3/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "Landroidx/compose/ui/graphics/Shape;", "uncheckedThumbDiameter", "minBound", "maxBound", "SwitchImpl-0DmnUew", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material3/SwitchColors;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;FFFLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SwitchKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDiameter;
    private static final float ThumbPadding;
    private static final float ThumbPathLength;
    private static final float UncheckedThumbDiameter;

    static {
        SwitchTokens switchTokens = SwitchTokens.INSTANCE;
        float r12 = switchTokens.m2446getSelectedHandleWidthD9Ej5fM();
        ThumbDiameter = r12;
        UncheckedThumbDiameter = switchTokens.m2453getUnselectedHandleWidthD9Ej5fM();
        float r22 = switchTokens.m2451getTrackWidthD9Ej5fM();
        SwitchWidth = r22;
        float r02 = switchTokens.m2449getTrackHeightD9Ej5fM();
        SwitchHeight = r02;
        float r03 = Dp.m5478constructorimpl(Dp.m5478constructorimpl(r02 - r12) / ((float) 2));
        ThumbPadding = r03;
        ThumbPathLength = Dp.m5478constructorimpl(Dp.m5478constructorimpl(r22 - r12) - r03);
    }

    /* JADX WARNING: Removed duplicated region for block: B:147:0x03cf  */
    /* JADX WARNING: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00ee  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Switch(boolean r52, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r53, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r54, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, boolean r56, @org.jetbrains.annotations.Nullable androidx.compose.material3.SwitchColors r57, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r58, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r59, int r60, int r61) {
        /*
            r7 = r53
            r8 = r60
            r0 = 1580463220(0x5e33f474, float:3.24177919E18)
            r1 = r59
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            r1 = r61 & 1
            if (r1 == 0) goto L_0x0016
            r1 = r8 | 6
            r4 = r52
            goto L_0x0028
        L_0x0016:
            r1 = r8 & 14
            r4 = r52
            if (r1 != 0) goto L_0x0027
            boolean r1 = r6.changed((boolean) r4)
            if (r1 == 0) goto L_0x0024
            r1 = 4
            goto L_0x0025
        L_0x0024:
            r1 = 2
        L_0x0025:
            r1 = r1 | r8
            goto L_0x0028
        L_0x0027:
            r1 = r8
        L_0x0028:
            r2 = r61 & 2
            if (r2 == 0) goto L_0x002f
            r1 = r1 | 48
            goto L_0x003f
        L_0x002f:
            r2 = r8 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x003f
            boolean r2 = r6.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x003c
            r2 = 32
            goto L_0x003e
        L_0x003c:
            r2 = 16
        L_0x003e:
            r1 = r1 | r2
        L_0x003f:
            r2 = r61 & 4
            if (r2 == 0) goto L_0x0046
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0059
        L_0x0046:
            r3 = r8 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0059
            r3 = r54
            boolean r9 = r6.changed((java.lang.Object) r3)
            if (r9 == 0) goto L_0x0055
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0057
        L_0x0055:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0057:
            r1 = r1 | r9
            goto L_0x005b
        L_0x0059:
            r3 = r54
        L_0x005b:
            r9 = r61 & 8
            if (r9 == 0) goto L_0x0062
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0075
        L_0x0062:
            r10 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x0075
            r10 = r55
            boolean r11 = r6.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0071
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x0071:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r1 = r1 | r11
            goto L_0x0077
        L_0x0075:
            r10 = r55
        L_0x0077:
            r11 = r61 & 16
            if (r11 == 0) goto L_0x007e
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0093
        L_0x007e:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x0093
            r12 = r56
            boolean r13 = r6.changed((boolean) r12)
            if (r13 == 0) goto L_0x008f
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0091
        L_0x008f:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0091:
            r1 = r1 | r13
            goto L_0x0095
        L_0x0093:
            r12 = r56
        L_0x0095:
            r46 = 458752(0x70000, float:6.42848E-40)
            r13 = r8 & r46
            if (r13 != 0) goto L_0x00b0
            r13 = r61 & 32
            if (r13 != 0) goto L_0x00aa
            r13 = r57
            boolean r14 = r6.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00ac
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00aa:
            r13 = r57
        L_0x00ac:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00ae:
            r1 = r1 | r14
            goto L_0x00b2
        L_0x00b0:
            r13 = r57
        L_0x00b2:
            r47 = r61 & 64
            r48 = 3670016(0x380000, float:5.142788E-39)
            if (r47 == 0) goto L_0x00bc
            r14 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r14
            goto L_0x00cf
        L_0x00bc:
            r14 = r8 & r48
            if (r14 != 0) goto L_0x00cf
            r14 = r58
            boolean r15 = r6.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00cb
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00cb:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r1 = r1 | r15
            goto L_0x00d1
        L_0x00cf:
            r14 = r58
        L_0x00d1:
            r15 = 2995931(0x2db6db, float:4.198194E-39)
            r15 = r15 & r1
            r5 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r5) goto L_0x00ee
            boolean r5 = r6.getSkipping()
            if (r5 != 0) goto L_0x00e1
            goto L_0x00ee
        L_0x00e1:
            r6.skipToGroupEnd()
            r4 = r3
            r3 = r6
            r23 = r10
            r5 = r12
            r6 = r13
            r25 = r14
            goto L_0x03c8
        L_0x00ee:
            r6.startDefaults()
            r5 = r8 & 1
            r49 = -458753(0xfffffffffff8ffff, float:NaN)
            r15 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            if (r5 == 0) goto L_0x0119
            boolean r5 = r6.getDefaultsInvalid()
            if (r5 == 0) goto L_0x0102
            goto L_0x0119
        L_0x0102:
            r6.skipToGroupEnd()
            r2 = r61 & 32
            if (r2 == 0) goto L_0x010b
            r1 = r1 & r49
        L_0x010b:
            r9 = r1
            r23 = r10
            r50 = r12
            r24 = r13
            r25 = r14
            r3 = r15
            r15 = r54
            goto L_0x0193
        L_0x0119:
            if (r2 == 0) goto L_0x011e
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x0120
        L_0x011e:
            r2 = r54
        L_0x0120:
            if (r9 == 0) goto L_0x0124
            r5 = 0
            goto L_0x0125
        L_0x0124:
            r5 = r10
        L_0x0125:
            if (r11 == 0) goto L_0x012b
            r9 = 1
            r50 = r9
            goto L_0x012d
        L_0x012b:
            r50 = r12
        L_0x012d:
            r9 = r61 & 32
            if (r9 == 0) goto L_0x0164
            androidx.compose.material3.SwitchDefaults r9 = androidx.compose.material3.SwitchDefaults.INSTANCE
            r10 = 0
            r12 = 0
            r16 = 0
            r3 = r15
            r14 = r16
            r18 = 0
            r20 = 0
            r22 = 0
            r24 = 0
            r26 = 0
            r28 = 0
            r30 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            r38 = 0
            r40 = 0
            r43 = 0
            r44 = 1572864(0x180000, float:2.204052E-39)
            r45 = 65535(0xffff, float:9.1834E-41)
            r42 = r6
            androidx.compose.material3.SwitchColors r9 = r9.m1873colorsV1nXRL4(r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r43, r44, r45)
            r1 = r1 & r49
            goto L_0x0166
        L_0x0164:
            r3 = r15
            r9 = r13
        L_0x0166:
            if (r47 == 0) goto L_0x018b
            r6.startReplaceableGroup(r3)
            java.lang.Object r10 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r10 != r11) goto L_0x017e
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r6.updateRememberedValue(r10)
        L_0x017e:
            r6.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = (androidx.compose.foundation.interaction.MutableInteractionSource) r10
            r15 = r2
            r23 = r5
            r24 = r9
            r25 = r10
            goto L_0x0192
        L_0x018b:
            r25 = r58
            r15 = r2
            r23 = r5
            r24 = r9
        L_0x0192:
            r9 = r1
        L_0x0193:
            r6.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01a2
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.Switch (Switch.kt:90)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r1, r2)
        L_0x01a2:
            if (r23 != 0) goto L_0x01a7
            float r0 = UncheckedThumbDiameter
            goto L_0x01a9
        L_0x01a7:
            float r0 = ThumbDiameter
        L_0x01a9:
            r17 = r0
            float r10 = SwitchHeight
            float r0 = r10 - r17
            float r0 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
            r1 = 2
            float r2 = (float) r1
            float r0 = r0 / r2
            float r14 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r0 = r6.consume(r0)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            float r0 = r0.m5447toPx0680j_4(r14)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r1 = r6.consume(r1)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            float r13 = ThumbPathLength
            float r1 = r1.m5447toPx0680j_4(r13)
            java.lang.Float r2 = java.lang.Float.valueOf(r0)
            java.lang.Float r5 = java.lang.Float.valueOf(r1)
            r11 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r6.startReplaceableGroup(r11)
            boolean r2 = r6.changed((java.lang.Object) r2)
            boolean r5 = r6.changed((java.lang.Object) r5)
            r2 = r2 | r5
            java.lang.Object r5 = r6.rememberedValue()
            if (r2 != 0) goto L_0x01fd
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r5 != r2) goto L_0x0205
        L_0x01fd:
            androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1 r5 = new androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
            r5.<init>(r1, r0)
            r6.updateRememberedValue(r5)
        L_0x0205:
            r6.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r52)
            java.lang.Object r1 = r5.invoke(r1)
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            r6.startReplaceableGroup(r3)
            java.lang.Object r2 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r5.getEmpty()
            if (r2 != r11) goto L_0x0232
            r2 = 0
            r11 = 0
            r12 = 2
            androidx.compose.animation.core.Animatable r2 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r1, r2, r12, r11)
            r6.updateRememberedValue(r2)
            goto L_0x0234
        L_0x0232:
            r11 = 0
            r12 = 2
        L_0x0234:
            r6.endReplaceableGroup()
            androidx.compose.animation.core.Animatable r2 = (androidx.compose.animation.core.Animatable) r2
            r11 = 773894976(0x2e20b340, float:3.6538994E-11)
            r6.startReplaceableGroup(r11)
            r6.startReplaceableGroup(r3)
            java.lang.Object r3 = r6.rememberedValue()
            java.lang.Object r5 = r5.getEmpty()
            if (r3 != r5) goto L_0x025b
            kotlin.coroutines.EmptyCoroutineContext r3 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r3 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r3, r6)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r5 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r5.<init>(r3)
            r6.updateRememberedValue(r5)
            r3 = r5
        L_0x025b:
            r6.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r3
            kotlinx.coroutines.CoroutineScope r3 = r3.getCoroutineScope()
            r6.endReplaceableGroup()
            androidx.compose.material3.SwitchKt$Switch$2 r5 = new androidx.compose.material3.SwitchKt$Switch$2
            r5.<init>(r2, r0)
            r11 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r5, r6, r11)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r52)
            androidx.compose.material3.SwitchKt$Switch$3 r5 = new androidx.compose.material3.SwitchKt$Switch$3
            r5.<init>(r2, r1, r3)
            r1 = r9 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r5, (androidx.compose.runtime.Composer) r6, (int) r1)
            if (r7 == 0) goto L_0x029f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r1 = r1.m4915getSwitcho7Vup1c()
            r3 = 0
            androidx.compose.ui.semantics.Role r5 = androidx.compose.ui.semantics.Role.m4904boximpl(r1)
            r1 = r52
            r16 = r2
            r2 = r25
            r12 = 0
            r4 = r50
            r51 = r6
            r6 = r53
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m786toggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x02a6
        L_0x029f:
            r16 = r2
            r51 = r6
            r12 = 0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
        L_0x02a6:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            if (r7 == 0) goto L_0x02ae
            androidx.compose.ui.Modifier r1 = androidx.compose.material3.TouchTargetKt.minimumTouchTargetSize(r1)
        L_0x02ae:
            androidx.compose.ui.Modifier r1 = r15.then(r1)
            androidx.compose.ui.Modifier r0 = r1.then(r0)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r1.getCenter()
            r3 = 2
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r0, r2, r11, r3, r12)
            float r2 = SwitchWidth
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m552requiredSizeVpY3zN4(r0, r2, r10)
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r3 = r51
            r3.startReplaceableGroup(r2)
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r11, r3, r11)
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r2 = r3.consume(r2)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r4 = r3.consume(r4)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r5 = r3.consume(r5)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r12 = r3.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x0310
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0310:
            r3.startReusableNode()
            boolean r12 = r3.getInserting()
            if (r12 == 0) goto L_0x031d
            r3.createNode(r10)
            goto L_0x0320
        L_0x031d:
            r3.useNode()
        L_0x0320:
            r3.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m2536constructorimpl(r3)
            kotlin.jvm.functions.Function2 r12 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r1, r12)
            kotlin.jvm.functions.Function2 r1 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r2, r1)
            kotlin.jvm.functions.Function2 r1 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r4, r1)
            kotlin.jvm.functions.Function2 r1 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r5, r1)
            r3.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            r0.invoke(r1, r3, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r0)
            r0 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r3.startReplaceableGroup(r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r1 = 1204996270(0x47d2c8ae, float:107921.36)
            r3.startReplaceableGroup(r1)
            androidx.compose.runtime.State r1 = r16.asState()
            androidx.compose.material3.tokens.SwitchTokens r2 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r2 = r2.getHandleShape()
            r4 = 6
            androidx.compose.ui.graphics.Shape r16 = androidx.compose.material3.ShapesKt.toShape(r2, r3, r4)
            int r2 = r9 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | r4
            int r4 = r9 >> 6
            r5 = r4 & 896(0x380, float:1.256E-42)
            r2 = r2 | r5
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r4
            int r4 = r9 << 6
            r4 = r4 & r46
            r2 = r2 | r4
            r4 = r9 & r48
            r21 = r2 | r4
            r22 = 6
            r9 = r0
            r10 = r52
            r11 = r50
            r12 = r24
            r0 = r13
            r13 = r1
            r1 = r14
            r14 = r23
            r2 = r15
            r15 = r25
            r18 = r1
            r19 = r0
            r20 = r3
            m1875SwitchImpl0DmnUew(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            r3.endNode()
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03c3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03c3:
            r4 = r2
            r6 = r24
            r5 = r50
        L_0x03c8:
            androidx.compose.runtime.ScopeUpdateScope r10 = r3.endRestartGroup()
            if (r10 != 0) goto L_0x03cf
            goto L_0x03e5
        L_0x03cf:
            androidx.compose.material3.SwitchKt$Switch$5 r11 = new androidx.compose.material3.SwitchKt$Switch$5
            r0 = r11
            r1 = r52
            r2 = r53
            r3 = r4
            r4 = r23
            r7 = r25
            r8 = r60
            r9 = r61
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.updateScope(r11)
        L_0x03e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.SwitchColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: SwitchImpl-0DmnUew  reason: not valid java name */
    public static final void m1875SwitchImpl0DmnUew(BoxScope boxScope, boolean z11, boolean z12, SwitchColors switchColors, State<Float> state, Function2<? super Composer, ? super Integer, Unit> function2, InteractionSource interactionSource, Shape shape, float f11, float f12, float f13, Composer composer, int i11, int i12) {
        int i13;
        int i14;
        float f14;
        float f15;
        float f16;
        BoxScope boxScope2 = boxScope;
        boolean z13 = z11;
        boolean z14 = z12;
        SwitchColors switchColors2 = switchColors;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        InteractionSource interactionSource2 = interactionSource;
        Shape shape2 = shape;
        float f17 = f11;
        float f18 = f12;
        float f19 = f13;
        int i15 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-1968109941);
        if ((i15 & 14) == 0) {
            i13 = (startRestartGroup.changed((Object) boxScope2) ? 4 : 2) | i15;
        } else {
            i13 = i15;
        }
        if ((i15 & 112) == 0) {
            i13 |= startRestartGroup.changed(z13) ? 32 : 16;
        }
        if ((i15 & 896) == 0) {
            i13 |= startRestartGroup.changed(z14) ? 256 : 128;
        }
        if ((i15 & 7168) == 0) {
            i13 |= startRestartGroup.changed((Object) switchColors2) ? 2048 : 1024;
        }
        if ((57344 & i15) == 0) {
            i13 |= startRestartGroup.changed((Object) state) ? 16384 : 8192;
        } else {
            State<Float> state2 = state;
        }
        if ((i15 & Opcodes.ASM7) == 0) {
            i13 |= startRestartGroup.changed((Object) function22) ? 131072 : 65536;
        }
        if ((i15 & 3670016) == 0) {
            i13 |= startRestartGroup.changed((Object) interactionSource2) ? 1048576 : 524288;
        }
        if ((i15 & 29360128) == 0) {
            i13 |= startRestartGroup.changed((Object) shape2) ? 8388608 : 4194304;
        }
        if ((i15 & 234881024) == 0) {
            i13 |= startRestartGroup.changed(f17) ? 67108864 : 33554432;
        }
        if ((i15 & 1879048192) == 0) {
            i13 |= startRestartGroup.changed(f18) ? 536870912 : 268435456;
        }
        if ((i12 & 14) == 0) {
            i14 = i12 | (startRestartGroup.changed(f19) ? 4 : 2);
        } else {
            i14 = i12;
        }
        if ((i13 & 1533916891) == 306783378 && (i14 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            InteractionSource interactionSource3 = interactionSource2;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1968109941, i13, i14, "androidx.compose.material3.SwitchImpl (Switch.kt:171)");
            }
            int i16 = ((i13 >> 6) & 14) | (i13 & 112) | ((i13 >> 3) & 896);
            State<Color> trackColor$material3_release = switchColors2.trackColor$material3_release(z14, z13, startRestartGroup, i16);
            State<Boolean> collectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(interactionSource2, startRestartGroup, (i13 >> 18) & 14);
            int i17 = i13;
            float r13 = ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).m5443toDpu2uoSUM(state.getValue().floatValue());
            if (m1878SwitchImpl_0DmnUew$lambda7(collectIsPressedAsState)) {
                f14 = SwitchTokens.INSTANCE.m2444getPressedHandleWidthD9Ej5fM();
            } else {
                f14 = Dp.m5478constructorimpl(Dp.m5478constructorimpl(Dp.m5478constructorimpl(ThumbDiameter - f17) * (Dp.m5478constructorimpl(r13 - f18) / Dp.m5478constructorimpl(f19 - f18))) + f17);
            }
            float f21 = f14;
            startRestartGroup.startReplaceableGroup(-993794194);
            if (m1878SwitchImpl_0DmnUew$lambda7(collectIsPressedAsState)) {
                Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                if (z13) {
                    f16 = Dp.m5478constructorimpl(ThumbPathLength - SwitchTokens.INSTANCE.m2450getTrackOutlineWidthD9Ej5fM());
                } else {
                    f16 = SwitchTokens.INSTANCE.m2450getTrackOutlineWidthD9Ej5fM();
                }
                f15 = density.m5447toPx0680j_4(f16);
            } else {
                f15 = state.getValue().floatValue();
            }
            startRestartGroup.endReplaceableGroup();
            SwitchTokens switchTokens = SwitchTokens.INSTANCE;
            Shape shape3 = ShapesKt.toShape(switchTokens.getTrackShape(), startRestartGroup, 6);
            Modifier.Companion companion = Modifier.Companion;
            Alignment.Companion companion2 = Alignment.Companion;
            Modifier r12 = BackgroundKt.m176backgroundbw27NRU(BorderKt.m182borderxT4_qwU(SizeKt.m544height3ABfNKs(SizeKt.m563width3ABfNKs(boxScope2.align(companion, companion2.getCenter()), SwitchWidth), SwitchHeight), switchTokens.m2450getTrackOutlineWidthD9Ej5fM(), switchColors2.borderColor$material3_release(z14, z13, startRestartGroup, i16).getValue().m2929unboximpl(), shape3), m1877SwitchImpl_0DmnUew$lambda6(trackColor$material3_release), shape3);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r12);
            float f22 = f21;
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
            Composer r92 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r92, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r92, density2, companion3.getSetDensity());
            Updater.m2543setimpl(r92, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r92, viewConfiguration, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(968687813);
            long r11 = m1876SwitchImpl_0DmnUew$lambda13$lambda10(switchColors2.thumbColor$material3_release(z14, z13, startRestartGroup, i16));
            Modifier align = boxScopeInstance.align(companion, companion2.getCenterStart());
            Float valueOf = Float.valueOf(f15);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed((Object) valueOf);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SwitchKt$SwitchImpl$1$1$1(f15);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            int i18 = i17;
            Modifier r62 = BackgroundKt.m176backgroundbw27NRU(SizeKt.m550requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(align, (Function1) rememberedValue), interactionSource, RippleKt.m1485rememberRipple9IZ8Weo(false, Dp.m5478constructorimpl(switchTokens.m2448getStateLayerSizeD9Ej5fM() / ((float) 2)), 0, startRestartGroup, 54, 4)), f22), r11, shape2);
            Alignment center = companion2.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r62);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r132 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r132, rememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r132, density3, companion3.getSetDensity());
            Updater.m2543setimpl(r132, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r132, viewConfiguration2, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            startRestartGroup.startReplaceableGroup(881862015);
            Function2<? super Composer, ? super Integer, Unit> function23 = function2;
            if (function23 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(switchColors2.iconColor$material3_release(z14, z13, startRestartGroup, i16).getValue())}, function23, startRestartGroup, ((i18 >> 12) & 112) | 8);
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SwitchKt$SwitchImpl$2(boxScope, z11, z12, switchColors, state, function2, interactionSource, shape, f11, f12, f13, i11, i12));
        }
    }

    /* renamed from: SwitchImpl_0DmnUew$lambda-13$lambda-10  reason: not valid java name */
    private static final long m1876SwitchImpl_0DmnUew$lambda13$lambda10(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* renamed from: SwitchImpl_0DmnUew$lambda-6  reason: not valid java name */
    private static final long m1877SwitchImpl_0DmnUew$lambda6(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* renamed from: SwitchImpl_0DmnUew$lambda-7  reason: not valid java name */
    private static final boolean m1878SwitchImpl_0DmnUew$lambda7(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return UncheckedThumbDiameter;
    }
}
