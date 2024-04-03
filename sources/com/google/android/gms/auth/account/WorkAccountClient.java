package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth.zzal;
import com.google.android.gms.tasks.Task;

public class WorkAccountClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    private final WorkAccountApi zza = new zzal();

    public WorkAccountClient(@NonNull Activity activity) {
        super(activity, WorkAccount.API, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public Task<Account> addWorkAccount(@NonNull String str) {
        return PendingResultUtil.toTask(this.zza.addWorkAccount(asGoogleApiClient(), str), new zzg(this));
    }

    @NonNull
    public Task<Void> removeWorkAccount(@NonNull Account account) {
        return PendingResultUtil.toVoidTask(this.zza.removeWorkAccount(asGoogleApiClient(), account));
    }

    @NonNull
    public Task<Void> setWorkAuthenticatorEnabled(boolean z11) {
        return PendingResultUtil.toVoidTask(this.zza.setWorkAuthenticatorEnabledWithResult(asGoogleApiClient(), z11));
    }

    public WorkAccountClient(@NonNull Context context) {
        super(context, WorkAccount.API, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
