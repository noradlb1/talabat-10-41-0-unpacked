package com.google.android.gms.internal.icing;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
@VisibleForTesting
public final class zze {
    public static final Api.ClientKey<zzae> zza;
    public static final Api<Api.ApiOptions.NoOptions> zzb;
    @Deprecated
    public static final zzz zzc = new zzal();
    private static final Api.AbstractClientBuilder<zzae, Api.ApiOptions.NoOptions> zzd;

    static {
        Api.ClientKey<zzae> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzd zzd2 = new zzd();
        zzd = zzd2;
        zzb = new Api<>("AppDataSearch.LIGHTWEIGHT_API", zzd2, clientKey);
    }
}
