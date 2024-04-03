package com.talabat.sdsquad.data.vendorslist.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJ:\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/response/VendorsListResult;", "", "activeEvent", "Lcom/talabat/sdsquad/data/vendorslist/response/ActiveEvent;", "vendors", "", "Lcom/talabat/sdsquad/data/vendorslist/response/Vendor;", "showCollections", "", "(Lcom/talabat/sdsquad/data/vendorslist/response/ActiveEvent;Ljava/util/List;Ljava/lang/Boolean;)V", "getActiveEvent", "()Lcom/talabat/sdsquad/data/vendorslist/response/ActiveEvent;", "getShowCollections", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVendors", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Lcom/talabat/sdsquad/data/vendorslist/response/ActiveEvent;Ljava/util/List;Ljava/lang/Boolean;)Lcom/talabat/sdsquad/data/vendorslist/response/VendorsListResult;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListResult {
    @SerializedName("active_event")
    @Nullable
    private final ActiveEvent activeEvent;
    @SerializedName("showCollections")
    @Nullable
    private final Boolean showCollections;
    @SerializedName("restaurants")
    @Nullable
    private final List<Vendor> vendors;

    public VendorsListResult(@Nullable ActiveEvent activeEvent2, @Nullable List<Vendor> list, @Nullable Boolean bool) {
        this.activeEvent = activeEvent2;
        this.vendors = list;
        this.showCollections = bool;
    }

    public static /* synthetic */ VendorsListResult copy$default(VendorsListResult vendorsListResult, ActiveEvent activeEvent2, List<Vendor> list, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            activeEvent2 = vendorsListResult.activeEvent;
        }
        if ((i11 & 2) != 0) {
            list = vendorsListResult.vendors;
        }
        if ((i11 & 4) != 0) {
            bool = vendorsListResult.showCollections;
        }
        return vendorsListResult.copy(activeEvent2, list, bool);
    }

    @Nullable
    public final ActiveEvent component1() {
        return this.activeEvent;
    }

    @Nullable
    public final List<Vendor> component2() {
        return this.vendors;
    }

    @Nullable
    public final Boolean component3() {
        return this.showCollections;
    }

    @NotNull
    public final VendorsListResult copy(@Nullable ActiveEvent activeEvent2, @Nullable List<Vendor> list, @Nullable Boolean bool) {
        return new VendorsListResult(activeEvent2, list, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorsListResult)) {
            return false;
        }
        VendorsListResult vendorsListResult = (VendorsListResult) obj;
        return Intrinsics.areEqual((Object) this.activeEvent, (Object) vendorsListResult.activeEvent) && Intrinsics.areEqual((Object) this.vendors, (Object) vendorsListResult.vendors) && Intrinsics.areEqual((Object) this.showCollections, (Object) vendorsListResult.showCollections);
    }

    @Nullable
    public final ActiveEvent getActiveEvent() {
        return this.activeEvent;
    }

    @Nullable
    public final Boolean getShowCollections() {
        return this.showCollections;
    }

    @Nullable
    public final List<Vendor> getVendors() {
        return this.vendors;
    }

    public int hashCode() {
        ActiveEvent activeEvent2 = this.activeEvent;
        int i11 = 0;
        int hashCode = (activeEvent2 == null ? 0 : activeEvent2.hashCode()) * 31;
        List<Vendor> list = this.vendors;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.showCollections;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        ActiveEvent activeEvent2 = this.activeEvent;
        List<Vendor> list = this.vendors;
        Boolean bool = this.showCollections;
        return "VendorsListResult(activeEvent=" + activeEvent2 + ", vendors=" + list + ", showCollections=" + bool + ")";
    }
}
