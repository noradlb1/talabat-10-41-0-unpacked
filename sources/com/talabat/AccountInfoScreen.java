package com.talabat;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import buisnessmodels.Customer;
import com.designsystem.ds_input_field.DateInputField;
import com.materialedittext.MaterialEditText;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.safety.domain.SafetyAgent;
import com.talabat.core.safety.domain.SafetyCoreLibApi;
import com.talabat.core.safety.domain.SafetyEventType;
import com.talabat.core.safety.domain.entities.SafetyAppData;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.account.DaggerAccountInfoScreenComponent;
import com.talabat.helpers.AdjustIdProvider;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.UnableToValidateDetailsDialogFactory;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcommon.views.MobileNumberEditText;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.userandlocation.compliance.status.di.module.UserStatusDomainModule;
import datamodels.CustomerInfo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.accountinfo.AccountInfoView;
import library.talabat.mvp.accountinfo.AccountInteractor;
import library.talabat.mvp.accountinfo.AccountPresenter;
import library.talabat.mvp.accountinfo.IAccountPresenter;
import org.jetbrains.annotations.NotNull;
import tracking.ScreenNames;
import ue.b;
import y10.a;

public class AccountInfoScreen extends TalabatBase implements AccountInfoView {
    private ImageView calendar;
    /* access modifiers changed from: private */
    public SimpleDateFormat dateFormatter;
    /* access modifiers changed from: private */
    public MaterialEditText dob;
    /* access modifiers changed from: private */
    public DatePickerDialog dobDatePickerDialog;
    private EditText email;
    private RadioButton female;
    private MaterialEditText first_name;
    private RadioGroup gender;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f53486i;
    public boolean isEditing = false;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public ConfigurationLocalRepository f53487j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public SafetyAgent f53488k;
    /* access modifiers changed from: private */
    public MaterialEditText last_name;
    private RadioButton male;
    @Nullable
    private MobileNumberEditText mobileNumberEditText;
    private CheckBox newsLetter;
    /* access modifiers changed from: private */
    public IAccountPresenter presenter;
    private CheckBox sms;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;

    /* access modifiers changed from: private */
    @NotNull
    public Map<String, String> createObservabilityAttributes(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorMessage", "" + exc.getMessage());
        return hashMap;
    }

