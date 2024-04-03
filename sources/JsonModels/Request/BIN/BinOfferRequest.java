package JsonModels.Request.BIN;

import com.google.gson.annotations.SerializedName;

public class BinOfferRequest {
    public int areaId;
    public int branchId;
    public boolean hasCoupon;
    public boolean hasFreeItem;
    public boolean hasPromotion;
    @SerializedName("mob")
    public String mobileNumber;
    @SerializedName("restId")
    public int restaurantId;

    public BinOfferRequest(int i11, boolean z11, boolean z12, boolean z13, String str, int i12, int i13) {
        this.restaurantId = i11;
        this.hasPromotion = z11;
        this.hasFreeItem = z12;
        this.hasCoupon = z13;
        this.mobileNumber = str;
        this.areaId = i12;
        this.branchId = i13;
    }
}
