package com.talabat.splash.core.di;

import com.talabat.messaging.MessagingServiceType;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.gms.base.domain.IsGmsAvailable", "com.talabat.core.hms.base.domain.IsHmsAvailable"})
public final class MessagingModule_MessagingServiceTypeFactory implements Factory<MessagingServiceType> {
    private final Provider<Boolean> isGmsAvailableProvider;
    private final Provider<Boolean> isHmsAvailableProvider;
    private final MessagingModule module;

    public MessagingModule_MessagingServiceTypeFactory(MessagingModule messagingModule, Provider<Boolean> provider, Provider<Boolean> provider2) {
        this.module = messagingModule;
        this.isGmsAvailableProvider = provider;
        this.isHmsAvailableProvider = provider2;
    }

    public static MessagingModule_MessagingServiceTypeFactory create(MessagingModule messagingModule, Provider<Boolean> provider, Provider<Boolean> provider2) {
        return new MessagingModule_MessagingServiceTypeFactory(messagingModule, provider, provider2);
    }

    public static MessagingServiceType messagingServiceType(MessagingModule messagingModule, boolean z11, boolean z12) {
        return (MessagingServiceType) Preconditions.checkNotNullFromProvides(messagingModule.messagingServiceType(z11, z12));
    }

    public MessagingServiceType get() {
        return messagingServiceType(this.module, this.isGmsAvailableProvider.get().booleanValue(), this.isHmsAvailableProvider.get().booleanValue());
    }
}
