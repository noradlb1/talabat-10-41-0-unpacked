package com.opsquad.ui.orderDetail.rows.deliveryAddressCell;

import com.opsquad.ui.orderDetail.rows.RowDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/deliveryAddressCell/DeliveryAddressDisplayModel;", "Lcom/opsquad/ui/orderDetail/rows/RowDisplayModel;", "()V", "addressDescription", "", "getAddressDescription", "()Ljava/lang/String;", "setAddressDescription", "(Ljava/lang/String;)V", "areaName", "getAreaName", "setAreaName", "extraDirections", "getExtraDirections", "setExtraDirections", "landLineNumber", "getLandLineNumber", "setLandLineNumber", "mobileNumber", "getMobileNumber", "setMobileNumber", "profileName", "getProfileName", "setProfileName", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryAddressDisplayModel extends RowDisplayModel {
    @NotNull
    private String addressDescription = "";
    @NotNull
    private String areaName = "";
    @NotNull
    private String extraDirections = "";
    @NotNull
    private String landLineNumber = "";
    @NotNull
    private String mobileNumber = "";
    @NotNull
    private String profileName = "";

    @NotNull
    public final String getAddressDescription() {
        return this.addressDescription;
    }

    @NotNull
    public final String getAreaName() {
        return this.areaName;
    }

    @NotNull
    public final String getExtraDirections() {
        return this.extraDirections;
    }

    @NotNull
    public final String getLandLineNumber() {
        return this.landLineNumber;
    }

    @NotNull
    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    @NotNull
    public final String getProfileName() {
        return this.profileName;
    }

    public final void setAddressDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.addressDescription = str;
    }

    public final void setAreaName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.areaName = str;
    }

    public final void setExtraDirections(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extraDirections = str;
    }

    public final void setLandLineNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.landLineNumber = str;
    }

    public final void setMobileNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mobileNumber = str;
    }

    public final void setProfileName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.profileName = str;
    }
}
