package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ProgressIndicatorKt$CircularProgressIndicator$3 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Integer> f7792g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Float> f7793h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<Float> f7794i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ State<Float> f7795j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f7796k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f7797l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Stroke f7798m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$CircularProgressIndicator$3(State<Integer> state, State<Float> state2, State<Float> state3, State<Float> state4, float f11, long j11, Stroke stroke) {
        super(1);
        this.f7792g = state;
        this.f7793h = state2;
        this.f7794i = state3;
        this.f7795j = state4;
        this.f7796k = f11;
        this.f7797l = j11;
        this.f7798m = stroke;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        DrawScope drawScope2 = drawScope;
        ProgressIndicatorKt.m1806drawIndeterminateCircularIndicatorhrjfTZI(drawScope2, this.f7794i.getValue().floatValue() + (((this.f7792g.getValue().floatValue() * 216.0f) % 360.0f) - 0.049804688f) + this.f7795j.getValue().floatValue(), this.f7796k, Math.abs(this.f7793h.getValue().floatValue() - this.f7794i.getValue().floatValue()), this.f7797l, this.f7798m);
    }
}
