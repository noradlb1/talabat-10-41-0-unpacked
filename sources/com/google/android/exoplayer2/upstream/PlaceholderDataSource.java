package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import java.io.IOException;
import java.util.Map;
import l8.b;
import l8.h;

public final class PlaceholderDataSource implements DataSource {
    public static final DataSource.Factory FACTORY = new h();
    public static final PlaceholderDataSource INSTANCE = new PlaceholderDataSource();

    private PlaceholderDataSource() {
    }

    public static /* synthetic */ PlaceholderDataSource a() {
        return new PlaceholderDataSource();
    }

    public void addTransferListener(TransferListener transferListener) {
    }

    public void close() {
    }

    public /* synthetic */ Map getResponseHeaders() {
        return b.a(this);
    }

    @Nullable
    public Uri getUri() {
        return null;
    }

    public long open(DataSpec dataSpec) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    public int read(byte[] bArr, int i11, int i12) {
        throw new UnsupportedOperationException();
    }
}
