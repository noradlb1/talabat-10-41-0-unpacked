package library.talabat.mvp.addressV2;

import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.domain.address.Address;
import com.talabat.domain.location.GeoCoordinate;
import com.talabat.domain.location.GeoCoordinateKt;
import com.talabat.maps.domain.model.LatLng;
import dagger.internal.Preconditions;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J \u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J \u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J \u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J0\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Llibrary/talabat/mvp/addressV2/AddAddressScreenEventsTalabatTracker;", "Llibrary/talabat/mvp/addressV2/UserAddAddressScreenEventsListener;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "onAddressDeleteClicked", "", "addressView", "Llibrary/talabat/mvp/addressV2/AddressView;", "address", "Lcom/talabat/domain/address/Address;", "onAddressDeleted", "onDeleteAddressPopUpClicked", "popupButtonYesClicked", "", "onDeleteAddressPopUpShown", "onSaveAddressApiValidationError", "isForEdit", "onSaveAddressClicked", "onSaveAddressFormValidationError", "onSaveAddressSucceeded", "onScreenLoaded", "cityId", "", "areaId", "latLng", "Lcom/talabat/domain/location/GeoCoordinate;", "eventOrigin", "Llibrary/talabat/mvp/addressV2/SaveAddressEventsOrigin;", "isEdit", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddAddressScreenEventsTalabatTracker implements UserAddAddressScreenEventsListener {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public AddAddressScreenEventsTalabatTracker(@NotNull TalabatTracker talabatTracker2, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.talabatTracker = talabatTracker2;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public void onAddressDeleteClicked(@NotNull AddressView addressView, @NotNull Address address) {
        Intrinsics.checkNotNullParameter(addressView, "addressView");
        Intrinsics.checkNotNullParameter(address, "address");
        TalabatTracker talabatTracker2 = this.talabatTracker;
        try {
            int i11 = address.cityId;
            int i12 = address.areaId;
            Country selectedCountry = this.configurationLocalRepository.selectedCountry();
            GeoCoordinate geo = GeoCoordinateKt.geo(address.latitude, address.longitude);
            SaveAddressEventsOrigin addressFlowOrigin = addressView.addressFlowOrigin();
            Intrinsics.checkNotNullExpressionValue(addressFlowOrigin, "addressView.addressFlowOrigin()");
            talabatTracker2.track(UserAddressEventsKt.deleteAddressClicked(i11, i12, selectedCountry, geo, addressFlowOrigin));
        } catch (Throwable th2) {
            talabatTracker2.track(new UserAddressExceptionEvents(th2, "onScreenLoaded"));
        }
    }

    public void onAddressDeleted(@NotNull AddressView addressView, @NotNull Address address) {
        Intrinsics.checkNotNullParameter(addressView, "addressView");
        Intrinsics.checkNotNullParameter(address, "address");
        TalabatTracker talabatTracker2 = this.talabatTracker;
        try {
            int i11 = address.cityId;
            int i12 = address.areaId;
            Country selectedCountry = this.configurationLocalRepository.selectedCountry();
            GeoCoordinate geo = GeoCoordinateKt.geo(address.latitude, address.longitude);
            SaveAddressEventsOrigin addressFlowOrigin = addressView.addressFlowOrigin();
            Intrinsics.checkNotNullExpressionValue(addressFlowOrigin, "addressView.addressFlowOrigin()");
            talabatTracker2.track(UserAddressEventsKt.deleteAddressSuccess(i11, i12, selectedCountry, geo, addressFlowOrigin));
        } catch (Throwable th2) {
            talabatTracker2.track(new UserAddressExceptionEvents(th2, "onAddressDeleted"));
        }
    }

    public void onDeleteAddressPopUpClicked(@NotNull AddressView addressView, @NotNull Address address, boolean z11) {
        Intrinsics.checkNotNullParameter(addressView, "addressView");
        Intrinsics.checkNotNullParameter(address, "address");
        TalabatTracker talabatTracker2 = this.talabatTracker;
        String str = "onDeleteAddressPopUpClicked yes = " + z11;
        try {
            int i11 = address.cityId;
            int i12 = address.areaId;
            Country selectedCountry = this.configurationLocalRepository.selectedCountry();
            GeoCoordinate geo = GeoCoordinateKt.geo(address.latitude, address.longitude);
            SaveAddressEventsOrigin addressFlowOrigin = addressView.addressFlowOrigin();
            Intrinsics.checkNotNullExpressionValue(addressFlowOrigin, "addressView.addressFlowOrigin()");
            talabatTracker2.track(UserAddressEventsKt.deleteAddressPopupClicked(i11, i12, selectedCountry, geo, addressFlowOrigin, z11));
        } catch (Throwable th2) {
            talabatTracker2.track(new UserAddressExceptionEvents(th2, str));
        }
    }

    public void onDeleteAddressPopUpShown(@NotNull AddressView addressView, @NotNull Address address) {
        Intrinsics.checkNotNullParameter(addressView, "addressView");
        Intrinsics.checkNotNullParameter(address, "address");
        TalabatTracker talabatTracker2 = this.talabatTracker;
        try {
            int i11 = address.cityId;
            int i12 = address.areaId;
            Country selectedCountry = this.configurationLocalRepository.selectedCountry();
            GeoCoordinate geo = GeoCoordinateKt.geo(address.latitude, address.longitude);
            SaveAddressEventsOrigin addressFlowOrigin = addressView.addressFlowOrigin();
            Intrinsics.checkNotNullExpressionValue(addressFlowOrigin, "addressView.addressFlowOrigin()");
            talabatTracker2.track(UserAddressEventsKt.deleteAddressPopupShown(i11, i12, selectedCountry, geo, addressFlowOrigin));
        } catch (Throwable th2) {
            talabatTracker2.track(new UserAddressExceptionEvents(th2, "onDeleteAddressPopUpShown"));
        }
    }

    public void onSaveAddressApiValidationError(@NotNull AddressView addressView, @NotNull Address address, boolean z11) {
        Intrinsics.checkNotNullParameter(addressView, "addressView");
        Intrinsics.checkNotNullParameter(address, "address");
        TalabatTracker talabatTracker2 = this.talabatTracker;
        try {
            int i11 = address.cityId;
            int i12 = address.areaId;
            Country selectedCountry = this.configurationLocalRepository.selectedCountry();
            GeoCoordinate geo = GeoCoordinateKt.geo(address.latitude, address.longitude);
            SaveAddressEventsOrigin addressFlowOrigin = addressView.addressFlowOrigin();
            Intrinsics.checkNotNullExpressionValue(addressFlowOrigin, "addressView.addressFlowOrigin()");
            talabatTracker2.track(UserAddressEventsKt.saveAddressError(i11, i12, selectedCountry, geo, addressFlowOrigin, address, z11));
        } catch (Throwable th2) {
            talabatTracker2.track(new UserAddressExceptionEvents(th2, "saveEditAddressError"));
        }
    }

    public void onSaveAddressClicked(@NotNull AddressView addressView, @NotNull Address address, boolean z11) {
        Intrinsics.checkNotNullParameter(addressView, "addressView");
        Intrinsics.checkNotNullParameter(address, "address");
        TalabatTracker talabatTracker2 = this.talabatTracker;
        try {
            GeoCoordinate geo = GeoCoordinateKt.geo(addressView.getGeoCodinates().getLatitude(), addressView.getGeoCodinates().getLongitude());
            int cityId = addressView.getCityId();
            int areaId = addressView.getAreaId();
            Country selectedCountry = this.configurationLocalRepository.selectedCountry();
            SaveAddressEventsOrigin addressFlowOrigin = addressView.addressFlowOrigin();
            Intrinsics.checkNotNullExpressionValue(addressFlowOrigin, "addressView.addressFlowOrigin()");
            talabatTracker2.track(UserAddressEventsKt.saveAddressClickedEvent(cityId, areaId, selectedCountry, geo, addressFlowOrigin, address, z11));
        } catch (Throwable th2) {
            talabatTracker2.track(new UserAddressExceptionEvents(th2, "saveAddressClickedEvent"));
        }
    }

    public void onSaveAddressFormValidationError(@NotNull AddressView addressView, @NotNull Address address, boolean z11) {
        GeoCoordinate geoCoordinate;
        Intrinsics.checkNotNullParameter(addressView, "addressView");
        Intrinsics.checkNotNullParameter(address, "address");
        TalabatTracker talabatTracker2 = this.talabatTracker;
        try {
            LatLng geoCodinates = addressView.getGeoCodinates();
            int cityId = addressView.getCityId();
            int areaId = addressView.getAreaId();
            Country selectedCountry = this.configurationLocalRepository.selectedCountry();
            if (geoCodinates != null) {
                geoCoordinate = new GeoCoordinate(geoCodinates.getLatitude(), geoCodinates.getLongitude());
            } else {
                geoCoordinate = GeoCoordinate.Companion.getZERO();
            }
            SaveAddressEventsOrigin addressFlowOrigin = addressView.addressFlowOrigin();
            Intrinsics.checkNotNullExpressionValue(addressFlowOrigin, "addressView.addressFlowOrigin()");
            Object checkNotNull = Preconditions.checkNotNull(address);
            Intrinsics.checkNotNullExpressionValue(checkNotNull, "checkNotNull(\n          …address\n                )");
            talabatTracker2.track(UserAddressEventsKt.saveAddressError(cityId, areaId, selectedCountry, geoCoordinate, addressFlowOrigin, (Address) checkNotNull, z11));
        } catch (Throwable th2) {
            talabatTracker2.track(new UserAddressExceptionEvents(th2, "addressValidationError"));
        }
    }

    public void onSaveAddressSucceeded(@NotNull AddressView addressView, @NotNull Address address, boolean z11) {
        Intrinsics.checkNotNullParameter(addressView, "addressView");
        Intrinsics.checkNotNullParameter(address, "address");
        TalabatTracker talabatTracker2 = this.talabatTracker;
        try {
            int i11 = address.cityId;
            int i12 = address.areaId;
            Country selectedCountry = this.configurationLocalRepository.selectedCountry();
            GeoCoordinate geo = GeoCoordinateKt.geo(address.latitude, address.longitude);
            SaveAddressEventsOrigin addressFlowOrigin = addressView.addressFlowOrigin();
            Intrinsics.checkNotNullExpressionValue(addressFlowOrigin, "addressView.addressFlowOrigin()");
            talabatTracker2.track(UserAddressEventsKt.saveAddressSuccess(i11, i12, selectedCountry, geo, addressFlowOrigin, address, z11));
        } catch (Throwable th2) {
            talabatTracker2.track(new UserAddressExceptionEvents(th2, "saveAddAddressSuccess"));
        }
    }

    public void onScreenLoaded(int i11, int i12, @NotNull GeoCoordinate geoCoordinate, @NotNull SaveAddressEventsOrigin saveAddressEventsOrigin, boolean z11) {
        Intrinsics.checkNotNullParameter(geoCoordinate, Param.LAT_LNG);
        Intrinsics.checkNotNullParameter(saveAddressEventsOrigin, "eventOrigin");
        TalabatTracker talabatTracker2 = this.talabatTracker;
        try {
            talabatTracker2.track(UserAddressEventsKt.addressScreenLoaded(i11, i12, this.configurationLocalRepository.selectedCountry(), GeoCoordinateKt.geo(geoCoordinate.getLatitude(), geoCoordinate.getLongitude()), saveAddressEventsOrigin, z11));
        } catch (Throwable th2) {
            talabatTracker2.track(new UserAddressExceptionEvents(th2, "onScreenLoaded"));
        }
    }
}
