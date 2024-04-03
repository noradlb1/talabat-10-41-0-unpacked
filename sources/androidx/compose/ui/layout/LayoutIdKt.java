package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0000\u001a\u00020\u0001H\u0007\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"layoutId", "", "Landroidx/compose/ui/layout/Measurable;", "getLayoutId", "(Landroidx/compose/ui/layout/Measurable;)Ljava/lang/Object;", "Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LayoutIdKt {
    @Nullable
    public static final Object getLayoutId(@NotNull Measurable measurable) {
        LayoutIdParentData layoutIdParentData;
        Intrinsics.checkNotNullParameter(measurable, "<this>");
        Object parentData = measurable.getParentData();
        if (parentData instanceof LayoutIdParentData) {
            layoutIdParentData = (LayoutIdParentData) parentData;
        } else {
            layoutIdParentData = null;
        }
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    @NotNull
    @Stable
    public static final Modifier layoutId(@NotNull Modifier modifier, @NotNull Object obj) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(obj, "layoutId");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new LayoutIdKt$layoutId$$inlined$debugInspectorInfo$1(obj);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new LayoutId(obj, function1));
    }
}
