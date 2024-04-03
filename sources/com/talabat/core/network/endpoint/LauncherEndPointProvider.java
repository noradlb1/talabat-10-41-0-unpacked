package com.talabat.core.network.endpoint;

import com.talabat.core.network.domain.endpoint.EndpointEnvironment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/core/network/endpoint/LauncherEndPointProvider;", "Lcom/talabat/core/network/endpoint/EndPointProvider;", "()V", "URL_RESTAURANT_BASE_QA", "", "URL_RESTAURANT_PRODUCTION", "baseUrl", "getBaseUrl", "()Ljava/lang/String;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Use BaseUrlFactory from :core:network:domain and don't depend on :core:network:data. Read wiki: https://github.com/talabat-dhme/TalabatAndroid/wiki/Endpoints-and-Base-Urls")
public final class LauncherEndPointProvider extends EndPointProvider {
    @NotNull
    public static final LauncherEndPointProvider INSTANCE;
    @NotNull
    private static final String URL_RESTAURANT_BASE_QA = "https://launcher-qa.dhhmena.com";
    @NotNull
    private static final String URL_RESTAURANT_PRODUCTION = "https://launcher.talabat.com";
    @NotNull
    private static final String baseUrl;

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

    static {
        String str;
        LauncherEndPointProvider launcherEndPointProvider = new LauncherEndPointProvider();
        INSTANCE = launcherEndPointProvider;
        int i11 = WhenMappings.$EnumSwitchMapping$0[launcherEndPointProvider.getEndpointEnvironment().ordinal()];
        if (i11 == 1) {
            str = URL_RESTAURANT_PRODUCTION;
        } else if (i11 == 2) {
            str = URL_RESTAURANT_BASE_QA;
        } else if (i11 == 3) {
            str = "http://localhost:8000/";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        baseUrl = str;
    }

    private LauncherEndPointProvider() {
        super((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    @NotNull
    public String getBaseUrl() {
        return baseUrl;
    }
}
