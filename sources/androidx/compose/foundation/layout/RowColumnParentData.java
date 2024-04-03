package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnParentData;", "", "weight", "", "fill", "", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "(FZLandroidx/compose/foundation/layout/CrossAxisAlignment;)V", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "setCrossAxisAlignment", "(Landroidx/compose/foundation/layout/CrossAxisAlignment;)V", "getFill", "()Z", "setFill", "(Z)V", "getWeight", "()F", "setWeight", "(F)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RowColumnParentData {
    @Nullable
    private CrossAxisAlignment crossAxisAlignment;
    private boolean fill;
    private float weight;

    public RowColumnParentData() {
        this(0.0f, false, (CrossAxisAlignment) null, 7, (DefaultConstructorMarker) null);
    }

    public RowColumnParentData(float f11, boolean z11, @Nullable CrossAxisAlignment crossAxisAlignment2) {
        this.weight = f11;
        this.fill = z11;
        this.crossAxisAlignment = crossAxisAlignment2;
    }

    public static /* synthetic */ RowColumnParentData copy$default(RowColumnParentData rowColumnParentData, float f11, boolean z11, CrossAxisAlignment crossAxisAlignment2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = rowColumnParentData.weight;
        }
        if ((i11 & 2) != 0) {
            z11 = rowColumnParentData.fill;
        }
        if ((i11 & 4) != 0) {
            crossAxisAlignment2 = rowColumnParentData.crossAxisAlignment;
        }
        return rowColumnParentData.copy(f11, z11, crossAxisAlignment2);
    }

    public final float component1() {
        return this.weight;
    }

    public final boolean component2() {
        return this.fill;
    }

    @Nullable
    public final CrossAxisAlignment component3() {
        return this.crossAxisAlignment;
    }

    @NotNull
    public final RowColumnParentData copy(float f11, boolean z11, @Nullable CrossAxisAlignment crossAxisAlignment2) {
        return new RowColumnParentData(f11, z11, crossAxisAlignment2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RowColumnParentData)) {
            return false;
        }
        RowColumnParentData rowColumnParentData = (RowColumnParentData) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.weight), (Object) Float.valueOf(rowColumnParentData.weight)) && this.fill == rowColumnParentData.fill && Intrinsics.areEqual((Object) this.crossAxisAlignment, (Object) rowColumnParentData.crossAxisAlignment);
    }

    @Nullable
    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final boolean getFill() {
        return this.fill;
    }

    public final float getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.weight) * 31;
        boolean z11 = this.fill;
        if (z11) {
            z11 = true;
        }
        int i11 = (floatToIntBits + (z11 ? 1 : 0)) * 31;
        CrossAxisAlignment crossAxisAlignment2 = this.crossAxisAlignment;
        return i11 + (crossAxisAlignment2 == null ? 0 : crossAxisAlignment2.hashCode());
    }

    public final void setCrossAxisAlignment(@Nullable CrossAxisAlignment crossAxisAlignment2) {
        this.crossAxisAlignment = crossAxisAlignment2;
    }

    public final void setFill(boolean z11) {
        this.fill = z11;
    }

    public final void setWeight(float f11) {
        this.weight = f11;
    }

    @NotNull
    public String toString() {
        return "RowColumnParentData(weight=" + this.weight + ", fill=" + this.fill + ", crossAxisAlignment=" + this.crossAxisAlignment + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RowColumnParentData(float f11, boolean z11, CrossAxisAlignment crossAxisAlignment2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0.0f : f11, (i11 & 2) != 0 ? true : z11, (i11 & 4) != 0 ? null : crossAxisAlignment2);
    }
}
