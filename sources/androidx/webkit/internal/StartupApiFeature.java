package androidx.webkit.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.WebViewCompat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class StartupApiFeature {
    @VisibleForTesting
    public static final String METADATA_HOLDER_SERVICE_NAME = "org.chromium.android_webview.services.StartupFeatureMetadataHolder";
    private static final Set<StartupApiFeature> sValues = new HashSet();
    private final String mInternalFeatureValue;
    private final String mPublicFeatureValue;

    public static class NoFramework extends StartupApiFeature {
        public NoFramework(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return false;
        }
    }

    public static class P extends StartupApiFeature {
        public P(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    public StartupApiFeature(@NonNull String str, @NonNull String str2) {
        this.mPublicFeatureValue = str;
        this.mInternalFeatureValue = str2;
        sValues.add(this);
    }

    @Nullable
    private static Bundle getMetaDataFromWebViewManifestOrNull(@NonNull Context context) {
        int i11;
        PackageInfo currentWebViewPackage = WebViewCompat.getCurrentWebViewPackage(context);
        if (currentWebViewPackage == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(currentWebViewPackage.packageName, METADATA_HOLDER_SERVICE_NAME);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 33) {
            try {
                return ApiHelperForTiramisu.a(context.getPackageManager(), componentName, ApiHelperForTiramisu.b(640)).metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        } else {
            if (i12 >= 24) {
                i11 = 640;
            } else {
                i11 = 128;
            }
            try {
                return getServiceInfo(context, componentName, i11).metaData;
            } catch (PackageManager.NameNotFoundException unused2) {
                return null;
            }
        }
    }

    private static ServiceInfo getServiceInfo(@NonNull Context context, ComponentName componentName, int i11) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getServiceInfo(componentName, i11);
    }

    @NonNull
    public static Set<StartupApiFeature> values() {
        return Collections.unmodifiableSet(sValues);
    }

    @NonNull
    public String getPublicFeatureName() {
        return this.mPublicFeatureValue;
    }

    public boolean isSupported(@NonNull Context context) {
        return isSupportedByFramework() || isSupportedByWebView(context);
    }

    public abstract boolean isSupportedByFramework();

    @ChecksSdkIntAtLeast(api = 21)
    public boolean isSupportedByWebView(@NonNull Context context) {
        Bundle metaDataFromWebViewManifestOrNull = getMetaDataFromWebViewManifestOrNull(context);
        if (metaDataFromWebViewManifestOrNull == null) {
            return false;
        }
        return metaDataFromWebViewManifestOrNull.containsKey(this.mInternalFeatureValue);
    }
}
