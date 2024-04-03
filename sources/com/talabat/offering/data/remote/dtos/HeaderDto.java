package com.talabat.offering.data.remote.dtos;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b'\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010$J\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0010HÖ\u0001J\t\u00106\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u000b\u0010\u001cR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$¨\u00067"}, d2 = {"Lcom/talabat/offering/data/remote/dtos/HeaderDto;", "", "backgroundDto", "Lcom/talabat/offering/data/remote/dtos/BackgroundDto;", "baseUrl", "", "callToActionDto", "Lcom/talabat/offering/data/remote/dtos/CallToActionDto;", "foregroundImg", "hasTermsNCodn", "", "isCuisine", "slug", "headerTextDto", "Lcom/talabat/offering/data/remote/dtos/HeaderTextDto;", "verticalId", "", "popupTitle", "popupDescription", "(Lcom/talabat/offering/data/remote/dtos/BackgroundDto;Ljava/lang/String;Lcom/talabat/offering/data/remote/dtos/CallToActionDto;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/talabat/offering/data/remote/dtos/HeaderTextDto;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundDto", "()Lcom/talabat/offering/data/remote/dtos/BackgroundDto;", "getBaseUrl", "()Ljava/lang/String;", "getCallToActionDto", "()Lcom/talabat/offering/data/remote/dtos/CallToActionDto;", "getForegroundImg", "getHasTermsNCodn", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHeaderTextDto", "()Lcom/talabat/offering/data/remote/dtos/HeaderTextDto;", "getPopupDescription", "getPopupTitle", "getSlug", "getVerticalId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/talabat/offering/data/remote/dtos/BackgroundDto;Ljava/lang/String;Lcom/talabat/offering/data/remote/dtos/CallToActionDto;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/talabat/offering/data/remote/dtos/HeaderTextDto;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/offering/data/remote/dtos/HeaderDto;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeaderDto {
    @SerializedName("background")
    @Nullable
    private final BackgroundDto backgroundDto;
    @SerializedName("baseUrl")
    @Nullable
    private final String baseUrl;
    @SerializedName("callToAction")
    @Nullable
    private final CallToActionDto callToActionDto;
    @SerializedName("foregroundImg")
    @Nullable
    private final String foregroundImg;
    @SerializedName("hasTermsNCodn")
    @Nullable
    private final Boolean hasTermsNCodn;
    @SerializedName("text")
    @Nullable
    private final HeaderTextDto headerTextDto;
    @SerializedName("isCuisine")
    @Nullable
    private final Boolean isCuisine;
    @SerializedName("popupDescription")
    @Nullable
    private final String popupDescription;
    @SerializedName("popupTitle")
    @Nullable
    private final String popupTitle;
    @SerializedName("slug")
    @Nullable
    private final String slug;
    @SerializedName("verticalId")
    @Nullable
    private final Integer verticalId;

    public HeaderDto() {
        this((BackgroundDto) null, (String) null, (CallToActionDto) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (HeaderTextDto) null, (Integer) null, (String) null, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    public HeaderDto(@Nullable BackgroundDto backgroundDto2, @Nullable String str, @Nullable CallToActionDto callToActionDto2, @Nullable String str2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str3, @Nullable HeaderTextDto headerTextDto2, @Nullable Integer num, @Nullable String str4, @Nullable String str5) {
        this.backgroundDto = backgroundDto2;
        this.baseUrl = str;
        this.callToActionDto = callToActionDto2;
        this.foregroundImg = str2;
        this.hasTermsNCodn = bool;
        this.isCuisine = bool2;
        this.slug = str3;
        this.headerTextDto = headerTextDto2;
        this.verticalId = num;
        this.popupTitle = str4;
        this.popupDescription = str5;
    }

    public static /* synthetic */ HeaderDto copy$default(HeaderDto headerDto, BackgroundDto backgroundDto2, String str, CallToActionDto callToActionDto2, String str2, Boolean bool, Boolean bool2, String str3, HeaderTextDto headerTextDto2, Integer num, String str4, String str5, int i11, Object obj) {
        HeaderDto headerDto2 = headerDto;
        int i12 = i11;
        return headerDto.copy((i12 & 1) != 0 ? headerDto2.backgroundDto : backgroundDto2, (i12 & 2) != 0 ? headerDto2.baseUrl : str, (i12 & 4) != 0 ? headerDto2.callToActionDto : callToActionDto2, (i12 & 8) != 0 ? headerDto2.foregroundImg : str2, (i12 & 16) != 0 ? headerDto2.hasTermsNCodn : bool, (i12 & 32) != 0 ? headerDto2.isCuisine : bool2, (i12 & 64) != 0 ? headerDto2.slug : str3, (i12 & 128) != 0 ? headerDto2.headerTextDto : headerTextDto2, (i12 & 256) != 0 ? headerDto2.verticalId : num, (i12 & 512) != 0 ? headerDto2.popupTitle : str4, (i12 & 1024) != 0 ? headerDto2.popupDescription : str5);
    }

    @Nullable
    public final BackgroundDto component1() {
        return this.backgroundDto;
    }

    @Nullable
    public final String component10() {
        return this.popupTitle;
    }

    @Nullable
    public final String component11() {
        return this.popupDescription;
    }

    @Nullable
    public final String component2() {
        return this.baseUrl;
    }

    @Nullable
    public final CallToActionDto component3() {
        return this.callToActionDto;
    }

    @Nullable
    public final String component4() {
        return this.foregroundImg;
    }

    @Nullable
    public final Boolean component5() {
        return this.hasTermsNCodn;
    }

    @Nullable
    public final Boolean component6() {
        return this.isCuisine;
    }

    @Nullable
    public final String component7() {
        return this.slug;
    }

    @Nullable
    public final HeaderTextDto component8() {
        return this.headerTextDto;
    }

    @Nullable
    public final Integer component9() {
        return this.verticalId;
    }

    @NotNull
    public final HeaderDto copy(@Nullable BackgroundDto backgroundDto2, @Nullable String str, @Nullable CallToActionDto callToActionDto2, @Nullable String str2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str3, @Nullable HeaderTextDto headerTextDto2, @Nullable Integer num, @Nullable String str4, @Nullable String str5) {
        return new HeaderDto(backgroundDto2, str, callToActionDto2, str2, bool, bool2, str3, headerTextDto2, num, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderDto)) {
            return false;
        }
        HeaderDto headerDto = (HeaderDto) obj;
        return Intrinsics.areEqual((Object) this.backgroundDto, (Object) headerDto.backgroundDto) && Intrinsics.areEqual((Object) this.baseUrl, (Object) headerDto.baseUrl) && Intrinsics.areEqual((Object) this.callToActionDto, (Object) headerDto.callToActionDto) && Intrinsics.areEqual((Object) this.foregroundImg, (Object) headerDto.foregroundImg) && Intrinsics.areEqual((Object) this.hasTermsNCodn, (Object) headerDto.hasTermsNCodn) && Intrinsics.areEqual((Object) this.isCuisine, (Object) headerDto.isCuisine) && Intrinsics.areEqual((Object) this.slug, (Object) headerDto.slug) && Intrinsics.areEqual((Object) this.headerTextDto, (Object) headerDto.headerTextDto) && Intrinsics.areEqual((Object) this.verticalId, (Object) headerDto.verticalId) && Intrinsics.areEqual((Object) this.popupTitle, (Object) headerDto.popupTitle) && Intrinsics.areEqual((Object) this.popupDescription, (Object) headerDto.popupDescription);
    }

    @Nullable
    public final BackgroundDto getBackgroundDto() {
        return this.backgroundDto;
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @Nullable
    public final CallToActionDto getCallToActionDto() {
        return this.callToActionDto;
    }

    @Nullable
    public final String getForegroundImg() {
        return this.foregroundImg;
    }

    @Nullable
    public final Boolean getHasTermsNCodn() {
        return this.hasTermsNCodn;
    }

    @Nullable
    public final HeaderTextDto getHeaderTextDto() {
        return this.headerTextDto;
    }

    @Nullable
    public final String getPopupDescription() {
        return this.popupDescription;
    }

    @Nullable
    public final String getPopupTitle() {
        return this.popupTitle;
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final Integer getVerticalId() {
        return this.verticalId;
    }

    public int hashCode() {
        BackgroundDto backgroundDto2 = this.backgroundDto;
        int i11 = 0;
        int hashCode = (backgroundDto2 == null ? 0 : backgroundDto2.hashCode()) * 31;
        String str = this.baseUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        CallToActionDto callToActionDto2 = this.callToActionDto;
        int hashCode3 = (hashCode2 + (callToActionDto2 == null ? 0 : callToActionDto2.hashCode())) * 31;
        String str2 = this.foregroundImg;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.hasTermsNCodn;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isCuisine;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str3 = this.slug;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        HeaderTextDto headerTextDto2 = this.headerTextDto;
        int hashCode8 = (hashCode7 + (headerTextDto2 == null ? 0 : headerTextDto2.hashCode())) * 31;
        Integer num = this.verticalId;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.popupTitle;
        int hashCode10 = (hashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.popupDescription;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode10 + i11;
    }

    @Nullable
    public final Boolean isCuisine() {
        return this.isCuisine;
    }

    @NotNull
    public String toString() {
        BackgroundDto backgroundDto2 = this.backgroundDto;
        String str = this.baseUrl;
        CallToActionDto callToActionDto2 = this.callToActionDto;
        String str2 = this.foregroundImg;
        Boolean bool = this.hasTermsNCodn;
        Boolean bool2 = this.isCuisine;
        String str3 = this.slug;
        HeaderTextDto headerTextDto2 = this.headerTextDto;
        Integer num = this.verticalId;
        String str4 = this.popupTitle;
        String str5 = this.popupDescription;
        return "HeaderDto(backgroundDto=" + backgroundDto2 + ", baseUrl=" + str + ", callToActionDto=" + callToActionDto2 + ", foregroundImg=" + str2 + ", hasTermsNCodn=" + bool + ", isCuisine=" + bool2 + ", slug=" + str3 + ", headerTextDto=" + headerTextDto2 + ", verticalId=" + num + ", popupTitle=" + str4 + ", popupDescription=" + str5 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HeaderDto(com.talabat.offering.data.remote.dtos.BackgroundDto r13, java.lang.String r14, com.talabat.offering.data.remote.dtos.CallToActionDto r15, java.lang.String r16, java.lang.Boolean r17, java.lang.Boolean r18, java.lang.String r19, com.talabat.offering.data.remote.dtos.HeaderTextDto r20, java.lang.Integer r21, java.lang.String r22, java.lang.String r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r14
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r15
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x0020
        L_0x001e:
            r5 = r16
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r2
            goto L_0x0028
        L_0x0026:
            r6 = r17
        L_0x0028:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002e
            r7 = r2
            goto L_0x0030
        L_0x002e:
            r7 = r18
        L_0x0030:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0036
            r8 = r2
            goto L_0x0038
        L_0x0036:
            r8 = r19
        L_0x0038:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003e
            r9 = r2
            goto L_0x0040
        L_0x003e:
            r9 = r20
        L_0x0040:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0046
            r10 = r2
            goto L_0x0048
        L_0x0046:
            r10 = r21
        L_0x0048:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004e
            r11 = r2
            goto L_0x0050
        L_0x004e:
            r11 = r22
        L_0x0050:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r2 = r23
        L_0x0057:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.data.remote.dtos.HeaderDto.<init>(com.talabat.offering.data.remote.dtos.BackgroundDto, java.lang.String, com.talabat.offering.data.remote.dtos.CallToActionDto, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, com.talabat.offering.data.remote.dtos.HeaderTextDto, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
