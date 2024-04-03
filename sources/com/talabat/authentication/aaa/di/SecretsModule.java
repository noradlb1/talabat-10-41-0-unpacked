package com.talabat.authentication.aaa.di;

import com.talabat.secrets.Secrets;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/talabat/authentication/aaa/di/SecretsModule;", "", "()V", "secrets", "Lcom/talabat/secrets/Secrets;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class SecretsModule {
    @NotNull
    public static final SecretsModule INSTANCE = new SecretsModule();

    private SecretsModule() {
    }

    @NotNull
    @Provides
    public final Secrets secrets() {
        return new Secrets();
    }
}
