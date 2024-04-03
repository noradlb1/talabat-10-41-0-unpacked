package library.talabat.mvp.addressV2;

import JsonModels.parser.UniversalGson;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.McdMapTempAddress;
import com.android.volley.VolleyError;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeTracer;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.security.CertificateUtil;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.domain.address.Address;
import com.talabat.domain.location.GeoCoordinate;
import com.talabat.domain.location.GeoCoordinateKt;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.userandlocation.LatLngRefactorHelperKt;
import dagger.internal.Preconditions;
import datamodels.Area;
import datamodels.Country;
import datamodels.mappers.AreaToOldAreaMapper;
import io.reactivex.Scheduler;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import library.talabat.mvp.homemap.HomeMapTemp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tracking.AppTracker;
import x00.m;

@Instrumented
public class AddressPresenter implements IAddressPresenter, AddressListener {
    private Address address;
    private String addressId;
    private IAddressInteractor addressInteractor;
    private final Function0<String> addressJsonProvider;
    private int addressType = 1;
    private AddressView addressView;
    private int addressViewType;
    private final AppVersionProvider appVersionProvider;
    private AreaToOldAreaMapper areaToOldAreaMapper;
    private Area[] areas;
    private JSONObject commonvalidationObject;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private JSONArray countryValidationObject;
    private final Country datamodelsCountry;
    boolean isAddNewAddressFromGRL;
    boolean isMcdFlowMapFlow;
    private boolean isMcdLocationEdited;
    private final LatLngFactory latLngFactory;
    private final MutableLocationConfigurationRepository locationConfigurationRepository;
    private Address oldAddress;
    private boolean redirectToAreaPage;
    private boolean shouldUsePolygon;
    private String tempCountryCode;
    private String tempMobile;
    private String tempPhone;
    @NonNull
    private final UserAddAddressScreenEventsListener userAddAddressScreenEventsListener;

    public static class AddressFields {
        public static int AREA = 200;
        public static int AVENUE = 3;
        public static int BLOCK = 0;
        public static int CITY = 150;
        public static int FLAT = 10;
        public static int FLATOFFICE = 11;
        public static int FLOOR = 16;
        public static int HOUSENAME = 7;
        public static int LANE = 4;
        public static int STREET = 2;
        public static int WAY = 5;
    }

    public static class AddressType {
        public static int BUILDING = 1;
        public static int HOUSE;
    }

    public static class ERRORMESSAGES {
        public static int EMPTY = 0;
        public static int EMPTY_AREA = 701;
        public static int EMPTY_CITY = 700;
    }

    public AddressPresenter(Context context, AddressView addressView2, CustomerAddressesRepository customerAddressesRepository, Scheduler scheduler, Scheduler scheduler2, AppVersionProvider appVersionProvider2, ConfigurationLocalRepository configurationLocalRepository2, MutableLocationConfigurationRepository mutableLocationConfigurationRepository, @NonNull UserAddAddressScreenEventsListener userAddAddressScreenEventsListener2, Function0<String> function0, ITalabatFeatureFlag iTalabatFeatureFlag, LatLngFactory latLngFactory2) {
        this.addressViewType = 0;
        this.addressId = null;
        this.isAddNewAddressFromGRL = false;
        this.isMcdFlowMapFlow = false;
        this.areaToOldAreaMapper = new AreaToOldAreaMapper();
        LatLngFactory latLngFactory3 = latLngFactory2;
        this.latLngFactory = latLngFactory3;
        LogManager.info("UiTestInvestigation: AddressPresenter contstructor invoked");
        this.addressJsonProvider = function0;
        this.addressView = addressView2;
        AppVersionProvider appVersionProvider3 = appVersionProvider2;
        this.appVersionProvider = appVersionProvider3;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = mutableLocationConfigurationRepository;
        this.addressInteractor = new AddressInteractor(this, customerAddressesRepository, scheduler, scheduler2, appVersionProvider3, configurationLocalRepository2, iTalabatFeatureFlag, mutableLocationConfigurationRepository, latLngFactory3);
        try {
            LogManager.info("UiTestInvestigation: AddressPresenter loading JSON Array");
            this.commonvalidationObject = new JSONArray(loadJSONFromAsset(context)).getJSONObject(configurationLocalRepository2.selectedCountry().getCountryId() - 1);
            LogManager.info("UiTestInvestigation: AddressPresenter JSON loading complete");
        } catch (Exception e11) {
            LogManager.info("UiTestInvestigation: AddressPresenter Exception: " + e11.getMessage());
            LogManager.logException(e11);
        }
        this.datamodelsCountry = TalabatUtils.getSelectedCountry(configurationLocalRepository2, mutableLocationConfigurationRepository);
        List<com.talabat.configuration.location.Area> areas2 = mutableLocationConfigurationRepository.areas();
        Area[] areaArr = new Area[areas2.size()];
        for (int i11 = 0; i11 < areas2.size(); i11++) {
            areaArr[i11] = this.areaToOldAreaMapper.apply(areas2.get(i11));
        }
        this.areas = areaArr;
        this.userAddAddressScreenEventsListener = (UserAddAddressScreenEventsListener) Preconditions.checkNotNull(userAddAddressScreenEventsListener2);
    }

    private boolean blockMatching(String str, String str2) {
        if (TalabatUtils.isNullOrEmpty(str) || TalabatUtils.isNullOrEmpty(str2) || str.equals(str2)) {
            return false;
        }
        return true;
    }

    private void changeAdditionalDirectionsHint() {
        if (this.configurationLocalRepository.selectedCountry() == com.talabat.configuration.country.Country.EGYPT || this.configurationLocalRepository.selectedCountry() == com.talabat.configuration.country.Country.IRAQ) {
            this.addressView.switchAdditionalDirectionsToLandmark();
            this.addressView.switchAddressTypeToBuildingType();
        }
    }

    private void clearCartChangeArea() {
        if (Customer.getInstance().getSelectedCustomerAddress() != null && Customer.getInstance().getSelectedCustomerAddress().f58343id.equals(this.address.f58343id)) {
            if (Customer.getInstance().getBrandLocalAddress() != null) {
                Customer.getInstance().resetBrandLocalAddress();
            }
            if (Cart.getInstance().hasItems()) {
                Cart.getInstance().clearCart(this.addressView.getContext());
            }
        }
    }

