package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\t\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016J/\u0010\u000b\u001a\u00020\f*\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"androidx/compose/foundation/layout/RowColumnImplKt$rowColumnMeasurePolicy$1", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RowColumnImplKt$rowColumnMeasurePolicy$1 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LayoutOrientation f2523a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f2524b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SizeMode f2525c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function5<Integer, int[], LayoutDirection, Density, int[], Unit> f2526d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CrossAxisAlignment f2527e;

    public RowColumnImplKt$rowColumnMeasurePolicy$1(LayoutOrientation layoutOrientation, float f11, SizeMode sizeMode, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> function5, CrossAxisAlignment crossAxisAlignment) {
        this.f2523a = layoutOrientation;
        this.f2524b = f11;
        this.f2525c = sizeMode;
        this.f2526d = function5;
        this.f2527e = crossAxisAlignment;
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return ((Number) RowColumnImplKt.MaxIntrinsicHeightMeasureBlock(this.f2523a).invoke(list, Integer.valueOf(i11), Integer.valueOf(intrinsicMeasureScope.m5441roundToPx0680j_4(this.f2524b)))).intValue();
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return ((Number) RowColumnImplKt.MaxIntrinsicWidthMeasureBlock(this.f2523a).invoke(list, Integer.valueOf(i11), Integer.valueOf(intrinsicMeasureScope.m5441roundToPx0680j_4(this.f2524b)))).intValue();
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m530measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Integer num;
        int i17;
        float f11;
        float f12;
        int i18;
        boolean z11;
        int i19;
        boolean z12;
        RowColumnParentData[] rowColumnParentDataArr;
        int i21;
        int i22;
        boolean z13;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope2, "$this$measure");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        OrientationIndependentConstraints orientationIndependentConstraints = new OrientationIndependentConstraints(j11, this.f2523a, (DefaultConstructorMarker) null);
        int r11 = measureScope2.m5441roundToPx0680j_4(this.f2524b);
        int size = list.size();
        Placeable[] placeableArr = new Placeable[size];
        int size2 = list.size();
        RowColumnParentData[] rowColumnParentDataArr2 = new RowColumnParentData[size2];
        for (int i23 = 0; i23 < size2; i23++) {
            rowColumnParentDataArr2[i23] = RowColumnImplKt.getData((IntrinsicMeasurable) list2.get(i23));
        }
        int size3 = list.size();
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        boolean z14 = false;
        float f13 = 0.0f;
        while (true) {
            int i29 = Integer.MAX_VALUE;
            if (i26 >= size3) {
                break;
            }
            Measurable measurable = (Measurable) list2.get(i26);
            RowColumnParentData rowColumnParentData = rowColumnParentDataArr2[i26];
            float access$getWeight = RowColumnImplKt.getWeight(rowColumnParentData);
            if (access$getWeight > 0.0f) {
                f13 += access$getWeight;
                i27++;
                i22 = i26;
                i21 = size3;
                rowColumnParentDataArr = rowColumnParentDataArr2;
            } else {
                int mainAxisMax = orientationIndependentConstraints.getMainAxisMax();
                if (mainAxisMax != Integer.MAX_VALUE) {
                    i29 = mainAxisMax - i28;
                }
                int i31 = mainAxisMax;
                i22 = i26;
                i21 = size3;
                rowColumnParentDataArr = rowColumnParentDataArr2;
                Placeable r32 = measurable.m4508measureBRTryo0(OrientationIndependentConstraints.copy$default(orientationIndependentConstraints, 0, i29, 0, 0, 8, (Object) null).m478toBoxConstraintsOenEA2s(this.f2523a));
                int min = Math.min(r11, (i31 - i28) - RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(r32, this.f2523a));
                i28 += RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(r32, this.f2523a) + min;
                i25 = Math.max(i25, RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(r32, this.f2523a));
                if (z14 || RowColumnImplKt.isRelative(rowColumnParentData)) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                placeableArr[i22] = r32;
                i24 = min;
                z14 = z13;
            }
            i26 = i22 + 1;
            size3 = i21;
            rowColumnParentDataArr2 = rowColumnParentDataArr;
        }
        int i32 = i25;
        RowColumnParentData[] rowColumnParentDataArr3 = rowColumnParentDataArr2;
        if (i27 == 0) {
            i28 -= i24;
            i12 = i32;
            i11 = 0;
        } else {
            int i33 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
            if (i33 <= 0 || orientationIndependentConstraints.getMainAxisMax() == Integer.MAX_VALUE) {
                i17 = orientationIndependentConstraints.getMainAxisMin();
            } else {
                i17 = orientationIndependentConstraints.getMainAxisMax();
            }
            int i34 = r11 * (i27 - 1);
            int i35 = (i17 - i28) - i34;
            if (i33 > 0) {
                f11 = ((float) i35) / f13;
            } else {
                f11 = 0.0f;
            }
            int i36 = 0;
            for (int i37 = 0; i37 < size2; i37++) {
                i36 += MathKt__MathJVMKt.roundToInt(RowColumnImplKt.getWeight(rowColumnParentDataArr3[i37]) * f11);
            }
            int size4 = list.size();
            int i38 = i35 - i36;
            i12 = i32;
            int i39 = 0;
            int i41 = 0;
            while (i39 < size4) {
                if (placeableArr[i39] == null) {
                    Measurable measurable2 = (Measurable) list2.get(i39);
                    RowColumnParentData rowColumnParentData2 = rowColumnParentDataArr3[i39];
                    float access$getWeight2 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    if (access$getWeight2 > 0.0f) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        int sign = MathKt__MathJVMKt.getSign(i38);
                        int i42 = i38 - sign;
                        int max = Math.max(0, MathKt__MathJVMKt.roundToInt(access$getWeight2 * f11) + sign);
                        f12 = f11;
                        if (!RowColumnImplKt.getFill(rowColumnParentData2) || max == Integer.MAX_VALUE) {
                            i18 = size4;
                            i19 = 0;
                        } else {
                            i19 = max;
                            i18 = size4;
                        }
                        int i43 = i42;
                        Placeable r22 = measurable2.m4508measureBRTryo0(new OrientationIndependentConstraints(i19, max, 0, orientationIndependentConstraints.getCrossAxisMax()).m478toBoxConstraintsOenEA2s(this.f2523a));
                        i41 += RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(r22, this.f2523a);
                        i12 = Math.max(i12, RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(r22, this.f2523a));
                        if (z14 || RowColumnImplKt.isRelative(rowColumnParentData2)) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        placeableArr[i39] = r22;
                        z14 = z12;
                        i38 = i43;
                    } else {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                } else {
                    f12 = f11;
                    i18 = size4;
                }
                i39++;
                list2 = list;
                f11 = f12;
                size4 = i18;
            }
            i11 = RangesKt___RangesKt.coerceAtMost(i41 + i34, orientationIndependentConstraints.getMainAxisMax() - i28);
        }
        Ref.IntRef intRef = new Ref.IntRef();
        if (z14) {
            i13 = 0;
            for (int i44 = 0; i44 < size; i44++) {
                Placeable placeable = placeableArr[i44];
                Intrinsics.checkNotNull(placeable);
                CrossAxisAlignment access$getCrossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(rowColumnParentDataArr3[i44]);
                if (access$getCrossAxisAlignment != null) {
                    num = access$getCrossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable);
                } else {
                    num = null;
                }
                if (num != null) {
                    int i45 = intRef.element;
                    int intValue = num.intValue();
                    if (intValue == Integer.MIN_VALUE) {
                        intValue = 0;
                    }
                    intRef.element = Math.max(i45, intValue);
                    int access$rowColumnMeasurePolicy_TDGSqEk$crossAxisSize = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable, this.f2523a);
                    LayoutOrientation layoutOrientation = this.f2523a;
                    int intValue2 = num.intValue();
                    if (intValue2 == Integer.MIN_VALUE) {
                        intValue2 = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable, layoutOrientation);
                    }
                    i13 = Math.max(i13, access$rowColumnMeasurePolicy_TDGSqEk$crossAxisSize - intValue2);
                }
            }
        } else {
            i13 = 0;
        }
        int max2 = Math.max(i28 + i11, orientationIndependentConstraints.getMainAxisMin());
        if (orientationIndependentConstraints.getCrossAxisMax() == Integer.MAX_VALUE || this.f2525c != SizeMode.Expand) {
            i14 = Math.max(i12, Math.max(orientationIndependentConstraints.getCrossAxisMin(), intRef.element + i13));
        } else {
            i14 = orientationIndependentConstraints.getCrossAxisMax();
        }
        int i46 = i14;
        LayoutOrientation layoutOrientation2 = this.f2523a;
        LayoutOrientation layoutOrientation3 = LayoutOrientation.Horizontal;
        if (layoutOrientation2 == layoutOrientation3) {
            i15 = max2;
        } else {
            i15 = i46;
        }
        if (layoutOrientation2 == layoutOrientation3) {
            i16 = i46;
        } else {
            i16 = max2;
        }
        int size5 = list.size();
        int[] iArr = new int[size5];
        for (int i47 = 0; i47 < size5; i47++) {
            iArr[i47] = 0;
        }
        return MeasureScope.CC.p(measureScope, i15, i16, (Map) null, new RowColumnImplKt$rowColumnMeasurePolicy$1$measure$4(list, placeableArr, this.f2526d, max2, measureScope, iArr, this.f2523a, rowColumnParentDataArr3, this.f2527e, i46, intRef), 4, (Object) null);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return ((Number) RowColumnImplKt.MinIntrinsicHeightMeasureBlock(this.f2523a).invoke(list, Integer.valueOf(i11), Integer.valueOf(intrinsicMeasureScope.m5441roundToPx0680j_4(this.f2524b)))).intValue();
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return ((Number) RowColumnImplKt.MinIntrinsicWidthMeasureBlock(this.f2523a).invoke(list, Integer.valueOf(i11), Integer.valueOf(intrinsicMeasureScope.m5441roundToPx0680j_4(this.f2524b)))).intValue();
    }
}
