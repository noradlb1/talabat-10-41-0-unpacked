package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "t", "invoke", "(D)Ljava/lang/Double;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SpringEstimationKt$estimateCriticallyDamped$fnPrime$1 extends Lambda implements Function1<Double, Double> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ double f1365g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ double f1366h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ double f1367i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpringEstimationKt$estimateCriticallyDamped$fnPrime$1(double d11, double d12, double d13) {
        super(1);
        this.f1365g = d11;
        this.f1366h = d12;
        this.f1367i = d13;
    }

    @NotNull
    public final Double invoke(double d11) {
        double d12 = this.f1365g;
        double d13 = this.f1366h;
        return Double.valueOf(((d12 * ((d13 * d11) + ((double) 1))) + (this.f1367i * d13)) * Math.exp(d13 * d11));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).doubleValue());
    }
}
