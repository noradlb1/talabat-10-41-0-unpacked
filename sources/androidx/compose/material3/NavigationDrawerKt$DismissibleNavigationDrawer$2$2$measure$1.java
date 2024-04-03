package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f7453g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Placeable f7454h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DrawerState f7455i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1(Placeable placeable, Placeable placeable2, DrawerState drawerState) {
        super(1);
        this.f7453g = placeable;
        this.f7454h = placeable2;
        this.f7455i = drawerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.placeRelative$default(placementScope2, this.f7453g, this.f7454h.getWidth() + MathKt__MathJVMKt.roundToInt(this.f7455i.getOffset().getValue().floatValue()), 0, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope2, this.f7454h, MathKt__MathJVMKt.roundToInt(this.f7455i.getOffset().getValue().floatValue()), 0, 0.0f, 4, (Object) null);
    }
}
