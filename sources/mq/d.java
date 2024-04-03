package mq;

import android.view.MotionEvent;
import android.view.View;
import com.talabat.fragments.DeliveryAreaFragment;

public final /* synthetic */ class d implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeliveryAreaFragment f62319b;

    public /* synthetic */ d(DeliveryAreaFragment deliveryAreaFragment) {
        this.f62319b = deliveryAreaFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return DeliveryAreaFragment.m10482onCreateView$lambda0(this.f62319b, view, motionEvent);
    }
}
