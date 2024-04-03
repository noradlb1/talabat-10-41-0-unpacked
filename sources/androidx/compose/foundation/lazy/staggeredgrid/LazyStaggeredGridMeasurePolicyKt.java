package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0001\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u001d\u0010\u0014\u001a\u0019\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u0001¢\u0006\u0002\b\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a,\u0010\u001a\u001a\u00020\u001b*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a,\u0010\u001f\u001a\u00020\u001b*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a$\u0010 \u001a\u00020\u001b*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002ø\u0001\u0000¢\u0006\u0002\u0010!\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"rememberStaggeredGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "slotSizesSums", "Landroidx/compose/ui/unit/Density;", "", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "afterPadding", "Landroidx/compose/ui/unit/Dp;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "startPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridMeasurePolicyKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            iArr[Orientation.Vertical.ordinal()] = 1;
            iArr[Orientation.Horizontal.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    public static final float afterPadding(PaddingValues paddingValues, Orientation orientation, boolean z11, LayoutDirection layoutDirection) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            } else if (z11) {
                return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            } else {
                return PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            }
        } else if (z11) {
            return paddingValues.m499calculateTopPaddingD9Ej5fM();
        } else {
            return paddingValues.m496calculateBottomPaddingD9Ej5fM();
        }
    }

    /* access modifiers changed from: private */
    public static final float beforePadding(PaddingValues paddingValues, Orientation orientation, boolean z11, LayoutDirection layoutDirection) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            } else if (z11) {
                return PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            } else {
                return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            }
        } else if (z11) {
            return paddingValues.m496calculateBottomPaddingD9Ej5fM();
        } else {
            return paddingValues.m499calculateTopPaddingD9Ej5fM();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x008f, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0091;
     */
    @androidx.compose.foundation.ExperimentalFoundationApi
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.jvm.functions.Function2<androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult> rememberStaggeredGridMeasurePolicy(@org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r14, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider r15, @org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.PaddingValues r16, boolean r17, @org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.Orientation r18, @org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.Arrangement.Vertical r19, @org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.Arrangement.Horizontal r20, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super androidx.compose.ui.unit.Constraints, int[]> r21, @org.jetbrains.annotations.NotNull androidx.compose.foundation.OverscrollEffect r22, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r23, int r24) {
        /*
            r3 = r14
            r8 = r15
            r4 = r16
            r1 = r18
            r6 = r19
            r7 = r20
            r2 = r21
            r9 = r22
            r10 = r23
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "itemProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "contentPadding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "orientation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "verticalArrangement"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "horizontalArrangement"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "slotSizesSums"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "overscrollEffect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1688989793(0x64abf061, float:2.5373715E22)
            r10.startReplaceableGroup(r0)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x004c
            r5 = -1
            java.lang.String r11 = "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:40)"
            r12 = r24
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r5, r11)
        L_0x004c:
            r0 = 9
            java.lang.Object[] r5 = new java.lang.Object[r0]
            r11 = 0
            r5[r11] = r3
            r12 = 1
            r5[r12] = r8
            r12 = 2
            r5[r12] = r4
            r12 = 3
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r17)
            r5[r12] = r13
            r12 = 4
            r5[r12] = r1
            r12 = 5
            r5[r12] = r6
            r12 = 6
            r5[r12] = r7
            r12 = 7
            r5[r12] = r2
            r12 = 8
            r5[r12] = r9
            r12 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r10.startReplaceableGroup(r12)
            r12 = r11
        L_0x0077:
            if (r11 >= r0) goto L_0x0083
            r13 = r5[r11]
            boolean r13 = r10.changed((java.lang.Object) r13)
            r12 = r12 | r13
            int r11 = r11 + 1
            goto L_0x0077
        L_0x0083:
            java.lang.Object r0 = r23.rememberedValue()
            if (r12 != 0) goto L_0x0091
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r0 != r5) goto L_0x00aa
        L_0x0091:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1 r11 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1
            r0 = r11
            r1 = r18
            r2 = r21
            r3 = r14
            r4 = r16
            r5 = r17
            r6 = r19
            r7 = r20
            r8 = r15
            r9 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.updateRememberedValue(r11)
        L_0x00aa:
            r23.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00b8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00b8:
            r23.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt.rememberStaggeredGridMeasurePolicy(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.Orientation, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function2, androidx.compose.foundation.OverscrollEffect, androidx.compose.runtime.Composer, int):kotlin.jvm.functions.Function2");
    }

    /* access modifiers changed from: private */
    public static final float startPadding(PaddingValues paddingValues, Orientation orientation, LayoutDirection layoutDirection) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i11 == 1) {
            return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
        }
        if (i11 == 2) {
            return paddingValues.m499calculateTopPaddingD9Ej5fM();
        }
        throw new NoWhenBranchMatchedException();
    }
}
