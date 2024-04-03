package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzand extends zzaoa {
    private static final zzaob<zzakf> zzi = new zzaob<>();
    private final Context zzj;

    public zzand(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12, Context context, zzais zzais) {
        super(zzams, "iH08ecr5p8p5eQT3/BFJ6jAaJm3eLNoIe2oA7hLZl5P0jAtinrUdPK16lrJGpxBz", "Gvy6wet11FtrNaAWhnvYSI1hOQnkPBTAgqoI9PXuwaM=", zzaiz, i11, 27);
        this.zzj = context;
    }

    private final String zzc() {
        try {
            if (this.zzb.zzl() != null) {
                this.zzb.zzl().get();
            }
            zzajp zzc = this.zzb.zzc();
            if (zzc == null || !zzc.zzae()) {
                return null;
            }
            return zzc.zzh();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzakf zzakf;
        int i11;
        boolean z11;
        String str;
        Boolean bool;
        AtomicReference<zzakf> zza = zzi.zza(this.zzj.getPackageName());
        synchronized (zza) {
            zzakf zzakf2 = zza.get();
            if (zzakf2 == null || zzamv.zzg(zzakf2.zza) || zzakf2.zza.equals(ExifInterface.LONGITUDE_EAST) || zzakf2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (!zzamv.zzg((String) null)) {
                    i11 = 5;
                } else {
                    if (!zzamv.zzg((String) null)) {
                        bool = Boolean.FALSE;
                    } else {
                        bool = Boolean.FALSE;
                    }
                    if (!bool.booleanValue() || !this.zzb.zzp()) {
                        i11 = 3;
                    } else {
                        i11 = 4;
                    }
                }
                if (i11 == 3) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Boolean valueOf = Boolean.valueOf(z11);
                Boolean bool2 = (Boolean) zzbgq.zzc().zzb(zzblj.zzbH);
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbG)).booleanValue()) {
                    str = zzb();
                } else {
                    str = null;
                }
                if (bool2.booleanValue() && this.zzb.zzp() && zzamv.zzg(str)) {
                    str = zzc();
                }
                zzakf zzakf3 = new zzakf((String) this.zzf.invoke((Object) null, new Object[]{this.zzj, valueOf, str}));
                if (zzamv.zzg(zzakf3.zza) || zzakf3.zza.equals(ExifInterface.LONGITUDE_EAST)) {
                    int i12 = i11 - 1;
                    if (i12 == 3) {
                        String zzc = zzc();
                        if (!zzamv.zzg(zzc)) {
                            zzakf3.zza = zzc;
                        }
                    } else if (i12 == 4) {
                        throw null;
                    }
                }
                zza.set(zzakf3);
            }
            zzakf = zza.get();
        }
        synchronized (this.zze) {
            if (zzakf != null) {
                this.zze.zzt(zzakf.zza);
                this.zze.zzS(zzakf.zzb);
                this.zze.zzU(zzakf.zzc);
                this.zze.zzg(zzakf.zzd);
                this.zze.zzs(zzakf.zze);
            }
        }
    }

    public final String zzb() {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byte[] zzi2 = zzamv.zzi((String) zzbgq.zzc().zzb(zzblj.zzbI));
            ArrayList arrayList = new ArrayList();
            arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzi2)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzamv.zzi((String) zzbgq.zzc().zzb(zzblj.zzbJ)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zzb.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH)) {
                return null;
            }
            zzfxi zza = zzfxi.zza();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new zzaoc(zza));
            return (String) zza.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
