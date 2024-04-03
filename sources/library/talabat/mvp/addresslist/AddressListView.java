package library.talabat.mvp.addresslist;

import android.content.Context;
import com.talabat.domain.address.Address;
import com.talabat.helpers.Talabat;
import java.util.ArrayList;

public interface AddressListView extends Talabat {
    Context getContext();

    void mcdKsaAddressMatched(Address address);

    void mcdKsaAddressUpdateRequired(Address address);

    void onAddressDeleteFailed(int i11, String str);

    void onAddressListLoaded(ArrayList<Address> arrayList, boolean z11, boolean z12);

    void onAddressesDeleted(String str);

    void onRedirectToEdit(Address address);

    void onRedirectToLogin();
}
