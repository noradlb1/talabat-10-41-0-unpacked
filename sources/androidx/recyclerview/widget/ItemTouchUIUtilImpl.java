package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;

class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    static final ItemTouchUIUtil INSTANCE = new ItemTouchUIUtilImpl();

    private static float findMaxElevation(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f11 = 0.0f;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            if (childAt != view) {
                float elevation = ViewCompat.getElevation(childAt);
                if (elevation > f11) {
                    f11 = elevation;
                }
            }
        }
        return f11;
    }

    public void clearView(View view) {
        int i11 = R.id.item_touch_helper_previous_elevation;
        Object tag = view.getTag(i11);
        if (tag instanceof Float) {
            ViewCompat.setElevation(view, ((Float) tag).floatValue());
        }
        view.setTag(i11, (Object) null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f11, float f12, int i11, boolean z11) {
        if (z11) {
            int i12 = R.id.item_touch_helper_previous_elevation;
            if (view.getTag(i12) == null) {
                Float valueOf = Float.valueOf(ViewCompat.getElevation(view));
                ViewCompat.setElevation(view, findMaxElevation(recyclerView, view) + 1.0f);
                view.setTag(i12, valueOf);
            }
        }
        view.setTranslationX(f11);
        view.setTranslationY(f12);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f11, float f12, int i11, boolean z11) {
    }

    public void onSelected(View view) {
    }
}
