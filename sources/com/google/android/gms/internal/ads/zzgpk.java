package com.google.android.gms.internal.ads;

public final class zzgpk {
    public static final zzgpk zza = new zzgpk(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final zzgpk zzb = new zzgpk(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final zzgpk zzc = new zzgpk(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final zzgpk zzd = new zzgpk(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public final double zze;
    public final double zzf;
    public final double zzg;
    public final double zzh;
    public final double zzi;
    public final double zzj;
    public final double zzk;
    public final double zzl;
    public final double zzm;

    public zzgpk(double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19) {
        this.zze = d15;
        this.zzf = d16;
        this.zzg = d17;
        this.zzh = d11;
        this.zzi = d12;
        this.zzj = d13;
        this.zzk = d14;
        this.zzl = d18;
        this.zzm = d19;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzgpk.class != obj.getClass()) {
            return false;
        }
        zzgpk zzgpk = (zzgpk) obj;
        if (Double.compare(zzgpk.zzh, this.zzh) == 0 && Double.compare(zzgpk.zzi, this.zzi) == 0 && Double.compare(zzgpk.zzj, this.zzj) == 0 && Double.compare(zzgpk.zzk, this.zzk) == 0 && Double.compare(zzgpk.zzl, this.zzl) == 0 && Double.compare(zzgpk.zzm, this.zzm) == 0 && Double.compare(zzgpk.zze, this.zze) == 0 && Double.compare(zzgpk.zzf, this.zzf) == 0 && Double.compare(zzgpk.zzg, this.zzg) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zze);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzf);
        long doubleToLongBits3 = Double.doubleToLongBits(this.zzg);
        long doubleToLongBits4 = Double.doubleToLongBits(this.zzh);
        long doubleToLongBits5 = Double.doubleToLongBits(this.zzi);
        long doubleToLongBits6 = Double.doubleToLongBits(this.zzj);
        long doubleToLongBits7 = Double.doubleToLongBits(this.zzk);
        long doubleToLongBits8 = Double.doubleToLongBits(this.zzl);
        long doubleToLongBits9 = Double.doubleToLongBits(this.zzm);
        return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) ((doubleToLongBits3 >>> 32) ^ doubleToLongBits3))) * 31) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4))) * 31) + ((int) ((doubleToLongBits5 >>> 32) ^ doubleToLongBits5))) * 31) + ((int) ((doubleToLongBits6 >>> 32) ^ doubleToLongBits6))) * 31) + ((int) ((doubleToLongBits7 >>> 32) ^ doubleToLongBits7))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) ((doubleToLongBits9 >>> 32) ^ doubleToLongBits9));
    }

    public final String toString() {
        if (equals(zza)) {
            return "Rotate 0°";
        }
        if (equals(zzb)) {
            return "Rotate 90°";
        }
        if (equals(zzc)) {
            return "Rotate 180°";
        }
        if (equals(zzd)) {
            return "Rotate 270°";
        }
        double d11 = this.zze;
        double d12 = this.zzf;
        double d13 = this.zzg;
        double d14 = this.zzh;
        double d15 = this.zzi;
        double d16 = this.zzj;
        double d17 = this.zzk;
        double d18 = this.zzl;
        double d19 = this.zzm;
        StringBuilder sb2 = new StringBuilder(260);
        sb2.append("Matrix{u=");
        sb2.append(d11);
        sb2.append(", v=");
        sb2.append(d12);
        sb2.append(", w=");
        sb2.append(d13);
        sb2.append(", a=");
        sb2.append(d14);
        sb2.append(", b=");
        sb2.append(d15);
        sb2.append(", c=");
        sb2.append(d16);
        sb2.append(", d=");
        sb2.append(d17);
        sb2.append(", tx=");
        sb2.append(d18);
        sb2.append(", ty=");
        sb2.append(d19);
        sb2.append("}");
        return sb2.toString();
    }
}
