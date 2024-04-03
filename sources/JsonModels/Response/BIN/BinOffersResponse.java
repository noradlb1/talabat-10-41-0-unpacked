package JsonModels.Response.BIN;

import com.google.gson.annotations.SerializedName;

public class BinOffersResponse {
    public boolean isValid;
    @SerializedName("notifyMesg")
    public String notificationMesage;
}
