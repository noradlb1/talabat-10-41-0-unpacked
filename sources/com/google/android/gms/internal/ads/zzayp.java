package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import net.bytebuddy.jar.asm.Opcodes;

@ParametersAreNonnullByDefault
public final class zzayp {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final zzaze zze;
    private final zzazm zzf;
    private final Object zzg = new Object();
    private final ArrayList<String> zzh = new ArrayList<>();
    private final ArrayList<String> zzi = new ArrayList<>();
    private final ArrayList<zzaza> zzj = new ArrayList<>();
    private int zzk = 0;
    private int zzl = 0;
    private int zzm = 0;
    private int zzn;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";

    public zzayp(int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z11) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = z11;
        this.zze = new zzaze(i14);
        this.zzf = new zzazm(i15, i16, i17);
    }

    private final void zzp(@Nullable String str, boolean z11, float f11, float f12, float f13, float f14) {
        if (str != null && str.length() >= this.zzc) {
            synchronized (this.zzg) {
                this.zzh.add(str);
                this.zzk += str.length();
                if (z11) {
                    this.zzi.add(str);
                    this.zzj.add(new zzaza(f11, f12, f13, f14, this.zzi.size() - 1));
                }
            }
        }
    }

    private static final String zzq(ArrayList<String> arrayList, int i11) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            sb2.append(arrayList.get(i12));
            sb2.append(' ');
            i12++;
            if (sb2.length() > 100) {
                break;
            }
        }
        sb2.deleteCharAt(sb2.length() - 1);
        String sb3 = sb2.toString();
        if (sb3.length() < 100) {
            return sb3;
        }
        return sb3.substring(0, 100);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzayp)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzayp) obj).zzo;
        if (str == null || !str.equals(this.zzo)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.zzo.hashCode();
    }

    public final String toString() {
        int i11 = this.zzl;
        int i12 = this.zzn;
        int i13 = this.zzk;
        String zzq2 = zzq(this.zzh, 100);
        String zzq3 = zzq(this.zzi, 100);
        String str = this.zzo;
        String str2 = this.zzp;
        String str3 = this.zzq;
        int length = String.valueOf(zzq2).length();
        int length2 = String.valueOf(zzq3).length();
        int length3 = String.valueOf(str).length();
        int length4 = String.valueOf(str2).length();
        StringBuilder sb2 = new StringBuilder(length + Opcodes.IF_ACMPEQ + length2 + length3 + length4 + String.valueOf(str3).length());
        sb2.append("ActivityContent fetchId: ");
        sb2.append(i11);
        sb2.append(" score:");
        sb2.append(i12);
        sb2.append(" total_length:");
        sb2.append(i13);
        sb2.append("\n text: ");
        sb2.append(zzq2);
        sb2.append("\n viewableText");
        sb2.append(zzq3);
        sb2.append("\n signture: ");
        sb2.append(str);
        sb2.append("\n viewableSignture: ");
        sb2.append(str2);
        sb2.append("\n viewableSignatureForVertical: ");
        sb2.append(str3);
        return sb2.toString();
    }

    @VisibleForTesting
    public final int zza(int i11, int i12) {
        return this.zzd ? this.zzb : (i11 * this.zza) + (i12 * this.zzb);
    }

    public final int zzb() {
        return this.zzn;
    }

    @VisibleForTesting
    public final int zzc() {
        return this.zzk;
    }

    public final String zzd() {
        return this.zzo;
    }

    public final String zze() {
        return this.zzp;
    }

    public final String zzf() {
        return this.zzq;
    }

    public final void zzg() {
        synchronized (this.zzg) {
            this.zzm--;
        }
    }

    public final void zzh() {
        synchronized (this.zzg) {
            this.zzm++;
        }
    }

    public final void zzi() {
        synchronized (this.zzg) {
            this.zzn -= 100;
        }
    }

    public final void zzj(int i11) {
        this.zzl = i11;
    }

    public final void zzk(String str, boolean z11, float f11, float f12, float f13, float f14) {
        zzp(str, z11, f11, f12, f13, f14);
    }

    public final void zzl(String str, boolean z11, float f11, float f12, float f13, float f14) {
        zzp(str, z11, f11, f12, f13, f14);
        synchronized (this.zzg) {
            if (this.zzm < 0) {
                zzciz.zze("ActivityContent: negative number of WebViews.");
            }
            zzm();
        }
    }

    public final void zzm() {
        synchronized (this.zzg) {
            int zza2 = zza(this.zzk, this.zzl);
            if (zza2 > this.zzn) {
                this.zzn = zza2;
                if (!zzt.zzo().zzh().zzI()) {
                    this.zzo = this.zze.zza(this.zzh);
                    this.zzp = this.zze.zza(this.zzi);
                }
                if (!zzt.zzo().zzh().zzJ()) {
                    this.zzq = this.zzf.zza(this.zzi, this.zzj);
                }
            }
        }
    }

    public final void zzn() {
        synchronized (this.zzg) {
            int zza2 = zza(this.zzk, this.zzl);
            if (zza2 > this.zzn) {
                this.zzn = zza2;
            }
        }
    }

    public final boolean zzo() {
        boolean z11;
        synchronized (this.zzg) {
            if (this.zzm == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }
}
