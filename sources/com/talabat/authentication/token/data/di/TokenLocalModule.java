package com.talabat.authentication.token.data.di;

import com.talabat.authentication.token.data.local.EncryptedStorageProvider;
import com.talabat.authentication.token.data.local.LegacyTokenLocalDataSource;
import com.talabat.authentication.token.data.local.TokenLocalDataSource;
import com.talabat.authentication.token.data.local.impl.EncryptedStorageProviderImpl;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.authentication.token.data.local.impl.TokenLocalDataSourceImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'¨\u0006\f"}, d2 = {"Lcom/talabat/authentication/token/data/di/TokenLocalModule;", "", "encryptedStorageProvider", "Lcom/talabat/authentication/token/data/local/EncryptedStorageProvider;", "impl", "Lcom/talabat/authentication/token/data/local/impl/EncryptedStorageProviderImpl;", "legacyTokenLocalDataSource", "Lcom/talabat/authentication/token/data/local/LegacyTokenLocalDataSource;", "Lcom/talabat/authentication/token/data/local/impl/LegacyTokenLocalDataSourceImpl;", "tokenLocalDataSource", "Lcom/talabat/authentication/token/data/local/TokenLocalDataSource;", "Lcom/talabat/authentication/token/data/local/impl/TokenLocalDataSourceImpl;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface TokenLocalModule {
    @NotNull
    @Binds
    EncryptedStorageProvider encryptedStorageProvider(@NotNull EncryptedStorageProviderImpl encryptedStorageProviderImpl);

    @NotNull
    @Binds
    LegacyTokenLocalDataSource legacyTokenLocalDataSource(@NotNull LegacyTokenLocalDataSourceImpl legacyTokenLocalDataSourceImpl);

    @NotNull
    @Binds
    @Reusable
    TokenLocalDataSource tokenLocalDataSource(@NotNull TokenLocalDataSourceImpl tokenLocalDataSourceImpl);
}
