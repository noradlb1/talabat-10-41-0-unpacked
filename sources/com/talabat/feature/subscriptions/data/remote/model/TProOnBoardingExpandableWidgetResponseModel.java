package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u00105\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\t\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014¨\u0006="}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingExpandableWidgetResponseModel;", "Lcom/talabat/feature/subscriptions/data/remote/model/HeroWidgetResponseModel;", "headerTitle", "", "headerTitleColor", "title", "titleColor", "subtitle", "subTitleColor", "isExpanded", "", "expandWidgetTitle", "trackingId", "listItems", "", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingExpandableItemResponseModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getExpandWidgetTitle", "()Ljava/lang/String;", "setExpandWidgetTitle", "(Ljava/lang/String;)V", "getHeaderTitle", "setHeaderTitle", "getHeaderTitleColor", "setHeaderTitleColor", "()Ljava/lang/Boolean;", "setExpanded", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getListItems", "()Ljava/util/List;", "setListItems", "(Ljava/util/List;)V", "getSubTitleColor", "setSubTitleColor", "getSubtitle", "setSubtitle", "getTitle", "setTitle", "getTitleColor", "setTitleColor", "getTrackingId", "setTrackingId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingExpandableWidgetResponseModel;", "equals", "other", "", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingExpandableWidgetResponseModel extends HeroWidgetResponseModel {
    @Nullable
    private String expandWidgetTitle;
    @Nullable
    private String headerTitle;
    @Nullable
    private String headerTitleColor;
    @Nullable
    private Boolean isExpanded;
    @Nullable
    private List<TProOnBoardingExpandableItemResponseModel> listItems;
    @Nullable
    private String subTitleColor;
    @Nullable
    private String subtitle;
    @Nullable
    private String title;
    @Nullable
    private String titleColor;
    @Nullable
    private String trackingId;

    public TProOnBoardingExpandableWidgetResponseModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (List) null, 1023, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TProOnBoardingExpandableWidgetResponseModel(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.Boolean r18, java.lang.String r19, java.lang.String r20, java.util.List r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002f
        L_0x002d:
            r7 = r17
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            r8 = r2
            goto L_0x0037
        L_0x0035:
            r8 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r2
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0045
            r10 = r2
            goto L_0x0047
        L_0x0045:
            r10 = r20
        L_0x0047:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r2 = r21
        L_0x004e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingExpandableWidgetResponseModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ TProOnBoardingExpandableWidgetResponseModel copy$default(TProOnBoardingExpandableWidgetResponseModel tProOnBoardingExpandableWidgetResponseModel, String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, String str7, String str8, List list, int i11, Object obj) {
        TProOnBoardingExpandableWidgetResponseModel tProOnBoardingExpandableWidgetResponseModel2 = tProOnBoardingExpandableWidgetResponseModel;
        int i12 = i11;
        return tProOnBoardingExpandableWidgetResponseModel.copy((i12 & 1) != 0 ? tProOnBoardingExpandableWidgetResponseModel2.headerTitle : str, (i12 & 2) != 0 ? tProOnBoardingExpandableWidgetResponseModel2.headerTitleColor : str2, (i12 & 4) != 0 ? tProOnBoardingExpandableWidgetResponseModel2.title : str3, (i12 & 8) != 0 ? tProOnBoardingExpandableWidgetResponseModel2.titleColor : str4, (i12 & 16) != 0 ? tProOnBoardingExpandableWidgetResponseModel2.subtitle : str5, (i12 & 32) != 0 ? tProOnBoardingExpandableWidgetResponseModel2.subTitleColor : str6, (i12 & 64) != 0 ? tProOnBoardingExpandableWidgetResponseModel2.isExpanded : bool, (i12 & 128) != 0 ? tProOnBoardingExpandableWidgetResponseModel2.expandWidgetTitle : str7, (i12 & 256) != 0 ? tProOnBoardingExpandableWidgetResponseModel.getTrackingId() : str8, (i12 & 512) != 0 ? tProOnBoardingExpandableWidgetResponseModel2.listItems : list);
    }

    @Nullable
    public final String component1() {
        return this.headerTitle;
    }

    @Nullable
    public final List<TProOnBoardingExpandableItemResponseModel> component10() {
        return this.listItems;
    }

    @Nullable
    public final String component2() {
        return this.headerTitleColor;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    @Nullable
    public final String component4() {
        return this.titleColor;
    }

    @Nullable
    public final String component5() {
        return this.subtitle;
    }

    @Nullable
    public final String component6() {
        return this.subTitleColor;
    }

    @Nullable
    public final Boolean component7() {
        return this.isExpanded;
    }

    @Nullable
    public final String component8() {
        return this.expandWidgetTitle;
    }

    @Nullable
    public final String component9() {
        return getTrackingId();
    }

    @NotNull
    public final TProOnBoardingExpandableWidgetResponseModel copy(@Nullable @Json(name = "headerTitle") String str, @Nullable @Json(name = "headerTitleColor") String str2, @Nullable @Json(name = "title") String str3, @Nullable @Json(name = "titleColor") String str4, @Nullable @Json(name = "subtitle") String str5, @Nullable @Json(name = "subTitleColor") String str6, @Nullable @Json(name = "isExpanded") Boolean bool, @Nullable @Json(name = "expandWidgetTitle") String str7, @Nullable @Json(name = "trackingId") String str8, @Nullable @Json(name = "listItems") List<TProOnBoardingExpandableItemResponseModel> list) {
        return new TProOnBoardingExpandableWidgetResponseModel(str, str2, str3, str4, str5, str6, bool, str7, str8, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingExpandableWidgetResponseModel)) {
            return false;
        }
        TProOnBoardingExpandableWidgetResponseModel tProOnBoardingExpandableWidgetResponseModel = (TProOnBoardingExpandableWidgetResponseModel) obj;
        return Intrinsics.areEqual((Object) this.headerTitle, (Object) tProOnBoardingExpandableWidgetResponseModel.headerTitle) && Intrinsics.areEqual((Object) this.headerTitleColor, (Object) tProOnBoardingExpandableWidgetResponseModel.headerTitleColor) && Intrinsics.areEqual((Object) this.title, (Object) tProOnBoardingExpandableWidgetResponseModel.title) && Intrinsics.areEqual((Object) this.titleColor, (Object) tProOnBoardingExpandableWidgetResponseModel.titleColor) && Intrinsics.areEqual((Object) this.subtitle, (Object) tProOnBoardingExpandableWidgetResponseModel.subtitle) && Intrinsics.areEqual((Object) this.subTitleColor, (Object) tProOnBoardingExpandableWidgetResponseModel.subTitleColor) && Intrinsics.areEqual((Object) this.isExpanded, (Object) tProOnBoardingExpandableWidgetResponseModel.isExpanded) && Intrinsics.areEqual((Object) this.expandWidgetTitle, (Object) tProOnBoardingExpandableWidgetResponseModel.expandWidgetTitle) && Intrinsics.areEqual((Object) getTrackingId(), (Object) tProOnBoardingExpandableWidgetResponseModel.getTrackingId()) && Intrinsics.areEqual((Object) this.listItems, (Object) tProOnBoardingExpandableWidgetResponseModel.listItems);
    }

    @Nullable
    public final String getExpandWidgetTitle() {
        return this.expandWidgetTitle;
    }

    @Nullable
    public final String getHeaderTitle() {
        return this.headerTitle;
    }

    @Nullable
    public final String getHeaderTitleColor() {
        return this.headerTitleColor;
    }

    @Nullable
    public final List<TProOnBoardingExpandableItemResponseModel> getListItems() {
        return this.listItems;
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

    @Nullable
    public String getTrackingId() {
        return this.trackingId;
    }

    public int hashCode() {
        String str = this.headerTitle;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.headerTitleColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.titleColor;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.subtitle;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.subTitleColor;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool = this.isExpanded;
        int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str7 = this.expandWidgetTitle;
        int hashCode8 = (((hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + (getTrackingId() == null ? 0 : getTrackingId().hashCode())) * 31;
        List<TProOnBoardingExpandableItemResponseModel> list = this.listItems;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode8 + i11;
    }

    @Nullable
    public final Boolean isExpanded() {
        return this.isExpanded;
    }

    public final void setExpandWidgetTitle(@Nullable String str) {
        this.expandWidgetTitle = str;
    }

    public final void setExpanded(@Nullable Boolean bool) {
        this.isExpanded = bool;
    }

    public final void setHeaderTitle(@Nullable String str) {
        this.headerTitle = str;
    }

    public final void setHeaderTitleColor(@Nullable String str) {
        this.headerTitleColor = str;
    }

    public final void setListItems(@Nullable List<TProOnBoardingExpandableItemResponseModel> list) {
        this.listItems = list;
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

    public void setTrackingId(@Nullable String str) {
        this.trackingId = str;
    }

    @NotNull
    public String toString() {
        String str = this.headerTitle;
        String str2 = this.headerTitleColor;
        String str3 = this.title;
        String str4 = this.titleColor;
        String str5 = this.subtitle;
        String str6 = this.subTitleColor;
        Boolean bool = this.isExpanded;
        String str7 = this.expandWidgetTitle;
        String trackingId2 = getTrackingId();
        List<TProOnBoardingExpandableItemResponseModel> list = this.listItems;
        return "TProOnBoardingExpandableWidgetResponseModel(headerTitle=" + str + ", headerTitleColor=" + str2 + ", title=" + str3 + ", titleColor=" + str4 + ", subtitle=" + str5 + ", subTitleColor=" + str6 + ", isExpanded=" + bool + ", expandWidgetTitle=" + str7 + ", trackingId=" + trackingId2 + ", listItems=" + list + ")";
    }

    public TProOnBoardingExpandableWidgetResponseModel(@Nullable @Json(name = "headerTitle") String str, @Nullable @Json(name = "headerTitleColor") String str2, @Nullable @Json(name = "title") String str3, @Nullable @Json(name = "titleColor") String str4, @Nullable @Json(name = "subtitle") String str5, @Nullable @Json(name = "subTitleColor") String str6, @Nullable @Json(name = "isExpanded") Boolean bool, @Nullable @Json(name = "expandWidgetTitle") String str7, @Nullable @Json(name = "trackingId") String str8, @Nullable @Json(name = "listItems") List<TProOnBoardingExpandableItemResponseModel> list) {
        super(HeroWidgetTypeResponse.expandableWidget.name(), str8);
        this.headerTitle = str;
        this.headerTitleColor = str2;
        this.title = str3;
        this.titleColor = str4;
        this.subtitle = str5;
        this.subTitleColor = str6;
        this.isExpanded = bool;
        this.expandWidgetTitle = str7;
        this.trackingId = str8;
        this.listItems = list;
    }
}
