package androidx.compose.foundation;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u000b\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a/\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a1\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0002\u001a:\u0010\u001d\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001aA\u0010#\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001aW\u0010+\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010!\u001a\u00020,2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.\u001a\u0012\u0010/\u001a\u00020 *\b\u0012\u0004\u0012\u00020 0\u001fH\u0002\u001a!\u00100\u001a\u000201*\u0002012\u0006\u00102\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00065"}, d2 = {"createInsetRoundedRect", "Landroidx/compose/ui/geometry/RoundRect;", "widthPx", "", "roundedRect", "createRoundRectPath", "Landroidx/compose/ui/graphics/Path;", "targetPath", "strokeWidth", "fillArea", "", "border", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/BorderStroke;", "shape", "Landroidx/compose/ui/graphics/Shape;", "width", "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "border-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "border-xT4_qwU", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "drawContentWithoutBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "drawGenericBorder", "borderCacheRef", "Landroidx/compose/ui/node/Ref;", "Landroidx/compose/foundation/BorderCache;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "drawRectBorder", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "strokeWidthPx", "drawRectBorder-NsqcLGU", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;JJZF)Landroidx/compose/ui/draw/DrawResult;", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "drawRoundRectBorder-SYlcjDY", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/node/Ref;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "obtain", "shrink", "Landroidx/compose/ui/geometry/CornerRadius;", "value", "shrink-Kibmq7A", "(JF)J", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BorderKt {
    @NotNull
    public static final Modifier border(@NotNull Modifier modifier, @NotNull BorderStroke borderStroke, @NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(borderStroke, OutlinedTextFieldKt.BorderId);
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m184borderziNgDLE(modifier, borderStroke.m190getWidthD9Ej5fM(), borderStroke.getBrush(), shape);
    }

    public static /* synthetic */ Modifier border$default(Modifier modifier, BorderStroke borderStroke, Shape shape, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return border(modifier, borderStroke, shape);
    }

    @NotNull
    /* renamed from: border-xT4_qwU  reason: not valid java name */
    public static final Modifier m182borderxT4_qwU(@NotNull Modifier modifier, float f11, long j11, @NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "$this$border");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m184borderziNgDLE(modifier, f11, new SolidColor(j11, (DefaultConstructorMarker) null), shape);
    }

    /* renamed from: border-xT4_qwU$default  reason: not valid java name */
    public static /* synthetic */ Modifier m183borderxT4_qwU$default(Modifier modifier, float f11, long j11, Shape shape, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return m182borderxT4_qwU(modifier, f11, j11, shape);
    }

    @NotNull
    /* renamed from: border-ziNgDLE  reason: not valid java name */
    public static final Modifier m184borderziNgDLE(@NotNull Modifier modifier, float f11, @NotNull Brush brush, @NotNull Shape shape) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "$this$border");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new BorderKt$borderziNgDLE$$inlined$debugInspectorInfo$1(f11, brush, shape);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new BorderKt$border$2(f11, shape, brush));
    }

    private static final RoundRect createInsetRoundedRect(float f11, RoundRect roundRect) {
        float f12 = f11;
        return new RoundRect(f11, f12, roundRect.getWidth() - f12, roundRect.getHeight() - f12, m187shrinkKibmq7A(roundRect.m2726getTopLeftCornerRadiuskKHJgLs(), f11), m187shrinkKibmq7A(roundRect.m2727getTopRightCornerRadiuskKHJgLs(), f11), m187shrinkKibmq7A(roundRect.m2725getBottomRightCornerRadiuskKHJgLs(), f11), m187shrinkKibmq7A(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs(), f11), (DefaultConstructorMarker) null);
    }

    private static final Path createRoundRectPath(Path path, RoundRect roundRect, float f11, boolean z11) {
        path.reset();
        path.addRoundRect(roundRect);
        if (!z11) {
            Path Path = AndroidPath_androidKt.Path();
            Path.addRoundRect(createInsetRoundedRect(f11, roundRect));
            path.m3152opN5in7k0(path, Path, PathOperation.Companion.m3174getDifferenceb3I0S0c());
        }
        return path;
    }

    /* access modifiers changed from: private */
    public static final DrawResult drawContentWithoutBorder(CacheDrawScope cacheDrawScope) {
        return cacheDrawScope.onDrawWithContent(BorderKt$drawContentWithoutBorder$1.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b7, code lost:
        if (androidx.compose.ui.graphics.ImageBitmapConfig.m3084equalsimpl(r13, r3) != false) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.draw.DrawResult drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope r42, androidx.compose.ui.node.Ref<androidx.compose.foundation.BorderCache> r43, androidx.compose.ui.graphics.Brush r44, androidx.compose.ui.graphics.Outline.Generic r45, boolean r46, float r47) {
        /*
            r0 = r42
            r10 = r44
            if (r46 == 0) goto L_0x0013
            androidx.compose.foundation.BorderKt$drawGenericBorder$1 r1 = new androidx.compose.foundation.BorderKt$drawGenericBorder$1
            r2 = r45
            r1.<init>(r2, r10)
            androidx.compose.ui.draw.DrawResult r0 = r0.onDrawWithContent(r1)
            goto L_0x026c
        L_0x0013:
            r2 = r45
            boolean r1 = r10 instanceof androidx.compose.ui.graphics.SolidColor
            r3 = 0
            if (r1 == 0) goto L_0x0034
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r1 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r1 = r1.m3089getAlpha8_sVssgQ()
            androidx.compose.ui.graphics.ColorFilter$Companion r4 = androidx.compose.ui.graphics.ColorFilter.Companion
            r5 = r10
            androidx.compose.ui.graphics.SolidColor r5 = (androidx.compose.ui.graphics.SolidColor) r5
            long r5 = r5.m3235getValue0d7_KjU()
            r7 = 0
            r8 = 2
            r9 = 0
            androidx.compose.ui.graphics.ColorFilter r4 = androidx.compose.ui.graphics.ColorFilter.Companion.m2960tintxETnrds$default(r4, r5, r7, r8, r9)
            r13 = r1
            r18 = r4
            goto L_0x003d
        L_0x0034:
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r1 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r1 = r1.m3090getArgb8888_sVssgQ()
            r13 = r1
            r18 = r3
        L_0x003d:
            androidx.compose.ui.graphics.Path r1 = r45.getPath()
            androidx.compose.ui.geometry.Rect r9 = r1.getBounds()
            androidx.compose.foundation.BorderCache r1 = obtain(r43)
            androidx.compose.ui.graphics.Path r8 = r1.obtainPath()
            r8.reset()
            r8.addRect(r9)
            androidx.compose.ui.graphics.Path r4 = r45.getPath()
            androidx.compose.ui.graphics.PathOperation$Companion r5 = androidx.compose.ui.graphics.PathOperation.Companion
            int r5 = r5.m3174getDifferenceb3I0S0c()
            r8.m3152opN5in7k0(r8, r4, r5)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            float r4 = r9.getWidth()
            double r4 = (double) r4
            double r4 = java.lang.Math.ceil(r4)
            float r4 = (float) r4
            int r4 = (int) r4
            float r5 = r9.getHeight()
            double r5 = (double) r5
            double r5 = java.lang.Math.ceil(r5)
            float r5 = (float) r5
            int r5 = (int) r5
            long r19 = androidx.compose.ui.unit.IntSizeKt.IntSize(r4, r5)
            androidx.compose.ui.graphics.ImageBitmap r4 = r1.imageBitmap
            androidx.compose.ui.graphics.Canvas r5 = r1.canvas
            if (r4 == 0) goto L_0x0092
            int r6 = r4.m3081getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r6 = androidx.compose.ui.graphics.ImageBitmapConfig.m3082boximpl(r6)
            goto L_0x0093
        L_0x0092:
            r6 = r3
        L_0x0093:
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r11 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r11 = r11.m3090getArgb8888_sVssgQ()
            r12 = 0
            if (r6 != 0) goto L_0x009e
            r6 = r12
            goto L_0x00a6
        L_0x009e:
            int r6 = r6.m3088unboximpl()
            boolean r6 = androidx.compose.ui.graphics.ImageBitmapConfig.m3085equalsimpl0(r6, r11)
        L_0x00a6:
            r15 = 1
            if (r6 != 0) goto L_0x00b9
            if (r4 == 0) goto L_0x00b3
            int r3 = r4.m3081getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r3 = androidx.compose.ui.graphics.ImageBitmapConfig.m3082boximpl(r3)
        L_0x00b3:
            boolean r3 = androidx.compose.ui.graphics.ImageBitmapConfig.m3084equalsimpl(r13, r3)
            if (r3 == 0) goto L_0x00ba
        L_0x00b9:
            r12 = r15
        L_0x00ba:
            if (r4 == 0) goto L_0x00e7
            if (r5 == 0) goto L_0x00e7
            long r16 = r42.m2573getSizeNHjbRc()
            float r3 = androidx.compose.ui.geometry.Size.m2745getWidthimpl(r16)
            int r6 = r4.getWidth()
            float r6 = (float) r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x00e7
            long r16 = r42.m2573getSizeNHjbRc()
            float r3 = androidx.compose.ui.geometry.Size.m2742getHeightimpl(r16)
            int r6 = r4.getHeight()
            float r6 = (float) r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x00e7
            if (r12 != 0) goto L_0x00e3
            goto L_0x00e7
        L_0x00e3:
            r11 = r4
            r12 = r5
            r6 = r15
            goto L_0x0107
        L_0x00e7:
            int r11 = androidx.compose.ui.unit.IntSize.m5638getWidthimpl(r19)
            int r12 = androidx.compose.ui.unit.IntSize.m5637getHeightimpl(r19)
            r14 = 0
            r3 = 0
            r16 = 24
            r17 = 0
            r6 = r15
            r15 = r3
            androidx.compose.ui.graphics.ImageBitmap r4 = androidx.compose.ui.graphics.ImageBitmapKt.m3095ImageBitmapx__hDU$default(r11, r12, r13, r14, r15, r16, r17)
            r1.imageBitmap = r4
            androidx.compose.ui.graphics.Canvas r5 = androidx.compose.ui.graphics.CanvasKt.Canvas(r4)
            r1.canvas = r5
            r11 = r4
            r12 = r5
        L_0x0107:
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r3 = r1.canvasDrawScope
            if (r3 != 0) goto L_0x0115
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r3 = new androidx.compose.ui.graphics.drawscope.CanvasDrawScope
            r3.<init>()
            r1.canvasDrawScope = r3
        L_0x0115:
            r13 = r3
            long r3 = androidx.compose.ui.unit.IntSizeKt.m5648toSizeozmzZPI(r19)
            androidx.compose.ui.unit.LayoutDirection r1 = r42.getLayoutDirection()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r5 = r13.getDrawParams()
            androidx.compose.ui.unit.Density r14 = r5.component1()
            androidx.compose.ui.unit.LayoutDirection r15 = r5.component2()
            r43 = r8
            androidx.compose.ui.graphics.Canvas r8 = r5.component3()
            r46 = r7
            r16 = r8
            long r7 = r5.m3375component4NHjbRc()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r5 = r13.getDrawParams()
            r5.setDensity(r0)
            r5.setLayoutDirection(r1)
            r5.setCanvas(r12)
            r5.m3378setSizeuvyYCjk(r3)
            r12.save()
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r22 = r1.m2945getBlack0d7_KjU()
            r24 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            androidx.compose.ui.graphics.BlendMode$Companion r17 = androidx.compose.ui.graphics.BlendMode.Companion
            int r31 = r17.m2830getClear0nO6VwU()
            r32 = 58
            r33 = 0
            r21 = r13
            r26 = r3
            f0.b.K(r21, r22, r24, r26, r28, r29, r30, r31, r32, r33)
            float r1 = r9.getLeft()
            float r5 = -r1
            float r1 = r9.getTop()
            float r4 = -r1
            androidx.compose.ui.graphics.drawscope.DrawContext r1 = r13.getDrawContext()
            androidx.compose.ui.graphics.drawscope.DrawTransform r1 = r1.getTransform()
            r1.translate(r5, r4)
            androidx.compose.ui.graphics.Path r2 = r45.getPath()
            r21 = 0
            androidx.compose.ui.graphics.drawscope.Stroke r30 = new androidx.compose.ui.graphics.drawscope.Stroke
            r1 = 2
            float r1 = (float) r1
            float r23 = r47 * r1
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 30
            r22 = r30
            r22.<init>(r23, r24, r25, r26, r27, r28, r29)
            r22 = 0
            r23 = 0
            r24 = 52
            r25 = 0
            r1 = r13
            r3 = r44
            r34 = r4
            r4 = r21
            r35 = r5
            r5 = r30
            r6 = r22
            r36 = r7
            r8 = r46
            r7 = r23
            r38 = r8
            r39 = r16
            r16 = r43
            r8 = r24
            r21 = r9
            r9 = r25
            f0.b.F(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            long r1 = r13.m3425getSizeNHjbRc()
            float r1 = androidx.compose.ui.geometry.Size.m2745getWidthimpl(r1)
            r2 = 1
            float r2 = (float) r2
            float r1 = r1 + r2
            long r3 = r13.m3425getSizeNHjbRc()
            float r3 = androidx.compose.ui.geometry.Size.m2745getWidthimpl(r3)
            float r1 = r1 / r3
            long r3 = r13.m3425getSizeNHjbRc()
            float r3 = androidx.compose.ui.geometry.Size.m2742getHeightimpl(r3)
            float r3 = r3 + r2
            long r4 = r13.m3425getSizeNHjbRc()
            float r2 = androidx.compose.ui.geometry.Size.m2742getHeightimpl(r4)
            float r3 = r3 / r2
            long r4 = r13.m3424getCenterF1C5BW0()
            androidx.compose.ui.graphics.drawscope.DrawContext r9 = r13.getDrawContext()
            long r7 = r9.m3403getSizeNHjbRc()
            androidx.compose.ui.graphics.Canvas r2 = r9.getCanvas()
            r2.save()
            androidx.compose.ui.graphics.drawscope.DrawTransform r2 = r9.getTransform()
            r2.m3479scale0AR0LA0(r1, r3, r4)
            r4 = 0
            r5 = 0
            r6 = 0
            int r17 = r17.m2830getClear0nO6VwU()
            r22 = 28
            r23 = 0
            r1 = r13
            r2 = r16
            r3 = r44
            r40 = r7
            r7 = r17
            r8 = r22
            r10 = r9
            r9 = r23
            f0.b.F(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.ui.graphics.Canvas r1 = r10.getCanvas()
            r1.restore()
            r1 = r40
            r10.m3404setSizeuvyYCjk(r1)
            androidx.compose.ui.graphics.drawscope.DrawContext r1 = r13.getDrawContext()
            androidx.compose.ui.graphics.drawscope.DrawTransform r1 = r1.getTransform()
            r2 = r35
            float r2 = -r2
            r3 = r34
            float r3 = -r3
            r1.translate(r2, r3)
            r12.restore()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r1 = r13.getDrawParams()
            r1.setDensity(r14)
            r1.setLayoutDirection(r15)
            r2 = r39
            r1.setCanvas(r2)
            r2 = r36
            r1.m3378setSizeuvyYCjk(r2)
            r11.prepareToDraw()
            r1 = r38
            r1.element = r11
            androidx.compose.foundation.BorderKt$drawGenericBorder$3 r2 = new androidx.compose.foundation.BorderKt$drawGenericBorder$3
            r4 = r2
            r5 = r21
            r6 = r1
            r7 = r19
            r9 = r18
            r4.<init>(r5, r6, r7, r9)
            androidx.compose.ui.draw.DrawResult r0 = r0.onDrawWithContent(r2)
        L_0x026c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderKt.drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.node.Ref, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawRectBorder-NsqcLGU  reason: not valid java name */
    public static final DrawResult m185drawRectBorderNsqcLGU(CacheDrawScope cacheDrawScope, Brush brush, long j11, long j12, boolean z11, float f11) {
        long j13;
        long j14;
        DrawStyle drawStyle;
        if (z11) {
            j13 = Offset.Companion.m2692getZeroF1C5BW0();
        } else {
            j13 = j11;
        }
        if (z11) {
            j14 = cacheDrawScope.m2573getSizeNHjbRc();
        } else {
            j14 = j12;
        }
        if (z11) {
            drawStyle = Fill.INSTANCE;
        } else {
            drawStyle = new Stroke(f11, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null);
        }
        return cacheDrawScope.onDrawWithContent(new BorderKt$drawRectBorder$1(brush, j13, j14, drawStyle));
    }

    /* access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-SYlcjDY  reason: not valid java name */
    public static final DrawResult m186drawRoundRectBorderSYlcjDY(CacheDrawScope cacheDrawScope, Ref<BorderCache> ref, Brush brush, Outline.Rounded rounded, long j11, long j12, boolean z11, float f11) {
        CacheDrawScope cacheDrawScope2 = cacheDrawScope;
        float f12 = f11;
        if (!RoundRectKt.isSimple(rounded.getRoundRect())) {
            return cacheDrawScope.onDrawWithContent(new BorderKt$drawRoundRectBorder$2(createRoundRectPath(obtain(ref).obtainPath(), rounded.getRoundRect(), f12, z11), brush));
        }
        return cacheDrawScope.onDrawWithContent(new BorderKt$drawRoundRectBorder$1(z11, brush, rounded.getRoundRect().m2726getTopLeftCornerRadiuskKHJgLs(), f12 / ((float) 2), f11, j11, j12, new Stroke(f11, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null)));
    }

    private static final BorderCache obtain(Ref<BorderCache> ref) {
        BorderCache value = ref.getValue();
        if (value != null) {
            return value;
        }
        BorderCache borderCache = new BorderCache((ImageBitmap) null, (Canvas) null, (CanvasDrawScope) null, (Path) null, 15, (DefaultConstructorMarker) null);
        ref.setValue(borderCache);
        return borderCache;
    }

    /* access modifiers changed from: private */
    /* renamed from: shrink-Kibmq7A  reason: not valid java name */
    public static final long m187shrinkKibmq7A(long j11, float f11) {
        return CornerRadiusKt.CornerRadius(Math.max(0.0f, CornerRadius.m2651getXimpl(j11) - f11), Math.max(0.0f, CornerRadius.m2652getYimpl(j11) - f11));
    }
}
