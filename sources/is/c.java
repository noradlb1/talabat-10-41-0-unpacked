package is;

import android.view.View;
import com.talabat.homescreen.orderstatus.presentation.displaymodel.OrderStatus;
import com.talabat.homescreen.orderstatus.ui.OrderStatusRecyclerViewAdaptor;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderStatusRecyclerViewAdaptor f62170b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderStatus f62171c;

    public /* synthetic */ c(OrderStatusRecyclerViewAdaptor orderStatusRecyclerViewAdaptor, OrderStatus orderStatus) {
        this.f62170b = orderStatusRecyclerViewAdaptor;
        this.f62171c = orderStatus;
    }

    public final void onClick(View view) {
        OrderStatusRecyclerViewAdaptor.m10652onBindViewHolder$lambda1$lambda0(this.f62170b, this.f62171c, view);
    }
}
