package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.tar.TarConstants;

public final class ExifOrientationStream extends FilterInputStream {
    private static final byte[] EXIF_SEGMENT;
    private static final int ORIENTATION_POSITION;
    private static final int SEGMENT_LENGTH;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;

    static {
        byte[] bArr = {-1, -31, 0, Ascii.FS, 69, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, Ascii.DC2, 0, 2, 0, 0, 0, 1, 0};
        EXIF_SEGMENT = bArr;
        int length = bArr.length;
        SEGMENT_LENGTH = length;
        ORIENTATION_POSITION = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i11) {
        super(inputStream);
        if (i11 < -1 || i11 > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i11);
        }
        this.orientation = (byte) i11;
    }

    public void mark(int i11) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        int i11;
        int i12;
        int i13 = this.position;
        if (i13 < 2 || i13 > (i12 = ORIENTATION_POSITION)) {
            i11 = super.read();
        } else if (i13 == i12) {
            i11 = this.orientation;
        } else {
            i11 = EXIF_SEGMENT[i13 - 2] & 255;
        }
        if (i11 != -1) {
            this.position++;
        }
        return i11;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j11) throws IOException {
        long skip = super.skip(j11);
        if (skip > 0) {
            this.position = (int) (((long) this.position) + skip);
        }
        return skip;
    }

    public int read(@NonNull byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        int i14 = this.position;
        int i15 = ORIENTATION_POSITION;
        if (i14 > i15) {
            i13 = super.read(bArr, i11, i12);
        } else if (i14 == i15) {
            bArr[i11] = this.orientation;
            i13 = 1;
        } else if (i14 < 2) {
            i13 = super.read(bArr, i11, 2 - i14);
        } else {
            int min = Math.min(i15 - i14, i12);
            System.arraycopy(EXIF_SEGMENT, this.position - 2, bArr, i11, min);
            i13 = min;
        }
        if (i13 > 0) {
            this.position += i13;
        }
        return i13;
    }
}
