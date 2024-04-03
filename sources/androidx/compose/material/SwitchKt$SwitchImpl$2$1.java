package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwitchKt$SwitchImpl$2$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Color> f5705g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchKt$SwitchImpl$2$1(State<Color> state) {
        super(1);
        this.f5705g = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        SwitchKt.m1405drawTrackRPmYEkk(drawScope, SwitchKt.m1401SwitchImpl$lambda5(this.f5705g), drawScope.m5447toPx0680j_4(SwitchKt.getTrackWidth()), drawScope.m5447toPx0680j_4(SwitchKt.getTrackStrokeWidth()));
    }
}
