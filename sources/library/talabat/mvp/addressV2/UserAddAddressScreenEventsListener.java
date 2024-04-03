package library.talabat.mvp.addressV2;

import com.talabat.domain.address.Address;
import com.talabat.domain.location.GeoCoordinate;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH&J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH&J0\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH&¨\u0006\u001b"}, d2 = {"Llibrary/talabat/mvp/addressV2/UserAddAddressScreenEventsListener;", "", "onAddressDeleteClicked", "", "addressView", "Llibrary/talabat/mvp/addressV2/AddressView;", "address", "Lcom/talabat/domain/address/Address;", "onAddressDeleted", "onDeleteAddressPopUpClicked", "popupButtonYesClicked", "", "onDeleteAddressPopUpShown", "onSaveAddressApiValidationError", "isForEdit", "onSaveAddressClicked", "onSaveAddressFormValidationError", "onSaveAddressSucceeded", "onScreenLoaded", "cityId", "", "areaId", "latLng", "Lcom/talabat/domain/location/GeoCoordinate;", "eventOrigin", "Llibrary/talabat/mvp/addressV2/SaveAddressEventsOrigin;", "isEdit", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UserAddAddressScreenEventsListener {
    void onAddressDeleteClicked(@NotNull AddressView addressView, @NotNull Address address);

    void onAddressDeleted(@NotNull AddressView addressView, @NotNull Address address);

    void onDeleteAddressPopUpClicked(@NotNull AddressView addressView, @NotNull Address address, boolean z11);

    void onDeleteAddressPopUpShown(@NotNull AddressView addressView, @NotNull Address address);

    void onSaveAddressApiValidationError(@NotNull AddressView addressView, @NotNull Address address, boolean z11);

    void onSaveAddressClicked(@NotNull AddressView addressView, @NotNull Address address, boolean z11);

    void onSaveAddressFormValidationError(@NotNull AddressView addressView, @NotNull Address address, boolean z11);

    void onSaveAddressSucceeded(@NotNull AddressView addressView, @NotNull Address address, boolean z11);

    void onScreenLoaded(int i11, int i12, @NotNull GeoCoordinate geoCoordinate, @NotNull SaveAddressEventsOrigin saveAddressEventsOrigin, boolean z11);
}
