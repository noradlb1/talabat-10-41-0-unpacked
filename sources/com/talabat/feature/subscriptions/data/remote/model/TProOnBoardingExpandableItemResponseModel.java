package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\"\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006)"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingExpandableItemResponseModel;", "", "icon", "", "title", "titleColor", "value", "valueColor", "subTitle", "subTitleColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getSubTitle", "setSubTitle", "getSubTitleColor", "setSubTitleColor", "getTitle", "setTitle", "getTitleColor", "setTitleColor", "getValue", "setValue", "getValueColor", "setValueColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingExpandableItemResponseModel {
    @Nullable
    private String icon;
    @Nullable
    private String subTitle;
    @Nullable
    private String subTitleColor;
    @Nullable
    private String title;
    @Nullable
    private String titleColor;
    @Nullable
    private String value;
    @Nullable
    private String valueColor;

    public TProOnBoardingExpandableItemResponseModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public TProOnBoardingExpandableItemResponseModel(@Nullable @Json(name = "icon") String str, @Nullable @Json(name = "title") String str2, @Nullable @Json(name = "titleColor") String str3, @Nullable @Json(name = "value") String str4, @Nullable @Json(name = "valueColor") String str5, @Nullable @Json(name = "subTitle") String str6, @Nullable @Json(name = "subTitleColor") String str7) {
        this.icon = str;
        this.title = str2;
        this.titleColor = str3;
        this.value = str4;
        this.valueColor = str5;
        this.subTitle = str6;
        this.subTitleColor = str7;
    }

    public static /* synthetic */ TProOnBoardingExpandableItemResponseModel copy$default(TProOnBoardingExpandableItemResponseModel tProOnBoardingExpandableItemResponseModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingExpandableItemResponseModel.icon;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingExpandableItemResponseModel.title;
        }
        String str8 = str2;
        if ((i11 & 4) != 0) {
            str3 = tProOnBoardingExpandableItemResponseModel.titleColor;
        }
        String str9 = str3;
        if ((i11 & 8) != 0) {
            str4 = tProOnBoardingExpandableItemResponseModel.value;
        }
        String str10 = str4;
        if ((i11 & 16) != 0) {
            str5 = tProOnBoardingExpandableItemResponseModel.valueColor;
        }
        String str11 = str5;
        if ((i11 & 32) != 0) {
            str6 = tProOnBoardingExpandableItemResponseModel.subTitle;
        }
        String str12 = str6;
        if ((i11 & 64) != 0) {
            str7 = tProOnBoardingExpandableItemResponseModel.subTitleColor;
        }
        return tProOnBoardingExpandableItemResponseModel.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @Nullable
    public final String component1() {
        return this.icon;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.titleColor;
    }

    @Nullable
    public final String component4() {
        return this.value;
    }

    @Nullable
    public final String component5() {
        return this.valueColor;
    }

    @Nullable
    public final String component6() {
        return this.subTitle;
    }

    @Nullable
    public final String component7() {
        return this.subTitleColor;
    }

    @NotNull
    public final TProOnBoardingExpandableItemResponseModel copy(@Nullable @Json(name = "icon") String str, @Nullable @Json(name = "title") String str2, @Nullable @Json(name = "titleColor") String str3, @Nullable @Json(name = "value") String str4, @Nullable @Json(name = "valueColor") String str5, @Nullable @Json(name = "subTitle") String str6, @Nullable @Json(name = "subTitleColor") String str7) {
        return new TProOnBoardingExpandableItemResponseModel(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingExpandableItemResponseModel)) {
            return false;
        }
        TProOnBoardingExpandableItemResponseModel tProOnBoardingExpandableItemResponseModel = (TProOnBoardingExpandableItemResponseModel) obj;
        return Intrinsics.areEqual((Object) this.icon, (Object) tProOnBoardingExpandableItemResponseModel.icon) && Intrinsics.areEqual((Object) this.title, (Object) tProOnBoardingExpandableItemResponseModel.title) && Intrinsics.areEqual((Object) this.titleColor, (Object) tProOnBoardingExpandableItemResponseModel.titleColor) && Intrinsics.areEqual((Object) this.value, (Object) tProOnBoardingExpandableItemResponseModel.value) && Intrinsics.areEqual((Object) this.valueColor, (Object) tProOnBoardingExpandableItemResponseModel.valueColor) && Intrinsics.areEqual((Object) this.subTitle, (Object) tProOnBoardingExpandableItemResponseModel.subTitle) && Intrinsics.areEqual((Object) this.subTitleColor, (Object) tProOnBoardingExpandableItemResponseModel.subTitleColor);
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getSubTitle() {
        return this.subTitle;
    }

    @Nullable
    public final String getSubTitleColor() {
        return this.subTitleColor;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getTitleColor() {
        return this.titleColor;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    @Nullable
    public final String getValueColor() {
        return this.valueColor;
    }

    public int hashCode() {
        String str = this.icon;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.titleColor;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.value;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.valueColor;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.subTitle;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.subTitleColor;
        if (str7 != null) {
            i11 = str7.hashCode();
        }
        return hashCode6 + i11;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    public final void setSubTitle(@Nullable String str) {
        this.subTitle = str;
    }

    public final void setSubTitleColor(@Nullable String str) {
        this.subTitleColor = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setTitleColor(@Nullable String str) {
        this.titleColor = str;
    }

    public final void setValue(@Nullable String str) {
        this.value = str;
    }

    public final void setValueColor(@Nullable String str) {
        this.valueColor = str;
    }

    @NotNull
    public String toString() {
        String str = this.icon;
        String str2 = this.title;
        String str3 = this.titleColor;
        String str4 = this.value;
        String str5 = this.valueColor;
        String str6 = this.subTitle;
        String str7 = this.subTitleColor;
        return "TProOnBoardingExpandableItemResponseModel(icon=" + str + ", title=" + str2 + ", titleColor=" + str3 + ", value=" + str4 + ", valueColor=" + str5 + ", subTitle=" + str6 + ", subTitleColor=" + str7 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TProOnBoardingExpandableItemResponseModel(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingExpandableItemResponseModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
