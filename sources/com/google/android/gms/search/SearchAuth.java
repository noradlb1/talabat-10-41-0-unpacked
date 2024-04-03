package com.google.android.gms.search;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.icing.zzav;
import com.google.android.gms.internal.icing.zzbc;

public class SearchAuth {
    @NonNull
    public static final Api<Api.ApiOptions.NoOptions> API;
    @NonNull
    public static final SearchAuthApi SearchAuthApi = new zzbc();
    @NonNull
    public static final Api.ClientKey<zzav> zza;
    private static final Api.AbstractClientBuilder<zzav, Api.ApiOptions.NoOptions> zzb;

    public static class StatusCodes {
        public static final int AUTH_DISABLED = 10000;
        public static final int AUTH_THROTTLED = 10001;
        public static final int DEVELOPER_ERROR = 10;
        public static final int INTERNAL_ERROR = 8;
        public static final int SUCCESS = 0;
    }

    static {
        zzb zzb2 = new zzb();
        zzb = zzb2;
        Api.ClientKey<zzav> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        API = new Api<>("SearchAuth.API", zzb2, clientKey);
    }

    private SearchAuth() {
    }
}
