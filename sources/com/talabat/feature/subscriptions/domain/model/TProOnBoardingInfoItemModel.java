package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingInfoItemModel;", "", "title", "", "titleColor", "subtitle", "subTitleColor", "ctaTitle", "ctaColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCtaColor", "()Ljava/lang/String;", "setCtaColor", "(Ljava/lang/String;)V", "getCtaTitle", "setCtaTitle", "getSubTitleColor", "setSubTitleColor", "getSubtitle", "setSubtitle", "getTitle", "setTitle", "getTitleColor", "setTitleColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingInfoItemModel {
    @NotNull
    private String ctaColor;
    @NotNull
    private String ctaTitle;
    @NotNull
    private String subTitleColor;
    @NotNull
    private String subtitle;
    @NotNull
    private String title;
    @NotNull
    private String titleColor;

    public TProOnBoardingInfoItemModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "titleColor");
        Intrinsics.checkNotNullParameter(str3, "subtitle");
        Intrinsics.checkNotNullParameter(str4, "subTitleColor");
        Intrinsics.checkNotNullParameter(str5, "ctaTitle");
        Intrinsics.checkNotNullParameter(str6, "ctaColor");
        this.title = str;
        this.titleColor = str2;
        this.subtitle = str3;
        this.subTitleColor = str4;
        this.ctaTitle = str5;
        this.ctaColor = str6;
    }

    public static /* synthetic */ TProOnBoardingInfoItemModel copy$default(TProOnBoardingInfoItemModel tProOnBoardingInfoItemModel, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingInfoItemModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingInfoItemModel.titleColor;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = tProOnBoardingInfoItemModel.subtitle;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = tProOnBoardingInfoItemModel.subTitleColor;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = tProOnBoardingInfoItemModel.ctaTitle;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = tProOnBoardingInfoItemModel.ctaColor;
        }
        return tProOnBoardingInfoItemModel.copy(str, str7, str8, str9, str10, str6);
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
        return this.subtitle;
    }

    @NotNull
    public final String component4() {
        return this.subTitleColor;
    }

    @NotNull
    public final String component5() {
        return this.ctaTitle;
    }

    @NotNull
    public final String component6() {
        return this.ctaColor;
    }

    @NotNull
    public final TProOnBoardingInfoItemModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "titleColor");
        Intrinsics.checkNotNullParameter(str3, "subtitle");
        Intrinsics.checkNotNullParameter(str4, "subTitleColor");
        Intrinsics.checkNotNullParameter(str5, "ctaTitle");
        Intrinsics.checkNotNullParameter(str6, "ctaColor");
        return new TProOnBoardingInfoItemModel(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingInfoItemModel)) {
            return false;
        }
        TProOnBoardingInfoItemModel tProOnBoardingInfoItemModel = (TProOnBoardingInfoItemModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) tProOnBoardingInfoItemModel.title) && Intrinsics.areEqual((Object) this.titleColor, (Object) tProOnBoardingInfoItemModel.titleColor) && Intrinsics.areEqual((Object) this.subtitle, (Object) tProOnBoardingInfoItemModel.subtitle) && Intrinsics.areEqual((Object) this.subTitleColor, (Object) tProOnBoardingInfoItemModel.subTitleColor) && Intrinsics.areEqual((Object) this.ctaTitle, (Object) tProOnBoardingInfoItemModel.ctaTitle) && Intrinsics.areEqual((Object) this.ctaColor, (Object) tProOnBoardingInfoItemModel.ctaColor);
    }

    @NotNull
    public final String getCtaColor() {
        return this.ctaColor;
    }

    @NotNull
    public final String getCtaTitle() {
        return this.ctaTitle;
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

    public int hashCode() {
        return (((((((((this.title.hashCode() * 31) + this.titleColor.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.subTitleColor.hashCode()) * 31) + this.ctaTitle.hashCode()) * 31) + this.ctaColor.hashCode();
    }

    public final void setCtaColor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ctaColor = str;
    }

    public final void setCtaTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ctaTitle = str;
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
        String str = this.title;
        String str2 = this.titleColor;
        String str3 = this.subtitle;
        String str4 = this.subTitleColor;
        String str5 = this.ctaTitle;
        String str6 = this.ctaColor;
        return "TProOnBoardingInfoItemModel(title=" + str + ", titleColor=" + str2 + ", subtitle=" + str3 + ", subTitleColor=" + str4 + ", ctaTitle=" + str5 + ", ctaColor=" + str6 + ")";
    }
}
