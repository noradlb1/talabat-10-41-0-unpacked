package com.talabat.core.pinless.checkout.data;

import com.talabat.core.pinless.checkout.domain.PinlessCheckoutFeatureRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H!¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/core/pinless/checkout/data/PinlessCheckoutDataModule;", "", "()V", "providePinlessCheckoutFeatureRepository", "Lcom/talabat/core/pinless/checkout/domain/PinlessCheckoutFeatureRepository;", "impl", "Lcom/talabat/core/pinless/checkout/data/PinlessCheckoutRepository;", "providePinlessCheckoutFeatureRepository$com_talabat_core_pinless_checkout_data_data", "com_talabat_core_pinless-checkout_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public abstract class PinlessCheckoutDataModule {
    @NotNull
    @Binds
    @Reusable
    public abstract PinlessCheckoutFeatureRepository providePinlessCheckoutFeatureRepository$com_talabat_core_pinless_checkout_data_data(@NotNull PinlessCheckoutRepository pinlessCheckoutRepository);
}
