package androidx.compose.ui.text.style;

import androidx.compose.ui.text.SpanStyleKt;
import com.deliveryhero.performance.core.logger.TraceLogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"lerp", "Landroidx/compose/ui/text/style/TextIndent;", "start", "stop", "fraction", "", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextIndentKt {
    @NotNull
    public static final TextIndent lerp(@NotNull TextIndent textIndent, @NotNull TextIndent textIndent2, float f11) {
        Intrinsics.checkNotNullParameter(textIndent, "start");
        Intrinsics.checkNotNullParameter(textIndent2, TraceLogKt.STOP_PROPERTY_NAME);
        return new TextIndent(SpanStyleKt.m5006lerpTextUnitInheritableC3pnCVY(textIndent.m5390getFirstLineXSAIIZE(), textIndent2.m5390getFirstLineXSAIIZE(), f11), SpanStyleKt.m5006lerpTextUnitInheritableC3pnCVY(textIndent.m5391getRestLineXSAIIZE(), textIndent2.m5391getRestLineXSAIIZE(), f11), (DefaultConstructorMarker) null);
    }
}
