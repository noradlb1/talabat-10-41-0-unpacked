package o0;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.style.TextDecoration;

public final /* synthetic */ class a {
    public static /* synthetic */ int a(Paragraph paragraph, int i11, boolean z11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                z11 = false;
            }
            return paragraph.getLineEnd(i11, z11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEnd");
    }

    public static /* synthetic */ void b(Paragraph paragraph, Canvas canvas, Brush brush, float f11, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                f11 = Float.NaN;
            }
            paragraph.paint(canvas, brush, f11, (i11 & 8) != 0 ? null : shadow, (i11 & 16) != 0 ? null : textDecoration, (i11 & 32) != 0 ? null : drawStyle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint");
    }

    public static /* synthetic */ void c(Paragraph paragraph, Canvas canvas, long j11, Shadow shadow, TextDecoration textDecoration, int i11, Object obj) {
        Shadow shadow2;
        TextDecoration textDecoration2;
        if (obj == null) {
            if ((i11 & 2) != 0) {
                j11 = Color.Companion.m2955getUnspecified0d7_KjU();
            }
            long j12 = j11;
            if ((i11 & 4) != 0) {
                shadow2 = null;
            } else {
                shadow2 = shadow;
            }
            if ((i11 & 8) != 0) {
                textDecoration2 = null;
            } else {
                textDecoration2 = textDecoration;
            }
            paragraph.m4947paintRPmYEkk(canvas, j12, shadow2, textDecoration2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-RPmYEkk");
    }

    public static /* synthetic */ void d(Paragraph paragraph, Canvas canvas, long j11, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i11, Object obj) {
        Shadow shadow2;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        if (obj == null) {
            if ((i11 & 2) != 0) {
                j11 = Color.Companion.m2955getUnspecified0d7_KjU();
            }
            long j12 = j11;
            if ((i11 & 4) != 0) {
                shadow2 = null;
            } else {
                shadow2 = shadow;
            }
            if ((i11 & 8) != 0) {
                textDecoration2 = null;
            } else {
                textDecoration2 = textDecoration;
            }
            if ((i11 & 16) != 0) {
                drawStyle2 = null;
            } else {
                drawStyle2 = drawStyle;
            }
            paragraph.m4948paintiJQMabo(canvas, j12, shadow2, textDecoration2, drawStyle2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-iJQMabo");
    }
}
