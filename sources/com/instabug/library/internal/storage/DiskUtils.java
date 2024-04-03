package com.instabug.library.internal.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.NonNull;
import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.nonfatals.cache.NonFatalCacheManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.executor.DeleteOperationExecutor;
import com.instabug.library.internal.storage.executor.ReadOperationExecutor;
import com.instabug.library.internal.storage.executor.WriteOperationExecutor;
import com.instabug.library.internal.storage.operation.DiskOperation;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class DiskUtils {
    public static final String TAG = "DiskUtils";
    private final Context context;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51021b;

        public a(String str) {
            this.f51021b = str;
        }

        public void run() {
            new File(this.f51021b).delete();
        }
    }

    public class b implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51022a;

        public b(String str) {
            this.f51022a = str;
        }

        public boolean accept(File file, String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("files:");
            sb2.append(this.f51022a);
            return str.startsWith(sb2.toString()) && str.endsWith(".txt");
        }
    }

    private DiskUtils(Context context2) {
        this.context = context2;
    }

    public static void cleanDirectory(File file) {
        File[] listFiles;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.delete()) {
                    InstabugSDKLogger.v("IBG-Core", "file deleted successfully, path: " + file2.getPath());
                }
            }
        }
    }

    @SuppressLint({"RESOURCE_LEAK"})
    public static void copyFromUriIntoFile(@NonNull Context context2, Uri uri, File file) throws IOException {
        BufferedInputStream bufferedInputStream;
        OutputStream openOutputStream;
        InputStream openInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        if (uri == null || (openInputStream = context2.getContentResolver().openInputStream(uri)) == null) {
            bufferedInputStream = null;
        } else {
            bufferedInputStream = new BufferedInputStream(openInputStream);
        }
        if (bufferedInputStream != null) {
            InstabugSDKLogger.d(TAG, "Target file path: " + file.getPath());
            Uri fromFile = Uri.fromFile(file);
            if (!(fromFile == null || (openOutputStream = context2.getContentResolver().openOutputStream(fromFile)) == null)) {
                bufferedOutputStream = new BufferedOutputStream(openOutputStream);
            }
            if (bufferedOutputStream != null) {
                byte[] bArr = new byte[32768];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
            }
        }
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.close();
            } catch (IOException e11) {
                if (e11.getMessage() != null) {
                    InstabugSDKLogger.e(TAG, e11.getMessage(), e11);
                    return;
                }
                return;
            }
        }
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
    }

    public static File createStateTextFile(Context context2, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context2.getFilesDir().getAbsolutePath());
        String str2 = File.pathSeparator;
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        sb2.append(System.currentTimeMillis());
        sb2.append(".txt");
        return new File(sb2.toString());
    }

    public static void deleteAllStateFiles() {
        File[] listFiles;
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            File parentFile = applicationContext.getFilesDir().getParentFile();
            dd.a aVar = new dd.a();
            if (parentFile != null && (listFiles = parentFile.listFiles(aVar)) != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }
    }

    public static void deleteAppTerminationsStateFiles() {
        deleteStateFiles("app_termination_state");
    }

    public static void deleteBugsStateFiles() {
        deleteStateFiles(InstabugDbContract.BugEntry.COLUMN_BUG_STATE);
    }

    public static void deleteCrashStateFiles() {
        deleteStateFiles("crash_state");
    }

    public static void deleteFile(String str) {
        PoolProvider.postIOTask(new a(str));
    }

    public static void deleteNonfatalStateFiles() {
        deleteStateFiles(NonFatalCacheManager.NON_FATAL_STATE);
    }

    public static void deleteStateFiles(String str) {
        File[] listFiles;
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            File parentFile = applicationContext.getFilesDir().getParentFile();
            b bVar = new b(str);
            if (parentFile != null && (listFiles = parentFile.listFiles(bVar)) != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }
    }

    public static synchronized File getInsatbugLogDirectory(String str, Context context2) {
        File file;
        synchronized (DiskUtils.class) {
            file = new File(getInstabugDirectory(context2).getAbsolutePath().concat("/").concat(str));
            if (!file.exists() && !file.mkdir()) {
                Log.w(TAG, "failed logs directory to create");
            }
        }
        return file;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static File getInstabugDirectory(Context context2) {
        String str;
        if (context2.getExternalFilesDir((String) null) == null || !Environment.getExternalStorageState().equals("mounted")) {
            str = getInternalStoragePath(context2);
            InstabugSDKLogger.i(TAG, "External storage not available, saving file to internal storage.");
        } else {
            try {
                str = context2.getExternalFilesDir((String) null).getAbsolutePath();
            } catch (NullPointerException unused) {
                str = getInternalStoragePath(context2);
                InstabugSDKLogger.w(TAG, "External storage not available, saving file to internal storage.");
            }
        }
        File file = new File(str + "/instabug/");
        if (!file.exists() && file.mkdirs()) {
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        return file;
    }

    private static String getInternalStoragePath(Context context2) {
        return context2.getFilesDir().getAbsolutePath();
    }

    public static boolean isFileExist(String str) {
        return new File(str).exists();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$deleteAllStateFiles$0(File file, String str) {
        if (!str.startsWith("files:") || !str.endsWith(".txt") || str.contains(NonFatalCacheManager.NON_FATAL_STATE)) {
            return false;
        }
        return true;
    }

    public static void saveBitmapOnDisk(Bitmap bitmap, File file) throws IOException {
        if (bitmap != null && file != null) {
            InstabugSDKLogger.v("IBG-Core", "starting save viewHierarchy image, path: " + file.getAbsolutePath());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            InstabugSDKLogger.v("IBG-Core", "viewHierarchy image saved, path: " + file.getAbsolutePath() + ", time in MS: " + System.currentTimeMillis());
        }
    }

    public static DiskUtils with(Context context2) {
        return new DiskUtils(context2);
    }

    public DeleteOperationExecutor deleteOperation(@NonNull DiskOperation<Boolean, Void> diskOperation) {
        return new DeleteOperationExecutor(diskOperation);
    }

    public ReadOperationExecutor readOperation(@NonNull DiskOperation<String, Void> diskOperation) {
        return new ReadOperationExecutor(diskOperation);
    }

    public WriteOperationExecutor writeOperation(@NonNull DiskOperation<Uri, Context> diskOperation) {
        return new WriteOperationExecutor(this.context, diskOperation);
    }
}
