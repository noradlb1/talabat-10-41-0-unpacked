package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import e0.c1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u0.a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R-\u0010\b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R \u0010\u0011\u001a\u00020\u00128fX¦\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007R\u0018\u0010#\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007R\u0018\u0010&\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007R\u0018\u0010)\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R\u0018\u0010,\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0005\"\u0004\b.\u0010\u0007R\u0018\u0010/\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0005\"\u0004\b1\u0010\u0007R\u0018\u00102\u001a\u000203X¦\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R-\u00108\u001a\u00020\t2\u0006\u00108\u001a\u00020\t8V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010\rR!\u0010;\u001a\u00020<X¦\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b=\u0010\u000b\"\u0004\b>\u0010\rR\u0018\u0010?\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b@\u0010\u0005\"\u0004\bA\u0010\u0007R\u0018\u0010B\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bC\u0010\u0005\"\u0004\bD\u0010\u0007ø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006EÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Landroidx/compose/ui/unit/Density;", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "<anonymous parameter 0>", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface GraphicsLayerScope extends Density {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: getAmbientShadowColor-0d7_KjU  reason: not valid java name */
        public static long m3065getAmbientShadowColor0d7_KjU(@NotNull GraphicsLayerScope graphicsLayerScope) {
            return c1.a(graphicsLayerScope);
        }

        public static /* synthetic */ void getClip$annotations() {
        }

        @Nullable
        @Deprecated
        public static RenderEffect getRenderEffect(@NotNull GraphicsLayerScope graphicsLayerScope) {
            return c1.b(graphicsLayerScope);
        }

        @Deprecated
        /* renamed from: getSpotShadowColor-0d7_KjU  reason: not valid java name */
        public static long m3066getSpotShadowColor0d7_KjU(@NotNull GraphicsLayerScope graphicsLayerScope) {
            return c1.c(graphicsLayerScope);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m3067roundToPxR2X_6o(@NotNull GraphicsLayerScope graphicsLayerScope, long j11) {
            return a.a(graphicsLayerScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m3068roundToPx0680j_4(@NotNull GraphicsLayerScope graphicsLayerScope, float f11) {
            return a.b(graphicsLayerScope, f11);
        }

        @Deprecated
        /* renamed from: setAmbientShadowColor-8_81llA  reason: not valid java name */
        public static void m3069setAmbientShadowColor8_81llA(@NotNull GraphicsLayerScope graphicsLayerScope, long j11) {
            c1.d(graphicsLayerScope, j11);
        }

        @Deprecated
        public static void setRenderEffect(@NotNull GraphicsLayerScope graphicsLayerScope, @Nullable RenderEffect renderEffect) {
            c1.e(graphicsLayerScope, renderEffect);
        }

        @Deprecated
        /* renamed from: setSpotShadowColor-8_81llA  reason: not valid java name */
        public static void m3070setSpotShadowColor8_81llA(@NotNull GraphicsLayerScope graphicsLayerScope, long j11) {
            c1.f(graphicsLayerScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m3071toDpGaN1DYA(@NotNull GraphicsLayerScope graphicsLayerScope, long j11) {
            return a.c(graphicsLayerScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m3072toDpu2uoSUM(@NotNull GraphicsLayerScope graphicsLayerScope, float f11) {
            return a.d(graphicsLayerScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m3074toDpSizekrfVVM(@NotNull GraphicsLayerScope graphicsLayerScope, long j11) {
            return a.f(graphicsLayerScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m3075toPxR2X_6o(@NotNull GraphicsLayerScope graphicsLayerScope, long j11) {
            return a.g(graphicsLayerScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m3076toPx0680j_4(@NotNull GraphicsLayerScope graphicsLayerScope, float f11) {
            return a.h(graphicsLayerScope, f11);
        }

        @NotNull
        @Stable
        @Deprecated
        public static Rect toRect(@NotNull GraphicsLayerScope graphicsLayerScope, @NotNull DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "$receiver");
            return a.i(graphicsLayerScope, dpRect);
        }

        @Stable
        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m3077toSizeXkaWNTQ(@NotNull GraphicsLayerScope graphicsLayerScope, long j11) {
            return a.j(graphicsLayerScope, j11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m3078toSp0xMU5do(@NotNull GraphicsLayerScope graphicsLayerScope, float f11) {
            return a.k(graphicsLayerScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m3079toSpkPz2Gy4(@NotNull GraphicsLayerScope graphicsLayerScope, float f11) {
            return a.l(graphicsLayerScope, f11);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m3073toDpu2uoSUM(@NotNull GraphicsLayerScope graphicsLayerScope, int i11) {
            return a.e(graphicsLayerScope, i11);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m3080toSpkPz2Gy4(@NotNull GraphicsLayerScope graphicsLayerScope, int i11) {
            return a.m(graphicsLayerScope, i11);
        }
    }

    float getAlpha();

    /* renamed from: getAmbientShadowColor-0d7_KjU  reason: not valid java name */
    long m3059getAmbientShadowColor0d7_KjU();

    float getCameraDistance();

    boolean getClip();

    @Nullable
    RenderEffect getRenderEffect();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    @NotNull
    Shape getShape();

    /* renamed from: getSpotShadowColor-0d7_KjU  reason: not valid java name */
    long m3060getSpotShadowColor0d7_KjU();

    /* renamed from: getTransformOrigin-SzJe1aQ  reason: not valid java name */
    long m3061getTransformOriginSzJe1aQ();

    float getTranslationX();

    float getTranslationY();

    void setAlpha(float f11);

    /* renamed from: setAmbientShadowColor-8_81llA  reason: not valid java name */
    void m3062setAmbientShadowColor8_81llA(long j11);

    void setCameraDistance(float f11);

    void setClip(boolean z11);

    void setRenderEffect(@Nullable RenderEffect renderEffect);

    void setRotationX(float f11);

    void setRotationY(float f11);

    void setRotationZ(float f11);

    void setScaleX(float f11);

    void setScaleY(float f11);

    void setShadowElevation(float f11);

    void setShape(@NotNull Shape shape);

    /* renamed from: setSpotShadowColor-8_81llA  reason: not valid java name */
    void m3063setSpotShadowColor8_81llA(long j11);

    /* renamed from: setTransformOrigin-__ExYCQ  reason: not valid java name */
    void m3064setTransformOrigin__ExYCQ(long j11);

    void setTranslationX(float f11);

    void setTranslationY(float f11);
}
