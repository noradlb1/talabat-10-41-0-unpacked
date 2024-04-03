package library.talabat.mvp.home;

import com.google.android.gms.maps.model.LatLng;
import com.talabat.domain.address.Address;
import library.talabat.mvp.IGlobalListener;

public interface HomeScreenListener extends IGlobalListener {
    void onGeoAddressReceieved(Address address, LatLng latLng);

    void onReverseGeoAddressError();
}
