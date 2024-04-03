package com.instabug.library.internal.storage;

import androidx.annotation.NonNull;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

@Deprecated
public abstract class Encryptor {
    static {
        try {
            System.loadLibrary("ibg-native");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static boolean a(@NonNull String str) throws UnsatisfiedLinkError {
        File file = new File(str);
        boolean a11 = a(2, file);
        if (a11 && FileUtils.isReproStepFile(str)) {
            file.renameTo(new File(FileUtils.getPathWithDecryptedFlag(str)));
        }
        return a11;
    }

    public static native String getKey();

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.security.Key] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0076, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0085, code lost:
        r5 = null;
        r3 = r4;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008a, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        a(r10, (java.security.Key) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a7, code lost:
        r10 = "encrypting";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ab, code lost:
        if (r10 == 2) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ad, code lost:
        r10 = "decrypting";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cf, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d3, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00dc, code lost:
        r4.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0089 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0011] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009f A[SYNTHETIC, Splitter:B:33:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a7 A[Catch:{ all -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ab A[Catch:{ all -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ca A[SYNTHETIC, Splitter:B:43:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cf A[Catch:{ IOException -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d7 A[SYNTHETIC, Splitter:B:50:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00dc A[Catch:{ IOException -> 0x00df }] */
    @android.annotation.SuppressLint({"RESOURCE_LEAK"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(int r10, java.io.File r11) {
        /*
            java.lang.String r0 = "AES/ECB/NoPadding"
            android.content.Context r1 = com.instabug.library.Instabug.getApplicationContext()
            r2 = 0
            if (r1 == 0) goto L_0x00e0
            boolean r1 = com.instabug.library.util.memory.MemoryUtils.isLowMemory(r1)
            if (r1 != 0) goto L_0x00e0
            r1 = 1
            r3 = 0
            javax.crypto.spec.SecretKeySpec r4 = new javax.crypto.spec.SecretKeySpec     // Catch:{ NoSuchPaddingException -> 0x009a, NoSuchAlgorithmException -> 0x0098, InvalidKeyException -> 0x0096, IOException -> 0x0094, BadPaddingException -> 0x0092, IllegalBlockSizeException -> 0x0090, OutOfMemoryError -> 0x008e, UnsatisfiedLinkError -> 0x008c, all -> 0x0089 }
            java.lang.String r5 = getKey()     // Catch:{ NoSuchPaddingException -> 0x009a, NoSuchAlgorithmException -> 0x0098, InvalidKeyException -> 0x0096, IOException -> 0x0094, BadPaddingException -> 0x0092, IllegalBlockSizeException -> 0x0090, OutOfMemoryError -> 0x008e, UnsatisfiedLinkError -> 0x008c, all -> 0x0089 }
            java.lang.String r6 = "UTF-8"
            byte[] r5 = r5.getBytes(r6)     // Catch:{ NoSuchPaddingException -> 0x009a, NoSuchAlgorithmException -> 0x0098, InvalidKeyException -> 0x0096, IOException -> 0x0094, BadPaddingException -> 0x0092, IllegalBlockSizeException -> 0x0090, OutOfMemoryError -> 0x008e, UnsatisfiedLinkError -> 0x008c, all -> 0x0089 }
            r4.<init>(r5, r0)     // Catch:{ NoSuchPaddingException -> 0x009a, NoSuchAlgorithmException -> 0x0098, InvalidKeyException -> 0x0096, IOException -> 0x0094, BadPaddingException -> 0x0092, IllegalBlockSizeException -> 0x0090, OutOfMemoryError -> 0x008e, UnsatisfiedLinkError -> 0x008c, all -> 0x0089 }
            javax.crypto.Cipher r0 = javax.crypto.Cipher.getInstance(r0)     // Catch:{ NoSuchPaddingException -> 0x0084, NoSuchAlgorithmException -> 0x0082, InvalidKeyException -> 0x0080, IOException -> 0x007e, BadPaddingException -> 0x007c, IllegalBlockSizeException -> 0x007a, OutOfMemoryError -> 0x0078, UnsatisfiedLinkError -> 0x0076, all -> 0x0089 }
            r0.init(r10, r4)     // Catch:{ NoSuchPaddingException -> 0x0084, NoSuchAlgorithmException -> 0x0082, InvalidKeyException -> 0x0080, IOException -> 0x007e, BadPaddingException -> 0x007c, IllegalBlockSizeException -> 0x007a, OutOfMemoryError -> 0x0078, UnsatisfiedLinkError -> 0x0076, all -> 0x0089 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ NoSuchPaddingException -> 0x0084, NoSuchAlgorithmException -> 0x0082, InvalidKeyException -> 0x0080, IOException -> 0x007e, BadPaddingException -> 0x007c, IllegalBlockSizeException -> 0x007a, OutOfMemoryError -> 0x0078, UnsatisfiedLinkError -> 0x0076, all -> 0x0089 }
            r5.<init>(r11)     // Catch:{ NoSuchPaddingException -> 0x0084, NoSuchAlgorithmException -> 0x0082, InvalidKeyException -> 0x0080, IOException -> 0x007e, BadPaddingException -> 0x007c, IllegalBlockSizeException -> 0x007a, OutOfMemoryError -> 0x0078, UnsatisfiedLinkError -> 0x0076, all -> 0x0089 }
            r6 = 256(0x100, float:3.59E-43)
            byte[] r7 = new byte[r6]     // Catch:{ NoSuchPaddingException -> 0x0071, NoSuchAlgorithmException -> 0x006f, InvalidKeyException -> 0x006d, IOException -> 0x006b, BadPaddingException -> 0x0069, IllegalBlockSizeException -> 0x0067, OutOfMemoryError -> 0x0065, UnsatisfiedLinkError -> 0x0063, all -> 0x005f }
            r5.read(r7, r2, r6)     // Catch:{ NoSuchPaddingException -> 0x0071, NoSuchAlgorithmException -> 0x006f, InvalidKeyException -> 0x006d, IOException -> 0x006b, BadPaddingException -> 0x0069, IllegalBlockSizeException -> 0x0067, OutOfMemoryError -> 0x0065, UnsatisfiedLinkError -> 0x0063, all -> 0x005f }
            byte[] r0 = r0.doFinal(r7)     // Catch:{ NoSuchPaddingException -> 0x0071, NoSuchAlgorithmException -> 0x006f, InvalidKeyException -> 0x006d, IOException -> 0x006b, BadPaddingException -> 0x0069, IllegalBlockSizeException -> 0x0067, OutOfMemoryError -> 0x0065, UnsatisfiedLinkError -> 0x0063, all -> 0x005f }
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ NoSuchPaddingException -> 0x0071, NoSuchAlgorithmException -> 0x006f, InvalidKeyException -> 0x006d, IOException -> 0x006b, BadPaddingException -> 0x0069, IllegalBlockSizeException -> 0x0067, OutOfMemoryError -> 0x0065, UnsatisfiedLinkError -> 0x0063, all -> 0x005f }
            java.lang.String r7 = "rws"
            r6.<init>(r11, r7)     // Catch:{ NoSuchPaddingException -> 0x0071, NoSuchAlgorithmException -> 0x006f, InvalidKeyException -> 0x006d, IOException -> 0x006b, BadPaddingException -> 0x0069, IllegalBlockSizeException -> 0x0067, OutOfMemoryError -> 0x0065, UnsatisfiedLinkError -> 0x0063, all -> 0x005f }
            int r3 = r0.length     // Catch:{ NoSuchPaddingException -> 0x005c, NoSuchAlgorithmException -> 0x005a, InvalidKeyException -> 0x0058, IOException -> 0x0056, BadPaddingException -> 0x0054, IllegalBlockSizeException -> 0x0052, OutOfMemoryError -> 0x0050, UnsatisfiedLinkError -> 0x004e, all -> 0x0049 }
            r6.write(r0, r2, r3)     // Catch:{ NoSuchPaddingException -> 0x005c, NoSuchAlgorithmException -> 0x005a, InvalidKeyException -> 0x0058, IOException -> 0x0056, BadPaddingException -> 0x0054, IllegalBlockSizeException -> 0x0052, OutOfMemoryError -> 0x0050, UnsatisfiedLinkError -> 0x004e, all -> 0x0049 }
            r5.close()     // Catch:{ IOException -> 0x0048 }
            r6.close()     // Catch:{ IOException -> 0x0048 }
        L_0x0048:
            return r1
        L_0x0049:
            r10 = move-exception
            r3 = r5
            r4 = r6
            goto L_0x00d5
        L_0x004e:
            r0 = move-exception
            goto L_0x005d
        L_0x0050:
            r0 = move-exception
            goto L_0x005d
        L_0x0052:
            r0 = move-exception
            goto L_0x005d
        L_0x0054:
            r0 = move-exception
            goto L_0x005d
        L_0x0056:
            r0 = move-exception
            goto L_0x005d
        L_0x0058:
            r0 = move-exception
            goto L_0x005d
        L_0x005a:
            r0 = move-exception
            goto L_0x005d
        L_0x005c:
            r0 = move-exception
        L_0x005d:
            r3 = r6
            goto L_0x0072
        L_0x005f:
            r10 = move-exception
            r4 = r3
            goto L_0x00d4
        L_0x0063:
            r0 = move-exception
            goto L_0x0072
        L_0x0065:
            r0 = move-exception
            goto L_0x0072
        L_0x0067:
            r0 = move-exception
            goto L_0x0072
        L_0x0069:
            r0 = move-exception
            goto L_0x0072
        L_0x006b:
            r0 = move-exception
            goto L_0x0072
        L_0x006d:
            r0 = move-exception
            goto L_0x0072
        L_0x006f:
            r0 = move-exception
            goto L_0x0072
        L_0x0071:
            r0 = move-exception
        L_0x0072:
            r9 = r4
            r4 = r3
            r3 = r9
            goto L_0x009d
        L_0x0076:
            r0 = move-exception
            goto L_0x0085
        L_0x0078:
            r0 = move-exception
            goto L_0x0085
        L_0x007a:
            r0 = move-exception
            goto L_0x0085
        L_0x007c:
            r0 = move-exception
            goto L_0x0085
        L_0x007e:
            r0 = move-exception
            goto L_0x0085
        L_0x0080:
            r0 = move-exception
            goto L_0x0085
        L_0x0082:
            r0 = move-exception
            goto L_0x0085
        L_0x0084:
            r0 = move-exception
        L_0x0085:
            r5 = r3
            r3 = r4
            r4 = r5
            goto L_0x009d
        L_0x0089:
            r10 = move-exception
            r4 = r3
            goto L_0x00d5
        L_0x008c:
            r0 = move-exception
            goto L_0x009b
        L_0x008e:
            r0 = move-exception
            goto L_0x009b
        L_0x0090:
            r0 = move-exception
            goto L_0x009b
        L_0x0092:
            r0 = move-exception
            goto L_0x009b
        L_0x0094:
            r0 = move-exception
            goto L_0x009b
        L_0x0096:
            r0 = move-exception
            goto L_0x009b
        L_0x0098:
            r0 = move-exception
            goto L_0x009b
        L_0x009a:
            r0 = move-exception
        L_0x009b:
            r4 = r3
            r5 = r4
        L_0x009d:
            if (r3 == 0) goto L_0x00a2
            a((int) r10, (java.security.Key) r3)     // Catch:{ all -> 0x00d3 }
        L_0x00a2:
            java.lang.String r3 = ""
            r6 = 2
            if (r10 != r1) goto L_0x00ab
            java.lang.String r10 = "encrypting"
        L_0x00a9:
            r3 = r10
            goto L_0x00b0
        L_0x00ab:
            if (r10 != r6) goto L_0x00b0
            java.lang.String r10 = "decrypting"
            goto L_0x00a9
        L_0x00b0:
            java.lang.String r10 = "IBG-Core"
            java.lang.String r7 = "Error: %s occurred while %s file in path: %s"
            r8 = 3
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x00d3 }
            r8[r2] = r0     // Catch:{ all -> 0x00d3 }
            r8[r1] = r3     // Catch:{ all -> 0x00d3 }
            java.lang.String r11 = r11.getPath()     // Catch:{ all -> 0x00d3 }
            r8[r6] = r11     // Catch:{ all -> 0x00d3 }
            java.lang.String r11 = java.lang.String.format(r7, r8)     // Catch:{ all -> 0x00d3 }
            com.instabug.library.util.InstabugSDKLogger.e(r10, r11)     // Catch:{ all -> 0x00d3 }
            if (r5 == 0) goto L_0x00cd
            r5.close()     // Catch:{ IOException -> 0x00e0 }
        L_0x00cd:
            if (r4 == 0) goto L_0x00e0
            r4.close()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x00e0
        L_0x00d3:
            r10 = move-exception
        L_0x00d4:
            r3 = r5
        L_0x00d5:
            if (r3 == 0) goto L_0x00da
            r3.close()     // Catch:{ IOException -> 0x00df }
        L_0x00da:
            if (r4 == 0) goto L_0x00df
            r4.close()     // Catch:{ IOException -> 0x00df }
        L_0x00df:
            throw r10
        L_0x00e0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.Encryptor.a(int, java.io.File):boolean");
    }

    private static void a(int i11, Key key) {
        if (key != null) {
            try {
                Cipher.getInstance("AES/ECB/NoPadding").init(i11, key);
            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e11) {
                InstabugSDKLogger.e("IBG-Core", String.format("Error: %s occurred while resetting the Cipher instance.", new Object[]{e11}));
            }
        }
    }
}
