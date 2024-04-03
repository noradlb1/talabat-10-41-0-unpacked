package JsonModels.Response.SplitRestaurantApiResponse;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

public class TgoDiscountTierModel implements Comparable<TgoDiscountTierModel> {
    @SerializedName("perDisc")
    public float discountPercentage;
    @SerializedName("orderAmount")
    public float minimumOrderAmount;

    public int compareTo(@NonNull TgoDiscountTierModel tgoDiscountTierModel) {
        return Float.compare(tgoDiscountTierModel.minimumOrderAmount, this.minimumOrderAmount);
    }
}
