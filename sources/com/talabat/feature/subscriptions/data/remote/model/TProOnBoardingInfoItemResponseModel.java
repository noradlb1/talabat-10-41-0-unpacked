package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingInfoItemResponseModel;", "", "title", "", "titleColor", "subtitle", "subTitleColor", "ctaTitle", "ctaColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCtaColor", "()Ljava/lang/String;", "setCtaColor", "(Ljava/lang/String;)V", "getCtaTitle", "setCtaTitle", "getSubTitleColor", "setSubTitleColor", "getSubtitle", "setSubtitle", "getTitle", "setTitle", "getTitleColor", "setTitleColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingInfoItemResponseModel {
    @Nullable
    private String ctaColor;
    @Nullable
    private String ctaTitle;
    @Nullable
    private String subTitleColor;
    @Nullable
    private String subtitle;
    @Nullable
    private String title;
    @Nullable
    private String titleColor;

    public TProOnBoardingInfoItemResponseModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public TProOnBoardingInfoItemResponseModel(@Nullable @Json(name = "title") String str, @Nullable @Json(name = "titleColor") String str2, @Nullable @Json(name = "subtitle") String str3, @Nullable @Json(name = "subTitleColor") String str4, @Nullable @Json(name = "ctaTitle") String str5, @Nullable @Json(name = "ctaColor") String str6) {
        this.title = str;
        this.titleColor = str2;
        this.subtitle = str3;
        this.subTitleColor = str4;
        this.ctaTitle = str5;
        this.ctaColor = str6;
    }

    public static /* synthetic */ TProOnBoardingInfoItemResponseModel copy$default(TProOnBoardingInfoItemResponseModel tProOnBoardingInfoItemResponseModel, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingInfoItemResponseModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingInfoItemResponseModel.titleColor;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = tProOnBoardingInfoItemResponseModel.subtitle;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = tProOnBoardingInfoItemResponseModel.subTitleColor;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = tProOnBoardingInfoItemResponseModel.ctaTitle;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = tProOnBoardingInfoItemResponseModel.ctaColor;
        }
        return tProOnBoardingInfoItemResponseModel.copy(str, str7, str8, str9, str10, str6);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.titleColor;
    }

    @Nullable
    public final String component3() {
        return this.subtitle;
    }

    @Nullable
    public final String component4() {
        return this.subTitleColor;
    }

    @Nullable
    public final String component5() {
        return this.ctaTitle;
    }

    @Nullable
    public final String component6() {
        return this.ctaColor;
    }

    @NotNull
    public final TProOnBoardingInfoItemResponseModel copy(@Nullable @Json(name = "title") String str, @Nullable @Json(name = "titleColor") String str2, @Nullable @Json(name = "subtitle") String str3, @Nullable @Json(name = "subTitleColor") String str4, @Nullable @Json(name = "ctaTitle") String str5, @Nullable @Json(name = "ctaColor") String str6) {
        return new TProOnBoardingInfoItemResponseModel(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingInfoItemResponseModel)) {
            return false;
        }
        TProOnBoardingInfoItemResponseModel tProOnBoardingInfoItemResponseModel = (TProOnBoardingInfoItemResponseModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) tProOnBoardingInfoItemResponseModel.title) && Intrinsics.areEqual((Object) this.titleColor, (Object) tProOnBoardingInfoItemResponseModel.titleColor) && Intrinsics.areEqual((Object) this.subtitle, (Object) tProOnBoardingInfoItemResponseModel.subtitle) && Intrinsics.areEqual((Object) this.subTitleColor, (Object) tProOnBoardingInfoItemResponseModel.subTitleColor) && Intrinsics.areEqual((Object) this.ctaTitle, (Object) tProOnBoardingInfoItemResponseModel.ctaTitle) && Intrinsics.areEqual((Object) this.ctaColor, (Object) tProOnBoardingInfoItemResponseModel.ctaColor);
    }

    @Nullable
    public final String getCtaColor() {
        return this.ctaColor;
    }

    @Nullable
    public final String getCtaTitle() {
        return this.ctaTitle;
    }

    @Nullable
    public final String getSubTitleColor() {
        return this.subTitleColor;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getTitleColor() {
        return this.titleColor;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.titleColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subtitle;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.subTitleColor;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.ctaTitle;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.ctaColor;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return hashCode5 + i11;
    }

    public final void setCtaColor(@Nullable String str) {
        this.ctaColor = str;
    }

    public final void setCtaTitle(@Nullable String str) {
        this.ctaTitle = str;
    }

    public final void setSubTitleColor(@Nullable String str) {
        this.subTitleColor = str;
    }

    public final void setSubtitle(@Nullable String str) {
        this.subtitle = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setTitleColor(@Nullable String str) {
        this.titleColor = str;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.titleColor;
        String str3 = this.subtitle;
        String str4 = this.subTitleColor;
        String str5 = this.ctaTitle;
        String str6 = this.ctaColor;
        return "TProOnBoardingInfoItemResponseModel(title=" + str + ", titleColor=" + str2 + ", subtitle=" + str3 + ", subTitleColor=" + str4 + ", ctaTitle=" + str5 + ", ctaColor=" + str6 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TProOnBoardingInfoItemResponseModel(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingInfoItemResponseModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
