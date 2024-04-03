package JsonModels.Request.rateOrders;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class RateOrderRequest {
    @SerializedName("delivery_rating")
    String deliveryRating;
    @SerializedName("delivery_reasons")
    ArrayList<String> deliveryReasons;
    @SerializedName("order_id")
    String orderId;
    @SerializedName("review")
    String review;
    @SerializedName("vendor_rating")
    String vendorRating;
    @SerializedName("vendor_reasons")
    ArrayList<String> vendorReasons;

    public String getDeliveryRating() {
        return this.deliveryRating;
    }

    public ArrayList<String> getDeliveryReasons() {
        return this.deliveryReasons;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getReview() {
        return this.review;
    }

    public String getVendorRating() {
        return this.vendorRating;
    }

    public ArrayList<String> getVendorReasons() {
        return this.vendorReasons;
    }

    public void setDeliveryRating(String str) {
        this.deliveryRating = str;
    }

    public void setDeliveryReasons(ArrayList<String> arrayList) {
        this.deliveryReasons = arrayList;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setReview(String str) {
        this.review = str;
    }

    public void setVendorRating(String str) {
        this.vendorRating = str;
    }

    public void setVendorReasons(ArrayList<String> arrayList) {
        this.vendorReasons = arrayList;
    }
}
