package datamodels;

import library.talabat.com.talabatlib.RestuarntListResponse;

public class WrapperRestaurantRecommendation {
    RestuarntListResponse restaurantListInfoResponse;
    RestuarntListResponse restuarntListResponse;

    public RestuarntListResponse getRestaurantListInfoResponse() {
        return this.restaurantListInfoResponse;
    }

    public RestuarntListResponse getRestuarntListResponse() {
        return this.restuarntListResponse;
    }

    public void setRestaurantListInfoResponse(RestuarntListResponse restuarntListResponse2) {
        this.restaurantListInfoResponse = restuarntListResponse2;
    }

    public void setRestuarntListResponse(RestuarntListResponse restuarntListResponse2) {
        this.restuarntListResponse = restuarntListResponse2;
    }
}
