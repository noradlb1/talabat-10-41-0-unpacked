package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ProgressIndicatorKt$LinearProgressIndicator$3$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f7813g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Float> f7814h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<Float> f7815i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7816j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State<Float> f7817k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ State<Float> f7818l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$LinearProgressIndicator$3$1(long j11, State<Float> state, State<Float> state2, long j12, State<Float> state3, State<Float> state4) {
        super(1);
        this.f7813g = j11;
        this.f7814h = state;
        this.f7815i = state2;
        this.f7816j = j12;
        this.f7817k = state3;
        this.f7818l = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        float r02 = Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc());
        ProgressIndicatorKt.m1808drawLinearIndicatorTrackbw27NRU(drawScope, this.f7813g, r02);
        if (this.f7814h.getValue().floatValue() - this.f7815i.getValue().floatValue() > 0.0f) {
            ProgressIndicatorKt.m1807drawLinearIndicator42QJj7c(drawScope, this.f7814h.getValue().floatValue(), this.f7815i.getValue().floatValue(), this.f7816j, r02);
        }
        if (this.f7817k.getValue().floatValue() - this.f7818l.getValue().floatValue() > 0.0f) {
            ProgressIndicatorKt.m1807drawLinearIndicator42QJj7c(drawScope, this.f7817k.getValue().floatValue(), this.f7818l.getValue().floatValue(), this.f7816j, r02);
        }
    }
}
