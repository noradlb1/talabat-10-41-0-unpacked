package androidx.compose.material.internal;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    public static final ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6$measure$1 INSTANCE = new ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6$measure$1();

    public ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6$measure$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
    }
}
