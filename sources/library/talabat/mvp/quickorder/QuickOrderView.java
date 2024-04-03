package library.talabat.mvp.quickorder;

import android.content.Context;
import com.google.android.gms.maps.model.LatLng;
import datamodels.QuickOrderInfo;
import library.talabat.mvp.addressV2.AddressView;

public interface QuickOrderView extends AddressView {
    Context getContext();

    String getFirstName();

    String getLastName();

    void hideAddressName();

    void onRedirectToCheckout(QuickOrderInfo quickOrderInfo);

    void redirectToMap();

    void setFirstName(String str);

    void setFirstNameError(int i11);

    void setLastName(String str);

    void setLastNameError(int i11);

    void updateMapCompulsory(boolean z11, boolean z12, boolean z13);

    void updateTemapLatLang(LatLng latLng);
}
