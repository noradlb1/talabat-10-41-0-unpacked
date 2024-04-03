package com.talabat.feature.mission.control.domain.model;

import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/mission/control/domain/model/PrimaryMissionControlData;", "", "code", "", "name", "iconType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getIconType", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_mission-control_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrimaryMissionControlData {
    @NotNull
    private final String code;
    @NotNull
    private final String iconType;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58584name;

    public PrimaryMissionControlData(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "iconType");
        this.code = str;
        this.f58584name = str2;
        this.iconType = str3;
    }

    public static /* synthetic */ PrimaryMissionControlData copy$default(PrimaryMissionControlData primaryMissionControlData, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = primaryMissionControlData.code;
        }
        if ((i11 & 2) != 0) {
            str2 = primaryMissionControlData.f58584name;
        }
        if ((i11 & 4) != 0) {
            str3 = primaryMissionControlData.iconType;
        }
        return primaryMissionControlData.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.f58584name;
    }

    @NotNull
    public final String component3() {
        return this.iconType;
    }

    @NotNull
    public final PrimaryMissionControlData copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "iconType");
        return new PrimaryMissionControlData(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrimaryMissionControlData)) {
            return false;
        }
        PrimaryMissionControlData primaryMissionControlData = (PrimaryMissionControlData) obj;
        return Intrinsics.areEqual((Object) this.code, (Object) primaryMissionControlData.code) && Intrinsics.areEqual((Object) this.f58584name, (Object) primaryMissionControlData.f58584name) && Intrinsics.areEqual((Object) this.iconType, (Object) primaryMissionControlData.iconType);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getIconType() {
        return this.iconType;
    }

    @NotNull
    public final String getName() {
        return this.f58584name;
    }

    public int hashCode() {
        return (((this.code.hashCode() * 31) + this.f58584name.hashCode()) * 31) + this.iconType.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.code;
        String str2 = this.f58584name;
        String str3 = this.iconType;
        return "PrimaryMissionControlData(code=" + str + ", name=" + str2 + ", iconType=" + str3 + ")";
    }
}
