package com.talabat.feature.pickup.data.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/pickup/data/entity/PickupCuisineDto;", "", "id", "", "isPrimary", "", "name", "", "(IZLjava/lang/String;)V", "getId", "()I", "()Z", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupCuisineDto {

    /* renamed from: id  reason: collision with root package name */
    private final int f58633id;
    private final boolean isPrimary;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58634name;

    public PickupCuisineDto(int i11, boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f58633id = i11;
        this.isPrimary = z11;
        this.f58634name = str;
    }

    public static /* synthetic */ PickupCuisineDto copy$default(PickupCuisineDto pickupCuisineDto, int i11, boolean z11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = pickupCuisineDto.f58633id;
        }
        if ((i12 & 2) != 0) {
            z11 = pickupCuisineDto.isPrimary;
        }
        if ((i12 & 4) != 0) {
            str = pickupCuisineDto.f58634name;
        }
        return pickupCuisineDto.copy(i11, z11, str);
    }

    public final int component1() {
        return this.f58633id;
    }

    public final boolean component2() {
        return this.isPrimary;
    }

    @NotNull
    public final String component3() {
        return this.f58634name;
    }

    @NotNull
    public final PickupCuisineDto copy(int i11, boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new PickupCuisineDto(i11, z11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PickupCuisineDto)) {
            return false;
        }
        PickupCuisineDto pickupCuisineDto = (PickupCuisineDto) obj;
        return this.f58633id == pickupCuisineDto.f58633id && this.isPrimary == pickupCuisineDto.isPrimary && Intrinsics.areEqual((Object) this.f58634name, (Object) pickupCuisineDto.f58634name);
    }

    public final int getId() {
        return this.f58633id;
    }

    @NotNull
    public final String getName() {
        return this.f58634name;
    }

    public int hashCode() {
        int i11 = this.f58633id * 31;
        boolean z11 = this.isPrimary;
        if (z11) {
            z11 = true;
        }
        return ((i11 + (z11 ? 1 : 0)) * 31) + this.f58634name.hashCode();
    }

    public final boolean isPrimary() {
        return this.isPrimary;
    }

    @NotNull
    public String toString() {
        int i11 = this.f58633id;
        boolean z11 = this.isPrimary;
        String str = this.f58634name;
        return "PickupCuisineDto(id=" + i11 + ", isPrimary=" + z11 + ", name=" + str + ")";
    }
}
