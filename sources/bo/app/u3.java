package bo.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¨\u0006\u0002"}, d2 = {"Ljava/math/BigDecimal;", "a", "android-sdk-base_release"}, k = 2, mv = {1, 6, 0})
public final class u3 {
    public static final BigDecimal a(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        BigDecimal scale = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        Intrinsics.checkNotNullExpressionValue(scale, "this.setScale(2, RoundingMode.HALF_UP)");
        return scale;
    }
}