    private void inject() {
        DaggerAccountInfoScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class), (SafetyCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(SafetyCoreLibApi.class)).inject(this);
    }

    public void buttonTextChange() {
        if (this.isEditing) {
            this.sms.setEnabled(true);
            this.newsLetter.setEnabled(true);
            return;
        }
        this.sms.setEnabled(true);
        this.newsLetter.setEnabled(true);
        this.isEditing = false;
    }

    public void changeTitleToCreateYourAccount() {
    }

    public void destroyPresenter() {
        this.presenter = null;
    }

    public /* synthetic */ void disableGetOtpLinkFor(int i11) {
        a.a(this, i11);
    }

    public /* synthetic */ void disableSubmitButton() {
        a.b(this);
    }

    public /* synthetic */ void enableSubmitButton() {
        a.c(this);
    }

    public int getAreaId() {
        return 0;
    }

    public boolean getConsentCheckAvailable() {
        return false;
    }

    public boolean getConsentChecked() {
        return false;
    }

    public Context getContext() {
        return this;
    }

    public String getDateOfBirth() {
        return this.dob.getText().toString().trim();
    }

    public String getEmail() {
        return this.email.getText().toString();
    }

    public String getFirstName() {
        return this.first_name.getText().toString();
    }

    public boolean getGender() {
        if ((this.gender.getCheckedRadioButtonId() == R.id.account_info_rbMale || this.gender.getCheckedRadioButtonId() == R.id.account_info_rbFemale) && this.gender.getCheckedRadioButtonId() != R.id.account_info_rbMale) {
            return false;
        }
        return true;
    }

    public String getLastName() {
        return this.last_name.getText().toString();
    }

    public String getMobileNumber() {
        Editable editable;
        MobileNumberEditText mobileNumberEditText2 = this.mobileNumberEditText;
        if (mobileNumberEditText2 != null) {
            editable = mobileNumberEditText2.getText();
        } else {
            editable = null;
        }
        if (editable != null) {
            return editable.toString();
        }
        return "";
    }

    public boolean getNewsLetter() {
        return this.newsLetter.isChecked();
    }

    public /* synthetic */ String getOtp() {
        return a.d(this);
    }

    public String getPassWord() {
        return "";
    }

    public IGlobalPresenter getPresenter() {
        return this.presenter;
    }

    public String getScreenName() {
        return ScreenNames.REGISTRATION;
    }

    public boolean getSms() {
        return this.sms.isChecked();
    }

    public void hideEmailField() {
        this.email.setVisibility(8);
    }

    public void onAccountUpdateFailed(String str) {
        this.isEditing = false;
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void onAccountUpdated(CustomerInfo customerInfo) {
        this.isEditing = false;
        stopLodingPopup();
        Customer.getInstance().setCustomerInfo(customerInfo);
        UserStatusDomainModule.INSTANCE.provideUserStatusRepository().resetUserStatusAllowedCheck();
        finish();
        Toast.makeText(this, R.string.account_updated, 0).show();
    }

    public void onAuthError() {
    }

    public void onConsentValidationError() {
    }

    public void onCreate(Bundle bundle) {
        inject();
        super.onCreate(bundle);
        setContentView((int) R.layout.account_info_screen);
        try {
            setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
            this.email = (EditText) findViewById(R.id.account_info_etRegEmail);
            this.first_name = (MaterialEditText) findViewById(R.id.account_info_etRegFirstName);
            this.last_name = (MaterialEditText) findViewById(R.id.account_info_etRegLastName);
            this.calendar = (ImageView) findViewById(R.id.calendar_icon);
            this.dob = (MaterialEditText) findViewById(R.id.account_info_etdob);
            this.gender = (RadioGroup) findViewById(R.id.account_info_radioGroupGender);
            this.sms = (CheckBox) findViewById(R.id.account_info_switchSMS);
            this.newsLetter = (CheckBox) findViewById(R.id.account_info_switchNewsLetter);
            this.male = (RadioButton) findViewById(R.id.account_info_rbMale);
            this.female = (RadioButton) findViewById(R.id.account_info_rbFemale);
            AccountInteractor accountInteractor = new AccountInteractor(this.f53486i, this.talabatFeatureFlag);
            AccountPresenter accountPresenter = new AccountPresenter(this, accountInteractor, this.f53487j);
            this.presenter = accountPresenter;
            accountInteractor.setAccountListener(accountPresenter);
            this.presenter.setUpViews(Customer.getInstance().getCustomerInfo());
            this.presenter.setUpViewsForEditing();
            this.first_name.requestFocus();
            setBackButton(R.id.account_info_back);
            ((Button) findViewById(R.id.account_info_done)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AccountInfoScreen.this.presenter.updateCustomerInfo();
                }
            });
            ((Button) findViewById(R.id.save_bottom)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AccountInfoScreen.this.presenter.updateCustomerInfo();
                }
            });
            setTitle(R.id.account_info_title, getString(R.string.title_activity_account_info));
            this.email.setEnabled(false);
            this.email.setTextColor(Color.parseColor("#B5B5B5"));
            this.dateFormatter = new SimpleDateFormat(DateInputField.DefaultDateFormat);
            Calendar instance = Calendar.getInstance();
            ((FrameLayout) findViewById(R.id.date_container)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AccountInfoScreen.this.dobDatePickerDialog.show();
                }
            });
            this.dobDatePickerDialog = new DatePickerDialog(this, R.style.AlertDialogTheme, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker datePicker, int i11, int i12, int i13) {
                    Calendar instance = Calendar.getInstance();
                    instance.set(i11, i12, i13);
                    AccountInfoScreen.this.dob.setText(AccountInfoScreen.this.dateFormatter.format(instance.getTime()));
                    try {
                        ((InputMethodManager) AccountInfoScreen.this.getSystemService("input_method")).hideSoftInputFromWindow(AccountInfoScreen.this.dob.getWindowToken(), 0);
                    } catch (Exception e11) {
                        ObservabilityManager.trackUnExpectedScenario("AccountInfoScreenKeyboardHide", AccountInfoScreen.this.createObservabilityAttributes(e11));
                        LogManager.logException(e11);
                    }
                }
            }, instance.get(1) - 5, instance.get(2), instance.get(5));
            Calendar instance2 = Calendar.getInstance();
            instance2.set(instance.get(1) - 5, instance.get(2), instance.get(5));
            final Date time = instance2.getTime();
            Calendar instance3 = Calendar.getInstance();
            instance3.set(instance.get(1) - 100, instance.get(2), instance.get(5));
            Date time2 = instance3.getTime();
            long time3 = time.getTime();
            this.dobDatePickerDialog.getDatePicker().setMinDate(time2.getTime());
            this.dobDatePickerDialog.getDatePicker().setMaxDate(time3);
            this.dobDatePickerDialog.getDatePicker().init(instance.get(1) - 5, instance.get(2), instance.get(5), new DatePicker.OnDateChangedListener() {
                public void onDateChanged(DatePicker datePicker, int i11, int i12, int i13) {
                    Calendar instance = Calendar.getInstance();
                    instance.set(i11, i12, i13);
                    instance.getTime().getTime();
                    time.getTime();
                }
            });
            this.first_name.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
            this.last_name.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
            this.first_name.setFocusableInTouchMode(true);
            MaterialEditText materialEditText = this.first_name;
            materialEditText.setSelection(materialEditText.getText().length());
            this.first_name.requestFocus();
            this.first_name.setImeOptions(5);
            this.first_name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                    if (i11 != 5) {
                        return false;
                    }
                    AccountInfoScreen.this.last_name.setSelection(AccountInfoScreen.this.last_name.getText().length());
                    AccountInfoScreen.this.last_name.requestFocus();
                    return true;
                }
            });
            this.last_name.setImeOptions(5);
            this.last_name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                    if (i11 != 5) {
                        return false;
                    }
                    AccountInfoScreen.this.dob.setSelection(AccountInfoScreen.this.dob.getText().length());
                    AccountInfoScreen.this.dob.requestFocus();
                    return true;
                }
            });
        } catch (Exception e11) {
            ObservabilityManager.trackUnExpectedScenario("AccountInfoOnCreateCrash", createObservabilityAttributes(e11));
            finish();
        }
    }

    public void onError() {
    }

    public void onLocalValidationSuccess() {
        startLodingPopup();
    }

    public void onRegisterFailedWithAccessDeniedMessage() {
    }

    public void onRegistrationCompleted() {
        String str;
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        SafetyAgent safetyAgent = this.f53488k;
        if (customerInfo != null) {
            str = String.valueOf(customerInfo.f13850id);
        } else {
            str = "";
        }
        safetyAgent.sendSafetyInformation(str, SafetyEventType.SIGNUP, new SafetyAppData(new AdjustIdProvider().get()));
    }

    public void onRegistrationFailed(String str, String str2, String str3) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str2);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void onValidationError(int i11) {
        stopLodingPopup();
        if (i11 == 2) {
            this.first_name.setErrorColor(getResources().getColor(R.color.edit_text_error));
            this.first_name.setError(getString(R.string.required));
        } else if (i11 == 3) {
            this.last_name.setErrorColor(getResources().getColor(R.color.edit_text_error));
            this.last_name.setError(getString(R.string.required));
        }
    }

    public void serverValidationFailed(int i11, String str) {
        stopLodingPopup();
        if (i11 == 23) {
            this.first_name.setErrorColor(getResources().getColor(R.color.edit_text_error));
            this.first_name.setError(str);
        } else if (i11 == 24) {
            this.last_name.setErrorColor(getResources().getColor(R.color.edit_text_error));
            this.last_name.setError(str);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder.setMessage((CharSequence) str);
            builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
            builder.show();
        }
    }

    public void setDateOfBirth(String str) {
        this.dob.setText(str);
    }

    public void setEmail(String str) {
        this.email.setText(str);
    }

    public void setFirstName(String str) {
        this.first_name.setText(str);
    }

    public void setGender(boolean z11) {
        if (z11) {
            this.male.setChecked(true);
        } else {
            this.female.setChecked(true);
        }
    }

    public void setLastName(String str) {
        this.last_name.setText(str);
    }

    public void setSubscription(boolean z11, boolean z12) {
        this.sms.setChecked(z12);
        this.newsLetter.setChecked(z11);
    }

    public void setView() {
        this.isEditing = true;
        this.sms.setEnabled(false);
        this.newsLetter.setEnabled(false);
    }

    public void showAccountAlreadyExistForMobileNumber(String str) {
    }

    public /* synthetic */ void showAlertDialog(String str) {
        a.e(this, str);
    }

    public void showComplianceCannotCreateAccountDialog() {
    }

    public void showConsentSubtitle() {
    }

    public void showCouldNotValidateDetailsDialog(String str) {
        UnableToValidateDetailsDialogFactory.createDialog(this, str, new b()).show();
    }

    public void showDateOfBirthField() {
    }

    public void showGenderSelector(boolean z11) {
        if (z11) {
            this.dob.setClickable(true);
            this.calendar.setVisibility(0);
            return;
        }
        this.dob.setClickable(false);
        this.calendar.setVisibility(8);
    }

    public void showMobileNumber(int i11, String str) {
        MobileNumberEditText mobileNumberEditText2 = (MobileNumberEditText) findViewById(R.id.eTMobileNumber);
        this.mobileNumberEditText = mobileNumberEditText2;
        mobileNumberEditText2.setEnabled(false);
        this.mobileNumberEditText.setCountryCode(i11);
        this.mobileNumberEditText.setText(str);
        this.mobileNumberEditText.setVisibility(0);
    }

    public /* synthetic */ void showMobileNumberField(int i11, boolean z11) {
        a.f(this, i11, z11);
    }

    public void showNormalTermsAndCondition() {
    }

    public /* synthetic */ void showOTPField() {
        a.g(this);
    }

    public void showRegistrationConsentCheck() {
    }

    public void showRegistrationConsentCheckWithChangedText() {
    }

    public /* synthetic */ void showSuccessOtpRequestDialog() {
        a.h(this);
    }

    public void switchEnabled(boolean z11) {
    }
}
