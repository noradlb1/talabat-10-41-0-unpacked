package com.talabat.fluid.homescreen.presentation.displaymodel;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/displaymodel/TrackingType;", "", "trackingTypeList", "", "", "(Ljava/util/List;)V", "getTrackingTypeList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackingType {
    @NotNull
    private final List<String> trackingTypeList;

    public TrackingType(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "trackingTypeList");
        this.trackingTypeList = list;
    }

    public static /* synthetic */ TrackingType copy$default(TrackingType trackingType, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = trackingType.trackingTypeList;
        }
        return trackingType.copy(list);
    }

    @NotNull
    public final List<String> component1() {
        return this.trackingTypeList;
    }

    @NotNull
    public final TrackingType copy(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "trackingTypeList");
        return new TrackingType(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TrackingType) && Intrinsics.areEqual((Object) this.trackingTypeList, (Object) ((TrackingType) obj).trackingTypeList);
    }

    @NotNull
    public final List<String> getTrackingTypeList() {
        return this.trackingTypeList;
    }

    public int hashCode() {
        return this.trackingTypeList.hashCode();
    }

    @NotNull
    public String toString() {
        List<String> list = this.trackingTypeList;
        return "TrackingType(trackingTypeList=" + list + ")";
    }
}
