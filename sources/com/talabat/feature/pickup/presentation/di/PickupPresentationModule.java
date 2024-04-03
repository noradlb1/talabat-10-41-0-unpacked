package com.talabat.feature.pickup.presentation.di;

import buisnessmodels.Customer;
import com.talabat.feature.pickup.presentation.provider.CreditProvider;
import com.talabat.feature.pickup.presentation.provider.impl.CreditProviderImpl;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/feature/pickup/presentation/di/PickupPresentationModule;", "", "()V", "provideCreditBalance", "Lcom/talabat/feature/pickup/presentation/provider/CreditProvider;", "provideCustomer", "Lbuisnessmodels/Customer;", "provideRemoteConfig", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class PickupPresentationModule {
    @NotNull
    public static final PickupPresentationModule INSTANCE = new PickupPresentationModule();

    private PickupPresentationModule() {
    }

    @NotNull
    @Provides
    public final CreditProvider provideCreditBalance() {
        return new CreditProviderImpl(provideCustomer());
    }

    @NotNull
    @Provides
    public final Customer provideCustomer() {
        Customer instance = Customer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    @NotNull
    @Provides
    public final RemoteConfiguration provideRemoteConfig() {
        return RemoteConfiguration.INSTANCE;
    }
}
