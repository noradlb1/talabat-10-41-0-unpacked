package com.talabat.fluid.homescreen.ui.widget.orderstatus;

import com.deliveryhero.fluid.expression.literal.Literal;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.talabat.homescreen.orderstatus.ui.OrderStatusView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusModel;", "it", "Lcom/talabat/homescreen/orderstatus/ui/OrderStatusView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusWidgetFactory$defaultFactory$1 extends Lambda implements Function1<OrderStatusView, OrderStatusModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OrderStatusWidgetFactory f59753g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderStatusWidgetFactory$defaultFactory$1(OrderStatusWidgetFactory orderStatusWidgetFactory) {
        super(1);
        this.f59753g = orderStatusWidgetFactory;
    }

    @NotNull
    public final OrderStatusModel invoke(@NotNull OrderStatusView orderStatusView) {
        Intrinsics.checkNotNullParameter(orderStatusView, "it");
        LogicalPixel.Companion companion = LogicalPixel.Companion;
        return new OrderStatusModel(new Literal(companion.getZERO()), new Literal(companion.getZERO()), new Literal(companion.getZERO()), new Literal(companion.getZERO()), new Literal(companion.getZERO()), this.f59753g.a(orderStatusView));
    }
}
