package com.talabat.core.social.login.domain;

import com.talabat.core.di.Api;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/social/login/domain/SocialLoginCoreLibApi;", "Lcom/talabat/core/di/Api;", "facebookLoginUseCase", "Lcom/talabat/core/social/login/domain/FacebookLoginUseCase;", "getFacebookLoginUseCase", "()Lcom/talabat/core/social/login/domain/FacebookLoginUseCase;", "googleLoginUseCase", "Lcom/talabat/core/social/login/domain/GoogleLoginUseCase;", "getGoogleLoginUseCase", "()Lcom/talabat/core/social/login/domain/GoogleLoginUseCase;", "initializeFacebookLoginUseCase", "Lcom/talabat/core/social/login/domain/InitializeFacebookLoginUseCase;", "getInitializeFacebookLoginUseCase", "()Lcom/talabat/core/social/login/domain/InitializeFacebookLoginUseCase;", "initializeGoogleLoginUseCase", "Lcom/talabat/core/social/login/domain/InitializeGoogleLoginUseCase;", "getInitializeGoogleLoginUseCase", "()Lcom/talabat/core/social/login/domain/InitializeGoogleLoginUseCase;", "com_talabat_core_social-login_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SocialLoginCoreLibApi extends Api {
    @NotNull
    FacebookLoginUseCase getFacebookLoginUseCase();

    @NotNull
    GoogleLoginUseCase getGoogleLoginUseCase();

    @NotNull
    InitializeFacebookLoginUseCase getInitializeFacebookLoginUseCase();

    @NotNull
    InitializeGoogleLoginUseCase getInitializeGoogleLoginUseCase();
}
