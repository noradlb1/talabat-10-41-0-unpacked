package androidx.compose.material3.internal;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuPopupKt$SimpleStack$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    public static final ExposedDropdownMenuPopupKt$SimpleStack$1$measure$1 INSTANCE = new ExposedDropdownMenuPopupKt$SimpleStack$1$measure$1();

    public ExposedDropdownMenuPopupKt$SimpleStack$1$measure$1() {
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
