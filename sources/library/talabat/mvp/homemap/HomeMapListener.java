package library.talabat.mvp.homemap;

import JsonModels.RestGeoAddressResult;
import com.talabat.domain.address.Address;
import datamodels.Area;
import datamodels.DeliveryArea;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalListener;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u001f\u0010\u000b\u001a\u00020\u00032\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH&¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0003H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0018"}, d2 = {"Llibrary/talabat/mvp/homemap/HomeMapListener;", "Llibrary/talabat/mvp/IGlobalListener;", "locationToAddressResult", "", "msg", "", "address", "Lcom/talabat/domain/address/Address;", "area", "Ldatamodels/Area;", "onCountrySpecificDataLoaded", "onReorderAreasRecieved", "result", "", "Ldatamodels/DeliveryArea;", "([Ldatamodels/DeliveryArea;)V", "resBasereverseGeocodingError", "resBasereverseGeocodingResult", "LJsonModels/RestGeoAddressResult;", "reverseGeocodingResult", "saveCountryInPrefs", "selectedCountryId", "", "selectedCountryName", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HomeMapListener extends IGlobalListener {
    void locationToAddressResult(@Nullable String str, @Nullable Address address, @Nullable Area area);

    void onCountrySpecificDataLoaded();

    void onReorderAreasRecieved(@Nullable DeliveryArea[] deliveryAreaArr);

    void resBasereverseGeocodingError();

    void resBasereverseGeocodingResult(@Nullable RestGeoAddressResult restGeoAddressResult);

    void reverseGeocodingResult(@Nullable Address address);

    void saveCountryInPrefs(int i11, @Nullable String str);
}
