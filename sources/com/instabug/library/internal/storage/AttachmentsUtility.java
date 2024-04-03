package com.instabug.library.internal.storage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.AttachmentsDbHelper;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.model.Attachment;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.bytebuddy.utility.JavaConstant;

public class AttachmentsUtility {
    public static final double MAX_FILE_SIZE_IN_MB = 5.0d;

    public static void clearInternalAttachments(@Nullable Context context) {
        if (context != null) {
            FileUtils.deleteDirectory(getFilesInternalAttachmentDirectory(context));
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static boolean decryptAttachmentAndUpdateDb(Attachment attachment) {
        InstabugSDKLogger.v("IBG-Core", "decryptAttachmentAndUpdateDb");
        if (!attachment.isEncrypted() || attachment.getLocalPath() == null) {
            return true;
        }
        boolean decrypt = InstabugCore.decrypt(attachment.getLocalPath());
        boolean z11 = !decrypt;
        attachment.setEncrypted(z11);
        ContentValues contentValues = new ContentValues();
        if (decrypt) {
            String pathWithDecryptedFlag = FileUtils.getPathWithDecryptedFlag(attachment.getLocalPath());
            contentValues.put(InstabugDbContract.AttachmentEntry.COLUMN_LOCALE_PATH, pathWithDecryptedFlag);
            attachment.setLocalPath(pathWithDecryptedFlag);
            String fileName = FileUtils.getFileName(attachment.getLocalPath());
            if (fileName != null) {
                attachment.setName(fileName);
            }
        }
        contentValues.put(InstabugDbContract.AttachmentEntry.COLUMN_ENCRYPTED, Boolean.valueOf(z11));
        AttachmentsDbHelper.update(attachment.getId(), contentValues);
        return decrypt;
    }

    public static void encryptAttachments(@Nullable List<Attachment> list) {
        InstabugSDKLogger.v("IBG-Core", "encryptAttachments");
        if (list != null) {
            for (Attachment next : list) {
                if (!next.isEncrypted() && next.getLocalPath() != null) {
                    next.setEncrypted(InstabugCore.encrypt(next.getLocalPath()));
                }
            }
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static void encryptAttachmentsAndUpdateDb(@Nullable List<Attachment> list) {
        InstabugSDKLogger.v("IBG-Core", "encryptAttachmentsAndUpdateDb");
        if (list != null) {
            for (Attachment next : list) {
                if (!next.isEncrypted() && next.getLocalPath() != null) {
                    boolean encrypt = InstabugCore.encrypt(next.getLocalPath());
                    next.setEncrypted(encrypt);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(InstabugDbContract.AttachmentEntry.COLUMN_ENCRYPTED, Boolean.valueOf(encrypt));
                    AttachmentsDbHelper.update(next.getId(), contentValues);
                }
            }
        }
    }

    private static boolean fileSizeIsNotValidWithLog(Uri uri, double d11) {
        if (validateFileSize(uri, d11)) {
            return false;
        }
        InstabugSDKLogger.w("IBG-Core", "Attachment file " + uri.toString() + " size exceeds than the limit " + d11);
        return true;
    }

    public static File getAttachmentFile(Context context, String str) {
        File filesAttachmentDirectory = getFilesAttachmentDirectory(context);
        File file = new File(filesAttachmentDirectory, str);
        if (!file.exists()) {
            return file;
        }
        return new File(filesAttachmentDirectory, String.valueOf(System.currentTimeMillis()) + JavaConstant.Dynamic.DEFAULT_NAME + str);
    }

    @RequiresApi(api = 19)
    @Nullable
    public static File getFileFromContentProvider(Context context, @Nullable Uri uri, String str) {
        if (uri == null) {
            return null;
        }
        InputStream fileInputStreamFileFromUri = getFileInputStreamFileFromUri(context, uri);
        if (fileInputStreamFileFromUri != null) {
            return saveInputStreamToFile(context, fileInputStreamFileFromUri, str);
        }
        InstabugSDKLogger.e("IBG-Core", "Inputstream is null while reading file from content provider");
        return null;
    }

    @RequiresApi(api = 19)
    @Nullable
    public static InputStream getFileInputStreamFileFromUri(Context context, Uri uri) {
        try {
            return context.getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public static Pair<String, String> getFileNameAndSize(Context context, @Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    return new Pair<>(query.getString(query.getColumnIndexOrThrow("_display_name")), query.getString(query.getColumnIndexOrThrow("_size")));
                }
            } finally {
                query.close();
            }
        }
        if (query != null) {
            query.close();
        }
        return null;
    }

    public static File getFilesAttachmentDirectory(Context context) {
        return getNewDirectory(context, InstabugDbContract.AttachmentEntry.TABLE_NAME);
    }

    public static File getFilesInternalAttachmentDirectory(Context context) {
        return getNewDirectory(context, "internal-attachments");
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public static String getGalleryImagePath(Activity activity, @Nullable Uri uri) {
        Cursor managedQuery;
        if (uri == null || (managedQuery = activity.managedQuery(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null)) == null) {
            return null;
        }
        int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
        managedQuery.moveToFirst();
        return managedQuery.getString(columnIndexOrThrow);
    }

    private static File getInternalAttachmentFile(Context context, String str) {
        File filesInternalAttachmentDirectory = getFilesInternalAttachmentDirectory(context);
        File file = new File(filesInternalAttachmentDirectory, str);
        if (!file.exists()) {
            return file;
        }
        return new File(filesInternalAttachmentDirectory, System.currentTimeMillis() + JavaConstant.Dynamic.DEFAULT_NAME + str);
    }

    public static File getNewDirectory(Context context, String str) {
        File file = new File(DiskUtils.getInstabugDirectory(context) + "/" + str + "/");
        if (!file.exists() && file.mkdirs()) {
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        return file;
    }

    @Nullable
    public static Uri getNewFileAttachmentUri(@Nullable Context context, Uri uri, @Nullable String str) {
        String str2;
        if (!(uri == null || context == null || uri.getPath() == null)) {
            String lastPathSegment = uri.getLastPathSegment();
            File filesAttachmentDirectory = getFilesAttachmentDirectory(context);
            if (lastPathSegment == null) {
                str2 = "";
            } else {
                str2 = lastPathSegment.toLowerCase();
            }
            if (str == null || SettingsManager.getInstance().getExtraAttachmentFiles() == null || !SettingsManager.getInstance().getExtraAttachmentFiles().containsKey(uri)) {
                str = str2;
            }
            File file = new File(filesAttachmentDirectory, str);
            if (file.exists()) {
                file = new File(filesAttachmentDirectory, System.currentTimeMillis() + JavaConstant.Dynamic.DEFAULT_NAME + str);
            }
            try {
                if (fileSizeIsNotValidWithLog(uri, 5.0d)) {
                    return null;
                }
                DiskUtils.copyFromUriIntoFile(context, uri, file);
                Uri fromFile = Uri.fromFile(file);
                if (fileSizeIsNotValidWithLog(fromFile, 5.0d)) {
                    return null;
                }
                return fromFile;
            } catch (IOException e11) {
                String message = e11.getMessage();
                if (message == null) {
                    message = "Exception while copying attachment file";
                }
                InstabugSDKLogger.e("IBG-Core", message, e11);
            }
        }
        return null;
    }

    @Nullable
    public static Uri getUriFromBytes(Context context, byte[] bArr, String str) {
        File internalAttachmentFile = getInternalAttachmentFile(context, str);
        try {
            saveBytesToFile(bArr, internalAttachmentFile);
            if (FileUtils.encryptFile(internalAttachmentFile.getPath())) {
                internalAttachmentFile = new File(FileUtils.getPathWithEncryptedFlag(internalAttachmentFile.getPath()));
            }
            return Uri.fromFile(internalAttachmentFile);
        } catch (IOException e11) {
            if (e11.getMessage() == null) {
                return null;
            }
            InstabugSDKLogger.e("IBG-Core", "Error while getting uri: " + e11.getMessage(), e11);
            return null;
        }
    }

    public static File getVideoFile(Context context) {
        File newDirectory = getNewDirectory(context, "videos");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS", Locale.ENGLISH);
        return new File(newDirectory, "video-" + simpleDateFormat.format(new Date()) + ".mp4");
    }

    public static File getVideoRecordingFramesDirectory(Context context) {
        return getNewDirectory(context, "frames");
    }

    public static boolean isValidSize(double d11, double d12) {
        double d13 = d11 / 1048576.0d;
        if (d13 <= d12) {
            return true;
        }
        InstabugSDKLogger.w("IBG-Core", "External attachment file size is " + d13 + " MBs > maxFileSize " + d12);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a  */
    @android.annotation.SuppressLint({"RESOURCE_LEAK"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void saveBytesToFile(byte[] r2, java.io.File r3) throws java.io.IOException {
        /*
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0016 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0016 }
            r1.<init>(r3)     // Catch:{ all -> 0x0016 }
            r0.<init>(r1)     // Catch:{ all -> 0x0016 }
            r0.write(r2)     // Catch:{ all -> 0x0014 }
            r0.flush()
            r0.close()
            return
        L_0x0014:
            r2 = move-exception
            goto L_0x0018
        L_0x0016:
            r2 = move-exception
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x0020
            r0.flush()
            r0.close()
        L_0x0020:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.AttachmentsUtility.saveBytesToFile(byte[], java.io.File):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041 A[SYNTHETIC, Splitter:B:23:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069 A[SYNTHETIC, Splitter:B:32:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007a A[SYNTHETIC, Splitter:B:40:0x007a] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0038=Splitter:B:20:0x0038, B:29:0x004f=Splitter:B:29:0x004f} */
    @android.annotation.SuppressLint({"RESOURCE_LEAK"})
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File saveInputStreamToFile(android.content.Context r5, java.io.InputStream r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "IBG-Core"
            java.io.File r1 = new java.io.File
            java.io.File r5 = getFilesAttachmentDirectory(r5)
            r1.<init>(r5, r7)
            r5 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x004d, Exception -> 0x0036, all -> 0x0034 }
            r7.<init>(r1)     // Catch:{ IOException -> 0x004d, Exception -> 0x0036, all -> 0x0034 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x0032, Exception -> 0x0030 }
        L_0x0015:
            int r3 = r6.read(r2)     // Catch:{ IOException -> 0x0032, Exception -> 0x0030 }
            r4 = -1
            if (r3 == r4) goto L_0x0021
            r4 = 0
            r7.write(r2, r4, r3)     // Catch:{ IOException -> 0x0032, Exception -> 0x0030 }
            goto L_0x0015
        L_0x0021:
            r6.close()     // Catch:{ IOException -> 0x0032, Exception -> 0x0030 }
            r7.flush()     // Catch:{ IOException -> 0x002b }
            r7.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x002f:
            return r1
        L_0x0030:
            r6 = move-exception
            goto L_0x0038
        L_0x0032:
            r6 = move-exception
            goto L_0x004f
        L_0x0034:
            r6 = move-exception
            goto L_0x0078
        L_0x0036:
            r6 = move-exception
            r7 = r5
        L_0x0038:
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0075 }
            com.instabug.library.util.InstabugSDKLogger.e(r0, r1, r6)     // Catch:{ all -> 0x0075 }
            if (r7 == 0) goto L_0x0074
            r7.flush()     // Catch:{ IOException -> 0x0048 }
            r7.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x0074
        L_0x0048:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0074
        L_0x004d:
            r6 = move-exception
            r7 = r5
        L_0x004f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
            r1.<init>()     // Catch:{ all -> 0x0075 }
            java.lang.String r2 = "IO exception: "
            r1.append(r2)     // Catch:{ all -> 0x0075 }
            java.lang.String r2 = r6.getMessage()     // Catch:{ all -> 0x0075 }
            r1.append(r2)     // Catch:{ all -> 0x0075 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0075 }
            com.instabug.library.util.InstabugSDKLogger.e(r0, r1, r6)     // Catch:{ all -> 0x0075 }
            if (r7 == 0) goto L_0x0074
            r7.flush()     // Catch:{ IOException -> 0x0070 }
            r7.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0074:
            return r5
        L_0x0075:
            r5 = move-exception
            r6 = r5
            r5 = r7
        L_0x0078:
            if (r5 == 0) goto L_0x0085
            r5.flush()     // Catch:{ IOException -> 0x0081 }
            r5.close()     // Catch:{ IOException -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0085:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.AttachmentsUtility.saveInputStreamToFile(android.content.Context, java.io.InputStream, java.lang.String):java.io.File");
    }

    public static boolean validateFileSize(Uri uri, double d11) {
        long j11;
        if (Instabug.getApplicationContext() == null || uri.getPath() == null) {
            return false;
        }
        if (uri.toString().contains("android.resource")) {
            try {
                InputStream openInputStream = Instabug.getApplicationContext().getContentResolver().openInputStream(uri);
                if (openInputStream == null) {
                    return false;
                }
                j11 = (long) openInputStream.available();
            } catch (IOException unused) {
                InstabugSDKLogger.w("IBG-Core", "External attachment file " + uri.getPath() + " couldn't be loaded to calculate its size");
                return false;
            }
        } else {
            j11 = new File(uri.getPath()).length();
        }
        double d12 = (double) j11;
        double d13 = d12 / 1048576.0d;
        if (d13 <= d11) {
            return isValidSize(d12, d11);
        }
        InstabugSDKLogger.w("IBG-Core", "External attachment file size is " + j11 + " bytes or " + d13 + " MBs > maxFileSize " + d11);
        return false;
    }

    @Nullable
    public static Uri getNewFileAttachmentUri(@Nullable Context context, Uri uri, @Nullable String str, double d11) {
        String str2;
        if (!(uri == null || context == null || uri.getPath() == null)) {
            String lastPathSegment = uri.getLastPathSegment();
            File filesAttachmentDirectory = getFilesAttachmentDirectory(context);
            if (lastPathSegment == null) {
                str2 = "";
            } else {
                str2 = lastPathSegment.toLowerCase();
            }
            if (str == null || SettingsManager.getInstance().getExtraAttachmentFiles() == null || !SettingsManager.getInstance().getExtraAttachmentFiles().containsKey(uri)) {
                str = str2;
            }
            File file = new File(filesAttachmentDirectory, str);
            if (file.exists()) {
                file = new File(filesAttachmentDirectory, System.currentTimeMillis() + JavaConstant.Dynamic.DEFAULT_NAME + str);
            }
            try {
                if (fileSizeIsNotValidWithLog(uri, d11)) {
                    return null;
                }
                DiskUtils.copyFromUriIntoFile(context, uri, file);
                Uri fromFile = Uri.fromFile(file);
                if (fileSizeIsNotValidWithLog(fromFile, d11)) {
                    return null;
                }
                return fromFile;
            } catch (IOException e11) {
                String message = e11.getMessage();
                if (message == null) {
                    message = "Exception while copying attachment file";
                }
                InstabugSDKLogger.e("IBG-Core", message, e11);
            }
        }
        return null;
    }

    @Nullable
    public static Uri getNewFileAttachmentUri(@Nullable Context context, Uri uri) {
        return getNewFileAttachmentUri(context, uri, (String) null);
    }
}
