package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"AssumePointerMoveStoppedMilliseconds", "", "DefaultWeight", "", "HistorySize", "HorizonMilliseconds", "MinSampleSize", "polyFitLeastSquares", "Landroidx/compose/ui/input/pointer/util/PolynomialFit;", "x", "", "y", "degree", "addPointerInputChange", "", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;
    private static final int MinSampleSize = 3;

    public static final void addPointerInputChange(@NotNull VelocityTracker velocityTracker, @NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(velocityTracker, "<this>");
        Intrinsics.checkNotNullParameter(pointerInputChange, "event");
        if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
            velocityTracker.m4426setCurrentPointerPositionAccumulatork4lQ0M$ui_release(pointerInputChange.m4306getPositionF1C5BW0());
            velocityTracker.resetTracking();
        }
        long r02 = pointerInputChange.m4307getPreviousPositionF1C5BW0();
        List<HistoricalChange> historical = pointerInputChange.getHistorical();
        int size = historical.size();
        int i11 = 0;
        while (i11 < size) {
            HistoricalChange historicalChange = historical.get(i11);
            long r03 = Offset.m2680minusMKHz9U(historicalChange.m4236getPositionF1C5BW0(), r02);
            long r62 = historicalChange.m4236getPositionF1C5BW0();
            velocityTracker.m4426setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m2681plusMKHz9U(velocityTracker.m4425getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), r03));
            velocityTracker.m4423addPositionUv8p0NA(historicalChange.getUptimeMillis(), velocityTracker.m4425getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
            i11++;
            r02 = r62;
        }
        velocityTracker.m4426setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m2681plusMKHz9U(velocityTracker.m4425getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), Offset.m2680minusMKHz9U(pointerInputChange.m4306getPositionF1C5BW0(), r02)));
        velocityTracker.m4423addPositionUv8p0NA(pointerInputChange.getUptimeMillis(), velocityTracker.m4425getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
    }

    @NotNull
    public static final PolynomialFit polyFitLeastSquares(@NotNull List<Float> list, @NotNull List<Float> list2, int i11) {
        int i12;
        float f11;
        float f12;
        float f13;
        List<Float> list3 = list;
        List<Float> list4 = list2;
        int i13 = i11;
        Intrinsics.checkNotNullParameter(list3, Param.X);
        Intrinsics.checkNotNullParameter(list4, Param.Y);
        if (i13 < 1) {
            throw new IllegalArgumentException("The degree must be at positive integer");
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("x and y must be the same length");
        } else if (!list.isEmpty()) {
            if (i13 >= list.size()) {
                i12 = list.size() - 1;
            } else {
                i12 = i13;
            }
            int i14 = i13 + 1;
            ArrayList arrayList = new ArrayList(i14);
            int i15 = 0;
            while (true) {
                f11 = 0.0f;
                if (i15 >= i14) {
                    break;
                }
                arrayList.add(Float.valueOf(0.0f));
                i15++;
            }
            int size = list.size();
            int i16 = i12 + 1;
            Matrix matrix = new Matrix(i16, size);
            int i17 = 0;
            while (true) {
                f12 = 1.0f;
                if (i17 >= size) {
                    break;
                }
                matrix.set(0, i17, 1.0f);
                for (int i18 = 1; i18 < i16; i18++) {
                    matrix.set(i18, i17, matrix.get(i18 - 1, i17) * list3.get(i17).floatValue());
                }
                i17++;
            }
            Matrix matrix2 = new Matrix(i16, size);
            Matrix matrix3 = new Matrix(i16, i16);
            int i19 = 0;
            while (i19 < i16) {
                for (int i21 = 0; i21 < size; i21++) {
                    matrix2.set(i19, i21, matrix.get(i19, i21));
                }
                for (int i22 = 0; i22 < i19; i22++) {
                    float times = matrix2.getRow(i19).times(matrix2.getRow(i22));
                    for (int i23 = 0; i23 < size; i23++) {
                        matrix2.set(i19, i23, matrix2.get(i19, i23) - (matrix2.get(i22, i23) * times));
                    }
                }
                float norm = matrix2.getRow(i19).norm();
                if (((double) norm) >= 1.0E-6d) {
                    float f14 = 1.0f / norm;
                    for (int i24 = 0; i24 < size; i24++) {
                        matrix2.set(i19, i24, matrix2.get(i19, i24) * f14);
                    }
                    for (int i25 = 0; i25 < i16; i25++) {
                        if (i25 < i19) {
                            f13 = 0.0f;
                        } else {
                            f13 = matrix2.getRow(i19).times(matrix.getRow(i25));
                        }
                        matrix3.set(i19, i25, f13);
                    }
                    i19++;
                } else {
                    throw new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
                }
            }
            Vector vector = new Vector(size);
            for (int i26 = 0; i26 < size; i26++) {
                vector.set(i26, list4.get(i26).floatValue() * 1.0f);
            }
            int i27 = i16 - 1;
            for (int i28 = i27; -1 < i28; i28--) {
                arrayList.set(i28, Float.valueOf(matrix2.getRow(i28).times(vector)));
                int i29 = i28 + 1;
                if (i29 <= i27) {
                    int i31 = i27;
                    while (true) {
                        arrayList.set(i28, Float.valueOf(((Number) arrayList.get(i28)).floatValue() - (matrix3.get(i28, i31) * ((Number) arrayList.get(i31)).floatValue())));
                        if (i31 == i29) {
                            break;
                        }
                        i31--;
                    }
                }
                arrayList.set(i28, Float.valueOf(((Number) arrayList.get(i28)).floatValue() / matrix3.get(i28, i28)));
            }
            float f15 = 0.0f;
            for (int i32 = 0; i32 < size; i32++) {
                f15 += list4.get(i32).floatValue();
            }
            float f16 = f15 / ((float) size);
            float f17 = 0.0f;
            for (int i33 = 0; i33 < size; i33++) {
                float floatValue = list4.get(i33).floatValue() - ((Number) arrayList.get(0)).floatValue();
                float f18 = 1.0f;
                for (int i34 = 1; i34 < i16; i34++) {
                    f18 *= list3.get(i33).floatValue();
                    floatValue -= ((Number) arrayList.get(i34)).floatValue() * f18;
                }
                f17 += floatValue * 1.0f * floatValue;
                float floatValue2 = list4.get(i33).floatValue() - f16;
                f11 += floatValue2 * 1.0f * floatValue2;
            }
            if (f11 > 1.0E-6f) {
                f12 = 1.0f - (f17 / f11);
            }
            return new PolynomialFit(arrayList, f12);
        } else {
            throw new IllegalArgumentException("At least one point must be provided");
        }
    }
}
