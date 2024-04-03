package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private final Object mInfo;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static void a(AccessibilityWindowInfo accessibilityWindowInfo, Rect rect) {
            accessibilityWindowInfo.getBoundsInScreen(rect);
        }

        @DoNotInline
        public static AccessibilityWindowInfo b(AccessibilityWindowInfo accessibilityWindowInfo, int i11) {
            return accessibilityWindowInfo.getChild(i11);
        }

        @DoNotInline
        public static int c(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getChildCount();
        }

        @DoNotInline
        public static int d(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getId();
        }

        @DoNotInline
        public static int e(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLayer();
        }

        @DoNotInline
        public static AccessibilityWindowInfo f(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getParent();
        }

        @DoNotInline
        public static AccessibilityNodeInfo g(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getRoot();
        }

        @DoNotInline
        public static int h(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getType();
        }

        @DoNotInline
        public static boolean i(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isAccessibilityFocused();
        }

        @DoNotInline
        public static boolean j(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isActive();
        }

        @DoNotInline
        public static boolean k(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isFocused();
        }

        @DoNotInline
        public static AccessibilityWindowInfo l() {
            return AccessibilityWindowInfo.obtain();
        }

        @DoNotInline
        public static AccessibilityWindowInfo m(AccessibilityWindowInfo accessibilityWindowInfo) {
            return AccessibilityWindowInfo.obtain(accessibilityWindowInfo);
        }

        @DoNotInline
        public static void n(AccessibilityWindowInfo accessibilityWindowInfo) {
            accessibilityWindowInfo.recycle();
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static AccessibilityNodeInfo a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getAnchor();
        }

        @DoNotInline
        public static CharSequence b(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTitle();
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static int a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getDisplayId();
        }

        @DoNotInline
        public static void b(AccessibilityWindowInfo accessibilityWindowInfo, Region region) {
            accessibilityWindowInfo.getRegionInScreen(region);
        }

        @DoNotInline
        public static boolean c(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isInPictureInPictureMode();
        }
    }

    private AccessibilityWindowInfoCompat(Object obj) {
        this.mInfo = obj;
    }

    public static AccessibilityWindowInfoCompat a(Object obj) {
        if (obj != null) {
            return new AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    @Nullable
    public static AccessibilityWindowInfoCompat obtain() {
        return a(Api21Impl.l());
    }

    private static String typeToString(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY" : "TYPE_SYSTEM" : "TYPE_INPUT_METHOD" : "TYPE_APPLICATION";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityWindowInfoCompat)) {
            return false;
        }
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
        Object obj2 = this.mInfo;
        if (obj2 != null) {
            return obj2.equals(accessibilityWindowInfoCompat.mInfo);
        }
        if (accessibilityWindowInfoCompat.mInfo == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public AccessibilityNodeInfoCompat getAnchor() {
        if (Build.VERSION.SDK_INT >= 24) {
            return AccessibilityNodeInfoCompat.a(Api24Impl.a((AccessibilityWindowInfo) this.mInfo));
        }
        return null;
    }

    public void getBoundsInScreen(@NonNull Rect rect) {
        Api21Impl.a((AccessibilityWindowInfo) this.mInfo, rect);
    }

    @Nullable
    public AccessibilityWindowInfoCompat getChild(int i11) {
        return a(Api21Impl.b((AccessibilityWindowInfo) this.mInfo, i11));
    }

    public int getChildCount() {
        return Api21Impl.c((AccessibilityWindowInfo) this.mInfo);
    }

    public int getDisplayId() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.a((AccessibilityWindowInfo) this.mInfo);
        }
        return 0;
    }

    public int getId() {
        return Api21Impl.d((AccessibilityWindowInfo) this.mInfo);
    }

    public int getLayer() {
        return Api21Impl.e((AccessibilityWindowInfo) this.mInfo);
    }

    @Nullable
    public AccessibilityWindowInfoCompat getParent() {
        return a(Api21Impl.f((AccessibilityWindowInfo) this.mInfo));
    }

    public void getRegionInScreen(@NonNull Region region) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.b((AccessibilityWindowInfo) this.mInfo, region);
            return;
        }
        Rect rect = new Rect();
        Api21Impl.a((AccessibilityWindowInfo) this.mInfo, rect);
        region.set(rect);
    }

    @Nullable
    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.a(Api21Impl.g((AccessibilityWindowInfo) this.mInfo));
    }

    @Nullable
    public CharSequence getTitle() {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.b((AccessibilityWindowInfo) this.mInfo);
        }
        return null;
    }

    public int getType() {
        return Api21Impl.h((AccessibilityWindowInfo) this.mInfo);
    }

    public int hashCode() {
        Object obj = this.mInfo;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return Api21Impl.i((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isActive() {
        return Api21Impl.j((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isFocused() {
        return Api21Impl.k((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isInPictureInPictureMode() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.c((AccessibilityWindowInfo) this.mInfo);
        }
        return false;
    }

    public void recycle() {
        Api21Impl.n((AccessibilityWindowInfo) this.mInfo);
    }

    @NonNull
    public String toString() {
        boolean z11;
        StringBuilder sb2 = new StringBuilder();
        Rect rect = new Rect();
        getBoundsInScreen(rect);
        sb2.append("AccessibilityWindowInfo[");
        sb2.append("id=");
        sb2.append(getId());
        sb2.append(", type=");
        sb2.append(typeToString(getType()));
        sb2.append(", layer=");
        sb2.append(getLayer());
        sb2.append(", bounds=");
        sb2.append(rect);
        sb2.append(", focused=");
        sb2.append(isFocused());
        sb2.append(", active=");
        sb2.append(isActive());
        sb2.append(", hasParent=");
        boolean z12 = true;
        if (getParent() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        sb2.append(z11);
        sb2.append(", hasChildren=");
        if (getChildCount() <= 0) {
            z12 = false;
        }
        sb2.append(z12);
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }

    @Nullable
    public AccessibilityWindowInfo unwrap() {
        return (AccessibilityWindowInfo) this.mInfo;
    }

    @Nullable
    public static AccessibilityWindowInfoCompat obtain(@Nullable AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        if (accessibilityWindowInfoCompat == null) {
            return null;
        }
        return a(Api21Impl.m((AccessibilityWindowInfo) accessibilityWindowInfoCompat.mInfo));
    }
}
