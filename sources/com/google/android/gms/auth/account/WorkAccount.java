package com.google.android.gms.auth.account;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzal;

public class WorkAccount {
    @NonNull
    public static final Api<Api.ApiOptions.NoOptions> API;
    @NonNull
    @Deprecated
    public static final WorkAccountApi WorkAccountApi = new zzal();
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzf zzf = new zzf();
        zzb = zzf;
        API = new Api<>("WorkAccount.API", zzf, clientKey);
    }

    private WorkAccount() {
    }

    @NonNull
    public static WorkAccountClient getClient(@NonNull Activity activity) {
        return new WorkAccountClient(activity);
    }

    @NonNull
    public static WorkAccountClient getClient(@NonNull Context context) {
        return new WorkAccountClient(context);
    }
}
