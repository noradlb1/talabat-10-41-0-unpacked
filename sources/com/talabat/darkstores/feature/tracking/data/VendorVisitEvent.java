package com.talabat.darkstores.feature.tracking.data;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bHÖ\u0003J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/data/VendorVisitEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "vendorVisitDetails", "Lcom/talabat/darkstores/feature/tracking/data/VendorVisitDetails;", "(Lcom/talabat/darkstores/feature/tracking/data/VendorVisitDetails;)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "platforms", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorVisitEvent extends TalabatEvent {
    @NotNull
    private final VendorVisitDetails vendorVisitDetails;

    public VendorVisitEvent(@NotNull VendorVisitDetails vendorVisitDetails2) {
        Intrinsics.checkNotNullParameter(vendorVisitDetails2, "vendorVisitDetails");
        this.vendorVisitDetails = vendorVisitDetails2;
    }

    private final VendorVisitDetails component1() {
        return this.vendorVisitDetails;
    }

    public static /* synthetic */ VendorVisitEvent copy$default(VendorVisitEvent vendorVisitEvent, VendorVisitDetails vendorVisitDetails2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            vendorVisitDetails2 = vendorVisitEvent.vendorVisitDetails;
        }
        return vendorVisitEvent.copy(vendorVisitDetails2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        VendorVisitDetails vendorVisitDetails2 = this.vendorVisitDetails;
        return MapsKt__MapsKt.mapOf(TuplesKt.to("chain_id", String.valueOf(vendorVisitDetails2.getChainId())), TuplesKt.to("chain_name", vendorVisitDetails2.getChainName()), TuplesKt.to(OPNavigatorActions.ARG_BRANCH_ID, String.valueOf(vendorVisitDetails2.getBranchId())), TuplesKt.to("branch_name", vendorVisitDetails2.getBranchName()), TuplesKt.to("vertical_type", String.valueOf(vendorVisitDetails2.getVerticalType())), TuplesKt.to("is_darkstore", String.valueOf(vendorVisitDetails2.isDarkstore())));
    }

    @NotNull
    public final VendorVisitEvent copy(@NotNull VendorVisitDetails vendorVisitDetails2) {
        Intrinsics.checkNotNullParameter(vendorVisitDetails2, "vendorVisitDetails");
        return new VendorVisitEvent(vendorVisitDetails2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VendorVisitEvent) && Intrinsics.areEqual((Object) this.vendorVisitDetails, (Object) ((VendorVisitEvent) obj).vendorVisitDetails);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores";
    }

    public int hashCode() {
        return this.vendorVisitDetails.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "vendor_visit";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.BRAZE);
    }

    @NotNull
    public String toString() {
        VendorVisitDetails vendorVisitDetails2 = this.vendorVisitDetails;
        return "VendorVisitEvent(vendorVisitDetails=" + vendorVisitDetails2 + ")";
    }
}
