package com.talabat.core.google.login.domain;

import com.talabat.core.di.Api;
import com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration;
import com.talabat.core.google.login.domain.repository.GoogleLoginRepository;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/core/google/login/domain/GoogleLoginCoreLibApi;", "Lcom/talabat/core/di/Api;", "googleLoginActivityIntegration", "Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration;", "getGoogleLoginActivityIntegration", "()Lcom/talabat/core/google/login/domain/integration/GoogleLoginActivityIntegration;", "googleLoginRepository", "Lcom/talabat/core/google/login/domain/repository/GoogleLoginRepository;", "getGoogleLoginRepository", "()Lcom/talabat/core/google/login/domain/repository/GoogleLoginRepository;", "com_talabat_core_social-login_google_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GoogleLoginCoreLibApi extends Api {
    @NotNull
    GoogleLoginActivityIntegration getGoogleLoginActivityIntegration();

    @NotNull
    GoogleLoginRepository getGoogleLoginRepository();
}
