package is;

import androidx.lifecycle.Observer;
import com.talabat.homescreen.orderstatus.ui.OrderStatusView;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OrderStatusView f62172a;

    public /* synthetic */ d(OrderStatusView orderStatusView) {
        this.f62172a = orderStatusView;
    }

    public final void onChanged(Object obj) {
        OrderStatusView.m10654onAttach$lambda5(this.f62172a, (String) obj);
    }
}
