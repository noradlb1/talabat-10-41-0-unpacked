package androidx.compose.material3;

import androidx.compose.material3.tokens.BadgeTokens;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BadgeKt$BadgedBox$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f6568g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f6569h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Placeable f6570i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadgeKt$BadgedBox$2$measure$1(Placeable placeable, MeasureScope measureScope, Placeable placeable2) {
        super(1);
        this.f6568g = placeable;
        this.f6569h = measureScope;
        this.f6570i = placeable2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        boolean z11 = this.f6568g.getWidth() > this.f6569h.m5441roundToPx0680j_4(BadgeTokens.INSTANCE.m2032getSizeD9Ej5fM());
        float badgeWithContentHorizontalOffset = z11 ? BadgeKt.getBadgeWithContentHorizontalOffset() : BadgeKt.getBadgeOffset();
        float badgeWithContentVerticalOffset = z11 ? BadgeKt.getBadgeWithContentVerticalOffset() : BadgeKt.getBadgeOffset();
        Placeable.PlacementScope.placeRelative$default(placementScope, this.f6570i, 0, 0, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope, this.f6568g, this.f6570i.getWidth() + this.f6569h.m5441roundToPx0680j_4(badgeWithContentHorizontalOffset), ((-this.f6568g.getHeight()) / 2) + this.f6569h.m5441roundToPx0680j_4(badgeWithContentVerticalOffset), 0.0f, 4, (Object) null);
    }
}
