package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class OffsetPxModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OffsetPxModifier f2502g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f2503h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Placeable f2504i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OffsetPxModifier$measure$1(OffsetPxModifier offsetPxModifier, MeasureScope measureScope, Placeable placeable) {
        super(1);
        this.f2502g = offsetPxModifier;
        this.f2503h = measureScope;
        this.f2504i = placeable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        long r22 = this.f2502g.getOffset().invoke(this.f2503h).m5605unboximpl();
        if (this.f2502g.getRtlAware()) {
            Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, this.f2504i, IntOffset.m5596getXimpl(r22), IntOffset.m5597getYimpl(r22), 0.0f, (Function1) null, 12, (Object) null);
            return;
        }
        Placeable.PlacementScope.placeWithLayer$default(placementScope, this.f2504i, IntOffset.m5596getXimpl(r22), IntOffset.m5597getYimpl(r22), 0.0f, (Function1) null, 12, (Object) null);
    }
}
