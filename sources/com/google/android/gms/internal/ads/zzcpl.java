package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.deliveryhero.performance.core.logger.TraceLogKt;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpl extends zzbiy {
    private final zzclh zza;
    private final Object zzb = new Object();
    private final boolean zzc;
    private final boolean zzd;
    @GuardedBy("lock")
    private int zze;
    @GuardedBy("lock")
    @Nullable
    private zzbjc zzf;
    @GuardedBy("lock")
    private boolean zzg;
    @GuardedBy("lock")
    private boolean zzh = true;
    @GuardedBy("lock")
    private float zzi;
    @GuardedBy("lock")
    private float zzj;
    @GuardedBy("lock")
    private float zzk;
    @GuardedBy("lock")
    private boolean zzl;
    @GuardedBy("lock")
    private boolean zzm;
    @GuardedBy("lock")
    private zzbpq zzn;

    public zzcpl(zzclh zzclh, float f11, boolean z11, boolean z12) {
        this.zza = zzclh;
        this.zzi = f11;
        this.zzc = z11;
        this.zzd = z12;
    }

    private final void zzw(int i11, int i12, boolean z11, boolean z12) {
        zzcjm.zze.execute(new zzcpj(this, i11, i12, z11, z12));
    }

    private final void zzx(String str, @Nullable Map<String, String> map) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        zzcjm.zze.execute(new zzcpk(this, hashMap));
    }

    public final void zzc(float f11, float f12, int i11, boolean z11, float f13) {
        boolean z12;
        boolean z13;
        int i12;
        synchronized (this.zzb) {
            z12 = true;
            if (f12 == this.zzi) {
                if (f13 == this.zzk) {
                    z12 = false;
                }
            }
            this.zzi = f12;
            this.zzj = f11;
            z13 = this.zzh;
            this.zzh = z11;
            i12 = this.zze;
            this.zze = i11;
            float f14 = this.zzk;
            this.zzk = f13;
            if (Math.abs(f13 - f14) > 1.0E-4f) {
                this.zza.zzH().invalidate();
            }
        }
        if (z12) {
            try {
                zzbpq zzbpq = this.zzn;
                if (zzbpq != null) {
                    zzbpq.zze();
                }
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        }
        zzw(i12, i11, z13, z11);
    }

    public final /* synthetic */ void zzd(int i11, int i12, boolean z11, boolean z12) {
        boolean z13;
        int i13;
        boolean z14;
        boolean z15;
        boolean z16;
        zzbjc zzbjc;
        zzbjc zzbjc2;
        zzbjc zzbjc3;
        synchronized (this.zzb) {
            boolean z17 = this.zzg;
            boolean z18 = false;
            if (z17 || i12 != 1) {
                i13 = i12;
                z13 = false;
            } else {
                i13 = 1;
                z13 = true;
            }
            if (i11 == i12 || i13 != 1) {
                z14 = false;
            } else {
                i13 = 1;
                z14 = true;
            }
            if (i11 == i12 || i13 != 2) {
                z15 = false;
            } else {
                z15 = true;
            }
            if (i11 == i12 || i13 != 3) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z17 || z13) {
                z18 = true;
            }
            this.zzg = z18;
            if (z13) {
                try {
                    zzbjc zzbjc4 = this.zzf;
                    if (zzbjc4 != null) {
                        zzbjc4.zzi();
                    }
                } catch (RemoteException e11) {
                    zzciz.zzl("#007 Could not call remote method.", e11);
                }
            }
            if (z14 && (zzbjc3 = this.zzf) != null) {
                zzbjc3.zzh();
            }
            if (z15 && (zzbjc2 = this.zzf) != null) {
                zzbjc2.zzg();
            }
            if (z16) {
                zzbjc zzbjc5 = this.zzf;
                if (zzbjc5 != null) {
                    zzbjc5.zze();
                }
                this.zza.zzy();
            }
            if (!(z11 == z12 || (zzbjc = this.zzf) == null)) {
                zzbjc.zzf(z12);
            }
        }
    }

    public final float zze() {
        float f11;
        synchronized (this.zzb) {
            f11 = this.zzk;
        }
        return f11;
    }

    public final float zzf() {
        float f11;
        synchronized (this.zzb) {
            f11 = this.zzj;
        }
        return f11;
    }

    public final float zzg() {
        float f11;
        synchronized (this.zzb) {
            f11 = this.zzi;
        }
        return f11;
    }

    public final int zzh() {
        int i11;
        synchronized (this.zzb) {
            i11 = this.zze;
        }
        return i11;
    }

    @Nullable
    public final zzbjc zzi() throws RemoteException {
        zzbjc zzbjc;
        synchronized (this.zzb) {
            zzbjc = this.zzf;
        }
        return zzbjc;
    }

    public final void zzj(boolean z11) {
        String str;
        if (true != z11) {
            str = "unmute";
        } else {
            str = "mute";
        }
        zzx(str, (Map<String, String>) null);
    }

    public final void zzk() {
        zzx("pause", (Map<String, String>) null);
    }

    public final void zzl() {
        zzx("play", (Map<String, String>) null);
    }

    public final void zzm(@Nullable zzbjc zzbjc) {
        synchronized (this.zzb) {
            this.zzf = zzbjc;
        }
    }

    public final void zzn() {
        zzx(TraceLogKt.STOP_PROPERTY_NAME, (Map<String, String>) null);
    }

    public final boolean zzo() {
        boolean z11;
        boolean zzp = zzp();
        synchronized (this.zzb) {
            z11 = false;
            if (!zzp) {
                try {
                    if (this.zzm && this.zzd) {
                        z11 = true;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return z11;
    }

    public final boolean zzp() {
        boolean z11;
        synchronized (this.zzb) {
            z11 = false;
            if (this.zzc && this.zzl) {
                z11 = true;
            }
        }
        return z11;
    }

    public final boolean zzq() {
        boolean z11;
        synchronized (this.zzb) {
            z11 = this.zzh;
        }
        return z11;
    }

    public final /* synthetic */ void zzr(Map map) {
        this.zza.zzd("pubVideoCmd", map);
    }

    public final void zzs(zzbkq zzbkq) {
        String str;
        String str2;
        String str3;
        boolean z11 = zzbkq.zza;
        boolean z12 = zzbkq.zzb;
        boolean z13 = zzbkq.zzc;
        synchronized (this.zzb) {
            this.zzl = z12;
            this.zzm = z13;
        }
        if (true != z11) {
            str = "0";
        } else {
            str = "1";
        }
        String str4 = str;
        if (true != z12) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        String str5 = str2;
        if (true != z13) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        zzx("initialState", CollectionUtils.mapOf("muteStart", str4, "customControlsRequested", str5, "clickToExpandRequested", str3));
    }

    public final void zzt(float f11) {
        synchronized (this.zzb) {
            this.zzj = f11;
        }
    }

    public final void zzu() {
        boolean z11;
        int i11;
        synchronized (this.zzb) {
            z11 = this.zzh;
            i11 = this.zze;
            this.zze = 3;
        }
        zzw(i11, 3, z11, z11);
    }

    public final void zzv(zzbpq zzbpq) {
        synchronized (this.zzb) {
            this.zzn = zzbpq;
        }
    }
}
