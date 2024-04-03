package JsonModels.Response;

import com.google.gson.annotations.SerializedName;

public class WalletCreditCardABTestResponse {
    @SerializedName("baseUrl")
    public String baseUrl;
    @SerializedName("result")
    public WalletCreditCardABTestResponseResult result;
    @SerializedName("timestamp")
    public String timestamp;
}
