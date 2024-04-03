package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;

final class zzcck extends zzccg {
    final /* synthetic */ UpdateImpressionUrlsCallback zza;

    public zzcck(zzccn zzccn, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza = updateImpressionUrlsCallback;
    }

    public final void zze(String str) {
        this.zza.onFailure(str);
    }

    public final void zzf(List<Uri> list) {
        this.zza.onSuccess(list);
    }
}
