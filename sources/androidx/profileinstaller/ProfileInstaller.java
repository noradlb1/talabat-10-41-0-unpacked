package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import i2.b;
import i2.c;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

public class ProfileInstaller {
    public static final int DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST = 2;
    public static final int DIAGNOSTIC_CURRENT_PROFILE_EXISTS = 1;
    public static final int DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST = 4;
    public static final int DIAGNOSTIC_REF_PROFILE_EXISTS = 3;
    private static final DiagnosticsCallback EMPTY_DIAGNOSTICS = new DiagnosticsCallback() {
        public void onDiagnosticReceived(int i11, @Nullable Object obj) {
        }

        public void onResultReceived(int i11, @Nullable Object obj) {
        }
    };
    private static final String PROFILE_BASE_DIR = "/data/misc/profiles/cur/0";
    private static final String PROFILE_FILE = "primary.prof";
    private static final String PROFILE_INSTALLER_SKIP_FILE_NAME = "profileinstaller_profileWrittenFor_lastUpdateTime.dat";
    private static final String PROFILE_META_LOCATION = "dexopt/baseline.profm";
    private static final String PROFILE_SOURCE_LOCATION = "dexopt/baseline.prof";
    public static final int RESULT_ALREADY_INSTALLED = 2;
    public static final int RESULT_BASELINE_PROFILE_NOT_FOUND = 6;
    public static final int RESULT_DELETE_SKIP_FILE_SUCCESS = 11;
    public static final int RESULT_DESIRED_FORMAT_UNSUPPORTED = 5;
    public static final int RESULT_INSTALL_SKIP_FILE_SUCCESS = 10;
    public static final int RESULT_INSTALL_SUCCESS = 1;
    public static final int RESULT_IO_EXCEPTION = 7;
    public static final int RESULT_META_FILE_REQUIRED_BUT_NOT_FOUND = 9;
    public static final int RESULT_NOT_WRITABLE = 4;
    public static final int RESULT_PARSE_EXCEPTION = 8;
    public static final int RESULT_UNSUPPORTED_ART_VERSION = 3;
    private static final String TAG = "ProfileInstaller";
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static final DiagnosticsCallback f37392a = new DiagnosticsCallback() {
        public void onDiagnosticReceived(int i11, @Nullable Object obj) {
        }

        public void onResultReceived(int i11, @Nullable Object obj) {
            String str;
            switch (i11) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
                default:
                    str = "";
                    break;
            }
            if (i11 == 6 || i11 == 7 || i11 == 8) {
                Log.e(ProfileInstaller.TAG, str, (Throwable) obj);
            }
        }
    };

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiagnosticCode {
    }

    public interface DiagnosticsCallback {
        void onDiagnosticReceived(int i11, @Nullable Object obj);

        void onResultReceived(int i11, @Nullable Object obj);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultCode {
    }

    private ProfileInstaller() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean b(@NonNull File file) {
        return new File(file, PROFILE_INSTALLER_SKIP_FILE_NAME).delete();
    }

    @WorkerThread
    public static void c(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback) {
        b(context.getFilesDir());
        f(executor, diagnosticsCallback, 11, (Object) null);
    }

    @WorkerThread
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean d(PackageInfo packageInfo, File file, DiagnosticsCallback diagnosticsCallback) {
        DataInputStream dataInputStream;
        File file2 = new File(file, PROFILE_INSTALLER_SKIP_FILE_NAME);
        boolean z11 = false;
        if (!file2.exists()) {
            return false;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(file2));
            long readLong = dataInputStream.readLong();
            dataInputStream.close();
            if (readLong == packageInfo.lastUpdateTime) {
                z11 = true;
            }
            if (z11) {
                diagnosticsCallback.onResultReceived(2, (Object) null);
            }
            return z11;
        } catch (IOException unused) {
            return false;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void e(@NonNull PackageInfo packageInfo, @NonNull File file) {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, PROFILE_INSTALLER_SKIP_FILE_NAME)));
            dataOutputStream.writeLong(packageInfo.lastUpdateTime);
            dataOutputStream.close();
            return;
        } catch (IOException unused) {
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static void f(@NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback, int i11, @Nullable Object obj) {
        executor.execute(new c(diagnosticsCallback, i11, obj));
    }

    @WorkerThread
    public static void g(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback, boolean z11) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name2 = new File(applicationInfo.sourceDir).getName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (z11 || !d(packageInfo, filesDir, diagnosticsCallback)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Installing profile for ");
                sb2.append(context.getPackageName());
                transcodeAndWrite(assets, packageName, packageInfo, filesDir, name2, executor, diagnosticsCallback);
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Skipping profile installation for ");
            sb3.append(context.getPackageName());
        } catch (PackageManager.NameNotFoundException e11) {
            diagnosticsCallback.onResultReceived(7, e11);
        }
    }

    @WorkerThread
    public static void h(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback) {
        try {
            e(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            f(executor, diagnosticsCallback, 10, (Object) null);
        } catch (PackageManager.NameNotFoundException e11) {
            f(executor, diagnosticsCallback, 7, e11);
        }
    }

    private static void transcodeAndWrite(@NonNull AssetManager assetManager, @NonNull String str, @NonNull PackageInfo packageInfo, @NonNull File file, @NonNull String str2, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback) {
        DeviceProfileWriter deviceProfileWriter = new DeviceProfileWriter(assetManager, executor, diagnosticsCallback, str2, PROFILE_SOURCE_LOCATION, PROFILE_META_LOCATION, new File(new File(PROFILE_BASE_DIR, str), PROFILE_FILE));
        if (deviceProfileWriter.deviceAllowsProfileInstallerAotWrites() && deviceProfileWriter.read().transcodeIfNeeded().write()) {
            e(packageInfo, file);
        }
    }

    @WorkerThread
    public static void writeProfile(@NonNull Context context) {
        writeProfile(context, new b(), EMPTY_DIAGNOSTICS);
    }

    @WorkerThread
    public static void writeProfile(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback) {
        g(context, executor, diagnosticsCallback, false);
    }
}
