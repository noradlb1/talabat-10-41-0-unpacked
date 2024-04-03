package library.talabat.mvp.payfortcardlist;

import buisnessmodels.Customer;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.android.volley.VolleyError;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.helpers.GlobalDataModel;
import java.util.ArrayList;
import java.util.Iterator;
import tracking.AppTracker;

public class PayfortCardListPresenter implements IPayfortCardListPresenter, PayfortCardListListener {
    private final ConfigurationLocalRepository configurationLocalRepository;
    private IPayfortCardListIntractor iPayfortCardListIntractor;
    private final LocationConfigurationRepository locationConfigurationRepository;
    private PayfortSavedCardListView payfortSavedCardListView;

    public PayfortCardListPresenter(AppVersionProvider appVersionProvider, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository2, PayfortSavedCardListView payfortSavedCardListView2) {
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.payfortSavedCardListView = payfortSavedCardListView2;
        this.iPayfortCardListIntractor = new PayfortCardListIntractor(appVersionProvider, configurationLocalRepository2, locationConfigurationRepository2, this);
    }

    public void deleteSavedCardButtonClicked(TokenisationCreditCard tokenisationCreditCard) {
        this.iPayfortCardListIntractor.deleteSavedCard(tokenisationCreditCard);
    }

    public void loadSavedCreditCardList() {
        if (Customer.getInstance().isLoggedIn()) {
            this.payfortSavedCardListView.savedCreditCardListLoaded(Customer.getInstance().getSavedCards());
        }
    }

    public void onDataError() {
    }

    public void onDeleteAllSavedCardSuccess() {
        this.payfortSavedCardListView.deleteAllSavedCardList();
    }

    public void onDeleteSavedCardFail(String str) {
        this.payfortSavedCardListView.deleteCardFail(str);
    }

    public void onDeleteSavedCardSucess(String str, String str2) {
        Customer.getInstance().removeDeletedCreditCard(str);
        if (GlobalDataModel.BIN.savedTokens != null) {
            TokenisationCreditCard tokenisationCreditCard = new TokenisationCreditCard();
            Iterator<TokenisationCreditCard> it = GlobalDataModel.BIN.savedTokens.iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                TokenisationCreditCard next = it.next();
                if (next.token.equals(str)) {
                    z11 = true;
                    tokenisationCreditCard = next;
                }
            }
            ArrayList<TokenisationCreditCard> arrayList = GlobalDataModel.BIN.savedTokens;
            if (arrayList != null && z11 && arrayList.contains(tokenisationCreditCard)) {
                GlobalDataModel.BIN.savedTokens.remove(tokenisationCreditCard);
                GlobalDataModel.BIN.handled = false;
            }
        }
        AppTracker.onTokenRemoved(this.payfortSavedCardListView.getcontext());
        this.payfortSavedCardListView.refreshSavedCardList(Customer.getInstance().getSavedCards(), str2);
    }

    public void onDestroy() {
        this.payfortSavedCardListView = null;
        IPayfortCardListIntractor iPayfortCardListIntractor2 = this.iPayfortCardListIntractor;
        if (iPayfortCardListIntractor2 != null) {
            iPayfortCardListIntractor2.unregister();
        }
        this.iPayfortCardListIntractor = null;
    }

    public void onNetworkError() {
    }

    public void onServerError(VolleyError volleyError) {
    }

    public void setUpViews() {
        loadSavedCreditCardList();
    }
}
