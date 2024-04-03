package com.google.android.recaptcha.internal;

import java.io.IOException;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public abstract class zzek {
    private static final zzek zza;
    private static final zzek zzb;
    private static final zzek zzc;
    private static final zzek zzd;
    private static final zzek zze = new zzeg("base16()", "0123456789ABCDEF");

    static {
        Character valueOf = Character.valueOf(SignatureVisitor.INSTANCEOF);
        zza = new zzeh("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        zzb = new zzeh("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        zzc = new zzej("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        zzd = new zzej("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
    }

    public static zzek zzg() {
        return zza;
    }

    public static zzek zzh() {
        return zzb;
    }

    public abstract int zza(byte[] bArr, CharSequence charSequence) throws zzei;

    public abstract void zzb(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException;

    public abstract int zzc(int i11);

    public abstract int zzd(int i11);

    public CharSequence zze(CharSequence charSequence) {
        throw null;
    }

    public final String zzi(byte[] bArr, int i11, int i12) {
        zzdr.zzd(0, i12, bArr.length);
        StringBuilder sb2 = new StringBuilder(zzd(i12));
        try {
            zzb(sb2, bArr, 0, i12);
            return sb2.toString();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    public final byte[] zzj(CharSequence charSequence) {
        try {
            CharSequence zze2 = zze(charSequence);
            int zzc2 = zzc(zze2.length());
            byte[] bArr = new byte[zzc2];
            int zza2 = zza(bArr, zze2);
            if (zza2 == zzc2) {
                return bArr;
            }
            byte[] bArr2 = new byte[zza2];
            System.arraycopy(bArr, 0, bArr2, 0, zza2);
            return bArr2;
        } catch (zzei e11) {
            throw new IllegalArgumentException(e11);
        }
    }
}
