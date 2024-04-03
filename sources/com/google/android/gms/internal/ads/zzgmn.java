package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import net.bytebuddy.jar.asm.Opcodes;

final class zzgmn extends zzgjf {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, Opcodes.D2F, 233, 377, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    /* access modifiers changed from: private */
    public final zzgjf zzd;
    /* access modifiers changed from: private */
    public final zzgjf zze;
    private final int zzf;
    private final int zzg;

    private zzgmn(zzgjf zzgjf, zzgjf zzgjf2) {
        this.zzd = zzgjf;
        this.zze = zzgjf2;
        int zzd2 = zzgjf.zzd();
        this.zzf = zzd2;
        this.zzc = zzd2 + zzgjf2.zzd();
        this.zzg = Math.max(zzgjf.zzf(), zzgjf2.zzf()) + 1;
    }

    public static zzgjf zzG(zzgjf zzgjf, zzgjf zzgjf2) {
        if (zzgjf2.zzd() == 0) {
            return zzgjf;
        }
        if (zzgjf.zzd() == 0) {
            return zzgjf2;
        }
        int zzd2 = zzgjf.zzd() + zzgjf2.zzd();
        if (zzd2 < 128) {
            return zzH(zzgjf, zzgjf2);
        }
        if (zzgjf instanceof zzgmn) {
            zzgmn zzgmn = (zzgmn) zzgjf;
            if (zzgmn.zze.zzd() + zzgjf2.zzd() < 128) {
                return new zzgmn(zzgmn.zzd, zzH(zzgmn.zze, zzgjf2));
            } else if (zzgmn.zzd.zzf() > zzgmn.zze.zzf() && zzgmn.zzg > zzgjf2.zzf()) {
                return new zzgmn(zzgmn.zzd, new zzgmn(zzgmn.zze, zzgjf2));
            }
        }
        if (zzd2 >= zzc(Math.max(zzgjf.zzf(), zzgjf2.zzf()) + 1)) {
            return new zzgmn(zzgjf, zzgjf2);
        }
        return zzgmj.zza(new zzgmj((zzgmi) null), zzgjf, zzgjf2);
    }

    private static zzgjf zzH(zzgjf zzgjf, zzgjf zzgjf2) {
        int zzd2 = zzgjf.zzd();
        int zzd3 = zzgjf2.zzd();
        byte[] bArr = new byte[(zzd2 + zzd3)];
        zzgjf.zzC(bArr, 0, 0, zzd2);
        zzgjf2.zzC(bArr, 0, zzd2, zzd3);
        return new zzgjb(bArr);
    }

