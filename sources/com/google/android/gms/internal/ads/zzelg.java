package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.utility.JavaConstant;

public final class zzelg {
    /* access modifiers changed from: private */
    public final Clock zza;
    /* access modifiers changed from: private */
    public final zzelh zzb;
    /* access modifiers changed from: private */
    public final zzfjs zzc;
    private final List<String> zzd = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public final boolean zze;
    /* access modifiers changed from: private */
    public final zzehy zzf;

    public zzelg(Clock clock, zzelh zzelh, zzehy zzehy, zzfjs zzfjs) {
        this.zza = clock;
        this.zzb = zzelh;
        this.zze = ((Boolean) zzbgq.zzc().zzb(zzblj.zzfk)).booleanValue();
        this.zzf = zzehy;
        this.zzc = zzfjs;
    }

    public static /* bridge */ /* synthetic */ void zzg(zzelg zzelg, String str, int i11, long j11, String str2) {
        StringBuilder sb2 = new StringBuilder(str.length() + 33);
        sb2.append(str);
        sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        sb2.append(i11);
        sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        sb2.append(j11);
        String sb3 = sb2.toString();
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb4 = new StringBuilder(sb3.length() + 1 + String.valueOf(str2).length());
            sb4.append(sb3);
            sb4.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            sb4.append(str2);
            sb3 = sb4.toString();
        }
        zzelg.zzd.add(sb3);
    }

    public final <T> zzfxa<T> zze(zzfdz zzfdz, zzfdn zzfdn, zzfxa<T> zzfxa, zzfjp zzfjp) {
        zzfdq zzfdq = zzfdz.zzb.zzb;
        long elapsedRealtime = this.zza.elapsedRealtime();
        String str = zzfdn.zzx;
        if (str != null) {
            zzfwq.zzr(zzfxa, new zzelf(this, elapsedRealtime, str, zzfdn, zzfdq, zzfjp, zzfdz), zzcjm.zzf);
        }
        return zzfxa;
    }

    public final String zzf() {
        return TextUtils.join(JavaConstant.Dynamic.DEFAULT_NAME, this.zzd);
    }
}
