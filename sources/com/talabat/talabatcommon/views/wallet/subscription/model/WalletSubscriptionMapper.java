package com.talabat.talabatcommon.views.wallet.subscription.model;

import com.talabat.configuration.country.Country;
import com.talabat.mapper.ModelMappingIntegrationKt;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardResponseModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDetailRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanResponseModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionProduct;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionResponseModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionResponseResult;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationReason;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationReasonResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationReasonResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/model/WalletSubscriptionMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletSubscriptionMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010\u0016J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\"J\u0010\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010(J@\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u00100\u001a\u00020\r¨\u00061"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/model/WalletSubscriptionMapper$Companion;", "", "()V", "getSubscriptionCancellationReasons", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionCancellationReasonsDisplayModel;", "response", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationReasonResponse;", "getUpSubscribedPlans", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanDisplayModel;", "subscriptions", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDisplayModel;", "plans", "mapCountryToISOValue", "", "countryId", "", "mapPlanResponseToDisplayModel", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanRootResponse;", "subscriptionsFeatureFlag", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "mapPlanToSubscriptionItemDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanItemDisplayModel;", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanResponseModel;", "mapSubscriptionDefaultCardToDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDefaultCardDisplayModel;", "subscriptionDefaultCardRootResponse", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardRootResponse;", "mapSubscriptionDetailToDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionItemDisplayModel;", "subscriptionDetailRootResponse", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDetailRootResponse;", "mapSubscriptionPlanToDisplayModel", "subscriptionPlanResponseModel", "mapSubscriptionProductList", "", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionProductDisplayModel;", "subscriptionProductList", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionProduct;", "mapSubscriptionToDisplayModel", "subscriptionRootResponse", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionRootResponse;", "subscriptionDurationStringMapper", "duration", "dayText", "weekText", "monthText", "yearText", "monthsText", "perText", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String subscriptionDurationStringMapper$default(Companion companion, int i11, String str, String str2, String str3, String str4, String str5, String str6, int i12, Object obj) {
            String str7;
            if ((i12 & 64) != 0) {
                str7 = StringUtils.empty(StringCompanionObject.INSTANCE);
            } else {
                str7 = str6;
            }
            return companion.subscriptionDurationStringMapper(i11, str, str2, str3, str4, str5, str7);
        }

        @NotNull
        public final SubscriptionCancellationReasonsDisplayModel getSubscriptionCancellationReasons(@Nullable SubscriptionCancellationReasonResponse subscriptionCancellationReasonResponse) {
            SubscriptionCancellationReasonResult result;
            List<SubscriptionCancellationReason> reasons;
            ArrayList arrayList = new ArrayList();
            if (!(subscriptionCancellationReasonResponse == null || (result = subscriptionCancellationReasonResponse.getResult()) == null || (reasons = result.getReasons()) == null)) {
                for (SubscriptionCancellationReason parseFromNullable : reasons) {
                    arrayList.add(ModelMappingIntegrationKt.parseFromNullable(new SubscriptionCancellationReasonDisplayModel(), parseFromNullable));
                }
            }
            SubscriptionCancellationReasonsDisplayModel subscriptionCancellationReasonsDisplayModel = new SubscriptionCancellationReasonsDisplayModel();
            subscriptionCancellationReasonsDisplayModel.setSubscriptionCancellationReasons(arrayList);
            return subscriptionCancellationReasonsDisplayModel;
        }

        @NotNull
        public final SubscriptionPlanDisplayModel getUpSubscribedPlans(@NotNull SubscriptionDisplayModel subscriptionDisplayModel, @NotNull SubscriptionPlanDisplayModel subscriptionPlanDisplayModel) {
            Intrinsics.checkNotNullParameter(subscriptionDisplayModel, "subscriptions");
            Intrinsics.checkNotNullParameter(subscriptionPlanDisplayModel, "plans");
            HashMap hashMap = new HashMap();
            for (SubscriptionItemDisplayModel next : subscriptionPlanDisplayModel.getSubscriptionPlans()) {
                hashMap.put(next.getSubscriptionPlanItem().getId(), next);
            }
            for (SubscriptionItemDisplayModel next2 : subscriptionDisplayModel.getSubscriptions()) {
                if (hashMap.containsKey(next2.getSubscriptionPlanItem().getId())) {
                    hashMap.remove(next2.getSubscriptionPlanItem().getId());
                }
            }
            SubscriptionPlanDisplayModel subscriptionPlanDisplayModel2 = new SubscriptionPlanDisplayModel();
            Collection values = hashMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "plansMap.values");
            subscriptionPlanDisplayModel2.setSubscriptionPlans(CollectionsKt___CollectionsKt.toList(values));
            return subscriptionPlanDisplayModel2;
        }

        @NotNull
        public final String mapCountryToISOValue(int i11) {
            if (i11 == Country.BAHRAIN.getCountryId()) {
                return SubscriptionCountryCode.BHR_ISO_CODE.getValue();
            }
            if (i11 == Country.KUWAIT.getCountryId()) {
                return SubscriptionCountryCode.KWT_ISO_CODE.getValue();
            }
            if (i11 == Country.UAE.getCountryId()) {
                return SubscriptionCountryCode.UAE_ISO_CODE.getValue();
            }
            if (i11 == Country.KSA.getCountryId()) {
                return SubscriptionCountryCode.KSA_ISO_CODE.getValue();
            }
            if (i11 == Country.LEBANON.getCountryId()) {
                return SubscriptionCountryCode.LBN_ISO_CODE.getValue();
            }
            if (i11 == Country.QATAR.getCountryId()) {
                return SubscriptionCountryCode.QAT_ISO_CODE.getValue();
            }
            if (i11 == Country.JORDAN.getCountryId()) {
                return SubscriptionCountryCode.JOR_ISO_CODE.getValue();
            }
            if (i11 == Country.EGYPT.getCountryId()) {
                return SubscriptionCountryCode.EGP_ISO_CODE.getValue();
            }
            if (i11 == Country.OMAN.getCountryId()) {
                return SubscriptionCountryCode.OMN_ISO_CODE.getValue();
            }
            return StringUtils.empty(StringCompanionObject.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b9, code lost:
            if (r8 != null) goto L_0x00c1;
         */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionPlanDisplayModel mapPlanResponseToDisplayModel(@org.jetbrains.annotations.Nullable com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanRootResponse r8, @org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository r9) {
            /*
                r7 = this;
                java.lang.String r0 = "subscriptionsFeatureFlag"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                boolean r9 = r9.isTproSubscriptionEnabled()
                com.talabat.talabatcommon.feature.TalabatCommonUrlConstants$Companion r0 = com.talabat.talabatcommon.feature.TalabatCommonUrlConstants.Companion
                com.talabat.core.buildconfig.TalabatEnvironment r1 = com.talabat.core.buildconfig.TalabatEnvironment.INSTANCE
                java.lang.String r1 = r1.getEnvironment()
                java.lang.String r2 = "release"
                java.lang.String r0 = r0.getProSubscriptionProductId(r2, r1)
                r1 = 1
                if (r8 == 0) goto L_0x00bc
                com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanResponseResult r8 = r8.getResult()
                if (r8 == 0) goto L_0x00bc
                java.util.List r8 = r8.getSubscriptionPlans()
                if (r8 == 0) goto L_0x00bc
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r8 = r8.iterator()
            L_0x0031:
                boolean r3 = r8.hasNext()
                if (r3 == 0) goto L_0x007d
                java.lang.Object r3 = r8.next()
                r4 = r3
                com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanResponseModel r4 = (com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanResponseModel) r4
                java.util.List r4 = r4.getProducts()
                r5 = 0
                if (r4 == 0) goto L_0x0071
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                boolean r6 = r4 instanceof java.util.Collection
                if (r6 == 0) goto L_0x0055
                r6 = r4
                java.util.Collection r6 = (java.util.Collection) r6
                boolean r6 = r6.isEmpty()
                if (r6 == 0) goto L_0x0055
                goto L_0x0071
            L_0x0055:
                java.util.Iterator r4 = r4.iterator()
            L_0x0059:
                boolean r6 = r4.hasNext()
                if (r6 == 0) goto L_0x0071
                java.lang.Object r6 = r4.next()
                com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionProduct r6 = (com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionProduct) r6
                java.lang.String r6 = r6.getId()
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
                if (r6 == 0) goto L_0x0059
                r4 = r5
                goto L_0x0072
            L_0x0071:
                r4 = r1
            L_0x0072:
                if (r4 != 0) goto L_0x0076
                if (r9 == 0) goto L_0x0077
            L_0x0076:
                r5 = r1
            L_0x0077:
                if (r5 == 0) goto L_0x0031
                r2.add(r3)
                goto L_0x0031
            L_0x007d:
                java.util.ArrayList r8 = new java.util.ArrayList
                r9 = 10
                int r9 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r2, r9)
                r8.<init>(r9)
                java.util.Iterator r9 = r2.iterator()
            L_0x008c:
                boolean r0 = r9.hasNext()
                if (r0 == 0) goto L_0x00b5
                java.lang.Object r0 = r9.next()
                com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanResponseModel r0 = (com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanResponseModel) r0
                com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionItemDisplayModel r2 = new com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionItemDisplayModel
                r2.<init>()
                java.lang.Boolean r3 = r0.getActiveSubscription()
                boolean r3 = com.talabat.talabatcommon.extentions.BooleanKt.orFalse((java.lang.Boolean) r3)
                r2.setActive(r3)
                com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapper$Companion r3 = com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapper.Companion
                com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionPlanItemDisplayModel r0 = r3.mapPlanToSubscriptionItemDisplayModel(r0)
                r2.setSubscriptionPlanItem(r0)
                r8.add(r2)
                goto L_0x008c
            L_0x00b5:
                java.util.List r8 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r8)
                if (r8 == 0) goto L_0x00bc
                goto L_0x00c1
            L_0x00bc:
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
            L_0x00c1:
                com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionPlanDisplayModel r9 = new com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionPlanDisplayModel
                r9.<init>()
                r9.setServiceCompleted(r1)
                r9.setSubscriptionPlans(r8)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapper.Companion.mapPlanResponseToDisplayModel(com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanRootResponse, com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository):com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionPlanDisplayModel");
        }

        @NotNull
        public final SubscriptionPlanItemDisplayModel mapPlanToSubscriptionItemDisplayModel(@Nullable SubscriptionPlanResponseModel subscriptionPlanResponseModel) {
            if (subscriptionPlanResponseModel == null) {
                return new SubscriptionPlanItemDisplayModel();
            }
            SubscriptionPlanItemDisplayModel subscriptionPlanItemDisplayModel = new SubscriptionPlanItemDisplayModel();
            subscriptionPlanItemDisplayModel.setActiveSubscription(BooleanKt.orFalse(subscriptionPlanResponseModel.getActiveSubscription()));
            subscriptionPlanItemDisplayModel.setAmount(FloatKt.orZero(subscriptionPlanResponseModel.getAmount()));
            String category = subscriptionPlanResponseModel.getCategory();
            String str = "";
            if (category == null) {
                category = str;
            }
            subscriptionPlanItemDisplayModel.setCategory(category);
            String country = subscriptionPlanResponseModel.getCountry();
            if (country == null) {
                country = str;
            }
            subscriptionPlanItemDisplayModel.setCountry(country);
            String currency = subscriptionPlanResponseModel.getCurrency();
            if (currency == null) {
                currency = str;
            }
            subscriptionPlanItemDisplayModel.setCurrency(currency);
            String description = subscriptionPlanResponseModel.getDescription();
            if (description == null) {
                description = str;
            }
            subscriptionPlanItemDisplayModel.setDescription(description);
            subscriptionPlanItemDisplayModel.setDurationDays(IntKt.orZero(subscriptionPlanResponseModel.getDurationDays()));
            subscriptionPlanItemDisplayModel.setFreeTrialDays(IntKt.orZero(subscriptionPlanResponseModel.getFreeTrialDays()));
            String freeTrialTitle = subscriptionPlanResponseModel.getFreeTrialTitle();
            if (freeTrialTitle == null) {
                freeTrialTitle = str;
            }
            subscriptionPlanItemDisplayModel.setFreeTrialTitle(freeTrialTitle);
            String imageUrl = subscriptionPlanResponseModel.getImageUrl();
            if (imageUrl == null) {
                imageUrl = str;
            }
            subscriptionPlanItemDisplayModel.setImageUrl(imageUrl);
            String termsUrl = subscriptionPlanResponseModel.getTermsUrl();
            if (termsUrl == null) {
                termsUrl = str;
            }
            subscriptionPlanItemDisplayModel.setTermsUrl(termsUrl);
            String id2 = subscriptionPlanResponseModel.getId();
            if (id2 == null) {
                id2 = str;
            }
            subscriptionPlanItemDisplayModel.setId(id2);
            String title = subscriptionPlanResponseModel.getTitle();
            if (title == null) {
                title = str;
            }
            subscriptionPlanItemDisplayModel.setTitle(title);
            subscriptionPlanItemDisplayModel.setFreeTrialEligible(BooleanKt.orFalse(subscriptionPlanResponseModel.getFreeTrialEligible()));
            String onBoardingLink = subscriptionPlanResponseModel.getOnBoardingLink();
            if (onBoardingLink != null) {
                str = onBoardingLink;
            }
            subscriptionPlanItemDisplayModel.setOnBoardingLink(str);
            subscriptionPlanItemDisplayModel.setProducts(WalletSubscriptionMapper.Companion.mapSubscriptionProductList(subscriptionPlanResponseModel.getProducts()));
            return subscriptionPlanItemDisplayModel;
        }

        @NotNull
        public final SubscriptionDefaultCardDisplayModel mapSubscriptionDefaultCardToDisplayModel(@Nullable SubscriptionDefaultCardRootResponse subscriptionDefaultCardRootResponse) {
            SubscriptionDefaultCardResponseModel result;
            if (subscriptionDefaultCardRootResponse == null || (result = subscriptionDefaultCardRootResponse.getResult()) == null) {
                return new SubscriptionDefaultCardDisplayModel((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
            }
            return (SubscriptionDefaultCardDisplayModel) ModelMappingIntegrationKt.parseFrom(new SubscriptionDefaultCardDisplayModel((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null), result);
        }

        @NotNull
        public final SubscriptionItemDisplayModel mapSubscriptionDetailToDisplayModel(@Nullable SubscriptionDetailRootResponse subscriptionDetailRootResponse) {
            SubscriptionResponseModel result;
            if (subscriptionDetailRootResponse == null || (result = subscriptionDetailRootResponse.getResult()) == null) {
                return new SubscriptionItemDisplayModel();
            }
            SubscriptionItemDisplayModel subscriptionItemDisplayModel = new SubscriptionItemDisplayModel();
            String membershipId = result.getMembershipId();
            String str = "";
            if (membershipId == null) {
                membershipId = str;
            }
            subscriptionItemDisplayModel.setMembershipId(membershipId);
            subscriptionItemDisplayModel.setActive(BooleanKt.orFalse(result.isActive()));
            subscriptionItemDisplayModel.setAutoRenewable(BooleanKt.orFalse(result.isAutoRenewable()));
            String nextBillingDate = result.getNextBillingDate();
            if (nextBillingDate == null) {
                nextBillingDate = str;
            }
            subscriptionItemDisplayModel.setNextBillingDate(nextBillingDate);
            String endDate = result.getEndDate();
            if (endDate == null) {
                endDate = str;
            }
            subscriptionItemDisplayModel.setEndDate(endDate);
            String type = result.getType();
            if (type != null) {
                str = type;
            }
            subscriptionItemDisplayModel.setType(str);
            subscriptionItemDisplayModel.setSubscriptionPlanItem(WalletSubscriptionMapper.Companion.mapSubscriptionPlanToDisplayModel(result.getSubscriptionPlan()));
            return subscriptionItemDisplayModel;
        }

        @NotNull
        public final SubscriptionPlanItemDisplayModel mapSubscriptionPlanToDisplayModel(@Nullable SubscriptionPlanResponseModel subscriptionPlanResponseModel) {
            if (subscriptionPlanResponseModel == null) {
                return new SubscriptionPlanItemDisplayModel();
            }
            SubscriptionPlanItemDisplayModel subscriptionPlanItemDisplayModel = new SubscriptionPlanItemDisplayModel();
            String id2 = subscriptionPlanResponseModel.getId();
            String str = "";
            if (id2 == null) {
                id2 = str;
            }
            subscriptionPlanItemDisplayModel.setId(id2);
            String title = subscriptionPlanResponseModel.getTitle();
            if (title == null) {
                title = str;
            }
            subscriptionPlanItemDisplayModel.setTitle(title);
            String description = subscriptionPlanResponseModel.getDescription();
            if (description == null) {
                description = str;
            }
            subscriptionPlanItemDisplayModel.setDescription(description);
            subscriptionPlanItemDisplayModel.setAmount(FloatKt.orZero(subscriptionPlanResponseModel.getAmount()));
            String currency = subscriptionPlanResponseModel.getCurrency();
            if (currency == null) {
                currency = str;
            }
            subscriptionPlanItemDisplayModel.setCurrency(currency);
            String country = subscriptionPlanResponseModel.getCountry();
            if (country == null) {
                country = str;
            }
            subscriptionPlanItemDisplayModel.setCountry(country);
            subscriptionPlanItemDisplayModel.setDurationDays(IntKt.orZero(subscriptionPlanResponseModel.getDurationDays()));
            subscriptionPlanItemDisplayModel.setFreeTrialDays(IntKt.orZero(subscriptionPlanResponseModel.getFreeTrialDays()));
            String freeTrialTitle = subscriptionPlanResponseModel.getFreeTrialTitle();
            if (freeTrialTitle == null) {
                freeTrialTitle = str;
            }
            subscriptionPlanItemDisplayModel.setFreeTrialTitle(freeTrialTitle);
            String category = subscriptionPlanResponseModel.getCategory();
            if (category == null) {
                category = str;
            }
            subscriptionPlanItemDisplayModel.setCategory(category);
            String imageUrl = subscriptionPlanResponseModel.getImageUrl();
            if (imageUrl == null) {
                imageUrl = str;
            }
            subscriptionPlanItemDisplayModel.setImageUrl(imageUrl);
            String termsUrl = subscriptionPlanResponseModel.getTermsUrl();
            if (termsUrl == null) {
                termsUrl = str;
            }
            subscriptionPlanItemDisplayModel.setTermsUrl(termsUrl);
            subscriptionPlanItemDisplayModel.setFreeTrialEligible(BooleanKt.orFalse(subscriptionPlanResponseModel.getFreeTrialEligible()));
            subscriptionPlanItemDisplayModel.setActiveSubscription(BooleanKt.orFalse(subscriptionPlanResponseModel.getActiveSubscription()));
            String onBoardingLink = subscriptionPlanResponseModel.getOnBoardingLink();
            if (onBoardingLink != null) {
                str = onBoardingLink;
            }
            subscriptionPlanItemDisplayModel.setOnBoardingLink(str);
            subscriptionPlanItemDisplayModel.setProducts(WalletSubscriptionMapper.Companion.mapSubscriptionProductList(subscriptionPlanResponseModel.getProducts()));
            return subscriptionPlanItemDisplayModel;
        }

        @NotNull
        public final List<SubscriptionProductDisplayModel> mapSubscriptionProductList(@Nullable List<SubscriptionProduct> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SubscriptionProduct parseFrom : list) {
                    arrayList.add(ModelMappingIntegrationKt.parseFrom(new SubscriptionProductDisplayModel((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null), parseFrom));
                }
            }
            return arrayList;
        }

        @NotNull
        public final SubscriptionDisplayModel mapSubscriptionToDisplayModel(@Nullable SubscriptionRootResponse subscriptionRootResponse) {
            SubscriptionResponseResult result;
            List<SubscriptionResponseModel> subscriptions;
            String str;
            ArrayList arrayList = new ArrayList();
            boolean z11 = false;
            if (!(subscriptionRootResponse == null || (result = subscriptionRootResponse.getResult()) == null || (subscriptions = result.getSubscriptions()) == null)) {
                for (SubscriptionResponseModel next : subscriptions) {
                    SubscriptionItemDisplayModel subscriptionItemDisplayModel = new SubscriptionItemDisplayModel();
                    String membershipId = next.getMembershipId();
                    String str2 = "";
                    if (membershipId == null) {
                        membershipId = str2;
                    }
                    subscriptionItemDisplayModel.setMembershipId(membershipId);
                    subscriptionItemDisplayModel.setActive(BooleanKt.orFalse(next.isActive()));
                    subscriptionItemDisplayModel.setAutoRenewable(BooleanKt.orFalse(next.isAutoRenewable()));
                    String nextBillingDate = next.getNextBillingDate();
                    if (nextBillingDate == null) {
                        nextBillingDate = str2;
                    }
                    subscriptionItemDisplayModel.setNextBillingDate(nextBillingDate);
                    String endDate = next.getEndDate();
                    if (endDate == null) {
                        endDate = str2;
                    }
                    subscriptionItemDisplayModel.setEndDate(endDate);
                    String type = next.getType();
                    if (type != null) {
                        str2 = type;
                    }
                    subscriptionItemDisplayModel.setType(str2);
                    subscriptionItemDisplayModel.setSubscriptionPlanItem(WalletSubscriptionMapper.Companion.mapSubscriptionPlanToDisplayModel(next.getSubscriptionPlan()));
                    arrayList.add(subscriptionItemDisplayModel);
                    SubscriptionPlanResponseModel subscriptionPlan = next.getSubscriptionPlan();
                    if (subscriptionPlan != null) {
                        str = subscriptionPlan.getCategory();
                    } else {
                        str = null;
                    }
                    if (StringsKt__StringsJVMKt.equals(str, WalletSubscriptionMapperKt.BUSINESS_TO_CUSTOMER_SUBSCRIPTION_TAG, true)) {
                        z11 = true;
                    }
                }
            }
            SubscriptionDisplayModel subscriptionDisplayModel = new SubscriptionDisplayModel();
            subscriptionDisplayModel.setServiceCompleted(true);
            subscriptionDisplayModel.setSubscriptions(arrayList);
            subscriptionDisplayModel.setShouldShowChangeCardWidget(z11);
            return subscriptionDisplayModel;
        }

        @NotNull
        public final String subscriptionDurationStringMapper(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
            Intrinsics.checkNotNullParameter(str, "dayText");
            Intrinsics.checkNotNullParameter(str2, "weekText");
            Intrinsics.checkNotNullParameter(str3, "monthText");
            Intrinsics.checkNotNullParameter(str4, "yearText");
            Intrinsics.checkNotNullParameter(str5, "monthsText");
            Intrinsics.checkNotNullParameter(str6, "perText");
            if (i11 == 7) {
                return str2;
            }
            if (i11 == 30) {
                return str3;
            }
            if (i11 == 365) {
                return str4;
            }
            if (i11 % 30 == 0) {
                return str6 + " " + (i11 / 30) + " " + str5;
            }
            return str6 + " " + i11 + " " + str;
        }
    }
}
