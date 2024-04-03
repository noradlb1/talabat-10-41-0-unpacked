package JsonModels.Response;

import com.google.gson.annotations.SerializedName;

public class InforMapResult {
    @SerializedName("Msg")
    public String message;
    @SerializedName("title")
    public String msgTitle;
    @SerializedName("StatusCode")
    public int statusCode;
}
