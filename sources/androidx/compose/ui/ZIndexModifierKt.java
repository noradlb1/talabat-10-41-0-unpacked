package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007¨\u0006\u0003"}, d2 = {"zIndex", "Landroidx/compose/ui/Modifier;", "", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ZIndexModifierKt {
    @NotNull
    @Stable
    public static final Modifier zIndex(@NotNull Modifier modifier, float f11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new ZIndexModifierKt$zIndex$$inlined$debugInspectorInfo$1(f11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new ZIndexModifier(f11, function1));
    }
}
