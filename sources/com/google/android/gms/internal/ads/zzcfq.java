package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.RewardItem;

public final class zzcfq extends zzcev {
    private final String zza;
    private final int zzb;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzcfq(@Nullable RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public final int zze() throws RemoteException {
        return this.zzb;
    }

    public final String zzf() throws RemoteException {
        return this.zza;
    }

    public zzcfq(String str, int i11) {
        this.zza = str;
        this.zzb = i11;
    }
}
