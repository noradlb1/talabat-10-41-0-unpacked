package datamodels;

import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

public class GemOfferItemsModel {
    @SerializedName("imagePath")
    public String imagePath;
    @SerializedName("rank")
    public int rank;
    @SerializedName("reservationCode")
    public long reservationCode;
    @SerializedName("restaurant")
    private Restaurant restaurant;
    @SerializedName("branchID")
    private int restaurantBranchId;
    @SerializedName("reservationStatus")
    public int status;
    @SerializedName("reservationStatusText")
    public String statusText;

    public int getBranchId() {
        Restaurant restaurant2 = this.restaurant;
        return restaurant2 != null ? restaurant2.branchId : this.restaurantBranchId;
    }

    @Nullable
    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    @Deprecated
    public void setRestaurantBranchId(int i11) {
        this.restaurantBranchId = i11;
    }
}
