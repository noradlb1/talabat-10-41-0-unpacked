package androidx.webkit.internal;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public abstract class ApiFeature implements ConditionallySupportedFeature {
    private static final Set<ApiFeature> sValues = new HashSet();
    private final String mInternalFeatureValue;
    private final String mPublicFeatureValue;

    public static class LAZY_HOLDER {

        /* renamed from: a  reason: collision with root package name */
        public static final Set<String> f37937a = new HashSet(Arrays.asList(WebViewGlueCommunicator.getFactory().getWebViewFeatures()));

        private LAZY_HOLDER() {
        }
    }

    public static class M extends ApiFeature {
        public M(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return true;
        }
    }

    public static class N extends ApiFeature {
        public N(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 24;
        }
    }

    public static class NoFramework extends ApiFeature {
        public NoFramework(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return false;
        }
    }

    public static class O extends ApiFeature {
        public O(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 26;
        }
    }

    public static class O_MR1 extends ApiFeature {
        public O_MR1(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    public static class P extends ApiFeature {
        public P(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    public static class Q extends ApiFeature {
        public Q(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    public static class T extends ApiFeature {
        public T(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }

        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    public ApiFeature(@NonNull String str, @NonNull String str2) {
        this.mPublicFeatureValue = str;
        this.mInternalFeatureValue = str2;
        sValues.add(this);
    }

    @VisibleForTesting
    @NonNull
    public static Set<String> getWebViewApkFeaturesForTesting() {
        return LAZY_HOLDER.f37937a;
    }

    @NonNull
    public static Set<ApiFeature> values() {
        return Collections.unmodifiableSet(sValues);
    }

    @NonNull
    public String getPublicFeatureName() {
        return this.mPublicFeatureValue;
    }

    public boolean isSupported() {
        return isSupportedByFramework() || isSupportedByWebView();
    }

    public abstract boolean isSupportedByFramework();

    @ChecksSdkIntAtLeast(api = 21)
    public boolean isSupportedByWebView() {
        return BoundaryInterfaceReflectionUtil.containsFeature((Collection<String>) LAZY_HOLDER.f37937a, this.mInternalFeatureValue);
    }
}
