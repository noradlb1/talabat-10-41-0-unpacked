package tracking.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import datamodels.City;
import datamodels.Country;
import datamodels.DeliveryArea;
import datamodels.OrderDetails;
import datamodels.QuickFilter;
import datamodels.RateOrderReq;
import datamodels.Restaurant;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;

public interface DeeplinkListener {
    boolean canHandleAppLink(Uri uri);

    void onALRedirectToDeepLinkWebviewScreen(String str);

    void onALRedirectToGroceryMenu();

    void onALRedirectToRestauranListScreen();

    void onALRedirectToRestauranMenu();

    void onALRedirectToRestaurantSearchScreen();

    void onDLForceRedirectToHomeScreenWithQatar(boolean z11, @NonNull MutableConfigurationLocalRepository mutableConfigurationLocalRepository);

    void onDLRedirectTLifeOfferPage(String str);

    void onDLRedirectTLifeVendorsList(boolean z11, boolean z12);

    void onDLRedirectTLoyaltyDashboardScreen();

    void onDLRedirectToAccountInfoScreen();

    void onDLRedirectToAddressListScreen();

    void onDLRedirectToCartScreen();

    void onDLRedirectToDarkstores(Restaurant restaurant, int i11, String str, String str2, String str3, DarkstoresTrackingData darkstoresTrackingData);

    void onDLRedirectToGiftVoucherScreen();

    void onDLRedirectToGroceryHomeScreen(@Nullable Bundle bundle);

    void onDLRedirectToHomeScreen();

    void onDLRedirectToHomeScreenThenListing(boolean z11);

    void onDLRedirectToHomeScreenWithVoucherDetailsBottomSheet(String str, @Nullable String str2, @Nullable String str3);

    void onDLRedirectToLiveChatScreen(String str);

    void onDLRedirectToLoginScreen(@Nullable Intent intent, boolean z11);

    void onDLRedirectToLoginScreenWithDeeplink(@Nullable String str, boolean z11);

    void onDLRedirectToNewRestaurantScreen();

    void onDLRedirectToNotificationScreen();

    void onDLRedirectToOffersScreen();

    void onDLRedirectToOrderDetailsScreen(OrderDetails orderDetails);

    void onDLRedirectToOrderTrackingWebview(String str);

    void onDLRedirectToOrdersListScreen();

    void onDLRedirectToPurchaseTalabatCreditScreen();

    void onDLRedirectToRateOrderScreen(RateOrderReq rateOrderReq);

    void onDLRedirectToRedeemVoucherScreen(String str);

    void onDLRedirectToReorderScreen();

    void onDLRedirectToRestauranListScreen();

    void onDLRedirectToRestauransQuickFilterListScreen(QuickFilter quickFilter);

    void onDLRedirectToRestaurantScreen(Restaurant restaurant, DeliveryArea[] deliveryAreaArr, City[] cityArr, int i11, String str);

    void onDLRedirectToRestaurantSearchScreen(String str);

    void onDLRedirectToSelectCountryScreen();

    void onDLRedirectToSettingsScreen();

    void onDLRedirectToTalabatCreditStatementScreen();

    void onDLRedirectToWebview(String str, boolean z11);

    void onDLRedirectVoucherWalletScreen(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z11);

    void onDLSaveArea(int i11, String str);

    void onDLSaveCity(int i11, String str);

    void onDLSaveCountry(Country country, @NonNull MutableConfigurationLocalRepository mutableConfigurationLocalRepository);

    void onDeepLinkNavigateToBNPLDashboard();

    void onDeepLinkNavigateToCollectionScreen(String str, String str2);

    void onDeepLinkNavigateToGemComponent(String str);

    void onDeepLinkNavigateToGlobalHelpCenter(String str, String str2);

    void onDeepLinkNavigateToHomeOfOffers();

    void onDeepLinkNavigateToPickupScreen();

    void onDeepLinkNavigateToSubscriptionScreen();

    void onDeepLinkNavigateToTproBenefits();

    void onDeepLinkNavigateToWalletDashBoard();

    void onRiderChatRedirection(String str);

    void showDarkstoresErrorMessage();
}
