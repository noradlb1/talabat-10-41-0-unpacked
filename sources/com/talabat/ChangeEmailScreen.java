package com.talabat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.hotspot2.pps.Credential;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import buisnessmodels.Customer;
import com.google.android.gms.auth.api.credentials.Credential;
import com.materialedittext.MaterialEditText;
import com.talabat.bugreport.TalabatBugReportManager;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.changeemail.DaggerChangeEmailScreenComponent;
import com.talabat.helpers.SmartLockHelper;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import datamodels.CustomerInfo;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.changeemail.ChangeEmailPresenter;
import library.talabat.mvp.changeemail.ChangeEmailView;
import library.talabat.mvp.changeemail.IChangeEmailPresenter;
import tracking.ScreenNames;

public class ChangeEmailScreen extends TalabatBase implements ChangeEmailView {
    public static int CHANGE_EMAIL_LOCK = 2;
    private static final int RC_UPDATE = 4;
    private Button apply;
    /* access modifiers changed from: private */
    public MaterialEditText currentPassword;

    /* renamed from: i  reason: collision with root package name */
    public String f53811i = "";
    /* access modifiers changed from: private */
    public IChangeEmailPresenter iChangeEmailPresenter;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public AppVersionProvider f53812j;
    private Credential mCredential = null;
    public SmartLockHelper mSmartLockHelper;
    private Toolbar mToolbar;
    private MaterialEditText newEmail;
    private MaterialEditText retypeEmail;
    /* access modifiers changed from: private */
    public TextView showHideTxt;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;

