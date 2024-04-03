package com.talabat;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
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
import com.talabat.di.changepassword.DaggerChangePasswordScreenComponent;
import com.talabat.helpers.SmartLockHelper;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.changepassword.ChangePasswordPresenter;
import library.talabat.mvp.changepassword.ChangePasswordView;
import library.talabat.mvp.changepassword.IChangePasswordPresenter;
import library.talabat.mvp.changepassword.PasswordValidator;
import tracking.ScreenNames;

public class ChangePasswordScreen extends TalabatBase implements ChangePasswordView {
    public static int CHANGE_PASSWORD_LOCK = 3;
    private Button apply;
    /* access modifiers changed from: private */
    public MaterialEditText currentPassword;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f53817i;
    /* access modifiers changed from: private */
    public IChangePasswordPresenter iChangePasswordPresenter;
    public SmartLockHelper mSmartLockHelper;
    private Toolbar mToolbar;
    private String message;
    /* access modifiers changed from: private */
    public TextView newPasswordError;
    /* access modifiers changed from: private */
    public TextView newPasswordHint;
    /* access modifiers changed from: private */
    public MaterialEditText newPasword;
    private MaterialEditText retypePassword;
    /* access modifiers changed from: private */
    public TextView showHideCurrentPassTxt;
    /* access modifiers changed from: private */
    public TextView showHideNewPassTxt;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;

