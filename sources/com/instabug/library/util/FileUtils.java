package com.instabug.library.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.util.MimeTypes;
import com.instabug.library.Instabug;
import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.storage.ProcessedBytes;
import com.instabug.library.util.threading.PoolProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

public final class FileUtils {
    private static final char EXTENSION_SEPARATOR = '.';
    public static final String FLAG_ENCRYPTED = "_e";
    private static final int IV_LENGTH = 12;
    private static final int NOT_FOUND = -1;
    private static final int NUMBER_BYTES_TO_PROCESS = 256;
    private static final char UNIX_SEPARATOR = '/';

    public class a implements Comparator {
        /* renamed from: a */
        public int compare(File file, File file2) {
            return Double.compare((double) file.lastModified(), (double) file2.lastModified());
        }
    }

    public class b implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52047a;

        public b(String str) {
            this.f52047a = str;
        }

        @Nullable
        /* renamed from: a */
        public Boolean run() {
            return Boolean.valueOf(this.f52047a.substring(0, FileUtils.getIndexOfExtension(this.f52047a)).endsWith(FileUtils.FLAG_ENCRYPTED));
        }
    }

    public class c implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52048a;

        public c(String str) {
            this.f52048a = str;
        }

        @Nullable
        /* renamed from: a */
        public Boolean run() {
            File file = new File(this.f52048a);
            boolean b11 = FileUtils.fileProcessor(1, file);
            if (b11 && (FileUtils.isReproStepFile(this.f52048a) || FileUtils.isInternalAttachmentFile(this.f52048a))) {
                String pathWithEncryptedFlag = FileUtils.getPathWithEncryptedFlag(this.f52048a);
                if (!pathWithEncryptedFlag.equals("")) {
                    file.renameTo(new File(pathWithEncryptedFlag));
                }
            }
            return Boolean.valueOf(b11);
        }
    }

    public class d implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52049a;

        public d(String str) {
            this.f52049a = str;
        }

        @Nullable
        /* renamed from: a */
        public Boolean run() {
            File file = new File(this.f52049a);
            boolean b11 = FileUtils.fileProcessor(2, file);
            if (b11 && (FileUtils.isReproStepFile(this.f52049a) || FileUtils.isInternalAttachmentFile(this.f52049a))) {
                file.renameTo(new File(FileUtils.getPathWithDecryptedFlag(this.f52049a)));
            }
            return Boolean.valueOf(b11);
        }
    }

    private static Intent appropriateIntent(Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (str.equalsIgnoreCase("doc") || str.equalsIgnoreCase("docx")) {
            intent.setDataAndType(uri, "application/msword");
        } else if (str.equalsIgnoreCase("pdf")) {
            intent.setDataAndType(uri, "application/pdf");
        } else if (str.equalsIgnoreCase("ppt") || str.equalsIgnoreCase("pptx")) {
            intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
        } else if (str.equalsIgnoreCase("xls") || str.equalsIgnoreCase("xlsx")) {
            intent.setDataAndType(uri, "application/vnd.ms-excel");
        } else if (str.equalsIgnoreCase(ArchiveStreamFactory.ZIP) || str.equalsIgnoreCase("rar")) {
            intent.setDataAndType(uri, "application/x-wav");
        } else if (str.equalsIgnoreCase("rtf")) {
            intent.setDataAndType(uri, "application/rtf");
        } else if (str.equalsIgnoreCase("wav") || str.equalsIgnoreCase("mp3")) {
            intent.setDataAndType(uri, "audio/x-wav");
        } else if (str.equalsIgnoreCase("gif")) {
            intent.setDataAndType(uri, "image/gif");
        } else if (str.equalsIgnoreCase("jpg") || str.equalsIgnoreCase("jpeg") || str.equalsIgnoreCase("png")) {
            intent.setDataAndType(uri, MimeTypes.IMAGE_JPEG);
        } else if (str.equalsIgnoreCase("txt")) {
            intent.setDataAndType(uri, "text/plain");
        } else if (str.equalsIgnoreCase("3gp") || str.equalsIgnoreCase("mpg") || str.equalsIgnoreCase("mpeg") || str.equalsIgnoreCase("mpe") || str.equalsIgnoreCase("mp4") || str.equalsIgnoreCase("avi")) {
            intent.setDataAndType(uri, "video/*");
        } else {
            intent.setDataAndType(uri, "*/*");
        }
        intent.addFlags(268435456);
        return intent;
    }

    public static boolean decryptFile(@NonNull String str) throws UnsatisfiedLinkError {
        Boolean bool = (Boolean) PoolProvider.getFilesEncryptionExecutor().executeAndGet(new d(str));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static ProcessedBytes decryptOnTheFly(String str) throws UnsatisfiedLinkError {
        return fileDecryptionOnTheFlyProcessor(new File(str));
    }

    public static void deleteDirectory(@Nullable File file) {
        File[] listFiles;
        if (file != null) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File deleteDirectory : listFiles) {
                    deleteDirectory(deleteDirectory);
                }
            }
            file.delete();
        }
    }

    public static boolean encryptFile(@NonNull String str) throws UnsatisfiedLinkError {
        Boolean bool = (Boolean) PoolProvider.getFilesEncryptionExecutor().executeAndGet(new c(str));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bd A[SYNTHETIC, Splitter:B:29:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cf A[SYNTHETIC, Splitter:B:36:0x00cf] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.instabug.library.internal.storage.ProcessedBytes fileDecryptionOnTheFlyProcessor(java.io.File r11) {
        /*
            java.lang.String r0 = " occurred while decrypting file in path: "
            java.lang.String r1 = "Error: "
            r2 = 0
            r3 = 0
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0080, OutOfMemoryError -> 0x007e }
            java.lang.String r5 = "rws"
            r4.<init>(r11, r5)     // Catch:{ Exception -> 0x0080, OutOfMemoryError -> 0x007e }
            int r3 = IV_LENGTH     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            int r3 = r3 + 256
            byte[] r5 = new byte[r3]     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            long r6 = r4.length()     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            long r8 = (long) r3     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0024
            long r6 = r4.length()     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            long r6 = r6 - r8
            r4.seek(r6)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
        L_0x0024:
            r4.read(r5, r2, r3)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            byte[] r3 = com.instabug.library.encryption.EncryptionManager.decrypt((byte[]) r5)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            long r5 = r4.length()     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x003b
            long r5 = r4.length()     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            long r5 = r5 - r8
            r4.seek(r5)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
        L_0x003b:
            int r5 = r3.length     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            r4.write(r3, r2, r5)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            long r5 = r11.length()     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            int r3 = (int) r5     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            read(r11, r3)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            java.lang.String r5 = r11.getPath()     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            boolean r5 = isReproStepFile(r5)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            if (r5 == 0) goto L_0x0063
            java.lang.String r5 = r11.getPath()     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            java.lang.String r5 = getPathWithDecryptedFlag(r5)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            r11.renameTo(r6)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
        L_0x0063:
            com.instabug.library.internal.storage.ProcessedBytes r5 = new com.instabug.library.internal.storage.ProcessedBytes     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            r6 = 1
            r5.<init>(r3, r6)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0075, all -> 0x0072 }
            r4.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r11 = move-exception
            r11.printStackTrace()
        L_0x0071:
            return r5
        L_0x0072:
            r11 = move-exception
            r3 = r4
            goto L_0x00cd
        L_0x0075:
            r3 = move-exception
            goto L_0x0078
        L_0x0077:
            r3 = move-exception
        L_0x0078:
            r10 = r4
            r4 = r3
            r3 = r10
            goto L_0x0081
        L_0x007c:
            r11 = move-exception
            goto L_0x00cd
        L_0x007e:
            r4 = move-exception
            goto L_0x0081
        L_0x0080:
            r4 = move-exception
        L_0x0081:
            java.lang.String r5 = "IBG-Core"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r6.<init>()     // Catch:{ all -> 0x007c }
            r6.append(r1)     // Catch:{ all -> 0x007c }
            r6.append(r4)     // Catch:{ all -> 0x007c }
            r6.append(r0)     // Catch:{ all -> 0x007c }
            java.lang.String r7 = r11.getPath()     // Catch:{ all -> 0x007c }
            r6.append(r7)     // Catch:{ all -> 0x007c }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x007c }
            com.instabug.library.util.InstabugSDKLogger.e(r5, r6)     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r5.<init>()     // Catch:{ all -> 0x007c }
            r5.append(r1)     // Catch:{ all -> 0x007c }
            r5.append(r4)     // Catch:{ all -> 0x007c }
            r5.append(r0)     // Catch:{ all -> 0x007c }
            java.lang.String r11 = r11.getPath()     // Catch:{ all -> 0x007c }
            r5.append(r11)     // Catch:{ all -> 0x007c }
            java.lang.String r11 = r5.toString()     // Catch:{ all -> 0x007c }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r4, r11)     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x00c5
            r3.close()     // Catch:{ IOException -> 0x00c1 }
            goto L_0x00c5
        L_0x00c1:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00c5:
            com.instabug.library.internal.storage.ProcessedBytes r11 = new com.instabug.library.internal.storage.ProcessedBytes
            byte[] r0 = new byte[r2]
            r11.<init>(r0, r2)
            return r11
        L_0x00cd:
            if (r3 == 0) goto L_0x00d7
            r3.close()     // Catch:{ IOException -> 0x00d3 }
            goto L_0x00d7
        L_0x00d3:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d7:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.FileUtils.fileDecryptionOnTheFlyProcessor(java.io.File):com.instabug.library.internal.storage.ProcessedBytes");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.io.RandomAccessFile} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b7 A[SYNTHETIC, Splitter:B:53:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c1 A[SYNTHETIC, Splitter:B:58:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cf A[SYNTHETIC, Splitter:B:66:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d9 A[SYNTHETIC, Splitter:B:71:0x00d9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean fileProcessor(int r13, java.io.File r14) {
        /*
            java.lang.String r0 = "Error: %s occurred while %s file in path: %s"
            android.content.Context r1 = com.instabug.library.Instabug.getApplicationContext()
            r2 = 0
            if (r1 == 0) goto L_0x00e2
            boolean r1 = com.instabug.library.util.memory.MemoryUtils.isLowMemory(r1)
            if (r1 != 0) goto L_0x00e2
            r1 = 2
            r3 = 1
            if (r13 != r3) goto L_0x0016
            java.lang.String r4 = "encrypting"
            goto L_0x001d
        L_0x0016:
            if (r13 != r1) goto L_0x001b
            java.lang.String r4 = "decrypting"
            goto L_0x001d
        L_0x001b:
            java.lang.String r4 = ""
        L_0x001d:
            r5 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ OutOfMemoryError -> 0x008a, Exception -> 0x0088, all -> 0x0085 }
            r6.<init>(r14)     // Catch:{ OutOfMemoryError -> 0x008a, Exception -> 0x0088, all -> 0x0085 }
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ OutOfMemoryError -> 0x0081, Exception -> 0x007f, all -> 0x007d }
            java.lang.String r8 = "rws"
            r7.<init>(r14, r8)     // Catch:{ OutOfMemoryError -> 0x0081, Exception -> 0x007f, all -> 0x007d }
            r5 = 256(0x100, float:3.59E-43)
            if (r13 != r1) goto L_0x0031
            int r8 = IV_LENGTH     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
            int r5 = r5 + r8
        L_0x0031:
            byte[] r8 = new byte[r5]     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
            long r9 = r7.length()     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
            long r11 = (long) r5     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 <= 0) goto L_0x0044
            long r9 = r7.length()     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
            long r9 = r9 - r11
            r7.seek(r9)     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
        L_0x0044:
            r7.read(r8, r2, r5)     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
            if (r13 != r3) goto L_0x004e
            byte[] r13 = com.instabug.library.encryption.EncryptionManager.encrypt((byte[]) r8)     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
            goto L_0x0052
        L_0x004e:
            byte[] r13 = com.instabug.library.encryption.EncryptionManager.decrypt((byte[]) r8)     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
        L_0x0052:
            long r8 = r7.length()     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
            int r5 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x0062
            long r8 = r7.length()     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
            long r8 = r8 - r11
            r7.seek(r8)     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
        L_0x0062:
            int r5 = r13.length     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
            r7.write(r13, r2, r5)     // Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
            r6.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r13 = move-exception
            r13.printStackTrace()
        L_0x006e:
            r7.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r13 = move-exception
            r13.printStackTrace()
        L_0x0076:
            return r3
        L_0x0077:
            r13 = move-exception
            goto L_0x00cc
        L_0x0079:
            r13 = move-exception
            goto L_0x0083
        L_0x007b:
            r13 = move-exception
            goto L_0x0083
        L_0x007d:
            r13 = move-exception
            goto L_0x00cd
        L_0x007f:
            r13 = move-exception
            goto L_0x0082
        L_0x0081:
            r13 = move-exception
        L_0x0082:
            r7 = r5
        L_0x0083:
            r5 = r6
            goto L_0x008c
        L_0x0085:
            r13 = move-exception
            r7 = r5
            goto L_0x00cb
        L_0x0088:
            r13 = move-exception
            goto L_0x008b
        L_0x008a:
            r13 = move-exception
        L_0x008b:
            r7 = r5
        L_0x008c:
            java.lang.String r6 = "IBG-Core"
            r8 = 3
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x00ca }
            r9[r2] = r13     // Catch:{ all -> 0x00ca }
            r9[r3] = r4     // Catch:{ all -> 0x00ca }
            java.lang.String r10 = r14.getPath()     // Catch:{ all -> 0x00ca }
            r9[r1] = r10     // Catch:{ all -> 0x00ca }
            java.lang.String r9 = java.lang.String.format(r0, r9)     // Catch:{ all -> 0x00ca }
            com.instabug.library.util.InstabugSDKLogger.e(r6, r9)     // Catch:{ all -> 0x00ca }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x00ca }
            r6[r2] = r13     // Catch:{ all -> 0x00ca }
            r6[r3] = r4     // Catch:{ all -> 0x00ca }
            java.lang.String r14 = r14.getPath()     // Catch:{ all -> 0x00ca }
            r6[r1] = r14     // Catch:{ all -> 0x00ca }
            java.lang.String r14 = java.lang.String.format(r0, r6)     // Catch:{ all -> 0x00ca }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r13, r14)     // Catch:{ all -> 0x00ca }
            if (r5 == 0) goto L_0x00bf
            r5.close()     // Catch:{ IOException -> 0x00bb }
            goto L_0x00bf
        L_0x00bb:
            r13 = move-exception
            r13.printStackTrace()
        L_0x00bf:
            if (r7 == 0) goto L_0x00e2
            r7.close()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00e2
        L_0x00c5:
            r13 = move-exception
            r13.printStackTrace()
            goto L_0x00e2
        L_0x00ca:
            r13 = move-exception
        L_0x00cb:
            r6 = r5
        L_0x00cc:
            r5 = r7
        L_0x00cd:
            if (r6 == 0) goto L_0x00d7
            r6.close()     // Catch:{ IOException -> 0x00d3 }
            goto L_0x00d7
        L_0x00d3:
            r14 = move-exception
            r14.printStackTrace()
        L_0x00d7:
            if (r5 == 0) goto L_0x00e1
            r5.close()     // Catch:{ IOException -> 0x00dd }
            goto L_0x00e1
        L_0x00dd:
            r14 = move-exception
            r14.printStackTrace()
        L_0x00e1:
            throw r13
        L_0x00e2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.FileUtils.fileProcessor(int, java.io.File):boolean");
    }

    public static String getExtension(@NonNull File file) {
        return getExtension(file.getAbsolutePath());
    }

    @Nullable
    public static File getFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    @Nullable
    public static String getFileName(@NonNull String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    public static int getFileType(@NonNull File file) {
        if (file.isDirectory()) {
            return 2;
        }
        String absolutePath = file.getAbsolutePath();
        if (getIndexOfExtension(absolutePath) == -1) {
            return -1;
        }
        return getTypeFromExtension(absolutePath);
    }

    public static Intent getFileViewerIntent(@NonNull String str) {
        if (URLUtil.isNetworkUrl(str)) {
            return new Intent("android.intent.action.VIEW", Uri.parse(str));
        }
        return appropriateIntent(Uri.fromFile(new File(str)), getExtension(str));
    }

    public static int getIndexOfExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (str.lastIndexOf(47) > lastIndexOf) {
            return -1;
        }
        return lastIndexOf;
    }

    public static String getPathWithDecryptedFlag(String str) {
        return str.replace(FLAG_ENCRYPTED, "");
    }

    public static String getPathWithEncryptedFlag(String str) {
        int indexOfExtension = getIndexOfExtension(str);
        if (indexOfExtension == -1) {
            return "";
        }
        return String.format("%s%s%s", new Object[]{str.substring(0, indexOfExtension), FLAG_ENCRYPTED, str.substring(indexOfExtension)});
    }

    public static long getSize(@NonNull File file) {
        File[] listFiles;
        if (!file.exists()) {
            return 0;
        }
        long length = file.length();
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File size : listFiles) {
                length += getSize(size);
            }
        }
        return length;
    }

    @WorkerThread
    @NonNull
    public static synchronized List<File> getStateFiles(String str) {
        ArrayList arrayList;
        File[] listFiles;
        synchronized (FileUtils.class) {
            arrayList = new ArrayList();
            Context applicationContext = Instabug.getApplicationContext();
            if (applicationContext != null) {
                File parentFile = applicationContext.getFilesDir().getParentFile();
                pd.b bVar = new pd.b(str);
                if (!(parentFile == null || (listFiles = parentFile.listFiles(bVar)) == null)) {
                    arrayList.addAll(Arrays.asList(listFiles));
                }
            }
        }
        return arrayList;
    }

    private static int getTypeFromExtension(String str) {
        String extension = getExtension(str);
        if (isVideoExtension(extension)) {
            return 0;
        }
        if (isImageExtension(extension)) {
            return 1;
        }
        return -1;
    }

    private static boolean isCacheExtension(@NonNull String str) {
        return str.equalsIgnoreCase("cache");
    }

    public static boolean isCacheFile(@NonNull File file) {
        if (!file.isFile()) {
            return false;
        }
        return isCacheExtension(getExtension(file.getAbsolutePath()));
    }

    public static boolean isEncryptedFile(String str) {
        Boolean bool = (Boolean) PoolProvider.getFilesEncryptionExecutor().executeAndGet(new b(str));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static boolean isFileRelatedToBugOrCrashReport(String str) {
        if (str.contains("vusf") || str.contains("view-hierarchy-images") || ((str.contains("bug_") && str.endsWith("_.jpg")) || ((str.contains("view_hierarchy_attachment_") && str.endsWith(".zip")) || (str.contains("usersteps_") && str.endsWith(".zip"))))) {
            return true;
        }
        return false;
    }

    public static boolean isImageExtension(@NonNull String str) {
        if (str.equalsIgnoreCase("jpeg") || str.equalsIgnoreCase("gif") || str.equalsIgnoreCase("png") || str.equalsIgnoreCase("bmp") || str.equalsIgnoreCase("jpg") || str.equalsIgnoreCase("webp")) {
            return true;
        }
        return false;
    }

    public static boolean isImageFile(@NonNull File file) {
        if (!file.isFile()) {
            return false;
        }
        return isImageExtension(getExtension(file));
    }

    /* access modifiers changed from: private */
    public static boolean isInternalAttachmentFile(@NonNull String str) {
        return str.contains("internal-attachments");
    }

    public static boolean isReproStepFile(String str) {
        if ((str.contains("step") || str.contains("icon")) && str.endsWith(".png") && !str.contains("usersteps_") && !str.endsWith(".zip")) {
            return true;
        }
        return false;
    }

    private static boolean isTextExtension(@NonNull String str) {
        return str.equalsIgnoreCase("txt");
    }

    public static boolean isTextFile(@NonNull File file) {
        if (!file.isFile()) {
            return false;
        }
        return isTextExtension(getExtension(file.getAbsolutePath()));
    }

    public static boolean isVideoExtension(@NonNull String str) {
        if (str.equalsIgnoreCase("mp4") || str.equalsIgnoreCase("avi") || str.equalsIgnoreCase("mpg") || str.equalsIgnoreCase("3gp") || str.equalsIgnoreCase("3gpp") || str.equalsIgnoreCase("ts") || str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("webm") || str.equalsIgnoreCase("mkv")) {
            return true;
        }
        return false;
    }

    public static boolean isVideoFile(@NonNull File file) {
        if (!file.isFile()) {
            return false;
        }
        return isVideoExtension(getExtension(file));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getStateFiles$0(String str, File file, String str2) {
        return str2.startsWith(str) && str2.endsWith(".txt");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void read(java.io.File r1, byte[] r2) throws java.io.IOException {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ all -> 0x000e }
            r0.<init>(r1)     // Catch:{ all -> 0x000e }
            r0.read(r2)     // Catch:{ all -> 0x000c }
            r0.close()
            return
        L_0x000c:
            r1 = move-exception
            goto L_0x0010
        L_0x000e:
            r1 = move-exception
            r0 = 0
        L_0x0010:
            if (r0 == 0) goto L_0x0015
            r0.close()
        L_0x0015:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.FileUtils.read(java.io.File, byte[]):void");
    }

    public static void sortByLastModifiedAsc(@NonNull List<File> list) {
        try {
            Collections.sort(list, new a());
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Exception " + e11.getMessage() + " while sorting list");
        }
    }

    public static String getExtension(@NonNull String str) {
        int indexOfExtension = getIndexOfExtension(str);
        if (indexOfExtension == -1) {
            return "";
        }
        return str.substring(indexOfExtension + 1);
    }
}
