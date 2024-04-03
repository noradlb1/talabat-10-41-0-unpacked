package com.talabat.core.google.login.data.di;

import com.talabat.core.google.login.data.impl.GoogleLoginActivityIntegrationImpl;
import com.talabat.core.google.login.data.impl.GoogleLoginRepositoryImpl;
import com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration;
import com.talabat.core.google.login.domain.repository.GoogleLoginRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/talabat/core/google/login/data/di/GoogleLoginCoreLibModule;", "", "provideGoogleActivityIntegration", "Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration;", "googleLoginActivityIntegrationImpl", "Lcom/talabat/core/google/login/data/impl/GoogleLoginActivityIntegrationImpl;", "provideGoogleRepository", "Lcom/talabat/core/google/login/domain/repository/GoogleLoginRepository;", "googleRepositoryImpl", "Lcom/talabat/core/google/login/data/impl/GoogleLoginRepositoryImpl;", "com_talabat_core_social-login_google_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {GoogleLoginDataSourceModule.class})
public interface GoogleLoginCoreLibModule {
    @NotNull
    @Binds
    @Reusable
    GoogleLoginActivityIntegration provideGoogleActivityIntegration(@NotNull GoogleLoginActivityIntegrationImpl googleLoginActivityIntegrationImpl);

    @NotNull
    @Binds
    @Reusable
    GoogleLoginRepository provideGoogleRepository(@NotNull GoogleLoginRepositoryImpl googleLoginRepositoryImpl);
}
