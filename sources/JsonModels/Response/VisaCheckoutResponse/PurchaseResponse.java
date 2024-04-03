package JsonModels.Response.VisaCheckoutResponse;

import com.google.gson.annotations.SerializedName;

public class PurchaseResponse {
    @SerializedName("isValid")
    public boolean isValid;
    @SerializedName("displayMessage")
    public String message;
    @SerializedName("redirectUrl")
    public String redirectUrl;
    @SerializedName("technicalError")
    public String technicalError;
}
