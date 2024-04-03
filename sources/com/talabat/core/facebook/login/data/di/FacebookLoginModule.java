package com.talabat.core.facebook.login.data.di;

import com.facebook.AccessTokenManager;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/core/facebook/login/data/di/FacebookLoginModule;", "", "()V", "provideAccessTokenManager", "Lcom/facebook/AccessTokenManager;", "provideCallbackManager", "Lcom/facebook/CallbackManager;", "provideLoginManager", "Lcom/facebook/login/LoginManager;", "com_talabat_core_social-login_facebook_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class FacebookLoginModule {
    @NotNull
    public static final FacebookLoginModule INSTANCE = new FacebookLoginModule();

    private FacebookLoginModule() {
    }

    @NotNull
    @Provides
    public final AccessTokenManager provideAccessTokenManager() {
        return AccessTokenManager.Companion.getInstance();
    }

    @NotNull
    @Reusable
    @Provides
    public final CallbackManager provideCallbackManager() {
        return CallbackManager.Factory.create();
    }

    @NotNull
    @Provides
    public final LoginManager provideLoginManager() {
        return LoginManager.Companion.getInstance();
    }
}
