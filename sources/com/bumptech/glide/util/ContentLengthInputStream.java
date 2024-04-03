package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentLengthInputStream extends FilterInputStream {
    private static final String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private final long contentLength;
    private int readSoFar;

    private ContentLengthInputStream(@NonNull InputStream inputStream, long j11) {
        super(inputStream);
        this.contentLength = j11;
    }

    private int checkReadSoFarOrThrow(int i11) throws IOException {
        if (i11 >= 0) {
            this.readSoFar += i11;
        } else if (this.contentLength - ((long) this.readSoFar) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.readSoFar);
        }
        return i11;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, @Nullable String str) {
        return obtain(inputStream, (long) parseContentLength(str));
    }

    private static int parseContentLength(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                if (Log.isLoggable(TAG, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("failed to parse content length header: ");
                    sb2.append(str);
                }
            }
        }
        return -1;
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.contentLength - ((long) this.readSoFar), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        checkReadSoFarOrThrow(read >= 0 ? 1 : -1);
        return read;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, long j11) {
        return new ContentLengthInputStream(inputStream, j11);
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i11, int i12) throws IOException {
        return checkReadSoFarOrThrow(super.read(bArr, i11, i12));
    }
}
