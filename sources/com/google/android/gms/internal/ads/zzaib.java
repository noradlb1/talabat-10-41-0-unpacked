package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzaib implements zzaic {
    private static final Logger zzb = Logger.getLogger(zzaib.class.getName());
    final ThreadLocal<ByteBuffer> zza = new zzaia(this);

    public abstract zzaif zza(String str, byte[] bArr, String str2);

    public final zzaif zzb(zzgpd zzgpd, zzaig zzaig) throws IOException {
        int zza2;
        long j11;
        String str;
        long zzb2 = zzgpd.zzb();
        this.zza.get().rewind().limit(8);
        do {
            zza2 = zzgpd.zza(this.zza.get());
            if (zza2 == 8) {
                this.zza.get().rewind();
                long zze = zzaie.zze(this.zza.get());
                byte[] bArr = null;
                if (zze >= 8 || zze <= 1) {
                    byte[] bArr2 = new byte[4];
                    this.zza.get().get(bArr2);
                    try {
                        String str2 = new String(bArr2, "ISO-8859-1");
                        if (zze == 1) {
                            this.zza.get().limit(16);
                            zzgpd.zza(this.zza.get());
                            this.zza.get().position(8);
                            j11 = zzaie.zzf(this.zza.get()) - 16;
                        } else if (zze == 0) {
                            j11 = zzgpd.zzc() - zzgpd.zzb();
                        } else {
                            j11 = zze - 8;
                        }
                        if ("uuid".equals(str2)) {
                            this.zza.get().limit(this.zza.get().limit() + 16);
                            zzgpd.zza(this.zza.get());
                            bArr = new byte[16];
                            for (int position = this.zza.get().position() - 16; position < this.zza.get().position(); position++) {
                                bArr[position - (this.zza.get().position() - 16)] = this.zza.get().get(position);
                            }
                            j11 -= 16;
                        }
                        long j12 = j11;
                        if (zzaig instanceof zzaif) {
                            str = ((zzaif) zzaig).zza();
                        } else {
                            str = "";
                        }
                        zzaif zza3 = zza(str2, bArr, str);
                        zza3.zzc(zzaig);
                        this.zza.get().rewind();
                        zza3.zzb(zzgpd, this.zza.get(), j12, this);
                        return zza3;
                    } catch (UnsupportedEncodingException e11) {
                        throw new RuntimeException(e11);
                    }
                } else {
                    Logger logger = zzb;
                    Level level = Level.SEVERE;
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Plausibility check failed: size < 8 (size = ");
                    sb2.append(zze);
                    sb2.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb2.toString());
                    return null;
                }
            }
        } while (zza2 >= 0);
        zzgpd.zze(zzb2);
        throw new EOFException();
    }
}
