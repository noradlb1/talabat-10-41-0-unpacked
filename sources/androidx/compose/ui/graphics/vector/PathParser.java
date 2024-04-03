package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.vector.PathNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002bcB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0012JX\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0006\u0010 \u001a\u00020\fJ\u0010\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0015H\u0002J \u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002JX\u0010'\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0002J \u0010/\u001a\u00020\f2\u0006\u00100\u001a\u0002012\u0006\u0010\u001e\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u00102\u0006\u00100\u001a\u000201H\u0002J\u0018\u00105\u001a\u00020%2\u0006\u00100\u001a\u0002012\u0006\u0010&\u001a\u00020%H\u0002J\u000e\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u000201J\f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0\u0012J\u0010\u00109\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015J\u0014\u0010:\u001a\u00020\f*\u00020;2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010<\u001a\u00020\f*\u00020=2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010>\u001a\u00020\f*\u00020?2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010@\u001a\u00020\f*\u00020A2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010B\u001a\u00020\f*\u00020C2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010D\u001a\u00020\f*\u00020E2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u001c\u0010F\u001a\u00020\f*\u00020G2\u0006\u0010H\u001a\u00020-2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u001c\u0010I\u001a\u00020\f*\u00020J2\u0006\u0010K\u001a\u00020-2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010L\u001a\u00020\f*\u00020M2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010N\u001a\u00020\f*\u00020O2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010P\u001a\u00020\f*\u00020Q2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010R\u001a\u00020\f*\u00020S2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010T\u001a\u00020\f*\u00020U2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010V\u001a\u00020\f*\u00020W2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u001c\u0010X\u001a\u00020\f*\u00020Y2\u0006\u0010H\u001a\u00020-2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u001c\u0010Z\u001a\u00020\f*\u00020[2\u0006\u0010K\u001a\u00020-2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0014\u0010\\\u001a\u00020\f*\u00020]2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\f\u0010^\u001a\u00020\u0017*\u00020\u0017H\u0002J\f\u0010^\u001a\u00020_*\u00020_H\u0002J\u0014\u0010`\u001a\u00020\f*\u00020a2\u0006\u0010\"\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathParser;", "", "()V", "ctrlPoint", "Landroidx/compose/ui/graphics/vector/PathParser$PathPoint;", "currentPoint", "nodes", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "reflectiveCtrlPoint", "segmentPoint", "addNode", "", "cmd", "", "args", "", "addPathNodes", "", "arcToBezier", "p", "Landroidx/compose/ui/graphics/Path;", "cx", "", "cy", "a", "b", "e1x", "e1y", "theta", "start", "sweep", "clear", "close", "target", "copyOfRange", "original", "", "end", "drawArc", "x0", "y0", "x1", "y1", "isMoreThanHalf", "", "isPositiveArc", "extract", "s", "", "result", "Landroidx/compose/ui/graphics/vector/PathParser$ExtractFloatResult;", "getFloats", "nextStart", "parsePathString", "pathData", "toNodes", "toPath", "arcTo", "Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "curveTo", "Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "horizontalTo", "Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "lineTo", "Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "moveTo", "Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "quadTo", "Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "reflectiveCurveTo", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "prevIsCurve", "reflectiveQuadTo", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "prevIsQuad", "relativeArcTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "relativeCurveTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "relativeHorizontalTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "relativeLineTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "relativeMoveTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "relativeQuadTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "relativeReflectiveCurveTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "relativeReflectiveQuadTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "relativeVerticalTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "toRadians", "", "verticalTo", "Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "ExtractFloatResult", "PathPoint", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PathParser {
    @NotNull
    private final PathPoint ctrlPoint = new PathPoint(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
    @NotNull
    private final PathPoint currentPoint = new PathPoint(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
    @NotNull
    private final List<PathNode> nodes = new ArrayList();
    @NotNull
    private final PathPoint reflectiveCtrlPoint = new PathPoint(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
    @NotNull
    private final PathPoint segmentPoint = new PathPoint(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathParser$PathPoint;", "", "x", "", "y", "(FF)V", "getX", "()F", "setX", "(F)V", "getY", "setY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "reset", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PathPoint {

        /* renamed from: x  reason: collision with root package name */
        private float f9694x;

        /* renamed from: y  reason: collision with root package name */
        private float f9695y;

        public PathPoint() {
            this(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
        }

        public PathPoint(float f11, float f12) {
            this.f9694x = f11;
            this.f9695y = f12;
        }

        public static /* synthetic */ PathPoint copy$default(PathPoint pathPoint, float f11, float f12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = pathPoint.f9694x;
            }
            if ((i11 & 2) != 0) {
                f12 = pathPoint.f9695y;
            }
            return pathPoint.copy(f11, f12);
        }

        public final float component1() {
            return this.f9694x;
        }

        public final float component2() {
            return this.f9695y;
        }

        @NotNull
        public final PathPoint copy(float f11, float f12) {
            return new PathPoint(f11, f12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PathPoint)) {
                return false;
            }
            PathPoint pathPoint = (PathPoint) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.f9694x), (Object) Float.valueOf(pathPoint.f9694x)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9695y), (Object) Float.valueOf(pathPoint.f9695y));
        }

        public final float getX() {
            return this.f9694x;
        }

        public final float getY() {
            return this.f9695y;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f9694x) * 31) + Float.floatToIntBits(this.f9695y);
        }

        public final void reset() {
            this.f9694x = 0.0f;
            this.f9695y = 0.0f;
        }

        public final void setX(float f11) {
            this.f9694x = f11;
        }

        public final void setY(float f11) {
            this.f9695y = f11;
        }

        @NotNull
        public String toString() {
            return "PathPoint(x=" + this.f9694x + ", y=" + this.f9695y + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PathPoint(float f11, float f12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? 0.0f : f11, (i11 & 2) != 0 ? 0.0f : f12);
        }
    }

    private final void addNode(char c11, float[] fArr) {
        this.nodes.addAll(PathNodeKt.toPathNodes(c11, fArr));
    }

    private final void arcTo(PathNode.ArcTo arcTo, Path path) {
        drawArc(path, (double) this.currentPoint.getX(), (double) this.currentPoint.getY(), (double) arcTo.getArcStartX(), (double) arcTo.getArcStartY(), (double) arcTo.getHorizontalEllipseRadius(), (double) arcTo.getVerticalEllipseRadius(), (double) arcTo.getTheta(), arcTo.isMoreThanHalf(), arcTo.isPositiveArc());
        this.currentPoint.setX(arcTo.getArcStartX());
        this.currentPoint.setY(arcTo.getArcStartY());
        this.ctrlPoint.setX(this.currentPoint.getX());
        this.ctrlPoint.setY(this.currentPoint.getY());
    }

    private final void arcToBezier(Path path, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19) {
        double d21 = d13;
        double d22 = (double) 4;
        int ceil = (int) Math.ceil(Math.abs((d19 * d22) / 3.141592653589793d));
        double cos = Math.cos(d17);
        double sin = Math.sin(d17);
        double cos2 = Math.cos(d18);
        double sin2 = Math.sin(d18);
        double d23 = -d21;
        double d24 = d23 * cos;
        double d25 = d14 * sin;
        double d26 = (d24 * sin2) - (d25 * cos2);
        double d27 = d23 * sin;
        double d28 = d14 * cos;
        double d29 = (sin2 * d27) + (cos2 * d28);
        double d31 = d19 / ((double) ceil);
        double d32 = d15;
        double d33 = d29;
        double d34 = d26;
        int i11 = 0;
        double d35 = d16;
        double d36 = d18;
        while (i11 < ceil) {
            double d37 = d36 + d31;
            double sin3 = Math.sin(d37);
            double cos3 = Math.cos(d37);
            int i12 = ceil;
            double d38 = (d11 + ((d21 * cos) * cos3)) - (d25 * sin3);
            double d39 = d12 + (d21 * sin * cos3) + (d28 * sin3);
            double d41 = (d24 * sin3) - (d25 * cos3);
            double d42 = (sin3 * d27) + (cos3 * d28);
            double d43 = d37 - d36;
            double tan = Math.tan(d43 / ((double) 2));
            double d44 = d22;
            double sin4 = (Math.sin(d43) * (Math.sqrt(d22 + ((3.0d * tan) * tan)) - ((double) 1))) / ((double) 3);
            path.cubicTo((float) (d32 + (d34 * sin4)), (float) (d35 + (d33 * sin4)), (float) (d38 - (sin4 * d41)), (float) (d39 - (sin4 * d42)), (float) d38, (float) d39);
            i11++;
            d31 = d31;
            sin = sin;
            d32 = d38;
            d27 = d27;
            d36 = d37;
            d33 = d42;
            d22 = d44;
            d34 = d41;
            cos = cos;
            ceil = i12;
            d35 = d39;
            d21 = d13;
        }
    }

    private final void close(Path path) {
        this.currentPoint.setX(this.segmentPoint.getX());
        this.currentPoint.setY(this.segmentPoint.getY());
        this.ctrlPoint.setX(this.segmentPoint.getX());
        this.ctrlPoint.setY(this.segmentPoint.getY());
        path.close();
        path.moveTo(this.currentPoint.getX(), this.currentPoint.getY());
    }

    private final float[] copyOfRange(float[] fArr, int i11, int i12) {
        if (i11 <= i12) {
            int length = fArr.length;
            if (i11 < 0 || i11 > length) {
                throw new IndexOutOfBoundsException();
            }
            int i13 = i12 - i11;
            int min = Math.min(i13, length - i11);
            float[] fArr2 = new float[i13];
            float[] unused = ArraysKt___ArraysJvmKt.copyInto(fArr, fArr2, 0, i11, min + i11);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    private final void curveTo(PathNode.CurveTo curveTo, Path path) {
        path.cubicTo(curveTo.getX1(), curveTo.getY1(), curveTo.getX2(), curveTo.getY2(), curveTo.getX3(), curveTo.getY3());
        this.ctrlPoint.setX(curveTo.getX2());
        this.ctrlPoint.setY(curveTo.getY2());
        this.currentPoint.setX(curveTo.getX3());
        this.currentPoint.setY(curveTo.getY3());
    }

    private final void drawArc(Path path, double d11, double d12, double d13, double d14, double d15, double d16, double d17, boolean z11, boolean z12) {
        boolean z13;
        double d18;
        double d19;
        boolean z14;
        double d21 = d11;
        double d22 = d13;
        boolean z15 = z12;
        double radians = toRadians(d17);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d23 = ((d21 * cos) + (d12 * sin)) / d15;
        double d24 = (((-d21) * sin) + (d12 * cos)) / d16;
        double d25 = ((d22 * cos) + (d14 * sin)) / d15;
        double d26 = (((-d22) * sin) + (d14 * cos)) / d16;
        double d27 = d23 - d25;
        double d28 = d24 - d26;
        double d29 = (double) 2;
        double d31 = (d23 + d25) / d29;
        double d32 = (d24 + d26) / d29;
        double d33 = (d27 * d27) + (d28 * d28);
        if (d33 == 0.0d) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (!z13) {
            double d34 = (1.0d / d33) - 0.25d;
            if (d34 < 0.0d) {
                double sqrt = (double) ((float) (Math.sqrt(d33) / 1.99999d));
                boolean z16 = z15;
                drawArc(path, d11, d12, d13, d14, d15 * sqrt, d16 * sqrt, d17, z11, z12);
                return;
            }
            double sqrt2 = Math.sqrt(d34);
            double d35 = d27 * sqrt2;
            double d36 = sqrt2 * d28;
            boolean z17 = z12;
            if (z11 == z17) {
                d19 = d31 - d36;
                d18 = d32 + d35;
            } else {
                d19 = d31 + d36;
                d18 = d32 - d35;
            }
            double atan2 = Math.atan2(d24 - d18, d23 - d19);
            double atan22 = Math.atan2(d26 - d18, d25 - d19) - atan2;
            int i11 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (i11 >= 0) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (z17 != z14) {
                if (i11 > 0) {
                    atan22 -= 6.283185307179586d;
                } else {
                    atan22 += 6.283185307179586d;
                }
            }
            double d37 = d19 * d15;
            double d38 = d18 * d16;
            arcToBezier(path, (d37 * cos) - (d38 * sin), (d37 * sin) + (d38 * cos), d15, d16, d11, d12, radians, atan2, atan22);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0051 A[LOOP:0: B:1:0x0008->B:31:0x0051, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0054 A[EDGE_INSN: B:35:0x0054->B:32:0x0054 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void extract(java.lang.String r9, int r10, androidx.compose.ui.graphics.vector.PathParser.ExtractFloatResult r11) {
        /*
            r8 = this;
            r0 = 0
            r11.setEndWithNegativeOrDot(r0)
            r1 = r10
            r2 = r0
            r3 = r2
            r4 = r3
        L_0x0008:
            int r5 = r9.length()
            if (r1 >= r5) goto L_0x0054
            char r5 = r9.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 != r6) goto L_0x0019
        L_0x0017:
            r6 = r7
            goto L_0x001f
        L_0x0019:
            r6 = 44
            if (r5 != r6) goto L_0x001e
            goto L_0x0017
        L_0x001e:
            r6 = r0
        L_0x001f:
            if (r6 == 0) goto L_0x0024
        L_0x0021:
            r2 = r0
            r4 = r7
            goto L_0x004e
        L_0x0024:
            r6 = 45
            if (r5 != r6) goto L_0x0030
            if (r1 == r10) goto L_0x004d
            if (r2 != 0) goto L_0x004d
            r11.setEndWithNegativeOrDot(r7)
            goto L_0x0021
        L_0x0030:
            r2 = 46
            if (r5 != r2) goto L_0x003d
            if (r3 != 0) goto L_0x0039
            r2 = r0
            r3 = r7
            goto L_0x004e
        L_0x0039:
            r11.setEndWithNegativeOrDot(r7)
            goto L_0x0021
        L_0x003d:
            r2 = 101(0x65, float:1.42E-43)
            if (r5 != r2) goto L_0x0043
        L_0x0041:
            r2 = r7
            goto L_0x0049
        L_0x0043:
            r2 = 69
            if (r5 != r2) goto L_0x0048
            goto L_0x0041
        L_0x0048:
            r2 = r0
        L_0x0049:
            if (r2 == 0) goto L_0x004d
            r2 = r7
            goto L_0x004e
        L_0x004d:
            r2 = r0
        L_0x004e:
            if (r4 == 0) goto L_0x0051
            goto L_0x0054
        L_0x0051:
            int r1 = r1 + 1
            goto L_0x0008
        L_0x0054:
            r11.setEndPosition(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathParser.extract(java.lang.String, int, androidx.compose.ui.graphics.vector.PathParser$ExtractFloatResult):void");
    }

    private final float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        float[] fArr = new float[str.length()];
        ExtractFloatResult extractFloatResult = new ExtractFloatResult(0, false, 3, (DefaultConstructorMarker) null);
        int length = str.length();
        int i11 = 1;
        int i12 = 0;
        while (i11 < length) {
            extract(str, i11, extractFloatResult);
            int endPosition = extractFloatResult.getEndPosition();
            if (i11 < endPosition) {
                String substring = str.substring(i11, endPosition);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                fArr[i12] = Float.parseFloat(substring);
                i12++;
            }
            if (extractFloatResult.getEndWithNegativeOrDot()) {
                i11 = endPosition;
            } else {
                i11 = endPosition + 1;
            }
        }
        return copyOfRange(fArr, 0, i12);
    }

    private final void horizontalTo(PathNode.HorizontalTo horizontalTo, Path path) {
        path.lineTo(horizontalTo.getX(), this.currentPoint.getY());
        this.currentPoint.setX(horizontalTo.getX());
    }

    private final void lineTo(PathNode.LineTo lineTo, Path path) {
        path.lineTo(lineTo.getX(), lineTo.getY());
        this.currentPoint.setX(lineTo.getX());
        this.currentPoint.setY(lineTo.getY());
    }

    private final void moveTo(PathNode.MoveTo moveTo, Path path) {
        this.currentPoint.setX(moveTo.getX());
        this.currentPoint.setY(moveTo.getY());
        path.moveTo(moveTo.getX(), moveTo.getY());
        this.segmentPoint.setX(this.currentPoint.getX());
        this.segmentPoint.setY(this.currentPoint.getY());
    }

    private final int nextStart(String str, int i11) {
        while (i11 < str.length()) {
            char charAt = str.charAt(i11);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i11;
            }
            i11++;
        }
        return i11;
    }

    private final void quadTo(PathNode.QuadTo quadTo, Path path) {
        path.quadraticBezierTo(quadTo.getX1(), quadTo.getY1(), quadTo.getX2(), quadTo.getY2());
        this.ctrlPoint.setX(quadTo.getX1());
        this.ctrlPoint.setY(quadTo.getY1());
        this.currentPoint.setX(quadTo.getX2());
        this.currentPoint.setY(quadTo.getY2());
    }

    private final void reflectiveCurveTo(PathNode.ReflectiveCurveTo reflectiveCurveTo, boolean z11, Path path) {
        if (z11) {
            float f11 = (float) 2;
            this.reflectiveCtrlPoint.setX((this.currentPoint.getX() * f11) - this.ctrlPoint.getX());
            this.reflectiveCtrlPoint.setY((f11 * this.currentPoint.getY()) - this.ctrlPoint.getY());
        } else {
            this.reflectiveCtrlPoint.setX(this.currentPoint.getX());
            this.reflectiveCtrlPoint.setY(this.currentPoint.getY());
        }
        path.cubicTo(this.reflectiveCtrlPoint.getX(), this.reflectiveCtrlPoint.getY(), reflectiveCurveTo.getX1(), reflectiveCurveTo.getY1(), reflectiveCurveTo.getX2(), reflectiveCurveTo.getY2());
        this.ctrlPoint.setX(reflectiveCurveTo.getX1());
        this.ctrlPoint.setY(reflectiveCurveTo.getY1());
        this.currentPoint.setX(reflectiveCurveTo.getX2());
        this.currentPoint.setY(reflectiveCurveTo.getY2());
    }

    private final void reflectiveQuadTo(PathNode.ReflectiveQuadTo reflectiveQuadTo, boolean z11, Path path) {
        if (z11) {
            float f11 = (float) 2;
            this.reflectiveCtrlPoint.setX((this.currentPoint.getX() * f11) - this.ctrlPoint.getX());
            this.reflectiveCtrlPoint.setY((f11 * this.currentPoint.getY()) - this.ctrlPoint.getY());
        } else {
            this.reflectiveCtrlPoint.setX(this.currentPoint.getX());
            this.reflectiveCtrlPoint.setY(this.currentPoint.getY());
        }
        path.quadraticBezierTo(this.reflectiveCtrlPoint.getX(), this.reflectiveCtrlPoint.getY(), reflectiveQuadTo.getX(), reflectiveQuadTo.getY());
        this.ctrlPoint.setX(this.reflectiveCtrlPoint.getX());
        this.ctrlPoint.setY(this.reflectiveCtrlPoint.getY());
        this.currentPoint.setX(reflectiveQuadTo.getX());
        this.currentPoint.setY(reflectiveQuadTo.getY());
    }

    private final void relativeArcTo(PathNode.RelativeArcTo relativeArcTo, Path path) {
        float arcStartDx = relativeArcTo.getArcStartDx() + this.currentPoint.getX();
        float arcStartDy = relativeArcTo.getArcStartDy() + this.currentPoint.getY();
        drawArc(path, (double) this.currentPoint.getX(), (double) this.currentPoint.getY(), (double) arcStartDx, (double) arcStartDy, (double) relativeArcTo.getHorizontalEllipseRadius(), (double) relativeArcTo.getVerticalEllipseRadius(), (double) relativeArcTo.getTheta(), relativeArcTo.isMoreThanHalf(), relativeArcTo.isPositiveArc());
        this.currentPoint.setX(arcStartDx);
        this.currentPoint.setY(arcStartDy);
        this.ctrlPoint.setX(this.currentPoint.getX());
        this.ctrlPoint.setY(this.currentPoint.getY());
    }

    private final void relativeCurveTo(PathNode.RelativeCurveTo relativeCurveTo, Path path) {
        path.relativeCubicTo(relativeCurveTo.getDx1(), relativeCurveTo.getDy1(), relativeCurveTo.getDx2(), relativeCurveTo.getDy2(), relativeCurveTo.getDx3(), relativeCurveTo.getDy3());
        this.ctrlPoint.setX(this.currentPoint.getX() + relativeCurveTo.getDx2());
        this.ctrlPoint.setY(this.currentPoint.getY() + relativeCurveTo.getDy2());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeCurveTo.getDx3());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + relativeCurveTo.getDy3());
    }

    private final void relativeHorizontalTo(PathNode.RelativeHorizontalTo relativeHorizontalTo, Path path) {
        path.relativeLineTo(relativeHorizontalTo.getDx(), 0.0f);
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeHorizontalTo.getDx());
    }

    private final void relativeLineTo(PathNode.RelativeLineTo relativeLineTo, Path path) {
        path.relativeLineTo(relativeLineTo.getDx(), relativeLineTo.getDy());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeLineTo.getDx());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + relativeLineTo.getDy());
    }

    private final void relativeMoveTo(PathNode.RelativeMoveTo relativeMoveTo, Path path) {
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeMoveTo.getDx());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + relativeMoveTo.getDy());
        path.relativeMoveTo(relativeMoveTo.getDx(), relativeMoveTo.getDy());
        this.segmentPoint.setX(this.currentPoint.getX());
        this.segmentPoint.setY(this.currentPoint.getY());
    }

    private final void relativeQuadTo(PathNode.RelativeQuadTo relativeQuadTo, Path path) {
        path.relativeQuadraticBezierTo(relativeQuadTo.getDx1(), relativeQuadTo.getDy1(), relativeQuadTo.getDx2(), relativeQuadTo.getDy2());
        this.ctrlPoint.setX(this.currentPoint.getX() + relativeQuadTo.getDx1());
        this.ctrlPoint.setY(this.currentPoint.getY() + relativeQuadTo.getDy1());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeQuadTo.getDx2());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + relativeQuadTo.getDy2());
    }

    private final void relativeReflectiveCurveTo(PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo, boolean z11, Path path) {
        if (z11) {
            this.reflectiveCtrlPoint.setX(this.currentPoint.getX() - this.ctrlPoint.getX());
            this.reflectiveCtrlPoint.setY(this.currentPoint.getY() - this.ctrlPoint.getY());
        } else {
            this.reflectiveCtrlPoint.reset();
        }
        path.relativeCubicTo(this.reflectiveCtrlPoint.getX(), this.reflectiveCtrlPoint.getY(), relativeReflectiveCurveTo.getDx1(), relativeReflectiveCurveTo.getDy1(), relativeReflectiveCurveTo.getDx2(), relativeReflectiveCurveTo.getDy2());
        this.ctrlPoint.setX(this.currentPoint.getX() + relativeReflectiveCurveTo.getDx1());
        this.ctrlPoint.setY(this.currentPoint.getY() + relativeReflectiveCurveTo.getDy1());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeReflectiveCurveTo.getDx2());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + relativeReflectiveCurveTo.getDy2());
    }

    private final void relativeReflectiveQuadTo(PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo, boolean z11, Path path) {
        if (z11) {
            this.reflectiveCtrlPoint.setX(this.currentPoint.getX() - this.ctrlPoint.getX());
            this.reflectiveCtrlPoint.setY(this.currentPoint.getY() - this.ctrlPoint.getY());
        } else {
            this.reflectiveCtrlPoint.reset();
        }
        path.relativeQuadraticBezierTo(this.reflectiveCtrlPoint.getX(), this.reflectiveCtrlPoint.getY(), relativeReflectiveQuadTo.getDx(), relativeReflectiveQuadTo.getDy());
        this.ctrlPoint.setX(this.currentPoint.getX() + this.reflectiveCtrlPoint.getX());
        this.ctrlPoint.setY(this.currentPoint.getY() + this.reflectiveCtrlPoint.getY());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setX(pathPoint.getX() + relativeReflectiveQuadTo.getDx());
        PathPoint pathPoint2 = this.currentPoint;
        pathPoint2.setY(pathPoint2.getY() + relativeReflectiveQuadTo.getDy());
    }

    private final void relativeVerticalTo(PathNode.RelativeVerticalTo relativeVerticalTo, Path path) {
        path.relativeLineTo(0.0f, relativeVerticalTo.getDy());
        PathPoint pathPoint = this.currentPoint;
        pathPoint.setY(pathPoint.getY() + relativeVerticalTo.getDy());
    }

    public static /* synthetic */ Path toPath$default(PathParser pathParser, Path path, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return pathParser.toPath(path);
    }

    private final double toRadians(double d11) {
        return (d11 / ((double) 180)) * 3.141592653589793d;
    }

    private final float toRadians(float f11) {
        return (f11 / 180.0f) * 3.1415927f;
    }

    private final void verticalTo(PathNode.VerticalTo verticalTo, Path path) {
        path.lineTo(this.currentPoint.getX(), verticalTo.getY());
        this.currentPoint.setY(verticalTo.getY());
    }

    @NotNull
    public final PathParser addPathNodes(@NotNull List<? extends PathNode> list) {
        Intrinsics.checkNotNullParameter(list, "nodes");
        this.nodes.addAll(list);
        return this;
    }

    public final void clear() {
        this.nodes.clear();
    }

    @NotNull
    public final PathParser parsePathString(@NotNull String str) {
        boolean z11;
        int i11;
        boolean z12;
        Intrinsics.checkNotNullParameter(str, "pathData");
        this.nodes.clear();
        int i12 = 0;
        int i13 = 1;
        while (i13 < str.length()) {
            int nextStart = nextStart(str, i13);
            String substring = str.substring(i12, nextStart);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            int length = substring.length() - 1;
            int i14 = 0;
            boolean z13 = false;
            while (i14 <= length) {
                if (!z13) {
                    i11 = i14;
                } else {
                    i11 = length;
                }
                if (Intrinsics.compare((int) substring.charAt(i11), 32) <= 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z13) {
                    if (!z12) {
                        z13 = true;
                    } else {
                        i14++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            String obj = substring.subSequence(i14, length + 1).toString();
            if (obj.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                addNode(obj.charAt(0), getFloats(obj));
            }
            i12 = nextStart;
            i13 = nextStart + 1;
        }
        if (i13 - i12 == 1 && i12 < str.length()) {
            addNode(str.charAt(i12), new float[0]);
        }
        return this;
    }

    @NotNull
    public final List<PathNode> toNodes() {
        return this.nodes;
    }

    @NotNull
    public final Path toPath(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "target");
        path.reset();
        this.currentPoint.reset();
        this.ctrlPoint.reset();
        this.segmentPoint.reset();
        this.reflectiveCtrlPoint.reset();
        List<PathNode> list = this.nodes;
        int size = list.size();
        PathNode pathNode = null;
        int i11 = 0;
        while (i11 < size) {
            PathNode pathNode2 = list.get(i11);
            if (pathNode == null) {
                pathNode = pathNode2;
            }
            if (pathNode2 instanceof PathNode.Close) {
                close(path);
            } else if (pathNode2 instanceof PathNode.RelativeMoveTo) {
                relativeMoveTo((PathNode.RelativeMoveTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.MoveTo) {
                moveTo((PathNode.MoveTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.RelativeLineTo) {
                relativeLineTo((PathNode.RelativeLineTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.LineTo) {
                lineTo((PathNode.LineTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.RelativeHorizontalTo) {
                relativeHorizontalTo((PathNode.RelativeHorizontalTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.HorizontalTo) {
                horizontalTo((PathNode.HorizontalTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.RelativeVerticalTo) {
                relativeVerticalTo((PathNode.RelativeVerticalTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.VerticalTo) {
                verticalTo((PathNode.VerticalTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.RelativeCurveTo) {
                relativeCurveTo((PathNode.RelativeCurveTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.CurveTo) {
                curveTo((PathNode.CurveTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.RelativeReflectiveCurveTo) {
                Intrinsics.checkNotNull(pathNode);
                relativeReflectiveCurveTo((PathNode.RelativeReflectiveCurveTo) pathNode2, pathNode.isCurve(), path);
            } else if (pathNode2 instanceof PathNode.ReflectiveCurveTo) {
                Intrinsics.checkNotNull(pathNode);
                reflectiveCurveTo((PathNode.ReflectiveCurveTo) pathNode2, pathNode.isCurve(), path);
            } else if (pathNode2 instanceof PathNode.RelativeQuadTo) {
                relativeQuadTo((PathNode.RelativeQuadTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.QuadTo) {
                quadTo((PathNode.QuadTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.RelativeReflectiveQuadTo) {
                Intrinsics.checkNotNull(pathNode);
                relativeReflectiveQuadTo((PathNode.RelativeReflectiveQuadTo) pathNode2, pathNode.isQuad(), path);
            } else if (pathNode2 instanceof PathNode.ReflectiveQuadTo) {
                Intrinsics.checkNotNull(pathNode);
                reflectiveQuadTo((PathNode.ReflectiveQuadTo) pathNode2, pathNode.isQuad(), path);
            } else if (pathNode2 instanceof PathNode.RelativeArcTo) {
                relativeArcTo((PathNode.RelativeArcTo) pathNode2, path);
            } else if (pathNode2 instanceof PathNode.ArcTo) {
                arcTo((PathNode.ArcTo) pathNode2, path);
            }
            i11++;
            pathNode = pathNode2;
        }
        return path;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathParser$ExtractFloatResult;", "", "endPosition", "", "endWithNegativeOrDot", "", "(IZ)V", "getEndPosition", "()I", "setEndPosition", "(I)V", "getEndWithNegativeOrDot", "()Z", "setEndWithNegativeOrDot", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ExtractFloatResult {
        private int endPosition;
        private boolean endWithNegativeOrDot;

        public ExtractFloatResult() {
            this(0, false, 3, (DefaultConstructorMarker) null);
        }

        public ExtractFloatResult(int i11, boolean z11) {
            this.endPosition = i11;
            this.endWithNegativeOrDot = z11;
        }

        public static /* synthetic */ ExtractFloatResult copy$default(ExtractFloatResult extractFloatResult, int i11, boolean z11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = extractFloatResult.endPosition;
            }
            if ((i12 & 2) != 0) {
                z11 = extractFloatResult.endWithNegativeOrDot;
            }
            return extractFloatResult.copy(i11, z11);
        }

        public final int component1() {
            return this.endPosition;
        }

        public final boolean component2() {
            return this.endWithNegativeOrDot;
        }

        @NotNull
        public final ExtractFloatResult copy(int i11, boolean z11) {
            return new ExtractFloatResult(i11, z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExtractFloatResult)) {
                return false;
            }
            ExtractFloatResult extractFloatResult = (ExtractFloatResult) obj;
            return this.endPosition == extractFloatResult.endPosition && this.endWithNegativeOrDot == extractFloatResult.endWithNegativeOrDot;
        }

        public final int getEndPosition() {
            return this.endPosition;
        }

        public final boolean getEndWithNegativeOrDot() {
            return this.endWithNegativeOrDot;
        }

        public int hashCode() {
            int i11 = this.endPosition * 31;
            boolean z11 = this.endWithNegativeOrDot;
            if (z11) {
                z11 = true;
            }
            return i11 + (z11 ? 1 : 0);
        }

        public final void setEndPosition(int i11) {
            this.endPosition = i11;
        }

        public final void setEndWithNegativeOrDot(boolean z11) {
            this.endWithNegativeOrDot = z11;
        }

        @NotNull
        public String toString() {
            return "ExtractFloatResult(endPosition=" + this.endPosition + ", endWithNegativeOrDot=" + this.endWithNegativeOrDot + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ExtractFloatResult(int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 0 : i11, (i12 & 2) != 0 ? false : z11);
        }
    }
}
