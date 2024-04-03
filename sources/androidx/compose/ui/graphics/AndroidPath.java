package androidx.compose.ui.graphics;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.PathOperation;
import e0.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J \u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J%\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016J(\u00101\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u00102\u001a\u00020\u000fH\u0016J\b\u00103\u001a\u00020\u001eH\u0016J8\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020!H\u0016J\b\u0010;\u001a\u00020\u001cH\u0016J\u0018\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020!H\u0016J\u0018\u0010?\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020!H\u0016J-\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020DH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ(\u0010G\u001a\u00020\u001e2\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020!H\u0016J8\u0010H\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00020!2\u0006\u0010M\u001a\u00020!2\u0006\u0010N\u001a\u00020!H\u0016J\u0018\u0010O\u001a\u00020\u001e2\u0006\u0010P\u001a\u00020!2\u0006\u0010Q\u001a\u00020!H\u0016J\u0018\u0010R\u001a\u00020\u001e2\u0006\u0010P\u001a\u00020!2\u0006\u0010Q\u001a\u00020!H\u0016J(\u0010S\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00020!H\u0016J\b\u0010T\u001a\u00020\u001eH\u0016J\u001d\u0010U\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WR-\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006X"}, d2 = {"Landroidx/compose/ui/graphics/AndroidPath;", "Landroidx/compose/ui/graphics/Path;", "internalPath", "Landroid/graphics/Path;", "(Landroid/graphics/Path;)V", "value", "Landroidx/compose/ui/graphics/PathFillType;", "fillType", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "getInternalPath", "()Landroid/graphics/Path;", "isConvex", "", "isConvex$annotations", "()V", "()Z", "isEmpty", "mMatrix", "Landroid/graphics/Matrix;", "radii", "", "rectF", "Landroid/graphics/RectF;", "_rectIsValid", "rect", "Landroidx/compose/ui/geometry/Rect;", "addArc", "", "oval", "startAngleDegrees", "", "sweepAngleDegrees", "addArcRad", "startAngleRadians", "sweepAngleRadians", "addOval", "addPath", "path", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "addRect", "addRoundRect", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "arcTo", "forceMoveTo", "close", "cubicTo", "x1", "y1", "x2", "y2", "x3", "y3", "getBounds", "lineTo", "x", "y", "moveTo", "op", "path1", "path2", "operation", "Landroidx/compose/ui/graphics/PathOperation;", "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "quadraticBezierTo", "relativeCubicTo", "dx1", "dy1", "dx2", "dy2", "dx3", "dy3", "relativeLineTo", "dx", "dy", "relativeMoveTo", "relativeQuadraticBezierTo", "reset", "translate", "translate-k-4lQ0M", "(J)V", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidPath implements Path {
    @NotNull
    private final Path internalPath;
    @NotNull
    private final Matrix mMatrix;
    @NotNull
    private final float[] radii;
    @NotNull
    private final RectF rectF;

    public AndroidPath() {
        this((Path) null, 1, (DefaultConstructorMarker) null);
    }

    public AndroidPath(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "internalPath");
        this.internalPath = path;
        this.rectF = new RectF();
        this.radii = new float[8];
        this.mMatrix = new Matrix();
    }

    private final boolean _rectIsValid(Rect rect) {
        if (!(!Float.isNaN(rect.getLeft()))) {
            throw new IllegalStateException("Rect.left is NaN".toString());
        } else if (!(!Float.isNaN(rect.getTop()))) {
            throw new IllegalStateException("Rect.top is NaN".toString());
        } else if (!(!Float.isNaN(rect.getRight()))) {
            throw new IllegalStateException("Rect.right is NaN".toString());
        } else if (!Float.isNaN(rect.getBottom())) {
            return true;
        } else {
            throw new IllegalStateException("Rect.bottom is NaN".toString());
        }
    }

    public static /* synthetic */ void isConvex$annotations() {
    }

    public void addArc(@NotNull Rect rect, float f11, float f12) {
        Intrinsics.checkNotNullParameter(rect, "oval");
        if (_rectIsValid(rect)) {
            this.rectF.set(RectHelper_androidKt.toAndroidRect(rect));
            this.internalPath.addArc(this.rectF, f11, f12);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public void addArcRad(@NotNull Rect rect, float f11, float f12) {
        Intrinsics.checkNotNullParameter(rect, "oval");
        addArc(rect, DegreesKt.degrees(f11), DegreesKt.degrees(f12));
    }

    public void addOval(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "oval");
        this.rectF.set(RectHelper_androidKt.toAndroidRect(rect));
        this.internalPath.addOval(this.rectF, Path.Direction.CCW);
    }

    /* renamed from: addPath-Uv8p0NA  reason: not valid java name */
    public void m2808addPathUv8p0NA(@NotNull Path path, long j11) {
        Intrinsics.checkNotNullParameter(path, "path");
        Path path2 = this.internalPath;
        if (path instanceof AndroidPath) {
            path2.addPath(((AndroidPath) path).getInternalPath(), Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11));
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public void addRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (_rectIsValid(rect)) {
            this.rectF.set(RectHelper_androidKt.toAndroidRectF(rect));
            this.internalPath.addRect(this.rectF, Path.Direction.CCW);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public void addRoundRect(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "roundRect");
        this.rectF.set(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
        this.radii[0] = CornerRadius.m2651getXimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs());
        this.radii[1] = CornerRadius.m2652getYimpl(roundRect.m2726getTopLeftCornerRadiuskKHJgLs());
        this.radii[2] = CornerRadius.m2651getXimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs());
        this.radii[3] = CornerRadius.m2652getYimpl(roundRect.m2727getTopRightCornerRadiuskKHJgLs());
        this.radii[4] = CornerRadius.m2651getXimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs());
        this.radii[5] = CornerRadius.m2652getYimpl(roundRect.m2725getBottomRightCornerRadiuskKHJgLs());
        this.radii[6] = CornerRadius.m2651getXimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs());
        this.radii[7] = CornerRadius.m2652getYimpl(roundRect.m2724getBottomLeftCornerRadiuskKHJgLs());
        this.internalPath.addRoundRect(this.rectF, this.radii, Path.Direction.CCW);
    }

    public void arcTo(@NotNull Rect rect, float f11, float f12, boolean z11) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.rectF.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        this.internalPath.arcTo(this.rectF, f11, f12, z11);
    }

    public /* synthetic */ void arcToRad(Rect rect, float f11, float f12, boolean z11) {
        e1.a(this, rect, f11, f12, z11);
    }

    public void close() {
        this.internalPath.close();
    }

    public void cubicTo(float f11, float f12, float f13, float f14, float f15, float f16) {
        this.internalPath.cubicTo(f11, f12, f13, f14, f15, f16);
    }

    @NotNull
    public Rect getBounds() {
        this.internalPath.computeBounds(this.rectF, true);
        RectF rectF2 = this.rectF;
        return new Rect(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom);
    }

    /* renamed from: getFillType-Rg-k1Os  reason: not valid java name */
    public int m2809getFillTypeRgk1Os() {
        if (this.internalPath.getFillType() == Path.FillType.EVEN_ODD) {
            return PathFillType.Companion.m3165getEvenOddRgk1Os();
        }
        return PathFillType.Companion.m3166getNonZeroRgk1Os();
    }

    @NotNull
    public final Path getInternalPath() {
        return this.internalPath;
    }

    public boolean isConvex() {
        return this.internalPath.isConvex();
    }

    public boolean isEmpty() {
        return this.internalPath.isEmpty();
    }

    public void lineTo(float f11, float f12) {
        this.internalPath.lineTo(f11, f12);
    }

    public void moveTo(float f11, float f12) {
        this.internalPath.moveTo(f11, f12);
    }

    /* renamed from: op-N5in7k0  reason: not valid java name */
    public boolean m2810opN5in7k0(@NotNull Path path, @NotNull Path path2, int i11) {
        Path.Op op2;
        Intrinsics.checkNotNullParameter(path, "path1");
        Intrinsics.checkNotNullParameter(path2, "path2");
        PathOperation.Companion companion = PathOperation.Companion;
        if (PathOperation.m3170equalsimpl0(i11, companion.m3174getDifferenceb3I0S0c())) {
            op2 = Path.Op.DIFFERENCE;
        } else if (PathOperation.m3170equalsimpl0(i11, companion.m3175getIntersectb3I0S0c())) {
            op2 = Path.Op.INTERSECT;
        } else if (PathOperation.m3170equalsimpl0(i11, companion.m3176getReverseDifferenceb3I0S0c())) {
            op2 = Path.Op.REVERSE_DIFFERENCE;
        } else if (PathOperation.m3170equalsimpl0(i11, companion.m3177getUnionb3I0S0c())) {
            op2 = Path.Op.UNION;
        } else {
            op2 = Path.Op.XOR;
        }
        Path path3 = this.internalPath;
        if (path instanceof AndroidPath) {
            Path internalPath2 = ((AndroidPath) path).getInternalPath();
            if (path2 instanceof AndroidPath) {
                return path3.op(internalPath2, ((AndroidPath) path2).getInternalPath(), op2);
            }
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public void quadraticBezierTo(float f11, float f12, float f13, float f14) {
        this.internalPath.quadTo(f11, f12, f13, f14);
    }

    public void relativeCubicTo(float f11, float f12, float f13, float f14, float f15, float f16) {
        this.internalPath.rCubicTo(f11, f12, f13, f14, f15, f16);
    }

    public void relativeLineTo(float f11, float f12) {
        this.internalPath.rLineTo(f11, f12);
    }

    public void relativeMoveTo(float f11, float f12) {
        this.internalPath.rMoveTo(f11, f12);
    }

    public void relativeQuadraticBezierTo(float f11, float f12, float f13, float f14) {
        this.internalPath.rQuadTo(f11, f12, f13, f14);
    }

    public void reset() {
        this.internalPath.reset();
    }

    /* renamed from: setFillType-oQ8Xj4U  reason: not valid java name */
    public void m2811setFillTypeoQ8Xj4U(int i11) {
        Path.FillType fillType;
        Path path = this.internalPath;
        if (PathFillType.m3161equalsimpl0(i11, PathFillType.Companion.m3165getEvenOddRgk1Os())) {
            fillType = Path.FillType.EVEN_ODD;
        } else {
            fillType = Path.FillType.WINDING;
        }
        path.setFillType(fillType);
    }

    /* renamed from: translate-k-4lQ0M  reason: not valid java name */
    public void m2812translatek4lQ0M(long j11) {
        this.mMatrix.reset();
        this.mMatrix.setTranslate(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11));
        this.internalPath.transform(this.mMatrix);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidPath(Path path, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new Path() : path);
    }
}
