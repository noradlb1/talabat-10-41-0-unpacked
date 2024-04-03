package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class AppLocalesMetadataHolderService extends Service {

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static int a() {
            return 512;
        }
    }

    @NonNull
    public static ServiceInfo getServiceInfo(@NonNull Context context) throws PackageManager.NameNotFoundException {
        int i11;
        if (Build.VERSION.SDK_INT >= 24) {
            i11 = Api24Impl.a() | 128;
        } else {
            i11 = 640;
        }
        return context.getPackageManager().getServiceInfo(new ComponentName(context, AppLocalesMetadataHolderService.class), i11);
    }

    @NonNull
    public IBinder onBind(@NonNull Intent intent) {
        throw new UnsupportedOperationException();
    }
}
