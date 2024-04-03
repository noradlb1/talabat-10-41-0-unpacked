package library.talabat.mvp.addressV2;

import com.talabat.domain.address.Address;
import com.talabat.maps.domain.model.LatLng;
import datamodels.Area;
import java.util.List;
import library.talabat.mvp.IGlobalListener;

public interface AddressListener extends IGlobalListener {
    void onAddressAddFailed(int i11, String str, Address address);

    void onAddressAddSuccess(Address address);

    void onAddressDeleteFailed(int i11, String str);

    void onAddressDeleted(String str);

    void onAddressEditFailed(int i11, String str, Address address);

    void onAddressEditSuccess(Address address);

    void onAddressMicroserviceError();

    void onAreGeoPolyGonCoOrdinatesReceived(List<LatLng> list, String str, boolean z11);

    void onAreGeoPolyGonFailed(boolean z11);

    void onAreaReceived(Area[] areaArr);

    void onGeoAddressRecieved(Address address);
}
