package ue;

import android.view.View;
import com.talabat.OrderListScreen;
import datamodels.OrderInfoPaging;

public final /* synthetic */ class kb implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderListScreen.OrderListAdapter f57611b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderInfoPaging f57612c;

    public /* synthetic */ kb(OrderListScreen.OrderListAdapter orderListAdapter, OrderInfoPaging orderInfoPaging) {
        this.f57611b = orderListAdapter;
        this.f57612c = orderInfoPaging;
    }

    public final void onClick(View view) {
        this.f57611b.lambda$onBindViewHolder$0(this.f57612c, view);
    }
}
