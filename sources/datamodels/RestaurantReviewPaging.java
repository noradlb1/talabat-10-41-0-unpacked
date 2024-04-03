package datamodels;

import com.google.gson.annotations.SerializedName;

public class RestaurantReviewPaging {
    @SerializedName("oid")
    int OrderId;
    @SerializedName("con")
    String date;
    @SerializedName("fn")
    String firstName;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    int f13874id;
    @SerializedName("ln")
    String lastName;
    @SerializedName("rat")
    float rating;
    public ReviewReply res;
    @SerializedName("rew")
    String review;

    public String getDate() {
        return this.date;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public float getRating() {
        return this.rating;
    }

    public String getReview() {
        return this.review;
    }
}
