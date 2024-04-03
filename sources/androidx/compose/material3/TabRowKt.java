package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012.\b\u0002\u0010\u0011\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u00182\u0013\b\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u00182\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0001\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2.\b\u0002\u0010\u0011\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u00182\u0013\b\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u00182\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowPadding", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TabRow", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TabRowKt {
    /* access modifiers changed from: private */
    public static final float ScrollableTabRowMinimumTabWidth = Dp.m5478constructorimpl((float) 90);
    private static final float ScrollableTabRowPadding = Dp.m5478constructorimpl((float) 52);
    /* access modifiers changed from: private */
    @NotNull
    public static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:123:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0112  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    @androidx.compose.runtime.Composable
    /* renamed from: ScrollableTabRow-sKfQg0A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1894ScrollableTabRowsKfQg0A(int r28, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r29, long r30, long r32, float r34, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r1 = r28
            r10 = r37
            r11 = r39
            r12 = r40
            java.lang.String r0 = "tabs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -497821003(0xffffffffe253dab5, float:-9.770056E20)
            r2 = r38
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            r3 = r12 & 1
            if (r3 == 0) goto L_0x001d
            r3 = r11 | 6
            goto L_0x002d
        L_0x001d:
            r3 = r11 & 14
            if (r3 != 0) goto L_0x002c
            boolean r3 = r2.changed((int) r1)
            if (r3 == 0) goto L_0x0029
            r3 = 4
            goto L_0x002a
        L_0x0029:
            r3 = 2
        L_0x002a:
            r3 = r3 | r11
            goto L_0x002d
        L_0x002c:
            r3 = r11
        L_0x002d:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0034
            r3 = r3 | 48
            goto L_0x0047
        L_0x0034:
            r5 = r11 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0047
            r5 = r29
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0043
            r6 = 32
            goto L_0x0045
        L_0x0043:
            r6 = 16
        L_0x0045:
            r3 = r3 | r6
            goto L_0x0049
        L_0x0047:
            r5 = r29
        L_0x0049:
            r6 = r11 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0062
            r6 = r12 & 4
            if (r6 != 0) goto L_0x005c
            r6 = r30
            boolean r8 = r2.changed((long) r6)
            if (r8 == 0) goto L_0x005e
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r6 = r30
        L_0x005e:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r3 = r3 | r8
            goto L_0x0064
        L_0x0062:
            r6 = r30
        L_0x0064:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007d
            r8 = r12 & 8
            if (r8 != 0) goto L_0x0077
            r8 = r32
            boolean r13 = r2.changed((long) r8)
            if (r13 == 0) goto L_0x0079
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0077:
            r8 = r32
        L_0x0079:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r3 = r3 | r13
            goto L_0x007f
        L_0x007d:
            r8 = r32
        L_0x007f:
            r13 = r12 & 16
            if (r13 == 0) goto L_0x0086
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0086:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r11
            if (r14 != 0) goto L_0x009b
            r14 = r34
            boolean r15 = r2.changed((float) r14)
            if (r15 == 0) goto L_0x0097
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r15
            goto L_0x009d
        L_0x009b:
            r14 = r34
        L_0x009d:
            r15 = r12 & 32
            if (r15 == 0) goto L_0x00a8
            r16 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r16
            r0 = r35
            goto L_0x00bd
        L_0x00a8:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r11 & r16
            r0 = r35
            if (r16 != 0) goto L_0x00bd
            boolean r17 = r2.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00b9
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r3 = r3 | r17
        L_0x00bd:
            r17 = r12 & 64
            if (r17 == 0) goto L_0x00c8
            r18 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r18
            r0 = r36
            goto L_0x00dd
        L_0x00c8:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r11 & r18
            r0 = r36
            if (r18 != 0) goto L_0x00dd
            boolean r18 = r2.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00d9
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00db
        L_0x00d9:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00db:
            r3 = r3 | r18
        L_0x00dd:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00e6
            r3 = r3 | r18
            goto L_0x00f7
        L_0x00e6:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r11
            if (r0 != 0) goto L_0x00f7
            boolean r0 = r2.changed((java.lang.Object) r10)
            if (r0 == 0) goto L_0x00f4
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f6
        L_0x00f4:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f6:
            r3 = r3 | r0
        L_0x00f7:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r3
            r5 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r5) goto L_0x0112
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0107
            goto L_0x0112
        L_0x0107:
            r2.skipToGroupEnd()
            r3 = r29
            r13 = r35
            r15 = r36
            goto L_0x01de
        L_0x0112:
            r2.startDefaults()
            r0 = r11 & 1
            if (r0 == 0) goto L_0x0139
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0120
            goto L_0x0139
        L_0x0120:
            r2.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0129
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0129:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x012f
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x012f:
            r0 = r29
            r13 = r3
            r4 = r8
            r8 = r14
            r9 = r35
        L_0x0136:
            r3 = r36
            goto L_0x0183
        L_0x0139:
            if (r4 == 0) goto L_0x013e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0140
        L_0x013e:
            r0 = r29
        L_0x0140:
            r4 = r12 & 4
            r5 = 6
            if (r4 == 0) goto L_0x014d
            androidx.compose.material3.TabRowDefaults r4 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r6 = r4.getContainerColor(r2, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x014d:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x015a
            androidx.compose.material3.TabRowDefaults r4 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r4 = r4.getContentColor(r2, r5)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x015b
        L_0x015a:
            r4 = r8
        L_0x015b:
            if (r13 == 0) goto L_0x0160
            float r8 = ScrollableTabRowPadding
            goto L_0x0161
        L_0x0160:
            r8 = r14
        L_0x0161:
            if (r15 == 0) goto L_0x0171
            androidx.compose.material3.TabRowKt$ScrollableTabRow$1 r9 = new androidx.compose.material3.TabRowKt$ScrollableTabRow$1
            r9.<init>(r1)
            r13 = -913748678(0xffffffffc9894d3a, float:-1124775.2)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r13, r14, r9)
            goto L_0x0173
        L_0x0171:
            r9 = r35
        L_0x0173:
            if (r17 == 0) goto L_0x0181
            androidx.compose.material3.ComposableSingletons$TabRowKt r13 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r13 = r13.m1634getLambda2$material3_release()
            r27 = r13
            r13 = r3
            r3 = r27
            goto L_0x0183
        L_0x0181:
            r13 = r3
            goto L_0x0136
        L_0x0183:
            r2.endDefaults()
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0195
            r14 = -1
            java.lang.String r15 = "androidx.compose.material3.ScrollableTabRow (TabRow.kt:221)"
            r1 = -497821003(0xffffffffe253dab5, float:-9.770056E20)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r13, r14, r15)
        L_0x0195:
            r19 = 0
            r20 = 0
            r21 = 0
            androidx.compose.material3.TabRowKt$ScrollableTabRow$2 r1 = new androidx.compose.material3.TabRowKt$ScrollableTabRow$2
            r29 = r1
            r30 = r8
            r31 = r37
            r32 = r3
            r33 = r28
            r34 = r9
            r35 = r13
            r29.<init>(r30, r31, r32, r33, r34, r35)
            r15 = 286469328(0x11132cd0, float:1.1610064E-28)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r22 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r15, r14, r1)
            int r1 = r13 >> 3
            r1 = r1 & 14
            r1 = r1 | r18
            r14 = r13 & 896(0x380, float:1.256E-42)
            r1 = r1 | r14
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r24 = r1 | r13
            r25 = 114(0x72, float:1.6E-43)
            r13 = r0
            r1 = 0
            r14 = r1
            r15 = r6
            r17 = r4
            r23 = r2
            androidx.compose.material3.SurfaceKt.m1857SurfaceT9BRK9s(r13, r14, r15, r17, r19, r20, r21, r22, r23, r24, r25)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01d9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d9:
            r15 = r3
            r14 = r8
            r13 = r9
            r3 = r0
            r8 = r4
        L_0x01de:
            androidx.compose.runtime.ScopeUpdateScope r5 = r2.endRestartGroup()
            if (r5 != 0) goto L_0x01e5
            goto L_0x0203
        L_0x01e5:
            androidx.compose.material3.TabRowKt$ScrollableTabRow$3 r4 = new androidx.compose.material3.TabRowKt$ScrollableTabRow$3
            r0 = r4
            r1 = r28
            r2 = r3
            r26 = r4
            r3 = r6
            r7 = r5
            r5 = r8
            r9 = r7
            r7 = r14
            r8 = r13
            r13 = r9
            r9 = r15
            r10 = r37
            r11 = r39
            r12 = r40
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
            r0 = r26
            r13.updateScope(r0)
        L_0x0203:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m1894ScrollableTabRowsKfQg0A(int, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ec  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_]]")
    @androidx.compose.runtime.Composable
    /* renamed from: TabRow-pAZo6Ak  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1895TabRowpAZo6Ak(int r25, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r26, long r27, long r29, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r1 = r25
            r9 = r33
            r10 = r35
            java.lang.String r0 = "tabs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -1199178586(0xffffffffb885fca6, float:-6.388994E-5)
            r2 = r34
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            r3 = r36 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r10 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changed((int) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r10
            goto L_0x002b
        L_0x002a:
            r3 = r10
        L_0x002b:
            r4 = r36 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r10 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0045
            r5 = r26
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r3 = r3 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r26
        L_0x0047:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0060
            r6 = r36 & 4
            if (r6 != 0) goto L_0x005a
            r6 = r27
            boolean r8 = r2.changed((long) r6)
            if (r8 == 0) goto L_0x005c
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r6 = r27
        L_0x005c:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r3 = r3 | r8
            goto L_0x0062
        L_0x0060:
            r6 = r27
        L_0x0062:
            r8 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0079
            r8 = r36 & 8
            r11 = r29
            if (r8 != 0) goto L_0x0075
            boolean r8 = r2.changed((long) r11)
            if (r8 == 0) goto L_0x0075
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r3 = r3 | r8
            goto L_0x007b
        L_0x0079:
            r11 = r29
        L_0x007b:
            r8 = r36 & 16
            if (r8 == 0) goto L_0x0082
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0082:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x0097
            r13 = r31
            boolean r14 = r2.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0093
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r3 = r3 | r14
            goto L_0x0099
        L_0x0097:
            r13 = r31
        L_0x0099:
            r14 = r36 & 32
            if (r14 == 0) goto L_0x00a1
            r15 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r15
            goto L_0x00b6
        L_0x00a1:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00b6
            r15 = r32
            boolean r16 = r2.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00b1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r3 = r3 | r16
            goto L_0x00b8
        L_0x00b6:
            r15 = r32
        L_0x00b8:
            r16 = r36 & 64
            if (r16 == 0) goto L_0x00c1
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00be:
            r3 = r3 | r16
            goto L_0x00d3
        L_0x00c1:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00d3
            boolean r16 = r2.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x00d0
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00be
        L_0x00d0:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00be
        L_0x00d3:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r3 & r16
            r5 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r5) goto L_0x00ec
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x00e4
            goto L_0x00ec
        L_0x00e4:
            r2.skipToGroupEnd()
            r3 = r26
            r8 = r13
            goto L_0x0199
        L_0x00ec:
            r2.startDefaults()
            r0 = r10 & 1
            if (r0 == 0) goto L_0x0110
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x00fa
            goto L_0x0110
        L_0x00fa:
            r2.skipToGroupEnd()
            r0 = r36 & 4
            if (r0 == 0) goto L_0x0103
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0103:
            r0 = r36 & 8
            if (r0 == 0) goto L_0x0109
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0109:
            r0 = r26
            r4 = r11
            r8 = r13
        L_0x010d:
            r11 = r3
            r3 = r15
            goto L_0x0150
        L_0x0110:
            if (r4 == 0) goto L_0x0115
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0117
        L_0x0115:
            r0 = r26
        L_0x0117:
            r4 = r36 & 4
            r5 = 6
            if (r4 == 0) goto L_0x0124
            androidx.compose.material3.TabRowDefaults r4 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r6 = r4.getContainerColor(r2, r5)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0124:
            r4 = r36 & 8
            if (r4 == 0) goto L_0x0131
            androidx.compose.material3.TabRowDefaults r4 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r4 = r4.getContentColor(r2, r5)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0132
        L_0x0131:
            r4 = r11
        L_0x0132:
            if (r8 == 0) goto L_0x0142
            androidx.compose.material3.TabRowKt$TabRow$1 r8 = new androidx.compose.material3.TabRowKt$TabRow$1
            r8.<init>(r1)
            r11 = -2052073983(0xffffffff85afd601, float:-1.6535534E-35)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r11, r12, r8)
            goto L_0x0143
        L_0x0142:
            r8 = r13
        L_0x0143:
            if (r14 == 0) goto L_0x010d
            androidx.compose.material3.ComposableSingletons$TabRowKt r11 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r11 = r11.m1633getLambda1$material3_release()
            r24 = r11
            r11 = r3
            r3 = r24
        L_0x0150:
            r2.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x0162
            r12 = -1
            java.lang.String r13 = "androidx.compose.material3.TabRow (TabRow.kt:125)"
            r14 = -1199178586(0xffffffffb885fca6, float:-6.388994E-5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r11, r12, r13)
        L_0x0162:
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r0)
            r17 = 0
            r18 = 0
            r19 = 0
            androidx.compose.material3.TabRowKt$TabRow$2 r14 = new androidx.compose.material3.TabRowKt$TabRow$2
            r14.<init>(r9, r3, r8, r11)
            r15 = 1273256619(0x4be45aab, float:2.9930838E7)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r20 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r15, r13, r14)
            r13 = 12582912(0xc00000, float:1.7632415E-38)
            r14 = r11 & 896(0x380, float:1.256E-42)
            r13 = r13 | r14
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r22 = r13 | r11
            r23 = 114(0x72, float:1.6E-43)
            r11 = r12
            r12 = 0
            r13 = r6
            r15 = r4
            r21 = r2
            androidx.compose.material3.SurfaceKt.m1857SurfaceT9BRK9s(r11, r12, r13, r15, r17, r18, r19, r20, r21, r22, r23)
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0196
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0196:
            r15 = r3
            r11 = r4
            r3 = r0
        L_0x0199:
            androidx.compose.runtime.ScopeUpdateScope r13 = r2.endRestartGroup()
            if (r13 != 0) goto L_0x01a0
            goto L_0x01b6
        L_0x01a0:
            androidx.compose.material3.TabRowKt$TabRow$3 r14 = new androidx.compose.material3.TabRowKt$TabRow$3
            r0 = r14
            r1 = r25
            r2 = r3
            r3 = r6
            r5 = r11
            r7 = r8
            r8 = r15
            r9 = r33
            r10 = r35
            r11 = r36
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            r13.updateScope(r14)
        L_0x01b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m1895TabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
