package androidx.compose.animation;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExpandShrinkModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f1260g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f1261h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f1262i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandShrinkModifier$measure$1(Placeable placeable, long j11, long j12) {
        super(1);
        this.f1260g = placeable;
        this.f1261h = j11;
        this.f1262i = j12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope.place$default(placementScope, this.f1260g, IntOffset.m5596getXimpl(this.f1261h) + IntOffset.m5596getXimpl(this.f1262i), IntOffset.m5597getYimpl(this.f1261h) + IntOffset.m5597getYimpl(this.f1262i), 0.0f, 4, (Object) null);
    }
}
