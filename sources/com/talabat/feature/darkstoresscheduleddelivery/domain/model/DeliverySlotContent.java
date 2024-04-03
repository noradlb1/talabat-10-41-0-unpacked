package com.talabat.feature.darkstoresscheduleddelivery.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlotContent;", "", "displayTime", "", "slotTime", "date", "", "monthOfYear", "(Ljava/lang/String;Ljava/lang/String;II)V", "getDate", "()I", "getDisplayTime", "()Ljava/lang/String;", "getMonthOfYear", "getSlotTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getLocalisedDisplayTime", "amString", "pmString", "hashCode", "toString", "com_talabat_feature_darkstores-scheduled-delivery_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliverySlotContent {
    private final int date;
    @NotNull
    private final String displayTime;
    private final int monthOfYear;
    @NotNull
    private final String slotTime;

    public DeliverySlotContent(@NotNull String str, @NotNull String str2, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "displayTime");
        Intrinsics.checkNotNullParameter(str2, "slotTime");
        this.displayTime = str;
        this.slotTime = str2;
        this.date = i11;
        this.monthOfYear = i12;
    }

    public static /* synthetic */ DeliverySlotContent copy$default(DeliverySlotContent deliverySlotContent, String str, String str2, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = deliverySlotContent.displayTime;
        }
        if ((i13 & 2) != 0) {
            str2 = deliverySlotContent.slotTime;
        }
        if ((i13 & 4) != 0) {
            i11 = deliverySlotContent.date;
        }
        if ((i13 & 8) != 0) {
            i12 = deliverySlotContent.monthOfYear;
        }
        return deliverySlotContent.copy(str, str2, i11, i12);
    }

    @NotNull
    public final String component1() {
        return this.displayTime;
    }

    @NotNull
    public final String component2() {
        return this.slotTime;
    }

    public final int component3() {
        return this.date;
    }

    public final int component4() {
        return this.monthOfYear;
    }

    @NotNull
    public final DeliverySlotContent copy(@NotNull String str, @NotNull String str2, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "displayTime");
        Intrinsics.checkNotNullParameter(str2, "slotTime");
        return new DeliverySlotContent(str, str2, i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeliverySlotContent)) {
            return false;
        }
        DeliverySlotContent deliverySlotContent = (DeliverySlotContent) obj;
        return Intrinsics.areEqual((Object) this.displayTime, (Object) deliverySlotContent.displayTime) && Intrinsics.areEqual((Object) this.slotTime, (Object) deliverySlotContent.slotTime) && this.date == deliverySlotContent.date && this.monthOfYear == deliverySlotContent.monthOfYear;
    }

    public final int getDate() {
        return this.date;
    }

    @NotNull
    public final String getDisplayTime() {
        return this.displayTime;
    }

    @NotNull
    public final String getLocalisedDisplayTime(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "amString");
        Intrinsics.checkNotNullParameter(str2, "pmString");
        return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(this.displayTime, "AM", str, false, 4, (Object) null), "PM", str2, false, 4, (Object) null);
    }

    public final int getMonthOfYear() {
        return this.monthOfYear;
    }

    @NotNull
    public final String getSlotTime() {
        return this.slotTime;
    }

    public int hashCode() {
        return (((((this.displayTime.hashCode() * 31) + this.slotTime.hashCode()) * 31) + this.date) * 31) + this.monthOfYear;
    }

    @NotNull
    public String toString() {
        String str = this.displayTime;
        String str2 = this.slotTime;
        int i11 = this.date;
        int i12 = this.monthOfYear;
        return "DeliverySlotContent(displayTime=" + str + ", slotTime=" + str2 + ", date=" + i11 + ", monthOfYear=" + i12 + ")";
    }
}
