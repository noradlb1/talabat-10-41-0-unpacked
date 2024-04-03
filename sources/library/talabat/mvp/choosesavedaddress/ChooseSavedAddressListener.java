package library.talabat.mvp.choosesavedaddress;

import JsonModels.RestGeoAddressResult;
import com.talabat.domain.address.Address;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\nH&J\u001a\u0010\u0012\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\nH&J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H&¨\u0006\u0019"}, d2 = {"Llibrary/talabat/mvp/choosesavedaddress/ChooseSavedAddressListener;", "Llibrary/talabat/mvp/IGlobalListener;", "onCountrySpecificDataLoaded", "", "onResposneError", "outSideCountry", "countyId", "", "resBasereverseGeocodingError", "trackError", "", "resBasereverseGeocodingResult", "address", "Lcom/talabat/domain/address/Address;", "result", "LJsonModels/RestGeoAddressResult;", "resDClBasereverseGeocodingResult", "direct", "reverseGeocodingResult", "saveCountryInPrefs", "selectedCountryId", "selectedCountryName", "", "updateApiError", "localizedMessage", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChooseSavedAddressListener extends IGlobalListener {
    void onCountrySpecificDataLoaded();

    void onResposneError();

    void outSideCountry(int i11);

    void resBasereverseGeocodingError(boolean z11);

    void resBasereverseGeocodingResult(@NotNull Address address, @Nullable RestGeoAddressResult restGeoAddressResult);

    void resDClBasereverseGeocodingResult(@Nullable RestGeoAddressResult restGeoAddressResult, boolean z11);

    void reverseGeocodingResult(@Nullable Address address, boolean z11);

    void saveCountryInPrefs(int i11, @Nullable String str);

    void updateApiError(@Nullable String str);
}
