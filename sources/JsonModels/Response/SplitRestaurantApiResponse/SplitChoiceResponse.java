package JsonModels.Response.SplitRestaurantApiResponse;

import com.google.gson.annotations.SerializedName;

public class SplitChoiceResponse {
    @SerializedName("choiceForItem")
    public SplitChoiceItemModel[] items;
}
