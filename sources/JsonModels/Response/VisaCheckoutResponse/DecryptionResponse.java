package JsonModels.Response.VisaCheckoutResponse;

import com.google.gson.annotations.SerializedName;

public class DecryptionResponse {
    public String baseImageFileName;
    @SerializedName("name")
    public String cardHolderName;
    public String cardType;
    public String displayMessage;
    public String expiryDate;
    public boolean isValid;
    @SerializedName("last4")
    public String lastFourDigits;
}
