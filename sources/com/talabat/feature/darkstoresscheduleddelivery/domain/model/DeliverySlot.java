package com.talabat.feature.darkstoresscheduleddelivery.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlot;", "", "from", "", "to", "(Ljava/lang/String;Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "getTo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-scheduled-delivery_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliverySlot {
    @NotNull
    private final String from;
    @NotNull

    /* renamed from: to  reason: collision with root package name */
    private final String f58503to;

    public DeliverySlot(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "from");
        Intrinsics.checkNotNullParameter(str2, "to");
        this.from = str;
        this.f58503to = str2;
    }

    public static /* synthetic */ DeliverySlot copy$default(DeliverySlot deliverySlot, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = deliverySlot.from;
        }
        if ((i11 & 2) != 0) {
            str2 = deliverySlot.f58503to;
        }
        return deliverySlot.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.from;
    }

    @NotNull
    public final String component2() {
        return this.f58503to;
    }

    @NotNull
    public final DeliverySlot copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "from");
        Intrinsics.checkNotNullParameter(str2, "to");
        return new DeliverySlot(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeliverySlot)) {
            return false;
        }
        DeliverySlot deliverySlot = (DeliverySlot) obj;
        return Intrinsics.areEqual((Object) this.from, (Object) deliverySlot.from) && Intrinsics.areEqual((Object) this.f58503to, (Object) deliverySlot.f58503to);
    }

    @NotNull
    public final String getFrom() {
        return this.from;
    }

    @NotNull
    public final String getTo() {
        return this.f58503to;
    }

    public int hashCode() {
        return (this.from.hashCode() * 31) + this.f58503to.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.from;
        String str2 = this.f58503to;
        return "DeliverySlot(from=" + str + ", to=" + str2 + ")";
    }
}
