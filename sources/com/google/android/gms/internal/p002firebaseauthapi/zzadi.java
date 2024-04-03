package com.google.android.gms.internal.p002firebaseauthapi;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.zze;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadi  reason: invalid package */
public final class zzadi {
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private zzadx zzf;
    private String zzg;
    private String zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private zze zzl;
    private List zzm;

    public zzadi() {
        this.zzf = new zzadx();
    }

    public final long zza() {
        return this.zzi;
    }

    public final long zzb() {
        return this.zzj;
    }

    @Nullable
    public final Uri zzc() {
        if (!TextUtils.isEmpty(this.zze)) {
            return Uri.parse(this.zze);
        }
        return null;
    }

    @Nullable
    public final zze zzd() {
        return this.zzl;
    }

    @NonNull
    public final zzadi zze(zze zze2) {
        this.zzl = zze2;
        return this;
    }

    @NonNull
    public final zzadi zzf(@Nullable String str) {
        this.zzd = str;
        return this;
    }

    @NonNull
    public final zzadi zzg(@Nullable String str) {
        this.zzb = str;
        return this;
    }

    public final zzadi zzh(boolean z11) {
        this.zzk = z11;
        return this;
    }

    @NonNull
    public final zzadi zzi(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzg = str;
        return this;
    }

    @NonNull
    public final zzadi zzj(@Nullable String str) {
        this.zze = str;
        return this;
    }

    @NonNull
    public final zzadi zzk(List list) {
        Preconditions.checkNotNull(list);
        zzadx zzadx = new zzadx();
        this.zzf = zzadx;
        zzadx.zzc().addAll(list);
        return this;
    }

    public final zzadx zzl() {
        return this.zzf;
    }

    @Nullable
    public final String zzm() {
        return this.zzd;
    }

    @Nullable
    public final String zzn() {
        return this.zzb;
    }

    @NonNull
    public final String zzo() {
        return this.zza;
    }

    @Nullable
    public final String zzp() {
        return this.zzh;
    }

    @NonNull
    public final List zzq() {
        return this.zzm;
    }

    @NonNull
    public final List zzr() {
        return this.zzf.zzc();
    }

    public final boolean zzs() {
        return this.zzc;
    }

    public final boolean zzt() {
        return this.zzk;
    }

    public zzadi(String str, String str2, boolean z11, String str3, String str4, zzadx zzadx, String str5, String str6, long j11, long j12, boolean z12, zze zze2, List list) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = z11;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = zzadx.zzb(zzadx);
        this.zzg = str5;
        this.zzh = str6;
        this.zzi = j11;
        this.zzj = j12;
        this.zzk = false;
        this.zzl = null;
        this.zzm = list;
    }
}
