package com.talabat.core.google.login.data.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.google.login.domain.GoogleLoginCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/google/login/data/di/GoogleLoginCoreLibComponent;", "Lcom/talabat/core/google/login/domain/GoogleLoginCoreLibApi;", "Factory", "com_talabat_core_social-login_google_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ContextCoreLibApi.class}, modules = {GoogleLoginCoreLibModule.class})
public interface GoogleLoginCoreLibComponent extends GoogleLoginCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/google/login/data/di/GoogleLoginCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/google/login/data/di/GoogleLoginCoreLibComponent;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "com_talabat_core_social-login_google_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        GoogleLoginCoreLibComponent create(@NotNull ContextCoreLibApi contextCoreLibApi);
    }
}
