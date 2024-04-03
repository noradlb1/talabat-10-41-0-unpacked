package library.talabat.mvp.quickorder;

import com.talabat.domain.address.Address;
import datamodels.QuickOrderUserInfo;
import library.talabat.mvp.IGlobalInteractor;

public interface IQuickOrderInteractor extends IGlobalInteractor {
    void validateAddress(Address address, QuickOrderUserInfo quickOrderUserInfo);
}
