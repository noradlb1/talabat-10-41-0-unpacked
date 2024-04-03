package ue;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class h9 implements View.OnTouchListener {
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return view.getParent().requestDisallowInterceptTouchEvent(true);
    }
}
