package library.talabat.mvp.homemap;

import JsonModels.Request.RestGeoReverseCodingRequest;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.domain.address.Address;
import datamodels.Country;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0015"}, d2 = {"Llibrary/talabat/mvp/homemap/IHomeMapInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "getReoderAreas", "", "orderId", "", "reorderResId", "", "loadAppinitCountrySpecficData", "selectedCountry", "Ldatamodels/Country;", "locationToArea", "latlng", "Lcom/google/android/gms/maps/model/LatLng;", "reverseGeoCoding", "reverseGeoCodingBasedRestaurant", "restGeoReverseCodingRequest", "LJsonModels/Request/RestGeoReverseCodingRequest;", "updateAddressBackGround", "userSelectedAddressCp", "Lcom/talabat/domain/address/Address;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IHomeMapInteractor extends IGlobalInteractor {
    void getReoderAreas(@NotNull String str, int i11);

    void loadAppinitCountrySpecficData(@Nullable Country country);

    void locationToArea(@Nullable LatLng latLng);

    void reverseGeoCoding(@Nullable LatLng latLng);

    void reverseGeoCodingBasedRestaurant(@NotNull RestGeoReverseCodingRequest restGeoReverseCodingRequest);

    void updateAddressBackGround(@NotNull Address address);
}
