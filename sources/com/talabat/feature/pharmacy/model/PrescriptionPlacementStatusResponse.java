package com.talabat.feature.pharmacy.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/pharmacy/model/PrescriptionPlacementStatusResponse;", "Ljava/io/Serializable;", "enabled", "", "disabledTitle", "", "disabledSubtitle", "timeStartAndEnd", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisabledSubtitle", "()Ljava/lang/String;", "getDisabledTitle", "getEnabled", "()Z", "getTimeStartAndEnd", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "com_talabat_feature_pharmacy_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrescriptionPlacementStatusResponse implements Serializable {
    @SerializedName("disabled_subtitle")
    @NotNull
    private final String disabledSubtitle;
    @SerializedName("disabled_title")
    @NotNull
    private final String disabledTitle;
    @SerializedName("enabled")
    private final boolean enabled;
    @SerializedName("time_start_and_end")
    @NotNull
    private final String timeStartAndEnd;

    public PrescriptionPlacementStatusResponse(boolean z11, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "disabledTitle");
        Intrinsics.checkNotNullParameter(str2, "disabledSubtitle");
        Intrinsics.checkNotNullParameter(str3, "timeStartAndEnd");
        this.enabled = z11;
        this.disabledTitle = str;
        this.disabledSubtitle = str2;
        this.timeStartAndEnd = str3;
    }

    public static /* synthetic */ PrescriptionPlacementStatusResponse copy$default(PrescriptionPlacementStatusResponse prescriptionPlacementStatusResponse, boolean z11, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = prescriptionPlacementStatusResponse.enabled;
        }
        if ((i11 & 2) != 0) {
            str = prescriptionPlacementStatusResponse.disabledTitle;
        }
        if ((i11 & 4) != 0) {
            str2 = prescriptionPlacementStatusResponse.disabledSubtitle;
        }
        if ((i11 & 8) != 0) {
            str3 = prescriptionPlacementStatusResponse.timeStartAndEnd;
        }
        return prescriptionPlacementStatusResponse.copy(z11, str, str2, str3);
    }

    public final boolean component1() {
        return this.enabled;
    }

    @NotNull
    public final String component2() {
        return this.disabledTitle;
    }

    @NotNull
    public final String component3() {
        return this.disabledSubtitle;
    }

    @NotNull
    public final String component4() {
        return this.timeStartAndEnd;
    }

    @NotNull
    public final PrescriptionPlacementStatusResponse copy(boolean z11, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "disabledTitle");
        Intrinsics.checkNotNullParameter(str2, "disabledSubtitle");
        Intrinsics.checkNotNullParameter(str3, "timeStartAndEnd");
        return new PrescriptionPlacementStatusResponse(z11, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrescriptionPlacementStatusResponse)) {
            return false;
        }
        PrescriptionPlacementStatusResponse prescriptionPlacementStatusResponse = (PrescriptionPlacementStatusResponse) obj;
        return this.enabled == prescriptionPlacementStatusResponse.enabled && Intrinsics.areEqual((Object) this.disabledTitle, (Object) prescriptionPlacementStatusResponse.disabledTitle) && Intrinsics.areEqual((Object) this.disabledSubtitle, (Object) prescriptionPlacementStatusResponse.disabledSubtitle) && Intrinsics.areEqual((Object) this.timeStartAndEnd, (Object) prescriptionPlacementStatusResponse.timeStartAndEnd);
    }

    @NotNull
    public final String getDisabledSubtitle() {
        return this.disabledSubtitle;
    }

    @NotNull
    public final String getDisabledTitle() {
        return this.disabledTitle;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @NotNull
    public final String getTimeStartAndEnd() {
        return this.timeStartAndEnd;
    }

    public int hashCode() {
        boolean z11 = this.enabled;
        if (z11) {
            z11 = true;
        }
        return ((((((z11 ? 1 : 0) * true) + this.disabledTitle.hashCode()) * 31) + this.disabledSubtitle.hashCode()) * 31) + this.timeStartAndEnd.hashCode();
    }

    @NotNull
    public String toString() {
        boolean z11 = this.enabled;
        String str = this.disabledTitle;
        String str2 = this.disabledSubtitle;
        String str3 = this.timeStartAndEnd;
        return "PrescriptionPlacementStatusResponse(enabled=" + z11 + ", disabledTitle=" + str + ", disabledSubtitle=" + str2 + ", timeStartAndEnd=" + str3 + ")";
    }
}
