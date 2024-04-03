package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DisplayCutoutCompat {
    private final DisplayCutout mDisplayCutout;

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static DisplayCutout a(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        @DoNotInline
        public static List<Rect> b(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        @DoNotInline
        public static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        @DoNotInline
        public static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        @DoNotInline
        public static int e(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        @DoNotInline
        public static int f(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static DisplayCutout a(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4) {
            return new DisplayCutout(insets, rect, rect2, rect3, rect4);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static DisplayCutout a(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, Insets insets2) {
            return new DisplayCutout(insets, rect, rect2, rect3, rect4, insets2);
        }

        @DoNotInline
        public static Insets b(DisplayCutout displayCutout) {
            return displayCutout.getWaterfallInsets();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DisplayCutoutCompat(@Nullable Rect rect, @Nullable List<Rect> list) {
        this(Build.VERSION.SDK_INT >= 28 ? Api28Impl.a(rect, list) : null);
    }

    public static DisplayCutoutCompat b(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new DisplayCutoutCompat(displayCutout);
    }

    private static DisplayCutout constructDisplayCutout(@NonNull androidx.core.graphics.Insets insets, @Nullable Rect rect, @Nullable Rect rect2, @Nullable Rect rect3, @Nullable Rect rect4, @NonNull androidx.core.graphics.Insets insets2) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            return Api30Impl.a(insets.toPlatformInsets(), rect, rect2, rect3, rect4, insets2.toPlatformInsets());
        } else if (i11 >= 29) {
            return Api29Impl.a(insets.toPlatformInsets(), rect, rect2, rect3, rect4);
        } else {
            if (i11 < 28) {
                return null;
            }
            Rect rect5 = new Rect(insets.left, insets.top, insets.right, insets.bottom);
            ArrayList arrayList = new ArrayList();
            if (rect != null) {
                arrayList.add(rect);
            }
            if (rect2 != null) {
                arrayList.add(rect2);
            }
            if (rect3 != null) {
                arrayList.add(rect3);
            }
            if (rect4 != null) {
                arrayList.add(rect4);
            }
            return Api28Impl.a(rect5, arrayList);
        }
    }

    @RequiresApi(28)
    public DisplayCutout a() {
        return this.mDisplayCutout;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DisplayCutoutCompat.class != obj.getClass()) {
            return false;
        }
        return ObjectsCompat.equals(this.mDisplayCutout, ((DisplayCutoutCompat) obj).mDisplayCutout);
    }

    @NonNull
    public List<Rect> getBoundingRects() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.b(this.mDisplayCutout);
        }
        return Collections.emptyList();
    }

    public int getSafeInsetBottom() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.c(this.mDisplayCutout);
        }
        return 0;
    }

    public int getSafeInsetLeft() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.d(this.mDisplayCutout);
        }
        return 0;
    }

    public int getSafeInsetRight() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.e(this.mDisplayCutout);
        }
        return 0;
    }

    public int getSafeInsetTop() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.f(this.mDisplayCutout);
        }
        return 0;
    }

    @NonNull
    public androidx.core.graphics.Insets getWaterfallInsets() {
        if (Build.VERSION.SDK_INT >= 30) {
            return androidx.core.graphics.Insets.toCompatInsets(Api30Impl.b(this.mDisplayCutout));
        }
        return androidx.core.graphics.Insets.NONE;
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.mDisplayCutout;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    @NonNull
    public String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
    }

    public DisplayCutoutCompat(@NonNull androidx.core.graphics.Insets insets, @Nullable Rect rect, @Nullable Rect rect2, @Nullable Rect rect3, @Nullable Rect rect4, @NonNull androidx.core.graphics.Insets insets2) {
        this(constructDisplayCutout(insets, rect, rect2, rect3, rect4, insets2));
    }

    private DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.mDisplayCutout = displayCutout;
    }
}
