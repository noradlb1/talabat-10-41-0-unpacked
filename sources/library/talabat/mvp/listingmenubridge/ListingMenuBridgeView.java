package library.talabat.mvp.listingmenubridge;

import JsonModels.MenuItemsResponseModel;
import android.content.Context;
import com.talabat.domain.address.Address;
import com.talabat.helpers.Talabat;
import datamodels.Restaurant;

public interface ListingMenuBridgeView extends Talabat {
    void darkstoreError();

    void darkstoreSuccess(Restaurant restaurant, DarkstoresTrackingData darkstoresTrackingData);

    Context getContext();

    void mcdServerError();

    void navigateToFlutterMenu(int i11, String str, boolean z11);

    void onEmptyMenuReceived(String str);

    void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMigratedVendorInfoReceived(Restaurant restaurant, DarkstoresTrackingData darkstoresTrackingData);

    void onRequestError();

    void showAlert(int i11, String str, boolean z11);

    void showInforMap(int i11, String str);

    void showMcdGoogleMap(int i11, String str, Address address, int i12);

    void showMenuWithGlrID(String str, Restaurant restaurant, int i11);

    void showMenuWithMcdStores(Restaurant restaurant, int i11, Address address);

    void startLoadingPopup();
}
