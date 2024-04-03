package library.talabat.mvp.home;

import android.content.Context;
import com.talabat.helpers.Talabat;
import datamodels.Restaurant;
import java.util.List;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;
import org.jetbrains.annotations.Nullable;

public interface HomeView extends Talabat {
    void checkVouchersState();

    Context getContext();

    String getScreenName();

    void hideCartView();

    void hideLoading();

    void hideOverdueNotification();

    boolean isAccountSelected();

    boolean isOverdueNotificationVisible();

    void loadGroceryHomeScreen(int i11, String str, List<Integer> list);

    void navigateToVendorListScreen(boolean z11);

    void openBasketListScreen();

    void openFoodBasketScreen();

    void openQCommerceBasketScreen(Restaurant restaurant);

    void outSideCountry(int i11);

    void redirectToChooseSavedAddressScreen(boolean z11);

    void redirectToHomeMapScreen(boolean z11, String str, boolean z12);

    void redirectToSearchScreen();

    void refreshHomeScreen();

    void resetAddressName();

    void resetCurrentLocationObserver();

    void setCurrentLocationFromBeginning();

    void setToolBarAddressLocationTitle(String str);

    void setupAccountTab(boolean z11);

    void showCartView(ActiveCartInfo activeCartInfo);

    void showLoading();

    void showLocationFetching();

    void showNotificationPermissionDialog();

    void showOverdueNotification();

    void showRatingBottomSheetForLastOrder(@Nullable String str);

    void updateVoucherState(VoucherStateDomainModel voucherStateDomainModel);

    void userAccountClicked();
}
