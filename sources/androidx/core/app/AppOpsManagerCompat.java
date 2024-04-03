package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static int noteOp(AppOpsManager appOpsManager, String str, int i11, String str2) {
            return appOpsManager.noteOp(str, i11, str2);
        }

        @DoNotInline
        public static int noteOpNoThrow(AppOpsManager appOpsManager, String str, int i11, String str2) {
            return appOpsManager.noteOpNoThrow(str, i11, str2);
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static <T> T getSystemService(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        @DoNotInline
        public static int noteProxyOp(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOp(str, str2);
        }

        @DoNotInline
        public static int noteProxyOpNoThrow(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        @DoNotInline
        public static String permissionToOp(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static int checkOpNoThrow(@Nullable AppOpsManager appOpsManager, @NonNull String str, int i11, @NonNull String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i11, str2);
        }

        @DoNotInline
        @NonNull
        public static String getOpPackageName(@NonNull Context context) {
            return context.getOpPackageName();
        }

        @DoNotInline
        @Nullable
        public static AppOpsManager getSystemService(@NonNull Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    private AppOpsManagerCompat() {
    }

    public static int checkOrNoteProxyOp(@NonNull Context context, int i11, @NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return noteProxyOpNoThrow(context, str, str2);
        }
        AppOpsManager systemService = Api29Impl.getSystemService(context);
        int checkOpNoThrow = Api29Impl.checkOpNoThrow(systemService, str, Binder.getCallingUid(), str2);
        if (checkOpNoThrow != 0) {
            return checkOpNoThrow;
        }
        return Api29Impl.checkOpNoThrow(systemService, str, i11, Api29Impl.getOpPackageName(context));
    }

    public static int noteOp(@NonNull Context context, @NonNull String str, int i11, @NonNull String str2) {
        return Api19Impl.noteOp((AppOpsManager) context.getSystemService("appops"), str, i11, str2);
    }

    public static int noteOpNoThrow(@NonNull Context context, @NonNull String str, int i11, @NonNull String str2) {
        return Api19Impl.noteOpNoThrow((AppOpsManager) context.getSystemService("appops"), str, i11, str2);
    }

    public static int noteProxyOp(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return Api23Impl.noteProxyOp((AppOpsManager) Api23Impl.getSystemService(context, AppOpsManager.class), str, str2);
    }

    public static int noteProxyOpNoThrow(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return Api23Impl.noteProxyOpNoThrow((AppOpsManager) Api23Impl.getSystemService(context, AppOpsManager.class), str, str2);
    }

    @Nullable
    public static String permissionToOp(@NonNull String str) {
        return Api23Impl.permissionToOp(str);
    }
}
