package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\f\u0010\u0007\u001a\u00020\u0004*\u00020\u0004H\u0017¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/layout/BoxScopeInstance;", "Landroidx/compose/foundation/layout/BoxScope;", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "matchParentSize", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BoxScopeInstance implements BoxScope {
    @NotNull
    public static final BoxScopeInstance INSTANCE = new BoxScopeInstance();

    private BoxScopeInstance() {
    }

    @NotNull
    @Stable
    public Modifier align(@NotNull Modifier modifier, @NotNull Alignment alignment) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new BoxScopeInstance$align$$inlined$debugInspectorInfo$1(alignment);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new BoxChildData(alignment, false, function1));
    }

    @NotNull
    @Stable
    public Modifier matchParentSize(@NotNull Modifier modifier) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Alignment center = Alignment.Companion.getCenter();
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new BoxScopeInstance$matchParentSize$$inlined$debugInspectorInfo$1();
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new BoxChildData(center, true, function1));
    }
}
