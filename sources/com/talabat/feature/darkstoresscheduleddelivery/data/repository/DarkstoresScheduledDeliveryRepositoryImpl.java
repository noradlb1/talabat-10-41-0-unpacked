package com.talabat.feature.darkstoresscheduleddelivery.data.repository;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstoresscheduleddelivery.data.mapper.DeliveryDateResponseMapper;
import com.talabat.feature.darkstoresscheduleddelivery.data.model.DeliveryDateResponse;
import com.talabat.feature.darkstoresscheduleddelivery.data.remote.DarkstoresScheduledDeliveryApi;
import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliveryDate;
import com.talabat.feature.darkstoresscheduleddelivery.domain.repository.DarkstoresScheduledDeliveryRepository;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/data/repository/DarkstoresScheduledDeliveryRepositoryImpl;", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/repository/DarkstoresScheduledDeliveryRepository;", "api", "Lcom/talabat/feature/darkstoresscheduleddelivery/data/remote/DarkstoresScheduledDeliveryApi;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "deliveryDateResponseMapper", "Lcom/talabat/feature/darkstoresscheduleddelivery/data/mapper/DeliveryDateResponseMapper;", "(Lcom/talabat/feature/darkstoresscheduleddelivery/data/remote/DarkstoresScheduledDeliveryApi;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;Lcom/talabat/feature/darkstoresscheduleddelivery/data/mapper/DeliveryDateResponseMapper;)V", "getDeliverySlots", "Lio/reactivex/Single;", "", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliveryDate;", "vendorId", "", "com_talabat_feature_darkstores-scheduled-delivery_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresScheduledDeliveryRepositoryImpl implements DarkstoresScheduledDeliveryRepository {
    @NotNull
    private final DarkstoresScheduledDeliveryApi api;
    @NotNull
    private final DeliveryDateResponseMapper deliveryDateResponseMapper;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;

    @Inject
    public DarkstoresScheduledDeliveryRepositoryImpl(@NotNull DarkstoresScheduledDeliveryApi darkstoresScheduledDeliveryApi, @NotNull RxSchedulersFactory rxSchedulersFactory2, @NotNull DeliveryDateResponseMapper deliveryDateResponseMapper2) {
        Intrinsics.checkNotNullParameter(darkstoresScheduledDeliveryApi, "api");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        Intrinsics.checkNotNullParameter(deliveryDateResponseMapper2, "deliveryDateResponseMapper");
        this.api = darkstoresScheduledDeliveryApi;
        this.rxSchedulersFactory = rxSchedulersFactory2;
        this.deliveryDateResponseMapper = deliveryDateResponseMapper2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getDeliverySlots$lambda-0  reason: not valid java name */
    public static final List m10208getDeliverySlots$lambda0(DarkstoresScheduledDeliveryRepositoryImpl darkstoresScheduledDeliveryRepositoryImpl, List list) {
        Intrinsics.checkNotNullParameter(darkstoresScheduledDeliveryRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(list, "dates");
        Iterable<DeliveryDateResponse> iterable = list;
        DeliveryDateResponseMapper deliveryDateResponseMapper2 = darkstoresScheduledDeliveryRepositoryImpl.deliveryDateResponseMapper;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (DeliveryDateResponse apply : iterable) {
            arrayList.add(deliveryDateResponseMapper2.apply(apply));
        }
        return arrayList;
    }

    @NotNull
    public Single<List<DeliveryDate>> getDeliverySlots(int i11) {
        Single<R> map = this.api.getDeliverySlots(i11).subscribeOn(this.rxSchedulersFactory.io()).map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "api.getDeliverySlots(ven…per::apply)\n            }");
        return map;
    }
}
