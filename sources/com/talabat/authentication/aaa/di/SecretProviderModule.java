package com.talabat.authentication.aaa.di;

import com.talabat.authentication.aaa.EndpointProvider;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.aaa.secrets.impl.SecretProviderImpl;
import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.secrets.Secrets;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/authentication/aaa/di/SecretProviderModule;", "", "()V", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "secrets", "Lcom/talabat/secrets/Secrets;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {SecretsModule.class})
public final class SecretProviderModule {
    @NotNull
    public static final SecretProviderModule INSTANCE = new SecretProviderModule();

    private SecretProviderModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final SecretProvider secretProvider(@NotNull Secrets secrets) {
        Intrinsics.checkNotNullParameter(secrets, "secrets");
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        return new SecretProviderImpl(secrets, new EndpointProvider(talabatEnvironment.getEnvironment(), "release"), "release", talabatEnvironment.getEnvironment());
    }
}
