package io.flutter.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import f00.a;
import f00.b;

public final class ViewUtils {

    public interface ViewVisitor {
        boolean run(@NonNull View view);
    }

    public static boolean childHasFocus(@Nullable View view) {
        return traverseHierarchy(view, new a());
    }

    public static int generateViewId(int i11) {
        return View.generateViewId();
    }

    @Nullable
    public static Activity getActivity(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return getActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean hasChildViewOfType(@Nullable View view, Class<? extends View>[] clsArr) {
        return traverseHierarchy(view, new b(clsArr));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$hasChildViewOfType$1(Class[] clsArr, View view) {
        for (Class isInstance : clsArr) {
            if (isInstance.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    public static boolean traverseHierarchy(@Nullable View view, @NonNull ViewVisitor viewVisitor) {
        if (view == null) {
            return false;
        }
        if (viewVisitor.run(view)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                if (traverseHierarchy(viewGroup.getChildAt(i11), viewVisitor)) {
                    return true;
                }
            }
        }
        return false;
    }
}
