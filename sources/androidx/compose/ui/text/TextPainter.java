package androidx.compose.ui.text;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.IntSize;
import e0.z0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextPainter {
    public static final int $stable = 0;
    @NotNull
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    public final void paint(@NotNull Canvas canvas, @NotNull TextLayoutResult textLayoutResult) {
        boolean z11;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        if (!textLayoutResult.getHasVisualOverflow() || TextOverflow.m5395equalsimpl0(textLayoutResult.getLayoutInput().m5010getOverflowgIe3tQ8(), TextOverflow.Companion.m5404getVisiblegIe3tQ8())) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            Rect r22 = RectKt.m2716Recttz77jQw(Offset.Companion.m2692getZeroF1C5BW0(), SizeKt.Size((float) IntSize.m5638getWidthimpl(textLayoutResult.m5014getSizeYbymL2g()), (float) IntSize.m5637getHeightimpl(textLayoutResult.m5014getSizeYbymL2g())));
            canvas.save();
            z0.o(canvas, r22, 0, 2, (Object) null);
        }
        try {
            Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
            if (brush != null) {
                textLayoutResult.getMultiParagraph().paint(canvas, brush, textLayoutResult.getLayoutInput().getStyle().getAlpha(), textLayoutResult.getLayoutInput().getStyle().getShadow(), textLayoutResult.getLayoutInput().getStyle().getTextDecoration());
            } else {
                textLayoutResult.getMultiParagraph().m4944paintRPmYEkk(canvas, textLayoutResult.getLayoutInput().getStyle().m5056getColor0d7_KjU(), textLayoutResult.getLayoutInput().getStyle().getShadow(), textLayoutResult.getLayoutInput().getStyle().getTextDecoration());
            }
        } finally {
            if (z11) {
                canvas.restore();
            }
        }
    }
}
