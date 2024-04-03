package JsonModels;

import com.google.gson.annotations.SerializedName;

public class DashStatusDetailsModel {
    @SerializedName("iso")
    public boolean isSuccessfull;
    @SerializedName("eos")
    public int newOrderStatus;
    @SerializedName("id")
    public String orderID;
}
