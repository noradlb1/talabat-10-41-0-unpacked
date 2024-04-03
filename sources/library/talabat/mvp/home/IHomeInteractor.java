package library.talabat.mvp.home;

import com.google.android.gms.maps.model.LatLng;
import library.talabat.mvp.IGlobalInteractor;

public interface IHomeInteractor extends IGlobalInteractor {
    void fetchAddressBasedOnLatLng(LatLng latLng);
}
