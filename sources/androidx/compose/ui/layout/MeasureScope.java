package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.DpRect;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u0.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0016ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface MeasureScope extends IntrinsicMeasureScope {

    /* renamed from: androidx.compose.ui.layout.MeasureScope$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        @NotNull
        public static MeasureResult a(MeasureScope measureScope, int i11, int i12, @NotNull Map map, @NotNull Function1 function1) {
            Intrinsics.checkNotNullParameter(map, "alignmentLines");
            Intrinsics.checkNotNullParameter(function1, "placementBlock");
            return new MeasureScope$layout$1(i11, i12, map, measureScope, function1);
        }

        public static /* synthetic */ MeasureResult p(MeasureScope measureScope, int i11, int i12, Map map, Function1 function1, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 4) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                return measureScope.layout(i11, i12, map, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        @Deprecated
        public static MeasureResult layout(@NotNull MeasureScope measureScope, int i11, int i12, @NotNull Map<AlignmentLine, Integer> map, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(map, "alignmentLines");
            Intrinsics.checkNotNullParameter(function1, "placementBlock");
            return CC.a(measureScope, i11, i12, map, function1);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m4510roundToPxR2X_6o(@NotNull MeasureScope measureScope, long j11) {
            return a.a(measureScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m4511roundToPx0680j_4(@NotNull MeasureScope measureScope, float f11) {
            return a.b(measureScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m4512toDpGaN1DYA(@NotNull MeasureScope measureScope, long j11) {
            return a.c(measureScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m4513toDpu2uoSUM(@NotNull MeasureScope measureScope, float f11) {
            return a.d(measureScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m4515toDpSizekrfVVM(@NotNull MeasureScope measureScope, long j11) {
            return a.f(measureScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m4516toPxR2X_6o(@NotNull MeasureScope measureScope, long j11) {
            return a.g(measureScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m4517toPx0680j_4(@NotNull MeasureScope measureScope, float f11) {
            return a.h(measureScope, f11);
        }

        @NotNull
        @Stable
        @Deprecated
        public static Rect toRect(@NotNull MeasureScope measureScope, @NotNull DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "$receiver");
            return a.i(measureScope, dpRect);
        }

        @Stable
        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m4518toSizeXkaWNTQ(@NotNull MeasureScope measureScope, long j11) {
            return a.j(measureScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m4519toSp0xMU5do(@NotNull MeasureScope measureScope, float f11) {
            return a.k(measureScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m4520toSpkPz2Gy4(@NotNull MeasureScope measureScope, float f11) {
            return a.l(measureScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m4514toDpu2uoSUM(@NotNull MeasureScope measureScope, int i11) {
            return a.e(measureScope, i11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m4521toSpkPz2Gy4(@NotNull MeasureScope measureScope, int i11) {
            return a.m(measureScope, i11);
        }
    }

    @NotNull
    MeasureResult layout(int i11, int i12, @NotNull Map<AlignmentLine, Integer> map, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1);
}