    private String getFieldName(JSONObject jSONObject) {
        try {
            if (GlobalDataModel.SelectedLanguage.equals(GlobalConstants.ARABIC)) {
                return jSONObject.getString("nameAr");
            }
            if (GlobalDataModel.SelectedLanguage.equals(GlobalConstants.KURDISH_SORANI)) {
                return jSONObject.getString("nameSo");
            }
            if (GlobalDataModel.SelectedLanguage.equals(GlobalConstants.KURDISH_BADINI)) {
                return jSONObject.getString("nameBa");
            }
            return jSONObject.getString("nameEn");
        } catch (JSONException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    private String getKey(JSONObject jSONObject) {
        try {
            return jSONObject.getString("key");
        } catch (Exception unused) {
            return "";
        }
    }

    private int getLimint(JSONObject jSONObject) {
        try {
            return Integer.parseInt(jSONObject.getString(RichContentLoadTimeTracer.MAX));
        } catch (Exception unused) {
            return 100;
        }
    }

    private boolean grlMatching(String str, String str2) {
        if (TalabatUtils.isNullOrEmpty(str) || TalabatUtils.isNullOrEmpty(str2) || !str.equals(str2)) {
            return false;
        }
        return true;
    }

    private boolean isFiledOptional(JSONObject jSONObject) {
        try {
            return jSONObject.getString("optional").equals("false");
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isNumeric(JSONObject jSONObject) {
        try {
            return !jSONObject.getString("numeric").equals("false");
        } catch (JSONException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    private boolean isPolygonServiceEnabledArea() {
        Cart instance = Cart.getInstance();
        if (instance.getRestaurant() != null && instance.getRestaurant().isTalabatGo) {
            for (com.talabat.configuration.location.Area next : this.locationConfigurationRepository.areas()) {
                if (next.getId() == GlobalDataModel.SelectedAreaId) {
                    this.shouldUsePolygon = next.isPolygonServiceEnabled();
                }
            }
        }
        return this.shouldUsePolygon;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$deleteCurrentAddress$0() {
        this.userAddAddressScreenEventsListener.onAddressDeleted(this.addressView, this.address);
        return Unit.INSTANCE;
    }

    private void setUpFields(int i11) {
        String str;
        if (i11 == 0) {
            str = "house";
        } else if (i11 == 1) {
            str = "building";
        } else {
            str = "office";
        }
        this.addressView.setSelectedAddressType(i11);
        try {
            JSONArray jSONArray = this.commonvalidationObject.getJSONArray(str);
            this.countryValidationObject = jSONArray;
            int length = jSONArray.length();
            this.addressView.setCount(length);
            if (length == 7) {
                JSONObject jSONObject = this.countryValidationObject.getJSONObject(0);
                this.addressView.setFeild1(true, getFieldName(jSONObject), isFiledOptional(jSONObject), getLimint(jSONObject), isNumeric(jSONObject));
                JSONObject jSONObject2 = this.countryValidationObject.getJSONObject(1);
                this.addressView.setFeild2(true, getFieldName(jSONObject2), isFiledOptional(jSONObject2), getLimint(jSONObject2), isNumeric(jSONObject2));
                JSONObject jSONObject3 = this.countryValidationObject.getJSONObject(2);
                this.addressView.setFeild3(true, getFieldName(jSONObject3), isFiledOptional(jSONObject3), getLimint(jSONObject3), isNumeric(jSONObject3));
                JSONObject jSONObject4 = this.countryValidationObject.getJSONObject(3);
                this.addressView.setFeild4(true, getFieldName(jSONObject4), isFiledOptional(jSONObject4), getLimint(jSONObject4), isNumeric(jSONObject4));
                JSONObject jSONObject5 = this.countryValidationObject.getJSONObject(4);
                this.addressView.setFeild5(true, getFieldName(jSONObject5), isFiledOptional(jSONObject5), getLimint(jSONObject5), isNumeric(jSONObject5));
                JSONObject jSONObject6 = this.countryValidationObject.getJSONObject(5);
                this.addressView.setFeild6(true, getFieldName(jSONObject6), isFiledOptional(jSONObject6), getLimint(jSONObject6), isNumeric(jSONObject6));
                JSONObject jSONObject7 = this.countryValidationObject.getJSONObject(6);
                this.addressView.setFeild7(true, getFieldName(jSONObject7), isFiledOptional(jSONObject7), getLimint(jSONObject7), isNumeric(jSONObject7));
            } else if (length == 6) {
                JSONObject jSONObject8 = this.countryValidationObject.getJSONObject(0);
                this.addressView.setFeild1(true, getFieldName(jSONObject8), isFiledOptional(jSONObject8), getLimint(jSONObject8), isNumeric(jSONObject8));
                JSONObject jSONObject9 = this.countryValidationObject.getJSONObject(1);
                this.addressView.setFeild2(true, getFieldName(jSONObject9), isFiledOptional(jSONObject9), getLimint(jSONObject9), isNumeric(jSONObject9));
                JSONObject jSONObject10 = this.countryValidationObject.getJSONObject(2);
                this.addressView.setFeild3(true, getFieldName(jSONObject10), isFiledOptional(jSONObject10), getLimint(jSONObject10), isNumeric(jSONObject10));
                JSONObject jSONObject11 = this.countryValidationObject.getJSONObject(3);
                this.addressView.setFeild4(true, getFieldName(jSONObject11), isFiledOptional(jSONObject11), getLimint(jSONObject11), isNumeric(jSONObject11));
                JSONObject jSONObject12 = this.countryValidationObject.getJSONObject(4);
                this.addressView.setFeild5(true, getFieldName(jSONObject12), isFiledOptional(jSONObject12), getLimint(jSONObject12), isNumeric(jSONObject12));
                JSONObject jSONObject13 = this.countryValidationObject.getJSONObject(5);
                this.addressView.setFeild6(true, getFieldName(jSONObject13), isFiledOptional(jSONObject13), getLimint(jSONObject13), isNumeric(jSONObject13));
                this.addressView.setFeild7(false, "", true, 0, false);
            } else if (length == 5) {
                JSONObject jSONObject14 = this.countryValidationObject.getJSONObject(0);
                this.addressView.setFeild1(true, getFieldName(jSONObject14), isFiledOptional(jSONObject14), getLimint(jSONObject14), isNumeric(jSONObject14));
                JSONObject jSONObject15 = this.countryValidationObject.getJSONObject(1);
                this.addressView.setFeild2(true, getFieldName(jSONObject15), isFiledOptional(jSONObject15), getLimint(jSONObject15), isNumeric(jSONObject15));
                JSONObject jSONObject16 = this.countryValidationObject.getJSONObject(2);
                this.addressView.setFeild3(true, getFieldName(jSONObject16), isFiledOptional(jSONObject16), getLimint(jSONObject16), isNumeric(jSONObject16));
                JSONObject jSONObject17 = this.countryValidationObject.getJSONObject(3);
                this.addressView.setFeild4(true, getFieldName(jSONObject17), isFiledOptional(jSONObject17), getLimint(jSONObject17), isNumeric(jSONObject17));
                JSONObject jSONObject18 = this.countryValidationObject.getJSONObject(4);
                this.addressView.setFeild5(true, getFieldName(jSONObject18), isFiledOptional(jSONObject18), getLimint(jSONObject18), isNumeric(jSONObject18));
                this.addressView.setFeild6(false, "", true, 0, false);
                this.addressView.setFeild7(false, "", true, 0, false);
            } else if (length == 4) {
                JSONObject jSONObject19 = this.countryValidationObject.getJSONObject(0);
                this.addressView.setFeild1(true, getFieldName(jSONObject19), isFiledOptional(jSONObject19), getLimint(jSONObject19), isNumeric(jSONObject19));
                JSONObject jSONObject20 = this.countryValidationObject.getJSONObject(1);
                this.addressView.setFeild2(true, getFieldName(jSONObject20), isFiledOptional(jSONObject20), getLimint(jSONObject20), isNumeric(jSONObject20));
                JSONObject jSONObject21 = this.countryValidationObject.getJSONObject(2);
                this.addressView.setFeild3(true, getFieldName(jSONObject21), isFiledOptional(jSONObject21), getLimint(jSONObject21), isNumeric(jSONObject21));
                JSONObject jSONObject22 = this.countryValidationObject.getJSONObject(3);
                this.addressView.setFeild4(true, getFieldName(jSONObject22), isFiledOptional(jSONObject22), getLimint(jSONObject22), isNumeric(jSONObject22));
                this.addressView.setFeild5(false, "", true, 0, false);
                this.addressView.setFeild6(false, "", true, 0, false);
                this.addressView.setFeild7(false, "", true, 0, false);
            } else if (length == 3) {
                JSONObject jSONObject23 = this.countryValidationObject.getJSONObject(0);
                this.addressView.setFeild1(true, getFieldName(jSONObject23), isFiledOptional(jSONObject23), getLimint(jSONObject23), isNumeric(jSONObject23));
                JSONObject jSONObject24 = this.countryValidationObject.getJSONObject(1);
                this.addressView.setFeild2(true, getFieldName(jSONObject24), isFiledOptional(jSONObject24), getLimint(jSONObject24), isNumeric(jSONObject24));
                JSONObject jSONObject25 = this.countryValidationObject.getJSONObject(2);
                this.addressView.setFeild3(true, getFieldName(jSONObject25), isFiledOptional(jSONObject25), getLimint(jSONObject25), isNumeric(jSONObject25));
                this.addressView.setFeild4(false, "", true, 0, false);
                this.addressView.setFeild5(false, "", true, 0, false);
                this.addressView.setFeild6(false, "", true, 0, false);
                this.addressView.setFeild7(false, "", true, 0, false);
            } else if (length == 2) {
                JSONObject jSONObject26 = this.countryValidationObject.getJSONObject(0);
                this.addressView.setFeild1(true, getFieldName(jSONObject26), isFiledOptional(jSONObject26), getLimint(jSONObject26), isNumeric(jSONObject26));
                JSONObject jSONObject27 = this.countryValidationObject.getJSONObject(1);
                this.addressView.setFeild2(true, getFieldName(jSONObject27), isFiledOptional(jSONObject27), getLimint(jSONObject27), isNumeric(jSONObject27));
                this.addressView.setFeild3(false, "", true, 0, false);
                this.addressView.setFeild4(false, "", true, 0, false);
                this.addressView.setFeild5(false, "", true, 0, false);
                this.addressView.setFeild6(false, "", true, 0, false);
                this.addressView.setFeild7(false, "", true, 0, false);
            } else if (length == 1) {
                JSONObject jSONObject28 = this.countryValidationObject.getJSONObject(0);
                this.addressView.setFeild1(true, getFieldName(jSONObject28), isFiledOptional(jSONObject28), getLimint(jSONObject28), isNumeric(jSONObject28));
                this.addressView.setFeild2(false, "", true, 0, false);
                this.addressView.setFeild3(false, "", true, 0, false);
                this.addressView.setFeild4(false, "", true, 0, false);
                this.addressView.setFeild5(false, "", true, 0, false);
                this.addressView.setFeild6(false, "", true, 0, false);
                this.addressView.setFeild7(false, "", true, 0, false);
            }
            if (this.addressViewType == 1) {
                this.addressView.setFeild1(false, "", true, 0, false);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    private void showAddressAddEditFailed(int i11, String str, Address address2) {
        this.addressView.onAddressEditFailed(i11, str, address2);
    }

    public void addressFromMapRecieved(Address address2, boolean z11, boolean z12, boolean z13) {
        if (address2 != null && !TalabatUtils.isNullOrEmpty(address2.areaName) && address2.areaId != 0) {
            AppTracker.onGeoLocationRecieved(this.addressView.getContext(), address2.areaId, true);
            if (!z11) {
                this.addressView.showConfirmAddressPopup();
            }
            this.addressType = address2.type;
            this.addressView.stopLodingPopup();
            if (this.address == null) {
                Address address3 = new Address();
                this.address = address3;
                address3.phoneNumber = this.addressView.getPhone();
                this.address.mobileNumber = this.addressView.getMobile();
                if (this.addressViewType != 1) {
                    this.address.profileName = this.addressView.getFeild1();
                } else {
                    this.address.profileName = "Appartment";
                }
            }
            Address address4 = this.address;
            if (address4 != null) {
                address4.latitude = address2.latitude;
                address4.longitude = address2.longitude;
                address4.type = address2.type;
                if (!TalabatUtils.isNullOrEmpty(address2.block)) {
                    this.address.block = address2.block;
                } else {
                    this.address.block = "";
                }
                if (!TalabatUtils.isNullOrEmpty(address2.buildingNo)) {
                    this.address.buildingNo = address2.buildingNo;
                }
                if (!TalabatUtils.isNullOrEmpty(address2.street)) {
                    this.address.street = address2.street;
                } else {
                    this.address.street = "";
                }
                if (!TalabatUtils.isNullOrEmpty(address2.extraDirections)) {
                    this.address.extraDirections = address2.extraDirections;
                } else {
                    this.address.extraDirections = "";
                }
                if (!TalabatUtils.isNullOrEmpty(address2.judda)) {
                    this.address.judda = address2.judda;
                }
                if (!TalabatUtils.isNullOrEmpty(address2.suite)) {
                    this.address.suite = address2.suite;
                }
                Address address5 = this.address;
                address5.areaId = address2.areaId;
                address5.areaName = address2.areaName;
                address5.cityId = address2.cityId;
                address5.countyId = address2.countyId;
                this.addressType = AddressType.BUILDING;
            } else {
                this.address = address2;
            }
            setUpViews(this.address, z13);
        }
    }

    public void addressTypeSelected(int i11) {
        this.addressType = i11;
        setUpFields(i11);
    }

    public void areaButtonClicked() {
        Area[] areaArr = this.areas;
        if (areaArr != null) {
            this.addressView.onAreaReceived(areaArr);
            this.addressView.onRedirectToAreaScreen();
            return;
        }
        this.redirectToAreaPage = true;
        this.addressView.startLodingPopup();
        this.addressInteractor.loadAreasForCountry(this.configurationLocalRepository.selectedCountry().getCountryId());
    }

    public void autoFillAddress(double d11, double d12) {
        this.addressInteractor.autoFillAddress(d11, d12);
    }

    public void citySelected(int i11) {
        this.addressInteractor.loadAreas(i11);
    }

    public void clearBlockOrAddressGRL(Address address2) {
        if (TalabatUtils.isMcdInforMapEnabledCountry()) {
            Address address3 = this.oldAddress;
            if (address3 != null && !TalabatUtils.isNullOrEmpty(address3.grl)) {
                if ((!TalabatUtils.isNullOrEmpty(this.oldAddress.street) && !address2.street.equals(this.oldAddress.street)) || (!TalabatUtils.isNullOrEmpty(this.oldAddress.buildingNo) && !address2.buildingNo.equals(this.oldAddress.buildingNo))) {
                    if (Cart.getInstance().hasItems() && Cart.getInstance().getRestaurant().isGlrEnabled && Customer.getInstance().getSelectedCustomerAddress() != null && Customer.getInstance().getSelectedCustomerAddress().f58343id.equals(address2.f58343id)) {
                        if (TalabatUtils.isNullOrEmpty(Customer.getInstance().getSelectedCustomerAddress().getGrlId()) || TalabatUtils.isNullOrEmpty(address2.getGrlId())) {
                            if (McdMapTempAddress.getInstance().getSelectedGrlTempAddress() != null && !TalabatUtils.isNullOrEmpty(McdMapTempAddress.getInstance().getSelectedGrlTempAddress().getGrlId()) && !TalabatUtils.isNullOrEmpty(address2.getGrlId())) {
                                Cart.getInstance().clearCart(this.addressView.getContext());
                            }
                        } else if (grlMatching(Customer.getInstance().getSelectedCustomerAddress().getGrlId(), address2.getGrlId())) {
                            Cart.getInstance().clearCart(this.addressView.getContext());
                        }
                    }
                    address2.grl = "";
                }
            }
        } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            Address address4 = this.oldAddress;
            if (address4 != null && !TalabatUtils.isNullOrEmpty(address4.block) && !TalabatUtils.isNullOrEmpty(this.oldAddress.block) && !address2.block.equals(this.oldAddress.block)) {
                if (Cart.getInstance().hasItems() && Cart.getInstance().getRestaurant().isGlrEnabled && Customer.getInstance().getSelectedCustomerAddress() != null && Customer.getInstance().getSelectedCustomerAddress().f58343id.equals(address2.f58343id)) {
                    if (TalabatUtils.isNullOrEmpty(Customer.getInstance().getSelectedCustomerAddress().block) || TalabatUtils.isNullOrEmpty(address2.block)) {
                        if (McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress() != null && !TalabatUtils.isNullOrEmpty(McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress().block) && !TalabatUtils.isNullOrEmpty(address2.block)) {
                            Cart.getInstance().clearCart(this.addressView.getContext());
                        }
                    } else if (blockMatching(Customer.getInstance().getSelectedCustomerAddress().block, address2.block)) {
                        Cart.getInstance().clearCart(this.addressView.getContext());
                    }
                }
                address2.grl = "";
                address2.grlid = "";
            }
        } else if (TalabatUtils.isMcdLatLngEnabledCountry() && this.oldAddress != null && Customer.getInstance().getSelectedCustomerAddress() != null && address2 != null && Customer.getInstance().getSelectedCustomerAddress().f58343id.equals(address2.f58343id)) {
            if (this.isMcdLocationEdited || !address2.street.equals(this.oldAddress.street)) {
                Cart.getInstance().clearCart(this.addressView.getContext());
            }
        }
    }

    public void deleteCurrentAddress() {
        this.addressInteractor.deleteAddress(this.addressId, new m(this));
    }

    @VisibleForTesting
    public Area[] getAreas() {
        return this.areas;
    }

    @VisibleForTesting
    public boolean getShouldUsePolygon() {
        return this.shouldUsePolygon;
    }

    public void inValidateCityLocation(int i11) {
        Address address2 = this.address;
        if (address2 != null) {
            address2.latitude = 0.0d;
            address2.longitude = 0.0d;
            this.addressView.setGeoCodinates((LatLng) null);
        }
    }

    public void invalidateAddressLocation(int i11) {
        Address address2 = this.address;
        if (address2 != null && address2.areaId != i11) {
            address2.latitude = 0.0d;
            address2.longitude = 0.0d;
            this.addressView.setGeoCodinates((LatLng) null);
        }
    }

    public void isCheckLoadResPoryGon(boolean z11) {
        if (z11) {
            isPolygonServiceEnabledArea();
        } else {
            this.shouldUsePolygon = false;
        }
        this.addressView.updatePolygonServiceEnabled(this.shouldUsePolygon);
    }

    public String loadJSONFromAsset(Context context) {
        try {
            InputStream open = context.getAssets().open(this.addressJsonProvider.invoke());
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return new String(bArr, "UTF-8");
        } catch (IOException e11) {
            LogManager.logException(e11);
            HashMap hashMap = new HashMap();
            hashMap.put("errorMessage", e11.getMessage());
            ObservabilityManager.trackUnExpectedScenario("AddressPresenterJSONParsing", hashMap);
            return null;
        }
    }

    public void mapMapMarkerPoitingDecesionHandler(int i11) {
        if (this.shouldUsePolygon) {
            this.addressInteractor.fetchRestaurantPolygonJson(i11, this.configurationLocalRepository.selectedCountry().getCountryId());
        } else if (i11 > 0) {
            this.addressInteractor.fetchAreaPolygonJson(i11, this.configurationLocalRepository.selectedCountry().getCountryId());
        } else {
            this.addressView.geoPolygonCenterPointAvailable(false, (LatLng) null);
        }
    }

    public void onAddressAddFailed(int i11, String str, Address address2) {
        this.userAddAddressScreenEventsListener.onSaveAddressApiValidationError(this.addressView, address2, false);
        showAddressAddEditFailed(i11, str, address2);
    }

    public void onAddressAddSuccess(Address address2) {
        this.userAddAddressScreenEventsListener.onSaveAddressSucceeded(this.addressView, address2, false);
        Customer.getInstance().AddCustomerAddress(address2);
        this.addressView.onAddressAddSuccess(address2);
    }

    public void onAddressDeleteFailed(int i11, String str) {
        this.addressView.onAddressDeleteFailed(i11, str);
    }

    public void onAddressDeleted(String str) {
        clearCartChangeArea();
        this.addressView.onAddressesDeleted(str);
    }

    public void onAddressEditFailed(int i11, String str, Address address2) {
        this.userAddAddressScreenEventsListener.onSaveAddressApiValidationError(this.addressView, address2, true);
        showAddressAddEditFailed(i11, str, address2);
    }

    public void onAddressEditSuccess(Address address2) {
        this.userAddAddressScreenEventsListener.onSaveAddressSucceeded(this.addressView, address2, true);
        Customer.getInstance().EditCustomerAddress(this.addressView.getContext(), address2);
        this.addressView.onAddressEditSuccess(address2);
    }

    public void onAddressMicroserviceError() {
        this.addressView.stopLodingPopup();
        this.addressView.showGenericErrorMessage();
    }

    public void onAreGeoPolyGonCoOrdinatesReceived(List<LatLng> list, String str, boolean z11) {
        LatLng latLng;
        if (!TalabatUtils.isNullOrEmpty(str)) {
            String[] split = str.split(",");
            latLng = this.latLngFactory.createLatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
        } else {
            latLng = null;
        }
        GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = z11;
        if (list != null) {
            List<com.google.android.gms.maps.model.LatLng> list2 = GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints;
            if (list2 != null && list2.size() > 0) {
                GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints.clear();
            }
            if (list.size() > 0) {
                GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = LatLngRefactorHelperKt.toGoogle((List<? extends LatLng>) list);
            }
        }
        if (latLng != null) {
            GlobalDataModel.GEO_CORDINATES.areaCenterPoint = LatLngRefactorHelperKt.toGoogle(latLng);
        }
    }

    public void onAreGeoPolyGonFailed(boolean z11) {
    }

    public void onAreaReceived(Area[] areaArr) {
        this.areas = areaArr;
        this.addressView.onAreaReceived(areaArr);
        if (this.redirectToAreaPage) {
            this.redirectToAreaPage = false;
            this.addressView.startLodingPopup();
            this.addressView.onRedirectToAreaScreen();
        }
    }

    public void onCreate() {
        changeAdditionalDirectionsHint();
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.EXPERIMENT_ADDRESS_NICKNAME_REORDER, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            this.addressView.clearFocusFromAllInput();
        }
    }

    public void onDataError() {
        this.addressView.onDataError();
    }

    public void onDeleteAddresNoClicked() {
        this.userAddAddressScreenEventsListener.onDeleteAddressPopUpClicked(this.addressView, this.address, false);
    }

    public void onDeleteAddresYesClicked() {
        this.userAddAddressScreenEventsListener.onDeleteAddressPopUpClicked(this.addressView, this.address, true);
    }

    public void onDeleteAddressBtnClicked() {
        this.userAddAddressScreenEventsListener.onAddressDeleteClicked(this.addressView, this.address);
    }

    public void onDeleteAddressPopUpShown() {
        this.userAddAddressScreenEventsListener.onDeleteAddressPopUpShown(this.addressView, this.address);
    }

    public void onDestroy() {
        this.addressView = null;
        IAddressInteractor iAddressInteractor = this.addressInteractor;
        if (iAddressInteractor != null) {
            iAddressInteractor.unregister();
        }
        this.addressInteractor = null;
    }

    public void onGeoAddressRecieved(Address address2) {
        AppTracker.onGeoLocationRecieved(this.addressView.getContext(), address2.areaId, true);
        if (address2.areaId != GlobalDataModel.SelectedAreaId) {
            this.addressView.locationMismatch(address2.areaName);
            return;
        }
        int i11 = AddressType.BUILDING;
        this.addressType = i11;
        address2.type = i11;
        this.addressView.stopLodingPopup();
        setUpViews(address2, false);
    }

    public void onNetworkError() {
        this.addressView.onNetworkError();
    }

    public void onScreenStart(boolean z11) {
        GeoCoordinate geoCoordinate;
        com.google.android.gms.maps.model.LatLng homeMapSavedLatLng = HomeMapTemp.INSTANCE.getHomeMapSavedLatLng();
        if (homeMapSavedLatLng != null) {
            geoCoordinate = GeoCoordinateKt.geo(homeMapSavedLatLng.latitude, homeMapSavedLatLng.longitude);
        } else {
            geoCoordinate = new GeoCoordinate(0.0d, 0.0d);
        }
        this.userAddAddressScreenEventsListener.onScreenLoaded(GlobalDataModel.SelectedCityId, GlobalDataModel.SelectedAreaId, geoCoordinate, this.addressView.addressFlowOrigin(), z11);
    }

    public void onServerError(VolleyError volleyError) {
        this.addressView.onServerError(volleyError);
    }

    public void setIsAddNewAddressFromGrl() {
        this.isAddNewAddressFromGRL = true;
    }

    public void setIsFromInMcdFlow() {
        this.isMcdFlowMapFlow = true;
    }

    public void setMcdLoactionEdited(boolean z11) {
        this.isMcdLocationEdited = z11;
    }

    public void setOrderFlowType(boolean z11) {
    }

    public void setUpViews(Address address2, boolean z11) {
        AddressPresenter addressPresenter;
        String str;
        Address address3 = address2;
        if (address3 != null) {
            String str2 = address3.f58343id;
            this.addressId = str2;
            if (this.oldAddress == null) {
                Address copy = address2.copy(str2, address3.areaId, address3.areaName, address3.block, address3.buildingNo, address3.cityId, address3.countyId, address3.countryName, address3.extraDirections, address3.floor, address3.geoAddressMsg, address3.geoAddressTitle, address3.grl, address3.grlid, address3.isAreaSplit, address3.isDeliverable, address3.isOldAddreses, address3.judda, address3.latitude, address3.longitude, address3.mobileNumber, address3.mobilNumberCountryCode, address3.phoneNumber, address3.profileName, address3.street, address3.suite, address3.type);
                addressPresenter = this;
                addressPresenter.oldAddress = copy;
            } else {
                addressPresenter = this;
            }
            Gson gson = UniversalGson.INSTANCE.gson;
            try {
                if (!(gson instanceof Gson)) {
                    str = gson.toJson((Object) address3);
                } else {
                    str = GsonInstrumentation.toJson(gson, (Object) address3);
                }
                addressPresenter.setUpViewsWithJson(new JSONObject(str), z11);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            this.addressView.setShowCity(false);
            setUpFields(1);
            if (GlobalDataModel.SelectedCityId > 0) {
                this.addressView.setCity(GlobalDataModel.SelectedCityName, GlobalDataModel.SelectedCityId);
            }
            if (GlobalDataModel.SelectedAreaId > 0) {
                this.addressView.setArea(GlobalDataModel.SelectedAreaName, GlobalDataModel.SelectedAreaId);
            }
            if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.configurationLocalRepository, this.locationConfigurationRepository)) {
                this.addressView.setDefaultCountryCode();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x033b A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0367 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0376 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03a1 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x03b0 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x03db A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x03ea A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0415 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0425 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x04ac A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x04ea A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0517 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0553 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x057e A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x058d A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x05b8 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x05c8 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x064d A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0689 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x06b5 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x06c4 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x06ef A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x06ff A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0786 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x07be A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x07ea A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0824 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x08a9 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x08b8 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x094c A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0951 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x095a A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x095f A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x098a A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x09af A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x09be A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x09c5 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x09d3 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x09f6 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x0a19 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x0a3c A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x0a41 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0118 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0a4a A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x0a51 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0a78 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x0a7d A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x0a8a A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x0aed  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0154 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0180 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x018f A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01ba A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01c9 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01f4 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0203 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x022e A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x023d A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0269 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0279 A[Catch:{ JSONException -> 0x0aef }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02ff A[Catch:{ JSONException -> 0x0aef }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setUpViewsWithJson(org.json.JSONObject r34, boolean r35) {
        /*
            r33 = this;
            r1 = r33
            r2 = r34
            r3 = r35
            java.lang.String r4 = "ltd"
            java.lang.String r5 = "+"
            java.lang.String r6 = "grlid"
            java.lang.String r7 = "grl"
            java.lang.String r8 = "extra"
            java.lang.String r9 = "eid"
            java.lang.String r10 = "an"
            java.lang.String r11 = "aid"
            java.lang.String r12 = "type"
            java.lang.String r13 = "exd"
            java.lang.String r14 = "ph"
            java.lang.String r15 = "mob"
            r16 = r4
            java.lang.String r4 = "ccd"
            r17 = r13
            int r13 = r2.getInt(r12)     // Catch:{ JSONException -> 0x0aef }
            r1.addressType = r13     // Catch:{ JSONException -> 0x0aef }
            r18 = r14
            r14 = 1
            if (r13 != 0) goto L_0x0034
            java.lang.String r19 = "house"
        L_0x0031:
            r14 = r19
            goto L_0x003c
        L_0x0034:
            if (r13 != r14) goto L_0x0039
            java.lang.String r19 = "building"
            goto L_0x0031
        L_0x0039:
            java.lang.String r19 = "office"
            goto L_0x0031
        L_0x003c:
            r1.setUpFields(r13)     // Catch:{ JSONException -> 0x0aef }
            library.talabat.mvp.addressV2.AddressView r13 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r19 = r15
            int r15 = r1.addressType     // Catch:{ JSONException -> 0x0aef }
            r13.setAddressTypeText(r15)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r13 = "cid"
            int r13 = r2.getInt(r13)     // Catch:{ JSONException -> 0x0aef }
            int r15 = r2.getInt(r11)     // Catch:{ JSONException -> 0x0aef }
            r21 = r5
            java.lang.String r5 = r2.getString(r10)     // Catch:{ JSONException -> 0x0aef }
            boolean r22 = r2.has(r9)     // Catch:{ JSONException -> 0x0aef }
            r23 = r4
            java.lang.String r4 = ""
            if (r22 == 0) goto L_0x0067
            java.lang.String r9 = r2.getString(r9)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0068
        L_0x0067:
            r9 = r4
        L_0x0068:
            r1.addressId = r9     // Catch:{ JSONException -> 0x0aef }
            boolean r9 = r2.has(r8)     // Catch:{ JSONException -> 0x0aef }
            r22 = r6
            if (r9 == 0) goto L_0x007d
            org.json.JSONObject r8 = r2.getJSONObject(r8)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r9 = "igb"
            boolean r8 = r8.getBoolean(r9)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x007e
        L_0x007d:
            r8 = 0
        L_0x007e:
            library.talabat.mvp.addressV2.AddressView r9 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            datamodels.Country r6 = r1.datamodelsCountry     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r6.isCityInAddress     // Catch:{ JSONException -> 0x0aef }
            r9.setShowCity(r6)     // Catch:{ JSONException -> 0x0aef }
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            com.talabat.configuration.ConfigurationLocalRepository r9 = r1.configurationLocalRepository     // Catch:{ JSONException -> 0x0aef }
            r25 = r7
            com.talabat.configuration.MutableLocationConfigurationRepository r7 = r1.locationConfigurationRepository     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = com.talabat.helpers.TalabatUtils.getCityName(r13, r9, r7)     // Catch:{ JSONException -> 0x0aef }
            r6.setCity(r7, r13)     // Catch:{ JSONException -> 0x0aef }
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6.setArea(r5, r15)     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r1.commonvalidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONArray r5 = r5.getJSONArray(r14)     // Catch:{ JSONException -> 0x0aef }
            r1.countryValidationObject = r5     // Catch:{ JSONException -> 0x0aef }
            int r5 = r5.length()     // Catch:{ JSONException -> 0x0aef }
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6.setCount(r5)     // Catch:{ JSONException -> 0x0aef }
            r6 = 7
            r9 = 5
            r13 = 4
            r14 = 3
            r15 = 2
            if (r5 != r6) goto L_0x0297
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            org.json.JSONObject r5 = r5.getJSONObject(r6)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x00ec
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x00e1
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild1(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x00fc
        L_0x00e1:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild1(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x00fc
        L_0x00ec:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x00fe
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild1(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x00fc:
            r7 = 1
            goto L_0x0108
        L_0x00fe:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild1(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x0108:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r7)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x0154
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x0145
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r2.getString(r7)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0140
            r5 = 1
            goto L_0x0141
        L_0x0140:
            r5 = 0
        L_0x0141:
            r6.setFeild2(r7, r5, r3, r8)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0170
        L_0x0145:
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild2(r5, r7, r3, r8)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0170
        L_0x0154:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0166
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            r7 = 1
            r5.setFeild2(r4, r7, r3, r6)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0170
        L_0x0166:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild2()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild2(r6, r7, r3, r8)     // Catch:{ JSONException -> 0x0aef }
        L_0x0170:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r15)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x018f
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild3(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x01aa
        L_0x018f:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x01a0
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild3(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x01aa
        L_0x01a0:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild3()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild3(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x01aa:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r14)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x01c9
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild4(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x01e4
        L_0x01c9:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x01da
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild4(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x01e4
        L_0x01da:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild4()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild4(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x01e4:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r13)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x0203
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild5(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x021e
        L_0x0203:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0214
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild5(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x021e
        L_0x0214:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild5()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild5(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x021e:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r9)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x023d
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild6(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0258
        L_0x023d:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x024e
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild6(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0258
        L_0x024e:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild6()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild6(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x0258:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            r6 = 6
            org.json.JSONObject r5 = r5.getJSONObject(r6)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x0279
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild7(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x0279:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x028b
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild7(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x028b:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild7()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild7(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x0297:
            r6 = 6
            if (r5 != r6) goto L_0x0443
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            org.json.JSONObject r5 = r5.getJSONObject(r6)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x02d3
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x02c8
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild1(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x02e3
        L_0x02c8:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild1(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x02e3
        L_0x02d3:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x02e5
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild1(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x02e3:
            r7 = 1
            goto L_0x02ef
        L_0x02e5:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild1(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x02ef:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r7)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x033b
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x032c
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r2.getString(r7)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0327
            r5 = 1
            goto L_0x0328
        L_0x0327:
            r5 = 0
        L_0x0328:
            r6.setFeild2(r7, r5, r3, r8)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0357
        L_0x032c:
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild2(r5, r7, r3, r8)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0357
        L_0x033b:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x034d
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            r7 = 1
            r5.setFeild2(r4, r7, r3, r6)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0357
        L_0x034d:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild2()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild2(r6, r7, r3, r8)     // Catch:{ JSONException -> 0x0aef }
        L_0x0357:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r15)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x0376
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild3(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0391
        L_0x0376:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0387
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            r5.setFeild3(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0391
        L_0x0387:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild3()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild3(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x0391:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r14)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x03b0
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild4(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x03cb
        L_0x03b0:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x03c1
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild4(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x03cb
        L_0x03c1:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild4()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild4(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x03cb:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r13)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x03ea
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild5(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0405
        L_0x03ea:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x03fb
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            r5.setFeild5(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0405
        L_0x03fb:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild5()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild5(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x0405:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r9)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x0425
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild6(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x0425:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0437
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild6(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x0437:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild6()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild6(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x0443:
            if (r5 != r9) goto L_0x05e6
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            org.json.JSONObject r5 = r5.getJSONObject(r6)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x0480
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x0474
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 0
            r8 = 1
            r6.setFeild1(r5, r8, r7)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0490
        L_0x0474:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 0
            r8 = 1
            r5.setFeild1(r6, r8, r7)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0490
        L_0x0480:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0492
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild1(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x0490:
            r7 = 1
            goto L_0x049c
        L_0x0492:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild1(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x049c:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r7)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x04ea
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x04da
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r2.getString(r7)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x04d4
            r5 = 1
            goto L_0x04d5
        L_0x04d4:
            r5 = 0
        L_0x04d5:
            r8 = 0
            r6.setFeild2(r7, r5, r3, r8)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0507
        L_0x04da:
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 0
            r8 = 1
            r6.setFeild2(r5, r8, r3, r7)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0507
        L_0x04ea:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x04fc
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            r7 = 1
            r5.setFeild2(r4, r7, r3, r6)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0507
        L_0x04fc:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild2()     // Catch:{ JSONException -> 0x0aef }
            r7 = 0
            r8 = 1
            r5.setFeild2(r6, r8, r3, r7)     // Catch:{ JSONException -> 0x0aef }
        L_0x0507:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r15)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x0553
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x0544
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r2.getString(r7)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x053f
            r5 = 1
            goto L_0x0540
        L_0x053f:
            r5 = 0
        L_0x0540:
            r6.setFeild3(r7, r5, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x056e
        L_0x0544:
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild3(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x056e
        L_0x0553:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0564
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild3(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x056e
        L_0x0564:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild3()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild3(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x056e:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r14)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x058d
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild4(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x05a8
        L_0x058d:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x059e
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild4(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x05a8
        L_0x059e:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild4()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild4(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x05a8:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r13)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x05c8
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild5(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x05c8:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x05da
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild5(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x05da:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild5()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild5(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x05e6:
            if (r5 != r13) goto L_0x071d
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            org.json.JSONObject r5 = r5.getJSONObject(r6)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x0621
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x0616
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild1(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0631
        L_0x0616:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild1(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0631
        L_0x0621:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0633
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild1(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x0631:
            r7 = 1
            goto L_0x063d
        L_0x0633:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild1(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x063d:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r7)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x0689
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x067a
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r2.getString(r7)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0675
            r5 = 1
            goto L_0x0676
        L_0x0675:
            r5 = 0
        L_0x0676:
            r6.setFeild2(r7, r5, r3, r8)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x06a5
        L_0x067a:
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild2(r5, r7, r3, r8)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x06a5
        L_0x0689:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x069b
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            r7 = 1
            r5.setFeild2(r4, r7, r3, r6)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x06a5
        L_0x069b:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild2()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild2(r6, r7, r3, r8)     // Catch:{ JSONException -> 0x0aef }
        L_0x06a5:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r15)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x06c4
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild3(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x06df
        L_0x06c4:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x06d5
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild3(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x06df
        L_0x06d5:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild3()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild3(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x06df:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r14)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x06ff
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild4(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x06ff:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0711
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild4(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x0711:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild4()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild4(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x071d:
            if (r5 != r14) goto L_0x0842
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            org.json.JSONObject r5 = r5.getJSONObject(r6)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x075a
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x074e
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 0
            r9 = 1
            r6.setFeild1(r5, r9, r7)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x076a
        L_0x074e:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 0
            r9 = 1
            r5.setFeild1(r6, r9, r7)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x076a
        L_0x075a:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x076c
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild1(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x076a:
            r7 = 1
            goto L_0x0776
        L_0x076c:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild1(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x0776:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r7)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x07be
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x07b3
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r2.getString(r7)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x07ae
            r5 = 1
            goto L_0x07af
        L_0x07ae:
            r5 = 0
        L_0x07af:
            r6.setFeild2(r7, r5, r3, r8)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x07da
        L_0x07b3:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild2()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild1(r6, r7, r8)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x07da
        L_0x07be:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x07d0
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            r7 = 1
            r5.setFeild2(r4, r7, r3, r6)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x07da
        L_0x07d0:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild2()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild2(r6, r7, r3, r8)     // Catch:{ JSONException -> 0x0aef }
        L_0x07da:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r15)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x0824
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x0818
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r2.getString(r7)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0812
            r5 = 1
            goto L_0x0813
        L_0x0812:
            r5 = 0
        L_0x0813:
            r6.setFeild3(r7, r5, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x0818:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild3()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild3(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x0824:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0836
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            r5.setFeild3(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x0836:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild3()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild3(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x0842:
            if (r5 != r15) goto L_0x08d4
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            org.json.JSONObject r5 = r5.getJSONObject(r6)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x087d
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x0872
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild1(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x088d
        L_0x0872:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild1(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x088d
        L_0x087d:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x088f
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            r5.setFeild1(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x088d:
            r7 = 1
            goto L_0x0899
        L_0x088f:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild1(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x0899:
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            org.json.JSONObject r5 = r5.getJSONObject(r7)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x08b8
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild2(r5, r7, r3, r8)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x08b8:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x08c9
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            r5.setFeild2(r4, r6, r3, r6)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x08c9:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild2()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild2(r6, r7, r3, r8)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x08d4:
            r6 = 1
            if (r5 != r6) goto L_0x092d
            org.json.JSONArray r5 = r1.countryValidationObject     // Catch:{ JSONException -> 0x0aef }
            r6 = 0
            org.json.JSONObject r5 = r5.getJSONObject(r6)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = r2.has(r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x0910
            java.lang.String r6 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0aef }
            boolean r6 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)     // Catch:{ JSONException -> 0x0aef }
            if (r6 != 0) goto L_0x0905
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r6.setFeild1(r5, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x0905:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild1(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0920
        L_0x0910:
            java.lang.String r5 = r1.getKey(r5)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = r1.shouldDiscardOldValue(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0922
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6 = 1
            r5.setFeild1(r4, r6, r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x0920:
            r7 = 1
            goto L_0x092e
        L_0x0922:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r5.getFeild1()     // Catch:{ JSONException -> 0x0aef }
            r7 = 1
            r5.setFeild1(r6, r7, r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x092e
        L_0x092d:
            r7 = r6
        L_0x092e:
            library.talabat.mvp.addressV2.AddressView r3 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r2.getString(r10)     // Catch:{ JSONException -> 0x0aef }
            int r6 = r2.getInt(r11)     // Catch:{ JSONException -> 0x0aef }
            r3.setArea(r5, r6)     // Catch:{ JSONException -> 0x0aef }
            library.talabat.mvp.addressV2.AddressView r3 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            int r5 = r2.getInt(r12)     // Catch:{ JSONException -> 0x0aef }
            r3.setSelectedAddressType(r5)     // Catch:{ JSONException -> 0x0aef }
            r3 = r25
            boolean r5 = r2.has(r3)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0951
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0952
        L_0x0951:
            r3 = r4
        L_0x0952:
            r5 = r22
            boolean r6 = r2.has(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r6 == 0) goto L_0x095f
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0960
        L_0x095f:
            r5 = r4
        L_0x0960:
            library.talabat.mvp.addressV2.AddressView r6 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r6.setGRL(r3)     // Catch:{ JSONException -> 0x0aef }
            library.talabat.mvp.addressV2.AddressView r3 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r3.setGrlId(r5)     // Catch:{ JSONException -> 0x0aef }
            r3 = r23
            boolean r5 = r2.has(r3)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0982
            java.lang.String r5 = r2.getString(r3)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 != 0) goto L_0x0982
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x0aef }
            r1.tempCountryCode = r3     // Catch:{ JSONException -> 0x0aef }
        L_0x0982:
            java.lang.String r3 = r1.tempCountryCode     // Catch:{ JSONException -> 0x0aef }
            boolean r3 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r3)     // Catch:{ JSONException -> 0x0aef }
            if (r3 != 0) goto L_0x09af
            java.lang.String r3 = r1.tempCountryCode     // Catch:{ JSONException -> 0x0aef }
            r5 = r21
            boolean r3 = r3.contains(r5)     // Catch:{ JSONException -> 0x0aef }
            if (r3 != 0) goto L_0x09a7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0aef }
            r3.<init>()     // Catch:{ JSONException -> 0x0aef }
            r3.append(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.tempCountryCode     // Catch:{ JSONException -> 0x0aef }
            r3.append(r5)     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0aef }
            r1.tempCountryCode = r3     // Catch:{ JSONException -> 0x0aef }
        L_0x09a7:
            library.talabat.mvp.addressV2.AddressView r3 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.tempCountryCode     // Catch:{ JSONException -> 0x0aef }
            r3.setMobileCountryCode(r5)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x09b4
        L_0x09af:
            library.talabat.mvp.addressV2.AddressView r3 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r3.setDefaultCountryCode()     // Catch:{ JSONException -> 0x0aef }
        L_0x09b4:
            com.talabat.configuration.ConfigurationLocalRepository r3 = r1.configurationLocalRepository     // Catch:{ JSONException -> 0x0aef }
            com.talabat.configuration.MutableLocationConfigurationRepository r5 = r1.locationConfigurationRepository     // Catch:{ JSONException -> 0x0aef }
            boolean r3 = com.talabat.helpers.TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(r3, r5)     // Catch:{ JSONException -> 0x0aef }
            if (r3 == 0) goto L_0x09c5
            library.talabat.mvp.addressV2.AddressView r3 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            boolean r14 = r3.getCountryCodeCountryGcc()     // Catch:{ JSONException -> 0x0aef }
            goto L_0x09c6
        L_0x09c5:
            r14 = r7
        L_0x09c6:
            library.talabat.mvp.addressV2.AddressView r3 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r3.setNonJsonFields(r14)     // Catch:{ JSONException -> 0x0aef }
            r3 = r19
            boolean r5 = r2.has(r3)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x09ee
            java.lang.String r5 = r2.getString(r3)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x09e5
            library.talabat.mvp.addressV2.AddressView r3 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.tempMobile     // Catch:{ JSONException -> 0x0aef }
            r3.setMobile(r5, r4)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x09ee
        L_0x09e5:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x0aef }
            r5.setMobile(r3, r4)     // Catch:{ JSONException -> 0x0aef }
        L_0x09ee:
            r3 = r18
            boolean r5 = r2.has(r3)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0a11
            java.lang.String r5 = r2.getString(r3)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0a08
            library.talabat.mvp.addressV2.AddressView r3 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r5 = r1.tempPhone     // Catch:{ JSONException -> 0x0aef }
            r3.setPhone(r5, r4, r14)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0a11
        L_0x0a08:
            library.talabat.mvp.addressV2.AddressView r5 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x0aef }
            r5.setPhone(r3, r4, r14)     // Catch:{ JSONException -> 0x0aef }
        L_0x0a11:
            r3 = r17
            boolean r5 = r2.has(r3)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0a32
            java.lang.String r5 = r2.getString(r3)     // Catch:{ JSONException -> 0x0aef }
            boolean r5 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r5)     // Catch:{ JSONException -> 0x0aef }
            if (r5 == 0) goto L_0x0a29
            library.talabat.mvp.addressV2.AddressView r3 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r3.setDirections(r4)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0a32
        L_0x0a29:
            library.talabat.mvp.addressV2.AddressView r4 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x0aef }
            r4.setDirections(r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x0a32:
            r3 = r16
            boolean r4 = r2.has(r3)     // Catch:{ JSONException -> 0x0aef }
            r5 = 0
            if (r4 == 0) goto L_0x0a41
            double r3 = r2.getDouble(r3)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0a42
        L_0x0a41:
            r3 = r5
        L_0x0a42:
            java.lang.String r7 = "lngt"
            boolean r7 = r2.has(r7)     // Catch:{ JSONException -> 0x0aef }
            if (r7 == 0) goto L_0x0a51
            java.lang.String r7 = "lngt"
            double r7 = r2.getDouble(r7)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0a52
        L_0x0a51:
            r7 = r5
        L_0x0a52:
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x0a6a
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x0a6a
            com.talabat.maps.domain.LatLngFactory r5 = r1.latLngFactory     // Catch:{ JSONException -> 0x0aef }
            com.talabat.maps.domain.model.LatLng r3 = r5.createLatLng(r3, r7)     // Catch:{ JSONException -> 0x0aef }
            library.talabat.mvp.addressV2.AddressView r4 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r4.setGeoCodinates(r3)     // Catch:{ JSONException -> 0x0aef }
            library.talabat.mvp.addressV2.AddressView r4 = r1.addressView     // Catch:{ JSONException -> 0x0aef }
            r4.setGoogleMapView(r3)     // Catch:{ JSONException -> 0x0aef }
        L_0x0a6a:
            JsonModels.parser.UniversalGson r3 = JsonModels.parser.UniversalGson.INSTANCE     // Catch:{ JSONException -> 0x0aef }
            com.google.gson.Gson r3 = r3.gson     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r2 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r34)     // Catch:{ JSONException -> 0x0aef }
            java.lang.Class<com.talabat.domain.address.Address> r4 = com.talabat.domain.address.Address.class
            boolean r5 = r3 instanceof com.google.gson.Gson     // Catch:{ JSONException -> 0x0aef }
            if (r5 != 0) goto L_0x0a7d
            java.lang.Object r2 = r3.fromJson((java.lang.String) r2, r4)     // Catch:{ JSONException -> 0x0aef }
            goto L_0x0a81
        L_0x0a7d:
            java.lang.Object r2 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r3, (java.lang.String) r2, r4)     // Catch:{ JSONException -> 0x0aef }
        L_0x0a81:
            r3 = r2
            com.talabat.domain.address.Address r3 = (com.talabat.domain.address.Address) r3     // Catch:{ JSONException -> 0x0aef }
            r1.address = r3     // Catch:{ JSONException -> 0x0aef }
            com.talabat.domain.address.Address r2 = r1.oldAddress     // Catch:{ JSONException -> 0x0aef }
            if (r2 != 0) goto L_0x0aed
            java.lang.String r4 = r3.f58343id     // Catch:{ JSONException -> 0x0aef }
            int r5 = r3.areaId     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r6 = r3.areaName     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r7 = r3.block     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r8 = r3.buildingNo     // Catch:{ JSONException -> 0x0aef }
            int r9 = r3.cityId     // Catch:{ JSONException -> 0x0aef }
            int r10 = r3.countyId     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r11 = r3.countryName     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r12 = r3.extraDirections     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r13 = r3.floor     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r14 = r3.geoAddressMsg     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r15 = r3.geoAddressTitle     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r2 = r3.grl     // Catch:{ JSONException -> 0x0aef }
            java.lang.String r1 = r3.grlid     // Catch:{ JSONException -> 0x0ae9 }
            r17 = r1
            boolean r1 = r3.isAreaSplit     // Catch:{ JSONException -> 0x0ae9 }
            r18 = r1
            boolean r1 = r3.isDeliverable     // Catch:{ JSONException -> 0x0ae9 }
            r19 = r1
            boolean r1 = r3.isOldAddreses     // Catch:{ JSONException -> 0x0ae9 }
            r20 = r1
            java.lang.String r1 = r3.judda     // Catch:{ JSONException -> 0x0ae9 }
            r21 = r1
            r16 = r2
            double r1 = r3.latitude     // Catch:{ JSONException -> 0x0ae9 }
            r22 = r1
            double r1 = r3.longitude     // Catch:{ JSONException -> 0x0ae9 }
            r24 = r1
            java.lang.String r1 = r3.mobileNumber     // Catch:{ JSONException -> 0x0ae9 }
            java.lang.String r2 = r3.mobilNumberCountryCode     // Catch:{ JSONException -> 0x0ae9 }
            r27 = r2
            java.lang.String r2 = r3.phoneNumber     // Catch:{ JSONException -> 0x0ae9 }
            r28 = r2
            java.lang.String r2 = r3.profileName     // Catch:{ JSONException -> 0x0ae9 }
            r29 = r2
            java.lang.String r2 = r3.street     // Catch:{ JSONException -> 0x0ae9 }
            r30 = r2
            java.lang.String r2 = r3.suite     // Catch:{ JSONException -> 0x0ae9 }
            r31 = r2
            int r2 = r3.type     // Catch:{ JSONException -> 0x0ae9 }
            r26 = r1
            r32 = r2
            com.talabat.domain.address.Address r1 = r3.copy(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r24, r26, r27, r28, r29, r30, r31, r32)     // Catch:{ JSONException -> 0x0ae9 }
            r2 = r33
            r2.oldAddress = r1     // Catch:{ JSONException -> 0x0ae7 }
            goto L_0x0af5
        L_0x0ae7:
            r0 = move-exception
            goto L_0x0af1
        L_0x0ae9:
            r0 = move-exception
            r2 = r33
            goto L_0x0af1
        L_0x0aed:
            r2 = r1
            goto L_0x0af5
        L_0x0aef:
            r0 = move-exception
            r2 = r1
        L_0x0af1:
            r1 = r0
            r1.printStackTrace()
        L_0x0af5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.addressV2.AddressPresenter.setUpViewsWithJson(org.json.JSONObject, boolean):void");
    }

    public void setValidateArea(boolean z11) {
    }

    public void setViewType(int i11) {
        this.addressViewType = i11;
    }

    public boolean shouldDiscardOldValue(String str) {
        if (str.equals(UserDataStore.STATE) || str.equals("blk")) {
            return true;
        }
        return false;
    }

    public void showAddressConfiramtion(boolean z11) {
        this.addressView.showConfirmAddressPopup();
    }

    public void showErrorAtField(int i11) {
        switch (i11) {
            case 1:
                this.addressView.setErrorFeild1(0);
                return;
            case 2:
                this.addressView.setErrorFeild2(0);
                return;
            case 3:
                this.addressView.setErrorFeild3(0);
                return;
            case 4:
                this.addressView.setErrorFeild4(0);
                return;
            case 5:
                this.addressView.setErrorFeild5(0);
                return;
            case 6:
                this.addressView.setErrorFeild6(0);
                return;
            case 7:
                this.addressView.setErrorFeild7(0);
                return;
            default:
                return;
        }
    }

    public void showMapForSelection(boolean z11) {
        boolean z12;
        LatLng latLng;
        AddressView addressView2 = this.addressView;
        if (addressView2 != null) {
            this.tempMobile = addressView2.getMobile();
            this.tempPhone = this.addressView.getPhone();
            if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.configurationLocalRepository, this.locationConfigurationRepository)) {
                this.tempCountryCode = this.addressView.getMobileDialCode();
            }
        }
        Address address2 = this.address;
        if (address2 != null) {
            double d11 = address2.latitude;
            if (d11 > 0.0d) {
                double d12 = address2.longitude;
                if (d12 > 0.0d) {
                    latLng = this.latLngFactory.createLatLng(d11, d12);
                    z12 = true;
                    this.addressView.onRedirectToMapScreen(latLng, z12, z11);
                }
            }
        }
        latLng = null;
        z12 = false;
        this.addressView.onRedirectToMapScreen(latLng, z12, z11);
    }

    public void updateQuickOrderAddress() {
        this.tempMobile = this.addressView.getMobile();
        this.tempPhone = this.addressView.getPhone();
        if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.configurationLocalRepository, this.locationConfigurationRepository)) {
            this.tempCountryCode = this.addressView.getMobileDialCode();
        }
    }

    public void validateAndAddAddress(boolean z11, boolean z12) {
        boolean z13;
        boolean z14;
        Object obj;
        String str;
        int i11;
        boolean z15 = z12;
        if (this.address == null) {
            this.address = new Address();
        }
        this.address.countyId = this.configurationLocalRepository.selectedCountry().getCountryId();
        int areaId = this.addressView.getAreaId();
        String mobile = this.addressView.getMobile();
        String phone = this.addressView.getPhone();
        String directions = this.addressView.getDirections();
        String grl = this.addressView.getGRL();
        String gRLId = this.addressView.getGRLId();
        if (TalabatUtils.isNullOrEmpty(mobile)) {
            this.addressView.setErrorMobileField(0);
            z13 = false;
        } else {
            z13 = true;
        }
        String mobileDialCode = this.addressView.getMobileDialCode();
        if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.configurationLocalRepository, this.locationConfigurationRepository)) {
            boolean countryCodeCountryType = this.addressView.getCountryCodeCountryType();
            if (!this.addressView.getCountryCodeCountryGcc() && TalabatUtils.isNullOrEmpty(this.addressView.getPhone())) {
                this.addressView.setErrorPhnField(0);
                z13 = false;
            }
            if (!countryCodeCountryType && mobile.length() <= 5) {
                this.addressView.setErrorMobileField(3);
                z13 = false;
            }
        }
        if (areaId <= 0) {
            this.addressView.onAddressValidationError(AddressFields.AREA, ERRORMESSAGES.EMPTY_AREA);
            z13 = false;
        } else {
            Address address2 = this.address;
            address2.areaId = areaId;
            address2.areaName = this.addressView.getAreaName();
        }
        String[] strArr = new String[10];
        strArr[0] = this.addressView.getFeild1();
        strArr[1] = this.addressView.getFeild2();
        strArr[2] = this.addressView.getFeild3();
        strArr[3] = this.addressView.getFeild4();
        strArr[4] = this.addressView.getFeild5();
        strArr[5] = this.addressView.getFeild6();
        strArr[6] = this.addressView.getFeild7();
        try {
            int i12 = this.addressType;
            if (i12 == 0) {
                str = "house";
            } else if (i12 == 1) {
                str = "building";
            } else {
                str = "office";
            }
            this.countryValidationObject = this.commonvalidationObject.getJSONArray(str);
            if (this.addressViewType == 1) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            while (i11 < this.countryValidationObject.length()) {
                if (this.countryValidationObject.getJSONObject(i11).getString("optional").equals("false") && TalabatUtils.isNullOrEmpty(strArr[i11])) {
                    if (z13) {
                        z13 = false;
                    }
                    showErrorAtField(i11 + 1);
                }
                i11++;
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
            z13 = false;
        }
        UserAddAddressScreenEventsListener userAddAddressScreenEventsListener2 = this.userAddAddressScreenEventsListener;
        AddressView addressView2 = this.addressView;
        Address address3 = this.address;
        if (z15 || z11) {
            z14 = true;
        } else {
            z14 = false;
        }
        userAddAddressScreenEventsListener2.onSaveAddressClicked(addressView2, address3, z14);
        if (z13) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("{");
            if (!TalabatUtils.isNullOrEmpty(this.addressId)) {
                sb2.append("\"");
                sb2.append("eid");
                sb2.append("\"");
                sb2.append(CertificateUtil.DELIMITER);
                sb2.append("\"");
                sb2.append(this.addressId);
                sb2.append("\"");
                sb2.append(",");
            }
            sb2.append("\"");
            sb2.append("cid");
            sb2.append("\"");
            sb2.append(CertificateUtil.DELIMITER);
            sb2.append("" + this.address.cityId);
            sb2.append(",");
            sb2.append("\"");
            sb2.append("cnt");
            sb2.append("\"");
            sb2.append(CertificateUtil.DELIMITER);
            sb2.append("" + this.address.countyId);
            sb2.append(",");
            sb2.append("\"");
            sb2.append("aid");
            sb2.append("\"");
            sb2.append(CertificateUtil.DELIMITER);
            sb2.append("" + this.address.areaId);
            sb2.append(",");
            sb2.append("\"");
            sb2.append("an");
            sb2.append("\"");
            sb2.append(CertificateUtil.DELIMITER);
            sb2.append("\"");
            sb2.append(this.address.areaName);
            sb2.append("\"");
            sb2.append(",");
            sb2.append("\"");
            sb2.append("type");
            sb2.append("\"");
            sb2.append(CertificateUtil.DELIMITER);
            sb2.append("\"");
            sb2.append("" + this.addressType);
            sb2.append("\"");
            sb2.append(",");
            sb2.append("\"");
            sb2.append("mob");
            sb2.append("\"");
            sb2.append(CertificateUtil.DELIMITER);
            sb2.append("\"");
            sb2.append(mobile);
            sb2.append("\"");
            if (!TalabatUtils.isNullOrEmpty(mobileDialCode)) {
                sb2.append(",");
                sb2.append("\"");
                sb2.append("ccd");
                sb2.append("\"");
                sb2.append(CertificateUtil.DELIMITER);
                sb2.append("\"");
                sb2.append(mobileDialCode.replace("+", "").replace(" ", ""));
                sb2.append("\"");
            }
            if (!TalabatUtils.isNullOrEmpty(phone)) {
                sb2.append(",");
                sb2.append("\"");
                sb2.append(UserDataStore.PHONE);
                sb2.append("\"");
                sb2.append(CertificateUtil.DELIMITER);
                sb2.append("\"");
                sb2.append(phone);
                sb2.append("\"");
            }
            if (!TalabatUtils.isNullOrEmpty(directions)) {
                sb2.append(",");
                sb2.append("\"");
                sb2.append("exd");
                sb2.append("\"");
                sb2.append(CertificateUtil.DELIMITER);
                sb2.append("\"");
                sb2.append(directions);
                sb2.append("\"");
            }
            if (!TalabatUtils.isNullOrEmpty(grl)) {
                String encodeToBase64 = TalabatUtils.encodeToBase64(grl);
                sb2.append(",");
                sb2.append("\"");
                sb2.append("grl");
                sb2.append("\"");
                sb2.append(CertificateUtil.DELIMITER);
                sb2.append("\"");
                sb2.append(encodeToBase64);
                sb2.append("\"");
            }
            if (!TalabatUtils.isNullOrEmpty(gRLId)) {
                sb2.append(",");
                sb2.append("\"");
                sb2.append("grlid");
                sb2.append("\"");
                sb2.append(CertificateUtil.DELIMITER);
                sb2.append("\"");
                sb2.append(gRLId);
                sb2.append("\"");
            }
            for (int i13 = 0; i13 < this.countryValidationObject.length(); i13++) {
                try {
                    JSONObject jSONObject = this.countryValidationObject.getJSONObject(i13);
                    if (jSONObject.getString("key").equals("blk")) {
                        this.addressView.compareBlockField(strArr[i13]);
                    }
                    if (jSONObject.getString("key").equals(UserDataStore.STATE)) {
                        this.addressView.compareStreetField(strArr[i13]);
                    }
                    sb2.append(",");
                    sb2.append("\"");
                    sb2.append(jSONObject.getString("key"));
                    sb2.append("\"");
                    sb2.append(CertificateUtil.DELIMITER);
                    sb2.append("\"");
                    sb2.append(strArr[i13]);
                    sb2.append("\"");
                } catch (JSONException e12) {
                    e12.printStackTrace();
                }
            }
            LatLng geoCodinates = this.addressView.getGeoCodinates();
            if (geoCodinates != null) {
                sb2.append(",");
                sb2.append("\"");
                sb2.append("ltd");
                sb2.append("\"");
                sb2.append(CertificateUtil.DELIMITER);
                sb2.append("" + geoCodinates.getLatitude());
                sb2.append(",");
                sb2.append("\"");
                sb2.append("lngt");
                sb2.append("\"");
                sb2.append(CertificateUtil.DELIMITER);
                sb2.append("" + geoCodinates.getLongitude());
            }
            sb2.append("}");
            Gson gson = UniversalGson.INSTANCE.gson;
            String sb3 = sb2.toString();
            Class cls = Address.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(sb3, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, sb3, cls);
            }
            Address address4 = (Address) obj;
            this.address = address4;
            if (!TalabatUtils.isNullOrEmpty(address4.grl) && this.address.grl.indexOf("\"") < 0) {
                Address address5 = this.address;
                address5.grl = TalabatUtils.decodeFromBase64(address5.grl);
            }
            this.addressView.onValidationSuccess();
            if (this.addressViewType == 1) {
                this.addressView.onAddressAddSuccess(this.address);
                return;
            }
            if (isPolygonServiceEnabledArea() && z11) {
                clearCartChangeArea();
            }
            if ((TalabatUtils.isMcdInforMapEnabledCountry() || TalabatUtils.isMcdBlockMenuEnabledCountry() || TalabatUtils.isMcdLatLngEnabledCountry()) && z12 && z11) {
                clearBlockOrAddressGRL(this.address);
            }
            this.addressInteractor.postAddress(this.address);
            return;
        }
        this.userAddAddressScreenEventsListener.onSaveAddressFormValidationError(this.addressView, this.address, z15);
    }
}
