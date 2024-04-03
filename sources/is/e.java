package is;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.talabat.homescreen.orderstatus.ui.OrderStatusView;
import java.util.List;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OrderStatusView f62173a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f62174b;

    public /* synthetic */ e(OrderStatusView orderStatusView, Context context) {
        this.f62173a = orderStatusView;
        this.f62174b = context;
    }

    public final void onChanged(Object obj) {
        OrderStatusView.m10655orderStatusObserver$lambda1(this.f62173a, this.f62174b, (List) obj);
    }
}
