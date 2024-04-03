package JsonModels.Request.CheckoutDotComRequest;

import com.google.gson.annotations.SerializedName;

public class RecurringPurchaseRequest {
    @SerializedName("cvc")
    public String cvv = "";
    @SerializedName("isCVCRequired")
    private boolean isCVCRequired;
    @SerializedName("lang")
    public String language;
    @SerializedName("cardId")
    public String token;
    @SerializedName("eTransId")
    public String transactionId;

    public boolean getIsCVCRequired() {
        return this.isCVCRequired;
    }

    public void setIsCVCRequired(Boolean bool) {
        this.isCVCRequired = bool.booleanValue();
    }
}
