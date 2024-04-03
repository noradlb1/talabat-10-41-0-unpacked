package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zzbjg {
    private final Date zza;
    private final String zzb;
    private final List<String> zzc;
    private final int zzd;
    private final Set<String> zze;
    private final Location zzf;
    private final Bundle zzg;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzh;
    private final String zzi;
    private final String zzj;
    @NotOnlyInitialized
    @Nullable
    private final SearchAdRequest zzk;
    private final int zzl;
    private final Set<String> zzm;
    private final Bundle zzn;
    private final Set<String> zzo;
    private final boolean zzp;
    private final AdInfo zzq;
    private final String zzr;
    private final int zzs;

    public zzbjg(zzbjf zzbjf, @Nullable SearchAdRequest searchAdRequest) {
        this.zza = zzbjf.zzg;
        this.zzb = zzbjf.zzh;
        this.zzc = zzbjf.zzi;
        this.zzd = zzbjf.zzj;
        this.zze = Collections.unmodifiableSet(zzbjf.zza);
        this.zzf = zzbjf.zzk;
        this.zzg = zzbjf.zzb;
        this.zzh = Collections.unmodifiableMap(zzbjf.zzc);
        this.zzi = zzbjf.zzl;
        this.zzj = zzbjf.zzm;
        this.zzk = searchAdRequest;
        this.zzl = zzbjf.zzn;
        this.zzm = Collections.unmodifiableSet(zzbjf.zzd);
        this.zzn = zzbjf.zze;
        this.zzo = Collections.unmodifiableSet(zzbjf.zzf);
        this.zzp = zzbjf.zzo;
        this.zzq = zzbjf.zzp;
        this.zzr = zzbjf.zzq;
        this.zzs = zzbjf.zzr;
    }

    @Deprecated
    public final int zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zzs;
    }

    public final int zzc() {
        return this.zzl;
    }

    public final Location zzd() {
        return this.zzf;
    }

    @Nullable
    public final Bundle zze(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzg.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle zzf() {
        return this.zzn;
    }

    @Nullable
    public final Bundle zzg(Class<? extends MediationExtrasReceiver> cls) {
        return this.zzg.getBundle(cls.getName());
    }

    public final Bundle zzh() {
        return this.zzg;
    }

    @Deprecated
    @Nullable
    public final <T extends NetworkExtras> T zzi(Class<T> cls) {
        return (NetworkExtras) this.zzh.get(cls);
    }

    @Nullable
    public final AdInfo zzj() {
        return this.zzq;
    }

    @Nullable
    public final SearchAdRequest zzk() {
        return this.zzk;
    }

    @Nullable
    public final String zzl() {
        return this.zzr;
    }

    public final String zzm() {
        return this.zzb;
    }

    public final String zzn() {
        return this.zzi;
    }

    public final String zzo() {
        return this.zzj;
    }

    @Deprecated
    public final Date zzp() {
        return this.zza;
    }

    public final List<String> zzq() {
        return new ArrayList(this.zzc);
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzr() {
        return this.zzh;
    }

    public final Set<String> zzs() {
        return this.zzo;
    }

    public final Set<String> zzt() {
        return this.zze;
    }

    @Deprecated
    public final boolean zzu() {
        return this.zzp;
    }

    public final boolean zzv(Context context) {
        RequestConfiguration zzc2 = zzbjq.zzf().zzc();
        zzbgo.zzb();
        String zzt = zzcis.zzt(context);
        if (this.zzm.contains(zzt) || zzc2.getTestDeviceIds().contains(zzt)) {
            return true;
        }
        return false;
    }
}
