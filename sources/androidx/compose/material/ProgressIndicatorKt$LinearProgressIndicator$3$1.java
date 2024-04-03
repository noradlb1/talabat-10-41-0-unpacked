package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProgressIndicatorKt$LinearProgressIndicator$3$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f4963g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f4964h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<Float> f4965i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ State<Float> f4966j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State<Float> f4967k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ State<Float> f4968l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$LinearProgressIndicator$3$1(long j11, long j12, State<Float> state, State<Float> state2, State<Float> state3, State<Float> state4) {
        super(1);
        this.f4963g = j11;
        this.f4964h = j12;
        this.f4965i = state;
        this.f4966j = state2;
        this.f4967k = state3;
        this.f4968l = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        float r02 = Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc());
        ProgressIndicatorKt.m1351drawLinearIndicatorBackgroundbw27NRU(drawScope, this.f4963g, r02);
        if (ProgressIndicatorKt.m1331LinearProgressIndicator_RIQooxk$lambda1(this.f4965i) - ProgressIndicatorKt.m1332LinearProgressIndicator_RIQooxk$lambda2(this.f4966j) > 0.0f) {
            ProgressIndicatorKt.m1350drawLinearIndicator42QJj7c(drawScope, ProgressIndicatorKt.m1331LinearProgressIndicator_RIQooxk$lambda1(this.f4965i), ProgressIndicatorKt.m1332LinearProgressIndicator_RIQooxk$lambda2(this.f4966j), this.f4964h, r02);
        }
        if (ProgressIndicatorKt.m1333LinearProgressIndicator_RIQooxk$lambda3(this.f4967k) - ProgressIndicatorKt.m1334LinearProgressIndicator_RIQooxk$lambda4(this.f4968l) > 0.0f) {
            ProgressIndicatorKt.m1350drawLinearIndicator42QJj7c(drawScope, ProgressIndicatorKt.m1333LinearProgressIndicator_RIQooxk$lambda3(this.f4967k), ProgressIndicatorKt.m1334LinearProgressIndicator_RIQooxk$lambda4(this.f4968l), this.f4964h, r02);
        }
    }
}
