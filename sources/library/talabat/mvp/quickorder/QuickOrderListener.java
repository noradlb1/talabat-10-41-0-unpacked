package library.talabat.mvp.quickorder;

import com.talabat.domain.address.Address;
import library.talabat.mvp.IGlobalListener;

public interface QuickOrderListener extends IGlobalListener {
    void onAddressValidationFailed(int i11, String str);

    void onAddressValidationSuccess(Address address);

    void onUnexpectedError(Throwable th2);
}
