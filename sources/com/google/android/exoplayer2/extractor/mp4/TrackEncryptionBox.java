package com.google.android.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

public final class TrackEncryptionBox {
    private static final String TAG = "TrackEncryptionBox";
    public final TrackOutput.CryptoData cryptoData;
    @Nullable
    public final byte[] defaultInitializationVector;
    public final boolean isEncrypted;
    public final int perSampleIvSize;
    @Nullable
    public final String schemeType;

    public TrackEncryptionBox(boolean z11, @Nullable String str, int i11, byte[] bArr, int i12, int i13, @Nullable byte[] bArr2) {
        boolean z12;
        boolean z13 = true;
        if (i11 == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        Assertions.checkArgument((bArr2 != null ? false : z13) ^ z12);
        this.isEncrypted = z11;
        this.schemeType = str;
        this.perSampleIvSize = i11;
        this.defaultInitializationVector = bArr2;
        this.cryptoData = new TrackOutput.CryptoData(schemeToCryptoMode(str), bArr, i12, i13);
    }

    private static int schemeToCryptoMode(@Nullable String str) {
        if (str == null) {
            return 1;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(C.CENC_TYPE_cbc1)) {
                    c11 = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals(C.CENC_TYPE_cbcs)) {
                    c11 = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals(C.CENC_TYPE_cenc)) {
                    c11 = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals(C.CENC_TYPE_cens)) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
                return 2;
            case 2:
            case 3:
                break;
            default:
                Log.w(TAG, "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                break;
        }
        return 1;
    }
}
