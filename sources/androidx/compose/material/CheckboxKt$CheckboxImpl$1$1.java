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
public final class CheckboxKt$CheckboxImpl$1$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CheckDrawingCache f4276g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Color> f4277h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<Color> f4278i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ State<Color> f4279j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State<Float> f4280k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ State<Float> f4281l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckboxKt$CheckboxImpl$1$1(CheckDrawingCache checkDrawingCache, State<Color> state, State<Color> state2, State<Color> state3, State<Float> state4, State<Float> state5) {
        super(1);
        this.f4276g = checkDrawingCache;
        this.f4277h = state;
        this.f4278i = state2;
        this.f4279j = state3;
        this.f4280k = state4;
        this.f4281l = state5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        float floor = (float) Math.floor((double) drawScope.m5447toPx0680j_4(CheckboxKt.StrokeWidth));
        DrawScope drawScope2 = drawScope;
        CheckboxKt.m1157drawBox1wkBAMs(drawScope2, CheckboxKt.m1149CheckboxImpl$lambda9(this.f4277h), CheckboxKt.m1145CheckboxImpl$lambda10(this.f4278i), drawScope.m5447toPx0680j_4(CheckboxKt.RadiusSize), floor);
        CheckboxKt.m1158drawCheck3IgeMak(drawScope2, CheckboxKt.m1148CheckboxImpl$lambda8(this.f4279j), CheckboxKt.m1146CheckboxImpl$lambda4(this.f4280k), CheckboxKt.m1147CheckboxImpl$lambda6(this.f4281l), floor, this.f4276g);
    }
}
