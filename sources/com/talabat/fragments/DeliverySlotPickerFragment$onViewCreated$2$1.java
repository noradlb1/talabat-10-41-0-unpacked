package com.talabat.fragments;

import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliverySlotContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "deliverySlot", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlotContent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DeliverySlotPickerFragment$onViewCreated$2$1 extends Lambda implements Function1<DeliverySlotContent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeliverySlotPickerFragment f59799g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeliverySlotPickerFragment$onViewCreated$2$1(DeliverySlotPickerFragment deliverySlotPickerFragment) {
        super(1);
        this.f59799g = deliverySlotPickerFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeliverySlotContent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DeliverySlotContent deliverySlotContent) {
        Intrinsics.checkNotNullParameter(deliverySlotContent, "deliverySlot");
        this.f59799g.selectedDeliverySlot = deliverySlotContent;
        this.f59799g.refreshButtonState();
    }
}
