package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"BlurEffect", "Landroidx/compose/ui/graphics/BlurEffect;", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "BlurEffect-3YTHUZs", "(FFI)Landroidx/compose/ui/graphics/BlurEffect;", "OffsetEffect", "Landroidx/compose/ui/graphics/OffsetEffect;", "offsetX", "offsetY", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RenderEffectKt {
    @NotNull
    @Stable
    /* renamed from: BlurEffect-3YTHUZs  reason: not valid java name */
    public static final BlurEffect m3194BlurEffect3YTHUZs(float f11, float f12, int i11) {
        return new BlurEffect((RenderEffect) null, f11, f12, i11, (DefaultConstructorMarker) null);
    }

    /* renamed from: BlurEffect-3YTHUZs$default  reason: not valid java name */
    public static /* synthetic */ BlurEffect m3195BlurEffect3YTHUZs$default(float f11, float f12, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = TileMode.Companion.m3274getClamp3opZhB0();
        }
        return m3194BlurEffect3YTHUZs(f11, f12, i11);
    }

    @NotNull
    @Stable
    public static final OffsetEffect OffsetEffect(float f11, float f12) {
        return new OffsetEffect((RenderEffect) null, OffsetKt.Offset(f11, f12), (DefaultConstructorMarker) null);
    }
}
