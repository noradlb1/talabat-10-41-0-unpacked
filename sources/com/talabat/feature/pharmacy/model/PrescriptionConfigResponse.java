package com.talabat.feature.pharmacy.model;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/pharmacy/model/PrescriptionConfigResponse;", "Ljava/io/Serializable;", "allowedAreaId", "", "", "(Ljava/util/List;)V", "getAllowedAreaId", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_feature_pharmacy_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrescriptionConfigResponse implements Serializable {
    @NotNull
    private final List<Integer> allowedAreaId;

    public PrescriptionConfigResponse(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "allowedAreaId");
        this.allowedAreaId = list;
    }

    public static /* synthetic */ PrescriptionConfigResponse copy$default(PrescriptionConfigResponse prescriptionConfigResponse, List<Integer> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = prescriptionConfigResponse.allowedAreaId;
        }
        return prescriptionConfigResponse.copy(list);
    }

    @NotNull
    public final List<Integer> component1() {
        return this.allowedAreaId;
    }

    @NotNull
    public final PrescriptionConfigResponse copy(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "allowedAreaId");
        return new PrescriptionConfigResponse(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PrescriptionConfigResponse) && Intrinsics.areEqual((Object) this.allowedAreaId, (Object) ((PrescriptionConfigResponse) obj).allowedAreaId);
    }

    @NotNull
    public final List<Integer> getAllowedAreaId() {
        return this.allowedAreaId;
    }

    public int hashCode() {
        return this.allowedAreaId.hashCode();
    }

    @NotNull
    public String toString() {
        List<Integer> list = this.allowedAreaId;
        return "PrescriptionConfigResponse(allowedAreaId=" + list + ")";
    }
}
