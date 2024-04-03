package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

public class zzds extends zzdj {
    public final zzdm zzb;

    public zzds(zzdm zzdm, int i11, int i12) {
        super(zzb(2008, 1));
        this.zzb = zzdm;
    }

    public static zzds zza(IOException iOException, zzdm zzdm, int i11) {
        int i12;
        String message = iOException.getMessage();
        if (iOException instanceof SocketTimeoutException) {
            i12 = PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT;
        } else if (iOException instanceof InterruptedIOException) {
            i12 = 1004;
        } else if (message == null || !zzfpn.zza(message).matches("cleartext.*not permitted.*")) {
            i12 = 2001;
        } else {
            i12 = 2007;
        }
        if (i12 == 2007) {
            return new zzdr(iOException, zzdm);
        }
        return new zzds(iOException, zzdm, i12, i11);
    }

    private static int zzb(int i11, int i12) {
        return i11 == 2000 ? i12 != 1 ? 2000 : 2001 : i11;
    }

    public zzds(IOException iOException, zzdm zzdm, int i11, int i12) {
        super((Throwable) iOException, zzb(i11, i12));
        this.zzb = zzdm;
    }

    public zzds(String str, zzdm zzdm, int i11, int i12) {
        super(str, zzb(2001, 1));
        this.zzb = zzdm;
    }

    @Deprecated
    public zzds(String str, IOException iOException, zzdm zzdm, int i11) {
        this(str, iOException, zzdm, 2000, 1);
    }

    public zzds(String str, @Nullable IOException iOException, zzdm zzdm, int i11, int i12) {
        super(str, iOException, zzb(i11, 1));
        this.zzb = zzdm;
    }
}
