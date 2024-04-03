package androidx.multidex;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class ZipUtil {
    private static final int BUFFER_SIZE = 16384;
    private static final int ENDHDR = 22;
    private static final int ENDSIG = 101010256;

    public static class CentralDirectory {

        /* renamed from: a  reason: collision with root package name */
        public long f36296a;

        /* renamed from: b  reason: collision with root package name */
        public long f36297b;
    }

    public static long a(RandomAccessFile randomAccessFile, CentralDirectory centralDirectory) throws IOException {
        CRC32 crc32 = new CRC32();
        long j11 = centralDirectory.f36297b;
        randomAccessFile.seek(centralDirectory.f36296a);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j11));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j11 -= (long) read;
            if (j11 == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j11));
        }
        return crc32.getValue();
    }

    public static CentralDirectory b(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length() - 22;
        long j11 = 0;
        if (length >= 0) {
            long j12 = length - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            if (j12 >= 0) {
                j11 = j12;
            }
            int reverseBytes = Integer.reverseBytes(ENDSIG);
            do {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    CentralDirectory centralDirectory = new CentralDirectory();
                    centralDirectory.f36297b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    centralDirectory.f36296a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    return centralDirectory;
                }
                length--;
            } while (length >= j11);
            throw new ZipException("End Of Central Directory signature not found");
        }
        throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
    }

    public static long c(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return a(randomAccessFile, b(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}
