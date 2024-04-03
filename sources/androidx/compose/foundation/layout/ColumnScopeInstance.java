package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.SiblingsAlignedModifier;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J \u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0017J\u0014\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0017J\u001c\u0010\u000e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/layout/ColumnScopeInstance;", "Landroidx/compose/foundation/layout/ColumnScope;", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "weight", "", "fill", "", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ColumnScopeInstance implements ColumnScope {
    @NotNull
    public static final ColumnScopeInstance INSTANCE = new ColumnScopeInstance();

    private ColumnScopeInstance() {
    }

    @NotNull
    @Stable
    public Modifier align(@NotNull Modifier modifier, @NotNull Alignment.Horizontal horizontal) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(horizontal, "alignment");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new ColumnScopeInstance$align$$inlined$debugInspectorInfo$1(horizontal);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new HorizontalAlignModifier(horizontal, function1));
    }

    @NotNull
    @Stable
    public Modifier alignBy(@NotNull Modifier modifier, @NotNull VerticalAlignmentLine verticalAlignmentLine) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(verticalAlignmentLine, "alignmentLine");
        return modifier.then(new SiblingsAlignedModifier.WithAlignmentLine(verticalAlignmentLine, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ColumnScopeInstance$alignBy$$inlined$debugInspectorInfo$1(verticalAlignmentLine) : InspectableValueKt.getNoInspectorInfo()));
    }

    @NotNull
    @Stable
    public Modifier weight(@NotNull Modifier modifier, float f11, boolean z11) {
        boolean z12;
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (((double) f11) > 0.0d) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
                function1 = new ColumnScopeInstance$weight$$inlined$debugInspectorInfo$1(f11, z11);
            } else {
                function1 = InspectableValueKt.getNoInspectorInfo();
            }
            return modifier.then(new LayoutWeightImpl(f11, z11, function1));
        }
        throw new IllegalArgumentException(("invalid weight " + f11 + "; must be greater than zero").toString());
    }

    @NotNull
    @Stable
    public Modifier alignBy(@NotNull Modifier modifier, @NotNull Function1<? super Measured, Integer> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "alignmentLineBlock");
        return modifier.then(new SiblingsAlignedModifier.WithAlignmentLineBlock(function1, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ColumnScopeInstance$alignBy$$inlined$debugInspectorInfo$2(function1) : InspectableValueKt.getNoInspectorInfo()));
    }
}
