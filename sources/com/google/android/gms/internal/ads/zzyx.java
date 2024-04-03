package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class zzyx {
    private final ByteArrayOutputStream zza;
    private final DataOutputStream zzb;

    public zzyx() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.zza = byteArrayOutputStream;
        this.zzb = new DataOutputStream(byteArrayOutputStream);
    }

    private static void zzb(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public final byte[] zza(zzyw zzyw) {
        this.zza.reset();
        try {
            zzb(this.zzb, zzyw.zza);
            String str = zzyw.zzb;
            if (str == null) {
                str = "";
            }
            zzb(this.zzb, str);
            this.zzb.writeLong(zzyw.zzc);
            this.zzb.writeLong(zzyw.zzd);
            this.zzb.write(zzyw.zze);
            this.zzb.flush();
            return this.zza.toByteArray();
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }
}
