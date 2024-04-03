package com.talabat.userandlocation.choosecountry.di.module;

import buisnessmodels.Customer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DomainModule$provideOnUserChooseCountryUseCase$7 extends Lambda implements Function0<Unit> {
    public static final DomainModule$provideOnUserChooseCountryUseCase$7 INSTANCE = new DomainModule$provideOnUserChooseCountryUseCase$7();

    public DomainModule$provideOnUserChooseCountryUseCase$7() {
        super(0);
    }

    public final void invoke() {
        Customer.getInstance().resetBrandLocalAddress();
    }
}
