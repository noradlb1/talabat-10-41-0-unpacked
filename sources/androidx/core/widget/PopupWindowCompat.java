package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static void showAsDropDown(PopupWindow popupWindow, View view, int i11, int i12, int i13) {
            popupWindow.showAsDropDown(view, i11, i12, i13);
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static boolean getOverlapAnchor(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        @DoNotInline
        public static int getWindowLayoutType(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        @DoNotInline
        public static void setOverlapAnchor(PopupWindow popupWindow, boolean z11) {
            popupWindow.setOverlapAnchor(z11);
        }

        @DoNotInline
        public static void setWindowLayoutType(PopupWindow popupWindow, int i11) {
            popupWindow.setWindowLayoutType(i11);
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(@NonNull PopupWindow popupWindow) {
        return Api23Impl.getOverlapAnchor(popupWindow);
    }

    public static int getWindowLayoutType(@NonNull PopupWindow popupWindow) {
        return Api23Impl.getWindowLayoutType(popupWindow);
    }

    public static void setOverlapAnchor(@NonNull PopupWindow popupWindow, boolean z11) {
        Api23Impl.setOverlapAnchor(popupWindow, z11);
    }

    public static void setWindowLayoutType(@NonNull PopupWindow popupWindow, int i11) {
        Api23Impl.setWindowLayoutType(popupWindow, i11);
    }

    public static void showAsDropDown(@NonNull PopupWindow popupWindow, @NonNull View view, int i11, int i12, int i13) {
        Api19Impl.showAsDropDown(popupWindow, view, i11, i12, i13);
    }
}
