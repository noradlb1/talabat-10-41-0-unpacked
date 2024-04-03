package library.talabat.mvp.addresslist;

import android.content.Context;
import com.talabat.domain.address.Address;
import library.talabat.mvp.IGlobalPresenter;

public interface IAddressListPresenter extends IGlobalPresenter, AddressListListener {
    void deleteCurrentAddress(String str);

    void mcdLatLngStores(Address address, int i11);

    void onGrlUpdateIsRequired(Address address, String str, String str2);

    void selectAddress(Address address, Context context);

    void setUpViews();

    void setUpViewsForAddressSelection(boolean z11);

    void setVisibilityLoadingPopup(boolean z11);

    void updateSelectedAddressGrl(String str, String str2, String str3);
}
