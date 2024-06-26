package com.talabat.feature.pickup.data;

import com.talabat.core.network.domain.endpoint.EndpointEnvironment;
import com.talabat.core.network.domain.endpoint.IBaseUrl;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/talabat/feature/pickup/data/PickupBaseUrl;", "Lcom/talabat/core/network/domain/endpoint/IBaseUrl;", "()V", "baseUrl", "", "environment", "Lcom/talabat/core/network/domain/endpoint/EndpointEnvironment;", "Companion", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupBaseUrl implements IBaseUrl {
    @NotNull
    private static final String BASE_URL_PROD = "https://api.talabat.com";
    @NotNull
    private static final String BASE_URL_QA = "https://api-qa.dhhmena.com";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/pickup/data/PickupBaseUrl$Companion;", "", "()V", "BASE_URL_PROD", "", "BASE_URL_QA", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

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

    @NotNull
    public String baseUrl(@NotNull EndpointEnvironment endpointEnvironment) {
        Intrinsics.checkNotNullParameter(endpointEnvironment, Profile.ENVIRONMENT);
        int i11 = WhenMappings.$EnumSwitchMapping$0[endpointEnvironment.ordinal()];
        if (i11 == 1) {
            return BASE_URL_PROD;
        }
        if (i11 == 2) {
            return BASE_URL_QA;
        }
        if (i11 == 3) {
            return "http://localhost:8000/";
        }
        throw new NoWhenBranchMatchedException();
    }
}
