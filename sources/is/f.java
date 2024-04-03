package is;

import androidx.lifecycle.Observer;
import com.talabat.homescreen.adapter.model.order_tracking.OrderTrackingItem;
import com.talabat.homescreen.orderstatus.ui.OrderStatusView;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OrderStatusView f62175a;

    public /* synthetic */ f(OrderStatusView orderStatusView) {
        this.f62175a = orderStatusView;
    }

    public final void onChanged(Object obj) {
        OrderStatusView.m10653navigateToOrderConfirmationObserver$lambda3(this.f62175a, (OrderTrackingItem) obj);
    }
}
