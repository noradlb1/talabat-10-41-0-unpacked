package library.talabat.mvp.quickorder;

import JsonModels.parser.UniversalGson;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import buisnessmodels.Cart;
import buisnessmodels.McdMapTempAddress;
import com.android.volley.VolleyError;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.userandlocation.LatLngRefactorHelperKt;
import dagger.internal.Preconditions;
import datamodels.QuickOrderInfo;
import datamodels.QuickOrderUserInfo;
import library.talabat.mvp.addressV2.IAddressPresenter;
import library.talabat.mvp.addressV2.UserAddAddressScreenEventsListener;
import library.talabat.mvp.homemap.HomeMapTemp;
import org.json.JSONObject;

@Instrumented
public class QuickOrderPresenter implements IQuickOrderPresenter, QuickOrderListener {
    private IAddressPresenter addressPresenter;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private QuickOrderInfo info;
    private IQuickOrderInteractor interactor;
    private final LocationConfigurationRepository locationConfigurationRepository;
    private QuickOrderUserInfo quickOrderUserInfo;
    private QuickOrderView quickOrderView;
    @NonNull
    private final UserAddAddressScreenEventsListener userAddAddressScreenEventsListener;

    public QuickOrderPresenter(AppVersionProvider appVersionProvider, QuickOrderView quickOrderView2, OnQuickOrderValidated onQuickOrderValidated, @NonNull UserAddAddressScreenEventsListener userAddAddressScreenEventsListener2, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository2) {
        this.quickOrderView = quickOrderView2;
        this.userAddAddressScreenEventsListener = (UserAddAddressScreenEventsListener) Preconditions.checkNotNull(userAddAddressScreenEventsListener2);
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.interactor = new QuickOrderInteractor(appVersionProvider, this, onQuickOrderValidated);
    }

