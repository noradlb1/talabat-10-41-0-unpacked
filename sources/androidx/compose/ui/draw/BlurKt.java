package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radius", "Landroidx/compose/ui/unit/Dp;", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radiusX", "radiusY", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BlurKt {
    @NotNull
    @Stable
    /* renamed from: blur-1fqS-gw  reason: not valid java name */
    public static final Modifier m2559blur1fqSgw(@NotNull Modifier modifier, float f11, float f12, @NotNull Shape shape) {
        boolean z11;
        int i11;
        Intrinsics.checkNotNullParameter(modifier, "$this$blur");
        if (shape != null) {
            i11 = TileMode.Companion.m3274getClamp3opZhB0();
            z11 = true;
        } else {
            z11 = false;
            i11 = TileMode.Companion.m3275getDecal3opZhB0();
        }
        float f13 = (float) 0;
        if ((Dp.m5477compareTo0680j_4(f11, Dp.m5478constructorimpl(f13)) <= 0 || Dp.m5477compareTo0680j_4(f12, Dp.m5478constructorimpl(f13)) <= 0) && !z11) {
            return modifier;
        }
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new BlurKt$blur$1(f11, f12, i11, shape, z11));
    }

    /* renamed from: blur-1fqS-gw$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2560blur1fqSgw$default(Modifier modifier, float f11, float f12, BlurredEdgeTreatment blurredEdgeTreatment, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m2563boximpl(BlurredEdgeTreatment.Companion.m2570getRectangleGoahg());
        }
        return m2559blur1fqSgw(modifier, f11, f12, blurredEdgeTreatment.m2569unboximpl());
    }

    @NotNull
    @Stable
    /* renamed from: blur-F8QBwvs  reason: not valid java name */
    public static final Modifier m2561blurF8QBwvs(@NotNull Modifier modifier, float f11, @NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "$this$blur");
        return m2559blur1fqSgw(modifier, f11, f11, shape);
    }

    /* renamed from: blur-F8QBwvs$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2562blurF8QBwvs$default(Modifier modifier, float f11, BlurredEdgeTreatment blurredEdgeTreatment, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m2563boximpl(BlurredEdgeTreatment.Companion.m2570getRectangleGoahg());
        }
        return m2561blurF8QBwvs(modifier, f11, blurredEdgeTreatment.m2569unboximpl());
    }
}
