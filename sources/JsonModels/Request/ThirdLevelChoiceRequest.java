package JsonModels.Request;

import com.google.gson.annotations.SerializedName;

public class ThirdLevelChoiceRequest {
    @SerializedName("branch_Id")
    public int branchId;
    @SerializedName("choice_Ids")
    public String choiceIds;
    @SerializedName("restaurant_Id")
    public int restaurantId;

    public ThirdLevelChoiceRequest(int i11, String str, int i12) {
        this.branchId = i11;
        this.choiceIds = str;
        this.restaurantId = i12;
    }
}
