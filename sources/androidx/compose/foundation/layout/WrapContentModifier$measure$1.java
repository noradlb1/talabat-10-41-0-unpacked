package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class WrapContentModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WrapContentModifier f2653g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2654h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Placeable f2655i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f2656j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f2657k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrapContentModifier$measure$1(WrapContentModifier wrapContentModifier, int i11, Placeable placeable, int i12, MeasureScope measureScope) {
        super(1);
        this.f2653g = wrapContentModifier;
        this.f2654h = i11;
        this.f2655i = placeable;
        this.f2656j = i12;
        this.f2657k = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.m4529place70tqf50$default(placementScope2, this.f2655i, ((IntOffset) this.f2653g.alignmentCallback.invoke(IntSize.m5630boximpl(IntSizeKt.IntSize(this.f2654h - this.f2655i.getWidth(), this.f2656j - this.f2655i.getHeight())), this.f2657k.getLayoutDirection())).m5605unboximpl(), 0.0f, 2, (Object) null);
    }
}
