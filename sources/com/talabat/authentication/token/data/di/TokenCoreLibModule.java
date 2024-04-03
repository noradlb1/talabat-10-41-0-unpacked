package com.talabat.authentication.token.data.di;

import com.talabat.authentication.token.data.flutter.TokenFlutterMapper;
import com.talabat.authentication.token.data.flutter.impl.TokenFlutterMapperImpl;
import com.talabat.authentication.token.data.impl.TokenRepositoryImpl;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/talabat/authentication/token/data/di/TokenCoreLibModule;", "", "tokenFlutterMapper", "Lcom/talabat/authentication/token/data/flutter/TokenFlutterMapper;", "impl", "Lcom/talabat/authentication/token/data/flutter/impl/TokenFlutterMapperImpl;", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "Lcom/talabat/authentication/token/data/impl/TokenRepositoryImpl;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {TokenLocalModule.class, TokenRemoteModule.class})
public interface TokenCoreLibModule {
    @NotNull
    @Binds
    @Reusable
    TokenFlutterMapper tokenFlutterMapper(@NotNull TokenFlutterMapperImpl tokenFlutterMapperImpl);

    @NotNull
    @Binds
    @Reusable
    TokenRepository tokenRepository(@NotNull TokenRepositoryImpl tokenRepositoryImpl);
}
