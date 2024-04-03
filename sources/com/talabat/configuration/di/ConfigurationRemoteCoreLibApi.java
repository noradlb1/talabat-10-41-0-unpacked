package com.talabat.configuration.di;

import com.talabat.configuration.ConfigurationRemoteRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.orderexperience.OrderExperienceConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.di.Api;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "Lcom/talabat/core/di/Api;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "getAppVersionProvider", "()Lcom/talabat/configuration/discovery/AppVersionProvider;", "discoveryConfigurationRepository", "Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;", "getDiscoveryConfigurationRepository", "()Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "orderExperienceConfigurationRepository", "Lcom/talabat/configuration/orderexperience/OrderExperienceConfigurationRepository;", "getOrderExperienceConfigurationRepository", "()Lcom/talabat/configuration/orderexperience/OrderExperienceConfigurationRepository;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "getPaymentConfigurationRepository", "()Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "repository", "Lcom/talabat/configuration/ConfigurationRemoteRepository;", "getRepository", "()Lcom/talabat/configuration/ConfigurationRemoteRepository;", "termsAndConditionsConfigurationRepository", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "getTermsAndConditionsConfigurationRepository", "()Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ConfigurationRemoteCoreLibApi extends Api {
    @NotNull
    AppVersionProvider getAppVersionProvider();

    @NotNull
    DiscoveryConfigurationRepository getDiscoveryConfigurationRepository();

    @NotNull
    LocationConfigurationRepository getLocationConfigurationRepository();

    @NotNull
    OrderExperienceConfigurationRepository getOrderExperienceConfigurationRepository();

    @NotNull
    PaymentConfigurationRepository getPaymentConfigurationRepository();

    @NotNull
    ConfigurationRemoteRepository getRepository();

    @NotNull
    TermsAndConditionsConfigurationRepository getTermsAndConditionsConfigurationRepository();
}
