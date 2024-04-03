package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"pointerHoverIcon", "Landroidx/compose/ui/Modifier;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PointerIconKt {
    @NotNull
    @Stable
    public static final Modifier pointerHoverIcon(@NotNull Modifier modifier, @NotNull PointerIcon pointerIcon, boolean z11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(pointerIcon, "icon");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new PointerIconKt$pointerHoverIcon$$inlined$debugInspectorInfo$1(pointerIcon, z11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new PointerIconKt$pointerHoverIcon$2(pointerIcon, z11));
    }

    public static /* synthetic */ Modifier pointerHoverIcon$default(Modifier modifier, PointerIcon pointerIcon, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return pointerHoverIcon(modifier, pointerIcon, z11);
    }
}
