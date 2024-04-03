package androidx.compose.ui.text.font;

import androidx.compose.ui.util.MathHelpersKt;
import com.deliveryhero.performance.core.logger.TraceLogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"lerp", "Landroidx/compose/ui/text/font/FontWeight;", "start", "stop", "fraction", "", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FontWeightKt {
    @NotNull
    public static final FontWeight lerp(@NotNull FontWeight fontWeight, @NotNull FontWeight fontWeight2, float f11) {
        Intrinsics.checkNotNullParameter(fontWeight, "start");
        Intrinsics.checkNotNullParameter(fontWeight2, TraceLogKt.STOP_PROPERTY_NAME);
        return new FontWeight(RangesKt___RangesKt.coerceIn(MathHelpersKt.lerp(fontWeight.getWeight(), fontWeight2.getWeight(), f11), 1, 1000));
    }
}
