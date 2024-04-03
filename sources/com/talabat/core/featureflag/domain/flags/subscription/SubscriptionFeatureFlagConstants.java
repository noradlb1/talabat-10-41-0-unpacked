package com.talabat.core.featureflag.domain.flags.subscription;

import com.talabat.core.featureflag.domain.flags.pay.FunWithFlagFeatureCountryKey;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0012\u001a\u00020\u0004J\u001d\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/talabat/core/featureflag/domain/flags/subscription/SubscriptionFeatureFlagConstants;", "", "()V", "ANDROID_PLATFORM", "", "SHOW_TPRO_BANNER_FOR_NON_TPRO_USERS", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "getSHOW_TPRO_BANNER_FOR_NON_TPRO_USERS", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "SUBSCRIPTION", "SUBSCRIPTION_LIST", "SubscriptionFlags", "Lkotlin/Function0;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "getSubscriptionFlags", "()Lkotlin/jvm/functions/Function0;", "getAllCountriesFlag", "feature", "getSubscriptionFeatureFwfKey", "countryId", "", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "com_talabat_core_feature-flag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionFeatureFlagConstants {
    @NotNull
    private static final String ANDROID_PLATFORM = "-android-";
    @NotNull
    public static final SubscriptionFeatureFlagConstants INSTANCE = new SubscriptionFeatureFlagConstants();
    @NotNull
    private static final FWFKeyObject SHOW_TPRO_BANNER_FOR_NON_TPRO_USERS = new FWFKeyObject("show-tpro-banner-for-non-tpro-users", (FWFProjectName) null, 2, (DefaultConstructorMarker) null);
    @NotNull
    private static final String SUBSCRIPTION = "subscription";
    @NotNull
    public static final String SUBSCRIPTION_LIST = "subscriptionlist-";
    @NotNull
    private static final Function0<List<FWFKey>> SubscriptionFlags = SubscriptionFeatureFlagConstants$SubscriptionFlags$1.INSTANCE;

    private SubscriptionFeatureFlagConstants() {
    }

    @NotNull
    public final List<FWFKey> getAllCountriesFlag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "feature");
        FunWithFlagFeatureCountryKey[] values = FunWithFlagFeatureCountryKey.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (FunWithFlagFeatureCountryKey id2 : values) {
            arrayList.add(INSTANCE.getSubscriptionFeatureFwfKey(Integer.valueOf(id2.getId()), str));
        }
        return arrayList;
    }

    @NotNull
    public final FWFKeyObject getSHOW_TPRO_BANNER_FOR_NON_TPRO_USERS() {
        return SHOW_TPRO_BANNER_FOR_NON_TPRO_USERS;
    }

    @NotNull
    public final FWFKey getSubscriptionFeatureFwfKey(@Nullable Integer num, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "feature");
        String countryKey = FunWithFlagFeatureCountryKey.Companion.getCountryKey(num);
        return new FWFKeyObject("subscription-android-" + str + countryKey, (FWFProjectName) null, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final Function0<List<FWFKey>> getSubscriptionFlags() {
        return SubscriptionFlags;
    }
}
