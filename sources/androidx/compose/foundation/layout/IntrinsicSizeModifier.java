package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bb\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u001c\u0010\u0013\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J)\u0010\u0015\u001a\u00020\u0016*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u001c\u0010\u001a\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/IntrinsicSizeModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "enforceIncoming", "", "getEnforceIncoming", "()Z", "calculateContentConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "calculateContentConstraints-l58MMJ0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
interface IntrinsicSizeModifier extends LayoutModifier {

    /* renamed from: androidx.compose.foundation.layout.IntrinsicSizeModifier$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean a(IntrinsicSizeModifier intrinsicSizeModifier) {
            return true;
        }

        public static int b(IntrinsicSizeModifier intrinsicSizeModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.maxIntrinsicHeight(i11);
        }

        public static int c(IntrinsicSizeModifier intrinsicSizeModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.maxIntrinsicWidth(i11);
        }

        @NotNull
        public static MeasureResult d(IntrinsicSizeModifier intrinsicSizeModifier, @NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
            Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            long r02 = intrinsicSizeModifier.m459calculateContentConstraintsl58MMJ0(measureScope, measurable, j11);
            if (intrinsicSizeModifier.getEnforceIncoming()) {
                r02 = ConstraintsKt.m5434constrainN9IONVI(j11, r02);
            }
            Placeable r72 = measurable.m4508measureBRTryo0(r02);
            return MeasureScope.CC.p(measureScope, r72.getWidth(), r72.getHeight(), (Map) null, new IntrinsicSizeModifier$measure$1(r72), 4, (Object) null);
        }

        public static int e(IntrinsicSizeModifier intrinsicSizeModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.minIntrinsicHeight(i11);
        }

        public static int f(IntrinsicSizeModifier intrinsicSizeModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.minIntrinsicWidth(i11);
        }
    }

    /* renamed from: calculateContentConstraints-l58MMJ0  reason: not valid java name */
    long m459calculateContentConstraintsl58MMJ0(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11);

    boolean getEnforceIncoming();

    int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11);

    int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11);

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    MeasureResult m460measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11);

    int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11);

    int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11);
}
