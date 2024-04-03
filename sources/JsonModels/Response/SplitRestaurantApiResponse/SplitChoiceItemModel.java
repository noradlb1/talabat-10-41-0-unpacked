package JsonModels.Response.SplitRestaurantApiResponse;

import com.google.gson.annotations.SerializedName;
import datamodels.ChoiceSection;

public class SplitChoiceItemModel {
    @SerializedName("choiceSections")
    public ChoiceSection[] choiceSections;
    @SerializedName("itemId")

    /* renamed from: id  reason: collision with root package name */
    public int f480id;
}
