package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001a\u001d\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002\u001a\u0001\u0010$\u001a\u0019\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%¢\u0006\u0002\b\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020,H\u0003ø\u0001\u0000¢\u0006\u0002\u0010-\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)V", "refreshOverscrollInfo", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "result", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;Landroidx/compose/runtime/Composer;III)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyListKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0131  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyList(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r32, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.LazyListState r33, @org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.PaddingValues r34, boolean r35, boolean r36, @org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.FlingBehavior r37, boolean r38, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment.Horizontal r39, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Vertical r40, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment.Vertical r41, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Horizontal r42, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r43, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r44, int r45, int r46, int r47) {
        /*
            r1 = r32
            r0 = r33
            r15 = r34
            r14 = r35
            r13 = r36
            r12 = r37
            r11 = r43
            r10 = r45
            r9 = r47
            java.lang.String r2 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "contentPadding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            java.lang.String r2 = "flingBehavior"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r2)
            java.lang.String r2 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r2)
            r2 = 955299798(0x38f0b7d6, float:1.1478334E-4)
            r3 = r44
            androidx.compose.runtime.Composer r8 = r3.startRestartGroup(r2)
            r3 = r9 & 1
            if (r3 == 0) goto L_0x003b
            r3 = r10 | 6
            goto L_0x004b
        L_0x003b:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x004a
            boolean r3 = r8.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0047
            r3 = 4
            goto L_0x0048
        L_0x0047:
            r3 = 2
        L_0x0048:
            r3 = r3 | r10
            goto L_0x004b
        L_0x004a:
            r3 = r10
        L_0x004b:
            r6 = r9 & 2
            r16 = 16
            if (r6 == 0) goto L_0x0054
            r3 = r3 | 48
            goto L_0x0064
        L_0x0054:
            r6 = r10 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0064
            boolean r6 = r8.changed((java.lang.Object) r0)
            if (r6 == 0) goto L_0x0061
            r6 = 32
            goto L_0x0063
        L_0x0061:
            r6 = r16
        L_0x0063:
            r3 = r3 | r6
        L_0x0064:
            r6 = r9 & 4
            if (r6 == 0) goto L_0x006b
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x007b
        L_0x006b:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x007b
            boolean r6 = r8.changed((java.lang.Object) r15)
            if (r6 == 0) goto L_0x0078
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x007a
        L_0x0078:
            r6 = 128(0x80, float:1.794E-43)
        L_0x007a:
            r3 = r3 | r6
        L_0x007b:
            r6 = r9 & 8
            if (r6 == 0) goto L_0x0082
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0092
        L_0x0082:
            r6 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0092
            boolean r6 = r8.changed((boolean) r14)
            if (r6 == 0) goto L_0x008f
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0091
        L_0x008f:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0091:
            r3 = r3 | r6
        L_0x0092:
            r6 = r9 & 16
            r18 = 57344(0xe000, float:8.0356E-41)
            if (r6 == 0) goto L_0x009c
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ac
        L_0x009c:
            r6 = r10 & r18
            if (r6 != 0) goto L_0x00ac
            boolean r6 = r8.changed((boolean) r13)
            if (r6 == 0) goto L_0x00a9
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ab
        L_0x00a9:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x00ab:
            r3 = r3 | r6
        L_0x00ac:
            r6 = r9 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r6 == 0) goto L_0x00b6
            r6 = 196608(0x30000, float:2.75506E-40)
        L_0x00b4:
            r3 = r3 | r6
            goto L_0x00c6
        L_0x00b6:
            r6 = r10 & r17
            if (r6 != 0) goto L_0x00c6
            boolean r6 = r8.changed((java.lang.Object) r12)
            if (r6 == 0) goto L_0x00c3
            r6 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00c3:
            r6 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b4
        L_0x00c6:
            r6 = r9 & 64
            r19 = 3670016(0x380000, float:5.142788E-39)
            if (r6 == 0) goto L_0x00d0
            r6 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r6
            goto L_0x00e4
        L_0x00d0:
            r6 = r10 & r19
            if (r6 != 0) goto L_0x00e4
            r6 = r38
            boolean r20 = r8.changed((boolean) r6)
            if (r20 == 0) goto L_0x00df
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r3 = r3 | r20
            goto L_0x00e6
        L_0x00e4:
            r6 = r38
        L_0x00e6:
            r4 = r9 & 128(0x80, float:1.794E-43)
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            if (r4 == 0) goto L_0x00f3
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r21
            r5 = r39
            goto L_0x0106
        L_0x00f3:
            r21 = r10 & r20
            r5 = r39
            if (r21 != 0) goto L_0x0106
            boolean r22 = r8.changed((java.lang.Object) r5)
            if (r22 == 0) goto L_0x0102
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0104
        L_0x0102:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x0104:
            r3 = r3 | r22
        L_0x0106:
            r7 = r9 & 256(0x100, float:3.59E-43)
            r23 = 234881024(0xe000000, float:1.5777218E-30)
            if (r7 == 0) goto L_0x0113
            r24 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r24
            r2 = r40
            goto L_0x0126
        L_0x0113:
            r24 = r10 & r23
            r2 = r40
            if (r24 != 0) goto L_0x0126
            boolean r25 = r8.changed((java.lang.Object) r2)
            if (r25 == 0) goto L_0x0122
            r25 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0124
        L_0x0122:
            r25 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0124:
            r3 = r3 | r25
        L_0x0126:
            r2 = r9 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0131
            r25 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r25
            r5 = r41
            goto L_0x0146
        L_0x0131:
            r25 = 1879048192(0x70000000, float:1.58456325E29)
            r25 = r10 & r25
            r5 = r41
            if (r25 != 0) goto L_0x0146
            boolean r25 = r8.changed((java.lang.Object) r5)
            if (r25 == 0) goto L_0x0142
            r25 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0144
        L_0x0142:
            r25 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0144:
            r3 = r3 | r25
        L_0x0146:
            r5 = r9 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x014f
            r21 = r46 | 6
            r6 = r42
            goto L_0x0165
        L_0x014f:
            r25 = r46 & 14
            r6 = r42
            if (r25 != 0) goto L_0x0163
            boolean r25 = r8.changed((java.lang.Object) r6)
            if (r25 == 0) goto L_0x015e
            r21 = 4
            goto L_0x0160
        L_0x015e:
            r21 = 2
        L_0x0160:
            r21 = r46 | r21
            goto L_0x0165
        L_0x0163:
            r21 = r46
        L_0x0165:
            r6 = r9 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x016c
            r21 = r21 | 48
            goto L_0x017a
        L_0x016c:
            r6 = r46 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x017a
            boolean r6 = r8.changed((java.lang.Object) r11)
            if (r6 == 0) goto L_0x0178
            r16 = 32
        L_0x0178:
            r21 = r21 | r16
        L_0x017a:
            r6 = r21
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r3 & r16
            r10 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r10) goto L_0x01a3
            r9 = r6 & 91
            r10 = 18
            if (r9 != r10) goto L_0x01a3
            boolean r9 = r8.getSkipping()
            if (r9 != 0) goto L_0x0193
            goto L_0x01a3
        L_0x0193:
            r8.skipToGroupEnd()
            r9 = r40
            r10 = r41
            r26 = r42
            r11 = r8
            r15 = r14
            r8 = r39
            r14 = r1
            goto L_0x0367
        L_0x01a3:
            r9 = 0
            if (r4 == 0) goto L_0x01a9
            r21 = r9
            goto L_0x01ab
        L_0x01a9:
            r21 = r39
        L_0x01ab:
            if (r7 == 0) goto L_0x01b0
            r22 = r9
            goto L_0x01b2
        L_0x01b0:
            r22 = r40
        L_0x01b2:
            if (r2 == 0) goto L_0x01b7
            r25 = r9
            goto L_0x01b9
        L_0x01b7:
            r25 = r41
        L_0x01b9:
            if (r5 == 0) goto L_0x01be
            r26 = r9
            goto L_0x01c0
        L_0x01be:
            r26 = r42
        L_0x01c0:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01ce
            java.lang.String r2 = "androidx.compose.foundation.lazy.LazyList (LazyList.kt:50)"
            r4 = 955299798(0x38f0b7d6, float:1.1478334E-4)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r3, r6, r2)
        L_0x01ce:
            androidx.compose.foundation.gestures.ScrollableDefaults r10 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r9 = 6
            androidx.compose.foundation.OverscrollEffect r7 = r10.overscrollEffect(r8, r9)
            int r5 = r3 >> 3
            r2 = r5 & 14
            r4 = r6 & 112(0x70, float:1.57E-43)
            r4 = r4 | r2
            androidx.compose.foundation.lazy.LazyListItemProvider r4 = androidx.compose.foundation.lazy.LazyListItemProviderKt.rememberLazyListItemProvider(r0, r11, r8, r4)
            r9 = r5 & 896(0x380, float:1.256E-42)
            r2 = r2 | r9
            r9 = r5 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r2
            r2 = r33
            r1 = r3
            r3 = r4
            r40 = r4
            r4 = r35
            r16 = r5
            r5 = r36
            r24 = r6
            r6 = r8
            r41 = r7
            r7 = r9
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r27 = androidx.compose.foundation.lazy.LazySemanticsKt.rememberLazyListSemanticState(r2, r3, r4, r5, r6, r7)
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r2)
            java.lang.Object r2 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r3.getEmpty()
            if (r2 != r4) goto L_0x0216
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r2 = new androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo
            r2.<init>()
            r8.updateRememberedValue(r2)
        L_0x0216:
            r8.endReplaceableGroup()
            r9 = r2
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r9 = (androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo) r9
            r2 = 773894976(0x2e20b340, float:3.6538994E-11)
            r8.startReplaceableGroup(r2)
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r2)
            java.lang.Object r2 = r8.rememberedValue()
            java.lang.Object r4 = r3.getEmpty()
            if (r2 != r4) goto L_0x0241
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r8)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r4 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r4.<init>(r2)
            r8.updateRememberedValue(r4)
            r2 = r4
        L_0x0241:
            r8.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            kotlinx.coroutines.CoroutineScope r2 = r2.getCoroutineScope()
            r8.endReplaceableGroup()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r36)
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r8.startReplaceableGroup(r5)
            boolean r5 = r8.changed((java.lang.Object) r0)
            boolean r4 = r8.changed((java.lang.Object) r4)
            r4 = r4 | r5
            java.lang.Object r5 = r8.rememberedValue()
            if (r4 != 0) goto L_0x026c
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x0274
        L_0x026c:
            androidx.compose.foundation.lazy.LazyListItemPlacementAnimator r5 = new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator
            r5.<init>(r2, r13)
            r8.updateRememberedValue(r5)
        L_0x0274:
            r8.endReplaceableGroup()
            r7 = r5
            androidx.compose.foundation.lazy.LazyListItemPlacementAnimator r7 = (androidx.compose.foundation.lazy.LazyListItemPlacementAnimator) r7
            r0.setPlacementAnimator$foundation_release(r7)
            r6 = r1 & 112(0x70, float:1.57E-43)
            int r28 = androidx.compose.runtime.collection.MutableVector.$stable
            int r2 = r28 << 6
            r2 = r2 | r6
            int r3 = r1 << 6
            r4 = r3 & r18
            r2 = r2 | r4
            r4 = r3 & r17
            r2 = r2 | r4
            r3 = r3 & r19
            r2 = r2 | r3
            r3 = r1 & r20
            r2 = r2 | r3
            r3 = r16 & r23
            r2 = r2 | r3
            int r3 = r24 << 27
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r4
            r16 = r2 | r3
            int r2 = r1 >> 24
            r2 = r2 & 14
            r17 = r2 | 64
            r19 = 0
            r2 = r40
            r3 = r33
            r4 = r9
            r5 = r41
            r42 = r1
            r1 = r6
            r6 = r34
            r20 = r7
            r7 = r35
            r44 = r8
            r8 = r36
            r39 = r9
            r23 = 6
            r9 = r21
            r29 = r10
            r10 = r25
            r11 = r26
            r12 = r22
            r13 = r20
            r14 = r44
            r15 = r16
            r16 = r17
            r17 = r19
            kotlin.jvm.functions.Function2 r10 = rememberLazyListMeasurePolicy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r12 = r40
            r11 = r44
            ScrollPositionUpdater(r12, r0, r11, r1)
            if (r36 == 0) goto L_0x02e0
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x02e2
        L_0x02e0:
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x02e2:
            r13 = r2
            androidx.compose.ui.layout.RemeasurementModifier r2 = r33.getRemeasurementModifier$foundation_release()
            r14 = r32
            r15 = r42
            androidx.compose.ui.Modifier r2 = r14.then(r2)
            androidx.compose.foundation.lazy.AwaitFirstLayoutModifier r3 = r33.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r3 = r2.then(r3)
            int r2 = r15 >> 6
            r9 = r2 & r18
            r4 = r12
            r5 = r27
            r6 = r13
            r7 = r38
            r8 = r11
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.ClipScrollableContainerKt.clipScrollableContainer(r2, r13)
            int r3 = r28 << 6
            r3 = r3 | r1
            r4 = r15 & 7168(0x1c00, float:1.0045E-41)
            r7 = r3 | r4
            r3 = r33
            r4 = r39
            r5 = r35
            r6 = r11
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.lazy.LazyBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(r2, r3, r4, r5, r6, r7)
            int r3 = r28 << 6
            r1 = r1 | r3
            r3 = r39
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.lazy.LazyListPinningModifierKt.lazyListPinningModifier(r2, r0, r3, r11, r1)
            r5 = r41
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.OverscrollKt.overscroll(r1, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r1 = r11.consume(r1)
            androidx.compose.ui.unit.LayoutDirection r1 = (androidx.compose.ui.unit.LayoutDirection) r1
            r15 = r35
            r3 = r29
            boolean r7 = r3.reverseDirection(r1, r13, r15)
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r33.getInternalInteractionSource$foundation_release()
            r3 = r33
            r4 = r13
            r6 = r38
            r8 = r37
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.gestures.ScrollableKt.scrollable(r2, r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r5 = r33.getPrefetchState$foundation_release()
            r8 = 0
            r9 = 0
            r3 = r12
            r6 = r10
            r7 = r11
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout(r3, r4, r5, r6, r7, r8, r9)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0361
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0361:
            r8 = r21
            r9 = r22
            r10 = r25
        L_0x0367:
            androidx.compose.runtime.ScopeUpdateScope r13 = r11.endRestartGroup()
            if (r13 != 0) goto L_0x036e
            goto L_0x0399
        L_0x036e:
            androidx.compose.foundation.lazy.LazyListKt$LazyList$1 r12 = new androidx.compose.foundation.lazy.LazyListKt$LazyList$1
            r0 = r12
            r1 = r32
            r2 = r33
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r37
            r7 = r38
            r11 = r26
            r15 = r12
            r12 = r43
            r14 = r13
            r13 = r45
            r30 = r14
            r14 = r46
            r31 = r15
            r15 = r47
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0 = r30
            r1 = r31
            r0.updateScope(r1)
        L_0x0399:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.LazyList(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    @ExperimentalFoundationApi
    @Composable
    public static final void ScrollPositionUpdater(LazyListItemProvider lazyListItemProvider, LazyListState lazyListState, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(3173830);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) lazyListItemProvider)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) lazyListState)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if ((i12 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(3173830, i11, -1, "androidx.compose.foundation.lazy.ScrollPositionUpdater (LazyList.kt:141)");
            }
            if (lazyListItemProvider.getItemCount() > 0) {
                lazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyListKt$ScrollPositionUpdater$1(lazyListItemProvider, lazyListState, i11));
        }
    }

    /* access modifiers changed from: private */
    public static final void refreshOverscrollInfo(OverscrollEffect overscrollEffect, LazyListMeasureResult lazyListMeasureResult) {
        int i11;
        boolean z11;
        boolean canScrollForward = lazyListMeasureResult.getCanScrollForward();
        LazyMeasuredItem firstVisibleItem = lazyListMeasureResult.getFirstVisibleItem();
        boolean z12 = false;
        if (firstVisibleItem != null) {
            i11 = firstVisibleItem.getIndex();
        } else {
            i11 = 0;
        }
        if (i11 == 0 && lazyListMeasureResult.getFirstVisibleItemScrollOffset() == 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (canScrollForward || z11) {
            z12 = true;
        }
        overscrollEffect.setEnabled(z12);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1} */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        if (r1 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x008c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.foundation.ExperimentalFoundationApi
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final kotlin.jvm.functions.Function2<androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.ui.layout.MeasureResult> rememberLazyListMeasurePolicy(androidx.compose.foundation.lazy.LazyListItemProvider r18, androidx.compose.foundation.lazy.LazyListState r19, androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r20, androidx.compose.foundation.OverscrollEffect r21, androidx.compose.foundation.layout.PaddingValues r22, boolean r23, boolean r24, androidx.compose.ui.Alignment.Horizontal r25, androidx.compose.ui.Alignment.Vertical r26, androidx.compose.foundation.layout.Arrangement.Horizontal r27, androidx.compose.foundation.layout.Arrangement.Vertical r28, androidx.compose.foundation.lazy.LazyListItemPlacementAnimator r29, androidx.compose.runtime.Composer r30, int r31, int r32, int r33) {
        /*
            r0 = r30
            r1 = r33
            r2 = -1404987696(0xffffffffac4196d0, float:-2.7510667E-12)
            r0.startReplaceableGroup(r2)
            r3 = r1 & 128(0x80, float:1.794E-43)
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r15 = r4
            goto L_0x0013
        L_0x0011:
            r15 = r25
        L_0x0013:
            r3 = r1 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x001a
            r16 = r4
            goto L_0x001c
        L_0x001a:
            r16 = r26
        L_0x001c:
            r3 = r1 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0022
            r12 = r4
            goto L_0x0024
        L_0x0022:
            r12 = r27
        L_0x0024:
            r1 = r1 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x002a
            r11 = r4
            goto L_0x002c
        L_0x002a:
            r11 = r28
        L_0x002c:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x003b
            java.lang.String r1 = "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:152)"
            r3 = r31
            r4 = r32
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r3, r4, r1)
        L_0x003b:
            r1 = 11
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r19
            r4 = 1
            r2[r4] = r20
            r4 = 2
            r2[r4] = r21
            r4 = 3
            r2[r4] = r22
            r4 = 4
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r23)
            r2[r4] = r5
            r4 = 5
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r24)
            r2[r4] = r5
            r4 = 6
            r2[r4] = r15
            r4 = 7
            r2[r4] = r16
            r4 = 8
            r2[r4] = r12
            r4 = 9
            r2[r4] = r11
            r4 = 10
            r2[r4] = r29
            r4 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r0.startReplaceableGroup(r4)
            r4 = r3
        L_0x0072:
            if (r3 >= r1) goto L_0x007e
            r5 = r2[r3]
            boolean r5 = r0.changed((java.lang.Object) r5)
            r4 = r4 | r5
            int r3 = r3 + 1
            goto L_0x0072
        L_0x007e:
            java.lang.Object r1 = r30.rememberedValue()
            if (r4 != 0) goto L_0x008c
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x00a5
        L_0x008c:
            androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1 r1 = new androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
            r5 = r1
            r6 = r24
            r7 = r22
            r8 = r23
            r9 = r19
            r10 = r18
            r13 = r29
            r14 = r20
            r17 = r21
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r0.updateRememberedValue(r1)
        L_0x00a5:
            r30.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00b3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00b3:
            r30.endReplaceableGroup()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.rememberLazyListMeasurePolicy(androidx.compose.foundation.lazy.LazyListItemProvider, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo, androidx.compose.foundation.OverscrollEffect, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.lazy.LazyListItemPlacementAnimator, androidx.compose.runtime.Composer, int, int, int):kotlin.jvm.functions.Function2");
    }
}
