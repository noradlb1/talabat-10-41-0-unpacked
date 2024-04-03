package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "x", "invoke", "(D)Ljava/lang/Double;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class Rgb$eotf$1 extends Lambda implements Function1<Double, Double> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Rgb f9645g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Rgb$eotf$1(Rgb rgb) {
        super(1);
        this.f9645g = rgb;
    }

    @NotNull
    public final Double invoke(double d11) {
        return this.f9645g.getEotfOrig$ui_graphics_release().invoke(Double.valueOf(RangesKt___RangesKt.coerceIn(d11, (double) this.f9645g.min, (double) this.f9645g.max)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).doubleValue());
    }
}
