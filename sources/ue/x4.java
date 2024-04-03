package ue;

import com.talabat.CheckOutScreen;
import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliverySlotContent;
import com.talabat.fragments.DeliverySlotPickerFragment;

public final /* synthetic */ class x4 implements DeliverySlotPickerFragment.DeliverySlotPickerFragmentListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57823a;

    public /* synthetic */ x4(CheckOutScreen checkOutScreen) {
        this.f57823a = checkOutScreen;
    }

    public final void onDeliverySlotSelected(DeliverySlotContent deliverySlotContent) {
        this.f57823a.lambda$showBottomSheetForDeliveryTiming$54(deliverySlotContent);
    }
}
