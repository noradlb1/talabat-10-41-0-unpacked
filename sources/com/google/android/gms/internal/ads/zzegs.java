package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;

public final class zzegs {
    private static final SparseArray<zzbdj> zza;
    private final Context zzb;
    private final zzddx zzc;
    private final TelephonyManager zzd;
    private final zzegl zze;
    /* access modifiers changed from: private */
    public final zzegh zzf;
    /* access modifiers changed from: private */
    public final zzg zzg;
    private int zzh;

    static {
        SparseArray<zzbdj> sparseArray = new SparseArray<>();
        zza = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbdj.CONNECTED);
        int ordinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzbdj zzbdj = zzbdj.CONNECTING;
        sparseArray.put(ordinal, zzbdj);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzbdj);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzbdj);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbdj.DISCONNECTING);
        int ordinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzbdj zzbdj2 = zzbdj.DISCONNECTED;
        sparseArray.put(ordinal2, zzbdj2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzbdj2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzbdj2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzbdj2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzbdj2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbdj.zzf);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzbdj);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzbdj);
    }

    public zzegs(Context context, zzddx zzddx, zzegl zzegl, zzegh zzegh, zzg zzg2) {
        this.zzb = context;
        this.zzc = zzddx;
        this.zze = zzegl;
        this.zzf = zzegh;
        this.zzd = (TelephonyManager) context.getSystemService("phone");
        this.zzg = zzg2;
    }

    public static /* bridge */ /* synthetic */ zzbda zza(zzegs zzegs, Bundle bundle) {
        zzbct zza2 = zzbda.zza();
        int i11 = bundle.getInt("cnt", -2);
        int i12 = bundle.getInt("gnt", 0);
        int i13 = 2;
        if (i11 == -1) {
            zzegs.zzh = 2;
        } else {
            zzegs.zzh = 1;
            if (i11 == 0) {
                zza2.zzb(2);
            } else if (i11 != 1) {
                zza2.zzb(1);
            } else {
                zza2.zzb(3);
            }
            switch (i12) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    i13 = 3;
                    break;
                case 13:
                    i13 = 5;
                    break;
                default:
                    i13 = 1;
                    break;
            }
            zza2.zza(i13);
        }
        return (zzbda) zza2.zzah();
    }

    public static /* bridge */ /* synthetic */ byte[] zzf(zzegs zzegs, boolean z11, ArrayList arrayList, zzbda zzbda, zzbdj zzbdj) {
        boolean z12;
        zzbde zzg2 = zzbdf.zzg();
        zzg2.zza(arrayList);
        boolean z13 = true;
        if (zzt.zzq().zza(zzegs.zzb.getContentResolver()) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        zzg2.zzh(zzg(z12));
        zzg2.zzi(zzt.zzq().zzq(zzegs.zzb, zzegs.zzd));
        zzg2.zzf(zzegs.zze.zzd());
        zzg2.zze(zzegs.zze.zzb());
        zzg2.zzb(zzegs.zze.zza());
        zzg2.zzc(zzbdj);
        zzg2.zzd(zzbda);
        zzg2.zzj(zzegs.zzh);
        zzg2.zzk(zzg(z11));
        zzg2.zzg(zzt.zzA().currentTimeMillis());
        if (zzt.zzq().zzb(zzegs.zzb.getContentResolver()) == 0) {
            z13 = false;
        }
        zzg2.zzl(zzg(z13));
        return ((zzbdf) zzg2.zzah()).zzar();
    }

    private static final int zzg(boolean z11) {
        return z11 ? 2 : 1;
    }

    public final void zze(boolean z11) {
        zzfwq.zzr(this.zzc.zzb(), new zzegr(this, z11), zzcjm.zzf);
    }
}
