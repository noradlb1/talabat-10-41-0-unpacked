package com.talabat;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/ChooseSavedAddressScreen$initView$4", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChooseSavedAddressScreen$initView$4 implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseSavedAddressScreen f54010b;

    public ChooseSavedAddressScreen$initView$4(ChooseSavedAddressScreen chooseSavedAddressScreen) {
        this.f54010b = chooseSavedAddressScreen;
    }

    public boolean onTouch(@Nullable View view, @Nullable MotionEvent motionEvent) {
        Integer num;
        if (motionEvent != null) {
            num = Integer.valueOf(motionEvent.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            this.f54010b.animateToHide();
        }
        if (view != null) {
            return view.onTouchEvent(motionEvent);
        }
        return true;
    }
}
