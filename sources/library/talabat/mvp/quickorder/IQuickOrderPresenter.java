package library.talabat.mvp.quickorder;

import com.talabat.domain.address.Address;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.addressV2.IAddressPresenter;
import org.json.JSONObject;

public interface IQuickOrderPresenter extends IGlobalPresenter {
    void addressValidated(Address address);

    void continueQuickOrder(boolean z11);

    void setUpQuickOrderView(JSONObject jSONObject, IAddressPresenter iAddressPresenter, String str, String str2, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16);

    void updateMobNoAfterVerification();
}
