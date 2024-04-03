package com.skydoves.landscapist;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import f0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0014R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR+\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0016\u001a\u00020\u00138VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/skydoves/landscapist/CircularRevealedPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "d", "Landroidx/compose/ui/graphics/ImageBitmap;", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "", "<set-?>", "radius$delegate", "Landroidx/compose/runtime/MutableState;", "getRadius", "()F", "setRadius", "(F)V", "radius", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "intrinsicSize", "<init>", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/graphics/painter/Painter;)V", "landscapist_release"}, k = 1, mv = {1, 5, 1})
public final class CircularRevealedPainter extends Painter {
    @NotNull
    private final ImageBitmap imageBitmap;
    @NotNull
    private final Painter painter;
    @NotNull
    private final MutableState radius$delegate = SnapshotStateKt.mutableStateOf(Float.valueOf(0.0f), SnapshotStateKt.neverEqualPolicy());

    public CircularRevealedPainter(@NotNull ImageBitmap imageBitmap2, @NotNull Painter painter2) {
        Intrinsics.checkNotNullParameter(imageBitmap2, "imageBitmap");
        Intrinsics.checkNotNullParameter(painter2, "painter");
        this.imageBitmap = imageBitmap2;
        this.painter = painter2;
    }

    public void d(@NotNull DrawScope drawScope) {
        float f11;
        float f12;
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Paint paint = (Paint) CircularRevealedPainterKt.paintPool.acquire();
        if (paint == null) {
            paint = AndroidPaint_androidKt.Paint();
        }
        Paint paint2 = paint;
        Intrinsics.checkNotNullExpressionValue(paint2, "paintPool.acquire() ?: Paint()");
        Matrix matrix = new Matrix();
        try {
            Shader r32 = ShaderKt.m3219ImageShaderF49vj9s$default(this.imageBitmap, TileMode.Companion.m3274getClamp3opZhB0(), 0, 4, (Object) null);
            ShaderBrush ShaderBrush = BrushKt.ShaderBrush(r32);
            android.graphics.Paint asFrameworkPaint = paint2.asFrameworkPaint();
            asFrameworkPaint.setAntiAlias(true);
            asFrameworkPaint.setDither(true);
            asFrameworkPaint.setFilterBitmap(true);
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            canvas.saveLayer(SizeKt.m2766toRectuvyYCjk(drawScope.m3425getSizeNHjbRc()), paint2);
            float f13 = 0.0f;
            RectF rectF = new RectF(0.0f, 0.0f, Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()), Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc()));
            float width = (float) AndroidImageBitmap_androidKt.asAndroidBitmap(this.imageBitmap).getWidth();
            float height = (float) AndroidImageBitmap_androidKt.asAndroidBitmap(this.imageBitmap).getHeight();
            if (rectF.height() * width > rectF.width() * height) {
                f11 = rectF.height() / height;
                f12 = 0.0f;
                f13 = (rectF.width() - (width * f11)) * 0.5f;
            } else {
                f11 = rectF.width() / width;
                f12 = (rectF.height() - (height * f11)) * 0.5f;
            }
            matrix.setScale(f11, f11);
            matrix.postTranslate(f13 + 0.5f + rectF.left, f12 + 0.5f + rectF.top);
            r32.setLocalMatrix(matrix);
            float f14 = (float) 2;
            b.w(drawScope, ShaderBrush, RangesKt___RangesKt.coerceAtLeast(Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()), Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc())) * getRadius(), OffsetKt.Offset(Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()) / f14, Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc()) / f14), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
            canvas.restore();
        } finally {
            paint2.asFrameworkPaint().reset();
            CircularRevealedPainterKt.paintPool.release(paint2);
        }
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m9392getIntrinsicSizeNHjbRc() {
        return this.painter.m3516getIntrinsicSizeNHjbRc();
    }

    public final float getRadius() {
        return ((Number) this.radius$delegate.getValue()).floatValue();
    }

    public final void setRadius(float f11) {
        this.radius$delegate.setValue(Float.valueOf(f11));
    }
}
