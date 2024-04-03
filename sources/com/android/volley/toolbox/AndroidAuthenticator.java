package com.android.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.VisibleForTesting;
import com.android.volley.AuthFailureError;
import com.huawei.hms.support.api.entity.core.CommonCode;

@SuppressLint({"MissingPermission"})
public class AndroidAuthenticator implements Authenticator {
    private final Account mAccount;
    private final AccountManager mAccountManager;
    private final String mAuthTokenType;
    private final boolean mNotifyAuthFailure;

    public AndroidAuthenticator(Context context, Account account, String str) {
        this(context, account, str, false);
    }

    public Account getAccount() {
        return this.mAccount;
    }

    public String getAuthToken() throws AuthFailureError {
        String str;
        AccountManagerFuture<Bundle> authToken = this.mAccountManager.getAuthToken(this.mAccount, this.mAuthTokenType, this.mNotifyAuthFailure, (AccountManagerCallback) null, (Handler) null);
        try {
            Bundle result = authToken.getResult();
            if (!authToken.isDone() || authToken.isCancelled()) {
                str = null;
            } else if (!result.containsKey(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK)) {
                str = result.getString("authtoken");
            } else {
                throw new AuthFailureError((Intent) result.getParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK));
            }
            if (str != null) {
                return str;
            }
            throw new AuthFailureError("Got null auth token for type: " + this.mAuthTokenType);
        } catch (Exception e11) {
            throw new AuthFailureError("Error while retrieving auth token", e11);
        }
    }

    public String getAuthTokenType() {
        return this.mAuthTokenType;
    }

    public void invalidateAuthToken(String str) {
        this.mAccountManager.invalidateAuthToken(this.mAccount.type, str);
    }

    public AndroidAuthenticator(Context context, Account account, String str, boolean z11) {
        this(AccountManager.get(context), account, str, z11);
    }

    @VisibleForTesting
    public AndroidAuthenticator(AccountManager accountManager, Account account, String str, boolean z11) {
        this.mAccountManager = accountManager;
        this.mAccount = account;
        this.mAuthTokenType = str;
        this.mNotifyAuthFailure = z11;
    }
}
