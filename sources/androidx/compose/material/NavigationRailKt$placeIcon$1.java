package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavigationRailKt$placeIcon$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f4808g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4809h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f4810i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$placeIcon$1(Placeable placeable, int i11, int i12) {
        super(1);
        this.f4808g = placeable;
        this.f4809h = i11;
        this.f4810i = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(placementScope, this.f4808g, this.f4809h, this.f4810i, 0.0f, 4, (Object) null);
    }
}
