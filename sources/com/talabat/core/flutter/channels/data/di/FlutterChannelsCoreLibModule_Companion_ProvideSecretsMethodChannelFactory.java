package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.flutter.secrets.domain.handler.SecretsMethodCallHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideSecretsMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<SecretsMethodCallHandler> secretsChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideSecretsMethodChannelFactory(Provider<SecretsMethodCallHandler> provider) {
        this.secretsChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideSecretsMethodChannelFactory create(Provider<SecretsMethodCallHandler> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideSecretsMethodChannelFactory(provider);
    }

    public static PlatformChannel provideSecretsMethodChannel(SecretsMethodCallHandler secretsMethodCallHandler) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideSecretsMethodChannel(secretsMethodCallHandler));
    }

    public PlatformChannel get() {
        return provideSecretsMethodChannel(this.secretsChannelCallbackProvider.get());
    }
}
