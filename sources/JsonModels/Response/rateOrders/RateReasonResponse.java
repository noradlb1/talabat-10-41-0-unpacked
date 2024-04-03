package JsonModels.Response.rateOrders;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class RateReasonResponse {
    @SerializedName("haserror")
    boolean hasError;
    @SerializedName("result")
    Data result;

    public class Data {
        @SerializedName("rating_reasons")
        RatingReasons ratingReasons;
        @SerializedName("vertical_type_id")
        int vendorType;

        public Data() {
        }

        public RatingReasons getRatingReasons() {
            return this.ratingReasons;
        }

        public int getVendorType() {
            return this.vendorType;
        }

        public void setRatingReasons(RatingReasons ratingReasons2) {
            this.ratingReasons = ratingReasons2;
        }

        public void setVendorType(int i11) {
            this.vendorType = i11;
        }
    }

    public class RatingReasons {
        @SerializedName("delivery_reasons")
        ArrayList<RateReason> deliveryReasons;
        @SerializedName("vendor_reasons")
        ArrayList<RateReason> vendorReasons;

        public RatingReasons() {
        }

        public ArrayList<RateReason> getDeliveryReasons() {
            return this.deliveryReasons;
        }

        public ArrayList<RateReason> getVendorReasons() {
            return this.vendorReasons;
        }

        public void setDeliveryReasons(ArrayList<RateReason> arrayList) {
            this.deliveryReasons = arrayList;
        }

        public void setVendorReasons(ArrayList<RateReason> arrayList) {
            this.vendorReasons = arrayList;
        }
    }

    public Data getResult() {
        return this.result;
    }

    public boolean isHasError() {
        return this.hasError;
    }

    public void setHasError(boolean z11) {
        this.hasError = z11;
    }

    public void setResult(Data data) {
        this.result = data;
    }
}
