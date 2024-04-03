package library.talabat.mvp.addressV2;

import android.content.Context;
import androidx.annotation.Nullable;
import com.talabat.domain.address.Address;
import com.talabat.helpers.Talabat;
import com.talabat.maps.domain.model.LatLng;
import datamodels.Area;

public interface AddressView extends Talabat {
    SaveAddressEventsOrigin addressFlowOrigin();

    void clearFocusFromAllInput();

    void compareBlockField(String str);

    void compareStreetField(String str);

    void geoPolygonCenterPointAvailable(boolean z11, LatLng latLng);

    int getAreaId();

    String getAreaName();

    int getCityId();

    Context getContext();

    boolean getCountryCodeCountryGcc();

    boolean getCountryCodeCountryType();

    String getDirections();

    String getFeild1();

    String getFeild2();

    String getFeild3();

    String getFeild4();

    String getFeild5();

    String getFeild6();

    String getFeild7();

    String getGRL();

    String getGRLId();

    LatLng getGeoCodinates();

    String getMobile();

    String getMobileDialCode();

    String getPhone();

    void locationMismatch(String str);

    void onAddressAddSuccess(Address address);

    void onAddressDeleteFailed(int i11, String str);

    void onAddressEditFailed(int i11, String str, Address address);

    void onAddressEditSuccess(Address address);

    void onAddressValidationError(int i11, int i12);

    void onAddressValidationError(int i11, String str);

    void onAddressesDeleted(String str);

    void onAreaReceived(Area[] areaArr);

    void onRedirectToAreaScreen();

    void onRedirectToMapScreen(@Nullable LatLng latLng, boolean z11, boolean z12);

    void onValidationSuccess();

    void setAddressTypeText(int i11);

    void setArea(String str, int i11);

    void setCity(String str, int i11);

    void setCount(int i11);

    void setDefaultCountryCode();

    void setDirections(String str);

    void setErrorFeild1(int i11);

    void setErrorFeild2(int i11);

    void setErrorFeild3(int i11);

    void setErrorFeild4(int i11);

    void setErrorFeild5(int i11);

    void setErrorFeild6(int i11);

    void setErrorFeild7(int i11);

    void setErrorMobileField(int i11);

    void setErrorPhnField(int i11);

    void setFeild1(String str, boolean z11, boolean z12);

    void setFeild1(boolean z11, String str, boolean z12, int i11, boolean z13);

    void setFeild2(String str, boolean z11, boolean z12, boolean z13);

    void setFeild2(boolean z11, String str, boolean z12, int i11, boolean z13);

    void setFeild3(String str, boolean z11, boolean z12);

    void setFeild3(boolean z11, String str, boolean z12, int i11, boolean z13);

    void setFeild4(String str, boolean z11, boolean z12);

    void setFeild4(boolean z11, String str, boolean z12, int i11, boolean z13);

    void setFeild5(String str, boolean z11, boolean z12);

    void setFeild5(boolean z11, String str, boolean z12, int i11, boolean z13);

    void setFeild6(String str, boolean z11, boolean z12);

    void setFeild6(boolean z11, String str, boolean z12, int i11, boolean z13);

    void setFeild7(String str, boolean z11, boolean z12);

    void setFeild7(boolean z11, String str, boolean z12, int i11, boolean z13);

    void setGRL(String str);

    void setGeoCodinates(@Nullable LatLng latLng);

    void setGoogleMapView(@Nullable LatLng latLng);

    void setGrlId(String str);

    void setMobile(String str, String str2);

    void setMobileCountryCode(String str);

    void setNonJsonFields(boolean z11);

    void setPhone(String str, String str2, boolean z11);

    void setSelectedAddressType(int i11);

    void setShowCity(boolean z11);

    @Deprecated
    void showConfirmAddressPopup();

    void showGenericErrorMessage();

    void switchAdditionalDirectionsToLandmark();

    void switchAddressTypeToBuildingType();

    void updatePolygonServiceEnabled(boolean z11);
}
