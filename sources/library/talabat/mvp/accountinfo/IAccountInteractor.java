package library.talabat.mvp.accountinfo;

import JsonModels.Request.AccountInfoReq;
import library.talabat.mvp.IGlobalInteractor;

public interface IAccountInteractor extends IGlobalInteractor {
    void updateCustomerInfo(AccountInfoReq accountInfoReq);
}
