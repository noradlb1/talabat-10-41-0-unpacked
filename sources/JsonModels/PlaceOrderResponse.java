package JsonModels;

import com.google.gson.annotations.SerializedName;
import datamodels.InvalidItem;

public class PlaceOrderResponse {
    @SerializedName("balAmount")
    public float balanceAmount = 0.0f;
    public int campId;
    public int campType;
    public String campUrl;
    public String eMobileNum = "";
    @SerializedName("eOrderId")
    public String encryptedOrderId = "";
    public int errorCode;
    public String errorDetail = "";
    public String errorMessage;
    @SerializedName("items")
    public InvalidItem[] invalidItems;
    public boolean isCampEnabled;
    public boolean isFirstOrder;
    public boolean isOrderSuccess;
    public String paymentRedirectURL;
    @SerializedName("eDuplicateTrans")
    public String previousEncryptedOrderId = "";
    @SerializedName("duplicateId")
    public int previousOrderId = 0;
    public String refId;
    public String smsToken = "";
    @SerializedName("duplicateDiff")
    public String timeDifference = "";
    public String transactionId;
}
