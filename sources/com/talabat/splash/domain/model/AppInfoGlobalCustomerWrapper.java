package com.talabat.splash.domain.model;

import android.content.Context;
import buisnessmodels.Customer;
import buisnessmodels.mappers.TokenizedBankCardToOldTokenizedBankCardMapper;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BC\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\tJ\u001b\u0010\u0012\u001a\u00020\t2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/splash/domain/model/AppInfoGlobalCustomerWrapper;", "", "context", "Landroid/content/Context;", "customer", "Lbuisnessmodels/Customer;", "setPilotUser", "Lio/reactivex/functions/Function;", "", "", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "tokenizedBankCardToOldTokenizedBankCardMapper", "Lbuisnessmodels/mappers/TokenizedBankCardToOldTokenizedBankCardMapper;", "featureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Landroid/content/Context;Lbuisnessmodels/Customer;Lio/reactivex/functions/Function;Lcom/talabat/configuration/payment/PaymentConfigurationRepository;Lbuisnessmodels/mappers/TokenizedBankCardToOldTokenizedBankCardMapper;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "clearGlobalToken", "setAppInfoGlobalCustomerAddressDetails", "response", "", "Lcom/talabat/domain/address/Address;", "([Lcom/talabat/domain/address/Address;)V", "setAppInfoGlobalCustomerCardTokens", "Lcom/talabat/splash/domain/entity/AppInitRootEntity;", "setCustomerLanguage", "language", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInfoGlobalCustomerWrapper {
    @NotNull
    private final Context context;
    @NotNull
    private final Customer customer;
    @NotNull
    private final ITalabatFeatureFlag featureFlags;
    @NotNull
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    @NotNull
    private final Function<String, Unit> setPilotUser;
    @NotNull
    private final TokenizedBankCardToOldTokenizedBankCardMapper tokenizedBankCardToOldTokenizedBankCardMapper;

    @Inject
    public AppInfoGlobalCustomerWrapper(@NotNull Context context2, @NotNull Customer customer2, @NotNull Function<String, Unit> function, @NotNull PaymentConfigurationRepository paymentConfigurationRepository2, @NotNull TokenizedBankCardToOldTokenizedBankCardMapper tokenizedBankCardToOldTokenizedBankCardMapper2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(customer2, "customer");
        Intrinsics.checkNotNullParameter(function, "setPilotUser");
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "paymentConfigurationRepository");
        Intrinsics.checkNotNullParameter(tokenizedBankCardToOldTokenizedBankCardMapper2, "tokenizedBankCardToOldTokenizedBankCardMapper");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlags");
        this.context = context2;
        this.customer = customer2;
        this.setPilotUser = function;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.tokenizedBankCardToOldTokenizedBankCardMapper = tokenizedBankCardToOldTokenizedBankCardMapper2;
        this.featureFlags = iTalabatFeatureFlag;
    }

    public final void clearGlobalToken() {
        GlobalDataModel.token = null;
    }

    public final void setAppInfoGlobalCustomerAddressDetails(@Nullable Address[] addressArr) {
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNull(addressArr);
        arrayList.addAll(Arrays.asList(Arrays.copyOf(addressArr, addressArr.length)));
        this.customer.setCustomerAddress(this.context, arrayList);
    }

    /* JADX WARNING: type inference failed for: r6v9, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setAppInfoGlobalCustomerCardTokens(@org.jetbrains.annotations.Nullable com.talabat.splash.domain.entity.AppInitRootEntity r6) {
        /*
            r5 = this;
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r0 = r5.featureFlags
            com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants$PayFeatureFlagsWithoutCountry r1 = com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAYMENT_REPO_REAL_CARD_TOKENS
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = com.talabat.core.featureflag.domain.ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L_0x004d
            com.talabat.configuration.payment.PaymentConfigurationRepository r6 = r5.paymentConfigurationRepository
            com.talabat.configuration.payment.WalletConfig r6 = r6.walletConfig()
            java.util.List r6 = r6.getTokenizedBankCards()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            buisnessmodels.mappers.TokenizedBankCardToOldTokenizedBankCardMapper r0 = r5.tokenizedBankCardToOldTokenizedBankCardMapper
            java.util.ArrayList r1 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r6, r3)
            r1.<init>(r3)
            java.util.Iterator r6 = r6.iterator()
        L_0x002a:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L_0x003e
            java.lang.Object r3 = r6.next()
            com.talabat.configuration.payment.TokenizedBankCard r3 = (com.talabat.configuration.payment.TokenizedBankCard) r3
            buisnessmodels.tokenisation.TokenisationCreditCard r3 = r0.apply((com.talabat.configuration.payment.TokenizedBankCard) r3)
            r1.add(r3)
            goto L_0x002a
        L_0x003e:
            buisnessmodels.tokenisation.TokenisationCreditCard[] r6 = new buisnessmodels.tokenisation.TokenisationCreditCard[r2]
            java.lang.Object[] r6 = r1.toArray(r6)
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)
            r4 = r6
            buisnessmodels.tokenisation.TokenisationCreditCard[] r4 = (buisnessmodels.tokenisation.TokenisationCreditCard[]) r4
            goto L_0x0059
        L_0x004d:
            if (r6 == 0) goto L_0x0059
            com.talabat.splash.domain.entity.AppInitResponseEntity r6 = r6.getResult()
            if (r6 == 0) goto L_0x0059
            buisnessmodels.tokenisation.TokenisationCreditCard[] r4 = r6.getTokens()
        L_0x0059:
            buisnessmodels.Customer r6 = r5.customer
            if (r6 == 0) goto L_0x0060
            r6.setSavedCreditCards(r4)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.domain.model.AppInfoGlobalCustomerWrapper.setAppInfoGlobalCustomerCardTokens(com.talabat.splash.domain.entity.AppInitRootEntity):void");
    }

    public final void setCustomerLanguage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ConstantsKt.ADJUST_LANGUAGE);
        Customer.setSavedLanguage(this.context, str);
    }
}
