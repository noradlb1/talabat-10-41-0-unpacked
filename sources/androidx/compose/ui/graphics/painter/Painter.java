package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\f\u0010\u000f\u001a\u00020\u0006*\u00020\u000eH$J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000bH\u0014J5\u0010\u0019\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0016\u0010\u0013\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010 R%\u0010#\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010'\u001a\u00020\u00158&X¦\u0004ø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b%\u0010&\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/ui/graphics/painter/Painter;", "", "Landroidx/compose/ui/graphics/Paint;", "obtainPaint", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "", "configureColorFilter", "", "alpha", "configureAlpha", "Landroidx/compose/ui/unit/LayoutDirection;", "rtl", "configureLayoutDirection", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "d", "", "a", "b", "layoutDirection", "c", "Landroidx/compose/ui/geometry/Size;", "size", "draw-x_KDEd0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/ui/graphics/ColorFilter;)V", "draw", "layerPaint", "Landroidx/compose/ui/graphics/Paint;", "useLayer", "Z", "Landroidx/compose/ui/graphics/ColorFilter;", "F", "Landroidx/compose/ui/unit/LayoutDirection;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "drawLambda", "Lkotlin/jvm/functions/Function1;", "getIntrinsicSize-NH-jbRc", "()J", "intrinsicSize", "<init>", "()V", "ui-graphics_release"}, k = 1, mv = {1, 7, 1})
public abstract class Painter {
    private float alpha = 1.0f;
    @Nullable
    private ColorFilter colorFilter;
    @NotNull
    private final Function1<DrawScope, Unit> drawLambda = new Painter$drawLambda$1(this);
    @Nullable
    private Paint layerPaint;
    @NotNull
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private boolean useLayer;

    private final void configureAlpha(float f11) {
        boolean z11;
        boolean z12;
        if (this.alpha == f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            if (!a(f11)) {
                if (f11 == 1.0f) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    Paint paint = this.layerPaint;
                    if (paint != null) {
                        paint.setAlpha(f11);
                    }
                    this.useLayer = false;
                } else {
                    obtainPaint().setAlpha(f11);
                    this.useLayer = true;
                }
            }
            this.alpha = f11;
        }
    }

    private final void configureColorFilter(ColorFilter colorFilter2) {
        if (!Intrinsics.areEqual((Object) this.colorFilter, (Object) colorFilter2)) {
            if (!b(colorFilter2)) {
                if (colorFilter2 == null) {
                    Paint paint = this.layerPaint;
                    if (paint != null) {
                        paint.setColorFilter((ColorFilter) null);
                    }
                    this.useLayer = false;
                } else {
                    obtainPaint().setColorFilter(colorFilter2);
                    this.useLayer = true;
                }
            }
            this.colorFilter = colorFilter2;
        }
    }

    private final void configureLayoutDirection(LayoutDirection layoutDirection2) {
        if (this.layoutDirection != layoutDirection2) {
            c(layoutDirection2);
            this.layoutDirection = layoutDirection2;
        }
    }

    /* renamed from: draw-x_KDEd0$default  reason: not valid java name */
    public static /* synthetic */ void m3514drawx_KDEd0$default(Painter painter, DrawScope drawScope, long j11, float f11, ColorFilter colorFilter2, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                f11 = 1.0f;
            }
            float f12 = f11;
            if ((i11 & 4) != 0) {
                colorFilter2 = null;
            }
            painter.m3515drawx_KDEd0(drawScope, j11, f12, colorFilter2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw-x_KDEd0");
    }

    private final Paint obtainPaint() {
        Paint paint = this.layerPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        this.layerPaint = Paint;
        return Paint;
    }

    public boolean a(float f11) {
        return false;
    }

    public boolean b(@Nullable ColorFilter colorFilter2) {
        return false;
    }

    public boolean c(@NotNull LayoutDirection layoutDirection2) {
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        return false;
    }

    public abstract void d(@NotNull DrawScope drawScope);

    /* renamed from: draw-x_KDEd0  reason: not valid java name */
    public final void m3515drawx_KDEd0(@NotNull DrawScope drawScope, long j11, float f11, @Nullable ColorFilter colorFilter2) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$draw");
        configureAlpha(f11);
        configureColorFilter(colorFilter2);
        configureLayoutDirection(drawScope.getLayoutDirection());
        float r82 = Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()) - Size.m2745getWidthimpl(j11);
        float r02 = Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc()) - Size.m2742getHeightimpl(j11);
        drawScope.getDrawContext().getTransform().inset(0.0f, 0.0f, r82, r02);
        if (f11 > 0.0f && Size.m2745getWidthimpl(j11) > 0.0f && Size.m2742getHeightimpl(j11) > 0.0f) {
            if (this.useLayer) {
                Rect r52 = RectKt.m2716Recttz77jQw(Offset.Companion.m2692getZeroF1C5BW0(), SizeKt.Size(Size.m2745getWidthimpl(j11), Size.m2742getHeightimpl(j11)));
                Canvas canvas = drawScope.getDrawContext().getCanvas();
                try {
                    canvas.saveLayer(r52, obtainPaint());
                    d(drawScope);
                } finally {
                    canvas.restore();
                }
            } else {
                d(drawScope);
            }
        }
        drawScope.getDrawContext().getTransform().inset(-0.0f, -0.0f, -r82, -r02);
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public abstract long m3516getIntrinsicSizeNHjbRc();
}
