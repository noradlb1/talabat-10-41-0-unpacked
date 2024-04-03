package androidx.compose.material;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a?\u0010!\u001a\u00020\u0014*\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0006\u0010\u001c\u001a\u00020%H\u0003¢\u0006\u0002\u0010&\u001a1\u0010'\u001a\u00020\u0014*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\t\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\n\u0010\u000b\"\u0013\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\r\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000e\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u000f\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0010\u0010\u000b\"\u0019\u0010\u0011\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u000b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DefaultSwitchPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchHeight", "SwitchWidth", "ThumbDefaultElevation", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPathLength", "ThumbPressedElevation", "ThumbRippleRadius", "TrackStrokeWidth", "getTrackStrokeWidth", "TrackWidth", "getTrackWidth", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Landroidx/compose/runtime/State;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SwitchKt {
    @NotNull
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float DefaultSwitchPadding = Dp.m5478constructorimpl((float) 2);
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation = Dp.m5478constructorimpl((float) 1);
    private static final float ThumbDiameter;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation = Dp.m5478constructorimpl((float) 6);
    private static final float ThumbRippleRadius = Dp.m5478constructorimpl((float) 24);
    private static final float TrackStrokeWidth = Dp.m5478constructorimpl((float) 14);
    private static final float TrackWidth;

    static {
        float r02 = Dp.m5478constructorimpl((float) 34);
        TrackWidth = r02;
        float r12 = Dp.m5478constructorimpl((float) 20);
        ThumbDiameter = r12;
        SwitchWidth = r02;
        SwitchHeight = r12;
        ThumbPathLength = Dp.m5478constructorimpl(r02 - r12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0172  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Switch(boolean r35, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r36, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r37, boolean r38, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r39, @org.jetbrains.annotations.Nullable androidx.compose.material.SwitchColors r40, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r7 = r36
            r8 = r42
            r0 = 25866825(0x18ab249, float:5.094902E-38)
            r1 = r41
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r43 & 1
            r6 = 2
            if (r1 == 0) goto L_0x0017
            r1 = r8 | 6
            r5 = r35
            goto L_0x0029
        L_0x0017:
            r1 = r8 & 14
            r5 = r35
            if (r1 != 0) goto L_0x0028
            boolean r1 = r0.changed((boolean) r5)
            if (r1 == 0) goto L_0x0025
            r1 = 4
            goto L_0x0026
        L_0x0025:
            r1 = r6
        L_0x0026:
            r1 = r1 | r8
            goto L_0x0029
        L_0x0028:
            r1 = r8
        L_0x0029:
            r2 = r43 & 2
            if (r2 == 0) goto L_0x0030
            r1 = r1 | 48
            goto L_0x0040
        L_0x0030:
            r2 = r8 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0040
            boolean r2 = r0.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x003d
            r2 = 32
            goto L_0x003f
        L_0x003d:
            r2 = 16
        L_0x003f:
            r1 = r1 | r2
        L_0x0040:
            r2 = r43 & 4
            if (r2 == 0) goto L_0x0047
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005a
        L_0x0047:
            r3 = r8 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x005a
            r3 = r37
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0056
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0058
        L_0x0056:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0058:
            r1 = r1 | r4
            goto L_0x005c
        L_0x005a:
            r3 = r37
        L_0x005c:
            r4 = r43 & 8
            if (r4 == 0) goto L_0x0063
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0076
        L_0x0063:
            r9 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0076
            r9 = r38
            boolean r10 = r0.changed((boolean) r9)
            if (r10 == 0) goto L_0x0072
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0074
        L_0x0072:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0074:
            r1 = r1 | r10
            goto L_0x0078
        L_0x0076:
            r9 = r38
        L_0x0078:
            r10 = r43 & 16
            if (r10 == 0) goto L_0x007f
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0094
        L_0x007f:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r8
            if (r11 != 0) goto L_0x0094
            r11 = r39
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0090
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x0090:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r1 = r1 | r12
            goto L_0x0096
        L_0x0094:
            r11 = r39
        L_0x0096:
            r32 = 458752(0x70000, float:6.42848E-40)
            r12 = r8 & r32
            if (r12 != 0) goto L_0x00b1
            r12 = r43 & 32
            if (r12 != 0) goto L_0x00ab
            r12 = r40
            boolean r13 = r0.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00ad
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00af
        L_0x00ab:
            r12 = r40
        L_0x00ad:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00af:
            r1 = r1 | r13
            goto L_0x00b3
        L_0x00b1:
            r12 = r40
        L_0x00b3:
            r13 = 374491(0x5b6db, float:5.24774E-40)
            r13 = r13 & r1
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r13 != r14) goto L_0x00cb
            boolean r13 = r0.getSkipping()
            if (r13 != 0) goto L_0x00c3
            goto L_0x00cb
        L_0x00c3:
            r0.skipToGroupEnd()
            r4 = r9
            r5 = r11
            r6 = r12
            goto L_0x02fa
        L_0x00cb:
            r0.startDefaults()
            r13 = r8 & 1
            r33 = -458753(0xfffffffffff8ffff, float:NaN)
            r34 = 1
            if (r13 == 0) goto L_0x00f1
            boolean r13 = r0.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00de
            goto L_0x00f1
        L_0x00de:
            r0.skipToGroupEnd()
            r2 = r43 & 32
            if (r2 == 0) goto L_0x00e7
            r1 = r1 & r33
        L_0x00e7:
            r15 = r3
            r17 = r9
            r30 = r11
            r31 = r12
        L_0x00ee:
            r9 = r1
            goto L_0x0156
        L_0x00f1:
            if (r2 == 0) goto L_0x00f6
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x00f7
        L_0x00f6:
            r2 = r3
        L_0x00f7:
            if (r4 == 0) goto L_0x00fc
            r3 = r34
            goto L_0x00fd
        L_0x00fc:
            r3 = r9
        L_0x00fd:
            if (r10 == 0) goto L_0x011e
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r4)
            java.lang.Object r4 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r4 != r9) goto L_0x0118
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r4)
        L_0x0118:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            goto L_0x011f
        L_0x011e:
            r4 = r11
        L_0x011f:
            r9 = r43 & 32
            if (r9 == 0) goto L_0x014e
            androidx.compose.material.SwitchDefaults r9 = androidx.compose.material.SwitchDefaults.INSTANCE
            r10 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r24 = 0
            r26 = 0
            r29 = 0
            r30 = 6
            r31 = 1023(0x3ff, float:1.434E-42)
            r28 = r0
            androidx.compose.material.SwitchColors r9 = r9.m1400colorsSQMK_m0(r10, r12, r14, r15, r17, r19, r20, r22, r24, r26, r28, r29, r30, r31)
            r1 = r1 & r33
            r15 = r2
            r17 = r3
            r30 = r4
            r31 = r9
            goto L_0x00ee
        L_0x014e:
            r9 = r1
            r15 = r2
            r17 = r3
            r30 = r4
            r31 = r12
        L_0x0156:
            r0.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            float r2 = ThumbPathLength
            float r10 = r1.m5447toPx0680j_4(r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r35)
            if (r7 != 0) goto L_0x0172
            androidx.compose.material.SwitchKt$Switch$swipeableState$1 r2 = androidx.compose.material.SwitchKt$Switch$swipeableState$1.INSTANCE
            goto L_0x0173
        L_0x0172:
            r2 = r7
        L_0x0173:
            androidx.compose.animation.core.TweenSpec<java.lang.Float> r3 = AnimationSpec
            r4 = r9 & 14
            r11 = r4 | 384(0x180, float:5.38E-43)
            r12 = 0
            r4 = r0
            r5 = r11
            r11 = r6
            r6 = r12
            androidx.compose.material.SwipeableState r12 = androidx.compose.material.SwipeableKt.rememberSwipeableStateFor(r1, r2, r3, r4, r5, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.ui.unit.LayoutDirection r2 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r13 = 0
            if (r1 != r2) goto L_0x0192
            r23 = r34
            goto L_0x0194
        L_0x0192:
            r23 = r13
        L_0x0194:
            if (r7 == 0) goto L_0x01b2
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r2 = androidx.compose.ui.semantics.Role.Companion
            int r2 = r2.m4915getSwitcho7Vup1c()
            r3 = 0
            androidx.compose.ui.semantics.Role r5 = androidx.compose.ui.semantics.Role.m4904boximpl(r2)
            r14 = r0
            r0 = r1
            r1 = r35
            r2 = r30
            r4 = r17
            r6 = r36
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m786toggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x01b5
        L_0x01b2:
            r14 = r0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
        L_0x01b5:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            if (r7 == 0) goto L_0x01bd
            androidx.compose.ui.Modifier r1 = androidx.compose.material.TouchTargetKt.minimumTouchTargetSize(r1)
        L_0x01bd:
            androidx.compose.ui.Modifier r1 = r15.then(r1)
            androidx.compose.ui.Modifier r18 = r1.then(r0)
            kotlin.Pair[] r0 = new kotlin.Pair[r11]
            r1 = 0
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r2)
            r0[r13] = r1
            java.lang.Float r1 = java.lang.Float.valueOf(r10)
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r2)
            r0[r34] = r1
            java.util.Map r20 = kotlin.collections.MapsKt__MapsKt.mapOf(r0)
            androidx.compose.foundation.gestures.Orientation r21 = androidx.compose.foundation.gestures.Orientation.Horizontal
            if (r17 == 0) goto L_0x01ed
            if (r7 == 0) goto L_0x01ed
            r22 = r34
            goto L_0x01ef
        L_0x01ed:
            r22 = r13
        L_0x01ef:
            androidx.compose.material.SwitchKt$Switch$2 r25 = androidx.compose.material.SwitchKt$Switch$2.INSTANCE
            r26 = 0
            r27 = 0
            r28 = 256(0x100, float:3.59E-43)
            r29 = 0
            r19 = r12
            r24 = r30
            androidx.compose.ui.Modifier r0 = androidx.compose.material.SwipeableKt.m1395swipeablepPrIpRY$default(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r1.getCenter()
            r3 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r0, r2, r13, r11, r3)
            float r2 = DefaultSwitchPadding
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.m486padding3ABfNKs(r0, r2)
            float r2 = SwitchWidth
            float r3 = SwitchHeight
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m552requiredSizeVpY3zN4(r0, r2, r3)
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r14.startReplaceableGroup(r2)
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r13, r14, r13)
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r14.startReplaceableGroup(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r2 = r14.consume(r2)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r3 = r14.consume(r3)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r4 = r14.consume(r4)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r10 = r14.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0261
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0261:
            r14.startReusableNode()
            boolean r10 = r14.getInserting()
            if (r10 == 0) goto L_0x026e
            r14.createNode(r6)
            goto L_0x0271
        L_0x026e:
            r14.useNode()
        L_0x0271:
            r14.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m2536constructorimpl(r14)
            kotlin.jvm.functions.Function2 r10 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r1, r10)
            kotlin.jvm.functions.Function2 r1 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r2, r1)
            kotlin.jvm.functions.Function2 r1 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r3, r1)
            kotlin.jvm.functions.Function2 r1 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r6, r4, r1)
            r14.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r14)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r0.invoke(r1, r14, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r0)
            r0 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r14.startReplaceableGroup(r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r1 = 1571176015(0x5da63e4f, float:1.49738737E18)
            r14.startReplaceableGroup(r1)
            androidx.compose.runtime.State r13 = r12.getOffset()
            int r1 = r9 << 3
            r2 = r1 & 112(0x70, float:1.57E-43)
            r3 = 6
            r2 = r2 | r3
            int r4 = r9 >> 3
            r4 = r4 & 896(0x380, float:1.256E-42)
            r2 = r2 | r4
            int r3 = r9 >> 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r1 = r1 & r32
            r16 = r2 | r1
            r9 = r0
            r10 = r35
            r11 = r17
            r12 = r31
            r0 = r14
            r14 = r30
            r2 = r15
            r15 = r0
            SwitchImpl(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r3 = r2
            r4 = r17
            r5 = r30
            r6 = r31
        L_0x02fa:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x0301
            goto L_0x0312
        L_0x0301:
            androidx.compose.material.SwitchKt$Switch$4 r10 = new androidx.compose.material.SwitchKt$Switch$4
            r0 = r10
            r1 = r35
            r2 = r36
            r7 = r42
            r8 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.updateScope(r10)
        L_0x0312:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SwitchColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SwitchImpl(BoxScope boxScope, boolean z11, boolean z12, SwitchColors switchColors, State<Float> state, InteractionSource interactionSource, Composer composer, int i11) {
        int i12;
        float f11;
        int i13;
        long j11;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        BoxScope boxScope2 = boxScope;
        boolean z13 = z11;
        boolean z14 = z12;
        SwitchColors switchColors2 = switchColors;
        State<Float> state2 = state;
        InteractionSource interactionSource2 = interactionSource;
        int i21 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-1834839253);
        if ((i21 & 14) == 0) {
            if (startRestartGroup.changed((Object) boxScope2)) {
                i19 = 4;
            } else {
                i19 = 2;
            }
            i12 = i19 | i21;
        } else {
            i12 = i21;
        }
        if ((i21 & 112) == 0) {
            if (startRestartGroup.changed(z13)) {
                i18 = 32;
            } else {
                i18 = 16;
            }
            i12 |= i18;
        }
        if ((i21 & 896) == 0) {
            if (startRestartGroup.changed(z14)) {
                i17 = 256;
            } else {
                i17 = 128;
            }
            i12 |= i17;
        }
        if ((i21 & 7168) == 0) {
            if (startRestartGroup.changed((Object) switchColors2)) {
                i16 = 2048;
            } else {
                i16 = 1024;
            }
            i12 |= i16;
        }
        if ((57344 & i21) == 0) {
            if (startRestartGroup.changed((Object) state2)) {
                i15 = 16384;
            } else {
                i15 = 8192;
            }
            i12 |= i15;
        }
        if ((458752 & i21) == 0) {
            if (startRestartGroup.changed((Object) interactionSource2)) {
                i14 = 131072;
            } else {
                i14 = 65536;
            }
            i12 |= i14;
        }
        if ((374491 & i12) != 74898 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateListOf();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
            int i22 = (i12 >> 15) & 14;
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed((Object) interactionSource2) | startRestartGroup.changed((Object) snapshotStateList);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new SwitchKt$SwitchImpl$1$1(interactionSource2, snapshotStateList, (Continuation<? super SwitchKt$SwitchImpl$1$1>) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect((Object) interactionSource2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, startRestartGroup, i22);
            if (!snapshotStateList.isEmpty()) {
                f11 = ThumbPressedElevation;
            } else {
                f11 = ThumbDefaultElevation;
            }
            float f12 = f11;
            int i23 = ((i12 >> 3) & 896) | ((i12 >> 6) & 14) | (i12 & 112);
            State<Color> trackColor = switchColors2.trackColor(z14, z13, startRestartGroup, i23);
            Modifier.Companion companion2 = Modifier.Companion;
            Alignment.Companion companion3 = Alignment.Companion;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(boxScope2.align(companion2, companion3.getCenter()), 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed2 = startRestartGroup.changed((Object) trackColor);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new SwitchKt$SwitchImpl$2$1(trackColor);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(fillMaxSize$default, (Function1) rememberedValue3, startRestartGroup, 0);
            State<Color> thumbColor = switchColors2.thumbColor(z14, z13, startRestartGroup, i23);
            ElevationOverlay elevationOverlay = (ElevationOverlay) startRestartGroup.consume(ElevationOverlayKt.getLocalElevationOverlay());
            float r12 = Dp.m5478constructorimpl(((Dp) startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m5492unboximpl() + f12);
            startRestartGroup.startReplaceableGroup(-539245361);
            Composer.Companion companion4 = companion;
            if (!Color.m2920equalsimpl0(m1402SwitchImpl$lambda7(thumbColor), MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1183getSurface0d7_KjU()) || elevationOverlay == null) {
                i13 = 1157296644;
                j11 = m1402SwitchImpl$lambda7(thumbColor);
            } else {
                i13 = 1157296644;
                j11 = elevationOverlay.m1247apply7g2Lkgo(m1402SwitchImpl$lambda7(thumbColor), r12, startRestartGroup, 0);
            }
            long j12 = j11;
            startRestartGroup.endReplaceableGroup();
            Modifier align = boxScope2.align(companion2, companion3.getCenterStart());
            startRestartGroup.startReplaceableGroup(i13);
            boolean changed3 = startRestartGroup.changed((Object) state2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue4 == companion4.getEmpty()) {
                rememberedValue4 = new SwitchKt$SwitchImpl$3$1(state2);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceableGroup();
            SpacerKt.Spacer(BackgroundKt.m176backgroundbw27NRU(ShadowKt.m2593shadows4CzXII$default(SizeKt.m550requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(align, (Function1) rememberedValue4), interactionSource2, RippleKt.m1485rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0, startRestartGroup, 54, 4)), ThumbDiameter), f12, RoundedCornerShapeKt.getCircleShape(), false, 0, 0, 24, (Object) null), j12, RoundedCornerShapeKt.getCircleShape()), startRestartGroup, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SwitchKt$SwitchImpl$4(boxScope, z11, z12, switchColors, state, interactionSource, i11));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: SwitchImpl$lambda-5  reason: not valid java name */
    public static final long m1401SwitchImpl$lambda5(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* renamed from: SwitchImpl$lambda-7  reason: not valid java name */
    private static final long m1402SwitchImpl$lambda7(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: drawTrack-RPmYEkk  reason: not valid java name */
    public static final void m1405drawTrackRPmYEkk(DrawScope drawScope, long j11, float f11, float f12) {
        float f13 = f12 / ((float) 2);
        b.C(drawScope, j11, androidx.compose.ui.geometry.OffsetKt.Offset(f13, Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0())), androidx.compose.ui.geometry.OffsetKt.Offset(f11 - f13, Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0())), f12, StrokeCap.Companion.m3254getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }
}
