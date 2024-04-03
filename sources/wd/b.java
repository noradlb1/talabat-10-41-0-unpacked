package wd;

import android.view.MotionEvent;
import android.view.View;
import androidx.customview.widget.ExploreByTouchHelper;

public final /* synthetic */ class b implements View.OnHoverListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExploreByTouchHelper f57914b;

    public /* synthetic */ b(ExploreByTouchHelper exploreByTouchHelper) {
        this.f57914b = exploreByTouchHelper;
    }

    public final boolean onHover(View view, MotionEvent motionEvent) {
        return this.f57914b.dispatchHoverEvent(motionEvent);
    }
}
