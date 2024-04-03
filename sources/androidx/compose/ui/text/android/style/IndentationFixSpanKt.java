package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import android.text.Layout;
import androidx.compose.ui.text.android.TextLayoutKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001e\u0010\t\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"EllipsisChar", "", "getEllipsizedLeftPadding", "", "Landroid/text/Layout;", "lineIndex", "", "paint", "Landroid/graphics/Paint;", "getEllipsizedRightPadding", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class IndentationFixSpanKt {
    @NotNull
    private static final String EllipsisChar = "…";

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final float getEllipsizedLeftPadding(@NotNull Layout layout, int i11, @NotNull Paint paint) {
        int i12;
        float f11;
        float f12;
        Intrinsics.checkNotNullParameter(layout, "<this>");
        Intrinsics.checkNotNullParameter(paint, "paint");
        float lineLeft = layout.getLineLeft(i11);
        if (!TextLayoutKt.isLineEllipsized(layout, i11) || layout.getParagraphDirection(i11) != 1 || lineLeft >= 0.0f) {
            return 0.0f;
        }
        float primaryHorizontal = (layout.getPrimaryHorizontal(layout.getLineStart(i11) + layout.getEllipsisStart(i11)) - lineLeft) + paint.measureText("…");
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i11);
        if (paragraphAlignment == null) {
            i12 = -1;
        } else {
            i12 = WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()];
        }
        if (i12 == 1) {
            f11 = Math.abs(lineLeft);
            f12 = (((float) layout.getWidth()) - primaryHorizontal) / 2.0f;
        } else {
            f11 = Math.abs(lineLeft);
            f12 = ((float) layout.getWidth()) - primaryHorizontal;
        }
        return f11 + f12;
    }

    public static /* synthetic */ float getEllipsizedLeftPadding$default(Layout layout, int i11, Paint paint, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            paint = layout.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "this.paint");
        }
        return getEllipsizedLeftPadding(layout, i11, paint);
    }

    public static final float getEllipsizedRightPadding(@NotNull Layout layout, int i11, @NotNull Paint paint) {
        float f11;
        float f12;
        Intrinsics.checkNotNullParameter(layout, "<this>");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (!TextLayoutKt.isLineEllipsized(layout, i11)) {
            return 0.0f;
        }
        int i12 = -1;
        if (layout.getParagraphDirection(i11) != -1 || ((float) layout.getWidth()) >= layout.getLineRight(i11)) {
            return 0.0f;
        }
        float lineRight = (layout.getLineRight(i11) - layout.getPrimaryHorizontal(layout.getLineStart(i11) + layout.getEllipsisStart(i11))) + paint.measureText("…");
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i11);
        if (paragraphAlignment != null) {
            i12 = WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()];
        }
        if (i12 == 1) {
            f11 = ((float) layout.getWidth()) - layout.getLineRight(i11);
            f12 = (((float) layout.getWidth()) - lineRight) / 2.0f;
        } else {
            f11 = ((float) layout.getWidth()) - layout.getLineRight(i11);
            f12 = ((float) layout.getWidth()) - lineRight;
        }
        return f11 - f12;
    }

    public static /* synthetic */ float getEllipsizedRightPadding$default(Layout layout, int i11, Paint paint, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            paint = layout.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "this.paint");
        }
        return getEllipsizedRightPadding(layout, i11, paint);
    }
}
