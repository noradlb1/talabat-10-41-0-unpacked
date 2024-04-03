package com.talabat.feature.darkstoresscheduleddelivery.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliveryDate;", "", "date", "", "slots", "", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlot;", "(Ljava/lang/String;Ljava/util/List;)V", "getDate", "()Ljava/lang/String;", "getSlots", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-scheduled-delivery_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryDate {
    @NotNull
    private final String date;
    @NotNull
    private final List<DeliverySlot> slots;

    public DeliveryDate(@NotNull String str, @NotNull List<DeliverySlot> list) {
        Intrinsics.checkNotNullParameter(str, "date");
        Intrinsics.checkNotNullParameter(list, "slots");
        this.date = str;
        this.slots = list;
    }

    public static /* synthetic */ DeliveryDate copy$default(DeliveryDate deliveryDate, String str, List<DeliverySlot> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = deliveryDate.date;
        }
        if ((i11 & 2) != 0) {
            list = deliveryDate.slots;
        }
        return deliveryDate.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.date;
    }

    @NotNull
    public final List<DeliverySlot> component2() {
        return this.slots;
    }

    @NotNull
    public final DeliveryDate copy(@NotNull String str, @NotNull List<DeliverySlot> list) {
        Intrinsics.checkNotNullParameter(str, "date");
        Intrinsics.checkNotNullParameter(list, "slots");
        return new DeliveryDate(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeliveryDate)) {
            return false;
        }
        DeliveryDate deliveryDate = (DeliveryDate) obj;
        return Intrinsics.areEqual((Object) this.date, (Object) deliveryDate.date) && Intrinsics.areEqual((Object) this.slots, (Object) deliveryDate.slots);
    }

    @NotNull
    public final String getDate() {
        return this.date;
    }

    @NotNull
    public final List<DeliverySlot> getSlots() {
        return this.slots;
    }

    public int hashCode() {
        return (this.date.hashCode() * 31) + this.slots.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.date;
        List<DeliverySlot> list = this.slots;
        return "DeliveryDate(date=" + str + ", slots=" + list + ")";
    }
}
