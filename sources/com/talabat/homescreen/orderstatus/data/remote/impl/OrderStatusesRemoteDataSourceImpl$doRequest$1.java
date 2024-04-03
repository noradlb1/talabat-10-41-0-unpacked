package com.talabat.homescreen.orderstatus.data.remote.impl;

import com.talabat.homescreen.network.model.order.OrderStatusRefreshItemResponse;
import com.talabat.homescreen.network.model.order.OrderStatusRefreshResponse;
import com.talabat.homescreen.orderstatus.data.model.OrderStatusData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/talabat/homescreen/orderstatus/data/model/OrderStatusData;", "response", "Lcom/talabat/homescreen/network/model/order/OrderStatusRefreshResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusesRemoteDataSourceImpl$doRequest$1 extends Lambda implements Function1<OrderStatusRefreshResponse, List<? extends OrderStatusData>> {
    public static final OrderStatusesRemoteDataSourceImpl$doRequest$1 INSTANCE = new OrderStatusesRemoteDataSourceImpl$doRequest$1();

    public OrderStatusesRemoteDataSourceImpl$doRequest$1() {
        super(1);
    }

    @NotNull
    public final List<OrderStatusData> invoke(@NotNull OrderStatusRefreshResponse orderStatusRefreshResponse) {
        Intrinsics.checkNotNullParameter(orderStatusRefreshResponse, "response");
        Iterable<OrderStatusRefreshItemResponse> orderStatusRefreshResponseArray = orderStatusRefreshResponse.getResult().getOrderStatusRefreshResponseArray();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(orderStatusRefreshResponseArray, 10));
        for (OrderStatusRefreshItemResponse orderStatusRefreshItemResponse : orderStatusRefreshResponseArray) {
            arrayList.add(new OrderStatusData(orderStatusRefreshItemResponse.getId(), orderStatusRefreshItemResponse.getNewOrderStatus(), orderStatusRefreshItemResponse.isSuccessful()));
        }
        return arrayList;
    }
}
