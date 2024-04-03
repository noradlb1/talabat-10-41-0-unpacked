package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@VisibleForTesting
final class zzahm extends FilterInputStream {
    private final long zza;
    private long zzb;

    public zzahm(InputStream inputStream, long j11) {
        super(inputStream);
        this.zza = j11;
    }

    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.zzb++;
        }
        return read;
    }

    public final long zza() {
        return this.zza - this.zzb;
    }

    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = super.read(bArr, i11, i12);
        if (read != -1) {
            this.zzb += (long) read;
        }
        return read;
    }
}
