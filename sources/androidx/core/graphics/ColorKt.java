package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.apptimize.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0019H\n\u001a\r\u0010\u0018\u001a\u00020\u0001*\u00020\u0001H\n\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0005H\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0019H\n\u001a\r\u0010\u001a\u001a\u00020\u0001*\u00020\u0001H\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0005H\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0019H\n\u001a\r\u0010\u001b\u001a\u00020\u0001*\u00020\u0001H\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0005H\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0019H\n\u001a\r\u0010\u001c\u001a\u00020\u0001*\u00020\u0001H\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0005H\n\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\f\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\u001eH\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\u001eH\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u001eH\f\u001a\u0015\u0010\u001f\u001a\u00020\u0019*\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0002\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0001H\b\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0005H\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020\u0005H\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020#H\b\u001a\r\u0010$\u001a\u00020\u0005*\u00020\u0001H\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0000\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\"\u0016\u0010\u000f\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00018Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006\"\u0016\u0010\u0016\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006¨\u0006%"}, d2 = {"alpha", "", "getAlpha", "(I)I", "", "", "(J)F", "blue", "getBlue", "colorSpace", "Landroid/graphics/ColorSpace;", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "green", "getGreen", "isSrgb", "", "(J)Z", "isWideGamut", "luminance", "getLuminance", "(I)F", "red", "getRed", "component1", "Landroid/graphics/Color;", "component2", "component3", "component4", "convertTo", "Landroid/graphics/ColorSpace$Named;", "plus", "c", "toColor", "toColorInt", "", "toColorLong", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ColorKt {
    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component1(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        return color.getComponent(0);
    }

    public static final int component1(@ColorInt int i11) {
        return (i11 >> 24) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component2(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        return color.getComponent(1);
    }

    public static final int component2(@ColorInt int i11) {
        return (i11 >> 16) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component3(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        return color.getComponent(2);
    }

    public static final int component3(@ColorInt int i11) {
        return (i11 >> 8) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component4(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        return color.getComponent(3);
    }

    public static final int component4(@ColorInt int i11) {
        return i11 & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(@ColorInt int i11, @NotNull ColorSpace.Named named) {
        Intrinsics.checkNotNullParameter(named, "colorSpace");
        return Color.convert(i11, ColorSpace.get(named));
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getAlpha(long j11) {
        return Color.alpha(j11);
    }

    public static final int getAlpha(@ColorInt int i11) {
        return (i11 >> 24) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getBlue(long j11) {
        return Color.blue(j11);
    }

    public static final int getBlue(@ColorInt int i11) {
        return i11 & 255;
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final ColorSpace getColorSpace(long j11) {
        ColorSpace a11 = Color.colorSpace(j11);
        Intrinsics.checkNotNullExpressionValue(a11, "colorSpace(this)");
        return a11;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getGreen(long j11) {
        return Color.green(j11);
    }

    public static final int getGreen(@ColorInt int i11) {
        return (i11 >> 8) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getLuminance(@ColorInt int i11) {
        return Color.luminance(i11);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getRed(long j11) {
        return Color.red(j11);
    }

    public static final int getRed(@ColorInt int i11) {
        return (i11 >> 16) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean isSrgb(long j11) {
        return Color.isSrgb(j11);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean isWideGamut(long j11) {
        return Color.isWideGamut(j11);
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color plus(@NotNull Color color, @NotNull Color color2) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        Intrinsics.checkNotNullParameter(color2, c.f41585a);
        Color compositeColors = ColorUtils.compositeColors(color2, color);
        Intrinsics.checkNotNullExpressionValue(compositeColors, "compositeColors(c, this)");
        return compositeColors;
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color toColor(@ColorInt int i11) {
        Color a11 = Color.valueOf(i11);
        Intrinsics.checkNotNullExpressionValue(a11, "valueOf(this)");
        return a11;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @ColorInt
    public static final int toColorInt(long j11) {
        return Color.toArgb(j11);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long toColorLong(@ColorInt int i11) {
        return Color.pack(i11);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component1(long j11) {
        return Color.red(j11);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component2(long j11) {
        return Color.green(j11);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component3(long j11) {
        return Color.blue(j11);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component4(long j11) {
        return Color.alpha(j11);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(@ColorInt int i11, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return Color.convert(i11, colorSpace);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getLuminance(long j11) {
        return Color.luminance(j11);
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color toColor(long j11) {
        Color a11 = Color.valueOf(j11);
        Intrinsics.checkNotNullExpressionValue(a11, "valueOf(this)");
        return a11;
    }

    @ColorInt
    public static final int toColorInt(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(long j11, @NotNull ColorSpace.Named named) {
        Intrinsics.checkNotNullParameter(named, "colorSpace");
        return Color.convert(j11, ColorSpace.get(named));
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(long j11, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return Color.convert(j11, colorSpace);
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color convertTo(@NotNull Color color, @NotNull ColorSpace.Named named) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        Intrinsics.checkNotNullParameter(named, "colorSpace");
        Color a11 = color.convert(ColorSpace.get(named));
        Intrinsics.checkNotNullExpressionValue(a11, "convert(ColorSpace.get(colorSpace))");
        return a11;
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color convertTo(@NotNull Color color, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(color, "<this>");
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        Color a11 = color.convert(colorSpace);
        Intrinsics.checkNotNullExpressionValue(a11, "convert(colorSpace)");
        return a11;
    }
}
