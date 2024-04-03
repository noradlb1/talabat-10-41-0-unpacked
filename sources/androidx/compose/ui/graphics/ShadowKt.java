package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.deliveryhero.performance.core.logger.TraceLogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"lerp", "Landroidx/compose/ui/graphics/Shadow;", "start", "stop", "fraction", "", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ShadowKt {
    @NotNull
    @Stable
    public static final Shadow lerp(@NotNull Shadow shadow, @NotNull Shadow shadow2, float f11) {
        Intrinsics.checkNotNullParameter(shadow, "start");
        Intrinsics.checkNotNullParameter(shadow2, TraceLogKt.STOP_PROPERTY_NAME);
        return new Shadow(ColorKt.m2971lerpjxsXWHM(shadow.m3230getColor0d7_KjU(), shadow2.m3230getColor0d7_KjU(), f11), OffsetKt.m2699lerpWko1d7g(shadow.m3231getOffsetF1C5BW0(), shadow2.m3231getOffsetF1C5BW0(), f11), MathHelpersKt.lerp(shadow.getBlurRadius(), shadow2.getBlurRadius(), f11), (DefaultConstructorMarker) null);
    }
}
