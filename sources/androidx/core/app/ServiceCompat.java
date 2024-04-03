package androidx.core.app;

import android.app.Service;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat {
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void stopForeground(Service service2, int i11) {
            service2.stopForeground(i11);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    public static void stopForeground(@NonNull Service service2, int i11) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.stopForeground(service2, i11);
            return;
        }
        boolean z11 = true;
        if ((i11 & 1) == 0) {
            z11 = false;
        }
        service2.stopForeground(z11);
    }
}
