package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u0.a;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010N\u001a\u00020OR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR%\u0010\t\u001a\u00020\nX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001a\u0010,\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001a\u0010/\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001a\u00102\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001a\u00105\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR\u001a\u00108\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\u001a\u0010;\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R%\u0010A\u001a\u00020\nX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\bB\u0010\f\"\u0004\bC\u0010\u000eR%\u0010D\u001a\u00020EX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\bF\u0010\f\"\u0004\bG\u0010\u000eR\u001a\u0010H\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR\u001a\u0010K\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006P"}, d2 = {"Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "", "getClip", "()Z", "setClip", "(Z)V", "density", "getDensity", "fontScale", "getFontScale", "graphicsDensity", "Landroidx/compose/ui/unit/Density;", "getGraphicsDensity$ui_release", "()Landroidx/compose/ui/unit/Density;", "setGraphicsDensity$ui_release", "(Landroidx/compose/ui/unit/Density;)V", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "reset", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ReusableGraphicsLayerScope implements GraphicsLayerScope {
    private float alpha = 1.0f;
    private long ambientShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
    private float cameraDistance = 8.0f;
    private boolean clip;
    @NotNull
    private Density graphicsDensity = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);
    @Nullable
    private RenderEffect renderEffect;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float shadowElevation;
    @NotNull
    private Shape shape = RectangleShapeKt.getRectangleShape();
    private long spotShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
    private long transformOrigin = TransformOrigin.Companion.m3292getCenterSzJe1aQ();
    private float translationX;
    private float translationY;

    public float getAlpha() {
        return this.alpha;
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU  reason: not valid java name */
    public long m3198getAmbientShadowColor0d7_KjU() {
        return this.ambientShadowColor;
    }

    public float getCameraDistance() {
        return this.cameraDistance;
    }

    public boolean getClip() {
        return this.clip;
    }

    public float getDensity() {
        return this.graphicsDensity.getDensity();
    }

    public float getFontScale() {
        return this.graphicsDensity.getFontScale();
    }

    @NotNull
    public final Density getGraphicsDensity$ui_release() {
        return this.graphicsDensity;
    }

    @Nullable
    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public float getRotationX() {
        return this.rotationX;
    }

    public float getRotationY() {
        return this.rotationY;
    }

    public float getRotationZ() {
        return this.rotationZ;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public float getShadowElevation() {
        return this.shadowElevation;
    }

    @NotNull
    public Shape getShape() {
        return this.shape;
    }

    /* renamed from: getSpotShadowColor-0d7_KjU  reason: not valid java name */
    public long m3199getSpotShadowColor0d7_KjU() {
        return this.spotShadowColor;
    }

    /* renamed from: getTransformOrigin-SzJe1aQ  reason: not valid java name */
    public long m3200getTransformOriginSzJe1aQ() {
        return this.transformOrigin;
    }

    public float getTranslationX() {
        return this.translationX;
    }

    public float getTranslationY() {
        return this.translationY;
    }

    public final void reset() {
        setScaleX(1.0f);
        setScaleY(1.0f);
        setAlpha(1.0f);
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        setShadowElevation(0.0f);
        m3203setAmbientShadowColor8_81llA(GraphicsLayerScopeKt.getDefaultShadowColor());
        m3204setSpotShadowColor8_81llA(GraphicsLayerScopeKt.getDefaultShadowColor());
        setRotationX(0.0f);
        setRotationY(0.0f);
        setRotationZ(0.0f);
        setCameraDistance(8.0f);
        m3205setTransformOrigin__ExYCQ(TransformOrigin.Companion.m3292getCenterSzJe1aQ());
        setShape(RectangleShapeKt.getRectangleShape());
        setClip(false);
        setRenderEffect((RenderEffect) null);
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ int m3201roundToPxR2X_6o(long j11) {
        return a.a(this, j11);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public /* synthetic */ int m3202roundToPx0680j_4(float f11) {
        return a.b(this, f11);
    }

    public void setAlpha(float f11) {
        this.alpha = f11;
    }

    /* renamed from: setAmbientShadowColor-8_81llA  reason: not valid java name */
    public void m3203setAmbientShadowColor8_81llA(long j11) {
        this.ambientShadowColor = j11;
    }

    public void setCameraDistance(float f11) {
        this.cameraDistance = f11;
    }

    public void setClip(boolean z11) {
        this.clip = z11;
    }

    public final void setGraphicsDensity$ui_release(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "<set-?>");
        this.graphicsDensity = density;
    }

    public void setRenderEffect(@Nullable RenderEffect renderEffect2) {
        this.renderEffect = renderEffect2;
    }

    public void setRotationX(float f11) {
        this.rotationX = f11;
    }

    public void setRotationY(float f11) {
        this.rotationY = f11;
    }

    public void setRotationZ(float f11) {
        this.rotationZ = f11;
    }

    public void setScaleX(float f11) {
        this.scaleX = f11;
    }

    public void setScaleY(float f11) {
        this.scaleY = f11;
    }

    public void setShadowElevation(float f11) {
        this.shadowElevation = f11;
    }

    public void setShape(@NotNull Shape shape2) {
        Intrinsics.checkNotNullParameter(shape2, "<set-?>");
        this.shape = shape2;
    }

    /* renamed from: setSpotShadowColor-8_81llA  reason: not valid java name */
    public void m3204setSpotShadowColor8_81llA(long j11) {
        this.spotShadowColor = j11;
    }

    /* renamed from: setTransformOrigin-__ExYCQ  reason: not valid java name */
    public void m3205setTransformOrigin__ExYCQ(long j11) {
        this.transformOrigin = j11;
    }

    public void setTranslationX(float f11) {
        this.translationX = f11;
    }

    public void setTranslationY(float f11) {
        this.translationY = f11;
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public /* synthetic */ float m3206toDpGaN1DYA(long j11) {
        return a.c(this, j11);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m3207toDpu2uoSUM(float f11) {
        return a.d(this, f11);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m3208toDpu2uoSUM(int i11) {
        return a.e(this, i11);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public /* synthetic */ long m3209toDpSizekrfVVM(long j11) {
        return a.f(this, j11);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ float m3210toPxR2X_6o(long j11) {
        return a.g(this, j11);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public /* synthetic */ float m3211toPx0680j_4(float f11) {
        return a.h(this, f11);
    }

    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return a.i(this, dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public /* synthetic */ long m3212toSizeXkaWNTQ(long j11) {
        return a.j(this, j11);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public /* synthetic */ long m3213toSp0xMU5do(float f11) {
        return a.k(this, f11);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m3214toSpkPz2Gy4(float f11) {
        return a.l(this, f11);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m3215toSpkPz2Gy4(int i11) {
        return a.m(this, i11);
    }
}
