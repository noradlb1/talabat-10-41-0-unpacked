package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PaddingValuesModifier$measure$2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f2520g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f2521h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PaddingValuesModifier f2522i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaddingValuesModifier$measure$2(Placeable placeable, MeasureScope measureScope, PaddingValuesModifier paddingValuesModifier) {
        super(1);
        this.f2520g = placeable;
        this.f2521h = measureScope;
        this.f2522i = paddingValuesModifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope.place$default(placementScope, this.f2520g, this.f2521h.m5441roundToPx0680j_4(this.f2522i.getPaddingValues().m497calculateLeftPaddingu2uoSUM(this.f2521h.getLayoutDirection())), this.f2521h.m5441roundToPx0680j_4(this.f2522i.getPaddingValues().m499calculateTopPaddingD9Ej5fM()), 0.0f, 4, (Object) null);
    }
}
