package com.talabat.offering.domain.entities;

import com.talabat.mapper.ModelMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0007\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/talabat/offering/domain/entities/Header;", "", "baseUrl", "", "foregroundImg", "hasTermsNCodn", "", "isCuisine", "slug", "verticalId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "getBaseUrl", "()Ljava/lang/String;", "getForegroundImg", "getHasTermsNCodn", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSlug", "getVerticalId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lcom/talabat/offering/domain/entities/Header;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Header {
    @ModelMapping({"baseUrl"})
    @Nullable
    private final String baseUrl;
    @ModelMapping({"foregroundImg"})
    @Nullable
    private final String foregroundImg;
    @ModelMapping({"hasTermsNCodn"})
    @Nullable
    private final Boolean hasTermsNCodn;
    @ModelMapping({"isCuisine"})
    @Nullable
    private final Boolean isCuisine;
    @ModelMapping({"slug"})
    @Nullable
    private final String slug;
    @ModelMapping({"verticalId"})
    @Nullable
    private final Integer verticalId;

    public Header() {
        this((String) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (Integer) null, 63, (DefaultConstructorMarker) null);
    }

    public Header(@Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str3, @Nullable Integer num) {
        this.baseUrl = str;
        this.foregroundImg = str2;
        this.hasTermsNCodn = bool;
        this.isCuisine = bool2;
        this.slug = str3;
        this.verticalId = num;
    }

    public static /* synthetic */ Header copy$default(Header header, String str, String str2, Boolean bool, Boolean bool2, String str3, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = header.baseUrl;
        }
        if ((i11 & 2) != 0) {
            str2 = header.foregroundImg;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            bool = header.hasTermsNCodn;
        }
        Boolean bool3 = bool;
        if ((i11 & 8) != 0) {
            bool2 = header.isCuisine;
        }
        Boolean bool4 = bool2;
        if ((i11 & 16) != 0) {
            str3 = header.slug;
        }
        String str5 = str3;
        if ((i11 & 32) != 0) {
            num = header.verticalId;
        }
        return header.copy(str, str4, bool3, bool4, str5, num);
    }

    @Nullable
    public final String component1() {
        return this.baseUrl;
    }

    @Nullable
    public final String component2() {
        return this.foregroundImg;
    }

    @Nullable
    public final Boolean component3() {
        return this.hasTermsNCodn;
    }

    @Nullable
    public final Boolean component4() {
        return this.isCuisine;
    }

    @Nullable
    public final String component5() {
        return this.slug;
    }

    @Nullable
    public final Integer component6() {
        return this.verticalId;
    }

    @NotNull
    public final Header copy(@Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str3, @Nullable Integer num) {
        return new Header(str, str2, bool, bool2, str3, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return Intrinsics.areEqual((Object) this.baseUrl, (Object) header.baseUrl) && Intrinsics.areEqual((Object) this.foregroundImg, (Object) header.foregroundImg) && Intrinsics.areEqual((Object) this.hasTermsNCodn, (Object) header.hasTermsNCodn) && Intrinsics.areEqual((Object) this.isCuisine, (Object) header.isCuisine) && Intrinsics.areEqual((Object) this.slug, (Object) header.slug) && Intrinsics.areEqual((Object) this.verticalId, (Object) header.verticalId);
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
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
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final Integer getVerticalId() {
        return this.verticalId;
    }

    public int hashCode() {
        String str = this.baseUrl;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.foregroundImg;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.hasTermsNCodn;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isCuisine;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str3 = this.slug;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.verticalId;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode5 + i11;
    }

    @Nullable
    public final Boolean isCuisine() {
        return this.isCuisine;
    }

    @NotNull
    public String toString() {
        String str = this.baseUrl;
        String str2 = this.foregroundImg;
        Boolean bool = this.hasTermsNCodn;
        Boolean bool2 = this.isCuisine;
        String str3 = this.slug;
        Integer num = this.verticalId;
        return "Header(baseUrl=" + str + ", foregroundImg=" + str2 + ", hasTermsNCodn=" + bool + ", isCuisine=" + bool2 + ", slug=" + str3 + ", verticalId=" + num + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Header(java.lang.String r6, java.lang.String r7, java.lang.Boolean r8, java.lang.Boolean r9, java.lang.String r10, java.lang.Integer r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.domain.entities.Header.<init>(java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
