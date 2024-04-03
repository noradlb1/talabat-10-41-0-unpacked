package com.instabug.library.util;

import androidx.annotation.NonNull;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class DiskUtils {

    public class a implements Callable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f52044b;

        public a(File file) {
            this.f52044b = file;
        }

        /* renamed from: a */
        public List call() {
            File[] listFiles;
            ArrayList arrayList = new ArrayList();
            if (this.f52044b.exists() && this.f52044b.isDirectory() && (listFiles = this.f52044b.listFiles()) != null) {
                for (File file : listFiles) {
                    if (!file.delete()) {
                        arrayList.add(file);
                    }
                }
            }
            return arrayList;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x001c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void copy(java.io.File r2, java.io.OutputStream r3) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0013 }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0013 }
            copy((java.io.InputStream) r1, (java.io.OutputStream) r3)     // Catch:{ FileNotFoundException -> 0x000f, all -> 0x000d }
            r1.close()
            goto L_0x001f
        L_0x000d:
            r2 = move-exception
            goto L_0x0021
        L_0x000f:
            r0 = r1
            goto L_0x0013
        L_0x0011:
            r2 = move-exception
            goto L_0x0020
        L_0x0013:
            java.lang.String r2 = "IBG-Core"
            java.lang.String r3 = "FileNotFoundException: can not copy file to another stream"
            com.instabug.library.util.InstabugSDKLogger.e(r2, r3)     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x001f
            r0.close()
        L_0x001f:
            return
        L_0x0020:
            r1 = r0
        L_0x0021:
            if (r1 == 0) goto L_0x0026
            r1.close()
        L_0x0026:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.DiskUtils.copy(java.io.File, java.io.OutputStream):void");
    }

    @NonNull
    public static Observable<List<File>> getCleanDirectoryObservable(File file) {
        return Observable.fromCallable(new a(file)).subscribeOn(Schedulers.io());
    }

    public static ArrayList<File> listFilesInDirectory(File file) {
        File[] listFiles = file.listFiles();
        Collection arrayList = new ArrayList();
        if (listFiles != null) {
            arrayList = Arrays.asList(listFiles);
        }
        return new ArrayList<>(arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00db A[SYNTHETIC, Splitter:B:31:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ea A[SYNTHETIC, Splitter:B:42:0x00ea] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized android.net.Uri zipFiles(android.content.Context r5, java.lang.String r6, java.util.ArrayList<java.io.File> r7) {
        /*
            java.lang.Class<com.instabug.library.util.DiskUtils> r0 = com.instabug.library.util.DiskUtils.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f3 }
            r1.<init>()     // Catch:{ all -> 0x00f3 }
            java.lang.String r2 = "zipping "
            r1.append(r2)     // Catch:{ all -> 0x00f3 }
            int r2 = r7.size()     // Catch:{ all -> 0x00f3 }
            r1.append(r2)     // Catch:{ all -> 0x00f3 }
            java.lang.String r2 = " files ... "
            r1.append(r2)     // Catch:{ all -> 0x00f3 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00f3 }
            java.lang.String r2 = "IBG-Core"
            com.instabug.library.util.InstabugSDKLogger.v(r2, r1)     // Catch:{ all -> 0x00f3 }
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            r3.<init>()     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            java.io.File r5 = com.instabug.library.internal.storage.AttachmentManager.getAttachmentDirectory(r5)     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            r3.append(r5)     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            java.lang.String r5 = java.io.File.separator     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            r3.append(r5)     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            r3.append(r6)     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            java.lang.String r5 = "_"
            r3.append(r5)     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            r3.append(r5)     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            java.lang.String r5 = ".zip"
            r3.append(r5)     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            java.lang.String r5 = r3.toString()     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            r2.<init>(r5)     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            r5.<init>(r2)     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            java.util.zip.ZipOutputStream r6 = new java.util.zip.ZipOutputStream     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            r6.<init>(r5)     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            java.util.Iterator r5 = r7.iterator()     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
        L_0x0060:
            boolean r7 = r5.hasNext()     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            if (r7 == 0) goto L_0x0081
            java.lang.Object r7 = r5.next()     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            java.io.File r7 = (java.io.File) r7     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            if (r7 == 0) goto L_0x0060
            java.util.zip.ZipEntry r3 = new java.util.zip.ZipEntry     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            java.lang.String r4 = r7.getName()     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            r6.putNextEntry(r3)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            copy((java.io.File) r7, (java.io.OutputStream) r6)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            r6.closeEntry()     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            goto L_0x0060
        L_0x0081:
            java.lang.String r5 = "IBG-Core"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            r7.<init>()     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            java.lang.String r3 = "zipping files have been finished successfully, path: "
            r7.append(r3)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            java.lang.String r3 = r2.getPath()     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            r7.append(r3)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            com.instabug.library.util.InstabugSDKLogger.v(r5, r7)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            android.net.Uri r5 = android.net.Uri.fromFile(r2)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            r6.close()     // Catch:{ IOException -> 0x00a4 }
            goto L_0x00a8
        L_0x00a4:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x00f3 }
        L_0x00a8:
            monitor-exit(r0)
            return r5
        L_0x00aa:
            r5 = move-exception
            goto L_0x00e8
        L_0x00ac:
            r5 = move-exception
            goto L_0x00b2
        L_0x00ae:
            r5 = move-exception
            goto L_0x00e7
        L_0x00b0:
            r5 = move-exception
            r6 = r1
        L_0x00b2:
            java.lang.String r7 = "IBG-Core"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            r2.<init>()     // Catch:{ all -> 0x00e5 }
            java.lang.String r3 = "zipping files went wrong: "
            r2.append(r3)     // Catch:{ all -> 0x00e5 }
            java.lang.String r3 = r5.getMessage()     // Catch:{ all -> 0x00e5 }
            r2.append(r3)     // Catch:{ all -> 0x00e5 }
            java.lang.String r3 = ", time in MS: "
            r2.append(r3)     // Catch:{ all -> 0x00e5 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00e5 }
            r2.append(r3)     // Catch:{ all -> 0x00e5 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e5 }
            com.instabug.library.util.InstabugSDKLogger.e(r7, r2, r5)     // Catch:{ all -> 0x00e5 }
            if (r6 == 0) goto L_0x00e3
            r6.close()     // Catch:{ IOException -> 0x00df }
            goto L_0x00e3
        L_0x00df:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x00f3 }
        L_0x00e3:
            monitor-exit(r0)
            return r1
        L_0x00e5:
            r5 = move-exception
            r1 = r6
        L_0x00e7:
            r6 = r1
        L_0x00e8:
            if (r6 == 0) goto L_0x00f2
            r6.close()     // Catch:{ IOException -> 0x00ee }
            goto L_0x00f2
        L_0x00ee:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x00f3 }
        L_0x00f2:
            throw r5     // Catch:{ all -> 0x00f3 }
        L_0x00f3:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.DiskUtils.zipFiles(android.content.Context, java.lang.String, java.util.ArrayList):android.net.Uri");
    }

    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