    private QuickOrderInfo getSavedQuickOrderAddressData() {
        Object obj;
        SharedPreferences sharedPreferences = this.quickOrderView.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!sharedPreferences.contains("" + GlobalDataModel.SelectedAreaId)) {
            return null;
        }
        try {
            String string = sharedPreferences.getString("" + GlobalDataModel.SelectedAreaId, "");
            Class cls = QuickOrderInfo.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(string, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, string, cls);
            }
            QuickOrderInfo quickOrderInfo = (QuickOrderInfo) obj;
            Address address = quickOrderInfo.address;
            String str = address.grl;
            address.grl = "";
            if (!TalabatUtils.isNullOrEmpty(str)) {
                Address address2 = quickOrderInfo.address;
                address2.grl = TalabatUtils.decodeFromBase64(address2.grl);
            }
            return quickOrderInfo;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private void saveQuickOrderAddressData(QuickOrderInfo quickOrderInfo) {
        String str;
        SharedPreferences.Editor edit = this.quickOrderView.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        Gson gson = UniversalGson.INSTANCE.gson;
        QuickOrderInfo copyForSaving = quickOrderInfo.copyForSaving();
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) copyForSaving);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) copyForSaving);
        }
        edit.putString(String.valueOf(GlobalDataModel.SelectedAreaId), str);
        edit.putString(String.valueOf(quickOrderInfo.address.areaId), str);
        edit.putString(GlobalConstants.PrefsConstants.FALLBACK_GUEST_ADDRESS, str);
        edit.apply();
    }

    private void saveQuickOrderUserData(QuickOrderUserInfo quickOrderUserInfo2) {
        String str;
        String str2;
        SharedPreferences.Editor edit = this.quickOrderView.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        Gson gson = UniversalGson.INSTANCE.gson;
        String str3 = "" + GlobalDataModel.quickOrderUserId;
        boolean z11 = gson instanceof Gson;
        if (!z11) {
            str = gson.toJson((Object) quickOrderUserInfo2);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) quickOrderUserInfo2);
        }
        edit.putString(str3, str);
        String str4 = "Sales_Froce" + GlobalDataModel.SelectedCountryId;
        if (!z11) {
            str2 = gson.toJson((Object) quickOrderUserInfo2);
        } else {
            str2 = GsonInstrumentation.toJson(gson, (Object) quickOrderUserInfo2);
        }
        edit.putString(str4, str2);
        edit.putInt("lastquickordercountryID", GlobalDataModel.SelectedCountryId);
        edit.apply();
    }

    private void trackAddressValidationError() {
        this.userAddAddressScreenEventsListener.onSaveAddressFormValidationError(this.quickOrderView, new Address(), false);
    }

    private void updateHomeTemp(Address address) {
        GlobalDataModel.SelectedAreaId = address.areaId;
        GlobalDataModel.SelectedAreaName = address.areaName;
        int i11 = address.cityId;
        GlobalDataModel.SelectedCityId = i11;
        GlobalDataModel.SelectedCityName = TalabatUtils.getCityName(i11, this.configurationLocalRepository, this.locationConfigurationRepository);
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        homeMapTemp.setHomeMapLatLng(LatLngRefactorHelperKt.toGoogleNullable(GlobalDataModel.GEO_CORDINATES.addressPageLatLang), this.quickOrderView.getContext());
        homeMapTemp.setHomeMapZoomeLevel(Float.valueOf(GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel));
        homeMapTemp.setTempAreaId(address.areaId);
        homeMapTemp.setStreetName(address.street);
        SharedPreferences.Editor edit = this.quickOrderView.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_LOCATION, "" + address.latitude + "," + address.longitude);
        edit.putFloat(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ZOOM, GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel);
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, address.areaId);
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_STREET_NAME, address.street);
        edit.apply();
    }

    private Address updatePrefAddressWithInforMap(Address address) {
        Address address2;
        if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            address2 = McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress();
        } else if (TalabatUtils.isMcdInforMapEnabledCountry()) {
            address2 = McdMapTempAddress.getInstance().getSelectedGrlTempAddress();
        } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
            address2 = McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress();
        } else {
            address2 = null;
        }
        if (address2 != null) {
            int i11 = address2.areaId;
            if (i11 > 0) {
                address.areaId = i11;
            }
            String str = address2.areaName;
            if (str != null && !TalabatUtils.isNullOrEmpty(str)) {
                address.areaName = address2.areaName;
            }
            int i12 = address2.cityId;
            if (i12 > 0) {
                address.cityId = i12;
            }
            String str2 = address2.block;
            if (str2 != null && !TalabatUtils.isNullOrEmpty(str2)) {
                address.block = address2.block;
            }
            String str3 = address2.street;
            if (str3 != null && !TalabatUtils.isNullOrEmpty(str3)) {
                address.street = address2.street;
            }
            String str4 = address2.buildingNo;
            if (str4 != null && !TalabatUtils.isNullOrEmpty(str4)) {
                address.buildingNo = address2.buildingNo;
            }
            if (!TalabatUtils.isNullOrEmpty(address2.grl)) {
                address.grl = address2.grl;
            }
            if (!TalabatUtils.isNullOrEmpty(address2.grlid)) {
                address.grlid = address2.grlid;
            }
        }
        return address;
    }

    public void addressValidated(Address address) {
        this.info = new QuickOrderInfo();
        this.quickOrderUserInfo = new QuickOrderUserInfo();
        this.info.firstName = this.quickOrderView.getFirstName();
        this.info.lastName = this.quickOrderView.getLastName();
        this.quickOrderUserInfo.firstName = this.quickOrderView.getFirstName();
        this.quickOrderUserInfo.lastName = this.quickOrderView.getLastName();
        this.quickOrderUserInfo.mobileNumber = this.quickOrderView.getMobile();
        this.quickOrderUserInfo.phoneNumber = this.quickOrderView.getPhone();
        this.quickOrderUserInfo.mobileNumberCountryCode = this.quickOrderView.getMobileDialCode();
        QuickOrderInfo quickOrderInfo = this.info;
        quickOrderInfo.address = address;
        saveQuickOrderAddressData(quickOrderInfo);
        saveQuickOrderUserData(this.quickOrderUserInfo);
        this.quickOrderView.startLodingPopup();
        this.interactor.validateAddress(address, this.quickOrderUserInfo);
    }

    public void continueQuickOrder(boolean z11) {
        boolean z12;
        String firstName = this.quickOrderView.getFirstName();
        String lastName = this.quickOrderView.getLastName();
        if (TalabatUtils.isNullOrEmpty(firstName)) {
            this.quickOrderView.setFirstNameError(0);
            z12 = false;
        } else {
            z12 = true;
        }
        if (TalabatUtils.isNullOrEmpty(lastName)) {
            this.quickOrderView.setLastNameError(0);
            z12 = false;
        }
        if (z12) {
            this.addressPresenter.validateAndAddAddress(false, false);
            return;
        }
        this.userAddAddressScreenEventsListener.onSaveAddressClicked(this.quickOrderView, new Address(), false);
        trackAddressValidationError();
    }

    public void onAddressValidationFailed(int i11, String str) {
        trackAddressValidationError();
        this.quickOrderView.stopLodingPopup();
        this.quickOrderView.onAddressValidationError(i11, str);
    }

    public void onAddressValidationSuccess(Address address) {
        this.userAddAddressScreenEventsListener.onSaveAddressSucceeded(this.quickOrderView, address, false);
        this.quickOrderView.stopLodingPopup();
        this.info = new QuickOrderInfo();
        this.quickOrderUserInfo = new QuickOrderUserInfo();
        this.info.firstName = this.quickOrderView.getFirstName();
        this.info.lastName = this.quickOrderView.getLastName();
        this.quickOrderUserInfo.firstName = this.quickOrderView.getFirstName();
        this.quickOrderUserInfo.lastName = this.quickOrderView.getLastName();
        QuickOrderUserInfo quickOrderUserInfo2 = this.quickOrderUserInfo;
        quickOrderUserInfo2.mobileNumber = address.mobileNumber;
        quickOrderUserInfo2.phoneNumber = this.quickOrderView.getPhone();
        this.quickOrderUserInfo.mobileNumberCountryCode = this.quickOrderView.getMobileDialCode();
        QuickOrderInfo quickOrderInfo = this.info;
        quickOrderInfo.address = address;
        saveQuickOrderAddressData(quickOrderInfo);
        saveQuickOrderUserData(this.quickOrderUserInfo);
        updateHomeTemp(address);
        this.quickOrderView.onRedirectToCheckout(this.info);
    }

    public void onDataError() {
        trackAddressValidationError();
        this.quickOrderView.onDataError();
    }

    public void onDestroy() {
        this.quickOrderView = null;
        IQuickOrderInteractor iQuickOrderInteractor = this.interactor;
        if (iQuickOrderInteractor != null) {
            iQuickOrderInteractor.unregister();
        }
        this.interactor = null;
    }

    public void onNetworkError() {
        trackAddressValidationError();
        this.quickOrderView.onNetworkError();
    }

    public void onServerError(VolleyError volleyError) {
        trackAddressValidationError();
        this.quickOrderView.onServerError(volleyError);
    }

    public void onUnexpectedError(Throwable th2) {
        trackAddressValidationError();
    }

    public void setUpQuickOrderView(JSONObject jSONObject, IAddressPresenter iAddressPresenter, String str, String str2, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.addressPresenter = iAddressPresenter;
        boolean z17 = true;
        iAddressPresenter.setOrderFlowType(true);
        if (jSONObject != null) {
            iAddressPresenter.setUpViewsWithJson(jSONObject, z14);
            return;
        }
        iAddressPresenter.setViewType(1);
        QuickOrderInfo savedQuickOrderAddressData = getSavedQuickOrderAddressData();
        this.quickOrderUserInfo = QuickOrderUserInfo.getSavedQuickOrderUserData(this.quickOrderView.getContext());
        if (savedQuickOrderAddressData == null) {
            Cart.getInstance().setCanShowLoyallyVoucherInCheckOut(true);
            Address address = null;
            if (z15) {
                if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                    if (McdMapTempAddress.getInstance().getSelectedGrlTempAddress() != null) {
                        address = McdMapTempAddress.getInstance().getSelectedGrlTempAddress();
                    }
                    iAddressPresenter.setUpViews(address, z14);
                } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    if (McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress() != null) {
                        address = McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress();
                    }
                    iAddressPresenter.setUpViews(address, z14);
                } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
                    if (McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress() != null) {
                        address = McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress();
                    }
                    iAddressPresenter.setUpViews(address, z14);
                }
            } else if (z11) {
                iAddressPresenter.setUpViews((Address) null, z14);
                if (TalabatUtils.isMapPackageEnabledCountry(this.configurationLocalRepository, this.locationConfigurationRepository) || (TalabatUtils.isPartiallyMapPackageEnabledCountry() && (z11 || z12))) {
                    this.quickOrderView.redirectToMap();
                }
            } else if (TalabatUtils.isMapPackageEnabledCountry(this.configurationLocalRepository, this.locationConfigurationRepository) || (TalabatUtils.isPartiallyMapPackageEnabledCountry() && (z11 || z12))) {
                this.quickOrderView.redirectToMap();
                iAddressPresenter.setUpViews((Address) null, z14);
            } else {
                iAddressPresenter.setUpViews((Address) null, z14);
            }
        } else if (z15) {
            iAddressPresenter.setUpViews(updatePrefAddressWithInforMap(savedQuickOrderAddressData.address), z14);
        } else if (z11) {
            Address address2 = savedQuickOrderAddressData.address;
            if (address2.latitude <= 0.0d || address2.longitude <= 0.0d) {
                this.quickOrderView.updateMapCompulsory(z11, z12, z13);
                iAddressPresenter.setUpViews(savedQuickOrderAddressData.address, z14);
                if (TalabatUtils.isMapPackageEnabledCountry(this.configurationLocalRepository, this.locationConfigurationRepository) || (TalabatUtils.isPartiallyMapPackageEnabledCountry() && (z11 || z12))) {
                    this.quickOrderView.redirectToMap();
                }
            } else {
                iAddressPresenter.setUpViews(address2, z14);
                if (z16) {
                    QuickOrderView quickOrderView2 = this.quickOrderView;
                    Address address3 = savedQuickOrderAddressData.address;
                    quickOrderView2.updateTemapLatLang(new LatLng(address3.latitude, address3.longitude));
                }
                this.quickOrderView.updateMapCompulsory(false, false, false);
            }
        } else if (TalabatUtils.isMapPackageEnabledCountry(this.configurationLocalRepository, this.locationConfigurationRepository) || (TalabatUtils.isPartiallyMapPackageEnabledCountry() && (z11 || z12))) {
            Address address4 = savedQuickOrderAddressData.address;
            if (address4.latitude <= 0.0d || address4.longitude <= 0.0d) {
                this.quickOrderView.updateMapCompulsory(z11, z12, z13);
                this.quickOrderView.redirectToMap();
                iAddressPresenter.setUpViews(savedQuickOrderAddressData.address, z14);
            } else {
                if (z16) {
                    QuickOrderView quickOrderView3 = this.quickOrderView;
                    Address address5 = savedQuickOrderAddressData.address;
                    quickOrderView3.updateTemapLatLang(new LatLng(address5.latitude, address5.longitude));
                }
                this.quickOrderView.updateMapCompulsory(z11, z12, z13);
                iAddressPresenter.setUpViews(savedQuickOrderAddressData.address, z14);
            }
        } else {
            iAddressPresenter.setUpViews(savedQuickOrderAddressData.address, z14);
        }
        QuickOrderUserInfo quickOrderUserInfo2 = this.quickOrderUserInfo;
        if (quickOrderUserInfo2 != null) {
            this.quickOrderView.setFirstName(quickOrderUserInfo2.firstName);
            this.quickOrderView.setLastName(this.quickOrderUserInfo.lastName);
            if (QuickOrderUserInfo.IsQuickOrderUSerinfoLastSelectedCountry(this.quickOrderView.getContext())) {
                QuickOrderUserInfo quickOrderUserInfo3 = this.quickOrderUserInfo;
                quickOrderUserInfo3.mobileNumber = "";
                quickOrderUserInfo3.phoneNumber = "";
            }
            if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.configurationLocalRepository, this.locationConfigurationRepository) && !this.quickOrderView.getCountryCodeCountryGcc()) {
                z17 = false;
            }
            this.quickOrderView.setMobile(this.quickOrderUserInfo.mobileNumber, "");
            this.quickOrderView.setPhone(this.quickOrderUserInfo.phoneNumber, "", z17);
        }
        this.quickOrderView.hideAddressName();
    }

    public void updateMobNoAfterVerification() {
        QuickOrderUserInfo savedQuickOrderUserData = QuickOrderUserInfo.getSavedQuickOrderUserData(this.quickOrderView.getContext());
        this.quickOrderUserInfo = savedQuickOrderUserData;
        this.quickOrderView.setMobile(savedQuickOrderUserData.mobileNumber, "");
    }
}
