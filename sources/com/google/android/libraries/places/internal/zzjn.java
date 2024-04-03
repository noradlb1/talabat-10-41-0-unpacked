package com.google.android.libraries.places.internal;

import java.io.IOException;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public abstract class zzjn {
    private static final zzjn zza;
    private static final zzjn zzb;
    private static final zzjn zzc;
    private static final zzjn zzd;
    private static final zzjn zze = new zzjk("base16()", "0123456789ABCDEF");

    static {
        Character valueOf = Character.valueOf(SignatureVisitor.INSTANCEOF);
        zza = new zzjl("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        zzb = new zzjl("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        zzc = new zzjm("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        zzd = new zzjm("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
    }

    public static zzjn zzd() {
        return zze;
    }

    public abstract void zza(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException;

    public abstract int zzb(int i11);

    public final String zze(byte[] bArr, int i11, int i12) {
        zzfm.zzg(0, i12, bArr.length);
        StringBuilder sb2 = new StringBuilder(zzb(i12));
        try {
            zza(sb2, bArr, 0, i12);
            return sb2.toString();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }
}
