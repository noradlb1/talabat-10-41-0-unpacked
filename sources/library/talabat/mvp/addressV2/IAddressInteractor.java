package library.talabat.mvp.addressV2;

import com.talabat.domain.address.Address;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import library.talabat.mvp.IGlobalInteractor;

public interface IAddressInteractor extends IGlobalInteractor {
    void autoFillAddress(double d11, double d12);

    void deleteAddress(String str, Function0<Unit> function0);

    void fetchAreaPolygonJson(int i11, int i12);

    void fetchRestaurantPolygonJson(int i11, int i12);

    void loadAreas(int i11);

    void loadAreasForCountry(int i11);

    void postAddress(Address address);
}
