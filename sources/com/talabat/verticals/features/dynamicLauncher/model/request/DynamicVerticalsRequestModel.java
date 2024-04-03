package com.talabat.verticals.features.dynamicLauncher.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/verticals/features/dynamicLauncher/model/request/DynamicVerticalsRequestModel;", "", "countryId", "", "latitude", "", "longitude", "(ILjava/lang/String;Ljava/lang/String;)V", "getCountryId", "()I", "setCountryId", "(I)V", "getLatitude", "()Ljava/lang/String;", "setLatitude", "(Ljava/lang/String;)V", "getLongitude", "setLongitude", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DynamicVerticalsRequestModel {
    private int countryId;
    @NotNull
    private String latitude;
    @NotNull
    private String longitude;

    public DynamicVerticalsRequestModel() {
        this(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public DynamicVerticalsRequestModel(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        this.countryId = i11;
        this.latitude = str;
        this.longitude = str2;
    }

    public static /* synthetic */ DynamicVerticalsRequestModel copy$default(DynamicVerticalsRequestModel dynamicVerticalsRequestModel, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = dynamicVerticalsRequestModel.countryId;
        }
        if ((i12 & 2) != 0) {
            str = dynamicVerticalsRequestModel.latitude;
        }
        if ((i12 & 4) != 0) {
            str2 = dynamicVerticalsRequestModel.longitude;
        }
        return dynamicVerticalsRequestModel.copy(i11, str, str2);
    }

    public final int component1() {
        return this.countryId;
    }

    @NotNull
    public final String component2() {
        return this.latitude;
    }

    @NotNull
    public final String component3() {
        return this.longitude;
    }

    @NotNull
    public final DynamicVerticalsRequestModel copy(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        return new DynamicVerticalsRequestModel(i11, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DynamicVerticalsRequestModel)) {
            return false;
        }
        DynamicVerticalsRequestModel dynamicVerticalsRequestModel = (DynamicVerticalsRequestModel) obj;
        return this.countryId == dynamicVerticalsRequestModel.countryId && Intrinsics.areEqual((Object) this.latitude, (Object) dynamicVerticalsRequestModel.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) dynamicVerticalsRequestModel.longitude);
    }

    public final int getCountryId() {
        return this.countryId;
    }

    @NotNull
    public final String getLatitude() {
        return this.latitude;
    }

    @NotNull
    public final String getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        return (((this.countryId * 31) + this.latitude.hashCode()) * 31) + this.longitude.hashCode();
    }

    public final void setCountryId(int i11) {
        this.countryId = i11;
    }

    public final void setLatitude(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.latitude = str;
    }

    public final void setLongitude(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.longitude = str;
    }

    @NotNull
    public String toString() {
        int i11 = this.countryId;
        String str = this.latitude;
        String str2 = this.longitude;
        return "DynamicVerticalsRequestModel(countryId=" + i11 + ", latitude=" + str + ", longitude=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DynamicVerticalsRequestModel(int i11, String str, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? -1 : i11, (i12 & 2) != 0 ? "" : str, (i12 & 4) != 0 ? "" : str2);
    }
}
