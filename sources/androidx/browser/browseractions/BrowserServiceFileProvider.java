package androidx.browser.browseractions;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.FileProvider;
import androidx.core.util.AtomicFile;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import net.bytebuddy.utility.JavaConstant;

@Deprecated
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class BrowserServiceFileProvider extends FileProvider {
    private static final String AUTHORITY_SUFFIX = ".image_provider";
    private static final String CLIP_DATA_LABEL = "image_provider_uris";
    private static final String CONTENT_SCHEME = "content";
    private static final String FILE_EXTENSION = ".png";
    private static final String FILE_SUB_DIR = "image_provider";
    private static final String FILE_SUB_DIR_NAME = "image_provider_images/";
    private static final String LAST_CLEANUP_TIME_KEY = "last_cleanup_time";
    private static final String TAG = "BrowserServiceFP";

    /* renamed from: b  reason: collision with root package name */
    public static Object f974b = new Object();

    public static class FileCleanupTask extends AsyncTask<Void, Void, Void> {
        private static final long CLEANUP_REQUIRED_TIME_SPAN;
        private static final long DELETION_FAILED_REATTEMPT_DURATION;
        private static final long IMAGE_RETENTION_DURATION;
        private final Context mAppContext;

        static {
            TimeUnit timeUnit = TimeUnit.DAYS;
            IMAGE_RETENTION_DURATION = timeUnit.toMillis(7);
            CLEANUP_REQUIRED_TIME_SPAN = timeUnit.toMillis(7);
            DELETION_FAILED_REATTEMPT_DURATION = timeUnit.toMillis(1);
        }

        public FileCleanupTask(Context context) {
            this.mAppContext = context.getApplicationContext();
        }

        private static boolean isImageFile(File file) {
            return file.getName().endsWith("..png");
        }

        private static boolean shouldCleanUp(SharedPreferences sharedPreferences) {
            if (System.currentTimeMillis() > sharedPreferences.getLong(BrowserServiceFileProvider.LAST_CLEANUP_TIME_KEY, System.currentTimeMillis()) + CLEANUP_REQUIRED_TIME_SPAN) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            long j11;
            SharedPreferences sharedPreferences = this.mAppContext.getSharedPreferences(this.mAppContext.getPackageName() + BrowserServiceFileProvider.AUTHORITY_SUFFIX, 0);
            if (!shouldCleanUp(sharedPreferences)) {
                return null;
            }
            synchronized (BrowserServiceFileProvider.f974b) {
                File file = new File(this.mAppContext.getFilesDir(), BrowserServiceFileProvider.FILE_SUB_DIR);
                if (!file.exists()) {
                    return null;
                }
                File[] listFiles = file.listFiles();
                long currentTimeMillis = System.currentTimeMillis() - IMAGE_RETENTION_DURATION;
                boolean z11 = true;
                for (File file2 : listFiles) {
                    if (isImageFile(file2)) {
                        if (file2.lastModified() < currentTimeMillis && !file2.delete()) {
                            Log.e(BrowserServiceFileProvider.TAG, "Fail to delete image: " + file2.getAbsoluteFile());
                            z11 = false;
                        }
                    }
                }
                if (z11) {
                    j11 = System.currentTimeMillis();
                } else {
                    j11 = (System.currentTimeMillis() - CLEANUP_REQUIRED_TIME_SPAN) + DELETION_FAILED_REATTEMPT_DURATION;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(BrowserServiceFileProvider.LAST_CLEANUP_TIME_KEY, j11);
                edit.apply();
                return null;
            }
        }
    }

    public static class FileSaveTask extends AsyncTask<String, Void, Void> {
        private final Context mAppContext;
        private final Bitmap mBitmap;
        private final Uri mFileUri;
        private final String mFilename;
        private final ResolvableFuture<Uri> mResultFuture;

        public FileSaveTask(Context context, String str, Bitmap bitmap, Uri uri, ResolvableFuture<Uri> resolvableFuture) {
            this.mAppContext = context.getApplicationContext();
            this.mFilename = str;
            this.mBitmap = bitmap;
            this.mFileUri = uri;
            this.mResultFuture = resolvableFuture;
        }

        private void saveFileBlocking(File file) {
            FileOutputStream fileOutputStream;
            AtomicFile atomicFile = new AtomicFile(file);
            try {
                fileOutputStream = atomicFile.startWrite();
                try {
                    this.mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.close();
                    atomicFile.finishWrite(fileOutputStream);
                    this.mResultFuture.set(this.mFileUri);
                } catch (IOException e11) {
                    e = e11;
                }
            } catch (IOException e12) {
                e = e12;
                fileOutputStream = null;
                atomicFile.failWrite(fileOutputStream);
                this.mResultFuture.setException(e);
            }
        }

        private void saveFileIfNeededBlocking() {
            File file = new File(this.mAppContext.getFilesDir(), BrowserServiceFileProvider.FILE_SUB_DIR);
            synchronized (BrowserServiceFileProvider.f974b) {
                if (file.exists() || file.mkdir()) {
                    File file2 = new File(file, this.mFilename + BrowserServiceFileProvider.FILE_EXTENSION);
                    if (file2.exists()) {
                        this.mResultFuture.set(this.mFileUri);
                    } else {
                        saveFileBlocking(file2);
                    }
                    file2.setLastModified(System.currentTimeMillis());
                    return;
                }
                this.mResultFuture.setException(new IOException("Could not create file directory."));
            }
        }

        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            saveFileIfNeededBlocking();
            return null;
        }

        /* renamed from: b */
        public void onPostExecute(Void voidR) {
            new FileCleanupTask(this.mAppContext).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    private static Uri generateUri(Context context, String str) {
        return new Uri.Builder().scheme("content").authority(context.getPackageName() + AUTHORITY_SUFFIX).path(FILE_SUB_DIR_NAME + str + FILE_EXTENSION).build();
    }

    public static void grantReadPermission(@NonNull Intent intent, @Nullable List<Uri> list, @NonNull Context context) {
        if (list != null && list.size() != 0) {
            ContentResolver contentResolver = context.getContentResolver();
            intent.addFlags(1);
            ClipData newUri = ClipData.newUri(contentResolver, CLIP_DATA_LABEL, list.get(0));
            for (int i11 = 1; i11 < list.size(); i11++) {
                newUri.addItem(new ClipData.Item(list.get(i11)));
            }
            intent.setClipData(newUri);
        }
    }

    @NonNull
    public static ListenableFuture<Bitmap> loadBitmap(@NonNull final ContentResolver contentResolver, @NonNull final Uri uri) {
        final ResolvableFuture create = ResolvableFuture.create();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
                    if (openFileDescriptor == null) {
                        create.setException(new FileNotFoundException());
                        return;
                    }
                    Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
                    openFileDescriptor.close();
                    if (decodeFileDescriptor == null) {
                        create.setException(new IOException("File could not be decoded."));
                    } else {
                        create.set(decodeFileDescriptor);
                    }
                } catch (IOException e11) {
                    create.setException(e11);
                }
            }
        });
        return create;
    }

    @UiThread
    @NonNull
    public static ResolvableFuture<Uri> saveBitmap(@NonNull Context context, @NonNull Bitmap bitmap, @NonNull String str, int i11) {
        String str2 = str + JavaConstant.Dynamic.DEFAULT_NAME + Integer.toString(i11);
        Uri generateUri = generateUri(context, str2);
        ResolvableFuture<Uri> create = ResolvableFuture.create();
        new FileSaveTask(context, str2, bitmap, generateUri, create).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        return create;
    }
}
