package com.talabat.core.network.data.endpoint;

import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.domain.endpoint.EndpointEnvironment;
import com.talabat.core.network.domain.endpoint.IBaseUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/talabat/core/network/data/endpoint/DefaultBaseUrlFactory;", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "()V", "baseUrl", "", "Lcom/talabat/core/network/domain/endpoint/IBaseUrl;", "currentEnvironment", "Lcom/talabat/core/network/domain/endpoint/EndpointEnvironment;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultBaseUrlFactory implements BaseUrlFactory {
    @NotNull
    public String baseUrl(@NotNull IBaseUrl iBaseUrl) {
        EndpointEnvironment endpointEnvironment;
        Intrinsics.checkNotNullParameter(iBaseUrl, "baseUrl");
        if (!Intrinsics.areEqual((Object) "release", (Object) "debug")) {
            endpointEnvironment = EndpointEnvironment.PRODUCTION;
        } else {
            endpointEnvironment = currentEnvironment();
        }
        return iBaseUrl.baseUrl(endpointEnvironment);
    }

    @NotNull
    public EndpointEnvironment currentEnvironment() {
        EndpointEnvironment endpointEnvironment;
        EndpointEnvironment[] values = EndpointEnvironment.Companion.getValues();
        int length = values.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                endpointEnvironment = null;
                break;
            }
            endpointEnvironment = values[i11];
            if (Intrinsics.areEqual((Object) endpointEnvironment.getLabel(), (Object) TalabatEnvironment.INSTANCE.getEnvironment())) {
                break;
            }
            i11++;
        }
        if (endpointEnvironment == null) {
            return EndpointEnvironment.QA;
        }
        return endpointEnvironment;
    }
}
