package JsonModels.Request.VisaCheckoutRequest;

public class UpdatePayRequest {
    public String eTransactionId;
    public String fortId;
    public boolean payStatus;

    public UpdatePayRequest(String str, boolean z11, String str2) {
        this.eTransactionId = str;
        this.payStatus = z11;
        this.fortId = str2;
    }
}
