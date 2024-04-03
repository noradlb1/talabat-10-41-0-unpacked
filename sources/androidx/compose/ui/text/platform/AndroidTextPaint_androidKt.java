package androidx.compose.ui.text.platform;

import android.graphics.Paint;
import android.text.TextPaint;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"setAlpha", "", "Landroid/text/TextPaint;", "alpha", "", "toAndroidCap", "Landroid/graphics/Paint$Cap;", "Landroidx/compose/ui/graphics/StrokeCap;", "toAndroidCap-BeK7IIE", "(I)Landroid/graphics/Paint$Cap;", "toAndroidJoin", "Landroid/graphics/Paint$Join;", "Landroidx/compose/ui/graphics/StrokeJoin;", "toAndroidJoin-Ww9F2mQ", "(I)Landroid/graphics/Paint$Join;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidTextPaint_androidKt {
    public static final void setAlpha(@NotNull TextPaint textPaint, float f11) {
        Intrinsics.checkNotNullParameter(textPaint, "<this>");
        if (!Float.isNaN(f11)) {
            textPaint.setAlpha(MathKt__MathJVMKt.roundToInt(RangesKt___RangesKt.coerceIn(f11, 0.0f, 1.0f) * ((float) 255)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: toAndroidCap-BeK7IIE  reason: not valid java name */
    public static final Paint.Cap m5255toAndroidCapBeK7IIE(int i11) {
        StrokeCap.Companion companion = StrokeCap.Companion;
        if (StrokeCap.m3249equalsimpl0(i11, companion.m3253getButtKaPHkGw())) {
            return Paint.Cap.BUTT;
        }
        if (StrokeCap.m3249equalsimpl0(i11, companion.m3254getRoundKaPHkGw())) {
            return Paint.Cap.ROUND;
        }
        if (StrokeCap.m3249equalsimpl0(i11, companion.m3255getSquareKaPHkGw())) {
            return Paint.Cap.SQUARE;
        }
        return Paint.Cap.BUTT;
    }

    /* access modifiers changed from: private */
    /* renamed from: toAndroidJoin-Ww9F2mQ  reason: not valid java name */
    public static final Paint.Join m5256toAndroidJoinWw9F2mQ(int i11) {
        StrokeJoin.Companion companion = StrokeJoin.Companion;
        if (StrokeJoin.m3259equalsimpl0(i11, companion.m3264getMiterLxFBmk8())) {
            return Paint.Join.MITER;
        }
        if (StrokeJoin.m3259equalsimpl0(i11, companion.m3265getRoundLxFBmk8())) {
            return Paint.Join.ROUND;
        }
        if (StrokeJoin.m3259equalsimpl0(i11, companion.m3263getBevelLxFBmk8())) {
            return Paint.Join.BEVEL;
        }
        return Paint.Join.MITER;
    }
}
