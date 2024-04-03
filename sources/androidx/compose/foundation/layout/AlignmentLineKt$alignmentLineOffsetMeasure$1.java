package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AlignmentLineKt$alignmentLineOffsetMeasure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AlignmentLine f2430g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f2431h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f2432i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f2433j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f2434k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Placeable f2435l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f2436m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlignmentLineKt$alignmentLineOffsetMeasure$1(AlignmentLine alignmentLine, float f11, int i11, int i12, int i13, Placeable placeable, int i14) {
        super(1);
        this.f2430g = alignmentLine;
        this.f2431h = f11;
        this.f2432i = i11;
        this.f2433j = i12;
        this.f2434k = i13;
        this.f2435l = placeable;
        this.f2436m = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        int i13 = 0;
        if (AlignmentLineKt.getHorizontal(this.f2430g)) {
            i11 = 0;
        } else {
            if (!Dp.m5483equalsimpl0(this.f2431h, Dp.Companion.m5498getUnspecifiedD9Ej5fM())) {
                i12 = this.f2432i;
            } else {
                i12 = (this.f2433j - this.f2434k) - this.f2435l.getWidth();
            }
            i11 = i12;
        }
        if (AlignmentLineKt.getHorizontal(this.f2430g)) {
            if (!Dp.m5483equalsimpl0(this.f2431h, Dp.Companion.m5498getUnspecifiedD9Ej5fM())) {
                i13 = this.f2432i;
            } else {
                i13 = (this.f2436m - this.f2434k) - this.f2435l.getHeight();
            }
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, this.f2435l, i11, i13, 0.0f, 4, (Object) null);
    }
}
