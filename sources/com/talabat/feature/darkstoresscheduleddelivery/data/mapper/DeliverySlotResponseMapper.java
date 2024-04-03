package com.talabat.feature.darkstoresscheduleddelivery.data.mapper;

import com.talabat.feature.darkstoresscheduleddelivery.data.model.DeliverySlotResponse;
import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliverySlot;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/data/mapper/DeliverySlotResponseMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstoresscheduleddelivery/data/model/DeliverySlotResponse;", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlot;", "()V", "apply", "source", "com_talabat_feature_darkstores-scheduled-delivery_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliverySlotResponseMapper implements ModelMapper<DeliverySlotResponse, DeliverySlot> {
    @NotNull
    public DeliverySlot apply(@NotNull DeliverySlotResponse deliverySlotResponse) {
        Intrinsics.checkNotNullParameter(deliverySlotResponse, "source");
        String from = deliverySlotResponse.getFrom();
        String str = "";
        if (from == null) {
            from = str;
        }
        String to2 = deliverySlotResponse.getTo();
        if (to2 != null) {
            str = to2;
        }
        return new DeliverySlot(from, str);
    }
}
