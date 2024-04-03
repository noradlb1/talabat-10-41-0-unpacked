package JsonModels.Request.CheckoutDotComRequest;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PurchaseRequest implements Serializable {
    public int bankId = -1;
    public String binNumber;
    @SerializedName("lang")
    public String language;
    @SerializedName("keepCard")
    public boolean saveCard;
    @SerializedName("cToken")
    public String token;
    @SerializedName("eTransId")
    public String transactionId;
}
