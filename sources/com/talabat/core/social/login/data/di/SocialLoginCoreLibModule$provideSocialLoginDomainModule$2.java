package com.talabat.core.social.login.data.di;

import com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SocialLoginCoreLibModule$provideSocialLoginDomainModule$2 extends Lambda implements Function0<FacebookLoginRepository> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Provider<FacebookLoginRepository> f55980g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SocialLoginCoreLibModule$provideSocialLoginDomainModule$2(Provider<FacebookLoginRepository> provider) {
        super(0);
        this.f55980g = provider;
    }

    public final FacebookLoginRepository invoke() {
        return this.f55980g.get();
    }
}
