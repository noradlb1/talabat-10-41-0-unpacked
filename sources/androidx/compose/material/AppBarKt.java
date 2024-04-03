package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ae\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001aq\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0001\u0010\u001f\u001a\u00020\n2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\n0!¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010!¢\u0006\u0002\b\u00172\u001e\b\u0002\u0010#\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001ae\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\u001a\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)H\b\u001a,\u0010,\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0-2\u0006\u0010.\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010/\u001a\u00020)H\u0000\u001a\u0011\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020)H\b\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"AppBarHeight", "Landroidx/compose/ui/unit/Dp;", "F", "AppBarHorizontalPadding", "BottomAppBarCutoutOffset", "BottomAppBarRoundedEdgeRadius", "TitleIconModifier", "Landroidx/compose/ui/Modifier;", "TitleInsetWithoutIcon", "AppBar", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "modifier", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "AppBar-celAv9A", "(JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar", "cutoutShape", "BottomAppBar-Y1yfwus", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar", "title", "Lkotlin/Function0;", "navigationIcon", "actions", "TopAppBar-xWeB9-s", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateCutoutCircleYIntercept", "", "cutoutRadius", "verticalOffset", "calculateRoundedEdgeIntercept", "Lkotlin/Pair;", "controlPointX", "radius", "square", "x", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AppBarKt {
    /* access modifiers changed from: private */
    public static final float AppBarHeight = Dp.m5478constructorimpl((float) 56);
    /* access modifiers changed from: private */
    public static final float AppBarHorizontalPadding;
    /* access modifiers changed from: private */
    public static final float BottomAppBarCutoutOffset = Dp.m5478constructorimpl((float) 8);
    /* access modifiers changed from: private */
    public static final float BottomAppBarRoundedEdgeRadius;
    /* access modifiers changed from: private */
    @NotNull
    public static final Modifier TitleIconModifier;
    /* access modifiers changed from: private */
    @NotNull
    public static final Modifier TitleInsetWithoutIcon;

    static {
        float f11 = (float) 4;
        float r12 = Dp.m5478constructorimpl(f11);
        AppBarHorizontalPadding = r12;
        Modifier.Companion companion = Modifier.Companion;
        TitleInsetWithoutIcon = SizeKt.m563width3ABfNKs(companion, Dp.m5478constructorimpl(Dp.m5478constructorimpl((float) 16) - r12));
        TitleIconModifier = SizeKt.m563width3ABfNKs(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, (Object) null), Dp.m5478constructorimpl(Dp.m5478constructorimpl((float) 72) - r12));
        BottomAppBarRoundedEdgeRadius = Dp.m5478constructorimpl(f11);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: AppBar-celAv9A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1084AppBarcelAv9A(long r24, long r26, float r28, androidx.compose.foundation.layout.PaddingValues r29, androidx.compose.ui.graphics.Shape r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r6 = r29
            r9 = r32
            r10 = r34
            r0 = -1249680788(0xffffffffb583626c, float:-9.788905E-7)
            r1 = r33
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r35 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r10 | 6
            r3 = r1
            r1 = r24
            goto L_0x002d
        L_0x0019:
            r1 = r10 & 14
            if (r1 != 0) goto L_0x002a
            r1 = r24
            boolean r3 = r0.changed((long) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r10
            goto L_0x002d
        L_0x002a:
            r1 = r24
            r3 = r10
        L_0x002d:
            r4 = r35 & 2
            if (r4 == 0) goto L_0x0034
            r3 = r3 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0047
            r4 = r26
            boolean r7 = r0.changed((long) r4)
            if (r7 == 0) goto L_0x0043
            r7 = 32
            goto L_0x0045
        L_0x0043:
            r7 = 16
        L_0x0045:
            r3 = r3 | r7
            goto L_0x0049
        L_0x0047:
            r4 = r26
        L_0x0049:
            r7 = r35 & 4
            if (r7 == 0) goto L_0x0050
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r7 = r10 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0063
            r7 = r28
            boolean r8 = r0.changed((float) r7)
            if (r8 == 0) goto L_0x005f
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r3 = r3 | r8
            goto L_0x0065
        L_0x0063:
            r7 = r28
        L_0x0065:
            r8 = r35 & 8
            if (r8 == 0) goto L_0x006c
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x006c:
            r8 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007c
            boolean r8 = r0.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x0079
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r3 = r3 | r8
        L_0x007c:
            r8 = r35 & 16
            if (r8 == 0) goto L_0x0083
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0083:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r10
            if (r8 != 0) goto L_0x0098
            r8 = r30
            boolean r11 = r0.changed((java.lang.Object) r8)
            if (r11 == 0) goto L_0x0094
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r3 = r3 | r11
            goto L_0x009a
        L_0x0098:
            r8 = r30
        L_0x009a:
            r11 = r35 & 32
            r12 = 458752(0x70000, float:6.42848E-40)
            if (r11 == 0) goto L_0x00a4
            r13 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r13
            goto L_0x00b7
        L_0x00a4:
            r13 = r10 & r12
            if (r13 != 0) goto L_0x00b7
            r13 = r31
            boolean r14 = r0.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00b3
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r3 = r3 | r14
            goto L_0x00b9
        L_0x00b7:
            r13 = r31
        L_0x00b9:
            r14 = r35 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00c1
            r3 = r3 | r15
            goto L_0x00d2
        L_0x00c1:
            r14 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00d2
            boolean r14 = r0.changed((java.lang.Object) r9)
            if (r14 == 0) goto L_0x00cf
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r3 = r3 | r14
        L_0x00d2:
            r14 = 2995931(0x2db6db, float:4.198194E-39)
            r14 = r14 & r3
            r12 = 599186(0x92492, float:8.39638E-40)
            if (r14 != r12) goto L_0x00e8
            boolean r12 = r0.getSkipping()
            if (r12 != 0) goto L_0x00e2
            goto L_0x00e8
        L_0x00e2:
            r0.skipToGroupEnd()
            r23 = r13
            goto L_0x012a
        L_0x00e8:
            if (r11 == 0) goto L_0x00ef
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            r23 = r11
            goto L_0x00f1
        L_0x00ef:
            r23 = r13
        L_0x00f1:
            r17 = 0
            androidx.compose.material.AppBarKt$AppBar$1 r11 = new androidx.compose.material.AppBarKt$AppBar$1
            r11.<init>(r6, r9, r3)
            r12 = -1027830352(0xffffffffc2bc8db0, float:-94.27673)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r19 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r12, r13, r11)
            int r11 = r3 >> 15
            r11 = r11 & 14
            r11 = r11 | r15
            int r12 = r3 >> 9
            r12 = r12 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            int r12 = r3 << 6
            r13 = r12 & 896(0x380, float:1.256E-42)
            r11 = r11 | r13
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            int r3 = r3 << 9
            r12 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r12
            r21 = r11 | r3
            r22 = 16
            r11 = r23
            r12 = r30
            r13 = r24
            r15 = r26
            r18 = r28
            r20 = r0
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r11, r12, r13, r15, r17, r18, r19, r20, r21, r22)
        L_0x012a:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x0131
            goto L_0x014c
        L_0x0131:
            androidx.compose.material.AppBarKt$AppBar$2 r13 = new androidx.compose.material.AppBarKt$AppBar$2
            r0 = r13
            r1 = r24
            r3 = r26
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r23
            r9 = r32
            r10 = r34
            r11 = r35
            r0.<init>(r1, r3, r5, r6, r7, r8, r9, r10, r11)
            r12.updateScope(r13)
        L_0x014c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AppBarKt.m1084AppBarcelAv9A(long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.ui.graphics.Shape, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f9  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: BottomAppBar-Y1yfwus  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1085BottomAppBarY1yfwus(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r24, long r25, long r27, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r29, float r30, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r31, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r12 = r32
            r13 = r34
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1651948973(0xffffffff9d894253, float:-3.6332176E-21)
            r1 = r33
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            r0 = r35 & 1
            if (r0 == 0) goto L_0x001c
            r1 = r13 | 6
            r2 = r1
            r1 = r24
            goto L_0x0030
        L_0x001c:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x002d
            r1 = r24
            boolean r2 = r14.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r2 = r2 | r13
            goto L_0x0030
        L_0x002d:
            r1 = r24
            r2 = r13
        L_0x0030:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0049
            r3 = r35 & 2
            if (r3 != 0) goto L_0x0043
            r3 = r25
            boolean r5 = r14.changed((long) r3)
            if (r5 == 0) goto L_0x0045
            r5 = 32
            goto L_0x0047
        L_0x0043:
            r3 = r25
        L_0x0045:
            r5 = 16
        L_0x0047:
            r2 = r2 | r5
            goto L_0x004b
        L_0x0049:
            r3 = r25
        L_0x004b:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0064
            r5 = r35 & 4
            if (r5 != 0) goto L_0x005e
            r5 = r27
            boolean r7 = r14.changed((long) r5)
            if (r7 == 0) goto L_0x0060
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x005e:
            r5 = r27
        L_0x0060:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r2 = r2 | r7
            goto L_0x0066
        L_0x0064:
            r5 = r27
        L_0x0066:
            r7 = r35 & 8
            if (r7 == 0) goto L_0x006d
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0080
            r8 = r29
            boolean r9 = r14.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007c
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r2 = r2 | r9
            goto L_0x0082
        L_0x0080:
            r8 = r29
        L_0x0082:
            r9 = r35 & 16
            if (r9 == 0) goto L_0x0089
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x0089:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x009e
            r10 = r30
            boolean r11 = r14.changed((float) r10)
            if (r11 == 0) goto L_0x009a
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r2 = r2 | r11
            goto L_0x00a0
        L_0x009e:
            r10 = r30
        L_0x00a0:
            r11 = r35 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r11 == 0) goto L_0x00ad
            r16 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r16
            r15 = r31
            goto L_0x00c0
        L_0x00ad:
            r16 = r13 & r15
            r15 = r31
            if (r16 != 0) goto L_0x00c0
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00bc
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00be
        L_0x00bc:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00be:
            r2 = r2 | r16
        L_0x00c0:
            r16 = r35 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00cb
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c8:
            r2 = r2 | r16
            goto L_0x00db
        L_0x00cb:
            r16 = r13 & r17
            if (r16 != 0) goto L_0x00db
            boolean r16 = r14.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x00d8
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c8
        L_0x00d8:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c8
        L_0x00db:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r1 = r2 & r16
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r1 != r3) goto L_0x00f9
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x00ec
            goto L_0x00f9
        L_0x00ec:
            r14.skipToGroupEnd()
            r1 = r24
            r2 = r25
            r4 = r5
            r6 = r8
            r7 = r10
            r8 = r15
            goto L_0x01d7
        L_0x00f9:
            r14.startDefaults()
            r1 = r13 & 1
            if (r1 == 0) goto L_0x0122
            boolean r1 = r14.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0107
            goto L_0x0122
        L_0x0107:
            r14.skipToGroupEnd()
            r0 = r35 & 2
            if (r0 == 0) goto L_0x0110
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0110:
            r0 = r35 & 4
            if (r0 == 0) goto L_0x0116
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0116:
            r18 = r25
            r20 = r5
            r11 = r8
            r16 = r10
            r22 = r15
            r15 = r24
            goto L_0x0176
        L_0x0122:
            if (r0 == 0) goto L_0x0127
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0129
        L_0x0127:
            r0 = r24
        L_0x0129:
            r1 = r35 & 2
            if (r1 == 0) goto L_0x013b
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 6
            androidx.compose.material.Colors r1 = r1.getColors(r14, r3)
            long r3 = androidx.compose.material.ColorsKt.getPrimarySurface(r1)
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x013d
        L_0x013b:
            r3 = r25
        L_0x013d:
            r1 = r35 & 4
            if (r1 == 0) goto L_0x014c
            int r1 = r2 >> 3
            r1 = r1 & 14
            long r5 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r3, r14, r1)
            r1 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r2 = r1
        L_0x014c:
            if (r7 == 0) goto L_0x0150
            r1 = 0
            r8 = r1
        L_0x0150:
            if (r9 == 0) goto L_0x0159
            androidx.compose.material.AppBarDefaults r1 = androidx.compose.material.AppBarDefaults.INSTANCE
            float r1 = r1.m1082getBottomAppBarElevationD9Ej5fM()
            r10 = r1
        L_0x0159:
            if (r11 == 0) goto L_0x016c
            androidx.compose.material.AppBarDefaults r1 = androidx.compose.material.AppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r1 = r1.getContentPadding()
            r15 = r0
            r22 = r1
            r18 = r3
            r20 = r5
            r11 = r8
            r16 = r10
            goto L_0x0176
        L_0x016c:
            r18 = r3
            r20 = r5
            r11 = r8
            r16 = r10
            r22 = r15
            r15 = r0
        L_0x0176:
            r14.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ScaffoldKt.getLocalFabPlacement()
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.material.FabPlacement r0 = (androidx.compose.material.FabPlacement) r0
            if (r11 == 0) goto L_0x0199
            r1 = 0
            if (r0 == 0) goto L_0x0190
            boolean r3 = r0.isDocked()
            r4 = 1
            if (r3 != r4) goto L_0x0190
            r1 = r4
        L_0x0190:
            if (r1 == 0) goto L_0x0199
            androidx.compose.material.BottomAppBarCutoutShape r1 = new androidx.compose.material.BottomAppBarCutoutShape
            r1.<init>(r11, r0)
            r6 = r1
            goto L_0x019e
        L_0x0199:
            androidx.compose.ui.graphics.Shape r0 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r6 = r0
        L_0x019e:
            int r0 = r2 >> 3
            r1 = r0 & 14
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r2 >> 6
            r3 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r2 << 15
            r3 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r3
            r0 = r0 | r1
            r1 = r2 & r17
            r10 = r0 | r1
            r17 = 0
            r0 = r18
            r2 = r20
            r4 = r16
            r5 = r22
            r7 = r15
            r8 = r32
            r9 = r14
            r23 = r11
            r11 = r17
            m1084AppBarcelAv9A(r0, r2, r4, r5, r6, r7, r8, r9, r10, r11)
            r1 = r15
            r7 = r16
            r2 = r18
            r4 = r20
            r8 = r22
            r6 = r23
        L_0x01d7:
            androidx.compose.runtime.ScopeUpdateScope r14 = r14.endRestartGroup()
            if (r14 != 0) goto L_0x01de
            goto L_0x01ed
        L_0x01de:
            androidx.compose.material.AppBarKt$BottomAppBar$1 r15 = new androidx.compose.material.AppBarKt$BottomAppBar$1
            r0 = r15
            r9 = r32
            r10 = r34
            r11 = r35
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10, r11)
            r14.updateScope(r15)
        L_0x01ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AppBarKt.m1085BottomAppBarY1yfwus(androidx.compose.ui.Modifier, long, long, androidx.compose.ui.graphics.Shape, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0180  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: TopAppBar-HsRjFd4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1086TopAppBarHsRjFd4(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r22, long r23, long r25, float r27, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r28, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r12 = r29
            r13 = r31
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 1897058582(0x7112d116, float:7.270013E29)
            r1 = r30
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            r0 = r32 & 1
            if (r0 == 0) goto L_0x001c
            r1 = r13 | 6
            r2 = r1
            r1 = r22
            goto L_0x0030
        L_0x001c:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x002d
            r1 = r22
            boolean r2 = r14.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r2 = r2 | r13
            goto L_0x0030
        L_0x002d:
            r1 = r22
            r2 = r13
        L_0x0030:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0049
            r3 = r32 & 2
            if (r3 != 0) goto L_0x0043
            r3 = r23
            boolean r5 = r14.changed((long) r3)
            if (r5 == 0) goto L_0x0045
            r5 = 32
            goto L_0x0047
        L_0x0043:
            r3 = r23
        L_0x0045:
            r5 = 16
        L_0x0047:
            r2 = r2 | r5
            goto L_0x004b
        L_0x0049:
            r3 = r23
        L_0x004b:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0064
            r5 = r32 & 4
            if (r5 != 0) goto L_0x005e
            r5 = r25
            boolean r7 = r14.changed((long) r5)
            if (r7 == 0) goto L_0x0060
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x005e:
            r5 = r25
        L_0x0060:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r2 = r2 | r7
            goto L_0x0066
        L_0x0064:
            r5 = r25
        L_0x0066:
            r7 = r32 & 8
            if (r7 == 0) goto L_0x006d
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0080
            r8 = r27
            boolean r9 = r14.changed((float) r8)
            if (r9 == 0) goto L_0x007c
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r2 = r2 | r9
            goto L_0x0082
        L_0x0080:
            r8 = r27
        L_0x0082:
            r9 = r32 & 16
            if (r9 == 0) goto L_0x0089
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x0089:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x009e
            r10 = r28
            boolean r11 = r14.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x009a
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r2 = r2 | r11
            goto L_0x00a0
        L_0x009e:
            r10 = r28
        L_0x00a0:
            r11 = r32 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r11 == 0) goto L_0x00aa
            r11 = 196608(0x30000, float:2.75506E-40)
        L_0x00a8:
            r2 = r2 | r11
            goto L_0x00ba
        L_0x00aa:
            r11 = r13 & r15
            if (r11 != 0) goto L_0x00ba
            boolean r11 = r14.changed((java.lang.Object) r12)
            if (r11 == 0) goto L_0x00b7
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a8
        L_0x00b7:
            r11 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a8
        L_0x00ba:
            r11 = 374491(0x5b6db, float:5.24774E-40)
            r11 = r11 & r2
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r11 != r15) goto L_0x00d3
            boolean r11 = r14.getSkipping()
            if (r11 != 0) goto L_0x00ca
            goto L_0x00d3
        L_0x00ca:
            r14.skipToGroupEnd()
            r2 = r3
            r4 = r5
            r6 = r8
            r7 = r10
            goto L_0x0179
        L_0x00d3:
            r14.startDefaults()
            r11 = r13 & 1
            if (r11 == 0) goto L_0x00fa
            boolean r11 = r14.getDefaultsInvalid()
            if (r11 == 0) goto L_0x00e1
            goto L_0x00fa
        L_0x00e1:
            r14.skipToGroupEnd()
            r0 = r32 & 2
            if (r0 == 0) goto L_0x00ea
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ea:
            r0 = r32 & 4
            if (r0 == 0) goto L_0x00f0
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00f0:
            r15 = r1
        L_0x00f1:
            r16 = r3
            r18 = r5
            r20 = r8
            r21 = r10
            goto L_0x013d
        L_0x00fa:
            if (r0 == 0) goto L_0x00ff
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0100
        L_0x00ff:
            r0 = r1
        L_0x0100:
            r1 = r32 & 2
            if (r1 == 0) goto L_0x0111
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 6
            androidx.compose.material.Colors r1 = r1.getColors(r14, r3)
            long r3 = androidx.compose.material.ColorsKt.getPrimarySurface(r1)
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0111:
            r1 = r32 & 4
            if (r1 == 0) goto L_0x0120
            int r1 = r2 >> 3
            r1 = r1 & 14
            long r5 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r3, r14, r1)
            r1 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r2 = r1
        L_0x0120:
            if (r7 == 0) goto L_0x0129
            androidx.compose.material.AppBarDefaults r1 = androidx.compose.material.AppBarDefaults.INSTANCE
            float r1 = r1.m1083getTopAppBarElevationD9Ej5fM()
            r8 = r1
        L_0x0129:
            if (r9 == 0) goto L_0x013b
            androidx.compose.material.AppBarDefaults r1 = androidx.compose.material.AppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r1 = r1.getContentPadding()
            r15 = r0
            r21 = r1
            r16 = r3
            r18 = r5
            r20 = r8
            goto L_0x013d
        L_0x013b:
            r15 = r0
            goto L_0x00f1
        L_0x013d:
            r14.endDefaults()
            androidx.compose.ui.graphics.Shape r6 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            int r0 = r2 >> 3
            r1 = r0 & 14
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r3 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            r3 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r2 << 15
            r3 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r3
            r0 = r0 | r1
            r1 = 3670016(0x380000, float:5.142788E-39)
            int r2 = r2 << 3
            r1 = r1 & r2
            r10 = r0 | r1
            r11 = 0
            r0 = r16
            r2 = r18
            r4 = r20
            r5 = r21
            r7 = r15
            r8 = r29
            r9 = r14
            m1084AppBarcelAv9A(r0, r2, r4, r5, r6, r7, r8, r9, r10, r11)
            r1 = r15
            r2 = r16
            r4 = r18
            r6 = r20
            r7 = r21
        L_0x0179:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x0180
            goto L_0x018f
        L_0x0180:
            androidx.compose.material.AppBarKt$TopAppBar$3 r14 = new androidx.compose.material.AppBarKt$TopAppBar$3
            r0 = r14
            r8 = r29
            r9 = r31
            r10 = r32
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10)
            r11.updateScope(r14)
        L_0x018f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AppBarKt.m1086TopAppBarHsRjFd4(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f2  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: TopAppBar-xWeB9-s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1087TopAppBarxWeB9s(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r26, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, long r29, long r31, float r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r1 = r25
            r10 = r35
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = -2087748139(0xffffffff838f7dd5, float:-8.433674E-37)
            r2 = r34
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r36 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r10 | 6
            goto L_0x0029
        L_0x0019:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x0028
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0025
            r2 = 4
            goto L_0x0026
        L_0x0025:
            r2 = 2
        L_0x0026:
            r2 = r2 | r10
            goto L_0x0029
        L_0x0028:
            r2 = r10
        L_0x0029:
            r3 = r36 & 2
            if (r3 == 0) goto L_0x0030
            r2 = r2 | 48
            goto L_0x0043
        L_0x0030:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0043
            r4 = r26
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x003f
            r5 = 32
            goto L_0x0041
        L_0x003f:
            r5 = 16
        L_0x0041:
            r2 = r2 | r5
            goto L_0x0045
        L_0x0043:
            r4 = r26
        L_0x0045:
            r5 = r36 & 4
            if (r5 == 0) goto L_0x004c
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x005f
            r6 = r27
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005b
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r2 = r2 | r7
            goto L_0x0061
        L_0x005f:
            r6 = r27
        L_0x0061:
            r7 = r36 & 8
            if (r7 == 0) goto L_0x0068
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r8 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007b
            r8 = r28
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0077
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r2 = r2 | r9
            goto L_0x007d
        L_0x007b:
            r8 = r28
        L_0x007d:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r10
            if (r9 != 0) goto L_0x0096
            r9 = r36 & 16
            r11 = r29
            if (r9 != 0) goto L_0x0092
            boolean r9 = r0.changed((long) r11)
            if (r9 == 0) goto L_0x0092
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r2 = r2 | r9
            goto L_0x0098
        L_0x0096:
            r11 = r29
        L_0x0098:
            r9 = 458752(0x70000, float:6.42848E-40)
            r13 = r10 & r9
            if (r13 != 0) goto L_0x00b3
            r13 = r36 & 32
            if (r13 != 0) goto L_0x00ad
            r13 = r31
            boolean r15 = r0.changed((long) r13)
            if (r15 == 0) goto L_0x00af
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00ad:
            r13 = r31
        L_0x00af:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r2 = r2 | r15
            goto L_0x00b5
        L_0x00b3:
            r13 = r31
        L_0x00b5:
            r15 = r36 & 64
            if (r15 == 0) goto L_0x00c0
            r16 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r16
            r9 = r33
            goto L_0x00d5
        L_0x00c0:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r10 & r16
            r9 = r33
            if (r16 != 0) goto L_0x00d5
            boolean r16 = r0.changed((float) r9)
            if (r16 == 0) goto L_0x00d1
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00d1:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r2 = r2 | r16
        L_0x00d5:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r4 = r2 & r16
            r6 = 599186(0x92492, float:8.39638E-40)
            if (r4 != r6) goto L_0x00f2
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x00e6
            goto L_0x00f2
        L_0x00e6:
            r0.skipToGroupEnd()
            r2 = r26
            r3 = r27
            r4 = r8
            r5 = r11
            r7 = r13
            goto L_0x01a3
        L_0x00f2:
            r0.startDefaults()
            r4 = r10 & 1
            r6 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            if (r4 == 0) goto L_0x011d
            boolean r4 = r0.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0106
            goto L_0x011d
        L_0x0106:
            r0.skipToGroupEnd()
            r3 = r36 & 16
            if (r3 == 0) goto L_0x010f
            r2 = r2 & r16
        L_0x010f:
            r3 = r36 & 32
            if (r3 == 0) goto L_0x0114
            r2 = r2 & r6
        L_0x0114:
            r3 = r26
            r4 = r27
            r5 = r8
            r7 = r11
            r23 = r13
            goto L_0x0161
        L_0x011d:
            if (r3 == 0) goto L_0x0122
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x0124
        L_0x0122:
            r3 = r26
        L_0x0124:
            if (r5 == 0) goto L_0x0128
            r4 = 0
            goto L_0x012a
        L_0x0128:
            r4 = r27
        L_0x012a:
            if (r7 == 0) goto L_0x0133
            androidx.compose.material.ComposableSingletons$AppBarKt r5 = androidx.compose.material.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r5 = r5.m1202getLambda1$material_release()
            goto L_0x0134
        L_0x0133:
            r5 = r8
        L_0x0134:
            r7 = r36 & 16
            if (r7 == 0) goto L_0x0146
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            r8 = 6
            androidx.compose.material.Colors r7 = r7.getColors(r0, r8)
            long r7 = androidx.compose.material.ColorsKt.getPrimarySurface(r7)
            r2 = r2 & r16
            goto L_0x0147
        L_0x0146:
            r7 = r11
        L_0x0147:
            r11 = r36 & 32
            if (r11 == 0) goto L_0x0155
            int r11 = r2 >> 12
            r11 = r11 & 14
            long r11 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r7, r0, r11)
            r2 = r2 & r6
            goto L_0x0156
        L_0x0155:
            r11 = r13
        L_0x0156:
            if (r15 == 0) goto L_0x015f
            androidx.compose.material.AppBarDefaults r6 = androidx.compose.material.AppBarDefaults.INSTANCE
            float r6 = r6.m1083getTopAppBarElevationD9Ej5fM()
            r9 = r6
        L_0x015f:
            r23 = r11
        L_0x0161:
            r0.endDefaults()
            androidx.compose.material.AppBarDefaults r6 = androidx.compose.material.AppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r16 = r6.getContentPadding()
            androidx.compose.ui.graphics.Shape r17 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            androidx.compose.material.AppBarKt$TopAppBar$1 r6 = new androidx.compose.material.AppBarKt$TopAppBar$1
            r6.<init>(r4, r2, r1, r5)
            r11 = -1484077694(0xffffffffa78ac582, float:-3.8516833E-15)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r19 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r11, r12, r6)
            int r6 = r2 >> 12
            r11 = r6 & 14
            r12 = 1600512(0x186c00, float:2.242795E-39)
            r11 = r11 | r12
            r12 = r6 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            r6 = r6 & 896(0x380, float:1.256E-42)
            r6 = r6 | r11
            int r2 = r2 << 12
            r11 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r11
            r21 = r6 | r2
            r22 = 0
            r11 = r7
            r13 = r23
            r15 = r9
            r18 = r3
            r20 = r0
            m1084AppBarcelAv9A(r11, r13, r15, r16, r17, r18, r19, r20, r21, r22)
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r7 = r23
        L_0x01a3:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x01aa
            goto L_0x01b9
        L_0x01aa:
            androidx.compose.material.AppBarKt$TopAppBar$2 r13 = new androidx.compose.material.AppBarKt$TopAppBar$2
            r0 = r13
            r1 = r25
            r10 = r35
            r11 = r36
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11)
            r12.updateScope(r13)
        L_0x01b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AppBarKt.m1087TopAppBarxWeB9s(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, long, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float calculateCutoutCircleYIntercept(float f11, float f12) {
        return -((float) Math.sqrt((double) ((f11 * f11) - (f12 * f12))));
    }

    @NotNull
    public static final Pair<Float, Float> calculateRoundedEdgeIntercept(float f11, float f12, float f13) {
        Pair pair;
        Float f14;
        Float f15;
        Float f16;
        Float f17;
        float f18 = f12 * f12;
        float f19 = f13 * f13;
        float f21 = (f11 * f11) + f18;
        float f22 = f18 * f19 * (f21 - f19);
        float f23 = f11 * f19;
        double d11 = (double) f22;
        float sqrt = (f23 - ((float) Math.sqrt(d11))) / f21;
        float sqrt2 = (f23 + ((float) Math.sqrt(d11))) / f21;
        float sqrt3 = (float) Math.sqrt((double) (f19 - (sqrt * sqrt)));
        float sqrt4 = (float) Math.sqrt((double) (f19 - (sqrt2 * sqrt2)));
        if (f12 > 0.0f) {
            if (sqrt3 > sqrt4) {
                f17 = Float.valueOf(sqrt);
                f16 = Float.valueOf(sqrt3);
            } else {
                f17 = Float.valueOf(sqrt2);
                f16 = Float.valueOf(sqrt4);
            }
            pair = TuplesKt.to(f17, f16);
        } else {
            if (sqrt3 < sqrt4) {
                f15 = Float.valueOf(sqrt);
                f14 = Float.valueOf(sqrt3);
            } else {
                f15 = Float.valueOf(sqrt2);
                f14 = Float.valueOf(sqrt4);
            }
            pair = TuplesKt.to(f15, f14);
        }
        float floatValue = ((Number) pair.component1()).floatValue();
        float floatValue2 = ((Number) pair.component2()).floatValue();
        if (floatValue < f11) {
            floatValue2 = -floatValue2;
        }
        return TuplesKt.to(Float.valueOf(floatValue), Float.valueOf(floatValue2));
    }

    private static final float square(float f11) {
        return f11 * f11;
    }
}
