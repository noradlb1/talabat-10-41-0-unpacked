package com.talabat.feature.tokenization.data.baseurl;

import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.network.domain.endpoint.EndpointEnvironment;
import com.talabat.core.network.domain.endpoint.IBaseUrl;
import com.visa.checkout.Profile;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/tokenization/data/baseurl/TokenizationBaseUrl;", "Lcom/talabat/core/network/domain/endpoint/IBaseUrl;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "(Lcom/talabat/configuration/payment/PaymentConfigurationRepository;)V", "baseUrl", "", "environment", "Lcom/talabat/core/network/domain/endpoint/EndpointEnvironment;", "com_talabat_feature_tokenization_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenizationBaseUrl implements IBaseUrl {
    @NotNull
    private final PaymentConfigurationRepository paymentConfigurationRepository;

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

    @Inject
    public TokenizationBaseUrl(@NotNull PaymentConfigurationRepository paymentConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "paymentConfigurationRepository");
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
    }

    @NotNull
    public String baseUrl(@NotNull EndpointEnvironment endpointEnvironment) {
        Intrinsics.checkNotNullParameter(endpointEnvironment, Profile.ENVIRONMENT);
        int i11 = WhenMappings.$EnumSwitchMapping$0[endpointEnvironment.ordinal()];
        if (i11 == 1) {
            return this.paymentConfigurationRepository.config().getCheckoutBaseUrl();
        }
        if (i11 == 2) {
            return this.paymentConfigurationRepository.config().getCheckoutBaseUrl();
        }
        if (i11 == 3) {
            return "http://localhost:8000/";
        }
        throw new NoWhenBranchMatchedException();
    }
}
