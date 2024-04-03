package library.talabat.mvp.appfeedback;

import android.content.Context;
import com.android.volley.VolleyError;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import datamodels.QuickOrderUserInfo;
import library.talabat.mvp.IGlobalPresenter;

public class AppFeedbackPresenter implements IAppFeedbackPresenter, AppFeedbackListener, IGlobalPresenter {
    private AppFeedbackView appFeedbackView;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private IAppFeedbackInteractor iAppFeedbackInteractor;
    private Context mContext;
    private QuickOrderUserInfo quickOrderUserInfo;

    public AppFeedbackPresenter(AppVersionProvider appVersionProvider, AppFeedbackView appFeedbackView2, Context context, ConfigurationLocalRepository configurationLocalRepository2) {
        this.appFeedbackView = appFeedbackView2;
        this.mContext = context;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.iAppFeedbackInteractor = new AppFeedbackInteractor(appVersionProvider, this);
    }

    public void onDataError() {
        this.appFeedbackView.onDataError();
    }

    public void onDestroy() {
        IAppFeedbackInteractor iAppFeedbackInteractor2 = this.iAppFeedbackInteractor;
        if (iAppFeedbackInteractor2 != null) {
            iAppFeedbackInteractor2.unregister();
        }
        this.iAppFeedbackInteractor = null;
    }

    public void onFeedBackSubmitCompleted() {
        this.appFeedbackView.showFeedbackThankYouPopup();
    }

    public void onNetworkError() {
        this.appFeedbackView.onNetworkError();
    }

    public void onServerError(VolleyError volleyError) {
        this.appFeedbackView.onServerError(volleyError);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendFeedback(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            datamodels.AppFeedbackRM r0 = new datamodels.AppFeedbackRM
            r0.<init>()
            r1 = 0
            if (r4 != 0) goto L_0x0011
            library.talabat.mvp.appfeedback.AppFeedbackView r4 = r3.appFeedbackView
            r2 = 302(0x12e, float:4.23E-43)
            r4.onValidationError(r2)
            r4 = r1
            goto L_0x0012
        L_0x0011:
            r4 = 1
        L_0x0012:
            library.talabat.mvp.appfeedback.AppFeedbackView r2 = r3.appFeedbackView
            java.lang.String r2 = r2.getEmail()
            boolean r2 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r2)
            if (r2 != 0) goto L_0x003a
            library.talabat.mvp.appfeedback.AppFeedbackView r2 = r3.appFeedbackView
            java.lang.String r2 = r2.getEmail()
            boolean r2 = com.talabat.helpers.TalabatUtils.isValidEmail(r2)
            if (r2 != 0) goto L_0x0032
            library.talabat.mvp.appfeedback.AppFeedbackView r4 = r3.appFeedbackView
            r2 = 303(0x12f, float:4.25E-43)
            r4.onValidationError(r2)
            goto L_0x003b
        L_0x0032:
            library.talabat.mvp.appfeedback.AppFeedbackView r1 = r3.appFeedbackView
            java.lang.String r1 = r1.getEmail()
            r0.Email = r1
        L_0x003a:
            r1 = r4
        L_0x003b:
            if (r1 == 0) goto L_0x0085
            library.talabat.mvp.appfeedback.AppFeedbackView r4 = r3.appFeedbackView
            java.lang.String r4 = r4.getMobileNumber()
            r0.Mobile = r4
            library.talabat.mvp.appfeedback.AppFeedbackView r4 = r3.appFeedbackView
            java.lang.String r4 = r4.getDateAndTime()
            r0.FDateTimel = r4
            java.lang.String r4 = "Android"
            r0.WebsiteName = r4
            java.lang.String r1 = com.talabat.helpers.BASEURLS.getBaseurl()
            r0.ApplicationURL = r1
            library.talabat.mvp.appfeedback.AppFeedbackView r1 = r3.appFeedbackView
            float r1 = r1.getFeedbackRating()
            r0.Score = r1
            java.lang.String r1 = com.talabat.helpers.GlobalDataModel.SelectedCountryName
            r0.Location = r1
            r0.ScreenPath = r5
            java.lang.String r5 = com.talabat.helpers.GlobalDataModel.SelectedLanguage
            r0.Language = r5
            r0.PlatformType = r4
            library.talabat.mvp.appfeedback.AppFeedbackView r4 = r3.appFeedbackView
            java.lang.String r4 = r4.getAppVersion()
            r0.AppVersion = r4
            library.talabat.mvp.appfeedback.AppFeedbackView r4 = r3.appFeedbackView
            java.lang.String r4 = r4.getFeedbackMessage()
            r0.FeedBackMsg = r4
            library.talabat.mvp.appfeedback.AppFeedbackView r4 = r3.appFeedbackView
            r4.showLoading()
            library.talabat.mvp.appfeedback.IAppFeedbackInteractor r4 = r3.iAppFeedbackInteractor
            r4.sendFeedbackRequest(r0)
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.appfeedback.AppFeedbackPresenter.sendFeedback(boolean, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void validateFeedbackSubmit(java.lang.String r3) {
        /*
            r2 = this;
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            boolean r0 = r0.isLoggedIn()
            if (r0 == 0) goto L_0x0032
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            com.talabat.configuration.ConfigurationLocalRepository r1 = r2.configurationLocalRepository
            com.talabat.configuration.country.Country r1 = r1.selectedCountry()
            boolean r0 = r0.hasAddresses((com.talabat.configuration.country.Country) r1)
            if (r0 == 0) goto L_0x003f
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            com.talabat.configuration.ConfigurationLocalRepository r1 = r2.configurationLocalRepository
            com.talabat.configuration.country.Country r1 = r1.selectedCountry()
            java.util.ArrayList r0 = r0.getCustomerAddress((com.talabat.configuration.country.Country) r1)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.talabat.domain.address.Address r0 = (com.talabat.domain.address.Address) r0
            java.lang.String r0 = r0.mobileNumber
            goto L_0x0040
        L_0x0032:
            android.content.Context r0 = r2.mContext
            datamodels.QuickOrderUserInfo r0 = datamodels.QuickOrderUserInfo.getSavedQuickOrderUserData(r0)
            r2.quickOrderUserInfo = r0
            if (r0 == 0) goto L_0x003f
            java.lang.String r0 = r0.mobileNumber
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            boolean r1 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)
            if (r1 == 0) goto L_0x004c
            library.talabat.mvp.appfeedback.AppFeedbackView r3 = r2.appFeedbackView
            r3.sendtoAddContactDetailsPage()
            goto L_0x0055
        L_0x004c:
            library.talabat.mvp.appfeedback.AppFeedbackView r1 = r2.appFeedbackView
            r1.setMobilenumber(r0)
            r0 = 1
            r2.sendFeedback(r0, r3)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.appfeedback.AppFeedbackPresenter.validateFeedbackSubmit(java.lang.String):void");
    }
}
