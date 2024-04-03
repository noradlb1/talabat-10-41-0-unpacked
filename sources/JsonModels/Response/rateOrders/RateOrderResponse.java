package JsonModels.Response.rateOrders;

import com.google.gson.annotations.SerializedName;

public class RateOrderResponse {
    @SerializedName("result")
    Data data;
    @SerializedName("haserror")
    boolean hasError;

    public class Data {
        @SerializedName("average_rating")
        float averageRating;
        @SerializedName("chain_id")
        int chainId;
        @SerializedName("delivery_rating")
        float deliveryRating;
        @SerializedName("order_id")
        int orderId;
        @SerializedName("review")
        String review;
        @SerializedName("transaction_id")
        int transactionId;
        @SerializedName("vendor_id")
        int vendorId;
        @SerializedName("vendor_rating")
        float vendorRating;

        public Data() {
        }

        public int getTransactionId() {
            return this.transactionId;
        }

        public float getVendorRating() {
            return this.vendorRating;
        }
    }

    public Data getData() {
        return this.data;
    }

    public boolean isHasError() {
        return this.hasError;
    }
}
