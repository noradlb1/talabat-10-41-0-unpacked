package s1;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.DragStartHelper;

public final /* synthetic */ class v implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DragStartHelper f11618b;

    public /* synthetic */ v(DragStartHelper dragStartHelper) {
        this.f11618b = dragStartHelper;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f11618b.onTouch(view, motionEvent);
    }
}
