package androidx.compose.animation;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedEnterExitMeasurePolicy$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<Placeable> f1118g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedEnterExitMeasurePolicy$measure$1(List<? extends Placeable> list) {
        super(1);
        this.f1118g = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        List<Placeable> list = this.f1118g;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Placeable.PlacementScope.place$default(placementScope, list.get(i11), 0, 0, 0.0f, 4, (Object) null);
        }
    }
}
