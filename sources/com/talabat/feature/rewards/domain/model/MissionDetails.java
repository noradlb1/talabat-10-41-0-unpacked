package com.talabat.feature.rewards.domain.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/rewards/domain/model/MissionDetails;", "", "title", "", "image", "sections", "", "Lcom/talabat/feature/rewards/domain/model/MissionSection;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getImage", "()Ljava/lang/String;", "getSections", "()Ljava/util/List;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_rewards_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionDetails {
    @Nullable
    private final String image;
    @Nullable
    private final List<MissionSection> sections;
    @Nullable
    private final String title;

    public MissionDetails() {
        this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public MissionDetails(@Nullable @Json(name = "title") String str, @Nullable @Json(name = "image") String str2, @Nullable @Json(name = "sections") List<MissionSection> list) {
        this.title = str;
        this.image = str2;
        this.sections = list;
    }

    public static /* synthetic */ MissionDetails copy$default(MissionDetails missionDetails, String str, String str2, List<MissionSection> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = missionDetails.title;
        }
        if ((i11 & 2) != 0) {
            str2 = missionDetails.image;
        }
        if ((i11 & 4) != 0) {
            list = missionDetails.sections;
        }
        return missionDetails.copy(str, str2, list);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.image;
    }

    @Nullable
    public final List<MissionSection> component3() {
        return this.sections;
    }

    @NotNull
    public final MissionDetails copy(@Nullable @Json(name = "title") String str, @Nullable @Json(name = "image") String str2, @Nullable @Json(name = "sections") List<MissionSection> list) {
        return new MissionDetails(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MissionDetails)) {
            return false;
        }
        MissionDetails missionDetails = (MissionDetails) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) missionDetails.title) && Intrinsics.areEqual((Object) this.image, (Object) missionDetails.image) && Intrinsics.areEqual((Object) this.sections, (Object) missionDetails.sections);
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final List<MissionSection> getSections() {
        return this.sections;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.image;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<MissionSection> list = this.sections;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.image;
        List<MissionSection> list = this.sections;
        return "MissionDetails(title=" + str + ", image=" + str2 + ", sections=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MissionDetails(String str, String str2, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : list);
    }
}
