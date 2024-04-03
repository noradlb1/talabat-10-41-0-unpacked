package com.designsystem.ds_theme;

import androidx.compose.runtime.Immutable;
import com.designsystem.ds_box_shadow.Shadow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J9\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/designsystem/ds_theme/DSElevation;", "", "dsElevationSmall", "", "Lcom/designsystem/ds_box_shadow/Shadow;", "dsElevationMedium", "dsElevationLarge", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDsElevationLarge", "()Ljava/util/List;", "getDsElevationMedium", "getDsElevationSmall", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSElevation {
    @NotNull
    private final List<Shadow> dsElevationLarge;
    @NotNull
    private final List<Shadow> dsElevationMedium;
    @NotNull
    private final List<Shadow> dsElevationSmall;

    public DSElevation(@NotNull List<Shadow> list, @NotNull List<Shadow> list2, @NotNull List<Shadow> list3) {
        Intrinsics.checkNotNullParameter(list, "dsElevationSmall");
        Intrinsics.checkNotNullParameter(list2, "dsElevationMedium");
        Intrinsics.checkNotNullParameter(list3, "dsElevationLarge");
        this.dsElevationSmall = list;
        this.dsElevationMedium = list2;
        this.dsElevationLarge = list3;
    }

    public static /* synthetic */ DSElevation copy$default(DSElevation dSElevation, List<Shadow> list, List<Shadow> list2, List<Shadow> list3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = dSElevation.dsElevationSmall;
        }
        if ((i11 & 2) != 0) {
            list2 = dSElevation.dsElevationMedium;
        }
        if ((i11 & 4) != 0) {
            list3 = dSElevation.dsElevationLarge;
        }
        return dSElevation.copy(list, list2, list3);
    }

    @NotNull
    public final List<Shadow> component1() {
        return this.dsElevationSmall;
    }

    @NotNull
    public final List<Shadow> component2() {
        return this.dsElevationMedium;
    }

    @NotNull
    public final List<Shadow> component3() {
        return this.dsElevationLarge;
    }

    @NotNull
    public final DSElevation copy(@NotNull List<Shadow> list, @NotNull List<Shadow> list2, @NotNull List<Shadow> list3) {
        Intrinsics.checkNotNullParameter(list, "dsElevationSmall");
        Intrinsics.checkNotNullParameter(list2, "dsElevationMedium");
        Intrinsics.checkNotNullParameter(list3, "dsElevationLarge");
        return new DSElevation(list, list2, list3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSElevation)) {
            return false;
        }
        DSElevation dSElevation = (DSElevation) obj;
        return Intrinsics.areEqual((Object) this.dsElevationSmall, (Object) dSElevation.dsElevationSmall) && Intrinsics.areEqual((Object) this.dsElevationMedium, (Object) dSElevation.dsElevationMedium) && Intrinsics.areEqual((Object) this.dsElevationLarge, (Object) dSElevation.dsElevationLarge);
    }

    @NotNull
    public final List<Shadow> getDsElevationLarge() {
        return this.dsElevationLarge;
    }

    @NotNull
    public final List<Shadow> getDsElevationMedium() {
        return this.dsElevationMedium;
    }

    @NotNull
    public final List<Shadow> getDsElevationSmall() {
        return this.dsElevationSmall;
    }

    public int hashCode() {
        return (((this.dsElevationSmall.hashCode() * 31) + this.dsElevationMedium.hashCode()) * 31) + this.dsElevationLarge.hashCode();
    }

    @NotNull
    public String toString() {
        return "DSElevation(dsElevationSmall=" + this.dsElevationSmall + ", dsElevationMedium=" + this.dsElevationMedium + ", dsElevationLarge=" + this.dsElevationLarge + ')';
    }
}
