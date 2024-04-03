package JsonModels.Request.AdyenRequestModels;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AdyenPurchaseRequest implements Serializable {
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
