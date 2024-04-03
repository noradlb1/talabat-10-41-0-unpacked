package com.talabat.core.social.login.data.di;

import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.core.facebook.login.domain.FacebookLoginCoreLibApi;
import com.talabat.core.google.login.domain.GoogleLoginCoreLibApi;
import com.talabat.core.social.login.domain.SocialLoginCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/social/login/data/di/SocialLoginCoreLibComponent;", "Lcom/talabat/core/social/login/domain/SocialLoginCoreLibApi;", "Factory", "com_talabat_core_social-login_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {AuthenticationCoreLibApi.class, GoogleLoginCoreLibApi.class, FacebookLoginCoreLibApi.class}, modules = {SocialLoginCoreLibModule.class})
public interface SocialLoginCoreLibComponent extends SocialLoginCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/core/social/login/data/di/SocialLoginCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/social/login/data/di/SocialLoginCoreLibComponent;", "authenticationCoreLibApi", "Lcom/talabat/authentication/authenticate/domain/AuthenticationCoreLibApi;", "googleLoginCoreLibApi", "Lcom/talabat/core/google/login/domain/GoogleLoginCoreLibApi;", "facebookLoginCoreLibApi", "Lcom/talabat/core/facebook/login/domain/FacebookLoginCoreLibApi;", "com_talabat_core_social-login_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        SocialLoginCoreLibComponent create(@NotNull AuthenticationCoreLibApi authenticationCoreLibApi, @NotNull GoogleLoginCoreLibApi googleLoginCoreLibApi, @NotNull FacebookLoginCoreLibApi facebookLoginCoreLibApi);
    }
}
