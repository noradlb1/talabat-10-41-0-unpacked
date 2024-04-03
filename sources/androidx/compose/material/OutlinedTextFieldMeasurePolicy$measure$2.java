package androidx.compose.material;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OutlinedTextFieldMeasurePolicy$measure$2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f4923g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4924h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Placeable f4925i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Placeable f4926j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Placeable f4927k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Placeable f4928l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Placeable f4929m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Placeable f4930n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ OutlinedTextFieldMeasurePolicy f4931o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f4932p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutlinedTextFieldMeasurePolicy$measure$2(int i11, int i12, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy, MeasureScope measureScope) {
        super(1);
        this.f4923g = i11;
        this.f4924h = i12;
        this.f4925i = placeable;
        this.f4926j = placeable2;
        this.f4927k = placeable3;
        this.f4928l = placeable4;
        this.f4929m = placeable5;
        this.f4930n = placeable6;
        this.f4931o = outlinedTextFieldMeasurePolicy;
        this.f4932p = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2 = placementScope;
        Intrinsics.checkNotNullParameter(placementScope2, "$this$layout");
        OutlinedTextFieldKt.place(placementScope2, this.f4923g, this.f4924h, this.f4925i, this.f4926j, this.f4927k, this.f4928l, this.f4929m, this.f4930n, this.f4931o.animationProgress, this.f4931o.singleLine, this.f4932p.getDensity(), this.f4932p.getLayoutDirection(), this.f4931o.paddingValues);
    }
}
