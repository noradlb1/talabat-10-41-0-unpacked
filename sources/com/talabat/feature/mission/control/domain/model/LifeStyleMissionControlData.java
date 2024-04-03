package com.talabat.feature.mission.control.domain.model;

import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/mission/control/domain/model/LifeStyleMissionControlData;", "", "bgColor", "", "code", "imageUrl", "name", "text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBgColor", "()Ljava/lang/String;", "getCode", "getImageUrl", "getName", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_mission-control_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifeStyleMissionControlData {
    @NotNull
    private final String bgColor;
    @NotNull
    private final String code;
    @NotNull
    private final String imageUrl;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58583name;
    @NotNull
    private final String text;

    public LifeStyleMissionControlData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "bgColor");
        Intrinsics.checkNotNullParameter(str2, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str3, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str4, "name");
        Intrinsics.checkNotNullParameter(str5, "text");
        this.bgColor = str;
        this.code = str2;
        this.imageUrl = str3;
        this.f58583name = str4;
        this.text = str5;
    }

    public static /* synthetic */ LifeStyleMissionControlData copy$default(LifeStyleMissionControlData lifeStyleMissionControlData, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = lifeStyleMissionControlData.bgColor;
        }
        if ((i11 & 2) != 0) {
            str2 = lifeStyleMissionControlData.code;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = lifeStyleMissionControlData.imageUrl;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = lifeStyleMissionControlData.f58583name;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = lifeStyleMissionControlData.text;
        }
        return lifeStyleMissionControlData.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.bgColor;
    }

    @NotNull
    public final String component2() {
        return this.code;
    }

    @NotNull
    public final String component3() {
        return this.imageUrl;
    }

    @NotNull
    public final String component4() {
        return this.f58583name;
    }

    @NotNull
    public final String component5() {
        return this.text;
    }

    @NotNull
    public final LifeStyleMissionControlData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "bgColor");
        Intrinsics.checkNotNullParameter(str2, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str3, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str4, "name");
        Intrinsics.checkNotNullParameter(str5, "text");
        return new LifeStyleMissionControlData(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LifeStyleMissionControlData)) {
            return false;
        }
        LifeStyleMissionControlData lifeStyleMissionControlData = (LifeStyleMissionControlData) obj;
        return Intrinsics.areEqual((Object) this.bgColor, (Object) lifeStyleMissionControlData.bgColor) && Intrinsics.areEqual((Object) this.code, (Object) lifeStyleMissionControlData.code) && Intrinsics.areEqual((Object) this.imageUrl, (Object) lifeStyleMissionControlData.imageUrl) && Intrinsics.areEqual((Object) this.f58583name, (Object) lifeStyleMissionControlData.f58583name) && Intrinsics.areEqual((Object) this.text, (Object) lifeStyleMissionControlData.text);
    }

    @NotNull
    public final String getBgColor() {
        return this.bgColor;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getName() {
        return this.f58583name;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((((((this.bgColor.hashCode() * 31) + this.code.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.f58583name.hashCode()) * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.bgColor;
        String str2 = this.code;
        String str3 = this.imageUrl;
        String str4 = this.f58583name;
        String str5 = this.text;
        return "LifeStyleMissionControlData(bgColor=" + str + ", code=" + str2 + ", imageUrl=" + str3 + ", name=" + str4 + ", text=" + str5 + ")";
    }
}
