package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.IntProgression;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001aØ\u0001\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2/\u0010+\u001a+\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-¢\u0006\u0002\b0\u0012\u0004\u0012\u0002010,H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00064"}, d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "items", "", "Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "itemsCount", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "firstVisibleItemIndex", "Landroidx/compose/foundation/lazy/DataIndex;", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-7Xnphek", "(ILandroidx/compose/foundation/lazy/LazyMeasuredItemProvider;IIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyListMeasureKt {
    private static final List<LazyListPositionedItem> calculateItemsOffsets(List<LazyMeasuredItem> list, List<LazyMeasuredItem> list2, List<LazyMeasuredItem> list3, int i11, int i12, int i13, int i14, int i15, boolean z11, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z12, Density density) {
        int i16;
        boolean z13;
        boolean z14;
        List<LazyMeasuredItem> list4 = list;
        int i17 = i11;
        int i18 = i12;
        Arrangement.Vertical vertical2 = vertical;
        boolean z15 = z12;
        int i19 = i14;
        if (z11) {
            i16 = i18;
        } else {
            i16 = i17;
        }
        boolean z16 = true;
        if (i13 < Math.min(i16, i19)) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            if (i15 == 0) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (!z14) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z13) {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                z16 = false;
            }
            if (z16) {
                int size = list.size();
                int[] iArr = new int[size];
                for (int i21 = 0; i21 < size; i21++) {
                    iArr[i21] = list.get(calculateItemsOffsets$reverseAware(i21, z15, size)).getSize();
                }
                int[] iArr2 = new int[size];
                for (int i22 = 0; i22 < size; i22++) {
                    iArr2[i22] = 0;
                }
                if (!z11) {
                    Density density2 = density;
                    if (horizontal != null) {
                        horizontal.arrange(density, i16, iArr, LayoutDirection.Ltr, iArr2);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else if (vertical2 != null) {
                    vertical2.arrange(density, i16, iArr, iArr2);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                IntProgression indices = ArraysKt___ArraysKt.getIndices(iArr2);
                if (z15) {
                    indices = RangesKt___RangesKt.reversed(indices);
                }
                int first = indices.getFirst();
                int last = indices.getLast();
                int step = indices.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    while (true) {
                        int i23 = iArr2[first];
                        LazyMeasuredItem lazyMeasuredItem = list.get(calculateItemsOffsets$reverseAware(first, z15, size));
                        if (z15) {
                            i23 = (i16 - i23) - lazyMeasuredItem.getSize();
                        }
                        arrayList.add(lazyMeasuredItem.position(i23, i17, i18));
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            int size2 = list2.size();
            int i24 = i15;
            for (int i25 = 0; i25 < size2; i25++) {
                List<LazyMeasuredItem> list5 = list2;
                LazyMeasuredItem lazyMeasuredItem2 = list2.get(i25);
                i24 -= lazyMeasuredItem2.getSizeWithSpacings();
                arrayList.add(lazyMeasuredItem2.position(i24, i17, i18));
            }
            int size3 = list.size();
            int i26 = i15;
            for (int i27 = 0; i27 < size3; i27++) {
                LazyMeasuredItem lazyMeasuredItem3 = list.get(i27);
                arrayList.add(lazyMeasuredItem3.position(i26, i17, i18));
                i26 += lazyMeasuredItem3.getSizeWithSpacings();
            }
            int size4 = list3.size();
            for (int i28 = 0; i28 < size4; i28++) {
                LazyMeasuredItem lazyMeasuredItem4 = list3.get(i28);
                arrayList.add(lazyMeasuredItem4.position(i26, i17, i18));
                i26 += lazyMeasuredItem4.getSizeWithSpacings();
            }
        }
        return arrayList;
    }

    private static final int calculateItemsOffsets$reverseAware(int i11, boolean z11, int i12) {
        return !z11 ? i11 : (i12 - i11) - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v10, resolved type: androidx.compose.foundation.lazy.LazyMeasuredItem} */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01fd, code lost:
        r37 = r11;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0319  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x028a  */
    @org.jetbrains.annotations.NotNull
    /* renamed from: measureLazyList-7Xnphek  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.LazyListMeasureResult m638measureLazyList7Xnphek(int r32, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.LazyMeasuredItemProvider r33, int r34, int r35, int r36, int r37, int r38, float r39, long r40, boolean r42, @org.jetbrains.annotations.NotNull java.util.List<java.lang.Integer> r43, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Vertical r44, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Horizontal r45, boolean r46, @org.jetbrains.annotations.NotNull androidx.compose.ui.unit.Density r47, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.LazyListItemPlacementAnimator r48, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r49, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r50) {
        /*
            r9 = r32
            r6 = r33
            r7 = r34
            r3 = r35
            r0 = r40
            r2 = r43
            r4 = r49
            r8 = r50
            java.lang.String r5 = "itemProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r5)
            java.lang.String r5 = "headerIndexes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
            java.lang.String r5 = "density"
            r15 = r47
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r5)
            java.lang.String r5 = "placementAnimator"
            r14 = r48
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r5)
            java.lang.String r5 = "beyondBoundsInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            java.lang.String r5 = "layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r5)
            r23 = 1
            r5 = 0
            if (r3 < 0) goto L_0x003a
            r10 = r23
            goto L_0x003b
        L_0x003a:
            r10 = r5
        L_0x003b:
            java.lang.String r11 = "Failed requirement."
            if (r10 == 0) goto L_0x03a0
            if (r36 < 0) goto L_0x0044
            r10 = r23
            goto L_0x0045
        L_0x0044:
            r10 = r5
        L_0x0045:
            if (r10 == 0) goto L_0x0396
            if (r9 > 0) goto L_0x008b
            androidx.compose.foundation.lazy.LazyListMeasureResult r13 = new androidx.compose.foundation.lazy.LazyListMeasureResult
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            int r9 = androidx.compose.ui.unit.Constraints.m5424getMinWidthimpl(r40)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r0 = androidx.compose.ui.unit.Constraints.m5423getMinHeightimpl(r40)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$1 r1 = androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$1.INSTANCE
            java.lang.Object r0 = r8.invoke(r9, r0, r1)
            r8 = r0
            androidx.compose.ui.layout.MeasureResult r8 = (androidx.compose.ui.layout.MeasureResult) r8
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            int r10 = -r3
            int r11 = r7 + r36
            r12 = 0
            if (r42 == 0) goto L_0x0075
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0077
        L_0x0075:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0077:
            r14 = r0
            r0 = r13
            r1 = r2
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r8
            r6 = r9
            r7 = r10
            r8 = r11
            r9 = r12
            r10 = r46
            r11 = r14
            r12 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        L_0x008b:
            r10 = r37
            if (r10 < r9) goto L_0x0097
            int r10 = r9 + -1
            int r10 = androidx.compose.foundation.lazy.DataIndex.m612constructorimpl(r10)
            r11 = r5
            goto L_0x0099
        L_0x0097:
            r11 = r38
        L_0x0099:
            int r12 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r39)
            int r11 = r11 - r12
            int r13 = androidx.compose.foundation.lazy.DataIndex.m612constructorimpl(r5)
            boolean r13 = androidx.compose.foundation.lazy.DataIndex.m615equalsimpl0(r10, r13)
            if (r13 == 0) goto L_0x00ac
            if (r11 >= 0) goto L_0x00ac
            int r12 = r12 + r11
            r11 = r5
        L_0x00ac:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            int r11 = r11 - r3
            int r5 = -r3
            r14 = 0
        L_0x00b4:
            if (r11 >= 0) goto L_0x00e3
            r37 = 0
            int r16 = androidx.compose.foundation.lazy.DataIndex.m612constructorimpl(r37)
            int r16 = r10 - r16
            if (r16 <= 0) goto L_0x00e3
            int r10 = r10 + -1
            int r10 = androidx.compose.foundation.lazy.DataIndex.m612constructorimpl(r10)
            androidx.compose.foundation.lazy.LazyMeasuredItem r15 = r6.m648getAndMeasureZjPyQlc(r10)
            r38 = r10
            r10 = r37
            r13.add(r10, r15)
            int r10 = r15.getCrossAxisSize()
            int r14 = java.lang.Math.max(r14, r10)
            int r10 = r15.getSizeWithSpacings()
            int r11 = r11 + r10
            r10 = r38
            r15 = r47
            goto L_0x00b4
        L_0x00e3:
            if (r11 >= r5) goto L_0x00e7
            int r12 = r12 + r11
            r11 = r5
        L_0x00e7:
            int r11 = r11 + r3
            int r15 = r7 + r36
            r37 = r10
            r16 = r14
            r10 = 0
            int r14 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((int) r15, (int) r10)
            int r10 = -r11
            r17 = r10
            int r10 = r13.size()
            r18 = r37
            r38 = r11
            r11 = 0
        L_0x00ff:
            if (r11 >= r10) goto L_0x0116
            java.lang.Object r19 = r13.get(r11)
            androidx.compose.foundation.lazy.LazyMeasuredItem r19 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r19
            int r18 = r18 + 1
            int r18 = androidx.compose.foundation.lazy.DataIndex.m612constructorimpl(r18)
            int r19 = r19.getSizeWithSpacings()
            int r17 = r17 + r19
            int r11 = r11 + 1
            goto L_0x00ff
        L_0x0116:
            r10 = r38
            r38 = r15
            r11 = r16
            r15 = r17
            r8 = r18
        L_0x0120:
            if (r15 <= r14) goto L_0x0128
            boolean r16 = r13.isEmpty()
            if (r16 == 0) goto L_0x0167
        L_0x0128:
            if (r8 >= r9) goto L_0x0167
            r16 = r14
            androidx.compose.foundation.lazy.LazyMeasuredItem r14 = r6.m648getAndMeasureZjPyQlc(r8)
            int r17 = r14.getSizeWithSpacings()
            int r15 = r15 + r17
            if (r15 > r5) goto L_0x014a
            r25 = r5
            int r5 = r9 + -1
            if (r8 == r5) goto L_0x014c
            int r5 = r8 + 1
            int r5 = androidx.compose.foundation.lazy.DataIndex.m612constructorimpl(r5)
            int r14 = r14.getSizeWithSpacings()
            int r10 = r10 - r14
            goto L_0x015a
        L_0x014a:
            r25 = r5
        L_0x014c:
            int r5 = r14.getCrossAxisSize()
            int r5 = java.lang.Math.max(r11, r5)
            r13.add(r14)
            r11 = r5
            r5 = r37
        L_0x015a:
            int r8 = r8 + 1
            int r8 = androidx.compose.foundation.lazy.DataIndex.m612constructorimpl(r8)
            r37 = r5
            r14 = r16
            r5 = r25
            goto L_0x0120
        L_0x0167:
            r25 = r5
            if (r15 >= r7) goto L_0x01a4
            int r5 = r7 - r15
            int r10 = r10 - r5
            int r15 = r15 + r5
            r8 = r11
            r11 = r37
        L_0x0172:
            if (r10 >= r3) goto L_0x019a
            r14 = 0
            int r16 = androidx.compose.foundation.lazy.DataIndex.m612constructorimpl(r14)
            int r16 = r11 - r16
            if (r16 <= 0) goto L_0x019a
            int r11 = r11 + -1
            int r11 = androidx.compose.foundation.lazy.DataIndex.m612constructorimpl(r11)
            androidx.compose.foundation.lazy.LazyMeasuredItem r7 = r6.m648getAndMeasureZjPyQlc(r11)
            r13.add(r14, r7)
            int r14 = r7.getCrossAxisSize()
            int r8 = java.lang.Math.max(r8, r14)
            int r7 = r7.getSizeWithSpacings()
            int r10 = r10 + r7
            r7 = r34
            goto L_0x0172
        L_0x019a:
            int r12 = r12 + r5
            if (r10 >= 0) goto L_0x01a3
            int r12 = r12 + r10
            int r15 = r15 + r10
            r11 = r8
            r7 = r15
            r10 = 0
            goto L_0x01a5
        L_0x01a3:
            r11 = r8
        L_0x01a4:
            r7 = r15
        L_0x01a5:
            int r5 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r39)
            int r5 = kotlin.math.MathKt__MathJVMKt.getSign((int) r5)
            int r8 = kotlin.math.MathKt__MathJVMKt.getSign((int) r12)
            if (r5 != r8) goto L_0x01c4
            int r5 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r39)
            int r5 = java.lang.Math.abs(r5)
            int r8 = java.lang.Math.abs(r12)
            if (r5 < r8) goto L_0x01c4
            float r5 = (float) r12
            r8 = r5
            goto L_0x01c6
        L_0x01c4:
            r8 = r39
        L_0x01c6:
            int r5 = -r10
            java.lang.Object r12 = kotlin.collections.CollectionsKt___CollectionsKt.first(r13)
            androidx.compose.foundation.lazy.LazyMeasuredItem r12 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r12
            if (r3 <= 0) goto L_0x0203
            int r14 = r13.size()
            r15 = r12
            r12 = r10
            r10 = 0
        L_0x01d6:
            if (r10 >= r14) goto L_0x01fd
            java.lang.Object r16 = r13.get(r10)
            androidx.compose.foundation.lazy.LazyMeasuredItem r16 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r16
            int r3 = r16.getSizeWithSpacings()
            if (r12 == 0) goto L_0x01fd
            if (r3 > r12) goto L_0x01fd
            r37 = r11
            int r11 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r13)
            if (r10 == r11) goto L_0x01ff
            int r12 = r12 - r3
            int r10 = r10 + 1
            java.lang.Object r3 = r13.get(r10)
            r15 = r3
            androidx.compose.foundation.lazy.LazyMeasuredItem r15 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r15
            r3 = r35
            r11 = r37
            goto L_0x01d6
        L_0x01fd:
            r37 = r11
        L_0x01ff:
            r26 = r12
            r3 = r15
            goto L_0x0208
        L_0x0203:
            r37 = r11
            r26 = r10
            r3 = r12
        L_0x0208:
            boolean r10 = r49.hasIntervals()
            if (r10 == 0) goto L_0x0248
            java.lang.Object r10 = kotlin.collections.CollectionsKt___CollectionsKt.first(r13)
            androidx.compose.foundation.lazy.LazyMeasuredItem r10 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r10
            int r10 = r10.getIndex()
            int r11 = measureLazyList_7Xnphek$startIndex(r4, r9)
            if (r10 <= r11) goto L_0x0248
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.Object r11 = kotlin.collections.CollectionsKt___CollectionsKt.first(r13)
            androidx.compose.foundation.lazy.LazyMeasuredItem r11 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r11
            int r11 = r11.getIndex()
            int r11 = r11 + -1
            int r12 = measureLazyList_7Xnphek$startIndex(r4, r9)
            if (r12 > r11) goto L_0x0245
        L_0x0235:
            int r14 = androidx.compose.foundation.lazy.DataIndex.m612constructorimpl(r11)
            androidx.compose.foundation.lazy.LazyMeasuredItem r14 = r6.m648getAndMeasureZjPyQlc(r14)
            r10.add(r14)
            if (r11 == r12) goto L_0x0245
            int r11 = r11 + -1
            goto L_0x0235
        L_0x0245:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            goto L_0x024c
        L_0x0248:
            java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x024c:
            r11 = r10
            boolean r10 = r49.hasIntervals()
            if (r10 == 0) goto L_0x028a
            java.lang.Object r10 = kotlin.collections.CollectionsKt___CollectionsKt.last(r13)
            androidx.compose.foundation.lazy.LazyMeasuredItem r10 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r10
            int r10 = r10.getIndex()
            int r12 = measureLazyList_7Xnphek$endIndex(r4, r9)
            if (r10 >= r12) goto L_0x028a
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.Object r12 = kotlin.collections.CollectionsKt___CollectionsKt.last(r13)
            androidx.compose.foundation.lazy.LazyMeasuredItem r12 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r12
            int r12 = r12.getIndex()
            int r4 = measureLazyList_7Xnphek$endIndex(r4, r9)
        L_0x0276:
            if (r12 >= r4) goto L_0x0286
            int r12 = r12 + 1
            int r14 = androidx.compose.foundation.lazy.DataIndex.m612constructorimpl(r12)
            androidx.compose.foundation.lazy.LazyMeasuredItem r14 = r6.m648getAndMeasureZjPyQlc(r14)
            r10.add(r14)
            goto L_0x0276
        L_0x0286:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r12 = r10
            goto L_0x028f
        L_0x028a:
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r12 = r4
        L_0x028f:
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.first(r13)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x02a8
            boolean r4 = r11.isEmpty()
            if (r4 == 0) goto L_0x02a8
            boolean r4 = r12.isEmpty()
            if (r4 == 0) goto L_0x02a8
            r27 = r23
            goto L_0x02aa
        L_0x02a8:
            r27 = 0
        L_0x02aa:
            if (r42 == 0) goto L_0x02af
            r4 = r37
            goto L_0x02b0
        L_0x02af:
            r4 = r7
        L_0x02b0:
            int r28 = androidx.compose.ui.unit.ConstraintsKt.m5436constrainWidthK40F9xA(r0, r4)
            if (r42 == 0) goto L_0x02b8
            r4 = r7
            goto L_0x02ba
        L_0x02b8:
            r4 = r37
        L_0x02ba:
            int r29 = androidx.compose.ui.unit.ConstraintsKt.m5435constrainHeightK40F9xA(r0, r4)
            r10 = r13
            r30 = r13
            r13 = r28
            r24 = 0
            r14 = r29
            r31 = r38
            r15 = r7
            r16 = r34
            r17 = r5
            r18 = r42
            r19 = r44
            r20 = r45
            r21 = r46
            r22 = r47
            java.util.List r10 = calculateItemsOffsets(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r2
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x02fc
            r0 = r10
            r1 = r33
            r2 = r43
            r15 = r3
            r3 = r35
            r4 = r28
            r11 = r24
            r12 = r25
            r5 = r29
            androidx.compose.foundation.lazy.LazyListPositionedItem r0 = androidx.compose.foundation.lazy.LazyListHeadersKt.findOrComposeLazyListHeader(r0, r1, r2, r3, r4, r5)
            goto L_0x0302
        L_0x02fc:
            r15 = r3
            r11 = r24
            r12 = r25
            r0 = 0
        L_0x0302:
            r13 = r0
            int r1 = (int) r8
            r0 = r48
            r2 = r28
            r3 = r29
            r4 = r46
            r5 = r10
            r6 = r33
            r0.onMeasured(r1, r2, r3, r4, r5, r6)
            r0 = r34
            if (r7 <= r0) goto L_0x0319
            r3 = r23
            goto L_0x031a
        L_0x0319:
            r3 = r11
        L_0x031a:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r28)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r29)
            androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$3 r2 = new androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$3
            r2.<init>(r10, r13)
            r4 = r50
            java.lang.Object r0 = r4.invoke(r0, r1, r2)
            r5 = r0
            androidx.compose.ui.layout.MeasureResult r5 = (androidx.compose.ui.layout.MeasureResult) r5
            if (r27 == 0) goto L_0x0334
            r6 = r10
            goto L_0x037a
        L_0x0334:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r10.size()
            r0.<init>(r1)
            int r1 = r10.size()
            r2 = r11
        L_0x0342:
            if (r2 >= r1) goto L_0x0379
            java.lang.Object r4 = r10.get(r2)
            r6 = r4
            androidx.compose.foundation.lazy.LazyListPositionedItem r6 = (androidx.compose.foundation.lazy.LazyListPositionedItem) r6
            int r7 = r6.getIndex()
            java.lang.Object r14 = kotlin.collections.CollectionsKt___CollectionsKt.first(r30)
            androidx.compose.foundation.lazy.LazyMeasuredItem r14 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r14
            int r14 = r14.getIndex()
            if (r7 < r14) goto L_0x036b
            int r7 = r6.getIndex()
            java.lang.Object r14 = kotlin.collections.CollectionsKt___CollectionsKt.last(r30)
            androidx.compose.foundation.lazy.LazyMeasuredItem r14 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r14
            int r14 = r14.getIndex()
            if (r7 <= r14) goto L_0x036d
        L_0x036b:
            if (r6 != r13) goto L_0x0370
        L_0x036d:
            r6 = r23
            goto L_0x0371
        L_0x0370:
            r6 = r11
        L_0x0371:
            if (r6 == 0) goto L_0x0376
            r0.add(r4)
        L_0x0376:
            int r2 = r2 + 1
            goto L_0x0342
        L_0x0379:
            r6 = r0
        L_0x037a:
            if (r42 == 0) goto L_0x037f
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0381
        L_0x037f:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0381:
            r11 = r0
            androidx.compose.foundation.lazy.LazyListMeasureResult r13 = new androidx.compose.foundation.lazy.LazyListMeasureResult
            r0 = r13
            r1 = r15
            r2 = r26
            r4 = r8
            r7 = r12
            r8 = r31
            r9 = r32
            r10 = r46
            r12 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        L_0x0396:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r11.toString()
            r0.<init>(r1)
            throw r0
        L_0x03a0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r11.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.m638measureLazyList7Xnphek(int, androidx.compose.foundation.lazy.LazyMeasuredItemProvider, int, int, int, int, int, float, long, boolean, java.util.List, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.LazyListItemPlacementAnimator, androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.LazyListMeasureResult");
    }

    private static final int measureLazyList_7Xnphek$endIndex(LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, int i11) {
        return Math.min(lazyListBeyondBoundsInfo.getEnd(), i11 - 1);
    }

    private static final int measureLazyList_7Xnphek$startIndex(LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, int i11) {
        return Math.min(lazyListBeyondBoundsInfo.getStart(), i11 - 1);
    }
}
