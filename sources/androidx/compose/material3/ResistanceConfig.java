package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/ResistanceConfig;", "", "basis", "", "factorAtMin", "factorAtMax", "(FFF)V", "getBasis", "()F", "getFactorAtMax", "getFactorAtMin", "computeResistance", "overflow", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ResistanceConfig {
    private final float basis;
    private final float factorAtMax;
    private final float factorAtMin;

    public ResistanceConfig(float f11, float f12, float f13) {
        this.basis = f11;
        this.factorAtMin = f12;
        this.factorAtMax = f13;
    }

    public final float computeResistance(float f11) {
        float f12;
        boolean z11;
        if (f11 < 0.0f) {
            f12 = this.factorAtMin;
        } else {
            f12 = this.factorAtMax;
        }
        if (f12 == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return 0.0f;
        }
        return (this.basis / f12) * ((float) Math.sin((double) ((RangesKt___RangesKt.coerceIn(f11 / this.basis, -1.0f, 1.0f) * 3.1415927f) / ((float) 2))));
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResistanceConfig)) {
            return false;
        }
        ResistanceConfig resistanceConfig = (ResistanceConfig) obj;
        if (this.basis == resistanceConfig.basis) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        if (this.factorAtMin == resistanceConfig.factorAtMin) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            return false;
        }
        if (this.factorAtMax == resistanceConfig.factorAtMax) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (!z13) {
            return false;
        }
        return true;
    }

    public final float getBasis() {
        return this.basis;
    }

    public final float getFactorAtMax() {
        return this.factorAtMax;
    }

    public final float getFactorAtMin() {
        return this.factorAtMin;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.basis) * 31) + Float.floatToIntBits(this.factorAtMin)) * 31) + Float.floatToIntBits(this.factorAtMax);
    }

    @NotNull
    public String toString() {
        return "ResistanceConfig(basis=" + this.basis + ", factorAtMin=" + this.factorAtMin + ", factorAtMax=" + this.factorAtMax + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResistanceConfig(float f11, float f12, float f13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, (i11 & 2) != 0 ? 10.0f : f12, (i11 & 4) != 0 ? 10.0f : f13);
    }
}
