package JsonModels.Request.GEMRequests;

import com.google.gson.annotations.SerializedName;

public class GemOfferRequest {
    String areaId;
    String countryId;
    boolean isSandBox = false;
    @SerializedName("branchIDs")
    String restaurantBranchIds;

    public GemOfferRequest(String str, String str2, String str3) {
        this.areaId = str;
        this.restaurantBranchIds = str2;
        this.countryId = str3;
    }
}
