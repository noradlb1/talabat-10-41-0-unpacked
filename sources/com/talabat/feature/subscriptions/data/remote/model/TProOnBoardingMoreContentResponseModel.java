package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003Jc\u0010\u001d\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006$"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingMoreContentResponseModel;", "", "ctaTitle", "", "ctaTitleColor", "ctaBackgroundColor", "title", "titleColor", "contentBackgroundColor", "items", "", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingMoreContentItemResponseModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContentBackgroundColor", "()Ljava/lang/String;", "getCtaBackgroundColor", "getCtaTitle", "getCtaTitleColor", "getItems", "()Ljava/util/List;", "getTitle", "getTitleColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingMoreContentResponseModel {
    @Nullable
    private final String contentBackgroundColor;
    @Nullable
    private final String ctaBackgroundColor;
    @Nullable
    private final String ctaTitle;
    @Nullable
    private final String ctaTitleColor;
    @Nullable
    private final List<TProOnBoardingMoreContentItemResponseModel> items;
    @Nullable
    private final String title;
    @Nullable
    private final String titleColor;

    public TProOnBoardingMoreContentResponseModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 127, (DefaultConstructorMarker) null);
    }

    public TProOnBoardingMoreContentResponseModel(@Nullable @Json(name = "ctaTitle") String str, @Nullable @Json(name = "ctaTitleColor") String str2, @Nullable @Json(name = "ctaBackgroundColor") String str3, @Nullable @Json(name = "title") String str4, @Nullable @Json(name = "titleColor") String str5, @Nullable @Json(name = "contentBackgroundColor") String str6, @Nullable @Json(name = "items") List<TProOnBoardingMoreContentItemResponseModel> list) {
        this.ctaTitle = str;
        this.ctaTitleColor = str2;
        this.ctaBackgroundColor = str3;
        this.title = str4;
        this.titleColor = str5;
        this.contentBackgroundColor = str6;
        this.items = list;
    }

    public static /* synthetic */ TProOnBoardingMoreContentResponseModel copy$default(TProOnBoardingMoreContentResponseModel tProOnBoardingMoreContentResponseModel, String str, String str2, String str3, String str4, String str5, String str6, List<TProOnBoardingMoreContentItemResponseModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingMoreContentResponseModel.ctaTitle;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingMoreContentResponseModel.ctaTitleColor;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = tProOnBoardingMoreContentResponseModel.ctaBackgroundColor;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = tProOnBoardingMoreContentResponseModel.title;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = tProOnBoardingMoreContentResponseModel.titleColor;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = tProOnBoardingMoreContentResponseModel.contentBackgroundColor;
        }
        String str11 = str6;
        if ((i11 & 64) != 0) {
            list = tProOnBoardingMoreContentResponseModel.items;
        }
        return tProOnBoardingMoreContentResponseModel.copy(str, str7, str8, str9, str10, str11, list);
    }

    @Nullable
    public final String component1() {
        return this.ctaTitle;
    }

    @Nullable
    public final String component2() {
        return this.ctaTitleColor;
    }

    @Nullable
    public final String component3() {
        return this.ctaBackgroundColor;
    }

    @Nullable
    public final String component4() {
        return this.title;
    }

    @Nullable
    public final String component5() {
        return this.titleColor;
    }

    @Nullable
    public final String component6() {
        return this.contentBackgroundColor;
    }

    @Nullable
    public final List<TProOnBoardingMoreContentItemResponseModel> component7() {
        return this.items;
    }

    @NotNull
    public final TProOnBoardingMoreContentResponseModel copy(@Nullable @Json(name = "ctaTitle") String str, @Nullable @Json(name = "ctaTitleColor") String str2, @Nullable @Json(name = "ctaBackgroundColor") String str3, @Nullable @Json(name = "title") String str4, @Nullable @Json(name = "titleColor") String str5, @Nullable @Json(name = "contentBackgroundColor") String str6, @Nullable @Json(name = "items") List<TProOnBoardingMoreContentItemResponseModel> list) {
        return new TProOnBoardingMoreContentResponseModel(str, str2, str3, str4, str5, str6, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingMoreContentResponseModel)) {
            return false;
        }
        TProOnBoardingMoreContentResponseModel tProOnBoardingMoreContentResponseModel = (TProOnBoardingMoreContentResponseModel) obj;
        return Intrinsics.areEqual((Object) this.ctaTitle, (Object) tProOnBoardingMoreContentResponseModel.ctaTitle) && Intrinsics.areEqual((Object) this.ctaTitleColor, (Object) tProOnBoardingMoreContentResponseModel.ctaTitleColor) && Intrinsics.areEqual((Object) this.ctaBackgroundColor, (Object) tProOnBoardingMoreContentResponseModel.ctaBackgroundColor) && Intrinsics.areEqual((Object) this.title, (Object) tProOnBoardingMoreContentResponseModel.title) && Intrinsics.areEqual((Object) this.titleColor, (Object) tProOnBoardingMoreContentResponseModel.titleColor) && Intrinsics.areEqual((Object) this.contentBackgroundColor, (Object) tProOnBoardingMoreContentResponseModel.contentBackgroundColor) && Intrinsics.areEqual((Object) this.items, (Object) tProOnBoardingMoreContentResponseModel.items);
    }

    @Nullable
    public final String getContentBackgroundColor() {
        return this.contentBackgroundColor;
    }

    @Nullable
    public final String getCtaBackgroundColor() {
        return this.ctaBackgroundColor;
    }

    @Nullable
    public final String getCtaTitle() {
        return this.ctaTitle;
    }

    @Nullable
    public final String getCtaTitleColor() {
        return this.ctaTitleColor;
    }

    @Nullable
    public final List<TProOnBoardingMoreContentItemResponseModel> getItems() {
        return this.items;
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
        String str = this.ctaTitle;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.ctaTitleColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ctaBackgroundColor;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.titleColor;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.contentBackgroundColor;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<TProOnBoardingMoreContentItemResponseModel> list = this.items;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode6 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.ctaTitle;
        String str2 = this.ctaTitleColor;
        String str3 = this.ctaBackgroundColor;
        String str4 = this.title;
        String str5 = this.titleColor;
        String str6 = this.contentBackgroundColor;
        List<TProOnBoardingMoreContentItemResponseModel> list = this.items;
        return "TProOnBoardingMoreContentResponseModel(ctaTitle=" + str + ", ctaTitleColor=" + str2 + ", ctaBackgroundColor=" + str3 + ", title=" + str4 + ", titleColor=" + str5 + ", contentBackgroundColor=" + str6 + ", items=" + list + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TProOnBoardingMoreContentResponseModel(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.util.List r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingMoreContentResponseModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
