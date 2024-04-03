package hs;

import com.talabat.homescreen.orderstatus.presentation.viewmodel.OrderStatusViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderStatusViewModel f62131b;

    public /* synthetic */ b(OrderStatusViewModel orderStatusViewModel) {
        this.f62131b = orderStatusViewModel;
    }

    public final void accept(Object obj) {
        this.f62131b.handleOrderStatusRefresh((List) obj);
    }
}
