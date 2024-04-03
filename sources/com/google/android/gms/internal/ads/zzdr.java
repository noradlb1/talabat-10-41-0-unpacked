package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.PlaybackException;
import java.io.IOException;

public final class zzdr extends zzds {
    public zzdr(IOException iOException, zzdm zzdm) {
        super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, zzdm, PlaybackException.ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED, 1);
    }
}
