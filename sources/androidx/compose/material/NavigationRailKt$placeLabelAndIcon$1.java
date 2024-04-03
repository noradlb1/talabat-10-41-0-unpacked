package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavigationRailKt$placeLabelAndIcon$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f4811g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Placeable f4812h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f4813i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4814j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4815k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Placeable f4816l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4817m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f4818n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$placeLabelAndIcon$1(float f11, Placeable placeable, int i11, int i12, int i13, Placeable placeable2, int i14, int i15) {
        super(1);
        this.f4811g = f11;
        this.f4812h = placeable;
        this.f4813i = i11;
        this.f4814j = i12;
        this.f4815k = i13;
        this.f4816l = placeable2;
        this.f4817m = i14;
        this.f4818n = i15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        if (!(this.f4811g == 0.0f)) {
            Placeable.PlacementScope.placeRelative$default(placementScope, this.f4812h, this.f4813i, this.f4814j + this.f4815k, 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, this.f4816l, this.f4817m, this.f4818n + this.f4815k, 0.0f, 4, (Object) null);
    }
}
