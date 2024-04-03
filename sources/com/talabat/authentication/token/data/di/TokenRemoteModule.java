package com.talabat.authentication.token.data.di;

import com.talabat.authentication.token.data.remote.LegacyTokenRemoteDataSource;
import com.talabat.authentication.token.data.remote.TokenRemoteDataSource;
import com.talabat.authentication.token.data.remote.TokenResponseMapper;
import com.talabat.authentication.token.data.remote.impl.LegacyTokenRemoteDataSourceImpl;
import com.talabat.authentication.token.data.remote.impl.TokenRemoteDataSourceImpl;
import com.talabat.authentication.token.data.remote.impl.TokenResponseMapperImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'¨\u0006\f"}, d2 = {"Lcom/talabat/authentication/token/data/di/TokenRemoteModule;", "", "legacyTokenRemoteDataSource", "Lcom/talabat/authentication/token/data/remote/LegacyTokenRemoteDataSource;", "impl", "Lcom/talabat/authentication/token/data/remote/impl/LegacyTokenRemoteDataSourceImpl;", "tokenRemoteDataSource", "Lcom/talabat/authentication/token/data/remote/TokenRemoteDataSource;", "Lcom/talabat/authentication/token/data/remote/impl/TokenRemoteDataSourceImpl;", "tokenResponseMapper", "Lcom/talabat/authentication/token/data/remote/TokenResponseMapper;", "Lcom/talabat/authentication/token/data/remote/impl/TokenResponseMapperImpl;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {SwapTokenApiModule.class})
public interface TokenRemoteModule {
    @NotNull
    @Binds
    LegacyTokenRemoteDataSource legacyTokenRemoteDataSource(@NotNull LegacyTokenRemoteDataSourceImpl legacyTokenRemoteDataSourceImpl);

    @NotNull
    @Binds
    TokenRemoteDataSource tokenRemoteDataSource(@NotNull TokenRemoteDataSourceImpl tokenRemoteDataSourceImpl);

    @NotNull
    @Binds
    TokenResponseMapper tokenResponseMapper(@NotNull TokenResponseMapperImpl tokenResponseMapperImpl);
}
