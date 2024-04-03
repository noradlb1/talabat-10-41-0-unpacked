package com.talabat.feature.mission.control.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/mission/control/data/remote/model/LifeStyleMissionControlResponseData;", "", "bgColor", "", "code", "imageUrl", "name", "text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBgColor", "()Ljava/lang/String;", "getCode", "getImageUrl", "getName", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_mission-control_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifeStyleMissionControlResponseData {
    @Nullable
    private final String bgColor;
    @Nullable
    private final String code;
    @Nullable
    private final String imageUrl;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f58581name;
    @Nullable
    private final String text;

    public LifeStyleMissionControlResponseData(@Nullable @Json(name = "bg_color") String str, @Nullable @Json(name = "code") String str2, @Nullable @Json(name = "image_url") String str3, @Nullable @Json(name = "name") String str4, @Nullable @Json(name = "text") String str5) {
        this.bgColor = str;
        this.code = str2;
        this.imageUrl = str3;
        this.f58581name = str4;
        this.text = str5;
    }

    public static /* synthetic */ LifeStyleMissionControlResponseData copy$default(LifeStyleMissionControlResponseData lifeStyleMissionControlResponseData, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = lifeStyleMissionControlResponseData.bgColor;
        }
        if ((i11 & 2) != 0) {
            str2 = lifeStyleMissionControlResponseData.code;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = lifeStyleMissionControlResponseData.imageUrl;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = lifeStyleMissionControlResponseData.f58581name;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = lifeStyleMissionControlResponseData.text;
        }
        return lifeStyleMissionControlResponseData.copy(str, str6, str7, str8, str5);
    }

    @Nullable
    public final String component1() {
        return this.bgColor;
    }

    @Nullable
    public final String component2() {
        return this.code;
    }

    @Nullable
    public final String component3() {
        return this.imageUrl;
    }

    @Nullable
    public final String component4() {
        return this.f58581name;
    }

    @Nullable
    public final String component5() {
        return this.text;
    }

    @NotNull
    public final LifeStyleMissionControlResponseData copy(@Nullable @Json(name = "bg_color") String str, @Nullable @Json(name = "code") String str2, @Nullable @Json(name = "image_url") String str3, @Nullable @Json(name = "name") String str4, @Nullable @Json(name = "text") String str5) {
        return new LifeStyleMissionControlResponseData(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LifeStyleMissionControlResponseData)) {
            return false;
        }
        LifeStyleMissionControlResponseData lifeStyleMissionControlResponseData = (LifeStyleMissionControlResponseData) obj;
        return Intrinsics.areEqual((Object) this.bgColor, (Object) lifeStyleMissionControlResponseData.bgColor) && Intrinsics.areEqual((Object) this.code, (Object) lifeStyleMissionControlResponseData.code) && Intrinsics.areEqual((Object) this.imageUrl, (Object) lifeStyleMissionControlResponseData.imageUrl) && Intrinsics.areEqual((Object) this.f58581name, (Object) lifeStyleMissionControlResponseData.f58581name) && Intrinsics.areEqual((Object) this.text, (Object) lifeStyleMissionControlResponseData.text);
    }

    @Nullable
    public final String getBgColor() {
        return this.bgColor;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final String getName() {
        return this.f58581name;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.bgColor;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.code;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imageUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f58581name;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.text;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.bgColor;
        String str2 = this.code;
        String str3 = this.imageUrl;
        String str4 = this.f58581name;
        String str5 = this.text;
        return "LifeStyleMissionControlResponseData(bgColor=" + str + ", code=" + str2 + ", imageUrl=" + str3 + ", name=" + str4 + ", text=" + str5 + ")";
    }
}
