package com.talabat.core.network.endpoint;

import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.core.network.domain.endpoint.EndpointEnvironment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/core/network/endpoint/EndPointProvider;", "Lcom/talabat/core/network/endpoint/IEndPointProvider;", "server", "", "buildType", "(Ljava/lang/String;Ljava/lang/String;)V", "endpointEnvironment", "Lcom/talabat/core/network/domain/endpoint/EndpointEnvironment;", "getEndpointEnvironment", "()Lcom/talabat/core/network/domain/endpoint/EndpointEnvironment;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Use BaseUrlFactory from :core:network:domain and don't depend on :core:network:data. Read wiki: https://github.com/talabat-dhme/TalabatAndroid/wiki/Endpoints-and-Base-Urls")
public abstract class EndPointProvider implements IEndPointProvider {
    @NotNull
    private final EndpointEnvironment endpointEnvironment;

    @JvmOverloads
    public EndPointProvider() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EndPointProvider(@NotNull String str) {
        this(str, (String) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "server");
    }

    @JvmOverloads
    public EndPointProvider(@NotNull String str, @NotNull String str2) {
        EndpointEnvironment endpointEnvironment2;
        Intrinsics.checkNotNullParameter(str, "server");
        Intrinsics.checkNotNullParameter(str2, "buildType");
        if (Intrinsics.areEqual((Object) str, (Object) "prod")) {
            endpointEnvironment2 = EndpointEnvironment.PRODUCTION;
        } else if (Intrinsics.areEqual((Object) str, (Object) FunWithFlags.ENV_QA)) {
            endpointEnvironment2 = EndpointEnvironment.QA;
        } else if (Intrinsics.areEqual((Object) str, (Object) "mock")) {
            endpointEnvironment2 = EndpointEnvironment.MOCK;
        } else if (Intrinsics.areEqual((Object) str2, (Object) "release")) {
            endpointEnvironment2 = EndpointEnvironment.PRODUCTION;
        } else {
            endpointEnvironment2 = EndpointEnvironment.QA;
        }
        this.endpointEnvironment = endpointEnvironment2;
    }

    @NotNull
    public final EndpointEnvironment getEndpointEnvironment() {
        return this.endpointEnvironment;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EndPointProvider(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? TalabatEnvironment.INSTANCE.getEnvironment() : str, (i11 & 2) != 0 ? "release" : str2);
    }
}
