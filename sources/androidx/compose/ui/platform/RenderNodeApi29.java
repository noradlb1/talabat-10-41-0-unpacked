package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import e0.z0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(29)
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020]2\u0006\u0010_\u001a\u00020`H\u0016J\b\u0010a\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020]2\u0006\u0010d\u001a\u00020eH\u0016J\u0010\u0010f\u001a\u00020]2\u0006\u0010d\u001a\u00020eH\u0016J\u0010\u0010g\u001a\u00020]2\u0006\u0010h\u001a\u00020\fH\u0016J\u0010\u0010i\u001a\u00020]2\u0006\u0010h\u001a\u00020\fH\u0016J.\u0010j\u001a\u00020]2\u0006\u0010k\u001a\u00020l2\b\u0010m\u001a\u0004\u0018\u00010n2\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020]0pH\u0016J\u0010\u0010r\u001a\u00020\u00172\u0006\u0010s\u001a\u00020\u0017H\u0016J\u0012\u0010t\u001a\u00020]2\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J(\u0010w\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\f2\u0006\u0010N\u001a\u00020\f2\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR$\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00178V@VX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00178V@VX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000bR\u0014\u0010#\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001aR\u0014\u0010%\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u000fR\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R$\u0010-\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000bR$\u00100\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000bR(\u00103\u001a\u0004\u0018\u00010(2\b\u0010\u0005\u001a\u0004\u0018\u00010(8V@VX\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u000fR$\u0010<\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b=\u0010\t\"\u0004\b>\u0010\u000bR$\u0010?\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b@\u0010\t\"\u0004\bA\u0010\u000bR$\u0010B\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bC\u0010\t\"\u0004\bD\u0010\u000bR$\u0010E\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bF\u0010\t\"\u0004\bG\u0010\u000bR$\u0010H\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bI\u0010\t\"\u0004\bJ\u0010\u000bR$\u0010K\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u000e¢\u0006\f\u001a\u0004\bL\u0010\u000f\"\u0004\bM\u0010\u0011R\u0014\u0010N\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u000fR$\u0010P\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bQ\u0010\t\"\u0004\bR\u0010\u000bR$\u0010S\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bT\u0010\t\"\u0004\bU\u0010\u000bR\u0014\u0010V\u001a\u00020W8VX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u000f¨\u0006x"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi29;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "", "ambientShadowColor", "getAmbientShadowColor", "()I", "setAmbientShadowColor", "(I)V", "bottom", "getBottom", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clipToBounds", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "clipToOutline", "getClipToOutline", "setClipToOutline", "elevation", "getElevation", "setElevation", "hasDisplayList", "getHasDisplayList", "height", "getHeight", "internalRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "left", "getLeft", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderNode", "Landroid/graphics/RenderNode;", "right", "getRight", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "spotShadowColor", "getSpotShadowColor", "setSpotShadowColor", "top", "getTop", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "uniqueId", "", "getUniqueId", "()J", "width", "getWidth", "discardDisplayList", "", "drawInto", "canvas", "Landroid/graphics/Canvas;", "dumpRenderNodeData", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "getInverseMatrix", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "offsetLeftAndRight", "offset", "offsetTopAndBottom", "record", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "setHasOverlappingRendering", "hasOverlappingRendering", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RenderNodeApi29 implements DeviceRenderNode {
    @Nullable
    private RenderEffect internalRenderEffect;
    @NotNull
    private final AndroidComposeView ownerView;
    @NotNull
    private final RenderNode renderNode = new RenderNode("Compose");

    public RenderNodeApi29(@NotNull AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "ownerView");
        this.ownerView = androidComposeView;
    }

    public void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }

    public void drawInto(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawRenderNode(this.renderNode);
    }

    @NotNull
    public DeviceRenderNodeData dumpRenderNodeData() {
        return new DeviceRenderNodeData(this.renderNode.getUniqueId(), this.renderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getRight(), this.renderNode.getBottom(), this.renderNode.getWidth(), this.renderNode.getHeight(), this.renderNode.getScaleX(), this.renderNode.getScaleY(), this.renderNode.getTranslationX(), this.renderNode.getTranslationY(), this.renderNode.getElevation(), this.renderNode.getAmbientShadowColor(), this.renderNode.getSpotShadowColor(), this.renderNode.getRotationZ(), this.renderNode.getRotationX(), this.renderNode.getRotationY(), this.renderNode.getCameraDistance(), this.renderNode.getPivotX(), this.renderNode.getPivotY(), this.renderNode.getClipToOutline(), this.renderNode.getClipToBounds(), this.renderNode.getAlpha(), this.internalRenderEffect);
    }

    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    public int getAmbientShadowColor() {
        return this.renderNode.getAmbientShadowColor();
    }

    public int getBottom() {
        return this.renderNode.getBottom();
    }

    public float getCameraDistance() {
        return this.renderNode.getCameraDistance();
    }

    public boolean getClipToBounds() {
        return this.renderNode.getClipToBounds();
    }

    public boolean getClipToOutline() {
        return this.renderNode.getClipToOutline();
    }

    public float getElevation() {
        return this.renderNode.getElevation();
    }

    public boolean getHasDisplayList() {
        return this.renderNode.hasDisplayList();
    }

    public int getHeight() {
        return this.renderNode.getHeight();
    }

    public void getInverseMatrix(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        this.renderNode.getInverseMatrix(matrix);
    }

    public int getLeft() {
        return this.renderNode.getLeft();
    }

    public void getMatrix(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        this.renderNode.getMatrix(matrix);
    }

    @NotNull
    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public float getPivotX() {
        return this.renderNode.getPivotX();
    }

    public float getPivotY() {
        return this.renderNode.getPivotY();
    }

    @Nullable
    public RenderEffect getRenderEffect() {
        return this.internalRenderEffect;
    }

    public int getRight() {
        return this.renderNode.getRight();
    }

    public float getRotationX() {
        return this.renderNode.getRotationX();
    }

    public float getRotationY() {
        return this.renderNode.getRotationY();
    }

    public float getRotationZ() {
        return this.renderNode.getRotationZ();
    }

    public float getScaleX() {
        return this.renderNode.getScaleX();
    }

    public float getScaleY() {
        return this.renderNode.getScaleY();
    }

    public int getSpotShadowColor() {
        return this.renderNode.getSpotShadowColor();
    }

    public int getTop() {
        return this.renderNode.getTop();
    }

    public float getTranslationX() {
        return this.renderNode.getTranslationX();
    }

    public float getTranslationY() {
        return this.renderNode.getTranslationY();
    }

    public long getUniqueId() {
        return this.renderNode.getUniqueId();
    }

    public int getWidth() {
        return this.renderNode.getWidth();
    }

    public void offsetLeftAndRight(int i11) {
        boolean unused = this.renderNode.offsetLeftAndRight(i11);
    }

    public void offsetTopAndBottom(int i11) {
        boolean unused = this.renderNode.offsetTopAndBottom(i11);
    }

    public void record(@NotNull CanvasHolder canvasHolder, @Nullable Path path, @NotNull Function1<? super androidx.compose.ui.graphics.Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(canvasHolder, "canvasHolder");
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        RecordingCanvas a11 = this.renderNode.beginRecording();
        Intrinsics.checkNotNullExpressionValue(a11, "renderNode.beginRecording()");
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(a11);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (path != null) {
            androidCanvas.save();
            z0.m(androidCanvas, path, 0, 2, (Object) null);
        }
        function1.invoke(androidCanvas);
        if (path != null) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        this.renderNode.endRecording();
    }

    public void setAlpha(float f11) {
        boolean unused = this.renderNode.setAlpha(f11);
    }

    public void setAmbientShadowColor(int i11) {
        boolean unused = this.renderNode.setAmbientShadowColor(i11);
    }

    public void setCameraDistance(float f11) {
        boolean unused = this.renderNode.setCameraDistance(f11);
    }

    public void setClipToBounds(boolean z11) {
        boolean unused = this.renderNode.setClipToBounds(z11);
    }

    public void setClipToOutline(boolean z11) {
        boolean unused = this.renderNode.setClipToOutline(z11);
    }

    public void setElevation(float f11) {
        boolean unused = this.renderNode.setElevation(f11);
    }

    public boolean setHasOverlappingRendering(boolean z11) {
        return this.renderNode.setHasOverlappingRendering(z11);
    }

    public void setOutline(@Nullable Outline outline) {
        boolean unused = this.renderNode.setOutline(outline);
    }

    public void setPivotX(float f11) {
        boolean unused = this.renderNode.setPivotX(f11);
    }

    public void setPivotY(float f11) {
        boolean unused = this.renderNode.setPivotY(f11);
    }

    public boolean setPosition(int i11, int i12, int i13, int i14) {
        return this.renderNode.setPosition(i11, i12, i13, i14);
    }

    public void setRenderEffect(@Nullable RenderEffect renderEffect) {
        this.internalRenderEffect = renderEffect;
        if (Build.VERSION.SDK_INT >= 31) {
            RenderNodeApi29VerificationHelper.INSTANCE.setRenderEffect(this.renderNode, renderEffect);
        }
    }

    public void setRotationX(float f11) {
        boolean unused = this.renderNode.setRotationX(f11);
    }

    public void setRotationY(float f11) {
        boolean unused = this.renderNode.setRotationY(f11);
    }

    public void setRotationZ(float f11) {
        boolean unused = this.renderNode.setRotationZ(f11);
    }

    public void setScaleX(float f11) {
        boolean unused = this.renderNode.setScaleX(f11);
    }

    public void setScaleY(float f11) {
        boolean unused = this.renderNode.setScaleY(f11);
    }

    public void setSpotShadowColor(int i11) {
        boolean unused = this.renderNode.setSpotShadowColor(i11);
    }

    public void setTranslationX(float f11) {
        boolean unused = this.renderNode.setTranslationX(f11);
    }

    public void setTranslationY(float f11) {
        boolean unused = this.renderNode.setTranslationY(f11);
    }
}
