package com.talabat.configuration.discovery;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;", "", "config", "Lcom/talabat/configuration/discovery/DiscoveryConfig;", "isNewAppVersionAvailable", "", "shouldForceUpdate", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DiscoveryConfigurationRepository {
    @NotNull
    DiscoveryConfig config();

    boolean isNewAppVersionAvailable();

    boolean shouldForceUpdate();
}
