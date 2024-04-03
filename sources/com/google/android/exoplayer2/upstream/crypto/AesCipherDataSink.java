package com.google.android.exoplayer2.upstream.crypto;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class AesCipherDataSink implements DataSink {
    @Nullable
    private AesFlushingCipher cipher;
    @Nullable
    private final byte[] scratch;
    private final byte[] secretKey;
    private final DataSink wrappedDataSink;

    public AesCipherDataSink(byte[] bArr, DataSink dataSink) {
        this(bArr, dataSink, (byte[]) null);
    }

    public void close() throws IOException {
        this.cipher = null;
        this.wrappedDataSink.close();
    }

    public void open(DataSpec dataSpec) throws IOException {
        this.wrappedDataSink.open(dataSpec);
        this.cipher = new AesFlushingCipher(1, this.secretKey, dataSpec.key, dataSpec.uriPositionOffset + dataSpec.position);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        if (this.scratch == null) {
            ((AesFlushingCipher) Util.castNonNull(this.cipher)).updateInPlace(bArr, i11, i12);
            this.wrappedDataSink.write(bArr, i11, i12);
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            int min = Math.min(i12 - i13, this.scratch.length);
            ((AesFlushingCipher) Util.castNonNull(this.cipher)).update(bArr, i11 + i13, min, this.scratch, 0);
            this.wrappedDataSink.write(this.scratch, 0, min);
            i13 += min;
        }
    }

    public AesCipherDataSink(byte[] bArr, DataSink dataSink, @Nullable byte[] bArr2) {
        this.wrappedDataSink = dataSink;
        this.secretKey = bArr;
        this.scratch = bArr2;
    }
}
