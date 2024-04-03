package library.talabat.mvp.cart;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.talabat.domain.address.Address;
import datamodels.CartMenuItem;
import datamodels.MenuItem;
import datamodels.Restaurant;
import library.talabat.mvp.IGlobalPresenter;

public interface ICartPresenter extends IGlobalPresenter {
    void addMoreItemsClicked(Restaurant restaurant, String str);

    void addUpsellingItem(MenuItem menuItem);

    void clearShowBusyPopup();

    void confirmButtonPressed(Restaurant restaurant, Context context, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15);

    void decreaseQuantity(CartMenuItem cartMenuItem);

    void editCartCompleted();

    void getBinTokens();

    CartAdapterListener getCartFooterListener();

    MutableLiveData<Boolean> getFreeDeliveryVoucherStackingError();

    boolean getIsNonCombinationalPromotionItemPresent();

    String getMobileNumber(boolean z11);

    void getShopStatus();

    MutableLiveData<Boolean> getShowBusyPopup();

    void handleDeliveryFee(float f11);

    void handleServiceFee(float f11);

    void handleSmallOrderFee(float f11);

    void increaseQuantiy(CartMenuItem cartMenuItem);

    boolean isVoucherStackingEnabled();

    void loadCouponsAndPromotions(int i11, float f11, Restaurant restaurant);

    void loadCustomerDetails();

    void loadCustomerDetailsBackground();

    void observeBusyPopupOpen(Restaurant restaurant);

    void observeBusyPopupRestaurantSelection(Restaurant restaurant);

    void observeBusyPopupViewSimilarClick();

    void observeInconsistencyInCartItems(int i11, int i12, int i13, int i14, Boolean bool, Restaurant restaurant);

    void onGuestCheckoutRequested();

    void onResultFromLoginScreenForAddressList();

    void onResultSuccessFromProgressiveLoginBottomSheet();

    void onViewLoaded();

    void recalculateAppliedVoucher();

    void redirectToLogin();

    void removeBinDiscount();

    void removeItemAtPosition(int i11, Context context);

    void removeVoucherIfRequired();

    void setViews();

    void updateAddressWithGoogleApi(Address address);
}
