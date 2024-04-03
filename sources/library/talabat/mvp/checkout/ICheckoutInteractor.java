package library.talabat.mvp.checkout;

import JsonModels.Request.BIN.BinRequest;
import JsonModels.Response.MenuItemResponse;
import datamodels.CardInformation;
import datamodels.Restaurant;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import library.talabat.mvp.IGlobalInteractor;

interface ICheckoutInteractor extends IGlobalInteractor {
    void callCashBackApi(float f11);

    void checkForBinVoucher(BinRequest binRequest);

    void getAllBinOffers(boolean z11);

    void getBinOfferDetails(int i11, boolean z11, boolean z12, boolean z13, String str, int i12);

    void getCampaignVoucher(int i11);

    void getCustomerTokensForBin();

    void getDeliveryTimeIntervals(int i11, int i12, String str);

    void getGetActiveSubscriptions(Function1<Boolean, Unit> function1);

    void getGroceryMenu(Restaurant restaurant);

    void getOrderDetails(String str);

    Observable<MenuItemResponse> getRestaurantInfo(int i11, double d11, double d12);

    void getRestaurantInfoOnly(Restaurant restaurant);

    void getRestaurantMenuOnly(Restaurant restaurant);

    void getRestaurants(int i11, int i12, int i13);

    void getVoucherDetalsForLoyaltyVoucher(String str, String str2);

    void postSubscriptionPayment(CardInformation cardInformation);

    void proceedForVisaCheckout(String str, String str2);

    void sendDecryptRequest(String str, String str2);
}
