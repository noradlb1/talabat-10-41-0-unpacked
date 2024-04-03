package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import e0.e1;
import f0.b;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010R\u001a\u00020\u0014H\u0016J\b\u0010S\u001a\u00020TH\u0002J\b\u0010U\u001a\u00020TH\u0002J\f\u0010V\u001a\u00020T*\u00020WH\u0016R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R0\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R/\u0010&\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020%@FX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u000e\u00102\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R(\u00103\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR$\u00106\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR/\u0010:\u001a\u0002092\u0006\u0010\u0003\u001a\u000209@FX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R/\u0010>\u001a\u00020=2\u0006\u0010\u0003\u001a\u00020=@FX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b?\u0010(\"\u0004\b@\u0010*R$\u0010A\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR$\u0010D\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR\u0010\u0010G\u001a\u0004\u0018\u00010HX\u000e¢\u0006\u0002\n\u0000R$\u0010I\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\r\"\u0004\bK\u0010\u000fR$\u0010L\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\r\"\u0004\bN\u0010\u000fR$\u0010O\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\r\"\u0004\bQ\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006X"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "()V", "value", "Landroidx/compose/ui/graphics/Brush;", "fill", "getFill", "()Landroidx/compose/ui/graphics/Brush;", "setFill", "(Landroidx/compose/ui/graphics/Brush;)V", "", "fillAlpha", "getFillAlpha", "()F", "setFillAlpha", "(F)V", "isPathDirty", "", "isStrokeDirty", "isTrimPathDirty", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "parser", "Landroidx/compose/ui/graphics/vector/PathParser;", "path", "Landroidx/compose/ui/graphics/Path;", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "pathData", "getPathData", "()Ljava/util/List;", "setPathData", "(Ljava/util/List;)V", "Landroidx/compose/ui/graphics/PathFillType;", "pathFillType", "getPathFillType-Rg-k1Os", "()I", "setPathFillType-oQ8Xj4U", "(I)V", "I", "pathMeasure", "Landroidx/compose/ui/graphics/PathMeasure;", "getPathMeasure", "()Landroidx/compose/ui/graphics/PathMeasure;", "pathMeasure$delegate", "Lkotlin/Lazy;", "renderPath", "stroke", "getStroke", "setStroke", "strokeAlpha", "getStrokeAlpha", "setStrokeAlpha", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineCap", "getStrokeLineCap-KaPHkGw", "setStrokeLineCap-BeK7IIE", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineJoin", "getStrokeLineJoin-LxFBmk8", "setStrokeLineJoin-Ww9F2mQ", "strokeLineMiter", "getStrokeLineMiter", "setStrokeLineMiter", "strokeLineWidth", "getStrokeLineWidth", "setStrokeLineWidth", "strokeStyle", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trimPathEnd", "getTrimPathEnd", "setTrimPathEnd", "trimPathOffset", "getTrimPathOffset", "setTrimPathOffset", "trimPathStart", "getTrimPathStart", "setTrimPathStart", "toString", "updatePath", "", "updateRenderPath", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PathComponent extends VNode {
    @Nullable
    private Brush fill;
    private float fillAlpha = 1.0f;
    private boolean isPathDirty = true;
    private boolean isStrokeDirty = true;
    private boolean isTrimPathDirty = true;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private String f9663name = "";
    @NotNull
    private final PathParser parser = new PathParser();
    @NotNull
    private final Path path = AndroidPath_androidKt.Path();
    @NotNull
    private List<? extends PathNode> pathData = VectorKt.getEmptyPath();
    private int pathFillType = VectorKt.getDefaultFillType();
    @NotNull
    private final Lazy pathMeasure$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, PathComponent$pathMeasure$2.INSTANCE);
    @NotNull
    private final Path renderPath = AndroidPath_androidKt.Path();
    @Nullable
    private Brush stroke;
    private float strokeAlpha = 1.0f;
    private int strokeLineCap = VectorKt.getDefaultStrokeLineCap();
    private int strokeLineJoin = VectorKt.getDefaultStrokeLineJoin();
    private float strokeLineMiter = 4.0f;
    private float strokeLineWidth;
    @Nullable
    private Stroke strokeStyle;
    private float trimPathEnd = 1.0f;
    private float trimPathOffset;
    private float trimPathStart;

    public PathComponent() {
        super((DefaultConstructorMarker) null);
    }

    private final PathMeasure getPathMeasure() {
        return (PathMeasure) this.pathMeasure$delegate.getValue();
    }

    private final void updatePath() {
        this.parser.clear();
        this.path.reset();
        this.parser.addPathNodes(this.pathData).toPath(this.path);
        updateRenderPath();
    }

    private final void updateRenderPath() {
        boolean z11;
        boolean z12;
        this.renderPath.reset();
        if (this.trimPathStart == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (this.trimPathEnd == 1.0f) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                e1.c(this.renderPath, this.path, 0, 2, (Object) null);
                return;
            }
        }
        getPathMeasure().setPath(this.path, false);
        float length = getPathMeasure().getLength();
        float f11 = this.trimPathStart;
        float f12 = this.trimPathOffset;
        float f13 = ((f11 + f12) % 1.0f) * length;
        float f14 = ((this.trimPathEnd + f12) % 1.0f) * length;
        if (f13 > f14) {
            getPathMeasure().getSegment(f13, length, this.renderPath, true);
            getPathMeasure().getSegment(0.0f, f14, this.renderPath, true);
            return;
        }
        getPathMeasure().getSegment(f13, f14, this.renderPath, true);
    }

    public void draw(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (this.isPathDirty) {
            updatePath();
        } else if (this.isTrimPathDirty) {
            updateRenderPath();
        }
        this.isPathDirty = false;
        this.isTrimPathDirty = false;
        Brush brush = this.fill;
        if (brush != null) {
            b.F(drawScope, this.renderPath, brush, this.fillAlpha, (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
        }
        Brush brush2 = this.stroke;
        if (brush2 != null) {
            Stroke stroke2 = this.strokeStyle;
            if (this.isStrokeDirty || stroke2 == null) {
                stroke2 = new Stroke(this.strokeLineWidth, this.strokeLineMiter, this.strokeLineCap, this.strokeLineJoin, (PathEffect) null, 16, (DefaultConstructorMarker) null);
                this.strokeStyle = stroke2;
                this.isStrokeDirty = false;
            }
            Stroke stroke3 = stroke2;
            b.F(drawScope, this.renderPath, brush2, this.strokeAlpha, stroke3, (ColorFilter) null, 0, 48, (Object) null);
        }
    }

    @Nullable
    public final Brush getFill() {
        return this.fill;
    }

    public final float getFillAlpha() {
        return this.fillAlpha;
    }

    @NotNull
    public final String getName() {
        return this.f9663name;
    }

    @NotNull
    public final List<PathNode> getPathData() {
        return this.pathData;
    }

    /* renamed from: getPathFillType-Rg-k1Os  reason: not valid java name */
    public final int m3526getPathFillTypeRgk1Os() {
        return this.pathFillType;
    }

    @Nullable
    public final Brush getStroke() {
        return this.stroke;
    }

    public final float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    /* renamed from: getStrokeLineCap-KaPHkGw  reason: not valid java name */
    public final int m3527getStrokeLineCapKaPHkGw() {
        return this.strokeLineCap;
    }

    /* renamed from: getStrokeLineJoin-LxFBmk8  reason: not valid java name */
    public final int m3528getStrokeLineJoinLxFBmk8() {
        return this.strokeLineJoin;
    }

    public final float getStrokeLineMiter() {
        return this.strokeLineMiter;
    }

    public final float getStrokeLineWidth() {
        return this.strokeLineWidth;
    }

    public final float getTrimPathEnd() {
        return this.trimPathEnd;
    }

    public final float getTrimPathOffset() {
        return this.trimPathOffset;
    }

    public final float getTrimPathStart() {
        return this.trimPathStart;
    }

    public final void setFill(@Nullable Brush brush) {
        this.fill = brush;
        invalidate();
    }

    public final void setFillAlpha(float f11) {
        this.fillAlpha = f11;
        invalidate();
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.f9663name = str;
        invalidate();
    }

    public final void setPathData(@NotNull List<? extends PathNode> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.pathData = list;
        this.isPathDirty = true;
        invalidate();
    }

    /* renamed from: setPathFillType-oQ8Xj4U  reason: not valid java name */
    public final void m3529setPathFillTypeoQ8Xj4U(int i11) {
        this.pathFillType = i11;
        this.renderPath.m3153setFillTypeoQ8Xj4U(i11);
        invalidate();
    }

    public final void setStroke(@Nullable Brush brush) {
        this.stroke = brush;
        invalidate();
    }

    public final void setStrokeAlpha(float f11) {
        this.strokeAlpha = f11;
        invalidate();
    }

    /* renamed from: setStrokeLineCap-BeK7IIE  reason: not valid java name */
    public final void m3530setStrokeLineCapBeK7IIE(int i11) {
        this.strokeLineCap = i11;
        this.isStrokeDirty = true;
        invalidate();
    }

    /* renamed from: setStrokeLineJoin-Ww9F2mQ  reason: not valid java name */
    public final void m3531setStrokeLineJoinWw9F2mQ(int i11) {
        this.strokeLineJoin = i11;
        this.isStrokeDirty = true;
        invalidate();
    }

    public final void setStrokeLineMiter(float f11) {
        this.strokeLineMiter = f11;
        this.isStrokeDirty = true;
        invalidate();
    }

    public final void setStrokeLineWidth(float f11) {
        this.strokeLineWidth = f11;
        invalidate();
    }

    public final void setTrimPathEnd(float f11) {
        boolean z11;
        if (this.trimPathEnd == f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            this.trimPathEnd = f11;
            this.isTrimPathDirty = true;
            invalidate();
        }
    }

    public final void setTrimPathOffset(float f11) {
        boolean z11;
        if (this.trimPathOffset == f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            this.trimPathOffset = f11;
            this.isTrimPathDirty = true;
            invalidate();
        }
    }

    public final void setTrimPathStart(float f11) {
        boolean z11;
        if (this.trimPathStart == f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            this.trimPathStart = f11;
            this.isTrimPathDirty = true;
            invalidate();
        }
    }

    @NotNull
    public String toString() {
        return this.path.toString();
    }
}
