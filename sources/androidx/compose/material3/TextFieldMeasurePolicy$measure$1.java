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
public final class TextFieldMeasurePolicy$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Placeable f8939g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8940h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f8941i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8942j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8943k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Placeable f8944l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Placeable f8945m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Placeable f8946n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Placeable f8947o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Placeable f8948p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Placeable f8949q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ TextFieldMeasurePolicy f8950r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f8951s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f8952t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f8953u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldMeasurePolicy$measure$1(Placeable placeable, int i11, int i12, int i13, int i14, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, TextFieldMeasurePolicy textFieldMeasurePolicy, int i15, int i16, MeasureScope measureScope) {
        super(1);
        this.f8939g = placeable;
        this.f8940h = i11;
        this.f8941i = i12;
        this.f8942j = i13;
        this.f8943k = i14;
        this.f8944l = placeable2;
        this.f8945m = placeable3;
        this.f8946n = placeable4;
        this.f8947o = placeable5;
        this.f8948p = placeable6;
        this.f8949q = placeable7;
        this.f8950r = textFieldMeasurePolicy;
        this.f8951s = i15;
        this.f8952t = i16;
        this.f8953u = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        if (this.f8939g != null) {
            int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.f8940h - this.f8941i, 0);
            Placeable.PlacementScope placementScope2 = placementScope;
            TextFieldKt.placeWithLabel(placementScope2, this.f8942j, this.f8943k, this.f8944l, this.f8939g, this.f8945m, this.f8946n, this.f8947o, this.f8948p, this.f8949q, this.f8950r.singleLine, coerceAtLeast, this.f8952t + this.f8951s, this.f8950r.animationProgress, this.f8953u.getDensity());
            return;
        }
        TextFieldKt.placeWithoutLabel(placementScope, this.f8942j, this.f8943k, this.f8944l, this.f8945m, this.f8946n, this.f8947o, this.f8948p, this.f8949q, this.f8950r.singleLine, this.f8953u.getDensity(), this.f8950r.paddingValues);
    }
}
