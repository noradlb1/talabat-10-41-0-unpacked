package com.talabat.core.social.login.data.di;

import com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository;
import com.talabat.core.facebook.login.domain.integration.FacebookLoginActivityIntegration;
import com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository;
import com.talabat.core.google.login.domain.repository.GoogleLoginRepository;
import com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository;
import com.talabat.core.social.login.domain.AaaAuthenticationForSocialLoginRepository;
import com.talabat.core.social.login.domain.FacebookLoginUseCase;
import com.talabat.core.social.login.domain.GoogleLoginUseCase;
import com.talabat.core.social.login.domain.InitializeFacebookLoginUseCase;
import com.talabat.core.social.login.domain.InitializeGoogleLoginUseCase;
import com.talabat.core.social.login.domain.di.SocialLoginDomainModule;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import javax.inject.Provider;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J@\u0010\u0011\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013H\u0007¨\u0006\u001a"}, d2 = {"Lcom/talabat/core/social/login/data/di/SocialLoginCoreLibModule;", "", "()V", "facebookLoginUseCase", "Lcom/talabat/core/social/login/domain/FacebookLoginUseCase;", "socialLoginDomainModule", "Lcom/talabat/core/social/login/domain/di/SocialLoginDomainModule;", "googleLoginUseCase", "Lcom/talabat/core/social/login/domain/GoogleLoginUseCase;", "initializeFacebookLoginUseCase", "Lcom/talabat/core/social/login/domain/InitializeFacebookLoginUseCase;", "initializeGoogleLoginUseCase", "Lcom/talabat/core/social/login/domain/InitializeGoogleLoginUseCase;", "provideAaaAuthenticatorForSocialLogin", "Lcom/talabat/core/social/login/domain/AaaAuthenticationForSocialLoginRepository;", "authenticationRepository", "Lcom/talabat/authentication/authenticate/domain/repository/SocialAuthenticationRepository;", "provideSocialLoginDomainModule", "googleLoginRepositoryProvider", "Ljavax/inject/Provider;", "Lcom/talabat/core/google/login/domain/repository/GoogleLoginRepository;", "facebookLoginRepositoryProvider", "Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository;", "aaaAuthenticationRepositoryProvider", "facebookLoginActivityIntegration", "Lcom/talabat/core/facebook/login/domain/integration/FacebookLoginActivityIntegration;", "com_talabat_core_social-login_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class SocialLoginCoreLibModule {
    @NotNull
    @Reusable
    @Provides
    public final FacebookLoginUseCase facebookLoginUseCase(@NotNull SocialLoginDomainModule socialLoginDomainModule) {
        Intrinsics.checkNotNullParameter(socialLoginDomainModule, "socialLoginDomainModule");
        return socialLoginDomainModule.getFacebookLoginUseCase();
    }

    @NotNull
    @Reusable
    @Provides
    public final GoogleLoginUseCase googleLoginUseCase(@NotNull SocialLoginDomainModule socialLoginDomainModule) {
        Intrinsics.checkNotNullParameter(socialLoginDomainModule, "socialLoginDomainModule");
        return socialLoginDomainModule.getGoogleLoginUseCase();
    }

    @NotNull
    @Reusable
    @Provides
    public final InitializeFacebookLoginUseCase initializeFacebookLoginUseCase(@NotNull SocialLoginDomainModule socialLoginDomainModule) {
        Intrinsics.checkNotNullParameter(socialLoginDomainModule, "socialLoginDomainModule");
        return socialLoginDomainModule.getInitializeFacebookLoginUseCase();
    }

    @NotNull
    @Reusable
    @Provides
    public final InitializeGoogleLoginUseCase initializeGoogleLoginUseCase(@NotNull SocialLoginDomainModule socialLoginDomainModule) {
        Intrinsics.checkNotNullParameter(socialLoginDomainModule, "socialLoginDomainModule");
        return socialLoginDomainModule.getInitializeGoogleLoginUseCase();
    }

    @NotNull
    @Reusable
    @Provides
    public final AaaAuthenticationForSocialLoginRepository provideAaaAuthenticatorForSocialLogin(@NotNull SocialAuthenticationRepository socialAuthenticationRepository) {
        Intrinsics.checkNotNullParameter(socialAuthenticationRepository, "authenticationRepository");
        return new SocialLoginAAAAuthenticationRepository(socialAuthenticationRepository);
    }

    @NotNull
    @Reusable
    @Provides
    public final SocialLoginDomainModule provideSocialLoginDomainModule(@NotNull Provider<GoogleLoginRepository> provider, @NotNull Provider<FacebookLoginRepository> provider2, @NotNull Provider<AaaAuthenticationForSocialLoginRepository> provider3, @NotNull Provider<FacebookLoginActivityIntegration> provider4) {
        Intrinsics.checkNotNullParameter(provider, "googleLoginRepositoryProvider");
        Intrinsics.checkNotNullParameter(provider2, "facebookLoginRepositoryProvider");
        Intrinsics.checkNotNullParameter(provider3, "aaaAuthenticationRepositoryProvider");
        Intrinsics.checkNotNullParameter(provider4, "facebookLoginActivityIntegration");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        return new SocialLoginDomainModule(LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SocialLoginCoreLibModule$provideSocialLoginDomainModule$1(provider)), LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SocialLoginCoreLibModule$provideSocialLoginDomainModule$2(provider2)), LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SocialLoginCoreLibModule$provideSocialLoginDomainModule$3(provider3)), LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SocialLoginCoreLibModule$provideSocialLoginDomainModule$4(provider4)));
    }
}
