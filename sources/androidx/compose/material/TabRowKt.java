package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a¬\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000123\b\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a¢\u0001\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r23\b\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TabRow", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TabRowKt {
    /* access modifiers changed from: private */
    public static final float ScrollableTabRowMinimumTabWidth = Dp.m5478constructorimpl((float) 90);
    /* access modifiers changed from: private */
    @NotNull
    public static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:124:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0113  */
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.UiComposable
    /* renamed from: ScrollableTabRow-sKfQg0A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1424ScrollableTabRowsKfQg0A(int r28, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r29, long r30, long r32, float r34, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r1 = r28
            r10 = r37
            r11 = r39
            r12 = r40
            java.lang.String r0 = "tabs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -1473476840(0xffffffffa82c8718, float:-9.577212E-15)
            r2 = r38
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x001d
            r2 = r11 | 6
            goto L_0x002d
        L_0x001d:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x002c
            boolean r2 = r0.changed((int) r1)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r11
            goto L_0x002d
        L_0x002c:
            r2 = r11
        L_0x002d:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r11 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0047
            r4 = r29
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r2 = r2 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r29
        L_0x0049:
            r5 = r11 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0062
            r5 = r12 & 4
            if (r5 != 0) goto L_0x005c
            r5 = r30
            boolean r7 = r0.changed((long) r5)
            if (r7 == 0) goto L_0x005e
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r5 = r30
        L_0x005e:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r2 = r2 | r7
            goto L_0x0064
        L_0x0062:
            r5 = r30
        L_0x0064:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x007d
            r7 = r12 & 8
            if (r7 != 0) goto L_0x0077
            r7 = r32
            boolean r9 = r0.changed((long) r7)
            if (r9 == 0) goto L_0x0079
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0077:
            r7 = r32
        L_0x0079:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r9
            goto L_0x007f
        L_0x007d:
            r7 = r32
        L_0x007f:
            r9 = r12 & 16
            if (r9 == 0) goto L_0x0086
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0086:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x009b
            r13 = r34
            boolean r14 = r0.changed((float) r13)
            if (r14 == 0) goto L_0x0097
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r2 = r2 | r14
            goto L_0x009d
        L_0x009b:
            r13 = r34
        L_0x009d:
            r14 = r12 & 32
            if (r14 == 0) goto L_0x00a5
            r15 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r15
            goto L_0x00ba
        L_0x00a5:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00ba
            r15 = r35
            boolean r16 = r0.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00b5
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r2 = r2 | r16
            goto L_0x00bc
        L_0x00ba:
            r15 = r35
        L_0x00bc:
            r16 = r12 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00c7
            r2 = r2 | r17
            r4 = r36
            goto L_0x00dc
        L_0x00c7:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r11 & r18
            r4 = r36
            if (r18 != 0) goto L_0x00dc
            boolean r18 = r0.changed((java.lang.Object) r4)
            if (r18 == 0) goto L_0x00d8
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r2 = r2 | r18
        L_0x00dc:
            r4 = r12 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x00e4
            r4 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00e2:
            r2 = r2 | r4
            goto L_0x00f5
        L_0x00e4:
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r11
            if (r4 != 0) goto L_0x00f5
            boolean r4 = r0.changed((java.lang.Object) r10)
            if (r4 == 0) goto L_0x00f2
            r4 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e2
        L_0x00f2:
            r4 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00e2
        L_0x00f5:
            r4 = 23967451(0x16db6db, float:4.3661218E-38)
            r4 = r4 & r2
            r5 = 4793490(0x492492, float:6.71711E-39)
            if (r4 != r5) goto L_0x0113
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x0105
            goto L_0x0113
        L_0x0105:
            r0.skipToGroupEnd()
            r2 = r29
            r3 = r30
            r9 = r36
            r5 = r7
            r7 = r13
            r8 = r15
            goto L_0x01d5
        L_0x0113:
            r0.startDefaults()
            r4 = r11 & 1
            if (r4 == 0) goto L_0x013a
            boolean r4 = r0.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0121
            goto L_0x013a
        L_0x0121:
            r0.skipToGroupEnd()
            r3 = r12 & 4
            if (r3 == 0) goto L_0x012a
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x012a:
            r3 = r12 & 8
            if (r3 == 0) goto L_0x0130
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0130:
            r3 = r29
            r5 = r30
            r4 = r13
            r9 = r15
        L_0x0136:
            r13 = r2
            r2 = r36
            goto L_0x018d
        L_0x013a:
            if (r3 == 0) goto L_0x013f
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x0141
        L_0x013f:
            r3 = r29
        L_0x0141:
            r4 = r12 & 4
            if (r4 == 0) goto L_0x0155
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            r6 = 6
            androidx.compose.material.Colors r4 = r4.getColors(r0, r6)
            long r18 = androidx.compose.material.ColorsKt.getPrimarySurface(r4)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r5 = r18
            goto L_0x0157
        L_0x0155:
            r5 = r30
        L_0x0157:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x0165
            int r4 = r2 >> 6
            r4 = r4 & 14
            long r7 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r5, r0, r4)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0165:
            if (r9 == 0) goto L_0x016e
            androidx.compose.material.TabRowDefaults r4 = androidx.compose.material.TabRowDefaults.INSTANCE
            float r4 = r4.m1421getScrollableTabRowPaddingD9Ej5fM()
            goto L_0x016f
        L_0x016e:
            r4 = r13
        L_0x016f:
            if (r14 == 0) goto L_0x017f
            androidx.compose.material.TabRowKt$ScrollableTabRow$1 r9 = new androidx.compose.material.TabRowKt$ScrollableTabRow$1
            r9.<init>(r1)
            r13 = -655609869(0xffffffffd8ec2ff3, float:-2.07752548E15)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r13, r14, r9)
            goto L_0x0180
        L_0x017f:
            r9 = r15
        L_0x0180:
            if (r16 == 0) goto L_0x0136
            androidx.compose.material.ComposableSingletons$TabRowKt r13 = androidx.compose.material.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r13 = r13.m1211getLambda2$material_release()
            r25 = r13
            r13 = r2
            r2 = r25
        L_0x018d:
            r0.endDefaults()
            r19 = 0
            r20 = 0
            androidx.compose.material.TabRowKt$ScrollableTabRow$2 r15 = new androidx.compose.material.TabRowKt$ScrollableTabRow$2
            r29 = r15
            r30 = r4
            r31 = r37
            r32 = r2
            r33 = r28
            r34 = r9
            r35 = r13
            r29.<init>(r30, r31, r32, r33, r34, r35)
            r14 = 1455860572(0x56c6ab5c, float:1.09219643E14)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r21 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r14, r1, r15)
            int r1 = r13 >> 3
            r1 = r1 & 14
            r1 = r1 | r17
            r14 = r13 & 896(0x380, float:1.256E-42)
            r1 = r1 | r14
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r23 = r1 | r13
            r24 = 50
            r13 = r3
            r1 = 0
            r14 = r1
            r15 = r5
            r17 = r7
            r22 = r0
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r13, r14, r15, r17, r19, r20, r21, r22, r23, r24)
            r25 = r9
            r9 = r2
            r2 = r3
            r26 = r7
            r7 = r4
            r3 = r5
            r5 = r26
            r8 = r25
        L_0x01d5:
            androidx.compose.runtime.ScopeUpdateScope r13 = r0.endRestartGroup()
            if (r13 != 0) goto L_0x01dc
            goto L_0x01ed
        L_0x01dc:
            androidx.compose.material.TabRowKt$ScrollableTabRow$3 r14 = new androidx.compose.material.TabRowKt$ScrollableTabRow$3
            r0 = r14
            r1 = r28
            r10 = r37
            r11 = r39
            r12 = r40
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
            r13.updateScope(r14)
        L_0x01ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabRowKt.m1424ScrollableTabRowsKfQg0A(int, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00ee  */
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.UiComposable
    /* renamed from: TabRow-pAZo6Ak  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1425TabRowpAZo6Ak(int r24, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r25, long r26, long r28, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r1 = r24
            r9 = r32
            r10 = r34
            java.lang.String r0 = "tabs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -249175289(0xfffffffff125e307, float:-8.214318E29)
            r2 = r33
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r35 & 1
            if (r2 == 0) goto L_0x001b
            r2 = r10 | 6
            goto L_0x002b
        L_0x001b:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x002a
            boolean r2 = r0.changed((int) r1)
            if (r2 == 0) goto L_0x0027
            r2 = 4
            goto L_0x0028
        L_0x0027:
            r2 = 2
        L_0x0028:
            r2 = r2 | r10
            goto L_0x002b
        L_0x002a:
            r2 = r10
        L_0x002b:
            r3 = r35 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0045
        L_0x0032:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0045
            r4 = r25
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r2 = r2 | r5
            goto L_0x0047
        L_0x0045:
            r4 = r25
        L_0x0047:
            r5 = r10 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0060
            r5 = r35 & 4
            if (r5 != 0) goto L_0x005a
            r5 = r26
            boolean r7 = r0.changed((long) r5)
            if (r7 == 0) goto L_0x005c
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r5 = r26
        L_0x005c:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r2 = r2 | r7
            goto L_0x0062
        L_0x0060:
            r5 = r26
        L_0x0062:
            r7 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x007b
            r7 = r35 & 8
            if (r7 != 0) goto L_0x0075
            r7 = r28
            boolean r11 = r0.changed((long) r7)
            if (r11 == 0) goto L_0x0077
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0075:
            r7 = r28
        L_0x0077:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r2 = r2 | r11
            goto L_0x007d
        L_0x007b:
            r7 = r28
        L_0x007d:
            r11 = r35 & 16
            if (r11 == 0) goto L_0x0084
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0084:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x0099
            r12 = r30
            boolean r13 = r0.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0095
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r2 = r2 | r13
            goto L_0x009b
        L_0x0099:
            r12 = r30
        L_0x009b:
            r13 = r35 & 32
            if (r13 == 0) goto L_0x00a3
            r14 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r14
            goto L_0x00b7
        L_0x00a3:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b7
            r14 = r31
            boolean r15 = r0.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b3
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r2 = r2 | r15
            goto L_0x00b9
        L_0x00b7:
            r14 = r31
        L_0x00b9:
            r15 = r35 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c2
            r2 = r2 | r16
            goto L_0x00d3
        L_0x00c2:
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00d3
            boolean r15 = r0.changed((java.lang.Object) r9)
            if (r15 == 0) goto L_0x00d0
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00d0:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r2 = r2 | r15
        L_0x00d3:
            r15 = 2995931(0x2db6db, float:4.198194E-39)
            r15 = r15 & r2
            r4 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r4) goto L_0x00ee
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x00e3
            goto L_0x00ee
        L_0x00e3:
            r0.skipToGroupEnd()
            r2 = r25
            r3 = r5
            r5 = r7
            r7 = r12
            r8 = r14
            goto L_0x0190
        L_0x00ee:
            r0.startDefaults()
            r4 = r10 & 1
            r15 = 1
            if (r4 == 0) goto L_0x0114
            boolean r4 = r0.getDefaultsInvalid()
            if (r4 == 0) goto L_0x00fd
            goto L_0x0114
        L_0x00fd:
            r0.skipToGroupEnd()
            r3 = r35 & 4
            if (r3 == 0) goto L_0x0106
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0106:
            r3 = r35 & 8
            if (r3 == 0) goto L_0x010c
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x010c:
            r3 = r25
            r11 = r2
            r4 = r5
            r6 = r7
            r8 = r12
        L_0x0112:
            r2 = r14
            goto L_0x015e
        L_0x0114:
            if (r3 == 0) goto L_0x0119
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x011b
        L_0x0119:
            r3 = r25
        L_0x011b:
            r4 = r35 & 4
            if (r4 == 0) goto L_0x012d
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            r5 = 6
            androidx.compose.material.Colors r4 = r4.getColors(r0, r5)
            long r4 = androidx.compose.material.ColorsKt.getPrimarySurface(r4)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x012e
        L_0x012d:
            r4 = r5
        L_0x012e:
            r6 = r35 & 8
            if (r6 == 0) goto L_0x013d
            int r6 = r2 >> 6
            r6 = r6 & 14
            long r6 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r4, r0, r6)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x013e
        L_0x013d:
            r6 = r7
        L_0x013e:
            if (r11 == 0) goto L_0x014d
            androidx.compose.material.TabRowKt$TabRow$1 r8 = new androidx.compose.material.TabRowKt$TabRow$1
            r8.<init>(r1)
            r11 = -553782708(0xffffffffdefdf24c, float:-9.1493859E18)
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r11, r15, r8)
            goto L_0x014e
        L_0x014d:
            r8 = r12
        L_0x014e:
            if (r13 == 0) goto L_0x015c
            androidx.compose.material.ComposableSingletons$TabRowKt r11 = androidx.compose.material.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r11 = r11.m1210getLambda1$material_release()
            r23 = r11
            r11 = r2
            r2 = r23
            goto L_0x015e
        L_0x015c:
            r11 = r2
            goto L_0x0112
        L_0x015e:
            r0.endDefaults()
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r3)
            r17 = 0
            r18 = 0
            androidx.compose.material.TabRowKt$TabRow$2 r14 = new androidx.compose.material.TabRowKt$TabRow$2
            r14.<init>(r9, r2, r8, r11)
            r13 = -1961746365(0xffffffff8b122043, float:-2.8142848E-32)
            androidx.compose.runtime.internal.ComposableLambda r19 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r13, r15, r14)
            r13 = r11 & 896(0x380, float:1.256E-42)
            r13 = r13 | r16
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r21 = r13 | r11
            r22 = 50
            r11 = r12
            r12 = 0
            r13 = r4
            r15 = r6
            r20 = r0
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r11, r12, r13, r15, r17, r18, r19, r20, r21, r22)
            r23 = r8
            r8 = r2
            r2 = r3
            r3 = r4
            r5 = r6
            r7 = r23
        L_0x0190:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x0197
            goto L_0x01a8
        L_0x0197:
            androidx.compose.material.TabRowKt$TabRow$3 r13 = new androidx.compose.material.TabRowKt$TabRow$3
            r0 = r13
            r1 = r24
            r9 = r32
            r10 = r34
            r11 = r35
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            r12.updateScope(r13)
        L_0x01a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabRowKt.m1425TabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
