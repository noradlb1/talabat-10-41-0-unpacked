package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "t", "invoke", "(D)Ljava/lang/Double;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SpringEstimationKt$estimateOverDamped$fnPrime$1 extends Lambda implements Function1<Double, Double> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ double f1373g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ double f1374h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ double f1375i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ double f1376j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpringEstimationKt$estimateOverDamped$fnPrime$1(double d11, double d12, double d13, double d14) {
        super(1);
        this.f1373g = d11;
        this.f1374h = d12;
        this.f1375i = d13;
        this.f1376j = d14;
    }

    @NotNull
    public final Double invoke(double d11) {
        double d12 = this.f1373g;
        double d13 = this.f1374h;
        double exp = d12 * d13 * Math.exp(d13 * d11);
        double d14 = this.f1375i;
        double d15 = this.f1376j;
        return Double.valueOf(exp + (d14 * d15 * Math.exp(d15 * d11)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).doubleValue());
    }
}
