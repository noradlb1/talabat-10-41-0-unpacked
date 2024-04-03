package library.talabat.mvp.accountinfo;

import JsonModels.Request.AccountInfoReq;
import JsonModels.Response.AccountInfoRM;
import JsonModels.Response.AccountInfoResult;
import buisnessmodels.Customer;
import com.android.volley.VolleyError;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.TalabatUtils;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import datamodels.CustomerInfo;
import datamodels.RegistrationType;
import tracking.AppTracker;

public class AccountPresenter implements IAccountPresenter, AccountListener {
    private AccountInfoView accountInfoView;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private IAccountInteractor interactor;
    private RegistrationType registrationType = RegistrationType.UNDEFINED;

    public AccountPresenter(AccountInfoView accountInfoView2, IAccountInteractor iAccountInteractor, ConfigurationLocalRepository configurationLocalRepository2) {
        this.accountInfoView = accountInfoView2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.interactor = iAccountInteractor;
    }

    public void onAccountUpdated(AccountInfoRM accountInfoRM) {
        String str = String.valueOf(accountInfoRM.result.bday) + "/" + String.valueOf(accountInfoRM.result.bmon) + "/" + String.valueOf(accountInfoRM.result.byr);
        AccountInfoResult accountInfoResult = accountInfoRM.result;
        boolean z11 = accountInfoResult.subscribedToNewsletter;
        boolean z12 = accountInfoResult.subscribedToSMS;
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        AccountInfoResult accountInfoResult2 = accountInfoRM.result;
        customerInfo.firstName = accountInfoResult2.firstName;
        customerInfo.lastName = accountInfoResult2.lastName;
        customerInfo.subscribedToSMS = z12;
        customerInfo.subscribedToNewsletter = z11;
        customerInfo.setGender(accountInfoResult2.gender);
        customerInfo.birthday = str;
        customerInfo.registrationType = accountInfoRM.result.registrationType;
        Customer.getInstance().setCustomerInfo(customerInfo);
        AppTracker.onAccountUpdated(this.accountInfoView.getContext(), customerInfo);
        this.accountInfoView.onAccountUpdated(customerInfo);
    }

    public void onAccountUpdatingFailed(int i11, String str) {
        if (i11 == 1) {
            this.accountInfoView.onAccountUpdateFailed(str);
        } else if (i11 == 4) {
            this.accountInfoView.serverValidationFailed(23, str);
        } else if (i11 == 5) {
            this.accountInfoView.serverValidationFailed(24, str);
        } else {
            this.accountInfoView.serverValidationFailed(-4, str);
        }
    }

    public void onDataError() {
        this.accountInfoView.onDataError();
    }

    public void onDestroy() {
        this.accountInfoView = null;
        IAccountInteractor iAccountInteractor = this.interactor;
        if (iAccountInteractor != null) {
            iAccountInteractor.unregister();
        }
        this.interactor = null;
    }

    public void onKurdishNamesBlocked(String str) {
        this.accountInfoView.stopLodingPopup();
        this.accountInfoView.showCouldNotValidateDetailsDialog(str);
    }

    public void onNetworkError() {
        this.accountInfoView.onNetworkError();
    }

    public void onServerError(VolleyError volleyError) {
        this.accountInfoView.onServerError(volleyError);
    }

    public void setUpViews(CustomerInfo customerInfo) {
        String str = "";
        this.registrationType = customerInfo.registrationType;
        String str2 = customerInfo.birthday;
        boolean z11 = true;
        if (str2.length() > 10) {
            String[] split = str2.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
            str2 = split[2].substring(0, 2) + "/" + split[1] + "/" + split[0];
        }
        try {
            if (!str2.equals("01/01/0001") && !str2.equals("0/0/0")) {
                str = str2;
            }
        } catch (Exception unused) {
        }
        this.accountInfoView.setFirstName(customerInfo.firstName);
        this.accountInfoView.setLastName(customerInfo.lastName);
        this.accountInfoView.setDateOfBirth(str);
        AccountInfoView accountInfoView2 = this.accountInfoView;
        if (!customerInfo.getGender().startsWith("M") && !customerInfo.getGender().startsWith("m")) {
            z11 = false;
        }
        accountInfoView2.setGender(z11);
        RegistrationType registrationType2 = this.registrationType;
        if (registrationType2 == RegistrationType.EMAIL || registrationType2 == RegistrationType.UNDEFINED) {
            this.accountInfoView.setEmail(customerInfo.email);
        } else if (registrationType2 == RegistrationType.MOBILE_NUMBER) {
            this.accountInfoView.showMobileNumber(GlobalConstants.IRAQ_COUNTRY_CODE, customerInfo.mobileNumber);
            this.accountInfoView.hideEmailField();
        }
        this.accountInfoView.setSubscription(customerInfo.subscribedToNewsletter, customerInfo.subscribedToSMS);
        this.accountInfoView.switchEnabled(false);
    }

    public void setUpViewsForEditing() {
        this.accountInfoView.setView();
        this.accountInfoView.showGenderSelector(true);
        this.accountInfoView.buttonTextChange();
    }

    public void updateCustomerInfo() {
        int i11;
        int i12;
        int i13;
        boolean z11 = false;
        this.accountInfoView.showGenderSelector(false);
        this.accountInfoView.buttonTextChange();
        String email = this.accountInfoView.getEmail();
        String firstName = this.accountInfoView.getFirstName();
        String lastName = this.accountInfoView.getLastName();
        String dateOfBirth = this.accountInfoView.getDateOfBirth();
        boolean z12 = true;
        if (!TalabatUtils.isNullOrEmpty(dateOfBirth)) {
            String[] split = dateOfBirth.split("/");
            i12 = Integer.parseInt(split[0]);
            i11 = Integer.parseInt(split[1]);
            i13 = Integer.parseInt(split[2]);
        } else {
            i13 = 0;
            i12 = 0;
            i11 = 0;
        }
        String mobileNumber = this.accountInfoView.getMobileNumber();
        boolean gender = this.accountInfoView.getGender();
        boolean sms = this.accountInfoView.getSms();
        boolean newsLetter = this.accountInfoView.getNewsLetter();
        if (firstName.equals("")) {
            this.accountInfoView.onValidationError(2);
            z12 = false;
        }
        if (lastName.equals("")) {
            this.accountInfoView.onValidationError(3);
        } else {
            z11 = z12;
        }
        if (z11) {
            this.accountInfoView.onLocalValidationSuccess();
            AccountInfoReq accountInfoReq = new AccountInfoReq();
            accountInfoReq.email = email;
            accountInfoReq.firstName = firstName;
            accountInfoReq.lastName = lastName;
            accountInfoReq.countryId = this.configurationLocalRepository.selectedCountry().getCountryId();
            accountInfoReq.gender = gender;
            accountInfoReq.subscribedToNewsletter = newsLetter;
            accountInfoReq.subscribedToSMS = sms;
            accountInfoReq.bday = i12;
            accountInfoReq.bmon = i11;
            accountInfoReq.byr = i13;
            accountInfoReq.registrationType = this.registrationType;
            accountInfoReq.mobileNumber = mobileNumber;
            this.interactor.updateCustomerInfo(accountInfoReq);
        }
    }
}
