package com.talabat;

import JsonModels.Response.PasswordResponse;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.materialedittext.MaterialEditText;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.auth.DaggerForgotPasswordScreenComponent;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.HomeScreenActivity;
import com.talabat.observability.ObservabilityManager;
import com.talabat.registration.IRegistrationPresenter;
import com.talabat.talabatcommon.views.MobileNumberEditText;
import com.talabat.talabatcore.logger.LogManager;
import java.util.HashMap;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.forgotpassword.ForgotPasswordInteractor;
import library.talabat.mvp.forgotpassword.ForgotPasswordPresenter;
import library.talabat.mvp.forgotpassword.ForgotPasswordView;
import library.talabat.mvp.forgotpassword.IForgotPasswordPresenter;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;
import tracking.gtm.TrackingUtils;
import ue.a6;
import ue.b6;
import ue.c6;
import ue.y5;
import ue.z5;

public class ForgotPasswordScreen extends TalabatBase implements ForgotPasswordView {
    public static final String EXTRA_FOR_MOBILE_NUMBER_LOGIN = "extraForMobileNumberLogin";
    private String addressString;
    /* access modifiers changed from: private */
    public MaterialEditText emailEditText;
    private boolean forMobileNumberLogin = false;
    private String from = "";
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f54016i;
    private IForgotPasswordPresenter iForgotPasswordPresenter;
    private boolean isFromQuickRegister;
    private boolean isGrlEnabled;
    private boolean isMapCompulsory;
    private boolean isNineCookiesTrackingEnabled;
    private boolean isTalabatDeliveryAvailable;
    private MobileNumberEditText mobileNumberEditText;

    private void assignExtras() {
        String str;
        Intent intent = getIntent();
        if (intent.hasExtra("from")) {
            str = intent.getStringExtra("from");
        } else {
            str = "";
        }
        this.from = str;
        this.isFromQuickRegister = intent.getBooleanExtra("fromQuickRegister", false);
        this.isMapCompulsory = intent.getBooleanExtra("map_compulsory", false);
        this.isNineCookiesTrackingEnabled = intent.getBooleanExtra("nineCookiesEnabled", false);
        this.isTalabatDeliveryAvailable = intent.getBooleanExtra("talabatDeliveryAvailable", false);
        this.isGrlEnabled = intent.getBooleanExtra("isGlrEnabledRes", false);
        this.addressString = intent.getStringExtra("value");
        this.forMobileNumberLogin = intent.getBooleanExtra(EXTRA_FOR_MOBILE_NUMBER_LOGIN, false);
    }

