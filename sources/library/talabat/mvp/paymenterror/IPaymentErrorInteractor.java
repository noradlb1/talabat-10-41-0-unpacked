package library.talabat.mvp.paymenterror;

import library.talabat.mvp.IGlobalInteractor;

public interface IPaymentErrorInteractor extends IGlobalInteractor {
    void loadTransactionDetails(String str);
}
