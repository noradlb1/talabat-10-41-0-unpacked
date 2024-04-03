package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingExpandableItemModel;", "", "title", "", "titleColor", "value", "valueColor", "subTitle", "subTitleColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "getSubTitleColor", "setSubTitleColor", "getTitle", "setTitle", "getTitleColor", "setTitleColor", "getValue", "setValue", "getValueColor", "setValueColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingExpandableItemModel {
    @NotNull
    private String subTitle;
    @NotNull
    private String subTitleColor;
    @NotNull
    private String title;
    @NotNull
    private String titleColor;
    @NotNull
    private String value;
    @NotNull
    private String valueColor;

    public TProOnBoardingExpandableItemModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "titleColor");
        Intrinsics.checkNotNullParameter(str3, "value");
        Intrinsics.checkNotNullParameter(str4, "valueColor");
        Intrinsics.checkNotNullParameter(str5, "subTitle");
        Intrinsics.checkNotNullParameter(str6, "subTitleColor");
        this.title = str;
        this.titleColor = str2;
        this.value = str3;
        this.valueColor = str4;
        this.subTitle = str5;
        this.subTitleColor = str6;
    }

    public static /* synthetic */ TProOnBoardingExpandableItemModel copy$default(TProOnBoardingExpandableItemModel tProOnBoardingExpandableItemModel, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingExpandableItemModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingExpandableItemModel.titleColor;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = tProOnBoardingExpandableItemModel.value;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = tProOnBoardingExpandableItemModel.valueColor;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = tProOnBoardingExpandableItemModel.subTitle;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = tProOnBoardingExpandableItemModel.subTitleColor;
        }
        return tProOnBoardingExpandableItemModel.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.titleColor;
    }

    @NotNull
    public final String component3() {
        return this.value;
    }

    @NotNull
    public final String component4() {
        return this.valueColor;
    }

    @NotNull
    public final String component5() {
        return this.subTitle;
    }

    @NotNull
    public final String component6() {
        return this.subTitleColor;
    }

    @NotNull
    public final TProOnBoardingExpandableItemModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "titleColor");
        Intrinsics.checkNotNullParameter(str3, "value");
        Intrinsics.checkNotNullParameter(str4, "valueColor");
        Intrinsics.checkNotNullParameter(str5, "subTitle");
        Intrinsics.checkNotNullParameter(str6, "subTitleColor");
        return new TProOnBoardingExpandableItemModel(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingExpandableItemModel)) {
            return false;
        }
        TProOnBoardingExpandableItemModel tProOnBoardingExpandableItemModel = (TProOnBoardingExpandableItemModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) tProOnBoardingExpandableItemModel.title) && Intrinsics.areEqual((Object) this.titleColor, (Object) tProOnBoardingExpandableItemModel.titleColor) && Intrinsics.areEqual((Object) this.value, (Object) tProOnBoardingExpandableItemModel.value) && Intrinsics.areEqual((Object) this.valueColor, (Object) tProOnBoardingExpandableItemModel.valueColor) && Intrinsics.areEqual((Object) this.subTitle, (Object) tProOnBoardingExpandableItemModel.subTitle) && Intrinsics.areEqual((Object) this.subTitleColor, (Object) tProOnBoardingExpandableItemModel.subTitleColor);
    }

    @NotNull
    public final String getSubTitle() {
        return this.subTitle;
    }

    @NotNull
    public final String getSubTitleColor() {
        return this.subTitleColor;
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
    public final String getValue() {
        return this.value;
    }

    @NotNull
    public final String getValueColor() {
        return this.valueColor;
    }

    public int hashCode() {
        return (((((((((this.title.hashCode() * 31) + this.titleColor.hashCode()) * 31) + this.value.hashCode()) * 31) + this.valueColor.hashCode()) * 31) + this.subTitle.hashCode()) * 31) + this.subTitleColor.hashCode();
    }

    public final void setSubTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitle = str;
    }

    public final void setSubTitleColor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitleColor = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setTitleColor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.titleColor = str;
    }

    public final void setValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.value = str;
    }

    public final void setValueColor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.valueColor = str;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.titleColor;
        String str3 = this.value;
        String str4 = this.valueColor;
        String str5 = this.subTitle;
        String str6 = this.subTitleColor;
        return "TProOnBoardingExpandableItemModel(title=" + str + ", titleColor=" + str2 + ", value=" + str3 + ", valueColor=" + str4 + ", subTitle=" + str5 + ", subTitleColor=" + str6 + ")";
    }
}
