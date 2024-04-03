package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u0005*\u00060\u0003j\u0002`\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\b*\u00060\u0003j\u0002`\u0006H\u0000\u001a\u0018\u0010\t\u001a\u00020\n*\u00060\u0003j\u0002`\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\f\u001a\u00020\r*\u00060\u0003j\u0002`\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0018\u0010\u000f\u001a\u00020\u0010*\u00060\u0003j\u0002`\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0018\u0010\u0011\u001a\u00020\u0012*\u00060\u0003j\u0002`\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0010\u0010\u0013\u001a\u00020\u0005*\u00060\u0003j\u0002`\u0006H\u0000\u001a\u0010\u0010\u0014\u001a\u00020\u0005*\u00060\u0003j\u0002`\u0006H\u0000\u001a\u0018\u0010\u0015\u001a\u00020\u0016*\u00060\u0003j\u0002`\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0018\u0010\u0017\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0000\u001a%\u0010\u001b\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010 \u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\nH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001a\u0010#\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010$H\u0000\u001a%\u0010%\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\rH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u001f\u001a\u001a\u0010'\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010(H\u0000\u001a \u0010)\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u000e\u0010\u0019\u001a\n\u0018\u00010*j\u0004\u0018\u0001`+H\u0000\u001a%\u0010,\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\u0010H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010\u001f\u001a%\u0010.\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\u0012H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u001f\u001a\u0018\u00100\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\u0005H\u0000\u001a\u0018\u00101\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\u0005H\u0000\u001a%\u00102\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\u0016H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u0010\u001f*\n\u00104\"\u00020\u00032\u00020\u0003\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"Paint", "Landroidx/compose/ui/graphics/Paint;", "makeNativePaint", "Landroid/graphics/Paint;", "getNativeAlpha", "", "Landroidx/compose/ui/graphics/NativePaint;", "getNativeAntiAlias", "", "getNativeColor", "Landroidx/compose/ui/graphics/Color;", "(Landroid/graphics/Paint;)J", "getNativeFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "(Landroid/graphics/Paint;)I", "getNativeStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getNativeStrokeJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getNativeStrokeMiterLimit", "getNativeStrokeWidth", "getNativeStyle", "Landroidx/compose/ui/graphics/PaintingStyle;", "setNativeAlpha", "", "value", "setNativeAntiAlias", "setNativeBlendMode", "mode", "Landroidx/compose/ui/graphics/BlendMode;", "setNativeBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "setNativeColor", "setNativeColor-4WTKRHQ", "(Landroid/graphics/Paint;J)V", "setNativeColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "setNativeFilterQuality", "setNativeFilterQuality-50PEsBU", "setNativePathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "setNativeShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "setNativeStrokeCap", "setNativeStrokeCap-CSYIeUk", "setNativeStrokeJoin", "setNativeStrokeJoin-kLtJ_vA", "setNativeStrokeMiterLimit", "setNativeStrokeWidth", "setNativeStyle", "setNativeStyle--5YerkU", "NativePaint", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidPaint_androidKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Paint.Style.values().length];
            iArr[Paint.Style.STROKE.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Paint.Cap.values().length];
            iArr2[Paint.Cap.BUTT.ordinal()] = 1;
            iArr2[Paint.Cap.ROUND.ordinal()] = 2;
            iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Paint.Join.values().length];
            iArr3[Paint.Join.MITER.ordinal()] = 1;
            iArr3[Paint.Join.BEVEL.ordinal()] = 2;
            iArr3[Paint.Join.ROUND.ordinal()] = 3;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @NotNull
    public static final Paint Paint() {
        return new AndroidPaint();
    }

    public static final float getNativeAlpha(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return ((float) paint.getAlpha()) / 255.0f;
    }

    public static final boolean getNativeAntiAlias(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return paint.isAntiAlias();
    }

    public static final long getNativeColor(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return ColorKt.Color(paint.getColor());
    }

    public static final int getNativeFilterQuality(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        if (!paint.isFilterBitmap()) {
            return FilterQuality.Companion.m3007getNonefv9h1I();
        }
        return FilterQuality.Companion.m3005getLowfv9h1I();
    }

    public static final int getNativeStrokeCap(@NotNull Paint paint) {
        int i11;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        Paint.Cap strokeCap = paint.getStrokeCap();
        if (strokeCap == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()];
        }
        if (i11 == 1) {
            return StrokeCap.Companion.m3253getButtKaPHkGw();
        }
        if (i11 == 2) {
            return StrokeCap.Companion.m3254getRoundKaPHkGw();
        }
        if (i11 != 3) {
            return StrokeCap.Companion.m3253getButtKaPHkGw();
        }
        return StrokeCap.Companion.m3255getSquareKaPHkGw();
    }

    public static final int getNativeStrokeJoin(@NotNull Paint paint) {
        int i11;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        Paint.Join strokeJoin = paint.getStrokeJoin();
        if (strokeJoin == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        }
        if (i11 == 1) {
            return StrokeJoin.Companion.m3264getMiterLxFBmk8();
        }
        if (i11 == 2) {
            return StrokeJoin.Companion.m3263getBevelLxFBmk8();
        }
        if (i11 != 3) {
            return StrokeJoin.Companion.m3264getMiterLxFBmk8();
        }
        return StrokeJoin.Companion.m3265getRoundLxFBmk8();
    }

    public static final float getNativeStrokeMiterLimit(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return paint.getStrokeMiter();
    }

    public static final float getNativeStrokeWidth(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return paint.getStrokeWidth();
    }

    public static final int getNativeStyle(@NotNull Paint paint) {
        int i11;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        Paint.Style style = paint.getStyle();
        if (style == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
        }
        if (i11 == 1) {
            return PaintingStyle.Companion.m3149getStrokeTiuSbCo();
        }
        return PaintingStyle.Companion.m3148getFillTiuSbCo();
    }

    @NotNull
    public static final Paint makeNativePaint() {
        return new Paint(7);
    }

    public static final void setNativeAlpha(@NotNull Paint paint, float f11) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setAlpha((int) ((float) Math.rint((double) (f11 * 255.0f))));
    }

    public static final void setNativeAntiAlias(@NotNull Paint paint, boolean z11) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setAntiAlias(z11);
    }

    /* renamed from: setNativeBlendMode-GB0RdKg  reason: not valid java name */
    public static final void m2802setNativeBlendModeGB0RdKg(@NotNull Paint paint, int i11) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeBlendMode");
        if (Build.VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.INSTANCE.m3304setBlendModeGB0RdKg(paint, i11);
        } else {
            paint.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m2769toPorterDuffModes9anfk8(i11)));
        }
    }

    /* renamed from: setNativeColor-4WTKRHQ  reason: not valid java name */
    public static final void m2803setNativeColor4WTKRHQ(@NotNull Paint paint, long j11) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeColor");
        paint.setColor(ColorKt.m2974toArgb8_81llA(j11));
    }

    public static final void setNativeColorFilter(@NotNull Paint paint, @Nullable ColorFilter colorFilter) {
        ColorFilter colorFilter2;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        if (colorFilter != null) {
            colorFilter2 = AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter);
        } else {
            colorFilter2 = null;
        }
        paint.setColorFilter(colorFilter2);
    }

    /* renamed from: setNativeFilterQuality-50PEsBU  reason: not valid java name */
    public static final void m2804setNativeFilterQuality50PEsBU(@NotNull Paint paint, int i11) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeFilterQuality");
        paint.setFilterBitmap(!FilterQuality.m3000equalsimpl0(i11, FilterQuality.Companion.m3007getNonefv9h1I()));
    }

    public static final void setNativePathEffect(@NotNull Paint paint, @Nullable PathEffect pathEffect) {
        PathEffect pathEffect2;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        AndroidPathEffect androidPathEffect = (AndroidPathEffect) pathEffect;
        if (androidPathEffect != null) {
            pathEffect2 = androidPathEffect.getNativePathEffect();
        } else {
            pathEffect2 = null;
        }
        paint.setPathEffect(pathEffect2);
    }

    public static final void setNativeShader(@NotNull Paint paint, @Nullable Shader shader) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setShader(shader);
    }

    /* renamed from: setNativeStrokeCap-CSYIeUk  reason: not valid java name */
    public static final void m2805setNativeStrokeCapCSYIeUk(@NotNull Paint paint, int i11) {
        Paint.Cap cap;
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeStrokeCap");
        StrokeCap.Companion companion = StrokeCap.Companion;
        if (StrokeCap.m3249equalsimpl0(i11, companion.m3255getSquareKaPHkGw())) {
            cap = Paint.Cap.SQUARE;
        } else if (StrokeCap.m3249equalsimpl0(i11, companion.m3254getRoundKaPHkGw())) {
            cap = Paint.Cap.ROUND;
        } else if (StrokeCap.m3249equalsimpl0(i11, companion.m3253getButtKaPHkGw())) {
            cap = Paint.Cap.BUTT;
        } else {
            cap = Paint.Cap.BUTT;
        }
        paint.setStrokeCap(cap);
    }

    /* renamed from: setNativeStrokeJoin-kLtJ_vA  reason: not valid java name */
    public static final void m2806setNativeStrokeJoinkLtJ_vA(@NotNull Paint paint, int i11) {
        Paint.Join join;
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeStrokeJoin");
        StrokeJoin.Companion companion = StrokeJoin.Companion;
        if (StrokeJoin.m3259equalsimpl0(i11, companion.m3264getMiterLxFBmk8())) {
            join = Paint.Join.MITER;
        } else if (StrokeJoin.m3259equalsimpl0(i11, companion.m3263getBevelLxFBmk8())) {
            join = Paint.Join.BEVEL;
        } else if (StrokeJoin.m3259equalsimpl0(i11, companion.m3265getRoundLxFBmk8())) {
            join = Paint.Join.ROUND;
        } else {
            join = Paint.Join.MITER;
        }
        paint.setStrokeJoin(join);
    }

    public static final void setNativeStrokeMiterLimit(@NotNull Paint paint, float f11) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setStrokeMiter(f11);
    }

    public static final void setNativeStrokeWidth(@NotNull Paint paint, float f11) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setStrokeWidth(f11);
    }

    /* renamed from: setNativeStyle--5YerkU  reason: not valid java name */
    public static final void m2807setNativeStyle5YerkU(@NotNull Paint paint, int i11) {
        Paint.Style style;
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeStyle");
        if (PaintingStyle.m3144equalsimpl0(i11, PaintingStyle.Companion.m3149getStrokeTiuSbCo())) {
            style = Paint.Style.STROKE;
        } else {
            style = Paint.Style.FILL;
        }
        paint.setStyle(style);
    }
}
