package androidx.profileinstaller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

@RequiresApi(19)
class Encoding {
    private Encoding() {
    }

    public static int a(int i11) {
        return (((i11 + 8) - 1) & -8) / 8;
    }

    public static byte[] b(@NonNull byte[] bArr) throws IOException {
        DeflaterOutputStream deflaterOutputStream;
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            deflater.end();
            throw th2;
        }
        throw th;
    }

    @NonNull
    public static RuntimeException c(@Nullable String str) {
        return new IllegalStateException(str);
    }

    @NonNull
    public static byte[] d(@NonNull InputStream inputStream, int i11) throws IOException {
        byte[] bArr = new byte[i11];
        int i12 = 0;
        while (i12 < i11) {
            int read = inputStream.read(bArr, i12, i11 - i12);
            if (read >= 0) {
                i12 += read;
            } else {
                throw c("Not enough bytes to read: " + i11);
            }
        }
        return bArr;
    }

    @NonNull
    public static byte[] e(@NonNull InputStream inputStream, int i11, int i12) throws IOException {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i12];
            byte[] bArr2 = new byte[2048];
            int i13 = 0;
            int i14 = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i13 < i11) {
                int read = inputStream.read(bArr2);
                if (read >= 0) {
                    inflater.setInput(bArr2, 0, read);
                    i14 += inflater.inflate(bArr, i14, i12 - i14);
                    i13 += read;
                } else {
                    throw c("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i11 + " bytes");
                }
            }
            if (i13 != i11) {
                throw c("Didn't read enough bytes during decompression. expected=" + i11 + " actual=" + i13);
            } else if (inflater.finished()) {
                inflater.end();
                return bArr;
            } else {
                throw c("Inflater did not finish");
            }
        } catch (DataFormatException e11) {
            throw c(e11.getMessage());
        } catch (Throwable th2) {
            inflater.end();
            throw th2;
        }
    }

    @NonNull
    public static String f(InputStream inputStream, int i11) throws IOException {
        return new String(d(inputStream, i11), StandardCharsets.UTF_8);
    }

    public static long g(@NonNull InputStream inputStream, int i11) throws IOException {
        byte[] d11 = d(inputStream, i11);
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j11 += ((long) (d11[i12] & 255)) << (i12 * 8);
        }
        return j11;
    }

    public static int h(@NonNull InputStream inputStream) throws IOException {
        return (int) g(inputStream, 2);
    }

    public static long i(@NonNull InputStream inputStream) throws IOException {
        return g(inputStream, 4);
    }

    public static int j(@NonNull InputStream inputStream) throws IOException {
        return (int) g(inputStream, 1);
    }

    public static int k(@NonNull String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    public static void l(@NonNull InputStream inputStream, @NonNull OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[512];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void m(@NonNull OutputStream outputStream, byte[] bArr) throws IOException {
        q(outputStream, (long) bArr.length);
        byte[] b11 = b(bArr);
        q(outputStream, (long) b11.length);
        outputStream.write(b11);
    }

    public static void n(@NonNull OutputStream outputStream, @NonNull String str) throws IOException {
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    public static void o(@NonNull OutputStream outputStream, long j11, int i11) throws IOException {
        byte[] bArr = new byte[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bArr[i12] = (byte) ((int) ((j11 >> (i12 * 8)) & 255));
        }
        outputStream.write(bArr);
    }

    public static void p(@NonNull OutputStream outputStream, int i11) throws IOException {
        o(outputStream, (long) i11, 2);
    }

    public static void q(@NonNull OutputStream outputStream, long j11) throws IOException {
        o(outputStream, j11, 4);
    }

    public static void r(@NonNull OutputStream outputStream, int i11) throws IOException {
        o(outputStream, (long) i11, 1);
    }
}
