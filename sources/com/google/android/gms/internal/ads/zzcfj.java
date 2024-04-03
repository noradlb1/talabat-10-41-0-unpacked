package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

public final class zzcfj implements RewardItem {
    private final zzcew zza;

    public zzcfj(zzcew zzcew) {
        this.zza = zzcew;
    }

    public final int getAmount() {
        zzcew zzcew = this.zza;
        if (zzcew != null) {
            try {
                return zzcew.zze();
            } catch (RemoteException e11) {
                zzciz.zzk("Could not forward getAmount to RewardItem", e11);
            }
        }
        return 0;
    }

    public final String getType() {
        zzcew zzcew = this.zza;
        if (zzcew != null) {
            try {
                return zzcew.zzf();
            } catch (RemoteException e11) {
                zzciz.zzk("Could not forward getType to RewardItem", e11);
            }
        }
        return null;
    }
}
