package com.talabat.fluid.homescreen.di.factory;

import buisnessmodels.Customer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lbuisnessmodels/Customer;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$1 extends Lambda implements Function0<Customer> {
    public static final FluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$1 INSTANCE = new FluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$1();

    public FluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$1() {
        super(0);
    }

    public final Customer invoke() {
        return Customer.getInstance();
    }
}
