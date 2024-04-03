package com.talabat.core.network.domain.endpoint;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "", "baseUrl", "", "Lcom/talabat/core/network/domain/endpoint/IBaseUrl;", "currentEnvironment", "Lcom/talabat/core/network/domain/endpoint/EndpointEnvironment;", "com_talabat_core_network_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BaseUrlFactory {
    @NotNull
    String baseUrl(@NotNull IBaseUrl iBaseUrl);

    @NotNull
    EndpointEnvironment currentEnvironment();
}
