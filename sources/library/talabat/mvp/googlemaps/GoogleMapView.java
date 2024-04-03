package library.talabat.mvp.googlemaps;

import JsonModels.Response.McdBlockAddressResponse;
import JsonModels.Response.McdStreetAddressResponse;
import android.content.Context;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.domain.address.Address;
import com.talabat.helpers.Talabat;
import java.util.List;

public interface GoogleMapView extends Talabat {
    void ProceedToOrder(int i11, String str);

    void animateCamera(LatLng latLng, float f11, int i11, float f12, int i12);

    void cameraAnimatorWithoutWaitPolygonValidation(LatLng latLng, int i11, int i12, float f11, int i13);

    boolean checkCurrentLocationInsideAreaPolygon(LatLng latLng);

    void drawAreaPolygon(List<LatLng> list);

    Context getContext();

    boolean gpsDeviceStatus();

    void locationMismatch(Address address);

    void locationMismatchValidateWithPlygon(Address address);

    void locationMismatchValidateWithResPlygon(Address address);

    void mapRotateSlowAnimationUtilPointingDecisionMaking(LatLng latLng, boolean z11, boolean z12, int i11, float f11, int i12);

    void mcdBlockFailed();

    void mcdDeliveryUnavaliable(String str, String str2, String str3);

    void mcdFlowHideSkip();

    void mcdServerError();

    void onAddressRecieved(Address address);

    void onAddressRecievedWithPorygon(Address address);

    void onGeoCordinatesUpdated(Address address);

    void polyGonLoaded(List<LatLng> list);

    void requestForCurrentLocation(boolean z11);

    void restaurantOutSideDeliveryZone(Address address);

    void showAddressNotSelectedPopup();

    void showMcdBlockSection(McdBlockAddressResponse mcdBlockAddressResponse, boolean z11);

    void showMcdStreetSelection(McdStreetAddressResponse mcdStreetAddressResponse);

    void updateButtonVisiblity(boolean z11, boolean z12);

    void updateResPoryGonAvailable(boolean z11);

    void updateUserSavedLocation(LatLng latLng);

    void updateValidationType(boolean z11);
}
