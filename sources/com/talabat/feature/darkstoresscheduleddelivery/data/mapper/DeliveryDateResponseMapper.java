package com.talabat.feature.darkstoresscheduleddelivery.data.mapper;

import com.talabat.feature.darkstoresscheduleddelivery.data.model.DeliveryDateResponse;
import com.talabat.feature.darkstoresscheduleddelivery.data.model.DeliverySlotResponse;
import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliveryDate;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/data/mapper/DeliveryDateResponseMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstoresscheduleddelivery/data/model/DeliveryDateResponse;", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliveryDate;", "deliverySlotResponseMapper", "Lcom/talabat/feature/darkstoresscheduleddelivery/data/mapper/DeliverySlotResponseMapper;", "(Lcom/talabat/feature/darkstoresscheduleddelivery/data/mapper/DeliverySlotResponseMapper;)V", "apply", "source", "com_talabat_feature_darkstores-scheduled-delivery_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryDateResponseMapper implements ModelMapper<DeliveryDateResponse, DeliveryDate> {
    @NotNull
    private final DeliverySlotResponseMapper deliverySlotResponseMapper;

    @Inject
    public DeliveryDateResponseMapper(@NotNull DeliverySlotResponseMapper deliverySlotResponseMapper2) {
        Intrinsics.checkNotNullParameter(deliverySlotResponseMapper2, "deliverySlotResponseMapper");
        this.deliverySlotResponseMapper = deliverySlotResponseMapper2;
    }

    @NotNull
    public DeliveryDate apply(@NotNull DeliveryDateResponse deliveryDateResponse) {
        List list;
        Intrinsics.checkNotNullParameter(deliveryDateResponse, "source");
        String date = deliveryDateResponse.getDate();
        if (date == null) {
            date = "";
        }
        List<DeliverySlotResponse> slots = deliveryDateResponse.getSlots();
        if (slots != null) {
            Iterable<DeliverySlotResponse> iterable = slots;
            DeliverySlotResponseMapper deliverySlotResponseMapper2 = this.deliverySlotResponseMapper;
            list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (DeliverySlotResponse apply : iterable) {
                list.add(deliverySlotResponseMapper2.apply(apply));
            }
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return new DeliveryDate(date, list);
    }
}
