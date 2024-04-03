package io.flutter.embedding.engine.loader;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import io.flutter.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

@Instrumented
class ResourceExtractor {
    private static final String[] SUPPORTED_ABIS = getSupportedAbis();
    private static final String TAG = "ResourceExtractor";
    private static final String TIMESTAMP_PREFIX = "res_timestamp-";
    @NonNull
    private final AssetManager mAssetManager;
    @NonNull
    private final String mDataDirPath;
    private ExtractTask mExtractTask;
    @NonNull
    private final PackageManager mPackageManager;
    @NonNull
    private final String mPackageName;
    @NonNull
    private final HashSet<String> mResources;

    @Instrumented
    public static class ExtractTask extends AsyncTask implements TraceFieldInterface {
        public Trace _nr_trace;
        @NonNull
        private final AssetManager mAssetManager;
        @NonNull
        private final String mDataDirPath;
        @NonNull
        private final PackageManager mPackageManager;
        @NonNull
        private final String mPackageName;
        @NonNull
        private final HashSet<String> mResources;

        @WorkerThread
        private boolean extractAPK(@NonNull File file) {
            FileOutputStream fileOutputStream;
            Iterator<String> it = this.mResources.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    File file2 = new File(file, next);
                    if (!file2.exists()) {
                        if (file2.getParentFile() != null) {
                            file2.getParentFile().mkdirs();
                        }
                        InputStream open = this.mAssetManager.open(next);
                        try {
                            fileOutputStream = new FileOutputStream(file2);
                            ResourceExtractor.copy(open, fileOutputStream);
                            fileOutputStream.close();
                            if (open != null) {
                                open.close();
                            }
                        } catch (Throwable th2) {
                            if (open != null) {
                                open.close();
                            }
                            throw th2;
                        }
                    }
                } catch (FileNotFoundException unused) {
                } catch (IOException e11) {
                    Log.w(ResourceExtractor.TAG, "Exception unpacking resources: " + e11.getMessage());
                    ResourceExtractor.deleteFiles(this.mDataDirPath, this.mResources);
                    return false;
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            return true;
            throw th;
        }

        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        public Void a(Void... voidArr) {
            File file = new File(this.mDataDirPath);
            String a11 = ResourceExtractor.checkTimestamp(file, this.mPackageManager, this.mPackageName);
            if (a11 == null) {
                return null;
            }
            ResourceExtractor.deleteFiles(this.mDataDirPath, this.mResources);
            if (!extractAPK(file)) {
                return null;
            }
            try {
                new File(file, a11).createNewFile();
            } catch (IOException unused) {
                Log.w(ResourceExtractor.TAG, "Failed to write resource timestamp");
            }
            return null;
        }

        public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "ResourceExtractor$ExtractTask#doInBackground", (ArrayList<String>) null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod((Trace) null, "ResourceExtractor$ExtractTask#doInBackground", (ArrayList<String>) null);
            }
            Void a11 = a((Void[]) objArr);
            TraceMachine.exitMethod();
            return a11;
        }
    }

    /* access modifiers changed from: private */
    public static String checkTimestamp(@NonNull File file, @NonNull PackageManager packageManager, @NonNull String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return TIMESTAMP_PREFIX;
            }
            String str2 = TIMESTAMP_PREFIX + d(packageInfo) + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + packageInfo.lastUpdateTime;
            String[] existingTimestamps = getExistingTimestamps(file);
            if (existingTimestamps != null && existingTimestamps.length == 1 && str2.equals(existingTimestamps[0])) {
                return null;
            }
            return str2;
        } catch (PackageManager.NameNotFoundException unused) {
            return TIMESTAMP_PREFIX;
        }
    }

    /* access modifiers changed from: private */
    public static void copy(@NonNull InputStream inputStream, @NonNull OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[16384];
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static long d(@NonNull PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }

    /* access modifiers changed from: private */
    public static void deleteFiles(@NonNull String str, @NonNull HashSet<String> hashSet) {
        File file = new File(str);
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            File file2 = new File(file, it.next());
            if (file2.exists()) {
                file2.delete();
            }
        }
        String[] existingTimestamps = getExistingTimestamps(file);
        if (existingTimestamps != null) {
            for (String file3 : existingTimestamps) {
                new File(file, file3).delete();
            }
        }
    }

    private static String[] getExistingTimestamps(File file) {
        return file.list(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.startsWith(ResourceExtractor.TIMESTAMP_PREFIX);
            }
        });
    }

    private static String[] getSupportedAbis() {
        return Build.SUPPORTED_ABIS;
    }

    public void e() {
        ExtractTask extractTask = this.mExtractTask;
        if (extractTask != null) {
            try {
                extractTask.get();
            } catch (InterruptedException | CancellationException | ExecutionException unused) {
                deleteFiles(this.mDataDirPath, this.mResources);
            }
        }
    }
}
