package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

public final class zzbay {
    private final zzbbc zza;
    @GuardedBy("this")
    private final zzbcl zzb;
    private final boolean zzc;

    private zzbay() {
        this.zzb = zzbcm.zzd();
        this.zzc = false;
        this.zza = new zzbbc();
    }

    public static zzbay zza() {
        return new zzbay();
    }

    private final synchronized String zzd(int i11) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.zzb.zzk(), Long.valueOf(zzt.zzA().elapsedRealtime()), Integer.valueOf(i11 - 1), Base64.encodeToString(((zzbcm) this.zzb.zzah()).zzar(), 3)});
    }

    private final synchronized void zze(int i11) {
        FileOutputStream fileOutputStream;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(zzd(i11).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zze.zza("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zze.zza("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zze.zza("Could not close Clearcut output stream.");
                    }
                }
            } catch (FileNotFoundException unused4) {
                zze.zza("Could not find file for Clearcut");
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                    zze.zza("Could not close Clearcut output stream.");
                }
                throw th2;
            }
        }
    }

    private final synchronized void zzf(int i11) {
        String str;
        zzbcl zzbcl = this.zzb;
        zzbcl.zzd();
        List<String> zzb2 = zzblj.zzb();
        ArrayList arrayList = new ArrayList();
        for (String split : zzb2) {
            for (String valueOf : split.split(",")) {
                try {
                    arrayList.add(Long.valueOf(valueOf));
                } catch (NumberFormatException unused) {
                    zze.zza("Experiment ID is not a number");
                }
            }
        }
        zzbcl.zzc(arrayList);
        zzbbb zzbbb = new zzbbb(this.zza, ((zzbcm) this.zzb.zzah()).zzar(), (zzbba) null);
        int i12 = i11 - 1;
        zzbbb.zza(i12);
        zzbbb.zzb();
        String valueOf2 = String.valueOf(Integer.toString(i12, 10));
        if (valueOf2.length() != 0) {
            str = "Logging Event with event code : ".concat(valueOf2);
        } else {
            str = new String("Logging Event with event code : ");
        }
        zze.zza(str);
    }

    public final synchronized void zzb(zzbax zzbax) {
        if (this.zzc) {
            try {
                zzbax.zza(this.zzb);
            } catch (NullPointerException e11) {
                zzt.zzo().zzs(e11, "AdMobClearcutLogger.modify");
            }
        }
    }

    public final synchronized void zzc(int i11) {
        if (this.zzc) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdw)).booleanValue()) {
                zze(i11);
            } else {
                zzf(i11);
            }
        }
    }

    public zzbay(zzbbc zzbbc) {
        this.zzb = zzbcm.zzd();
        this.zza = zzbbc;
        this.zzc = ((Boolean) zzbgq.zzc().zzb(zzblj.zzdv)).booleanValue();
    }
}
