package JsonModels.Response;

import com.google.gson.annotations.SerializedName;

public class OrderItem {
    @SerializedName("ics")
    public String choices;
    @SerializedName("itn")
    public String itemName;
    @SerializedName("qty")
    public int quantity;
}
