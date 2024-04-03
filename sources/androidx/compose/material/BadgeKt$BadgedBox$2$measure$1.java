package androidx.compose.material;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BadgeKt$BadgedBox$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f4060g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f4061h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Placeable f4062i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadgeKt$BadgedBox$2$measure$1(Placeable placeable, MeasureScope measureScope, Placeable placeable2) {
        super(1);
        this.f4060g = placeable;
        this.f4061h = measureScope;
        this.f4062i = placeable2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        float badgeWithContentHorizontalOffset = this.f4060g.getWidth() > this.f4061h.m5441roundToPx0680j_4(BadgeKt.getBadgeRadius()) * 2 ? BadgeKt.getBadgeWithContentHorizontalOffset() : BadgeKt.getBadgeHorizontalOffset();
        Placeable.PlacementScope.placeRelative$default(placementScope, this.f4062i, 0, 0, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope, this.f4060g, this.f4062i.getWidth() + this.f4061h.m5441roundToPx0680j_4(badgeWithContentHorizontalOffset), (-this.f4060g.getHeight()) / 2, 0.0f, 4, (Object) null);
    }
}
