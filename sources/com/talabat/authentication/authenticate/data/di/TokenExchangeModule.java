package com.talabat.authentication.authenticate.data.di;

import com.talabat.authentication.authenticate.data.repository.TokenExchangeRetriesRepositoryImpl;
import com.talabat.authentication.authenticate.data.usecase.TokenExchangeAllowedImpl;
import com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository;
import com.talabat.authentication.authenticate.domain.usecase.TokenExchangeAllowed;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/talabat/authentication/authenticate/data/di/TokenExchangeModule;", "", "tokenExchangeAllowedUseCase", "Lcom/talabat/authentication/authenticate/domain/usecase/TokenExchangeAllowed;", "real", "Lcom/talabat/authentication/authenticate/data/usecase/TokenExchangeAllowedImpl;", "tokenExchangeRetriesRepository", "Lcom/talabat/authentication/authenticate/domain/repository/TokenExchangeRetriesRepository;", "Lcom/talabat/authentication/authenticate/data/repository/TokenExchangeRetriesRepositoryImpl;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface TokenExchangeModule {
    @NotNull
    @Binds
    @Reusable
    TokenExchangeAllowed tokenExchangeAllowedUseCase(@NotNull TokenExchangeAllowedImpl tokenExchangeAllowedImpl);

    @NotNull
    @Binds
    @Reusable
    TokenExchangeRetriesRepository tokenExchangeRetriesRepository(@NotNull TokenExchangeRetriesRepositoryImpl tokenExchangeRetriesRepositoryImpl);
}
