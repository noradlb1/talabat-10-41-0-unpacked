package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class zzbjf {
    /* access modifiers changed from: private */
    public final HashSet<String> zza = new HashSet<>();
    /* access modifiers changed from: private */
    public final Bundle zzb = new Bundle();
    /* access modifiers changed from: private */
    public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzc = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzd = new HashSet<>();
    /* access modifiers changed from: private */
    public final Bundle zze = new Bundle();
    /* access modifiers changed from: private */
    public final HashSet<String> zzf = new HashSet<>();
    /* access modifiers changed from: private */
    public Date zzg;
    /* access modifiers changed from: private */
    public String zzh;
    /* access modifiers changed from: private */
    public final List<String> zzi = new ArrayList();
    /* access modifiers changed from: private */
    public int zzj = -1;
    /* access modifiers changed from: private */
    public Location zzk;
    /* access modifiers changed from: private */
    public String zzl;
    /* access modifiers changed from: private */
    public String zzm;
    /* access modifiers changed from: private */
    public int zzn = -1;
    /* access modifiers changed from: private */
    public boolean zzo;
    /* access modifiers changed from: private */
    public AdInfo zzp;
    /* access modifiers changed from: private */
    public String zzq;
    /* access modifiers changed from: private */
    public int zzr = 60000;

    public final void zzA(String str) {
        this.zzq = str;
    }

    @Deprecated
    public final void zzB(Date date) {
        this.zzg = date;
    }

    public final void zzC(String str) {
        this.zzh = str;
    }

    @Deprecated
    public final void zzD(int i11) {
        this.zzj = i11;
    }

    public final void zzE(int i11) {
        this.zzr = i11;
    }

    @Deprecated
    public final void zzF(boolean z11) {
        this.zzo = z11;
    }

    public final void zzG(Location location) {
        this.zzk = location;
    }

    public final void zzH(List<String> list) {
        this.zzi.clear();
        for (String next : list) {
            if (TextUtils.isEmpty(next)) {
                zzciz.zzj("neighboring content URL should not be null or empty");
            } else {
                this.zzi.add(next);
            }
        }
    }

    public final void zzI(String str) {
        this.zzl = str;
    }

    public final void zzJ(String str) {
        this.zzm = str;
    }

    @Deprecated
    public final void zzK(boolean z11) {
        this.zzn = z11 ? 1 : 0;
    }

    public final void zzr(String str) {
        this.zzf.add(str);
    }

    public final void zzs(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzb.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzb.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        Bundle bundle2 = this.zzb.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        Preconditions.checkNotNull(bundle2);
        bundle2.putBundle(cls.getName(), bundle);
    }

    public final void zzt(String str, String str2) {
        this.zze.putString(str, str2);
    }

    public final void zzu(String str) {
        this.zza.add(str);
    }

    public final void zzv(Class<? extends MediationExtrasReceiver> cls, @Nullable Bundle bundle) {
        this.zzb.putBundle(cls.getName(), bundle);
    }

    @Deprecated
    public final void zzw(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zzv(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            return;
        }
        this.zzc.put(networkExtras.getClass(), networkExtras);
    }

    public final void zzx(String str) {
        this.zzd.add(str);
    }

    public final void zzy(String str) {
        this.zzd.remove("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    public final void zzz(AdInfo adInfo) {
        this.zzp = adInfo;
    }
}
