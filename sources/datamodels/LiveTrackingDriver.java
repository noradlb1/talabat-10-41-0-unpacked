package datamodels;

import com.google.gson.annotations.SerializedName;

public class LiveTrackingDriver {
    @SerializedName("lat")
    public String driverLatitude;
    @SerializedName("lng")
    public String driverLongitude;
    @SerializedName("timestamp")
    public String timeRemaining;

    public String getDriverLatitude() {
        return this.driverLatitude;
    }

    public String getDriverLongitude() {
        return this.driverLongitude;
    }

    public String getTimeRemaining() {
        return this.timeRemaining;
    }

    public void setDriverLatitude(String str) {
        this.driverLatitude = str;
    }

    public void setDriverLongitude(String str) {
        this.driverLongitude = str;
    }

    public void setTimeRemaining(String str) {
        this.timeRemaining = str;
    }
}
