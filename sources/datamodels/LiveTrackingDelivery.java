package datamodels;

import com.google.gson.annotations.SerializedName;

public class LiveTrackingDelivery {
    @SerializedName("deliverAt")
    public String deliveryTime;

    public String getDeliveryTime() {
        return this.deliveryTime;
    }

    public void setDeliveryTime(String str) {
        this.deliveryTime = str;
    }
}
