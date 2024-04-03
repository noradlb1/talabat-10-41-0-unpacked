package library.talabat.mvp.cart;

import JsonModels.Request.McdBlockMapGrlUpdateRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Response.ShopStatus.ShopStatusResponse;
import com.talabat.domain.address.Address;
import datamodels.Restaurant;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import library.talabat.mvp.IGlobalInteractor;

interface ICartInteractor extends IGlobalInteractor {
    void checkForSelectedAddressAreaUpdate(Function0<Unit> function0);

    void fetchPaymentOptionABTestUserStatus();

    void getAllBinOffers();

    void getCampaignVoucher(int i11);

    void getCustomerTokensForBin();

    void getGroceryMenu(Restaurant restaurant);

    void getMcdLatLngStoresCheck(McdBranchRequest mcdBranchRequest, boolean z11);

    void getRestaurantInfoOnly(Restaurant restaurant);

    void getRestaurantMenuOnly(Restaurant restaurant);

    Observable<ShopStatusResponse> getShopStatus(String str, String str2, String str3, boolean z11);

    void getVoucherDetalsForLoyaltyVoucher(String str, String str2);

    void loadCouponsAndPromotions(int i11, float f11, Restaurant restaurant);

    void loadCustomerDetails();

    void loadRestaurantReview(int i11, int i12);

    void loadUpSellingItems(Restaurant restaurant);

    void updateAddresswithGoogleAddress(Address address);

    void updateSelectedAddressGrl(McdBlockMapGrlUpdateRequest mcdBlockMapGrlUpdateRequest);

    void updateUserInfoBackground();
}