    @NotNull
    private String getMobileNumber() {
        Editable text = this.mobileNumberEditText.getText();
        if (text != null) {
            return text.toString();
        }
        return "";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setupAlertForError$3(DialogInterface dialogInterface, int i11) {
        this.emailEditText.setText("");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setupAlertForError$4(DialogInterface dialogInterface, int i11) {
        redirectToCreateAccount(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setupAlertForSuccess$2(DialogInterface dialogInterface, int i11) {
        Intent intent = new Intent();
        if (this.forMobileNumberLogin) {
            intent.putExtra(GlobalConstants.LOGIN.RESET_MOBILE, getMobileNumber());
        } else {
            intent.putExtra(GlobalConstants.LOGIN.RESET_EMAIL, this.emailEditText.getText().toString());
        }
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setupViews$0(View view) {
        if (this.isFromQuickRegister) {
            launchHomeScreen();
        } else {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setupViews$1(View view) {
        this.iForgotPasswordPresenter.validateAndRequest(getMobileNumber());
        AppTracker.onPasswordResetSelection(this, this.from, "Forgot Password Screen", TrackingUtils.ResetPasswordOption.Submitted.getValue());
    }

    private void launchHomeScreen() {
        startActivity(new Intent(this, HomeScreenActivity.class));
        finish();
    }

    /* access modifiers changed from: private */
    public void redirectToCreateAccount(boolean z11) {
        Intent intent = new Intent(this, RegistrationScreen.class);
        if (z11) {
            intent.putExtra(RegistrationScreen.EXTRA_REGISTRATION_TYPE, IRegistrationPresenter.RegistrationType.MOBILE_NUMBER);
        }
        if (this.from.equals("Cart Screen")) {
            intent.putExtra("isOrderFlow", true);
            intent.putExtra("map_compulsory", this.isMapCompulsory);
            intent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
            intent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
            if (this.isGrlEnabled) {
                intent.putExtra("value", this.addressString);
                intent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
            }
            intent.putExtra("isGlrEnabledRes", this.isGrlEnabled);
        }
        startActivity(intent);
        finish();
    }

    private void setupAlertForError(AlertDialog.Builder builder) {
        if (this.forMobileNumberLogin) {
            builder.setTitle((int) R.string.incorrect_mobile_number);
            builder.setPositiveButton((int) R.string.incorrect_try_again, (DialogInterface.OnClickListener) new a6(this));
            builder.setNegativeButton((int) R.string.create_new_account, (DialogInterface.OnClickListener) new b6(this));
            return;
        }
        builder.setTitle((int) R.string.email_not_found_title);
        builder.setPositiveButton((int) R.string.incorrect_try_again, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                if (!TalabatUtils.isNullOrEmpty(ForgotPasswordScreen.this.emailEditText.getText().toString())) {
                    ForgotPasswordScreen.this.emailEditText.setText("");
                }
            }
        });
        builder.setNegativeButton((int) R.string.create_new_account, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                if (!TalabatUtils.isNullOrEmpty(ForgotPasswordScreen.this.emailEditText.getText().toString())) {
                    ForgotPasswordScreen.this.redirectToCreateAccount(false);
                }
            }
        });
        AppTracker.onPasswordResetSubmit(this, this.from, "Forgot Password Screen", TrackingUtils.ResetPasswordOption.Failed.getValue(), getResources().getString(R.string.email_not_found_title));
    }

    private void setupAlertForSuccess(AlertDialog.Builder builder) {
        builder.setTitle((int) R.string.password_reset_title);
        builder.setPositiveButton((int) R.string.ok_btn, (DialogInterface.OnClickListener) new c6(this));
        AppTracker.onPasswordResetSubmit(this, this.from, "Forgot Password Screen", TrackingUtils.ResetPasswordOption.Succeeded.getValue(), "");
    }

    private void setupViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setToolbarPadding(toolbar);
        this.emailEditText = (MaterialEditText) findViewById(R.id.eTxtEmail);
        this.mobileNumberEditText = (MobileNumberEditText) findViewById(R.id.eTMobileNumber);
        setBackButton(R.id.back);
        ((ImageButton) findViewById(R.id.back)).setOnClickListener(new y5(this));
        setTitle(R.id.title, getString(R.string.title_activity_item_forgot_password));
        ((Button) findViewById(R.id.btnSubmitEmail)).setOnClickListener(new z5(this));
    }

    private void trackCrash(String str, Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorMessage", exc.getMessage());
        ObservabilityManager.trackUnExpectedScenario(str, hashMap);
    }

    public void destroyPresenter() {
        this.iForgotPasswordPresenter = null;
    }

    public Context getContext() {
        return this;
    }

    public String getEmail() {
        return this.emailEditText.getText().toString().trim();
    }

    public IGlobalPresenter getPresenter() {
        return this.iForgotPasswordPresenter;
    }

    public String getScreenName() {
        return "Forgot Password Screen";
    }

    public void hideEmailField() {
        this.emailEditText.setVisibility(8);
    }

    public void loading() {
        startLodingPopup();
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        if (this.isFromQuickRegister) {
            launchHomeScreen();
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        DaggerForgotPasswordScreenComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.forgot_password_screen);
        try {
            assignExtras();
            setupViews();
            ForgotPasswordInteractor forgotPasswordInteractor = new ForgotPasswordInteractor(this.f54016i);
            ForgotPasswordPresenter forgotPasswordPresenter = new ForgotPasswordPresenter(this, forgotPasswordInteractor);
            this.iForgotPasswordPresenter = forgotPasswordPresenter;
            forgotPasswordInteractor.setForgotPasswordListener(forgotPasswordPresenter);
            this.iForgotPasswordPresenter.onCreate(this.forMobileNumberLogin);
        } catch (Exception e11) {
            LogManager.logException(e11);
            trackCrash("ForgotPasswordScreenOnCreateCrash", e11);
            finish();
        }
    }

    public void onError() {
    }

    public void onRequestPasswordSuccess(PasswordResponse passwordResponse) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            stopLodingPopup();
            if (passwordResponse != null) {
                builder.setMessage((CharSequence) passwordResponse.result);
                if (passwordResponse.isSuccess) {
                    setupAlertForSuccess(builder);
                } else {
                    setupAlertForError(builder);
                }
                builder.show();
            }
        } catch (Exception e11) {
            LogManager.logException(e11);
            trackCrash("ForgotPasswordScreenOnRequestPasswordSuccess", e11);
            finish();
        }
    }

    public void onValidationError(int i11) {
        int color = ContextCompat.getColor(this, R.color.edit_text_error);
        if (i11 == 10) {
            this.emailEditText.setErrorColor(color);
            this.emailEditText.setError(getString(R.string.required));
        } else if (i11 == 11) {
            this.emailEditText.setErrorColor(color);
            this.emailEditText.setError(getString(R.string.enter_valid_email));
            this.emailEditText.setFocusable(true);
        } else if (i11 == 12) {
            this.mobileNumberEditText.setErrorColor(color);
            this.mobileNumberEditText.setError(getString(R.string.required));
        }
    }

    public void showMobileNumberField(int i11) {
        this.mobileNumberEditText.setVisibility(0);
        this.mobileNumberEditText.setCountryCode(i11);
    }
}
