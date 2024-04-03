package library.talabat.mvp.choosesavedaddress;

import JsonModels.Request.RestGeoReverseCodingRequest;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.domain.address.Address;
import datamodels.Country;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u0011"}, d2 = {"Llibrary/talabat/mvp/choosesavedaddress/IChooseSavedAddressInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "loadAppinitCountrySpecficData", "", "selectedCountry", "Ldatamodels/Country;", "reverseGeoCodingBasedRestaurant", "cstAddress", "Lcom/talabat/domain/address/Address;", "restGeoReverseCodingRequest", "LJsonModels/Request/RestGeoReverseCodingRequest;", "reverseGeoCodingBasedRestaurantDCL", "isDirect", "", "reverseGeoCodingDCL", "loc", "Lcom/google/android/gms/maps/model/LatLng;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IChooseSavedAddressInteractor extends IGlobalInteractor {
    void loadAppinitCountrySpecficData(@Nullable Country country);

    void reverseGeoCodingBasedRestaurant(@NotNull Address address, @NotNull RestGeoReverseCodingRequest restGeoReverseCodingRequest);

    void reverseGeoCodingBasedRestaurantDCL(@NotNull RestGeoReverseCodingRequest restGeoReverseCodingRequest, boolean z11);

    void reverseGeoCodingDCL(@NotNull LatLng latLng, boolean z11);
}
