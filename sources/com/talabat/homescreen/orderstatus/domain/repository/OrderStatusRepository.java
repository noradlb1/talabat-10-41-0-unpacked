package com.talabat.homescreen.orderstatus.domain.repository;

import com.talabat.homescreen.orderstatus.domain.entity.OrderStatusEntity;
import io.reactivex.Flowable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/homescreen/orderstatus/domain/repository/OrderStatusRepository;", "", "observeOrderStatuses", "Lio/reactivex/Flowable;", "", "Lcom/talabat/homescreen/orderstatus/domain/entity/OrderStatusEntity;", "orderIds", "", "refreshPeriod", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OrderStatusRepository {
    @NotNull
    Flowable<List<OrderStatusEntity>> observeOrderStatuses(@NotNull List<String> list, long j11, @NotNull TimeUnit timeUnit);
}
