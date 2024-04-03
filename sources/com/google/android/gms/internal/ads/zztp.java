package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zztp implements zzdi {
    private final Context zza;
    private final List<zzdx> zzb = new ArrayList();
    private final zzdi zzc;
    @Nullable
    private zzdi zzd;
    @Nullable
    private zzdi zze;
    @Nullable
    private zzdi zzf;
    @Nullable
    private zzdi zzg;
    @Nullable
    private zzdi zzh;
    @Nullable
    private zzdi zzi;
    @Nullable
    private zzdi zzj;
    @Nullable
    private zzdi zzk;

    public zztp(Context context, zzdi zzdi) {
        this.zza = context.getApplicationContext();
        this.zzc = zzdi;
    }

    private final zzdi zzc() {
        if (this.zze == null) {
            zzsz zzsz = new zzsz(this.zza);
            this.zze = zzsz;
            zzd(zzsz);
        }
        return this.zze;
    }

    private final void zzd(zzdi zzdi) {
        for (int i11 = 0; i11 < this.zzb.size(); i11++) {
            zzdi.zzb(this.zzb.get(i11));
        }
    }

    private static final void zze(@Nullable zzdi zzdi, zzdx zzdx) {
        if (zzdi != null) {
            zzdi.zzb(zzdx);
        }
    }

    public final Map<String, List<String>> zza() {
        zzdi zzdi = this.zzk;
        return zzdi == null ? Collections.emptyMap() : zzdi.zza();
    }

    public final void zzb(zzdx zzdx) {
        zzdx.getClass();
        this.zzc.zzb(zzdx);
        this.zzb.add(zzdx);
        zze(this.zzd, zzdx);
        zze(this.zze, zzdx);
        zze(this.zzf, zzdx);
        zze(this.zzg, zzdx);
        zze(this.zzh, zzdx);
        zze(this.zzi, zzdx);
        zze(this.zzj, zzdx);
    }

    public final int zzg(byte[] bArr, int i11, int i12) throws IOException {
        zzdi zzdi = this.zzk;
        zzdi.getClass();
        return zzdi.zzg(bArr, i11, i12);
    }

    public final long zzh(zzdm zzdm) throws IOException {
        boolean z11;
        zzdi zzdi;
        if (this.zzk == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        String scheme = zzdm.zza.getScheme();
        if (zzfn.zzS(zzdm.zza)) {
            String path = zzdm.zza.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    zztt zztt = new zztt();
                    this.zzd = zztt;
                    zzd(zztt);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzc();
            }
        } else if ("asset".equals(scheme)) {
            this.zzk = zzc();
        } else if ("content".equals(scheme)) {
            if (this.zzf == null) {
                zzti zzti = new zzti(this.zza);
                this.zzf = zzti;
                zzd(zzti);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    zzdi zzdi2 = (zzdi) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.zzg = zzdi2;
                    zzd(zzdi2);
                } catch (ClassNotFoundException unused) {
                    Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e11) {
                    throw new RuntimeException("Error instantiating RTMP extension", e11);
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                zzun zzun = new zzun(2000);
                this.zzh = zzun;
                zzd(zzun);
            }
            this.zzk = this.zzh;
        } else if ("data".equals(scheme)) {
            if (this.zzi == null) {
                zztj zztj = new zztj();
                this.zzi = zztj;
                zzd(zztj);
            }
            this.zzk = this.zzi;
        } else {
            if (RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(scheme) || "android.resource".equals(scheme)) {
                if (this.zzj == null) {
                    zzuf zzuf = new zzuf(this.zza);
                    this.zzj = zzuf;
                    zzd(zzuf);
                }
                zzdi = this.zzj;
            } else {
                zzdi = this.zzc;
            }
            this.zzk = zzdi;
        }
        return this.zzk.zzh(zzdm);
    }

    @Nullable
    public final Uri zzi() {
        zzdi zzdi = this.zzk;
        if (zzdi == null) {
            return null;
        }
        return zzdi.zzi();
    }

    public final void zzj() throws IOException {
        zzdi zzdi = this.zzk;
        if (zzdi != null) {
            try {
                zzdi.zzj();
            } finally {
                this.zzk = null;
            }
        }
    }
}
