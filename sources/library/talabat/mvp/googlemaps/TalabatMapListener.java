package library.talabat.mvp.googlemaps;

import JsonModels.Response.McdBlockAddressResponse;
import JsonModels.Response.McdStoresResponse;
import JsonModels.Response.McdStreetAddressResponse;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.domain.address.Address;
import java.util.List;
import library.talabat.mvp.IGlobalListener;

public interface TalabatMapListener extends IGlobalListener {
    void mcdBranchFailed();

    void mcdBranchReceived(McdStoresResponse mcdStoresResponse);

    void onAreGeoPolyGonCoOrdinatesReceived(List<LatLng> list, String str, boolean z11);

    void onAreGeoPolyGonFailed(boolean z11);

    void onGeoAddressRecieved(Address address);

    void onMcdBlockFailed();

    void onMcdBlockReceived(McdBlockAddressResponse mcdBlockAddressResponse);

    void onMcdKsAddressFailed();

    void onMcdKsAddressReceived(McdStreetAddressResponse mcdStreetAddressResponse);

    void onUpdateGeoAddressRecieved(Address address);
}
