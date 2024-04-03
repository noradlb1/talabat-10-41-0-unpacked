package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzfed {
    /* access modifiers changed from: private */
    public zzbfd zza;
    /* access modifiers changed from: private */
    public zzbfi zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public zzbkq zzd;
    /* access modifiers changed from: private */
    public boolean zze;
    /* access modifiers changed from: private */
    public ArrayList<String> zzf;
    /* access modifiers changed from: private */
    public ArrayList<String> zzg;
    /* access modifiers changed from: private */
    public zzbnw zzh;
    /* access modifiers changed from: private */
    public zzbfo zzi;
    /* access modifiers changed from: private */
    public AdManagerAdViewOptions zzj;
    /* access modifiers changed from: private */
    public PublisherAdViewOptions zzk;
    /* access modifiers changed from: private */
    @Nullable
    public zzbhr zzl;
    /* access modifiers changed from: private */
    public int zzm = 1;
    /* access modifiers changed from: private */
    public zzbtz zzn;
    /* access modifiers changed from: private */
    public final zzfdt zzo = new zzfdt();
    /* access modifiers changed from: private */
    public boolean zzp = false;
    /* access modifiers changed from: private */
    @Nullable
    public zzeox zzq;
    /* access modifiers changed from: private */
    public zzbhv zzr;

    public final zzfed zzA(ArrayList<String> arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzfed zzB(ArrayList<String> arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzfed zzC(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zzc();
            this.zzl = publisherAdViewOptions.zza();
        }
        return this;
    }

    public final zzfed zzD(zzbfd zzbfd) {
        this.zza = zzbfd;
        return this;
    }

    public final zzfed zzE(zzbkq zzbkq) {
        this.zzd = zzbkq;
        return this;
    }

    public final zzfef zzF() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzfef(this, (zzfee) null);
    }

    public final String zzH() {
        return this.zzc;
    }

    public final boolean zzM() {
        return this.zzp;
    }

    public final zzfed zzO(zzbhv zzbhv) {
        this.zzr = zzbhv;
        return this;
    }

    public final zzbfd zze() {
        return this.zza;
    }

    public final zzbfi zzg() {
        return this.zzb;
    }

    public final zzfdt zzo() {
        return this.zzo;
    }

    public final zzfed zzp(zzfef zzfef) {
        this.zzo.zza(zzfef.zzo.zza);
        this.zza = zzfef.zzd;
        this.zzb = zzfef.zze;
        this.zzr = zzfef.zzq;
        this.zzc = zzfef.zzf;
        this.zzd = zzfef.zza;
        this.zzf = zzfef.zzg;
        this.zzg = zzfef.zzh;
        this.zzh = zzfef.zzi;
        this.zzi = zzfef.zzj;
        zzq(zzfef.zzl);
        zzC(zzfef.zzm);
        this.zzp = zzfef.zzp;
        this.zzq = zzfef.zzc;
        return this;
    }

    public final zzfed zzq(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzfed zzr(zzbfi zzbfi) {
        this.zzb = zzbfi;
        return this;
    }

    public final zzfed zzs(String str) {
        this.zzc = str;
        return this;
    }

    public final zzfed zzt(zzbfo zzbfo) {
        this.zzi = zzbfo;
        return this;
    }

    public final zzfed zzu(zzeox zzeox) {
        this.zzq = zzeox;
        return this;
    }

    public final zzfed zzv(zzbtz zzbtz) {
        this.zzn = zzbtz;
        this.zzd = new zzbkq(false, true, false);
        return this;
    }

    public final zzfed zzw(boolean z11) {
        this.zzp = z11;
        return this;
    }

    public final zzfed zzx(boolean z11) {
        this.zze = z11;
        return this;
    }

    public final zzfed zzy(int i11) {
        this.zzm = i11;
        return this;
    }

    public final zzfed zzz(zzbnw zzbnw) {
        this.zzh = zzbnw;
        return this;
    }
}
