package library.talabat.mvp.cart;

import android.content.Context;
import com.talabat.domain.address.Address;
import com.talabat.helpers.Talabat;
import datamodels.MenuItem;
import datamodels.RatingSection;
import datamodels.RestaurantReviewPaging;
import java.util.ArrayList;

public interface CartView extends Talabat {
    int getBlackColor();

    Context getContext();

    String getDeliveryChargesString();

    String getFreeString();

    int getGemTextColor(int i11);

    String getMinimumOrderString();

    String getMunicipalityTaxText();

    String getNormalVoucherText();

    int getPromoColor();

    String getScreenName();

    String getTalabatChargesString();

    String getTouristTaxLabelText();

    int getVoucherDiscountTextColor();

    String getZeroVoucherText();

    int getZeroVoucherTextColor();

    void isGrlRestaurantRedirect(Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16);

    void isMapCompulsory(Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15);

    void mapFirstRedirect(Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19);

    void mapFirstUpdateAddressRedirect(Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19);

    void navigateToFlutterMenu();

    void navigateToQuickOrderScreen(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15);

    void notifyItemRemovedToAdapter(int i11);

    void notifyRecyclerViewFooter();

    void notifySubTotalChanged(float f11);

    void onCartEmpty();

    void onCouponsAndPromotionsLoaded(boolean z11, boolean z12);

    void onEmptyMenuReceived(String str);

    void onGemEnabledItemUpdated();

    void onMenuLoadingStarted();

    void onParallelBinAvailable();

    void onRedirectToAddressSelection(boolean z11, boolean z12, boolean z13, boolean z14);

    void onRedirectToCheckOut(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16);

    void onRedirectToGroceryMenuPage();

    void onRedirectToLogin(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15);

    void onRedirectToMenuPage();

    void onRequestError();

    void onReviewLoadingCompleted(RestaurantReviewPaging[] restaurantReviewPagingArr, int i11, int i12, RatingSection ratingSection);

    void onServerError();

    void onSetWalletABTestStatus(boolean z11);

    void onUpsellingItemsRecieved(ArrayList<MenuItem> arrayList);

    void setContinueButtonAlpha(float f11);

    void setContinueButtonEnabledStatus(boolean z11);

    void setMinimumOrderText(String str);

    void setMinimumOrderVisibility(int i11);

    void setRestaurantName(String str, String str2);

    void showCouponLoading();

    void showLoginOptionsBottomSheet(boolean z11);

    void showMinimumOrderAmountPopup();

    void showNonCancelableProgress();

    void showUserVerifyicationView(String str, String str2, String str3);

    void stopNonCancelableLoading();
}
