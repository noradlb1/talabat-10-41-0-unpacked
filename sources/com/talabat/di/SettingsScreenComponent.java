package com.talabat.di;

import com.talabat.SettingsScreen;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.ulaccountinfo.domain.AccountInfoFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/di/SettingsScreenComponent;", "", "inject", "", "settingsScreen", "Lcom/talabat/SettingsScreen;", "Factory", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {MutableConfigurationLocalCoreLibApi.class, MutableConfigurationRemoteCoreLibApi.class, ParserCoreLibApi.class, SubscriptionsFeatureApi.class, FeatureFlagCoreLibApi.class, AccountInfoFeatureApi.class, AuthenticationCoreLibApi.class})
public interface SettingsScreenComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/talabat/di/SettingsScreenComponent$Factory;", "", "create", "Lcom/talabat/di/SettingsScreenComponent;", "mutableConfigurationLocalCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationLocalCoreLibApi;", "mutableConfigurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;", "parserCoreLibApi", "Lcom/talabat/core/parser/domain/ParserCoreLibApi;", "subscriptionsFeatureApi", "Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "accountInfoFeatureApi", "Lcom/talabat/feature/ulaccountinfo/domain/AccountInfoFeatureApi;", "authenticationCoreLibApi", "Lcom/talabat/authentication/authenticate/domain/AuthenticationCoreLibApi;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        SettingsScreenComponent create(@NotNull MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi, @NotNull MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi, @NotNull ParserCoreLibApi parserCoreLibApi, @NotNull SubscriptionsFeatureApi subscriptionsFeatureApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull AccountInfoFeatureApi accountInfoFeatureApi, @NotNull AuthenticationCoreLibApi authenticationCoreLibApi);
    }

    void inject(@NotNull SettingsScreen settingsScreen);
}
