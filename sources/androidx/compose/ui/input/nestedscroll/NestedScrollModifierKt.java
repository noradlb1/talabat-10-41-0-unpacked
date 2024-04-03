package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, d2 = {"nestedScroll", "Landroidx/compose/ui/Modifier;", "connection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class NestedScrollModifierKt {
    @NotNull
    public static final Modifier nestedScroll(@NotNull Modifier modifier, @NotNull NestedScrollConnection nestedScrollConnection, @Nullable NestedScrollDispatcher nestedScrollDispatcher) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(nestedScrollConnection, "connection");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new NestedScrollModifierKt$nestedScroll$$inlined$debugInspectorInfo$1(nestedScrollConnection, nestedScrollDispatcher);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new NestedScrollModifierKt$nestedScroll$2(nestedScrollDispatcher, nestedScrollConnection));
    }

    public static /* synthetic */ Modifier nestedScroll$default(Modifier modifier, NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            nestedScrollDispatcher = null;
        }
        return nestedScroll(modifier, nestedScrollConnection, nestedScrollDispatcher);
    }
}
