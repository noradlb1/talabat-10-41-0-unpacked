package JsonModels.Request.VisaCheckoutRequest;

import com.google.gson.annotations.SerializedName;

public class PurchaseRequest {
    @SerializedName("callId")
    public String callId;
    @SerializedName("lang")
    public String language;
    @SerializedName("eTransactionId")
    public String transactionId;
}
