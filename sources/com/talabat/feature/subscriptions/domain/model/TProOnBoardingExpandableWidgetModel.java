package com.talabat.feature.subscriptions.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J}\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00109\u001a\u00020\n2\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020=HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016R\u0014\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0014R\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006?"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingExpandableWidgetModel;", "Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetModel;", "headerTitle", "", "headerTitleColor", "title", "titleColor", "subtitle", "subTitleColor", "isExpanded", "", "expandWidgetTitle", "listItems", "", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingExpandableItemModel;", "widgetType", "Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetType;", "trackingId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetType;Ljava/lang/String;)V", "getExpandWidgetTitle", "()Ljava/lang/String;", "setExpandWidgetTitle", "(Ljava/lang/String;)V", "getHeaderTitle", "setHeaderTitle", "getHeaderTitleColor", "setHeaderTitleColor", "()Z", "setExpanded", "(Z)V", "getListItems", "()Ljava/util/List;", "setListItems", "(Ljava/util/List;)V", "getSubTitleColor", "setSubTitleColor", "getSubtitle", "setSubtitle", "getTitle", "setTitle", "getTitleColor", "setTitleColor", "getTrackingId", "getWidgetType", "()Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetType;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingExpandableWidgetModel extends HeroWidgetModel {
    @NotNull
    private String expandWidgetTitle;
    @NotNull
    private String headerTitle;
    @NotNull
    private String headerTitleColor;
    private boolean isExpanded;
    @NotNull
    private List<TProOnBoardingExpandableItemModel> listItems;
    @NotNull
    private String subTitleColor;
    @NotNull
    private String subtitle;
    @NotNull
    private String title;
    @NotNull
    private String titleColor;
    @NotNull
    private final String trackingId;
    @NotNull
    private final HeroWidgetType widgetType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProOnBoardingExpandableWidgetModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z11, @NotNull String str7, @NotNull List<TProOnBoardingExpandableItemModel> list, @NotNull HeroWidgetType heroWidgetType, @NotNull String str8) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "headerTitle");
        Intrinsics.checkNotNullParameter(str2, "headerTitleColor");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "titleColor");
        Intrinsics.checkNotNullParameter(str5, "subtitle");
        Intrinsics.checkNotNullParameter(str6, "subTitleColor");
        Intrinsics.checkNotNullParameter(str7, "expandWidgetTitle");
        Intrinsics.checkNotNullParameter(list, "listItems");
        Intrinsics.checkNotNullParameter(heroWidgetType, "widgetType");
        Intrinsics.checkNotNullParameter(str8, "trackingId");
        this.headerTitle = str;
        this.headerTitleColor = str2;
        this.title = str3;
        this.titleColor = str4;
        this.subtitle = str5;
        this.subTitleColor = str6;
        this.isExpanded = z11;
        this.expandWidgetTitle = str7;
        this.listItems = list;
        this.widgetType = heroWidgetType;
        this.trackingId = str8;
    }

    public static /* synthetic */ TProOnBoardingExpandableWidgetModel copy$default(TProOnBoardingExpandableWidgetModel tProOnBoardingExpandableWidgetModel, String str, String str2, String str3, String str4, String str5, String str6, boolean z11, String str7, List list, HeroWidgetType heroWidgetType, String str8, int i11, Object obj) {
        TProOnBoardingExpandableWidgetModel tProOnBoardingExpandableWidgetModel2 = tProOnBoardingExpandableWidgetModel;
        int i12 = i11;
        return tProOnBoardingExpandableWidgetModel.copy((i12 & 1) != 0 ? tProOnBoardingExpandableWidgetModel2.headerTitle : str, (i12 & 2) != 0 ? tProOnBoardingExpandableWidgetModel2.headerTitleColor : str2, (i12 & 4) != 0 ? tProOnBoardingExpandableWidgetModel2.title : str3, (i12 & 8) != 0 ? tProOnBoardingExpandableWidgetModel2.titleColor : str4, (i12 & 16) != 0 ? tProOnBoardingExpandableWidgetModel2.subtitle : str5, (i12 & 32) != 0 ? tProOnBoardingExpandableWidgetModel2.subTitleColor : str6, (i12 & 64) != 0 ? tProOnBoardingExpandableWidgetModel2.isExpanded : z11, (i12 & 128) != 0 ? tProOnBoardingExpandableWidgetModel2.expandWidgetTitle : str7, (i12 & 256) != 0 ? tProOnBoardingExpandableWidgetModel2.listItems : list, (i12 & 512) != 0 ? tProOnBoardingExpandableWidgetModel.getWidgetType() : heroWidgetType, (i12 & 1024) != 0 ? tProOnBoardingExpandableWidgetModel.getTrackingId() : str8);
    }

    @NotNull
    public final String component1() {
        return this.headerTitle;
    }

    @NotNull
    public final HeroWidgetType component10() {
        return getWidgetType();
    }

    @NotNull
    public final String component11() {
        return getTrackingId();
    }

    @NotNull
    public final String component2() {
        return this.headerTitleColor;
    }

    @NotNull
    public final String component3() {
        return this.title;
    }

    @NotNull
    public final String component4() {
        return this.titleColor;
    }

    @NotNull
    public final String component5() {
        return this.subtitle;
    }

    @NotNull
    public final String component6() {
        return this.subTitleColor;
    }

    public final boolean component7() {
        return this.isExpanded;
    }

    @NotNull
    public final String component8() {
        return this.expandWidgetTitle;
    }

    @NotNull
    public final List<TProOnBoardingExpandableItemModel> component9() {
        return this.listItems;
    }

    @NotNull
    public final TProOnBoardingExpandableWidgetModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z11, @NotNull String str7, @NotNull List<TProOnBoardingExpandableItemModel> list, @NotNull HeroWidgetType heroWidgetType, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, "headerTitle");
        Intrinsics.checkNotNullParameter(str2, "headerTitleColor");
        String str9 = str3;
        Intrinsics.checkNotNullParameter(str9, "title");
        String str10 = str4;
        Intrinsics.checkNotNullParameter(str10, "titleColor");
        String str11 = str5;
        Intrinsics.checkNotNullParameter(str11, "subtitle");
        String str12 = str6;
        Intrinsics.checkNotNullParameter(str12, "subTitleColor");
        String str13 = str7;
        Intrinsics.checkNotNullParameter(str13, "expandWidgetTitle");
        List<TProOnBoardingExpandableItemModel> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "listItems");
        HeroWidgetType heroWidgetType2 = heroWidgetType;
        Intrinsics.checkNotNullParameter(heroWidgetType2, "widgetType");
        String str14 = str8;
        Intrinsics.checkNotNullParameter(str14, "trackingId");
        return new TProOnBoardingExpandableWidgetModel(str, str2, str9, str10, str11, str12, z11, str13, list2, heroWidgetType2, str14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingExpandableWidgetModel)) {
            return false;
        }
        TProOnBoardingExpandableWidgetModel tProOnBoardingExpandableWidgetModel = (TProOnBoardingExpandableWidgetModel) obj;
        return Intrinsics.areEqual((Object) this.headerTitle, (Object) tProOnBoardingExpandableWidgetModel.headerTitle) && Intrinsics.areEqual((Object) this.headerTitleColor, (Object) tProOnBoardingExpandableWidgetModel.headerTitleColor) && Intrinsics.areEqual((Object) this.title, (Object) tProOnBoardingExpandableWidgetModel.title) && Intrinsics.areEqual((Object) this.titleColor, (Object) tProOnBoardingExpandableWidgetModel.titleColor) && Intrinsics.areEqual((Object) this.subtitle, (Object) tProOnBoardingExpandableWidgetModel.subtitle) && Intrinsics.areEqual((Object) this.subTitleColor, (Object) tProOnBoardingExpandableWidgetModel.subTitleColor) && this.isExpanded == tProOnBoardingExpandableWidgetModel.isExpanded && Intrinsics.areEqual((Object) this.expandWidgetTitle, (Object) tProOnBoardingExpandableWidgetModel.expandWidgetTitle) && Intrinsics.areEqual((Object) this.listItems, (Object) tProOnBoardingExpandableWidgetModel.listItems) && getWidgetType() == tProOnBoardingExpandableWidgetModel.getWidgetType() && Intrinsics.areEqual((Object) getTrackingId(), (Object) tProOnBoardingExpandableWidgetModel.getTrackingId());
    }

    @NotNull
    public final String getExpandWidgetTitle() {
        return this.expandWidgetTitle;
    }

    @NotNull
    public final String getHeaderTitle() {
        return this.headerTitle;
    }

    @NotNull
    public final String getHeaderTitleColor() {
        return this.headerTitleColor;
    }

    @NotNull
    public final List<TProOnBoardingExpandableItemModel> getListItems() {
        return this.listItems;
    }

    @NotNull
    public final String getSubTitleColor() {
        return this.subTitleColor;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getTitleColor() {
        return this.titleColor;
    }

    @NotNull
    public String getTrackingId() {
        return this.trackingId;
    }

    @NotNull
    public HeroWidgetType getWidgetType() {
        return this.widgetType;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.headerTitle.hashCode() * 31) + this.headerTitleColor.hashCode()) * 31) + this.title.hashCode()) * 31) + this.titleColor.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.subTitleColor.hashCode()) * 31;
        boolean z11 = this.isExpanded;
        if (z11) {
            z11 = true;
        }
        return ((((((((hashCode + (z11 ? 1 : 0)) * 31) + this.expandWidgetTitle.hashCode()) * 31) + this.listItems.hashCode()) * 31) + getWidgetType().hashCode()) * 31) + getTrackingId().hashCode();
    }

    public final boolean isExpanded() {
        return this.isExpanded;
    }

    public final void setExpandWidgetTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.expandWidgetTitle = str;
    }

    public final void setExpanded(boolean z11) {
        this.isExpanded = z11;
    }

    public final void setHeaderTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headerTitle = str;
    }

    public final void setHeaderTitleColor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headerTitleColor = str;
    }

    public final void setListItems(@NotNull List<TProOnBoardingExpandableItemModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.listItems = list;
    }

    public final void setSubTitleColor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitleColor = str;
    }

    public final void setSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subtitle = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setTitleColor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.titleColor = str;
    }

    @NotNull
    public String toString() {
        String str = this.headerTitle;
        String str2 = this.headerTitleColor;
        String str3 = this.title;
        String str4 = this.titleColor;
        String str5 = this.subtitle;
        String str6 = this.subTitleColor;
        boolean z11 = this.isExpanded;
        String str7 = this.expandWidgetTitle;
        List<TProOnBoardingExpandableItemModel> list = this.listItems;
        HeroWidgetType widgetType2 = getWidgetType();
        String trackingId2 = getTrackingId();
        return "TProOnBoardingExpandableWidgetModel(headerTitle=" + str + ", headerTitleColor=" + str2 + ", title=" + str3 + ", titleColor=" + str4 + ", subtitle=" + str5 + ", subTitleColor=" + str6 + ", isExpanded=" + z11 + ", expandWidgetTitle=" + str7 + ", listItems=" + list + ", widgetType=" + widgetType2 + ", trackingId=" + trackingId2 + ")";
    }
}
