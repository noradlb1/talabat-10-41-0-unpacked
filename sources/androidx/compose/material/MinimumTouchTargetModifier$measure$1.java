package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MinimumTouchTargetModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f4699g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Placeable f4700h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f4701i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MinimumTouchTargetModifier$measure$1(int i11, Placeable placeable, int i12) {
        super(1);
        this.f4699g = i11;
        this.f4700h = placeable;
        this.f4701i = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.place$default(placementScope2, this.f4700h, MathKt__MathJVMKt.roundToInt(((float) (this.f4699g - this.f4700h.getWidth())) / 2.0f), MathKt__MathJVMKt.roundToInt(((float) (this.f4701i - this.f4700h.getHeight())) / 2.0f), 0.0f, 4, (Object) null);
    }
}
