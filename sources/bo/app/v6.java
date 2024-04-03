package bo.app;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

final class v6 {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f39511a = Charset.forName("US-ASCII");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f39512b = Charset.forName("UTF-8");

    public static void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i11 = 0;
            while (i11 < length) {
                File file2 = listFiles[i11];
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (file2.delete()) {
                    i11++;
                } else {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }
}
