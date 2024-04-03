package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    @RequiresApi(18)
    public static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        public static int a(ViewGroup viewGroup) {
            return viewGroup.getLayoutMode();
        }

        @DoNotInline
        public static void b(ViewGroup viewGroup, int i11) {
            viewGroup.setLayoutMode(i11);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        @DoNotInline
        public static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        @DoNotInline
        public static void c(ViewGroup viewGroup, boolean z11) {
            viewGroup.setTransitionGroup(z11);
        }
    }

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(@NonNull ViewGroup viewGroup) {
        return Api18Impl.a(viewGroup);
    }

    public static int getNestedScrollAxes(@NonNull ViewGroup viewGroup) {
        return Api21Impl.a(viewGroup);
    }

    public static boolean isTransitionGroup(@NonNull ViewGroup viewGroup) {
        return Api21Impl.b(viewGroup);
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void setLayoutMode(@NonNull ViewGroup viewGroup, int i11) {
        Api18Impl.b(viewGroup, i11);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z11) {
        viewGroup.setMotionEventSplittingEnabled(z11);
    }

    public static void setTransitionGroup(@NonNull ViewGroup viewGroup, boolean z11) {
        Api21Impl.c(viewGroup, z11);
    }
}
