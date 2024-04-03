package androidx.compose.ui.text.platform;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o0.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000\u001a8\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¨\u0006\u000e"}, d2 = {"drawMultiParagraph", "", "Landroidx/compose/ui/text/MultiParagraph;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawParagraphs", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidMultiParagraphDrawKt {
    public static final void drawMultiParagraph(@NotNull MultiParagraph multiParagraph, @NotNull Canvas canvas, @NotNull Brush brush, float f11, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration) {
        Canvas canvas2 = canvas;
        Brush brush2 = brush;
        Intrinsics.checkNotNullParameter(multiParagraph, "<this>");
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        Intrinsics.checkNotNullParameter(brush2, "brush");
        canvas.save();
        if (multiParagraph.getParagraphInfoList$ui_text_release().size() <= 1) {
            drawParagraphs(multiParagraph, canvas, brush, f11, shadow, textDecoration);
        } else if (brush2 instanceof SolidColor) {
            drawParagraphs(multiParagraph, canvas, brush, f11, shadow, textDecoration);
        } else if (brush2 instanceof ShaderBrush) {
            List<ParagraphInfo> paragraphInfoList$ui_text_release = multiParagraph.getParagraphInfoList$ui_text_release();
            int size = paragraphInfoList$ui_text_release.size();
            float f12 = 0.0f;
            float f13 = 0.0f;
            for (int i11 = 0; i11 < size; i11++) {
                ParagraphInfo paragraphInfo = paragraphInfoList$ui_text_release.get(i11);
                f13 += paragraphInfo.getParagraph().getHeight();
                f12 = Math.max(f12, paragraphInfo.getParagraph().getWidth());
            }
            Shader r11 = ((ShaderBrush) brush2).m3217createShaderuvyYCjk(SizeKt.Size(f12, f13));
            Matrix matrix = new Matrix();
            r11.getLocalMatrix(matrix);
            List<ParagraphInfo> paragraphInfoList$ui_text_release2 = multiParagraph.getParagraphInfoList$ui_text_release();
            int size2 = paragraphInfoList$ui_text_release2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                ParagraphInfo paragraphInfo2 = paragraphInfoList$ui_text_release2.get(i12);
                a.b(paragraphInfo2.getParagraph(), canvas, BrushKt.ShaderBrush(r11), f11, shadow, textDecoration, (DrawStyle) null, 32, (Object) null);
                canvas2.translate(0.0f, paragraphInfo2.getParagraph().getHeight());
                matrix.setTranslate(0.0f, -paragraphInfo2.getParagraph().getHeight());
                r11.setLocalMatrix(matrix);
            }
        }
        canvas.restore();
    }

    public static /* synthetic */ void drawMultiParagraph$default(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f11, Shadow shadow, TextDecoration textDecoration, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            f11 = Float.NaN;
        }
        drawMultiParagraph(multiParagraph, canvas, brush, f11, (i11 & 8) != 0 ? null : shadow, (i11 & 16) != 0 ? null : textDecoration);
    }

    private static final void drawParagraphs(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f11, Shadow shadow, TextDecoration textDecoration) {
        List<ParagraphInfo> paragraphInfoList$ui_text_release = multiParagraph.getParagraphInfoList$ui_text_release();
        int size = paragraphInfoList$ui_text_release.size();
        for (int i11 = 0; i11 < size; i11++) {
            ParagraphInfo paragraphInfo = paragraphInfoList$ui_text_release.get(i11);
            a.b(paragraphInfo.getParagraph(), canvas, brush, f11, shadow, textDecoration, (DrawStyle) null, 32, (Object) null);
            canvas.translate(0.0f, paragraphInfo.getParagraph().getHeight());
        }
    }
}
