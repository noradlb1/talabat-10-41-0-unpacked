package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Map;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public abstract class zzags<T> implements Comparable<zzags<T>> {
    /* access modifiers changed from: private */
    public final zzahd zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    @GuardedBy("mLock")
    @Nullable
    private final zzagw zzf;
    private Integer zzg;
    private zzagv zzh;
    @GuardedBy("mLock")
    private boolean zzi;
    @Nullable
    private zzagb zzj;
    @GuardedBy("mLock")
    private zzagr zzk;
    private final zzagg zzl;

    public zzags(int i11, String str, @Nullable zzagw zzagw) {
        zzahd zzahd;
        Uri parse;
        String host;
        if (zzahd.zza) {
            zzahd = new zzahd();
        } else {
            zzahd = null;
        }
        this.zza = zzahd;
        this.zze = new Object();
        int i12 = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i11;
        this.zzc = str;
        this.zzf = zzagw;
        this.zzl = new zzagg();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i12 = host.hashCode();
        }
        this.zzd = i12;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzags) obj).zzg.intValue();
    }

    public final String toString() {
        String str;
        String valueOf = String.valueOf(Integer.toHexString(this.zzd));
        if (valueOf.length() != 0) {
            str = "0x".concat(valueOf);
        } else {
            str = new String("0x");
        }
        zzw();
        String str2 = this.zzc;
        String valueOf2 = String.valueOf(this.zzg);
        int length = String.valueOf(str2).length();
        StringBuilder sb2 = new StringBuilder(length + 7 + String.valueOf(str).length() + 6 + valueOf2.length());
        sb2.append("[ ] ");
        sb2.append(str2);
        sb2.append(" ");
        sb2.append(str);
        sb2.append(" NORMAL ");
        sb2.append(valueOf2);
        return sb2.toString();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    @Nullable
    public final zzagb zzd() {
        return this.zzj;
    }

    public final zzags<?> zze(zzagb zzagb) {
        this.zzj = zzagb;
        return this;
    }

    public final zzags<?> zzf(zzagv zzagv) {
        this.zzh = zzagv;
        return this;
    }

    public final zzags<?> zzg(int i11) {
        this.zzg = Integer.valueOf(i11);
        return this;
    }

    public abstract zzagy<T> zzh(zzago zzago);

    public final String zzj() {
        String str = this.zzc;
        if (this.zzb == 0) {
            return str;
        }
        String num = Integer.toString(1);
        StringBuilder sb2 = new StringBuilder(String.valueOf(num).length() + 1 + String.valueOf(str).length());
        sb2.append(num);
        sb2.append(SignatureVisitor.SUPER);
        sb2.append(str);
        return sb2.toString();
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map<String, String> zzl() throws zzaga {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzahd.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzahb zzahb) {
        zzagw zzagw;
        synchronized (this.zze) {
            zzagw = this.zzf;
        }
        if (zzagw != null) {
            zzagw.zza(zzahb);
        }
    }

    public abstract void zzo(T t11);

    public final void zzp(String str) {
        zzagv zzagv = this.zzh;
        if (zzagv != null) {
            zzagv.zzb(this);
        }
        if (zzahd.zza) {
            long id2 = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzagq(this, str, id2));
                return;
            }
            this.zza.zza(str, id2);
            this.zza.zzb(toString());
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    public final void zzr() {
        zzagr zzagr;
        synchronized (this.zze) {
            zzagr = this.zzk;
        }
        if (zzagr != null) {
            zzagr.zza(this);
        }
    }

    public final void zzs(zzagy<?> zzagy) {
        zzagr zzagr;
        synchronized (this.zze) {
            zzagr = this.zzk;
        }
        if (zzagr != null) {
            zzagr.zzb(this, zzagy);
        }
    }

    public final void zzt(int i11) {
        zzagv zzagv = this.zzh;
        if (zzagv != null) {
            zzagv.zzc(this, i11);
        }
    }

    public final void zzu(zzagr zzagr) {
        synchronized (this.zze) {
            this.zzk = zzagr;
        }
    }

    public final boolean zzv() {
        boolean z11;
        synchronized (this.zze) {
            z11 = this.zzi;
        }
        return z11;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() throws zzaga {
        return null;
    }

    public final zzagg zzy() {
        return this.zzl;
    }
}
