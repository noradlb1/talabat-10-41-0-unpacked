package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.huawei.hms.flutter.map.constants.Param;
import e0.z0;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J=\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J\b\u0010#\u001a\u00020\u000fH\u0016JH\u0010$\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J-\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J-\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020-2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106JE\u00107\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020;2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?J-\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020-2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010DJ)\u0010E\u001a\u00020\u000f2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002ø\u0001\u0001J0\u0010J\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010K\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*H\u0016J3\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010PJ!\u0010L\u001a\u00020\u000f2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*H\u0002ø\u0001\u0001J \u0010Q\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J-\u0010S\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bT\u0010UJ \u0010S\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J0\u0010V\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J@\u0010W\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J-\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b_\u0010`J\b\u0010a\u001a\u00020\u000fH\u0016J\b\u0010b\u001a\u00020\u000fH\u0016J\u0010\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u0018H\u0016J\b\u0010e\u001a\u00020\u000fH\u0016J\u0018\u0010f\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020h2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010i\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u00182\u0006\u0010k\u001a\u00020\u0018H\u0016J\u0018\u0010l\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u00182\u0006\u0010k\u001a\u00020\u0018H\u0016J\u0018\u0010m\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u00182\u0006\u0010o\u001a\u00020\u0018H\u0016J\u0017\u0010p\u001a\u00020q*\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\br\u0010sR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u00060\u0006j\u0002`\u00078\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006t"}, d2 = {"Landroidx/compose/ui/graphics/AndroidCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "()V", "dstRect", "Landroid/graphics/Rect;", "internalCanvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "getInternalCanvas$annotations", "getInternalCanvas", "()Landroid/graphics/Canvas;", "setInternalCanvas", "(Landroid/graphics/Canvas;)V", "srcRect", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "disableZ", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawCircle", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawLines", "points", "", "stepBy", "", "drawOval", "drawPath", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawLines", "", "drawRawPoints", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "restore", "rotate", "degrees", "save", "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "scale", "sx", "sy", "skew", "translate", "dx", "dy", "toRegionOp", "Landroid/graphics/Region$Op;", "toRegionOp--7u2Bmg", "(I)Landroid/graphics/Region$Op;", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@PublishedApi
public final class AndroidCanvas implements Canvas {
    @NotNull
    private final Rect dstRect = new Rect();
    @NotNull
    private Canvas internalCanvas = AndroidCanvas_androidKt.EmptyCanvas;
    @NotNull
    private final Rect srcRect = new Rect();

