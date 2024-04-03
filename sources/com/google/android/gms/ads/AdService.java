package com.google.android.gms.ads;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbxe;
import com.google.android.gms.internal.ads.zzciz;

@KeepForSdk
public class AdService extends IntentService {
    public AdService() {
        super("AdService");
    }

    public final void onHandleIntent(@RecentlyNonNull Intent intent) {
        try {
            zzbgo.zza().zzl(this, new zzbxe()).zze(intent);
        } catch (RemoteException e11) {
            zzciz.zzg("RemoteException calling handleNotificationIntent: ".concat(e11.toString()));
        }
    }
}
