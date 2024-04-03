package JsonModels.Request.VisaCheckoutRequest;

public class DecryptionRequest {
    public String payload;
    public String wrappedKey;

    public DecryptionRequest(String str, String str2) {
        this.wrappedKey = str;
        this.payload = str2;
    }
}
