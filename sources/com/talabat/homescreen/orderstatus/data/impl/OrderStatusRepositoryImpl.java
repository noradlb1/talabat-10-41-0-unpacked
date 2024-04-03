package com.talabat.homescreen.orderstatus.data.impl;

import com.talabat.homescreen.orderstatus.data.model.OrderStatusData;
import com.talabat.homescreen.orderstatus.data.remote.OrderStatusesRemoteDataSource;
import com.talabat.homescreen.orderstatus.domain.entity.OrderStatusEntity;
import com.talabat.homescreen.orderstatus.domain.repository.OrderStatusRepository;
import fs.a;
import fs.b;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.SingleSource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\f\u0010\u0011\u001a\u00020\n*\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t*\b\u0012\u0004\u0012\u00020\u00120\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/homescreen/orderstatus/data/impl/OrderStatusRepositoryImpl;", "Lcom/talabat/homescreen/orderstatus/domain/repository/OrderStatusRepository;", "orderStatusesRemoteDataSource", "Lcom/talabat/homescreen/orderstatus/data/remote/OrderStatusesRemoteDataSource;", "ioScheduler", "Lio/reactivex/Scheduler;", "(Lcom/talabat/homescreen/orderstatus/data/remote/OrderStatusesRemoteDataSource;Lio/reactivex/Scheduler;)V", "observeOrderStatuses", "Lio/reactivex/Flowable;", "", "Lcom/talabat/homescreen/orderstatus/domain/entity/OrderStatusEntity;", "orderIds", "", "refreshPeriod", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "toOrderStatusEntity", "Lcom/talabat/homescreen/orderstatus/data/model/OrderStatusData;", "toOrderStatusEntityList", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusRepositoryImpl implements OrderStatusRepository {
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final OrderStatusesRemoteDataSource orderStatusesRemoteDataSource;

    public OrderStatusRepositoryImpl(@NotNull OrderStatusesRemoteDataSource orderStatusesRemoteDataSource2, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(orderStatusesRemoteDataSource2, "orderStatusesRemoteDataSource");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        this.orderStatusesRemoteDataSource = orderStatusesRemoteDataSource2;
        this.ioScheduler = scheduler;
    }

    /* access modifiers changed from: private */
    /* renamed from: observeOrderStatuses$lambda-1  reason: not valid java name */
    public static final SingleSource m10648observeOrderStatuses$lambda1(OrderStatusRepositoryImpl orderStatusRepositoryImpl, List list, Long l11) {
        Intrinsics.checkNotNullParameter(orderStatusRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(list, "$orderIds");
        Intrinsics.checkNotNullParameter(l11, "it");
        return orderStatusRepositoryImpl.orderStatusesRemoteDataSource.fetchOrderStatuses(list).map(new a(orderStatusRepositoryImpl));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeOrderStatuses$lambda-1$lambda-0  reason: not valid java name */
    public static final List m10649observeOrderStatuses$lambda1$lambda0(OrderStatusRepositoryImpl orderStatusRepositoryImpl, List list) {
        Intrinsics.checkNotNullParameter(orderStatusRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        return orderStatusRepositoryImpl.toOrderStatusEntityList(list);
    }

    private final OrderStatusEntity toOrderStatusEntity(OrderStatusData orderStatusData) {
        int i11;
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(orderStatusData.getOrderId());
        if (intOrNull != null) {
            i11 = intOrNull.intValue();
        } else {
            i11 = -1;
        }
        return new OrderStatusEntity(i11, orderStatusData.getOrderStatus(), orderStatusData.isOrderSuccessful());
    }

    private final List<OrderStatusEntity> toOrderStatusEntityList(List<OrderStatusData> list) {
        Iterable<OrderStatusData> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (OrderStatusData orderStatusEntity : iterable) {
            arrayList.add(toOrderStatusEntity(orderStatusEntity));
        }
        return arrayList;
    }

    @NotNull
    public Flowable<List<OrderStatusEntity>> observeOrderStatuses(@NotNull List<String> list, long j11, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(list, "orderIds");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        Flowable<R> flatMapSingle = Flowable.interval(j11, j11, timeUnit, this.ioScheduler).flatMapSingle(new b(this, list));
        Intrinsics.checkNotNullExpressionValue(flatMapSingle, "interval(refreshPeriod, …sEntityList() }\n        }");
        return flatMapSingle;
    }
}
