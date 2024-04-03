package library.talabat.mvp.addressV2;

import com.talabat.domain.address.Address;
import library.talabat.mvp.IGlobalPresenter;
import org.json.JSONObject;

public interface IAddressPresenter extends IGlobalPresenter {
    public static final int ADDRESSVIEWTYPE_QUICKORDER = 1;

    void addressFromMapRecieved(Address address, boolean z11, boolean z12, boolean z13);

    void addressTypeSelected(int i11);

    void areaButtonClicked();

    void autoFillAddress(double d11, double d12);

    void citySelected(int i11);

    void deleteCurrentAddress();

    void inValidateCityLocation(int i11);

    void invalidateAddressLocation(int i11);

    void isCheckLoadResPoryGon(boolean z11);

    void mapMapMarkerPoitingDecesionHandler(int i11);

    void onCreate();

    void onDeleteAddresNoClicked();

    void onDeleteAddresYesClicked();

    void onDeleteAddressBtnClicked();

    void onDeleteAddressPopUpShown();

    void onScreenStart(boolean z11);

    void setIsAddNewAddressFromGrl();

    void setIsFromInMcdFlow();

    void setMcdLoactionEdited(boolean z11);

    void setOrderFlowType(boolean z11);

    void setUpViews(Address address, boolean z11);

    void setUpViewsWithJson(JSONObject jSONObject, boolean z11);

    void setValidateArea(boolean z11);

    void setViewType(int i11);

    @Deprecated
    void showAddressConfiramtion(boolean z11);

    void showMapForSelection(boolean z11);

    void updateQuickOrderAddress();

    void validateAndAddAddress(boolean z11, boolean z12);
}
