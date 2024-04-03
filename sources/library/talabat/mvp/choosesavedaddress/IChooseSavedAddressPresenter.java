package library.talabat.mvp.choosesavedaddress;

import JsonModels.Request.RestGeoReverseCodingRequest;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.domain.address.Address;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\bH&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\bH&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0005H&¨\u0006\u001d"}, d2 = {"Llibrary/talabat/mvp/choosesavedaddress/IChooseSavedAddressPresenter;", "Llibrary/talabat/mvp/IGlobalPresenter;", "changeUserCountry", "", "countryId", "", "clToAddress", "fromBrandOrReorder", "", "loc", "Lcom/google/android/gms/maps/model/LatLng;", "interactedWithDL", "deliverToCurrentLocation", "deliverTooDifferentLocation", "isIgnoreCurrentLocation", "isFromBrandOrReorder", "fetchCurrentLocation", "fetchingCurrentLocation", "loadCustomerSavedAdddress", "isLoadeDeliveryAddress", "reverseGeoCodingBasedRestaurant", "cstAddress", "Lcom/talabat/domain/address/Address;", "restGeoReverseCodingRequest", "LJsonModels/Request/RestGeoReverseCodingRequest;", "savedAddressSelected", "updateReorder", "fromReOrder", "reorderResId", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IChooseSavedAddressPresenter extends IGlobalPresenter {
    void changeUserCountry(int i11);

    void clToAddress(boolean z11, @NotNull LatLng latLng, boolean z12);

    void deliverToCurrentLocation(boolean z11);

    void deliverTooDifferentLocation(boolean z11, boolean z12);

    void fetchCurrentLocation(boolean z11);

    void loadCustomerSavedAdddress(boolean z11);

    void reverseGeoCodingBasedRestaurant(@NotNull Address address, @NotNull RestGeoReverseCodingRequest restGeoReverseCodingRequest);

    void savedAddressSelected(@NotNull Address address);

    void updateReorder(boolean z11, int i11);
}
