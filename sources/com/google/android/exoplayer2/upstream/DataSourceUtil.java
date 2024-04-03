package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;

public final class DataSourceUtil {
    private DataSourceUtil() {
    }

    public static void closeQuietly(@Nullable DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] readExactly(DataSource dataSource, int i11) throws IOException {
        byte[] bArr = new byte[i11];
        int i12 = 0;
        while (i12 < i11) {
            int read = dataSource.read(bArr, i12, i11 - i12);
            if (read != -1) {
                i12 += read;
            } else {
                throw new IllegalStateException("Not enough data could be read: " + i12 + " < " + i11);
            }
        }
        return bArr;
    }

    public static byte[] readToEnd(DataSource dataSource) throws IOException {
        byte[] bArr = new byte[1024];
        int i11 = 0;
        int i12 = 0;
        while (i11 != -1) {
            if (i12 == bArr.length) {
                bArr = Arrays.copyOf(bArr, bArr.length * 2);
            }
            i11 = dataSource.read(bArr, i12, bArr.length - i12);
            if (i11 != -1) {
                i12 += i11;
            }
        }
        return Arrays.copyOf(bArr, i12);
    }
}
