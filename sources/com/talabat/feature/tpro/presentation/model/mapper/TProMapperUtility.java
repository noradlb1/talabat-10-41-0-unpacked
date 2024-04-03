package com.talabat.feature.tpro.presentation.model.mapper;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationExtensionsKt;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionProduct;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.feature.tpro.presentation.model.TProProductDisplayModel;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.visa.checkout.PurchaseInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/tpro/presentation/model/mapper/TProMapperUtility;", "", "()V", "getDecimalNumberForCurrency", "", "currency", "", "getDecimalSignForCurrency", "getDisplayValue", "amount", "", "mapPlanDisplayModel", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "source", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlan;", "mapProductDisplayModel", "Lcom/talabat/feature/tpro/presentation/model/TProProductDisplayModel;", "product", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionProduct;", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProMapperUtility {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DECIMAL_NUMBER_DEFAULT = 2;
    public static final int DECIMAL_NUMBER_FOR_AED = 0;
    public static final int DECIMAL_NUMBER_FOR_KD = 3;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/tpro/presentation/model/mapper/TProMapperUtility$Companion;", "", "()V", "DECIMAL_NUMBER_DEFAULT", "", "DECIMAL_NUMBER_FOR_AED", "DECIMAL_NUMBER_FOR_KD", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final int getDecimalNumberForCurrency(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) PurchaseInfo.Currency.AED)) {
            return 0;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "KD")) {
            return 3;
        }
        return 2;
    }

    private final String getDecimalSignForCurrency(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) PurchaseInfo.Currency.AED)) {
            return StringUtils.empty(StringCompanionObject.INSTANCE);
        }
        if (Intrinsics.areEqual((Object) str, (Object) "KD")) {
            return RealDiscoveryConfigurationRepository.VERSION_DELIMETER;
        }
        return LocationExtensionsKt.decimalPatterByNumberOfDecimalPlaces$default(0, 1, (Object) null);
    }

    private final String getDisplayValue(float f11, String str) {
        return StringsKt__StringsKt.trim((CharSequence) CurrencyFormatter.Companion.getFormattedCurrency(Double.parseDouble(String.valueOf(f11)), true, str, getDecimalNumberForCurrency(str), getDecimalSignForCurrency(str))).toString();
    }

    @NotNull
    public final TProPlanDisplayModel mapPlanDisplayModel(@NotNull SubscriptionPlan subscriptionPlan) {
        Intrinsics.checkNotNullParameter(subscriptionPlan, "source");
        String planId = subscriptionPlan.getPlanId();
        String title = subscriptionPlan.getTitle();
        String description = subscriptionPlan.getDescription();
        String displayValue = getDisplayValue(subscriptionPlan.getCurrencyAmount().getAmount(), subscriptionPlan.getCurrencyAmount().getCurrency());
        float amount = subscriptionPlan.getCurrencyAmount().getAmount();
        String country = subscriptionPlan.getCountry();
        int durationDays = subscriptionPlan.getDurationDays();
        int freeTrialDays = subscriptionPlan.getFreeTrialInfo().getFreeTrialDays();
        String freeTrialTitle = subscriptionPlan.getFreeTrialInfo().getFreeTrialTitle();
        String termsUrl = subscriptionPlan.getTermsUrl();
        Iterable<SubscriptionProduct> products = subscriptionPlan.getProducts();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(products, 10));
        for (SubscriptionProduct mapProductDisplayModel : products) {
            arrayList.add(mapProductDisplayModel(mapProductDisplayModel));
        }
        boolean freeTrialEligible = subscriptionPlan.getFreeTrialInfo().getFreeTrialEligible();
        boolean activeSubscription = subscriptionPlan.getActiveSubscription();
        String displayValue2 = getDisplayValue(subscriptionPlan.getMinDeliveryFee(), subscriptionPlan.getCurrencyAmount().getCurrency());
        float minDeliveryFee = subscriptionPlan.getMinDeliveryFee();
        String planPeriod = subscriptionPlan.getPlanPeriod();
        return new TProPlanDisplayModel(planId, title, description, displayValue, amount, country, durationDays, freeTrialDays, freeTrialTitle, termsUrl, displayValue2, arrayList, freeTrialEligible, activeSubscription, minDeliveryFee, subscriptionPlan.getPeriodPrice(), planPeriod, subscriptionPlan.getBillingCycle(), subscriptionPlan.getFreeTrialText(), subscriptionPlan.getPaymentText(), subscriptionPlan.getOrder(), subscriptionPlan.getCategory(), subscriptionPlan.getBannerImage(), subscriptionPlan.getBannerHeader(), subscriptionPlan.getBannerDescription(), subscriptionPlan.getBenefitsHeader(), subscriptionPlan.getRenewType(), subscriptionPlan.getEndDate());
    }

    @NotNull
    public final TProProductDisplayModel mapProductDisplayModel(@NotNull SubscriptionProduct subscriptionProduct) {
        Intrinsics.checkNotNullParameter(subscriptionProduct, "product");
        return new TProProductDisplayModel(subscriptionProduct.getTitle(), subscriptionProduct.getId(), subscriptionProduct.getDescription(), subscriptionProduct.getIcon());
    }
}
