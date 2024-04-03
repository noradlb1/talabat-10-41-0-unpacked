package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzdm {
    public final Uri zza;
    public final int zzb;
    @Nullable
    public final byte[] zzc;
    public final Map<String, String> zzd;
    @Deprecated
    public final long zze;
    public final long zzf;
    public final long zzg;
    @Nullable
    public final String zzh;
    public final int zzi;

    private zzdm(Uri uri, long j11, int i11, @Nullable byte[] bArr, Map<String, String> map, long j12, long j13, @Nullable String str, int i12, @Nullable Object obj) {
        long j14 = j11 + j12;
        boolean z11 = false;
        zzdy.zzd(j14 >= 0);
        zzdy.zzd(j12 >= 0);
        zzdy.zzd((j13 > 0 || j13 == -1) ? true : z11);
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap(map));
        this.zzf = j12;
        this.zze = j14;
        this.zzg = j13;
        this.zzh = null;
        this.zzi = i12;
    }

    public /* synthetic */ zzdm(Uri uri, long j11, int i11, byte[] bArr, Map map, long j12, long j13, String str, int i12, Object obj, zzdl zzdl) {
        this(uri, 0, 1, (byte[]) null, map, j12, -1, (String) null, i12, (Object) null);
    }

    public static String zza(int i11) {
        return "GET";
    }

    public final String toString() {
        String zza2 = zza(1);
        String valueOf = String.valueOf(this.zza);
        long j11 = this.zzf;
        long j12 = this.zzg;
        int i11 = this.zzi;
        StringBuilder sb2 = new StringBuilder(zza2.length() + 70 + valueOf.length() + 4);
        sb2.append("DataSpec[");
        sb2.append(zza2);
        sb2.append(" ");
        sb2.append(valueOf);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(j11);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(j12);
        sb2.append(", null, ");
        sb2.append(i11);
        sb2.append("]");
        return sb2.toString();
    }

    public final boolean zzb(int i11) {
        return (this.zzi & i11) == i11;
    }

    @Deprecated
    public zzdm(Uri uri, @Nullable byte[] bArr, long j11, long j12, long j13, @Nullable String str, int i11) {
        this(uri, j11 - j12, 1, (byte[]) null, Collections.emptyMap(), j12, j13, (String) null, i11, (Object) null);
    }
}
