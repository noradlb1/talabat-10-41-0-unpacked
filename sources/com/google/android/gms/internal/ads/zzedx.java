package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

public final class zzedx extends zzedr {
    private String zzg;
    private int zzh = 1;

    public zzedx(Context context) {
        this.zzf = new zzcdb(context, zzt.zzt().zzb(), this, this);
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    int i11 = this.zzh;
                    if (i11 == 2) {
                        this.zzf.zzp().zze(this.zze, new zzedq(this));
                    } else if (i11 == 3) {
                        this.zzf.zzp().zzh(this.zzg, new zzedq(this));
                    } else {
                        this.zza.zze(new zzeeg(1));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zze(new zzeeg(1));
                } catch (Throwable th2) {
                    zzt.zzo().zzs(th2, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zza.zze(new zzeeg(1));
                }
            }
        }
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzciz.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zze(new zzeeg(1));
    }

    public final zzfxa<InputStream> zzb(zzcdq zzcdq) {
        synchronized (this.zzb) {
            int i11 = this.zzh;
            if (i11 != 1 && i11 != 2) {
                zzfxa<InputStream> zzh2 = zzfwq.zzh(new zzeeg(2));
                return zzh2;
            } else if (this.zzc) {
                zzcjr<InputStream> zzcjr = this.zza;
                return zzcjr;
            } else {
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzcdq;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.zzc(new zzedv(this), zzcjm.zzf);
                zzcjr<InputStream> zzcjr2 = this.zza;
                return zzcjr2;
            }
        }
    }

    public final zzfxa<InputStream> zzc(String str) {
        synchronized (this.zzb) {
            int i11 = this.zzh;
            if (i11 != 1 && i11 != 3) {
                zzfxa<InputStream> zzh2 = zzfwq.zzh(new zzeeg(2));
                return zzh2;
            } else if (this.zzc) {
                zzcjr<InputStream> zzcjr = this.zza;
                return zzcjr;
            } else {
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.zzc(new zzedw(this), zzcjm.zzf);
                zzcjr<InputStream> zzcjr2 = this.zza;
                return zzcjr2;
            }
        }
    }
}
