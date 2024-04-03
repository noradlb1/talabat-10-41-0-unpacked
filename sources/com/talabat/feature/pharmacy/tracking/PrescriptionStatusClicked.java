package com.talabat.feature.pharmacy.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/pharmacy/tracking/PrescriptionStatusClicked;", "Lcom/talabat/feature/pharmacy/tracking/PharmacyPrescriptionsEvent;", "chainId", "", "chainName", "(Ljava/lang/String;Ljava/lang/String;)V", "getChainId", "()Ljava/lang/String;", "getChainName", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "name", "toString", "com_talabat_feature_pharmacy_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrescriptionStatusClicked extends PharmacyPrescriptionsEvent {
    @NotNull
    private final String chainId;
    @NotNull
    private final String chainName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrescriptionStatusClicked(@NotNull String str, @NotNull String str2) {
        super(str, str2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "chainId");
        Intrinsics.checkNotNullParameter(str2, "chainName");
        this.chainId = str;
        this.chainName = str2;
    }

    public static /* synthetic */ PrescriptionStatusClicked copy$default(PrescriptionStatusClicked prescriptionStatusClicked, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = prescriptionStatusClicked.chainId;
        }
        if ((i11 & 2) != 0) {
            str2 = prescriptionStatusClicked.chainName;
        }
        return prescriptionStatusClicked.copy(str, str2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.plus(super.attributes(platformName), TuplesKt.to("bannerName", "Pharmacy_vertical_status_banner"));
    }

    @NotNull
    public final String component1() {
        return this.chainId;
    }

    @NotNull
    public final String component2() {
        return this.chainName;
    }

    @NotNull
    public final PrescriptionStatusClicked copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "chainId");
        Intrinsics.checkNotNullParameter(str2, "chainName");
        return new PrescriptionStatusClicked(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrescriptionStatusClicked)) {
            return false;
        }
        PrescriptionStatusClicked prescriptionStatusClicked = (PrescriptionStatusClicked) obj;
        return Intrinsics.areEqual((Object) this.chainId, (Object) prescriptionStatusClicked.chainId) && Intrinsics.areEqual((Object) this.chainName, (Object) prescriptionStatusClicked.chainName);
    }

    @NotNull
    public final String getChainId() {
        return this.chainId;
    }

    @NotNull
    public final String getChainName() {
        return this.chainName;
    }

    public int hashCode() {
        return (this.chainId.hashCode() * 31) + this.chainName.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "order_tracking_widget_clicked";
    }

    @NotNull
    public String toString() {
        String str = this.chainId;
        String str2 = this.chainName;
        return "PrescriptionStatusClicked(chainId=" + str + ", chainName=" + str2 + ")";
    }
}
