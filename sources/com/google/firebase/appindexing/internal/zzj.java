package com.google.firebase.appindexing.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.internal.icing.zzbi;
import com.google.firebase.FirebaseExceptionMapper;

final class zzj extends GoogleApi<Api.ApiOptions.NoOptions> {
    public zzj(Context context) {
        super(context, zzf.zze, Api.ApiOptions.NO_OPTIONS, Looper.getMainLooper(), (StatusExceptionMapper) new FirebaseExceptionMapper());
        zzbi.zza(context);
    }
}
