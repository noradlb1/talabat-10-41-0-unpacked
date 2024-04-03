package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"aspectRatio", "Landroidx/compose/ui/Modifier;", "ratio", "", "matchHeightConstraintsFirst", "", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AspectRatioKt {
    @NotNull
    @Stable
    public static final Modifier aspectRatio(@NotNull Modifier modifier, float f11, boolean z11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new AspectRatioKt$aspectRatio$$inlined$debugInspectorInfo$1(f11, z11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new AspectRatioModifier(f11, z11, function1));
    }

    public static /* synthetic */ Modifier aspectRatio$default(Modifier modifier, float f11, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return aspectRatio(modifier, f11, z11);
    }
}
