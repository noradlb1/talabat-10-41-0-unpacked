package JsonModels.Response.ParallelBin;

import com.google.gson.annotations.SerializedName;

public class ParallelBinResponse {
    public int areaId;
    @SerializedName("icon")
    public String iconUrl;
    @SerializedName("moreOffers")
    public MoreBinModel[] moreBinModels;
    public String msg;
    public int restaurantId;

    public boolean areMoreBinModelsAvailable() {
        MoreBinModel[] moreBinModelArr = this.moreBinModels;
        return moreBinModelArr != null && moreBinModelArr.length > 0;
    }
}
