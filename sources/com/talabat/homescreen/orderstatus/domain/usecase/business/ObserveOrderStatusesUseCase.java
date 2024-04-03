package com.talabat.homescreen.orderstatus.domain.usecase.business;

import com.talabat.homescreen.orderstatus.domain.entity.OrderEntity;
import com.talabat.homescreen.orderstatus.domain.entity.OrderStatusEntity;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H&¨\u0006\b"}, d2 = {"Lcom/talabat/homescreen/orderstatus/domain/usecase/business/ObserveOrderStatusesUseCase;", "", "observeOrderStatuses", "Lio/reactivex/Flowable;", "", "Lcom/talabat/homescreen/orderstatus/domain/entity/OrderStatusEntity;", "orders", "Lcom/talabat/homescreen/orderstatus/domain/entity/OrderEntity;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ObserveOrderStatusesUseCase {
    @NotNull
    Flowable<List<OrderStatusEntity>> observeOrderStatuses(@NotNull List<OrderEntity> list);
}
