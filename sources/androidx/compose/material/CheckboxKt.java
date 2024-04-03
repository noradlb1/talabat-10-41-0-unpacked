package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import f0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u001c\u001aM\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010!\u001a9\u0010\"\u001a\u00020\f*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+\u001aA\u0010,\u001a\u00020\f*\u00020#2\u0006\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\b\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\t\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\n\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxRippleRadius", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/CheckboxColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material/CheckDrawingCache;)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxRippleRadius = Dp.m5478constructorimpl((float) 24);
    private static final float CheckboxSize = Dp.m5478constructorimpl((float) 20);
    /* access modifiers changed from: private */
    public static final float RadiusSize;
    /* access modifiers changed from: private */
    public static final float StrokeWidth;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
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

    static {
        float f11 = (float) 2;
        CheckboxDefaultPadding = Dp.m5478constructorimpl(f11);
        StrokeWidth = Dp.m5478constructorimpl(f11);
        RadiusSize = Dp.m5478constructorimpl(f11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0147  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Checkbox(boolean r26, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r27, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r28, boolean r29, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r30, @org.jetbrains.annotations.Nullable androidx.compose.material.CheckboxColors r31, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r1 = r26
            r2 = r27
            r7 = r33
            r0 = -2118660998(0xffffffff81b7cc7a, float:-6.751699E-38)
            r3 = r32
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            r3 = r34 & 1
            if (r3 == 0) goto L_0x0016
            r3 = r7 | 6
            goto L_0x0026
        L_0x0016:
            r3 = r7 & 14
            if (r3 != 0) goto L_0x0025
            boolean r3 = r0.changed((boolean) r1)
            if (r3 == 0) goto L_0x0022
            r3 = 4
            goto L_0x0023
        L_0x0022:
            r3 = 2
        L_0x0023:
            r3 = r3 | r7
            goto L_0x0026
        L_0x0025:
            r3 = r7
        L_0x0026:
            r4 = r34 & 2
            if (r4 == 0) goto L_0x002d
            r3 = r3 | 48
            goto L_0x003d
        L_0x002d:
            r4 = r7 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x003d
            boolean r4 = r0.changed((java.lang.Object) r2)
            if (r4 == 0) goto L_0x003a
            r4 = 32
            goto L_0x003c
        L_0x003a:
            r4 = 16
        L_0x003c:
            r3 = r3 | r4
        L_0x003d:
            r4 = r34 & 4
            if (r4 == 0) goto L_0x0044
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0057
        L_0x0044:
            r5 = r7 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0057
            r5 = r28
            boolean r6 = r0.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0053
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0055
        L_0x0053:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0055:
            r3 = r3 | r6
            goto L_0x0059
        L_0x0057:
            r5 = r28
        L_0x0059:
            r6 = r34 & 8
            if (r6 == 0) goto L_0x0060
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0073
        L_0x0060:
            r8 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0073
            r8 = r29
            boolean r9 = r0.changed((boolean) r8)
            if (r9 == 0) goto L_0x006f
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0071
        L_0x006f:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0071:
            r3 = r3 | r9
            goto L_0x0075
        L_0x0073:
            r8 = r29
        L_0x0075:
            r9 = r34 & 16
            r22 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x007f
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0092
        L_0x007f:
            r10 = r7 & r22
            if (r10 != 0) goto L_0x0092
            r10 = r30
            boolean r11 = r0.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x008e
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0090
        L_0x008e:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0090:
            r3 = r3 | r11
            goto L_0x0094
        L_0x0092:
            r10 = r30
        L_0x0094:
            r23 = 458752(0x70000, float:6.42848E-40)
            r11 = r7 & r23
            if (r11 != 0) goto L_0x00af
            r11 = r34 & 32
            if (r11 != 0) goto L_0x00a9
            r11 = r31
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x00ab
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ad
        L_0x00a9:
            r11 = r31
        L_0x00ab:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00ad:
            r3 = r3 | r12
            goto L_0x00b1
        L_0x00af:
            r11 = r31
        L_0x00b1:
            r12 = 374491(0x5b6db, float:5.24774E-40)
            r12 = r12 & r3
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r13) goto L_0x00ca
            boolean r12 = r0.getSkipping()
            if (r12 != 0) goto L_0x00c1
            goto L_0x00ca
        L_0x00c1:
            r0.skipToGroupEnd()
            r3 = r5
            r4 = r8
            r5 = r10
            r6 = r11
            goto L_0x019a
        L_0x00ca:
            r0.startDefaults()
            r12 = r7 & 1
            r24 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r12 == 0) goto L_0x00ea
            boolean r12 = r0.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00db
            goto L_0x00ea
        L_0x00db:
            r0.skipToGroupEnd()
            r4 = r34 & 32
            if (r4 == 0) goto L_0x00e4
            r3 = r3 & r24
        L_0x00e4:
            r4 = r5
            r5 = r8
            r6 = r10
        L_0x00e7:
            r8 = r3
            r3 = r11
            goto L_0x0138
        L_0x00ea:
            if (r4 == 0) goto L_0x00ef
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            goto L_0x00f0
        L_0x00ef:
            r4 = r5
        L_0x00f0:
            if (r6 == 0) goto L_0x00f4
            r5 = 1
            goto L_0x00f5
        L_0x00f4:
            r5 = r8
        L_0x00f5:
            if (r9 == 0) goto L_0x0116
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r6)
            java.lang.Object r6 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r6 != r8) goto L_0x0110
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r6)
        L_0x0110:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = (androidx.compose.foundation.interaction.MutableInteractionSource) r6
            goto L_0x0117
        L_0x0116:
            r6 = r10
        L_0x0117:
            r8 = r34 & 32
            if (r8 == 0) goto L_0x00e7
            androidx.compose.material.CheckboxDefaults r8 = androidx.compose.material.CheckboxDefaults.INSTANCE
            r9 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r20 = 196608(0x30000, float:2.75506E-40)
            r21 = 31
            r19 = r0
            androidx.compose.material.CheckboxColors r8 = r8.m1144colorszjMxDiM(r9, r11, r13, r15, r17, r19, r20, r21)
            r3 = r3 & r24
            r25 = r8
            r8 = r3
            r3 = r25
        L_0x0138:
            r0.endDefaults()
            androidx.compose.ui.state.ToggleableState r9 = androidx.compose.ui.state.ToggleableStateKt.ToggleableState(r26)
            r10 = 1433125990(0x556bc466, float:1.62017973E13)
            r0.startReplaceableGroup(r10)
            if (r2 == 0) goto L_0x0177
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r26)
            r11 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r11)
            boolean r11 = r0.changed((java.lang.Object) r2)
            boolean r10 = r0.changed((java.lang.Object) r10)
            r10 = r10 | r11
            java.lang.Object r11 = r0.rememberedValue()
            if (r10 != 0) goto L_0x0168
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x0170
        L_0x0168:
            androidx.compose.material.CheckboxKt$Checkbox$2$1 r11 = new androidx.compose.material.CheckboxKt$Checkbox$2$1
            r11.<init>(r2, r1)
            r0.updateRememberedValue(r11)
        L_0x0170:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r10 = r11
            goto L_0x0178
        L_0x0177:
            r10 = 0
        L_0x0178:
            r0.endReplaceableGroup()
            r11 = r8 & 896(0x380, float:1.256E-42)
            r12 = r8 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r12 = r8 & r22
            r11 = r11 | r12
            r8 = r8 & r23
            r15 = r11 | r8
            r16 = 0
            r8 = r9
            r9 = r10
            r10 = r4
            r11 = r5
            r12 = r6
            r13 = r3
            r14 = r0
            TriStateCheckbox(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r25 = r6
            r6 = r3
            r3 = r4
            r4 = r5
            r5 = r25
        L_0x019a:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x01a1
            goto L_0x01b2
        L_0x01a1:
            androidx.compose.material.CheckboxKt$Checkbox$3 r10 = new androidx.compose.material.CheckboxKt$Checkbox$3
            r0 = r10
            r1 = r26
            r2 = r27
            r7 = r33
            r8 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.updateScope(r10)
        L_0x01b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxKt.Checkbox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.CheckboxColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v25, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v38, resolved type: androidx.compose.material.CheckDrawingCache} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v45, resolved type: androidx.compose.material.CheckboxKt$CheckboxImpl$1$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v1, resolved type: androidx.compose.material.CheckboxKt$CheckboxImpl$1$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: androidx.compose.material.CheckDrawingCache} */
    /* JADX WARNING: type inference failed for: r6v16 */
    /* JADX WARNING: type inference failed for: r7v26 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x021f, code lost:
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0221;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x016b  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CheckboxImpl(boolean r34, androidx.compose.ui.state.ToggleableState r35, androidx.compose.ui.Modifier r36, androidx.compose.material.CheckboxColors r37, androidx.compose.runtime.Composer r38, int r39) {
        /*
            r1 = r34
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r39
            r0 = -2118895727(0xffffffff81b43791, float:-6.620129E-38)
            r6 = r38
            androidx.compose.runtime.Composer r0 = r6.startRestartGroup(r0)
            r6 = r5 & 14
            r15 = 2
            if (r6 != 0) goto L_0x0023
            boolean r6 = r0.changed((boolean) r1)
            if (r6 == 0) goto L_0x0020
            r6 = 4
            goto L_0x0021
        L_0x0020:
            r6 = r15
        L_0x0021:
            r6 = r6 | r5
            goto L_0x0024
        L_0x0023:
            r6 = r5
        L_0x0024:
            r7 = r5 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0034
            boolean r7 = r0.changed((java.lang.Object) r2)
            if (r7 == 0) goto L_0x0031
            r7 = 32
            goto L_0x0033
        L_0x0031:
            r7 = 16
        L_0x0033:
            r6 = r6 | r7
        L_0x0034:
            r7 = r5 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0044
            boolean r7 = r0.changed((java.lang.Object) r3)
            if (r7 == 0) goto L_0x0041
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0043
        L_0x0041:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0043:
            r6 = r6 | r7
        L_0x0044:
            r7 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0054
            boolean r7 = r0.changed((java.lang.Object) r4)
            if (r7 == 0) goto L_0x0051
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0053
        L_0x0051:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0053:
            r6 = r6 | r7
        L_0x0054:
            r13 = r6
            r6 = r13 & 5851(0x16db, float:8.199E-42)
            r7 = 1170(0x492, float:1.64E-42)
            if (r6 != r7) goto L_0x0067
            boolean r6 = r0.getSkipping()
            if (r6 != 0) goto L_0x0062
            goto L_0x0067
        L_0x0062:
            r0.skipToGroupEnd()
            goto L_0x0234
        L_0x0067:
            int r12 = r13 >> 3
            r11 = r12 & 14
            r10 = 0
            androidx.compose.animation.core.Transition r16 = androidx.compose.animation.core.TransitionKt.updateTransition(r2, (java.lang.String) r10, (androidx.compose.runtime.Composer) r0, (int) r11, (int) r15)
            androidx.compose.material.CheckboxKt$CheckboxImpl$checkDrawFraction$2 r6 = androidx.compose.material.CheckboxKt$CheckboxImpl$checkDrawFraction$2.INSTANCE
            r9 = 1399891485(0x5370a61d, float:1.03357907E12)
            r0.startReplaceableGroup(r9)
            java.lang.String r17 = "FloatAnimation"
            kotlin.jvm.internal.FloatCompanionObject r18 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r19 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r18)
            r8 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r8)
            java.lang.Object r7 = r16.getCurrentState()
            androidx.compose.ui.state.ToggleableState r7 = (androidx.compose.ui.state.ToggleableState) r7
            r8 = -1798345588(0xffffffff94cf6c8c, float:-2.0944473E-26)
            r0.startReplaceableGroup(r8)
            int[] r20 = androidx.compose.material.CheckboxKt.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r20[r7]
            r21 = 0
            r22 = 1065353216(0x3f800000, float:1.0)
            r14 = 1
            r23 = r13
            r13 = 3
            if (r7 == r14) goto L_0x00b2
            if (r7 == r15) goto L_0x00af
            if (r7 != r13) goto L_0x00a9
            goto L_0x00b2
        L_0x00a9:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00af:
            r7 = r21
            goto L_0x00b4
        L_0x00b2:
            r7 = r22
        L_0x00b4:
            r0.endReplaceableGroup()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.lang.Object r24 = r16.getTargetState()
            androidx.compose.ui.state.ToggleableState r24 = (androidx.compose.ui.state.ToggleableState) r24
            r0.startReplaceableGroup(r8)
            int r8 = r24.ordinal()
            r8 = r20[r8]
            if (r8 == r14) goto L_0x00da
            if (r8 == r15) goto L_0x00d7
            if (r8 != r13) goto L_0x00d1
            goto L_0x00da
        L_0x00d1:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00d7:
            r8 = r21
            goto L_0x00dc
        L_0x00da:
            r8 = r22
        L_0x00dc:
            r0.endReplaceableGroup()
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            androidx.compose.animation.core.Transition$Segment r9 = r16.getSegment()
            r15 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r15)
            java.lang.Object r6 = r6.invoke(r9, r0, r10)
            r9 = r6
            androidx.compose.animation.core.FiniteAnimationSpec r9 = (androidx.compose.animation.core.FiniteAnimationSpec) r9
            r25 = 0
            r6 = r16
            r10 = 1847725064(0x6e220c08, float:1.2537779E28)
            r15 = 1399891485(0x5370a61d, float:1.03357907E12)
            r14 = r10
            r10 = r19
            r19 = r11
            r11 = r17
            r26 = r12
            r12 = r0
            r17 = r23
            r13 = r25
            androidx.compose.runtime.State r32 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r6, r7, r8, r9, r10, r11, r12, r13)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2 r6 = androidx.compose.material.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2.INSTANCE
            r0.startReplaceableGroup(r15)
            java.lang.String r11 = "FloatAnimation"
            androidx.compose.animation.core.TwoWayConverter r10 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r18)
            r0.startReplaceableGroup(r14)
            java.lang.Object r7 = r16.getCurrentState()
            androidx.compose.ui.state.ToggleableState r7 = (androidx.compose.ui.state.ToggleableState) r7
            r8 = -2098942571(0xffffffff82e4ad95, float:-3.360122E-37)
            r0.startReplaceableGroup(r8)
            int r7 = r7.ordinal()
            r7 = r20[r7]
            r9 = 1
            if (r7 == r9) goto L_0x0147
            r9 = 2
            if (r7 == r9) goto L_0x0147
            r14 = 3
            if (r7 != r14) goto L_0x0141
            r7 = r22
            goto L_0x014a
        L_0x0141:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0147:
            r14 = 3
            r7 = r21
        L_0x014a:
            r0.endReplaceableGroup()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.lang.Object r9 = r16.getTargetState()
            androidx.compose.ui.state.ToggleableState r9 = (androidx.compose.ui.state.ToggleableState) r9
            r0.startReplaceableGroup(r8)
            int r8 = r9.ordinal()
            r8 = r20[r8]
            r9 = 1
            if (r8 == r9) goto L_0x0171
            r9 = 2
            if (r8 == r9) goto L_0x0171
            if (r8 != r14) goto L_0x016b
            r21 = r22
            goto L_0x0171
        L_0x016b:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0171:
            r0.endReplaceableGroup()
            java.lang.Float r8 = java.lang.Float.valueOf(r21)
            androidx.compose.animation.core.Transition$Segment r9 = r16.getSegment()
            r12 = 0
            java.lang.Integer r13 = java.lang.Integer.valueOf(r12)
            java.lang.Object r6 = r6.invoke(r9, r0, r13)
            r9 = r6
            androidx.compose.animation.core.FiniteAnimationSpec r9 = (androidx.compose.animation.core.FiniteAnimationSpec) r9
            r6 = r16
            r12 = r0
            r13 = r25
            androidx.compose.runtime.State r33 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r6, r7, r8, r9, r10, r11, r12, r13)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r6)
            java.lang.Object r6 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r6 != r7) goto L_0x01b7
            androidx.compose.material.CheckDrawingCache r6 = new androidx.compose.material.CheckDrawingCache
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 7
            r13 = 0
            r8 = r6
            r8.<init>(r9, r10, r11, r12, r13)
            r0.updateRememberedValue(r6)
        L_0x01b7:
            r0.endReplaceableGroup()
            r28 = r6
            androidx.compose.material.CheckDrawingCache r28 = (androidx.compose.material.CheckDrawingCache) r28
            int r6 = r17 >> 6
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r19 | r6
            androidx.compose.runtime.State r31 = r4.checkmarkColor(r2, r0, r6)
            r6 = r17 & 14
            r7 = r17 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            r7 = r26
            r7 = r7 & 896(0x380, float:1.256E-42)
            r6 = r6 | r7
            androidx.compose.runtime.State r29 = r4.boxColor(r1, r2, r0, r6)
            androidx.compose.runtime.State r30 = r4.borderColor(r1, r2, r0, r6)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getCenter()
            r7 = 0
            r8 = 0
            r9 = 2
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r3, r6, r8, r9, r7)
            float r7 = CheckboxSize
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m550requiredSize3ABfNKs(r6, r7)
            r7 = 6
            java.lang.Object[] r10 = new java.lang.Object[r7]
            r10[r8] = r29
            r8 = 1
            r10[r8] = r30
            r10[r9] = r31
            r10[r14] = r32
            r8 = 4
            r10[r8] = r33
            r8 = 5
            r10[r8] = r28
            r8 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r0.startReplaceableGroup(r8)
            r8 = 0
            r12 = 0
        L_0x0207:
            if (r12 >= r7) goto L_0x0213
            r9 = r10[r12]
            boolean r9 = r0.changed((java.lang.Object) r9)
            r8 = r8 | r9
            int r12 = r12 + 1
            goto L_0x0207
        L_0x0213:
            java.lang.Object r7 = r0.rememberedValue()
            if (r8 != 0) goto L_0x0221
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r7 != r8) goto L_0x022b
        L_0x0221:
            androidx.compose.material.CheckboxKt$CheckboxImpl$1$1 r7 = new androidx.compose.material.CheckboxKt$CheckboxImpl$1$1
            r27 = r7
            r27.<init>(r28, r29, r30, r31, r32, r33)
            r0.updateRememberedValue(r7)
        L_0x022b:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r8 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r6, r7, r0, r8)
        L_0x0234:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x023b
            goto L_0x024e
        L_0x023b:
            androidx.compose.material.CheckboxKt$CheckboxImpl$2 r7 = new androidx.compose.material.CheckboxKt$CheckboxImpl$2
            r0 = r7
            r1 = r34
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r39
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x024e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxKt.CheckboxImpl(boolean, androidx.compose.ui.state.ToggleableState, androidx.compose.ui.Modifier, androidx.compose.material.CheckboxColors, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-10  reason: not valid java name */
    public static final long m1145CheckboxImpl$lambda10(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-4  reason: not valid java name */
    public static final float m1146CheckboxImpl$lambda4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-6  reason: not valid java name */
    public static final float m1147CheckboxImpl$lambda6(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-8  reason: not valid java name */
    public static final long m1148CheckboxImpl$lambda8(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-9  reason: not valid java name */
    public static final long m1149CheckboxImpl$lambda9(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0181  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TriStateCheckbox(@org.jetbrains.annotations.NotNull androidx.compose.ui.state.ToggleableState r25, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r26, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r27, boolean r28, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r29, @org.jetbrains.annotations.Nullable androidx.compose.material.CheckboxColors r30, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r7 = r25
            r8 = r26
            r9 = r32
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 2031255194(0x79127e9a, float:4.7540195E34)
            r1 = r31
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            r0 = r33 & 1
            if (r0 == 0) goto L_0x001b
            r0 = r9 | 6
            goto L_0x002b
        L_0x001b:
            r0 = r9 & 14
            if (r0 != 0) goto L_0x002a
            boolean r0 = r6.changed((java.lang.Object) r7)
            if (r0 == 0) goto L_0x0027
            r0 = 4
            goto L_0x0028
        L_0x0027:
            r0 = 2
        L_0x0028:
            r0 = r0 | r9
            goto L_0x002b
        L_0x002a:
            r0 = r9
        L_0x002b:
            r1 = r33 & 2
            if (r1 == 0) goto L_0x0032
            r0 = r0 | 48
            goto L_0x0042
        L_0x0032:
            r1 = r9 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0042
            boolean r1 = r6.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x003f
            r1 = 32
            goto L_0x0041
        L_0x003f:
            r1 = 16
        L_0x0041:
            r0 = r0 | r1
        L_0x0042:
            r1 = r33 & 4
            if (r1 == 0) goto L_0x0049
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x005c
        L_0x0049:
            r2 = r9 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x005c
            r2 = r27
            boolean r3 = r6.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0058
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r3 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r0 = r0 | r3
            goto L_0x005e
        L_0x005c:
            r2 = r27
        L_0x005e:
            r3 = r33 & 8
            if (r3 == 0) goto L_0x0065
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0078
        L_0x0065:
            r4 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0078
            r4 = r28
            boolean r5 = r6.changed((boolean) r4)
            if (r5 == 0) goto L_0x0074
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0076
        L_0x0074:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0076:
            r0 = r0 | r5
            goto L_0x007a
        L_0x0078:
            r4 = r28
        L_0x007a:
            r5 = r33 & 16
            if (r5 == 0) goto L_0x0081
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0096
        L_0x0081:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r9
            if (r10 != 0) goto L_0x0096
            r10 = r29
            boolean r11 = r6.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0092
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r0 = r0 | r11
            goto L_0x0098
        L_0x0096:
            r10 = r29
        L_0x0098:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r9
            if (r11 != 0) goto L_0x00b2
            r11 = r33 & 32
            if (r11 != 0) goto L_0x00ac
            r11 = r30
            boolean r12 = r6.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x00ae
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ac:
            r11 = r30
        L_0x00ae:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r0 = r0 | r12
            goto L_0x00b4
        L_0x00b2:
            r11 = r30
        L_0x00b4:
            r12 = 374491(0x5b6db, float:5.24774E-40)
            r12 = r12 & r0
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r13) goto L_0x00cd
            boolean r12 = r6.getSkipping()
            if (r12 != 0) goto L_0x00c4
            goto L_0x00cd
        L_0x00c4:
            r6.skipToGroupEnd()
            r3 = r2
            r5 = r10
            r10 = r6
            r6 = r11
            goto L_0x01be
        L_0x00cd:
            r6.startDefaults()
            r12 = r9 & 1
            r24 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r12 == 0) goto L_0x00f1
            boolean r12 = r6.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00de
            goto L_0x00f1
        L_0x00de:
            r6.skipToGroupEnd()
            r1 = r33 & 32
            if (r1 == 0) goto L_0x00e7
            r0 = r0 & r24
        L_0x00e7:
            r20 = r0
            r5 = r2
            r17 = r4
            r18 = r10
        L_0x00ee:
            r19 = r11
            goto L_0x014c
        L_0x00f1:
            if (r1 == 0) goto L_0x00f6
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x00f7
        L_0x00f6:
            r1 = r2
        L_0x00f7:
            if (r3 == 0) goto L_0x00fb
            r2 = 1
            goto L_0x00fc
        L_0x00fb:
            r2 = r4
        L_0x00fc:
            if (r5 == 0) goto L_0x011d
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r3)
            java.lang.Object r3 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0117
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r6.updateRememberedValue(r3)
        L_0x0117:
            r6.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            goto L_0x011e
        L_0x011d:
            r3 = r10
        L_0x011e:
            r4 = r33 & 32
            if (r4 == 0) goto L_0x0144
            androidx.compose.material.CheckboxDefaults r10 = androidx.compose.material.CheckboxDefaults.INSTANCE
            r11 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r22 = 196608(0x30000, float:2.75506E-40)
            r23 = 31
            r21 = r6
            androidx.compose.material.CheckboxColors r4 = r10.m1144colorszjMxDiM(r11, r13, r15, r17, r19, r21, r22, r23)
            r0 = r0 & r24
            r20 = r0
            r5 = r1
            r17 = r2
            r18 = r3
            r19 = r4
            goto L_0x014c
        L_0x0144:
            r20 = r0
            r5 = r1
            r17 = r2
            r18 = r3
            goto L_0x00ee
        L_0x014c:
            r6.endDefaults()
            r0 = -1517549514(0xffffffffa58c0836, float:-2.4291693E-16)
            r6.startReplaceableGroup(r0)
            if (r8 == 0) goto L_0x0181
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r1 = r1.m4912getCheckboxo7Vup1c()
            r10 = 0
            float r11 = CheckboxRippleRadius
            r12 = 0
            r15 = 54
            r16 = 4
            r14 = r6
            androidx.compose.foundation.Indication r3 = androidx.compose.material.ripple.RippleKt.m1485rememberRipple9IZ8Weo(r10, r11, r12, r14, r15, r16)
            androidx.compose.ui.semantics.Role r10 = androidx.compose.ui.semantics.Role.m4904boximpl(r1)
            r1 = r25
            r2 = r18
            r4 = r17
            r11 = r5
            r5 = r10
            r10 = r6
            r6 = r26
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m790triStateToggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0185
        L_0x0181:
            r11 = r5
            r10 = r6
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
        L_0x0185:
            r10.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            if (r8 == 0) goto L_0x0190
            androidx.compose.ui.Modifier r1 = androidx.compose.material.TouchTargetKt.minimumTouchTargetSize(r1)
        L_0x0190:
            androidx.compose.ui.Modifier r1 = r11.then(r1)
            androidx.compose.ui.Modifier r0 = r1.then(r0)
            float r1 = CheckboxDefaultPadding
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m486padding3ABfNKs(r0, r1)
            int r0 = r20 >> 9
            r0 = r0 & 14
            int r1 = r20 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r20 >> 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r5 = r0 | r1
            r0 = r17
            r1 = r25
            r3 = r19
            r4 = r10
            CheckboxImpl(r0, r1, r2, r3, r4, r5)
            r3 = r11
            r4 = r17
            r5 = r18
            r6 = r19
        L_0x01be:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x01c5
            goto L_0x01d6
        L_0x01c5:
            androidx.compose.material.CheckboxKt$TriStateCheckbox$2 r11 = new androidx.compose.material.CheckboxKt$TriStateCheckbox$2
            r0 = r11
            r1 = r25
            r2 = r26
            r7 = r32
            r8 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.updateScope(r11)
        L_0x01d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxKt.TriStateCheckbox(androidx.compose.ui.state.ToggleableState, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.CheckboxColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawBox-1wkBAMs  reason: not valid java name */
    public static final void m1157drawBox1wkBAMs(DrawScope drawScope, long j11, long j12, float f11, float f12) {
        float f13 = f11;
        float f14 = f12;
        float f15 = f14 / 2.0f;
        Stroke stroke = new Stroke(f12, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null);
        float r12 = Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc());
        if (Color.m2920equalsimpl0(j11, j12)) {
            b.M(drawScope, j11, 0, SizeKt.Size(r12, r12), CornerRadiusKt.CornerRadius$default(f13, 0.0f, 2, (Object) null), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 226, (Object) null);
            return;
        }
        float f16 = r12 - (((float) 2) * f14);
        b.M(drawScope, j11, OffsetKt.Offset(f14, f14), SizeKt.Size(f16, f16), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f13 - f14), 0.0f, 2, (Object) null), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
        float f17 = r12 - f14;
        b.M(drawScope, j12, OffsetKt.Offset(f15, f15), SizeKt.Size(f17, f17), CornerRadiusKt.CornerRadius$default(f13 - f15, 0.0f, 2, (Object) null), stroke, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCheck-3IgeMak  reason: not valid java name */
    public static final void m1158drawCheck3IgeMak(DrawScope drawScope, long j11, float f11, float f12, float f13, CheckDrawingCache checkDrawingCache) {
        float f14 = f12;
        Stroke stroke = new Stroke(f13, 0.0f, StrokeCap.Companion.m3255getSquareKaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
        float r12 = Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc());
        float lerp = MathHelpersKt.lerp(0.4f, 0.5f, f12);
        float lerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f12);
        float lerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f12);
        float lerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f12);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * r12, lerp3 * r12);
        checkDrawingCache.getCheckPath().lineTo(lerp * r12, lerp2 * r12);
        checkDrawingCache.getCheckPath().lineTo(0.8f * r12, r12 * lerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f11, checkDrawingCache.getPathToDraw(), true);
        b.G(drawScope, checkDrawingCache.getPathToDraw(), j11, 0.0f, stroke, (ColorFilter) null, 0, 52, (Object) null);
    }
}
