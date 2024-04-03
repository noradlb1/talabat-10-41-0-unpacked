package com.talabat.feature.rewards.domain.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/rewards/domain/model/MissionSection;", "", "type", "", "title", "text", "deeplink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeeplink", "()Ljava/lang/String;", "getText", "getTitle", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_rewards_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionSection {
    @Nullable
    private final String deeplink;
    @Nullable
    private final String text;
    @Nullable
    private final String title;
    @Nullable
    private final String type;

    public MissionSection() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public MissionSection(@Nullable @Json(name = "type") String str, @Nullable @Json(name = "title") String str2, @Nullable @Json(name = "text") String str3, @Nullable @Json(name = "deeplink") String str4) {
        this.type = str;
        this.title = str2;
        this.text = str3;
        this.deeplink = str4;
    }

    public static /* synthetic */ MissionSection copy$default(MissionSection missionSection, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = missionSection.type;
        }
        if ((i11 & 2) != 0) {
            str2 = missionSection.title;
        }
        if ((i11 & 4) != 0) {
            str3 = missionSection.text;
        }
        if ((i11 & 8) != 0) {
            str4 = missionSection.deeplink;
        }
        return missionSection.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.text;
    }

    @Nullable
    public final String component4() {
        return this.deeplink;
    }

    @NotNull
    public final MissionSection copy(@Nullable @Json(name = "type") String str, @Nullable @Json(name = "title") String str2, @Nullable @Json(name = "text") String str3, @Nullable @Json(name = "deeplink") String str4) {
        return new MissionSection(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MissionSection)) {
            return false;
        }
        MissionSection missionSection = (MissionSection) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) missionSection.type) && Intrinsics.areEqual((Object) this.title, (Object) missionSection.title) && Intrinsics.areEqual((Object) this.text, (Object) missionSection.text) && Intrinsics.areEqual((Object) this.deeplink, (Object) missionSection.deeplink);
    }

    @Nullable
    public final String getDeeplink() {
        return this.deeplink;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.text;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.deeplink;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.type;
        String str2 = this.title;
        String str3 = this.text;
        String str4 = this.deeplink;
        return "MissionSection(type=" + str + ", title=" + str2 + ", text=" + str3 + ", deeplink=" + str4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MissionSection(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4);
    }
}
