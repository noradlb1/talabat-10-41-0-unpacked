package com.talabat.core.social.login.domain.di;

import com.talabat.core.social.login.domain.SocialLoginUseCase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/core/social/login/domain/SocialLoginUseCase;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SocialLoginDomainModule$initializeGoogleLoginUseCase$2 extends Lambda implements Function0<SocialLoginUseCase> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SocialLoginDomainModule f56000g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SocialLoginDomainModule$initializeGoogleLoginUseCase$2(SocialLoginDomainModule socialLoginDomainModule) {
        super(0);
        this.f56000g = socialLoginDomainModule;
    }

    @NotNull
    public final SocialLoginUseCase invoke() {
        return this.f56000g.getSocialLoginUseCase();
    }
}
