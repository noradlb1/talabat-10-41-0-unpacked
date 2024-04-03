package library.talabat.mvp.addresslist;

import JsonModels.Request.DeliverAddressRequest;
import JsonModels.Request.McdBlockMapGrlUpdateRequest;
import JsonModels.Request.McdBranchRequest;
import com.talabat.domain.address.Address;
import library.talabat.mvp.IGlobalInteractor;

public interface IAddressListInteractor extends IGlobalInteractor {
    void deleteAddress(String str);

    void getAddressBasedDeliveryArea(DeliverAddressRequest deliverAddressRequest);

    void getMcdLatLngStoresCheck(McdBranchRequest mcdBranchRequest);

    void updateAddress(Address address);

    void updateSelectedAddressGrl(McdBlockMapGrlUpdateRequest mcdBlockMapGrlUpdateRequest);
}
