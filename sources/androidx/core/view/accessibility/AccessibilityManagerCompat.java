package androidx.core.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

public final class AccessibilityManagerCompat {

    @Deprecated
    public interface AccessibilityStateChangeListener {
        @Deprecated
        void onAccessibilityStateChanged(boolean z11);
    }

    @Deprecated
    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
    }

    public static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public AccessibilityStateChangeListener f11534a;

        public AccessibilityStateChangeListenerWrapper(@NonNull AccessibilityStateChangeListener accessibilityStateChangeListener) {
            this.f11534a = accessibilityStateChangeListener;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AccessibilityStateChangeListenerWrapper)) {
                return false;
            }
            return this.f11534a.equals(((AccessibilityStateChangeListenerWrapper) obj).f11534a);
        }

        public int hashCode() {
            return this.f11534a.hashCode();
        }

        public void onAccessibilityStateChanged(boolean z11) {
            this.f11534a.onAccessibilityStateChanged(z11);
        }
    }

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static boolean a(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return accessibilityManager.addTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(touchExplorationStateChangeListener));
        }

        @DoNotInline
        public static boolean b(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return accessibilityManager.removeTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(touchExplorationStateChangeListener));
        }
    }

    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean z11);
    }

    @RequiresApi(19)
    public static final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final TouchExplorationStateChangeListener f11535a;

        public TouchExplorationStateChangeListenerWrapper(@NonNull TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            this.f11535a = touchExplorationStateChangeListener;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TouchExplorationStateChangeListenerWrapper)) {
                return false;
            }
            return this.f11535a.equals(((TouchExplorationStateChangeListenerWrapper) obj).f11535a);
        }

        public int hashCode() {
            return this.f11535a.hashCode();
        }

        public void onTouchExplorationStateChanged(boolean z11) {
            this.f11535a.onTouchExplorationStateChanged(z11);
        }
    }

    private AccessibilityManagerCompat() {
    }

    @Deprecated
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        if (accessibilityStateChangeListener == null) {
            return false;
        }
        return accessibilityManager.addAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(accessibilityStateChangeListener));
    }

    public static boolean addTouchExplorationStateChangeListener(@NonNull AccessibilityManager accessibilityManager, @NonNull TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return Api19Impl.a(accessibilityManager, touchExplorationStateChangeListener);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i11) {
        return accessibilityManager.getEnabledAccessibilityServiceList(i11);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return accessibilityManager.getInstalledAccessibilityServiceList();
    }

    @Deprecated
    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isTouchExplorationEnabled();
    }

    @Deprecated
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        if (accessibilityStateChangeListener == null) {
            return false;
        }
        return accessibilityManager.removeAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(accessibilityStateChangeListener));
    }

    public static boolean removeTouchExplorationStateChangeListener(@NonNull AccessibilityManager accessibilityManager, @NonNull TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return Api19Impl.b(accessibilityManager, touchExplorationStateChangeListener);
    }
}
