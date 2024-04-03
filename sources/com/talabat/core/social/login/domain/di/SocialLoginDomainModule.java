package com.talabat.core.social.login.domain.di;

import com.talabat.core.facebook.login.domain.integration.FacebookLoginActivityIntegration;
import com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository;
import com.talabat.core.google.login.domain.repository.GoogleLoginRepository;
import com.talabat.core.social.login.domain.AaaAuthenticationForSocialLoginRepository;
import com.talabat.core.social.login.domain.FacebookLoginUseCase;
import com.talabat.core.social.login.domain.GoogleLoginUseCase;
import com.talabat.core.social.login.domain.InitializeFacebookLoginUseCase;
import com.talabat.core.social.login.domain.InitializeGoogleLoginUseCase;
import com.talabat.core.social.login.domain.SocialLoginUseCase;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/talabat/core/social/login/domain/di/SocialLoginDomainModule;", "", "googleLoginRepositoryProvider", "Lkotlin/Lazy;", "Lcom/talabat/core/google/login/domain/repository/GoogleLoginRepository;", "facebookLoginRepositoryProvider", "Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository;", "aaaAuthenticationRepositoryProvider", "Lcom/talabat/core/social/login/domain/AaaAuthenticationForSocialLoginRepository;", "facebookLoginActivityIntegration", "Lcom/talabat/core/facebook/login/domain/integration/FacebookLoginActivityIntegration;", "(Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;)V", "facebookLoginUseCase", "Lcom/talabat/core/social/login/domain/FacebookLoginUseCase;", "getFacebookLoginUseCase", "()Lcom/talabat/core/social/login/domain/FacebookLoginUseCase;", "facebookLoginUseCase$delegate", "Lkotlin/Lazy;", "googleLoginUseCase", "Lcom/talabat/core/social/login/domain/GoogleLoginUseCase;", "getGoogleLoginUseCase", "()Lcom/talabat/core/social/login/domain/GoogleLoginUseCase;", "googleLoginUseCase$delegate", "initializeFacebookLoginUseCase", "Lcom/talabat/core/social/login/domain/InitializeFacebookLoginUseCase;", "getInitializeFacebookLoginUseCase", "()Lcom/talabat/core/social/login/domain/InitializeFacebookLoginUseCase;", "initializeFacebookLoginUseCase$delegate", "initializeGoogleLoginUseCase", "Lcom/talabat/core/social/login/domain/InitializeGoogleLoginUseCase;", "getInitializeGoogleLoginUseCase", "()Lcom/talabat/core/social/login/domain/InitializeGoogleLoginUseCase;", "initializeGoogleLoginUseCase$delegate", "socialLoginUseCase", "Lcom/talabat/core/social/login/domain/SocialLoginUseCase;", "getSocialLoginUseCase", "()Lcom/talabat/core/social/login/domain/SocialLoginUseCase;", "socialLoginUseCase$delegate", "com_talabat_core_social-login_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SocialLoginDomainModule {
    /* access modifiers changed from: private */
    @NotNull
    public final Lazy<AaaAuthenticationForSocialLoginRepository> aaaAuthenticationRepositoryProvider;
    /* access modifiers changed from: private */
    @NotNull
    public final Lazy<FacebookLoginActivityIntegration> facebookLoginActivityIntegration;
    /* access modifiers changed from: private */
    @NotNull
    public final Lazy<FacebookLoginRepository> facebookLoginRepositoryProvider;
    @NotNull
    private final Lazy facebookLoginUseCase$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final Lazy<GoogleLoginRepository> googleLoginRepositoryProvider;
    @NotNull
    private final Lazy googleLoginUseCase$delegate;
    @NotNull
    private final Lazy initializeFacebookLoginUseCase$delegate;
    @NotNull
    private final Lazy initializeGoogleLoginUseCase$delegate;
    @NotNull
    private final Lazy socialLoginUseCase$delegate;

    public SocialLoginDomainModule(@NotNull Lazy<? extends GoogleLoginRepository> lazy, @NotNull Lazy<? extends FacebookLoginRepository> lazy2, @NotNull Lazy<? extends AaaAuthenticationForSocialLoginRepository> lazy3, @NotNull Lazy<? extends FacebookLoginActivityIntegration> lazy4) {
        Intrinsics.checkNotNullParameter(lazy, "googleLoginRepositoryProvider");
        Intrinsics.checkNotNullParameter(lazy2, "facebookLoginRepositoryProvider");
        Intrinsics.checkNotNullParameter(lazy3, "aaaAuthenticationRepositoryProvider");
        Intrinsics.checkNotNullParameter(lazy4, "facebookLoginActivityIntegration");
        this.googleLoginRepositoryProvider = lazy;
        this.facebookLoginRepositoryProvider = lazy2;
        this.aaaAuthenticationRepositoryProvider = lazy3;
        this.facebookLoginActivityIntegration = lazy4;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.socialLoginUseCase$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SocialLoginDomainModule$socialLoginUseCase$2(this));
        this.facebookLoginUseCase$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SocialLoginDomainModule$facebookLoginUseCase$2(this));
        this.googleLoginUseCase$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SocialLoginDomainModule$googleLoginUseCase$2(this));
        this.initializeGoogleLoginUseCase$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SocialLoginDomainModule$initializeGoogleLoginUseCase$2(this));
        this.initializeFacebookLoginUseCase$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SocialLoginDomainModule$initializeFacebookLoginUseCase$2(this));
    }

    /* access modifiers changed from: private */
    public final SocialLoginUseCase getSocialLoginUseCase() {
        return (SocialLoginUseCase) this.socialLoginUseCase$delegate.getValue();
    }

    @NotNull
    public final FacebookLoginUseCase getFacebookLoginUseCase() {
        return (FacebookLoginUseCase) this.facebookLoginUseCase$delegate.getValue();
    }

    @NotNull
    public final GoogleLoginUseCase getGoogleLoginUseCase() {
        return (GoogleLoginUseCase) this.googleLoginUseCase$delegate.getValue();
    }

    @NotNull
    public final InitializeFacebookLoginUseCase getInitializeFacebookLoginUseCase() {
        return (InitializeFacebookLoginUseCase) this.initializeFacebookLoginUseCase$delegate.getValue();
    }

    @NotNull
    public final InitializeGoogleLoginUseCase getInitializeGoogleLoginUseCase() {
        return (InitializeGoogleLoginUseCase) this.initializeGoogleLoginUseCase$delegate.getValue();
    }
}
