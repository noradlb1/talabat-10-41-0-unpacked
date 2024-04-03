package androidx.compose.foundation;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"progressSemantics", "Landroidx/compose/ui/Modifier;", "value", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ProgressSemanticsKt {
    @NotNull
    @Stable
    public static final Modifier progressSemantics(@NotNull Modifier modifier, float f11, @NotNull ClosedFloatingPointRange<Float> closedFloatingPointRange, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "valueRange");
        return SemanticsModifierKt.semantics(modifier, true, new ProgressSemanticsKt$progressSemantics$1(f11, closedFloatingPointRange, i11));
    }

    public static /* synthetic */ Modifier progressSemantics$default(Modifier modifier, float f11, ClosedFloatingPointRange closedFloatingPointRange, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            closedFloatingPointRange = RangesKt__RangesKt.rangeTo(0.0f, 1.0f);
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return progressSemantics(modifier, f11, closedFloatingPointRange, i11);
    }

    @NotNull
    @Stable
    public static final Modifier progressSemantics(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return SemanticsModifierKt.semantics(modifier, true, ProgressSemanticsKt$progressSemantics$2.INSTANCE);
    }
}
