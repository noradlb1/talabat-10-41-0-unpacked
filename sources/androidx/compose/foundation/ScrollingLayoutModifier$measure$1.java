package androidx.compose.foundation;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScrollingLayoutModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ScrollingLayoutModifier f1813g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1814h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Placeable f1815i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollingLayoutModifier$measure$1(ScrollingLayoutModifier scrollingLayoutModifier, int i11, Placeable placeable) {
        super(1);
        this.f1813g = scrollingLayoutModifier;
        this.f1814h = i11;
        this.f1815i = placeable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        int coerceIn = RangesKt___RangesKt.coerceIn(this.f1813g.getScrollerState().getValue(), 0, this.f1814h);
        int i11 = this.f1813g.isReversed() ? coerceIn - this.f1814h : -coerceIn;
        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, this.f1815i, this.f1813g.isVertical() ? 0 : i11, this.f1813g.isVertical() ? i11 : 0, 0.0f, (Function1) null, 12, (Object) null);
    }
}
