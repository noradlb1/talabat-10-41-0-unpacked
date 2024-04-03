package f0;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final /* synthetic */ class b {
    static {
        DrawScope.Companion companion = DrawScope.Companion;
    }

    public static /* synthetic */ void A(DrawScope drawScope, ImageBitmap imageBitmap, long j11, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        long j12;
        float f12;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        int i13;
        if (obj == null) {
            if ((i12 & 2) != 0) {
                j12 = Offset.Companion.m2692getZeroF1C5BW0();
            } else {
                j12 = j11;
            }
            if ((i12 & 4) != 0) {
                f12 = 1.0f;
            } else {
                f12 = f11;
            }
            if ((i12 & 8) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i12 & 16) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i12 & 32) != 0) {
                i13 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i13 = i11;
            }
            drawScope.m3411drawImagegbVJVH8(imageBitmap, j12, f12, drawStyle2, colorFilter2, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
    }

    public static /* synthetic */ void B(DrawScope drawScope, Brush brush, long j11, long j12, float f11, int i11, PathEffect pathEffect, float f12, ColorFilter colorFilter, int i12, int i13, Object obj) {
        float f13;
        int i14;
        PathEffect pathEffect2;
        float f14;
        ColorFilter colorFilter2;
        int i15;
        int i16 = i13;
        if (obj == null) {
            if ((i16 & 8) != 0) {
                f13 = 0.0f;
            } else {
                f13 = f11;
            }
            if ((i16 & 16) != 0) {
                i14 = Stroke.Companion.m3503getDefaultCapKaPHkGw();
            } else {
                i14 = i11;
            }
            if ((i16 & 32) != 0) {
                pathEffect2 = null;
            } else {
                pathEffect2 = pathEffect;
            }
            if ((i16 & 64) != 0) {
                f14 = 1.0f;
            } else {
                f14 = f12;
            }
            if ((i16 & 128) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i16 & 256) != 0) {
                i15 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i15 = i12;
            }
            drawScope.m3412drawLine1RTmtNc(brush, j11, j12, f13, i14, pathEffect2, f14, colorFilter2, i15);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
    }

    public static /* synthetic */ void C(DrawScope drawScope, long j11, long j12, long j13, float f11, int i11, PathEffect pathEffect, float f12, ColorFilter colorFilter, int i12, int i13, Object obj) {
        float f13;
        int i14;
        PathEffect pathEffect2;
        float f14;
        ColorFilter colorFilter2;
        int i15;
        int i16 = i13;
        if (obj == null) {
            if ((i16 & 8) != 0) {
                f13 = 0.0f;
            } else {
                f13 = f11;
            }
            if ((i16 & 16) != 0) {
                i14 = Stroke.Companion.m3503getDefaultCapKaPHkGw();
            } else {
                i14 = i11;
            }
            if ((i16 & 32) != 0) {
                pathEffect2 = null;
            } else {
                pathEffect2 = pathEffect;
            }
            if ((i16 & 64) != 0) {
                f14 = 1.0f;
            } else {
                f14 = f12;
            }
            if ((i16 & 128) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i16 & 256) != 0) {
                i15 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i15 = i12;
            }
            drawScope.m3413drawLineNGM6Ib0(j11, j12, j13, f13, i14, pathEffect2, f14, colorFilter2, i15);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
    }

    public static /* synthetic */ void D(DrawScope drawScope, Brush brush, long j11, long j12, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        long j13;
        long j14;
        float f12;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        int i13;
        if (obj == null) {
            if ((i12 & 2) != 0) {
                j13 = Offset.Companion.m2692getZeroF1C5BW0();
            } else {
                j13 = j11;
            }
            if ((i12 & 4) != 0) {
                DrawScope drawScope2 = drawScope;
                j14 = d(drawScope, drawScope.m3425getSizeNHjbRc(), j13);
            } else {
                DrawScope drawScope3 = drawScope;
                j14 = j12;
            }
            if ((i12 & 8) != 0) {
                f12 = 1.0f;
            } else {
                f12 = f11;
            }
            if ((i12 & 16) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i12 & 32) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i12 & 64) != 0) {
                i13 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i13 = i11;
            }
            drawScope.m3414drawOvalAsUm42w(brush, j13, j14, f12, drawStyle2, colorFilter2, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-AsUm42w");
    }

    public static /* synthetic */ void E(DrawScope drawScope, long j11, long j12, long j13, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        long j14;
        long j15;
        float f12;
        Fill fill;
        ColorFilter colorFilter2;
        int i13;
        if (obj == null) {
            if ((i12 & 2) != 0) {
                j14 = Offset.Companion.m2692getZeroF1C5BW0();
            } else {
                j14 = j12;
            }
            if ((i12 & 4) != 0) {
                DrawScope drawScope2 = drawScope;
                j15 = d(drawScope, drawScope.m3425getSizeNHjbRc(), j14);
            } else {
                DrawScope drawScope3 = drawScope;
                j15 = j13;
            }
            if ((i12 & 8) != 0) {
                f12 = 1.0f;
            } else {
                f12 = f11;
            }
            if ((i12 & 16) != 0) {
                fill = Fill.INSTANCE;
            } else {
                fill = drawStyle;
            }
            if ((i12 & 32) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i12 & 64) != 0) {
                i13 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i13 = i11;
            }
            drawScope.m3415drawOvalnJ9OG0(j11, j14, j15, f12, fill, colorFilter2, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-n-J9OG0");
    }

    public static /* synthetic */ void F(DrawScope drawScope, Path path, Brush brush, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 4) != 0) {
                f11 = 1.0f;
            }
            float f12 = f11;
            if ((i12 & 8) != 0) {
                drawStyle = Fill.INSTANCE;
            }
            DrawStyle drawStyle2 = drawStyle;
            if ((i12 & 16) != 0) {
                colorFilter = null;
            }
            ColorFilter colorFilter2 = colorFilter;
            if ((i12 & 32) != 0) {
                i11 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            }
            drawScope.m3416drawPathGBMwjPU(path, brush, f12, drawStyle2, colorFilter2, i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
    }

    public static /* synthetic */ void G(DrawScope drawScope, Path path, long j11, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        float f12;
        Fill fill;
        ColorFilter colorFilter2;
        int i13;
        if (obj == null) {
            if ((i12 & 4) != 0) {
                f12 = 1.0f;
            } else {
                f12 = f11;
            }
            if ((i12 & 8) != 0) {
                fill = Fill.INSTANCE;
            } else {
                fill = drawStyle;
            }
            if ((i12 & 16) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i12 & 32) != 0) {
                i13 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i13 = i11;
            }
            drawScope.m3417drawPathLG529CI(path, j11, f12, fill, colorFilter2, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
    }

    public static /* synthetic */ void H(DrawScope drawScope, List list, int i11, long j11, float f11, int i12, PathEffect pathEffect, float f12, ColorFilter colorFilter, int i13, int i14, Object obj) {
        float f13;
        int i15;
        PathEffect pathEffect2;
        float f14;
        ColorFilter colorFilter2;
        int i16;
        int i17 = i14;
        if (obj == null) {
            if ((i17 & 8) != 0) {
                f13 = 0.0f;
            } else {
                f13 = f11;
            }
            if ((i17 & 16) != 0) {
                i15 = StrokeCap.Companion.m3253getButtKaPHkGw();
            } else {
                i15 = i12;
            }
            if ((i17 & 32) != 0) {
                pathEffect2 = null;
            } else {
                pathEffect2 = pathEffect;
            }
            if ((i17 & 64) != 0) {
                f14 = 1.0f;
            } else {
                f14 = f12;
            }
            if ((i17 & 128) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i17 & 256) != 0) {
                i16 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i16 = i13;
            }
            drawScope.m3418drawPointsF8ZwMP8(list, i11, j11, f13, i15, pathEffect2, f14, colorFilter2, i16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
    }

    public static /* synthetic */ void I(DrawScope drawScope, List list, int i11, Brush brush, float f11, int i12, PathEffect pathEffect, float f12, ColorFilter colorFilter, int i13, int i14, Object obj) {
        float f13;
        int i15;
        PathEffect pathEffect2;
        float f14;
        ColorFilter colorFilter2;
        int i16;
        int i17 = i14;
        if (obj == null) {
            if ((i17 & 8) != 0) {
                f13 = 0.0f;
            } else {
                f13 = f11;
            }
            if ((i17 & 16) != 0) {
                i15 = StrokeCap.Companion.m3253getButtKaPHkGw();
            } else {
                i15 = i12;
            }
            if ((i17 & 32) != 0) {
                pathEffect2 = null;
            } else {
                pathEffect2 = pathEffect;
            }
            if ((i17 & 64) != 0) {
                f14 = 1.0f;
            } else {
                f14 = f12;
            }
            if ((i17 & 128) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i17 & 256) != 0) {
                i16 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i16 = i13;
            }
            drawScope.m3419drawPointsGsft0Ws(list, i11, brush, f13, i15, pathEffect2, f14, colorFilter2, i16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-Gsft0Ws");
    }

    public static /* synthetic */ void J(DrawScope drawScope, Brush brush, long j11, long j12, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        long j13;
        long j14;
        float f12;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        int i13;
        if (obj == null) {
            if ((i12 & 2) != 0) {
                j13 = Offset.Companion.m2692getZeroF1C5BW0();
            } else {
                j13 = j11;
            }
            if ((i12 & 4) != 0) {
                DrawScope drawScope2 = drawScope;
                j14 = d(drawScope, drawScope.m3425getSizeNHjbRc(), j13);
            } else {
                DrawScope drawScope3 = drawScope;
                j14 = j12;
            }
            if ((i12 & 8) != 0) {
                f12 = 1.0f;
            } else {
                f12 = f11;
            }
            if ((i12 & 16) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i12 & 32) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i12 & 64) != 0) {
                i13 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i13 = i11;
            }
            drawScope.m3420drawRectAsUm42w(brush, j13, j14, f12, drawStyle2, colorFilter2, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
    }

    public static /* synthetic */ void K(DrawScope drawScope, long j11, long j12, long j13, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        long j14;
        long j15;
        float f12;
        Fill fill;
        ColorFilter colorFilter2;
        int i13;
        if (obj == null) {
            if ((i12 & 2) != 0) {
                j14 = Offset.Companion.m2692getZeroF1C5BW0();
            } else {
                j14 = j12;
            }
            if ((i12 & 4) != 0) {
                DrawScope drawScope2 = drawScope;
                j15 = d(drawScope, drawScope.m3425getSizeNHjbRc(), j14);
            } else {
                DrawScope drawScope3 = drawScope;
                j15 = j13;
            }
            if ((i12 & 8) != 0) {
                f12 = 1.0f;
            } else {
                f12 = f11;
            }
            if ((i12 & 16) != 0) {
                fill = Fill.INSTANCE;
            } else {
                fill = drawStyle;
            }
            if ((i12 & 32) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i12 & 64) != 0) {
                i13 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i13 = i11;
            }
            drawScope.m3421drawRectnJ9OG0(j11, j14, j15, f12, fill, colorFilter2, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
    }

    public static /* synthetic */ void L(DrawScope drawScope, Brush brush, long j11, long j12, long j13, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        long j14;
        long j15;
        long j16;
        float f12;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        int i13;
        int i14 = i12;
        if (obj == null) {
            if ((i14 & 2) != 0) {
                j14 = Offset.Companion.m2692getZeroF1C5BW0();
            } else {
                j14 = j11;
            }
            if ((i14 & 4) != 0) {
                DrawScope drawScope2 = drawScope;
                j15 = d(drawScope, drawScope.m3425getSizeNHjbRc(), j14);
            } else {
                DrawScope drawScope3 = drawScope;
                j15 = j12;
            }
            if ((i14 & 8) != 0) {
                j16 = CornerRadius.Companion.m2661getZerokKHJgLs();
            } else {
                j16 = j13;
            }
            if ((i14 & 16) != 0) {
                f12 = 1.0f;
            } else {
                f12 = f11;
            }
            if ((i14 & 32) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i14 & 64) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i14 & 128) != 0) {
                i13 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i13 = i11;
            }
            drawScope.m3422drawRoundRectZuiqVtQ(brush, j14, j15, j16, f12, drawStyle2, colorFilter2, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
    }

    public static /* synthetic */ void M(DrawScope drawScope, long j11, long j12, long j13, long j14, DrawStyle drawStyle, float f11, ColorFilter colorFilter, int i11, int i12, Object obj) {
        long j15;
        long j16;
        long j17;
        Fill fill;
        float f12;
        ColorFilter colorFilter2;
        int i13;
        int i14 = i12;
        if (obj == null) {
            if ((i14 & 2) != 0) {
                j15 = Offset.Companion.m2692getZeroF1C5BW0();
            } else {
                j15 = j12;
            }
            if ((i14 & 4) != 0) {
                j16 = d(drawScope, drawScope.m3425getSizeNHjbRc(), j15);
            } else {
                DrawScope drawScope2 = drawScope;
                j16 = j13;
            }
            if ((i14 & 8) != 0) {
                j17 = CornerRadius.Companion.m2661getZerokKHJgLs();
            } else {
                j17 = j14;
            }
            if ((i14 & 16) != 0) {
                fill = Fill.INSTANCE;
            } else {
                fill = drawStyle;
            }
            if ((i14 & 32) != 0) {
                f12 = 1.0f;
            } else {
                f12 = f11;
            }
            if ((i14 & 64) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i14 & 128) != 0) {
                i13 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i13 = i11;
            }
            drawScope.m3423drawRoundRectuAw5IA(j11, j15, j16, j17, fill, f12, colorFilter2, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
    }

    public static void a(DrawScope drawScope, @NotNull ImageBitmap imageBitmap, long j11, long j12, long j13, long j14, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11, int i12) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        z(drawScope, imageBitmap, j11, j12, j13, j14, f11, drawStyle, colorFilter, i11, 0, 512, (Object) null);
    }

    public static long b(DrawScope drawScope) {
        return SizeKt.m2755getCenteruvyYCjk(drawScope.getDrawContext().m3403getSizeNHjbRc());
    }

    public static long c(DrawScope drawScope) {
        return drawScope.getDrawContext().m3403getSizeNHjbRc();
    }

    public static long d(DrawScope drawScope, long j11, long j12) {
        return SizeKt.Size(Size.m2745getWidthimpl(j11) - Offset.m2676getXimpl(j12), Size.m2742getHeightimpl(j11) - Offset.m2677getYimpl(j12));
    }

    public static /* synthetic */ void u(DrawScope drawScope, Brush brush, float f11, float f12, boolean z11, long j11, long j12, float f13, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        long j13;
        long j14;
        float f14;
        Fill fill;
        ColorFilter colorFilter2;
        int i13;
        int i14 = i12;
        if (obj == null) {
            if ((i14 & 16) != 0) {
                j13 = Offset.Companion.m2692getZeroF1C5BW0();
            } else {
                j13 = j11;
            }
            if ((i14 & 32) != 0) {
                j14 = d(drawScope, drawScope.m3425getSizeNHjbRc(), j13);
            } else {
                DrawScope drawScope2 = drawScope;
                j14 = j12;
            }
            if ((i14 & 64) != 0) {
                f14 = 1.0f;
            } else {
                f14 = f13;
            }
            if ((i14 & 128) != 0) {
                fill = Fill.INSTANCE;
            } else {
                fill = drawStyle;
            }
            if ((i14 & 256) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i14 & 512) != 0) {
                i13 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i13 = i11;
            }
            drawScope.m3405drawArcillE91I(brush, f11, f12, z11, j13, j14, f14, fill, colorFilter2, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
    }

    public static /* synthetic */ void v(DrawScope drawScope, long j11, float f11, float f12, boolean z11, long j12, long j13, float f13, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        long j14;
        long j15;
        float f14;
        Fill fill;
        ColorFilter colorFilter2;
        int i13;
        int i14 = i12;
        if (obj == null) {
            if ((i14 & 16) != 0) {
                j14 = Offset.Companion.m2692getZeroF1C5BW0();
            } else {
                j14 = j12;
            }
            if ((i14 & 32) != 0) {
                j15 = d(drawScope, drawScope.m3425getSizeNHjbRc(), j14);
            } else {
                DrawScope drawScope2 = drawScope;
                j15 = j13;
            }
            if ((i14 & 64) != 0) {
                f14 = 1.0f;
            } else {
                f14 = f13;
            }
            if ((i14 & 128) != 0) {
                fill = Fill.INSTANCE;
            } else {
                fill = drawStyle;
            }
            if ((i14 & 256) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i14 & 512) != 0) {
                i13 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i13 = i11;
            }
            drawScope.m3406drawArcyD3GUKo(j11, f11, f12, z11, j14, j15, f14, fill, colorFilter2, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
    }

    public static /* synthetic */ void w(DrawScope drawScope, Brush brush, float f11, long j11, float f12, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        float f13;
        long j12;
        float f14;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        int i13;
        if (obj == null) {
            if ((i12 & 2) != 0) {
                f13 = Size.m2744getMinDimensionimpl(drawScope.m3425getSizeNHjbRc()) / 2.0f;
            } else {
                f13 = f11;
            }
            if ((i12 & 4) != 0) {
                j12 = drawScope.m3424getCenterF1C5BW0();
            } else {
                j12 = j11;
            }
            if ((i12 & 8) != 0) {
                f14 = 1.0f;
            } else {
                f14 = f12;
            }
            if ((i12 & 16) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i12 & 32) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i12 & 64) != 0) {
                i13 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i13 = i11;
            }
            drawScope.m3407drawCircleV9BoPsw(brush, f13, j12, f14, drawStyle2, colorFilter2, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
    }

    public static /* synthetic */ void x(DrawScope drawScope, long j11, float f11, long j12, float f12, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        float f13;
        long j13;
        float f14;
        Fill fill;
        ColorFilter colorFilter2;
        int i13;
        if (obj == null) {
            if ((i12 & 2) != 0) {
                f13 = Size.m2744getMinDimensionimpl(drawScope.m3425getSizeNHjbRc()) / 2.0f;
            } else {
                f13 = f11;
            }
            if ((i12 & 4) != 0) {
                j13 = drawScope.m3424getCenterF1C5BW0();
            } else {
                j13 = j12;
            }
            if ((i12 & 8) != 0) {
                f14 = 1.0f;
            } else {
                f14 = f12;
            }
            if ((i12 & 16) != 0) {
                fill = Fill.INSTANCE;
            } else {
                fill = drawStyle;
            }
            if ((i12 & 32) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i12 & 64) != 0) {
                i13 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i13 = i11;
            }
            drawScope.m3408drawCircleVaOC9Bg(j11, f13, j13, f14, fill, colorFilter2, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
    }

    public static /* synthetic */ void y(DrawScope drawScope, ImageBitmap imageBitmap, long j11, long j12, long j13, long j14, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        long j15;
        long j16;
        long j17;
        long j18;
        float f12;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        int i13;
        int i14 = i12;
        if (obj == null) {
            if ((i14 & 2) != 0) {
                j15 = IntOffset.Companion.m5606getZeronOccac();
            } else {
                j15 = j11;
            }
            if ((i14 & 4) != 0) {
                j16 = IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight());
            } else {
                j16 = j12;
            }
            if ((i14 & 8) != 0) {
                j17 = IntOffset.Companion.m5606getZeronOccac();
            } else {
                j17 = j13;
            }
            if ((i14 & 16) != 0) {
                j18 = j16;
            } else {
                j18 = j14;
            }
            if ((i14 & 32) != 0) {
                f12 = 1.0f;
            } else {
                f12 = f11;
            }
            if ((i14 & 64) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i14 & 128) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i14 & 256) != 0) {
                i13 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i13 = i11;
            }
            drawScope.m3409drawImage9jGpkUE(imageBitmap, j15, j16, j17, j18, f12, drawStyle2, colorFilter2, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-9jGpkUE");
    }

    public static /* synthetic */ void z(DrawScope drawScope, ImageBitmap imageBitmap, long j11, long j12, long j13, long j14, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, int i13, Object obj) {
        long j15;
        long j16;
        long j17;
        long j18;
        float f12;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        int i14;
        int i15;
        int i16 = i13;
        if (obj == null) {
            if ((i16 & 2) != 0) {
                j15 = IntOffset.Companion.m5606getZeronOccac();
            } else {
                j15 = j11;
            }
            if ((i16 & 4) != 0) {
                j16 = IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight());
            } else {
                j16 = j12;
            }
            if ((i16 & 8) != 0) {
                j17 = IntOffset.Companion.m5606getZeronOccac();
            } else {
                j17 = j13;
            }
            if ((i16 & 16) != 0) {
                j18 = j16;
            } else {
                j18 = j14;
            }
            if ((i16 & 32) != 0) {
                f12 = 1.0f;
            } else {
                f12 = f11;
            }
            if ((i16 & 64) != 0) {
                drawStyle2 = Fill.INSTANCE;
            } else {
                drawStyle2 = drawStyle;
            }
            if ((i16 & 128) != 0) {
                colorFilter2 = null;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((i16 & 256) != 0) {
                i14 = DrawScope.Companion.m3426getDefaultBlendMode0nO6VwU();
            } else {
                i14 = i11;
            }
            if ((i16 & 512) != 0) {
                i15 = DrawScope.Companion.m3427getDefaultFilterQualityfv9h1I();
            } else {
                i15 = i12;
            }
            drawScope.m3410drawImageAZ2fEMs(imageBitmap, j15, j16, j17, j18, f12, drawStyle2, colorFilter2, i14, i15);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
    }
}
