package com.talabat.authentication.aaa;

import com.talabat.core.network.domain.endpoint.EndpointEnvironment;
import com.talabat.core.network.endpoint.EndPointProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/authentication/aaa/EndpointProvider;", "Lcom/talabat/core/network/endpoint/EndPointProvider;", "server", "", "buildType", "(Ljava/lang/String;Ljava/lang/String;)V", "baseUrl", "getBaseUrl", "()Ljava/lang/String;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EndpointProvider extends EndPointProvider {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public EndpointProvider(@NotNull String str, @NotNull String str2) {
        super(str, str2);
        String str3;
        Intrinsics.checkNotNullParameter(str, "server");
        Intrinsics.checkNotNullParameter(str2, "buildType");
        int i11 = WhenMappings.$EnumSwitchMapping$0[getEndpointEnvironment().ordinal()];
        if (i11 == 1) {
            str3 = "https://talabat.dh-auth.io";
        } else if (i11 == 2) {
            str3 = "https://talabat-st.dh-auth.io";
        } else if (i11 == 3) {
            str3 = "http://localhost:8000/";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.baseUrl = str3;
    }

    @NotNull
    public String getBaseUrl() {
        return this.baseUrl;
    }
}
