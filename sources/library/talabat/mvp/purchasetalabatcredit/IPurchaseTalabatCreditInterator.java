package library.talabat.mvp.purchasetalabatcredit;

import JsonModels.Request.PurchaseCreditReq;
import library.talabat.mvp.IGlobalInteractor;

public interface IPurchaseTalabatCreditInterator extends IGlobalInteractor {
    void buyTalabatCredit(PurchaseCreditReq purchaseCreditReq, int i11);

    void getTransactionDetails(String str, int i11);

    void loadCreditList(int i11);
}
