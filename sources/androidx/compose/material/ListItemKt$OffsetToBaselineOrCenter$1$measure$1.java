package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ListItemKt$OffsetToBaselineOrCenter$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f4645g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4646h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemKt$OffsetToBaselineOrCenter$1$measure$1(Placeable placeable, int i11) {
        super(1);
        this.f4645g = placeable;
        this.f4646h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(placementScope, this.f4645g, 0, this.f4646h, 0.0f, 4, (Object) null);
    }
}
