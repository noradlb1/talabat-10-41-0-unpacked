package com.talabat.homescreen.orderstatus.domain.usecase.business.impl;

import com.talabat.helpers.AppUrls;
import com.talabat.homescreen.orderstatus.domain.entity.OrderEntity;
import com.talabat.homescreen.orderstatus.domain.entity.OrderStatusEntity;
import com.talabat.homescreen.orderstatus.domain.repository.OrderStatusRepository;
import com.talabat.homescreen.orderstatus.domain.usecase.business.ObserveOrderStatusesUseCase;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/homescreen/orderstatus/domain/usecase/business/impl/ObserveOrderStatusesUseCaseImpl;", "Lcom/talabat/homescreen/orderstatus/domain/usecase/business/ObserveOrderStatusesUseCase;", "orderStatusRepository", "Lcom/talabat/homescreen/orderstatus/domain/repository/OrderStatusRepository;", "(Lcom/talabat/homescreen/orderstatus/domain/repository/OrderStatusRepository;)V", "observeOrderStatuses", "Lio/reactivex/Flowable;", "", "Lcom/talabat/homescreen/orderstatus/domain/entity/OrderStatusEntity;", "orders", "Lcom/talabat/homescreen/orderstatus/domain/entity/OrderEntity;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObserveOrderStatusesUseCaseImpl implements ObserveOrderStatusesUseCase {
    @NotNull
    private final OrderStatusRepository orderStatusRepository;

    public ObserveOrderStatusesUseCaseImpl(@NotNull OrderStatusRepository orderStatusRepository2) {
        Intrinsics.checkNotNullParameter(orderStatusRepository2, "orderStatusRepository");
        this.orderStatusRepository = orderStatusRepository2;
    }

    @NotNull
    public Flowable<List<OrderStatusEntity>> observeOrderStatuses(@NotNull List<OrderEntity> list) {
        Intrinsics.checkNotNullParameter(list, AppUrls.PLACEORDER_SEGMENT);
        ArrayList<OrderEntity> arrayList = new ArrayList<>();
        for (Object next : list) {
            if (!((OrderEntity) next).isPickup()) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (OrderEntity encryptedOrderId : arrayList) {
            arrayList2.add(encryptedOrderId.getEncryptedOrderId());
        }
        if (!arrayList2.isEmpty()) {
            return this.orderStatusRepository.observeOrderStatuses(arrayList2, 45, TimeUnit.SECONDS);
        }
        Flowable<List<OrderStatusEntity>> empty = Flowable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "empty()");
        return empty;
    }
}
