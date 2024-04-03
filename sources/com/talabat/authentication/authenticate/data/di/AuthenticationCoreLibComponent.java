package com.talabat.authentication.authenticate.data.di;

import com.talabat.authentication.aaa.di.AaaCoreLibApi;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.gdm.owin.domain.GdmOwinTokenApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/authentication/authenticate/data/di/AuthenticationCoreLibComponent;", "Lcom/talabat/authentication/authenticate/domain/AuthenticationCoreLibApi;", "Factory", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {AaaCoreLibApi.class, ContextCoreLibApi.class, DispatcherCoreLibApi.class, FeatureFlagCoreLibApi.class, GdmOwinTokenApi.class, ParserCoreLibApi.class, SecretCoreLibApi.class, TokenCoreLibDataApi.class, ObservabilityCoreLibApi.class}, modules = {AuthenticationCoreLibModule.class})
public interface AuthenticationCoreLibComponent extends AuthenticationCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/talabat/authentication/authenticate/data/di/AuthenticationCoreLibComponent$Factory;", "", "create", "Lcom/talabat/authentication/authenticate/data/di/AuthenticationCoreLibComponent;", "aaaCoreLibApi", "Lcom/talabat/authentication/aaa/di/AaaCoreLibApi;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "gdmOwinTokenApi", "Lcom/talabat/gdm/owin/domain/GdmOwinTokenApi;", "parserCoreLibApi", "Lcom/talabat/core/parser/domain/ParserCoreLibApi;", "secretCoreLibApi", "Lcom/talabat/authentication/aaa/di/SecretCoreLibApi;", "tokenCoreLibDataApi", "Lcom/talabat/authentication/token/data/di/TokenCoreLibDataApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        AuthenticationCoreLibComponent create(@NotNull AaaCoreLibApi aaaCoreLibApi, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull GdmOwinTokenApi gdmOwinTokenApi, @NotNull ParserCoreLibApi parserCoreLibApi, @NotNull SecretCoreLibApi secretCoreLibApi, @NotNull TokenCoreLibDataApi tokenCoreLibDataApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi);
    }
}
