package com.instabug.library.internal.storage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import net.bytebuddy.utility.JavaConstant;

public class AttachmentManager {
    private static final double MAX_FILE_SIZE_IN_MB = 50.0d;

    public interface a {
        void onError(Throwable th2);

        void onSuccess(Uri uri);
    }

    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r2v7, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0071 A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0076 A[SYNTHETIC, Splitter:B:45:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x007e A[Catch:{ IOException -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0091 A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0096 A[SYNTHETIC, Splitter:B:60:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x009e A[Catch:{ IOException -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00b1 A[SYNTHETIC, Splitter:B:73:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00b9 A[Catch:{ IOException -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x006b=Splitter:B:40:0x006b, B:55:0x008b=Splitter:B:55:0x008b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFromUriIntoFile(@androidx.annotation.Nullable android.content.Context r4, @androidx.annotation.NonNull android.net.Uri r5, java.io.File r6) {
        /*
            java.lang.String r0 = "Error while copying file"
            java.lang.String r1 = "IBG-Core"
            if (r4 != 0) goto L_0x0007
            return
        L_0x0007:
            android.content.ContentResolver r2 = r4.getContentResolver()
            if (r2 != 0) goto L_0x000e
            return
        L_0x000e:
            r2 = 0
            android.content.ContentResolver r3 = r4.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0089, IOException -> 0x0069, all -> 0x0066 }
            java.io.InputStream r5 = r3.openInputStream(r5)     // Catch:{ FileNotFoundException -> 0x0089, IOException -> 0x0069, all -> 0x0066 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0089, IOException -> 0x0069, all -> 0x0066 }
            android.net.Uri r6 = android.net.Uri.fromFile(r6)     // Catch:{ FileNotFoundException -> 0x0089, IOException -> 0x0069, all -> 0x0066 }
            java.io.OutputStream r4 = r4.openOutputStream(r6)     // Catch:{ FileNotFoundException -> 0x0089, IOException -> 0x0069, all -> 0x0066 }
            if (r5 == 0) goto L_0x0065
            if (r4 != 0) goto L_0x0028
            goto L_0x0065
        L_0x0028:
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0089, IOException -> 0x0069, all -> 0x0066 }
            r6.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0089, IOException -> 0x0069, all -> 0x0066 }
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005d, all -> 0x005a }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005d, all -> 0x005a }
            r4 = 32768(0x8000, float:4.5918E-41)
            byte[] r4 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0053 }
        L_0x0037:
            int r2 = r6.read(r4)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0053 }
            if (r2 <= 0) goto L_0x0042
            r3 = 0
            r5.write(r4, r3, r2)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x0056, all -> 0x0053 }
            goto L_0x0037
        L_0x0042:
            r5.close()     // Catch:{ IOException -> 0x004a }
            r6.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x00ab
        L_0x004a:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            if (r5 == 0) goto L_0x00ab
            goto L_0x00a8
        L_0x0053:
            r4 = move-exception
            goto L_0x00ae
        L_0x0056:
            r4 = move-exception
            goto L_0x005f
        L_0x0058:
            r4 = move-exception
            goto L_0x0063
        L_0x005a:
            r4 = move-exception
            goto L_0x00af
        L_0x005d:
            r4 = move-exception
            r5 = r2
        L_0x005f:
            r2 = r6
            goto L_0x006b
        L_0x0061:
            r4 = move-exception
            r5 = r2
        L_0x0063:
            r2 = r6
            goto L_0x008b
        L_0x0065:
            return
        L_0x0066:
            r4 = move-exception
            r5 = r2
            goto L_0x00ad
        L_0x0069:
            r4 = move-exception
            r5 = r2
        L_0x006b:
            java.lang.String r6 = r4.getMessage()     // Catch:{ all -> 0x00ac }
            if (r6 == 0) goto L_0x0074
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r4)     // Catch:{ all -> 0x00ac }
        L_0x0074:
            if (r5 == 0) goto L_0x007c
            r5.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x007c
        L_0x007a:
            r4 = move-exception
            goto L_0x0082
        L_0x007c:
            if (r2 == 0) goto L_0x00ab
            r2.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x00ab
        L_0x0082:
            java.lang.String r5 = r4.getMessage()
            if (r5 == 0) goto L_0x00ab
            goto L_0x00a8
        L_0x0089:
            r4 = move-exception
            r5 = r2
        L_0x008b:
            java.lang.String r6 = r4.getMessage()     // Catch:{ all -> 0x00ac }
            if (r6 == 0) goto L_0x0094
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r4)     // Catch:{ all -> 0x00ac }
        L_0x0094:
            if (r5 == 0) goto L_0x009c
            r5.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x009c
        L_0x009a:
            r4 = move-exception
            goto L_0x00a2
        L_0x009c:
            if (r2 == 0) goto L_0x00ab
            r2.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x00ab
        L_0x00a2:
            java.lang.String r5 = r4.getMessage()
            if (r5 == 0) goto L_0x00ab
        L_0x00a8:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r4)
        L_0x00ab:
            return
        L_0x00ac:
            r4 = move-exception
        L_0x00ad:
            r6 = r2
        L_0x00ae:
            r2 = r5
        L_0x00af:
            if (r2 == 0) goto L_0x00b7
            r2.close()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00b7
        L_0x00b5:
            r5 = move-exception
            goto L_0x00bd
        L_0x00b7:
            if (r6 == 0) goto L_0x00c6
            r6.close()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00c6
        L_0x00bd:
            java.lang.String r6 = r5.getMessage()
            if (r6 == 0) goto L_0x00c6
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r5)
        L_0x00c6:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.AttachmentManager.copyFromUriIntoFile(android.content.Context, android.net.Uri, java.io.File):void");
    }

    public static void deleteRecursive(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File deleteRecursive : listFiles) {
                    deleteRecursive(deleteRecursive);
                }
            }
            file.delete();
            return;
        }
        file.delete();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public static File getAttachmentDirectory(@Nullable Context context) {
        String str;
        if (context == null && Instabug.isBuilt()) {
            context = Instabug.getApplicationContext();
        }
        if (context == null) {
            return null;
        }
        if (context.getExternalFilesDir((String) null) == null || !Environment.getExternalStorageState().equals("mounted")) {
            str = getInternalStoragePath(context);
        } else {
            try {
                str = context.getExternalFilesDir((String) null).getAbsolutePath();
            } catch (NullPointerException unused) {
                str = getInternalStoragePath(context);
            }
        }
        File file = new File(str + "/instabug/");
        if (!file.exists()) {
            file.mkdirs();
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        return file;
    }

    private static File getAttachmentFile(Context context, String str) {
        File attachmentDirectory = getAttachmentDirectory(context);
        File file = new File(attachmentDirectory, str);
        if (!file.exists()) {
            return file;
        }
        return new File(attachmentDirectory, String.valueOf(System.currentTimeMillis()) + JavaConstant.Dynamic.DEFAULT_NAME + str);
    }

    public static File getAutoScreenRecordingFile(Context context) {
        File autoScreenRecordingVideosDirectory = getAutoScreenRecordingVideosDirectory(context);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS", Locale.ENGLISH);
        return new File(autoScreenRecordingVideosDirectory, "auto-recording-" + simpleDateFormat.format(new Date()) + ".mp4");
    }

    public static File getAutoScreenRecordingVideosDirectory(Context context) {
        File file = new File(getAttachmentDirectory(context) + "/auto_recording/");
        if (!file.exists()) {
            file.mkdirs();
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        return file;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public static String getGalleryImagePath(Activity activity, Uri uri) {
        Cursor managedQuery;
        if (activity == null || uri == null || (managedQuery = activity.managedQuery(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null)) == null) {
            return null;
        }
        int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
        managedQuery.moveToFirst();
        return managedQuery.getString(columnIndexOrThrow);
    }

    private static String getInternalStoragePath(Context context) {
        return context.getFilesDir().getAbsolutePath();
    }

    public static File getNewDirectory(@Nullable Context context, String str) {
        File file = new File(getAttachmentDirectory(context) + "/" + str + "/");
        if (!file.exists()) {
            file.mkdirs();
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        return file;
    }

    @Nullable
    public static Uri getNewFileUri(Context context, Uri uri, @Nullable String str) {
        if (uri == null) {
            return null;
        }
        String lastPathSegment = uri.getLastPathSegment();
        String lowerCase = lastPathSegment != null ? lastPathSegment.toLowerCase() : "";
        if (str == null || SettingsManager.getInstance().getExtraAttachmentFiles() == null || !SettingsManager.getInstance().getExtraAttachmentFiles().containsKey(uri)) {
            str = lowerCase;
        }
        File attachmentFile = getAttachmentFile(context, str);
        copyFromUriIntoFile(context, uri, attachmentFile);
        if (!validateFileSize(uri, attachmentFile)) {
            return null;
        }
        return Uri.fromFile(attachmentFile);
    }

    @Nullable
    public static Uri getUriFromBytes(Context context, byte[] bArr, String str) {
        File attachmentFile = getAttachmentFile(context, str);
        saveBytesToFile(bArr, attachmentFile);
        return Uri.fromFile(attachmentFile);
    }

    public static File getVideoFile(Context context) {
        File videoRecordingVideosDirectory = getVideoRecordingVideosDirectory(context);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS", Locale.getDefault());
        return new File(videoRecordingVideosDirectory, "video-" + simpleDateFormat.format(new Date()) + ".mp4");
    }

    public static File getVideoRecordingFramesDirectory(Context context) {
        File file = new File(getAttachmentDirectory(context) + "/frames/");
        if (!file.exists()) {
            file.mkdirs();
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        return file;
    }

    public static File getVideoRecordingVideosDirectory(Context context) {
        File file = new File(getAttachmentDirectory(context) + "/videos/");
        if (!file.exists()) {
            file.mkdirs();
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        return file;
    }

    private static Bitmap resizeBitmap(Bitmap bitmap, int i11) {
        int i12;
        float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
        if (width > 1.0f) {
            i12 = (int) (((float) i11) / width);
        } else {
            int i13 = (int) (((float) i11) * width);
            i12 = i11;
            i11 = i13;
        }
        return Bitmap.createScaledBitmap(bitmap, i11, i12, false);
    }

    public static void saveBitmap(Bitmap bitmap, Context context, a aVar) {
        File attachmentDirectory = getAttachmentDirectory(context);
        File file = new File(attachmentDirectory, "bug_" + System.currentTimeMillis() + "_.jpg");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("image path: ");
        sb2.append(file.toString());
        InstabugSDKLogger.v("IBG-Core", sb2.toString());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.close();
            Uri fromFile = Uri.fromFile(file);
            if (fromFile != null) {
                aVar.onSuccess(fromFile);
            } else {
                aVar.onError(new Throwable("Uri equal null"));
            }
        } catch (IOException e11) {
            aVar.onError(e11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0060, code lost:
        com.instabug.library.util.InstabugSDKLogger.e("IBG-Core", "Error while saving file", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0032 A[Catch:{ all -> 0x0029 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0037 A[SYNTHETIC, Splitter:B:22:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004d A[Catch:{ all -> 0x0029 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0052 A[SYNTHETIC, Splitter:B:33:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0067 A[SYNTHETIC, Splitter:B:41:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x0047=Splitter:B:28:0x0047, B:17:0x002c=Splitter:B:17:0x002c} */
    @android.annotation.SuppressLint({"RESOURCE_LEAK"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void saveBytesToFile(byte[] r5, java.io.File r6) {
        /*
            java.lang.String r0 = "Error while saving file"
            java.lang.String r1 = "IBG-Core"
            r2 = 0
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x002b }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x002b }
            r4.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x002b }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x002b }
            r3.write(r5)     // Catch:{ FileNotFoundException -> 0x0026, IOException -> 0x0023, all -> 0x0021 }
            r3.flush()     // Catch:{ IOException -> 0x0019 }
            r3.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x0063
        L_0x0019:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            if (r6 == 0) goto L_0x0063
            goto L_0x0060
        L_0x0021:
            r5 = move-exception
            goto L_0x0065
        L_0x0023:
            r5 = move-exception
            r2 = r3
            goto L_0x002c
        L_0x0026:
            r5 = move-exception
            r2 = r3
            goto L_0x0047
        L_0x0029:
            r5 = move-exception
            goto L_0x0064
        L_0x002b:
            r5 = move-exception
        L_0x002c:
            java.lang.String r6 = r5.getMessage()     // Catch:{ all -> 0x0029 }
            if (r6 == 0) goto L_0x0035
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r5)     // Catch:{ all -> 0x0029 }
        L_0x0035:
            if (r2 == 0) goto L_0x0063
            r2.flush()     // Catch:{ IOException -> 0x003e }
            r2.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0063
        L_0x003e:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            if (r6 == 0) goto L_0x0063
            goto L_0x0060
        L_0x0046:
            r5 = move-exception
        L_0x0047:
            java.lang.String r6 = r5.getMessage()     // Catch:{ all -> 0x0029 }
            if (r6 == 0) goto L_0x0050
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r5)     // Catch:{ all -> 0x0029 }
        L_0x0050:
            if (r2 == 0) goto L_0x0063
            r2.flush()     // Catch:{ IOException -> 0x0059 }
            r2.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x0063
        L_0x0059:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            if (r6 == 0) goto L_0x0063
        L_0x0060:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r5)
        L_0x0063:
            return
        L_0x0064:
            r3 = r2
        L_0x0065:
            if (r3 == 0) goto L_0x0078
            r3.flush()     // Catch:{ IOException -> 0x006e }
            r3.close()     // Catch:{ IOException -> 0x006e }
            goto L_0x0078
        L_0x006e:
            r6 = move-exception
            java.lang.String r2 = r6.getMessage()
            if (r2 == 0) goto L_0x0078
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r6)
        L_0x0078:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.AttachmentManager.saveBytesToFile(byte[], java.io.File):void");
    }

    private static boolean validateFileSize(Uri uri, File file) {
        if (SettingsManager.getInstance().getExtraAttachmentFiles() == null || !SettingsManager.getInstance().getExtraAttachmentFiles().containsKey(uri)) {
            return true;
        }
        double length = ((double) file.length()) / 1048576.0d;
        if (length <= 50.0d) {
            return true;
        }
        InstabugSDKLogger.w("IBG-Core", "Attachment size is" + length + ", exceeds " + 50.0d + " MBs file size limit, ignoring attachment");
        return false;
    }

    @Nullable
    public static Uri getNewFileUri(Context context, Uri uri) {
        return getNewFileUri(context, uri, (String) null);
    }

    public static void saveBitmap(Bitmap bitmap, File file, a aVar) {
        File file2 = new File(file, "frame_" + System.currentTimeMillis() + "_.jpg");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("video frame path: ");
        sb2.append(file2.toString());
        InstabugSDKLogger.v("IBG-Core", sb2.toString());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            if ((bitmap.getWidth() > bitmap.getHeight() ? bitmap.getWidth() : bitmap.getHeight()) > 640) {
                resizeBitmap(bitmap, 640).compress(Bitmap.CompressFormat.JPEG, 90, bufferedOutputStream);
            } else {
                resizeBitmap(bitmap, 320).compress(Bitmap.CompressFormat.JPEG, 90, bufferedOutputStream);
            }
            bufferedOutputStream.close();
            Uri fromFile = Uri.fromFile(file2);
            if (fromFile != null) {
                aVar.onSuccess(fromFile);
            } else {
                aVar.onError(new Throwable("Uri equal null"));
            }
        } catch (IOException e11) {
            aVar.onError(e11);
        }
    }
}
