package com.talabat.feature.mission.control.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/mission/control/domain/model/MissionControlRequest;", "", "variant", "", "screen", "vendorId", "isDarkstores", "", "talabatBranchId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "()Z", "getScreen", "()Ljava/lang/String;", "getTalabatBranchId", "getVariant", "getVendorId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_mission-control_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionControlRequest {
    private final boolean isDarkstores;
    @NotNull
    private final String screen;
    @NotNull
    private final String talabatBranchId;
    @NotNull
    private final String variant;
    @NotNull
    private final String vendorId;

    public MissionControlRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "variant");
        Intrinsics.checkNotNullParameter(str2, "screen");
        Intrinsics.checkNotNullParameter(str3, "vendorId");
        Intrinsics.checkNotNullParameter(str4, "talabatBranchId");
        this.variant = str;
        this.screen = str2;
        this.vendorId = str3;
        this.isDarkstores = z11;
        this.talabatBranchId = str4;
    }

    public static /* synthetic */ MissionControlRequest copy$default(MissionControlRequest missionControlRequest, String str, String str2, String str3, boolean z11, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = missionControlRequest.variant;
        }
        if ((i11 & 2) != 0) {
            str2 = missionControlRequest.screen;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = missionControlRequest.vendorId;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            z11 = missionControlRequest.isDarkstores;
        }
        boolean z12 = z11;
        if ((i11 & 16) != 0) {
            str4 = missionControlRequest.talabatBranchId;
        }
        return missionControlRequest.copy(str, str5, str6, z12, str4);
    }

    @NotNull
    public final String component1() {
        return this.variant;
    }

    @NotNull
    public final String component2() {
        return this.screen;
    }

    @NotNull
    public final String component3() {
        return this.vendorId;
    }

    public final boolean component4() {
        return this.isDarkstores;
    }

    @NotNull
    public final String component5() {
        return this.talabatBranchId;
    }

    @NotNull
    public final MissionControlRequest copy(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "variant");
        Intrinsics.checkNotNullParameter(str2, "screen");
        Intrinsics.checkNotNullParameter(str3, "vendorId");
        Intrinsics.checkNotNullParameter(str4, "talabatBranchId");
        return new MissionControlRequest(str, str2, str3, z11, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MissionControlRequest)) {
            return false;
        }
        MissionControlRequest missionControlRequest = (MissionControlRequest) obj;
        return Intrinsics.areEqual((Object) this.variant, (Object) missionControlRequest.variant) && Intrinsics.areEqual((Object) this.screen, (Object) missionControlRequest.screen) && Intrinsics.areEqual((Object) this.vendorId, (Object) missionControlRequest.vendorId) && this.isDarkstores == missionControlRequest.isDarkstores && Intrinsics.areEqual((Object) this.talabatBranchId, (Object) missionControlRequest.talabatBranchId);
    }

    @NotNull
    public final String getScreen() {
        return this.screen;
    }

    @NotNull
    public final String getTalabatBranchId() {
        return this.talabatBranchId;
    }

    @NotNull
    public final String getVariant() {
        return this.variant;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        int hashCode = ((((this.variant.hashCode() * 31) + this.screen.hashCode()) * 31) + this.vendorId.hashCode()) * 31;
        boolean z11 = this.isDarkstores;
        if (z11) {
            z11 = true;
        }
        return ((hashCode + (z11 ? 1 : 0)) * 31) + this.talabatBranchId.hashCode();
    }

    public final boolean isDarkstores() {
        return this.isDarkstores;
    }

    @NotNull
    public String toString() {
        String str = this.variant;
        String str2 = this.screen;
        String str3 = this.vendorId;
        boolean z11 = this.isDarkstores;
        String str4 = this.talabatBranchId;
        return "MissionControlRequest(variant=" + str + ", screen=" + str2 + ", vendorId=" + str3 + ", isDarkstores=" + z11 + ", talabatBranchId=" + str4 + ")";
    }
}
