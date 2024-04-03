package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationBarKt$placeIcon$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f7412g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Placeable f7413h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7414i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7415j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Placeable f7416k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7417l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7418m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7419n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f7420o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationBarKt$placeIcon$1(Placeable placeable, Placeable placeable2, int i11, int i12, Placeable placeable3, int i13, int i14, int i15, int i16) {
        super(1);
        this.f7412g = placeable;
        this.f7413h = placeable2;
        this.f7414i = i11;
        this.f7415j = i12;
        this.f7416k = placeable3;
        this.f7417l = i13;
        this.f7418m = i14;
        this.f7419n = i15;
        this.f7420o = i16;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable placeable = this.f7412g;
        if (placeable != null) {
            int i11 = this.f7419n;
            int i12 = this.f7420o;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i11 - placeable.getWidth()) / 2, (i12 - placeable.getHeight()) / 2, 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.placeRelative$default(placementScope2, this.f7413h, this.f7414i, this.f7415j, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope2, this.f7416k, this.f7417l, this.f7418m, 0.0f, 4, (Object) null);
    }
}
