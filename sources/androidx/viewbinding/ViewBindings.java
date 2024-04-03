package androidx.viewbinding;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

public class ViewBindings {
    private ViewBindings() {
    }

    @Nullable
    public static <T extends View> T findChildViewById(View view, @IdRes int i11) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            T findViewById = viewGroup.getChildAt(i12).findViewById(i11);
            if (findViewById != null) {
                return findViewById;
            }
        }
        return null;
    }
}
