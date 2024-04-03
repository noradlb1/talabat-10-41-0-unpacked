package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;

public interface ItemTouchUIUtil {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f11, float f12, int i11, boolean z11);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f11, float f12, int i11, boolean z11);

    void onSelected(View view);
}
