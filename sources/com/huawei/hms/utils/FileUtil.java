package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public abstract class FileUtil {
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f49918a = false;

    /* renamed from: b  reason: collision with root package name */
    private static ScheduledExecutorService f49919b = Executors.newSingleThreadScheduledExecutor();

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f49920a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f49921b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f49922c;

        public a(File file, long j11, String str) {
            this.f49920a = file;
            this.f49921b = j11;
            this.f49922c = str;
        }

        public void run() {
            Throwable th2;
            File file = this.f49920a;
            if (file == null) {
                HMSLog.e("FileUtil", "In writeFile Failed to get local file.");
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile == null || (!parentFile.mkdirs() && !parentFile.isDirectory())) {
                HMSLog.e("FileUtil", "In writeFile, Failed to create directory.");
                return;
            }
            RandomAccessFile randomAccessFile = null;
            try {
                long length = this.f49920a.length();
                if (length > this.f49921b) {
                    String canonicalPath = this.f49920a.getCanonicalPath();
                    if (!this.f49920a.delete()) {
                        HMSLog.e("FileUtil", "last file delete failed.");
                    }
                    randomAccessFile = new RandomAccessFile(new File(canonicalPath), "rw");
                } else {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.f49920a, "rw");
                    try {
                        randomAccessFile2.seek(length);
                        randomAccessFile = randomAccessFile2;
                    } catch (IOException e11) {
                        e = e11;
                        randomAccessFile = randomAccessFile2;
                        try {
                            HMSLog.e("FileUtil", "writeFile exception:", (Throwable) e);
                            IOUtils.closeQuietly((Closeable) randomAccessFile);
                        } catch (Throwable th3) {
                            randomAccessFile2 = randomAccessFile;
                            th2 = th3;
                            IOUtils.closeQuietly((Closeable) randomAccessFile2);
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        IOUtils.closeQuietly((Closeable) randomAccessFile2);
                        throw th2;
                    }
                }
                randomAccessFile.writeBytes(this.f49922c + System.getProperty("line.separator"));
            } catch (IOException e12) {
                e = e12;
            }
            IOUtils.closeQuietly((Closeable) randomAccessFile);
        }
    }

    public static boolean verifyHash(String str, File file) {
        byte[] digest = SHA256.digest(file);
        if (digest == null || !HEX.encodeHexString(digest, true).equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public static void writeFile(File file, String str, long j11) {
        f49919b.execute(new a(file, j11, str));
    }

    public static void writeFileReport(Context context, File file, File file2, String str, long j11, int i11) {
        if (file != null && file.isFile() && file.exists()) {
            if (!f49918a) {
                if (file2 != null && file2.exists() && !file2.delete()) {
                    HMSLog.e("FileUtil", "file delete failed.");
                }
                f49918a = true;
            }
            writeFile(file2, str + "|" + j11 + "|" + i11, LOCAL_REPORT_FILE_MAX_SIZE);
        }
    }
}
