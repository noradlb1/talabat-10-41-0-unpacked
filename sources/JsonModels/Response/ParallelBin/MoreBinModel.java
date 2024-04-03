package JsonModels.Response.ParallelBin;

import com.google.gson.annotations.SerializedName;

public class MoreBinModel {
    @SerializedName("campaignId")
    public String campaignId = "";
    @SerializedName("icon")
    public String moreBinIconUrl;
    @SerializedName("msg")
    public String moreBinMessage;
}
