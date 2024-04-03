package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import e0.e1;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001aQ\u0010\u0005\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001aQ\u0010\u0005\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0001\u0010\u001a\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042,\u0010\u001b\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!2,\u0010\"\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110#¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!2,\u0010%\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!H\b\u001a\f\u0010'\u001a\u00020(*\u00020#H\u0002\u001a\u0014\u0010)\u001a\u00020**\u00020\u001dH\u0002ø\u0001\u0001¢\u0006\u0002\u0010+\u001a\u0014\u0010)\u001a\u00020**\u00020#H\u0002ø\u0001\u0001¢\u0006\u0002\u0010,\u001a\u0014\u0010-\u001a\u00020.*\u00020\u001dH\u0002ø\u0001\u0001¢\u0006\u0002\u0010+\u001a\u0014\u0010-\u001a\u00020.*\u00020#H\u0002ø\u0001\u0001¢\u0006\u0002\u0010,\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006/"}, d2 = {"addOutline", "", "Landroidx/compose/ui/graphics/Path;", "outline", "Landroidx/compose/ui/graphics/Outline;", "drawOutline", "Landroidx/compose/ui/graphics/Canvas;", "paint", "Landroidx/compose/ui/graphics/Paint;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawOutline-hn5TExg", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawOutline-wDX37Ww", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOutlineHelper", "drawRectBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", "name", "rect", "Lkotlin/ExtensionFunctionType;", "drawRoundedRectBlock", "Landroidx/compose/ui/geometry/RoundRect;", "rrect", "drawPathBlock", "path", "hasSameCornerRadius", "", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/geometry/Rect;)J", "(Landroidx/compose/ui/geometry/RoundRect;)J", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class OutlineKt {
    public static final void addOutline(@NotNull Path path, @NotNull Outline outline) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(outline, "outline");
        if (outline instanceof Outline.Rectangle) {
            path.addRect(((Outline.Rectangle) outline).getRect());
        } else if (outline instanceof Outline.Rounded) {
            path.addRoundRect(((Outline.Rounded) outline).getRoundRect());
        } else if (outline instanceof Outline.Generic) {
            e1.c(path, ((Outline.Generic) outline).getPath(), 0, 2, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final void drawOutline(@NotNull Canvas canvas, @NotNull Outline outline, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (outline instanceof Outline.Rectangle) {
            canvas.drawRect(((Outline.Rectangle) outline).getRect(), paint);
        } else if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            Path roundRectPath$ui_graphics_release = rounded.getRoundRectPath$ui_graphics_release();
            if (roundRectPath$ui_graphics_release != null) {
                canvas.drawPath(roundRectPath$ui_graphics_release, paint);
                return;
            }
            canvas.drawRoundRect(rounded.getRoundRect().getLeft(), rounded.getRoundRect().getTop(), rounded.getRoundRect().getRight(), rounded.getRoundRect().getBottom(), CornerRadius.m2651getXimpl(rounded.getRoundRect().m2724getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m2652getYimpl(rounded.getRoundRect().m2724getBottomLeftCornerRadiuskKHJgLs()), paint);
        } else if (outline instanceof Outline.Generic) {
            canvas.drawPath(((Outline.Generic) outline).getPath(), paint);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: drawOutline-hn5TExg  reason: not valid java name */
    public static final void m3125drawOutlinehn5TExg(@NotNull DrawScope drawScope, @NotNull Outline outline, @NotNull Brush brush, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Path path;
        Outline outline2 = outline;
        DrawScope drawScope2 = drawScope;
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawOutline");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        if (outline2 instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline2).getRect();
            drawScope.m3420drawRectAsUm42w(brush, topLeft(rect), size(rect), f11, drawStyle, colorFilter, i11);
            return;
        }
        if (outline2 instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline2;
            path = rounded.getRoundRectPath$ui_graphics_release();
            if (path == null) {
                RoundRect roundRect = rounded.getRoundRect();
                float r12 = CornerRadius.m2651getXimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs());
                drawScope.m3422drawRoundRectZuiqVtQ(brush, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(r12, 0.0f, 2, (Object) null), f11, drawStyle, colorFilter, i11);
                return;
            }
        } else if (outline2 instanceof Outline.Generic) {
            path = ((Outline.Generic) outline2).getPath();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        drawScope.m3416drawPathGBMwjPU(path, brush, f11, drawStyle, colorFilter, i11);
    }

    /* renamed from: drawOutline-hn5TExg$default  reason: not valid java name */
    public static /* synthetic */ void m3126drawOutlinehn5TExg$default(DrawScope drawScope, Outline outline, Brush brush, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
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
        m3125drawOutlinehn5TExg(drawScope, outline, brush, f12, drawStyle2, colorFilter2, i11);
    }

    /* renamed from: drawOutline-wDX37Ww  reason: not valid java name */
    public static final void m3127drawOutlinewDX37Ww(@NotNull DrawScope drawScope, @NotNull Outline outline, long j11, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Path path;
        Outline outline2 = outline;
        DrawScope drawScope2 = drawScope;
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawOutline");
        Intrinsics.checkNotNullParameter(outline2, "outline");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        if (outline2 instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline2).getRect();
            drawScope.m3421drawRectnJ9OG0(j11, topLeft(rect), size(rect), f11, drawStyle, colorFilter, i11);
            return;
        }
        if (outline2 instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline2;
            path = rounded.getRoundRectPath$ui_graphics_release();
            if (path == null) {
                RoundRect roundRect = rounded.getRoundRect();
                DrawScope drawScope3 = drawScope;
                long j12 = j11;
                drawScope3.m3423drawRoundRectuAw5IA(j12, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m2651getXimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs()), 0.0f, 2, (Object) null), drawStyle, f11, colorFilter, i11);
                return;
            }
        } else if (outline2 instanceof Outline.Generic) {
            path = ((Outline.Generic) outline2).getPath();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        drawScope.m3417drawPathLG529CI(path, j11, f11, drawStyle, colorFilter, i11);
    }

    /* renamed from: drawOutline-wDX37Ww$default  reason: not valid java name */
    public static /* synthetic */ void m3128drawOutlinewDX37Ww$default(DrawScope drawScope, Outline outline, long j11, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11, int i12, Object obj) {
        float f12;
        Fill fill;
        ColorFilter colorFilter2;
        int i13;
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
        m3127drawOutlinewDX37Ww(drawScope, outline, j11, f12, fill, colorFilter2, i13);
    }

    private static final void drawOutlineHelper(DrawScope drawScope, Outline outline, Function2<? super DrawScope, ? super Rect, Unit> function2, Function2<? super DrawScope, ? super RoundRect, Unit> function22, Function2<? super DrawScope, ? super Path, Unit> function23) {
        if (outline instanceof Outline.Rectangle) {
            function2.invoke(drawScope, ((Outline.Rectangle) outline).getRect());
        } else if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            Path roundRectPath$ui_graphics_release = rounded.getRoundRectPath$ui_graphics_release();
            if (roundRectPath$ui_graphics_release != null) {
                function23.invoke(drawScope, roundRectPath$ui_graphics_release);
            } else {
                function22.invoke(drawScope, rounded.getRoundRect());
            }
        } else if (outline instanceof Outline.Generic) {
            function23.invoke(drawScope, ((Outline.Generic) outline).getPath());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a0 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean hasSameCornerRadius(androidx.compose.ui.geometry.RoundRect r6) {
        /*
            long r0 = r6.m2724getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2651getXimpl(r0)
            long r1 = r6.m2725getBottomRightCornerRadiuskKHJgLs()
            float r1 = androidx.compose.ui.geometry.CornerRadius.m2651getXimpl(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0018
            r0 = r1
            goto L_0x0019
        L_0x0018:
            r0 = r2
        L_0x0019:
            if (r0 == 0) goto L_0x004f
            long r3 = r6.m2725getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2651getXimpl(r3)
            long r3 = r6.m2727getTopRightCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2651getXimpl(r3)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0031
            r0 = r1
            goto L_0x0032
        L_0x0031:
            r0 = r2
        L_0x0032:
            if (r0 == 0) goto L_0x004f
            long r3 = r6.m2727getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2651getXimpl(r3)
            long r3 = r6.m2726getTopLeftCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2651getXimpl(r3)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x004a
            r0 = r1
            goto L_0x004b
        L_0x004a:
            r0 = r2
        L_0x004b:
            if (r0 == 0) goto L_0x004f
            r0 = r1
            goto L_0x0050
        L_0x004f:
            r0 = r2
        L_0x0050:
            long r3 = r6.m2724getBottomLeftCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2652getYimpl(r3)
            long r4 = r6.m2725getBottomRightCornerRadiuskKHJgLs()
            float r4 = androidx.compose.ui.geometry.CornerRadius.m2652getYimpl(r4)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0066
            r3 = r1
            goto L_0x0067
        L_0x0066:
            r3 = r2
        L_0x0067:
            if (r3 == 0) goto L_0x009d
            long r3 = r6.m2725getBottomRightCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2652getYimpl(r3)
            long r4 = r6.m2727getTopRightCornerRadiuskKHJgLs()
            float r4 = androidx.compose.ui.geometry.CornerRadius.m2652getYimpl(r4)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x007f
            r3 = r1
            goto L_0x0080
        L_0x007f:
            r3 = r2
        L_0x0080:
            if (r3 == 0) goto L_0x009d
            long r3 = r6.m2727getTopRightCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2652getYimpl(r3)
            long r4 = r6.m2726getTopLeftCornerRadiuskKHJgLs()
            float r6 = androidx.compose.ui.geometry.CornerRadius.m2652getYimpl(r4)
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0098
            r6 = r1
            goto L_0x0099
        L_0x0098:
            r6 = r2
        L_0x0099:
            if (r6 == 0) goto L_0x009d
            r6 = r1
            goto L_0x009e
        L_0x009d:
            r6 = r2
        L_0x009e:
            if (r0 == 0) goto L_0x00a3
            if (r6 == 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r1 = r2
        L_0x00a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.OutlineKt.hasSameCornerRadius(androidx.compose.ui.geometry.RoundRect):boolean");
    }

    private static final long size(Rect rect) {
        return SizeKt.Size(rect.getWidth(), rect.getHeight());
    }

    private static final long topLeft(Rect rect) {
        return OffsetKt.Offset(rect.getLeft(), rect.getTop());
    }

    private static final long size(RoundRect roundRect) {
        return SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
    }

    private static final long topLeft(RoundRect roundRect) {
        return OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
    }
}
