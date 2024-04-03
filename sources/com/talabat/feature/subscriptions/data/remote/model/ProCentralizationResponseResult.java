package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ8\u0010\u0011\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0005\u0010\tR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/ProCentralizationResponseResult;", "", "subscriptionsList", "", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionResponseModel;", "isPro", "", "showPro", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowPro", "getSubscriptionsList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/talabat/feature/subscriptions/data/remote/model/ProCentralizationResponseResult;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProCentralizationResponseResult {
    @Nullable
    private final Boolean isPro;
    @Nullable
    private final Boolean showPro;
    @Nullable
    private final List<SubscriptionResponseModel> subscriptionsList;

    public ProCentralizationResponseResult() {
        this((List) null, (Boolean) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
    }

    public ProCentralizationResponseResult(@Nullable @Json(name = "subscriptions") List<SubscriptionResponseModel> list, @Nullable @Json(name = "isPro") Boolean bool, @Nullable @Json(name = "showPro") Boolean bool2) {
        this.subscriptionsList = list;
        this.isPro = bool;
        this.showPro = bool2;
    }

    public static /* synthetic */ ProCentralizationResponseResult copy$default(ProCentralizationResponseResult proCentralizationResponseResult, List<SubscriptionResponseModel> list, Boolean bool, Boolean bool2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = proCentralizationResponseResult.subscriptionsList;
        }
        if ((i11 & 2) != 0) {
            bool = proCentralizationResponseResult.isPro;
        }
        if ((i11 & 4) != 0) {
            bool2 = proCentralizationResponseResult.showPro;
        }
        return proCentralizationResponseResult.copy(list, bool, bool2);
    }

    @Nullable
    public final List<SubscriptionResponseModel> component1() {
        return this.subscriptionsList;
    }

    @Nullable
    public final Boolean component2() {
        return this.isPro;
    }

    @Nullable
    public final Boolean component3() {
        return this.showPro;
    }

    @NotNull
    public final ProCentralizationResponseResult copy(@Nullable @Json(name = "subscriptions") List<SubscriptionResponseModel> list, @Nullable @Json(name = "isPro") Boolean bool, @Nullable @Json(name = "showPro") Boolean bool2) {
        return new ProCentralizationResponseResult(list, bool, bool2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProCentralizationResponseResult)) {
            return false;
        }
        ProCentralizationResponseResult proCentralizationResponseResult = (ProCentralizationResponseResult) obj;
        return Intrinsics.areEqual((Object) this.subscriptionsList, (Object) proCentralizationResponseResult.subscriptionsList) && Intrinsics.areEqual((Object) this.isPro, (Object) proCentralizationResponseResult.isPro) && Intrinsics.areEqual((Object) this.showPro, (Object) proCentralizationResponseResult.showPro);
    }

    @Nullable
    public final Boolean getShowPro() {
        return this.showPro;
    }

    @Nullable
    public final List<SubscriptionResponseModel> getSubscriptionsList() {
        return this.subscriptionsList;
    }

    public int hashCode() {
        List<SubscriptionResponseModel> list = this.subscriptionsList;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Boolean bool = this.isPro;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.showPro;
        if (bool2 != null) {
            i11 = bool2.hashCode();
        }
        return hashCode2 + i11;
    }

    @Nullable
    public final Boolean isPro() {
        return this.isPro;
    }

    @NotNull
    public String toString() {
        List<SubscriptionResponseModel> list = this.subscriptionsList;
        Boolean bool = this.isPro;
        Boolean bool2 = this.showPro;
        return "ProCentralizationResponseResult(subscriptionsList=" + list + ", isPro=" + bool + ", showPro=" + bool2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProCentralizationResponseResult(List list, Boolean bool, Boolean bool2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : bool, (i11 & 4) != 0 ? null : bool2);
    }
}
