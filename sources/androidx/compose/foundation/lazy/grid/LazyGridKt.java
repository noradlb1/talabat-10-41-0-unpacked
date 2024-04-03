package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\fH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010 \u001a\u0018\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0001\u0010&\u001a\u0019\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020(0\u0007¢\u0006\u0002\b\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010)\u001a\u00020*H\u0003ø\u0001\u0000¢\u0006\u0002\u0010+\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slotSizesSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "", "", "Lkotlin/ExtensionFunctionType;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/runtime/Composer;I)V", "refreshOverscrollInfo", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "result", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "rememberLazyGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureResult;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyGridKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0133  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyGrid(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r31, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.grid.LazyGridState r32, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super androidx.compose.ui.unit.Constraints, ? extends java.util.List<java.lang.Integer>> r33, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r34, boolean r35, boolean r36, @org.jetbrains.annotations.Nullable androidx.compose.foundation.gestures.FlingBehavior r37, boolean r38, @org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.Arrangement.Vertical r39, @org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.Arrangement.Horizontal r40, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r41, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r42, int r43, int r44, int r45) {
        /*
            r13 = r32
            r14 = r33
            r15 = r36
            r12 = r39
            r11 = r40
            r10 = r41
            r9 = r43
            r8 = r45
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "slotSizesSums"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "verticalArrangement"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "horizontalArrangement"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 152645664(0x9193020, float:1.8439333E-33)
            r1 = r42
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            r1 = r8 & 1
            if (r1 == 0) goto L_0x003c
            r4 = r9 | 6
            r5 = r4
            r4 = r31
            goto L_0x0050
        L_0x003c:
            r4 = r9 & 14
            if (r4 != 0) goto L_0x004d
            r4 = r31
            boolean r5 = r7.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004a
            r5 = 4
            goto L_0x004b
        L_0x004a:
            r5 = 2
        L_0x004b:
            r5 = r5 | r9
            goto L_0x0050
        L_0x004d:
            r4 = r31
            r5 = r9
        L_0x0050:
            r6 = r8 & 2
            if (r6 == 0) goto L_0x0057
            r5 = r5 | 48
            goto L_0x0067
        L_0x0057:
            r6 = r9 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0067
            boolean r6 = r7.changed((java.lang.Object) r13)
            if (r6 == 0) goto L_0x0064
            r6 = 32
            goto L_0x0066
        L_0x0064:
            r6 = 16
        L_0x0066:
            r5 = r5 | r6
        L_0x0067:
            r6 = r8 & 4
            if (r6 == 0) goto L_0x006e
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x007e
        L_0x006e:
            r6 = r9 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x007e
            boolean r6 = r7.changed((java.lang.Object) r14)
            if (r6 == 0) goto L_0x007b
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x007d
        L_0x007b:
            r6 = 128(0x80, float:1.794E-43)
        L_0x007d:
            r5 = r5 | r6
        L_0x007e:
            r6 = r8 & 8
            if (r6 == 0) goto L_0x0085
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x0099
        L_0x0085:
            r2 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0099
            r2 = r34
            boolean r16 = r7.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x0094
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x0096
        L_0x0094:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x0096:
            r5 = r5 | r16
            goto L_0x009b
        L_0x0099:
            r2 = r34
        L_0x009b:
            r16 = r8 & 16
            r17 = 57344(0xe000, float:8.0356E-41)
            if (r16 == 0) goto L_0x00a7
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r0 = r35
            goto L_0x00ba
        L_0x00a7:
            r18 = r9 & r17
            r0 = r35
            if (r18 != 0) goto L_0x00ba
            boolean r19 = r7.changed((boolean) r0)
            if (r19 == 0) goto L_0x00b6
            r19 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b8
        L_0x00b6:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x00b8:
            r5 = r5 | r19
        L_0x00ba:
            r19 = r8 & 32
            r20 = 458752(0x70000, float:6.42848E-40)
            if (r19 == 0) goto L_0x00c5
            r19 = 196608(0x30000, float:2.75506E-40)
        L_0x00c2:
            r5 = r5 | r19
            goto L_0x00d5
        L_0x00c5:
            r19 = r9 & r20
            if (r19 != 0) goto L_0x00d5
            boolean r19 = r7.changed((boolean) r15)
            if (r19 == 0) goto L_0x00d2
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00d2:
            r19 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00c2
        L_0x00d5:
            r19 = 3670016(0x380000, float:5.142788E-39)
            r21 = r9 & r19
            if (r21 != 0) goto L_0x00ef
            r21 = r8 & 64
            r3 = r37
            if (r21 != 0) goto L_0x00ea
            boolean r22 = r7.changed((java.lang.Object) r3)
            if (r22 == 0) goto L_0x00ea
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ec
        L_0x00ea:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00ec:
            r5 = r5 | r22
            goto L_0x00f1
        L_0x00ef:
            r3 = r37
        L_0x00f1:
            r0 = r8 & 128(0x80, float:1.794E-43)
            r22 = 29360128(0x1c00000, float:7.052966E-38)
            if (r0 == 0) goto L_0x00fb
            r0 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 | r0
            goto L_0x010f
        L_0x00fb:
            r0 = r9 & r22
            if (r0 != 0) goto L_0x010f
            r0 = r38
            boolean r23 = r7.changed((boolean) r0)
            if (r23 == 0) goto L_0x010a
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010c
        L_0x010a:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x010c:
            r5 = r5 | r23
            goto L_0x0111
        L_0x010f:
            r0 = r38
        L_0x0111:
            r0 = r8 & 256(0x100, float:3.59E-43)
            r23 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x011b
            r0 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0119:
            r5 = r5 | r0
            goto L_0x012b
        L_0x011b:
            r0 = r9 & r23
            if (r0 != 0) goto L_0x012b
            boolean r0 = r7.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x0128
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0119
        L_0x0128:
            r0 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0119
        L_0x012b:
            r0 = r8 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0133
            r0 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0131:
            r5 = r5 | r0
            goto L_0x0144
        L_0x0133:
            r0 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r9
            if (r0 != 0) goto L_0x0144
            boolean r0 = r7.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x0141
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0131
        L_0x0141:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0131
        L_0x0144:
            r0 = r8 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x014b
            r0 = r44 | 6
            goto L_0x015d
        L_0x014b:
            r0 = r44 & 14
            if (r0 != 0) goto L_0x015b
            boolean r0 = r7.changed((java.lang.Object) r10)
            if (r0 == 0) goto L_0x0157
            r0 = 4
            goto L_0x0158
        L_0x0157:
            r0 = 2
        L_0x0158:
            r0 = r44 | r0
            goto L_0x015d
        L_0x015b:
            r0 = r44
        L_0x015d:
            r24 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r5 & r24
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r3) goto L_0x0180
            r2 = r0 & 11
            r3 = 2
            if (r2 != r3) goto L_0x0180
            boolean r2 = r7.getSkipping()
            if (r2 != 0) goto L_0x0173
            goto L_0x0180
        L_0x0173:
            r7.skipToGroupEnd()
            r5 = r35
            r1 = r4
            r9 = r7
            r4 = r34
            r7 = r37
            goto L_0x033b
        L_0x0180:
            r7.startDefaults()
            r2 = r9 & 1
            r3 = 6
            if (r2 == 0) goto L_0x01a3
            boolean r2 = r7.getDefaultsInvalid()
            if (r2 == 0) goto L_0x018f
            goto L_0x01a3
        L_0x018f:
            r7.skipToGroupEnd()
            r1 = r8 & 64
            if (r1 == 0) goto L_0x019a
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r5 = r5 & r1
        L_0x019a:
            r16 = r34
            r21 = r37
            r6 = r4
            r4 = r5
            r5 = r35
            goto L_0x01da
        L_0x01a3:
            if (r1 == 0) goto L_0x01a8
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x01a9
        L_0x01a8:
            r1 = r4
        L_0x01a9:
            r2 = 0
            if (r6 == 0) goto L_0x01b6
            float r4 = (float) r2
            float r4 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r4)
            androidx.compose.foundation.layout.PaddingValues r4 = androidx.compose.foundation.layout.PaddingKt.m479PaddingValues0680j_4(r4)
            goto L_0x01b8
        L_0x01b6:
            r4 = r34
        L_0x01b8:
            if (r16 == 0) goto L_0x01bb
            goto L_0x01bd
        L_0x01bb:
            r2 = r35
        L_0x01bd:
            r6 = r8 & 64
            if (r6 == 0) goto L_0x01d3
            androidx.compose.foundation.gestures.ScrollableDefaults r6 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.foundation.gestures.FlingBehavior r6 = r6.flingBehavior(r7, r3)
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            r5 = r5 & r16
            r16 = r4
            r4 = r5
            r21 = r6
            r6 = r1
            goto L_0x01d9
        L_0x01d3:
            r21 = r37
            r6 = r1
            r16 = r4
            r4 = r5
        L_0x01d9:
            r5 = r2
        L_0x01da:
            r7.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01eb
            java.lang.String r1 = "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)"
            r2 = 152645664(0x9193020, float:1.8439333E-33)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r4, r0, r1)
        L_0x01eb:
            androidx.compose.foundation.gestures.ScrollableDefaults r2 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.foundation.OverscrollEffect r3 = r2.overscrollEffect(r7, r3)
            int r1 = r4 >> 3
            r1 = r1 & 14
            int r0 = r0 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            androidx.compose.foundation.lazy.grid.LazyGridItemProvider r0 = androidx.compose.foundation.lazy.grid.LazyGridItemProviderKt.rememberLazyGridItemProvider(r13, r10, r7, r0)
            r31 = r2
            int r2 = r4 >> 6
            r34 = r6
            r6 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r6
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r18 = androidx.compose.foundation.lazy.grid.LazySemanticsKt.rememberLazyGridSemanticState(r13, r0, r5, r7, r1)
            r1 = 773894976(0x2e20b340, float:3.6538994E-11)
            r7.startReplaceableGroup(r1)
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r1)
            java.lang.Object r1 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            r35 = r0
            java.lang.Object r0 = r6.getEmpty()
            if (r1 != r0) goto L_0x0233
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r7)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r7.updateRememberedValue(r1)
        L_0x0233:
            r7.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r0 = r1.getCoroutineScope()
            r7.endReplaceableGroup()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r36)
            r24 = r5
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r7.startReplaceableGroup(r5)
            boolean r5 = r7.changed((java.lang.Object) r13)
            boolean r1 = r7.changed((java.lang.Object) r1)
            r1 = r1 | r5
            java.lang.Object r5 = r7.rememberedValue()
            if (r1 != 0) goto L_0x0260
            java.lang.Object r1 = r6.getEmpty()
            if (r5 != r1) goto L_0x0268
        L_0x0260:
            androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator r5 = new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator
            r5.<init>(r0, r15)
            r7.updateRememberedValue(r5)
        L_0x0268:
            r7.endReplaceableGroup()
            r6 = r5
            androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator r6 = (androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator) r6
            r13.setPlacementAnimator$foundation_release(r6)
            r5 = r4 & 112(0x70, float:1.57E-43)
            r0 = 1073741824(0x40000000, float:2.0)
            r0 = r0 | r5
            int r1 = r4 << 3
            r37 = r5
            r5 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r5
            r5 = r1 & r17
            r0 = r0 | r5
            r5 = r1 & r20
            r0 = r0 | r5
            r1 = r1 & r19
            r0 = r0 | r1
            r1 = r2 & r22
            r0 = r0 | r1
            r1 = r4 & r23
            r19 = r0 | r1
            r20 = 0
            r5 = r35
            r0 = r5
            r1 = r32
            r25 = r31
            r2 = r3
            r26 = r3
            r3 = r33
            r22 = r4
            r4 = r16
            r28 = r37
            r27 = r5
            r5 = r24
            r29 = r34
            r23 = r6
            r6 = r36
            r31 = r7
            r7 = r40
            r8 = r39
            r9 = r23
            r10 = r31
            r11 = r19
            r12 = r20
            kotlin.jvm.functions.Function2 r8 = rememberLazyGridMeasurePolicy(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.setVertical$foundation_release(r15)
            r9 = r31
            r10 = r27
            r0 = r28
            ScrollPositionUpdater(r10, r13, r9, r0)
            if (r15 == 0) goto L_0x02ce
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x02d0
        L_0x02ce:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x02d0:
            r11 = r0
            androidx.compose.ui.layout.RemeasurementModifier r0 = r32.getRemeasurementModifier$foundation_release()
            r12 = r29
            androidx.compose.ui.Modifier r0 = r12.then(r0)
            androidx.compose.foundation.lazy.AwaitFirstLayoutModifier r1 = r32.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r1 = r0.then(r1)
            int r0 = r22 >> 9
            r7 = r0 & r17
            r2 = r10
            r3 = r18
            r4 = r11
            r5 = r38
            r6 = r9
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ClipScrollableContainerKt.clipScrollableContainer(r0, r11)
            r3 = r26
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.OverscrollKt.overscroll(r0, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r1 = r9.consume(r1)
            androidx.compose.ui.unit.LayoutDirection r1 = (androidx.compose.ui.unit.LayoutDirection) r1
            r7 = r24
            r2 = r25
            boolean r5 = r2.reverseDirection(r1, r11, r7)
            androidx.compose.foundation.interaction.MutableInteractionSource r17 = r32.getInternalInteractionSource$foundation_release()
            r1 = r32
            r2 = r11
            r4 = r38
            r6 = r21
            r11 = r7
            r7 = r17
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.gestures.ScrollableKt.scrollable(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r3 = r32.getPrefetchState$foundation_release()
            r6 = 0
            r7 = 0
            r1 = r10
            r4 = r8
            r5 = r9
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0335
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0335:
            r5 = r11
            r1 = r12
            r4 = r16
            r7 = r21
        L_0x033b:
            androidx.compose.runtime.ScopeUpdateScope r12 = r9.endRestartGroup()
            if (r12 != 0) goto L_0x0342
            goto L_0x0365
        L_0x0342:
            androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1 r11 = new androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1
            r0 = r11
            r2 = r32
            r3 = r33
            r6 = r36
            r8 = r38
            r9 = r39
            r10 = r40
            r15 = r11
            r11 = r41
            r14 = r12
            r12 = r43
            r13 = r44
            r30 = r14
            r14 = r45
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r30
            r0.updateScope(r15)
        L_0x0365:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void ScrollPositionUpdater(LazyGridItemProvider lazyGridItemProvider, LazyGridState lazyGridState, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(950944068);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) lazyGridItemProvider)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) lazyGridState)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if ((i12 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(950944068, i11, -1, "androidx.compose.foundation.lazy.grid.ScrollPositionUpdater (LazyGrid.kt:140)");
            }
            if (lazyGridItemProvider.getItemCount() > 0) {
                lazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyGridKt$ScrollPositionUpdater$1(lazyGridItemProvider, lazyGridState, i11));
        }
    }

    /* access modifiers changed from: private */
    public static final void refreshOverscrollInfo(OverscrollEffect overscrollEffect, LazyGridMeasureResult lazyGridMeasureResult) {
        Object obj;
        boolean z11;
        LazyMeasuredItem[] items;
        boolean canScrollForward = lazyGridMeasureResult.getCanScrollForward();
        LazyMeasuredLine firstVisibleLine = lazyGridMeasureResult.getFirstVisibleLine();
        boolean z12 = false;
        if (firstVisibleLine == null || (items = firstVisibleLine.getItems()) == null || (obj = (LazyMeasuredItem) ArraysKt___ArraysKt.firstOrNull((T[]) items)) == null) {
            obj = 0;
        }
        if (!Intrinsics.areEqual(obj, (Object) 0) || lazyGridMeasureResult.getFirstVisibleLineScrollOffset() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (canScrollForward || z11) {
            z12 = true;
        }
        overscrollEffect.setEnabled(z12);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1} */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (r1 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0072;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final kotlin.jvm.functions.Function2<androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.ui.layout.MeasureResult> rememberLazyGridMeasurePolicy(androidx.compose.foundation.lazy.grid.LazyGridItemProvider r16, androidx.compose.foundation.lazy.grid.LazyGridState r17, androidx.compose.foundation.OverscrollEffect r18, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super androidx.compose.ui.unit.Constraints, ? extends java.util.List<java.lang.Integer>> r19, androidx.compose.foundation.layout.PaddingValues r20, boolean r21, boolean r22, androidx.compose.foundation.layout.Arrangement.Horizontal r23, androidx.compose.foundation.layout.Arrangement.Vertical r24, androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r0 = r26
            r1 = r28
            r2 = 1958911962(0x74c29fda, float:1.2335788E32)
            r0.startReplaceableGroup(r2)
            r3 = r1 & 128(0x80, float:1.794E-43)
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r13 = r4
            goto L_0x0013
        L_0x0011:
            r13 = r23
        L_0x0013:
            r1 = r1 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0019
            r12 = r4
            goto L_0x001b
        L_0x0019:
            r12 = r24
        L_0x001b:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0029
            r1 = -1
            java.lang.String r3 = "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:151)"
            r4 = r27
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r4, r1, r3)
        L_0x0029:
            r1 = 9
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r17
            r4 = 1
            r2[r4] = r18
            r4 = 2
            r2[r4] = r19
            r4 = 3
            r2[r4] = r20
            r4 = 4
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r21)
            r2[r4] = r5
            r4 = 5
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r22)
            r2[r4] = r5
            r4 = 6
            r2[r4] = r13
            r4 = 7
            r2[r4] = r12
            r4 = 8
            r2[r4] = r25
            r4 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r0.startReplaceableGroup(r4)
            r4 = r3
        L_0x0058:
            if (r3 >= r1) goto L_0x0064
            r5 = r2[r3]
            boolean r5 = r0.changed((java.lang.Object) r5)
            r4 = r4 | r5
            int r3 = r3 + 1
            goto L_0x0058
        L_0x0064:
            java.lang.Object r1 = r26.rememberedValue()
            if (r4 != 0) goto L_0x0072
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x008b
        L_0x0072:
            androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1 r1 = new androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
            r5 = r1
            r6 = r22
            r7 = r20
            r8 = r21
            r9 = r17
            r10 = r16
            r11 = r19
            r14 = r25
            r15 = r18
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0.updateRememberedValue(r1)
        L_0x008b:
            r26.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0099
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0099:
            r26.endReplaceableGroup()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.rememberLazyGridMeasurePolicy(androidx.compose.foundation.lazy.grid.LazyGridItemProvider, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.OverscrollEffect, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator, androidx.compose.runtime.Composer, int, int):kotlin.jvm.functions.Function2");
    }
}
