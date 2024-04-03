package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPlanResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionUpgradePlanResponseModel;
import com.talabat.feature.subscriptions.domain.model.CurrencyAmount;
import com.talabat.feature.subscriptions.domain.model.FreeTrialInfo;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory;
import com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType;
import com.talabat.feature.subscriptions.domain.model.SubscriptionType;
import com.talabat.feature.subscriptions.domain.model.SubscriptionUpgradePlan;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\b\u0007\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0016H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/SubscriptionModelMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "subscriptionPlanMapper", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPlanResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlan;", "subscriptionUpgradePlanMapper", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionUpgradePlanResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionUpgradePlan;", "(Lcom/talabat/mapper/ModelMapper;Lcom/talabat/mapper/ModelMapper;)V", "apply", "source", "getLocalDateTime", "Lorg/threeten/bp/LocalDateTime;", "kotlin.jvm.PlatformType", "stringToParse", "", "mapType", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionType;", "type", "mapUpgradePlanList", "", "upgradePlans", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionModelMapper implements ModelMapper<SubscriptionResponseModel, Subscription> {
    @NotNull
    private final ModelMapper<SubscriptionPlanResponseModel, SubscriptionPlan> subscriptionPlanMapper;
    @NotNull
    private final ModelMapper<SubscriptionUpgradePlanResponseModel, SubscriptionUpgradePlan> subscriptionUpgradePlanMapper;

    @Inject
    public SubscriptionModelMapper(@NotNull ModelMapper<SubscriptionPlanResponseModel, SubscriptionPlan> modelMapper, @NotNull ModelMapper<SubscriptionUpgradePlanResponseModel, SubscriptionUpgradePlan> modelMapper2) {
        Intrinsics.checkNotNullParameter(modelMapper, "subscriptionPlanMapper");
        Intrinsics.checkNotNullParameter(modelMapper2, "subscriptionUpgradePlanMapper");
        this.subscriptionPlanMapper = modelMapper;
        this.subscriptionUpgradePlanMapper = modelMapper2;
    }

    private final LocalDateTime getLocalDateTime(String str) {
        return LocalDateTime.parse(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x000e A[Catch:{ IllegalArgumentException -> 0x0016 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0011 A[Catch:{ IllegalArgumentException -> 0x0016 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.talabat.feature.subscriptions.domain.model.SubscriptionType mapType(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x000b
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r2)     // Catch:{ IllegalArgumentException -> 0x0016 }
            if (r0 == 0) goto L_0x0009
            goto L_0x000b
        L_0x0009:
            r0 = 0
            goto L_0x000c
        L_0x000b:
            r0 = 1
        L_0x000c:
            if (r0 == 0) goto L_0x0011
            com.talabat.feature.subscriptions.domain.model.SubscriptionType r2 = com.talabat.feature.subscriptions.domain.model.SubscriptionType.Unknown     // Catch:{ IllegalArgumentException -> 0x0016 }
            goto L_0x0018
        L_0x0011:
            com.talabat.feature.subscriptions.domain.model.SubscriptionType r2 = com.talabat.feature.subscriptions.domain.model.SubscriptionType.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x0016 }
            goto L_0x0018
        L_0x0016:
            com.talabat.feature.subscriptions.domain.model.SubscriptionType r2 = com.talabat.feature.subscriptions.domain.model.SubscriptionType.Unknown
        L_0x0018:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.model.SubscriptionModelMapper.mapType(java.lang.String):com.talabat.feature.subscriptions.domain.model.SubscriptionType");
    }

    private final List<SubscriptionUpgradePlan> mapUpgradePlanList(List<SubscriptionUpgradePlanResponseModel> list) {
        Iterable<SubscriptionUpgradePlanResponseModel> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (SubscriptionUpgradePlanResponseModel apply : iterable) {
            arrayList.add(this.subscriptionUpgradePlanMapper.apply(apply));
        }
        return arrayList;
    }

    @NotNull
    public Subscription apply(@NotNull SubscriptionResponseModel subscriptionResponseModel) {
        Intrinsics.checkNotNullParameter(subscriptionResponseModel, "source");
        List<SubscriptionUpgradePlanResponseModel> upgradeablePlanInfos = subscriptionResponseModel.getUpgradeablePlanInfos();
        if (upgradeablePlanInfos == null) {
            upgradeablePlanInfos = CollectionsKt__CollectionsKt.emptyList();
        }
        String membershipId = subscriptionResponseModel.getMembershipId();
        if (membershipId == null) {
            membershipId = "";
        }
        String str = membershipId;
        Boolean isActive = subscriptionResponseModel.isActive();
        boolean booleanValue = isActive != null ? isActive.booleanValue() : false;
        Boolean isAutorenewable = subscriptionResponseModel.isAutorenewable();
        boolean booleanValue2 = isAutorenewable != null ? isAutorenewable.booleanValue() : false;
        SubscriptionType mapType = mapType(subscriptionResponseModel.getType());
        SubscriptionPlanResponseModel plan = subscriptionResponseModel.getPlan();
        LocalDateTime localDateTime = null;
        SubscriptionPlan apply = plan != null ? this.subscriptionPlanMapper.apply(plan) : null;
        SubscriptionPlan subscriptionPlan = apply == null ? new SubscriptionPlan((String) null, (String) null, (String) null, (String) null, 0, (String) null, false, 0.0f, false, (List) null, (CurrencyAmount) null, (FreeTrialInfo) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (SubscriptionPlanCategory) null, (SubscriptionCancellationType) null, (String) null, (String) null, (String) null, (String) null, (SubscriptionRenewType) null, (LocalDateTime) null, 67108863, (DefaultConstructorMarker) null) : apply;
        String nextBillingDate = subscriptionResponseModel.getNextBillingDate();
        LocalDateTime localDateTime2 = nextBillingDate != null ? getLocalDateTime(nextBillingDate) : null;
        String endDate = subscriptionResponseModel.getEndDate();
        if (endDate != null) {
            localDateTime = getLocalDateTime(endDate);
        }
        LocalDateTime localDateTime3 = localDateTime;
        Boolean isUpgradeable = subscriptionResponseModel.isUpgradeable();
        return new Subscription(str, booleanValue, booleanValue2, localDateTime2, localDateTime3, mapType, subscriptionPlan, isUpgradeable != null ? isUpgradeable.booleanValue() : false, mapUpgradePlanList(upgradeablePlanInfos));
    }
}
