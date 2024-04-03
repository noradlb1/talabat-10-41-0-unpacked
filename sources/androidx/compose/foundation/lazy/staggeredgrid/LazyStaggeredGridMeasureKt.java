package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\n\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\f\u0010\u000b\u001a\u00020\u0006*\u00020\u0004H\u0002\u001a2\u0010\f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00060\u0010H\b¢\u0006\u0002\u0010\u0011\u001a\f\u0010\u0012\u001a\u00020\u0006*\u00020\u0004H\u0000\u001a,\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0003\u001aq\u0010\u001a\u001a\u00020\u0014*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,\u001a\u0014\u0010-\u001a\u00020\u0001*\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0002\u001a!\u0010/\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010H\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"ensureIndicesInRange", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "indices", "", "itemCount", "", "findNextItemIndex", "item", "lane", "findPreviousItemIndex", "indexOfMaxValue", "indexOfMinBy", "T", "", "block", "Lkotlin/Function1;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMinValue", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "initialScrollDelta", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "resolvedSlotSums", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "crossAxisSpacing", "beforeContentPadding", "afterContentPadding", "measureStaggeredGrid-yR9pz_M", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;[IJZJIIIII)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "offsetBy", "delta", "transform", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridMeasureKt {
    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i11) {
        int i12;
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i13 = length - 1;
                while (true) {
                    i12 = iArr[length];
                    if (i12 < i11) {
                        break;
                    }
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, i12, length);
                }
                if (i12 != -1) {
                    lazyStaggeredGridMeasureContext.getSpans().setSpan(iArr[length], length);
                }
                if (i13 >= 0) {
                    length = i13;
                } else {
                    return;
                }
            }
        }
    }

    private static final int findNextItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i11, int i12) {
        return lazyStaggeredGridMeasureContext.getSpans().findNextItemIndex(i11, i12);
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i11, int i12) {
        return lazyStaggeredGridMeasureContext.getSpans().findPreviousItemIndex(i11, i12);
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i11 = -1;
        int i12 = Integer.MIN_VALUE;
        for (int i13 = 0; i13 < length; i13++) {
            int i14 = iArr[i13];
            if (i12 < i14) {
                i11 = i13;
                i12 = i14;
            }
        }
        return i11;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i11 = -1;
        int i12 = Integer.MAX_VALUE;
        for (int i13 = 0; i13 < length; i13++) {
            int intValue = function1.invoke(tArr[i13]).intValue();
            if (i12 > intValue) {
                i11 = i13;
                i12 = intValue;
            }
        }
        return i11;
    }

    public static final int indexOfMinValue(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        int i11 = -1;
        int i12 = Integer.MAX_VALUE;
        for (int i13 = 0; i13 < length; i13++) {
            int i14 = iArr[i13];
            if (i12 > i14) {
                i11 = i13;
                i12 = i14;
            }
        }
        return i11;
    }

    @ExperimentalFoundationApi
    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i11, int[] iArr, int[] iArr2, boolean z11) {
        boolean z12;
        int i12;
        int i13;
        boolean z13;
        int i14;
        int i15;
        boolean z14;
        int[] iArr3;
        int[] iArr4;
        int i16;
        float f11;
        int i17;
        int i18;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i19;
        int i21;
        boolean z21;
        int i22;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        int i23;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
        int i24 = i11;
        int[] iArr5 = iArr;
        int[] iArr6 = iArr2;
        LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext.getItemProvider().getItemCount();
        if (itemCount > 0) {
            if (lazyStaggeredGridMeasureContext.getResolvedSlotSums().length == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                int[] copyOf = Arrays.copyOf(iArr5, iArr5.length);
                String str = "copyOf(this, size)";
                Intrinsics.checkNotNullExpressionValue(copyOf, str);
                int[] copyOf2 = Arrays.copyOf(iArr6, iArr6.length);
                Intrinsics.checkNotNullExpressionValue(copyOf2, str);
                ensureIndicesInRange(lazyStaggeredGridMeasureContext2, copyOf, itemCount);
                offsetBy(copyOf2, -i24);
                int length = lazyStaggeredGridMeasureContext.getResolvedSlotSums().length;
                ArrayDeque[] arrayDequeArr = new ArrayDeque[length];
                for (int i25 = 0; i25 < length; i25++) {
                    arrayDequeArr[i25] = new ArrayDeque();
                }
                offsetBy(copyOf2, -lazyStaggeredGridMeasureContext.getBeforeContentPadding());
                while (true) {
                    if (!m773measure$lambda17$hasSpaceBeforeFirst(copyOf, copyOf2, lazyStaggeredGridMeasureContext2)) {
                        i12 = -1;
                        break;
                    }
                    i12 = indexOfMinValue(copyOf2);
                    int findPreviousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, copyOf[i12], i12);
                    if (findPreviousItemIndex < 0) {
                        break;
                    }
                    if (lazyStaggeredGridMeasureContext.getSpans().getSpan(findPreviousItemIndex) == -1) {
                        lazyStaggeredGridMeasureContext.getSpans().setSpan(findPreviousItemIndex, i12);
                    }
                    LazyStaggeredGridMeasuredItem andMeasure = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getAndMeasure(findPreviousItemIndex, i12);
                    arrayDequeArr[i12].addFirst(andMeasure);
                    copyOf[i12] = findPreviousItemIndex;
                    copyOf2[i12] = copyOf2[i12] + andMeasure.getSizeWithSpacings();
                }
                int i26 = -lazyStaggeredGridMeasureContext.getBeforeContentPadding();
                int i27 = copyOf2[0];
                if (i27 < i26) {
                    offsetBy(copyOf2, i26 - i27);
                    i13 = i24 + i27;
                } else {
                    i13 = i24;
                }
                offsetBy(copyOf2, lazyStaggeredGridMeasureContext.getBeforeContentPadding());
                if (i12 == -1) {
                    i12 = ArraysKt___ArraysKt.indexOf(copyOf, 0);
                }
                if (i12 == -1 || !m774measure$lambda17$misalignedStart(copyOf, lazyStaggeredGridMeasureContext2, copyOf2, i12) || !z11) {
                    int[] copyOf3 = Arrays.copyOf(iArr5, iArr5.length);
                    Intrinsics.checkNotNullExpressionValue(copyOf3, str);
                    ensureIndicesInRange(lazyStaggeredGridMeasureContext2, copyOf3, itemCount);
                    Unit unit = Unit.INSTANCE;
                    int length2 = iArr6.length;
                    int[] iArr7 = new int[length2];
                    LazyLayoutMeasureScope lazyLayoutMeasureScope = measureScope;
                    int i28 = 0;
                    while (i28 < length2) {
                        iArr7[i28] = -(iArr6[i28] - i13);
                        i28++;
                        str = str;
                    }
                    String str2 = str;
                    int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), 0);
                    int length3 = copyOf3.length;
                    int i29 = i13;
                    int[] iArr8 = copyOf;
                    int i31 = 0;
                    int i32 = 0;
                    while (i31 < length3) {
                        int i33 = length3;
                        int i34 = copyOf3[i31];
                        int i35 = i32 + 1;
                        int[] iArr9 = copyOf2;
                        if (i34 >= 0) {
                            LazyStaggeredGridMeasuredItem andMeasure2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getAndMeasure(i34, i32);
                            iArr7[i32] = iArr7[i32] + andMeasure2.getSizeWithSpacings();
                            i23 = i26;
                            arrayDequeArr[i32].addLast(andMeasure2);
                            lazyStaggeredGridMeasureContext.getSpans().setSpan(i34, i32);
                        } else {
                            i23 = i26;
                        }
                        i31++;
                        length3 = i33;
                        i32 = i35;
                        copyOf2 = iArr9;
                        i26 = i23;
                    }
                    int[] iArr10 = copyOf2;
                    int i36 = i26;
                    while (true) {
                        int i37 = 0;
                        while (true) {
                            if (i37 >= length2) {
                                z13 = false;
                                break;
                            }
                            if (iArr7[i37] <= coerceAtLeast) {
                                z25 = true;
                            } else {
                                z25 = false;
                            }
                            if (z25) {
                                z13 = true;
                                break;
                            }
                            i37++;
                        }
                        if (!z13) {
                            int i38 = 0;
                            while (true) {
                                if (i38 >= length) {
                                    z24 = true;
                                    break;
                                } else if (!arrayDequeArr[i38].isEmpty()) {
                                    z24 = false;
                                    break;
                                } else {
                                    i38++;
                                }
                            }
                            if (!z24) {
                                i14 = coerceAtLeast;
                                i15 = Integer.MAX_VALUE;
                                break;
                            }
                        }
                        int indexOfMinValue = indexOfMinValue(iArr7);
                        int findNextItemIndex = findNextItemIndex(lazyStaggeredGridMeasureContext2, copyOf3[indexOfMinValue], indexOfMinValue);
                        if (findNextItemIndex >= itemCount) {
                            int length4 = copyOf3.length;
                            i14 = coerceAtLeast;
                            int i39 = Integer.MAX_VALUE;
                            int i41 = 0;
                            int i42 = 0;
                            while (i41 < length4) {
                                int i43 = copyOf3[i41];
                                int i44 = i42 + 1;
                                if (i42 != indexOfMinValue) {
                                    int findNextItemIndex2 = findNextItemIndex(lazyStaggeredGridMeasureContext2, i43, i42);
                                    while (findNextItemIndex2 < itemCount) {
                                        int min = Math.min(findNextItemIndex2, i39);
                                        lazyStaggeredGridMeasureContext.getSpans().setSpan(findNextItemIndex2, -1);
                                        findNextItemIndex2 = findNextItemIndex(lazyStaggeredGridMeasureContext2, findNextItemIndex2, i42);
                                        i39 = min;
                                        length4 = length4;
                                    }
                                }
                                i41++;
                                i42 = i44;
                                length4 = length4;
                            }
                            i15 = Integer.MAX_VALUE;
                            if (i39 != Integer.MAX_VALUE && z11) {
                                iArr5[indexOfMinValue] = Math.min(iArr5[indexOfMinValue], i39);
                                return measure(lazyStaggeredGridMeasureContext2, i24, iArr5, iArr6, false);
                            }
                        } else {
                            int[] iArr11 = iArr8;
                            int[] iArr12 = iArr10;
                            int i45 = i36;
                            String str3 = str2;
                            int i46 = coerceAtLeast;
                            String str4 = str3;
                            if (iArr11[indexOfMinValue] == -1) {
                                iArr11[indexOfMinValue] = findNextItemIndex;
                            }
                            lazyStaggeredGridMeasureContext.getSpans().setSpan(findNextItemIndex, indexOfMinValue);
                            LazyStaggeredGridMeasuredItem andMeasure3 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getAndMeasure(findNextItemIndex, indexOfMinValue);
                            iArr7[indexOfMinValue] = iArr7[indexOfMinValue] + andMeasure3.getSizeWithSpacings();
                            arrayDequeArr[indexOfMinValue].addLast(andMeasure3);
                            copyOf3[indexOfMinValue] = findNextItemIndex;
                            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
                            iArr10 = iArr12;
                            iArr8 = iArr11;
                            i36 = i45;
                            int i47 = i46;
                            str2 = str4;
                            coerceAtLeast = i47;
                        }
                    }
                    for (int i48 = 0; i48 < length; i48++) {
                        ArrayDeque arrayDeque = arrayDequeArr[i48];
                        int i49 = iArr7[i48];
                        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayDeque);
                        int i50 = 0;
                        int i51 = -1;
                        while (true) {
                            if (i51 >= lastIndex) {
                                lastIndex = i50;
                                break;
                            }
                            i49 -= ((LazyStaggeredGridMeasuredItem) arrayDeque.get(lastIndex)).getSizeWithSpacings();
                            if (i49 <= i36 + lazyStaggeredGridMeasureContext.getMainAxisSpacing()) {
                                break;
                            }
                            i51 = -1;
                            i50 = lastIndex;
                            lastIndex--;
                        }
                        for (int i52 = 0; i52 < lastIndex; i52++) {
                            iArr10[i48] = iArr10[i48] - ((LazyStaggeredGridMeasuredItem) arrayDeque.removeFirst()).getSizeWithSpacings();
                        }
                        if (!arrayDeque.isEmpty()) {
                            iArr8[i48] = ((LazyStaggeredGridMeasuredItem) arrayDeque.first()).getIndex();
                        }
                    }
                    int i53 = 0;
                    while (true) {
                        if (i53 >= length2) {
                            z14 = true;
                            break;
                        }
                        if (iArr7[i53] < lazyStaggeredGridMeasureContext.getMainAxisAvailableSize()) {
                            z23 = true;
                        } else {
                            z23 = false;
                        }
                        if (!z23) {
                            z14 = false;
                            break;
                        }
                        i53++;
                    }
                    if (z14) {
                        int mainAxisAvailableSize = lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() - iArr7[indexOfMaxValue(iArr7)];
                        iArr4 = iArr10;
                        offsetBy(iArr4, -mainAxisAvailableSize);
                        offsetBy(iArr7, mainAxisAvailableSize);
                        while (true) {
                            int length5 = iArr4.length;
                            int i54 = 0;
                            while (true) {
                                if (i54 >= length5) {
                                    z21 = false;
                                    break;
                                }
                                if (iArr4[i54] < lazyStaggeredGridMeasureContext.getBeforeContentPadding()) {
                                    z22 = true;
                                } else {
                                    z22 = false;
                                }
                                if (z22) {
                                    z21 = true;
                                    break;
                                }
                                i54++;
                            }
                            if (!z21) {
                                i22 = i29;
                                iArr3 = iArr8;
                                break;
                            }
                            int indexOfMinValue2 = indexOfMinValue(iArr4);
                            int i55 = iArr8[indexOfMinValue2];
                            if (i55 == -1) {
                                i55 = itemCount;
                            }
                            int findPreviousItemIndex2 = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i55, indexOfMinValue2);
                            if (findPreviousItemIndex2 < 0) {
                                iArr3 = iArr8;
                                if (!m774measure$lambda17$misalignedStart(iArr3, lazyStaggeredGridMeasureContext2, iArr4, indexOfMinValue2) || !z11) {
                                    i22 = i29;
                                } else {
                                    lazyStaggeredGridMeasureContext.getSpans().reset();
                                    int length6 = iArr3.length;
                                    int[] iArr13 = new int[length6];
                                    for (int i56 = 0; i56 < length6; i56++) {
                                        iArr13[i56] = -1;
                                    }
                                    int length7 = iArr4.length;
                                    int[] iArr14 = new int[length7];
                                    for (int i57 = 0; i57 < length7; i57++) {
                                        iArr14[i57] = iArr4[indexOfMinValue2];
                                    }
                                    return measure(lazyStaggeredGridMeasureContext2, i29, iArr13, iArr14, false);
                                }
                            } else {
                                int i58 = i29;
                                lazyStaggeredGridMeasureContext.getSpans().setSpan(findPreviousItemIndex2, indexOfMinValue2);
                                LazyStaggeredGridMeasuredItem andMeasure4 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getAndMeasure(findPreviousItemIndex2, indexOfMinValue2);
                                arrayDequeArr[indexOfMinValue2].addFirst(andMeasure4);
                                iArr4[indexOfMinValue2] = iArr4[indexOfMinValue2] + andMeasure4.getSizeWithSpacings();
                                iArr8[indexOfMinValue2] = findPreviousItemIndex2;
                            }
                        }
                        i16 = i22 + mainAxisAvailableSize;
                        int i59 = iArr4[indexOfMinValue(iArr4)];
                        if (i59 < 0) {
                            i16 += i59;
                            offsetBy(iArr7, i59);
                            offsetBy(iArr4, -i59);
                        }
                    } else {
                        iArr3 = iArr8;
                        iArr4 = iArr10;
                        i16 = i29;
                    }
                    if (MathKt__MathJVMKt.getSign(MathKt__MathJVMKt.roundToInt(lazyStaggeredGridMeasureContext.getState().getScrollToBeConsumed$foundation_release())) != MathKt__MathJVMKt.getSign(i16) || Math.abs(MathKt__MathJVMKt.roundToInt(lazyStaggeredGridMeasureContext.getState().getScrollToBeConsumed$foundation_release())) < Math.abs(i16)) {
                        f11 = lazyStaggeredGridMeasureContext.getState().getScrollToBeConsumed$foundation_release();
                    } else {
                        f11 = (float) i16;
                    }
                    float f12 = f11;
                    int[] copyOf4 = Arrays.copyOf(iArr4, iArr4.length);
                    Intrinsics.checkNotNullExpressionValue(copyOf4, str2);
                    int length8 = copyOf4.length;
                    for (int i60 = 0; i60 < length8; i60++) {
                        copyOf4[i60] = -copyOf4[i60];
                    }
                    if (lazyStaggeredGridMeasureContext.getBeforeContentPadding() > 0) {
                        for (int i61 = 0; i61 < length; i61++) {
                            ArrayDeque arrayDeque2 = arrayDequeArr[i61];
                            int size = arrayDeque2.size();
                            int i62 = 0;
                            while (i62 < size) {
                                int sizeWithSpacings = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i62)).getSizeWithSpacings();
                                if (i62 == CollectionsKt__CollectionsKt.getLastIndex(arrayDeque2) || (i21 = iArr4[i61]) == 0 || i21 < sizeWithSpacings) {
                                    break;
                                }
                                iArr4[i61] = i21 - sizeWithSpacings;
                                i62++;
                                iArr3[i61] = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i62)).getIndex();
                            }
                        }
                    }
                    if (lazyStaggeredGridMeasureContext.isVertical()) {
                        i17 = Constraints.m5422getMaxWidthimpl(lazyStaggeredGridMeasureContext.m771getConstraintsmsEJaDk());
                    } else {
                        i17 = ConstraintsKt.m5436constrainWidthK40F9xA(lazyStaggeredGridMeasureContext.m771getConstraintsmsEJaDk(), ArraysKt___ArraysKt.maxOrThrow(iArr7));
                    }
                    int i63 = i17;
                    if (lazyStaggeredGridMeasureContext.isVertical()) {
                        i18 = ConstraintsKt.m5435constrainHeightK40F9xA(lazyStaggeredGridMeasureContext.m771getConstraintsmsEJaDk(), ArraysKt___ArraysKt.maxOrThrow(iArr7));
                    } else {
                        i18 = Constraints.m5421getMaxHeightimpl(lazyStaggeredGridMeasureContext.m771getConstraintsmsEJaDk());
                    }
                    int i64 = i18;
                    int i65 = 0;
                    for (int i66 = 0; i66 < length; i66++) {
                        i65 += arrayDequeArr[i66].size();
                    }
                    MutableVector mutableVector = new MutableVector(new LazyStaggeredGridPositionedItem[i65], 0);
                    while (true) {
                        int i67 = 0;
                        while (true) {
                            if (i67 >= length) {
                                z15 = true;
                                z16 = false;
                                break;
                            }
                            z15 = true;
                            if (!arrayDequeArr[i67].isEmpty()) {
                                z16 = true;
                                break;
                            }
                            i67++;
                        }
                        if (!z16) {
                            break;
                        }
                        int i68 = i15;
                        int i69 = 0;
                        int i70 = -1;
                        while (i69 < length) {
                            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDequeArr[i69].firstOrNull();
                            if (lazyStaggeredGridMeasuredItem != null) {
                                i15 = lazyStaggeredGridMeasuredItem.getIndex();
                            }
                            if (i68 > i15) {
                                i70 = i69;
                                i68 = i15;
                            }
                            i69++;
                            i15 = Integer.MAX_VALUE;
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDequeArr[i70].removeFirst();
                        int i71 = copyOf4[i70];
                        if (i70 == 0) {
                            i19 = 0;
                        } else {
                            i19 = lazyStaggeredGridMeasureContext.getResolvedSlotSums()[i70 - 1] + (lazyStaggeredGridMeasureContext.getCrossAxisSpacing() * i70);
                        }
                        mutableVector.add(lazyStaggeredGridMeasuredItem2.position(i70, i71, i19));
                        copyOf4[i70] = copyOf4[i70] + lazyStaggeredGridMeasuredItem2.getSizeWithSpacings();
                        i15 = Integer.MAX_VALUE;
                    }
                    if (iArr3[0] != 0 || iArr4[0] > 0) {
                        z17 = z15;
                    } else {
                        z17 = false;
                    }
                    int i72 = 0;
                    while (true) {
                        if (i72 >= length2) {
                            z18 = false;
                            break;
                        }
                        if (iArr7[i72] > lazyStaggeredGridMeasureContext.getMainAxisAvailableSize()) {
                            z19 = z15;
                        } else {
                            z19 = false;
                        }
                        if (z19) {
                            z18 = z15;
                            break;
                        }
                        i72++;
                    }
                    return new LazyStaggeredGridMeasureResult(iArr3, iArr4, f12, MeasureScope.CC.p(lazyLayoutMeasureScope, i63, i64, (Map) null, new LazyStaggeredGridMeasureKt$measure$1$13(mutableVector), 4, (Object) null), z18, z17, itemCount, mutableVector.asMutableList(), IntSizeKt.IntSize(i63, i64), i36, i14, lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), (DefaultConstructorMarker) null);
                }
                lazyStaggeredGridMeasureContext.getSpans().reset();
                int length9 = copyOf.length;
                int[] iArr15 = new int[length9];
                for (int i73 = 0; i73 < length9; i73++) {
                    iArr15[i73] = -1;
                }
                int length10 = copyOf2.length;
                int[] iArr16 = new int[length10];
                for (int i74 = 0; i74 < length10; i74++) {
                    iArr16[i74] = copyOf2[i12];
                }
                return measure(lazyStaggeredGridMeasureContext2, i13, iArr15, iArr16, false);
            }
        }
        return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.CC.p(measureScope, Constraints.m5424getMinWidthimpl(lazyStaggeredGridMeasureContext.m771getConstraintsmsEJaDk()), Constraints.m5423getMinHeightimpl(lazyStaggeredGridMeasureContext.m771getConstraintsmsEJaDk()), (Map) null, LazyStaggeredGridMeasureKt$measure$1$1.INSTANCE, 4, (Object) null), false, false, itemCount, CollectionsKt__CollectionsKt.emptyList(), IntSizeKt.IntSize(Constraints.m5424getMinWidthimpl(lazyStaggeredGridMeasureContext.m771getConstraintsmsEJaDk()), Constraints.m5423getMinHeightimpl(lazyStaggeredGridMeasureContext.m771getConstraintsmsEJaDk())), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), (DefaultConstructorMarker) null);
    }

    /* renamed from: measure$lambda-17$hasSpaceBeforeFirst  reason: not valid java name */
    private static final boolean m773measure$lambda17$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = iArr[i11];
            if (iArr2[i11] < (-lazyStaggeredGridMeasureContext.getMainAxisSpacing()) && i12 > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0079  */
    /* renamed from: measure$lambda-17$misalignedStart  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean m774measure$lambda17$misalignedStart(int[] r8, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext r9, int[] r10, int r11) {
        /*
            kotlin.ranges.IntRange r0 = kotlin.collections.ArraysKt___ArraysKt.getIndices((int[]) r8)
            boolean r1 = r0 instanceof java.util.Collection
            r2 = -1
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0016
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0016
        L_0x0014:
            r5 = r4
            goto L_0x003b
        L_0x0016:
            java.util.Iterator r5 = r0.iterator()
        L_0x001a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0014
            r6 = r5
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6
            int r6 = r6.nextInt()
            r7 = r8[r6]
            int r7 = findPreviousItemIndex(r9, r7, r6)
            if (r7 != r2) goto L_0x0037
            r6 = r10[r6]
            r7 = r10[r11]
            if (r6 == r7) goto L_0x0037
            r6 = r3
            goto L_0x0038
        L_0x0037:
            r6 = r4
        L_0x0038:
            if (r6 == 0) goto L_0x001a
            r5 = r3
        L_0x003b:
            if (r1 == 0) goto L_0x0048
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0048
        L_0x0046:
            r8 = r4
            goto L_0x006d
        L_0x0048:
            java.util.Iterator r0 = r0.iterator()
        L_0x004c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0046
            r1 = r0
            kotlin.collections.IntIterator r1 = (kotlin.collections.IntIterator) r1
            int r1 = r1.nextInt()
            r6 = r8[r1]
            int r6 = findPreviousItemIndex(r9, r6, r1)
            if (r6 == r2) goto L_0x0069
            r1 = r10[r1]
            r6 = r10[r11]
            if (r1 < r6) goto L_0x0069
            r1 = r3
            goto L_0x006a
        L_0x0069:
            r1 = r4
        L_0x006a:
            if (r1 == 0) goto L_0x004c
            r8 = r3
        L_0x006d:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpans r9 = r9.getSpans()
            int r9 = r9.getSpan(r4)
            if (r9 == 0) goto L_0x0079
            r9 = r3
            goto L_0x007a
        L_0x0079:
            r9 = r4
        L_0x007a:
            if (r5 != 0) goto L_0x0082
            if (r8 != 0) goto L_0x0082
            if (r9 == 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r3 = r4
        L_0x0082:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt.m774measure$lambda17$misalignedStart(int[], androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext, int[], int):boolean");
    }

    @NotNull
    @ExperimentalFoundationApi
    /* renamed from: measureStaggeredGrid-yR9pz_M  reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m775measureStaggeredGridyR9pz_M(@NotNull LazyLayoutMeasureScope lazyLayoutMeasureScope, @NotNull LazyStaggeredGridState lazyStaggeredGridState, @NotNull LazyLayoutItemProvider lazyLayoutItemProvider, @NotNull int[] iArr, long j11, boolean z11, long j12, int i11, int i12, int i13, int i14, int i15) {
        Snapshot makeCurrent;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext;
        Object obj;
        Object obj2;
        int i16;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2;
        int i17;
        int[] iArr2 = iArr;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope2, "$this$measureStaggeredGrid");
        Intrinsics.checkNotNullParameter(lazyStaggeredGridState, "state");
        LazyLayoutItemProvider lazyLayoutItemProvider2 = lazyLayoutItemProvider;
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider2, "itemProvider");
        Intrinsics.checkNotNullParameter(iArr2, "resolvedSlotSums");
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = r1;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext4 = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, lazyLayoutItemProvider2, iArr, j11, z11, lazyLayoutMeasureScope2, i11, j12, i14, i15, i12, i13, (DefaultConstructorMarker) null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            int[] indices = lazyStaggeredGridState.getScrollPosition$foundation_release().getIndices();
            int[] offsets = lazyStaggeredGridState.getScrollPosition$foundation_release().getOffsets();
            if (indices.length == iArr2.length) {
                lazyStaggeredGridMeasureContext = lazyStaggeredGridMeasureContext3;
                obj = indices;
            } else {
                lazyStaggeredGridMeasureContext3.getSpans().reset();
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                int i18 = 0;
                while (i18 < length) {
                    if (i18 < indices.length) {
                        lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext3;
                        i17 = indices[i18];
                    } else if (i18 == 0) {
                        lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext3;
                        i17 = 0;
                    } else {
                        lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext3;
                        i17 = findNextItemIndex(lazyStaggeredGridMeasureContext2, iArr3[i18 - 1], i18);
                    }
                    iArr3[i18] = i17;
                    lazyStaggeredGridMeasureContext2.getSpans().setSpan(iArr3[i18], i18);
                    i18++;
                    lazyStaggeredGridMeasureContext3 = lazyStaggeredGridMeasureContext2;
                }
                lazyStaggeredGridMeasureContext = lazyStaggeredGridMeasureContext3;
                obj = iArr3;
            }
            objectRef.element = obj;
            if (offsets.length == iArr2.length) {
                obj2 = offsets;
            } else {
                int length2 = iArr2.length;
                int[] iArr4 = new int[length2];
                for (int i19 = 0; i19 < length2; i19++) {
                    if (i19 < offsets.length) {
                        i16 = offsets[i19];
                    } else if (i19 == 0) {
                        i16 = 0;
                    } else {
                        i16 = iArr4[i19 - 1];
                    }
                    iArr4[i19] = i16;
                }
                obj2 = iArr4;
            }
            objectRef2.element = obj2;
            Unit unit = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
            return measure(lazyStaggeredGridMeasureContext, MathKt__MathJVMKt.roundToInt(lazyStaggeredGridState.getScrollToBeConsumed$foundation_release()), (int[]) objectRef.element, (int[]) objectRef2.element, true);
        } catch (Throwable th2) {
            createNonObservableSnapshot.dispose();
            throw th2;
        }
    }

    private static final void offsetBy(int[] iArr, int i11) {
        int length = iArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = iArr[i12] + i11;
        }
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = function1.invoke(Integer.valueOf(iArr[i11])).intValue();
        }
        return iArr;
    }
}
