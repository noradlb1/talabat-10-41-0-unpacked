package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executors;

public final class PackageManagerCompat {
    @SuppressLint({"ActionValue"})
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String LOG_TAG = "PackageManagerCompat";

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static boolean a(@NonNull Context context) {
            return !context.getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface UnusedAppRestrictionsStatus {
    }

    private PackageManagerCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean areUnusedAppRestrictionsAvailable(@NonNull PackageManager packageManager) {
        boolean z11;
        boolean z12;
        boolean z13;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (i11 < 30) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getPermissionRevocationVerifierApp(packageManager) != null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z11) {
            return true;
        }
        if (!z12 || !z13) {
            return false;
        }
        return true;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String getPermissionRevocationVerifierApp(@NonNull PackageManager packageManager) {
        String str = null;
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", "com.example", (String) null)), 0)) {
            String str2 = resolveInfo.activityInfo.packageName;
            if (packageManager.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", str2) == 0) {
                if (str != null) {
                    return str;
                }
                str = str2;
            }
        }
        return str;
    }

    @NonNull
    public static ListenableFuture<Integer> getUnusedAppRestrictionsStatus(@NonNull Context context) {
        ResolvableFuture create = ResolvableFuture.create();
        if (!UserManagerCompat.isUserUnlocked(context)) {
            create.set(0);
            Log.e(LOG_TAG, "User is in locked direct boot mode");
            return create;
        } else if (!areUnusedAppRestrictionsAvailable(context.getPackageManager())) {
            create.set(1);
            return create;
        } else {
            int i11 = context.getApplicationInfo().targetSdkVersion;
            if (i11 < 30) {
                create.set(0);
                Log.e(LOG_TAG, "Target SDK version below API 30");
                return create;
            }
            int i12 = Build.VERSION.SDK_INT;
            int i13 = 4;
            if (i12 >= 31) {
                if (Api30Impl.a(context)) {
                    if (i11 >= 31) {
                        i13 = 5;
                    }
                    create.set(Integer.valueOf(i13));
                } else {
                    create.set(2);
                }
                return create;
            } else if (i12 == 30) {
                if (!Api30Impl.a(context)) {
                    i13 = 2;
                }
                create.set(Integer.valueOf(i13));
                return create;
            } else {
                UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection = new UnusedAppRestrictionsBackportServiceConnection(context);
                create.addListener(new a(unusedAppRestrictionsBackportServiceConnection), Executors.newSingleThreadExecutor());
                unusedAppRestrictionsBackportServiceConnection.connectAndFetchResult(create);
                return create;
            }
        }
    }
}
