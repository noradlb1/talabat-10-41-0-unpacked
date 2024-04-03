package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

final class zzbar extends PushbackInputStream {
    final /* synthetic */ zzbas zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbar(zzbas zzbas, InputStream inputStream, int i11) {
        super(inputStream, 1);
        this.zza = zzbas;
    }

    public final synchronized void close() throws IOException {
        zzbau.zze(this.zza.zzc);
        super.close();
    }
}
