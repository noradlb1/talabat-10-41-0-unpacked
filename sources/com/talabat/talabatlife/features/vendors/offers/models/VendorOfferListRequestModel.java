package com.talabat.talabatlife.features.vendors.offers.models;

import com.talabat.talabatcommon.extentions.IntKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/offers/models/VendorOfferListRequestModel;", "", "restaurantID", "", "countryCode", "(II)V", "getCountryCode", "()I", "setCountryCode", "(I)V", "getRestaurantID", "setRestaurantID", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorOfferListRequestModel {
    private int countryCode;
    private int restaurantID;

    public VendorOfferListRequestModel() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public VendorOfferListRequestModel(int i11, int i12) {
        this.restaurantID = i11;
        this.countryCode = i12;
    }

    public final int getCountryCode() {
        return this.countryCode;
    }

    public final int getRestaurantID() {
        return this.restaurantID;
    }

    public final void setCountryCode(int i11) {
        this.countryCode = i11;
    }

    public final void setRestaurantID(int i11) {
        this.restaurantID = i11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorOfferListRequestModel(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? -1 : i11, (i13 & 2) != 0 ? IntKt.orZero(IntCompanionObject.INSTANCE) : i12);
    }
}
