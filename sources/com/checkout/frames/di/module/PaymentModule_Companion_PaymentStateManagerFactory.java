package com.checkout.frames.di.module;

import com.checkout.base.model.CardScheme;
import com.checkout.frames.screen.manager.PaymentStateManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class PaymentModule_Companion_PaymentStateManagerFactory implements Factory<PaymentStateManager> {
    private final Provider<List<? extends CardScheme>> supportedCardSchemesProvider;

    public PaymentModule_Companion_PaymentStateManagerFactory(Provider<List<? extends CardScheme>> provider) {
        this.supportedCardSchemesProvider = provider;
    }

    public static PaymentModule_Companion_PaymentStateManagerFactory create(Provider<List<? extends CardScheme>> provider) {
        return new PaymentModule_Companion_PaymentStateManagerFactory(provider);
    }

    public static PaymentStateManager paymentStateManager(List<? extends CardScheme> list) {
        return (PaymentStateManager) Preconditions.checkNotNullFromProvides(PaymentModule.Companion.paymentStateManager(list));
    }

    public PaymentStateManager get() {
        return paymentStateManager(this.supportedCardSchemesProvider.get());
    }
}
