package library.talabat.mvp.talabatcreditstatement;

import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import datamodels.TalabatCreditStatement;

public class TalabatCreditStatementPresenter implements ITalabatCreditStatementPresenter, TalabatCreditStatementListener {
    private TalabatCreditStatementInteractor talabatCreditStatementInteractor;
    private TalabatCreditStatementView talabatCreditStatementView;

    public TalabatCreditStatementPresenter(AppVersionProvider appVersionProvider, TalabatCreditStatementView talabatCreditStatementView2) {
        this.talabatCreditStatementView = talabatCreditStatementView2;
        this.talabatCreditStatementInteractor = new TalabatCreditStatementInteractor(appVersionProvider, this);
    }

    public void onCreditStatementRecieved(TalabatCreditStatement[] talabatCreditStatementArr) {
        this.talabatCreditStatementView.showProgress(false);
        this.talabatCreditStatementView.setTalabatCreditStatements(talabatCreditStatementArr);
    }

    public void onDataError() {
        this.talabatCreditStatementView.onDataError();
    }

    public void onDestroy() {
        this.talabatCreditStatementView = null;
        TalabatCreditStatementInteractor talabatCreditStatementInteractor2 = this.talabatCreditStatementInteractor;
        if (talabatCreditStatementInteractor2 != null) {
            talabatCreditStatementInteractor2.unregister();
        }
        this.talabatCreditStatementInteractor = null;
    }

    public void onNetworkError() {
        this.talabatCreditStatementView.onNetworkError();
    }

    public void onServerError(VolleyError volleyError) {
        this.talabatCreditStatementView.onServerError(volleyError);
    }

    public void setUpViews() {
        this.talabatCreditStatementView.showProgress(true);
        this.talabatCreditStatementInteractor.getTalabatCreditStatement(GlobalDataModel.SelectedCountryId);
    }
}
