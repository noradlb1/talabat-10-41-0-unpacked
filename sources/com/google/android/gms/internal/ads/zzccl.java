package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import java.util.List;

final class zzccl extends zzccg {
    final /* synthetic */ UpdateClickUrlCallback zza;

    public zzccl(zzccn zzccn, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zza = updateClickUrlCallback;
    }

    public final void zze(String str) {
        this.zza.onFailure(str);
    }

    public final void zzf(List<Uri> list) {
        this.zza.onSuccess(list.get(0));
    }
}
