package com.talabat.authentication.authenticate.domain;

import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository;
import com.talabat.authentication.usecase.RegistrationObservabilityUseCase;
import com.talabat.core.di.Api;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/AuthenticationCoreLibApi;", "Lcom/talabat/core/di/Api;", "authenticationRepository", "Lcom/talabat/authentication/authenticate/domain/repository/AuthenticationRepository;", "getAuthenticationRepository", "()Lcom/talabat/authentication/authenticate/domain/repository/AuthenticationRepository;", "registrationObservabilityUseCase", "Lcom/talabat/authentication/usecase/RegistrationObservabilityUseCase;", "getRegistrationObservabilityUseCase", "()Lcom/talabat/authentication/usecase/RegistrationObservabilityUseCase;", "socialAuthenticationRepository", "Lcom/talabat/authentication/authenticate/domain/repository/SocialAuthenticationRepository;", "getSocialAuthenticationRepository", "()Lcom/talabat/authentication/authenticate/domain/repository/SocialAuthenticationRepository;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AuthenticationCoreLibApi extends Api {
    @NotNull
    AuthenticationRepository getAuthenticationRepository();

    @NotNull
    RegistrationObservabilityUseCase getRegistrationObservabilityUseCase();

    @NotNull
    SocialAuthenticationRepository getSocialAuthenticationRepository();
}
