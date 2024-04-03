package com.opsquad.ui.orderDetail;

import com.opsquad.ui.orderDetail.model.OrderDetailDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class OrderDetailFragment$observatory$1 extends FunctionReferenceImpl implements Function1<OrderDetailDisplayModel, Unit> {
    public OrderDetailFragment$observatory$1(Object obj) {
        super(1, obj, OrderDetailFragment.class, "handleSuccess", "handleSuccess(Lcom/opsquad/ui/orderDetail/model/OrderDetailDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OrderDetailDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable OrderDetailDisplayModel orderDetailDisplayModel) {
        ((OrderDetailFragment) this.receiver).handleSuccess(orderDetailDisplayModel);
    }
}
