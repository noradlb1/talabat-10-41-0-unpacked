package com.google.android.gms.appindexing;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.icing.zzal;
import com.google.android.gms.internal.icing.zze;

@Deprecated
@VisibleForTesting
public final class AppIndex {
    @NonNull
    public static final Api<Api.ApiOptions.NoOptions> API;
    @NonNull
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> APP_INDEX_API;
    @NonNull
    public static final AppIndexApi AppIndexApi = new zzal();

    static {
        Api<Api.ApiOptions.NoOptions> api = zze.zzb;
        API = api;
        APP_INDEX_API = api;
    }

    private AppIndex() {
    }
}