    private void inject() {
        DaggerChangePasswordScreenComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    private boolean isSmartLockEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_ANDROID_SMART_LOCK, false);
    }

    private void passwordFldReadableFWF() {
        this.showHideCurrentPassTxt.setVisibility(0);
        this.showHideNewPassTxt.setVisibility(0);
        this.showHideCurrentPassTxt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ChangePasswordScreen.this.showHideCurrentPassTxt.getText().toString().equals(ChangePasswordScreen.this.getResources().getString(R.string.login_password_show))) {
                    ChangePasswordScreen.this.currentPassword.setTransformationMethod((TransformationMethod) null);
                    ChangePasswordScreen.this.showHideCurrentPassTxt.setText(ChangePasswordScreen.this.getResources().getString(R.string.login_password_hide));
                } else {
                    ChangePasswordScreen.this.currentPassword.setTransformationMethod(new PasswordTransformationMethod());
                    ChangePasswordScreen.this.showHideCurrentPassTxt.setText(ChangePasswordScreen.this.getResources().getString(R.string.login_password_show));
                }
                ChangePasswordScreen.this.currentPassword.setSelection(ChangePasswordScreen.this.currentPassword.getText().length());
            }
        });
        this.showHideNewPassTxt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ChangePasswordScreen.this.showHideNewPassTxt.getText().toString().equals(ChangePasswordScreen.this.getResources().getString(R.string.login_password_show))) {
                    ChangePasswordScreen.this.newPasword.setTransformationMethod((TransformationMethod) null);
                    ChangePasswordScreen.this.showHideNewPassTxt.setText(ChangePasswordScreen.this.getResources().getString(R.string.login_password_hide));
                } else {
                    ChangePasswordScreen.this.newPasword.setTransformationMethod(new PasswordTransformationMethod());
                    ChangePasswordScreen.this.showHideNewPassTxt.setText(ChangePasswordScreen.this.getResources().getString(R.string.login_password_show));
                }
                ChangePasswordScreen.this.newPasword.setSelection(ChangePasswordScreen.this.newPasword.getText().length());
            }
        });
    }

    private void processUpdateRetrievedCredential(String str) {
        this.message = str;
        Credential build = new Credential.Builder(Customer.getInstance().getCustomerInfo().email).setPassword(this.newPasword.getText().toString()).setName(Customer.getInstance().getCustomerInfo().firstName + " " + Customer.getInstance().getCustomerInfo().lastName).build();
        SmartLockHelper smartLockHelper = this.mSmartLockHelper;
        if (smartLockHelper != null) {
            smartLockHelper.updateCredentialPassword(build);
        }
    }

    public void credentialUpdated(boolean z11) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setTitle((CharSequence) getString(R.string.passwords_updated));
        builder.setMessage((CharSequence) this.message);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                ChangePasswordScreen.this.finish();
            }
        });
        builder.show();
    }

    public void destroyPresenter() {
        this.iChangePasswordPresenter = null;
    }

    public String getCurrentPassword() {
        return this.currentPassword.getText().toString().trim();
    }

    public String getNewPassword() {
        return this.newPasword.getText().toString().trim();
    }

    public IGlobalPresenter getPresenter() {
        return this.iChangePasswordPresenter;
    }

    public String getRetypedPassword() {
        return this.retypePassword.getText().toString().trim();
    }

    public String getScreenName() {
        return ScreenNames.CHANGE_PASSWORD_SCREEN;
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        int i11;
        int i12;
        inject();
        super.onCreate(bundle);
        setContentView((int) R.layout.change_password_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            setBackButton(R.id.back);
            if (isSmartLockEnabled()) {
                this.mSmartLockHelper = new SmartLockHelper(this, CHANGE_PASSWORD_LOCK);
            }
            this.currentPassword = (MaterialEditText) findViewById(R.id.change_password_current);
            this.newPasword = (MaterialEditText) findViewById(R.id.change_password_new);
            this.newPasswordHint = (TextView) findViewById(R.id.password_hint);
            this.newPasswordError = (TextView) findViewById(R.id.password_error);
            this.retypePassword = (MaterialEditText) findViewById(R.id.change_password_retype);
            this.apply = (Button) findViewById(R.id.change_password_apply);
            this.showHideCurrentPassTxt = (TextView) findViewById(R.id.show_current_hide_txt);
            this.showHideNewPassTxt = (TextView) findViewById(R.id.show_current_new_txt);
            this.iChangePasswordPresenter = new ChangePasswordPresenter(this.f53817i, this, new PasswordValidator(), this.talabatFeatureFlag);
            MaterialEditText materialEditText = this.currentPassword;
            int i13 = 5;
            if (TalabatUtils.isRTL()) {
                i11 = 5;
            } else {
                i11 = 3;
            }
            materialEditText.setGravity(i11);
            MaterialEditText materialEditText2 = this.newPasword;
            if (TalabatUtils.isRTL()) {
                i12 = 5;
            } else {
                i12 = 3;
            }
            materialEditText2.setGravity(i12);
            MaterialEditText materialEditText3 = this.retypePassword;
            if (!TalabatUtils.isRTL()) {
                i13 = 3;
            }
            materialEditText3.setGravity(i13);
            TalabatBugReportManager.INSTANCE.blockViewsRecording(this.currentPassword, this.newPasword, this.retypePassword);
            passwordFldReadableFWF();
            this.apply.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ChangePasswordScreen.this.iChangePasswordPresenter.validateAndRequest();
                }
            });
            this.newPasword.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    ChangePasswordScreen.this.newPasswordHint.setVisibility(0);
                    ChangePasswordScreen.this.newPasswordError.setVisibility(8);
                }

                public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }

                public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }
            });
            if (this.iChangePasswordPresenter.isAdvancedPasswordValidationEnabled()) {
                this.newPasswordHint.setText(R.string.password_invalid_combined_rule);
            } else {
                this.newPasswordHint.setText(R.string.create_password_hint);
            }
            this.retypePassword.setImeOptions(6);
            this.retypePassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                    if (i11 != 6) {
                        return false;
                    }
                    ChangePasswordScreen.this.iChangePasswordPresenter.validateAndRequest();
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
        TalabatBugReportManager.INSTANCE.removeViewBlocking(this.currentPassword, this.newPasword, this.retypePassword);
    }

    public void onError() {
    }

    public void onPasswordRequestFailed(String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void onPasswordRequestSuccess(String str) {
        if (isSmartLockEnabled()) {
            processUpdateRetrievedCredential(str);
            return;
        }
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setTitle((CharSequence) getString(R.string.passwords_updated));
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                ChangePasswordScreen.this.finish();
            }
        });
        builder.show();
    }

    public void onValidationError(int i11) {
        if (i11 == 30) {
            this.currentPassword.setErrorColor(getResources().getColor(R.color.talabat_red));
            this.currentPassword.setError(getString(R.string.required));
        } else if (i11 == 31) {
            this.newPasswordHint.setVisibility(8);
            this.newPasswordError.setVisibility(0);
            this.newPasswordError.setText(getString(R.string.required));
        } else if (i11 == 35) {
            this.retypePassword.setText("");
            this.newPasword.setText("");
            this.newPasword.requestFocus();
            this.newPasswordHint.setVisibility(8);
            this.newPasswordError.setVisibility(0);
            this.newPasswordError.setText(getString(R.string.password_invalid_combined_rule));
        } else if (i11 == 33) {
            this.retypePassword.setText("");
            this.newPasword.setText("");
            this.newPasword.requestFocus();
            this.newPasswordHint.setVisibility(8);
            this.newPasswordError.setVisibility(0);
            this.newPasswordError.setText(getString(R.string.change_password_enter_min_six_characters));
        } else if (i11 == 34) {
            this.retypePassword.setText("");
            this.newPasword.setText("");
            this.newPasword.requestFocus();
            this.newPasswordHint.setVisibility(8);
            this.newPasswordError.setVisibility(0);
            this.newPasswordError.setText(getString(R.string.password_mismatch));
        }
    }

    public void onValidationSuccess() {
        startLodingPopup();
    }
}
