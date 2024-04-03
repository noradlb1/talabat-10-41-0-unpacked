package JsonModels.Response;

import com.google.gson.annotations.SerializedName;

public class GroceryBuyAgainResponse {
    public GroceryBuyAgainResult result;
    public String timestamp;

    public static class GroceryBuyAgainResult {
        public String headline;
        @SerializedName("swimlane_id")
        public String swimlaneId;
        @SerializedName("vendor_id")
        public String vendorId;
    }
}
