package JsonModels.Response.AdyenResponse;

import com.google.gson.annotations.SerializedName;

public class AdyenPurchaseResponse {
    @SerializedName("IsValid")
    public boolean isValid;
    @SerializedName("DisplayMessage")
    public String message;
    @SerializedName("RedirectUrl")
    public String redirectUrl;
    @SerializedName(" ResponseCode")
    public int responseCode;
    public int verificationCode;
}
