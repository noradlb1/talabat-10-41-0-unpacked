package z5;

import android.view.MotionEvent;
import android.view.View;
import com.designsystem.ds_bottom_sheet.DSBottomSheetContents;

public final /* synthetic */ class d implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DSBottomSheetContents f34853b;

    public /* synthetic */ d(DSBottomSheetContents dSBottomSheetContents) {
        this.f34853b = dSBottomSheetContents;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return DSBottomSheetContents.m8261setupViewsVisibility$lambda1(this.f34853b, view, motionEvent);
    }
}
