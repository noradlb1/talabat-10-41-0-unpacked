package library.talabat.mvp.addresslist;

import JsonModels.Request.DeliverAddressRequest;
import JsonModels.Request.McdBlockMapGrlUpdateRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Response.McdStoresResponse;
import android.content.Context;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.android.volley.VolleyError;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.Area;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;
import java.util.Arrays;

public class AddressListPresenter implements IAddressListPresenter {
    private AddressListView addressListView;
    private final ConfigurationLocalRepository configurationLocalRepository;
    boolean hideLoadingPopup = false;
    private IAddressListInteractor iAddressListInteractor;
    public boolean isForSelection;
    public boolean isLoadResDeliverableAddress;
    private final LocationConfigurationRepository locationConfigurationRepository;
    private Address selectedAddress;
    boolean shouldUsePolygon = false;

    public AddressListPresenter(AddressListView addressListView2, IAddressListInteractor iAddressListInteractor2, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository2) {
        this.addressListView = addressListView2;
        this.iAddressListInteractor = iAddressListInteractor2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    private boolean isPolygonServiceEnabledArea() {
        Cart instance = Cart.getInstance();
        if (instance.getRestaurant() != null && instance.getRestaurant().isTalabatGo) {
            for (Area next : this.locationConfigurationRepository.areas()) {
                if (next.getId() == GlobalDataModel.SelectedAreaId) {
                    this.shouldUsePolygon = next.isPolygonServiceEnabled();
                }
            }
        }
        return this.shouldUsePolygon;
    }

    public void deleteCurrentAddress(String str) {
        this.iAddressListInteractor.deleteAddress(str);
    }

    public void loadResBasedDeliverableAddress(Address[] addressArr) {
        this.addressListView.stopLodingPopup();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(addressArr));
        this.addressListView.onAddressListLoaded(arrayList, this.isForSelection, this.shouldUsePolygon);
    }

    public void mcdBranchFailed() {
        this.addressListView.mcdKsaAddressUpdateRequired(this.selectedAddress);
    }

    public void mcdBranchReceived(McdStoresResponse mcdStoresResponse) {
        if (mcdStoresResponse == null) {
            this.addressListView.mcdKsaAddressUpdateRequired(this.selectedAddress);
        } else if (mcdStoresResponse.result.statusCode != 0) {
            this.addressListView.mcdKsaAddressUpdateRequired(this.selectedAddress);
        } else if (mcdStoresResponse.tlbBranchId <= 0) {
        } else {
            if (Cart.getInstance().getRestaurant().branchId == mcdStoresResponse.tlbBranchId) {
                this.addressListView.mcdKsaAddressMatched(this.selectedAddress);
            } else {
                this.addressListView.mcdKsaAddressUpdateRequired(this.selectedAddress);
            }
        }
    }

    public void mcdLatLngStores(Address address, int i11) {
        this.selectedAddress = address;
        this.iAddressListInteractor.getMcdLatLngStoresCheck(new McdBranchRequest(address, i11));
    }

    public void onAddressDeleteFailed(int i11, String str) {
        this.addressListView.onAddressDeleteFailed(i11, str);
    }

    public void onAddressDeleted(String str) {
        this.addressListView.onAddressesDeleted(str);
    }

    public void onDataError() {
        this.addressListView.onDataError();
    }

    public void onDestroy() {
        this.addressListView = null;
        IAddressListInteractor iAddressListInteractor2 = this.iAddressListInteractor;
        if (iAddressListInteractor2 != null) {
            iAddressListInteractor2.unregister();
        }
        this.iAddressListInteractor = null;
    }

    public void onGrlUpdateIsRequired(Address address, String str, String str2) {
        Address address2 = address;
        String str3 = str;
        String str4 = address2.f58343id;
        int i11 = address2.areaId;
        String str5 = address2.areaName;
        String str6 = address2.block;
        String str7 = address2.buildingNo;
        int i12 = address2.cityId;
        int i13 = address2.countyId;
        String str8 = address2.countryName;
        String str9 = address2.extraDirections;
        String str10 = address2.floor;
        String str11 = address2.geoAddressMsg;
        String str12 = address2.geoAddressTitle;
        String str13 = str4;
        Address address3 = address2;
        int i14 = i11;
        Address address4 = address;
        this.iAddressListInteractor.updateAddress(address4.copy(str13, i14, str5, str6, str7, i12, i13, str8, str9, str10, str11, str12, str2, str3, address2.isAreaSplit, address3.isDeliverable, address3.isOldAddreses, address3.judda, address3.latitude, address3.longitude, address3.mobileNumber, address3.mobilNumberCountryCode, address3.phoneNumber, address3.profileName, address3.street, address3.suite, address3.type));
    }

    public void onNetworkError() {
        this.addressListView.onNetworkError();
    }

    public void onResponseError() {
        this.addressListView.stopLodingPopup();
    }

    public void onServerError(VolleyError volleyError) {
        this.addressListView.onServerError(volleyError);
    }

    public void selectAddress(Address address, Context context) {
        if (this.isForSelection) {
            Customer instance = Customer.getInstance();
            instance.setSelectedCustomerAddress(context, address.f58343id, address.areaId);
            if (instance.getBrandLocalAddress() != null && !TalabatUtils.isNullOrEmpty(address.f58343id) && !TalabatUtils.isNullOrEmpty(instance.getBrandLocalAddress().f58343id)) {
                if (!address.f58343id.equals(instance.getBrandLocalAddress().f58343id)) {
                    GlobalDataModel.GEO_CORDINATES.isRefreshBrandAddress = true;
                } else {
                    GlobalDataModel.GEO_CORDINATES.isRefreshBrandAddress = false;
                }
            }
            instance.setBrandScreenLocalAddress();
            return;
        }
        this.addressListView.onRedirectToEdit(address);
    }

    public void setUpViews() {
        Customer instance = Customer.getInstance();
        if (!instance.isLoggedIn()) {
            this.addressListView.onRedirectToLogin();
        } else if (!this.isForSelection) {
            this.addressListView.onAddressListLoaded(instance.getCustomerAddress(this.configurationLocalRepository.selectedCountry()), this.isForSelection, false);
        } else if (isPolygonServiceEnabledArea()) {
            if (!this.hideLoadingPopup) {
                this.addressListView.startLodingPopup();
            }
            this.hideLoadingPopup = false;
            this.iAddressListInteractor.getAddressBasedDeliveryArea(new DeliverAddressRequest(0, GlobalDataModel.SelectedCountryId, GlobalDataModel.RECENT_LATLONG.getLongitude(), GlobalDataModel.RECENT_LATLONG.getLatitude(), Cart.getInstance().getRestaurant().branchId));
        } else {
            this.addressListView.onAddressListLoaded(instance.getCustomerAddress(GlobalDataModel.SelectedAreaId), this.isForSelection, false);
        }
    }

    public void setUpViewsForAddressSelection(boolean z11) {
        this.isLoadResDeliverableAddress = z11;
        this.isForSelection = true;
        setUpViews();
    }

    public void setVisibilityLoadingPopup(boolean z11) {
        this.hideLoadingPopup = z11;
    }

    public void updateSelectedAddressGrl(String str, String str2, String str3) {
        McdBlockMapGrlUpdateRequest mcdBlockMapGrlUpdateRequest = new McdBlockMapGrlUpdateRequest(str2, str3, str);
        Customer.getInstance().updateAddressGrl(str, str2, str3);
        this.iAddressListInteractor.updateSelectedAddressGrl(mcdBlockMapGrlUpdateRequest);
    }
}
