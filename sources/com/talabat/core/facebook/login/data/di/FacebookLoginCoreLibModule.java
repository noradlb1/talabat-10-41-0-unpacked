package com.talabat.core.facebook.login.data.di;

import com.talabat.core.facebook.login.data.impl.FacebookLoginRepositoryImpl;
import com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/facebook/login/data/di/FacebookLoginCoreLibModule;", "", "provideFacebookRepository", "Lcom/talabat/core/facebook/login/domain/repository/FacebookLoginRepository;", "facebookRepositoryImpl", "Lcom/talabat/core/facebook/login/data/impl/FacebookLoginRepositoryImpl;", "com_talabat_core_social-login_facebook_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {FacebookLoginActivityIntegrationModule.class, FacebookLoginDataSourceModule.class})
public interface FacebookLoginCoreLibModule {
    @NotNull
    @Binds
    @Reusable
    FacebookLoginRepository provideFacebookRepository(@NotNull FacebookLoginRepositoryImpl facebookLoginRepositoryImpl);
}
