package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class InsetsPaddingModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f2487g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2488h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f2489i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InsetsPaddingModifier$measure$1(Placeable placeable, int i11, int i12) {
        super(1);
        this.f2487g = placeable;
        this.f2488h = i11;
        this.f2489i = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope.place$default(placementScope, this.f2487g, this.f2488h, this.f2489i, 0.0f, 4, (Object) null);
    }
}
