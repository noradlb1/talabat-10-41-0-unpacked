package androidx.compose.material3;

import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class RadioButtonKt$RadioButton$2$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Color> f7824g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Dp> f7825h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioButtonKt$RadioButton$2$1(State<Color> state, State<Dp> state2) {
        super(1);
        this.f7824g = state;
        this.f7825h = state2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        DrawScope drawScope2 = drawScope;
        Intrinsics.checkNotNullParameter(drawScope2, "$this$Canvas");
        float r32 = drawScope2.m5447toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
        float f11 = (float) 2;
        float f12 = r32 / f11;
        b.x(drawScope, this.f7824g.getValue().m2929unboximpl(), drawScope2.m5447toPx0680j_4(Dp.m5478constructorimpl(RadioButtonTokens.INSTANCE.m2413getIconSizeD9Ej5fM() / f11)) - f12, 0, 0.0f, new Stroke(r32, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 108, (Object) null);
        if (Dp.m5477compareTo0680j_4(this.f7825h.getValue().m5492unboximpl(), Dp.m5478constructorimpl((float) 0)) > 0) {
            b.x(drawScope, this.f7824g.getValue().m2929unboximpl(), drawScope2.m5447toPx0680j_4(this.f7825h.getValue().m5492unboximpl()) - f12, 0, 0.0f, Fill.INSTANCE, (ColorFilter) null, 0, 108, (Object) null);
        }
    }
}
