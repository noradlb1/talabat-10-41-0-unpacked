package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ap\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001aÒ\u0001\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(2/\u0010)\u001a+\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+¢\u0006\u0002\b.\u0012\u0004\u0012\u00020/0*H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00062"}, d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "lines", "", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredLine;", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "mainAxisAvailableSize", "slotsPerLine", "beforeContentPadding", "afterContentPadding", "firstVisibleLineIndex", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-zIfe3eg", "(ILandroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyGridMeasureKt {
    private static final List<LazyGridPositionedItem> calculateItemsOffsets(List<LazyMeasuredLine> list, int i11, int i12, int i13, int i14, int i15, boolean z11, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z12, Density density) {
        int i16;
        boolean z13;
        List<LazyMeasuredLine> list2 = list;
        int i17 = i11;
        int i18 = i12;
        Arrangement.Vertical vertical2 = vertical;
        boolean z14 = z12;
        int i19 = i14;
        if (z11) {
            i16 = i18;
        } else {
            i16 = i17;
        }
        boolean z15 = true;
        if (i13 < Math.min(i16, i19)) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            if (i15 != 0) {
                z15 = false;
            }
            if (!z15) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        int size = list.size();
        int i21 = 0;
        for (int i22 = 0; i22 < size; i22++) {
            i21 += list.get(i22).getItems().length;
        }
        ArrayList arrayList = new ArrayList(i21);
        if (z13) {
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i23 = 0; i23 < size2; i23++) {
                iArr[i23] = list.get(calculateItemsOffsets$reverseAware(i23, z14, size2)).getMainAxisSize();
            }
            int[] iArr2 = new int[size2];
            for (int i24 = 0; i24 < size2; i24++) {
                iArr2[i24] = 0;
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
            if (z14) {
                indices = RangesKt___RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i25 = iArr2[first];
                    LazyMeasuredLine lazyMeasuredLine = list.get(calculateItemsOffsets$reverseAware(first, z14, size2));
                    if (z14) {
                        i25 = (i16 - i25) - lazyMeasuredLine.getMainAxisSize();
                    }
                    arrayList.addAll(lazyMeasuredLine.position(i25, i11, i18));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list.size();
            int i26 = i15;
            for (int i27 = 0; i27 < size3; i27++) {
                LazyMeasuredLine lazyMeasuredLine2 = list.get(i27);
                arrayList.addAll(lazyMeasuredLine2.position(i26, i11, i18));
                i26 += lazyMeasuredLine2.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }

    private static final int calculateItemsOffsets$reverseAware(int i11, boolean z11, int i12) {
        return !z11 ? i11 : (i12 - i11) - 1;
    }

    @NotNull
    /* renamed from: measureLazyGrid-zIfe3eg  reason: not valid java name */
    public static final LazyGridMeasureResult m699measureLazyGridzIfe3eg(int i11, @NotNull LazyMeasuredLineProvider lazyMeasuredLineProvider, @NotNull LazyMeasuredItemProvider lazyMeasuredItemProvider, int i12, int i13, int i14, int i15, int i16, int i17, float f11, long j11, boolean z11, @Nullable Arrangement.Vertical vertical, @Nullable Arrangement.Horizontal horizontal, boolean z12, @NotNull Density density, @NotNull LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, @NotNull Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i18;
        int i19;
        LazyMeasuredLine lazyMeasuredLine;
        int i21;
        int i22;
        int i23;
        LazyMeasuredLineProvider lazyMeasuredLineProvider2 = lazyMeasuredLineProvider;
        int i24 = i12;
        int i25 = i14;
        long j12 = j11;
        Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function32 = function3;
        Intrinsics.checkNotNullParameter(lazyMeasuredLineProvider2, "measuredLineProvider");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider, "measuredItemProvider");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(lazyGridItemPlacementAnimator, "placementAnimator");
        Intrinsics.checkNotNullParameter(function32, TtmlNode.TAG_LAYOUT);
        if (i25 >= 0) {
            if (!(i15 >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (i11 <= 0) {
                return new LazyGridMeasureResult((LazyMeasuredLine) null, 0, false, 0.0f, (MeasureResult) function32.invoke(Integer.valueOf(Constraints.m5424getMinWidthimpl(j11)), Integer.valueOf(Constraints.m5423getMinHeightimpl(j11)), LazyGridMeasureKt$measureLazyGrid$1.INSTANCE), CollectionsKt__CollectionsKt.emptyList(), -i25, i24 + i15, 0, z12, z11 ? Orientation.Vertical : Orientation.Horizontal, i15);
            } else {
                int roundToInt = MathKt__MathJVMKt.roundToInt(f11);
                int i26 = i17 - roundToInt;
                int i27 = i16;
                if (LineIndex.m725equalsimpl0(i27, LineIndex.m722constructorimpl(0)) && i26 < 0) {
                    roundToInt += i26;
                    i26 = 0;
                }
                ArrayList arrayList = new ArrayList();
                int i28 = i26 - i25;
                int i29 = -i25;
                while (i28 < 0 && i27 - LineIndex.m722constructorimpl(0) > 0) {
                    i27 = LineIndex.m722constructorimpl(i27 - 1);
                    LazyMeasuredLine r82 = lazyMeasuredLineProvider2.m719getAndMeasurebKFJvoY(i27);
                    arrayList.add(0, r82);
                    i28 += r82.getMainAxisSizeWithSpacings();
                }
                if (i28 < i29) {
                    roundToInt += i28;
                    i28 = i29;
                }
                int i31 = i28 + i25;
                int i32 = i24 + i15;
                int i33 = i27;
                int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i32, 0);
                int i34 = -i31;
                int i35 = i31;
                int size = arrayList.size();
                int i36 = i33;
                int i37 = i32;
                for (int i38 = 0; i38 < size; i38++) {
                    i36 = LineIndex.m722constructorimpl(i36 + 1);
                    i34 += ((LazyMeasuredLine) arrayList.get(i38)).getMainAxisSizeWithSpacings();
                }
                int i39 = i35;
                int i41 = i36;
                while (true) {
                    if (i34 > coerceAtLeast && !arrayList.isEmpty()) {
                        break;
                    }
                    int i42 = coerceAtLeast;
                    LazyMeasuredLine r72 = lazyMeasuredLineProvider2.m719getAndMeasurebKFJvoY(i41);
                    if (r72.isEmpty()) {
                        LineIndex.m722constructorimpl(i41 - 1);
                        break;
                    }
                    int i43 = i29;
                    int i44 = i37;
                    i34 += r72.getMainAxisSizeWithSpacings();
                    if (i34 > i43 || ((LazyMeasuredItem) ArraysKt___ArraysKt.last((T[]) r72.getItems())).m714getIndexVZbfaAc() == i11 - 1) {
                        arrayList.add(r72);
                        i23 = i33;
                    } else {
                        i23 = LineIndex.m722constructorimpl(i41 + 1);
                        i39 -= r72.getMainAxisSizeWithSpacings();
                    }
                    i41 = LineIndex.m722constructorimpl(i41 + 1);
                    coerceAtLeast = i42;
                    i33 = i23;
                    i29 = i43;
                    i37 = i44;
                    lazyMeasuredLineProvider2 = lazyMeasuredLineProvider;
                    LazyMeasuredItemProvider lazyMeasuredItemProvider2 = lazyMeasuredItemProvider;
                }
                if (i34 < i24) {
                    int i45 = i24 - i34;
                    i39 -= i45;
                    i34 += i45;
                    int i46 = i33;
                    while (true) {
                        if (i39 < i25) {
                            if (i46 - LineIndex.m722constructorimpl(0) <= 0) {
                                i19 = 0;
                                i18 = i29;
                                break;
                            }
                            i46 = LineIndex.m722constructorimpl(i46 - 1);
                            int i47 = i29;
                            LazyMeasuredLine r92 = lazyMeasuredLineProvider2.m719getAndMeasurebKFJvoY(i46);
                            arrayList.add(0, r92);
                            i39 += r92.getMainAxisSizeWithSpacings();
                            LazyMeasuredItemProvider lazyMeasuredItemProvider3 = lazyMeasuredItemProvider;
                            i29 = i47;
                        } else {
                            i18 = i29;
                            i19 = 0;
                            break;
                        }
                    }
                    roundToInt += i45;
                    if (i39 < 0) {
                        roundToInt += i39;
                        i34 += i39;
                        i39 = i19;
                    }
                } else {
                    i18 = i29;
                    i19 = 0;
                }
                float f12 = (MathKt__MathJVMKt.getSign(MathKt__MathJVMKt.roundToInt(f11)) != MathKt__MathJVMKt.getSign(roundToInt) || Math.abs(MathKt__MathJVMKt.roundToInt(f11)) < Math.abs(roundToInt)) ? f11 : (float) roundToInt;
                int i48 = -i39;
                LazyMeasuredLine lazyMeasuredLine2 = (LazyMeasuredLine) CollectionsKt___CollectionsKt.first(arrayList);
                if (i25 > 0) {
                    int size2 = arrayList.size();
                    LazyMeasuredLine lazyMeasuredLine3 = lazyMeasuredLine2;
                    int i49 = i19;
                    while (i49 < size2) {
                        int mainAxisSizeWithSpacings = ((LazyMeasuredLine) arrayList.get(i49)).getMainAxisSizeWithSpacings();
                        if (i39 == 0 || mainAxisSizeWithSpacings > i39 || i49 == CollectionsKt__CollectionsKt.getLastIndex(arrayList)) {
                            break;
                        }
                        i39 -= mainAxisSizeWithSpacings;
                        i49++;
                        lazyMeasuredLine3 = (LazyMeasuredLine) arrayList.get(i49);
                    }
                    lazyMeasuredLine = lazyMeasuredLine3;
                } else {
                    lazyMeasuredLine = lazyMeasuredLine2;
                }
                int i50 = i39;
                if (z11) {
                    i21 = Constraints.m5422getMaxWidthimpl(j11);
                } else {
                    i21 = ConstraintsKt.m5436constrainWidthK40F9xA(j12, i34);
                }
                int i51 = i21;
                if (z11) {
                    i22 = ConstraintsKt.m5435constrainHeightK40F9xA(j12, i34);
                } else {
                    i22 = Constraints.m5421getMaxHeightimpl(j11);
                }
                int i52 = i22;
                int i53 = i37;
                float f13 = f12;
                List<LazyGridPositionedItem> calculateItemsOffsets = calculateItemsOffsets(arrayList, i51, i52, i34, i12, i48, z11, vertical, horizontal, z12, density);
                int i54 = i34;
                int i55 = i18;
                lazyGridItemPlacementAnimator.onMeasured((int) f13, i51, i52, i13, z12, calculateItemsOffsets, lazyMeasuredItemProvider);
                return new LazyGridMeasureResult(lazyMeasuredLine, i50, i54 > i24, f13, (MeasureResult) function3.invoke(Integer.valueOf(i51), Integer.valueOf(i52), new LazyGridMeasureKt$measureLazyGrid$3(calculateItemsOffsets)), calculateItemsOffsets, i55, i53, i11, z12, z11 ? Orientation.Vertical : Orientation.Horizontal, i15);
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
