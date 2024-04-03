package androidx.compose.foundation.layout;

import android.graphics.Insets;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"androidx/compose/foundation/layout/SideCalculator$Companion$BottomSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator;", "adjustInsets", "Landroid/graphics/Insets;", "oldInsets", "newValue", "", "consumedOffsets", "Landroidx/compose/ui/geometry/Offset;", "available", "consumedOffsets-MK-Hz9U", "(J)J", "consumedVelocity", "Landroidx/compose/ui/unit/Velocity;", "remaining", "", "consumedVelocity-QWom1Mo", "(JF)J", "motionOf", "x", "y", "valueOf", "insets", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SideCalculator$Companion$BottomSideCalculator$1 implements SideCalculator {
    @NotNull
    public Insets adjustInsets(@NotNull Insets insets, int i11) {
        Intrinsics.checkNotNullParameter(insets, "oldInsets");
        Insets a11 = Insets.of(insets.left, insets.top, insets.right, i11);
        Intrinsics.checkNotNullExpressionValue(a11, "of(oldInsets.left, oldIn…ldInsets.right, newValue)");
        return a11;
    }

    /* renamed from: consumedOffsets-MK-Hz9U  reason: not valid java name */
    public long m534consumedOffsetsMKHz9U(long j11) {
        return OffsetKt.Offset(0.0f, Offset.m2677getYimpl(j11));
    }

    /* renamed from: consumedVelocity-QWom1Mo  reason: not valid java name */
    public long m535consumedVelocityQWom1Mo(long j11, float f11) {
        return VelocityKt.Velocity(0.0f, Velocity.m5704getYimpl(j11) + f11);
    }

    public /* synthetic */ float hideMotion(float f11, float f12) {
        return a.a(this, f11, f12);
    }

    public float motionOf(float f11, float f12) {
        return -f12;
    }

    public /* synthetic */ float showMotion(float f11, float f12) {
        return a.b(this, f11, f12);
    }

    public int valueOf(@NotNull Insets insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        return insets.bottom;
    }
}
