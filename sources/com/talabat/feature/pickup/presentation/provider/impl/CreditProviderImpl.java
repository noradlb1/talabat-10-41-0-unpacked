package com.talabat.feature.pickup.presentation.provider.impl;

import buisnessmodels.Customer;
import com.talabat.feature.pickup.presentation.provider.CreditProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/pickup/presentation/provider/impl/CreditProviderImpl;", "Lcom/talabat/feature/pickup/presentation/provider/CreditProvider;", "customer", "Lbuisnessmodels/Customer;", "(Lbuisnessmodels/Customer;)V", "get", "", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CreditProviderImpl implements CreditProvider {
    @NotNull
    private final Customer customer;

    @Inject
    public CreditProviderImpl(@NotNull Customer customer2) {
        Intrinsics.checkNotNullParameter(customer2, "customer");
        this.customer = customer2;
    }

    public float get() {
        return this.customer.getTalabatCreditBalance();
    }
}
