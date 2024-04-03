package com.talabat.feature.subscriptions.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0006HÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingBannerModel;", "", "heroHeaderLogo", "", "heroBackgroundColor", "heroWidget", "", "Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetModel;", "heroBackgroundImage", "heroSpannableTitle", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingTitleSpanningModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getHeroBackgroundColor", "()Ljava/lang/String;", "getHeroBackgroundImage", "getHeroHeaderLogo", "getHeroSpannableTitle", "()Ljava/util/List;", "getHeroWidget", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingBannerModel {
    @NotNull
    private final String heroBackgroundColor;
    @NotNull
    private final String heroBackgroundImage;
    @NotNull
    private final String heroHeaderLogo;
    @NotNull
    private final List<TProOnBoardingTitleSpanningModel> heroSpannableTitle;
    @NotNull
    private final List<HeroWidgetModel> heroWidget;

    public TProOnBoardingBannerModel(@NotNull String str, @NotNull String str2, @NotNull List<? extends HeroWidgetModel> list, @NotNull String str3, @NotNull List<TProOnBoardingTitleSpanningModel> list2) {
        Intrinsics.checkNotNullParameter(str, "heroHeaderLogo");
        Intrinsics.checkNotNullParameter(str2, "heroBackgroundColor");
        Intrinsics.checkNotNullParameter(list, "heroWidget");
        Intrinsics.checkNotNullParameter(str3, "heroBackgroundImage");
        Intrinsics.checkNotNullParameter(list2, "heroSpannableTitle");
        this.heroHeaderLogo = str;
        this.heroBackgroundColor = str2;
        this.heroWidget = list;
        this.heroBackgroundImage = str3;
        this.heroSpannableTitle = list2;
    }

    public static /* synthetic */ TProOnBoardingBannerModel copy$default(TProOnBoardingBannerModel tProOnBoardingBannerModel, String str, String str2, List<HeroWidgetModel> list, String str3, List<TProOnBoardingTitleSpanningModel> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingBannerModel.heroHeaderLogo;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingBannerModel.heroBackgroundColor;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            list = tProOnBoardingBannerModel.heroWidget;
        }
        List<HeroWidgetModel> list3 = list;
        if ((i11 & 8) != 0) {
            str3 = tProOnBoardingBannerModel.heroBackgroundImage;
        }
        String str5 = str3;
        if ((i11 & 16) != 0) {
            list2 = tProOnBoardingBannerModel.heroSpannableTitle;
        }
        return tProOnBoardingBannerModel.copy(str, str4, list3, str5, list2);
    }

    @NotNull
    public final String component1() {
        return this.heroHeaderLogo;
    }

    @NotNull
    public final String component2() {
        return this.heroBackgroundColor;
    }

    @NotNull
    public final List<HeroWidgetModel> component3() {
        return this.heroWidget;
    }

    @NotNull
    public final String component4() {
        return this.heroBackgroundImage;
    }

    @NotNull
    public final List<TProOnBoardingTitleSpanningModel> component5() {
        return this.heroSpannableTitle;
    }

    @NotNull
    public final TProOnBoardingBannerModel copy(@NotNull String str, @NotNull String str2, @NotNull List<? extends HeroWidgetModel> list, @NotNull String str3, @NotNull List<TProOnBoardingTitleSpanningModel> list2) {
        Intrinsics.checkNotNullParameter(str, "heroHeaderLogo");
        Intrinsics.checkNotNullParameter(str2, "heroBackgroundColor");
        Intrinsics.checkNotNullParameter(list, "heroWidget");
        Intrinsics.checkNotNullParameter(str3, "heroBackgroundImage");
        Intrinsics.checkNotNullParameter(list2, "heroSpannableTitle");
        return new TProOnBoardingBannerModel(str, str2, list, str3, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingBannerModel)) {
            return false;
        }
        TProOnBoardingBannerModel tProOnBoardingBannerModel = (TProOnBoardingBannerModel) obj;
        return Intrinsics.areEqual((Object) this.heroHeaderLogo, (Object) tProOnBoardingBannerModel.heroHeaderLogo) && Intrinsics.areEqual((Object) this.heroBackgroundColor, (Object) tProOnBoardingBannerModel.heroBackgroundColor) && Intrinsics.areEqual((Object) this.heroWidget, (Object) tProOnBoardingBannerModel.heroWidget) && Intrinsics.areEqual((Object) this.heroBackgroundImage, (Object) tProOnBoardingBannerModel.heroBackgroundImage) && Intrinsics.areEqual((Object) this.heroSpannableTitle, (Object) tProOnBoardingBannerModel.heroSpannableTitle);
    }

    @NotNull
    public final String getHeroBackgroundColor() {
        return this.heroBackgroundColor;
    }

    @NotNull
    public final String getHeroBackgroundImage() {
        return this.heroBackgroundImage;
    }

    @NotNull
    public final String getHeroHeaderLogo() {
        return this.heroHeaderLogo;
    }

    @NotNull
    public final List<TProOnBoardingTitleSpanningModel> getHeroSpannableTitle() {
        return this.heroSpannableTitle;
    }

    @NotNull
    public final List<HeroWidgetModel> getHeroWidget() {
        return this.heroWidget;
    }

    public int hashCode() {
        return (((((((this.heroHeaderLogo.hashCode() * 31) + this.heroBackgroundColor.hashCode()) * 31) + this.heroWidget.hashCode()) * 31) + this.heroBackgroundImage.hashCode()) * 31) + this.heroSpannableTitle.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.heroHeaderLogo;
        String str2 = this.heroBackgroundColor;
        List<HeroWidgetModel> list = this.heroWidget;
        String str3 = this.heroBackgroundImage;
        List<TProOnBoardingTitleSpanningModel> list2 = this.heroSpannableTitle;
        return "TProOnBoardingBannerModel(heroHeaderLogo=" + str + ", heroBackgroundColor=" + str2 + ", heroWidget=" + list + ", heroBackgroundImage=" + str3 + ", heroSpannableTitle=" + list2 + ")";
    }
}