    private void changeEmailAlert(String str) {
        stopLodingPopup();
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        customerInfo.email = this.newEmail.getText().toString();
        Customer.getInstance().setCustomerInfo(customerInfo);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setTitle((CharSequence) getString(R.string.account_email));
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                ChangeEmailScreen.this.finish();
            }
        });
        builder.show();
    }

    private void inject() {
        DaggerChangeEmailScreenComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    private boolean isSmartLockEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_ANDROID_SMART_LOCK, false);
    }

    private void passwordFldReadableFWF() {
        this.showHideTxt.setVisibility(0);
        this.showHideTxt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ChangeEmailScreen.this.showHideTxt.getText().toString().equals(ChangeEmailScreen.this.getResources().getString(R.string.login_password_show))) {
                    ChangeEmailScreen.this.currentPassword.setTransformationMethod((TransformationMethod) null);
                    ChangeEmailScreen.this.showHideTxt.setText(ChangeEmailScreen.this.getResources().getString(R.string.login_password_hide));
                } else {
                    ChangeEmailScreen.this.currentPassword.setTransformationMethod(new PasswordTransformationMethod());
                    ChangeEmailScreen.this.showHideTxt.setText(ChangeEmailScreen.this.getResources().getString(R.string.login_password_show));
                }
                ChangeEmailScreen.this.currentPassword.setSelection(ChangeEmailScreen.this.currentPassword.getText().length());
            }
        });
    }

    private void processUpdateRetrievedCredential(String str) {
        this.f53811i = str;
        com.google.android.gms.auth.api.credentials.Credential build = new Credential.Builder(this.retypeEmail.getText().toString()).setPassword(this.currentPassword.getText().toString()).setName(Customer.getInstance().getCustomerInfo().firstName + " " + Customer.getInstance().getCustomerInfo().lastName).build();
        SmartLockHelper smartLockHelper = this.mSmartLockHelper;
        if (smartLockHelper != null) {
            smartLockHelper.updateCredentialEmail(build);
        }
    }

    public void credentialUpdated(boolean z11) {
        changeEmailAlert(this.f53811i);
    }

    public void destroyPresenter() {
        this.iChangeEmailPresenter = null;
    }

    public String getCurrentPassword() {
        return this.currentPassword.getText().toString().trim();
    }

    public String getNewEmail() {
        return this.newEmail.getText().toString().trim();
    }

    public IGlobalPresenter getPresenter() {
        return this.iChangeEmailPresenter;
    }

    public String getRetypedEmail() {
        return this.retypeEmail.getText().toString().trim();
    }

    public String getScreenName() {
        return ScreenNames.CHANGE_EMAIL_SCREEN;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 != 4) {
            return;
        }
        if (i12 == -1) {
            changeEmailAlert(this.f53811i);
        } else if (i12 == 0) {
            changeEmailAlert(this.f53811i);
        }
    }

    public void onAuthError() {
    }

    public void onCreate(Bundle bundle) {
        int i11;
        int i12;
        inject();
        super.onCreate(bundle);
        setContentView((int) R.layout.change_email_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            setBackButton(R.id.back);
            if (isSmartLockEnabled()) {
                this.mSmartLockHelper = new SmartLockHelper(this, CHANGE_EMAIL_LOCK);
            }
            this.currentPassword = (MaterialEditText) findViewById(R.id.etRegPassword);
            this.newEmail = (MaterialEditText) findViewById(R.id.change_email_new);
            this.retypeEmail = (MaterialEditText) findViewById(R.id.change_email_retype);
            this.apply = (Button) findViewById(R.id.change_email_apply);
            this.showHideTxt = (TextView) findViewById(R.id.show_hide_txt);
            MaterialEditText materialEditText = this.currentPassword;
            int i13 = 5;
            if (TalabatUtils.isRTL()) {
                i11 = 5;
            } else {
                i11 = 3;
            }
            materialEditText.setGravity(i11);
            MaterialEditText materialEditText2 = this.newEmail;
            if (TalabatUtils.isRTL()) {
                i12 = 5;
            } else {
                i12 = 3;
            }
            materialEditText2.setGravity(i12);
            MaterialEditText materialEditText3 = this.retypeEmail;
            if (!TalabatUtils.isRTL()) {
                i13 = 3;
            }
            materialEditText3.setGravity(i13);
            this.iChangeEmailPresenter = new ChangeEmailPresenter(this.f53812j, this);
            TalabatBugReportManager.INSTANCE.blockViewsRecording(this.currentPassword);
            passwordFldReadableFWF();
            this.apply.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ChangeEmailScreen.this.iChangeEmailPresenter.validateAndRequest();
                }
            });
            this.currentPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                    if (i11 != 6) {
                        return false;
                    }
                    ChangeEmailScreen.this.iChangeEmailPresenter.validateAndRequest();
                    return false;
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        TalabatBugReportManager.INSTANCE.removeViewBlocking(this.currentPassword);
    }

    public void onEmailRequestFailed(String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void onEmailRequestSuccess(String str) {
        if (isSmartLockEnabled()) {
            processUpdateRetrievedCredential(str);
        } else {
            changeEmailAlert(str);
        }
    }

    public void onError() {
    }

    public void onValidationError(int i11) {
        if (i11 == 20) {
            this.newEmail.setErrorColor(getResources().getColor(R.color.talabat_red));
            this.newEmail.setError(getString(R.string.required));
        } else if (i11 == 21) {
            this.retypeEmail.setErrorColor(getResources().getColor(R.color.talabat_red));
            this.retypeEmail.setError(getString(R.string.required));
        } else if (i11 == 22) {
            this.currentPassword.setErrorColor(getResources().getColor(R.color.talabat_red));
            this.currentPassword.setError(getString(R.string.required));
        } else if (i11 == 23) {
            this.retypeEmail.setErrorColor(getResources().getColor(R.color.talabat_red));
            this.retypeEmail.requestFocus();
            this.retypeEmail.setError(getString(R.string.email_mismatch));
        } else if (i11 == 24) {
            this.retypeEmail.setText("");
            this.newEmail.setErrorColor(getResources().getColor(R.color.talabat_red));
            this.newEmail.setError(getString(R.string.change_email_invalid_email));
        }
    }

    public void onValidationSuccess() {
        startLodingPopup();
    }
}
