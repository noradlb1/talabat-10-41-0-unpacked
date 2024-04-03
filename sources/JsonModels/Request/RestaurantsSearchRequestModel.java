package JsonModels.Request;

import com.google.gson.annotations.SerializedName;

public class RestaurantsSearchRequestModel {
    @SerializedName("BranchIds")
    public String BranchIds;
    @SerializedName("SearchTerm")
    public String SearchTerm;
    @SerializedName("KeyboardType")
    public String keyboardType;
}
