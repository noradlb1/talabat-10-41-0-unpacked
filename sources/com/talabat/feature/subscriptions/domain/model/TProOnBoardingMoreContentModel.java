package com.talabat.feature.subscriptions.domain.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JU\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006$"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentModel;", "", "ctaTitle", "", "ctaTitleColor", "ctaBackgroundColor", "title", "titleColor", "contentBackgroundColor", "items", "", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentItemModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContentBackgroundColor", "()Ljava/lang/String;", "getCtaBackgroundColor", "getCtaTitle", "getCtaTitleColor", "getItems", "()Ljava/util/List;", "getTitle", "getTitleColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingMoreContentModel {
    @NotNull
    private final String contentBackgroundColor;
    @NotNull
    private final String ctaBackgroundColor;
    @NotNull
    private final String ctaTitle;
    @NotNull
    private final String ctaTitleColor;
    @NotNull
    private final List<TProOnBoardingMoreContentItemModel> items;
    @NotNull
    private final String title;
    @NotNull
    private final String titleColor;

    public TProOnBoardingMoreContentModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull List<TProOnBoardingMoreContentItemModel> list) {
        Intrinsics.checkNotNullParameter(str, "ctaTitle");
        Intrinsics.checkNotNullParameter(str2, "ctaTitleColor");
        Intrinsics.checkNotNullParameter(str3, "ctaBackgroundColor");
        Intrinsics.checkNotNullParameter(str4, "title");
        Intrinsics.checkNotNullParameter(str5, "titleColor");
        Intrinsics.checkNotNullParameter(str6, "contentBackgroundColor");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.ctaTitle = str;
        this.ctaTitleColor = str2;
        this.ctaBackgroundColor = str3;
        this.title = str4;
        this.titleColor = str5;
        this.contentBackgroundColor = str6;
        this.items = list;
    }

    public static /* synthetic */ TProOnBoardingMoreContentModel copy$default(TProOnBoardingMoreContentModel tProOnBoardingMoreContentModel, String str, String str2, String str3, String str4, String str5, String str6, List<TProOnBoardingMoreContentItemModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingMoreContentModel.ctaTitle;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingMoreContentModel.ctaTitleColor;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = tProOnBoardingMoreContentModel.ctaBackgroundColor;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = tProOnBoardingMoreContentModel.title;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = tProOnBoardingMoreContentModel.titleColor;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = tProOnBoardingMoreContentModel.contentBackgroundColor;
        }
        String str11 = str6;
        if ((i11 & 64) != 0) {
            list = tProOnBoardingMoreContentModel.items;
        }
        return tProOnBoardingMoreContentModel.copy(str, str7, str8, str9, str10, str11, list);
    }

    @NotNull
    public final String component1() {
        return this.ctaTitle;
    }

    @NotNull
    public final String component2() {
        return this.ctaTitleColor;
    }

    @NotNull
    public final String component3() {
        return this.ctaBackgroundColor;
    }

    @NotNull
    public final String component4() {
        return this.title;
    }

    @NotNull
    public final String component5() {
        return this.titleColor;
    }

    @NotNull
    public final String component6() {
        return this.contentBackgroundColor;
    }

    @NotNull
    public final List<TProOnBoardingMoreContentItemModel> component7() {
        return this.items;
    }

    @NotNull
    public final TProOnBoardingMoreContentModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull List<TProOnBoardingMoreContentItemModel> list) {
        Intrinsics.checkNotNullParameter(str, "ctaTitle");
        Intrinsics.checkNotNullParameter(str2, "ctaTitleColor");
        Intrinsics.checkNotNullParameter(str3, "ctaBackgroundColor");
        Intrinsics.checkNotNullParameter(str4, "title");
        Intrinsics.checkNotNullParameter(str5, "titleColor");
        Intrinsics.checkNotNullParameter(str6, "contentBackgroundColor");
        List<TProOnBoardingMoreContentItemModel> list2 = list;
        Intrinsics.checkNotNullParameter(list2, FirebaseAnalytics.Param.ITEMS);
        return new TProOnBoardingMoreContentModel(str, str2, str3, str4, str5, str6, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingMoreContentModel)) {
            return false;
        }
        TProOnBoardingMoreContentModel tProOnBoardingMoreContentModel = (TProOnBoardingMoreContentModel) obj;
        return Intrinsics.areEqual((Object) this.ctaTitle, (Object) tProOnBoardingMoreContentModel.ctaTitle) && Intrinsics.areEqual((Object) this.ctaTitleColor, (Object) tProOnBoardingMoreContentModel.ctaTitleColor) && Intrinsics.areEqual((Object) this.ctaBackgroundColor, (Object) tProOnBoardingMoreContentModel.ctaBackgroundColor) && Intrinsics.areEqual((Object) this.title, (Object) tProOnBoardingMoreContentModel.title) && Intrinsics.areEqual((Object) this.titleColor, (Object) tProOnBoardingMoreContentModel.titleColor) && Intrinsics.areEqual((Object) this.contentBackgroundColor, (Object) tProOnBoardingMoreContentModel.contentBackgroundColor) && Intrinsics.areEqual((Object) this.items, (Object) tProOnBoardingMoreContentModel.items);
    }

    @NotNull
    public final String getContentBackgroundColor() {
        return this.contentBackgroundColor;
    }

    @NotNull
    public final String getCtaBackgroundColor() {
        return this.ctaBackgroundColor;
    }

    @NotNull
    public final String getCtaTitle() {
        return this.ctaTitle;
    }

    @NotNull
    public final String getCtaTitleColor() {
        return this.ctaTitleColor;
    }

    @NotNull
    public final List<TProOnBoardingMoreContentItemModel> getItems() {
        return this.items;
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
        return (((((((((((this.ctaTitle.hashCode() * 31) + this.ctaTitleColor.hashCode()) * 31) + this.ctaBackgroundColor.hashCode()) * 31) + this.title.hashCode()) * 31) + this.titleColor.hashCode()) * 31) + this.contentBackgroundColor.hashCode()) * 31) + this.items.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.ctaTitle;
        String str2 = this.ctaTitleColor;
        String str3 = this.ctaBackgroundColor;
        String str4 = this.title;
        String str5 = this.titleColor;
        String str6 = this.contentBackgroundColor;
        List<TProOnBoardingMoreContentItemModel> list = this.items;
        return "TProOnBoardingMoreContentModel(ctaTitle=" + str + ", ctaTitleColor=" + str2 + ", ctaBackgroundColor=" + str3 + ", title=" + str4 + ", titleColor=" + str5 + ", contentBackgroundColor=" + str6 + ", items=" + list + ")";
    }
}
