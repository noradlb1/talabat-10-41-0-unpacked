package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006HÆ\u0003JQ\u0010\u0018\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingBannerResponseModel;", "", "heroHeaderLogo", "", "heroBackgroundColor", "heroWidget", "", "Lcom/talabat/feature/subscriptions/data/remote/model/HeroWidgetResponseModel;", "heroBackgroundImage", "heroSpannableTitle", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingTitleSpanningResponseModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getHeroBackgroundColor", "()Ljava/lang/String;", "getHeroBackgroundImage", "getHeroHeaderLogo", "getHeroSpannableTitle", "()Ljava/util/List;", "getHeroWidget", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingBannerResponseModel {
    @Nullable
    private final String heroBackgroundColor;
    @Nullable
    private final String heroBackgroundImage;
    @Nullable
    private final String heroHeaderLogo;
    @Nullable
    private final List<TProOnBoardingTitleSpanningResponseModel> heroSpannableTitle;
    @Nullable
    private final List<HeroWidgetResponseModel> heroWidget;

    public TProOnBoardingBannerResponseModel() {
        this((String) null, (String) null, (List) null, (String) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public TProOnBoardingBannerResponseModel(@Nullable @Json(name = "heroHeaderLogo") String str, @Nullable @Json(name = "heroBackgroundColor") String str2, @Nullable @Json(name = "heroWidget") List<? extends HeroWidgetResponseModel> list, @Nullable @Json(name = "heroBackgroundImage") String str3, @Nullable @Json(name = "heroHeaderTitleSpanning") List<TProOnBoardingTitleSpanningResponseModel> list2) {
        this.heroHeaderLogo = str;
        this.heroBackgroundColor = str2;
        this.heroWidget = list;
        this.heroBackgroundImage = str3;
        this.heroSpannableTitle = list2;
    }

    public static /* synthetic */ TProOnBoardingBannerResponseModel copy$default(TProOnBoardingBannerResponseModel tProOnBoardingBannerResponseModel, String str, String str2, List<HeroWidgetResponseModel> list, String str3, List<TProOnBoardingTitleSpanningResponseModel> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingBannerResponseModel.heroHeaderLogo;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingBannerResponseModel.heroBackgroundColor;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            list = tProOnBoardingBannerResponseModel.heroWidget;
        }
        List<HeroWidgetResponseModel> list3 = list;
        if ((i11 & 8) != 0) {
            str3 = tProOnBoardingBannerResponseModel.heroBackgroundImage;
        }
        String str5 = str3;
        if ((i11 & 16) != 0) {
            list2 = tProOnBoardingBannerResponseModel.heroSpannableTitle;
        }
        return tProOnBoardingBannerResponseModel.copy(str, str4, list3, str5, list2);
    }

    @Nullable
    public final String component1() {
        return this.heroHeaderLogo;
    }

    @Nullable
    public final String component2() {
        return this.heroBackgroundColor;
    }

    @Nullable
    public final List<HeroWidgetResponseModel> component3() {
        return this.heroWidget;
    }

    @Nullable
    public final String component4() {
        return this.heroBackgroundImage;
    }

    @Nullable
    public final List<TProOnBoardingTitleSpanningResponseModel> component5() {
        return this.heroSpannableTitle;
    }

    @NotNull
    public final TProOnBoardingBannerResponseModel copy(@Nullable @Json(name = "heroHeaderLogo") String str, @Nullable @Json(name = "heroBackgroundColor") String str2, @Nullable @Json(name = "heroWidget") List<? extends HeroWidgetResponseModel> list, @Nullable @Json(name = "heroBackgroundImage") String str3, @Nullable @Json(name = "heroHeaderTitleSpanning") List<TProOnBoardingTitleSpanningResponseModel> list2) {
        return new TProOnBoardingBannerResponseModel(str, str2, list, str3, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingBannerResponseModel)) {
            return false;
        }
        TProOnBoardingBannerResponseModel tProOnBoardingBannerResponseModel = (TProOnBoardingBannerResponseModel) obj;
        return Intrinsics.areEqual((Object) this.heroHeaderLogo, (Object) tProOnBoardingBannerResponseModel.heroHeaderLogo) && Intrinsics.areEqual((Object) this.heroBackgroundColor, (Object) tProOnBoardingBannerResponseModel.heroBackgroundColor) && Intrinsics.areEqual((Object) this.heroWidget, (Object) tProOnBoardingBannerResponseModel.heroWidget) && Intrinsics.areEqual((Object) this.heroBackgroundImage, (Object) tProOnBoardingBannerResponseModel.heroBackgroundImage) && Intrinsics.areEqual((Object) this.heroSpannableTitle, (Object) tProOnBoardingBannerResponseModel.heroSpannableTitle);
    }

    @Nullable
    public final String getHeroBackgroundColor() {
        return this.heroBackgroundColor;
    }

    @Nullable
    public final String getHeroBackgroundImage() {
        return this.heroBackgroundImage;
    }

    @Nullable
    public final String getHeroHeaderLogo() {
        return this.heroHeaderLogo;
    }

    @Nullable
    public final List<TProOnBoardingTitleSpanningResponseModel> getHeroSpannableTitle() {
        return this.heroSpannableTitle;
    }

    @Nullable
    public final List<HeroWidgetResponseModel> getHeroWidget() {
        return this.heroWidget;
    }

    public int hashCode() {
        String str = this.heroHeaderLogo;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.heroBackgroundColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<HeroWidgetResponseModel> list = this.heroWidget;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.heroBackgroundImage;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<TProOnBoardingTitleSpanningResponseModel> list2 = this.heroSpannableTitle;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.heroHeaderLogo;
        String str2 = this.heroBackgroundColor;
        List<HeroWidgetResponseModel> list = this.heroWidget;
        String str3 = this.heroBackgroundImage;
        List<TProOnBoardingTitleSpanningResponseModel> list2 = this.heroSpannableTitle;
        return "TProOnBoardingBannerResponseModel(heroHeaderLogo=" + str + ", heroBackgroundColor=" + str2 + ", heroWidget=" + list + ", heroBackgroundImage=" + str3 + ", heroSpannableTitle=" + list2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TProOnBoardingBannerResponseModel(java.lang.String r5, java.lang.String r6, java.util.List r7, java.lang.String r8, java.util.List r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingBannerResponseModel.<init>(java.lang.String, java.lang.String, java.util.List, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
