package com.talabat.homescreen.network.apiweb;

import com.talabat.homescreen.network.model.order.OrderStatusRefreshResponse;
import com.talabat.homescreen.network.model.order.OrderStatusRequestModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/talabat/homescreen/network/apiweb/ApiWebApi;", "", "refreshDashBoardOrders", "Lretrofit2/Call;", "Lcom/talabat/homescreen/network/model/order/OrderStatusRefreshResponse;", "orderStatusRequestModel", "Lcom/talabat/homescreen/network/model/order/OrderStatusRequestModel;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ApiWebApi {
    @NotNull
    @POST("v1/orders/orderstatus")
    Call<OrderStatusRefreshResponse> refreshDashBoardOrders(@NotNull @Body OrderStatusRequestModel orderStatusRequestModel);
}
