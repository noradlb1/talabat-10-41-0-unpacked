package datamodels;

import com.google.gson.annotations.SerializedName;

public class RestaurantReview {
    @SerializedName("sr")
    public RatingSection ratingSection;
    public RestaurantReviewPaging[] rev;
    @SerializedName("pg")
    public int totalPages;
    @SerializedName("tr")
    public int totalReviews;
}
