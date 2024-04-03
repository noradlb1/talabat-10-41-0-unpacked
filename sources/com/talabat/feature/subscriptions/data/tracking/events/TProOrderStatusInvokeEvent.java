package com.talabat.feature.subscriptions.data.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/subscriptions/data/tracking/events/TProOrderStatusInvokeEvent;", "Lcom/talabat/feature/subscriptions/data/tracking/events/TProEvent;", "isUserPro", "", "isSubscribeAtCheckout", "subscriptionId", "", "isFreeDeliveryEligibleVendor", "isVendorPro", "vendorId", "branchId", "branchName", "isPickUp", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOrderStatusInvokeEvent extends TProEvent {
    @Nullable
    private final String branchId;
    @Nullable
    private final String branchName;
    @Nullable
    private final Boolean isFreeDeliveryEligibleVendor;
    @Nullable
    private final Boolean isPickUp;
    @Nullable
    private final Boolean isSubscribeAtCheckout;
    @Nullable
    private final Boolean isUserPro;
    @Nullable
    private final Boolean isVendorPro;
    @Nullable
    private final String subscriptionId;
    @Nullable
    private final String vendorId;

    public TProOrderStatusInvokeEvent(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool5) {
        this.isUserPro = bool;
        this.isSubscribeAtCheckout = bool2;
        this.subscriptionId = str;
        this.isFreeDeliveryEligibleVendor = bool3;
        this.isVendorPro = bool4;
        this.vendorId = str2;
        this.branchId = str3;
        this.branchName = str4;
        this.isPickUp = bool5;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[10];
        pairArr[0] = TuplesKt.to("dataPointName", "GetTProOrderStatusUseCase -> Invoke");
        Object obj = this.isUserPro;
        Object obj2 = "null";
        if (obj == null) {
            obj = obj2;
        }
        pairArr[1] = TuplesKt.to("isUserPro", obj);
        Object obj3 = this.isSubscribeAtCheckout;
        if (obj3 == null) {
            obj3 = obj2;
        }
        pairArr[2] = TuplesKt.to("isSubscribeAtCheckout", obj3);
        Object obj4 = this.subscriptionId;
        if (obj4 == null) {
            obj4 = obj2;
        }
        pairArr[3] = TuplesKt.to("subscriptionId", obj4);
        Object obj5 = this.isVendorPro;
        if (obj5 == null) {
            obj5 = obj2;
        }
        pairArr[4] = TuplesKt.to("isVendorPro", obj5);
        Object obj6 = this.vendorId;
        if (obj6 == null) {
            obj6 = obj2;
        }
        pairArr[5] = TuplesKt.to("vendorId", obj6);
        Object obj7 = this.branchId;
        if (obj7 == null) {
            obj7 = obj2;
        }
        pairArr[6] = TuplesKt.to("branchId", obj7);
        Object obj8 = this.branchName;
        if (obj8 == null) {
            obj8 = obj2;
        }
        pairArr[7] = TuplesKt.to("branchName", obj8);
        Object obj9 = this.isPickUp;
        if (obj9 == null) {
            obj9 = obj2;
        }
        pairArr[8] = TuplesKt.to("isPickUp", obj9);
        Object obj10 = this.isFreeDeliveryEligibleVendor;
        if (obj10 != null) {
            obj2 = obj10;
        }
        pairArr[9] = TuplesKt.to("isFreeDeliveryEligibleVendor", obj2);
        return MapsKt__MapsKt.mutableMapOf(pairArr);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "tpro";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "tpro_order_status";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.NEW_RELIC);
    }
}
