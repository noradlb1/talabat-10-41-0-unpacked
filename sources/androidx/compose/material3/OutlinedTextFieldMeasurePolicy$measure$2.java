package androidx.compose.material3;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class OutlinedTextFieldMeasurePolicy$measure$2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f7771g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7772h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Placeable f7773i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Placeable f7774j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Placeable f7775k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Placeable f7776l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Placeable f7777m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Placeable f7778n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Placeable f7779o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ OutlinedTextFieldMeasurePolicy f7780p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f7781q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutlinedTextFieldMeasurePolicy$measure$2(int i11, int i12, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy, MeasureScope measureScope) {
        super(1);
        this.f7771g = i11;
        this.f7772h = i12;
        this.f7773i = placeable;
        this.f7774j = placeable2;
        this.f7775k = placeable3;
        this.f7776l = placeable4;
        this.f7777m = placeable5;
        this.f7778n = placeable6;
        this.f7779o = placeable7;
        this.f7780p = outlinedTextFieldMeasurePolicy;
        this.f7781q = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2 = placementScope;
        Intrinsics.checkNotNullParameter(placementScope2, "$this$layout");
        OutlinedTextFieldKt.place(placementScope2, this.f7771g, this.f7772h, this.f7773i, this.f7774j, this.f7775k, this.f7776l, this.f7777m, this.f7778n, this.f7779o, this.f7780p.animationProgress, this.f7780p.singleLine, this.f7781q.getDensity(), this.f7781q.getLayoutDirection(), this.f7780p.paddingValues);
    }
}