    private final void drawLines(List<Offset> list, Paint paint, int i11) {
        if (list.size() >= 2) {
            IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, list.size() - 1), i11);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    long r22 = list.get(first).m2686unboximpl();
                    long r42 = list.get(first + 1).m2686unboximpl();
                    this.internalCanvas.drawLine(Offset.m2676getXimpl(r22), Offset.m2677getYimpl(r22), Offset.m2676getXimpl(r42), Offset.m2677getYimpl(r42), paint.asFrameworkPaint());
                    if (first != last) {
                        first += step2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private final void drawPoints(List<Offset> list, Paint paint) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            long r22 = list.get(i11).m2686unboximpl();
            this.internalCanvas.drawPoint(Offset.m2676getXimpl(r22), Offset.m2677getYimpl(r22), paint.asFrameworkPaint());
        }
    }

    private final void drawRawLines(float[] fArr, Paint paint, int i11) {
        if (fArr.length >= 4 && fArr.length % 2 == 0) {
            IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, fArr.length - 3), i11 * 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    this.internalCanvas.drawLine(fArr[first], fArr[first + 1], fArr[first + 2], fArr[first + 3], paint.asFrameworkPaint());
                    if (first != last) {
                        first += step2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private final void drawRawPoints(float[] fArr, Paint paint, int i11) {
        if (fArr.length % 2 == 0) {
            IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, fArr.length - 1), i11);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    this.internalCanvas.drawPoint(fArr[first], fArr[first + 1], paint.asFrameworkPaint());
                    if (first != last) {
                        first += step2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @PublishedApi
    public static /* synthetic */ void getInternalCanvas$annotations() {
    }

    /* renamed from: clipPath-mtrdD-E  reason: not valid java name */
    public void m2770clipPathmtrdDE(@NotNull Path path, int i11) {
        Intrinsics.checkNotNullParameter(path, "path");
        Canvas canvas = this.internalCanvas;
        if (path instanceof AndroidPath) {
            canvas.clipPath(((AndroidPath) path).getInternalPath(), m2781toRegionOp7u2Bmg(i11));
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    /* renamed from: clipRect-N_I0leg  reason: not valid java name */
    public void m2771clipRectN_I0leg(float f11, float f12, float f13, float f14, int i11) {
        this.internalCanvas.clipRect(f11, f12, f13, f14, m2781toRegionOp7u2Bmg(i11));
    }

    /* renamed from: clipRect-mtrdD-E  reason: not valid java name */
    public /* synthetic */ void m2772clipRectmtrdDE(androidx.compose.ui.geometry.Rect rect, int i11) {
        z0.a(this, rect, i11);
    }

    /* renamed from: concat-58bKbWc  reason: not valid java name */
    public void m2773concat58bKbWc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        if (!MatrixKt.m3124isIdentity58bKbWc(fArr)) {
            Matrix matrix = new Matrix();
            AndroidMatrixConversions_androidKt.m2788setFromEL8BTi8(matrix, fArr);
            this.internalCanvas.concat(matrix);
        }
    }

    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    public void drawArc(float f11, float f12, float f13, float f14, float f15, float f16, boolean z11, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawArc(f11, f12, f13, f14, f15, f16, z11, paint.asFrameworkPaint());
    }

    public /* synthetic */ void drawArc(androidx.compose.ui.geometry.Rect rect, float f11, float f12, boolean z11, Paint paint) {
        z0.b(this, rect, f11, f12, z11, paint);
    }

    public /* synthetic */ void drawArcRad(androidx.compose.ui.geometry.Rect rect, float f11, float f12, boolean z11, Paint paint) {
        z0.c(this, rect, f11, f12, z11, paint);
    }

    /* renamed from: drawCircle-9KIMszo  reason: not valid java name */
    public void m2774drawCircle9KIMszo(long j11, float f11, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawCircle(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11), f11, paint.asFrameworkPaint());
    }

    /* renamed from: drawImage-d-4ec7I  reason: not valid java name */
    public void m2775drawImaged4ec7I(@NotNull ImageBitmap imageBitmap, long j11, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11), paint.asFrameworkPaint());
    }

    /* renamed from: drawImageRect-HPBpro0  reason: not valid java name */
    public void m2776drawImageRectHPBpro0(@NotNull ImageBitmap imageBitmap, long j11, long j12, long j13, long j14, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.internalCanvas;
        Bitmap asAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap);
        Rect rect = this.srcRect;
        rect.left = IntOffset.m5596getXimpl(j11);
        rect.top = IntOffset.m5597getYimpl(j11);
        rect.right = IntOffset.m5596getXimpl(j11) + IntSize.m5638getWidthimpl(j12);
        rect.bottom = IntOffset.m5597getYimpl(j11) + IntSize.m5637getHeightimpl(j12);
        Unit unit = Unit.INSTANCE;
        Rect rect2 = this.dstRect;
        rect2.left = IntOffset.m5596getXimpl(j13);
        rect2.top = IntOffset.m5597getYimpl(j13);
        rect2.right = IntOffset.m5596getXimpl(j13) + IntSize.m5638getWidthimpl(j14);
        rect2.bottom = IntOffset.m5597getYimpl(j13) + IntSize.m5637getHeightimpl(j14);
        canvas.drawBitmap(asAndroidBitmap, rect, rect2, paint.asFrameworkPaint());
    }

    /* renamed from: drawLine-Wko1d7g  reason: not valid java name */
    public void m2777drawLineWko1d7g(long j11, long j12, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawLine(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11), Offset.m2676getXimpl(j12), Offset.m2677getYimpl(j12), paint.asFrameworkPaint());
    }

    public void drawOval(float f11, float f12, float f13, float f14, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawOval(f11, f12, f13, f14, paint.asFrameworkPaint());
    }

    public /* synthetic */ void drawOval(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        z0.d(this, rect, paint);
    }

    public void drawPath(@NotNull Path path, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.internalCanvas;
        if (path instanceof AndroidPath) {
            canvas.drawPath(((AndroidPath) path).getInternalPath(), paint.asFrameworkPaint());
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    /* renamed from: drawPoints-O7TthRY  reason: not valid java name */
    public void m2778drawPointsO7TthRY(int i11, @NotNull List<Offset> list, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(list, Param.POINTS);
        Intrinsics.checkNotNullParameter(paint, "paint");
        PointMode.Companion companion = PointMode.Companion;
        if (PointMode.m3183equalsimpl0(i11, companion.m3187getLinesr_lszbg())) {
            drawLines(list, paint, 2);
        } else if (PointMode.m3183equalsimpl0(i11, companion.m3189getPolygonr_lszbg())) {
            drawLines(list, paint, 1);
        } else if (PointMode.m3183equalsimpl0(i11, companion.m3188getPointsr_lszbg())) {
            drawPoints(list, paint);
        }
    }

    /* renamed from: drawRawPoints-O7TthRY  reason: not valid java name */
    public void m2779drawRawPointsO7TthRY(int i11, @NotNull float[] fArr, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(fArr, Param.POINTS);
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (fArr.length % 2 == 0) {
            PointMode.Companion companion = PointMode.Companion;
            if (PointMode.m3183equalsimpl0(i11, companion.m3187getLinesr_lszbg())) {
                drawRawLines(fArr, paint, 2);
            } else if (PointMode.m3183equalsimpl0(i11, companion.m3189getPolygonr_lszbg())) {
                drawRawLines(fArr, paint, 1);
            } else if (PointMode.m3183equalsimpl0(i11, companion.m3188getPointsr_lszbg())) {
                drawRawPoints(fArr, paint, 2);
            }
        } else {
            throw new IllegalArgumentException("points must have an even number of values");
        }
    }

    public void drawRect(float f11, float f12, float f13, float f14, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawRect(f11, f12, f13, f14, paint.asFrameworkPaint());
    }

    public /* synthetic */ void drawRect(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        z0.e(this, rect, paint);
    }

    public void drawRoundRect(float f11, float f12, float f13, float f14, float f15, float f16, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawRoundRect(f11, f12, f13, f14, f15, f16, paint.asFrameworkPaint());
    }

    /* renamed from: drawVertices-TPEHhCM  reason: not valid java name */
    public void m2780drawVerticesTPEHhCM(@NotNull Vertices vertices, int i11, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawVertices(AndroidVertexMode_androidKt.m2821toAndroidVertexModeJOOmi9M(vertices.m3303getVertexModec2xauaI()), vertices.getPositions().length, vertices.getPositions(), 0, vertices.getTextureCoordinates(), 0, vertices.getColors(), 0, vertices.getIndices(), 0, vertices.getIndices().length, paint.asFrameworkPaint());
    }

    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    @NotNull
    public final Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    public void restore() {
        this.internalCanvas.restore();
    }

    public void rotate(float f11) {
        this.internalCanvas.rotate(f11);
    }

    public void save() {
        this.internalCanvas.save();
    }

    public void saveLayer(@NotNull androidx.compose.ui.geometry.Rect rect, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rect, Param.BOUNDS);
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.saveLayer(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint.asFrameworkPaint(), 31);
    }

    public void scale(float f11, float f12) {
        this.internalCanvas.scale(f11, f12);
    }

    public final void setInternalCanvas(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "<set-?>");
        this.internalCanvas = canvas;
    }

    public void skew(float f11, float f12) {
        this.internalCanvas.skew(f11, f12);
    }

    public /* synthetic */ void skewRad(float f11, float f12) {
        z0.f(this, f11, f12);
    }

    @NotNull
    /* renamed from: toRegionOp--7u2Bmg  reason: not valid java name */
    public final Region.Op m2781toRegionOp7u2Bmg(int i11) {
        if (ClipOp.m2903equalsimpl0(i11, ClipOp.Companion.m2907getDifferencertfAjoo())) {
            return Region.Op.DIFFERENCE;
        }
        return Region.Op.INTERSECT;
    }

    public void translate(float f11, float f12) {
        this.internalCanvas.translate(f11, f12);
    }
}
