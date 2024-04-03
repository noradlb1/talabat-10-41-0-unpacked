package com.talabat.homescreen.orderstatus.data.remote.impl;

import com.talabat.homescreen.network.apiweb.ApiWebApi;
import com.talabat.homescreen.network.model.order.OrderStatusRefreshArrayResponse;
import com.talabat.homescreen.network.model.order.OrderStatusRefreshResponse;
import com.talabat.homescreen.network.model.order.OrderStatusRequestModel;
import com.talabat.homescreen.orderstatus.data.model.OrderStatusData;
import com.talabat.homescreen.orderstatus.data.remote.OrderStatusesRemoteDataSource;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import gs.a;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\"\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/homescreen/orderstatus/data/remote/impl/OrderStatusesRemoteDataSourceImpl;", "Lcom/talabat/homescreen/orderstatus/data/remote/OrderStatusesRemoteDataSource;", "apiWebApi", "Lcom/talabat/homescreen/network/apiweb/ApiWebApi;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "(Lcom/talabat/homescreen/network/apiweb/ApiWebApi;Lcom/talabat/talabatcore/platform/NetworkHandler;)V", "doRequest", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "", "Lcom/talabat/homescreen/orderstatus/data/model/OrderStatusData;", "orderStatusRequestModel", "Lcom/talabat/homescreen/network/model/order/OrderStatusRequestModel;", "fetchOrderStatuses", "Lio/reactivex/Single;", "orderIds", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusesRemoteDataSourceImpl implements OrderStatusesRemoteDataSource {
    @NotNull
    private final ApiWebApi apiWebApi;
    @NotNull
    private final NetworkHandler networkHandler;

    public OrderStatusesRemoteDataSourceImpl(@NotNull ApiWebApi apiWebApi2, @NotNull NetworkHandler networkHandler2) {
        Intrinsics.checkNotNullParameter(apiWebApi2, "apiWebApi");
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        this.apiWebApi = apiWebApi2;
        this.networkHandler = networkHandler2;
    }

    private final Either<Failure, List<OrderStatusData>> doRequest(OrderStatusRequestModel orderStatusRequestModel) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.apiWebApi.refreshDashBoardOrders(orderStatusRequestModel), OrderStatusesRemoteDataSourceImpl$doRequest$1.INSTANCE, new OrderStatusRefreshResponse("", new OrderStatusRefreshArrayResponse(CollectionsKt__CollectionsKt.emptyList())));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    /* renamed from: fetchOrderStatuses$lambda-0  reason: not valid java name */
    public static final void m10650fetchOrderStatuses$lambda0(List list, OrderStatusesRemoteDataSourceImpl orderStatusesRemoteDataSourceImpl, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(list, "$orderIds");
        Intrinsics.checkNotNullParameter(orderStatusesRemoteDataSourceImpl, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        orderStatusesRemoteDataSourceImpl.doRequest(new OrderStatusRequestModel(list)).either(new OrderStatusesRemoteDataSourceImpl$fetchOrderStatuses$1$1(singleEmitter), new OrderStatusesRemoteDataSourceImpl$fetchOrderStatuses$1$2(singleEmitter));
    }

    @NotNull
    public Single<List<OrderStatusData>> fetchOrderStatuses(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "orderIds");
        Single<List<OrderStatusData>> create = Single.create(new a(list, this));
        Intrinsics.checkNotNullExpressionValue(create, "create { emitter ->\n    …sed(it) }\n        )\n    }");
        return create;
    }
}
