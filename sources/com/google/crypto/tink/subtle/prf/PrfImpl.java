package com.google.crypto.tink.subtle.prf;

import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

@Immutable
public class PrfImpl implements Prf {
    private final StreamingPrf prfStreamer;

    private PrfImpl(StreamingPrf streamingPrf) {
        this.prfStreamer = streamingPrf;
    }

    private static byte[] readBytesFromStream(InputStream inputStream, int i11) throws GeneralSecurityException {
        try {
            byte[] bArr = new byte[i11];
            int i12 = 0;
            while (i12 < i11) {
                int read = inputStream.read(bArr, i12, i11 - i12);
                if (read > 0) {
                    i12 += read;
                } else {
                    throw new GeneralSecurityException("Provided StreamingPrf terminated before providing requested number of bytes.");
                }
            }
            return bArr;
        } catch (IOException e11) {
            throw new GeneralSecurityException(e11);
        }
    }

    public static PrfImpl wrap(StreamingPrf streamingPrf) {
        return new PrfImpl(streamingPrf);
    }

    public byte[] compute(byte[] bArr, int i11) throws GeneralSecurityException {
        if (bArr == null) {
            throw new GeneralSecurityException("Invalid input provided.");
        } else if (i11 > 0) {
            return readBytesFromStream(this.prfStreamer.computePrf(bArr), i11);
        } else {
            throw new GeneralSecurityException("Invalid outputLength specified.");
        }
    }
}
