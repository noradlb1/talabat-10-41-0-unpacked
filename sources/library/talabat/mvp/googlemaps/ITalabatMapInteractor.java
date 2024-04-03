package library.talabat.mvp.googlemaps;

import JsonModels.Request.McdBranchRequest;
import JsonModels.Request.McdMapAddressRequest;
import com.google.android.gms.maps.model.LatLng;
import library.talabat.mvp.IGlobalInteractor;

public interface ITalabatMapInteractor extends IGlobalInteractor {
    void autoFillAddress(LatLng latLng);

    void autoFillAddressGeoUpdate(LatLng latLng);

    void fetchAreaPolygonJsonGeoCenterPoint(int i11, int i12, boolean z11);

    void fetchRestaurantPolygonJson(int i11, int i12, boolean z11);

    void getBranchIdFromBlock(McdBranchRequest mcdBranchRequest);

    void getBranchIdFromStreet(McdBranchRequest mcdBranchRequest);

    void getMcdBhBlockDetails(McdMapAddressRequest mcdMapAddressRequest);

    void getMcdLatLngAddressDetails(McdMapAddressRequest mcdMapAddressRequest);
}
