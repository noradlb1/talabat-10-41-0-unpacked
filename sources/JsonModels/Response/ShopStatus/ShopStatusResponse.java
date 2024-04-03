package JsonModels.Response.ShopStatus;

import com.google.gson.annotations.SerializedName;

public class ShopStatusResponse {
    public static final int BUSY = 2;
    public static final int CLOSED = 1;
    public static final int HIDDEN = 3;
    public static final int OPEN = 0;
    public static final int OPEN_FOR_PREORDER = 5;
    public static final int PRAYER = 4;
    @SerializedName("base_url")
    public String baseUrl;
    @SerializedName("error")
    public ShopStatusError error;
    @SerializedName("hasserror")
    public boolean hasserror;
    @SerializedName("result")
    public ShopStatusResult result = new ShopStatusResult();
    @SerializedName("timestamp")
    public String timestamp = "";
    @SerializedName("version")
    public String version = "";

    public boolean isShopBusy() {
        ShopStatusResult shopStatusResult = this.result;
        if (shopStatusResult == null || shopStatusResult.shopStatusDeliveryDetails.deliveryAreaStatus != 2) {
            return false;
        }
        return true;
    }
}
