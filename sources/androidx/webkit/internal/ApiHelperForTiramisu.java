package androidx.webkit.internal;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi(33)
public class ApiHelperForTiramisu {
    private ApiHelperForTiramisu() {
    }

    @DoNotInline
    public static ServiceInfo a(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException {
        return packageManager.getServiceInfo(componentName, componentInfoFlags);
    }

    @DoNotInline
    public static PackageManager.ComponentInfoFlags b(long j11) {
        return PackageManager.ComponentInfoFlags.of(j11);
    }
}
