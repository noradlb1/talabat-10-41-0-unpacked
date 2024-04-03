package androidx.compose.animation;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SlideModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SlideModifier f1273g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Placeable f1274h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f1275i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SlideModifier$measure$1(SlideModifier slideModifier, Placeable placeable, long j11) {
        super(1);
        this.f1273g = slideModifier;
        this.f1274h = placeable;
        this.f1275i = j11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.m4532placeWithLayeraW9wM$default(placementScope2, this.f1274h, this.f1273g.getLazyAnimation().animate(this.f1273g.getTransitionSpec(), new SlideModifier$measure$1$slideOffset$1(this.f1273g, this.f1275i)).getValue().m5605unboximpl(), 0.0f, (Function1) null, 6, (Object) null);
    }
}
