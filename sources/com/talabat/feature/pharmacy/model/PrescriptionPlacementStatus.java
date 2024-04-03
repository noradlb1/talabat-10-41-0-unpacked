package com.talabat.feature.pharmacy.model;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u001aJ\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/pharmacy/model/PrescriptionPlacementStatus;", "Ljava/io/Serializable;", "enabled", "", "disabledTitle", "", "disabledSubtitle", "timeStartAndEnd", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisabledSubtitle", "()Ljava/lang/String;", "getDisabledTitle", "getEnabled", "()Z", "getTimeStartAndEnd", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toMap", "", "toString", "com_talabat_feature_pharmacy_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrescriptionPlacementStatus implements Serializable {
    @NotNull
    private final String disabledSubtitle;
    @NotNull
    private final String disabledTitle;
    private final boolean enabled;
    @NotNull
    private final String timeStartAndEnd;

    public PrescriptionPlacementStatus(boolean z11, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "disabledTitle");
        Intrinsics.checkNotNullParameter(str2, "disabledSubtitle");
        Intrinsics.checkNotNullParameter(str3, "timeStartAndEnd");
        this.enabled = z11;
        this.disabledTitle = str;
        this.disabledSubtitle = str2;
        this.timeStartAndEnd = str3;
    }

    public static /* synthetic */ PrescriptionPlacementStatus copy$default(PrescriptionPlacementStatus prescriptionPlacementStatus, boolean z11, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = prescriptionPlacementStatus.enabled;
        }
        if ((i11 & 2) != 0) {
            str = prescriptionPlacementStatus.disabledTitle;
        }
        if ((i11 & 4) != 0) {
            str2 = prescriptionPlacementStatus.disabledSubtitle;
        }
        if ((i11 & 8) != 0) {
            str3 = prescriptionPlacementStatus.timeStartAndEnd;
        }
        return prescriptionPlacementStatus.copy(z11, str, str2, str3);
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
    public final PrescriptionPlacementStatus copy(boolean z11, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "disabledTitle");
        Intrinsics.checkNotNullParameter(str2, "disabledSubtitle");
        Intrinsics.checkNotNullParameter(str3, "timeStartAndEnd");
        return new PrescriptionPlacementStatus(z11, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrescriptionPlacementStatus)) {
            return false;
        }
        PrescriptionPlacementStatus prescriptionPlacementStatus = (PrescriptionPlacementStatus) obj;
        return this.enabled == prescriptionPlacementStatus.enabled && Intrinsics.areEqual((Object) this.disabledTitle, (Object) prescriptionPlacementStatus.disabledTitle) && Intrinsics.areEqual((Object) this.disabledSubtitle, (Object) prescriptionPlacementStatus.disabledSubtitle) && Intrinsics.areEqual((Object) this.timeStartAndEnd, (Object) prescriptionPlacementStatus.timeStartAndEnd);
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
    public final Map<String, Object> toMap() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("enabled", Boolean.valueOf(this.enabled)), TuplesKt.to("disabledTitle", this.disabledTitle), TuplesKt.to("disabledSubtitle", this.disabledSubtitle), TuplesKt.to("timeStartAndEnd", this.timeStartAndEnd));
    }

    @NotNull
    public String toString() {
        boolean z11 = this.enabled;
        String str = this.disabledTitle;
        String str2 = this.disabledSubtitle;
        String str3 = this.timeStartAndEnd;
        return "PrescriptionPlacementStatus(enabled=" + z11 + ", disabledTitle=" + str + ", disabledSubtitle=" + str2 + ", timeStartAndEnd=" + str3 + ")";
    }
}
