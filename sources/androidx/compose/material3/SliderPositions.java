package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Stable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R+\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038F@@X\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00058F@@X\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/SliderPositions;", "", "initialPositionFraction", "", "initialTickFractions", "", "(F[F)V", "<set-?>", "positionFraction", "getPositionFraction", "()F", "setPositionFraction$material3_release", "(F)V", "positionFraction$delegate", "Landroidx/compose/runtime/MutableState;", "tickFractions", "getTickFractions", "()[F", "setTickFractions$material3_release", "([F)V", "tickFractions$delegate", "equals", "", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
@Stable
public final class SliderPositions {
    @NotNull
    private final MutableState positionFraction$delegate;
    @NotNull
    private final MutableState tickFractions$delegate;

    public SliderPositions(float f11, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "initialTickFractions");
        this.positionFraction$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f11), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.tickFractions$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fArr, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SliderPositions)) {
            return false;
        }
        SliderPositions sliderPositions = (SliderPositions) obj;
        if (getPositionFraction() == sliderPositions.getPositionFraction()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && Arrays.equals(getTickFractions(), sliderPositions.getTickFractions())) {
            return true;
        }
        return false;
    }

    public final float getPositionFraction() {
        return ((Number) this.positionFraction$delegate.getValue()).floatValue();
    }

    @NotNull
    public final float[] getTickFractions() {
        return (float[]) this.tickFractions$delegate.getValue();
    }

    public int hashCode() {
        return (Float.floatToIntBits(getPositionFraction()) * 31) + Arrays.hashCode(getTickFractions());
    }

    public final void setPositionFraction$material3_release(float f11) {
        this.positionFraction$delegate.setValue(Float.valueOf(f11));
    }

    public final void setTickFractions$material3_release(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.tickFractions$delegate.setValue(fArr);
    }
}
