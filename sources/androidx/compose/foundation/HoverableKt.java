package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"hoverable", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class HoverableKt {
    @NotNull
    public static final Modifier hoverable(@NotNull Modifier modifier, @NotNull MutableInteractionSource mutableInteractionSource, boolean z11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new HoverableKt$hoverable$$inlined$debugInspectorInfo$1(mutableInteractionSource, z11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new HoverableKt$hoverable$2(mutableInteractionSource, z11));
    }

    public static /* synthetic */ Modifier hoverable$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return hoverable(modifier, mutableInteractionSource, z11);
    }
}
