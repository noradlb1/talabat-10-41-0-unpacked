package com.google.android.exoplayer2.upstream.crypto;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class AesCipherDataSource implements DataSource {
    @Nullable
    private AesFlushingCipher cipher;
    private final byte[] secretKey;
    private final DataSource upstream;

    public AesCipherDataSource(byte[] bArr, DataSource dataSource) {
        this.upstream = dataSource;
        this.secretKey = bArr;
    }

    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.upstream.addTransferListener(transferListener);
    }

    public void close() throws IOException {
        this.cipher = null;
        this.upstream.close();
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    @Nullable
    public Uri getUri() {
        return this.upstream.getUri();
    }

    public long open(DataSpec dataSpec) throws IOException {
        long open = this.upstream.open(dataSpec);
        this.cipher = new AesFlushingCipher(2, this.secretKey, dataSpec.key, dataSpec.uriPositionOffset + dataSpec.position);
        return open;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        int read = this.upstream.read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        ((AesFlushingCipher) Util.castNonNull(this.cipher)).updateInPlace(bArr, i11, read);
        return read;
    }
}
