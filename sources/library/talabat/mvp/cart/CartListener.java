package library.talabat.mvp.cart;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.CustomerAddressInfoJsonResult;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import JsonModels.Response.McdStoresResponse;
import JsonModels.Response.UpsellingResponse;
import JsonModels.RestaurantReviewResponse;
import com.talabat.domain.address.Address;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import datamodels.CampaignVoucher;
import library.talabat.mvp.IGlobalListener;

interface CartListener extends IGlobalListener {
    public static final int TALABAT_DELIVERY_VOUCHER = 2;

    void geoAddressNotReceived();

    void mcdBranchFailed();

    void mcdBranchReceived(McdStoresResponse mcdStoresResponse, boolean z11);

    void onCouponsAndPromotionsLoaded(boolean z11);

    void onCustomVoucherRecived(CampaignVoucher campaignVoucher);

    void onCustomerinfoLoaded(CustomerAddressInfoJsonResult customerAddressInfoJsonResult);

    void onCustomerinfoLoadedBackGround(CustomerAddressInfoJsonResult customerAddressInfoJsonResult, Subscription subscription);

    void onEmptyMenuReceived(String str);

    void onGeoAddressRecieved(Address address, Address address2);

    void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onLoyaltyVoucherError();

    void onLoyaltyVoucherInfoReceived(LoyaltyVoucherRM loyaltyVoucherRM);

    void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onParallelBinAvailable();

    void onRequestError();

    void onReviewLoadingCompleted(RestaurantReviewResponse restaurantReviewResponse);

    void onServerError();

    void onUpsellingItemsReceived(UpsellingResponse upsellingResponse);

    void onWalletCreditCardABTestStatusResponse(boolean z11);
}
