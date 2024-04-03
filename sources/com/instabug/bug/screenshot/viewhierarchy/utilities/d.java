package com.instabug.bug.screenshot.viewhierarchy.utilities;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.instabug.bug.screenshot.viewhierarchy.b;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class d {
    public static File a(Context context) {
        File file = new File(DiskUtils.getInstabugDirectory(context) + "/view-hierarchy-images/");
        if (!file.exists() && file.mkdir()) {
            InstabugSDKLogger.v("IBG-BR", "Temp directory for view hierarchy images created successfully");
        }
        return file;
    }

    public static void a(b bVar) {
        View l11 = bVar.l();
        if (l11 != null) {
            File file = new File(a(l11.getContext()).getAbsolutePath() + File.separator + bVar.c() + ".png");
            try {
                if (bVar.d() != null) {
                    DiskUtils.saveBitmapOnDisk(bVar.d(), file);
                    bVar.a(Uri.fromFile(file));
                    return;
                }
                InstabugSDKLogger.e("IBG-BR", "trying to save a null value bitmap");
            } catch (IOException e11) {
                InstabugSDKLogger.e("IBG-BR", "save viewHierarchy image got error: " + e11.getMessage(), e11);
            }
        }
    }

    private static void a(File file, OutputStream outputStream) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            a((InputStream) fileInputStream, outputStream);
        } finally {
            fileInputStream.close();
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0101, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e9 A[SYNTHETIC, Splitter:B:37:0x00e9] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f7 A[SYNTHETIC, Splitter:B:47:0x00f7] */
    @android.annotation.SuppressLint({"RESOURCE_LEAK"})
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized android.net.Uri b(com.instabug.bug.screenshot.viewhierarchy.b r8) {
        /*
            java.lang.Class<com.instabug.bug.screenshot.viewhierarchy.utilities.d> r0 = com.instabug.bug.screenshot.viewhierarchy.utilities.d.class
            monitor-enter(r0)
            android.view.View r1 = r8.l()     // Catch:{ all -> 0x0102 }
            r2 = 0
            if (r1 == 0) goto L_0x0100
            android.content.Context r3 = r1.getContext()     // Catch:{ all -> 0x0102 }
            if (r3 == 0) goto L_0x0100
            java.lang.String r3 = "IBG-BR"
            java.lang.String r4 = "zip viewHierarchy images just started"
            com.instabug.library.util.InstabugSDKLogger.v(r3, r4)     // Catch:{ all -> 0x0102 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            r4.<init>()     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            android.content.Context r1 = r1.getContext()     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            java.io.File r1 = com.instabug.library.internal.storage.DiskUtils.getInstabugDirectory(r1)     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            r4.append(r1)     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            java.lang.String r1 = java.io.File.separator     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            r4.append(r1)     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            java.lang.String r1 = "view_hierarchy_attachment_"
            r4.append(r1)     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            r4.append(r5)     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            java.lang.String r1 = ".zip"
            r4.append(r1)     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            java.util.zip.ZipOutputStream r4 = new java.util.zip.ZipOutputStream     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x00cb, all -> 0x00c9 }
            java.util.List r8 = com.instabug.bug.screenshot.viewhierarchy.e.b((com.instabug.bug.screenshot.viewhierarchy.b) r8)     // Catch:{ IOException -> 0x00c7 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ IOException -> 0x00c7 }
        L_0x0058:
            boolean r1 = r8.hasNext()     // Catch:{ IOException -> 0x00c7 }
            if (r1 == 0) goto L_0x00b2
            java.lang.Object r1 = r8.next()     // Catch:{ IOException -> 0x00c7 }
            com.instabug.bug.screenshot.viewhierarchy.b r1 = (com.instabug.bug.screenshot.viewhierarchy.b) r1     // Catch:{ IOException -> 0x00c7 }
            android.net.Uri r5 = r1.e()     // Catch:{ IOException -> 0x00c7 }
            if (r5 == 0) goto L_0x0058
            android.net.Uri r5 = r1.e()     // Catch:{ IOException -> 0x00c7 }
            java.lang.String r5 = r5.getPath()     // Catch:{ IOException -> 0x00c7 }
            if (r5 == 0) goto L_0x0058
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x00c7 }
            android.net.Uri r6 = r1.e()     // Catch:{ IOException -> 0x00c7 }
            java.lang.String r6 = r6.getPath()     // Catch:{ IOException -> 0x00c7 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x00c7 }
            java.util.zip.ZipEntry r6 = new java.util.zip.ZipEntry     // Catch:{ IOException -> 0x00c7 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c7 }
            r7.<init>()     // Catch:{ IOException -> 0x00c7 }
            java.lang.String r1 = r1.c()     // Catch:{ IOException -> 0x00c7 }
            r7.append(r1)     // Catch:{ IOException -> 0x00c7 }
            java.lang.String r1 = ".png"
            r7.append(r1)     // Catch:{ IOException -> 0x00c7 }
            java.lang.String r1 = r7.toString()     // Catch:{ IOException -> 0x00c7 }
            r6.<init>(r1)     // Catch:{ IOException -> 0x00c7 }
            r4.putNextEntry(r6)     // Catch:{ IOException -> 0x00c7 }
            a((java.io.File) r5, (java.io.OutputStream) r4)     // Catch:{ IOException -> 0x00c7 }
            r4.closeEntry()     // Catch:{ IOException -> 0x00c7 }
            boolean r1 = r5.delete()     // Catch:{ IOException -> 0x00c7 }
            if (r1 == 0) goto L_0x0058
            java.lang.String r1 = "IBG-BR"
            java.lang.String r5 = "file zipped successfully"
            com.instabug.library.util.InstabugSDKLogger.v(r1, r5)     // Catch:{ IOException -> 0x00c7 }
            goto L_0x0058
        L_0x00b2:
            java.lang.String r8 = "IBG-BR"
            java.lang.String r1 = "zip viewHierarchy images done successfully"
            com.instabug.library.util.InstabugSDKLogger.v(r8, r1)     // Catch:{ IOException -> 0x00c7 }
            android.net.Uri r8 = android.net.Uri.fromFile(r3)     // Catch:{ IOException -> 0x00c7 }
            r4.close()     // Catch:{ IOException -> 0x00c1 }
            goto L_0x00c5
        L_0x00c1:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x0102 }
        L_0x00c5:
            monitor-exit(r0)
            return r8
        L_0x00c7:
            r8 = move-exception
            goto L_0x00cd
        L_0x00c9:
            r8 = move-exception
            goto L_0x00f5
        L_0x00cb:
            r8 = move-exception
            r4 = r2
        L_0x00cd:
            java.lang.String r1 = "IBG-BR"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f3 }
            r3.<init>()     // Catch:{ all -> 0x00f3 }
            java.lang.String r5 = "zip viewHierarchy images got error: "
            r3.append(r5)     // Catch:{ all -> 0x00f3 }
            java.lang.String r5 = r8.getMessage()     // Catch:{ all -> 0x00f3 }
            r3.append(r5)     // Catch:{ all -> 0x00f3 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00f3 }
            com.instabug.library.util.InstabugSDKLogger.e(r1, r3, r8)     // Catch:{ all -> 0x00f3 }
            if (r4 == 0) goto L_0x00f1
            r4.close()     // Catch:{ IOException -> 0x00ed }
            goto L_0x00f1
        L_0x00ed:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ all -> 0x0102 }
        L_0x00f1:
            monitor-exit(r0)
            return r2
        L_0x00f3:
            r8 = move-exception
            r2 = r4
        L_0x00f5:
            if (r2 == 0) goto L_0x00ff
            r2.close()     // Catch:{ IOException -> 0x00fb }
            goto L_0x00ff
        L_0x00fb:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x0102 }
        L_0x00ff:
            throw r8     // Catch:{ all -> 0x0102 }
        L_0x0100:
            monitor-exit(r0)
            return r2
        L_0x0102:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.screenshot.viewhierarchy.utilities.d.b(com.instabug.bug.screenshot.viewhierarchy.b):android.net.Uri");
    }
}
