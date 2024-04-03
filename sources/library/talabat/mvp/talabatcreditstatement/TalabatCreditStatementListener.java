package library.talabat.mvp.talabatcreditstatement;

import datamodels.TalabatCreditStatement;
import library.talabat.mvp.IGlobalListener;

public interface TalabatCreditStatementListener extends IGlobalListener {
    void onCreditStatementRecieved(TalabatCreditStatement[] talabatCreditStatementArr);
}
