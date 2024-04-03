package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProgressIndicatorKt$CircularProgressIndicator$3 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f4942g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f4943h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Stroke f4944i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ State<Integer> f4945j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State<Float> f4946k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ State<Float> f4947l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ State<Float> f4948m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$CircularProgressIndicator$3(float f11, long j11, Stroke stroke, State<Integer> state, State<Float> state2, State<Float> state3, State<Float> state4) {
        super(1);
        this.f4942g = f11;
        this.f4943h = j11;
        this.f4944i = stroke;
        this.f4945j = state;
        this.f4946k = state2;
        this.f4947l = state3;
        this.f4948m = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        DrawScope drawScope2 = drawScope;
        ProgressIndicatorKt.m1349drawIndeterminateCircularIndicatorhrjfTZI(drawScope2, ProgressIndicatorKt.m1326CircularProgressIndicator_aM_cp0Q$lambda11(this.f4947l) + (((((float) ProgressIndicatorKt.m1327CircularProgressIndicator_aM_cp0Q$lambda8(this.f4945j)) * 216.0f) % 360.0f) - 0.049804688f) + ProgressIndicatorKt.m1328CircularProgressIndicator_aM_cp0Q$lambda9(this.f4948m), this.f4942g, Math.abs(ProgressIndicatorKt.m1325CircularProgressIndicator_aM_cp0Q$lambda10(this.f4946k) - ProgressIndicatorKt.m1326CircularProgressIndicator_aM_cp0Q$lambda11(this.f4947l)), this.f4943h, this.f4944i);
    }
}