    public static int zzc(int i11) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i11 >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i11];
    }

    public final boolean equals(Object obj) {
        boolean z11;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgjf)) {
            return false;
        }
        zzgjf zzgjf = (zzgjf) obj;
        if (this.zzc != zzgjf.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int zzr = zzr();
        int zzr2 = zzgjf.zzr();
        if (zzr != 0 && zzr2 != 0 && zzr != zzr2) {
            return false;
        }
        zzgml zzgml = new zzgml(this, (zzgmk) null);
        zzgja zza2 = zzgml.next();
        zzgml zzgml2 = new zzgml(zzgjf, (zzgmk) null);
        zzgja zza3 = zzgml2.next();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int zzd2 = zza2.zzd() - i11;
            int zzd3 = zza3.zzd() - i12;
            int min = Math.min(zzd2, zzd3);
            if (i11 == 0) {
                z11 = zza2.zzg(zza3, i12, min);
            } else {
                z11 = zza3.zzg(zza2, i11, min);
            }
            if (!z11) {
                return false;
            }
            i13 += min;
            int i14 = this.zzc;
            if (i13 < i14) {
                if (min == zzd2) {
                    zza2 = zzgml.next();
                    i11 = 0;
                } else {
                    i11 += min;
                }
                if (min == zzd3) {
                    zza3 = zzgml2.next();
                    i12 = 0;
                } else {
                    i12 += min;
                }
            } else if (i13 == i14) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzgmh(this);
    }

    public final byte zza(int i11) {
        zzgjf.zzB(i11, this.zzc);
        return zzb(i11);
    }

    public final byte zzb(int i11) {
        int i12 = this.zzf;
        if (i11 < i12) {
            return this.zzd.zzb(i11);
        }
        return this.zze.zzb(i11 - i12);
    }

    public final int zzd() {
        return this.zzc;
    }

    public final void zze(byte[] bArr, int i11, int i12, int i13) {
        int i14 = this.zzf;
        if (i11 + i13 <= i14) {
            this.zzd.zze(bArr, i11, i12, i13);
        } else if (i11 >= i14) {
            this.zze.zze(bArr, i11 - i14, i12, i13);
        } else {
            int i15 = i14 - i11;
            this.zzd.zze(bArr, i11, i12, i15);
            this.zze.zze(bArr, 0, i12 + i15, i13 - i15);
        }
    }

    public final int zzf() {
        return this.zzg;
    }

    public final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    public final int zzi(int i11, int i12, int i13) {
        int i14 = this.zzf;
        if (i12 + i13 <= i14) {
            return this.zzd.zzi(i11, i12, i13);
        }
        if (i12 >= i14) {
            return this.zze.zzi(i11, i12 - i14, i13);
        }
        int i15 = i14 - i12;
        return this.zze.zzi(this.zzd.zzi(i11, i12, i15), 0, i13 - i15);
    }

    public final int zzj(int i11, int i12, int i13) {
        int i14 = this.zzf;
        if (i12 + i13 <= i14) {
            return this.zzd.zzj(i11, i12, i13);
        }
        if (i12 >= i14) {
            return this.zze.zzj(i11, i12 - i14, i13);
        }
        int i15 = i14 - i12;
        return this.zze.zzj(this.zzd.zzj(i11, i12, i15), 0, i13 - i15);
    }

    public final zzgjf zzk(int i11, int i12) {
        int zzq = zzgjf.zzq(i11, i12, this.zzc);
        if (zzq == 0) {
            return zzgjf.zzb;
        }
        if (zzq == this.zzc) {
            return this;
        }
        int i13 = this.zzf;
        if (i12 <= i13) {
            return this.zzd.zzk(i11, i12);
        }
        if (i11 >= i13) {
            return this.zze.zzk(i11 - i13, i12 - i13);
        }
        zzgjf zzgjf = this.zzd;
        return new zzgmn(zzgjf.zzk(i11, zzgjf.zzd()), this.zze.zzk(0, i12 - this.zzf));
    }

    public final zzgjn zzl() {
        ArrayList<ByteBuffer> arrayList = new ArrayList<>();
        zzgml zzgml = new zzgml(this, (zzgmk) null);
        while (zzgml.hasNext()) {
            arrayList.add(zzgml.next().zzn());
        }
        int i11 = zzgjn.zzd;
        boolean z11 = false;
        int i12 = 0;
        for (ByteBuffer byteBuffer : arrayList) {
            i12 += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                z11 |= true;
            } else if (byteBuffer.isDirect()) {
                z11 |= true;
            } else {
                z11 |= true;
            }
        }
        if (z11) {
            return new zzgjj(arrayList, i12, true, (zzgji) null);
        }
        return new zzgjl(new zzgky(arrayList), 4096, (zzgjk) null);
    }

    public final String zzm(Charset charset) {
        return new String(zzE(), charset);
    }

    public final ByteBuffer zzn() {
        throw null;
    }

    public final void zzo(zzgit zzgit) throws IOException {
        this.zzd.zzo(zzgit);
        this.zze.zzo(zzgit);
    }

    public final boolean zzp() {
        int zzj = this.zzd.zzj(0, 0, this.zzf);
        zzgjf zzgjf = this.zze;
        if (zzgjf.zzj(zzj, 0, zzgjf.zzd()) == 0) {
            return true;
        }
        return false;
    }

    public final zzgiz zzs() {
        return new zzgmh(this);
    }
}
