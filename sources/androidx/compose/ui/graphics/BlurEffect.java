package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B0\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0015J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u001d\u0010\u0013\u001a\u00020\u00128\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/graphics/BlurEffect;", "Landroidx/compose/ui/graphics/RenderEffect;", "Landroid/graphics/RenderEffect;", "a", "", "other", "", "equals", "", "hashCode", "", "toString", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "", "radiusX", "F", "radiusY", "Landroidx/compose/ui/graphics/TileMode;", "edgeTreatment", "I", "<init>", "(Landroidx/compose/ui/graphics/RenderEffect;FFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "ui-graphics_release"}, k = 1, mv = {1, 7, 1})
public final class BlurEffect extends RenderEffect {
    private final int edgeTreatment;
    private final float radiusX;
    private final float radiusY;
    @Nullable
    private final RenderEffect renderEffect;

    private BlurEffect(RenderEffect renderEffect2, float f11, float f12, int i11) {
        super((DefaultConstructorMarker) null);
        this.renderEffect = renderEffect2;
        this.radiusX = f11;
        this.radiusY = f12;
        this.edgeTreatment = i11;
    }

    public /* synthetic */ BlurEffect(RenderEffect renderEffect2, float f11, float f12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(renderEffect2, f11, f12, i11);
    }

    @RequiresApi(31)
    @NotNull
    public RenderEffect a() {
        return RenderEffectVerificationHelper.INSTANCE.m3196createBlurEffect8A3gB4(this.renderEffect, this.radiusX, this.radiusY, this.edgeTreatment);
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        boolean z12;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlurEffect)) {
            return false;
        }
        BlurEffect blurEffect = (BlurEffect) obj;
        if (this.radiusX == blurEffect.radiusX) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        if (this.radiusY == blurEffect.radiusY) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12 && TileMode.m3270equalsimpl0(this.edgeTreatment, blurEffect.edgeTreatment) && Intrinsics.areEqual((Object) this.renderEffect, (Object) blurEffect.renderEffect)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        RenderEffect renderEffect2 = this.renderEffect;
        if (renderEffect2 != null) {
            i11 = renderEffect2.hashCode();
        } else {
            i11 = 0;
        }
        return (((((i11 * 31) + Float.floatToIntBits(this.radiusX)) * 31) + Float.floatToIntBits(this.radiusY)) * 31) + TileMode.m3271hashCodeimpl(this.edgeTreatment);
    }

    @NotNull
    public String toString() {
        return "BlurEffect(renderEffect=" + this.renderEffect + ", radiusX=" + this.radiusX + ", radiusY=" + this.radiusY + ", edgeTreatment=" + TileMode.m3272toStringimpl(this.edgeTreatment) + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlurEffect(RenderEffect renderEffect2, float f11, float f12, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(renderEffect2, f11, (i12 & 4) != 0 ? f11 : f12, (i12 & 8) != 0 ? TileMode.Companion.m3274getClamp3opZhB0() : i11, (DefaultConstructorMarker) null);
    }
}
