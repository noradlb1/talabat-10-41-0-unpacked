package com.opsquad.features.orderDetails.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/opsquad/features/orderDetails/network/OrderEndpoint;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderServices$orderDetailsApi$2 extends Lambda implements Function0<OrderEndpoint> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatAPIBuilder f52865g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderServices$orderDetailsApi$2(TalabatAPIBuilder talabatAPIBuilder) {
        super(0);
        this.f52865g = talabatAPIBuilder;
    }

    @NotNull
    public final OrderEndpoint invoke() {
        return (OrderEndpoint) this.f52865g.createApi(OrderEndpoint.class);
    }
}
