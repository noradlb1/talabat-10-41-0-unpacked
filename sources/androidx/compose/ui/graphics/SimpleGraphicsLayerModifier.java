package androidx.compose.ui.graphics;

import a0.b;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.a;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B£\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\b\u001dø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0013\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J)\u0010)\u001a\u00020**\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\u00020\u0017X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010 \u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\b\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\u00020\u0017X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001fR\u0019\u0010\u000e\u001a\u00020\u000fX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00062"}, d2 = {"Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "layerBlock", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "equals", "other", "", "hashCode", "", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class SimpleGraphicsLayerModifier extends InspectorValueInfo implements LayoutModifier {
    /* access modifiers changed from: private */
    public final float alpha;
    /* access modifiers changed from: private */
    public final long ambientShadowColor;
    /* access modifiers changed from: private */
    public final float cameraDistance;
    /* access modifiers changed from: private */
    public final boolean clip;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<GraphicsLayerScope, Unit> layerBlock;
    /* access modifiers changed from: private */
    @Nullable
    public final RenderEffect renderEffect;
    /* access modifiers changed from: private */
    public final float rotationX;
    /* access modifiers changed from: private */
    public final float rotationY;
    /* access modifiers changed from: private */
    public final float rotationZ;
    /* access modifiers changed from: private */
    public final float scaleX;
    /* access modifiers changed from: private */
    public final float scaleY;
    /* access modifiers changed from: private */
    public final float shadowElevation;
    /* access modifiers changed from: private */
    @NotNull
    public final Shape shape;
    /* access modifiers changed from: private */
    public final long spotShadowColor;
    /* access modifiers changed from: private */
    public final long transformOrigin;
    /* access modifiers changed from: private */
    public final float translationX;
    /* access modifiers changed from: private */
    public final float translationY;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private SimpleGraphicsLayerModifier(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, Shape shape2, boolean z11, RenderEffect renderEffect2, long j12, long j13, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.scaleX = f11;
        this.scaleY = f12;
        this.alpha = f13;
        this.translationX = f14;
        this.translationY = f15;
        this.shadowElevation = f16;
        this.rotationX = f17;
        this.rotationY = f18;
        this.rotationZ = f19;
        this.cameraDistance = f21;
        this.transformOrigin = j11;
        this.shape = shape2;
        this.clip = z11;
        this.renderEffect = renderEffect2;
        this.ambientShadowColor = j12;
        this.spotShadowColor = j13;
        this.layerBlock = new SimpleGraphicsLayerModifier$layerBlock$1(this);
    }

    public /* synthetic */ SimpleGraphicsLayerModifier(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, Shape shape2, boolean z11, RenderEffect renderEffect2, long j12, long j13, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, f15, f16, f17, f18, f19, f21, j11, shape2, z11, renderEffect2, j12, j13, function1);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        SimpleGraphicsLayerModifier simpleGraphicsLayerModifier;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z21;
        if (obj instanceof SimpleGraphicsLayerModifier) {
            simpleGraphicsLayerModifier = (SimpleGraphicsLayerModifier) obj;
        } else {
            simpleGraphicsLayerModifier = null;
        }
        if (simpleGraphicsLayerModifier == null) {
            return false;
        }
        if (this.scaleX == simpleGraphicsLayerModifier.scaleX) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        if (this.scaleY == simpleGraphicsLayerModifier.scaleY) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            return false;
        }
        if (this.alpha == simpleGraphicsLayerModifier.alpha) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (!z13) {
            return false;
        }
        if (this.translationX == simpleGraphicsLayerModifier.translationX) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (!z14) {
            return false;
        }
        if (this.translationY == simpleGraphicsLayerModifier.translationY) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (!z15) {
            return false;
        }
        if (this.shadowElevation == simpleGraphicsLayerModifier.shadowElevation) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (this.rotationX == simpleGraphicsLayerModifier.rotationX) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            return false;
        }
        if (this.rotationY == simpleGraphicsLayerModifier.rotationY) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            return false;
        }
        if (this.rotationZ == simpleGraphicsLayerModifier.rotationZ) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (!z19) {
            return false;
        }
        if (this.cameraDistance == simpleGraphicsLayerModifier.cameraDistance) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (!z21 || !TransformOrigin.m3286equalsimpl0(this.transformOrigin, simpleGraphicsLayerModifier.transformOrigin) || !Intrinsics.areEqual((Object) this.shape, (Object) simpleGraphicsLayerModifier.shape) || this.clip != simpleGraphicsLayerModifier.clip || !Intrinsics.areEqual((Object) this.renderEffect, (Object) simpleGraphicsLayerModifier.renderEffect) || !Color.m2920equalsimpl0(this.ambientShadowColor, simpleGraphicsLayerModifier.ambientShadowColor) || !Color.m2920equalsimpl0(this.spotShadowColor, simpleGraphicsLayerModifier.spotShadowColor)) {
            return false;
        }
        return true;
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    public int hashCode() {
        int i11;
        int floatToIntBits = ((((((((((((((((((((((((Float.floatToIntBits(this.scaleX) * 31) + Float.floatToIntBits(this.scaleY)) * 31) + Float.floatToIntBits(this.alpha)) * 31) + Float.floatToIntBits(this.translationX)) * 31) + Float.floatToIntBits(this.translationY)) * 31) + Float.floatToIntBits(this.shadowElevation)) * 31) + Float.floatToIntBits(this.rotationX)) * 31) + Float.floatToIntBits(this.rotationY)) * 31) + Float.floatToIntBits(this.rotationZ)) * 31) + Float.floatToIntBits(this.cameraDistance)) * 31) + TransformOrigin.m3289hashCodeimpl(this.transformOrigin)) * 31) + this.shape.hashCode()) * 31) + e.a(this.clip)) * 31;
        RenderEffect renderEffect2 = this.renderEffect;
        if (renderEffect2 != null) {
            i11 = renderEffect2.hashCode();
        } else {
            i11 = 0;
        }
        return ((((floatToIntBits + i11) * 31) + Color.m2926hashCodeimpl(this.ambientShadowColor)) * 31) + Color.m2926hashCodeimpl(this.spotShadowColor);
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.a(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.b(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m3233measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Placeable r92 = measurable.m4508measureBRTryo0(j11);
        return MeasureScope.CC.p(measureScope, r92.getWidth(), r92.getHeight(), (Map) null, new SimpleGraphicsLayerModifier$measure$1(r92, this), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.c(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.d(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a0.a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "SimpleGraphicsLayerModifier(scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", alpha = " + this.alpha + ", translationX=" + this.translationX + ", translationY=" + this.translationY + ", shadowElevation=" + this.shadowElevation + ", rotationX=" + this.rotationX + ", rotationY=" + this.rotationY + ", rotationZ=" + this.rotationZ + ", cameraDistance=" + this.cameraDistance + ", transformOrigin=" + TransformOrigin.m3290toStringimpl(this.transformOrigin) + ", shape=" + this.shape + ", clip=" + this.clip + ", renderEffect=" + this.renderEffect + ", ambientShadowColor=" + Color.m2927toStringimpl(this.ambientShadowColor) + ", spotShadowColor=" + Color.m2927toStringimpl(this.spotShadowColor) + ')';
    }
}
