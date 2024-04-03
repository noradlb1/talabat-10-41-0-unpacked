package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bø\u0001\u0001¢\u0006\u0002\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\u0002*\u00020\u0006ø\u0001\u0001¢\u0006\u0002\u0010\f\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0006\u001a\u0001\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2`\u0010\u0013\u001a\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00100\u0014H@ø\u0001\u0001ø\u0001\u0001¢\u0006\u0002\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"angle", "", "Landroidx/compose/ui/geometry/Offset;", "angle-k-4lQ0M", "(J)F", "calculateCentroid", "Landroidx/compose/ui/input/pointer/PointerEvent;", "useCurrent", "", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "calculateCentroidSize", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateRotation", "calculateZoom", "detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "onGesture", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "centroid", "pan", "zoom", "rotation", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TransformGestureDetectorKt {
    /* renamed from: angle-k-4lQ0M  reason: not valid java name */
    private static final float m360anglek4lQ0M(long j11) {
        boolean z11 = true;
        if (Offset.m2676getXimpl(j11) == 0.0f) {
            if (Offset.m2677getYimpl(j11) != 0.0f) {
                z11 = false;
            }
            if (z11) {
                return 0.0f;
            }
        }
        return ((-((float) Math.atan2((double) Offset.m2676getXimpl(j11), (double) Offset.m2677getYimpl(j11)))) * 180.0f) / 3.1415927f;
    }

    public static final long calculateCentroid(@NotNull PointerEvent pointerEvent, boolean z11) {
        long j11;
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        long r02 = Offset.Companion.m2692getZeroF1C5BW0();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            PointerInputChange pointerInputChange = changes.get(i12);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                if (z11) {
                    j11 = pointerInputChange.m4306getPositionF1C5BW0();
                } else {
                    j11 = pointerInputChange.m4307getPreviousPositionF1C5BW0();
                }
                r02 = Offset.m2681plusMKHz9U(r02, j11);
                i11++;
            }
        }
        if (i11 == 0) {
            return Offset.Companion.m2691getUnspecifiedF1C5BW0();
        }
        return Offset.m2671divtuRUvjQ(r02, (float) i11);
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        return calculateCentroid(pointerEvent, z11);
    }

    public static final float calculateCentroidSize(@NotNull PointerEvent pointerEvent, boolean z11) {
        long j11;
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        long calculateCentroid = calculateCentroid(pointerEvent, z11);
        float f11 = 0.0f;
        if (Offset.m2673equalsimpl0(calculateCentroid, Offset.Companion.m2691getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            PointerInputChange pointerInputChange = changes.get(i12);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                if (z11) {
                    j11 = pointerInputChange.m4306getPositionF1C5BW0();
                } else {
                    j11 = pointerInputChange.m4307getPreviousPositionF1C5BW0();
                }
                f11 += Offset.m2674getDistanceimpl(Offset.m2680minusMKHz9U(j11, calculateCentroid));
                i11++;
            }
        }
        return f11 / ((float) i11);
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        return calculateCentroidSize(pointerEvent, z11);
    }

    public static final long calculatePan(@NotNull PointerEvent pointerEvent) {
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        long calculateCentroid = calculateCentroid(pointerEvent, true);
        Offset.Companion companion = Offset.Companion;
        if (Offset.m2673equalsimpl0(calculateCentroid, companion.m2691getUnspecifiedF1C5BW0())) {
            return companion.m2692getZeroF1C5BW0();
        }
        return Offset.m2680minusMKHz9U(calculateCentroid, calculateCentroid(pointerEvent, false));
    }

    public static final float calculateRotation(@NotNull PointerEvent pointerEvent) {
        boolean z11;
        PointerEvent pointerEvent2 = pointerEvent;
        Intrinsics.checkNotNullParameter(pointerEvent2, "<this>");
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = 1;
            if (i11 >= size) {
                break;
            }
            PointerInputChange pointerInputChange = changes.get(i11);
            if (!pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
                i13 = 0;
            }
            i12 += i13;
            i11++;
        }
        float f11 = 0.0f;
        if (i12 < 2) {
            return 0.0f;
        }
        long calculateCentroid = calculateCentroid(pointerEvent2, true);
        long calculateCentroid2 = calculateCentroid(pointerEvent2, false);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        float f12 = 0.0f;
        float f13 = 0.0f;
        int i14 = 0;
        while (i14 < size2) {
            PointerInputChange pointerInputChange2 = changes2.get(i14);
            if (pointerInputChange2.getPressed() && pointerInputChange2.getPreviousPressed()) {
                long r13 = pointerInputChange2.m4306getPositionF1C5BW0();
                long r22 = Offset.m2680minusMKHz9U(pointerInputChange2.m4307getPreviousPositionF1C5BW0(), calculateCentroid2);
                long r12 = Offset.m2680minusMKHz9U(r13, calculateCentroid);
                float r15 = m360anglek4lQ0M(r12) - m360anglek4lQ0M(r22);
                float r23 = Offset.m2674getDistanceimpl(Offset.m2681plusMKHz9U(r12, r22)) / 2.0f;
                if (r15 > 180.0f) {
                    r15 -= 360.0f;
                } else if (r15 < -180.0f) {
                    r15 += 360.0f;
                }
                f13 += r15 * r23;
                f12 += r23;
            }
            i14++;
            f11 = 0.0f;
        }
        if (f12 == f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return f11;
        }
        return f13 / f12;
    }

    public static final float calculateZoom(@NotNull PointerEvent pointerEvent) {
        boolean z11;
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        boolean z12 = true;
        float calculateCentroidSize = calculateCentroidSize(pointerEvent, true);
        float calculateCentroidSize2 = calculateCentroidSize(pointerEvent, false);
        if (calculateCentroidSize == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return 1.0f;
        }
        if (calculateCentroidSize2 != 0.0f) {
            z12 = false;
        }
        if (z12) {
            return 1.0f;
        }
        return calculateCentroidSize / calculateCentroidSize2;
    }

    @Nullable
    public static final Object detectTransformGestures(@NotNull PointerInputScope pointerInputScope, boolean z11, @NotNull Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, @NotNull Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new TransformGestureDetectorKt$detectTransformGestures$2(z11, function4, (Continuation<? super TransformGestureDetectorKt$detectTransformGestures$2>) null), continuation);
        return forEachGesture == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z11, Function4 function4, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return detectTransformGestures(pointerInputScope, z11, function4, continuation);
    }
}
