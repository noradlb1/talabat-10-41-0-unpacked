package library.talabat.mvp.googlemaps;

import JsonModels.Request.McdBranchRequest;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.domain.address.Address;
import library.talabat.mvp.IGlobalPresenter;

public interface ITalabatMapPresenter extends IGlobalPresenter {
    void confirmButtonPressed(LatLng latLng, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15);

    void currentLocationReceived(LatLng latLng, String str);

    void getMcdBranchIdFromBlock(Address address, String str, McdBranchRequest mcdBranchRequest);

    void getMcdBranchIdFromStreet(Address address, String str, McdBranchRequest mcdBranchRequest);

    void getMcdConvertToAddress(int i11, int i12, String str, boolean z11, boolean z12, LatLng latLng);

    void mapCountryPolyGonLoaded();

    void mapLoadingCompleted();

    void mapMapMarkerPoitingDecesionHandler(int i11, int i12, boolean z11);

    void mapReady(boolean z11);

    void mapViewInitilise(int i11, boolean z11, boolean z12, int i12, boolean z13, boolean z14);

    void updateGeoCordinates(LatLng latLng, Address address, boolean z11, boolean z12, boolean z13);

    void updateRestaurantpolygonServiceEnabled();

    void userConfirmedTempLocation(String str);

    void waitForCurrentLocation(boolean z11);
}
