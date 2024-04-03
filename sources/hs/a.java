package hs;

import com.talabat.homescreen.orderstatus.presentation.viewmodel.OrderStatusViewModel;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderStatusViewModel f62130b;

    public /* synthetic */ a(OrderStatusViewModel orderStatusViewModel) {
        this.f62130b = orderStatusViewModel;
    }

    public final void accept(Object obj) {
        this.f62130b.trackOrderStatusObserveError((Throwable) obj);
    }
}
