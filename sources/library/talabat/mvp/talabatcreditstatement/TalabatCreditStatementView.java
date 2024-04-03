package library.talabat.mvp.talabatcreditstatement;

import com.talabat.helpers.Talabat;
import datamodels.TalabatCreditStatement;

public interface TalabatCreditStatementView extends Talabat {
    void setTalabatCreditStatements(TalabatCreditStatement[] talabatCreditStatementArr);

    void showProgress(boolean z11);
}
