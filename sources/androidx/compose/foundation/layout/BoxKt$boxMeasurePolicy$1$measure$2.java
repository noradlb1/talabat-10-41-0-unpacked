package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BoxKt$boxMeasurePolicy$1$measure$2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f2452g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Measurable f2453h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f2454i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f2455j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f2456k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Alignment f2457l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoxKt$boxMeasurePolicy$1$measure$2(Placeable placeable, Measurable measurable, MeasureScope measureScope, int i11, int i12, Alignment alignment) {
        super(1);
        this.f2452g = placeable;
        this.f2453h = measurable;
        this.f2454i = measureScope;
        this.f2455j = i11;
        this.f2456k = i12;
        this.f2457l = alignment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        BoxKt.placeInBox(placementScope, this.f2452g, this.f2453h, this.f2454i.getLayoutDirection(), this.f2455j, this.f2456k, this.f2457l);
    }
}
