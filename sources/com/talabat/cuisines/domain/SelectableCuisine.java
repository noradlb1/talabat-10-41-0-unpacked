package com.talabat.cuisines.domain;

import datamodels.Cuisine;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\n\"\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/talabat/cuisines/domain/SelectableCuisine;", "Ljava/io/Serializable;", "cuisine", "Ldatamodels/Cuisine;", "isOn", "", "isPopular", "(Ldatamodels/Cuisine;ZZ)V", "getCuisine", "()Ldatamodels/Cuisine;", "()Z", "setOn", "(Z)V", "setPopular", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SelectableCuisine implements Serializable {
    @NotNull
    private final Cuisine cuisine;
    private boolean isOn;
    private boolean isPopular;

    public SelectableCuisine(@NotNull Cuisine cuisine2, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(cuisine2, "cuisine");
        this.cuisine = cuisine2;
        this.isOn = z11;
        this.isPopular = z12;
    }

    public static /* synthetic */ SelectableCuisine copy$default(SelectableCuisine selectableCuisine, Cuisine cuisine2, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cuisine2 = selectableCuisine.cuisine;
        }
        if ((i11 & 2) != 0) {
            z11 = selectableCuisine.isOn;
        }
        if ((i11 & 4) != 0) {
            z12 = selectableCuisine.isPopular;
        }
        return selectableCuisine.copy(cuisine2, z11, z12);
    }

    @NotNull
    public final Cuisine component1() {
        return this.cuisine;
    }

    public final boolean component2() {
        return this.isOn;
    }

    public final boolean component3() {
        return this.isPopular;
    }

    @NotNull
    public final SelectableCuisine copy(@NotNull Cuisine cuisine2, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(cuisine2, "cuisine");
        return new SelectableCuisine(cuisine2, z11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectableCuisine)) {
            return false;
        }
        SelectableCuisine selectableCuisine = (SelectableCuisine) obj;
        return Intrinsics.areEqual((Object) this.cuisine, (Object) selectableCuisine.cuisine) && this.isOn == selectableCuisine.isOn && this.isPopular == selectableCuisine.isPopular;
    }

    @NotNull
    public final Cuisine getCuisine() {
        return this.cuisine;
    }

    public int hashCode() {
        int hashCode = this.cuisine.hashCode() * 31;
        boolean z11 = this.isOn;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isPopular;
        if (!z13) {
            z12 = z13;
        }
        return i11 + (z12 ? 1 : 0);
    }

    public final boolean isOn() {
        return this.isOn;
    }

    public final boolean isPopular() {
        return this.isPopular;
    }

    public final void setOn(boolean z11) {
        this.isOn = z11;
    }

    public final void setPopular(boolean z11) {
        this.isPopular = z11;
    }

    @NotNull
    public String toString() {
        Cuisine cuisine2 = this.cuisine;
        boolean z11 = this.isOn;
        boolean z12 = this.isPopular;
        return "SelectableCuisine(cuisine=" + cuisine2 + ", isOn=" + z11 + ", isPopular=" + z12 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectableCuisine(Cuisine cuisine2, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(cuisine2, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? false : z12);
    }
}
