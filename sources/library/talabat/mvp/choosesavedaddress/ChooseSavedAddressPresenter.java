package library.talabat.mvp.choosesavedaddress;

import JsonModels.Request.RestGeoReverseCodingRequest;
import JsonModels.RestGeoAddressResult;
import android.content.Context;
import android.content.SharedPreferences;
import buisnessmodels.Customer;
import buisnessmodels.TalabatFormatter;
import com.android.volley.VolleyError;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepository;
import datamodels.Country;
import datamodels.SmsVerificationInstance;
import datamodels.mappers.CityToOldCityMapper;
import datamodels.mappers.CountryToOldCountryMapper;
import io.reactivex.Scheduler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.homemap.HomeMapTemp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.gtm.TrackingUtils;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020#H\u0002J\u0010\u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020*H\u0016J \u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020#H\u0016J\u0010\u0010A\u001a\u0002062\u0006\u0010=\u001a\u00020#H\u0016J\u0018\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020#H\u0016J\u0010\u0010E\u001a\u0002062\u0006\u0010F\u001a\u00020#H\u0016J\u0010\u0010G\u001a\u0002062\u0006\u0010H\u001a\u00020#H\u0016J\b\u0010I\u001a\u000206H\u0016J\b\u0010J\u001a\u000206H\u0016J\b\u0010K\u001a\u000206H\u0016J\b\u0010L\u001a\u000206H\u0016J\b\u0010M\u001a\u000206H\u0016J\u0012\u0010N\u001a\u0002062\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0010\u0010Q\u001a\u0002062\u0006\u0010R\u001a\u00020*H\u0016J\u0010\u0010S\u001a\u0002062\u0006\u0010T\u001a\u00020#H\u0016J\u001a\u0010U\u001a\u0002062\u0006\u0010V\u001a\u00020W2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001a\u0010X\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010Y\u001a\u00020#H\u0016J\b\u0010Z\u001a\u000206H\u0002J\u0018\u0010[\u001a\u0002062\u0006\u0010\\\u001a\u00020W2\u0006\u0010]\u001a\u00020^H\u0016J\u001a\u0010_\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010W2\u0006\u0010Y\u001a\u00020#H\u0016J\u001a\u0010`\u001a\u0002062\u0006\u0010a\u001a\u00020*2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J \u0010d\u001a\u0002062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020*2\u0006\u0010e\u001a\u00020cH\u0002J\u0010\u0010f\u001a\u0002062\u0006\u0010\\\u001a\u00020WH\u0016J\u0012\u0010g\u001a\u0002062\b\u0010h\u001a\u0004\u0018\u00010cH\u0016J\u0018\u0010i\u001a\u0002062\u0006\u0010j\u001a\u00020#2\u0006\u0010)\u001a\u00020*H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006k"}, d2 = {"Llibrary/talabat/mvp/choosesavedaddress/ChooseSavedAddressPresenter;", "Llibrary/talabat/mvp/choosesavedaddress/IChooseSavedAddressPresenter;", "Llibrary/talabat/mvp/choosesavedaddress/ChooseSavedAddressListener;", "chooseSavedAddressView", "Llibrary/talabat/mvp/choosesavedaddress/ChooseSavedAddressView;", "appInfoRepository", "Lcom/talabat/userandlocation/appinfo/domain/repo/AppInfoRepository;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "locationConfigRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "mutableConfigurationLocalRepository", "Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "(Llibrary/talabat/mvp/choosesavedaddress/ChooseSavedAddressView;Lcom/talabat/userandlocation/appinfo/domain/repo/AppInfoRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/configuration/MutableConfigurationLocalRepository;)V", "getChooseSavedAddressView", "()Llibrary/talabat/mvp/choosesavedaddress/ChooseSavedAddressView;", "setChooseSavedAddressView", "(Llibrary/talabat/mvp/choosesavedaddress/ChooseSavedAddressView;)V", "cityToOldCityMapper", "Ldatamodels/mappers/CityToOldCityMapper;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "countryToOldCountryMapper", "Ldatamodels/mappers/CountryToOldCountryMapper;", "iChooseSavedAddressInteractor", "Llibrary/talabat/mvp/choosesavedaddress/IChooseSavedAddressInteractor;", "getIChooseSavedAddressInteractor", "()Llibrary/talabat/mvp/choosesavedaddress/IChooseSavedAddressInteractor;", "setIChooseSavedAddressInteractor", "(Llibrary/talabat/mvp/choosesavedaddress/IChooseSavedAddressInteractor;)V", "isFromReorder", "", "()Z", "setFromReorder", "(Z)V", "getMutableConfigurationLocalRepository", "()Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "reorderResId", "", "getReorderResId", "()I", "setReorderResId", "(I)V", "selectedCountry", "Ldatamodels/Country;", "getSelectedCountry", "()Ldatamodels/Country;", "setSelectedCountry", "(Ldatamodels/Country;)V", "brandDeliverHere", "", "result", "LJsonModels/RestGeoAddressResult;", "fromDcl", "changeUserCountry", "countryId", "clToAddress", "fromBrandOrReorder", "loc", "Lcom/google/android/gms/maps/model/LatLng;", "interactedWithDL", "deliverToCurrentLocation", "deliverTooDifferentLocation", "isIgnoreCurrentLocation", "isFromBrandOrReorder", "fetchCurrentLocation", "fetchingCurrentLocation", "loadCustomerSavedAdddress", "isLoadeDeliveryAddress", "onCountrySpecificDataLoaded", "onDataError", "onDestroy", "onNetworkError", "onResposneError", "onServerError", "volleyError", "Lcom/android/volley/VolleyError;", "outSideCountry", "countyId", "resBasereverseGeocodingError", "trackError", "resBasereverseGeocodingResult", "address", "Lcom/talabat/domain/address/Address;", "resDClBasereverseGeocodingResult", "direct", "resetMenuSection", "reverseGeoCodingBasedRestaurant", "cstAddress", "restGeoReverseCodingRequest", "LJsonModels/Request/RestGeoReverseCodingRequest;", "reverseGeocodingResult", "saveCountryInPrefs", "selectedCountryId", "selectedCountryName", "", "saveSelectedCountry", "countryName", "savedAddressSelected", "updateApiError", "localizedMessage", "updateReorder", "fromReOrder", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChooseSavedAddressPresenter implements IChooseSavedAddressPresenter, ChooseSavedAddressListener {
    @Nullable
    private ChooseSavedAddressView chooseSavedAddressView;
    @NotNull
    private final CityToOldCityMapper cityToOldCityMapper;
    @Nullable
    private Context context;
    @NotNull
    private final CountryToOldCountryMapper countryToOldCountryMapper;
    @Nullable
    private IChooseSavedAddressInteractor iChooseSavedAddressInteractor;
    private boolean isFromReorder;
    @NotNull
    private final LocationConfigurationRepository locationConfigRepository;
    @NotNull
    private final MutableConfigurationLocalRepository mutableConfigurationLocalRepository;
    private int reorderResId;
    @Nullable
    private Country selectedCountry;

    public ChooseSavedAddressPresenter(@NotNull ChooseSavedAddressView chooseSavedAddressView2, @NotNull AppInfoRepository appInfoRepository, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull MutableConfigurationLocalRepository mutableConfigurationLocalRepository2) {
        LocationConfigurationRepository locationConfigurationRepository2 = locationConfigurationRepository;
        MutableConfigurationLocalRepository mutableConfigurationLocalRepository3 = mutableConfigurationLocalRepository2;
        Intrinsics.checkNotNullParameter(chooseSavedAddressView2, "chooseSavedAddressView");
        Intrinsics.checkNotNullParameter(appInfoRepository, "appInfoRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigRepository");
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalRepository3, "mutableConfigurationLocalRepository");
        this.locationConfigRepository = locationConfigurationRepository2;
        this.mutableConfigurationLocalRepository = mutableConfigurationLocalRepository3;
        CityToOldCityMapper cityToOldCityMapper2 = new CityToOldCityMapper();
        this.cityToOldCityMapper = cityToOldCityMapper2;
        this.countryToOldCountryMapper = new CountryToOldCountryMapper(cityToOldCityMapper2);
        this.chooseSavedAddressView = chooseSavedAddressView2;
        this.iChooseSavedAddressInteractor = new ChooseSavedAddressInteractor(this, (Scheduler) null, (Scheduler) null, appInfoRepository, iTalabatFeatureFlag, locationConfigurationRepository2, mutableConfigurationLocalRepository3, 6, (DefaultConstructorMarker) null);
    }

    private final void brandDeliverHere(RestGeoAddressResult restGeoAddressResult, boolean z11) {
        Address address = restGeoAddressResult.reverseAddress;
        if (address == null) {
            return;
        }
        if (address.countyId != GlobalDataModel.SelectedCountryId) {
            ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
            if (chooseSavedAddressView2 != null) {
                chooseSavedAddressView2.stopLodingPopup();
            }
            ChooseSavedAddressView chooseSavedAddressView3 = this.chooseSavedAddressView;
            if (chooseSavedAddressView3 != null) {
                chooseSavedAddressView3.showBrandNotDeliverHere(restGeoAddressResult.reverseAddress.geoAddressTitle, z11);
            }
        } else if (!TalabatUtils.isNullOrEmpty(address.geoAddressTitle)) {
            ChooseSavedAddressView chooseSavedAddressView4 = this.chooseSavedAddressView;
            if (chooseSavedAddressView4 != null) {
                chooseSavedAddressView4.stopLodingPopup();
            }
            ChooseSavedAddressView chooseSavedAddressView5 = this.chooseSavedAddressView;
            if (chooseSavedAddressView5 != null) {
                chooseSavedAddressView5.showBrandNotDeliverHere(restGeoAddressResult.reverseAddress.geoAddressTitle, z11);
            }
        }
    }

    private final void resetMenuSection() {
        GlobalDataModel.JSON.sideMenuSection = null;
        GlobalDataModel.JSON.sideMenuSectionLinks = null;
        SmsVerificationInstance.resetInstance();
        GlobalDataModel.GEO_CORDINATES.polyGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.areaCenterPoint = null;
        GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = false;
    }

    private final void saveSelectedCountry(Context context2, int i11, String str) {
        GlobalDataModel.SelectedAreaId = 0;
        GlobalDataModel.SelectedAreaName = "";
        GlobalDataModel.SelectedCityId = 0;
        GlobalDataModel.SelectedCityName = "";
        this.mutableConfigurationLocalRepository.setSelectedCountry(i11);
        GlobalDataModel.SelectedCountryName = str;
        GlobalDataModel.areas = null;
        GlobalDataModel.cuisines = null;
        GlobalDataModel.filterEngine = null;
        SharedPreferences.Editor edit = context2.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.COUNTRY_ID, i11);
        edit.putString(GlobalConstants.PrefsConstants.COUNTRY_NAME, str);
        edit.putString(GlobalConstants.PrefsConstants.CITY_NAME, "");
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.apply();
    }

    public void changeUserCountry(int i11) {
        resetMenuSection();
        ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
        if (chooseSavedAddressView2 != null) {
            chooseSavedAddressView2.startLodingPopup();
        }
        try {
            List<com.talabat.configuration.location.Country> countries = this.locationConfigRepository.countries();
            if (!countries.isEmpty()) {
                Iterator<com.talabat.configuration.location.Country> it = countries.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.talabat.configuration.location.Country next = it.next();
                    if (next.getCountry().getCountryId() == i11) {
                        Country apply = this.countryToOldCountryMapper.apply(next);
                        this.selectedCountry = apply;
                        MutableConfigurationLocalRepository mutableConfigurationLocalRepository2 = this.mutableConfigurationLocalRepository;
                        Intrinsics.checkNotNull(apply);
                        mutableConfigurationLocalRepository2.setSelectedCountry(apply.f13845id);
                        Country country = this.selectedCountry;
                        Intrinsics.checkNotNull(country);
                        GlobalDataModel.SelectedCountryName = country.f13846name;
                        ChooseSavedAddressView chooseSavedAddressView3 = this.chooseSavedAddressView;
                        Intrinsics.checkNotNull(chooseSavedAddressView3);
                        saveSelectedCountry(chooseSavedAddressView3.getContext(), next.getCountry().getCountryId(), next.getCountry().getCountryName());
                        break;
                    }
                }
                IChooseSavedAddressInteractor iChooseSavedAddressInteractor2 = this.iChooseSavedAddressInteractor;
                if (iChooseSavedAddressInteractor2 != null) {
                    iChooseSavedAddressInteractor2.loadAppinitCountrySpecficData(this.selectedCountry);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void clToAddress(boolean z11, @NotNull LatLng latLng, boolean z12) {
        int i11;
        Intrinsics.checkNotNullParameter(latLng, "loc");
        if (z11) {
            if (this.isFromReorder) {
                i11 = this.reorderResId;
            } else {
                i11 = GlobalDataModel.SELECTED.restaurant.f13872id;
            }
            RestGeoReverseCodingRequest restGeoReverseCodingRequest = new RestGeoReverseCodingRequest(i11, GlobalDataModel.SelectedCountryId, latLng.longitude, latLng.latitude, 0);
            IChooseSavedAddressInteractor iChooseSavedAddressInteractor2 = this.iChooseSavedAddressInteractor;
            if (iChooseSavedAddressInteractor2 != null) {
                iChooseSavedAddressInteractor2.reverseGeoCodingBasedRestaurantDCL(restGeoReverseCodingRequest, z12);
                return;
            }
            return;
        }
        IChooseSavedAddressInteractor iChooseSavedAddressInteractor3 = this.iChooseSavedAddressInteractor;
        if (iChooseSavedAddressInteractor3 != null) {
            iChooseSavedAddressInteractor3.reverseGeoCodingDCL(latLng, z12);
        }
    }

    public void deliverToCurrentLocation(boolean z11) {
        ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
        Intrinsics.checkNotNull(chooseSavedAddressView2);
        if (chooseSavedAddressView2.showRedirectLoading()) {
            ChooseSavedAddressView chooseSavedAddressView3 = this.chooseSavedAddressView;
            Intrinsics.checkNotNull(chooseSavedAddressView3);
            chooseSavedAddressView3.startLodingPopup();
        }
        GlobalDataModel.GEO_LOCATION_TRACKING.ADDRESS_STATUS = TrackingUtils.INSTANCE.getAddressMethodNew();
        ChooseSavedAddressView chooseSavedAddressView4 = this.chooseSavedAddressView;
        if (chooseSavedAddressView4 != null) {
            chooseSavedAddressView4.fetchCurrentLocaion();
        }
    }

    public void deliverTooDifferentLocation(boolean z11, boolean z12) {
        Context context2;
        ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
        if (chooseSavedAddressView2 != null) {
            context2 = chooseSavedAddressView2.getContext();
        } else {
            context2 = null;
        }
        AppTracker.onActionSheetDifferentLocationClicked(context2);
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        if (homeMapTemp != null && !z12) {
            ChooseSavedAddressView chooseSavedAddressView3 = this.chooseSavedAddressView;
            Intrinsics.checkNotNull(chooseSavedAddressView3);
            homeMapTemp.resetPref(chooseSavedAddressView3.getContext());
        }
        ChooseSavedAddressView chooseSavedAddressView4 = this.chooseSavedAddressView;
        if (chooseSavedAddressView4 != null) {
            chooseSavedAddressView4.updateIsIGnoreSavedLoc();
        }
        GlobalDataModel.GEO_LOCATION_TRACKING.ADDRESS_STATUS = TrackingUtils.INSTANCE.getAddressMethodNew();
        ChooseSavedAddressView chooseSavedAddressView5 = this.chooseSavedAddressView;
        if (chooseSavedAddressView5 != null) {
            int i11 = GlobalDataModel.SelectedAreaId;
            Boolean bool = GlobalDataModel.Apptimize.CAN_PRIORITIZE_SEARCH;
            Intrinsics.checkNotNullExpressionValue(bool, "CAN_PRIORITIZE_SEARCH");
            chooseSavedAddressView5.redirectMapScreen(z11, "", i11, bool.booleanValue());
        }
    }

    public void fetchCurrentLocation(boolean z11) {
        if (z11) {
            ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
            if (chooseSavedAddressView2 != null) {
                chooseSavedAddressView2.listenForCurrentLocation();
                return;
            }
            return;
        }
        ChooseSavedAddressView chooseSavedAddressView3 = this.chooseSavedAddressView;
        if (chooseSavedAddressView3 != null) {
            chooseSavedAddressView3.forceToenableCurrentLocation();
        }
    }

    @Nullable
    public final ChooseSavedAddressView getChooseSavedAddressView() {
        return this.chooseSavedAddressView;
    }

    @Nullable
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final IChooseSavedAddressInteractor getIChooseSavedAddressInteractor() {
        return this.iChooseSavedAddressInteractor;
    }

    @NotNull
    public final MutableConfigurationLocalRepository getMutableConfigurationLocalRepository() {
        return this.mutableConfigurationLocalRepository;
    }

    public final int getReorderResId() {
        return this.reorderResId;
    }

    @Nullable
    public final Country getSelectedCountry() {
        return this.selectedCountry;
    }

    public final boolean isFromReorder() {
        return this.isFromReorder;
    }

    public void loadCustomerSavedAdddress(boolean z11) {
        ChooseSavedAddressView chooseSavedAddressView2;
        if (!Customer.getInstance().hasAddresses()) {
            return;
        }
        if (z11) {
            ChooseSavedAddressView chooseSavedAddressView3 = this.chooseSavedAddressView;
            if (chooseSavedAddressView3 != null) {
                ArrayList<Address> resDeliverableAddress = Customer.getInstance().getResDeliverableAddress();
                Intrinsics.checkNotNullExpressionValue(resDeliverableAddress, "getInstance().getResDeliverableAddress()");
                chooseSavedAddressView3.showCustomerSavedAddress(resDeliverableAddress);
            }
        } else if (Customer.getInstance().hasAddresses() && (chooseSavedAddressView2 = this.chooseSavedAddressView) != null) {
            ArrayList<Address> customerAddress = Customer.getInstance().getCustomerAddress();
            Intrinsics.checkNotNullExpressionValue(customerAddress, "getInstance().getCustomerAddress()");
            chooseSavedAddressView2.showCustomerSavedAddress(customerAddress);
        }
    }

    public void onCountrySpecificDataLoaded() {
        Integer num;
        ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
        if (chooseSavedAddressView2 != null) {
            Country country = this.selectedCountry;
            if (country != null) {
                num = Integer.valueOf(country.f13845id);
            } else {
                num = null;
            }
            chooseSavedAddressView2.onCountryDataLoaded(num);
        }
        Country country2 = this.selectedCountry;
        if (country2 != null) {
            TalabatFormatter.getInstance().setFormat(country2.currencySymbol, country2.numOfDecimalPlaces, country2.f13845id);
        }
    }

    public void onDataError() {
        ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
        if (chooseSavedAddressView2 != null) {
            chooseSavedAddressView2.stopLodingPopup();
        }
    }

    public void onDestroy() {
        this.chooseSavedAddressView = null;
    }

    public void onNetworkError() {
        ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
        if (chooseSavedAddressView2 != null) {
            chooseSavedAddressView2.stopLodingPopup();
        }
    }

    public void onResposneError() {
    }

    public void onServerError(@Nullable VolleyError volleyError) {
        ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
        if (chooseSavedAddressView2 != null) {
            chooseSavedAddressView2.stopLodingPopup();
        }
    }

    public void outSideCountry(int i11) {
        ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
        if (chooseSavedAddressView2 != null) {
            chooseSavedAddressView2.currentLocOutSideCountry(i11);
        }
    }

    public void resBasereverseGeocodingError(boolean z11) {
        ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
        if (chooseSavedAddressView2 != null) {
            chooseSavedAddressView2.stopLodingPopup();
        }
        ChooseSavedAddressView chooseSavedAddressView3 = this.chooseSavedAddressView;
        if (chooseSavedAddressView3 != null) {
            chooseSavedAddressView3.unableToFindLocation(z11);
        }
    }

    public void resBasereverseGeocodingResult(@NotNull Address address, @Nullable RestGeoAddressResult restGeoAddressResult) {
        FranchiseBranchList[] franchiseBranchListArr;
        Intrinsics.checkNotNullParameter(address, "address");
        if (restGeoAddressResult == null) {
            ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
            if (chooseSavedAddressView2 != null) {
                chooseSavedAddressView2.stopLodingPopup();
            }
        } else if (restGeoAddressResult.branchInfo != null) {
            if (restGeoAddressResult.iSGroupRestaurant && (franchiseBranchListArr = restGeoAddressResult.franchiseBranchList) != null) {
                if (franchiseBranchListArr.length > 1) {
                    ChooseSavedAddressView chooseSavedAddressView3 = this.chooseSavedAddressView;
                    if (chooseSavedAddressView3 != null) {
                        chooseSavedAddressView3.updateIsFrachiseRestaurant(true);
                    }
                    ChooseSavedAddressView chooseSavedAddressView4 = this.chooseSavedAddressView;
                    if (chooseSavedAddressView4 != null) {
                        chooseSavedAddressView4.updateRestGrpId(restGeoAddressResult.branchInfo.restGrpId);
                    }
                } else {
                    ChooseSavedAddressView chooseSavedAddressView5 = this.chooseSavedAddressView;
                    if (chooseSavedAddressView5 != null) {
                        chooseSavedAddressView5.updateIsFrachiseRestaurant(false);
                    }
                }
            }
            int i11 = restGeoAddressResult.branchInfo.branchId;
            if (i11 > 0) {
                ChooseSavedAddressView chooseSavedAddressView6 = this.chooseSavedAddressView;
                if (chooseSavedAddressView6 != null) {
                    chooseSavedAddressView6.reverseBrachIdReceived(i11, address);
                    return;
                }
                return;
            }
            brandDeliverHere(restGeoAddressResult, false);
        } else {
            brandDeliverHere(restGeoAddressResult, false);
        }
    }

    public void resDClBasereverseGeocodingResult(@Nullable RestGeoAddressResult restGeoAddressResult, boolean z11) {
        ChooseSavedAddressView chooseSavedAddressView2;
        FranchiseBranchList[] franchiseBranchListArr;
        if (restGeoAddressResult != null) {
            Address address = restGeoAddressResult.reverseAddress;
            if (address != null) {
                int i11 = address.countyId;
                if (i11 == GlobalDataModel.SelectedCountryId) {
                    ChooseSavedAddressView chooseSavedAddressView3 = this.chooseSavedAddressView;
                    if (chooseSavedAddressView3 != null) {
                        chooseSavedAddressView3.reverserAddressReceived(address);
                    }
                    if (restGeoAddressResult.branchInfo != null) {
                        if (restGeoAddressResult.iSGroupRestaurant && (franchiseBranchListArr = restGeoAddressResult.franchiseBranchList) != null) {
                            if (franchiseBranchListArr.length > 1) {
                                ChooseSavedAddressView chooseSavedAddressView4 = this.chooseSavedAddressView;
                                if (chooseSavedAddressView4 != null) {
                                    chooseSavedAddressView4.updateIsFrachiseRestaurant(true);
                                }
                                ChooseSavedAddressView chooseSavedAddressView5 = this.chooseSavedAddressView;
                                if (chooseSavedAddressView5 != null) {
                                    chooseSavedAddressView5.updateRestGrpId(restGeoAddressResult.branchInfo.restGrpId);
                                }
                            } else {
                                ChooseSavedAddressView chooseSavedAddressView6 = this.chooseSavedAddressView;
                                if (chooseSavedAddressView6 != null) {
                                    chooseSavedAddressView6.updateIsFrachiseRestaurant(false);
                                }
                            }
                        }
                        int i12 = restGeoAddressResult.branchInfo.branchId;
                        if (i12 <= 0) {
                            brandDeliverHere(restGeoAddressResult, true);
                        } else if (z11 && (chooseSavedAddressView2 = this.chooseSavedAddressView) != null) {
                            Address address2 = restGeoAddressResult.reverseAddress;
                            Intrinsics.checkNotNullExpressionValue(address2, "result.reverseAddress");
                            chooseSavedAddressView2.reverseBrachIdReceivedFromDL(i12, address2);
                        }
                    }
                } else {
                    ChooseSavedAddressView chooseSavedAddressView7 = this.chooseSavedAddressView;
                    if (chooseSavedAddressView7 != null) {
                        chooseSavedAddressView7.currentLocOutSideCountry(i11);
                    }
                }
            } else {
                brandDeliverHere(restGeoAddressResult, true);
            }
        }
    }

    public void reverseGeoCodingBasedRestaurant(@NotNull Address address, @NotNull RestGeoReverseCodingRequest restGeoReverseCodingRequest) {
        Intrinsics.checkNotNullParameter(address, "cstAddress");
        Intrinsics.checkNotNullParameter(restGeoReverseCodingRequest, "restGeoReverseCodingRequest");
        ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
        if (chooseSavedAddressView2 != null) {
            chooseSavedAddressView2.startLodingPopup();
        }
        IChooseSavedAddressInteractor iChooseSavedAddressInteractor2 = this.iChooseSavedAddressInteractor;
        if (iChooseSavedAddressInteractor2 != null) {
            iChooseSavedAddressInteractor2.reverseGeoCodingBasedRestaurant(address, restGeoReverseCodingRequest);
        }
    }

    public void reverseGeocodingResult(@Nullable Address address, boolean z11) {
        ChooseSavedAddressView chooseSavedAddressView2;
        ChooseSavedAddressView chooseSavedAddressView3 = this.chooseSavedAddressView;
        if (chooseSavedAddressView3 != null) {
            chooseSavedAddressView3.reverserAddressReceived(address);
        }
        if (z11 && (chooseSavedAddressView2 = this.chooseSavedAddressView) != null) {
            Intrinsics.checkNotNull(address);
            chooseSavedAddressView2.redirectToListingFromDCL(address);
        }
    }

    public void saveCountryInPrefs(int i11, @Nullable String str) {
        ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
        Intrinsics.checkNotNull(chooseSavedAddressView2);
        Context context2 = chooseSavedAddressView2.getContext();
        Intrinsics.checkNotNull(str);
        saveSelectedCountry(context2, i11, str);
    }

    public void savedAddressSelected(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "cstAddress");
        ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
        if (chooseSavedAddressView2 != null) {
            chooseSavedAddressView2.selectAddress(address);
        }
    }

    public final void setChooseSavedAddressView(@Nullable ChooseSavedAddressView chooseSavedAddressView2) {
        this.chooseSavedAddressView = chooseSavedAddressView2;
    }

    public final void setContext(@Nullable Context context2) {
        this.context = context2;
    }

    public final void setFromReorder(boolean z11) {
        this.isFromReorder = z11;
    }

    public final void setIChooseSavedAddressInteractor(@Nullable IChooseSavedAddressInteractor iChooseSavedAddressInteractor2) {
        this.iChooseSavedAddressInteractor = iChooseSavedAddressInteractor2;
    }

    public final void setReorderResId(int i11) {
        this.reorderResId = i11;
    }

    public final void setSelectedCountry(@Nullable Country country) {
        this.selectedCountry = country;
    }

    public void updateApiError(@Nullable String str) {
        ChooseSavedAddressView chooseSavedAddressView2 = this.chooseSavedAddressView;
        if (chooseSavedAddressView2 != null) {
            chooseSavedAddressView2.updateApiErrorMsg(str);
        }
    }

    public void updateReorder(boolean z11, int i11) {
        this.isFromReorder = z11;
        this.reorderResId = i11;
    }
}
