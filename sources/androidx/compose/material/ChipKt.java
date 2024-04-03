package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0001\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010 \u001aÄ\u0001\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020#2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010&\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingIconEndSpacing", "LeadingIconStartSpacing", "SelectedIconContainerSize", "SelectedOverlayOpacity", "", "SurfaceOverlayOpacity", "TrailingIconSpacing", "Chip", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "border", "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ChipKt {
    /* access modifiers changed from: private */
    public static final float HorizontalPadding = Dp.m5478constructorimpl((float) 12);
    /* access modifiers changed from: private */
    public static final float LeadingIconEndSpacing;
    /* access modifiers changed from: private */
    public static final float LeadingIconStartSpacing = Dp.m5478constructorimpl((float) 4);
    /* access modifiers changed from: private */
    public static final float SelectedIconContainerSize = Dp.m5478constructorimpl((float) 24);
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    /* access modifiers changed from: private */
    public static final float TrailingIconSpacing;

    static {
        float f11 = (float) 8;
        LeadingIconEndSpacing = Dp.m5478constructorimpl(f11);
        TrailingIconSpacing = Dp.m5478constructorimpl(f11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0107  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Chip(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r33, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r34, boolean r35, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r36, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r37, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r38, @org.jetbrains.annotations.Nullable androidx.compose.material.ChipColors r39, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r15 = r33
            r14 = r41
            r13 = r43
            r12 = r44
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -368396408(0xffffffffea0ab788, float:-4.1924616E25)
            r1 = r42
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0022
            r0 = r13 | 6
            goto L_0x0032
        L_0x0022:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0031
            boolean r0 = r11.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = 2
        L_0x002f:
            r0 = r0 | r13
            goto L_0x0032
        L_0x0031:
            r0 = r13
        L_0x0032:
            r1 = r12 & 2
            if (r1 == 0) goto L_0x0039
            r0 = r0 | 48
            goto L_0x004c
        L_0x0039:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004c
            r2 = r34
            boolean r3 = r11.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0048
            r3 = 32
            goto L_0x004a
        L_0x0048:
            r3 = 16
        L_0x004a:
            r0 = r0 | r3
            goto L_0x004e
        L_0x004c:
            r2 = r34
        L_0x004e:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x0055
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0068
            r4 = r35
            boolean r5 = r11.changed((boolean) r4)
            if (r5 == 0) goto L_0x0064
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r5
            goto L_0x006a
        L_0x0068:
            r4 = r35
        L_0x006a:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0071
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0084
            r6 = r36
            boolean r7 = r11.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0080
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r0 = r0 | r7
            goto L_0x0086
        L_0x0084:
            r6 = r36
        L_0x0086:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r13
            if (r7 != 0) goto L_0x00a1
            r7 = r12 & 16
            if (r7 != 0) goto L_0x009b
            r7 = r37
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x009d
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009b:
            r7 = r37
        L_0x009d:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r8
            goto L_0x00a3
        L_0x00a1:
            r7 = r37
        L_0x00a3:
            r8 = r12 & 32
            if (r8 == 0) goto L_0x00ab
            r9 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r9
            goto L_0x00bf
        L_0x00ab:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00bf
            r9 = r38
            boolean r10 = r11.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00bb
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00bb:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r0 = r0 | r10
            goto L_0x00c1
        L_0x00bf:
            r9 = r38
        L_0x00c1:
            r10 = 3670016(0x380000, float:5.142788E-39)
            r16 = r13 & r10
            if (r16 != 0) goto L_0x00db
            r16 = r12 & 64
            r10 = r39
            if (r16 != 0) goto L_0x00d6
            boolean r16 = r11.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00d6
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d8
        L_0x00d6:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d8:
            r0 = r0 | r16
            goto L_0x00dd
        L_0x00db:
            r10 = r39
        L_0x00dd:
            r2 = r12 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00e8
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r16
            r4 = r40
            goto L_0x00fd
        L_0x00e8:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r13 & r16
            r4 = r40
            if (r16 != 0) goto L_0x00fd
            boolean r16 = r11.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x00f9
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fb
        L_0x00f9:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fb:
            r0 = r0 | r16
        L_0x00fd:
            r4 = r12 & 256(0x100, float:3.59E-43)
            r32 = 234881024(0xe000000, float:1.5777218E-30)
            if (r4 == 0) goto L_0x0107
            r4 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0105:
            r0 = r0 | r4
            goto L_0x0117
        L_0x0107:
            r4 = r13 & r32
            if (r4 != 0) goto L_0x0117
            boolean r4 = r11.changed((java.lang.Object) r14)
            if (r4 == 0) goto L_0x0114
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0105
        L_0x0114:
            r4 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0105
        L_0x0117:
            r4 = 191739611(0xb6db6db, float:4.5782105E-32)
            r4 = r4 & r0
            r6 = 38347922(0x2492492, float:1.4777643E-37)
            if (r4 != r6) goto L_0x0139
            boolean r4 = r11.getSkipping()
            if (r4 != 0) goto L_0x0127
            goto L_0x0139
        L_0x0127:
            r11.skipToGroupEnd()
            r2 = r34
            r3 = r35
            r4 = r36
            r8 = r40
            r5 = r7
            r6 = r9
            r7 = r10
            r26 = r11
            goto L_0x028f
        L_0x0139:
            r11.startDefaults()
            r4 = r13 & 1
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r6 = 1
            if (r4 == 0) goto L_0x016b
            boolean r4 = r11.getDefaultsInvalid()
            if (r4 == 0) goto L_0x014b
            goto L_0x016b
        L_0x014b:
            r11.skipToGroupEnd()
            r1 = r12 & 16
            if (r1 == 0) goto L_0x0154
            r0 = r0 & r16
        L_0x0154:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x015c
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r1
        L_0x015c:
            r16 = r34
            r17 = r36
            r20 = r40
            r18 = r7
            r19 = r9
            r9 = r10
            r10 = r35
            goto L_0x01f6
        L_0x016b:
            if (r1 == 0) goto L_0x0170
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0172
        L_0x0170:
            r1 = r34
        L_0x0172:
            if (r3 == 0) goto L_0x0176
            r3 = r6
            goto L_0x0178
        L_0x0176:
            r3 = r35
        L_0x0178:
            if (r5 == 0) goto L_0x0199
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r4)
            java.lang.Object r4 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x0193
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r4)
        L_0x0193:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            goto L_0x019b
        L_0x0199:
            r4 = r36
        L_0x019b:
            r5 = r12 & 16
            if (r5 == 0) goto L_0x01b7
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            r7 = 6
            androidx.compose.material.Shapes r5 = r5.getShapes(r11, r7)
            androidx.compose.foundation.shape.CornerBasedShape r5 = r5.getSmall()
            r7 = 50
            androidx.compose.foundation.shape.CornerSize r7 = androidx.compose.foundation.shape.CornerSizeKt.CornerSize((int) r7)
            androidx.compose.foundation.shape.CornerBasedShape r5 = r5.copy(r7)
            r0 = r0 & r16
            goto L_0x01b8
        L_0x01b7:
            r5 = r7
        L_0x01b8:
            r7 = 0
            if (r8 == 0) goto L_0x01bc
            r9 = r7
        L_0x01bc:
            r8 = r12 & 64
            if (r8 == 0) goto L_0x01dd
            androidx.compose.material.ChipDefaults r16 = androidx.compose.material.ChipDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r30 = 1572864(0x180000, float:2.204052E-39)
            r31 = 63
            r29 = r11
            androidx.compose.material.ChipColors r8 = r16.m1159chipColors5tl4gsc(r17, r19, r21, r23, r25, r27, r29, r30, r31)
            r10 = -3670017(0xffffffffffc7ffff, float:NaN)
            r0 = r0 & r10
            goto L_0x01de
        L_0x01dd:
            r8 = r10
        L_0x01de:
            if (r2 == 0) goto L_0x01ea
            r16 = r1
            r10 = r3
            r17 = r4
            r18 = r5
            r20 = r7
            goto L_0x01f3
        L_0x01ea:
            r20 = r40
            r16 = r1
            r10 = r3
            r17 = r4
            r18 = r5
        L_0x01f3:
            r19 = r9
            r9 = r8
        L_0x01f6:
            r11.endDefaults()
            int r1 = r0 >> 6
            r1 = r1 & 14
            int r2 = r0 >> 15
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            androidx.compose.runtime.State r2 = r9.contentColor(r10, r11, r1)
            androidx.compose.runtime.State r1 = r9.backgroundColor(r10, r11, r1)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r4 = r1.m2929unboximpl()
            long r21 = m1167Chip$lambda1(r2)
            r23 = 1065353216(0x3f800000, float:1.0)
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 14
            r28 = 0
            long r7 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r21, r23, r24, r25, r26, r27, r28)
            r21 = 0
            androidx.compose.material.ChipKt$Chip$2 r1 = new androidx.compose.material.ChipKt$Chip$2
            r34 = r1
            r35 = r2
            r36 = r20
            r37 = r9
            r38 = r10
            r39 = r0
            r40 = r41
            r34.<init>(r35, r36, r37, r38, r39, r40)
            r2 = 139076687(0x84a244f, float:6.0829844E-34)
            androidx.compose.runtime.internal.ComposableLambda r22 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r2, r6, r1)
            r1 = r0 & 14
            r2 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r2
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r0 >> 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            int r2 = r0 << 3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r3
            r1 = r1 | r2
            int r0 = r0 << 15
            r0 = r0 & r32
            r23 = r1 | r0
            r24 = 128(0x80, float:1.794E-43)
            r0 = r33
            r1 = r16
            r2 = r10
            r3 = r18
            r6 = r7
            r8 = r19
            r25 = r9
            r9 = r21
            r21 = r10
            r10 = r17
            r26 = r11
            r11 = r22
            r12 = r26
            r13 = r23
            r14 = r24
            androidx.compose.material.SurfaceKt.m1385SurfaceLPr_se0(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14)
            r2 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r8 = r20
            r3 = r21
            r7 = r25
        L_0x028f:
            androidx.compose.runtime.ScopeUpdateScope r12 = r26.endRestartGroup()
            if (r12 != 0) goto L_0x0296
            goto L_0x02a7
        L_0x0296:
            androidx.compose.material.ChipKt$Chip$3 r13 = new androidx.compose.material.ChipKt$Chip$3
            r0 = r13
            r1 = r33
            r9 = r41
            r10 = r43
            r11 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.updateScope(r13)
        L_0x02a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt.Chip(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.ChipColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Chip$lambda-1  reason: not valid java name */
    public static final long m1167Chip$lambda1(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0129  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void FilterChip(boolean r44, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r45, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r46, boolean r47, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r48, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r49, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r50, @org.jetbrains.annotations.Nullable androidx.compose.material.SelectableChipColors r51, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r56, int r57, int r58, int r59) {
        /*
            r15 = r44
            r12 = r45
            r11 = r55
            r10 = r57
            r9 = r59
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -1259208246(0xffffffffb4f201ca, float:-4.5077314E-7)
            r1 = r56
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            r0 = r9 & 1
            if (r0 == 0) goto L_0x0024
            r0 = r10 | 6
            goto L_0x0034
        L_0x0024:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x0033
            boolean r0 = r8.changed((boolean) r15)
            if (r0 == 0) goto L_0x0030
            r0 = 4
            goto L_0x0031
        L_0x0030:
            r0 = 2
        L_0x0031:
            r0 = r0 | r10
            goto L_0x0034
        L_0x0033:
            r0 = r10
        L_0x0034:
            r3 = r9 & 2
            if (r3 == 0) goto L_0x003b
            r0 = r0 | 48
            goto L_0x004b
        L_0x003b:
            r3 = r10 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004b
            boolean r3 = r8.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x0048
            r3 = 32
            goto L_0x004a
        L_0x0048:
            r3 = 16
        L_0x004a:
            r0 = r0 | r3
        L_0x004b:
            r3 = r9 & 4
            if (r3 == 0) goto L_0x0052
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0065
            r6 = r46
            boolean r7 = r8.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0061
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r0 = r0 | r7
            goto L_0x0067
        L_0x0065:
            r6 = r46
        L_0x0067:
            r7 = r9 & 8
            if (r7 == 0) goto L_0x006e
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r13 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x0081
            r13 = r47
            boolean r14 = r8.changed((boolean) r13)
            if (r14 == 0) goto L_0x007d
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r0 = r0 | r14
            goto L_0x0083
        L_0x0081:
            r13 = r47
        L_0x0083:
            r14 = r9 & 16
            r38 = 57344(0xe000, float:8.0356E-41)
            if (r14 == 0) goto L_0x008f
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r1 = r48
            goto L_0x00a2
        L_0x008f:
            r16 = r10 & r38
            r1 = r48
            if (r16 != 0) goto L_0x00a2
            boolean r16 = r8.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x009e
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009e:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r0 = r0 | r16
        L_0x00a2:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00bc
            r16 = r9 & 32
            r2 = r49
            if (r16 != 0) goto L_0x00b7
            boolean r17 = r8.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x00b7
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r0 = r0 | r17
            goto L_0x00be
        L_0x00bc:
            r2 = r49
        L_0x00be:
            r17 = r9 & 64
            if (r17 == 0) goto L_0x00c9
            r18 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r18
            r4 = r50
            goto L_0x00de
        L_0x00c9:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r10 & r18
            r4 = r50
            if (r18 != 0) goto L_0x00de
            boolean r19 = r8.changed((java.lang.Object) r4)
            if (r19 == 0) goto L_0x00da
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dc
        L_0x00da:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00dc:
            r0 = r0 | r19
        L_0x00de:
            r39 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r10 & r39
            if (r19 != 0) goto L_0x00fa
            r5 = r9 & 128(0x80, float:1.794E-43)
            if (r5 != 0) goto L_0x00f3
            r5 = r51
            boolean r20 = r8.changed((java.lang.Object) r5)
            if (r20 == 0) goto L_0x00f5
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f7
        L_0x00f3:
            r5 = r51
        L_0x00f5:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f7:
            r0 = r0 | r20
            goto L_0x00fc
        L_0x00fa:
            r5 = r51
        L_0x00fc:
            r1 = r9 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0107
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r20
            r2 = r52
            goto L_0x011c
        L_0x0107:
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            r20 = r10 & r20
            r2 = r52
            if (r20 != 0) goto L_0x011c
            boolean r20 = r8.changed((java.lang.Object) r2)
            if (r20 == 0) goto L_0x0118
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011a
        L_0x0118:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011a:
            r0 = r0 | r20
        L_0x011c:
            r2 = r9 & 512(0x200, float:7.175E-43)
            r40 = 1879048192(0x70000000, float:1.58456325E29)
            if (r2 == 0) goto L_0x0129
            r20 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r20
            r4 = r53
            goto L_0x013c
        L_0x0129:
            r20 = r10 & r40
            r4 = r53
            if (r20 != 0) goto L_0x013c
            boolean r20 = r8.changed((java.lang.Object) r4)
            if (r20 == 0) goto L_0x0138
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013a
        L_0x0138:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013a:
            r0 = r0 | r20
        L_0x013c:
            r4 = r9 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0145
            r16 = r58 | 6
            r5 = r54
            goto L_0x015b
        L_0x0145:
            r20 = r58 & 14
            r5 = r54
            if (r20 != 0) goto L_0x0159
            boolean r20 = r8.changed((java.lang.Object) r5)
            if (r20 == 0) goto L_0x0154
            r16 = 4
            goto L_0x0156
        L_0x0154:
            r16 = 2
        L_0x0156:
            r16 = r58 | r16
            goto L_0x015b
        L_0x0159:
            r16 = r58
        L_0x015b:
            r5 = r9 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0164
            r5 = r16 | 48
        L_0x0161:
            r41 = r5
            goto L_0x0178
        L_0x0164:
            r5 = r58 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0176
            boolean r5 = r8.changed((java.lang.Object) r11)
            if (r5 == 0) goto L_0x0171
            r18 = 32
            goto L_0x0173
        L_0x0171:
            r18 = 16
        L_0x0173:
            r5 = r16 | r18
            goto L_0x0161
        L_0x0176:
            r41 = r16
        L_0x0178:
            r5 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r5 = r5 & r0
            r6 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r6) goto L_0x01a5
            r5 = r41 & 91
            r6 = 18
            if (r5 != r6) goto L_0x01a5
            boolean r5 = r8.getSkipping()
            if (r5 != 0) goto L_0x018e
            goto L_0x01a5
        L_0x018e:
            r8.skipToGroupEnd()
            r3 = r46
            r5 = r48
            r6 = r49
            r7 = r50
            r9 = r52
            r10 = r53
            r11 = r54
            r0 = r8
            r4 = r13
            r8 = r51
            goto L_0x0345
        L_0x01a5:
            r8.startDefaults()
            r5 = r10 & 1
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r5 == 0) goto L_0x01dc
            boolean r5 = r8.getDefaultsInvalid()
            if (r5 == 0) goto L_0x01b6
            goto L_0x01dc
        L_0x01b6:
            r8.skipToGroupEnd()
            r1 = r9 & 32
            if (r1 == 0) goto L_0x01bf
            r0 = r0 & r16
        L_0x01bf:
            r1 = r9 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01c7
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r0 & r1
        L_0x01c7:
            r7 = r46
            r28 = r48
            r29 = r49
            r30 = r50
            r5 = r51
            r31 = r52
            r32 = r53
            r33 = r54
            r20 = r0
            r6 = r13
            goto L_0x0287
        L_0x01dc:
            if (r3 == 0) goto L_0x01e1
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x01e3
        L_0x01e1:
            r3 = r46
        L_0x01e3:
            if (r7 == 0) goto L_0x01e6
            r13 = 1
        L_0x01e6:
            if (r14 == 0) goto L_0x0207
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r5)
            java.lang.Object r5 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r5 != r7) goto L_0x0201
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r8.updateRememberedValue(r5)
        L_0x0201:
            r8.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            goto L_0x0209
        L_0x0207:
            r5 = r48
        L_0x0209:
            r7 = r9 & 32
            if (r7 == 0) goto L_0x0225
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            r14 = 6
            androidx.compose.material.Shapes r7 = r7.getShapes(r8, r14)
            androidx.compose.foundation.shape.CornerBasedShape r7 = r7.getSmall()
            r14 = 50
            androidx.compose.foundation.shape.CornerSize r14 = androidx.compose.foundation.shape.CornerSizeKt.CornerSize((int) r14)
            androidx.compose.foundation.shape.CornerBasedShape r7 = r7.copy(r14)
            r0 = r0 & r16
            goto L_0x0227
        L_0x0225:
            r7 = r49
        L_0x0227:
            if (r17 == 0) goto L_0x022b
            r14 = 0
            goto L_0x022d
        L_0x022b:
            r14 = r50
        L_0x022d:
            r6 = r9 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x0255
            androidx.compose.material.ChipDefaults r16 = androidx.compose.material.ChipDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r36 = 805306368(0x30000000, float:4.656613E-10)
            r37 = 511(0x1ff, float:7.16E-43)
            r35 = r8
            androidx.compose.material.SelectableChipColors r6 = r16.m1160filterChipColorsJ08w3E(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r36, r37)
            r16 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r0 & r16
            goto L_0x0257
        L_0x0255:
            r6 = r51
        L_0x0257:
            if (r1 == 0) goto L_0x025b
            r1 = 0
            goto L_0x025d
        L_0x025b:
            r1 = r52
        L_0x025d:
            if (r2 == 0) goto L_0x0261
            r2 = 0
            goto L_0x0263
        L_0x0261:
            r2 = r53
        L_0x0263:
            if (r4 == 0) goto L_0x0276
            r20 = r0
            r31 = r1
            r32 = r2
            r28 = r5
            r5 = r6
            r29 = r7
            r6 = r13
            r30 = r14
            r33 = 0
            goto L_0x0286
        L_0x0276:
            r33 = r54
            r20 = r0
            r31 = r1
            r32 = r2
            r28 = r5
            r5 = r6
            r29 = r7
            r6 = r13
            r30 = r14
        L_0x0286:
            r7 = r3
        L_0x0287:
            r8.endDefaults()
            int r0 = r20 >> 9
            r0 = r0 & 14
            int r22 = r20 << 3
            r1 = r22 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r20 >> 15
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            androidx.compose.runtime.State r1 = r5.contentColor(r6, r15, r8, r0)
            r2 = 0
            androidx.compose.material.ChipKt$FilterChip$2 r3 = androidx.compose.material.ChipKt$FilterChip$2.INSTANCE
            r4 = 0
            r14 = 1
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r7, r2, r3, r14, r4)
            androidx.compose.runtime.State r0 = r5.backgroundColor(r6, r15, r8, r0)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r16 = r0.m2929unboximpl()
            java.lang.Object r0 = r1.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r2 = r0.m2929unboximpl()
            r0 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r18 = 0
            r19 = 0
            r21 = 14
            r23 = 0
            r46 = r2
            r48 = r0
            r49 = r4
            r50 = r18
            r51 = r19
            r52 = r21
            r53 = r23
            long r18 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r46, r48, r49, r50, r51, r52, r53)
            r0 = 0
            r23 = r14
            r14 = r0
            r21 = 0
            androidx.compose.material.ChipKt$FilterChip$3 r4 = new androidx.compose.material.ChipKt$FilterChip$3
            r0 = r4
            r2 = r31
            r3 = r44
            r14 = r4
            r4 = r32
            r34 = r5
            r5 = r33
            r35 = r6
            r11 = r23
            r6 = r55
            r36 = r7
            r7 = r41
            r47 = r13
            r13 = r8
            r8 = r34
            r9 = r35
            r10 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = 722126431(0x2b0ac65f, float:4.9302744E-13)
            androidx.compose.runtime.internal.ComposableLambda r23 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r11, r14)
            r0 = r20 & 14
            r1 = r20 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r20 >> 3
            r1 = r1 & r38
            r0 = r0 | r1
            r1 = r22 & r39
            r0 = r0 | r1
            int r1 = r20 << 15
            r1 = r1 & r40
            r25 = r0 | r1
            r26 = 6
            r27 = 264(0x108, float:3.7E-43)
            r11 = r44
            r12 = r45
            r15 = r29
            r20 = r30
            r22 = r28
            r24 = r13
            r0 = r13
            r14 = 0
            r13 = r47
            androidx.compose.material.SurfaceKt.m1386SurfaceNy5ogXk((boolean) r11, (kotlin.jvm.functions.Function0<kotlin.Unit>) r12, (androidx.compose.ui.Modifier) r13, (boolean) r14, (androidx.compose.ui.graphics.Shape) r15, (long) r16, (long) r18, (androidx.compose.foundation.BorderStroke) r20, (float) r21, (androidx.compose.foundation.interaction.MutableInteractionSource) r22, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r23, (androidx.compose.runtime.Composer) r24, (int) r25, (int) r26, (int) r27)
            r5 = r28
            r6 = r29
            r7 = r30
            r9 = r31
            r10 = r32
            r11 = r33
            r4 = r35
            r3 = r36
        L_0x0345:
            androidx.compose.runtime.ScopeUpdateScope r15 = r0.endRestartGroup()
            if (r15 != 0) goto L_0x034c
            goto L_0x0369
        L_0x034c:
            androidx.compose.material.ChipKt$FilterChip$4 r14 = new androidx.compose.material.ChipKt$FilterChip$4
            r0 = r14
            r1 = r44
            r2 = r45
            r12 = r55
            r13 = r57
            r42 = r14
            r14 = r58
            r43 = r15
            r15 = r59
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1 = r42
            r0 = r43
            r0.updateScope(r1)
        L_0x0369:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt.FilterChip(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.SelectableChipColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
