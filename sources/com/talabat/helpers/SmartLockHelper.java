package com.talabat.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.IdentityProviders;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import library.talabat.mvp.accountinfo.AccountInfoView;
import library.talabat.mvp.changeemail.ChangeEmailView;
import library.talabat.mvp.changepassword.ChangePasswordView;
import library.talabat.mvp.login.LoginView;
import library.talabat.mvp.registration.RegistrationView;

public class SmartLockHelper implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks {
    public static int ACCNT_INFO_PASSWORD_LOCK = 6;
    public static int CHANGE_EMAIL_LOCK = 2;
    public static int CHANGE_PASSWORD_LOCK = 3;
    public static int ERR_NO_ACCNT_FOUND = 16;
    public static int LOGIN_SMART_LOCK = 1;
    public static final String LOG_SMART = "SmartLock";
    public static int QUICK_REG_PASSWORD_LOCK = 5;
    private static final int RC_READ = 3;
    private static final int RC_SAVE = 1;
    private static final int RC_UPDATE = 4;
    public static int REG_PASSWORD_LOCK = 4;
    public static boolean mIsRequesting;
    public int KIND;

    /* renamed from: b  reason: collision with root package name */
    public Context f60851b;

    /* renamed from: c  reason: collision with root package name */
    public GoogleApiClient f60852c;

    /* renamed from: d  reason: collision with root package name */
    public Credential f60853d = null;

    /* renamed from: e  reason: collision with root package name */
    public LoginView f60854e;

    /* renamed from: f  reason: collision with root package name */
    public ChangeEmailView f60855f;

    /* renamed from: g  reason: collision with root package name */
    public ChangePasswordView f60856g;

    /* renamed from: h  reason: collision with root package name */
    public RegistrationView f60857h;

    /* renamed from: i  reason: collision with root package name */
    public AccountInfoView f60858i;
    private Credential mCredential = null;
    public boolean mIsResolving;
    public boolean resolveResult;
    public boolean saveSuceess;
    public boolean updateSuccess;

    public SmartLockHelper(Context context, int i11) {
        mIsRequesting = false;
        this.f60851b = context;
        this.KIND = i11;
        if (i11 == LOGIN_SMART_LOCK) {
            this.f60854e = (LoginView) context;
        } else if (i11 == CHANGE_EMAIL_LOCK) {
            this.f60855f = (ChangeEmailView) context;
        } else if (i11 == CHANGE_PASSWORD_LOCK) {
            this.f60856g = (ChangePasswordView) context;
        } else if (i11 == REG_PASSWORD_LOCK) {
            this.f60857h = (RegistrationView) context;
        } else if (i11 == ACCNT_INFO_PASSWORD_LOCK) {
            this.f60858i = (AccountInfoView) context;
        }
        this.f60852c = new GoogleApiClient.Builder(context).addConnectionCallbacks(this).enableAutoManage((FragmentActivity) context, 0, this).addApi(Auth.CREDENTIALS_API).build();
    }

    public void disConnectFromAlreadyRunningApiClient(Context context) {
        GoogleApiClient googleApiClient = this.f60852c;
        if (googleApiClient != null) {
            googleApiClient.stopAutoManage((FragmentActivity) this.f60851b);
            this.f60852c.disconnect();
        }
    }

    public void onConnected(@Nullable Bundle bundle) {
        Log.w("SmartLock", "Connected");
        if (this.KIND == LOGIN_SMART_LOCK && !mIsRequesting) {
            requestCredentials();
        }
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e("ConnectionFailed", "ConnectionFailed");
    }

    public void onConnectionSuspended(int i11) {
        Log.e("ConnectionFailed", "ConnectionFailed");
    }

    public Credential requestCredentials() {
        mIsRequesting = true;
        Auth.CredentialsApi.request(this.f60852c, new CredentialRequest.Builder().setPasswordLoginSupported(true).setAccountTypes(IdentityProviders.GOOGLE).setIdTokenRequested(true).build()).setResultCallback(new ResultCallback<CredentialRequestResult>() {
            public void onResult(@NonNull CredentialRequestResult credentialRequestResult) {
                LoginView loginView = SmartLockHelper.this.f60854e;
                if (loginView != null) {
                    loginView.stopLodingPopup();
                }
                Status status = credentialRequestResult.getStatus();
                if (credentialRequestResult.getStatus().isSuccess()) {
                    SmartLockHelper.this.f60853d = credentialRequestResult.getCredential();
                    SmartLockHelper smartLockHelper = SmartLockHelper.this;
                    LoginView loginView2 = smartLockHelper.f60854e;
                    if (loginView2 != null) {
                        loginView2.autoSignin(smartLockHelper.f60853d);
                    }
                } else if (status.getStatusCode() == 6) {
                    SmartLockHelper.this.resolveResult(status, 3, false);
                } else if (status.getStatusCode() == 4) {
                    SmartLockHelper smartLockHelper2 = SmartLockHelper.this;
                    if (smartLockHelper2.KIND == SmartLockHelper.LOGIN_SMART_LOCK) {
                        LoginView loginView3 = smartLockHelper2.f60854e;
                        if (loginView3 != null) {
                            loginView3.stopLodingPopup();
                            return;
                        }
                        return;
                    }
                    RegistrationView registrationView = smartLockHelper2.f60857h;
                    if (registrationView != null) {
                        registrationView.stopLodingPopup();
                    }
                } else {
                    Log.w("SmartLock", "Unrecognized status code: " + status.getStatusCode());
                }
            }
        });
        return this.f60853d;
    }

