package com.talabat.core.flutter.channels.impl.data.tpro;

import buisnessmodels.Customer;
import dagger.Module;
import dagger.Provides;
import datamodels.CustomerInfo;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/tpro/TProDataModule;", "", "()V", "provideTProPlanMOV", "", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class TProDataModule {
    @NotNull
    public static final TProDataModule INSTANCE = new TProDataModule();

    private TProDataModule() {
    }

    @Provides
    @Named("TProPlanMOV")
    public final float provideTProPlanMOV() {
        CustomerInfo customerInfo;
        Customer instance = Customer.getInstance();
        if (instance == null || (customerInfo = instance.getCustomerInfo()) == null) {
            return 0.0f;
        }
        return customerInfo.minimOrderValueToEnableTproDiscount;
    }
}
