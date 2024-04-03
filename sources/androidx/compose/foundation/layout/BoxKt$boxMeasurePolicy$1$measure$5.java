package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BoxKt$boxMeasurePolicy$1$measure$5 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable[] f2458g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<Measurable> f2459h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f2460i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f2461j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f2462k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Alignment f2463l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoxKt$boxMeasurePolicy$1$measure$5(Placeable[] placeableArr, List<? extends Measurable> list, MeasureScope measureScope, Ref.IntRef intRef, Ref.IntRef intRef2, Alignment alignment) {
        super(1);
        this.f2458g = placeableArr;
        this.f2459h = list;
        this.f2460i = measureScope;
        this.f2461j = intRef;
        this.f2462k = intRef2;
        this.f2463l = alignment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable[] placeableArr = this.f2458g;
        List<Measurable> list = this.f2459h;
        MeasureScope measureScope = this.f2460i;
        Ref.IntRef intRef = this.f2461j;
        Ref.IntRef intRef2 = this.f2462k;
        Alignment alignment = this.f2463l;
        int length = placeableArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i12 < length) {
            Placeable placeable = placeableArr[i12];
            Intrinsics.checkNotNull(placeable, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
            BoxKt.placeInBox(placementScope, placeable, list.get(i11), measureScope.getLayoutDirection(), intRef.element, intRef2.element, alignment);
            i12++;
            i11++;
        }
    }
}