    public void resolveResult(Status status, int i11, boolean z11) {
        if (!z11) {
            if (status.hasResolution()) {
                this.resolveResult = false;
                try {
                    status.startResolutionForResult((Activity) this.f60851b, i11);
                } catch (IntentSender.SendIntentException unused) {
                    LoginView loginView = this.f60854e;
                    if (loginView != null) {
                        loginView.saveSmartLockSucess();
                    }
                }
            } else {
                this.resolveResult = true;
            }
        }
    }

    public boolean saveCredential(Credential credential) {
        try {
            Auth.CredentialsApi.save(this.f60852c, credential).setResultCallback(new ResultCallback<Status>() {
                public void onResult(@NonNull Status status) {
                    if (status.isSuccess()) {
                        SmartLockHelper.this.saveSuceess = true;
                        try {
                            LoginView loginView = SmartLockHelper.this.f60854e;
                            if (loginView != null) {
                                loginView.saveSmartLockSucess();
                            }
                        } catch (Exception unused) {
                            LoginView loginView2 = SmartLockHelper.this.f60854e;
                            if (loginView2 != null) {
                                loginView2.saveSmartLockSucess();
                            }
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Attempt to save credential failed ");
                        sb2.append(status.getStatusMessage());
                        sb2.append(" ");
                        sb2.append(status.getStatusCode());
                        TalabatUtils.isNullOrEmpty(status.getStatusMessage());
                        if (status.getStatusCode() == SmartLockHelper.ERR_NO_ACCNT_FOUND || status.getStatusCode() == 7 || status.getStatusCode() == 8) {
                            LoginView loginView3 = SmartLockHelper.this.f60854e;
                            if (loginView3 != null) {
                                loginView3.saveSmartLockSucess();
                                return;
                            }
                            return;
                        }
                        SmartLockHelper.this.resolveResult(status, 1, false);
                    }
                }
            });
            return this.saveSuceess;
        } catch (Exception unused) {
            LoginView loginView = this.f60854e;
            if (loginView == null) {
                return false;
            }
            loginView.saveSmartLockSucess();
            return false;
        }
    }

    public boolean updateCredentialEmail(Credential credential) {
        Auth.CredentialsApi.save(this.f60852c, credential).setResultCallback(new ResultCallback<Status>() {
            public void onResult(@NonNull Status status) {
                if (status.isSuccess()) {
                    SmartLockHelper.this.saveSuceess = true;
                    try {
                        ChangeEmailView changeEmailView = SmartLockHelper.this.f60855f;
                        if (changeEmailView != null) {
                            changeEmailView.credentialUpdated(true);
                        }
                    } catch (Exception unused) {
                        ChangeEmailView changeEmailView2 = SmartLockHelper.this.f60855f;
                        if (changeEmailView2 != null) {
                            changeEmailView2.credentialUpdated(false);
                        }
                    }
                } else if (SmartLockHelper.this.f60855f == null) {
                } else {
                    if (status.getStatusCode() == SmartLockHelper.ERR_NO_ACCNT_FOUND) {
                        SmartLockHelper.this.f60855f.credentialUpdated(false);
                    } else {
                        SmartLockHelper.this.resolveResult(status, 4, false);
                    }
                }
            }
        });
        return this.saveSuceess;
    }

    public void updateCredentialPassword(Credential credential) {
        Auth.CredentialsApi.save(this.f60852c, credential).setResultCallback(new ResultCallback<Status>() {
            public void onResult(@NonNull Status status) {
                if (status.isSuccess()) {
                    SmartLockHelper.this.updateSuccess = true;
                    try {
                        ChangePasswordView changePasswordView = SmartLockHelper.this.f60856g;
                        if (changePasswordView != null) {
                            changePasswordView.credentialUpdated(true);
                        }
                    } catch (Exception unused) {
                        ChangePasswordView changePasswordView2 = SmartLockHelper.this.f60856g;
                        if (changePasswordView2 != null) {
                            changePasswordView2.credentialUpdated(false);
                        }
                    }
                } else {
                    SmartLockHelper smartLockHelper = SmartLockHelper.this;
                    smartLockHelper.updateSuccess = false;
                    ChangePasswordView changePasswordView3 = smartLockHelper.f60856g;
                    if (changePasswordView3 != null) {
                        changePasswordView3.credentialUpdated(false);
                    }
                }
            }
        });
    }
}
