package JsonModels.Response.ShopStatus;

import com.google.gson.annotations.SerializedName;

public class ShopStatusError {
    @SerializedName("errorCode")
    public String errorCode = "";
    @SerializedName("message")
    public String message = "";
    @SerializedName("title")
    public String title = "";
}
