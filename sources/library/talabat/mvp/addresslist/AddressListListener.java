package library.talabat.mvp.addresslist;

import JsonModels.Response.McdStoresResponse;
import com.talabat.domain.address.Address;
import library.talabat.mvp.IGlobalListener;

public interface AddressListListener extends IGlobalListener {
    void loadResBasedDeliverableAddress(Address[] addressArr);

    void mcdBranchFailed();

    void mcdBranchReceived(McdStoresResponse mcdStoresResponse);

    void onAddressDeleteFailed(int i11, String str);

    void onAddressDeleted(String str);

    void onResponseError();
}
