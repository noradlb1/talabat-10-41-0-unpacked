package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

public final class zzfjp {
    private final zzelg zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzfea zzf;
    private final Clock zzg;
    private final zzalt zzh;

    public zzfjp(zzelg zzelg, zzcjf zzcjf, String str, String str2, Context context, @Nullable zzfea zzfea, Clock clock, zzalt zzalt) {
        this.zza = zzelg;
        this.zzb = zzcjf.zza;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzfea;
        this.zzg = clock;
        this.zzh = zzalt;
    }

    public static final List<String> zzd(int i11, int i12, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String zzf2 : list) {
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append("2.");
            sb2.append(i12);
            arrayList.add(zzf(zzf2, "@gw_mpe@", sb2.toString()));
        }
        return arrayList;
    }

    @Nullable
    private static String zze(@Nullable String str) {
        return (TextUtils.isEmpty(str) || !zzciy.zzl()) ? str : "fakeForAdDebugLog";
    }

    private static String zzf(String str, String str2, @Nullable String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public final List<String> zza(zzfdz zzfdz, zzfdn zzfdn, List<String> list) {
        return zzb(zzfdz, zzfdn, false, "", "", list);
    }

    public final List<String> zzb(zzfdz zzfdz, @Nullable zzfdn zzfdn, boolean z11, String str, @Nullable String str2, List<String> list) {
        String str3;
        ArrayList arrayList = new ArrayList();
        if (true != z11) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        for (String zzf2 : list) {
            String zzf3 = zzf(zzf(zzf(zzf2, "@gw_adlocid@", zzfdz.zza.zza.zzf), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.zzb);
            if (zzfdn != null) {
                zzf3 = zzchj.zzc(zzf(zzf(zzf(zzf3, "@gw_qdata@", zzfdn.zzz), "@gw_adnetid@", zzfdn.zzy), "@gw_allocid@", zzfdn.zzx), this.zze, zzfdn.zzT);
            }
            String zzf4 = zzf(zzf(zzf(zzf3, "@gw_adnetstatus@", this.zza.zzf()), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            boolean z12 = false;
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzch)).booleanValue() && !TextUtils.isEmpty(str)) {
                z12 = true;
            }
            boolean z13 = !TextUtils.isEmpty(str2);
            if (!z12) {
                if (z13) {
                    z13 = true;
                } else {
                    arrayList.add(zzf4);
                }
            }
            if (this.zzh.zzf(Uri.parse(zzf4))) {
                Uri.Builder buildUpon = Uri.parse(zzf4).buildUpon();
                if (z12) {
                    buildUpon = buildUpon.appendQueryParameter("ms", str);
                }
                if (z13) {
                    buildUpon = buildUpon.appendQueryParameter("attok", str2);
                }
                zzf4 = buildUpon.build().toString();
            }
            arrayList.add(zzf4);
        }
        return arrayList;
    }

    public final List<String> zzc(zzfdn zzfdn, List<String> list, zzceg zzceg) {
        String str;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = this.zzg.currentTimeMillis();
        try {
            String zzc2 = zzceg.zzc();
            String num = Integer.toString(zzceg.zzb());
            zzfea zzfea = this.zzf;
            String str2 = "";
            if (zzfea == null) {
                str = str2;
            } else {
                str = zze(zzfea.zza);
            }
            zzfea zzfea2 = this.zzf;
            if (zzfea2 != null) {
                str2 = zze(zzfea2.zzb);
            }
            for (String zzf2 : list) {
                arrayList.add(zzchj.zzc(zzf(zzf(zzf(zzf(zzf(zzf(zzf2, "@gw_rwd_userid@", Uri.encode(str)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(zzc2)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.zzb), this.zze, zzfdn.zzT));
            }
            return arrayList;
        } catch (RemoteException e11) {
            zzciz.zzh("Unable to determine award type and amount.", e11);
            return arrayList;
        }
    }
}
