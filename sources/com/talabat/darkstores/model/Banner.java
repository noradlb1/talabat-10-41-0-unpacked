package com.talabat.darkstores.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\b\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0003\u0010\n\u001a\u00020\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010+\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0007HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0010\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00061"}, d2 = {"Lcom/talabat/darkstores/model/Banner;", "", "globalId", "", "name", "bannerUrl", "position", "", "targetAudience", "Lcom/talabat/darkstores/model/TargetAudienceType;", "isStatic", "", "description", "tracking", "Lcom/talabat/feature/darkstorescart/data/model/Tracking;", "campaignEndTime", "isSponsored", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/talabat/darkstores/model/TargetAudienceType;ZLjava/lang/String;Lcom/talabat/feature/darkstorescart/data/model/Tracking;Ljava/lang/String;Ljava/lang/Boolean;)V", "getBannerUrl", "()Ljava/lang/String;", "getCampaignEndTime", "getDescription", "getGlobalId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()Z", "getName", "getPosition", "()I", "getTargetAudience", "()Lcom/talabat/darkstores/model/TargetAudienceType;", "getTracking", "()Lcom/talabat/feature/darkstorescart/data/model/Tracking;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/talabat/darkstores/model/TargetAudienceType;ZLjava/lang/String;Lcom/talabat/feature/darkstorescart/data/model/Tracking;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/darkstores/model/Banner;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Banner {
    @NotNull
    private final String bannerUrl;
    @Nullable
    private final String campaignEndTime;
    @Nullable
    private final String description;
    @NotNull
    private final String globalId;
    @Nullable
    private final Boolean isSponsored;
    private final boolean isStatic;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f56634name;
    private final int position;
    @NotNull
    private final TargetAudienceType targetAudience;
    @Nullable

    /* renamed from: tracking  reason: collision with root package name */
    private final Tracking f56635tracking;

    public Banner(@NotNull @Json(name = "global_id") String str, @NotNull String str2, @NotNull @Json(name = "banner_url") String str3, int i11, @NotNull @Json(name = "target_audience") TargetAudienceType targetAudienceType, @Json(name = "is_static") boolean z11, @Nullable @Json(name = "description") String str4, @Nullable @Json(name = "tracking") Tracking tracking2, @Nullable @Json(name = "campaign_end_time") String str5, @Nullable @Json(name = "is_sponsored") Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "globalId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "bannerUrl");
        Intrinsics.checkNotNullParameter(targetAudienceType, "targetAudience");
        this.globalId = str;
        this.f56634name = str2;
        this.bannerUrl = str3;
        this.position = i11;
        this.targetAudience = targetAudienceType;
        this.isStatic = z11;
        this.description = str4;
        this.f56635tracking = tracking2;
        this.campaignEndTime = str5;
        this.isSponsored = bool;
    }

    public static /* synthetic */ Banner copy$default(Banner banner, String str, String str2, String str3, int i11, TargetAudienceType targetAudienceType, boolean z11, String str4, Tracking tracking2, String str5, Boolean bool, int i12, Object obj) {
        Banner banner2 = banner;
        int i13 = i12;
        return banner.copy((i13 & 1) != 0 ? banner2.globalId : str, (i13 & 2) != 0 ? banner2.f56634name : str2, (i13 & 4) != 0 ? banner2.bannerUrl : str3, (i13 & 8) != 0 ? banner2.position : i11, (i13 & 16) != 0 ? banner2.targetAudience : targetAudienceType, (i13 & 32) != 0 ? banner2.isStatic : z11, (i13 & 64) != 0 ? banner2.description : str4, (i13 & 128) != 0 ? banner2.f56635tracking : tracking2, (i13 & 256) != 0 ? banner2.campaignEndTime : str5, (i13 & 512) != 0 ? banner2.isSponsored : bool);
    }

    @NotNull
    public final String component1() {
        return this.globalId;
    }

    @Nullable
    public final Boolean component10() {
        return this.isSponsored;
    }

    @NotNull
    public final String component2() {
        return this.f56634name;
    }

    @NotNull
    public final String component3() {
        return this.bannerUrl;
    }

    public final int component4() {
        return this.position;
    }

    @NotNull
    public final TargetAudienceType component5() {
        return this.targetAudience;
    }

    public final boolean component6() {
        return this.isStatic;
    }

    @Nullable
    public final String component7() {
        return this.description;
    }

    @Nullable
    public final Tracking component8() {
        return this.f56635tracking;
    }

    @Nullable
    public final String component9() {
        return this.campaignEndTime;
    }

    @NotNull
    public final Banner copy(@NotNull @Json(name = "global_id") String str, @NotNull String str2, @NotNull @Json(name = "banner_url") String str3, int i11, @NotNull @Json(name = "target_audience") TargetAudienceType targetAudienceType, @Json(name = "is_static") boolean z11, @Nullable @Json(name = "description") String str4, @Nullable @Json(name = "tracking") Tracking tracking2, @Nullable @Json(name = "campaign_end_time") String str5, @Nullable @Json(name = "is_sponsored") Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "globalId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "bannerUrl");
        TargetAudienceType targetAudienceType2 = targetAudienceType;
        Intrinsics.checkNotNullParameter(targetAudienceType2, "targetAudience");
        return new Banner(str, str2, str3, i11, targetAudienceType2, z11, str4, tracking2, str5, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Banner)) {
            return false;
        }
        Banner banner = (Banner) obj;
        return Intrinsics.areEqual((Object) this.globalId, (Object) banner.globalId) && Intrinsics.areEqual((Object) this.f56634name, (Object) banner.f56634name) && Intrinsics.areEqual((Object) this.bannerUrl, (Object) banner.bannerUrl) && this.position == banner.position && this.targetAudience == banner.targetAudience && this.isStatic == banner.isStatic && Intrinsics.areEqual((Object) this.description, (Object) banner.description) && Intrinsics.areEqual((Object) this.f56635tracking, (Object) banner.f56635tracking) && Intrinsics.areEqual((Object) this.campaignEndTime, (Object) banner.campaignEndTime) && Intrinsics.areEqual((Object) this.isSponsored, (Object) banner.isSponsored);
    }

    @NotNull
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    @Nullable
    public final String getCampaignEndTime() {
        return this.campaignEndTime;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getGlobalId() {
        return this.globalId;
    }

    @NotNull
    public final String getName() {
        return this.f56634name;
    }

    public final int getPosition() {
        return this.position;
    }

    @NotNull
    public final TargetAudienceType getTargetAudience() {
        return this.targetAudience;
    }

    @Nullable
    public final Tracking getTracking() {
        return this.f56635tracking;
    }

    public int hashCode() {
        int hashCode = ((((((((this.globalId.hashCode() * 31) + this.f56634name.hashCode()) * 31) + this.bannerUrl.hashCode()) * 31) + this.position) * 31) + this.targetAudience.hashCode()) * 31;
        boolean z11 = this.isStatic;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        String str = this.description;
        int i12 = 0;
        int hashCode2 = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        Tracking tracking2 = this.f56635tracking;
        int hashCode3 = (hashCode2 + (tracking2 == null ? 0 : tracking2.hashCode())) * 31;
        String str2 = this.campaignEndTime;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isSponsored;
        if (bool != null) {
            i12 = bool.hashCode();
        }
        return hashCode4 + i12;
    }

    @Nullable
    public final Boolean isSponsored() {
        return this.isSponsored;
    }

    public final boolean isStatic() {
        return this.isStatic;
    }

    @NotNull
    public String toString() {
        String str = this.globalId;
        String str2 = this.f56634name;
        String str3 = this.bannerUrl;
        int i11 = this.position;
        TargetAudienceType targetAudienceType = this.targetAudience;
        boolean z11 = this.isStatic;
        String str4 = this.description;
        Tracking tracking2 = this.f56635tracking;
        String str5 = this.campaignEndTime;
        Boolean bool = this.isSponsored;
        return "Banner(globalId=" + str + ", name=" + str2 + ", bannerUrl=" + str3 + ", position=" + i11 + ", targetAudience=" + targetAudienceType + ", isStatic=" + z11 + ", description=" + str4 + ", tracking=" + tracking2 + ", campaignEndTime=" + str5 + ", isSponsored=" + bool + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Banner(java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, com.talabat.darkstores.model.TargetAudienceType r18, boolean r19, java.lang.String r20, com.talabat.feature.darkstorescart.data.model.Tracking r21, java.lang.String r22, java.lang.Boolean r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r8 = r1
            goto L_0x000b
        L_0x0009:
            r8 = r19
        L_0x000b:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0012
            r9 = r2
            goto L_0x0014
        L_0x0012:
            r9 = r20
        L_0x0014:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x001a
            r10 = r2
            goto L_0x001c
        L_0x001a:
            r10 = r21
        L_0x001c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0022
            r11 = r2
            goto L_0x0024
        L_0x0022:
            r11 = r22
        L_0x0024:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x002a
            r12 = r2
            goto L_0x002c
        L_0x002a:
            r12 = r23
        L_0x002c:
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.model.Banner.<init>(java.lang.String, java.lang.String, java.lang.String, int, com.talabat.darkstores.model.TargetAudienceType, boolean, java.lang.String, com.talabat.feature.darkstorescart.data.model.Tracking, java.lang.String, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
