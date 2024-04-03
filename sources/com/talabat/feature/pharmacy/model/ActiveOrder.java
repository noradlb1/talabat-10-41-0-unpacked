package com.talabat.feature.pharmacy.model;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/pharmacy/model/ActiveOrder;", "Ljava/io/Serializable;", "eta", "", "status", "address", "Lcom/talabat/feature/pharmacy/model/ActiveOrderAddress;", "prescriptionOrderId", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/pharmacy/model/ActiveOrderAddress;Ljava/lang/String;)V", "getAddress", "()Lcom/talabat/feature/pharmacy/model/ActiveOrderAddress;", "getEta", "()Ljava/lang/String;", "getPrescriptionOrderId", "getStatus", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toMap", "", "toString", "com_talabat_feature_pharmacy_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActiveOrder implements Serializable {
    @NotNull
    private final ActiveOrderAddress address;
    @NotNull
    private final String eta;
    @NotNull
    private final String prescriptionOrderId;
    @NotNull
    private final String status;

    public ActiveOrder(@NotNull String str, @NotNull String str2, @NotNull ActiveOrderAddress activeOrderAddress, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "eta");
        Intrinsics.checkNotNullParameter(str2, "status");
        Intrinsics.checkNotNullParameter(activeOrderAddress, "address");
        Intrinsics.checkNotNullParameter(str3, "prescriptionOrderId");
        this.eta = str;
        this.status = str2;
        this.address = activeOrderAddress;
        this.prescriptionOrderId = str3;
    }

    public static /* synthetic */ ActiveOrder copy$default(ActiveOrder activeOrder, String str, String str2, ActiveOrderAddress activeOrderAddress, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = activeOrder.eta;
        }
        if ((i11 & 2) != 0) {
            str2 = activeOrder.status;
        }
        if ((i11 & 4) != 0) {
            activeOrderAddress = activeOrder.address;
        }
        if ((i11 & 8) != 0) {
            str3 = activeOrder.prescriptionOrderId;
        }
        return activeOrder.copy(str, str2, activeOrderAddress, str3);
    }

    @NotNull
    public final String component1() {
        return this.eta;
    }

    @NotNull
    public final String component2() {
        return this.status;
    }

    @NotNull
    public final ActiveOrderAddress component3() {
        return this.address;
    }

    @NotNull
    public final String component4() {
        return this.prescriptionOrderId;
    }

    @NotNull
    public final ActiveOrder copy(@NotNull String str, @NotNull String str2, @NotNull ActiveOrderAddress activeOrderAddress, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "eta");
        Intrinsics.checkNotNullParameter(str2, "status");
        Intrinsics.checkNotNullParameter(activeOrderAddress, "address");
        Intrinsics.checkNotNullParameter(str3, "prescriptionOrderId");
        return new ActiveOrder(str, str2, activeOrderAddress, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveOrder)) {
            return false;
        }
        ActiveOrder activeOrder = (ActiveOrder) obj;
        return Intrinsics.areEqual((Object) this.eta, (Object) activeOrder.eta) && Intrinsics.areEqual((Object) this.status, (Object) activeOrder.status) && Intrinsics.areEqual((Object) this.address, (Object) activeOrder.address) && Intrinsics.areEqual((Object) this.prescriptionOrderId, (Object) activeOrder.prescriptionOrderId);
    }

    @NotNull
    public final ActiveOrderAddress getAddress() {
        return this.address;
    }

    @NotNull
    public final String getEta() {
        return this.eta;
    }

    @NotNull
    public final String getPrescriptionOrderId() {
        return this.prescriptionOrderId;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((this.eta.hashCode() * 31) + this.status.hashCode()) * 31) + this.address.hashCode()) * 31) + this.prescriptionOrderId.hashCode();
    }

    @NotNull
    public final Map<String, Object> toMap() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("eta", this.eta), TuplesKt.to("status", this.status), TuplesKt.to("address", this.address.toMap()), TuplesKt.to("prescriptionOrderId", this.prescriptionOrderId));
    }

    @NotNull
    public String toString() {
        String str = this.eta;
        String str2 = this.status;
        ActiveOrderAddress activeOrderAddress = this.address;
        String str3 = this.prescriptionOrderId;
        return "ActiveOrder(eta=" + str + ", status=" + str2 + ", address=" + activeOrderAddress + ", prescriptionOrderId=" + str3 + ")";
    }
}
