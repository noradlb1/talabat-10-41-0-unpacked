package wd;

import android.view.MotionEvent;
import android.view.View;
import androidx.customview.widget.ExploreByTouchHelper;

public final /* synthetic */ class a implements View.OnHoverListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExploreByTouchHelper f57913b;

    public /* synthetic */ a(ExploreByTouchHelper exploreByTouchHelper) {
        this.f57913b = exploreByTouchHelper;
    }

    public final boolean onHover(View view, MotionEvent motionEvent) {
        return this.f57913b.dispatchHoverEvent(motionEvent);
    }
}
