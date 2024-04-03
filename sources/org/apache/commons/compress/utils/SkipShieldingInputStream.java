package org.apache.commons.compress.utils;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SkipShieldingInputStream extends FilterInputStream {
    private static final byte[] SKIP_BUFFER = new byte[8192];
    private static final int SKIP_BUFFER_SIZE = 8192;

    public SkipShieldingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public long skip(long j11) throws IOException {
        if (j11 < 0) {
            return 0;
        }
        return (long) read(SKIP_BUFFER, 0, (int) Math.min(j11, PlaybackStateCompat.ACTION_PLAY_FROM_URI));
    }
}
