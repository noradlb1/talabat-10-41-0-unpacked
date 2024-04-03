package com.talabat.authentication.authenticate.data.di;

import com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl;
import com.talabat.authentication.authenticate.data.usecase.UserLoggedInImpl;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository;
import com.talabat.authentication.authenticate.domain.usecase.UserLoggedIn;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u000b"}, d2 = {"Lcom/talabat/authentication/authenticate/data/di/AuthenticationCoreLibModule;", "", "authenticationRepository", "Lcom/talabat/authentication/authenticate/domain/repository/AuthenticationRepository;", "impl", "Lcom/talabat/authentication/authenticate/data/impl/AuthenticationRepositoryImpl;", "isLoggedInUseCase", "Lcom/talabat/authentication/authenticate/domain/usecase/UserLoggedIn;", "Lcom/talabat/authentication/authenticate/data/usecase/UserLoggedInImpl;", "socialAuthenticationRepository", "Lcom/talabat/authentication/authenticate/domain/repository/SocialAuthenticationRepository;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {AuthenticationRemoteModule.class})
public interface AuthenticationCoreLibModule {
    @NotNull
    @Binds
    @Reusable
    AuthenticationRepository authenticationRepository(@NotNull AuthenticationRepositoryImpl authenticationRepositoryImpl);

    @NotNull
    @Binds
    @Reusable
    UserLoggedIn isLoggedInUseCase(@NotNull UserLoggedInImpl userLoggedInImpl);

    @NotNull
    @Binds
    @Reusable
    SocialAuthenticationRepository socialAuthenticationRepository(@NotNull AuthenticationRepositoryImpl authenticationRepositoryImpl);
}
