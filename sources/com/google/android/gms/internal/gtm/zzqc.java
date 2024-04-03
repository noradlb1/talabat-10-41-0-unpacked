package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.nio.charset.Charset;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

class zzqc extends zzqb {
    protected final byte[] zzawe;

    public zzqc(byte[] bArr) {
        bArr.getClass();
        this.zzawe = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzps) || size() != ((zzps) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzqc)) {
            return obj.equals(this);
        }
        zzqc zzqc = (zzqc) obj;
        int zzne = zzne();
        int zzne2 = zzqc.zzne();
        if (zzne == 0 || zzne2 == 0 || zzne == zzne2) {
            return zza(zzqc, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzawe.length;
    }

    public final void zza(zzpr zzpr) throws IOException {
        zzpr.zza(this.zzawe, zznf(), size());
    }

    public byte zzak(int i11) {
        return this.zzawe[i11];
    }

    public byte zzal(int i11) {
        return this.zzawe[i11];
    }

    public final zzps zzc(int i11, int i12) {
        int zzb = zzps.zzb(0, i12, size());
        if (zzb == 0) {
            return zzps.zzavx;
        }
        return new zzpx(this.zzawe, zznf(), zzb);
    }

    public final boolean zznd() {
        int zznf = zznf();
        return zztz.zzf(this.zzawe, zznf, size() + zznf);
    }

    public int zznf() {
        return 0;
    }

    public final String zza(Charset charset) {
        return new String(this.zzawe, zznf(), size(), charset);
    }

    public final boolean zza(zzps zzps, int i11, int i12) {
        if (i12 > zzps.size()) {
            int size = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i12);
            sb2.append(size);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i12 > zzps.size()) {
            int size2 = zzps.size();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: 0, ");
            sb3.append(i12);
            sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb3.append(size2);
            throw new IllegalArgumentException(sb3.toString());
        } else if (!(zzps instanceof zzqc)) {
            return zzps.zzc(0, i12).equals(zzc(0, i12));
        } else {
            zzqc zzqc = (zzqc) zzps;
            if (zztx.zza(this.zzawe, zznf(), zzqc.zzawe, zzqc.zznf(), i12) == -1) {
                return true;
            }
            return false;
        }
    }

    public final int zza(int i11, int i12, int i13) {
        return zzre.zza(i11, this.zzawe, zznf(), i13);
    }
}
