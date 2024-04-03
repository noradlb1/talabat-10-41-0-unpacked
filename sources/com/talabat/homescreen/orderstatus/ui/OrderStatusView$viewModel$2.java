package com.talabat.homescreen.orderstatus.ui;

import android.content.Context;
import com.talabat.homescreen.orderstatus.di.OrderStatusViewModelFactory;
import com.talabat.homescreen.orderstatus.presentation.viewmodel.OrderStatusViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/homescreen/orderstatus/presentation/viewmodel/OrderStatusViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusView$viewModel$2 extends Lambda implements Function0<OrderStatusViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f60974g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ OrderStatusView f60975h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderStatusView$viewModel$2(Context context, OrderStatusView orderStatusView) {
        super(0);
        this.f60974g = context;
        this.f60975h = orderStatusView;
    }

    @NotNull
    public final OrderStatusViewModel invoke() {
        return OrderStatusViewModelFactory.INSTANCE.create(this.f60974g, this.f60975h.getObservabilityManager());
    }
}
