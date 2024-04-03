package com.talabat.core.hms.push.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/core/hms/push/domain/model/OrderUpdate;", "", "vendorName", "", "orderStatus", "", "etaText", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getEtaText", "()Ljava/lang/String;", "getOrderStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVendorName", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/talabat/core/hms/push/domain/model/OrderUpdate;", "equals", "", "other", "hashCode", "toString", "com_talabat_core_hms_push_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderUpdate {
    @Nullable
    private final String etaText;
    @Nullable
    private final Integer orderStatus;
    @Nullable
    private final String vendorName;

    public OrderUpdate(@Nullable String str, @Nullable Integer num, @Nullable String str2) {
        this.vendorName = str;
        this.orderStatus = num;
        this.etaText = str2;
    }

    public static /* synthetic */ OrderUpdate copy$default(OrderUpdate orderUpdate, String str, Integer num, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = orderUpdate.vendorName;
        }
        if ((i11 & 2) != 0) {
            num = orderUpdate.orderStatus;
        }
        if ((i11 & 4) != 0) {
            str2 = orderUpdate.etaText;
        }
        return orderUpdate.copy(str, num, str2);
    }

    @Nullable
    public final String component1() {
        return this.vendorName;
    }

    @Nullable
    public final Integer component2() {
        return this.orderStatus;
    }

    @Nullable
    public final String component3() {
        return this.etaText;
    }

    @NotNull
    public final OrderUpdate copy(@Nullable String str, @Nullable Integer num, @Nullable String str2) {
        return new OrderUpdate(str, num, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderUpdate)) {
            return false;
        }
        OrderUpdate orderUpdate = (OrderUpdate) obj;
        return Intrinsics.areEqual((Object) this.vendorName, (Object) orderUpdate.vendorName) && Intrinsics.areEqual((Object) this.orderStatus, (Object) orderUpdate.orderStatus) && Intrinsics.areEqual((Object) this.etaText, (Object) orderUpdate.etaText);
    }

    @Nullable
    public final String getEtaText() {
        return this.etaText;
    }

    @Nullable
    public final Integer getOrderStatus() {
        return this.orderStatus;
    }

    @Nullable
    public final String getVendorName() {
        return this.vendorName;
    }

    public int hashCode() {
        String str = this.vendorName;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.orderStatus;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.etaText;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.vendorName;
        Integer num = this.orderStatus;
        String str2 = this.etaText;
        return "OrderUpdate(vendorName=" + str + ", orderStatus=" + num + ", etaText=" + str2 + ")";
    }
}
