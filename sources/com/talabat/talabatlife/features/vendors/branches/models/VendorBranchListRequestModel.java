package com.talabat.talabatlife.features.vendors.branches.models;

import com.adjust.sdk.Constants;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/branches/models/VendorBranchListRequestModel;", "", "restaurantID", "", "lat", "", "long", "(ILjava/lang/String;Ljava/lang/String;)V", "getLat", "()Ljava/lang/String;", "setLat", "(Ljava/lang/String;)V", "getLong", "setLong", "getRestaurantID", "()I", "setRestaurantID", "(I)V", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorBranchListRequestModel {
    @NotNull
    private String lat;
    @NotNull

    /* renamed from: long  reason: not valid java name */
    private String f50long;
    private int restaurantID;

    public VendorBranchListRequestModel() {
        this(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public VendorBranchListRequestModel(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "lat");
        Intrinsics.checkNotNullParameter(str2, Constants.LONG);
        this.restaurantID = i11;
        this.lat = str;
        this.f50long = str2;
    }

    @NotNull
    public final String getLat() {
        return this.lat;
    }

    @NotNull
    public final String getLong() {
        return this.f50long;
    }

    public final int getRestaurantID() {
        return this.restaurantID;
    }

    public final void setLat(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lat = str;
    }

    public final void setLong(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f50long = str;
    }

    public final void setRestaurantID(int i11) {
        this.restaurantID = i11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorBranchListRequestModel(int i11, String str, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? -1 : i11, (i12 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, (i12 & 4) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str2);
    }
}
