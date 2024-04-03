package com.talabat.feature.darkstoresscheduleddelivery.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/data/model/DeliveryDateResponse;", "", "date", "", "slots", "", "Lcom/talabat/feature/darkstoresscheduleddelivery/data/model/DeliverySlotResponse;", "(Ljava/lang/String;Ljava/util/List;)V", "getDate", "()Ljava/lang/String;", "getSlots", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-scheduled-delivery_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryDateResponse {
    @Nullable
    private final String date;
    @Nullable
    private final List<DeliverySlotResponse> slots;

    public DeliveryDateResponse(@Nullable @Json(name = "date") String str, @Nullable @Json(name = "slots") List<DeliverySlotResponse> list) {
        this.date = str;
        this.slots = list;
    }

    public static /* synthetic */ DeliveryDateResponse copy$default(DeliveryDateResponse deliveryDateResponse, String str, List<DeliverySlotResponse> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = deliveryDateResponse.date;
        }
        if ((i11 & 2) != 0) {
            list = deliveryDateResponse.slots;
        }
        return deliveryDateResponse.copy(str, list);
    }

    @Nullable
    public final String component1() {
        return this.date;
    }

    @Nullable
    public final List<DeliverySlotResponse> component2() {
        return this.slots;
    }

    @NotNull
    public final DeliveryDateResponse copy(@Nullable @Json(name = "date") String str, @Nullable @Json(name = "slots") List<DeliverySlotResponse> list) {
        return new DeliveryDateResponse(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeliveryDateResponse)) {
            return false;
        }
        DeliveryDateResponse deliveryDateResponse = (DeliveryDateResponse) obj;
        return Intrinsics.areEqual((Object) this.date, (Object) deliveryDateResponse.date) && Intrinsics.areEqual((Object) this.slots, (Object) deliveryDateResponse.slots);
    }

    @Nullable
    public final String getDate() {
        return this.date;
    }

    @Nullable
    public final List<DeliverySlotResponse> getSlots() {
        return this.slots;
    }

    public int hashCode() {
        String str = this.date;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<DeliverySlotResponse> list = this.slots;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.date;
        List<DeliverySlotResponse> list = this.slots;
        return "DeliveryDateResponse(date=" + str + ", slots=" + list + ")";
    }
}
