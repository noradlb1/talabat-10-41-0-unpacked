package j3;

import android.view.MotionEvent;
import android.view.View;
import com.appboy.ui.AppboyFeedFragment;

public final /* synthetic */ class b implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppboyFeedFragment f44356b;

    public /* synthetic */ b(AppboyFeedFragment appboyFeedFragment) {
        this.f44356b = appboyFeedFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f44356b.lambda$onViewCreated$0(view, motionEvent);
    }
}
