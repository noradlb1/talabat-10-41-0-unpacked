package com.talabat.talabatcommon.feature.orderDetail.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.helpers.AppUrls;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/feature/orderDetail/network/OrderDetailRetrofitBuilder;", "", "()V", "getOrderDetailApi", "Lcom/talabat/talabatcommon/feature/orderDetail/network/OrderDetailApi;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailRetrofitBuilder {
    @NotNull
    public static final OrderDetailRetrofitBuilder INSTANCE = new OrderDetailRetrofitBuilder();

    private OrderDetailRetrofitBuilder() {
    }

    @NotNull
    public final OrderDetailApi getOrderDetailApi() {
        TalabatAPIBuilder talabatAPIBuilder = new TalabatAPIBuilder();
        String str = AppUrls.BASEURL;
        Intrinsics.checkNotNullExpressionValue(str, "BASEURL");
        return (OrderDetailApi) talabatAPIBuilder.createApi(str, OrderDetailApi.class);
    }
}
