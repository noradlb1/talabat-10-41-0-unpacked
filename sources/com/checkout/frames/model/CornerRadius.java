package com.checkout.frames.model;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/checkout/frames/model/CornerRadius;", "", "radius", "", "(I)V", "topStart", "topEnd", "bottomEnd", "bottomStart", "(IIII)V", "getBottomEnd", "()I", "getBottomStart", "getTopEnd", "getTopStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CornerRadius {
    public static final int $stable = 0;
    private final int bottomEnd;
    private final int bottomStart;
    private final int topEnd;
    private final int topStart;

    public CornerRadius() {
        this(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
    }

    public CornerRadius(int i11, int i12, int i13, int i14) {
        this.topStart = i11;
        this.topEnd = i12;
        this.bottomEnd = i13;
        this.bottomStart = i14;
    }

    public static /* synthetic */ CornerRadius copy$default(CornerRadius cornerRadius, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = cornerRadius.topStart;
        }
        if ((i15 & 2) != 0) {
            i12 = cornerRadius.topEnd;
        }
        if ((i15 & 4) != 0) {
            i13 = cornerRadius.bottomEnd;
        }
        if ((i15 & 8) != 0) {
            i14 = cornerRadius.bottomStart;
        }
        return cornerRadius.copy(i11, i12, i13, i14);
    }

    public final int component1() {
        return this.topStart;
    }

    public final int component2() {
        return this.topEnd;
    }

    public final int component3() {
        return this.bottomEnd;
    }

    public final int component4() {
        return this.bottomStart;
    }

    @NotNull
    public final CornerRadius copy(int i11, int i12, int i13, int i14) {
        return new CornerRadius(i11, i12, i13, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CornerRadius)) {
            return false;
        }
        CornerRadius cornerRadius = (CornerRadius) obj;
        return this.topStart == cornerRadius.topStart && this.topEnd == cornerRadius.topEnd && this.bottomEnd == cornerRadius.bottomEnd && this.bottomStart == cornerRadius.bottomStart;
    }

    public final int getBottomEnd() {
        return this.bottomEnd;
    }

    public final int getBottomStart() {
        return this.bottomStart;
    }

    public final int getTopEnd() {
        return this.topEnd;
    }

    public final int getTopStart() {
        return this.topStart;
    }

    public int hashCode() {
        return (((((this.topStart * 31) + this.topEnd) * 31) + this.bottomEnd) * 31) + this.bottomStart;
    }

    @NotNull
    public String toString() {
        int i11 = this.topStart;
        int i12 = this.topEnd;
        int i13 = this.bottomEnd;
        int i14 = this.bottomStart;
        return "CornerRadius(topStart=" + i11 + ", topEnd=" + i12 + ", bottomEnd=" + i13 + ", bottomStart=" + i14 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CornerRadius(int i11, int i12, int i13, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? 0 : i11, (i15 & 2) != 0 ? 0 : i12, (i15 & 4) != 0 ? 0 : i13, (i15 & 8) != 0 ? 0 : i14);
    }

    public CornerRadius(int i11) {
        this(i11, i11, i11, i11);
    }
}
