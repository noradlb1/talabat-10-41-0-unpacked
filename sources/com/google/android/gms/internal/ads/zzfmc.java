package com.google.android.gms.internal.ads;

import android.os.Build;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import okio.Utf8;
import org.apache.commons.compress.archivers.tar.TarConstants;

@VisibleForTesting
public final class zzfmc {
    @VisibleForTesting
    protected static final byte[] zza = {61, 122, Ascii.DC2, 35, 1, -102, -93, -99, -98, -96, -29, 67, 106, -73, -64, -119, 107, -5, 79, -74, 121, -12, -34, 95, -25, -62, Utf8.REPLACEMENT_BYTE, TarConstants.LF_SYMLINK, 108, -113, -103, 74};
    @VisibleForTesting
    protected static final byte[] zzb = {Ascii.DLE, 57, 56, -18, 69, TarConstants.LF_CONTIG, -27, -98, -114, -25, -110, -10, 84, 80, 79, -72, TarConstants.LF_BLK, 111, -58, -77, 70, -48, -69, -60, 65, 95, -61, 57, -4, -4, -114, -63};
    private final byte[] zzc = zzb;
    private final byte[] zzd = zza;

    public final boolean zza(File file) throws GeneralSecurityException {
        try {
            X509Certificate[][] zza2 = zzafy.zza(file.getAbsolutePath());
            if (zza2.length == 1) {
                byte[] digest = MessageDigest.getInstance(Constants.SHA256).digest(zza2[0][0].getEncoded());
                if (Arrays.equals(this.zzd, digest)) {
                    return true;
                }
                if ("user".equals(Build.TYPE)) {
                    return false;
                }
                if (Arrays.equals(this.zzc, digest)) {
                    return true;
                }
                return false;
            }
            throw new GeneralSecurityException("APK has more than one signature.");
        } catch (zzafv e11) {
            throw new GeneralSecurityException("Package is not signed", e11);
        } catch (IOException | RuntimeException e12) {
            throw new GeneralSecurityException("Failed to verify signatures", e12);
        }
    }
}
