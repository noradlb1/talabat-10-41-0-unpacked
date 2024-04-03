package com.mr.flutter.plugin.filepicker;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.internal.security.CertificateUtil;
import com.mr.flutter.plugin.filepicker.FileInfo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class FileUtils {
    private static final String PRIMARY_VOLUME_NAME = "primary";
    private static final String TAG = "FilePickerUtils";

    public static boolean clearCache(Context context) {
        try {
            File[] listFiles = new File(context.getCacheDir() + "/file_picker/").listFiles();
            if (listFiles == null) {
                return true;
            }
            for (File delete : listFiles) {
                delete.delete();
            }
            return true;
        } catch (Exception e11) {
            Log.e(TAG, "There was an error while clearing cached files: " + e11.toString());
            return false;
        }
    }

    @Nullable
    private static String getDirectoryPath(Class<?> cls, Object obj) {
        try {
            if (Build.VERSION.SDK_INT < 30) {
                return (String) cls.getMethod("getPath", new Class[0]).invoke(obj, new Object[0]);
            }
            File file = (File) cls.getMethod("getDirectory", new Class[0]).invoke(obj, new Object[0]);
            if (file != null) {
                return file.getPath();
            }
            return null;
        } catch (Exception unused) {
        }
    }

    @TargetApi(21)
    private static String getDocumentPathFromTreeUri(Uri uri) {
        String str;
        String[] split = DocumentsContract.getTreeDocumentId(uri).split(CertificateUtil.DELIMITER);
        if (split.length < 2 || (str = split[1]) == null) {
            return File.separator;
        }
        return str;
    }

    public static String getFileName(Uri uri, Context context) {
        Cursor query;
        String str = null;
        try {
            if (uri.getScheme().equals("content")) {
                query = context.getContentResolver().query(uri, new String[]{"_display_name"}, (String) null, (String[]) null, (String) null);
                if (query != null) {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_display_name"));
                    }
                }
                query.close();
            }
            if (str != null) {
                return str;
            }
            String path = uri.getPath();
            int lastIndexOf = path.lastIndexOf(47);
            if (lastIndexOf != -1) {
                return path.substring(lastIndexOf + 1);
            }
            return path;
        } catch (Exception e11) {
            Log.e(TAG, "Failed to handle file name: " + e11.toString());
            return null;
        } catch (Throwable th2) {
            query.close();
            throw th2;
        }
    }

    @RequiresApi(api = 19)
    @Nullable
    public static String getFullPathFromTreeUri(@Nullable Uri uri, Context context) {
        if (uri == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 30 || !isDownloadsDocument(uri)) {
            String volumePath = getVolumePath(getVolumeIdFromTreeUri(uri), context);
            new FileInfo.Builder();
            if (volumePath == null) {
                return File.separator;
            }
            String str = File.separator;
            if (volumePath.endsWith(str)) {
                volumePath = volumePath.substring(0, volumePath.length() - 1);
            }
            String documentPathFromTreeUri = getDocumentPathFromTreeUri(uri);
            if (documentPathFromTreeUri.endsWith(str)) {
                documentPathFromTreeUri = documentPathFromTreeUri.substring(0, documentPathFromTreeUri.length() - 1);
            }
            if (documentPathFromTreeUri.length() <= 0) {
                return volumePath;
            }
            if (documentPathFromTreeUri.startsWith(str)) {
                return volumePath + documentPathFromTreeUri;
            }
            return volumePath + str + documentPathFromTreeUri;
        }
        String documentId = DocumentsContract.getDocumentId(uri);
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        if (documentId.equals("downloads")) {
            return path;
        }
        if (documentId.matches("^ms[df]\\:.*")) {
            String fileName = getFileName(uri, context);
            return path + "/" + fileName;
        } else if (documentId.startsWith("raw:")) {
            return documentId.split(CertificateUtil.DELIMITER)[1];
        } else {
            return null;
        }
    }

    public static String[] getMimeTypes(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(arrayList.get(i11));
            if (mimeTypeFromExtension == null) {
                Log.w(TAG, "Custom file type " + arrayList.get(i11) + " is unsupported and will be ignored.");
            } else {
                arrayList2.add(mimeTypeFromExtension);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Allowed file extensions mimes: ");
        sb2.append(arrayList2);
        return (String[]) arrayList2.toArray(new String[0]);
    }

    @TargetApi(21)
    private static String getVolumeIdFromTreeUri(Uri uri) {
        String[] split = DocumentsContract.getTreeDocumentId(uri).split(CertificateUtil.DELIMITER);
        if (split.length > 0) {
            return split[0];
        }
        return null;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private static String getVolumePath(String str, Context context) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getUuid", new Class[0]);
            Method method3 = cls.getMethod("isPrimary", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            if (invoke == null) {
                return null;
            }
            int length = Array.getLength(invoke);
            for (int i11 = 0; i11 < length; i11++) {
                Object obj = Array.get(invoke, i11);
                String str2 = (String) method2.invoke(obj, new Object[0]);
                if (((Boolean) method3.invoke(obj, new Object[0])) != null && PRIMARY_VOLUME_NAME.equals(str)) {
                    return getDirectoryPath(cls, obj);
                }
                if (str2 != null && str2.equals(str)) {
                    return getDirectoryPath(cls, obj);
                }
            }
            return null;
        } catch (Exception unused) {
        }
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static void loadData(File file, FileInfo.Builder builder) {
        try {
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                bufferedInputStream.read(bArr, 0, length);
                bufferedInputStream.close();
            } catch (FileNotFoundException e11) {
                Log.e(TAG, "File not found: " + e11.getMessage(), (Throwable) null);
            } catch (IOException e12) {
                Log.e(TAG, "Failed to close file streams: " + e12.getMessage(), (Throwable) null);
            }
            builder.withData(bArr);
        } catch (Exception e13) {
            Log.e(TAG, "Failed to load bytes into memory with error " + e13.toString() + ". Probably the file is too big to fit device memory. Bytes won't be added to the file this time.");
        }
    }

    public static FileInfo openFileStream(Context context, Uri uri, boolean z11) {
        Object obj;
        FileOutputStream fileOutputStream;
        Log.i(TAG, "Caching from URI: " + uri.toString());
        FileInfo.Builder builder = new FileInfo.Builder();
        String fileName = getFileName(uri, context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getCacheDir().getAbsolutePath());
        sb2.append("/file_picker/");
        if (fileName != null) {
            obj = fileName;
        } else {
            obj = Long.valueOf(System.currentTimeMillis());
        }
        sb2.append(obj);
        String sb3 = sb2.toString();
        File file = new File(sb3);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(sb3);
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read < 0) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    fileOutputStream.getFD().sync();
                } catch (Exception e11) {
                    e = e11;
                    try {
                        fileOutputStream.close();
                        Log.e(TAG, "Failed to retrieve path: " + e.getMessage(), (Throwable) null);
                        return null;
                    } catch (IOException | NullPointerException unused) {
                        Log.e(TAG, "Failed to close file streams: " + e.getMessage(), (Throwable) null);
                        return null;
                    }
                } catch (Throwable th2) {
                    fileOutputStream.getFD().sync();
                    throw th2;
                }
            } catch (Exception e12) {
                e = e12;
                fileOutputStream = null;
                fileOutputStream.close();
                Log.e(TAG, "Failed to retrieve path: " + e.getMessage(), (Throwable) null);
                return null;
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("File loaded and cached at:");
        sb4.append(sb3);
        if (z11) {
            loadData(file, builder);
        }
        builder.withPath(sb3).withName(fileName).withUri(uri).withSize(Long.parseLong(String.valueOf(file.length())));
        return builder.build();
    }
}
