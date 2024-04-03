package com.talabat.homescreen.orderstatus.di;

import buisnessmodels.Customer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lbuisnessmodels/Customer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusViewModelFactory$create$1 extends Lambda implements Function0<Customer> {
    public static final OrderStatusViewModelFactory$create$1 INSTANCE = new OrderStatusViewModelFactory$create$1();

    public OrderStatusViewModelFactory$create$1() {
        super(0);
    }

    @NotNull
    public final Customer invoke() {
        Customer instance = Customer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }
}
