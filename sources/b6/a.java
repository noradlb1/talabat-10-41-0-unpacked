package b6;

import android.view.MotionEvent;
import android.view.View;
import com.designsystem.ds_button.DSButton;

public final /* synthetic */ class a implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DSButton f29320b;

    public /* synthetic */ a(DSButton dSButton) {
        this.f29320b = dSButton;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return DSButton.m8285setupTouchHandler$lambda1(this.f29320b, view, motionEvent);
    }
}
