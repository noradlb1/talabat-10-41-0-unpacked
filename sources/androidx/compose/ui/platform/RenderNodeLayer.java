package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(23)
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0002fgB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0007H\u0002J\b\u0010*\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0007H\u0016J\b\u0010,\u001a\u00020\bH\u0016J\u001d\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001d\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u000204H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u0018\u00107\u001a\u00020\b2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u000fH\u0016J%\u0010;\u001a\u0002042\u0006\u0010<\u001a\u0002042\u0006\u0010:\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001d\u0010?\u001a\u00020\b2\u0006\u00103\u001a\u00020@H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u001d\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020EH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010BJ*\u0010G\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\u001d\u0010H\u001a\u00020\b2\u0006\u0010.\u001a\u00020/H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u00101J\b\u0010J\u001a\u00020\bH\u0002J\b\u0010K\u001a\u00020\bH\u0016J§\u0001\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020N2\u0006\u0010Q\u001a\u00020N2\u0006\u0010R\u001a\u00020N2\u0006\u0010S\u001a\u00020N2\u0006\u0010T\u001a\u00020N2\u0006\u0010U\u001a\u00020N2\u0006\u0010V\u001a\u00020N2\u0006\u0010W\u001a\u00020N2\u0006\u0010%\u001a\u00020&2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u000f2\b\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020^2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020cH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bd\u0010eR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0018R\u000e\u0010\"\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010%\u001a\u00020&X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010'\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006h"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "drawnWithZ", "", "isDestroyed", "value", "isDirty", "setDirty", "(Z)V", "layerId", "", "getLayerId", "()J", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "renderNode", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "clipRenderNode", "canvas", "destroy", "drawLayer", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "triggerRepaint", "updateDisplayList", "updateLayerProperties", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "updateLayerProperties-NHXXZp8", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)V", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RenderNodeLayer implements OwnedLayer, GraphicLayerInfo {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final Function2<DeviceRenderNode, Matrix, Unit> getMatrix = RenderNodeLayer$Companion$getMatrix$1.INSTANCE;
    @NotNull
    private final CanvasHolder canvasHolder = new CanvasHolder();
    @Nullable
    private Function1<? super Canvas, Unit> drawBlock;
    private boolean drawnWithZ;
    @Nullable
    private Function0<Unit> invalidateParentLayer;
    private boolean isDestroyed;
    private boolean isDirty;
    @NotNull
    private final LayerMatrixCache<DeviceRenderNode> matrixCache = new LayerMatrixCache<>(getMatrix);
    @NotNull
    private final OutlineResolver outlineResolver;
    @NotNull
    private final AndroidComposeView ownerView;
    @NotNull
    private final DeviceRenderNode renderNode;
    @Nullable
    private Paint softwareLayerPaint;
    private long transformOrigin = TransformOrigin.Companion.m3292getCenterSzJe1aQ();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer$Companion;", "", "()V", "getMatrix", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "Landroid/graphics/Matrix;", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @RequiresApi(29)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class UniqueDrawingIdApi29 {
        @NotNull
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        @DoNotInline
        public static final long getUniqueDrawingId(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return view.getUniqueDrawingId();
        }
    }

    public RenderNodeLayer(@NotNull AndroidComposeView androidComposeView, @NotNull Function1<? super Canvas, Unit> function1, @NotNull Function0<Unit> function0) {
        DeviceRenderNode deviceRenderNode;
        Intrinsics.checkNotNullParameter(androidComposeView, "ownerView");
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Intrinsics.checkNotNullParameter(function0, "invalidateParentLayer");
        this.ownerView = androidComposeView;
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
        this.outlineResolver = new OutlineResolver(androidComposeView.getDensity());
        if (Build.VERSION.SDK_INT >= 29) {
            deviceRenderNode = new RenderNodeApi29(androidComposeView);
        } else {
            deviceRenderNode = new RenderNodeApi23(androidComposeView);
        }
        deviceRenderNode.setHasOverlappingRendering(true);
        this.renderNode = deviceRenderNode;
    }

    private final void clipRenderNode(Canvas canvas) {
        if (this.renderNode.getClipToOutline() || this.renderNode.getClipToBounds()) {
            this.outlineResolver.clipToOutline(canvas);
        }
    }

    private final void setDirty(boolean z11) {
        if (z11 != this.isDirty) {
            this.isDirty = z11;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z11);
        }
    }

    private final void triggerRepaint() {
        if (Build.VERSION.SDK_INT >= 26) {
            WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
        } else {
            this.ownerView.invalidate();
        }
    }

    public void destroy() {
        if (this.renderNode.getHasDisplayList()) {
            this.renderNode.discardDisplayList();
        }
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        this.ownerView.requestClearInvalidObservations();
        this.ownerView.recycle$ui_release(this);
    }

    public void drawLayer(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        boolean z11 = false;
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            if (this.renderNode.getElevation() > 0.0f) {
                z11 = true;
            }
            this.drawnWithZ = z11;
            if (z11) {
                canvas.enableZ();
            }
            this.renderNode.drawInto(nativeCanvas);
            if (this.drawnWithZ) {
                canvas.disableZ();
                return;
            }
            return;
        }
        float left = (float) this.renderNode.getLeft();
        float top = (float) this.renderNode.getTop();
        float right = (float) this.renderNode.getRight();
        float bottom = (float) this.renderNode.getBottom();
        if (this.renderNode.getAlpha() < 1.0f) {
            Paint paint = this.softwareLayerPaint;
            if (paint == null) {
                paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = paint;
            }
            paint.setAlpha(this.renderNode.getAlpha());
            nativeCanvas.saveLayer(left, top, right, bottom, paint.asFrameworkPaint());
        } else {
            canvas.save();
        }
        canvas.translate(left, top);
        canvas.m2887concat58bKbWc(this.matrixCache.m4844calculateMatrixGrdbGEg(this.renderNode));
        clipRenderNode(canvas);
        Function1<? super Canvas, Unit> function1 = this.drawBlock;
        if (function1 != null) {
            function1.invoke(canvas);
        }
        canvas.restore();
        setDirty(false);
    }

    public long getLayerId() {
        return this.renderNode.getUniqueId();
    }

    @NotNull
    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1;
    }

    public void invalidate() {
        if (!this.isDirty && !this.isDestroyed) {
            this.ownerView.invalidate();
            setDirty(true);
        }
    }

    /* renamed from: inverseTransform-58bKbWc  reason: not valid java name */
    public void m4872inverseTransform58bKbWc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        float[] r02 = this.matrixCache.m4843calculateInverseMatrixbWbORWo(this.renderNode);
        if (r02 != null) {
            androidx.compose.ui.graphics.Matrix.m3117timesAssign58bKbWc(fArr, r02);
        }
    }

    /* renamed from: isInLayer-k-4lQ0M  reason: not valid java name */
    public boolean m4873isInLayerk4lQ0M(long j11) {
        float r02 = Offset.m2676getXimpl(j11);
        float r12 = Offset.m2677getYimpl(j11);
        if (this.renderNode.getClipToBounds()) {
            if (0.0f > r02 || r02 >= ((float) this.renderNode.getWidth()) || 0.0f > r12 || r12 >= ((float) this.renderNode.getHeight())) {
                return false;
            }
            return true;
        } else if (this.renderNode.getClipToOutline()) {
            return this.outlineResolver.m4870isInOutlinek4lQ0M(j11);
        } else {
            return true;
        }
    }

    public void mapBounds(@NotNull MutableRect mutableRect, boolean z11) {
        Intrinsics.checkNotNullParameter(mutableRect, "rect");
        if (z11) {
            float[] r32 = this.matrixCache.m4843calculateInverseMatrixbWbORWo(this.renderNode);
            if (r32 == null) {
                mutableRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            } else {
                androidx.compose.ui.graphics.Matrix.m3108mapimpl(r32, mutableRect);
            }
        } else {
            androidx.compose.ui.graphics.Matrix.m3108mapimpl(this.matrixCache.m4844calculateMatrixGrdbGEg(this.renderNode), mutableRect);
        }
    }

    /* renamed from: mapOffset-8S9VItk  reason: not valid java name */
    public long m4874mapOffset8S9VItk(long j11, boolean z11) {
        if (!z11) {
            return androidx.compose.ui.graphics.Matrix.m3106mapMKHz9U(this.matrixCache.m4844calculateMatrixGrdbGEg(this.renderNode), j11);
        }
        float[] r42 = this.matrixCache.m4843calculateInverseMatrixbWbORWo(this.renderNode);
        if (r42 != null) {
            return androidx.compose.ui.graphics.Matrix.m3106mapMKHz9U(r42, j11);
        }
        return Offset.Companion.m2690getInfiniteF1C5BW0();
    }

    /* renamed from: move--gyyYBs  reason: not valid java name */
    public void m4875movegyyYBs(long j11) {
        int left = this.renderNode.getLeft();
        int top = this.renderNode.getTop();
        int r22 = IntOffset.m5596getXimpl(j11);
        int r42 = IntOffset.m5597getYimpl(j11);
        if (left != r22 || top != r42) {
            this.renderNode.offsetLeftAndRight(r22 - left);
            this.renderNode.offsetTopAndBottom(r42 - top);
            triggerRepaint();
            this.matrixCache.invalidate();
        }
    }

    /* renamed from: resize-ozmzZPI  reason: not valid java name */
    public void m4876resizeozmzZPI(long j11) {
        int r02 = IntSize.m5638getWidthimpl(j11);
        int r72 = IntSize.m5637getHeightimpl(j11);
        float f11 = (float) r02;
        this.renderNode.setPivotX(TransformOrigin.m3287getPivotFractionXimpl(this.transformOrigin) * f11);
        float f12 = (float) r72;
        this.renderNode.setPivotY(TransformOrigin.m3288getPivotFractionYimpl(this.transformOrigin) * f12);
        DeviceRenderNode deviceRenderNode = this.renderNode;
        if (deviceRenderNode.setPosition(deviceRenderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getLeft() + r02, this.renderNode.getTop() + r72)) {
            this.outlineResolver.m4871updateuvyYCjk(SizeKt.Size(f11, f12));
            this.renderNode.setOutline(this.outlineResolver.getOutline());
            invalidate();
            this.matrixCache.invalidate();
        }
    }

    public void reuseLayer(@NotNull Function1<? super Canvas, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Intrinsics.checkNotNullParameter(function0, "invalidateParentLayer");
        setDirty(false);
        this.isDestroyed = false;
        this.drawnWithZ = false;
        this.transformOrigin = TransformOrigin.Companion.m3292getCenterSzJe1aQ();
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
    }

    /* renamed from: transform-58bKbWc  reason: not valid java name */
    public void m4877transform58bKbWc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        androidx.compose.ui.graphics.Matrix.m3117timesAssign58bKbWc(fArr, this.matrixCache.m4844calculateMatrixGrdbGEg(this.renderNode));
    }

    public void updateDisplayList() {
        Path path;
        if (this.isDirty || !this.renderNode.getHasDisplayList()) {
            setDirty(false);
            if (!this.renderNode.getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
                path = null;
            } else {
                path = this.outlineResolver.getClipPath();
            }
            Function1<? super Canvas, Unit> function1 = this.drawBlock;
            if (function1 != null) {
                this.renderNode.record(this.canvasHolder, path, function1);
            }
        }
    }

    /* renamed from: updateLayerProperties-NHXXZp8  reason: not valid java name */
    public void m4878updateLayerPropertiesNHXXZp8(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, @NotNull Shape shape, boolean z11, @Nullable RenderEffect renderEffect, long j12, long j13, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Function0<Unit> function0;
        Shape shape2 = shape;
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        this.transformOrigin = j11;
        boolean z12 = true;
        boolean z13 = this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported();
        float f22 = f11;
        this.renderNode.setScaleX(f11);
        float f23 = f12;
        this.renderNode.setScaleY(f12);
        float f24 = f13;
        this.renderNode.setAlpha(f13);
        this.renderNode.setTranslationX(f14);
        this.renderNode.setTranslationY(f15);
        this.renderNode.setElevation(f16);
        this.renderNode.setAmbientShadowColor(ColorKt.m2974toArgb8_81llA(j12));
        this.renderNode.setSpotShadowColor(ColorKt.m2974toArgb8_81llA(j13));
        this.renderNode.setRotationZ(f19);
        this.renderNode.setRotationX(f17);
        this.renderNode.setRotationY(f18);
        this.renderNode.setCameraDistance(f21);
        this.renderNode.setPivotX(TransformOrigin.m3287getPivotFractionXimpl(j11) * ((float) this.renderNode.getWidth()));
        this.renderNode.setPivotY(TransformOrigin.m3288getPivotFractionYimpl(j11) * ((float) this.renderNode.getHeight()));
        this.renderNode.setClipToOutline(z11 && shape2 != RectangleShapeKt.getRectangleShape());
        this.renderNode.setClipToBounds(z11 && shape2 == RectangleShapeKt.getRectangleShape());
        this.renderNode.setRenderEffect(renderEffect);
        boolean update = this.outlineResolver.update(shape, this.renderNode.getAlpha(), this.renderNode.getClipToOutline(), this.renderNode.getElevation(), layoutDirection, density);
        this.renderNode.setOutline(this.outlineResolver.getOutline());
        if (!this.renderNode.getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
            z12 = false;
        }
        if (z13 != z12 || (z12 && update)) {
            invalidate();
        } else {
            triggerRepaint();
        }
        if (!this.drawnWithZ && this.renderNode.getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        this.matrixCache.invalidate();
    }
}
