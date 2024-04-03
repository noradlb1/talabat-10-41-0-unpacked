package androidx.compose.ui.text.style;

import androidx.compose.ui.util.MathHelpersKt;
import com.deliveryhero.performance.core.logger.TraceLogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"lerp", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "start", "stop", "fraction", "", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextGeometricTransformKt {
    @NotNull
    public static final TextGeometricTransform lerp(@NotNull TextGeometricTransform textGeometricTransform, @NotNull TextGeometricTransform textGeometricTransform2, float f11) {
        Intrinsics.checkNotNullParameter(textGeometricTransform, "start");
        Intrinsics.checkNotNullParameter(textGeometricTransform2, TraceLogKt.STOP_PROPERTY_NAME);
        return new TextGeometricTransform(MathHelpersKt.lerp(textGeometricTransform.getScaleX(), textGeometricTransform2.getScaleX(), f11), MathHelpersKt.lerp(textGeometricTransform.getSkewX(), textGeometricTransform2.getSkewX(), f11));
    }
}
