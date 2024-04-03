package com.talabat.feature.subscriptions.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J/\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/ProCentralization;", "", "subscriptionList", "", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "isPro", "", "showPro", "(Ljava/util/List;ZZ)V", "()Z", "getShowPro", "getSubscriptionList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProCentralization {
    private final boolean isPro;
    private final boolean showPro;
    @Nullable
    private final List<Subscription> subscriptionList;

    public ProCentralization() {
        this((List) null, false, false, 7, (DefaultConstructorMarker) null);
    }

    public ProCentralization(@Nullable List<Subscription> list, boolean z11, boolean z12) {
        this.subscriptionList = list;
        this.isPro = z11;
        this.showPro = z12;
    }

    public static /* synthetic */ ProCentralization copy$default(ProCentralization proCentralization, List<Subscription> list, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = proCentralization.subscriptionList;
        }
        if ((i11 & 2) != 0) {
            z11 = proCentralization.isPro;
        }
        if ((i11 & 4) != 0) {
            z12 = proCentralization.showPro;
        }
        return proCentralization.copy(list, z11, z12);
    }

    @Nullable
    public final List<Subscription> component1() {
        return this.subscriptionList;
    }

    public final boolean component2() {
        return this.isPro;
    }

    public final boolean component3() {
        return this.showPro;
    }

    @NotNull
    public final ProCentralization copy(@Nullable List<Subscription> list, boolean z11, boolean z12) {
        return new ProCentralization(list, z11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProCentralization)) {
            return false;
        }
        ProCentralization proCentralization = (ProCentralization) obj;
        return Intrinsics.areEqual((Object) this.subscriptionList, (Object) proCentralization.subscriptionList) && this.isPro == proCentralization.isPro && this.showPro == proCentralization.showPro;
    }

    public final boolean getShowPro() {
        return this.showPro;
    }

    @Nullable
    public final List<Subscription> getSubscriptionList() {
        return this.subscriptionList;
    }

    public int hashCode() {
        List<Subscription> list = this.subscriptionList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        boolean z11 = this.isPro;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.showPro;
        if (!z13) {
            z12 = z13;
        }
        return i11 + (z12 ? 1 : 0);
    }

    public final boolean isPro() {
        return this.isPro;
    }

    @NotNull
    public String toString() {
        List<Subscription> list = this.subscriptionList;
        boolean z11 = this.isPro;
        boolean z12 = this.showPro;
        return "ProCentralization(subscriptionList=" + list + ", isPro=" + z11 + ", showPro=" + z12 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProCentralization(List list, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? false : z12);
    }
}
