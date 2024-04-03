package com.talabat.core.network.endpoint;

import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.core.network.domain.endpoint.EndpointEnvironment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/network/endpoint/ChameleonEndPointProvider;", "Lcom/talabat/core/network/endpoint/EndPointProvider;", "server", "", "buildType", "(Ljava/lang/String;Ljava/lang/String;)V", "BASE_RELEASE_URL", "BASE_URL", "baseUrl", "getBaseUrl", "()Ljava/lang/String;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Use BaseUrlFactory from :core:network:domain and don't depend on :core:network:data. Read wiki: https://github.com/talabat-dhme/TalabatAndroid/wiki/Endpoints-and-Base-Urls")
public final class ChameleonEndPointProvider extends EndPointProvider {
    @NotNull
    private final String BASE_RELEASE_URL;
    @NotNull
    private final String BASE_URL;
    @NotNull
    private final String baseUrl;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EndpointEnvironment.values().length];
            iArr[EndpointEnvironment.PRODUCTION.ordinal()] = 1;
            iArr[EndpointEnvironment.QA.ordinal()] = 2;
            iArr[EndpointEnvironment.MOCK.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ChameleonEndPointProvider() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChameleonEndPointProvider(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? TalabatEnvironment.INSTANCE.getEnvironment() : str, (i11 & 2) != 0 ? "release" : str2);
    }

    @NotNull
    public String getBaseUrl() {
        return this.baseUrl;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChameleonEndPointProvider(@NotNull String str, @NotNull String str2) {
        super(str, str2);
        Intrinsics.checkNotNullParameter(str, "server");
        Intrinsics.checkNotNullParameter(str2, "buildType");
        String str3 = "https://api-qa.dhhmena.com/chameleon/";
        this.BASE_URL = str3;
        this.BASE_RELEASE_URL = "https://api.talabat.com/chameleon/";
        int i11 = WhenMappings.$EnumSwitchMapping$0[getEndpointEnvironment().ordinal()];
        if (i11 == 1) {
            str3 = "https://api.talabat.com/chameleon/";
        } else if (i11 != 2) {
            if (i11 == 3) {
                str3 = "http://localhost:8000/";
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        this.baseUrl = str3;
    }
}
