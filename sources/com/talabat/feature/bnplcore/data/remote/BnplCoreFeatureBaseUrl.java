package com.talabat.feature.bnplcore.data.remote;

import androidx.annotation.VisibleForTesting;
import com.talabat.core.network.domain.endpoint.EndpointEnvironment;
import com.talabat.core.network.domain.endpoint.IBaseUrl;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/talabat/feature/bnplcore/data/remote/BnplCoreFeatureBaseUrl;", "Lcom/talabat/core/network/domain/endpoint/IBaseUrl;", "()V", "baseUrl", "", "environment", "Lcom/talabat/core/network/domain/endpoint/EndpointEnvironment;", "Companion", "com_talabat_feature_bnpl-core_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BnplCoreFeatureBaseUrl implements IBaseUrl {
    @NotNull
    public static final String BASE_URL_PROD = "https://bnplpay.talabat.com";
    @NotNull
    public static final String BASE_URL_QA = "https://bnplpay-qa.dhhmena.com";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\b"}, d2 = {"Lcom/talabat/feature/bnplcore/data/remote/BnplCoreFeatureBaseUrl$Companion;", "", "()V", "BASE_URL_PROD", "", "getBASE_URL_PROD$com_talabat_feature_bnpl_core_data_data$annotations", "BASE_URL_QA", "getBASE_URL_QA$com_talabat_feature_bnpl_core_data_data$annotations", "com_talabat_feature_bnpl-core_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getBASE_URL_PROD$com_talabat_feature_bnpl_core_data_data$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getBASE_URL_QA$com_talabat_feature_bnpl_core_data_data$annotations() {
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
