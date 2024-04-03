package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.core.view.ViewCompat;
import e0.z0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(23)
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 }2\u00020\u0001:\u0001}B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010_\u001a\u00020`H\u0016J\b\u0010a\u001a\u00020`H\u0002J\u0010\u0010b\u001a\u00020`2\u0006\u0010c\u001a\u00020dH\u0016J\b\u0010e\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u00020`2\u0006\u0010h\u001a\u00020iH\u0016J\u0010\u0010j\u001a\u00020`2\u0006\u0010h\u001a\u00020iH\u0016J\u0010\u0010k\u001a\u00020`2\u0006\u0010l\u001a\u00020\fH\u0016J\u0010\u0010m\u001a\u00020`2\u0006\u0010l\u001a\u00020\fH\u0016J.\u0010n\u001a\u00020`2\u0006\u0010o\u001a\u00020p2\b\u0010q\u001a\u0004\u0018\u00010r2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020u\u0012\u0004\u0012\u00020`0tH\u0016J\u0010\u0010v\u001a\u00020\u00182\u0006\u0010w\u001a\u00020\u0018H\u0016J\u0012\u0010x\u001a\u00020`2\b\u0010y\u001a\u0004\u0018\u00010zH\u0016J(\u0010{\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\f2\u0006\u0010P\u001a\u00020\f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010|\u001a\u00020`2\u0006\u00109\u001a\u00020:H\u0002R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188V@VX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u0014\u0010$\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001bR\u0014\u0010&\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u000fR\u001a\u0010(\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R$\u0010-\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000bR$\u00100\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000bR\u001c\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000f\"\u0004\b=\u0010\u0011R$\u0010>\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b?\u0010\t\"\u0004\b@\u0010\u000bR$\u0010A\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bB\u0010\t\"\u0004\bC\u0010\u000bR$\u0010D\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bE\u0010\t\"\u0004\bF\u0010\u000bR$\u0010G\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bH\u0010\t\"\u0004\bI\u0010\u000bR$\u0010J\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bK\u0010\t\"\u0004\bL\u0010\u000bR$\u0010M\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u000e¢\u0006\f\u001a\u0004\bN\u0010\u000f\"\u0004\bO\u0010\u0011R\u001a\u0010P\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u000f\"\u0004\bR\u0010\u0011R$\u0010S\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bT\u0010\t\"\u0004\bU\u0010\u000bR$\u0010V\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bW\u0010\t\"\u0004\bX\u0010\u000bR\u0014\u0010Y\u001a\u00020Z8VX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\u000f¨\u0006~"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi23;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "", "ambientShadowColor", "getAmbientShadowColor", "()I", "setAmbientShadowColor", "(I)V", "bottom", "getBottom", "setBottom", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clipToBounds", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "clipToOutline", "getClipToOutline", "setClipToOutline", "elevation", "getElevation", "setElevation", "hasDisplayList", "getHasDisplayList", "height", "getHeight", "left", "getLeft", "setLeft", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderNode", "Landroid/view/RenderNode;", "right", "getRight", "setRight", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "spotShadowColor", "getSpotShadowColor", "setSpotShadowColor", "top", "getTop", "setTop", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "uniqueId", "", "getUniqueId", "()J", "width", "getWidth", "discardDisplayList", "", "discardDisplayListInternal", "drawInto", "canvas", "Landroid/graphics/Canvas;", "dumpRenderNodeData", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "getInverseMatrix", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "offsetLeftAndRight", "offset", "offsetTopAndBottom", "record", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "setHasOverlappingRendering", "hasOverlappingRendering", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "verifyShadowColorProperties", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RenderNodeApi23 implements DeviceRenderNode {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static boolean needToValidateAccess = true;
    /* access modifiers changed from: private */
    public static boolean testFailCreateRenderNode;
    private int bottom;
    private boolean clipToBounds;
    private int left;
    @NotNull
    private final AndroidComposeView ownerView;
    @Nullable
    private RenderEffect renderEffect;
    @NotNull
    private final RenderNode renderNode;
    private int right;
    private int top;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi23$Companion;", "", "()V", "needToValidateAccess", "", "testFailCreateRenderNode", "getTestFailCreateRenderNode$ui_release", "()Z", "setTestFailCreateRenderNode$ui_release", "(Z)V", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getTestFailCreateRenderNode$ui_release() {
            return RenderNodeApi23.testFailCreateRenderNode;
        }

        public final void setTestFailCreateRenderNode$ui_release(boolean z11) {
            RenderNodeApi23.testFailCreateRenderNode = z11;
        }
    }

    public RenderNodeApi23(@NotNull AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "ownerView");
        this.ownerView = androidComposeView;
        RenderNode create = RenderNode.create("Compose", androidComposeView);
        Intrinsics.checkNotNullExpressionValue(create, "create(\"Compose\", ownerView)");
        this.renderNode = create;
        if (needToValidateAccess) {
            create.setScaleX(create.getScaleX());
            create.setScaleY(create.getScaleY());
            create.setTranslationX(create.getTranslationX());
            create.setTranslationY(create.getTranslationY());
            create.setElevation(create.getElevation());
            create.setRotation(create.getRotation());
            create.setRotationX(create.getRotationX());
            create.setRotationY(create.getRotationY());
            create.setCameraDistance(create.getCameraDistance());
            create.setPivotX(create.getPivotX());
            create.setPivotY(create.getPivotY());
            create.setClipToOutline(create.getClipToOutline());
            create.setClipToBounds(false);
            create.setAlpha(create.getAlpha());
            create.isValid();
            create.setLeftTopRightBottom(0, 0, 0, 0);
            create.offsetLeftAndRight(0);
            create.offsetTopAndBottom(0);
            verifyShadowColorProperties(create);
            discardDisplayListInternal();
            needToValidateAccess = false;
        }
        if (testFailCreateRenderNode) {
            throw new NoClassDefFoundError();
        }
    }

    private final void discardDisplayListInternal() {
        if (Build.VERSION.SDK_INT >= 24) {
            RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
        } else {
            RenderNodeVerificationHelper23.INSTANCE.destroyDisplayListData(this.renderNode);
        }
    }

    private final void verifyShadowColorProperties(RenderNode renderNode2) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28 renderNodeVerificationHelper28 = RenderNodeVerificationHelper28.INSTANCE;
            renderNodeVerificationHelper28.setAmbientShadowColor(renderNode2, renderNodeVerificationHelper28.getAmbientShadowColor(renderNode2));
            renderNodeVerificationHelper28.setSpotShadowColor(renderNode2, renderNodeVerificationHelper28.getSpotShadowColor(renderNode2));
        }
    }

    public void discardDisplayList() {
        discardDisplayListInternal();
    }

    public void drawInto(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        ((DisplayListCanvas) canvas).drawRenderNode(this.renderNode);
    }

    @NotNull
    public DeviceRenderNodeData dumpRenderNodeData() {
        return new DeviceRenderNodeData(0, 0, 0, 0, 0, 0, 0, this.renderNode.getScaleX(), this.renderNode.getScaleY(), this.renderNode.getTranslationX(), this.renderNode.getTranslationY(), this.renderNode.getElevation(), getAmbientShadowColor(), getSpotShadowColor(), this.renderNode.getRotation(), this.renderNode.getRotationX(), this.renderNode.getRotationY(), this.renderNode.getCameraDistance(), this.renderNode.getPivotX(), this.renderNode.getPivotY(), this.renderNode.getClipToOutline(), getClipToBounds(), this.renderNode.getAlpha(), getRenderEffect());
    }

    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    public int getAmbientShadowColor() {
        if (Build.VERSION.SDK_INT >= 28) {
            return RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(this.renderNode);
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }

    public int getBottom() {
        return this.bottom;
    }

    public float getCameraDistance() {
        return -this.renderNode.getCameraDistance();
    }

    public boolean getClipToBounds() {
        return this.clipToBounds;
    }

    public boolean getClipToOutline() {
        return this.renderNode.getClipToOutline();
    }

    public float getElevation() {
        return this.renderNode.getElevation();
    }

    public boolean getHasDisplayList() {
        return this.renderNode.isValid();
    }

    public int getHeight() {
        return getBottom() - getTop();
    }

    public void getInverseMatrix(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        this.renderNode.getInverseMatrix(matrix);
    }

    public int getLeft() {
        return this.left;
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
        return this.renderEffect;
    }

    public int getRight() {
        return this.right;
    }

    public float getRotationX() {
        return this.renderNode.getRotationX();
    }

    public float getRotationY() {
        return this.renderNode.getRotationY();
    }

    public float getRotationZ() {
        return this.renderNode.getRotation();
    }

    public float getScaleX() {
        return this.renderNode.getScaleX();
    }

    public float getScaleY() {
        return this.renderNode.getScaleY();
    }

    public int getSpotShadowColor() {
        if (Build.VERSION.SDK_INT >= 28) {
            return RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(this.renderNode);
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }

    public int getTop() {
        return this.top;
    }

    public float getTranslationX() {
        return this.renderNode.getTranslationX();
    }

    public float getTranslationY() {
        return this.renderNode.getTranslationY();
    }

    public long getUniqueId() {
        return 0;
    }

    public int getWidth() {
        return getRight() - getLeft();
    }

    public void offsetLeftAndRight(int i11) {
        setLeft(getLeft() + i11);
        setRight(getRight() + i11);
        this.renderNode.offsetLeftAndRight(i11);
    }

    public void offsetTopAndBottom(int i11) {
        setTop(getTop() + i11);
        setBottom(getBottom() + i11);
        this.renderNode.offsetTopAndBottom(i11);
    }

    public void record(@NotNull CanvasHolder canvasHolder, @Nullable Path path, @NotNull Function1<? super androidx.compose.ui.graphics.Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(canvasHolder, "canvasHolder");
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Canvas start = this.renderNode.start(getWidth(), getHeight());
        Intrinsics.checkNotNullExpressionValue(start, "renderNode.start(width, height)");
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(start);
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
        this.renderNode.end(start);
    }

    public void setAlpha(float f11) {
        this.renderNode.setAlpha(f11);
    }

    public void setAmbientShadowColor(int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, i11);
        }
    }

    public void setBottom(int i11) {
        this.bottom = i11;
    }

    public void setCameraDistance(float f11) {
        this.renderNode.setCameraDistance(-f11);
    }

    public void setClipToBounds(boolean z11) {
        this.clipToBounds = z11;
        this.renderNode.setClipToBounds(z11);
    }

    public void setClipToOutline(boolean z11) {
        this.renderNode.setClipToOutline(z11);
    }

    public void setElevation(float f11) {
        this.renderNode.setElevation(f11);
    }

    public boolean setHasOverlappingRendering(boolean z11) {
        return this.renderNode.setHasOverlappingRendering(z11);
    }

    public void setLeft(int i11) {
        this.left = i11;
    }

    public void setOutline(@Nullable Outline outline) {
        this.renderNode.setOutline(outline);
    }

    public void setPivotX(float f11) {
        this.renderNode.setPivotX(f11);
    }

    public void setPivotY(float f11) {
        this.renderNode.setPivotY(f11);
    }

    public boolean setPosition(int i11, int i12, int i13, int i14) {
        setLeft(i11);
        setTop(i12);
        setRight(i13);
        setBottom(i14);
        return this.renderNode.setLeftTopRightBottom(i11, i12, i13, i14);
    }

    public void setRenderEffect(@Nullable RenderEffect renderEffect2) {
        this.renderEffect = renderEffect2;
    }

    public void setRight(int i11) {
        this.right = i11;
    }

    public void setRotationX(float f11) {
        this.renderNode.setRotationX(f11);
    }

    public void setRotationY(float f11) {
        this.renderNode.setRotationY(f11);
    }

    public void setRotationZ(float f11) {
        this.renderNode.setRotation(f11);
    }

    public void setScaleX(float f11) {
        this.renderNode.setScaleX(f11);
    }

    public void setScaleY(float f11) {
        this.renderNode.setScaleY(f11);
    }

    public void setSpotShadowColor(int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, i11);
        }
    }

    public void setTop(int i11) {
        this.top = i11;
    }

    public void setTranslationX(float f11) {
        this.renderNode.setTranslationX(f11);
    }

    public void setTranslationY(float f11) {
        this.renderNode.setTranslationY(f11);
    }
}
