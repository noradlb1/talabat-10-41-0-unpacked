package com.talabat.configuration.payment;

import buisnessmodels.mappers.OldTokenizedBankCardToTokenizedBankCardMapper;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.configuration.AppInfoContainer;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.helpers.GlobalDataModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/configuration/payment/LegacyPaymentConfigurationRepository;", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "realRepository", "Lcom/talabat/configuration/payment/RealPaymentConfigurationRepository;", "appInfoContainer", "Lcom/talabat/configuration/AppInfoContainer;", "featureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "oldTokenizedBankCardToTokenizedBankCardMapper", "Lbuisnessmodels/mappers/OldTokenizedBankCardToTokenizedBankCardMapper;", "(Lcom/talabat/configuration/payment/RealPaymentConfigurationRepository;Lcom/talabat/configuration/AppInfoContainer;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;Lbuisnessmodels/mappers/OldTokenizedBankCardToTokenizedBankCardMapper;)V", "config", "Lcom/talabat/configuration/payment/PaymentConfig;", "walletConfig", "Lcom/talabat/configuration/payment/WalletConfig;", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LegacyPaymentConfigurationRepository implements PaymentConfigurationRepository {
    @NotNull
    private final AppInfoContainer appInfoContainer;
    @NotNull
    private final BaseUrlFactory baseUrlFactory;
    @NotNull
    private final ITalabatFeatureFlag featureFlags;
    @NotNull
    private final OldTokenizedBankCardToTokenizedBankCardMapper oldTokenizedBankCardToTokenizedBankCardMapper;
    @NotNull
    private final RealPaymentConfigurationRepository realRepository;

    @Inject
    public LegacyPaymentConfigurationRepository(@NotNull RealPaymentConfigurationRepository realPaymentConfigurationRepository, @NotNull AppInfoContainer appInfoContainer2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull BaseUrlFactory baseUrlFactory2, @NotNull OldTokenizedBankCardToTokenizedBankCardMapper oldTokenizedBankCardToTokenizedBankCardMapper2) {
        Intrinsics.checkNotNullParameter(realPaymentConfigurationRepository, "realRepository");
        Intrinsics.checkNotNullParameter(appInfoContainer2, "appInfoContainer");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlags");
        Intrinsics.checkNotNullParameter(baseUrlFactory2, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(oldTokenizedBankCardToTokenizedBankCardMapper2, "oldTokenizedBankCardToTokenizedBankCardMapper");
        this.realRepository = realPaymentConfigurationRepository;
        this.appInfoContainer = appInfoContainer2;
        this.featureFlags = iTalabatFeatureFlag;
        this.baseUrlFactory = baseUrlFactory2;
        this.oldTokenizedBankCardToTokenizedBankCardMapper = oldTokenizedBankCardToTokenizedBankCardMapper2;
    }

    @NotNull
    public PaymentConfig config() {
        String str;
        PaymentConfig config = this.realRepository.config();
        String checkoutBaseUrl = config.getCheckoutBaseUrl();
        boolean isBinCampAvailable = config.isBinCampAvailable();
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlags, PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAYMENT_REPO_REAL_PUBLIC_KEY, false, 2, (Object) null)) {
            str = config.getPublicKey();
        } else {
            str = GlobalDataModel.CHECKOUTDOTCOM.publicKey;
            if (str == null) {
                str = "";
            }
        }
        return new PaymentConfig(checkoutBaseUrl, (String) null, (String) null, isBinCampAvailable, str, config.getVisaCheckoutPublicKey(), 6, (DefaultConstructorMarker) null);
    }

    @NotNull
    public WalletConfig walletConfig() {
        List<TokenizedBankCard> list;
        WalletConfig walletConfig = this.realRepository.walletConfig();
        boolean isAmexAvailable = walletConfig.isAmexAvailable();
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlags, PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAYMENT_REPO_REAL_CARD_TOKENS, false, 2, (Object) null)) {
            list = walletConfig.getTokenizedBankCards();
        } else {
            ArrayList<TokenisationCreditCard> arrayList = GlobalDataModel.BIN.savedTokens;
            Intrinsics.checkNotNullExpressionValue(arrayList, "savedTokens");
            OldTokenizedBankCardToTokenizedBankCardMapper oldTokenizedBankCardToTokenizedBankCardMapper2 = this.oldTokenizedBankCardToTokenizedBankCardMapper;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (TokenisationCreditCard apply : arrayList) {
                arrayList2.add(oldTokenizedBankCardToTokenizedBankCardMapper2.apply(apply));
            }
            list = arrayList2;
        }
        return new WalletConfig(isAmexAvailable, list);
    }
}
