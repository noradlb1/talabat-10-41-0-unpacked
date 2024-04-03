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
public final class TextFieldMeasurePolicy$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f6088g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6089h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f6090i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6091j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f6092k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Placeable f6093l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Placeable f6094m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Placeable f6095n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Placeable f6096o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ TextFieldMeasurePolicy f6097p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6098q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6099r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f6100s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldMeasurePolicy$measure$1(Placeable placeable, int i11, int i12, int i13, int i14, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, TextFieldMeasurePolicy textFieldMeasurePolicy, int i15, int i16, MeasureScope measureScope) {
        super(1);
        this.f6088g = placeable;
        this.f6089h = i11;
        this.f6090i = i12;
        this.f6091j = i13;
        this.f6092k = i14;
        this.f6093l = placeable2;
        this.f6094m = placeable3;
        this.f6095n = placeable4;
        this.f6096o = placeable5;
        this.f6097p = textFieldMeasurePolicy;
        this.f6098q = i15;
        this.f6099r = i16;
        this.f6100s = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        if (this.f6088g != null) {
            int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.f6089h - this.f6090i, 0);
            Placeable.PlacementScope placementScope2 = placementScope;
            TextFieldKt.placeWithLabel(placementScope2, this.f6091j, this.f6092k, this.f6093l, this.f6088g, this.f6094m, this.f6095n, this.f6096o, this.f6097p.singleLine, coerceAtLeast, this.f6099r + this.f6098q, this.f6097p.animationProgress, this.f6100s.getDensity());
            return;
        }
        TextFieldKt.placeWithoutLabel(placementScope, this.f6091j, this.f6092k, this.f6093l, this.f6094m, this.f6095n, this.f6096o, this.f6097p.singleLine, this.f6100s.getDensity(), this.f6097p.paddingValues);
    }
}
