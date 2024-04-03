package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CheckboxKt$CheckboxImpl$1$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Color> f6737g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Color> f6738h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<Color> f6739i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ State<Float> f6740j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State<Float> f6741k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ CheckDrawingCache f6742l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckboxKt$CheckboxImpl$1$1(State<Color> state, State<Color> state2, State<Color> state3, State<Float> state4, State<Float> state5, CheckDrawingCache checkDrawingCache) {
        super(1);
        this.f6737g = state;
        this.f6738h = state2;
        this.f6739i = state3;
        this.f6740j = state4;
        this.f6741k = state5;
        this.f6742l = checkDrawingCache;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        float floor = (float) Math.floor((double) drawScope.m5447toPx0680j_4(CheckboxKt.StrokeWidth));
        DrawScope drawScope2 = drawScope;
        CheckboxKt.m1538drawBox1wkBAMs(drawScope2, this.f6737g.getValue().m2929unboximpl(), this.f6738h.getValue().m2929unboximpl(), drawScope.m5447toPx0680j_4(CheckboxKt.RadiusSize), floor);
        CheckboxKt.m1539drawCheck3IgeMak(drawScope2, this.f6739i.getValue().m2929unboximpl(), this.f6740j.getValue().floatValue(), this.f6741k.getValue().floatValue(), floor, this.f6742l);
    }
}
