package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.List;

public class zzau {
    public final Uri zza;
    @Nullable
    public final String zzb = null;
    @Nullable
    public final zzao zzc = null;
    @Nullable
    public final zzae zzd = null;
    public final List zze;
    @Nullable
    public final String zzf;
    public final zzfss<zzax> zzg;
    @Deprecated
    public final List zzh;
    @Nullable
    public final Object zzi;

    public /* synthetic */ zzau(Uri uri, String str, zzao zzao, zzae zzae, List list, String str2, zzfss zzfss, Object obj, zzat zzat) {
        this.zza = uri;
        this.zze = list;
        this.zzf = null;
        this.zzg = zzfss;
        zzfsp zzi2 = zzfss.zzi();
        if (zzfss.size() <= 0) {
            this.zzh = zzi2.zzf();
            this.zzi = null;
            return;
        }
        zzax zzax = (zzax) zzfss.get(0);
        throw null;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzau)) {
            return false;
        }
        zzau zzau = (zzau) obj;
        if (!this.zza.equals(zzau.zza) || !zzfn.zzP((Object) null, (Object) null) || !zzfn.zzP((Object) null, (Object) null) || !zzfn.zzP((Object) null, (Object) null) || !this.zze.equals(zzau.zze) || !zzfn.zzP((Object) null, (Object) null) || !this.zzg.equals(zzau.zzg) || !zzfn.zzP((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() * 923521) + this.zze.hashCode()) * 961) + this.zzg.hashCode()) * 31;
    }
}
