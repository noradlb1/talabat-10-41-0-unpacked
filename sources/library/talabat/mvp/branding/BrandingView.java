package library.talabat.mvp.branding;

import android.content.Context;
import com.talabat.domain.address.Address;
import com.talabat.helpers.Talabat;
import datamodels.Area;
import datamodels.City;
import datamodels.Restaurant;

public interface BrandingView extends Talabat {
    public static final int AREA_NOT_SELECTED = 15;
    public static final int BRAND_NOT_SELECTED = 25;
    public static final int CITY_NOT_SELECTED = 20;

    void branchVisibility(boolean z11);

    void cityVisibility(boolean z11);

    Context getContext();

    void gpsToAddressResultRecieved(String str, Address address, Area area, City city);

    void locationSelectionView(boolean z11);

    void mcdServerError();

    void navigateToFlutterMenu(int i11, String str, boolean z11);

    void onEmptyMenuReceived(String str);

    void onMigratedVendorLoaded(Restaurant restaurant);

    void onRedirectToAreaScreen();

    void onRedirectToCityScreen();

    void onRedirectToFranchiseScreen();

    void onRedirectToGroceryMenuPage();

    void onRedirectToMenuPage();

    void onRequestError();

    void onServerError();

    void onValidationError(int i11);

    void redirectFranchiseSelection(String str, int i11);

    void redirectoChooseSavedAddressScreen(Address address);

    void redirectoHomeMapScreen(boolean z11, String str, Boolean bool);

    void selectedAddressDeliverable(boolean z11);

    void selectedAreaDeliverable(boolean z11);

    void setArea(String str, boolean z11, boolean z12);

    void setBranch(String str);

    void setCity(String str);

    void setCuisines(String str);

    void setGpsVisibility(boolean z11);

    void setRestaurantFranchise(boolean z11);

    void setRestaurantLogo(String str);

    void setRestaurantName(String str);

    void showBrandNotDeliverHere(String str);

    void showInforMap(int i11, int i12, String str);

    void showMcdGoogleMap(int i11, String str, Address address, int i12);

    void showMenuWithGlrID(String str, Restaurant restaurant, int i11);

    void showMenuWithMcdStores(Restaurant restaurant, int i11, Address address);

    void showSelectedAreaNotDeliveringPopup(String str);

    void updateResGrpId(int i11);
}
