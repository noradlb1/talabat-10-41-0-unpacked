package com.talabat.feature.mission.control.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/mission/control/data/remote/model/PrimaryMissionControlResponseData;", "", "code", "", "name", "iconType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getIconType", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_mission-control_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrimaryMissionControlResponseData {
    @Nullable
    private final String code;
    @Nullable
    private final String iconType;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f58582name;

    public PrimaryMissionControlResponseData(@Nullable @Json(name = "id") String str, @Nullable @Json(name = "name") String str2, @Nullable @Json(name = "icon_type") String str3) {
        this.code = str;
        this.f58582name = str2;
        this.iconType = str3;
    }

    public static /* synthetic */ PrimaryMissionControlResponseData copy$default(PrimaryMissionControlResponseData primaryMissionControlResponseData, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = primaryMissionControlResponseData.code;
        }
        if ((i11 & 2) != 0) {
            str2 = primaryMissionControlResponseData.f58582name;
        }
        if ((i11 & 4) != 0) {
            str3 = primaryMissionControlResponseData.iconType;
        }
        return primaryMissionControlResponseData.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.f58582name;
    }

    @Nullable
    public final String component3() {
        return this.iconType;
    }

    @NotNull
    public final PrimaryMissionControlResponseData copy(@Nullable @Json(name = "id") String str, @Nullable @Json(name = "name") String str2, @Nullable @Json(name = "icon_type") String str3) {
        return new PrimaryMissionControlResponseData(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrimaryMissionControlResponseData)) {
            return false;
        }
        PrimaryMissionControlResponseData primaryMissionControlResponseData = (PrimaryMissionControlResponseData) obj;
        return Intrinsics.areEqual((Object) this.code, (Object) primaryMissionControlResponseData.code) && Intrinsics.areEqual((Object) this.f58582name, (Object) primaryMissionControlResponseData.f58582name) && Intrinsics.areEqual((Object) this.iconType, (Object) primaryMissionControlResponseData.iconType);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getIconType() {
        return this.iconType;
    }

    @Nullable
    public final String getName() {
        return this.f58582name;
    }

    public int hashCode() {
        String str = this.code;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f58582name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconType;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.code;
        String str2 = this.f58582name;
        String str3 = this.iconType;
        return "PrimaryMissionControlResponseData(code=" + str + ", name=" + str2 + ", iconType=" + str3 + ")";
    }
}
